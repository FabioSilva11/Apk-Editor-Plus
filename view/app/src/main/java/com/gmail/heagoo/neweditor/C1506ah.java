package com.gmail.heagoo.neweditor;

import android.util.Log;
import java.util.Hashtable;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.ah */
/* JADX INFO: loaded from: classes.dex */
public final class C1506ah extends DefaultHandler {

    /* JADX INFO: renamed from: b */
    private C1526t f4437b;

    /* JADX INFO: renamed from: c */
    private C1530x f4438c;

    /* JADX INFO: renamed from: e */
    private String f4440e;

    /* JADX INFO: renamed from: f */
    private String f4441f;

    /* JADX INFO: renamed from: g */
    private Stack f4442g;

    /* JADX INFO: renamed from: h */
    private Hashtable f4443h;

    /* JADX INFO: renamed from: d */
    private String f4439d = "xml";

    /* JADX INFO: renamed from: a */
    private C1504af f4436a = new C1504af();

    public C1506ah() {
        this.f4436a.m3619a(new C1530x("xml", "MAIN"));
        this.f4442g = new Stack();
        this.f4443h = new Hashtable();
        m3623a((String) null, (Attributes) null);
    }

    /* JADX INFO: renamed from: a */
    private C1507ai m3622a(String str) {
        for (int size = this.f4442g.size() - 1; size >= 0; size--) {
            C1507ai c1507ai = (C1507ai) this.f4442g.get(size);
            if (c1507ai.f4469y.equals(str)) {
                return c1507ai;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private C1507ai m3623a(String str, Attributes attributes) {
        C1507ai c1507ai = str != null ? new C1507ai(this, str, attributes) : null;
        this.f4442g.push(c1507ai);
        return c1507ai;
    }

    /* JADX INFO: renamed from: a */
    protected static void m3626a(String str, Object obj) {
        Log.d("DEBUG", "error occurred: " + str + ", " + obj.toString());
    }

    /* JADX INFO: renamed from: b */
    private C1507ai m3628b() {
        return (C1507ai) this.f4442g.peek();
    }

    /* JADX INFO: renamed from: a */
    public final C1504af m3630a() {
        return this.f4436a;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void characters(char[] cArr, int i, int i2) {
        C1507ai c1507aiM3628b = m3628b();
        if (c1507aiM3628b.f4469y.equals("EOL_SPAN") || c1507aiM3628b.f4469y.equals("EOL_SPAN_REGEXP") || c1507aiM3628b.f4469y.equals("MARK_PREVIOUS") || c1507aiM3628b.f4469y.equals("MARK_FOLLOWING") || c1507aiM3628b.f4469y.equals("SEQ") || c1507aiM3628b.f4469y.equals("SEQ_REGEXP") || c1507aiM3628b.f4469y.equals("BEGIN")) {
            C1507ai c1507ai = c1507aiM3628b.f4469y.equals("BEGIN") ? (C1507ai) c1507aiM3628b.f4444A.f4442g.get(c1507aiM3628b.f4444A.f4442g.size() - 2) : c1507aiM3628b;
            if (c1507ai.f4466v != null) {
                c1507ai.f4466v.append(cArr, i, i2);
                return;
            }
            c1507ai.f4466v = new StringBuffer();
            c1507ai.f4466v.append(cArr, i, i2);
            c1507ai.f4467w = (c1507ai.f4447c ? 8 : 0) | (!c1507ai.f4446b ? 0 : 4) | (!c1507ai.f4445a ? 0 : 2);
            c1507ai.f4445a = false;
            c1507ai.f4447c = false;
            c1507ai.f4446b = false;
            return;
        }
        if (!c1507aiM3628b.f4469y.equals("END")) {
            if (c1507aiM3628b.f4459o == null) {
                c1507aiM3628b.f4459o = new StringBuffer();
            }
            c1507aiM3628b.f4459o.append(cArr, i, i2);
            return;
        }
        C1507ai c1507ai2 = (C1507ai) c1507aiM3628b.f4444A.f4442g.get(c1507aiM3628b.f4444A.f4442g.size() - 2);
        if (c1507ai2.f4451g != null) {
            c1507ai2.f4451g.append(cArr, i, i2);
            return;
        }
        c1507ai2.f4451g = new StringBuffer();
        c1507ai2.f4451g.append(cArr, i, i2);
        c1507ai2.f4452h = (c1507aiM3628b.f4445a ? 2 : 0) | (c1507aiM3628b.f4446b ? 4 : 0) | (c1507aiM3628b.f4447c ? 8 : 0);
        c1507ai2.f4453i = c1507aiM3628b.f4464t;
        c1507ai2.f4445a = false;
        c1507ai2.f4447c = false;
        c1507ai2.f4446b = false;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        byte bStringToToken;
        C1507ai c1507ai = (C1507ai) this.f4442g.pop();
        if (!str3.equals(c1507ai.f4469y)) {
            throw new InternalError();
        }
        if (c1507ai.f4469y.equals("PROPERTY")) {
            this.f4443h.put(this.f4440e, this.f4441f);
            return;
        }
        if (c1507ai.f4469y.equals("PROPS")) {
            if (m3628b().f4469y.equals("RULES")) {
                this.f4438c.m3678a(this.f4443h);
            }
            this.f4443h = new Hashtable();
            return;
        }
        if (c1507ai.f4469y.equals("RULES")) {
            this.f4438c.m3674a(this.f4437b);
            this.f4437b = null;
            this.f4438c = null;
            return;
        }
        if (c1507ai.f4469y.equals("IMPORT")) {
            if (this.f4438c.equals(c1507ai.f4449e)) {
                return;
            }
            this.f4438c.m3676a(c1507ai.f4449e);
            return;
        }
        if (c1507ai.f4469y.equals("TERMINATE")) {
            this.f4438c.m3673a(c1507ai.f4470z);
            return;
        }
        if (c1507ai.f4469y.equals("SEQ")) {
            if (c1507ai.f4466v == null) {
                m3626a("empty-tag", "SEQ");
                return;
            } else {
                this.f4438c.m3675a(C1529w.m3660a(c1507ai.f4467w, c1507ai.f4466v.toString(), c1507ai.f4449e, c1507ai.f4468x));
                return;
            }
        }
        if (c1507ai.f4469y.equals("SEQ_REGEXP")) {
            if (c1507ai.f4466v == null) {
                m3626a("empty-tag", "SEQ_REGEXP");
                return;
            }
            try {
                if (c1507ai.f4456l != null) {
                    this.f4438c.m3675a(C1529w.m3664a(c1507ai.f4467w, c1507ai.f4456l.toCharArray(), c1507ai.f4466v.toString(), c1507ai.f4449e, c1507ai.f4468x, m3622a("RULES").f4458n));
                } else {
                    this.f4438c.m3675a(C1529w.m3668a(c1507ai.f4455k, c1507ai.f4467w, c1507ai.f4466v.toString(), c1507ai.f4449e, c1507ai.f4468x, m3622a("RULES").f4458n));
                }
                return;
            } catch (PatternSyntaxException e) {
                m3626a("regexp", e);
                return;
            }
        }
        if (c1507ai.f4469y.equals("SPAN")) {
            if (c1507ai.f4466v == null) {
                m3626a("empty-tag", "BEGIN");
                return;
            } else if (c1507ai.f4451g == null) {
                m3626a("empty-tag", "END");
                return;
            } else {
                this.f4438c.m3675a(C1529w.m3659a(c1507ai.f4467w, c1507ai.f4466v.toString(), c1507ai.f4452h, c1507ai.f4451g.toString(), c1507ai.f4449e, c1507ai.f4468x, c1507ai.f4460p, c1507ai.f4461q, c1507ai.f4462r, c1507ai.f4454j));
                return;
            }
        }
        if (c1507ai.f4469y.equals("SPAN_REGEXP")) {
            if (c1507ai.f4466v == null) {
                m3626a("empty-tag", "BEGIN");
                return;
            }
            if (c1507ai.f4451g == null) {
                m3626a("empty-tag", "END");
                return;
            }
            try {
                if (c1507ai.f4456l != null) {
                    this.f4438c.m3675a(C1529w.m3662a(c1507ai.f4467w, c1507ai.f4456l.toCharArray(), c1507ai.f4466v.toString(), c1507ai.f4452h, c1507ai.f4451g.toString(), c1507ai.f4449e, c1507ai.f4468x, c1507ai.f4460p, c1507ai.f4461q, c1507ai.f4462r, m3622a("RULES").f4458n, c1507ai.f4454j, c1507ai.f4453i));
                } else {
                    this.f4438c.m3675a(C1529w.m3666a(c1507ai.f4455k, c1507ai.f4467w, c1507ai.f4466v.toString(), c1507ai.f4452h, c1507ai.f4451g.toString(), c1507ai.f4449e, c1507ai.f4468x, c1507ai.f4460p, c1507ai.f4461q, c1507ai.f4462r, m3622a("RULES").f4458n, c1507ai.f4454j, c1507ai.f4453i));
                }
                return;
            } catch (PatternSyntaxException e2) {
                m3626a("regexp", e2);
                return;
            }
        }
        if (c1507ai.f4469y.equals("EOL_SPAN")) {
            if (c1507ai.f4466v == null) {
                m3626a("empty-tag", "EOL_SPAN");
                return;
            } else {
                this.f4438c.m3675a(C1529w.m3661a(c1507ai.f4467w, c1507ai.f4466v.toString(), c1507ai.f4449e, c1507ai.f4468x, c1507ai.f4460p));
                return;
            }
        }
        if (c1507ai.f4469y.equals("EOL_SPAN_REGEXP")) {
            if (c1507ai.f4466v == null) {
                m3626a("empty-tag", "EOL_SPAN_REGEXP");
                return;
            }
            try {
                if (c1507ai.f4456l != null) {
                    this.f4438c.m3675a(C1529w.m3663a(c1507ai.f4467w, c1507ai.f4456l.toCharArray(), c1507ai.f4466v.toString(), c1507ai.f4449e, c1507ai.f4468x, c1507ai.f4460p, m3622a("RULES").f4458n));
                } else {
                    this.f4438c.m3675a(C1529w.m3667a(c1507ai.f4455k, c1507ai.f4467w, c1507ai.f4466v.toString(), c1507ai.f4449e, c1507ai.f4468x, c1507ai.f4460p, m3622a("RULES").f4458n));
                }
                return;
            } catch (PatternSyntaxException e3) {
                m3626a("regexp", e3);
                return;
            }
        }
        if (c1507ai.f4469y.equals("MARK_FOLLOWING")) {
            if (c1507ai.f4466v == null) {
                m3626a("empty-tag", "MARK_FOLLOWING");
                return;
            } else {
                this.f4438c.m3675a(C1529w.m3658a(c1507ai.f4467w, c1507ai.f4466v.toString(), c1507ai.f4468x, c1507ai.f4460p));
                return;
            }
        }
        if (c1507ai.f4469y.equals("MARK_PREVIOUS")) {
            if (c1507ai.f4466v == null) {
                m3626a("empty-tag", "MARK_PREVIOUS");
                return;
            } else {
                this.f4438c.m3675a(C1529w.m3669b(c1507ai.f4467w, c1507ai.f4466v.toString(), c1507ai.f4468x, c1507ai.f4460p));
                return;
            }
        }
        if (c1507ai.f4469y.equals("END") || c1507ai.f4469y.equals("BEGIN") || c1507ai.f4469y.equals("KEYWORDS") || c1507ai.f4469y.equals("MODE") || (bStringToToken = Token.stringToToken(c1507ai.f4469y)) == -1) {
            return;
        }
        if (c1507ai.f4459o == null || c1507ai.f4459o.length() == 0) {
            m3626a("empty-keyword", (Object) null);
            return;
        }
        String string = c1507ai.f4459o.toString();
        if (this.f4437b != null) {
            this.f4437b.m3657a(string, bStringToToken);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        C1507ai c1507aiM3623a = m3623a(str3, attributes);
        if (str3.equals("WHITESPACE")) {
            return;
        }
        if (str3.equals("KEYWORDS")) {
            this.f4437b = new C1526t(this.f4438c.m3687e());
            return;
        }
        if (str3.equals("RULES")) {
            if (c1507aiM3623a.f4465u == null) {
                c1507aiM3623a.f4465u = "MAIN";
            }
            this.f4438c = this.f4436a.m3618a(c1507aiM3623a.f4465u);
            if (this.f4438c == null) {
                this.f4438c = new C1530x(this.f4439d, c1507aiM3623a.f4465u);
                this.f4436a.m3619a(this.f4438c);
            }
            this.f4438c.m3680a(c1507aiM3623a.f4458n);
            this.f4438c.m3684b(c1507aiM3623a.f4457m);
            if (c1507aiM3623a.f4450f != null) {
                try {
                    this.f4438c.m3679a(Pattern.compile(c1507aiM3623a.f4450f, c1507aiM3623a.f4458n ? 2 : 0));
                } catch (Exception e) {
                    m3626a("regexp", e);
                }
            }
            if (c1507aiM3623a.f4454j != null) {
                this.f4438c.m3683b(C1529w.m3665a(c1507aiM3623a.f4454j));
            }
            this.f4438c.m3682b(c1507aiM3623a.f4448d);
            this.f4438c.m3677a(c1507aiM3623a.f4463s);
        }
    }
}
