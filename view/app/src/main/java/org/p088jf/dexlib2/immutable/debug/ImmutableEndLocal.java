package org.p088jf.dexlib2.immutable.debug;

import org.p088jf.dexlib2.iface.debug.EndLocal;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableEndLocal extends ImmutableDebugItem implements EndLocal {
    public final String name;
    public final int register;
    public final String signature;
    public final String type;

    public ImmutableEndLocal(int i, int i2, String str, String str2, String str3) {
        super(i);
        this.register = i2;
        this.name = str;
        this.type = str2;
        this.signature = str3;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableEndLocal m3865of(EndLocal endLocal) {
        return endLocal instanceof ImmutableEndLocal ? (ImmutableEndLocal) endLocal : new ImmutableEndLocal(endLocal.getCodeAddress(), endLocal.getRegister(), endLocal.getType(), endLocal.getName(), endLocal.getSignature());
    }

    @Override // org.p088jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 5;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getName() {
        return this.name;
    }

    @Override // org.p088jf.dexlib2.iface.debug.EndLocal
    public int getRegister() {
        return this.register;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getSignature() {
        return this.signature;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getType() {
        return this.type;
    }
}
