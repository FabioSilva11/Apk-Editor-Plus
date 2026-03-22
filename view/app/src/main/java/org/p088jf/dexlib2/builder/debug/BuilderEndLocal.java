package org.p088jf.dexlib2.builder.debug;

import org.p088jf.dexlib2.builder.BuilderDebugItem;
import org.p088jf.dexlib2.iface.debug.EndLocal;

/* JADX INFO: loaded from: classes.dex */
public class BuilderEndLocal extends BuilderDebugItem implements EndLocal {
    public final int register;

    public BuilderEndLocal(int i) {
        this.register = i;
    }

    @Override // org.p088jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 5;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LocalInfo
    public String getName() {
        return null;
    }

    @Override // org.p088jf.dexlib2.iface.debug.EndLocal
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
