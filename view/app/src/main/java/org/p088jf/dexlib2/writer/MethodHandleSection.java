package org.p088jf.dexlib2.writer;

import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.iface.reference.MethodHandleReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;

/* JADX INFO: loaded from: classes.dex */
public interface MethodHandleSection<MethodHandleKey extends MethodHandleReference, FieldRefKey extends FieldReference, MethodRefKey extends MethodReference> extends IndexSection<MethodHandleKey> {
    FieldRefKey getFieldReference(MethodHandleKey methodhandlekey);

    MethodRefKey getMethodReference(MethodHandleKey methodhandlekey);
}
