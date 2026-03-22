package org.p088jf.dexlib2.immutable;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.p088jf.dexlib2.base.BaseTryBlock;
import org.p088jf.dexlib2.iface.ExceptionHandler;
import org.p088jf.dexlib2.iface.TryBlock;
import org.p088jf.util.ImmutableConverter;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableTryBlock extends BaseTryBlock<ImmutableExceptionHandler> {
    public static final ImmutableConverter<ImmutableTryBlock, TryBlock<? extends ExceptionHandler>> CONVERTER = new ImmutableConverter<ImmutableTryBlock, TryBlock<? extends ExceptionHandler>>() { // from class: org.jf.dexlib2.immutable.ImmutableTryBlock.1
        @Override // org.p088jf.util.ImmutableConverter
        public /* bridge */ /* synthetic */ boolean isImmutable(TryBlock<? extends ExceptionHandler> tryBlock) {
            return isImmutable2((TryBlock) tryBlock);
        }

        /* JADX INFO: renamed from: isImmutable, reason: avoid collision after fix types in other method */
        public boolean isImmutable2(TryBlock tryBlock) {
            return tryBlock instanceof ImmutableTryBlock;
        }

        @Override // org.p088jf.util.ImmutableConverter
        public ImmutableTryBlock makeImmutable(TryBlock<? extends ExceptionHandler> tryBlock) {
            return ImmutableTryBlock.m3863of(tryBlock);
        }
    };
    public final int codeUnitCount;
    public final ImmutableList<? extends ImmutableExceptionHandler> exceptionHandlers;
    public final int startCodeAddress;

    public ImmutableTryBlock(int i, int i2, List<? extends ExceptionHandler> list) {
        this.startCodeAddress = i;
        this.codeUnitCount = i2;
        this.exceptionHandlers = ImmutableExceptionHandler.immutableListOf(list);
    }

    public static ImmutableList<ImmutableTryBlock> immutableListOf(List<? extends TryBlock<? extends ExceptionHandler>> list) {
        return CONVERTER.toList(list);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableTryBlock m3863of(TryBlock<? extends ExceptionHandler> tryBlock) {
        return tryBlock instanceof ImmutableTryBlock ? (ImmutableTryBlock) tryBlock : new ImmutableTryBlock(tryBlock.getStartCodeAddress(), tryBlock.getCodeUnitCount(), tryBlock.getExceptionHandlers());
    }

    @Override // org.p088jf.dexlib2.iface.TryBlock
    public int getCodeUnitCount() {
        return this.codeUnitCount;
    }

    @Override // org.p088jf.dexlib2.iface.TryBlock
    public ImmutableList<? extends ImmutableExceptionHandler> getExceptionHandlers() {
        return this.exceptionHandlers;
    }

    @Override // org.p088jf.dexlib2.iface.TryBlock
    public int getStartCodeAddress() {
        return this.startCodeAddress;
    }
}
