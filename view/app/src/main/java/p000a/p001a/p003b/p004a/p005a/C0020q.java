package p000a.p001a.p003b.p004a.p005a;

import android.util.TypedValue;

/* JADX INFO: renamed from: a.a.b.a.a.q */
/* JADX INFO: loaded from: classes.dex */
public class C0020q extends AbstractC0023t {

    /* JADX INFO: renamed from: a */
    protected final int f21a;

    /* JADX INFO: renamed from: c */
    private int f22c;

    public C0020q(int i, String str, int i2) {
        this(i, str, "integer");
        this.f22c = i2;
    }

    public C0020q(int i, String str, String str2) {
        super(str2, i, str);
        this.f21a = i;
    }

    @Override // p000a.p001a.p003b.p004a.p005a.AbstractC0023t
    /* JADX INFO: renamed from: a */
    protected String mo5a() {
        return TypedValue.coerceToString(this.f22c, this.f21a);
    }

    /* JADX INFO: renamed from: b */
    public final int m11b() {
        return this.f21a;
    }
}
