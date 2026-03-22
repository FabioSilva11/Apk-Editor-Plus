package org.p088jf.dexlib2;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public enum AccessFlags {
    PUBLIC(1, "public", true, true, true),
    PRIVATE(2, "private", true, true, true),
    PROTECTED(4, "protected", true, true, true),
    STATIC(8, "static", true, true, true),
    FINAL(16, "final", true, true, true),
    SYNCHRONIZED(32, "synchronized", false, true, false),
    VOLATILE(64, "volatile", false, false, true),
    BRIDGE(64, "bridge", false, true, false),
    TRANSIENT(128, "transient", false, false, true),
    VARARGS(128, "varargs", false, true, false),
    NATIVE(256, "native", false, true, false),
    INTERFACE(512, "interface", true, false, false),
    ABSTRACT(1024, "abstract", true, true, false),
    STRICTFP(2048, "strictfp", false, true, false),
    SYNTHETIC(4096, "synthetic", true, true, true),
    ANNOTATION(8192, "annotation", true, false, false),
    ENUM(16384, "enum", true, false, true),
    CONSTRUCTOR(65536, "constructor", false, true, false),
    DECLARED_SYNCHRONIZED(131072, "declared-synchronized", false, true, false);

    public static HashMap<String, AccessFlags> accessFlagsByName;
    public static final AccessFlags[] allFlags;
    public String accessFlagName;
    public boolean validForClass;
    public boolean validForField;
    public boolean validForMethod;
    public int value;

    static {
        AccessFlags[] accessFlagsArrValues = values();
        allFlags = accessFlagsArrValues;
        accessFlagsByName = new HashMap<>();
        for (AccessFlags accessFlags : accessFlagsArrValues) {
            accessFlagsByName.put(accessFlags.accessFlagName, accessFlags);
        }
    }

    AccessFlags(int i, String str, boolean z, boolean z2, boolean z3) {
        this.value = i;
        this.accessFlagName = str;
        this.validForClass = z;
        this.validForMethod = z2;
        this.validForField = z3;
    }

    public static AccessFlags getAccessFlag(String str) {
        return accessFlagsByName.get(str);
    }

    public static AccessFlags[] getAccessFlagsForClass(int i) {
        int i2 = 0;
        for (AccessFlags accessFlags : allFlags) {
            if (accessFlags.validForClass && (accessFlags.value & i) != 0) {
                i2++;
            }
        }
        AccessFlags[] accessFlagsArr = new AccessFlags[i2];
        int i3 = 0;
        for (AccessFlags accessFlags2 : allFlags) {
            if (accessFlags2.validForClass && (accessFlags2.value & i) != 0) {
                accessFlagsArr[i3] = accessFlags2;
                i3++;
            }
        }
        return accessFlagsArr;
    }

    public static AccessFlags[] getAccessFlagsForField(int i) {
        int i2 = 0;
        for (AccessFlags accessFlags : allFlags) {
            if (accessFlags.validForField && (accessFlags.value & i) != 0) {
                i2++;
            }
        }
        AccessFlags[] accessFlagsArr = new AccessFlags[i2];
        int i3 = 0;
        for (AccessFlags accessFlags2 : allFlags) {
            if (accessFlags2.validForField && (accessFlags2.value & i) != 0) {
                accessFlagsArr[i3] = accessFlags2;
                i3++;
            }
        }
        return accessFlagsArr;
    }

    public static AccessFlags[] getAccessFlagsForMethod(int i) {
        int i2 = 0;
        for (AccessFlags accessFlags : allFlags) {
            if (accessFlags.validForMethod && (accessFlags.value & i) != 0) {
                i2++;
            }
        }
        AccessFlags[] accessFlagsArr = new AccessFlags[i2];
        int i3 = 0;
        for (AccessFlags accessFlags2 : allFlags) {
            if (accessFlags2.validForMethod && (accessFlags2.value & i) != 0) {
                accessFlagsArr[i3] = accessFlags2;
                i3++;
            }
        }
        return accessFlagsArr;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isSet(int i) {
        return (i & this.value) != 0;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.accessFlagName;
    }
}
