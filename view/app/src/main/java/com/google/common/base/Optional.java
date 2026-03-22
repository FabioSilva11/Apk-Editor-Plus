package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class Optional<T> implements Serializable {
    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    /* JADX INFO: renamed from: of */
    public static <T> Optional<T> m3776of(T t) {
        return new Present(Preconditions.checkNotNull(t));
    }

    /* JADX INFO: renamed from: or */
    public abstract T mo3774or(T t);
}
