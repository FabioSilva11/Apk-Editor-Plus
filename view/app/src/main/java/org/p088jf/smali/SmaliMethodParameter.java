package org.p088jf.smali;

import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.Set;
import org.p088jf.dexlib2.base.BaseMethodParameter;
import org.p088jf.dexlib2.iface.Annotation;

/* JADX INFO: loaded from: classes.dex */
public class SmaliMethodParameter extends BaseMethodParameter implements WithRegister {
    public static final Comparator<WithRegister> COMPARATOR = new Comparator<WithRegister>() { // from class: org.jf.smali.SmaliMethodParameter.1
        @Override // java.util.Comparator
        public int compare(WithRegister withRegister, WithRegister withRegister2) {
            return Ints.compare(withRegister.getRegister(), withRegister2.getRegister());
        }
    };
    public Set<? extends Annotation> annotations = ImmutableSet.m3782of();
    public String name;
    public final int register;
    public final String type;

    public SmaliMethodParameter(int i, String str) {
        this.register = i;
        this.type = str;
    }

    @Override // org.p088jf.dexlib2.iface.MethodParameter
    public Set<? extends Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override // org.p088jf.dexlib2.iface.MethodParameter, org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getName() {
        return this.name;
    }

    @Override // org.p088jf.smali.WithRegister
    public int getRegister() {
        return this.register;
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
