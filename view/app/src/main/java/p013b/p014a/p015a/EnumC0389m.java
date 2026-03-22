package p013b.p014a.p015a;

import android.support.v7.appcompat.C0299R;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: b.a.a.m */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0389m implements InterfaceC0388l {

    /* JADX INFO: renamed from: u */
    private final int f324u;

    /* JADX INFO: renamed from: v */
    private final String f325v;

    /* JADX INFO: renamed from: e */
    private static EnumC0389m f308e = new EnumC0389m("SWITCH_PROTOCOL", 0, C0299R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle, "Switching Protocols");

    /* JADX INFO: renamed from: a */
    public static final EnumC0389m f304a = new EnumC0389m("OK", 1, 200, "OK");

    /* JADX INFO: renamed from: f */
    private static EnumC0389m f309f = new EnumC0389m("CREATED", 2, 201, "Created");

    /* JADX INFO: renamed from: g */
    private static EnumC0389m f310g = new EnumC0389m("ACCEPTED", 3, 202, "Accepted");

    /* JADX INFO: renamed from: h */
    private static EnumC0389m f311h = new EnumC0389m("NO_CONTENT", 4, 204, "No Content");

    /* JADX INFO: renamed from: i */
    private static EnumC0389m f312i = new EnumC0389m("PARTIAL_CONTENT", 5, 206, "Partial Content");

    /* JADX INFO: renamed from: j */
    private static EnumC0389m f313j = new EnumC0389m("REDIRECT", 6, 301, "Moved Permanently");

    /* JADX INFO: renamed from: k */
    private static EnumC0389m f314k = new EnumC0389m("NOT_MODIFIED", 7, 304, "Not Modified");

    /* JADX INFO: renamed from: b */
    public static final EnumC0389m f305b = new EnumC0389m("BAD_REQUEST", 8, 400, "Bad Request");

    /* JADX INFO: renamed from: l */
    private static EnumC0389m f315l = new EnumC0389m("UNAUTHORIZED", 9, 401, "Unauthorized");

    /* JADX INFO: renamed from: m */
    private static EnumC0389m f316m = new EnumC0389m("FORBIDDEN", 10, 403, "Forbidden");

    /* JADX INFO: renamed from: c */
    public static final EnumC0389m f306c = new EnumC0389m("NOT_FOUND", 11, 404, "Not Found");

    /* JADX INFO: renamed from: n */
    private static EnumC0389m f317n = new EnumC0389m("METHOD_NOT_ALLOWED", 12, 405, "Method Not Allowed");

    /* JADX INFO: renamed from: o */
    private static EnumC0389m f318o = new EnumC0389m("NOT_ACCEPTABLE", 13, 406, "Not Acceptable");

    /* JADX INFO: renamed from: p */
    private static EnumC0389m f319p = new EnumC0389m("REQUEST_TIMEOUT", 14, 408, "Request Timeout");

    /* JADX INFO: renamed from: q */
    private static EnumC0389m f320q = new EnumC0389m("CONFLICT", 15, 409, "Conflict");

    /* JADX INFO: renamed from: r */
    private static EnumC0389m f321r = new EnumC0389m("RANGE_NOT_SATISFIABLE", 16, 416, "Requested Range Not Satisfiable");

    /* JADX INFO: renamed from: d */
    public static final EnumC0389m f307d = new EnumC0389m("INTERNAL_ERROR", 17, 500, "Internal Server Error");

    /* JADX INFO: renamed from: s */
    private static EnumC0389m f322s = new EnumC0389m("NOT_IMPLEMENTED", 18, 501, "Not Implemented");

    /* JADX INFO: renamed from: t */
    private static EnumC0389m f323t = new EnumC0389m("UNSUPPORTED_HTTP_VERSION", 19, 505, "HTTP Version Not Supported");

    static {
        EnumC0389m[] enumC0389mArr = {f308e, f304a, f309f, f310g, f311h, f312i, f313j, f314k, f305b, f315l, f316m, f306c, f317n, f318o, f319p, f320q, f321r, f307d, f322s, f323t};
    }

    private EnumC0389m(String str, int i, int i2, String str2) {
        this.f324u = i2;
        this.f325v = str2;
    }

    @Override // p013b.p014a.p015a.InterfaceC0388l
    /* JADX INFO: renamed from: a */
    public final String mo293a() {
        return this.f324u + " " + this.f325v;
    }
}
