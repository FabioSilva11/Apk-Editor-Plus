package org.p088jf.dexlib2.dexbacked.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class FixedSizeSet<T> extends AbstractSet<T> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        return new Iterator<T>() { // from class: org.jf.dexlib2.dexbacked.util.FixedSizeSet.1
            public int index = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < FixedSizeSet.this.size();
            }

            @Override // java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                FixedSizeSet fixedSizeSet = FixedSizeSet.this;
                int i = this.index;
                this.index = i + 1;
                return (T) fixedSizeSet.readItem(i);
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public abstract T readItem(int i);
}
