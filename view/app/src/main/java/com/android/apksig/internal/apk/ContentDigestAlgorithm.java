package com.android.apksig.internal.apk;

/* JADX INFO: loaded from: classes.dex */
public enum ContentDigestAlgorithm {
    CHUNKED_SHA256(1, "SHA-256", 32),
    CHUNKED_SHA512(2, "SHA-512", 64),
    VERITY_CHUNKED_SHA256(3, "SHA-256", 32),
    SHA256(4, "SHA-256", 32);

    public final int mChunkDigestOutputSizeBytes;
    public final int mId;
    public final String mJcaMessageDigestAlgorithm;

    ContentDigestAlgorithm(int i, String str, int i2) {
        this.mId = i;
        this.mJcaMessageDigestAlgorithm = str;
        this.mChunkDigestOutputSizeBytes = i2;
    }

    public int getChunkDigestOutputSizeBytes() {
        return this.mChunkDigestOutputSizeBytes;
    }

    public int getId() {
        return this.mId;
    }

    public String getJcaMessageDigestAlgorithm() {
        return this.mJcaMessageDigestAlgorithm;
    }
}
