package com.android.apksig.internal.apk.p044v1;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public enum DigestAlgorithm {
    SHA1("SHA-1"),
    SHA256("SHA-256");

    public static Comparator<DigestAlgorithm> BY_STRENGTH_COMPARATOR = new StrengthComparator(null);
    public final String mJcaMessageDigestAlgorithm;

    /* JADX INFO: renamed from: com.android.apksig.internal.apk.v1.DigestAlgorithm$1 */
    public static /* synthetic */ class C09071 {
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

    public static class StrengthComparator implements Comparator<DigestAlgorithm> {
        public StrengthComparator() {
        }

        public /* synthetic */ StrengthComparator(C09071 c09071) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(DigestAlgorithm digestAlgorithm, DigestAlgorithm digestAlgorithm2) {
            int[] iArr = C09071.$SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm;
            int i = iArr[digestAlgorithm.ordinal()];
            if (i == 1) {
                int i2 = iArr[digestAlgorithm2.ordinal()];
                if (i2 == 1) {
                    return 0;
                }
                if (i2 == 2) {
                    return -1;
                }
                throw new RuntimeException("Unsupported algorithm: " + digestAlgorithm2);
            }
            if (i != 2) {
                throw new RuntimeException("Unsupported algorithm: " + digestAlgorithm);
            }
            int i3 = iArr[digestAlgorithm2.ordinal()];
            if (i3 == 1) {
                return 1;
            }
            if (i3 == 2) {
                return 0;
            }
            throw new RuntimeException("Unsupported algorithm: " + digestAlgorithm2);
        }
    }

    DigestAlgorithm(String str) {
        this.mJcaMessageDigestAlgorithm = str;
    }

    public String getJcaMessageDigestAlgorithm() {
        return this.mJcaMessageDigestAlgorithm;
    }
}
