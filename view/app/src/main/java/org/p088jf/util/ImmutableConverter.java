package org.p088jf.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableConverter<ImmutableItem, Item> {
    public abstract boolean isImmutable(Item item);

    public abstract ImmutableItem makeImmutable(Item item);

    public ImmutableList<ImmutableItem> toList(Iterable<? extends Item> iterable) {
        if (iterable == null) {
            return ImmutableList.m3778of();
        }
        boolean z = false;
        boolean z2 = true;
        if (iterable instanceof ImmutableList) {
            Iterator<? extends Item> it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!isImmutable(it.next())) {
                    z = true;
                    break;
                }
            }
            z2 = z;
        }
        if (!z2) {
            return (ImmutableList) iterable;
        }
        final Iterator<? extends Item> it2 = iterable.iterator();
        return ImmutableList.copyOf(new Iterator<ImmutableItem>() { // from class: org.jf.util.ImmutableConverter.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it2.hasNext();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public ImmutableItem next() {
                return (ImmutableItem) ImmutableConverter.this.makeImmutable(it2.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                it2.remove();
            }
        });
    }

    public ImmutableSet<ImmutableItem> toSet(Iterable<? extends Item> iterable) {
        if (iterable == null) {
            return ImmutableSet.m3782of();
        }
        boolean z = false;
        boolean z2 = true;
        if (iterable instanceof ImmutableSet) {
            Iterator<? extends Item> it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!isImmutable(it.next())) {
                    z = true;
                    break;
                }
            }
            z2 = z;
        }
        if (!z2) {
            return (ImmutableSet) iterable;
        }
        final Iterator<? extends Item> it2 = iterable.iterator();
        return ImmutableSet.copyOf(new Iterator<ImmutableItem>() { // from class: org.jf.util.ImmutableConverter.2
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it2.hasNext();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public ImmutableItem next() {
                return (ImmutableItem) ImmutableConverter.this.makeImmutable(it2.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                it2.remove();
            }
        });
    }

    public ImmutableSortedSet<ImmutableItem> toSortedSet(Comparator<? super ImmutableItem> comparator, Iterable<? extends Item> iterable) {
        if (iterable == null) {
            return ImmutableSortedSet.m3785of();
        }
        boolean z = false;
        boolean z2 = true;
        if ((iterable instanceof ImmutableSortedSet) && ((ImmutableSortedSet) iterable).comparator().equals(comparator)) {
            Iterator<? extends Item> it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!isImmutable(it.next())) {
                    z = true;
                    break;
                }
            }
            z2 = z;
        }
        if (!z2) {
            return (ImmutableSortedSet) iterable;
        }
        final Iterator<? extends Item> it2 = iterable.iterator();
        return ImmutableSortedSet.copyOf(comparator, new Iterator<ImmutableItem>() { // from class: org.jf.util.ImmutableConverter.3
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it2.hasNext();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public ImmutableItem next() {
                return (ImmutableItem) ImmutableConverter.this.makeImmutable(it2.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                it2.remove();
            }
        });
    }
}
