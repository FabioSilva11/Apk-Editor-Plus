package com.android.apksig.apk;

import android.R;
import com.android.apksig.apk.ApkUtilsLite;
import com.android.apksig.internal.apk.AndroidBinXmlParser;
import com.android.apksig.internal.apk.p044v1.V1SchemeVerifier;
import com.android.apksig.internal.util.Pair;
import com.android.apksig.internal.zip.CentralDirectoryRecord;
import com.android.apksig.internal.zip.LocalFileRecord;
import com.android.apksig.internal.zip.ZipUtils;
import com.android.apksig.util.DataSource;
import com.android.apksig.zip.ZipFormatException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class ApkUtils {
    public static final String ANDROID_MANIFEST_ZIP_ENTRY_NAME = "AndroidManifest.xml";
    public static final String SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME = "stamp-cert-sha256";

    public static class ApkSigningBlock extends ApkUtilsLite.ApkSigningBlock {
        public ApkSigningBlock(long j, DataSource dataSource) {
            super(j, dataSource);
        }
    }

    public static class CodenamesLazyInitializer {
        public static final Pair<Character, Integer>[] SORTED_CODENAMES_FIRST_CHAR_TO_API_LEVEL = {Pair.m2038of('C', 2), Pair.m2038of('D', 3), Pair.m2038of('E', 4), Pair.m2038of('F', 7), Pair.m2038of('G', 8), Pair.m2038of('H', 10), Pair.m2038of('I', 13), Pair.m2038of('J', 15), Pair.m2038of('K', 18), Pair.m2038of('L', 20), Pair.m2038of('M', 22), Pair.m2038of('N', 23), Pair.m2038of('O', 25)};
        public static final Comparator<Pair<Character, Integer>> CODENAME_FIRST_CHAR_COMPARATOR = new ByFirstComparator();

        public static class ByFirstComparator implements Comparator<Pair<Character, Integer>> {
            public ByFirstComparator() {
            }

            @Override // java.util.Comparator
            public int compare(Pair<Character, Integer> pair, Pair<Character, Integer> pair2) {
                return pair.getFirst().charValue() - pair2.getFirst().charValue();
            }
        }
    }

    public static class ZipSections extends com.android.apksig.zip.ZipSections {
        public ZipSections(long j, long j2, int i, long j3, ByteBuffer byteBuffer) {
            super(j, j2, i, j3, byteBuffer);
        }
    }

    public static byte[] computeSha256DigestBytes(byte[] bArr) {
        return ApkUtilsLite.computeSha256DigestBytes(bArr);
    }

    public static ApkSigningBlock findApkSigningBlock(DataSource dataSource, ZipSections zipSections) throws ApkSigningBlockNotFoundException, IOException {
        ApkUtilsLite.ApkSigningBlock apkSigningBlockFindApkSigningBlock = ApkUtilsLite.findApkSigningBlock(dataSource, zipSections);
        return new ApkSigningBlock(apkSigningBlockFindApkSigningBlock.getStartOffset(), apkSigningBlockFindApkSigningBlock.getContents());
    }

    public static ZipSections findZipSections(DataSource dataSource) throws IOException, ZipFormatException {
        com.android.apksig.zip.ZipSections zipSectionsFindZipSections = ApkUtilsLite.findZipSections(dataSource);
        return new ZipSections(zipSectionsFindZipSections.getZipCentralDirectoryOffset(), zipSectionsFindZipSections.getZipCentralDirectorySizeBytes(), zipSectionsFindZipSections.getZipCentralDirectoryRecordCount(), zipSectionsFindZipSections.getZipEndOfCentralDirectoryOffset(), zipSectionsFindZipSections.getZipEndOfCentralDirectory());
    }

    public static ByteBuffer getAndroidManifest(DataSource dataSource) throws IOException, ApkFormatException {
        try {
            ZipSections zipSectionsFindZipSections = findZipSections(dataSource);
            CentralDirectoryRecord centralDirectoryRecord = null;
            Iterator<CentralDirectoryRecord> it = V1SchemeVerifier.parseZipCentralDirectory(dataSource, zipSectionsFindZipSections).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CentralDirectoryRecord next = it.next();
                if (ANDROID_MANIFEST_ZIP_ENTRY_NAME.equals(next.getName())) {
                    centralDirectoryRecord = next;
                    break;
                }
            }
            if (centralDirectoryRecord == null) {
                throw new ApkFormatException("Missing AndroidManifest.xml");
            }
            DataSource dataSourceSlice = dataSource.slice(0L, zipSectionsFindZipSections.getZipCentralDirectoryOffset());
            try {
                return ByteBuffer.wrap(LocalFileRecord.getUncompressedData(dataSourceSlice, centralDirectoryRecord, dataSourceSlice.size()));
            } catch (ZipFormatException e) {
                throw new ApkFormatException("Failed to read AndroidManifest.xml", e);
            }
        } catch (ZipFormatException e2) {
            throw new ApkFormatException("Not a valid ZIP archive", e2);
        }
    }

    public static int getAttributeValueFromBinaryAndroidManifest(ByteBuffer byteBuffer, String str, int i) throws ApkFormatException {
        if (str == null) {
            throw new NullPointerException("elementName cannot be null");
        }
        try {
            AndroidBinXmlParser androidBinXmlParser = new AndroidBinXmlParser(byteBuffer);
            for (int eventType = androidBinXmlParser.getEventType(); eventType != 2; eventType = androidBinXmlParser.next()) {
                if (eventType == 3 && str.equals(androidBinXmlParser.getName())) {
                    for (int i2 = 0; i2 < androidBinXmlParser.getAttributeCount(); i2++) {
                        if (androidBinXmlParser.getAttributeNameResourceId(i2) == i) {
                            int attributeValueType = androidBinXmlParser.getAttributeValueType(i2);
                            if (attributeValueType != 1 && attributeValueType != 2) {
                                throw new ApkFormatException("Unsupported value type, " + attributeValueType + ", for attribute " + String.format("0x%08X", Integer.valueOf(i)) + " under element " + str);
                            }
                            return androidBinXmlParser.getAttributeIntValue(i2);
                        }
                    }
                }
            }
            throw new ApkFormatException("Failed to determine APK's " + str + " attribute " + String.format("0x%08X", Integer.valueOf(i)) + " value");
        } catch (AndroidBinXmlParser.XmlParserException e) {
            throw new ApkFormatException("Unable to determine value for attribute " + String.format("0x%08X", Integer.valueOf(i)) + " under element " + str + "; malformed binary resource: " + ANDROID_MANIFEST_ZIP_ENTRY_NAME, e);
        }
    }

    public static boolean getDebuggableFromBinaryAndroidManifest(ByteBuffer byteBuffer) throws ApkFormatException {
        try {
            AndroidBinXmlParser androidBinXmlParser = new AndroidBinXmlParser(byteBuffer);
            for (int eventType = androidBinXmlParser.getEventType(); eventType != 2; eventType = androidBinXmlParser.next()) {
                if (eventType == 3 && androidBinXmlParser.getDepth() == 2 && "application".equals(androidBinXmlParser.getName()) && androidBinXmlParser.getNamespace().isEmpty()) {
                    for (int i = 0; i < androidBinXmlParser.getAttributeCount(); i++) {
                        if (androidBinXmlParser.getAttributeNameResourceId(i) == 16842767) {
                            int attributeValueType = androidBinXmlParser.getAttributeValueType(i);
                            if (attributeValueType != 1 && attributeValueType != 2) {
                                if (attributeValueType == 3) {
                                    throw new ApkFormatException("Unable to determine whether APK is debuggable: AndroidManifest.xml's android:debuggable attribute references a resource. References are not supported for security reasons. Only constant boolean, string and int values are supported.");
                                }
                                if (attributeValueType != 4) {
                                    throw new ApkFormatException("Unable to determine whether APK is debuggable: AndroidManifest.xml's android:debuggable attribute uses unsupported value type. Only boolean, string and int values are supported.");
                                }
                            }
                            String attributeStringValue = androidBinXmlParser.getAttributeStringValue(i);
                            return "true".equals(attributeStringValue) || "TRUE".equals(attributeStringValue) || "1".equals(attributeStringValue);
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (AndroidBinXmlParser.XmlParserException e) {
            throw new ApkFormatException("Unable to determine whether APK is debuggable: malformed binary resource: AndroidManifest.xml", e);
        }
    }

    public static long getLongVersionCodeFromBinaryAndroidManifest(ByteBuffer byteBuffer) throws ApkFormatException {
        long attributeValueFromBinaryAndroidManifest;
        int versionCodeFromBinaryAndroidManifest = getVersionCodeFromBinaryAndroidManifest(byteBuffer);
        try {
            byteBuffer.rewind();
            attributeValueFromBinaryAndroidManifest = getAttributeValueFromBinaryAndroidManifest(byteBuffer, "manifest", R.attr.versionCodeMajor);
        } catch (ApkFormatException unused) {
            attributeValueFromBinaryAndroidManifest = 0;
        }
        return (attributeValueFromBinaryAndroidManifest << 32) | ((long) versionCodeFromBinaryAndroidManifest);
    }

    public static int getMinSdkVersionForCodename(String str) throws CodenameMinSdkVersionException {
        char cCharAt = str.isEmpty() ? ' ' : str.charAt(0);
        if (cCharAt < 'A' || cCharAt > 'Z') {
            throw new CodenameMinSdkVersionException("Unable to determine APK's minimum supported Android platform version : Unsupported codename in AndroidManifest.xml's minSdkVersion: \"" + str + "\"", str);
        }
        Pair[] pairArr = CodenamesLazyInitializer.SORTED_CODENAMES_FIRST_CHAR_TO_API_LEVEL;
        int iBinarySearch = Arrays.binarySearch(pairArr, Pair.m2038of(Character.valueOf(cCharAt), null), CodenamesLazyInitializer.CODENAME_FIRST_CHAR_COMPARATOR);
        if (iBinarySearch >= 0) {
            return ((Integer) pairArr[iBinarySearch].getSecond()).intValue();
        }
        int i = (-1) - iBinarySearch;
        if (i == 0) {
            return 1;
        }
        Pair pair = pairArr[i - 1];
        return ((Integer) pair.getSecond()).intValue() + (cCharAt - ((Character) pair.getFirst()).charValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        r4 = r0.getAttributeValueType(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r4 == 1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        if (r4 != 2) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        r6 = r0.getAttributeIntValue(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        throw new com.android.apksig.apk.MinSdkVersionException("Unable to determine APK's minimum supported Android: unsupported value type in AndroidManifest.xml's minSdkVersion. Only integer values supported.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        r6 = getMinSdkVersionForCodename(r0.getAttributeStringValue(r6));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getMinSdkVersionFromBinaryAndroidManifest(java.nio.ByteBuffer r6) throws com.android.apksig.apk.MinSdkVersionException {
        /*
            com.android.apksig.internal.apk.AndroidBinXmlParser r0 = new com.android.apksig.internal.apk.AndroidBinXmlParser     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            r0.<init>(r6)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            int r6 = r0.getEventType()     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            r1 = 1
            r2 = 1
        Lb:
            r3 = 2
            if (r6 == r3) goto L68
            r4 = 3
            if (r6 != r4) goto L63
            int r6 = r0.getDepth()     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            if (r6 != r3) goto L63
            java.lang.String r6 = "uses-sdk"
            java.lang.String r4 = r0.getName()     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            boolean r6 = r6.equals(r4)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            if (r6 == 0) goto L63
            java.lang.String r6 = r0.getNamespace()     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            boolean r6 = r6.isEmpty()     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            if (r6 == 0) goto L63
            r6 = 0
        L2e:
            int r4 = r0.getAttributeCount()     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            if (r6 >= r4) goto L5e
            int r4 = r0.getAttributeNameResourceId(r6)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            r5 = 16843276(0x101020c, float:2.3695027E-38)
            if (r4 != r5) goto L5b
            int r4 = r0.getAttributeValueType(r6)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            if (r4 == r1) goto L52
            if (r4 != r3) goto L4a
            int r6 = r0.getAttributeIntValue(r6)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            goto L5f
        L4a:
            com.android.apksig.apk.MinSdkVersionException r6 = new com.android.apksig.apk.MinSdkVersionException     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            java.lang.String r0 = "Unable to determine APK's minimum supported Android: unsupported value type in AndroidManifest.xml's minSdkVersion. Only integer values supported."
            r6.<init>(r0)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            throw r6     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
        L52:
            java.lang.String r6 = r0.getAttributeStringValue(r6)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            int r6 = getMinSdkVersionForCodename(r6)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            goto L5f
        L5b:
            int r6 = r6 + 1
            goto L2e
        L5e:
            r6 = 1
        L5f:
            int r2 = java.lang.Math.max(r2, r6)     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
        L63:
            int r6 = r0.next()     // Catch: com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException -> L69
            goto Lb
        L68:
            return r2
        L69:
            r6 = move-exception
            com.android.apksig.apk.MinSdkVersionException r0 = new com.android.apksig.apk.MinSdkVersionException
            java.lang.String r1 = "Unable to determine APK's minimum supported Android platform version: malformed binary resource: AndroidManifest.xml"
            r0.<init>(r1, r6)
            goto L73
        L72:
            throw r0
        L73:
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.apksig.apk.ApkUtils.getMinSdkVersionFromBinaryAndroidManifest(java.nio.ByteBuffer):int");
    }

    public static String getPackageNameFromBinaryAndroidManifest(ByteBuffer byteBuffer) throws ApkFormatException {
        try {
            AndroidBinXmlParser androidBinXmlParser = new AndroidBinXmlParser(byteBuffer);
            for (int eventType = androidBinXmlParser.getEventType(); eventType != 2; eventType = androidBinXmlParser.next()) {
                if (eventType == 3 && androidBinXmlParser.getDepth() == 1 && "manifest".equals(androidBinXmlParser.getName()) && androidBinXmlParser.getNamespace().isEmpty()) {
                    for (int i = 0; i < androidBinXmlParser.getAttributeCount(); i++) {
                        if ("package".equals(androidBinXmlParser.getAttributeName(i)) && androidBinXmlParser.getNamespace().isEmpty()) {
                            return androidBinXmlParser.getAttributeStringValue(i);
                        }
                    }
                    return null;
                }
            }
            return null;
        } catch (AndroidBinXmlParser.XmlParserException e) {
            throw new ApkFormatException("Unable to determine APK package name: malformed binary resource: AndroidManifest.xml", e);
        }
    }

    public static int getTargetSandboxVersionFromBinaryAndroidManifest(ByteBuffer byteBuffer) {
        try {
            return getAttributeValueFromBinaryAndroidManifest(byteBuffer, "manifest", R.attr.targetSandboxVersion);
        } catch (ApkFormatException unused) {
            return 1;
        }
    }

    public static int getTargetSdkVersionFromBinaryAndroidManifest(ByteBuffer byteBuffer) {
        try {
            return getAttributeValueFromBinaryAndroidManifest(byteBuffer, "uses-sdk", R.attr.targetSdkVersion);
        } catch (ApkFormatException unused) {
            byteBuffer.rewind();
            try {
                return getMinSdkVersionFromBinaryAndroidManifest(byteBuffer);
            } catch (ApkFormatException unused2) {
                return 1;
            }
        }
    }

    public static int getVersionCodeFromBinaryAndroidManifest(ByteBuffer byteBuffer) throws ApkFormatException {
        return getAttributeValueFromBinaryAndroidManifest(byteBuffer, "manifest", R.attr.versionCode);
    }

    public static void setZipEocdCentralDirectoryOffset(ByteBuffer byteBuffer, long j) {
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        ZipUtils.setZipEocdCentralDirectoryOffset(byteBufferSlice, j);
    }
}
