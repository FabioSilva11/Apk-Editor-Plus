package org.p088jf.dexlib2;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.p073io.ByteStreams;
import com.google.common.p073io.Files;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexBackedOdexFile;
import org.p088jf.dexlib2.dexbacked.OatFile;
import org.p088jf.dexlib2.dexbacked.ZipDexContainer;
import org.p088jf.dexlib2.iface.DexFile;
import org.p088jf.dexlib2.iface.MultiDexContainer;
import org.p088jf.dexlib2.writer.pool.DexPool;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public final class DexFileFactory {

    public static class DexEntryFinder {
        public final MultiDexContainer<? extends DexBackedDexFile> dexContainer;
        public final String filename;

        public DexEntryFinder(String str, MultiDexContainer<? extends DexBackedDexFile> multiDexContainer) {
            this.filename = str;
            this.dexContainer = multiDexContainer;
        }

        public MultiDexContainer.DexEntry<? extends DexBackedDexFile> findEntry(String str, boolean z) throws IOException {
            if (z) {
                try {
                    MultiDexContainer.DexEntry entry = this.dexContainer.getEntry(str);
                    if (entry != null) {
                        return entry;
                    }
                    throw new DexFileNotFoundException("Could not find entry %s in %s.", str, this.filename);
                } catch (DexBackedDexFile.NotADexFile unused) {
                    throw new UnsupportedFileTypeException("Entry %s in %s is not a dex file", str, this.filename);
                }
            }
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            ArrayList arrayListNewArrayList2 = Lists.newArrayList();
            ArrayList arrayListNewArrayList3 = Lists.newArrayList();
            ArrayList arrayListNewArrayList4 = Lists.newArrayList();
            for (String str2 : this.dexContainer.getDexEntryNames()) {
                if (DexFileFactory.fullEntryMatch(str2, str)) {
                    arrayListNewArrayList.add(str2);
                    arrayListNewArrayList2.add(this.dexContainer.getEntry(str2));
                } else if (DexFileFactory.partialEntryMatch(str2, str)) {
                    arrayListNewArrayList3.add(str2);
                    arrayListNewArrayList4.add(this.dexContainer.getEntry(str2));
                }
            }
            if (arrayListNewArrayList2.size() == 1) {
                try {
                    return (MultiDexContainer.DexEntry) arrayListNewArrayList2.get(0);
                } catch (DexBackedDexFile.NotADexFile unused2) {
                    throw new UnsupportedFileTypeException("Entry %s in %s is not a dex file", arrayListNewArrayList.get(0), this.filename);
                }
            }
            if (arrayListNewArrayList2.size() > 1) {
                throw new MultipleMatchingDexEntriesException(String.format("Multiple entries in %s match %s: %s", this.filename, str, Joiner.m3775on(", ").join(arrayListNewArrayList)), new Object[0]);
            }
            if (arrayListNewArrayList4.size() == 0) {
                throw new DexFileNotFoundException("Could not find a dex entry in %s matching %s", this.filename, str);
            }
            if (arrayListNewArrayList4.size() <= 1) {
                return (MultiDexContainer.DexEntry) arrayListNewArrayList4.get(0);
            }
            throw new MultipleMatchingDexEntriesException(String.format("Multiple dex entries in %s match %s: %s", this.filename, str, Joiner.m3775on(", ").join(arrayListNewArrayList3)), new Object[0]);
        }
    }

    public static class DexFileNotFoundException extends ExceptionWithContext {
        public DexFileNotFoundException(String str, Object... objArr) {
            super(str, objArr);
        }

        public DexFileNotFoundException(Throwable th, String str, Object... objArr) {
            super(th, str, objArr);
        }
    }

    public static class FilenameVdexProvider implements OatFile.VdexProvider {
        public byte[] buf = null;
        public boolean loadedVdex = false;
        public final File vdexFile;

        public FilenameVdexProvider(File file) {
            this.vdexFile = new File(file.getAbsoluteFile().getParentFile(), Files.getNameWithoutExtension(file.getAbsolutePath()) + ".vdex");
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.VdexProvider
        public byte[] getVdex() {
            File parentFile;
            if (!this.loadedVdex) {
                File file = this.vdexFile;
                if (!file.exists() && (parentFile = file.getParentFile().getParentFile()) != null) {
                    file = new File(parentFile, this.vdexFile.getName());
                }
                if (file.exists()) {
                    try {
                        this.buf = ByteStreams.toByteArray(new FileInputStream(file));
                    } catch (FileNotFoundException unused) {
                        this.buf = null;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                this.loadedVdex = true;
            }
            return this.buf;
        }
    }

    public static class MultipleMatchingDexEntriesException extends ExceptionWithContext {
        public MultipleMatchingDexEntriesException(String str, Object... objArr) {
            super(String.format(str, objArr), new Object[0]);
        }
    }

    public static class UnsupportedFileTypeException extends ExceptionWithContext {
        public UnsupportedFileTypeException(String str, Object... objArr) {
            super(String.format(str, objArr), new Object[0]);
        }
    }

    public static class UnsupportedOatVersionException extends ExceptionWithContext {
        public UnsupportedOatVersionException(OatFile oatFile) {
            super("Unsupported oat version: %d", Integer.valueOf(oatFile.getOatVersion()));
        }
    }

    public static boolean fullEntryMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (str.charAt(0) == '/') {
            str = str.substring(1);
        }
        if (str2.charAt(0) == '/') {
            str2 = str2.substring(1);
        }
        return str.equals(str2);
    }

    public static MultiDexContainer.DexEntry<? extends DexBackedDexFile> loadDexEntry(File file, String str, boolean z, Opcodes opcodes) throws IOException {
        if (!file.exists()) {
            throw new DexFileNotFoundException("Container file %s does not exist", file.getName());
        }
        try {
            return new DexEntryFinder(file.getPath(), new ZipDexContainer(file, opcodes)).findEntry(str, z);
        } catch (ZipDexContainer.NotAZipFileException unused) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            OatFile oatFileFromInputStream = null;
            try {
                try {
                    oatFileFromInputStream = OatFile.fromInputStream(bufferedInputStream, new FilenameVdexProvider(file));
                } catch (OatFile.NotAnOatFileException unused2) {
                }
                if (oatFileFromInputStream == null) {
                    bufferedInputStream.close();
                    throw new UnsupportedFileTypeException("%s is not an apk or oat file.", file.getPath());
                }
                if (oatFileFromInputStream.isSupportedVersion() == 0) {
                    throw new UnsupportedOatVersionException(oatFileFromInputStream);
                }
                if (oatFileFromInputStream.getDexFiles().size() != 0) {
                    return new DexEntryFinder(file.getPath(), oatFileFromInputStream).findEntry(str, z);
                }
                throw new DexFileNotFoundException("Oat file %s contains no dex files", file.getName());
            } finally {
                bufferedInputStream.close();
            }
        }
    }

    public static DexBackedDexFile loadDexFile(File file, Opcodes opcodes) throws IOException {
        if (!file.exists()) {
            throw new DexFileNotFoundException("%s does not exist", file.getName());
        }
        try {
            return (DexBackedDexFile) new DexEntryFinder(file.getPath(), new ZipDexContainer(file, opcodes)).findEntry("classes.dex", true).getDexFile();
        } catch (ZipDexContainer.NotAZipFileException unused) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                try {
                    return DexBackedDexFile.fromInputStream(opcodes, bufferedInputStream);
                } catch (DexBackedDexFile.NotADexFile unused2) {
                    return DexBackedOdexFile.fromInputStream(opcodes, (InputStream) bufferedInputStream);
                }
            } catch (DexBackedOdexFile.NotAnOdexFile unused3) {
                OatFile oatFileFromInputStream = null;
                try {
                    oatFileFromInputStream = OatFile.fromInputStream(bufferedInputStream, new FilenameVdexProvider(file));
                } catch (OatFile.NotAnOatFileException unused4) {
                }
                if (oatFileFromInputStream == null) {
                    bufferedInputStream.close();
                    throw new UnsupportedFileTypeException("%s is not an apk, dex, odex or oat file.", file.getPath());
                }
                if (oatFileFromInputStream.isSupportedVersion() == 0) {
                    throw new UnsupportedOatVersionException(oatFileFromInputStream);
                }
                List<DexBackedDexFile> dexFiles = oatFileFromInputStream.getDexFiles();
                if (dexFiles.size() != 0) {
                    return dexFiles.get(0);
                }
                throw new DexFileNotFoundException("Oat file %s contains no dex files", file.getName());
            } finally {
                bufferedInputStream.close();
            }
        }
    }

    public static boolean partialEntryMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2)) {
            return false;
        }
        char cCharAt = str.charAt((str.length() - str2.length()) - 1);
        char cCharAt2 = str2.charAt(0);
        return cCharAt2 == ':' || cCharAt2 == '/' || cCharAt2 == '!' || cCharAt == ':' || cCharAt == '/' || cCharAt == '!';
    }

    public static void writeDexFile(String str, DexFile dexFile) throws IOException {
        DexPool.writeTo(str, dexFile);
    }
}
