package org.p088jf.dexlib2.base;

import org.p088jf.dexlib2.iface.ExceptionHandler;
import org.p088jf.dexlib2.iface.TryBlock;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTryBlock<EH extends ExceptionHandler> implements TryBlock<EH> {
    public boolean equals(Object obj) {
        if (!(obj instanceof TryBlock)) {
            return false;
        }
        TryBlock tryBlock = (TryBlock) obj;
        return getStartCodeAddress() == tryBlock.getStartCodeAddress() && getCodeUnitCount() == tryBlock.getCodeUnitCount() && getExceptionHandlers().equals(tryBlock.getExceptionHandlers());
    }
}
