package org.p088jf.dexlib2.immutable.reference;

import org.p088jf.dexlib2.iface.reference.CallSiteReference;
import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.iface.reference.MethodHandleReference;
import org.p088jf.dexlib2.iface.reference.MethodProtoReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.dexlib2.iface.reference.StringReference;
import org.p088jf.dexlib2.iface.reference.TypeReference;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableReferenceFactory {
    /* JADX INFO: renamed from: of */
    public static ImmutableReference m3916of(int i, Reference reference) {
        switch (i) {
            case 0:
                return ImmutableStringReference.m3918of((StringReference) reference);
            case 1:
                return ImmutableTypeReference.m3919of((TypeReference) reference);
            case 2:
                return ImmutableFieldReference.m3912of((FieldReference) reference);
            case 3:
                return ImmutableMethodReference.m3915of((MethodReference) reference);
            case 4:
                return ImmutableMethodProtoReference.m3914of((MethodProtoReference) reference);
            case 5:
                return ImmutableCallSiteReference.m3911of((CallSiteReference) reference);
            case 6:
                return ImmutableMethodHandleReference.m3913of((MethodHandleReference) reference);
            default:
                throw new ExceptionWithContext("Invalid reference type: %d", Integer.valueOf(i));
        }
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableReference m3917of(Reference reference) {
        if (reference instanceof StringReference) {
            return ImmutableStringReference.m3918of((StringReference) reference);
        }
        if (reference instanceof TypeReference) {
            return ImmutableTypeReference.m3919of((TypeReference) reference);
        }
        if (reference instanceof FieldReference) {
            return ImmutableFieldReference.m3912of((FieldReference) reference);
        }
        if (reference instanceof MethodReference) {
            return ImmutableMethodReference.m3915of((MethodReference) reference);
        }
        if (reference instanceof MethodProtoReference) {
            return ImmutableMethodProtoReference.m3914of((MethodProtoReference) reference);
        }
        if (reference instanceof CallSiteReference) {
            return ImmutableCallSiteReference.m3911of((CallSiteReference) reference);
        }
        if (reference instanceof MethodHandleReference) {
            return ImmutableMethodHandleReference.m3913of((MethodHandleReference) reference);
        }
        throw new ExceptionWithContext("Invalid reference type", new Object[0]);
    }
}
