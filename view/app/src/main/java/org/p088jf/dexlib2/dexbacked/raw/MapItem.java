package org.p088jf.dexlib2.dexbacked.raw;

import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;

/* JADX INFO: loaded from: classes.dex */
public class MapItem {
    public final DexBackedDexFile dexFile;
    public final int offset;

    public MapItem(DexBackedDexFile dexBackedDexFile, int i) {
        this.dexFile = dexBackedDexFile;
        this.offset = i;
    }

    public int getItemCount() {
        return this.dexFile.getDataBuffer().readSmallUint(this.offset + 4);
    }

    public int getOffset() {
        return this.dexFile.getDataBuffer().readSmallUint(this.offset + 8);
    }

    public int getType() {
        return this.dexFile.getDataBuffer().readUshort(this.offset + 0);
    }
}
