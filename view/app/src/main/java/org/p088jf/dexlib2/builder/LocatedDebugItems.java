package org.p088jf.dexlib2.builder;

/* JADX INFO: loaded from: classes.dex */
public class LocatedDebugItems extends LocatedItems<BuilderDebugItem> {
    @Override // org.p088jf.dexlib2.builder.LocatedItems
    public String getAddLocatedItemError() {
        return "Cannot add a debug item that has already been added to a method.You must remove it from its current location first.";
    }
}
