package org.p088jf.dexlib2.builder;

/* JADX INFO: loaded from: classes.dex */
public abstract class ItemWithLocation {
    public MethodLocation location;

    public boolean isPlaced() {
        return this.location != null;
    }

    public void setLocation(MethodLocation methodLocation) {
        this.location = methodLocation;
    }
}
