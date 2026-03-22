package org.p088jf.dexlib2.dexbacked;

import android.support.v4.internal.view.SupportMenu;
import org.p088jf.dexlib2.dexbacked.raw.CodeItem;

/* JADX INFO: loaded from: classes.dex */
public class CDexBackedMethodImplementation extends DexBackedMethodImplementation {
    public CDexBackedMethodImplementation(DexBackedDexFile dexBackedDexFile, DexBackedMethod dexBackedMethod, int i) {
        super(dexBackedDexFile, dexBackedMethod, i);
    }

    @Override // org.p088jf.dexlib2.dexbacked.DexBackedMethodImplementation
    public int getDebugOffset() {
        CDexBackedDexFile cDexBackedDexFile = (CDexBackedDexFile) this.dexFile;
        int i = this.method.methodIndex;
        int i2 = (i / 16) * 4;
        int i3 = i % 16;
        int debugInfoOffsetsPos = cDexBackedDexFile.getDebugInfoOffsetsPos();
        DexReader<? extends DexBuffer> dexReader = cDexBackedDexFile.getDataBuffer().readerAt(debugInfoOffsetsPos + cDexBackedDexFile.getDataBuffer().readSmallUint(cDexBackedDexFile.getDebugInfoOffsetsTableOffset() + debugInfoOffsetsPos + i2));
        int ubyte = (dexReader.readUbyte() << 8) + dexReader.readUbyte();
        if (((1 << i3) & ubyte) == 0) {
            return 0;
        }
        int iBitCount = Integer.bitCount((SupportMenu.USER_MASK >> (16 - i3)) & ubyte);
        int debugInfoBase = cDexBackedDexFile.getDebugInfoBase();
        for (int i4 = 0; i4 < iBitCount; i4++) {
            debugInfoBase += dexReader.readBigUleb128();
        }
        return debugInfoBase + dexReader.readBigUleb128();
    }

    public int getInsCount() {
        int ushort = (this.dexFile.getDataBuffer().readUshort(this.codeOffset) >> CodeItem.CDEX_INS_COUNT_SHIFT) & 15;
        if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_INS_COUNT) == 0) {
            return ushort;
        }
        int i = (getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_INSTRUCTIONS_SIZE) != 0 ? 3 : 1;
        if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_REGISTER_COUNT) != 0) {
            i++;
        }
        return ushort + this.dexFile.getDataBuffer().readUshort(this.codeOffset - (i * 2));
    }

    @Override // org.p088jf.dexlib2.dexbacked.DexBackedMethodImplementation
    public int getInstructionsSize() {
        int ushort = this.dexFile.getDataBuffer().readUshort(this.codeOffset + CodeItem.CDEX_INSTRUCTIONS_SIZE_AND_PREHEADER_FLAGS_OFFSET) >> CodeItem.CDEX_INSTRUCTIONS_SIZE_SHIFT;
        return (getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_INSTRUCTIONS_SIZE) != 0 ? ushort + this.dexFile.getDataBuffer().readUshort(this.codeOffset - 2) + (this.dexFile.getDataBuffer().readUshort(this.codeOffset - 4) << 16) : ushort;
    }

    @Override // org.p088jf.dexlib2.dexbacked.DexBackedMethodImplementation
    public int getInstructionsStartOffset() {
        return this.codeOffset + 4;
    }

    public final int getPreheaderFlags() {
        return this.dexFile.getDataBuffer().readUshort(this.codeOffset + CodeItem.CDEX_INSTRUCTIONS_SIZE_AND_PREHEADER_FLAGS_OFFSET) & CodeItem.CDEX_PREHEADER_FLAGS_MASK;
    }

    @Override // org.p088jf.dexlib2.dexbacked.DexBackedMethodImplementation, org.p088jf.dexlib2.iface.MethodImplementation
    public int getRegisterCount() {
        int ushort = ((this.dexFile.getDataBuffer().readUshort(this.codeOffset) >> CodeItem.CDEX_REGISTER_COUNT_SHIFT) & 15) + getInsCount();
        if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_REGISTER_COUNT) != 0) {
            return ushort + this.dexFile.getDataBuffer().readUshort(this.codeOffset - (((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_INSTRUCTIONS_SIZE) > 0 ? 3 : 1) * 2));
        }
        return ushort;
    }

    @Override // org.p088jf.dexlib2.dexbacked.DexBackedMethodImplementation
    public int getTriesSize() {
        int ushort = (this.dexFile.getDataBuffer().readUshort(this.codeOffset) >> CodeItem.CDEX_TRIES_SIZE_SHIFT) & 15;
        if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_TRIES_COUNT) == 0) {
            return ushort;
        }
        int iBitCount = Integer.bitCount(getPreheaderFlags());
        if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_INSTRUCTIONS_SIZE) != 0) {
            iBitCount++;
        }
        return ushort + this.dexFile.getDataBuffer().readUshort(this.codeOffset - (iBitCount * 2));
    }
}
