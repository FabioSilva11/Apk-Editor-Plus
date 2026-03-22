package org.p088jf.dexlib2.iface.reference;

import java.util.List;
import org.p088jf.dexlib2.iface.value.EncodedValue;

/* JADX INFO: loaded from: classes.dex */
public interface CallSiteReference extends Reference {
    List<? extends EncodedValue> getExtraArguments();

    MethodHandleReference getMethodHandle();

    String getMethodName();

    MethodProtoReference getMethodProto();

    String getName();
}
