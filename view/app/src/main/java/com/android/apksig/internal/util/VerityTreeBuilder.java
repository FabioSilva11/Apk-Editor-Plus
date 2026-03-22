package com.android.apksig.internal.util;

import android.annotation.TargetApi;
import android.support.v4.media.session.PlaybackStateCompat;
import com.android.apksig.internal.zip.ZipUtils;
import com.android.apksig.util.DataSink;
import com.android.apksig.util.DataSource;
import com.android.apksig.util.DataSources;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class VerityTreeBuilder implements Closeable {
    public static final int DIGEST_PARALLELISM = Math.min(32, Runtime.getRuntime().availableProcessors());
    public final ExecutorService mExecutor;
    public final MessageDigest mMd;
    public final byte[] mSalt;

    public VerityTreeBuilder(byte[] bArr) throws NoSuchAlgorithmException {
        int i = DIGEST_PARALLELISM;
        this.mExecutor = new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(4), new ThreadPoolExecutor.CallerRunsPolicy());
        this.mSalt = bArr;
        this.mMd = getNewMessageDigest();
    }

    public static int[] calculateLevelOffset(long j, int i) {
        ArrayList arrayList = new ArrayList();
        do {
            j = divideRoundup(j, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) * ((long) i);
            arrayList.add(Long.valueOf(divideRoundup(j, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) * PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        } while (j > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        int[] iArr = new int[arrayList.size() + 1];
        int i2 = 0;
        iArr[0] = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            iArr[i3] = iArr[i2] + MathCompat.toIntExact(((Long) arrayList.get((arrayList.size() - i2) - 1)).longValue());
            i2 = i3;
        }
        return iArr;
    }

    public static long divideRoundup(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static MessageDigest getNewMessageDigest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256");
    }

    public static ByteBuffer slice(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.limit(i2);
        byteBufferDuplicate.position(i);
        return byteBufferDuplicate.slice();
    }

    public final MessageDigest cloneMessageDigest() {
        try {
            try {
                return (MessageDigest) this.mMd.clone();
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException("Failed to obtain an instance of a previously available message digest", e);
            }
        } catch (CloneNotSupportedException unused) {
            return getNewMessageDigest();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mExecutor.shutdownNow();
    }

    @TargetApi(21)
    public final void digestDataByChunks(DataSource dataSource, DataSink dataSink) throws IOException {
        long size = dataSource.size();
        long j = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        int iDivideRoundup = (int) divideRoundup(size, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        final byte[][] bArr = new byte[iDivideRoundup][];
        final Phaser phaser = new Phaser(1);
        long j2 = 0;
        int i = 0;
        while (j2 < size) {
            int iMin = (int) (Math.min(4194304 + j2, size) - j2);
            long j3 = iMin;
            int iDivideRoundup2 = (int) divideRoundup(j3, j);
            final ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iDivideRoundup2 * 4096);
            dataSource.copyTo(j2, iMin, byteBufferAllocate);
            byteBufferAllocate.rewind();
            final int i2 = i;
            Runnable runnable = new Runnable() { // from class: com.android.apksig.internal.util.VerityTreeBuilder.1
                @Override // java.lang.Runnable
                public void run() {
                    MessageDigest messageDigestCloneMessageDigest = VerityTreeBuilder.this.cloneMessageDigest();
                    int iCapacity = byteBufferAllocate.capacity();
                    int i3 = i2;
                    int i4 = 0;
                    while (i4 < iCapacity) {
                        int i5 = i4 + 4096;
                        bArr[i3] = VerityTreeBuilder.this.saltedDigest(messageDigestCloneMessageDigest, VerityTreeBuilder.slice(byteBufferAllocate, i4, i5));
                        i3++;
                        i4 = i5;
                    }
                    phaser.arriveAndDeregister();
                }
            };
            phaser.register();
            this.mExecutor.execute(runnable);
            i += iDivideRoundup2;
            j2 += j3;
            j = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        phaser.arriveAndAwaitAdvance();
        for (int i3 = 0; i3 < iDivideRoundup; i3++) {
            byte[] bArr2 = bArr[i3];
            dataSink.consume(bArr2, 0, bArr2.length);
        }
    }

    public ByteBuffer generateVerityTree(DataSource dataSource) throws IOException {
        DataSource dataSourceAsDataSource;
        int digestLength = this.mMd.getDigestLength();
        int[] iArrCalculateLevelOffset = calculateLevelOffset(dataSource.size(), digestLength);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iArrCalculateLevelOffset[iArrCalculateLevelOffset.length - 1]);
        for (int length = iArrCalculateLevelOffset.length - 2; length >= 0; length--) {
            int i = length + 1;
            ByteBufferSink byteBufferSink = new ByteBufferSink(slice(byteBufferAllocate, iArrCalculateLevelOffset[length], iArrCalculateLevelOffset[i]));
            if (length == iArrCalculateLevelOffset.length - 2) {
                digestDataByChunks(dataSource, byteBufferSink);
                dataSourceAsDataSource = dataSource;
            } else {
                dataSourceAsDataSource = DataSources.asDataSource(slice(byteBufferAllocate.asReadOnlyBuffer(), iArrCalculateLevelOffset[i], iArrCalculateLevelOffset[length + 2]));
                digestDataByChunks(dataSourceAsDataSource, byteBufferSink);
            }
            int iDivideRoundup = (int) ((divideRoundup(dataSourceAsDataSource.size(), PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) * ((long) digestLength)) % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            if (iDivideRoundup > 0) {
                int i2 = 4096 - iDivideRoundup;
                byteBufferSink.consume(new byte[i2], 0, i2);
            }
        }
        return byteBufferAllocate;
    }

    public byte[] generateVerityTreeRootHash(DataSource dataSource) throws IOException {
        return getRootHashFromTree(generateVerityTree(dataSource));
    }

    public byte[] generateVerityTreeRootHash(DataSource dataSource, DataSource dataSource2, DataSource dataSource3) throws IOException {
        if (dataSource.size() % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
            throw new IllegalStateException("APK Signing Block size not a multiple of 4096: " + dataSource.size());
        }
        long size = dataSource.size();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) dataSource3.size());
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        dataSource3.copyTo(0L, (int) dataSource3.size(), byteBufferAllocate);
        byteBufferAllocate.flip();
        ZipUtils.setZipEocdCentralDirectoryOffset(byteBufferAllocate, size);
        return generateVerityTreeRootHash(new ChainedDataSource(dataSource, dataSource2, DataSources.asDataSource(byteBufferAllocate)));
    }

    public byte[] getRootHashFromTree(ByteBuffer byteBuffer) throws IOException {
        return saltedDigest(slice(byteBuffer.asReadOnlyBuffer(), 0, 4096));
    }

    public final byte[] saltedDigest(ByteBuffer byteBuffer) {
        return saltedDigest(this.mMd, byteBuffer);
    }

    public final byte[] saltedDigest(MessageDigest messageDigest, ByteBuffer byteBuffer) {
        messageDigest.reset();
        byte[] bArr = this.mSalt;
        if (bArr != null) {
            messageDigest.update(bArr);
        }
        messageDigest.update(byteBuffer);
        return messageDigest.digest();
    }
}
