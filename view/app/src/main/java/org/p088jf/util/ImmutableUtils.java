package org.p088jf.util;

import com.google.common.collect.ImmutableList;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableUtils {
    public static <T> ImmutableList<T> nullToEmptyList(ImmutableList<T> immutableList) {
        return immutableList == null ? ImmutableList.m3778of() : immutableList;
    }
}
