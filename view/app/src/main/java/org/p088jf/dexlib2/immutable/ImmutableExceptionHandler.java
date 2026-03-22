package org.p088jf.dexlib2.immutable;

import com.google.common.collect.ImmutableList;
import org.p088jf.dexlib2.base.BaseExceptionHandler;
import org.p088jf.dexlib2.iface.ExceptionHandler;
import org.p088jf.util.ImmutableConverter;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableExceptionHandler extends BaseExceptionHandler {
    public static final ImmutableConverter<ImmutableExceptionHandler, ExceptionHandler> CONVERTER = new ImmutableConverter<ImmutableExceptionHandler, ExceptionHandler>() { // from class: org.jf.dexlib2.immutable.ImmutableExceptionHandler.1
        @Override // org.p088jf.util.ImmutableConverter
        public boolean isImmutable(ExceptionHandler exceptionHandler) {
            return exceptionHandler instanceof ImmutableExceptionHandler;
        }

        @Override // org.p088jf.util.ImmutableConverter
        public ImmutableExceptionHandler makeImmutable(ExceptionHandler exceptionHandler) {
            return ImmutableExceptionHandler.m3858of(exceptionHandler);
        }
    };
    public final String exceptionType;
    public final int handlerCodeAddress;

    public ImmutableExceptionHandler(String str, int i) {
        this.exceptionType = str;
        this.handlerCodeAddress = i;
    }

    public static ImmutableList<ImmutableExceptionHandler> immutableListOf(Iterable<? extends ExceptionHandler> iterable) {
        return CONVERTER.toList(iterable);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableExceptionHandler m3858of(ExceptionHandler exceptionHandler) {
        return exceptionHandler instanceof ImmutableExceptionHandler ? (ImmutableExceptionHandler) exceptionHandler : new ImmutableExceptionHandler(exceptionHandler.getExceptionType(), exceptionHandler.getHandlerCodeAddress());
    }

    @Override // org.p088jf.dexlib2.iface.ExceptionHandler
    public String getExceptionType() {
        return this.exceptionType;
    }

    @Override // org.p088jf.dexlib2.iface.ExceptionHandler
    public int getHandlerCodeAddress() {
        return this.handlerCodeAddress;
    }
}
