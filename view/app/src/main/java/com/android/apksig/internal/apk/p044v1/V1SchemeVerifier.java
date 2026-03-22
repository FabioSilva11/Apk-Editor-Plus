package com.android.apksig.internal.apk.p044v1;

import android.support.v7.widget.ActivityChooserView;
import android.util.Base64;
import com.android.apksig.ApkVerifier;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.apk.ApkUtils;
import com.android.apksig.internal.asn1.Asn1BerParser;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1DecodingException;
import com.android.apksig.internal.asn1.Asn1Field;
import com.android.apksig.internal.asn1.Asn1OpaqueObject;
import com.android.apksig.internal.asn1.Asn1Type;
import com.android.apksig.internal.jar.ManifestParser;
import com.android.apksig.internal.oid.OidConstants;
import com.android.apksig.internal.pkcs7.AlgorithmIdentifier;
import com.android.apksig.internal.pkcs7.Attribute;
import com.android.apksig.internal.pkcs7.ContentInfo;
import com.android.apksig.internal.pkcs7.Pkcs7Constants;
import com.android.apksig.internal.pkcs7.Pkcs7DecodingException;
import com.android.apksig.internal.pkcs7.SignedData;
import com.android.apksig.internal.pkcs7.SignerInfo;
import com.android.apksig.internal.util.ByteBufferUtils;
import com.android.apksig.internal.util.InclusiveIntRange;
import com.android.apksig.internal.util.Pair;
import com.android.apksig.internal.x509.Certificate;
import com.android.apksig.internal.zip.CentralDirectoryRecord;
import com.android.apksig.internal.zip.LocalFileRecord;
import com.android.apksig.internal.zip.ZipUtils;
import com.android.apksig.util.DataSinks;
import com.android.apksig.util.DataSource;
import com.android.apksig.zip.ZipFormatException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.jar.Attributes;

/* JADX INFO: loaded from: classes.dex */
public abstract class V1SchemeVerifier {
    public static final String[] JB_MR2_AND_NEWER_DIGEST_ALGS = {"SHA-512", "SHA-384", "SHA-256", "SHA-1"};
    public static final Map<String, Integer> MIN_SDK_VESION_FROM_WHICH_DIGEST_SUPPORTED_IN_MANIFEST;
    public static final Map<String, String> UPPER_CASE_JCA_DIGEST_ALG_TO_CANONICAL;

    public static class NamedDigest {
        public final byte[] digest;
        public final String jcaDigestAlgorithm;

        public NamedDigest(String str, byte[] bArr) {
            this.jcaDigestAlgorithm = str;
            this.digest = bArr;
        }
    }

    @Asn1Class(type = Asn1Type.CHOICE)
    public static class ObjectIdentifierChoice {

        @Asn1Field(type = Asn1Type.OBJECT_IDENTIFIER)
        public String value;
    }

    @Asn1Class(type = Asn1Type.CHOICE)
    public static class OctetStringChoice {

        @Asn1Field(type = Asn1Type.OCTET_STRING)
        public byte[] value;
    }

    public static class Result {
        public boolean verified;
        public final List<SignerInfo> signers = new ArrayList();
        public final List<SignerInfo> ignoredSigners = new ArrayList();
        public final List<ApkVerifier.IssueWithParams> mWarnings = new ArrayList();
        public final List<ApkVerifier.IssueWithParams> mErrors = new ArrayList();

        public static class SignerInfo {
            public final List<X509Certificate> certChain;
            public final List<ApkVerifier.IssueWithParams> mErrors;
            public final List<ApkVerifier.IssueWithParams> mWarnings;
            public final String name;
            public final String signatureBlockFileName;
            public final String signatureFileName;

            public SignerInfo(String str, String str2, String str3) {
                this.certChain = new ArrayList();
                this.mWarnings = new ArrayList();
                this.mErrors = new ArrayList();
                this.name = str;
                this.signatureBlockFileName = str2;
                this.signatureFileName = str3;
            }

            public final void addError(ApkVerifier.Issue issue, Object... objArr) {
                this.mErrors.add(new ApkVerifier.IssueWithParams(issue, objArr));
            }

            public final void addWarning(ApkVerifier.Issue issue, Object... objArr) {
                this.mWarnings.add(new ApkVerifier.IssueWithParams(issue, objArr));
            }

            public final boolean containsErrors() {
                return !this.mErrors.isEmpty();
            }

            public List<ApkVerifier.IssueWithParams> getErrors() {
                return this.mErrors;
            }

            public List<ApkVerifier.IssueWithParams> getWarnings() {
                return this.mWarnings;
            }
        }

        public final void addError(ApkVerifier.Issue issue, Object... objArr) {
            this.mErrors.add(new ApkVerifier.IssueWithParams(issue, objArr));
        }

        public final void addWarning(ApkVerifier.Issue issue, Object... objArr) {
            this.mWarnings.add(new ApkVerifier.IssueWithParams(issue, objArr));
        }

        public final boolean containsErrors() {
            if (!this.mErrors.isEmpty()) {
                return true;
            }
            Iterator<SignerInfo> it = this.signers.iterator();
            while (it.hasNext()) {
                if (it.next().containsErrors()) {
                    return true;
                }
            }
            return false;
        }

        public List<ApkVerifier.IssueWithParams> getErrors() {
            return this.mErrors;
        }

        public List<ApkVerifier.IssueWithParams> getWarnings() {
            return this.mWarnings;
        }
    }

    public static class SignedAttributes {
        public Map<String, List<Asn1OpaqueObject>> mAttrs;

