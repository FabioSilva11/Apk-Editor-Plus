package org.p088jf.dexlib2.base.reference;

import org.p088jf.dexlib2.formatter.DexFormatter;
import org.p088jf.dexlib2.iface.reference.CallSiteReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseCallSiteReference extends BaseReference implements CallSiteReference {
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CallSiteReference)) {
            return false;
        }
        CallSiteReference callSiteReference = (CallSiteReference) obj;
        return getMethodHandle().equals(callSiteReference.getMethodHandle()) && getMethodName().equals(callSiteReference.getMethodName()) && getMethodProto().equals(callSiteReference.getMethodProto()) && getExtraArguments().equals(callSiteReference.getExtraArguments());
    }

    public int hashCode() {
        return (((((((getName().hashCode() * 31) + getMethodHandle().hashCode()) * 31) + getMethodName().hashCode()) * 31) + getMethodProto().hashCode()) * 31) + getExtraArguments().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getCallSite(this);
    }
}
