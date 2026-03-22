package org.p088jf.dexlib2.iface;

import java.util.Set;
import org.p088jf.dexlib2.iface.debug.LocalInfo;
import org.p088jf.dexlib2.iface.reference.TypeReference;

/* JADX INFO: loaded from: classes.dex */
public interface MethodParameter extends TypeReference, LocalInfo {
    Set<? extends Annotation> getAnnotations();

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    String getName();

    @Override // org.p088jf.dexlib2.iface.reference.TypeReference
    String getType();
}
