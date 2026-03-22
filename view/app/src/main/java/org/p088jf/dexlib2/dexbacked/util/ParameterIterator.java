package org.p088jf.dexlib2.dexbacked.util;

import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p088jf.dexlib2.base.BaseMethodParameter;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.MethodParameter;

/* JADX INFO: loaded from: classes.dex */
public class ParameterIterator implements Iterator<MethodParameter> {
    public final Iterator<? extends Set<? extends Annotation>> parameterAnnotations;
    public final Iterator<String> parameterNames;
    public final Iterator<? extends CharSequence> parameterTypes;

    public ParameterIterator(List<? extends CharSequence> list, List<? extends Set<? extends Annotation>> list2, Iterator<String> it) {
        this.parameterTypes = list.iterator();
        this.parameterAnnotations = list2.iterator();
        this.parameterNames = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.parameterTypes.hasNext();
    }

    @Override // java.util.Iterator
    public MethodParameter next() {
        final String string = this.parameterTypes.next().toString();
        final Set<? extends Annotation> next = this.parameterAnnotations.hasNext() ? this.parameterAnnotations.next() : ImmutableSet.m3782of();
        final String next2 = this.parameterNames.hasNext() ? this.parameterNames.next() : null;
        return new BaseMethodParameter(this) { // from class: org.jf.dexlib2.dexbacked.util.ParameterIterator.1
            @Override // org.p088jf.dexlib2.iface.MethodParameter
            public Set<? extends Annotation> getAnnotations() {
                return next;
            }

            @Override // org.p088jf.dexlib2.iface.MethodParameter, org.p088jf.dexlib2.iface.debug.LocalInfo
            public String getName() {
                return next2;
            }

            @Override // org.p088jf.dexlib2.iface.reference.TypeReference
            public String getType() {
                return string;
            }
        };
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
