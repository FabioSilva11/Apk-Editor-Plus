package org.p088jf.dexlib2.iface.reference;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface MethodProtoReference extends Reference, Comparable<MethodProtoReference> {
    int compareTo(MethodProtoReference methodProtoReference);

    boolean equals(Object obj);

    List<? extends CharSequence> getParameterTypes();

    String getReturnType();

    int hashCode();
}
