package org.p088jf.dexlib2.dexbacked.reference;

import org.p088jf.dexlib2.base.reference.BaseStringReference;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.iface.reference.Reference;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedStringReference extends BaseStringReference {
    public final DexBackedDexFile dexFile;
    public final int stringIndex;

    public DexBackedStringReference(DexBackedDexFile dexBackedDexFile, int i) {
        this.dexFile = dexBackedDexFile;
        this.stringIndex = i;
    }

    @Override // org.p088jf.dexlib2.iface.reference.StringReference
    public String getString() {
        return this.dexFile.getStringSection().get(this.stringIndex);
    }

    @Override // org.p088jf.dexlib2.base.reference.BaseReference, org.p088jf.dexlib2.iface.reference.Reference
    public void validateReference() throws Reference.InvalidReferenceException {
        int i = this.stringIndex;
        if (i < 0 || i >= this.dexFile.getStringSection().size()) {
            throw new Reference.InvalidReferenceException("string@" + this.stringIndex);
        }
    }
}
