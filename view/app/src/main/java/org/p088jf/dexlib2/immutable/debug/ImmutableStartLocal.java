package org.p088jf.dexlib2.immutable.debug;

import org.p088jf.dexlib2.base.reference.BaseStringReference;
import org.p088jf.dexlib2.base.reference.BaseTypeReference;
import org.p088jf.dexlib2.iface.debug.StartLocal;
import org.p088jf.dexlib2.iface.reference.StringReference;
import org.p088jf.dexlib2.iface.reference.TypeReference;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableStartLocal extends ImmutableDebugItem implements StartLocal {
    public final String name;
    public final int register;
    public final String signature;
    public final String type;

    public ImmutableStartLocal(int i, int i2, String str, String str2, String str3) {
        super(i);
        this.register = i2;
        this.name = str;
        this.type = str2;
        this.signature = str3;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableStartLocal m3871of(StartLocal startLocal) {
        return startLocal instanceof ImmutableStartLocal ? (ImmutableStartLocal) startLocal : new ImmutableStartLocal(startLocal.getCodeAddress(), startLocal.getRegister(), startLocal.getName(), startLocal.getType(), startLocal.getSignature());
    }

    @Override // org.p088jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 3;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getName() {
        return this.name;
    }

    @Override // org.p088jf.dexlib2.iface.debug.StartLocal
    public StringReference getNameReference() {
        if (this.name == null) {
            return null;
        }
        return new BaseStringReference() { // from class: org.jf.dexlib2.immutable.debug.ImmutableStartLocal.1
            @Override // org.p088jf.dexlib2.iface.reference.StringReference
            public String getString() {
                return ImmutableStartLocal.this.name;
            }
        };
    }

    @Override // org.p088jf.dexlib2.iface.debug.StartLocal
    public int getRegister() {
        return this.register;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getSignature() {
        return this.signature;
    }

    @Override // org.p088jf.dexlib2.iface.debug.StartLocal
    public StringReference getSignatureReference() {
        if (this.signature == null) {
            return null;
        }
        return new BaseStringReference() { // from class: org.jf.dexlib2.immutable.debug.ImmutableStartLocal.3
            @Override // org.p088jf.dexlib2.iface.reference.StringReference
            public String getString() {
                return ImmutableStartLocal.this.signature;
            }
        };
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getType() {
        return this.type;
    }

    @Override // org.p088jf.dexlib2.iface.debug.StartLocal
    public TypeReference getTypeReference() {
        if (this.type == null) {
            return null;
        }
        return new BaseTypeReference() { // from class: org.jf.dexlib2.immutable.debug.ImmutableStartLocal.2
            @Override // org.p088jf.dexlib2.iface.reference.TypeReference
            public String getType() {
                return ImmutableStartLocal.this.type;
            }
        };
    }
}
