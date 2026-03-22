package org.p088jf.dexlib2.util;

import com.google.common.p073io.ByteStreams;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexBackedOdexFile;
import org.p088jf.dexlib2.dexbacked.raw.CdexHeaderItem;
import org.p088jf.dexlib2.dexbacked.raw.HeaderItem;
import org.p088jf.dexlib2.dexbacked.raw.OdexHeaderItem;

/* JADX INFO: loaded from: classes.dex */
public class DexUtil {

    public static class InvalidFile extends RuntimeException {
        public InvalidFile(String str) {
            super(str);
        }
    }

    public static class UnsupportedFile extends RuntimeException {
        public UnsupportedFile(String str) {
            super(str);
        }
    }

    public static int verifyCdexHeader(byte[] bArr, int i) {
        int version = CdexHeaderItem.getVersion(bArr, i);
        if (version == -1) {
            StringBuilder sb = new StringBuilder("Not a valid cdex magic value:");
            for (int i2 = 0; i2 < 8; i2++) {
                sb.append(String.format(" %02x", Byte.valueOf(bArr[i + i2])));
            }
            throw new DexBackedDexFile.NotADexFile(sb.toString());
        }
        if (!CdexHeaderItem.isSupportedCdexVersion(version)) {
            throw new UnsupportedFile(String.format("Dex version %03d is not supported", Integer.valueOf(version)));
        }
        int endian = HeaderItem.getEndian(bArr, i);
        if (endian == 2018915346) {
            throw new UnsupportedFile("Big endian dex files are not supported");
        }
        if (endian == 305419896) {
            return version;
        }
        throw new InvalidFile(String.format("Invalid endian tag: 0x%x", Integer.valueOf(endian)));
    }

    public static int verifyDexHeader(InputStream inputStream) throws IOException {
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("InputStream must support mark");
        }
        inputStream.mark(44);
        byte[] bArr = new byte[44];
        try {
            try {
                ByteStreams.readFully(inputStream, bArr);
                inputStream.reset();
                return verifyDexHeader(bArr, 0);
            } catch (EOFException unused) {
                throw new DexBackedDexFile.NotADexFile("File is too short");
            }
        } catch (Throwable th) {
            inputStream.reset();
            throw th;
        }
    }

    public static int verifyDexHeader(byte[] bArr, int i) {
        int version = HeaderItem.getVersion(bArr, i);
        if (version == -1) {
            StringBuilder sb = new StringBuilder("Not a valid dex magic value:");
            for (int i2 = 0; i2 < 8; i2++) {
                sb.append(String.format(" %02x", Byte.valueOf(bArr[i2])));
            }
            throw new DexBackedDexFile.NotADexFile(sb.toString());
        }
        if (!HeaderItem.isSupportedDexVersion(version)) {
            throw new UnsupportedFile(String.format("Dex version %03d is not supported", Integer.valueOf(version)));
        }
        int endian = HeaderItem.getEndian(bArr, i);
        if (endian == 2018915346) {
            throw new UnsupportedFile("Big endian dex files are not supported");
        }
        if (endian == 305419896) {
            return version;
        }
        throw new InvalidFile(String.format("Invalid endian tag: 0x%x", Integer.valueOf(endian)));
    }

    public static void verifyOdexHeader(InputStream inputStream) throws IOException {
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("InputStream must support mark");
        }
        inputStream.mark(8);
        byte[] bArr = new byte[8];
        try {
            try {
                ByteStreams.readFully(inputStream, bArr);
                inputStream.reset();
                verifyOdexHeader(bArr, 0);
            } catch (EOFException unused) {
                throw new DexBackedOdexFile.NotAnOdexFile("File is too short");
            }
        } catch (Throwable th) {
            inputStream.reset();
            throw th;
        }
    }

    public static void verifyOdexHeader(byte[] bArr, int i) {
        int version = OdexHeaderItem.getVersion(bArr, i);
        if (version != -1) {
            if (!OdexHeaderItem.isSupportedOdexVersion(version)) {
                throw new UnsupportedFile(String.format("Odex version %03d is not supported", Integer.valueOf(version)));
            }
            return;
        }
        StringBuilder sb = new StringBuilder("Not a valid odex magic value:");
        for (int i2 = 0; i2 < 8; i2++) {
            sb.append(String.format(" %02x", Byte.valueOf(bArr[i2])));
        }
        throw new DexBackedOdexFile.NotAnOdexFile(sb.toString());
    }
}
