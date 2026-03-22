package org.p088jf.dexlib2.dexbacked.util;

import java.util.AbstractList;

/* JADX INFO: loaded from: classes.dex */
public abstract class FixedSizeList<T> extends AbstractList<T> {
    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return readItem(i);
    }

    public abstract T readItem(int i);
}
