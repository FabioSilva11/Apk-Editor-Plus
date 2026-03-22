package android.support.v4.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class Pair {

    @Nullable
    public final Object first;

    @Nullable
    public final Object second;

    public Pair(@Nullable Object obj, @Nullable Object obj2) {
        this.first = obj;
        this.second = obj2;
    }

    @NonNull
    public static Pair create(@Nullable Object obj, @Nullable Object obj2) {
        return new Pair(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.equals(pair.first, this.first) && ObjectsCompat.equals(pair.second, this.second);
    }

    public int hashCode() {
        return (this.first == null ? 0 : this.first.hashCode()) ^ (this.second != null ? this.second.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
    }
}
