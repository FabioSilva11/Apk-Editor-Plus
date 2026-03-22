package com.gmail.heagoo.neweditor;

import org.xml.sax.Attributes;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.ai */
/* JADX INFO: loaded from: classes.dex */
final class C1507ai {

    /* JADX INFO: renamed from: A */
    final /* synthetic */ C1506ah f4444A;

    /* JADX INFO: renamed from: a */
    public boolean f4445a;

    /* JADX INFO: renamed from: b */
    public boolean f4446b;

    /* JADX INFO: renamed from: c */
    public boolean f4447c;

    /* JADX INFO: renamed from: d */
    public byte f4448d;

    /* JADX INFO: renamed from: e */
    public C1530x f4449e;

    /* JADX INFO: renamed from: f */
    public String f4450f;

    /* JADX INFO: renamed from: g */
    public StringBuffer f4451g;

    /* JADX INFO: renamed from: h */
    public int f4452h;

    /* JADX INFO: renamed from: i */
    public boolean f4453i;

    /* JADX INFO: renamed from: j */
    public String f4454j;

    /* JADX INFO: renamed from: k */
    public String f4455k;

    /* JADX INFO: renamed from: l */
    public String f4456l;

    /* JADX INFO: renamed from: m */
    public boolean f4457m;

    /* JADX INFO: renamed from: n */
    public boolean f4458n;

    /* JADX INFO: renamed from: o */
    public StringBuffer f4459o;

    /* JADX INFO: renamed from: p */
    public byte f4460p;

    /* JADX INFO: renamed from: q */
    public boolean f4461q;

    /* JADX INFO: renamed from: r */
    public boolean f4462r;

    /* JADX INFO: renamed from: s */
    public String f4463s;

    /* JADX INFO: renamed from: t */
    public boolean f4464t;

    /* JADX INFO: renamed from: u */
    public String f4465u;

    /* JADX INFO: renamed from: v */
    public StringBuffer f4466v;

    /* JADX INFO: renamed from: w */
    public int f4467w;

    /* JADX INFO: renamed from: x */
    public byte f4468x;

    /* JADX INFO: renamed from: y */
    public String f4469y;

    /* JADX INFO: renamed from: z */
    public int f4470z;

    public C1507ai(C1506ah c1506ah, String str, Attributes attributes) {
        String strSubstring;
        String strSubstring2;
        boolean z = true;
        this.f4444A = c1506ah;
        this.f4448d = (byte) 0;
        this.f4458n = true;
        this.f4463s = "_";
        this.f4470z = -1;
        this.f4469y = str;
        c1506ah.f4440e = attributes.getValue("NAME");
        c1506ah.f4441f = attributes.getValue("VALUE");
        String value = attributes.getValue("TYPE");
        if (value != null) {
            this.f4468x = Token.stringToToken(value);
            if (this.f4468x == -1) {
                C1506ah.m3626a("token-invalid", value);
            }
        }
        this.f4460p = (byte) -2;
        String value2 = attributes.getValue("EXCLUDE_MATCH");
        if (value2 != null && "TRUE".equalsIgnoreCase(value2)) {
            this.f4460p = (byte) -1;
        }
        String value3 = attributes.getValue("MATCH_TYPE");
        if (value3 != null) {
            if ("CONTEXT".equals(value3)) {
                this.f4460p = (byte) -1;
            } else if ("RULE".equals(value3)) {
                this.f4460p = (byte) -2;
            } else {
                this.f4460p = Token.stringToToken(value3);
                if (this.f4460p == -1) {
                    C1506ah.m3626a("token-invalid", value3);
                }
            }
        }
        this.f4445a = "TRUE".equals(attributes.getValue("AT_LINE_START"));
        this.f4446b = "TRUE".equals(attributes.getValue("AT_WHITESPACE_END"));
        this.f4447c = "TRUE".equals(attributes.getValue("AT_WORD_START"));
        this.f4461q = "TRUE".equals(attributes.getValue("NO_LINE_BREAK"));
        this.f4462r = "TRUE".equals(attributes.getValue("NO_WORD_BREAK"));
        if (attributes.getValue("IGNORE_CASE") != null && !"TRUE".equals(attributes.getValue("IGNORE_CASE"))) {
            z = false;
        }
        this.f4458n = z;
        this.f4457m = "TRUE".equals(attributes.getValue("HIGHLIGHT_DIGITS"));
        this.f4464t = "TRUE".equals(attributes.getValue("REGEXP"));
        this.f4450f = attributes.getValue("DIGIT_RE");
        String value4 = attributes.getValue("NO_WORD_SEP");
        if (value4 != null) {
            this.f4463s = value4;
        }
        String value5 = attributes.getValue("AT_CHAR");
        if (value5 != null) {
            try {
                this.f4470z = Integer.parseInt(value5);
            } catch (NumberFormatException e) {
                C1506ah.m3626a("termchar-invalid", value5);
                this.f4470z = -1;
            }
        }
        this.f4454j = attributes.getValue("ESCAPE");
        this.f4465u = attributes.getValue("SET");
        String value6 = attributes.getValue("DELEGATE");
        if (value6 != null) {
            int iIndexOf = value6.indexOf("::");
            if (iIndexOf != -1) {
                strSubstring = value6.substring(0, iIndexOf);
                strSubstring2 = value6.substring(iIndexOf + 2);
            } else {
                strSubstring = c1506ah.f4439d;
                strSubstring2 = value6;
            }
            C1504af c1504afM3630a = c1506ah.m3630a();
            if (c1504afM3630a == null) {
                C1506ah.m3626a("delegate-invalid", value6);
            } else {
                this.f4449e = c1504afM3630a.m3618a(strSubstring2);
                if (c1504afM3630a == c1506ah.f4436a && this.f4449e == null) {
                    this.f4449e = new C1530x(strSubstring, strSubstring2);
                    this.f4449e.m3682b((byte) 7);
                    c1506ah.f4436a.m3619a(this.f4449e);
                } else if (this.f4449e == null) {
                    C1506ah.m3626a("delegate-invalid", value6);
                }
            }
        }
        String value7 = attributes.getValue("DEFAULT");
        if (value7 != null) {
            this.f4448d = Token.stringToToken(value7);
            if (this.f4448d == -1) {
                C1506ah.m3626a("token-invalid", value7);
                this.f4448d = (byte) 0;
            }
        }
        this.f4455k = attributes.getValue("HASH_CHAR");
        this.f4456l = attributes.getValue("HASH_CHARS");
        if (this.f4455k == null || this.f4456l == null) {
            return;
        }
        C1506ah.m3626a("hash-char-and-hash-chars-mutually-exclusive", (Object) null);
        this.f4456l = null;
    }
}
