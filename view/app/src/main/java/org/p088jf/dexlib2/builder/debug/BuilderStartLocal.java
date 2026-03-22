package org.p088jf.dexlib2.builder.debug;

import org.p088jf.dexlib2.builder.BuilderDebugItem;
import org.p088jf.dexlib2.iface.debug.StartLocal;
import org.p088jf.dexlib2.iface.reference.StringReference;
import org.p088jf.dexlib2.iface.reference.TypeReference;

/* JADX INFO: loaded from: classes.dex */
public class BuilderStartLocal extends BuilderDebugItem implements StartLocal {
    public final StringReference name;
    public final int register;
    public final StringReference signature;
    public final TypeReference type;

    public BuilderStartLocal(int i, StringReference stringReference, TypeReference typeReference, StringReference stringReference2) {
        this.register = i;
        this.name = stringReference;
        this.type = typeReference;
        this.signature = stringReference2;
    }

    @Override // org.p088jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 3;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getName() {
        StringReference stringReference = this.name;
        if (stringReference == null) {
            return null;
        }
        return stringReference.getString();
    }

    @Override // org.p088jf.dexlib2.iface.debug.StartLocal
    public StringReference getNameReference() {
        return this.name;
    }

    @Override // org.p088jf.dexlib2.iface.debug.StartLocal
    public int getRegister() {
        return this.register;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getSignature() {
        StringReference stringReference = this.signature;
        if (stringReference == null) {
            return null;
        }
        return stringReference.getString();
    }

    @Override // org.p088jf.dexlib2.iface.debug.StartLocal
    public StringReference getSignatureReference() {
        return this.signature;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getType() {
        TypeReference typeReference = this.type;
        if (typeReference == null) {
            return null;
        }
        return typeReference.getType();
    }

    @Override // org.p088jf.dexlib2.iface.debug.StartLocal
    public TypeReference getTypeReference() {
        return this.type;
    }
}
