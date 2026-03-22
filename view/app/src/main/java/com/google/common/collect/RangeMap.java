package com.google.common.collect;

import java.lang.Comparable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface RangeMap<K extends Comparable, V> {
    Map<Range<K>, V> asMapOfRanges();

    V get(K k);
}
