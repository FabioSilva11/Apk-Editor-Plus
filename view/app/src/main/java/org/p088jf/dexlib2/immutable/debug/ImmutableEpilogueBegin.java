package org.p088jf.dexlib2.immutable.debug;

import org.p088jf.dexlib2.iface.debug.EpilogueBegin;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableEpilogueBegin extends ImmutableDebugItem implements EpilogueBegin {
    public ImmutableEpilogueBegin(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableEpilogueBegin m3866of(EpilogueBegin epilogueBegin) {
        return epilogueBegin instanceof ImmutableEpilogueBegin ? (ImmutableEpilogueBegin) epilogueBegin : new ImmutableEpilogueBegin(epilogueBegin.getCodeAddress());
    }

    @Override // org.p088jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 8;
    }
}
