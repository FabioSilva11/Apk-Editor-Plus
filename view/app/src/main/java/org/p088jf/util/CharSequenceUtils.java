package org.p088jf.util;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CharSequenceUtils {
    public static final Function<Object, String> TO_STRING = Functions.toStringFunction();

    public static boolean listEquals(List<? extends CharSequence> list, List<? extends CharSequence> list2) {
        Function<Object, String> function = TO_STRING;
        return Lists.transform(list, function).equals(Lists.transform(list2, function));
    }
}
