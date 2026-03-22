package org.p088jf.dexlib2.builder.debug;

import org.p088jf.dexlib2.builder.BuilderDebugItem;
import org.p088jf.dexlib2.iface.debug.RestartLocal;

/* JADX INFO: loaded from: classes.dex */
public class BuilderRestartLocal extends BuilderDebugItem implements RestartLocal {
    public final int register;

    public BuilderRestartLocal(int i) {
        this.register = i;
    }

    @Override // org.p088jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 6;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getName() {
        return null;
    }

    @Override // org.p088jf.dexlib2.iface.debug.RestartLocal
    public int getRegister() {
        return this.register;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getSignature() {
        return null;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getType() {
        return null;
    }
}
