package org.p088jf.dexlib2.immutable.reference;

import org.p088jf.dexlib2.base.reference.BaseMethodHandleReference;
import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.iface.reference.MethodHandleReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableMethodHandleReference extends BaseMethodHandleReference implements ImmutableReference {
    public final ImmutableReference memberReference;
    public final int methodHandleType;

    public ImmutableMethodHandleReference(int i, ImmutableReference immutableReference) {
        this.methodHandleType = i;
        this.memberReference = immutableReference;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableMethodHandleReference m3913of(MethodHandleReference methodHandleReference) {
        ImmutableReference immutableReferenceM3912of;
        if (methodHandleReference instanceof ImmutableMethodHandleReference) {
            return (ImmutableMethodHandleReference) methodHandleReference;
        }
        int methodHandleType = methodHandleReference.getMethodHandleType();
        switch (methodHandleType) {
            case 0:
            case 1:
            case 2:
            case 3:
                immutableReferenceM3912of = ImmutableFieldReference.m3912of((FieldReference) methodHandleReference.getMemberReference());
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                immutableReferenceM3912of = ImmutableMethodReference.m3915of((MethodReference) methodHandleReference.getMemberReference());
                break;
            default:
                throw new ExceptionWithContext("Invalid method handle type: %d", Integer.valueOf(methodHandleType));
        }
        return new ImmutableMethodHandleReference(methodHandleType, immutableReferenceM3912of);
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodHandleReference
    public Reference getMemberReference() {
        return this.memberReference;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodHandleReference
    public int getMethodHandleType() {
        return this.methodHandleType;
    }
}
