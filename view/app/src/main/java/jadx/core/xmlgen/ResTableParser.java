package jadx.core.xmlgen;

import jadx.core.codegen.CodeWriter;
import jadx.core.xmlgen.entry.EntryConfig;
import jadx.core.xmlgen.entry.RawNamedValue;
import jadx.core.xmlgen.entry.RawValue;
import jadx.core.xmlgen.entry.ResourceEntry;
import jadx.core.xmlgen.entry.ValuesParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ResTableParser extends CommonBinaryParser {
    private final ResourceStorage resStorage = new ResourceStorage();
    private String[] strings;

    final class PackageChunk {

        /* JADX INFO: renamed from: id */
        private final int f4703id;
        private final String[] keyStrings;
        private final String name;
        private final String[] typeStrings;

        private PackageChunk(int i, String str, String[] strArr, String[] strArr2) {
            this.f4703id = i;
            this.name = str;
            this.typeStrings = strArr;
            this.keyStrings = strArr2;
        }

        public final int getId() {
            return this.f4703id;
        }

        public final String[] getKeyStrings() {
            return this.keyStrings;
        }

        public final String getName() {
            return this.name;
        }

        public final String[] getTypeStrings() {
            return this.typeStrings;
        }
    }

    private EntryConfig parseConfig() throws IOException {
        long pos = this.f4702is.getPos();
        int int32 = this.f4702is.readInt32();
        EntryConfig entryConfig = new EntryConfig();
        this.f4702is.readInt16();
        this.f4702is.readInt16();
        entryConfig.setLanguage(parseLocale());
        entryConfig.setCountry(parseLocale());
        this.f4702is.readInt8();
        this.f4702is.readInt8();
        this.f4702is.readInt16();
        this.f4702is.skipToPos(pos + ((long) int32), "Skip config parsing");
        return entryConfig;
    }

    private void parseEntry(PackageChunk packageChunk, int i, int i2, EntryConfig entryConfig) throws IOException {
        this.f4702is.readInt16();
        int int16 = this.f4702is.readInt16();
        ResourceEntry resourceEntry = new ResourceEntry((packageChunk.getId() << 24) | (i << 16) | i2, packageChunk.getName(), packageChunk.getTypeStrings()[i - 1], packageChunk.getKeyStrings()[this.f4702is.readInt32()]);
        resourceEntry.setConfig(entryConfig);
        if ((int16 & 1) == 0) {
            resourceEntry.setSimpleValue(parseValue());
        } else {
            resourceEntry.setParentRef(this.f4702is.readInt32());
            int int32 = this.f4702is.readInt32();
            ArrayList arrayList = new ArrayList(int32);
            for (int i3 = 0; i3 < int32; i3++) {
                arrayList.add(parseValueMap());
            }
            resourceEntry.setNamedValues(arrayList);
        }
        this.resStorage.add(resourceEntry);
    }

    private String parseLocale() {
        int int8 = this.f4702is.readInt8();
        int int82 = this.f4702is.readInt8();
        if (int8 == 0 || int82 == 0 || (int8 & 128) != 0) {
            return null;
        }
        return new String(new char[]{(char) int8, (char) int82});
    }

    private PackageChunk parsePackage() throws IOException {
        long pos = this.f4702is.getPos();
        this.f4702is.checkInt16(512, "Not a table chunk");
        int int16 = this.f4702is.readInt16();
        if (int16 != 284 && int16 != 288) {
            die("Unexpected package header size");
        }
        long uInt32 = pos + this.f4702is.readUInt32();
        int int32 = this.f4702is.readInt32();
        String string16Fixed = this.f4702is.readString16Fixed(128);
        long int322 = ((long) this.f4702is.readInt32()) + pos;
        this.f4702is.readInt32();
        long int323 = ((long) this.f4702is.readInt32()) + pos;
        this.f4702is.readInt32();
        if (int16 == 288) {
            this.f4702is.readInt32();
        }
        String[] stringPool = null;
        if (int322 != 0) {
            this.f4702is.skipToPos(int322, "Expected typeStrings string pool");
            stringPool = parseStringPool();
        }
        String[] stringPool2 = null;
        if (int323 != 0) {
            this.f4702is.skipToPos(int323, "Expected keyStrings string pool");
            stringPool2 = parseStringPool();
        }
        PackageChunk packageChunk = new PackageChunk(int32, string16Fixed, stringPool, stringPool2);
        if (int32 == 127) {
            this.resStorage.setAppPackage(string16Fixed);
        }
        while (this.f4702is.getPos() < uInt32) {
            long pos2 = this.f4702is.getPos();
            int int162 = this.f4702is.readInt16();
            if (int162 != 0) {
                if (int162 == 514) {
                    parseTypeSpecChunk();
                } else if (int162 == 513) {
                    parseTypeChunk(pos2, packageChunk);
                }
            }
        }
        return packageChunk;
    }

    private void parseTypeChunk(long j, PackageChunk packageChunk) throws IOException {
        this.f4702is.readInt16();
        this.f4702is.readInt32();
        int int8 = this.f4702is.readInt8();
        this.f4702is.checkInt8(0, "type chunk, res0");
        this.f4702is.checkInt16(0, "type chunk, res1");
        int int32 = this.f4702is.readInt32();
        long int322 = ((long) this.f4702is.readInt32()) + j;
        EntryConfig config = parseConfig();
        int[] iArr = new int[int32];
        for (int i = 0; i < int32; i++) {
            iArr[i] = this.f4702is.readInt32();
        }
        this.f4702is.checkPos(int322, "Expected entry start");
        for (int i2 = 0; i2 < int32; i2++) {
            if (iArr[i2] != -1) {
                parseEntry(packageChunk, int8, i2, config);
            }
        }
    }

    private void parseTypeSpecChunk() throws IOException {
        this.f4702is.checkInt16(16, "Unexpected type spec header size");
        this.f4702is.readInt32();
        this.f4702is.readInt8();
        this.f4702is.skip(3L);
        int int32 = this.f4702is.readInt32();
        for (int i = 0; i < int32; i++) {
            this.f4702is.readInt32();
        }
    }

    private RawValue parseValue() throws IOException {
        this.f4702is.checkInt16(8, "value size");
        this.f4702is.checkInt8(0, "value res0 not 0");
        return new RawValue(this.f4702is.readInt8(), this.f4702is.readInt32());
    }

    private RawNamedValue parseValueMap() {
        return new RawNamedValue(this.f4702is.readInt32(), parseValue());
    }

    public void decode(InputStream inputStream) {
        this.f4702is = new ParserStream(inputStream);
        decodeTableChunk();
        this.resStorage.finish();
    }

    public ResContainer decodeFiles(InputStream inputStream) {
        decode(inputStream);
        ResXmlGen resXmlGen = new ResXmlGen(this.resStorage, new ValuesParser(this.strings, this.resStorage.getResourcesNames()));
        ResContainer resContainerMultiFile = ResContainer.multiFile("res");
        resContainerMultiFile.setContent(makeDump());
        resContainerMultiFile.getSubFiles().addAll(resXmlGen.makeResourcesXml());
        return resContainerMultiFile;
    }

    void decodeTableChunk() throws IOException {
        this.f4702is.checkInt16(2, "Not a table chunk");
        this.f4702is.checkInt16(12, "Unexpected table header size");
        this.f4702is.readInt32();
        int int32 = this.f4702is.readInt32();
        this.strings = parseStringPool();
        for (int i = 0; i < int32; i++) {
            parsePackage();
        }
    }

    public ResourceStorage getResStorage() {
        return this.resStorage;
    }

    public CodeWriter makeDump() {
        CodeWriter codeWriter = new CodeWriter();
        codeWriter.add("app package: ").add(this.resStorage.getAppPackage());
        codeWriter.startLine();
        ValuesParser valuesParser = new ValuesParser(this.strings, this.resStorage.getResourcesNames());
        for (ResourceEntry resourceEntry : this.resStorage.getResources()) {
            codeWriter.startLine(resourceEntry + ": " + valuesParser.getValueString(resourceEntry));
        }
        codeWriter.finish();
        return codeWriter;
    }
}
