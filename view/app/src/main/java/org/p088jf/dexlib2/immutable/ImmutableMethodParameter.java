package org.p088jf.dexlib2.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import org.p088jf.dexlib2.base.BaseMethodParameter;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.MethodParameter;
import org.p088jf.util.ImmutableConverter;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableMethodParameter extends BaseMethodParameter {
    public static final ImmutableConverter<ImmutableMethodParameter, MethodParameter> CONVERTER = new ImmutableConverter<ImmutableMethodParameter, MethodParameter>() { // from class: org.jf.dexlib2.immutable.ImmutableMethodParameter.1
        @Override // org.p088jf.util.ImmutableConverter
        public boolean isImmutable(MethodParameter methodParameter) {
            return methodParameter instanceof ImmutableMethodParameter;
        }

        @Override // org.p088jf.util.ImmutableConverter
        public ImmutableMethodParameter makeImmutable(MethodParameter methodParameter) {
            return ImmutableMethodParameter.m3862of(methodParameter);
        }
    };
    public final ImmutableSet<? extends ImmutableAnnotation> annotations;
    public final String name;
    public final String type;

    public ImmutableMethodParameter(String str, Set<? extends Annotation> set, String str2) {
        this.type = str;
        this.annotations = ImmutableAnnotation.immutableSetOf(set);
        this.name = str2;
    }

    public static ImmutableList<ImmutableMethodParameter> immutableListOf(Iterable<? extends MethodParameter> iterable) {
        return CONVERTER.toList(iterable);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableMethodParameter m3862of(MethodParameter methodParameter) {
        return methodParameter instanceof ImmutableMethodParameter ? (ImmutableMethodParameter) methodParameter : new ImmutableMethodParameter(methodParameter.getType(), methodParameter.getAnnotations(), methodParameter.getName());
    }

    @Override // org.p088jf.dexlib2.iface.MethodParameter
    public Set<? extends Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override // org.p088jf.dexlib2.iface.MethodParameter, org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getName() {
        return this.name;
    }

    @Override // org.p088jf.dexlib2.base.BaseMethodParameter, org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getSignature() {
        return null;
    }

    @Override // org.p088jf.dexlib2.iface.reference.TypeReference
    public String getType() {
        return this.type;
    }
}
