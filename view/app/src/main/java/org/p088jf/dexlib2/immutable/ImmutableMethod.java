package org.p088jf.dexlib2.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Set;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.base.reference.BaseMethodReference;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.Method;
import org.p088jf.dexlib2.iface.MethodImplementation;
import org.p088jf.dexlib2.iface.MethodParameter;
import org.p088jf.util.ImmutableConverter;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableMethod extends BaseMethodReference implements Method {
    public static final ImmutableConverter<ImmutableMethod, Method> CONVERTER = new ImmutableConverter<ImmutableMethod, Method>() { // from class: org.jf.dexlib2.immutable.ImmutableMethod.1
        @Override // org.p088jf.util.ImmutableConverter
        public boolean isImmutable(Method method) {
            return method instanceof ImmutableMethod;
        }

        @Override // org.p088jf.util.ImmutableConverter
        public ImmutableMethod makeImmutable(Method method) {
            return ImmutableMethod.m3860of(method);
        }
    };
    public final int accessFlags;
    public final ImmutableSet<? extends ImmutableAnnotation> annotations;
    public final String definingClass;
    public final ImmutableSet<HiddenApiRestriction> hiddenApiRestrictions;
    public final ImmutableMethodImplementation methodImplementation;
    public final String name;
    public final ImmutableList<? extends ImmutableMethodParameter> parameters;
    public final String returnType;

    public ImmutableMethod(String str, String str2, Iterable<? extends MethodParameter> iterable, String str3, int i, Set<? extends Annotation> set, Set<HiddenApiRestriction> set2, MethodImplementation methodImplementation) {
        this.definingClass = str;
        this.name = str2;
        this.parameters = ImmutableMethodParameter.immutableListOf(iterable);
        this.returnType = str3;
        this.accessFlags = i;
        this.annotations = ImmutableAnnotation.immutableSetOf(set);
        this.hiddenApiRestrictions = set2 == null ? ImmutableSet.m3782of() : ImmutableSet.copyOf((Collection) set2);
        this.methodImplementation = ImmutableMethodImplementation.m3861of(methodImplementation);
    }

    public static ImmutableSortedSet<ImmutableMethod> immutableSetOf(Iterable<? extends Method> iterable) {
        return CONVERTER.toSortedSet(Ordering.natural(), iterable);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableMethod m3860of(Method method) {
        return method instanceof ImmutableMethod ? (ImmutableMethod) method : new ImmutableMethod(method.getDefiningClass(), method.getName(), method.getParameters(), method.getReturnType(), method.getAccessFlags(), method.getAnnotations(), method.getHiddenApiRestrictions(), method.getImplementation());
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public ImmutableSet<? extends ImmutableAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getDefiningClass() {
        return this.definingClass;
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        return this.hiddenApiRestrictions;
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public ImmutableMethodImplementation getImplementation() {
        return this.methodImplementation;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getName() {
        return this.name;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference
    public ImmutableList<? extends CharSequence> getParameterTypes() {
        return this.parameters;
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public ImmutableList<? extends ImmutableMethodParameter> getParameters() {
        return this.parameters;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getReturnType() {
        return this.returnType;
    }
}
