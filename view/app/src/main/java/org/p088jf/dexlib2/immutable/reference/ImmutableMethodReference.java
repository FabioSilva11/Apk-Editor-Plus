package org.p088jf.dexlib2.immutable.reference;

import com.google.common.collect.ImmutableList;
import org.p088jf.dexlib2.base.reference.BaseMethodReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.dexlib2.immutable.util.CharSequenceConverter;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableMethodReference extends BaseMethodReference implements ImmutableReference {
    public final String definingClass;
    public final String name;
    public final ImmutableList<String> parameters;
    public final String returnType;

    public ImmutableMethodReference(String str, String str2, Iterable<? extends CharSequence> iterable, String str3) {
        this.definingClass = str;
        this.name = str2;
        this.parameters = CharSequenceConverter.immutableStringList(iterable);
        this.returnType = str3;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableMethodReference m3915of(MethodReference methodReference) {
        return methodReference instanceof ImmutableMethodReference ? (ImmutableMethodReference) methodReference : new ImmutableMethodReference(methodReference.getDefiningClass(), methodReference.getName(), methodReference.getParameterTypes(), methodReference.getReturnType());
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getDefiningClass() {
        return this.definingClass;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getName() {
        return this.name;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference
    public ImmutableList<String> getParameterTypes() {
        return this.parameters;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getReturnType() {
        return this.returnType;
    }
}
