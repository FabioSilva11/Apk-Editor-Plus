package org.p088jf.dexlib2.writer.builder;

import org.p088jf.dexlib2.base.reference.BaseMethodHandleReference;

/* JADX INFO: loaded from: classes.dex */
public class BuilderMethodHandleReference extends BaseMethodHandleReference implements BuilderReference {
    public int index = -1;
    public final BuilderReference memberReference;
    public final int methodHandleType;

    public BuilderMethodHandleReference(int i, BuilderReference builderReference) {
        this.methodHandleType = i;
        this.memberReference = builderReference;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodHandleReference
    public BuilderReference getMemberReference() {
        return this.memberReference;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodHandleReference
    public int getMethodHandleType() {
        return this.methodHandleType;
    }
}
