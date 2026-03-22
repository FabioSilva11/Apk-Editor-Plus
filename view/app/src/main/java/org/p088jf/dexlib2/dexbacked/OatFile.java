package org.p088jf.dexlib2.dexbacked;

import android.annotation.TargetApi;
import com.gmail.heagoo.neweditor.Token;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.p073io.ByteStreams;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import org.p088jf.dexlib2.DexFileFactory;
import org.p088jf.dexlib2.Opcodes;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.OatFile;
import org.p088jf.dexlib2.iface.MultiDexContainer;
import org.p088jf.dexlib2.util.DexUtil;
import org.p088jf.util.AbstractForwardSequentialList;

/* JADX INFO: loaded from: classes.dex */
public class OatFile extends DexBuffer implements MultiDexContainer<DexBackedDexFile> {
    public static final byte[] ELF_MAGIC = {Token.END, 69, 76, 70};
    public static final byte[] OAT_MAGIC = {111, 97, 116, 10};
    public final boolean is64bit;
    public final OatHeader oatHeader;
    public final Opcodes opcodes;
    public final VdexProvider vdexProvider;

    public class DexEntryIterator implements Iterator<OatDexEntry> {
        public int index;
        public int offset;

        public DexEntryIterator() {
            this.index = 0;
            this.offset = OatFile.this.oatHeader.getDexListStart();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < OatFile.this.oatHeader.getDexFileCount();
        }

