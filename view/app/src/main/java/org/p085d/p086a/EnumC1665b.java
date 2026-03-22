package org.p085d.p086a;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: org.d.a.b */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1665b {

    /* JADX INFO: renamed from: a */
    public static final EnumC1665b f4744a = new EnumC1665b("ERROR", 0, 40, "ERROR");

    /* JADX INFO: renamed from: b */
    public static final EnumC1665b f4745b = new EnumC1665b("WARN", 1, 30, "WARN");

    /* JADX INFO: renamed from: c */
    public static final EnumC1665b f4746c = new EnumC1665b("INFO", 2, 20, "INFO");

    /* JADX INFO: renamed from: d */
    public static final EnumC1665b f4747d = new EnumC1665b("DEBUG", 3, 10, "DEBUG");

    /* JADX INFO: renamed from: e */
    private static EnumC1665b f4748e = new EnumC1665b("TRACE", 4, 0, "TRACE");

    /* JADX INFO: renamed from: f */
    private String f4749f;

    static {
        EnumC1665b[] enumC1665bArr = {f4744a, f4745b, f4746c, f4747d, f4748e};
    }

    private EnumC1665b(String str, int i, int i2, String str2) {
        this.f4749f = str2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4749f;
    }
}
