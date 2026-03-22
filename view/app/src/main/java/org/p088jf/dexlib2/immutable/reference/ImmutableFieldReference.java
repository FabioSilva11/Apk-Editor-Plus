package org.p088jf.dexlib2.immutable.reference;

import org.p088jf.dexlib2.base.reference.BaseFieldReference;
import org.p088jf.dexlib2.iface.reference.FieldReference;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableFieldReference extends BaseFieldReference implements ImmutableReference {
    public final String definingClass;
    public final String name;
    public final String type;

    public ImmutableFieldReference(String str, String str2, String str3) {
        this.definingClass = str;
        this.name = str2;
        this.type = str3;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableFieldReference m3912of(FieldReference fieldReference) {
        return fieldReference instanceof ImmutableFieldReference ? (ImmutableFieldReference) fieldReference : new ImmutableFieldReference(fieldReference.getDefiningClass(), fieldReference.getName(), fieldReference.getType());
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getDefiningClass() {
        return this.definingClass;
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getName() {
        return this.name;
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getType() {
        return this.type;
    }
}
