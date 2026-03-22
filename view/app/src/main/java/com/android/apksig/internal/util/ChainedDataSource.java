package com.android.apksig.internal.util;

import com.android.apksig.util.DataSink;
import com.android.apksig.util.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ChainedDataSource implements DataSource {
    public final DataSource[] mSources;
    public final long mTotalSize;

    public ChainedDataSource(DataSource... dataSourceArr) {
        this.mSources = dataSourceArr;
        long size = 0;
        if (dataSourceArr != null) {
            for (DataSource dataSource : dataSourceArr) {
                size += dataSource.size();
            }
        }
        this.mTotalSize = size;
    }

    @Override // com.android.apksig.util.DataSource
    public void copyTo(long j, int i, ByteBuffer byteBuffer) throws IOException {
        feed(j, i, new ByteBufferSink(byteBuffer));
    }

    @Override // com.android.apksig.util.DataSource
    public void feed(long j, long j2, DataSink dataSink) throws IOException {
        if (j + j2 > this.mTotalSize) {
            throw new IndexOutOfBoundsException("Requested more than available");
        }
        long size = j;
        for (DataSource dataSource : this.mSources) {
            if (size >= dataSource.size()) {
                size -= dataSource.size();
            } else {
                long size2 = dataSource.size() - size;
                if (size2 >= j2) {
                    dataSource.feed(size, j2, dataSink);
                    return;
                } else {
                    dataSource.feed(size, size2, dataSink);
                    j2 -= size2;
                    size = 0;
                }
            }
        }
    }

    @Override // com.android.apksig.util.DataSource
    public ByteBuffer getByteBuffer(long j, int i) throws IOException {
        long j2 = i;
        if (j + j2 > this.mTotalSize) {
            throw new IndexOutOfBoundsException("Requested more than available");
        }
        Pair<Integer, Long> pairLocateDataSource = locateDataSource(j);
        int iIntValue = pairLocateDataSource.getFirst().intValue();
        long jLongValue = pairLocateDataSource.getSecond().longValue();
        if (j2 + jLongValue <= this.mSources[iIntValue].size()) {
            return this.mSources[iIntValue].getByteBuffer(jLongValue, i);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        while (iIntValue < this.mSources.length && byteBufferAllocate.hasRemaining()) {
            this.mSources[iIntValue].copyTo(jLongValue, MathCompat.toIntExact(Math.min(this.mSources[iIntValue].size() - jLongValue, byteBufferAllocate.remaining())), byteBufferAllocate);
            jLongValue = 0;
            iIntValue++;
        }
        byteBufferAllocate.rewind();
        return byteBufferAllocate;
    }

    public final Pair<Integer, Long> locateDataSource(long j) {
        int i = 0;
        long size = j;
        while (true) {
            DataSource[] dataSourceArr = this.mSources;
            if (i >= dataSourceArr.length) {
                throw new IndexOutOfBoundsException("Access is out of bound, offset: " + j + ", totalSize: " + this.mTotalSize);
            }
            if (size < dataSourceArr[i].size()) {
                return Pair.m2038of(Integer.valueOf(i), Long.valueOf(size));
            }
            size -= this.mSources[i].size();
            i++;
        }
    }

    @Override // com.android.apksig.util.DataSource
    public long size() {
        return this.mTotalSize;
    }

    @Override // com.android.apksig.util.DataSource
    public DataSource slice(long j, long j2) {
        Pair<Integer, Long> pairLocateDataSource = locateDataSource(j);
        int iIntValue = pairLocateDataSource.getFirst().intValue();
        long jLongValue = pairLocateDataSource.getSecond().longValue();
        DataSource dataSource = this.mSources[iIntValue];
        if (jLongValue + j2 <= dataSource.size()) {
            return dataSource.slice(jLongValue, j2);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(dataSource.slice(jLongValue, dataSource.size() - jLongValue));
        Pair<Integer, Long> pairLocateDataSource2 = locateDataSource((j + j2) - 1);
        int iIntValue2 = pairLocateDataSource2.getFirst().intValue();
        long jLongValue2 = pairLocateDataSource2.getSecond().longValue();
        while (true) {
            iIntValue++;
            if (iIntValue >= iIntValue2) {
                arrayList.add(this.mSources[iIntValue2].slice(0L, jLongValue2 + 1));
                return new ChainedDataSource((DataSource[]) arrayList.toArray(new DataSource[0]));
            }
            arrayList.add(this.mSources[iIntValue]);
        }
    }
}
