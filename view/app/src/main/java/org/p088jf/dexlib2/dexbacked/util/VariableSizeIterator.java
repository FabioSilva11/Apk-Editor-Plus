package org.p088jf.dexlib2.dexbacked.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.p088jf.dexlib2.dexbacked.DexBuffer;
import org.p088jf.dexlib2.dexbacked.DexReader;

/* JADX INFO: loaded from: classes.dex */
public abstract class VariableSizeIterator<T> implements Iterator<T> {
    public int index;
    public final DexReader reader;
    public final int size;

    public VariableSizeIterator(DexBuffer dexBuffer, int i, int i2) {
        this.reader = dexBuffer.readerAt(i);
        this.size = i2;
    }

    public VariableSizeIterator(DexReader dexReader, int i) {
        this.reader = dexReader;
        this.size = i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.size;
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.index;
        if (i >= this.size) {
            throw new NoSuchElementException();
        }
        DexReader dexReader = this.reader;
        this.index = i + 1;
        return readNextItem(dexReader, i);
    }

    public abstract T readNextItem(DexReader dexReader, int i);

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
