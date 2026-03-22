package org.p088jf.dexlib2.builder;

/* JADX INFO: loaded from: classes.dex */
public class LocatedLabels extends LocatedItems<Label> {
    @Override // org.p088jf.dexlib2.builder.LocatedItems
    public String getAddLocatedItemError() {
        return "Cannot add a label that is already placed.You must remove it from its current location first.";
    }
}
