package p000a.p001a.p003b.p004a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import java.util.LinkedHashMap;
import java.util.Map;
import p000a.p001a.C0000a;
import p000a.p001a.p002a.C0002b;

/* JADX INFO: renamed from: a.a.b.a.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0035i {

    /* JADX INFO: renamed from: a */
    private final String f83a;

    /* JADX INFO: renamed from: b */
    private final Map f84b = new LinkedHashMap();

    /* JADX INFO: renamed from: c */
    private final int f85c;

    public C0035i(String str, C0985a c0985a, C0031e c0031e, int i, int i2) {
        this.f83a = str;
        this.f85c = i;
    }

    /* JADX INFO: renamed from: a */
    public final C0032f m79a(String str) throws C0002b {
        C0032f c0032f = (C0032f) this.f84b.get(str);
        if (c0032f == null) {
            throw new C0002b(String.format("resource spec: %s/%s", this.f83a, str));
        }
        return c0032f;
    }

    /* JADX INFO: renamed from: a */
    public final String m80a() {
        return this.f83a;
    }

    /* JADX INFO: renamed from: a */
    public final void m81a(C0032f c0032f) {
        this.f84b.remove(c0032f.m67f());
    }

    /* JADX INFO: renamed from: b */
    public final int m82b() {
        return this.f85c;
    }

    /* JADX INFO: renamed from: b */
    public final void m83b(C0032f c0032f) throws C0000a {
        if (this.f84b.put(c0032f.m67f(), c0032f) != null) {
            throw new C0000a(String.format("Multiple res specs: %s/%s", this.f83a, c0032f.m67f()));
        }
    }

    /* JADX INFO: renamed from: c */
    public final boolean m84c() {
        return this.f83a.equalsIgnoreCase("string");
    }

    public final String toString() {
        return this.f83a;
    }

    public final C0032f unsafe(String str) {
        return (C0032f) this.f84b.get(str);
    }
}
