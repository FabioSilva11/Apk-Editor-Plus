package org.p088jf.dexlib2;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class MethodHandleType {
    public static final BiMap<Integer, String> methodHandleTypeNames = new ImmutableBiMap.Builder().put(0, "static-put").put(1, "static-get").put(2, "instance-put").put(3, "instance-get").put(4, "invoke-static").put(5, "invoke-instance").put(6, "invoke-constructor").put(7, "invoke-direct").put(8, "invoke-interface").build();

    public static class InvalidMethodHandleTypeException extends ExceptionWithContext {
        public InvalidMethodHandleTypeException(int i) {
            super("Invalid method handle type: %d", Integer.valueOf(i));
        }
    }

    public static int getMethodHandleType(String str) {
        Integer num = methodHandleTypeNames.inverse().get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new ExceptionWithContext("Invalid method handle type: %s", str);
    }

    public static String toString(int i) {
        String str = methodHandleTypeNames.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        throw new InvalidMethodHandleTypeException(i);
    }
}
