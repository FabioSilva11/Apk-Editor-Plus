package org.p088jf.dexlib2.builder.debug;

import org.p088jf.dexlib2.builder.BuilderDebugItem;
import org.p088jf.dexlib2.iface.debug.SetSourceFile;
import org.p088jf.dexlib2.iface.reference.StringReference;

/* JADX INFO: loaded from: classes.dex */
public class BuilderSetSourceFile extends BuilderDebugItem implements SetSourceFile {
    public final StringReference sourceFile;

    public BuilderSetSourceFile(StringReference stringReference) {
        this.sourceFile = stringReference;
    }

    @Override // org.p088jf.dexlib2.iface.debug.DebugItem
    public int getDebugItemType() {
        return 9;
    }

    @Override // org.p088jf.dexlib2.iface.debug.SetSourceFile
    public String getSourceFile() {
        StringReference stringReference = this.sourceFile;
        if (stringReference == null) {
            return null;
        }
        return stringReference.getString();
    }

    @Override // org.p088jf.dexlib2.iface.debug.SetSourceFile
    public StringReference getSourceFileReference() {
        return this.sourceFile;
    }
}
