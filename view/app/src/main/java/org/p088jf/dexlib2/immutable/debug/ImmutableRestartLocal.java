package org.p088jf.dexlib2.immutable.debug;

import org.p088jf.dexlib2.iface.debug.RestartLocal;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableRestartLocal extends ImmutableDebugItem implements RestartLocal {
    public final String name;
    public final int register;
    public final String signature;
    public final String type;

    public ImmutableRestartLocal(int i, int i2, String str, String str2, String str3) {
        super(i);
        this.register = i2;
        this.name = str;
        this.type = str2;
        this.signature = str3;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableRestartLocal m3869of(RestartLocal restartLocal) {
        return restartLocal instanceof ImmutableRestartLocal ? (ImmutableRestartLocal) restartLocal : new ImmutableRestartLocal(restartLocal.getCodeAddress(), restartLocal.getRegister(), restartLocal.getType(), restartLocal.getName(), restartLocal.getSignature());
    }

    @Override // org.p088jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 6;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getName() {
        return this.name;
    }

    @Override // org.p088jf.dexlib2.iface.debug.RestartLocal
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
