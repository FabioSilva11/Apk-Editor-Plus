package org.p088jf.dexlib2.writer.builder;

import org.p088jf.dexlib2.base.reference.BaseMethodReference;

/* JADX INFO: loaded from: classes.dex */
public class BuilderMethodReference extends BaseMethodReference implements BuilderReference {
    public final BuilderTypeReference definingClass;
    public int index = -1;
    public final BuilderStringReference name;
    public final BuilderMethodProtoReference proto;

    public BuilderMethodReference(BuilderTypeReference builderTypeReference, BuilderStringReference builderStringReference, BuilderMethodProtoReference builderMethodProtoReference) {
        this.definingClass = builderTypeReference;
        this.name = builderStringReference;
        this.proto = builderMethodProtoReference;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getDefiningClass() {
        return this.definingClass.getType();
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getName() {
        return this.name.getString();
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference
    public BuilderTypeList getParameterTypes() {
        return this.proto.parameterTypes;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getReturnType() {
        return this.proto.returnType.getType();
    }
}
