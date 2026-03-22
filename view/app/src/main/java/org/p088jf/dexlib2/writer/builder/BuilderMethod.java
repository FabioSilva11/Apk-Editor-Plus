package org.p088jf.dexlib2.writer.builder;

import java.util.List;
import java.util.Set;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.base.reference.BaseMethodReference;
import org.p088jf.dexlib2.iface.Method;
import org.p088jf.dexlib2.iface.MethodImplementation;

/* JADX INFO: loaded from: classes.dex */
public class BuilderMethod extends BaseMethodReference implements Method {
    public final int accessFlags;
    public final BuilderAnnotationSet annotations;
    public final Set<HiddenApiRestriction> hiddenApiRestrictions;
    public final MethodImplementation methodImplementation;
    public final BuilderMethodReference methodReference;
    public final List<? extends BuilderMethodParameter> parameters;
    public int annotationSetRefListOffset = 0;
    public int codeItemOffset = 0;

    public BuilderMethod(BuilderMethodReference builderMethodReference, List<? extends BuilderMethodParameter> list, int i, BuilderAnnotationSet builderAnnotationSet, Set<HiddenApiRestriction> set, MethodImplementation methodImplementation) {
        this.methodReference = builderMethodReference;
        this.parameters = list;
        this.accessFlags = i;
        this.annotations = builderAnnotationSet;
        this.hiddenApiRestrictions = set;
        this.methodImplementation = methodImplementation;
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public BuilderAnnotationSet getAnnotations() {
        return this.annotations;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getDefiningClass() {
        return this.methodReference.definingClass.getType();
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        return this.hiddenApiRestrictions;
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public MethodImplementation getImplementation() {
        return this.methodImplementation;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getName() {
        return this.methodReference.name.getString();
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference
    public BuilderTypeList getParameterTypes() {
        return this.methodReference.proto.parameterTypes;
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public List<? extends BuilderMethodParameter> getParameters() {
        return this.parameters;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getReturnType() {
        return this.methodReference.proto.returnType.getType();
    }
}
