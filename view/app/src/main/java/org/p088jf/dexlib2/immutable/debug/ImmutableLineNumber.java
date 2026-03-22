package org.p088jf.dexlib2.immutable.debug;

import org.p088jf.dexlib2.iface.debug.LineNumber;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableLineNumber extends ImmutableDebugItem implements LineNumber {
    public final int lineNumber;

    public ImmutableLineNumber(int i, int i2) {
        super(i);
        this.lineNumber = i2;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableLineNumber m3867of(LineNumber lineNumber) {
        return lineNumber instanceof ImmutableLineNumber ? (ImmutableLineNumber) lineNumber : new ImmutableLineNumber(lineNumber.getCodeAddress(), lineNumber.getLineNumber());
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
