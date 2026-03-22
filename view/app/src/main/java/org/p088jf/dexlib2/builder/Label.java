package org.p088jf.dexlib2.builder;

/* JADX INFO: loaded from: classes.dex */
public class Label extends ItemWithLocation {
    public int getCodeAddress() {
        return getLocation().getCodeAddress();
    }

    public MethodLocation getLocation() {
        MethodLocation methodLocation = this.location;
        if (methodLocation != null) {
            return methodLocation;
        }
        throw new IllegalStateException("Cannot get the location of a label that hasn't been placed yet.");
    }
}
