package org.p088jf.dexlib2.dexbacked;

import android.support.v7.appcompat.C0299R;
import java.io.UnsupportedEncodingException;
import org.p088jf.dexlib2.Opcodes;
import org.p088jf.dexlib2.dexbacked.raw.CdexHeaderItem;
import org.p088jf.dexlib2.util.DexUtil;

/* JADX INFO: loaded from: classes.dex */
public class CDexBackedDexFile extends DexBackedDexFile {
    public CDexBackedDexFile(Opcodes opcodes, byte[] bArr, int i) {
        super(opcodes, bArr, i);
    }

    public static boolean isCdex(byte[] bArr, int i) {
        if (i + 4 > bArr.length) {
            return false;
        }
        try {
            byte[] bytes = "cdex".getBytes("US-ASCII");
            return bArr[i] == bytes[0] && bArr[i + 1] == bytes[1] && bArr[i + 2] == bytes[2] && bArr[i + 3] == bytes[3];
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.p088jf.dexlib2.dexbacked.DexBackedDexFile
    public DexBackedMethodImplementation createMethodImplementation(DexBackedDexFile dexBackedDexFile, DexBackedMethod dexBackedMethod, int i) {
        return new CDexBackedMethodImplementation(dexBackedDexFile, dexBackedMethod, i);
    }

    @Override // org.p088jf.dexlib2.dexbacked.DexBackedDexFile
    public int getBaseDataOffset() {
        return getBuffer().readSmallUint(108);
    }

    public int getDebugInfoBase() {
        return getBuffer().readSmallUint(124);
    }

    public int getDebugInfoOffsetsPos() {
        return getBuffer().readSmallUint(C0299R.styleable.AppCompatTheme_listMenuViewStyle);
    }

    public int getDebugInfoOffsetsTableOffset() {
        return getBuffer().readSmallUint(120);
    }

    @Override // org.p088jf.dexlib2.dexbacked.DexBackedDexFile
    public Opcodes getDefaultOpcodes(int i) {
        return Opcodes.forApi(28);
    }

    @Override // org.p088jf.dexlib2.dexbacked.DexBackedDexFile
    public int getVersion(byte[] bArr, int i, boolean z) {
        return z ? DexUtil.verifyCdexHeader(bArr, i) : CdexHeaderItem.getVersion(bArr, i);
    }
}
