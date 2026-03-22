package org.p088jf.dexlib2.builder.debug;

import org.p088jf.dexlib2.builder.BuilderDebugItem;
import org.p088jf.dexlib2.iface.debug.LineNumber;

/* JADX INFO: loaded from: classes.dex */
public class BuilderLineNumber extends BuilderDebugItem implements LineNumber {
    public final int lineNumber;

    public BuilderLineNumber(int i) {
        this.lineNumber = i;
    }

    @Override // org.p088jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 10;
    }

    @Override // org.p088jf.dexlib2.iface.debug.LineNumber
    public int getLineNumber() {
        return this.lineNumber;
    }
}
