package org.p088jf.dexlib2.writer.builder;

import java.util.List;
import org.p088jf.dexlib2.base.reference.BaseMethodProtoReference;

/* JADX INFO: loaded from: classes.dex */
public class BuilderMethodProtoReference extends BaseMethodProtoReference implements BuilderReference {
    public int index = -1;
    public final BuilderTypeList parameterTypes;
    public final BuilderTypeReference returnType;
    public final BuilderStringReference shorty;

    public BuilderMethodProtoReference(BuilderStringReference builderStringReference, BuilderTypeList builderTypeList, BuilderTypeReference builderTypeReference) {
        this.shorty = builderStringReference;
        this.parameterTypes = builderTypeList;
        this.returnType = builderTypeReference;
    }

    public int getIndex() {
        return this.index;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodProtoReference
    public List<? extends CharSequence> getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodProtoReference
    public String getReturnType() {
        return this.returnType.getType();
    }
}
