package org.p088jf.dexlib2.iface;

import java.util.List;
import org.p088jf.dexlib2.iface.ExceptionHandler;

/* JADX INFO: loaded from: classes.dex */
public interface TryBlock<EH extends ExceptionHandler> {
    int getCodeUnitCount();

    List<? extends EH> getExceptionHandlers();

    int getStartCodeAddress();
}