        public SignedAttributes(Collection<Attribute> collection) throws Pkcs7DecodingException {
            HashMap map = new HashMap(collection.size());
            for (Attribute attribute : collection) {
                if (map.put(attribute.attrType, attribute.attrValues) != null) {
                    throw new Pkcs7DecodingException("Duplicate signed attribute: " + attribute.attrType);
                }
            }
            this.mAttrs = map;
        }

        public String getSingleObjectIdentifierValue(String str) throws Pkcs7DecodingException {
            Asn1OpaqueObject singleValue = getSingleValue(str);
            if (singleValue == null) {
                return null;
            }
            try {
                return ((ObjectIdentifierChoice) Asn1BerParser.parse(singleValue.getEncoded(), ObjectIdentifierChoice.class)).value;
            } catch (Asn1DecodingException e) {
                throw new Pkcs7DecodingException("Failed to decode OBJECT IDENTIFIER", e);
            }
        }

        public byte[] getSingleOctetStringValue(String str) throws Pkcs7DecodingException {
            Asn1OpaqueObject singleValue = getSingleValue(str);
            if (singleValue == null) {
                return null;
            }
            try {
                return ((OctetStringChoice) Asn1BerParser.parse(singleValue.getEncoded(), OctetStringChoice.class)).value;
            } catch (Asn1DecodingException e) {
                throw new Pkcs7DecodingException("Failed to decode OBJECT IDENTIFIER", e);
            }
        }

        public final Asn1OpaqueObject getSingleValue(String str) throws Pkcs7DecodingException {
            List<Asn1OpaqueObject> list = this.mAttrs.get(str);
            if (list == null || list.isEmpty()) {
                return null;
            }
            if (list.size() <= 1) {
                return list.get(0);
            }
            throw new Pkcs7DecodingException("Attribute " + str + " has multiple values");
        }
    }

    public static class Signer {
        public boolean mIgnored;
        public final String mName;
        public final Result.SignerInfo mResult;
        public byte[] mSigFileBytes;
        public Set<String> mSigFileEntryNames;
        public final CentralDirectoryRecord mSignatureBlockEntry;
        public final CentralDirectoryRecord mSignatureFileEntry;

        public Signer(String str, CentralDirectoryRecord centralDirectoryRecord, CentralDirectoryRecord centralDirectoryRecord2, Result.SignerInfo signerInfo) {
            this.mName = str;
            this.mResult = signerInfo;
            this.mSignatureBlockEntry = centralDirectoryRecord;
            this.mSignatureFileEntry = centralDirectoryRecord2;
        }

