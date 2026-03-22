package org.p088jf.dexlib2.dexbacked.util;

import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.Iterator;
import org.p088jf.dexlib2.AccessFlags;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexBackedMethod;
import org.p088jf.dexlib2.dexbacked.DexBackedMethodImplementation;
import org.p088jf.dexlib2.dexbacked.DexBuffer;
import org.p088jf.dexlib2.dexbacked.DexReader;
import org.p088jf.dexlib2.iface.debug.DebugItem;
import org.p088jf.dexlib2.iface.debug.LocalInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class DebugInfo implements Iterable<DebugItem> {

    public static class DebugInfoImpl extends DebugInfo {
        public static final LocalInfo EMPTY_LOCAL_INFO = new LocalInfo() { // from class: org.jf.dexlib2.dexbacked.util.DebugInfo.DebugInfoImpl.1
            @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
            public String getName() {
                return null;
            }

            @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
            public String getSignature() {
                return null;
            }

            @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
            public String getType() {
                return null;
            }
        };
        public final int debugInfoOffset;
        public final DexBackedDexFile dexFile;
        public final DexBackedMethodImplementation methodImpl;

        public DebugInfoImpl(DexBackedDexFile dexBackedDexFile, int i, DexBackedMethodImplementation dexBackedMethodImplementation) {
            this.dexFile = dexBackedDexFile;
            this.debugInfoOffset = i;
            this.methodImpl = dexBackedMethodImplementation;
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.DebugInfo
        public VariableSizeIterator<String> getParameterNames(DexReader dexReader) {
            if (dexReader == null) {
                dexReader = this.dexFile.getDataBuffer().readerAt(this.debugInfoOffset);
                dexReader.skipUleb128();
            }
            return new VariableSizeIterator<String>(dexReader, dexReader.readSmallUleb128()) { // from class: org.jf.dexlib2.dexbacked.util.DebugInfo.DebugInfoImpl.4
                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeIterator
                public String readNextItem(DexReader dexReader2, int i) {
                    return DebugInfoImpl.this.dexFile.getStringSection().getOptional(dexReader2.readSmallUleb128() - 1);
                }
            };
        }

        @Override // java.lang.Iterable
        public Iterator<DebugItem> iterator() {
            LocalInfo localInfo;
            String type;
            DexReader<? extends DexBuffer> dexReader = this.dexFile.getDataBuffer().readerAt(this.debugInfoOffset);
            int bigUleb128 = dexReader.readBigUleb128();
            int registerCount = this.methodImpl.getRegisterCount();
            LocalInfo[] localInfoArr = new LocalInfo[registerCount];
            Arrays.fill(localInfoArr, EMPTY_LOCAL_INFO);
            DexBackedMethod dexBackedMethod = this.methodImpl.method;
            ParameterIterator parameterIterator = new ParameterIterator(dexBackedMethod.getParameterTypes(), dexBackedMethod.getParameterAnnotations(), getParameterNames((DexReader) dexReader));
            int i = 0;
            if (!AccessFlags.STATIC.isSet(this.methodImpl.method.getAccessFlags())) {
                localInfoArr[0] = new LocalInfo() { // from class: org.jf.dexlib2.dexbacked.util.DebugInfo.DebugInfoImpl.2
                    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
                    public String getName() {
                        return "this";
                    }

                    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
                    public String getSignature() {
                        return null;
                    }

                    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
                    public String getType() {
                        return DebugInfoImpl.this.methodImpl.method.getDefiningClass();
                    }
                };
                i = 1;
            }
            while (parameterIterator.hasNext()) {
                localInfoArr[i] = parameterIterator.next();
                i++;
            }
            if (i < registerCount) {
                int i2 = registerCount - 1;
                while (true) {
                    i--;
                    if (i <= -1 || ((type = (localInfo = localInfoArr[i]).getType()) != null && ((type.equals("J") || type.equals("D")) && i2 - 1 == i))) {
                        break;
                    }
                    localInfoArr[i2] = localInfo;
                    localInfoArr[i] = EMPTY_LOCAL_INFO;
                    i2--;
                }
            }
            return new VariableSizeLookaheadIterator<DebugItem>(this.dexFile.getDataBuffer(), dexReader.getOffset(), bigUleb128, localInfoArr) { // from class: org.jf.dexlib2.dexbacked.util.DebugInfo.DebugInfoImpl.3
                public int codeAddress = 0;
                public int lineNumber;
                public final /* synthetic */ int val$lineNumberStart;
                public final /* synthetic */ LocalInfo[] val$locals;

                {
                    this.val$lineNumberStart = bigUleb128;
                    this.val$locals = localInfoArr;
                    this.lineNumber = bigUleb128;
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public org.p088jf.dexlib2.iface.debug.DebugItem readNextItem(org.p088jf.dexlib2.dexbacked.DexReader r15) {
                    /*
                        Method dump skipped, instruction units count: 386
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.jf.dexlib2.dexbacked.util.DebugInfo.DebugInfoImpl.C17513.readNextItem(org.jf.dexlib2.dexbacked.DexReader):org.jf.dexlib2.iface.debug.DebugItem");
                }
            };
        }
    }

    public static class EmptyDebugInfo extends DebugInfo {
        public static final EmptyDebugInfo INSTANCE = new EmptyDebugInfo();

        @Override // org.p088jf.dexlib2.dexbacked.util.DebugInfo
        public Iterator<String> getParameterNames(DexReader dexReader) {
            return ImmutableSet.m3782of().iterator();
        }

        @Override // java.lang.Iterable
        public Iterator<DebugItem> iterator() {
            return ImmutableSet.m3782of().iterator();
        }
    }

    public static DebugInfo newOrEmpty(DexBackedDexFile dexBackedDexFile, int i, DexBackedMethodImplementation dexBackedMethodImplementation) {
        return i == 0 ? EmptyDebugInfo.INSTANCE : new DebugInfoImpl(dexBackedDexFile, i, dexBackedMethodImplementation);
    }

    public abstract Iterator<String> getParameterNames(DexReader dexReader);
}
