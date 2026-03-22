package org.p088jf.dexlib2.dexbacked;

import com.google.common.p073io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractList;
import java.util.List;
import java.util.Set;
import org.p088jf.dexlib2.Opcodes;
import org.p088jf.dexlib2.dexbacked.raw.HeaderItem;
import org.p088jf.dexlib2.dexbacked.raw.MapItem;
import org.p088jf.dexlib2.dexbacked.reference.DexBackedCallSiteReference;
import org.p088jf.dexlib2.dexbacked.reference.DexBackedFieldReference;
import org.p088jf.dexlib2.dexbacked.reference.DexBackedMethodHandleReference;
import org.p088jf.dexlib2.dexbacked.reference.DexBackedMethodProtoReference;
import org.p088jf.dexlib2.dexbacked.reference.DexBackedMethodReference;
import org.p088jf.dexlib2.dexbacked.util.FixedSizeList;
import org.p088jf.dexlib2.dexbacked.util.FixedSizeSet;
import org.p088jf.dexlib2.iface.DexFile;
import org.p088jf.dexlib2.util.DexUtil;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedDexFile implements DexFile {
    public IndexedSection<DexBackedCallSiteReference> callSiteSection;
    public final int classCount;
    public IndexedSection<DexBackedClassDef> classSection;
    public final int classStartOffset;
    public final DexBuffer dataBuffer;
    public final DexBuffer dexBuffer;
    public final int fieldCount;
    public IndexedSection<DexBackedFieldReference> fieldSection;
    public final int fieldStartOffset;
    public final int hiddenApiRestrictionsOffset;
    public final int mapOffset;
    public final int methodCount;
    public IndexedSection<DexBackedMethodHandleReference> methodHandleSection;
    public IndexedSection<DexBackedMethodReference> methodSection;
    public final int methodStartOffset;
    public final Opcodes opcodes;
    public final int protoCount;
    public IndexedSection<DexBackedMethodProtoReference> protoSection;
    public final int protoStartOffset;
    public final int stringCount;
    public OptionalIndexedSection<String> stringSection;
    public final int stringStartOffset;
    public final int typeCount;
    public OptionalIndexedSection<String> typeSection;
    public final int typeStartOffset;

    public static abstract class IndexedSection<T> extends AbstractList<T> {
        public abstract int getOffset(int i);
    }

    public static class NotADexFile extends RuntimeException {
        public NotADexFile(String str) {
            super(str);
        }
    }

    public static abstract class OptionalIndexedSection<T> extends IndexedSection<T> {
        public abstract T getOptional(int i);
    }

    public DexBackedDexFile(Opcodes opcodes, byte[] bArr) {
        this(opcodes, bArr, 0, true);
    }

    public DexBackedDexFile(Opcodes opcodes, byte[] bArr, int i) {
        this(opcodes, bArr, i, false);
    }

    public DexBackedDexFile(Opcodes opcodes, byte[] bArr, int i, boolean z) {
        this.stringSection = new OptionalIndexedSection<String>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.5
            @Override // java.util.AbstractList, java.util.List
            public String get(int i2) {
                DexReader<? extends DexBuffer> dexReader = DexBackedDexFile.this.dataBuffer.readerAt(DexBackedDexFile.this.dexBuffer.readSmallUint(getOffset(i2)));
                return dexReader.readString(dexReader.readSmallUleb128());
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i2) {
                if (i2 < 0 || i2 >= size()) {
                    throw new IndexOutOfBoundsException(String.format("Invalid string index %d, not in [0, %d)", Integer.valueOf(i2), Integer.valueOf(size())));
                }
                return DexBackedDexFile.this.stringStartOffset + (i2 * 4);
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.OptionalIndexedSection
            public String getOptional(int i2) {
                if (i2 == -1) {
                    return null;
                }
                return get(i2);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.stringCount;
            }
        };
        this.typeSection = new OptionalIndexedSection<String>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.6
            @Override // java.util.AbstractList, java.util.List
            public String get(int i2) {
                return DexBackedDexFile.this.getStringSection().get(DexBackedDexFile.this.dexBuffer.readSmallUint(getOffset(i2)));
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i2) {
                if (i2 < 0 || i2 >= size()) {
                    throw new IndexOutOfBoundsException(String.format("Invalid type index %d, not in [0, %d)", Integer.valueOf(i2), Integer.valueOf(size())));
                }
                return DexBackedDexFile.this.typeStartOffset + (i2 * 4);
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.OptionalIndexedSection
            public String getOptional(int i2) {
                if (i2 == -1) {
                    return null;
                }
                return get(i2);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.typeCount;
            }
        };
        this.fieldSection = new IndexedSection<DexBackedFieldReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.7
            @Override // java.util.AbstractList, java.util.List
            public DexBackedFieldReference get(int i2) {
                return new DexBackedFieldReference(DexBackedDexFile.this, i2);
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i2) {
                if (i2 < 0 || i2 >= size()) {
                    throw new IndexOutOfBoundsException(String.format("Invalid field index %d, not in [0, %d)", Integer.valueOf(i2), Integer.valueOf(size())));
                }
                return DexBackedDexFile.this.fieldStartOffset + (i2 * 8);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.fieldCount;
            }
        };
        this.methodSection = new IndexedSection<DexBackedMethodReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.8
            @Override // java.util.AbstractList, java.util.List
            public DexBackedMethodReference get(int i2) {
                return new DexBackedMethodReference(DexBackedDexFile.this, i2);
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i2) {
                if (i2 < 0 || i2 >= size()) {
                    throw new IndexOutOfBoundsException(String.format("Invalid method index %d, not in [0, %d)", Integer.valueOf(i2), Integer.valueOf(size())));
                }
                return DexBackedDexFile.this.methodStartOffset + (i2 * 8);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.methodCount;
            }
        };
        this.protoSection = new IndexedSection<DexBackedMethodProtoReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.9
            @Override // java.util.AbstractList, java.util.List
            public DexBackedMethodProtoReference get(int i2) {
                return new DexBackedMethodProtoReference(DexBackedDexFile.this, i2);
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i2) {
                if (i2 < 0 || i2 >= size()) {
                    throw new IndexOutOfBoundsException(String.format("Invalid proto index %d, not in [0, %d)", Integer.valueOf(i2), Integer.valueOf(size())));
                }
                return DexBackedDexFile.this.protoStartOffset + (i2 * 12);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.protoCount;
            }
        };
        this.classSection = new IndexedSection<DexBackedClassDef>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.10
            @Override // java.util.AbstractList, java.util.List
            public DexBackedClassDef get(int i2) {
                return new DexBackedClassDef(DexBackedDexFile.this, getOffset(i2), DexBackedDexFile.this.readHiddenApiRestrictionsOffset(i2));
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i2) {
                if (i2 < 0 || i2 >= size()) {
                    throw new IndexOutOfBoundsException(String.format("Invalid class index %d, not in [0, %d)", Integer.valueOf(i2), Integer.valueOf(size())));
                }
                return DexBackedDexFile.this.classStartOffset + (i2 * 32);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedDexFile.this.classCount;
            }
        };
        this.callSiteSection = new IndexedSection<DexBackedCallSiteReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.11
            @Override // java.util.AbstractList, java.util.List
            public DexBackedCallSiteReference get(int i2) {
                return new DexBackedCallSiteReference(DexBackedDexFile.this, i2);
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i2) {
                MapItem mapItemForSection = DexBackedDexFile.this.getMapItemForSection(7);
                if (i2 < 0 || i2 >= size()) {
                    throw new IndexOutOfBoundsException(String.format("Invalid callsite index %d, not in [0, %d)", Integer.valueOf(i2), Integer.valueOf(size())));
                }
                return mapItemForSection.getOffset() + (i2 * 4);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                MapItem mapItemForSection = DexBackedDexFile.this.getMapItemForSection(7);
                if (mapItemForSection == null) {
                    return 0;
                }
                return mapItemForSection.getItemCount();
            }
        };
        this.methodHandleSection = new IndexedSection<DexBackedMethodHandleReference>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.12
            @Override // java.util.AbstractList, java.util.List
            public DexBackedMethodHandleReference get(int i2) {
                return new DexBackedMethodHandleReference(DexBackedDexFile.this, i2);
            }

            @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile.IndexedSection
            public int getOffset(int i2) {
                MapItem mapItemForSection = DexBackedDexFile.this.getMapItemForSection(8);
                if (i2 < 0 || i2 >= size()) {
                    throw new IndexOutOfBoundsException(String.format("Invalid method handle index %d, not in [0, %d)", Integer.valueOf(i2), Integer.valueOf(size())));
                }
                return mapItemForSection.getOffset() + (i2 * 8);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                MapItem mapItemForSection = DexBackedDexFile.this.getMapItemForSection(8);
                if (mapItemForSection == null) {
                    return 0;
                }
                return mapItemForSection.getItemCount();
            }
        };
        DexBuffer dexBuffer = new DexBuffer(bArr, i);
        this.dexBuffer = dexBuffer;
        this.dataBuffer = new DexBuffer(bArr, getBaseDataOffset() + i);
        int version = getVersion(bArr, i, z);
        if (opcodes == null) {
            this.opcodes = getDefaultOpcodes(version);
        } else {
            this.opcodes = opcodes;
        }
        this.stringCount = dexBuffer.readSmallUint(56);
        this.stringStartOffset = dexBuffer.readSmallUint(60);
        this.typeCount = dexBuffer.readSmallUint(64);
        this.typeStartOffset = dexBuffer.readSmallUint(68);
        this.protoCount = dexBuffer.readSmallUint(72);
        this.protoStartOffset = dexBuffer.readSmallUint(76);
        this.fieldCount = dexBuffer.readSmallUint(80);
        this.fieldStartOffset = dexBuffer.readSmallUint(84);
        this.methodCount = dexBuffer.readSmallUint(88);
        this.methodStartOffset = dexBuffer.readSmallUint(92);
        this.classCount = dexBuffer.readSmallUint(96);
        this.classStartOffset = dexBuffer.readSmallUint(100);
        this.mapOffset = dexBuffer.readSmallUint(52);
        MapItem mapItemForSection = getMapItemForSection(61440);
        if (mapItemForSection != null) {
            this.hiddenApiRestrictionsOffset = mapItemForSection.getOffset();
        } else {
            this.hiddenApiRestrictionsOffset = 0;
        }
    }

    public static DexBackedDexFile fromInputStream(Opcodes opcodes, InputStream inputStream) throws IOException {
        DexUtil.verifyDexHeader(inputStream);
        return new DexBackedDexFile(opcodes, ByteStreams.toByteArray(inputStream), 0, false);
    }

    public DexBackedMethodImplementation createMethodImplementation(DexBackedDexFile dexBackedDexFile, DexBackedMethod dexBackedMethod, int i) {
        return new DexBackedMethodImplementation(dexBackedDexFile, dexBackedMethod, i);
    }

    public int getBaseDataOffset() {
        return 0;
    }

    public DexBuffer getBuffer() {
        return this.dexBuffer;
    }

    public IndexedSection<DexBackedCallSiteReference> getCallSiteSection() {
        return this.callSiteSection;
    }

    public IndexedSection<DexBackedClassDef> getClassSection() {
        return this.classSection;
    }

    @Override // org.p088jf.dexlib2.iface.DexFile
    public Set<? extends DexBackedClassDef> getClasses() {
        return new FixedSizeSet<DexBackedClassDef>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.1
            @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeSet
            public DexBackedClassDef readItem(int i) {
                return DexBackedDexFile.this.getClassSection().get(i);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DexBackedDexFile.this.classCount;
            }
        };
    }

    public DexBuffer getDataBuffer() {
        return this.dataBuffer;
    }

    public Opcodes getDefaultOpcodes(int i) {
        return Opcodes.forDexVersion(i);
    }

    public IndexedSection<DexBackedFieldReference> getFieldSection() {
        return this.fieldSection;
    }

    public MapItem getMapItemForSection(int i) {
        for (MapItem mapItem : getMapItems()) {
            if (mapItem.getType() == i) {
                return mapItem;
            }
        }
        return null;
    }

    public List<MapItem> getMapItems() {
        final int smallUint = this.dataBuffer.readSmallUint(this.mapOffset);
        return new FixedSizeList<MapItem>() { // from class: org.jf.dexlib2.dexbacked.DexBackedDexFile.4
            @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeList
            public MapItem readItem(int i) {
                return new MapItem(DexBackedDexFile.this, DexBackedDexFile.this.mapOffset + 4 + (i * 12));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return smallUint;
            }
        };
    }

    public IndexedSection<DexBackedMethodHandleReference> getMethodHandleSection() {
        return this.methodHandleSection;
    }

    public IndexedSection<DexBackedMethodReference> getMethodSection() {
        return this.methodSection;
    }

    @Override // org.p088jf.dexlib2.iface.DexFile
    public Opcodes getOpcodes() {
        return this.opcodes;
    }

    public IndexedSection<DexBackedMethodProtoReference> getProtoSection() {
        return this.protoSection;
    }

    public OptionalIndexedSection<String> getStringSection() {
        return this.stringSection;
    }

    public OptionalIndexedSection<String> getTypeSection() {
        return this.typeSection;
    }

    public int getVersion(byte[] bArr, int i, boolean z) {
        return z ? DexUtil.verifyDexHeader(bArr, i) : HeaderItem.getVersion(bArr, i);
    }

    public final int readHiddenApiRestrictionsOffset(int i) {
        int i2;
        int i3 = this.hiddenApiRestrictionsOffset;
        if (i3 == 0 || (i2 = this.dexBuffer.readInt(i3 + 4 + (i * 4))) == 0) {
            return 0;
        }
        return this.hiddenApiRestrictionsOffset + i2;
    }
}
