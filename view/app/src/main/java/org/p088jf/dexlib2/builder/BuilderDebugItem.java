package org.p088jf.dexlib2.builder;

import org.p088jf.dexlib2.iface.debug.DebugItem;

/* JADX INFO: loaded from: classes.dex */
public abstract class BuilderDebugItem extends ItemWithLocation implements DebugItem {
    @Override // org.p088jf.dexlib2.iface.debug.DebugItem
    public int getCodeAddress() {
        MethodLocation methodLocation = this.location;
        if (methodLocation != null) {
            return methodLocation.getCodeAddress();
        }
        throw new IllegalStateException("Cannot get the address of a BuilderDebugItem that isn't associated with a method.");
    }
}