        @Override // java.util.Iterator
        public OatDexEntry next() {
            byte[] vdex;
            while (hasNext()) {
                int smallUint = OatFile.this.readSmallUint(this.offset);
                int i = this.offset + 4;
                this.offset = i;
                String str = new String(OatFile.this.buf, i, smallUint, Charset.forName("US-ASCII"));
                int i2 = this.offset + smallUint;
                this.offset = i2;
                int i3 = i2 + 4;
                this.offset = i3;
                int smallUint2 = OatFile.this.readSmallUint(i3);
                this.offset += 4;
                if (OatFile.this.getOatVersion() < 87 || OatFile.this.vdexProvider == null || OatFile.this.vdexProvider.getVdex() == null) {
                    OatFile oatFile = OatFile.this;
                    byte[] bArr = oatFile.buf;
                    smallUint2 += oatFile.oatHeader.headerOffset;
                    vdex = bArr;
                } else {
                    vdex = OatFile.this.vdexProvider.getVdex();
                }
                if (OatFile.this.getOatVersion() >= 75) {
                    this.offset += 4;
                }
                if (OatFile.this.getOatVersion() >= 73) {
                    this.offset += 4;
                }
                if (OatFile.this.getOatVersion() >= 131) {
                    this.offset += 4;
                }
                if (OatFile.this.getOatVersion() >= 127) {
                    this.offset += 4;
                }
                if (OatFile.this.getOatVersion() >= 135) {
                    this.offset += 8;
                }
                if (OatFile.this.getOatVersion() < 75) {
                    this.offset += OatFile.this.readSmallUint(smallUint2 + 96) * 4;
                }
                this.index++;
                if (OatFile.this.getOatVersion() < 138 || smallUint2 != 0) {
                    return OatFile.this.new OatDexEntry(str, vdex, smallUint2);
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static class InvalidOatFileException extends RuntimeException {
        public InvalidOatFileException(String str) {
            super(str);
        }
    }

    public static class NotAnOatFileException extends RuntimeException {
    }

    public class OatCDexFile extends CDexBackedDexFile {
        public OatCDexFile(OatFile oatFile, byte[] bArr, int i) {
            super(oatFile.opcodes, bArr, i);
        }
    }

    public class OatDexEntry implements MultiDexContainer.DexEntry<DexBackedDexFile> {
        public final byte[] buf;
        public final int dexOffset;
        public final String entryName;

        public OatDexEntry(String str, byte[] bArr, int i) {
            this.entryName = str;
            this.buf = bArr;
            this.dexOffset = i;
        }

        @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
        public DexBackedDexFile getDexFile() {
            if (CDexBackedDexFile.isCdex(this.buf, this.dexOffset)) {
                return new OatCDexFile(OatFile.this, this.buf, this.dexOffset);
            }
            try {
                DexUtil.verifyDexHeader(this.buf, this.dexOffset);
                return new OatDexFile(OatFile.this, this.buf, this.dexOffset);
            } catch (DexBackedDexFile.NotADexFile e) {
                if (OatFile.this.getOatVersion() >= 87) {
                    throw new DexFileFactory.DexFileNotFoundException(e, "Could not locate the embedded dex file %s. Is the vdex file missing?", this.entryName);
                }
                throw new DexFileFactory.DexFileNotFoundException(e, "The embedded dex file %s does not appear to be a valid dex file.", this.entryName);
            }
        }

        public String getEntryName() {
            return this.entryName;
        }
    }

    public class OatDexFile extends DexBackedDexFile {
        public OatDexFile(OatFile oatFile, byte[] bArr, int i) {
            super(oatFile.opcodes, bArr, i);
        }
    }

    public class OatHeader {
        public final int headerOffset;
        public final int keyValueStoreOffset;

        public OatHeader(int i) {
            this.headerOffset = i;
            if (getVersion() >= 170) {
                this.keyValueStoreOffset = 56;
                return;
            }
            if (getVersion() >= 166) {
                this.keyValueStoreOffset = 64;
                return;
            }
            if (getVersion() >= 162) {
                this.keyValueStoreOffset = 68;
            } else if (getVersion() >= 127) {
                this.keyValueStoreOffset = 76;
            } else {
                this.keyValueStoreOffset = 72;
            }
        }

        public int getDexFileCount() {
            return OatFile.this.readSmallUint(this.headerOffset + 20);
        }

        public int getDexListStart() {
            int i;
            int headerSize;
            if (getVersion() >= 127) {
                i = this.headerOffset;
                headerSize = OatFile.this.readSmallUint(i + 24);
            } else {
                i = this.headerOffset;
                headerSize = getHeaderSize();
            }
            return i + headerSize;
        }

        public int getHeaderSize() {
            if (getVersion() >= 56) {
                return this.keyValueStoreOffset + getKeyValueStoreSize();
            }
            throw new IllegalStateException("Unsupported oat version");
        }

        public int getKeyValueStoreSize() {
            if (getVersion() < 56) {
                throw new IllegalStateException("Unsupported oat version");
            }
            return OatFile.this.readSmallUint(this.headerOffset + (this.keyValueStoreOffset - 4));
        }

        public int getVersion() {
            return Integer.valueOf(new String(OatFile.this.buf, this.headerOffset + 4, 3)).intValue();
        }

        public boolean isValid() {
            for (int i = 0; i < OatFile.OAT_MAGIC.length; i++) {
                if (OatFile.this.buf[this.headerOffset + i] != OatFile.OAT_MAGIC[i]) {
                    return false;
                }
            }
            for (int i2 = 4; i2 < 7; i2++) {
                byte[] bArr = OatFile.this.buf;
                int i3 = this.headerOffset;
                if (bArr[i3 + i2] < 48 || bArr[i3 + i2] > 57) {
                    return false;
                }
            }
            return OatFile.this.buf[this.headerOffset + 7] == 0;
        }
    }

    public abstract class SectionHeader {
        public final int offset;

        public SectionHeader(int i) {
            this.offset = i;
        }

        public abstract long getAddress();

        public abstract int getEntrySize();

        public abstract int getLink();

        public abstract int getOffset();

        public abstract int getSize();

        public int getType() {
            return OatFile.this.readInt(this.offset + 4);
        }
    }

    public class SectionHeader32Bit extends SectionHeader {
        public SectionHeader32Bit(int i) {
            super(i);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public long getAddress() {
            return ((long) OatFile.this.readInt(this.offset + 12)) & 4294967295L;
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getEntrySize() {
            return OatFile.this.readSmallUint(this.offset + 36);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getLink() {
            return OatFile.this.readSmallUint(this.offset + 24);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getOffset() {
            return OatFile.this.readSmallUint(this.offset + 16);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getSize() {
            return OatFile.this.readSmallUint(this.offset + 20);
        }
    }

    public class SectionHeader64Bit extends SectionHeader {
        public SectionHeader64Bit(int i) {
            super(i);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public long getAddress() {
            return OatFile.this.readLong(this.offset + 16);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getEntrySize() {
            return OatFile.this.readLongAsSmallUint(this.offset + 56);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getLink() {
            return OatFile.this.readSmallUint(this.offset + 40);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getOffset() {
            return OatFile.this.readLongAsSmallUint(this.offset + 24);
        }

        @Override // org.jf.dexlib2.dexbacked.OatFile.SectionHeader
        public int getSize() {
            return OatFile.this.readLongAsSmallUint(this.offset + 32);
        }
    }

    public class StringTable {
        public final int offset;
        public final int size;

        public StringTable(SectionHeader sectionHeader) {
            int offset = sectionHeader.getOffset();
            this.offset = offset;
            int size = sectionHeader.getSize();
            this.size = size;
            if (offset + size > OatFile.this.buf.length) {
                throw new InvalidOatFileException("String table extends past end of file");
            }
        }

        public String getString(int i) {
            if (i >= this.size) {
                throw new InvalidOatFileException("String index is out of bounds");
            }
            int i2 = this.offset + i;
            int i3 = i2;
            do {
                byte[] bArr = OatFile.this.buf;
                if (bArr[i3] == 0) {
                    return new String(bArr, i2, i3 - i2, Charset.forName("US-ASCII"));
                }
                i3++;
            } while (i3 < this.offset + this.size);
            throw new InvalidOatFileException("String extends past end of string table");
        }
    }

    public class SymbolTable {
        public final int entryCount;
        public final int entrySize;
        public final int offset;
        public final StringTable stringTable;

        public abstract class Symbol {
            public final int offset;

            public Symbol(int i) {
                this.offset = i;
            }

            public int getFileOffset() {
                try {
                    SectionHeader sectionHeader = (SectionHeader) OatFile.this.getSections().get(getSectionIndex());
                    long address = sectionHeader.getAddress();
                    int offset = sectionHeader.getOffset();
                    int size = sectionHeader.getSize();
                    long value = getValue();
                    if (value < address || value >= ((long) size) + address) {
                        throw new InvalidOatFileException("symbol address lies outside it's associated section");
                    }
                    return (int) (((long) offset) + (getValue() - address));
                } catch (IndexOutOfBoundsException unused) {
                    throw new InvalidOatFileException("Section index for symbol is out of bounds");
                }
            }

            public abstract String getName();

            public abstract int getSectionIndex();

            public abstract long getValue();
        }

        public class Symbol32 extends Symbol {
            public Symbol32(int i) {
                super(i);
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            public String getName() {
                return SymbolTable.this.stringTable.getString(OatFile.this.readSmallUint(this.offset));
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            public int getSectionIndex() {
                return OatFile.this.readUshort(this.offset + 14);
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            public long getValue() {
                return OatFile.this.readSmallUint(this.offset + 4);
            }
        }

        public class Symbol64 extends Symbol {
            public Symbol64(int i) {
                super(i);
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            public String getName() {
                return SymbolTable.this.stringTable.getString(OatFile.this.readSmallUint(this.offset));
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            public int getSectionIndex() {
                return OatFile.this.readUshort(this.offset + 6);
            }

            @Override // org.jf.dexlib2.dexbacked.OatFile.SymbolTable.Symbol
            public long getValue() {
                return OatFile.this.readLong(this.offset + 8);
            }
        }

        public SymbolTable(SectionHeader sectionHeader) {
            try {
                this.stringTable = OatFile.this.new StringTable((SectionHeader) OatFile.this.getSections().get(sectionHeader.getLink()));
                int offset = sectionHeader.getOffset();
                this.offset = offset;
                int entrySize = sectionHeader.getEntrySize();
                this.entrySize = entrySize;
                int size = sectionHeader.getSize() / entrySize;
                this.entryCount = size;
                if (offset + (size * entrySize) > OatFile.this.buf.length) {
                    throw new InvalidOatFileException("Symbol table extends past end of file");
                }
            } catch (IndexOutOfBoundsException unused) {
                throw new InvalidOatFileException("String table section index is invalid");
            }
        }

        public List<Symbol> getSymbols() {
            return new AbstractList<Symbol>() { // from class: org.jf.dexlib2.dexbacked.OatFile.SymbolTable.1
                @Override // java.util.AbstractList, java.util.List
                public Symbol get(int i) {
                    if (i < 0 || i >= SymbolTable.this.entryCount) {
                        throw new IndexOutOfBoundsException();
                    }
                    if (OatFile.this.is64bit) {
                        SymbolTable symbolTable = SymbolTable.this;
                        return symbolTable.new Symbol64(symbolTable.offset + (i * SymbolTable.this.entrySize));
                    }
                    SymbolTable symbolTable2 = SymbolTable.this;
                    return symbolTable2.new Symbol32(symbolTable2.offset + (i * SymbolTable.this.entrySize));
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return SymbolTable.this.entryCount;
                }
            };
        }
    }

    public interface VdexProvider {
        byte[] getVdex();
    }

    public OatFile(byte[] bArr, VdexProvider vdexProvider) {
        super(bArr);
        if (bArr.length < 52) {
            throw new NotAnOatFileException();
        }
        verifyMagic(bArr);
        if (bArr[4] == 1) {
            this.is64bit = false;
        } else {
            if (bArr[4] != 2) {
                throw new InvalidOatFileException(String.format("Invalid word-size value: %x", Byte.valueOf(bArr[5])));
            }
            this.is64bit = true;
        }
        OatHeader oatHeader = null;
        Iterator<SymbolTable.Symbol> it = getSymbolTable().getSymbols().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SymbolTable.Symbol next = it.next();
            if (next.getName().equals("oatdata")) {
                oatHeader = new OatHeader(next.getFileOffset());
                break;
            }
        }
        if (oatHeader == null) {
            throw new InvalidOatFileException("Oat file has no oatdata symbol");
        }
        this.oatHeader = oatHeader;
        if (!oatHeader.isValid()) {
            throw new InvalidOatFileException("Invalid oat magic value");
        }
        this.opcodes = Opcodes.forArtVersion(oatHeader.getVersion());
        this.vdexProvider = vdexProvider;
    }

    /* JADX WARN: Finally extract failed */
    public static OatFile fromInputStream(InputStream inputStream, VdexProvider vdexProvider) throws IOException {
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("InputStream must support mark");
        }
        inputStream.mark(4);
        byte[] bArr = new byte[4];
        try {
            try {
                ByteStreams.readFully(inputStream, bArr);
                inputStream.reset();
                verifyMagic(bArr);
                inputStream.reset();
                return new OatFile(ByteStreams.toByteArray(inputStream), vdexProvider);
            } catch (EOFException unused) {
                throw new NotAnOatFileException();
            }
        } catch (Throwable th) {
            inputStream.reset();
            throw th;
        }
    }

    public static void verifyMagic(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = ELF_MAGIC;
            if (i >= bArr2.length) {
                return;
            }
            if (bArr[i] != bArr2[i]) {
                throw new NotAnOatFileException();
            }
            i++;
        }
    }

    @Override // org.p088jf.dexlib2.iface.MultiDexContainer
    public List<String> getDexEntryNames() throws IOException {
        return new AbstractForwardSequentialList<String>() { // from class: org.jf.dexlib2.dexbacked.OatFile.2
            @Override // org.p088jf.util.AbstractForwardSequentialList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
            @TargetApi(24)
            public Iterator<String> iterator() {
                return Iterators.transform(Iterators.filter(new DexEntryIterator(), new Predicate() { // from class: org.jf.dexlib2.dexbacked.OatFile$2$$ExternalSyntheticLambda0
                    @Override // com.google.common.base.Predicate
                    public final boolean apply(Object obj) {
                        return OatFile$1$$ExternalSyntheticBackport0.m3854m((OatFile.OatDexEntry) obj);
                    }
                }), new Function<OatDexEntry, String>(this) { // from class: org.jf.dexlib2.dexbacked.OatFile.2.1
                    @Override // com.google.common.base.Function
                    public String apply(OatDexEntry oatDexEntry) {
                        return oatDexEntry.entryName;
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            @TargetApi(24)
            public int size() {
                return Iterators.size(Iterators.filter(new DexEntryIterator(), new Predicate() { // from class: org.jf.dexlib2.dexbacked.OatFile$2$$ExternalSyntheticLambda1
                    @Override // com.google.common.base.Predicate
                    public final boolean apply(Object obj) {
                        return OatFile$1$$ExternalSyntheticBackport0.m3854m((OatFile.OatDexEntry) obj);
                    }
                }));
            }
        };
    }

    public List<DexBackedDexFile> getDexFiles() {
        return new AbstractForwardSequentialList<DexBackedDexFile>() { // from class: org.jf.dexlib2.dexbacked.OatFile.1
            @Override // org.p088jf.util.AbstractForwardSequentialList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
            @TargetApi(24)
            public Iterator<DexBackedDexFile> iterator() {
                return Iterators.transform(Iterators.filter(new DexEntryIterator(), new Predicate() { // from class: org.jf.dexlib2.dexbacked.OatFile$1$$ExternalSyntheticLambda2
                    @Override // com.google.common.base.Predicate
                    public final boolean apply(Object obj) {
                        return OatFile$1$$ExternalSyntheticBackport0.m3854m((OatFile.OatDexEntry) obj);
                    }
                }), new Function<OatDexEntry, DexBackedDexFile>(this) { // from class: org.jf.dexlib2.dexbacked.OatFile.1.1
                    @Override // com.google.common.base.Function
                    public DexBackedDexFile apply(OatDexEntry oatDexEntry) {
                        return oatDexEntry.getDexFile();
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            @TargetApi(24)
            public int size() {
                return Iterators.size(Iterators.filter(new DexEntryIterator(), new Predicate() { // from class: org.jf.dexlib2.dexbacked.OatFile$1$$ExternalSyntheticLambda1
                    @Override // com.google.common.base.Predicate
                    public final boolean apply(Object obj) {
                        return OatFile$1$$ExternalSyntheticBackport0.m3854m((OatFile.OatDexEntry) obj);
                    }
                }));
            }
        };
    }

    @Override // org.p088jf.dexlib2.iface.MultiDexContainer
    public OatDexEntry getEntry(String str) throws IOException {
        DexEntryIterator dexEntryIterator = new DexEntryIterator();
        while (dexEntryIterator.hasNext()) {
            OatDexEntry next = dexEntryIterator.next();
            if (next != null && next.getEntryName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public int getOatVersion() {
        return this.oatHeader.getVersion();
    }

    public final List<SectionHeader> getSections() {
        final int smallUint;
        final int ushort;
        final int ushort2;
        if (this.is64bit) {
            smallUint = readLongAsSmallUint(40);
            ushort = readUshort(58);
            ushort2 = readUshort(60);
        } else {
            smallUint = readSmallUint(32);
            ushort = readUshort(46);
            ushort2 = readUshort(48);
        }
        if ((ushort * ushort2) + smallUint <= this.buf.length) {
            return new AbstractList<SectionHeader>() { // from class: org.jf.dexlib2.dexbacked.OatFile.3
                @Override // java.util.AbstractList, java.util.List
                public SectionHeader get(int i) {
                    if (i < 0 || i >= ushort2) {
                        throw new IndexOutOfBoundsException();
                    }
                    return OatFile.this.is64bit ? OatFile.this.new SectionHeader64Bit(smallUint + (i * ushort)) : OatFile.this.new SectionHeader32Bit(smallUint + (i * ushort));
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return ushort2;
                }
            };
        }
        throw new InvalidOatFileException("The ELF section headers extend past the end of the file");
    }

    public final SymbolTable getSymbolTable() {
        for (SectionHeader sectionHeader : getSections()) {
            if (sectionHeader.getType() == 11) {
                return new SymbolTable(sectionHeader);
            }
        }
        throw new InvalidOatFileException("Oat file has no symbol table");
    }

    public int isSupportedVersion() {
        int oatVersion = getOatVersion();
        if (oatVersion < 56) {
            return 0;
        }
        return oatVersion <= 178 ? 1 : 2;
    }
}
