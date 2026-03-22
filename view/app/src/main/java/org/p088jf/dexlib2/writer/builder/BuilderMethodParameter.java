package org.p088jf.dexlib2.writer.builder;

import org.p088jf.dexlib2.base.BaseMethodParameter;

/* JADX INFO: loaded from: classes.dex */
public class BuilderMethodParameter extends BaseMethodParameter {
    public final BuilderAnnotationSet annotations;
    public final BuilderStringReference name;
    public final BuilderTypeReference type;

    public BuilderMethodParameter(BuilderTypeReference builderTypeReference, BuilderStringReference builderStringReference, BuilderAnnotationSet builderAnnotationSet) {
        this.type = builderTypeReference;
        this.name = builderStringReference;
        this.annotations = builderAnnotationSet;
    }

    @Override // org.p088jf.dexlib2.iface.MethodParameter
    public BuilderAnnotationSet getAnnotations() {
        return this.annotations;
    }

    @Override // org.p088jf.dexlib2.iface.MethodParameter, org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getName() {
        BuilderStringReference builderStringReference = this.name;
        if (builderStringReference == null) {
            return null;
        }
        return builderStringReference.getString();
    }

    @Override // org.p088jf.dexlib2.iface.reference.TypeReference
    public String getType() {
        return this.type.getType();
    }
}
