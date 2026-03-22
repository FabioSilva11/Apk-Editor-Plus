package com.android.apksig.internal.util;

/* JADX INFO: loaded from: classes.dex */
public final class Pair<A, B> {
    public final A mFirst;
    public final B mSecond;

    public Pair(A a2, B b2) {
        this.mFirst = a2;
        this.mSecond = b2;
    }

    /* JADX INFO: renamed from: of */
    public static <A, B> Pair<A, B> m2038of(A a2, B b2) {
        return new Pair<>(a2, b2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Pair.class != obj.getClass()) {
            return false;
        }
        Pair pair = (Pair) obj;
        A a2 = this.mFirst;
        if (a2 == null) {
            if (pair.mFirst != null) {
                return false;
            }
        } else if (!a2.equals(pair.mFirst)) {
            return false;
        }
        B b2 = this.mSecond;
        if (b2 == null) {
            if (pair.mSecond != null) {
                return false;
            }
        } else if (!b2.equals(pair.mSecond)) {
            return false;
        }
        return true;
    }

    public A getFirst() {
        return this.mFirst;
    }

    public B getSecond() {
        return this.mSecond;
    }

    public int hashCode() {
        A a2 = this.mFirst;
        int iHashCode = ((a2 == null ? 0 : a2.hashCode()) + 31) * 31;
        B b2 = this.mSecond;
        return iHashCode + (b2 != null ? b2.hashCode() : 0);
    }
}
