package org.p088jf.dexlib2.iface;

import org.p088jf.dexlib2.iface.reference.TypeReference;

/* JADX INFO: loaded from: classes.dex */
public interface ExceptionHandler extends Comparable<ExceptionHandler> {
    String getExceptionType();

    TypeReference getExceptionTypeReference();

    int getHandlerCodeAddress();
}
