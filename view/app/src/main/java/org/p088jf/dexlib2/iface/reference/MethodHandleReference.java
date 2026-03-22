package org.p088jf.dexlib2.iface.reference;

/* JADX INFO: loaded from: classes.dex */
public interface MethodHandleReference extends Reference, Comparable<MethodHandleReference> {
    int compareTo(MethodHandleReference methodHandleReference);

    boolean equals(Object obj);

    Reference getMemberReference();

    int getMethodHandleType();

    int hashCode();
}
