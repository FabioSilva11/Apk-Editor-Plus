package org.p088jf.dexlib2.util;

import org.p088jf.dexlib2.iface.reference.TypeReference;

/* JADX INFO: loaded from: classes.dex */
public final class TypeUtils {
    public static boolean isPrimitiveType(String str) {
        return str.length() == 1;
    }

    public static boolean isWideType(String str) {
        char cCharAt = str.charAt(0);
        return cCharAt == 'J' || cCharAt == 'D';
    }

    public static boolean isWideType(TypeReference typeReference) {
        return isWideType(typeReference.getType());
    }
}
