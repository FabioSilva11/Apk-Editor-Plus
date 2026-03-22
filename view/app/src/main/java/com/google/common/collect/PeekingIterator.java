package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public interface PeekingIterator<E> extends Iterator<E> {
    @Override // java.util.Iterator
    E next();

    E peek();
}
