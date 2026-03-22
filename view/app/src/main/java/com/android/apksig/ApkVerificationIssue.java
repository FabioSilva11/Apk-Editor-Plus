package com.android.apksig;

/* JADX INFO: loaded from: classes.dex */
public class ApkVerificationIssue {
    public static final int JAR_SIG_NO_SIGNATURES = 36;
    public static final int JAR_SIG_PARSE_EXCEPTION = 37;
    public static final int MALFORMED_APK = 28;

    /* JADX INFO: renamed from: SOURCE_STAMP_CERTIFICATE_MISMATCH_BETWEEN_SIGNATURE_BLOCK_AND_APK */
    public static final int f2268x995497fb = 27;
    public static final int SOURCE_STAMP_CERT_DIGEST_AND_SIG_BLOCK_MISSING = 25;
    public static final int SOURCE_STAMP_DID_NOT_VERIFY = 21;
    public static final int SOURCE_STAMP_EXPECTED_DIGEST_MISMATCH = 23;
    public static final int SOURCE_STAMP_MALFORMED_ATTRIBUTE = 31;
    public static final int SOURCE_STAMP_MALFORMED_CERTIFICATE = 18;
    public static final int SOURCE_STAMP_MALFORMED_LINEAGE = 33;
    public static final int SOURCE_STAMP_MALFORMED_SIGNATURE = 20;
    public static final int SOURCE_STAMP_NO_SIGNATURE = 17;
    public static final int SOURCE_STAMP_NO_SUPPORTED_SIGNATURE = 26;
    public static final int SOURCE_STAMP_POR_CERT_MISMATCH = 34;
    public static final int SOURCE_STAMP_POR_DID_NOT_VERIFY = 35;
    public static final int SOURCE_STAMP_SIGNATURE_BLOCK_WITHOUT_CERT_DIGEST = 24;
    public static final int SOURCE_STAMP_SIG_MISSING = 30;
    public static final int SOURCE_STAMP_UNKNOWN_ATTRIBUTE = 32;
    public static final int SOURCE_STAMP_UNKNOWN_SIG_ALGORITHM = 19;
    public static final int SOURCE_STAMP_VERIFY_EXCEPTION = 22;
    public static final int UNEXPECTED_EXCEPTION = 29;
    public static final int V2_SIG_MALFORMED_CERTIFICATE = 6;
    public static final int V2_SIG_MALFORMED_DIGEST = 8;
    public static final int V2_SIG_MALFORMED_SIGNATURE = 4;
    public static final int V2_SIG_MALFORMED_SIGNER = 3;
    public static final int V2_SIG_MALFORMED_SIGNERS = 1;
    public static final int V2_SIG_NO_CERTIFICATES = 7;
    public static final int V2_SIG_NO_SIGNATURES = 5;
    public static final int V2_SIG_NO_SIGNERS = 2;
    public static final int V3_SIG_MALFORMED_CERTIFICATE = 14;
    public static final int V3_SIG_MALFORMED_DIGEST = 16;
    public static final int V3_SIG_MALFORMED_SIGNATURE = 12;
    public static final int V3_SIG_MALFORMED_SIGNER = 11;
    public static final int V3_SIG_MALFORMED_SIGNERS = 9;
    public static final int V3_SIG_NO_CERTIFICATES = 15;
    public static final int V3_SIG_NO_SIGNATURES = 13;
    public static final int V3_SIG_NO_SIGNERS = 10;
    public final String mFormat;
    public final int mIssueId;
    public final Object[] mParams;

    public ApkVerificationIssue(int i, Object... objArr) {
        this.mIssueId = i;
        this.mFormat = null;
        this.mParams = objArr;
    }

    public ApkVerificationIssue(String str, Object... objArr) {
        this.mIssueId = -1;
        this.mFormat = str;
        this.mParams = objArr;
    }

    public int getIssueId() {
        return this.mIssueId;
    }

    public Object[] getParams() {
        return this.mParams;
    }

    public String toString() {
        String str = this.mFormat;
        if (str != null) {
            return String.format(str, this.mParams);
        }
        StringBuilder sb = new StringBuilder("mIssueId: ");
        sb.append(this.mIssueId);
        for (Object obj : this.mParams) {
            sb.append(", ");
            sb.append(obj.toString());
        }
        return sb.toString();
    }
}
