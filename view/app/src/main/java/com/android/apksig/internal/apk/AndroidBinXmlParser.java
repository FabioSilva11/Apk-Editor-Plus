package com.android.apksig.internal.apk;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AndroidBinXmlParser {
    public static final int EVENT_END_DOCUMENT = 2;
    public static final int EVENT_END_ELEMENT = 4;
    public static final int EVENT_START_DOCUMENT = 1;
    public static final int EVENT_START_ELEMENT = 3;
    public static final int VALUE_TYPE_BOOLEAN = 4;
    public static final int VALUE_TYPE_INT = 2;
    public static final int VALUE_TYPE_REFERENCE = 3;
    public static final int VALUE_TYPE_STRING = 1;
    public static final int VALUE_TYPE_UNSUPPORTED = 0;
    public int mCurrentElementAttrSizeBytes;
    public int mCurrentElementAttributeCount;
    public List<Attribute> mCurrentElementAttributes;
    public ByteBuffer mCurrentElementAttributesContents;
    public String mCurrentElementName;
    public String mCurrentElementNamespace;
    public int mCurrentEvent = 1;
    public int mDepth;
    public ResourceMap mResourceMap;
    public StringPool mStringPool;
    public final ByteBuffer mXml;

    public static class Attribute {
        public final long mNameId;
        public final long mNsId;
        public final ResourceMap mResourceMap;
        public final StringPool mStringPool;
        public final int mValueData;
        public final int mValueType;

        public Attribute(long j, long j2, int i, int i2, StringPool stringPool, ResourceMap resourceMap) {
            this.mNsId = j;
            this.mNameId = j2;
            this.mValueType = i;
            this.mValueData = i2;
            this.mStringPool = stringPool;
            this.mResourceMap = resourceMap;
        }

        public boolean getBooleanValue() throws XmlParserException {
            if (this.mValueType == 18) {
                return this.mValueData != 0;
            }
            throw new XmlParserException("Cannot coerce to boolean: value type " + this.mValueType);
        }

        public int getIntValue() throws XmlParserException {
            int i = this.mValueType;
            if (i != 1) {
                switch (i) {
                    case 16:
                    case 17:
                    case 18:
                        break;
                    default:
                        throw new XmlParserException("Cannot coerce to int: value type " + this.mValueType);
                }
            }
            return this.mValueData;
        }

        public String getName() throws XmlParserException {
            return this.mStringPool.getString(this.mNameId);
        }

        public int getNameResourceId() {
            ResourceMap resourceMap = this.mResourceMap;
            if (resourceMap != null) {
                return resourceMap.getResourceId(this.mNameId);
            }
            return 0;
        }

        public String getNamespace() throws XmlParserException {
            long j = this.mNsId;
            return j != 4294967295L ? this.mStringPool.getString(j) : "";
        }

        public String getStringValue() throws XmlParserException {
            int i = this.mValueType;
            if (i == 1) {
                return "@" + Integer.toHexString(this.mValueData);
            }
            if (i == 3) {
                return this.mStringPool.getString(((long) this.mValueData) & 4294967295L);
            }
            switch (i) {
                case 16:
                    return Integer.toString(this.mValueData);
                case 17:
                    return "0x" + Integer.toHexString(this.mValueData);
                case 18:
                    return Boolean.toString(this.mValueData != 0);
                default:
                    throw new XmlParserException("Cannot coerce to string: value type " + this.mValueType);
            }
        }

        public int getValueType() {
            return this.mValueType;
        }
    }

    public static class Chunk {
        public final ByteBuffer mContents;
        public final ByteBuffer mHeader;
        public final int mType;

        public Chunk(int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            this.mType = i;
            this.mHeader = byteBuffer;
            this.mContents = byteBuffer2;
        }

        public static Chunk get(ByteBuffer byteBuffer) throws XmlParserException {
            if (byteBuffer.remaining() < 8) {
                byteBuffer.position(byteBuffer.limit());
                return null;
            }
            int iPosition = byteBuffer.position();
            int unsignedInt16 = AndroidBinXmlParser.getUnsignedInt16(byteBuffer);
            int unsignedInt162 = AndroidBinXmlParser.getUnsignedInt16(byteBuffer);
            long unsignedInt32 = AndroidBinXmlParser.getUnsignedInt32(byteBuffer);
            if (unsignedInt32 - 8 > byteBuffer.remaining()) {
                byteBuffer.position(byteBuffer.limit());
                return null;
            }
            if (unsignedInt162 < 8) {
                throw new XmlParserException("Malformed chunk: header too short: " + unsignedInt162 + " bytes");
            }
            if (unsignedInt162 <= unsignedInt32) {
                int i = unsignedInt162 + iPosition;
                long j = ((long) iPosition) + unsignedInt32;
                Chunk chunk = new Chunk(unsignedInt16, AndroidBinXmlParser.sliceFromTo(byteBuffer, iPosition, i), AndroidBinXmlParser.sliceFromTo(byteBuffer, i, j));
                byteBuffer.position((int) j);
                return chunk;
            }
            throw new XmlParserException("Malformed chunk: header too long: " + unsignedInt162 + " bytes. Chunk size: " + unsignedInt32 + " bytes");
        }

        public ByteBuffer getContents() {
            ByteBuffer byteBufferSlice = this.mContents.slice();
            byteBufferSlice.order(this.mContents.order());
            return byteBufferSlice;
        }

        public ByteBuffer getHeader() {
            ByteBuffer byteBufferSlice = this.mHeader.slice();
            byteBufferSlice.order(this.mHeader.order());
            return byteBufferSlice;
        }

        public int getType() {
            return this.mType;
        }
    }

    public static class ResourceMap {
        public final ByteBuffer mChunkContents;
        public final int mEntryCount;

        public ResourceMap(Chunk chunk) throws XmlParserException {
            ByteBuffer byteBufferSlice = chunk.getContents().slice();
            this.mChunkContents = byteBufferSlice;
            byteBufferSlice.order(chunk.getContents().order());
            this.mEntryCount = byteBufferSlice.remaining() / 4;
        }

        public int getResourceId(long j) {
            if (j < 0 || j >= this.mEntryCount) {
                return 0;
            }
            return this.mChunkContents.getInt(((int) j) * 4);
        }
    }

    public static class StringPool {
        public final Map<Integer, String> mCachedStrings = new HashMap();
        public final ByteBuffer mChunkContents;
        public final int mStringCount;
        public final ByteBuffer mStringsSection;
        public final boolean mUtf8Encoded;

        public StringPool(Chunk chunk) throws XmlParserException {
            long j;
            int iRemaining;
            ByteBuffer header = chunk.getHeader();
            int iRemaining2 = header.remaining();
            header.position(8);
            if (header.remaining() < 20) {
                throw new XmlParserException("XML chunk's header too short. Required at least 20 bytes. Available: " + header.remaining() + " bytes");
            }
            long unsignedInt32 = AndroidBinXmlParser.getUnsignedInt32(header);
            if (unsignedInt32 > 2147483647L) {
                throw new XmlParserException("Too many strings: " + unsignedInt32);
            }
            int i = (int) unsignedInt32;
            this.mStringCount = i;
            long unsignedInt322 = AndroidBinXmlParser.getUnsignedInt32(header);
            if (unsignedInt322 > 2147483647L) {
                throw new XmlParserException("Too many styles: " + unsignedInt322);
            }
            long unsignedInt323 = AndroidBinXmlParser.getUnsignedInt32(header);
            long unsignedInt324 = AndroidBinXmlParser.getUnsignedInt32(header);
            long unsignedInt325 = AndroidBinXmlParser.getUnsignedInt32(header);
            ByteBuffer contents = chunk.getContents();
            if (i > 0) {
                long j2 = iRemaining2;
                j = unsignedInt323;
                int i2 = (int) (unsignedInt324 - j2);
                if (unsignedInt322 <= 0) {
                    iRemaining = contents.remaining();
                } else {
                    if (unsignedInt325 < unsignedInt324) {
                        throw new XmlParserException("Styles offset (" + unsignedInt325 + ") < strings offset (" + unsignedInt324 + ")");
                    }
                    iRemaining = (int) (unsignedInt325 - j2);
                }
                this.mStringsSection = AndroidBinXmlParser.sliceFromTo(contents, i2, iRemaining);
            } else {
                j = unsignedInt323;
                this.mStringsSection = ByteBuffer.allocate(0);
            }
            this.mUtf8Encoded = (256 & j) != 0;
            this.mChunkContents = contents;
        }

        public static String getLengthPrefixedUtf16EncodedString(ByteBuffer byteBuffer) throws XmlParserException {
            byte[] bArrArray;
            int iArrayOffset;
            int unsignedInt16 = AndroidBinXmlParser.getUnsignedInt16(byteBuffer);
            if ((32768 & unsignedInt16) != 0) {
                unsignedInt16 = ((unsignedInt16 & 32767) << 16) | AndroidBinXmlParser.getUnsignedInt16(byteBuffer);
            }
            if (unsignedInt16 > 1073741823) {
                throw new XmlParserException("String too long: " + unsignedInt16 + " uint16s");
            }
            int i = unsignedInt16 * 2;
            if (byteBuffer.hasArray()) {
                bArrArray = byteBuffer.array();
                iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                byteBuffer.position(byteBuffer.position() + i);
            } else {
                bArrArray = new byte[i];
                iArrayOffset = 0;
                byteBuffer.get(bArrArray);
            }
            int i2 = iArrayOffset + i;
            if (bArrArray[i2] != 0 || bArrArray[i2 + 1] != 0) {
                throw new XmlParserException("UTF-16 encoded form of string not NULL terminated");
            }
            try {
                return new String(bArrArray, iArrayOffset, i, "UTF-16LE");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-16LE character encoding not supported", e);
            }
        }

        public static String getLengthPrefixedUtf8EncodedString(ByteBuffer byteBuffer) throws XmlParserException {
            byte[] bArrArray;
            int iArrayOffset;
            if ((AndroidBinXmlParser.getUnsignedInt8(byteBuffer) & 128) != 0) {
                AndroidBinXmlParser.getUnsignedInt8(byteBuffer);
            }
            int unsignedInt8 = AndroidBinXmlParser.getUnsignedInt8(byteBuffer);
            if ((unsignedInt8 & 128) != 0) {
                unsignedInt8 = ((unsignedInt8 & 127) << 8) | AndroidBinXmlParser.getUnsignedInt8(byteBuffer);
            }
            if (byteBuffer.hasArray()) {
                bArrArray = byteBuffer.array();
                iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                byteBuffer.position(byteBuffer.position() + unsignedInt8);
            } else {
                bArrArray = new byte[unsignedInt8];
                iArrayOffset = 0;
                byteBuffer.get(bArrArray);
            }
            if (bArrArray[iArrayOffset + unsignedInt8] != 0) {
                throw new XmlParserException("UTF-8 encoded form of string not NULL terminated");
            }
            try {
                return new String(bArrArray, iArrayOffset, unsignedInt8, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 character encoding not supported", e);
            }
        }

        public String getString(long j) throws XmlParserException {
            if (j < 0) {
                throw new XmlParserException("Unsuported string index: " + j);
            }
            if (j >= this.mStringCount) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unsuported string index: ");
                sb.append(j);
                sb.append(", max: ");
                sb.append(this.mStringCount - 1);
                throw new XmlParserException(sb.toString());
            }
            int i = (int) j;
            String str = this.mCachedStrings.get(Integer.valueOf(i));
            if (str != null) {
                return str;
            }
            long unsignedInt32 = AndroidBinXmlParser.getUnsignedInt32(this.mChunkContents, i * 4);
            if (unsignedInt32 < this.mStringsSection.capacity()) {
                this.mStringsSection.position((int) unsignedInt32);
                String lengthPrefixedUtf8EncodedString = this.mUtf8Encoded ? getLengthPrefixedUtf8EncodedString(this.mStringsSection) : getLengthPrefixedUtf16EncodedString(this.mStringsSection);
                this.mCachedStrings.put(Integer.valueOf(i), lengthPrefixedUtf8EncodedString);
                return lengthPrefixedUtf8EncodedString;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Offset of string idx ");
            sb2.append(i);
            sb2.append(" out of bounds: ");
            sb2.append(unsignedInt32);
            sb2.append(", max: ");
            sb2.append(this.mStringsSection.capacity() - 1);
            throw new XmlParserException(sb2.toString());
        }
    }

    public static class XmlParserException extends Exception {
        public XmlParserException(String str) {
            super(str);
        }

        public XmlParserException(String str, Throwable th) {
            super(str, th);
        }
    }

    public AndroidBinXmlParser(ByteBuffer byteBuffer) throws XmlParserException {
        Chunk chunk;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        while (byteBuffer.hasRemaining() && (chunk = Chunk.get(byteBuffer)) != null) {
            if (chunk.getType() == 3) {
                break;
            }
        }
        chunk = null;
        if (chunk == null) {
            throw new XmlParserException("No XML chunk in file");
        }
        this.mXml = chunk.getContents();
    }

    public static int getUnsignedInt16(ByteBuffer byteBuffer) {
        return byteBuffer.getShort() & 65535;
    }

    public static long getUnsignedInt32(ByteBuffer byteBuffer) {
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public static long getUnsignedInt32(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    public static int getUnsignedInt8(ByteBuffer byteBuffer) {
        return byteBuffer.get() & 255;
    }

    public static ByteBuffer sliceFromTo(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int iCapacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(i);
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            return byteBufferSlice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(iLimit);
            byteBuffer.position(iPosition);
        }
    }

    public static ByteBuffer sliceFromTo(ByteBuffer byteBuffer, long j, long j2) {
        if (j < 0) {
            throw new IllegalArgumentException("start: " + j);
        }
        if (j2 < j) {
            throw new IllegalArgumentException("end < start: " + j2 + " < " + j);
        }
        int iCapacity = byteBuffer.capacity();
        if (j2 <= byteBuffer.capacity()) {
            return sliceFromTo(byteBuffer, (int) j, (int) j2);
        }
        throw new IllegalArgumentException("end > capacity: " + j2 + " > " + iCapacity);
    }

    public final Attribute getAttribute(int i) {
        if (this.mCurrentEvent != 3) {
            throw new IndexOutOfBoundsException("Current event not a START_ELEMENT");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("index must be >= 0");
        }
        if (i < this.mCurrentElementAttributeCount) {
            parseCurrentElementAttributesIfNotParsed();
            return this.mCurrentElementAttributes.get(i);
        }
        throw new IndexOutOfBoundsException("index must be <= attr count (" + this.mCurrentElementAttributeCount + ")");
    }

    public boolean getAttributeBooleanValue(int i) throws XmlParserException {
        return getAttribute(i).getBooleanValue();
    }

    public int getAttributeCount() {
        if (this.mCurrentEvent != 3) {
            return -1;
        }
        return this.mCurrentElementAttributeCount;
    }

    public int getAttributeIntValue(int i) throws XmlParserException {
        return getAttribute(i).getIntValue();
    }

    public String getAttributeName(int i) throws XmlParserException {
        return getAttribute(i).getName();
    }

    public int getAttributeNameResourceId(int i) throws XmlParserException {
        return getAttribute(i).getNameResourceId();
    }

    public String getAttributeNamespace(int i) throws XmlParserException {
        return getAttribute(i).getNamespace();
    }

    public String getAttributeStringValue(int i) throws XmlParserException {
        return getAttribute(i).getStringValue();
    }

    public int getAttributeValueType(int i) throws XmlParserException {
        int valueType = getAttribute(i).getValueType();
        if (valueType == 1) {
            return 3;
        }
        if (valueType == 3) {
            return 1;
        }
        switch (valueType) {
            case 16:
            case 17:
                return 2;
            case 18:
                return 4;
            default:
                return 0;
        }
    }

    public int getDepth() {
        return this.mDepth;
    }

    public int getEventType() {
        return this.mCurrentEvent;
    }

    public String getName() {
        int i = this.mCurrentEvent;
        if (i == 3 || i == 4) {
            return this.mCurrentElementName;
        }
        return null;
    }

    public String getNamespace() {
        int i = this.mCurrentEvent;
        if (i == 3 || i == 4) {
            return this.mCurrentElementNamespace;
        }
        return null;
    }

    public int next() throws XmlParserException {
        Chunk chunk;
        if (this.mCurrentEvent == 4) {
            this.mDepth--;
        }
        while (this.mXml.hasRemaining() && (chunk = Chunk.get(this.mXml)) != null) {
            int type = chunk.getType();
            if (type != 1) {
                if (type != 384) {
                    if (type == 258) {
                        if (this.mStringPool == null) {
                            throw new XmlParserException("Named element encountered before string pool");
                        }
                        ByteBuffer contents = chunk.getContents();
                        if (contents.remaining() < 20) {
                            throw new XmlParserException("Start element chunk too short. Need at least 20 bytes. Available: " + contents.remaining() + " bytes");
                        }
                        long unsignedInt32 = getUnsignedInt32(contents);
                        long unsignedInt322 = getUnsignedInt32(contents);
                        int unsignedInt16 = getUnsignedInt16(contents);
                        int unsignedInt162 = getUnsignedInt16(contents);
                        int unsignedInt163 = getUnsignedInt16(contents);
                        long j = unsignedInt16;
                        long j2 = (((long) unsignedInt163) * ((long) unsignedInt162)) + j;
                        contents.position(0);
                        if (unsignedInt16 > contents.remaining()) {
                            throw new XmlParserException("Attributes start offset out of bounds: " + unsignedInt16 + ", max: " + contents.remaining());
                        }
                        if (j2 > contents.remaining()) {
                            throw new XmlParserException("Attributes end offset out of bounds: " + j2 + ", max: " + contents.remaining());
                        }
                        this.mCurrentElementName = this.mStringPool.getString(unsignedInt322);
                        this.mCurrentElementNamespace = unsignedInt32 != 4294967295L ? this.mStringPool.getString(unsignedInt32) : "";
                        this.mCurrentElementAttributeCount = unsignedInt163;
                        this.mCurrentElementAttributes = null;
                        this.mCurrentElementAttrSizeBytes = unsignedInt162;
                        this.mCurrentElementAttributesContents = sliceFromTo(contents, j, j2);
                        this.mDepth++;
                        this.mCurrentEvent = 3;
                        return 3;
                    }
                    if (type == 259) {
                        if (this.mStringPool == null) {
                            throw new XmlParserException("Named element encountered before string pool");
                        }
                        ByteBuffer contents2 = chunk.getContents();
                        if (contents2.remaining() < 8) {
                            throw new XmlParserException("End element chunk too short. Need at least 8 bytes. Available: " + contents2.remaining() + " bytes");
                        }
                        long unsignedInt323 = getUnsignedInt32(contents2);
                        this.mCurrentElementName = this.mStringPool.getString(getUnsignedInt32(contents2));
                        this.mCurrentElementNamespace = unsignedInt323 != 4294967295L ? this.mStringPool.getString(unsignedInt323) : "";
                        this.mCurrentEvent = 4;
                        this.mCurrentElementAttributes = null;
                        this.mCurrentElementAttributesContents = null;
                        return 4;
                    }
                } else {
                    if (this.mResourceMap != null) {
                        throw new XmlParserException("Multiple resource maps not supported");
                    }
                    this.mResourceMap = new ResourceMap(chunk);
                }
            } else {
                if (this.mStringPool != null) {
                    throw new XmlParserException("Multiple string pools not supported");
                }
                this.mStringPool = new StringPool(chunk);
            }
        }
        this.mCurrentEvent = 2;
        return 2;
    }

    public final void parseCurrentElementAttributesIfNotParsed() {
        if (this.mCurrentElementAttributes != null) {
            return;
        }
        this.mCurrentElementAttributes = new ArrayList(this.mCurrentElementAttributeCount);
        for (int i = 0; i < this.mCurrentElementAttributeCount; i++) {
            int i2 = this.mCurrentElementAttrSizeBytes;
            int i3 = i * i2;
            ByteBuffer byteBufferSliceFromTo = sliceFromTo(this.mCurrentElementAttributesContents, i3, i2 + i3);
            long unsignedInt32 = getUnsignedInt32(byteBufferSliceFromTo);
            long unsignedInt322 = getUnsignedInt32(byteBufferSliceFromTo);
            byteBufferSliceFromTo.position(byteBufferSliceFromTo.position() + 7);
            this.mCurrentElementAttributes.add(new Attribute(unsignedInt32, unsignedInt322, getUnsignedInt8(byteBufferSliceFromTo), (int) getUnsignedInt32(byteBufferSliceFromTo), this.mStringPool, this.mResourceMap));
        }
    }
}