        public static List<X509Certificate> getCertificateChain(List<X509Certificate> list, X509Certificate x509Certificate) {
            ArrayList arrayList = new ArrayList(list);
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(x509Certificate);
            arrayList.remove(x509Certificate);
            while (!x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN())) {
                Principal issuerDN = x509Certificate.getIssuerDN();
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= arrayList.size()) {
                        break;
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) arrayList.get(i);
                    if (issuerDN.equals(x509Certificate2.getSubjectDN())) {
                        arrayList.remove(i);
                        arrayList2.add(x509Certificate2);
                        x509Certificate = x509Certificate2;
                        z = true;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    break;
                }
            }
            return arrayList2;
        }

        public final void checkForStrippedApkSignatures(ManifestParser.Section section, Map<Integer, String> map, Set<Integer> set) {
            String attributeValue = section.getAttributeValue(V1SchemeConstants.SF_ATTRIBUTE_NAME_ANDROID_APK_SIGNED_NAME_STR);
            if (attributeValue == null) {
                if (set.isEmpty()) {
                    return;
                }
                this.mResult.addWarning(ApkVerifier.Issue.JAR_SIG_NO_APK_SIG_STRIP_PROTECTION, this.mSignatureFileEntry.getName());
                return;
            }
            if (map.isEmpty()) {
                return;
            }
            Set<Integer> setKeySet = map.keySet();
            HashSet hashSet = new HashSet(1);
            StringTokenizer stringTokenizer = new StringTokenizer(attributeValue, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String strTrim = stringTokenizer.nextToken().trim();
                if (!strTrim.isEmpty()) {
                    try {
                        int i = Integer.parseInt(strTrim);
                        if (setKeySet.contains(Integer.valueOf(i))) {
                            hashSet.add(Integer.valueOf(i));
                        } else {
                            this.mResult.addWarning(ApkVerifier.Issue.JAR_SIG_UNKNOWN_APK_SIG_SCHEME_ID, this.mSignatureFileEntry.getName(), Integer.valueOf(i));
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!set.contains(Integer.valueOf(iIntValue))) {
                    this.mResult.addError(ApkVerifier.Issue.JAR_SIG_MISSING_APK_SIG_REFERENCED, this.mSignatureFileEntry.getName(), Integer.valueOf(iIntValue), map.get(Integer.valueOf(iIntValue)));
                }
            }
        }

        public String getName() {
            return this.mName;
        }

        public Result.SignerInfo getResult() {
            return this.mResult;
        }

        public Set<String> getSigFileEntryNames() {
            return this.mSigFileEntryNames;
        }

        public String getSignatureBlockEntryName() {
            return this.mSignatureBlockEntry.getName();
        }

        public String getSignatureFileEntryName() {
            return this.mSignatureFileEntry.getName();
        }

        public boolean isIgnored() {
            return this.mIgnored;
        }

        public void setIgnored() {
            this.mIgnored = true;
        }

        public final boolean verifyManifestDigest(ManifestParser.Section section, boolean z, byte[] bArr, int i, int i2) throws NoSuchAlgorithmException {
            Collection<NamedDigest> digestsToVerify = V1SchemeVerifier.getDigestsToVerify(section, z ? "-Digest" : "-Digest-Manifest", i, i2);
            if (!(!digestsToVerify.isEmpty())) {
                this.mResult.addWarning(ApkVerifier.Issue.JAR_SIG_NO_MANIFEST_DIGEST_IN_SIG_FILE, this.mSignatureFileEntry.getName());
                return false;
            }
            boolean z2 = true;
            for (NamedDigest namedDigest : digestsToVerify) {
                String str = namedDigest.jcaDigestAlgorithm;
                byte[] bArrDigest = V1SchemeVerifier.digest(str, bArr);
                byte[] bArr2 = namedDigest.digest;
                if (!Arrays.equals(bArr2, bArrDigest)) {
                    this.mResult.addWarning(ApkVerifier.Issue.JAR_SIG_ZIP_ENTRY_DIGEST_DID_NOT_VERIFY, "META-INF/MANIFEST.MF", str, this.mSignatureFileEntry.getName(), Base64.encodeToString(bArrDigest, 2), Base64.encodeToString(bArr2, 2));
                    z2 = false;
                }
            }
            return z2;
        }

        public final void verifyManifestIndividualSectionDigest(ManifestParser.Section section, boolean z, ManifestParser.Section section2, byte[] bArr, int i, int i2) throws NoSuchAlgorithmException {
            String name = section.getName();
            Collection<NamedDigest> digestsToVerify = V1SchemeVerifier.getDigestsToVerify(section, "-Digest", i, i2);
            if (digestsToVerify.isEmpty()) {
                this.mResult.addError(ApkVerifier.Issue.JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_SIG_FILE, name, this.mSignatureFileEntry.getName());
                return;
            }
            int startOffset = section2.getStartOffset();
            int sizeBytes = section2.getSizeBytes();
            if (z) {
                int i3 = startOffset + sizeBytes;
                if (bArr[i3 - 1] == 10 && bArr[i3 - 2] == 10) {
                    sizeBytes--;
                }
            }
            for (NamedDigest namedDigest : digestsToVerify) {
                String str = namedDigest.jcaDigestAlgorithm;
                byte[] bArrDigest = V1SchemeVerifier.digest(str, bArr, startOffset, sizeBytes);
                byte[] bArr2 = namedDigest.digest;
                if (!Arrays.equals(bArr2, bArrDigest)) {
                    this.mResult.addError(ApkVerifier.Issue.JAR_SIG_MANIFEST_SECTION_DIGEST_DID_NOT_VERIFY, name, str, this.mSignatureFileEntry.getName(), Base64.encodeToString(bArrDigest, 2), Base64.encodeToString(bArr2, 2));
                }
            }
        }

        public final void verifyManifestMainSectionDigest(ManifestParser.Section section, ManifestParser.Section section2, byte[] bArr, int i, int i2) throws NoSuchAlgorithmException {
            Collection<NamedDigest> digestsToVerify = V1SchemeVerifier.getDigestsToVerify(section, "-Digest-Manifest-Main-Attributes", i, i2);
            if (digestsToVerify.isEmpty()) {
                return;
            }
            for (NamedDigest namedDigest : digestsToVerify) {
                String str = namedDigest.jcaDigestAlgorithm;
                byte[] bArrDigest = V1SchemeVerifier.digest(str, bArr, section2.getStartOffset(), section2.getSizeBytes());
                byte[] bArr2 = namedDigest.digest;
                if (!Arrays.equals(bArr2, bArrDigest)) {
                    this.mResult.addError(ApkVerifier.Issue.JAR_SIG_MANIFEST_MAIN_SECTION_DIGEST_DID_NOT_VERIFY, str, this.mSignatureFileEntry.getName(), Base64.encodeToString(bArrDigest, 2), Base64.encodeToString(bArr2, 2));
                }
            }
        }

        public void verifySigBlockAgainstSigFile(DataSource dataSource, long j, int i, int i2) throws NoSuchAlgorithmException, IOException, ApkFormatException {
            try {
                byte[] uncompressedData = LocalFileRecord.getUncompressedData(dataSource, this.mSignatureBlockEntry, j);
                try {
                    this.mSigFileBytes = LocalFileRecord.getUncompressedData(dataSource, this.mSignatureFileEntry, j);
                    try {
                        ContentInfo contentInfo = (ContentInfo) Asn1BerParser.parse(ByteBuffer.wrap(uncompressedData), ContentInfo.class);
                        if (!Pkcs7Constants.OID_SIGNED_DATA.equals(contentInfo.contentType)) {
                            throw new Asn1DecodingException("Unsupported ContentInfo.contentType: " + contentInfo.contentType);
                        }
                        SignedData signedData = (SignedData) Asn1BerParser.parse(contentInfo.content.getEncoded(), SignedData.class);
                        if (signedData.signerInfos.isEmpty()) {
                            this.mResult.addError(ApkVerifier.Issue.JAR_SIG_NO_SIGNERS, this.mSignatureBlockEntry.getName());
                            return;
                        }
                        List<X509Certificate> certificates = null;
                        SignerInfo signerInfo = null;
                        X509Certificate x509Certificate = null;
                        for (SignerInfo signerInfo2 : i < 24 ? Collections.singletonList(signedData.signerInfos.get(0)) : signedData.signerInfos) {
                            if (certificates == null) {
                                try {
                                    certificates = Certificate.parseCertificates(signedData.certificates);
                                } catch (CertificateException e) {
                                    this.mResult.addError(ApkVerifier.Issue.JAR_SIG_PARSE_EXCEPTION, this.mSignatureBlockEntry.getName(), e);
                                    return;
                                }
                            }
                            List<X509Certificate> list = certificates;
                            try {
                                X509Certificate x509CertificateVerifySignerInfoAgainstSigFile = verifySignerInfoAgainstSigFile(signedData, list, signerInfo2, this.mSigFileBytes, i, i2);
                                if (this.mResult.containsErrors()) {
                                    return;
                                }
                                if (x509CertificateVerifySignerInfoAgainstSigFile != null && signerInfo == null) {
                                    x509Certificate = x509CertificateVerifySignerInfoAgainstSigFile;
                                    signerInfo = signerInfo2;
                                }
                                certificates = list;
                            } catch (Pkcs7DecodingException e2) {
                                this.mResult.addError(ApkVerifier.Issue.JAR_SIG_PARSE_EXCEPTION, this.mSignatureBlockEntry.getName(), e2);
                                return;
                            } catch (InvalidKeyException e3) {
                                e = e3;
                                this.mResult.addError(ApkVerifier.Issue.JAR_SIG_VERIFY_EXCEPTION, this.mSignatureBlockEntry.getName(), this.mSignatureFileEntry.getName(), e);
                                return;
                            } catch (SignatureException e4) {
                                e = e4;
                                this.mResult.addError(ApkVerifier.Issue.JAR_SIG_VERIFY_EXCEPTION, this.mSignatureBlockEntry.getName(), this.mSignatureFileEntry.getName(), e);
                                return;
                            }
                        }
                        if (signerInfo == null) {
                            this.mResult.addError(ApkVerifier.Issue.JAR_SIG_DID_NOT_VERIFY, this.mSignatureBlockEntry.getName(), this.mSignatureFileEntry.getName());
                            return;
                        }
                        List<X509Certificate> certificateChain = getCertificateChain(certificates, x509Certificate);
                        this.mResult.certChain.clear();
                        this.mResult.certChain.addAll(certificateChain);
                    } catch (Asn1DecodingException e5) {
                        e5.printStackTrace();
                        this.mResult.addError(ApkVerifier.Issue.JAR_SIG_PARSE_EXCEPTION, this.mSignatureBlockEntry.getName(), e5);
                    }
                } catch (ZipFormatException e6) {
                    throw new ApkFormatException("Malformed ZIP entry: " + this.mSignatureFileEntry.getName(), e6);
                }
            } catch (ZipFormatException e7) {
                throw new ApkFormatException("Malformed ZIP entry: " + this.mSignatureBlockEntry.getName(), e7);
            }
        }

        public void verifySigFileAgainstManifest(byte[] bArr, ManifestParser.Section section, Map<String, ManifestParser.Section> map, Map<Integer, String> map2, Set<Integer> set, int i, int i2) throws NoSuchAlgorithmException {
            ManifestParser manifestParser = new ManifestParser(this.mSigFileBytes);
            ManifestParser.Section section2 = manifestParser.readSection();
            if (section2.getAttributeValue(Attributes.Name.SIGNATURE_VERSION) == null) {
                this.mResult.addError(ApkVerifier.Issue.JAR_SIG_MISSING_VERSION_ATTR_IN_SIG_FILE, this.mSignatureFileEntry.getName());
                setIgnored();
                return;
            }
            if (i2 >= 24) {
                checkForStrippedApkSignatures(section2, map2, set);
                if (this.mResult.containsErrors()) {
                    return;
                }
            }
            String attributeValue = section2.getAttributeValue("Created-By");
            boolean z = attributeValue != null ? attributeValue.indexOf("signtool") != -1 : false;
            boolean zVerifyManifestDigest = verifyManifestDigest(section2, z, bArr, i, i2);
            if (!z) {
                verifyManifestMainSectionDigest(section2, section, bArr, i, i2);
            }
            if (this.mResult.containsErrors()) {
                return;
            }
            List<ManifestParser.Section> allSections = manifestParser.readAllSections();
            HashSet hashSet = new HashSet(allSections.size());
            int i3 = 0;
            for (ManifestParser.Section section3 : allSections) {
                int i4 = i3 + 1;
                String name = section3.getName();
                if (name == null) {
                    this.mResult.addError(ApkVerifier.Issue.JAR_SIG_UNNNAMED_SIG_FILE_SECTION, this.mSignatureFileEntry.getName(), Integer.valueOf(i4));
                    setIgnored();
                    return;
                } else {
                    if (!hashSet.add(name)) {
                        this.mResult.addError(ApkVerifier.Issue.JAR_SIG_DUPLICATE_SIG_FILE_SECTION, this.mSignatureFileEntry.getName(), name);
                        setIgnored();
                        return;
                    }
                    if (!zVerifyManifestDigest) {
                        ManifestParser.Section section4 = map.get(name);
                        if (section4 == null) {
                            this.mResult.addError(ApkVerifier.Issue.JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_SIG_FILE, name, this.mSignatureFileEntry.getName());
                            setIgnored();
                        } else {
                            verifyManifestIndividualSectionDigest(section3, z, section4, bArr, i, i2);
                        }
                    }
                    i3 = i4;
                }
            }
            this.mSigFileEntryNames = hashSet;
        }

        public final X509Certificate verifySignerInfoAgainstSigFile(SignedData signedData, Collection<X509Certificate> collection, SignerInfo signerInfo, byte[] bArr, int i, int i2) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException, Pkcs7DecodingException {
            String str = signerInfo.digestAlgorithm.algorithm;
            String str2 = signerInfo.signatureAlgorithm.algorithm;
            List<InclusiveIntRange> valuesNotIn = InclusiveIntRange.fromTo(i, i2).getValuesNotIn(OidConstants.getSigAlgSupportedApiLevels(str, str2));
            boolean z = false;
            if (!valuesNotIn.isEmpty()) {
                String userFriendlyNameForOid = OidConstants.OidToUserFriendlyNameMapper.getUserFriendlyNameForOid(str);
                if (userFriendlyNameForOid == null) {
                    userFriendlyNameForOid = str;
                }
                String userFriendlyNameForOid2 = OidConstants.OidToUserFriendlyNameMapper.getUserFriendlyNameForOid(str2);
                if (userFriendlyNameForOid2 == null) {
                    userFriendlyNameForOid2 = str2;
                }
                StringBuilder sb = new StringBuilder();
                for (InclusiveIntRange inclusiveIntRange : valuesNotIn) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    if (inclusiveIntRange.getMin() == inclusiveIntRange.getMax()) {
                        sb.append(String.valueOf(inclusiveIntRange.getMin()));
                    } else if (inclusiveIntRange.getMax() == Integer.MAX_VALUE) {
                        sb.append(inclusiveIntRange.getMin() + "+");
                    } else {
                        sb.append(inclusiveIntRange.getMin() + "-" + inclusiveIntRange.getMax());
                    }
                }
                this.mResult.addError(ApkVerifier.Issue.JAR_SIG_UNSUPPORTED_SIG_ALG, this.mSignatureBlockEntry.getName(), str, str2, sb.toString(), userFriendlyNameForOid, userFriendlyNameForOid2);
                return null;
            }
            X509Certificate x509CertificateFindCertificate = Certificate.findCertificate(collection, signerInfo.sid);
            if (x509CertificateFindCertificate == null) {
                throw new SignatureException("Signing certificate referenced in SignerInfo not found in SignedData");
            }
            if (x509CertificateFindCertificate.hasUnsupportedCriticalExtension()) {
                throw new SignatureException("Signing certificate has unsupported critical extensions");
            }
            boolean[] keyUsage = x509CertificateFindCertificate.getKeyUsage();
            if (keyUsage != null) {
                boolean z2 = keyUsage.length >= 1 && keyUsage[0];
                if (keyUsage.length >= 2 && keyUsage[1]) {
                    z = true;
                }
                if (!z2 && !z) {
                    throw new SignatureException("Signing certificate not authorized for use in digital signatures: keyUsage extension missing digitalSignature and nonRepudiation");
                }
            }
            Signature signature = Signature.getInstance(AlgorithmIdentifier.getJcaSignatureAlgorithm(str, str2));
            signature.initVerify(x509CertificateFindCertificate.getPublicKey());
            Asn1OpaqueObject asn1OpaqueObject = signerInfo.signedAttrs;
            if (asn1OpaqueObject == null) {
                signature.update(bArr);
            } else {
                if (i < 19) {
                    throw new SignatureException("APKs with Signed Attributes broken on platforms with API Level < 19");
                }
                try {
                    SignedAttributes signedAttributes = new SignedAttributes(Asn1BerParser.parseImplicitSetOf(asn1OpaqueObject.getEncoded(), Attribute.class));
                    if (i2 >= 24) {
                        String singleObjectIdentifierValue = signedAttributes.getSingleObjectIdentifierValue(Pkcs7Constants.OID_CONTENT_TYPE);
                        if (singleObjectIdentifierValue == null) {
                            throw new SignatureException("No Content Type in signed attributes");
                        }
                        if (!singleObjectIdentifierValue.equals(signedData.encapContentInfo.contentType)) {
                            return null;
                        }
                    }
                    byte[] singleOctetStringValue = signedAttributes.getSingleOctetStringValue(Pkcs7Constants.OID_MESSAGE_DIGEST);
                    if (singleOctetStringValue == null) {
                        throw new SignatureException("No content digest in signed attributes");
                    }
                    if (!Arrays.equals(singleOctetStringValue, MessageDigest.getInstance(AlgorithmIdentifier.getJcaDigestAlgorithm(str)).digest(bArr))) {
                        return null;
                    }
                    ByteBuffer encoded = signerInfo.signedAttrs.getEncoded();
                    signature.update((byte) 49);
                    encoded.position(1);
                    signature.update(encoded);
                } catch (Asn1DecodingException e) {
                    throw new SignatureException("Failed to parse signed attributes", e);
                }
            }
            if (signature.verify(ByteBufferUtils.toByteArray(signerInfo.signature.slice()))) {
                return x509CertificateFindCertificate;
            }
            return null;
        }
    }

    public static class Signers {
        public static void verify(DataSource dataSource, long j, List<CentralDirectoryRecord> list, Set<String> set, Map<Integer, String> map, Set<Integer> set2, int i, int i2, Result result) throws NoSuchAlgorithmException, IOException, ApkFormatException {
            HashMap map2 = new HashMap(1);
            ArrayList<CentralDirectoryRecord> arrayList = new ArrayList(1);
            CentralDirectoryRecord centralDirectoryRecord = null;
            for (CentralDirectoryRecord centralDirectoryRecord2 : list) {
                String name = centralDirectoryRecord2.getName();
                if (name.startsWith("META-INF/")) {
                    if (centralDirectoryRecord == null && "META-INF/MANIFEST.MF".equals(name)) {
                        centralDirectoryRecord = centralDirectoryRecord2;
                    } else if (name.endsWith(".SF")) {
                        map2.put(name, centralDirectoryRecord2);
                    } else if (name.endsWith(".RSA") || name.endsWith(".DSA") || name.endsWith(".EC")) {
                        arrayList.add(centralDirectoryRecord2);
                    }
                }
            }
            int i3 = 0;
            if (centralDirectoryRecord == null) {
                result.addError(ApkVerifier.Issue.JAR_SIG_NO_MANIFEST, new Object[0]);
                return;
            }
            try {
                byte[] uncompressedData = LocalFileRecord.getUncompressedData(dataSource, centralDirectoryRecord, j);
                Pair<ManifestParser.Section, Map<String, ManifestParser.Section>> manifest = V1SchemeVerifier.parseManifest(uncompressedData, set, result);
                if (result.containsErrors()) {
                    return;
                }
                ManifestParser.Section first = manifest.getFirst();
                Map<String, ManifestParser.Section> second = manifest.getSecond();
                ArrayList<Signer> arrayList2 = new ArrayList(arrayList.size());
                for (CentralDirectoryRecord centralDirectoryRecord3 : arrayList) {
                    String name2 = centralDirectoryRecord3.getName();
                    int iLastIndexOf = name2.lastIndexOf(46);
                    if (iLastIndexOf == -1) {
                        throw new RuntimeException("Signature block file name does not contain extension: " + name2);
                    }
                    String str = name2.substring(i3, iLastIndexOf) + ".SF";
                    CentralDirectoryRecord centralDirectoryRecord4 = (CentralDirectoryRecord) map2.get(str);
                    if (centralDirectoryRecord4 == null) {
                        ApkVerifier.Issue issue = ApkVerifier.Issue.JAR_SIG_MISSING_FILE;
                        Object[] objArr = new Object[2];
                        objArr[i3] = name2;
                        objArr[1] = str;
                        result.addWarning(issue, objArr);
                    } else {
                        String strSubstring = name2.substring(9);
                        arrayList2.add(new Signer(strSubstring, centralDirectoryRecord3, centralDirectoryRecord4, new Result.SignerInfo(strSubstring, name2, centralDirectoryRecord4.getName())));
                        i3 = 0;
                    }
                }
                if (arrayList2.isEmpty()) {
                    result.addError(ApkVerifier.Issue.JAR_SIG_NO_SIGNATURES, new Object[0]);
                    return;
                }
                for (Signer signer : arrayList2) {
                    ArrayList arrayList3 = arrayList2;
                    byte[] bArr = uncompressedData;
                    signer.verifySigBlockAgainstSigFile(dataSource, j, i, i2);
                    if (signer.getResult().containsErrors()) {
                        result.signers.add(signer.getResult());
                    }
                    arrayList2 = arrayList3;
                    uncompressedData = bArr;
                }
                ArrayList<Signer> arrayList4 = arrayList2;
                byte[] bArr2 = uncompressedData;
                if (result.containsErrors()) {
                    return;
                }
                ArrayList<Signer> arrayList5 = new ArrayList(arrayList4.size());
                for (Signer signer2 : arrayList4) {
                    signer2.verifySigFileAgainstManifest(bArr2, first, second, map, set2, i, i2);
                    if (signer2.isIgnored()) {
                        result.ignoredSigners.add(signer2.getResult());
                    } else if (signer2.getResult().containsErrors()) {
                        result.signers.add(signer2.getResult());
                    } else {
                        arrayList5.add(signer2);
                    }
                }
                if (result.containsErrors()) {
                    return;
                }
                if (arrayList5.isEmpty()) {
                    result.addError(ApkVerifier.Issue.JAR_SIG_NO_SIGNATURES, new Object[0]);
                    return;
                }
                Set<Signer> setVerifyJarEntriesAgainstManifestAndSigners = V1SchemeVerifier.verifyJarEntriesAgainstManifestAndSigners(dataSource, j, list, second, arrayList5, i, i2, result);
                if (result.containsErrors()) {
                    return;
                }
                HashSet hashSet = new HashSet((result.signers.size() * 2) + 1);
                hashSet.add(centralDirectoryRecord.getName());
                for (Signer signer3 : setVerifyJarEntriesAgainstManifestAndSigners) {
                    hashSet.add(signer3.getSignatureBlockEntryName());
                    hashSet.add(signer3.getSignatureFileEntryName());
                }
                Iterator<CentralDirectoryRecord> it = list.iterator();
                while (it.hasNext()) {
                    String name3 = it.next().getName();
                    if (name3.startsWith("META-INF/") && !name3.endsWith("/") && !hashSet.contains(name3)) {
                        result.addWarning(ApkVerifier.Issue.JAR_SIG_UNPROTECTED_ZIP_ENTRY, name3);
                    }
                }
                for (Signer signer4 : arrayList5) {
                    if (setVerifyJarEntriesAgainstManifestAndSigners.contains(signer4)) {
                        result.signers.add(signer4.getResult());
                    } else {
                        result.ignoredSigners.add(signer4.getResult());
                    }
                }
                result.verified = true;
            } catch (ZipFormatException e) {
                throw new ApkFormatException("Malformed ZIP entry: " + centralDirectoryRecord.getName(), e);
            }
        }
    }

    static {
        HashMap map = new HashMap(8);
        UPPER_CASE_JCA_DIGEST_ALG_TO_CANONICAL = map;
        map.put("MD5", "MD5");
        map.put("SHA", "SHA-1");
        map.put("SHA1", "SHA-1");
        map.put("SHA-1", "SHA-1");
        map.put("SHA-256", "SHA-256");
        map.put("SHA-384", "SHA-384");
        map.put("SHA-512", "SHA-512");
        HashMap map2 = new HashMap(5);
        MIN_SDK_VESION_FROM_WHICH_DIGEST_SUPPORTED_IN_MANIFEST = map2;
        map2.put("MD5", 0);
        map2.put("SHA-1", 0);
        map2.put("SHA-256", 0);
        map2.put("SHA-384", 9);
        map2.put("SHA-512", 9);
    }

    public static Set<String> checkForDuplicateEntries(List<CentralDirectoryRecord> list, Result result) {
        HashSet hashSet = new HashSet(list.size());
        Iterator<CentralDirectoryRecord> it = list.iterator();
        HashSet hashSet2 = null;
        while (it.hasNext()) {
            String name = it.next().getName();
            if (!hashSet.add(name)) {
                if (hashSet2 == null) {
                    hashSet2 = new HashSet();
                }
                if (hashSet2.add(name)) {
                    result.addError(ApkVerifier.Issue.JAR_SIG_DUPLICATE_ZIP_ENTRY, name);
                }
            }
        }
        return hashSet;
    }

    public static byte[] digest(String str, byte[] bArr) throws NoSuchAlgorithmException {
        return getMessageDigest(str).digest(bArr);
    }

    public static byte[] digest(String str, byte[] bArr, int i, int i2) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = getMessageDigest(str);
        messageDigest.update(bArr, i, i2);
        return messageDigest.digest();
    }

    public static String getCanonicalJcaMessageDigestAlgorithm(String str) {
        return UPPER_CASE_JCA_DIGEST_ALG_TO_CANONICAL.get(str.toUpperCase(Locale.US));
    }

    public static byte[] getDigest(Collection<NamedDigest> collection, String str) {
        for (NamedDigest namedDigest : collection) {
            if (namedDigest.jcaDigestAlgorithm.equalsIgnoreCase(str)) {
                return namedDigest.digest;
            }
        }
        return null;
    }

    public static Collection<NamedDigest> getDigestsToVerify(ManifestParser.Section section, String str, int i, int i2) {
        String canonicalJcaMessageDigestAlgorithm;
        ArrayList arrayList = new ArrayList(1);
        if (i < 18) {
            String attributeValue = section.getAttributeValue("Digest-Algorithms");
            if (attributeValue == null) {
                attributeValue = "SHA SHA1";
            }
            StringTokenizer stringTokenizer = new StringTokenizer(attributeValue);
            while (true) {
                if (!stringTokenizer.hasMoreTokens()) {
                    break;
                }
                String strNextToken = stringTokenizer.nextToken();
                String attributeValue2 = section.getAttributeValue(strNextToken + str);
                if (attributeValue2 != null && (canonicalJcaMessageDigestAlgorithm = getCanonicalJcaMessageDigestAlgorithm(strNextToken)) != null && getMinSdkVersionFromWhichSupportedInManifestOrSignatureFile(canonicalJcaMessageDigestAlgorithm) <= i) {
                    arrayList.add(new NamedDigest(canonicalJcaMessageDigestAlgorithm, Base64.decode(attributeValue2, 2)));
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                return arrayList;
            }
        }
        if (i2 >= 18) {
            String[] strArr = JB_MR2_AND_NEWER_DIGEST_ALGS;
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                String str2 = strArr[i3];
                String attributeValue3 = section.getAttributeValue(getJarDigestAttributeName(str2, str));
                if (attributeValue3 == null) {
                    i3++;
                } else {
                    byte[] bArrDecode = Base64.decode(attributeValue3, 2);
                    byte[] digest = getDigest(arrayList, str2);
                    if (digest == null || !Arrays.equals(digest, bArrDecode)) {
                        arrayList.add(new NamedDigest(str2, bArrDecode));
                    }
                }
            }
        }
        return arrayList;
    }

    public static String getJarDigestAttributeName(String str, String str2) {
        if ("SHA-1".equalsIgnoreCase(str)) {
            return "SHA1" + str2;
        }
        return str + str2;
    }

    public static MessageDigest getMessageDigest(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(str);
    }

    public static int getMinSdkVersionFromWhichSupportedInManifestOrSignatureFile(String str) {
        Integer num = MIN_SDK_VESION_FROM_WHICH_DIGEST_SUPPORTED_IN_MANIFEST.get(str.toUpperCase(Locale.US));
        return num != null ? num.intValue() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public static List<String> getSignerNames(List<Signer> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Signer> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getName());
        }
        return arrayList;
    }

    public static boolean isJarEntryDigestNeededInManifest(String str) {
        if (str.startsWith("META-INF/")) {
            return false;
        }
        return !str.endsWith("/");
    }

    public static Pair<ManifestParser.Section, Map<String, ManifestParser.Section>> parseManifest(byte[] bArr, Set<String> set, Result result) {
        ManifestParser manifestParser = new ManifestParser(bArr);
        ManifestParser.Section section = manifestParser.readSection();
        List<ManifestParser.Section> allSections = manifestParser.readAllSections();
        HashMap map = new HashMap(allSections.size());
        int i = 0;
        for (ManifestParser.Section section2 : allSections) {
            i++;
            String name = section2.getName();
            if (name == null) {
                result.addError(ApkVerifier.Issue.JAR_SIG_UNNNAMED_MANIFEST_SECTION, Integer.valueOf(i));
            } else if (map.put(name, section2) != null) {
                result.addError(ApkVerifier.Issue.JAR_SIG_DUPLICATE_MANIFEST_SECTION, name);
            } else if (!set.contains(name)) {
                result.addError(ApkVerifier.Issue.JAR_SIG_MISSING_ZIP_ENTRY_REFERENCED_IN_MANIFEST, name);
            }
        }
        return Pair.m2038of(section, map);
    }

    public static List<CentralDirectoryRecord> parseZipCentralDirectory(DataSource dataSource, ApkUtils.ZipSections zipSections) throws IOException, ApkFormatException {
        return ZipUtils.parseZipCentralDirectory(dataSource, zipSections);
    }

    public static Result verify(DataSource dataSource, ApkUtils.ZipSections zipSections, Map<Integer, String> map, Set<Integer> set, int i, int i2) throws NoSuchAlgorithmException, IOException, ApkFormatException {
        if (i <= i2) {
            Result result = new Result();
            List<CentralDirectoryRecord> zipCentralDirectory = parseZipCentralDirectory(dataSource, zipSections);
            Set<String> setCheckForDuplicateEntries = checkForDuplicateEntries(zipCentralDirectory, result);
            if (result.containsErrors()) {
                return result;
            }
            Signers.verify(dataSource, zipSections.getZipCentralDirectoryOffset(), zipCentralDirectory, setCheckForDuplicateEntries, map, set, i, i2, result);
            return result;
        }
        throw new IllegalArgumentException("minSdkVersion (" + i + ") > maxSdkVersion (" + i2 + ")");
    }

    public static Set<Signer> verifyJarEntriesAgainstManifestAndSigners(DataSource dataSource, long j, Collection<CentralDirectoryRecord> collection, Map<String, ManifestParser.Section> map, List<Signer> list, int i, int i2, Result result) throws NoSuchAlgorithmException, IOException, ApkFormatException {
        String str;
        String str2;
        Iterator it;
        ArrayList arrayList;
        String str3;
        ArrayList arrayList2 = new ArrayList(collection);
        Collections.sort(arrayList2, CentralDirectoryRecord.BY_LOCAL_FILE_HEADER_OFFSET_COMPARATOR);
        Iterator it2 = arrayList2.iterator();
        ArrayList arrayList3 = null;
        String str4 = null;
        while (it2.hasNext()) {
            CentralDirectoryRecord centralDirectoryRecord = (CentralDirectoryRecord) it2.next();
            String name = centralDirectoryRecord.getName();
            if (isJarEntryDigestNeededInManifest(name)) {
                ManifestParser.Section section = map.get(name);
                if (section == null) {
                    result.addError(ApkVerifier.Issue.JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_MANIFEST, name);
                } else {
                    ArrayList arrayList4 = new ArrayList(list.size());
                    for (Signer signer : list) {
                        if (signer.getSigFileEntryNames().contains(name)) {
                            arrayList4.add(signer);
                        }
                    }
                    if (arrayList4.isEmpty()) {
                        result.addError(ApkVerifier.Issue.JAR_SIG_ZIP_ENTRY_NOT_SIGNED, name);
                    } else {
                        if (arrayList3 == null) {
                            str4 = name;
                            arrayList3 = arrayList4;
                        } else if (!arrayList4.equals(arrayList3)) {
                            result.addError(ApkVerifier.Issue.JAR_SIG_ZIP_ENTRY_SIGNERS_MISMATCH, str4, getSignerNames(arrayList3), name, getSignerNames(arrayList4));
                        }
                        ArrayList arrayList5 = new ArrayList(getDigestsToVerify(section, "-Digest", i, i2));
                        if (arrayList5.isEmpty()) {
                            result.addError(ApkVerifier.Issue.JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_MANIFEST, name);
                        } else {
                            MessageDigest[] messageDigestArr = new MessageDigest[arrayList5.size()];
                            for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                                messageDigestArr[i3] = getMessageDigest(((NamedDigest) arrayList5.get(i3)).jcaDigestAlgorithm);
                            }
                            try {
                                str = name;
                            } catch (ZipFormatException e) {
                                e = e;
                                str2 = name;
                            } catch (IOException e2) {
                                e = e2;
                                str = name;
                            }
                            try {
                                LocalFileRecord.outputUncompressedData(dataSource, centralDirectoryRecord, j, DataSinks.asDataSink(messageDigestArr));
                                int i4 = 0;
                                while (i4 < arrayList5.size()) {
                                    NamedDigest namedDigest = (NamedDigest) arrayList5.get(i4);
                                    byte[] bArrDigest = messageDigestArr[i4].digest();
                                    if (Arrays.equals(namedDigest.digest, bArrDigest)) {
                                        it = it2;
                                        arrayList = arrayList3;
                                        str3 = str4;
                                    } else {
                                        it = it2;
                                        arrayList = arrayList3;
                                        str3 = str4;
                                        result.addError(ApkVerifier.Issue.JAR_SIG_ZIP_ENTRY_DIGEST_DID_NOT_VERIFY, str, namedDigest.jcaDigestAlgorithm, "META-INF/MANIFEST.MF", Base64.encodeToString(bArrDigest, 2), Base64.encodeToString(namedDigest.digest, 2));
                                    }
                                    i4++;
                                    it2 = it;
                                    arrayList3 = arrayList;
                                    str4 = str3;
                                }
                            } catch (ZipFormatException e3) {
                                e = e3;
                                str2 = str;
                                throw new ApkFormatException("Malformed ZIP entry: " + str2, e);
                            } catch (IOException e4) {
                                e = e4;
                                throw new IOException("Failed to read entry: " + str, e);
                            }
                        }
                        it2 = it2;
                        arrayList3 = arrayList3;
                        str4 = str4;
                    }
                }
            }
        }
        if (arrayList3 != null) {
            return new HashSet(arrayList3);
        }
        result.addError(ApkVerifier.Issue.JAR_SIG_NO_SIGNED_ZIP_ENTRIES, new Object[0]);
        return Collections.emptySet();
    }
}
