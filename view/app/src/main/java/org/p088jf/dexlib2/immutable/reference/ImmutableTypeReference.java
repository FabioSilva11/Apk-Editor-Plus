package org.p088jf.dexlib2.immutable.reference;

import org.p088jf.dexlib2.base.reference.BaseTypeReference;
import org.p088jf.dexlib2.iface.reference.TypeReference;
import org.p088jf.util.ImmutableConverter;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableTypeReference extends BaseTypeReference implements ImmutableReference {
    public final String type;

    static {
        new ImmutableConverter<ImmutableTypeReference, TypeReference>() { // from class: org.jf.dexlib2.immutable.reference.ImmutableTypeReference.1
            @Override // org.p088jf.util.ImmutableConverter
            public boolean isImmutable(TypeReference typeReference) {
                return typeReference instanceof ImmutableTypeReference;
            }

            @Override // org.p088jf.util.ImmutableConverter
            public ImmutableTypeReference makeImmutable(TypeReference typeReference) {
                return ImmutableTypeReference.m3919of(typeReference);
            }
        };
    }

    public ImmutableTypeReference(String str) {
        this.type = str;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableTypeReference m3919of(TypeReference typeReference) {
        return typeReference instanceof ImmutableTypeReference ? (ImmutableTypeReference) typeReference : new ImmutableTypeReference(typeReference.getType());
    }

    @Override // org.p088jf.dexlib2.iface.reference.TypeReference
    public String getType() {
        return this.type;
    }
}
