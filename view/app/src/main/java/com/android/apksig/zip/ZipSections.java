package com.android.apksig.zip;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ZipSections {
    public final long mCentralDirectoryOffset;
    public final int mCentralDirectoryRecordCount;
    public final long mCentralDirectorySizeBytes;
    public final ByteBuffer mEocd;
    public final long mEocdOffset;

    public ZipSections(long j, long j2, int i, long j3, ByteBuffer byteBuffer) {
        this.mCentralDirectoryOffset = j;
        this.mCentralDirectorySizeBytes = j2;
        this.mCentralDirectoryRecordCount = i;
        this.mEocdOffset = j3;
        this.mEocd = byteBuffer;
    }

    public long getZipCentralDirectoryOffset() {
        return this.mCentralDirectoryOffset;
    }

    public int getZipCentralDirectoryRecordCount() {
        return this.mCentralDirectoryRecordCount;
    }

    public long getZipCentralDirectorySizeBytes() {
        return this.mCentralDirectorySizeBytes;
    }

    public ByteBuffer getZipEndOfCentralDirectory() {
        return this.mEocd;
    }

    public long getZipEndOfCentralDirectoryOffset() {
        return this.mEocdOffset;
    }
}
