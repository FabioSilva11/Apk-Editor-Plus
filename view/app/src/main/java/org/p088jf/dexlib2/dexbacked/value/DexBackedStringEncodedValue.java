package org.p088jf.dexlib2.dexbacked.value;

import org.p088jf.dexlib2.base.value.BaseStringEncodedValue;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexReader;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedStringEncodedValue extends BaseStringEncodedValue {
    public final DexBackedDexFile dexFile;
    public final int stringIndex;

    public DexBackedStringEncodedValue(DexBackedDexFile dexBackedDexFile, DexReader dexReader, int i) {
        this.dexFile = dexBackedDexFile;
        this.stringIndex = dexReader.readSizedSmallUint(i + 1);
    }

    @Override // org.p088jf.dexlib2.iface.value.StringEncodedValue
    public String getValue() {
        return this.dexFile.getStringSection().get(this.stringIndex);
    }
}
