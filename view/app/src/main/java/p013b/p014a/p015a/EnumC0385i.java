package p013b.p014a.p015a;

/* JADX INFO: renamed from: b.a.a.i */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0385i {
    GET,
    PUT,
    POST,
    DELETE,
    HEAD,
    OPTIONS,
    TRACE,
    CONNECT,
    PATCH;

    /* JADX INFO: renamed from: a */
    static EnumC0385i m280a(String str) {
        for (EnumC0385i enumC0385i : (EnumC0385i[]) values().clone()) {
            if (enumC0385i.toString().equalsIgnoreCase(str)) {
                return enumC0385i;
            }
        }
        return null;
    }
}
