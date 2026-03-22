package com.android.apksig.internal.apk.p044v1;

import android.util.Base64;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.internal.apk.ApkSigningBlockUtils;
import com.android.apksig.internal.asn1.Asn1EncodingException;
import com.android.apksig.internal.jar.ManifestWriter;
import com.android.apksig.internal.jar.SignatureFileWriter;
import com.android.apksig.internal.pkcs7.AlgorithmIdentifier;
import com.android.apksig.internal.util.Pair;
import jadx.core.deobf.Deobfuscator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/* JADX INFO: loaded from: classes.dex */
public abstract class V1SchemeSigner {
    public static final String MANIFEST_ENTRY_NAME = "META-INF/MANIFEST.MF";
    public static final Attributes.Name ATTRIBUTE_NAME_CREATED_BY = new Attributes.Name("Created-By");
    public static final Attributes.Name SF_ATTRIBUTE_NAME_ANDROID_APK_SIGNED_NAME = new Attributes.Name(V1SchemeConstants.SF_ATTRIBUTE_NAME_ANDROID_APK_SIGNED_NAME_STR);

    /* JADX INFO: renamed from: com.android.apksig.internal.apk.v1.V1SchemeSigner$1 */
    public static /* synthetic */ class C09081 {
        public static final /* synthetic */ int[] $SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm;

        static {
            int[] iArr = new int[DigestAlgorithm.values().length];
            $SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm = iArr;
            try {
                iArr[DigestAlgorithm.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[DigestAlgorithm.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class OutputManifestFile {
        public byte[] contents;
        public SortedMap<String, byte[]> individualSectionsContents;
        public Attributes mainSectionAttributes;
    }

    public static class SignerConfig {
        public List<X509Certificate> certificates;
        public String name;
        public PrivateKey privateKey;
        public DigestAlgorithm signatureDigestAlgorithm;
    }

    public static void checkEntryNameValid(String str) throws ApkFormatException {
        for (char c : str.toCharArray()) {
            if (c == '\r' || c == '\n' || c == 0) {
                throw new ApkFormatException(String.format("Unsupported character 0x%1$02x in ZIP entry name \"%2$s\"", Integer.valueOf(c), str));
            }
        }
    }

    public static OutputManifestFile generateManifestFile(DigestAlgorithm digestAlgorithm, Map<String, byte[]> map, byte[] bArr) throws ApkFormatException {
        Manifest manifest;
        if (bArr != null) {
            try {
                manifest = new Manifest(new ByteArrayInputStream(bArr));
            } catch (IOException e) {
                throw new ApkFormatException("Malformed source META-INF/MANIFEST.MF", e);
            }
        } else {
            manifest = null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Attributes attributes = new Attributes();
        if (manifest != null) {
            attributes.putAll(manifest.getMainAttributes());
        } else {
            attributes.put(Attributes.Name.MANIFEST_VERSION, "1.0");
        }
        try {
            ManifestWriter.writeMainSection(byteArrayOutputStream, attributes);
            ArrayList<String> arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            TreeMap treeMap = new TreeMap();
            String entryDigestAttributeName = getEntryDigestAttributeName(digestAlgorithm);
            for (String str : arrayList) {
                checkEntryNameValid(str);
                byte[] bArr2 = map.get(str);
                Attributes attributes2 = new Attributes();
                attributes2.putValue(entryDigestAttributeName, Base64.encodeToString(bArr2, 2));
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    ManifestWriter.writeIndividualSection(byteArrayOutputStream2, str, attributes2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream.write(byteArray);
                    treeMap.put(str, byteArray);
                } catch (IOException e2) {
                    throw new RuntimeException("Failed to write in-memory MANIFEST.MF", e2);
                }
            }
            OutputManifestFile outputManifestFile = new OutputManifestFile();
            outputManifestFile.contents = byteArrayOutputStream.toByteArray();
            outputManifestFile.mainSectionAttributes = attributes;
            outputManifestFile.individualSectionsContents = treeMap;
            return outputManifestFile;
        } catch (IOException e3) {
            throw new RuntimeException("Failed to write in-memory MANIFEST.MF", e3);
        }
    }

    public static byte[] generateSignatureBlock(SignerConfig signerConfig, byte[] bArr) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException {
        List<X509Certificate> list = signerConfig.certificates;
        PublicKey publicKey = list.get(0).getPublicKey();
        DigestAlgorithm digestAlgorithm = signerConfig.signatureDigestAlgorithm;
        Pair<String, AlgorithmIdentifier> signerInfoSignatureAlgorithm = AlgorithmIdentifier.getSignerInfoSignatureAlgorithm(publicKey, digestAlgorithm);
        String first = signerInfoSignatureAlgorithm.getFirst();
        try {
            Signature signature = Signature.getInstance(first);
            signature.initSign(signerConfig.privateKey);
            signature.update(bArr);
            byte[] bArrSign = signature.sign();
            try {
                Signature signature2 = Signature.getInstance(first);
                signature2.initVerify(publicKey);
                signature2.update(bArr);
                if (!signature2.verify(bArrSign)) {
                    throw new SignatureException("Signature did not verify");
                }
                try {
                    return ApkSigningBlockUtils.generatePkcs7DerEncodedMessage(bArrSign, null, list, AlgorithmIdentifier.getSignerInfoDigestAlgorithmOid(digestAlgorithm), signerInfoSignatureAlgorithm.getSecond());
                } catch (Asn1EncodingException | CertificateEncodingException unused) {
                    throw new SignatureException("Failed to encode signature block");
                }
            } catch (InvalidKeyException e) {
                throw new InvalidKeyException("Failed to verify generated " + first + " signature using public key from certificate", e);
            } catch (SignatureException e2) {
                throw new SignatureException("Failed to verify generated " + first + " signature using public key from certificate", e2);
            }
        } catch (InvalidKeyException e3) {
            throw new InvalidKeyException("Failed to sign using " + first, e3);
        } catch (SignatureException e4) {
            throw new SignatureException("Failed to sign using " + first, e4);
        }
    }

    public static byte[] generateSignatureFile(List<Integer> list, DigestAlgorithm digestAlgorithm, String str, OutputManifestFile outputManifestFile) throws NoSuchAlgorithmException {
        Attributes mainAttributes = new Manifest().getMainAttributes();
        mainAttributes.put(Attributes.Name.SIGNATURE_VERSION, "1.0");
        mainAttributes.put(ATTRIBUTE_NAME_CREATED_BY, str);
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(String.valueOf(iIntValue));
            }
            mainAttributes.put(SF_ATTRIBUTE_NAME_ANDROID_APK_SIGNED_NAME, sb.toString());
        }
        MessageDigest messageDigestInstance = getMessageDigestInstance(digestAlgorithm);
        mainAttributes.putValue(getManifestDigestAttributeName(digestAlgorithm), Base64.encodeToString(messageDigestInstance.digest(outputManifestFile.contents), 2));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            SignatureFileWriter.writeMainSection(byteArrayOutputStream, mainAttributes);
            String entryDigestAttributeName = getEntryDigestAttributeName(digestAlgorithm);
            for (Map.Entry<String, byte[]> entry : outputManifestFile.individualSectionsContents.entrySet()) {
                String key = entry.getKey();
                byte[] bArrDigest = messageDigestInstance.digest(entry.getValue());
                Attributes attributes = new Attributes();
                attributes.putValue(entryDigestAttributeName, Base64.encodeToString(bArrDigest, 2));
                try {
                    SignatureFileWriter.writeIndividualSection(byteArrayOutputStream, key, attributes);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to write in-memory .SF file", e);
                }
            }
            if (byteArrayOutputStream.size() > 0 && byteArrayOutputStream.size() % 1024 == 0) {
                try {
                    SignatureFileWriter.writeSectionDelimiter(byteArrayOutputStream);
                } catch (IOException e2) {
                    throw new RuntimeException("Failed to write to ByteArrayOutputStream", e2);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e3) {
            throw new RuntimeException("Failed to write in-memory .SF file", e3);
        }
    }

    public static String getEntryDigestAttributeName(DigestAlgorithm digestAlgorithm) {
        int i = C09081.$SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[digestAlgorithm.ordinal()];
        if (i == 1) {
            return "SHA1-Digest";
        }
        if (i == 2) {
            return "SHA-256-Digest";
        }
        throw new IllegalArgumentException("Unexpected content digest algorithm: " + digestAlgorithm);
    }

    public static String getJcaMessageDigestAlgorithm(DigestAlgorithm digestAlgorithm) {
        return digestAlgorithm.getJcaMessageDigestAlgorithm();
    }

    public static String getManifestDigestAttributeName(DigestAlgorithm digestAlgorithm) {
        int i = C09081.$SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[digestAlgorithm.ordinal()];
        if (i == 1) {
            return "SHA1-Digest-Manifest";
        }
        if (i == 2) {
            return "SHA-256-Digest-Manifest";
        }
        throw new IllegalArgumentException("Unexpected content digest algorithm: " + digestAlgorithm);
    }

    public static MessageDigest getMessageDigestInstance(DigestAlgorithm digestAlgorithm) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(digestAlgorithm.getJcaMessageDigestAlgorithm());
    }

    public static Set<String> getOutputEntryNames(List<SignerConfig> list) {
        HashSet hashSet = new HashSet((list.size() * 2) + 1);
        for (SignerConfig signerConfig : list) {
            String str = signerConfig.name;
            hashSet.add("META-INF/" + str + ".SF");
            hashSet.add("META-INF/" + str + Deobfuscator.CLASS_NAME_SEPARATOR + signerConfig.certificates.get(0).getPublicKey().getAlgorithm().toUpperCase(Locale.US));
        }
        hashSet.add("META-INF/MANIFEST.MF");
        return hashSet;
    }

    public static String getSafeSignerName(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Empty name");
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toUpperCase(Locale.US).toCharArray();
        for (int i = 0; i < Math.min(charArray.length, 8); i++) {
            char c = charArray[i];
            if ((c < 'A' || c > 'Z') && !((c >= '0' && c <= '9') || c == '-' || c == '_')) {
                sb.append('_');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static DigestAlgorithm getSuggestedSignatureDigestAlgorithm(PublicKey publicKey, int i) throws InvalidKeyException {
        String algorithm = publicKey.getAlgorithm();
        if ("RSA".equalsIgnoreCase(algorithm)) {
            return i < 18 ? DigestAlgorithm.SHA1 : DigestAlgorithm.SHA256;
        }
        if ("DSA".equalsIgnoreCase(algorithm)) {
            return i < 21 ? DigestAlgorithm.SHA1 : DigestAlgorithm.SHA256;
        }
        if ("EC".equalsIgnoreCase(algorithm)) {
            if (i >= 18) {
                return DigestAlgorithm.SHA256;
            }
            throw new InvalidKeyException("ECDSA signatures only supported for minSdkVersion 18 and higher");
        }
        throw new InvalidKeyException("Unsupported key algorithm: " + algorithm);
    }

    public static boolean isJarEntryDigestNeededInManifest(String str) {
        if (str.endsWith("/")) {
            return false;
        }
        if (!str.startsWith("META-INF/") || str.indexOf(47, 9) != -1) {
            return true;
        }
        String lowerCase = str.substring(9).toLowerCase(Locale.US);
        return ("manifest.mf".equals(lowerCase) || lowerCase.endsWith(".sf") || lowerCase.endsWith(".rsa") || lowerCase.endsWith(".dsa") || lowerCase.endsWith(".ec") || lowerCase.startsWith("sig-")) ? false : true;
    }

    public static List<Pair<String, byte[]>> sign(List<SignerConfig> list, DigestAlgorithm digestAlgorithm, Map<String, byte[]> map, List<Integer> list2, byte[] bArr, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, ApkFormatException, CertificateException {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one signer config must be provided");
        }
        return signManifest(list, digestAlgorithm, list2, str, generateManifestFile(digestAlgorithm, map, bArr));
    }

    public static List<Pair<String, byte[]>> signManifest(List<SignerConfig> list, DigestAlgorithm digestAlgorithm, List<Integer> list2, String str, OutputManifestFile outputManifestFile) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one signer config must be provided");
        }
        ArrayList arrayList = new ArrayList((list.size() * 2) + 1);
        byte[] bArrGenerateSignatureFile = generateSignatureFile(list2, digestAlgorithm, str, outputManifestFile);
        for (SignerConfig signerConfig : list) {
            String str2 = signerConfig.name;
            try {
                byte[] bArrGenerateSignatureBlock = generateSignatureBlock(signerConfig, bArrGenerateSignatureFile);
                arrayList.add(Pair.m2038of("META-INF/" + str2 + ".SF", bArrGenerateSignatureFile));
                arrayList.add(Pair.m2038of("META-INF/" + str2 + Deobfuscator.CLASS_NAME_SEPARATOR + signerConfig.certificates.get(0).getPublicKey().getAlgorithm().toUpperCase(Locale.US), bArrGenerateSignatureBlock));
            } catch (InvalidKeyException e) {
                throw new InvalidKeyException("Failed to sign using signer \"" + str2 + "\"", e);
            } catch (SignatureException e2) {
                throw new SignatureException("Failed to sign using signer \"" + str2 + "\"", e2);
            } catch (CertificateException e3) {
                throw new CertificateException("Failed to sign using signer \"" + str2 + "\"", e3);
            }
        }
        arrayList.add(Pair.m2038of("META-INF/MANIFEST.MF", outputManifestFile.contents));
        return arrayList;
    }
}
