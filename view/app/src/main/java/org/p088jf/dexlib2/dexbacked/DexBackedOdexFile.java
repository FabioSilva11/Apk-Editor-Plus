package org.p088jf.dexlib2.dexbacked;

import com.google.common.p073io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import org.p088jf.dexlib2.Opcodes;
import org.p088jf.dexlib2.dexbacked.raw.OdexHeaderItem;
import org.p088jf.dexlib2.util.DexUtil;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedOdexFile extends DexBackedDexFile {

    public static class NotAnOdexFile extends RuntimeException {
        public NotAnOdexFile(String str) {
            super(str);
        }
    }

    public DexBackedOdexFile(Opcodes opcodes, byte[] bArr, byte[] bArr2) {
        super(opcodes, bArr2);
    }

    public static DexBackedOdexFile fromInputStream(Opcodes opcodes, InputStream inputStream) throws IOException {
        DexUtil.verifyOdexHeader(inputStream);
        inputStream.reset();
        byte[] bArr = new byte[40];
        ByteStreams.readFully(inputStream, bArr);
        if (OdexHeaderItem.getDexOffset(bArr) > 40) {
            ByteStreams.skipFully(inputStream, r2 - 40);
        }
        return new DexBackedOdexFile(opcodes, bArr, ByteStreams.toByteArray(inputStream));
    }
}
