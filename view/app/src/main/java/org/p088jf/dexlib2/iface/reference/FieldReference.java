package org.p088jf.dexlib2.iface.reference;

/* JADX INFO: loaded from: classes.dex */
public interface FieldReference extends Reference, Comparable<FieldReference> {
    int compareTo(FieldReference fieldReference);

    boolean equals(Object obj);

    String getDefiningClass();

    String getName();

    String getType();

    int hashCode();
}
