package com.android.apksig.internal.zip;

import com.android.apksig.zip.ZipFormatException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class CentralDirectoryRecord {
    public static final Comparator<CentralDirectoryRecord> BY_LOCAL_FILE_HEADER_OFFSET_COMPARATOR = new ByLocalFileHeaderOffsetComparator();
    public final long mCompressedSize;
    public final short mCompressionMethod;
    public final long mCrc32;
    public final ByteBuffer mData;
    public final short mGpFlags;
    public final int mLastModificationDate;
    public final int mLastModificationTime;
    public final long mLocalFileHeaderOffset;
    public final String mName;
    public final int mNameSizeBytes;
    public final long mUncompressedSize;

    public static class ByLocalFileHeaderOffsetComparator implements Comparator<CentralDirectoryRecord> {
        public ByLocalFileHeaderOffsetComparator() {
        }

        @Override // java.util.Comparator
        public int compare(CentralDirectoryRecord centralDirectoryRecord, CentralDirectoryRecord centralDirectoryRecord2) {
            long localFileHeaderOffset = centralDirectoryRecord.getLocalFileHeaderOffset();
            long localFileHeaderOffset2 = centralDirectoryRecord2.getLocalFileHeaderOffset();
            if (localFileHeaderOffset > localFileHeaderOffset2) {
                return 1;
            }
            return localFileHeaderOffset < localFileHeaderOffset2 ? -1 : 0;
        }
    }

    public CentralDirectoryRecord(ByteBuffer byteBuffer, short s, short s2, int i, int i2, long j, long j2, long j3, long j4, String str, int i3) {
        this.mData = byteBuffer;
        this.mGpFlags = s;
        this.mCompressionMethod = s2;
        this.mLastModificationDate = i2;
        this.mLastModificationTime = i;
        this.mCrc32 = j;
        this.mCompressedSize = j2;
        this.mUncompressedSize = j3;
        this.mLocalFileHeaderOffset = j4;
        this.mName = str;
        this.mNameSizeBytes = i3;
    }

    public static CentralDirectoryRecord createWithDeflateCompressedData(String str, int i, int i2, long j, long j2, long j3, long j4) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 46);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(33639248);
        ZipUtils.putUnsignedInt16(byteBufferAllocate, 20);
        ZipUtils.putUnsignedInt16(byteBufferAllocate, 20);
        byteBufferAllocate.putShort(ZipUtils.GP_FLAG_EFS);
        byteBufferAllocate.putShort((short) 8);
        ZipUtils.putUnsignedInt16(byteBufferAllocate, i);
        ZipUtils.putUnsignedInt16(byteBufferAllocate, i2);
        ZipUtils.putUnsignedInt32(byteBufferAllocate, j);
        ZipUtils.putUnsignedInt32(byteBufferAllocate, j2);
        ZipUtils.putUnsignedInt32(byteBufferAllocate, j3);
        ZipUtils.putUnsignedInt16(byteBufferAllocate, bytes.length);
        ZipUtils.putUnsignedInt16(byteBufferAllocate, 0);
        ZipUtils.putUnsignedInt16(byteBufferAllocate, 0);
        ZipUtils.putUnsignedInt16(byteBufferAllocate, 0);
        ZipUtils.putUnsignedInt16(byteBufferAllocate, 0);
        ZipUtils.putUnsignedInt32(byteBufferAllocate, 0L);
        ZipUtils.putUnsignedInt32(byteBufferAllocate, j4);
        byteBufferAllocate.put(bytes);
        if (!byteBufferAllocate.hasRemaining()) {
            byteBufferAllocate.flip();
            return new CentralDirectoryRecord(byteBufferAllocate, ZipUtils.GP_FLAG_EFS, (short) 8, i, i2, j, j2, j3, j4, str, bytes.length);
        }
        throw new RuntimeException("pos: " + byteBufferAllocate.position() + ", limit: " + byteBufferAllocate.limit());
    }

    public static String getName(ByteBuffer byteBuffer, int i, int i2) {
        byte[] bArrArray;
        int iArrayOffset;
        if (byteBuffer.hasArray()) {
            bArrArray = byteBuffer.array();
            iArrayOffset = byteBuffer.arrayOffset() + i;
        } else {
            bArrArray = new byte[i2];
            int iPosition = byteBuffer.position();
            try {
                byteBuffer.position(i);
                byteBuffer.get(bArrArray);
                byteBuffer.position(iPosition);
                iArrayOffset = 0;
            } catch (Throwable th) {
                byteBuffer.position(iPosition);
                throw th;
            }
        }
        return new String(bArrArray, iArrayOffset, i2, Charset.forName("UTF-8"));
    }

    public static CentralDirectoryRecord getRecord(ByteBuffer byteBuffer) throws ZipFormatException {
        ZipUtils.assertByteOrderLittleEndian(byteBuffer);
        if (byteBuffer.remaining() < 46) {
            throw new ZipFormatException("Input too short. Need at least: 46 bytes, available: " + byteBuffer.remaining() + " bytes", new BufferUnderflowException());
        }
        int iPosition = byteBuffer.position();
        int i = byteBuffer.getInt();
        if (i != 33639248) {
            throw new ZipFormatException("Not a Central Directory record. Signature: 0x" + Long.toHexString(((long) i) & 4294967295L));
        }
        byteBuffer.position(iPosition + 8);
        short s = byteBuffer.getShort();
        short s2 = byteBuffer.getShort();
        int unsignedInt16 = ZipUtils.getUnsignedInt16(byteBuffer);
        int unsignedInt162 = ZipUtils.getUnsignedInt16(byteBuffer);
        long unsignedInt32 = ZipUtils.getUnsignedInt32(byteBuffer);
        long unsignedInt322 = ZipUtils.getUnsignedInt32(byteBuffer);
        long unsignedInt323 = ZipUtils.getUnsignedInt32(byteBuffer);
        int unsignedInt163 = ZipUtils.getUnsignedInt16(byteBuffer);
        int unsignedInt164 = ZipUtils.getUnsignedInt16(byteBuffer);
        int unsignedInt165 = ZipUtils.getUnsignedInt16(byteBuffer);
        byteBuffer.position(iPosition + 42);
        long unsignedInt324 = ZipUtils.getUnsignedInt32(byteBuffer);
        byteBuffer.position(iPosition);
        int i2 = unsignedInt163 + 46 + unsignedInt164 + unsignedInt165;
        if (i2 > byteBuffer.remaining()) {
            throw new ZipFormatException("Input too short. Need: " + i2 + " bytes, available: " + byteBuffer.remaining() + " bytes", new BufferUnderflowException());
        }
        String name = getName(byteBuffer, iPosition + 46, unsignedInt163);
        byteBuffer.position(iPosition);
        int iLimit = byteBuffer.limit();
        int i3 = iPosition + i2;
        try {
            byteBuffer.limit(i3);
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBuffer.limit(iLimit);
            byteBuffer.position(i3);
            return new CentralDirectoryRecord(byteBufferSlice, s, s2, unsignedInt16, unsignedInt162, unsignedInt32, unsignedInt322, unsignedInt323, unsignedInt324, name, unsignedInt163);
        } catch (Throwable th) {
            byteBuffer.limit(iLimit);
            throw th;
        }
    }

    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.mData.slice());
    }

    public CentralDirectoryRecord createWithModifiedLocalFileHeaderOffset(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.mData.remaining());
        byteBufferAllocate.put(this.mData.slice());
        byteBufferAllocate.flip();
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        ZipUtils.setUnsignedInt32(byteBufferAllocate, 42, j);
        return new CentralDirectoryRecord(byteBufferAllocate, this.mGpFlags, this.mCompressionMethod, this.mLastModificationTime, this.mLastModificationDate, this.mCrc32, this.mCompressedSize, this.mUncompressedSize, j, this.mName, this.mNameSizeBytes);
    }

    public long getCompressedSize() {
        return this.mCompressedSize;
    }

    public short getCompressionMethod() {
        return this.mCompressionMethod;
    }

    public long getCrc32() {
        return this.mCrc32;
    }

    public short getGpFlags() {
        return this.mGpFlags;
    }

    public int getLastModificationDate() {
        return this.mLastModificationDate;
    }

    public int getLastModificationTime() {
        return this.mLastModificationTime;
    }

    public long getLocalFileHeaderOffset() {
        return this.mLocalFileHeaderOffset;
    }

    public String getName() {
        return this.mName;
    }

    public int getNameSizeBytes() {
        return this.mNameSizeBytes;
    }

    public int getSize() {
        return this.mData.remaining();
    }

    public long getUncompressedSize() {
        return this.mUncompressedSize;
    }
}
