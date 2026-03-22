package com.android.apksig.internal.jar;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.Attributes;

/* JADX INFO: loaded from: classes.dex */
public class ManifestParser {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public byte[] mBufferedLine;
    public int mEndOffset;
    public final byte[] mManifest;
    public int mOffset;

    public static class Attribute {
        public final String mName;
        public final String mValue;

        public Attribute(String str, String str2) {
            this.mName = str;
            this.mValue = str2;
        }

        public String getName() {
            return this.mName;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    public static class Section {
        public final List<Attribute> mAttributes;
        public final String mName;
        public final int mSizeBytes;
        public final int mStartOffset;

        /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Section(int r2, int r3, java.util.List<com.android.apksig.internal.jar.ManifestParser.Attribute> r4) {
            /*
                r1 = this;
                r1.<init>()
                r1.mStartOffset = r2
                r1.mSizeBytes = r3
                boolean r2 = r4.isEmpty()
                if (r2 != 0) goto L25
                r2 = 0
                java.lang.Object r2 = r4.get(r2)
                com.android.apksig.internal.jar.ManifestParser$Attribute r2 = (com.android.apksig.internal.jar.ManifestParser.Attribute) r2
                java.lang.String r3 = r2.getName()
                java.lang.String r0 = "Name"
                boolean r3 = r0.equalsIgnoreCase(r3)
                if (r3 == 0) goto L25
                java.lang.String r2 = r2.getValue()
                goto L26
            L25:
                r2 = 0
            L26:
                r1.mName = r2
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>(r4)
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.mAttributes = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.apksig.internal.jar.ManifestParser.Section.<init>(int, int, java.util.List):void");
        }

        public String getAttributeValue(String str) {
            for (Attribute attribute : this.mAttributes) {
                if (attribute.getName().equalsIgnoreCase(str)) {
                    return attribute.getValue();
                }
            }
            return null;
        }

        public String getAttributeValue(Attributes.Name name) {
            return getAttributeValue(name.toString());
        }

        public List<Attribute> getAttributes() {
            return this.mAttributes;
        }

        public String getName() {
            return this.mName;
        }

        public int getSizeBytes() {
            return this.mSizeBytes;
        }

        public int getStartOffset() {
            return this.mStartOffset;
        }
    }

    public ManifestParser(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public ManifestParser(byte[] bArr, int i, int i2) {
        this.mManifest = bArr;
        this.mOffset = i;
        this.mEndOffset = i + i2;
    }

    public static byte[] concat(byte[] bArr, byte[] bArr2, int i, int i2) {
        byte[] bArr3 = new byte[bArr.length + i2];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, i, bArr3, bArr.length, i2);
        return bArr3;
    }

    public static Attribute parseAttr(String str) {
        int iIndexOf = str.indexOf(": ");
        return iIndexOf == -1 ? new Attribute(str, "") : new Attribute(str.substring(0, iIndexOf), str.substring(iIndexOf + 2));
    }

    public List<Section> readAllSections() {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Section section = readSection();
            if (section == null) {
                return arrayList;
            }
            arrayList.add(section);
        }
    }

    public final String readAttribute() {
        byte[] attributeBytes = readAttributeBytes();
        if (attributeBytes == null) {
            return null;
        }
        return attributeBytes.length == 0 ? "" : new String(attributeBytes, Charset.forName("UTF-8"));
    }

    public final byte[] readAttributeBytes() {
        byte[] bArr = this.mBufferedLine;
        if (bArr != null && bArr.length == 0) {
            this.mBufferedLine = null;
            return EMPTY_BYTE_ARRAY;
        }
        byte[] line = readLine();
        if (line == null) {
            byte[] bArr2 = this.mBufferedLine;
            if (bArr2 == null) {
                return null;
            }
            this.mBufferedLine = null;
            return bArr2;
        }
        if (line.length == 0) {
            byte[] bArr3 = this.mBufferedLine;
            if (bArr3 == null) {
                return EMPTY_BYTE_ARRAY;
            }
            this.mBufferedLine = EMPTY_BYTE_ARRAY;
            return bArr3;
        }
        byte[] bArr4 = this.mBufferedLine;
        if (bArr4 != null) {
            if (line.length == 0 || line[0] != 32) {
                this.mBufferedLine = line;
                return bArr4;
            }
            this.mBufferedLine = null;
            line = concat(bArr4, line, 1, line.length - 1);
        }
        while (true) {
            byte[] line2 = readLine();
            if (line2 == null) {
                return line;
            }
            if (line2.length == 0) {
                this.mBufferedLine = EMPTY_BYTE_ARRAY;
                return line;
            }
            if (line2[0] != 32) {
                this.mBufferedLine = line2;
                return line;
            }
            line = concat(line, line2, 1, line2.length - 1);
        }
    }

    public final byte[] readLine() {
        int i;
        int i2;
        int i3 = this.mOffset;
        if (i3 >= this.mEndOffset) {
            return null;
        }
        int i4 = i3;
        while (true) {
            i = this.mEndOffset;
            if (i4 >= i) {
                i4 = -1;
                i2 = -1;
                break;
            }
            byte[] bArr = this.mManifest;
            byte b2 = bArr[i4];
            if (b2 == 13) {
                i2 = i4 + 1;
                if (i2 < i && bArr[i2] == 10) {
                    i2++;
                }
            } else {
                if (b2 == 10) {
                    i2 = i4 + 1;
                    break;
                }
                i4++;
            }
        }
        if (i4 == -1) {
            i4 = i;
        } else {
            i = i2;
        }
        this.mOffset = i;
        return i4 == i3 ? EMPTY_BYTE_ARRAY : Arrays.copyOfRange(this.mManifest, i3, i4);
    }

    public Section readSection() {
        int i;
        String attribute;
        do {
            i = this.mOffset;
            attribute = readAttribute();
            if (attribute == null) {
                return null;
            }
        } while (attribute.length() == 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(parseAttr(attribute));
        while (true) {
            String attribute2 = readAttribute();
            if (attribute2 == null || attribute2.length() == 0) {
                break;
            }
            arrayList.add(parseAttr(attribute2));
        }
        return new Section(i, this.mOffset - i, arrayList);
    }
}
