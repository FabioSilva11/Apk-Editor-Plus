package org.p088jf.dexlib2.iface.reference;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface MethodReference extends Reference, Comparable<MethodReference> {
    int compareTo(MethodReference methodReference);

    boolean equals(Object obj);

    String getDefiningClass();

    String getName();

    List<? extends CharSequence> getParameterTypes();

    String getReturnType();

    int hashCode();
}
