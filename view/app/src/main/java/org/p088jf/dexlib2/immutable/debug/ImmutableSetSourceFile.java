package org.p088jf.dexlib2.immutable.debug;

import org.p088jf.dexlib2.base.reference.BaseStringReference;
import org.p088jf.dexlib2.iface.debug.SetSourceFile;
import org.p088jf.dexlib2.iface.reference.StringReference;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableSetSourceFile extends ImmutableDebugItem implements SetSourceFile {
    public final String sourceFile;

    public ImmutableSetSourceFile(int i, String str) {
        super(i);
        this.sourceFile = str;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableSetSourceFile m3870of(SetSourceFile setSourceFile) {
        return setSourceFile instanceof ImmutableSetSourceFile ? (ImmutableSetSourceFile) setSourceFile : new ImmutableSetSourceFile(setSourceFile.getCodeAddress(), setSourceFile.getSourceFile());
    }

    @Override // org.p088jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 9;
    }

    @Override // org.p088jf.dexlib2.iface.debug.SetSourceFile
    public String getSourceFile() {
        return this.sourceFile;
    }

    @Override // org.p088jf.dexlib2.iface.debug.SetSourceFile
    public StringReference getSourceFileReference() {
        if (this.sourceFile == null) {
            return null;
        }
        return new BaseStringReference() { // from class: org.jf.dexlib2.immutable.debug.ImmutableSetSourceFile.1
            @Override // org.p088jf.dexlib2.iface.reference.StringReference
            public String getString() {
                return ImmutableSetSourceFile.this.sourceFile;
            }
        };
    }
}
