package org.p088jf.dexlib2.dexbacked.util;

import com.google.common.collect.AbstractIterator;
import org.p088jf.dexlib2.dexbacked.DexBuffer;
import org.p088jf.dexlib2.dexbacked.DexReader;

/* JADX WARN: Unexpected interfaces in signature: [java.util.Iterator<T>] */
/* JADX INFO: loaded from: classes.dex */
public abstract class VariableSizeLookaheadIterator<T> extends AbstractIterator<T> {
    public final DexReader reader;

    public VariableSizeLookaheadIterator(DexBuffer dexBuffer, int i) {
        this.reader = dexBuffer.readerAt(i);
    }

    @Override // com.google.common.collect.AbstractIterator
    public T computeNext() {
        return readNextItem(this.reader);
    }

    public abstract T readNextItem(DexReader dexReader);
}
