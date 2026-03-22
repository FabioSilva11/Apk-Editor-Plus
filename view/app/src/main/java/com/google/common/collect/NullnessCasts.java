package com.google.common.collect;

/* JADX INFO: loaded from: classes.dex */
public final class NullnessCasts {
    public static <T> T uncheckedCastNullableTToT(T t) {
        return t;
    }

    public static <T> T unsafeNull() {
        return null;
    }
}
