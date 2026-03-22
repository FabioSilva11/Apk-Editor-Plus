package org.p088jf.dexlib2.writer.util;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.p088jf.dexlib2.base.BaseTryBlock;
import org.p088jf.dexlib2.iface.ExceptionHandler;
import org.p088jf.dexlib2.iface.TryBlock;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class TryListBuilder<EH extends ExceptionHandler> {
    public final MutableTryBlock<EH> listEnd;
    public final MutableTryBlock<EH> listStart;

    public static class InvalidTryException extends ExceptionWithContext {
        public InvalidTryException(String str, Object... objArr) {
            super(str, objArr);
        }
    }

    public static class MutableTryBlock<EH extends ExceptionHandler> extends BaseTryBlock<EH> {
        public int endCodeAddress;
        public List<EH> exceptionHandlers;
        public MutableTryBlock<EH> next;
        public MutableTryBlock<EH> prev;
        public int startCodeAddress;

        public MutableTryBlock(int i, int i2) {
            this.prev = null;
            this.next = null;
            this.exceptionHandlers = Lists.newArrayList();
            this.startCodeAddress = i;
            this.endCodeAddress = i2;
        }

        public MutableTryBlock(int i, int i2, List<EH> list) {
            this.prev = null;
            this.next = null;
            this.exceptionHandlers = Lists.newArrayList();
            this.startCodeAddress = i;
            this.endCodeAddress = i2;
            this.exceptionHandlers = Lists.newArrayList(list);
        }

        public void addHandler(EH eh) {
            for (EH eh2 : this.exceptionHandlers) {
                String exceptionType = eh2.getExceptionType();
                String exceptionType2 = eh.getExceptionType();
                if (exceptionType == null) {
                    if (exceptionType2 == null) {
                        if (eh2.getHandlerCodeAddress() != eh.getHandlerCodeAddress()) {
                            throw new InvalidTryException("Multiple overlapping catch all handlers with different handlers", new Object[0]);
                        }
                        return;
                    }
                } else if (exceptionType.equals(exceptionType2)) {
                    return;
                }
            }
            this.exceptionHandlers.add(eh);
        }

        public void append(MutableTryBlock<EH> mutableTryBlock) {
            MutableTryBlock<EH> mutableTryBlock2 = this.next;
            mutableTryBlock2.prev = mutableTryBlock;
            mutableTryBlock.next = mutableTryBlock2;
            mutableTryBlock.prev = this;
            this.next = mutableTryBlock;
        }

        public void delete() {
            MutableTryBlock<EH> mutableTryBlock = this.next;
            mutableTryBlock.prev = this.prev;
            this.prev.next = mutableTryBlock;
        }

        @Override // org.p088jf.dexlib2.iface.TryBlock
        public int getCodeUnitCount() {
            return this.endCodeAddress - this.startCodeAddress;
        }

        @Override // org.p088jf.dexlib2.iface.TryBlock
        public List<EH> getExceptionHandlers() {
            return this.exceptionHandlers;
        }

        @Override // org.p088jf.dexlib2.iface.TryBlock
        public int getStartCodeAddress() {
            return this.startCodeAddress;
        }

        public void mergeNext() {
            MutableTryBlock<EH> mutableTryBlock = this.next;
            this.endCodeAddress = mutableTryBlock.endCodeAddress;
            mutableTryBlock.delete();
        }

        public void prepend(MutableTryBlock<EH> mutableTryBlock) {
            MutableTryBlock<EH> mutableTryBlock2 = this.prev;
            mutableTryBlock2.next = mutableTryBlock;
            mutableTryBlock.prev = mutableTryBlock2;
            mutableTryBlock.next = this;
            this.prev = mutableTryBlock;
        }

        public MutableTryBlock<EH> split(int i) {
            MutableTryBlock<EH> mutableTryBlock = new MutableTryBlock<>(i, this.endCodeAddress, this.exceptionHandlers);
            this.endCodeAddress = i;
            append(mutableTryBlock);
            return mutableTryBlock;
        }
    }

    public static class TryBounds<EH extends ExceptionHandler> {
        public final MutableTryBlock<EH> end;
        public final MutableTryBlock<EH> start;

        public TryBounds(MutableTryBlock<EH> mutableTryBlock, MutableTryBlock<EH> mutableTryBlock2) {
            this.start = mutableTryBlock;
            this.end = mutableTryBlock2;
        }
    }

    public TryListBuilder() {
        MutableTryBlock<EH> mutableTryBlock = new MutableTryBlock<>(0, 0);
        this.listStart = mutableTryBlock;
        MutableTryBlock<EH> mutableTryBlock2 = new MutableTryBlock<>(0, 0);
        this.listEnd = mutableTryBlock2;
        mutableTryBlock.next = mutableTryBlock2;
        mutableTryBlock2.prev = mutableTryBlock;
    }

    public static <EH extends ExceptionHandler> List<TryBlock<EH>> massageTryBlocks(List<? extends TryBlock<? extends EH>> list) {
        TryListBuilder tryListBuilder = new TryListBuilder();
        for (TryBlock<? extends EH> tryBlock : list) {
            int startCodeAddress = tryBlock.getStartCodeAddress();
            int codeUnitCount = tryBlock.getCodeUnitCount() + startCodeAddress;
            Iterator<? extends EH> it = tryBlock.getExceptionHandlers().iterator();
            while (it.hasNext()) {
                tryListBuilder.addHandler(startCodeAddress, codeUnitCount, it.next());
            }
        }
        return tryListBuilder.getTryBlocks();
    }

    public void addHandler(int i, int i2, EH eh) {
        TryBounds<EH> boundingRanges = getBoundingRanges(i, i2);
        MutableTryBlock<EH> mutableTryBlock = boundingRanges.start;
        MutableTryBlock<EH> mutableTryBlock2 = boundingRanges.end;
        do {
            int i3 = mutableTryBlock.startCodeAddress;
            if (i3 > i) {
                MutableTryBlock<EH> mutableTryBlock3 = new MutableTryBlock<>(i, i3);
                mutableTryBlock.prepend(mutableTryBlock3);
                mutableTryBlock = mutableTryBlock3;
            }
            mutableTryBlock.addHandler(eh);
            i = mutableTryBlock.endCodeAddress;
            mutableTryBlock = mutableTryBlock.next;
        } while (mutableTryBlock.prev != mutableTryBlock2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r0 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        r0 = new org.jf.dexlib2.writer.util.TryListBuilder.MutableTryBlock<>(r4, r5);
        r3.listEnd.prepend(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        return new org.jf.dexlib2.writer.util.TryListBuilder.TryBounds<>(r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        r1 = r3.listEnd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        if (r4 == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        r1 = r4.startCodeAddress;
        r2 = r4.endCodeAddress;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        if (r5 != r2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
    
        return new org.jf.dexlib2.writer.util.TryListBuilder.TryBounds<>(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        if (r5 <= r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
    
        if (r5 >= r2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
    
        r4.split(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0067, code lost:
    
        return new org.jf.dexlib2.writer.util.TryListBuilder.TryBounds<>(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        if (r5 > r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006a, code lost:
    
        r1 = new org.jf.dexlib2.writer.util.TryListBuilder.MutableTryBlock<>(r4.prev.endCodeAddress, r5);
        r4.prepend(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
    
        return new org.jf.dexlib2.writer.util.TryListBuilder.TryBounds<>(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
    
        r4 = r4.next;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
    
        r4 = new org.jf.dexlib2.writer.util.TryListBuilder.MutableTryBlock<>(r1.prev.endCodeAddress, r5);
        r3.listEnd.prepend(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0092, code lost:
    
        return new org.jf.dexlib2.writer.util.TryListBuilder.TryBounds<>(r0, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.jf.dexlib2.writer.util.TryListBuilder.TryBounds<EH> getBoundingRanges(int r4, int r5) {
        /*
            r3 = this;
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock<EH extends org.jf.dexlib2.iface.ExceptionHandler> r0 = r3.listStart
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock<EH extends org.jf.dexlib2.iface.ExceptionHandler> r0 = r0.next
        L4:
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock<EH extends org.jf.dexlib2.iface.ExceptionHandler> r1 = r3.listEnd
            if (r0 == r1) goto L37
            int r1 = r0.startCodeAddress
            int r2 = r0.endCodeAddress
            if (r4 != r1) goto Lf
            goto L38
        Lf:
            if (r4 <= r1) goto L18
            if (r4 >= r2) goto L18
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock r0 = r0.split(r4)
            goto L38
        L18:
            if (r4 >= r1) goto L34
            if (r5 > r1) goto L2a
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock r1 = new org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock
            r1.<init>(r4, r5)
            r0.prepend(r1)
            org.jf.dexlib2.writer.util.TryListBuilder$TryBounds r4 = new org.jf.dexlib2.writer.util.TryListBuilder$TryBounds
            r4.<init>(r1, r1)
            return r4
        L2a:
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock r2 = new org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock
            r2.<init>(r4, r1)
            r0.prepend(r2)
            r0 = r2
            goto L38
        L34:
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock<EH extends org.jf.dexlib2.iface.ExceptionHandler> r0 = r0.next
            goto L4
        L37:
            r0 = 0
        L38:
            if (r0 != 0) goto L4a
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock r0 = new org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock
            r0.<init>(r4, r5)
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock<EH extends org.jf.dexlib2.iface.ExceptionHandler> r4 = r3.listEnd
            r4.prepend(r0)
            org.jf.dexlib2.writer.util.TryListBuilder$TryBounds r4 = new org.jf.dexlib2.writer.util.TryListBuilder$TryBounds
            r4.<init>(r0, r0)
            return r4
        L4a:
            r4 = r0
        L4b:
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock<EH extends org.jf.dexlib2.iface.ExceptionHandler> r1 = r3.listEnd
            if (r4 == r1) goto L7f
            int r1 = r4.startCodeAddress
            int r2 = r4.endCodeAddress
            if (r5 != r2) goto L5b
            org.jf.dexlib2.writer.util.TryListBuilder$TryBounds r5 = new org.jf.dexlib2.writer.util.TryListBuilder$TryBounds
            r5.<init>(r0, r4)
            return r5
        L5b:
            if (r5 <= r1) goto L68
            if (r5 >= r2) goto L68
            r4.split(r5)
            org.jf.dexlib2.writer.util.TryListBuilder$TryBounds r5 = new org.jf.dexlib2.writer.util.TryListBuilder$TryBounds
            r5.<init>(r0, r4)
            return r5
        L68:
            if (r5 > r1) goto L7c
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock r1 = new org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock<EH extends org.jf.dexlib2.iface.ExceptionHandler> r2 = r4.prev
            int r2 = r2.endCodeAddress
            r1.<init>(r2, r5)
            r4.prepend(r1)
            org.jf.dexlib2.writer.util.TryListBuilder$TryBounds r4 = new org.jf.dexlib2.writer.util.TryListBuilder$TryBounds
            r4.<init>(r0, r1)
            return r4
        L7c:
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock<EH extends org.jf.dexlib2.iface.ExceptionHandler> r4 = r4.next
            goto L4b
        L7f:
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock r4 = new org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock<EH extends org.jf.dexlib2.iface.ExceptionHandler> r1 = r1.prev
            int r1 = r1.endCodeAddress
            r4.<init>(r1, r5)
            org.jf.dexlib2.writer.util.TryListBuilder$MutableTryBlock<EH extends org.jf.dexlib2.iface.ExceptionHandler> r5 = r3.listEnd
            r5.prepend(r4)
            org.jf.dexlib2.writer.util.TryListBuilder$TryBounds r5 = new org.jf.dexlib2.writer.util.TryListBuilder$TryBounds
            r5.<init>(r0, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p088jf.dexlib2.writer.util.TryListBuilder.getBoundingRanges(int, int):org.jf.dexlib2.writer.util.TryListBuilder$TryBounds");
    }

    public List<TryBlock<EH>> getTryBlocks() {
        return Lists.newArrayList(new Iterator<TryBlock<EH>>() { // from class: org.jf.dexlib2.writer.util.TryListBuilder.1
            public MutableTryBlock<EH> next;

            {
                this.next = TryListBuilder.this.listStart;
                this.next = readNextItem();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.next != null;
            }

            @Override // java.util.Iterator
            public TryBlock<EH> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                MutableTryBlock<EH> mutableTryBlock = this.next;
                this.next = readNextItem();
                return mutableTryBlock;
            }

            public MutableTryBlock<EH> readNextItem() {
                MutableTryBlock<EH> mutableTryBlock = this.next.next;
                if (mutableTryBlock == TryListBuilder.this.listEnd) {
                    return null;
                }
                while (mutableTryBlock.next != TryListBuilder.this.listEnd && mutableTryBlock.endCodeAddress == mutableTryBlock.next.startCodeAddress && mutableTryBlock.getExceptionHandlers().equals(mutableTryBlock.next.getExceptionHandlers())) {
                    mutableTryBlock.mergeNext();
                }
                return mutableTryBlock;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        });
    }
}
