package org.p088jf.dexlib2.util;

import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Iterator;
import org.p088jf.dexlib2.AccessFlags;
import org.p088jf.dexlib2.iface.Method;
import org.p088jf.dexlib2.iface.reference.MethodReference;

/* JADX INFO: loaded from: classes.dex */
public final class MethodUtil {
    public static int directMask = (AccessFlags.STATIC.getValue() | AccessFlags.PRIVATE.getValue()) | AccessFlags.CONSTRUCTOR.getValue();
    public static Predicate<Method> METHOD_IS_DIRECT = new Predicate<Method>() { // from class: org.jf.dexlib2.util.MethodUtil.1
        @Override // com.google.common.base.Predicate
        public boolean apply(Method method) {
            return method != null && MethodUtil.isDirect(method);
        }
    };
    public static Predicate<Method> METHOD_IS_VIRTUAL = new Predicate<Method>() { // from class: org.jf.dexlib2.util.MethodUtil.2
        @Override // com.google.common.base.Predicate
        public boolean apply(Method method) {
            return (method == null || MethodUtil.isDirect(method)) ? false : true;
        }
    };

    public static int getParameterRegisterCount(Collection<? extends CharSequence> collection, boolean z) {
        Iterator<? extends CharSequence> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            char cCharAt = it.next().charAt(0);
            i = (cCharAt == 'J' || cCharAt == 'D') ? i + 2 : i + 1;
        }
        return !z ? i + 1 : i;
    }

    public static int getParameterRegisterCount(Method method) {
        return getParameterRegisterCount(method, isStatic(method));
    }

    public static int getParameterRegisterCount(MethodReference methodReference, boolean z) {
        return getParameterRegisterCount(methodReference.getParameterTypes(), z);
    }

    public static String getShorty(Collection<? extends CharSequence> collection, String str) {
        StringBuilder sb = new StringBuilder(collection.size() + 1);
        sb.append(getShortyType(str));
        Iterator<? extends CharSequence> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(getShortyType(it.next()));
        }
        return sb.toString();
    }

    public static char getShortyType(CharSequence charSequence) {
        if (charSequence.length() > 1) {
            return 'L';
        }
        return charSequence.charAt(0);
    }

    public static boolean isConstructor(MethodReference methodReference) {
        return methodReference.getName().equals("<init>");
    }

    public static boolean isDirect(Method method) {
        return (method.getAccessFlags() & directMask) != 0;
    }

    public static boolean isStatic(Method method) {
        return AccessFlags.STATIC.isSet(method.getAccessFlags());
    }
}
