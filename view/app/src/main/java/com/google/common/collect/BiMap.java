package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface BiMap<K, V> extends Map<K, V> {
    BiMap<V, K> inverse();
}
