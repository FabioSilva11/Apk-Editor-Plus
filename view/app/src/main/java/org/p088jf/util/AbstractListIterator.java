package org.p088jf.util;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractListIterator<T> implements ListIterator<T> {
    @Override // java.util.ListIterator
    public void add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public void set(T t) {
        throw new UnsupportedOperationException();
    }
}
