package com.p016a.p019b.p020a.p022b;

import com.p016a.p019b.p020a.p021a.C0429b;
import com.p016a.p019b.p020a.p025e.InterfaceC0507b;
import com.p016a.p019b.p020a.p025e.InterfaceC0508c;
import com.p016a.p019b.p020a.p025e.InterfaceC0512g;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p036f.p039c.C0799w;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0803a;

/* JADX INFO: renamed from: com.a.b.a.b.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0474l implements InterfaceC0512g {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0512g f559a;

    /* JADX INFO: renamed from: b */
    private final C0801y f560b;

    /* JADX INFO: renamed from: c */
    private final boolean f561c;

    /* JADX INFO: renamed from: d */
    private final C0429b f562d;

    /* JADX INFO: renamed from: e */
    private final C0477o f563e;

    /* JADX INFO: renamed from: f */
    private final C0479q f564f;

    /* JADX WARN: Removed duplicated region for block: B:25:0x008e A[PHI: r1
  0x008e: PHI (r1v3 com.a.b.a.b.q) = (r1v2 com.a.b.a.b.q), (r1v4 com.a.b.a.b.q) binds: [B:13:0x004b, B:21:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private C0474l(com.p016a.p019b.p020a.p025e.InterfaceC0512g r7, int r8, com.p016a.p019b.p036f.p039c.C0801y r9, boolean r10, boolean r11) {
        /*
            r6 = this;
            r6.<init>()
            r6.f559a = r7
            r0 = r8 & 32
            if (r0 == 0) goto L44
            r0 = 1
        La:
            r6.f561c = r0
            r6.f560b = r9
            com.a.b.a.e.b r0 = r7.mo587e()
            java.lang.String r1 = "Code"
            com.a.b.a.e.a r0 = r0.mo785a(r1)
            com.a.b.a.a.b r0 = (com.p016a.p019b.p020a.p021a.C0429b) r0
            r6.f562d = r0
            com.a.b.a.a.b r0 = r6.f562d
            com.a.b.a.e.b r3 = r0.m449f()
            com.a.b.a.b.o r1 = com.p016a.p019b.p020a.p022b.C0477o.f571a
            if (r10 == 0) goto L46
            java.lang.String r0 = "LineNumberTable"
            com.a.b.a.e.a r0 = r3.mo785a(r0)
            com.a.b.a.a.h r0 = (com.p016a.p019b.p020a.p021a.C0435h) r0
            r5 = r0
            r0 = r1
            r1 = r5
        L31:
            if (r1 == 0) goto L47
            com.a.b.a.b.o r2 = r1.m455b()
            com.a.b.a.b.o r2 = com.p016a.p019b.p020a.p022b.C0477o.m624a(r0, r2)
            com.a.b.a.e.a r0 = r3.mo784a(r1)
            com.a.b.a.a.h r0 = (com.p016a.p019b.p020a.p021a.C0435h) r0
            r1 = r0
            r0 = r2
            goto L31
        L44:
            r0 = 0
            goto La
        L46:
            r0 = r1
        L47:
            r6.f563e = r0
            com.a.b.a.b.q r1 = com.p016a.p019b.p020a.p022b.C0479q.f574a
            if (r11 == 0) goto L8e
            java.lang.String r0 = "LocalVariableTable"
            com.a.b.a.e.a r0 = r3.mo785a(r0)
            com.a.b.a.a.i r0 = (com.p016a.p019b.p020a.p021a.C0436i) r0
        L55:
            if (r0 == 0) goto L66
            com.a.b.a.b.q r2 = r0.m459b()
            com.a.b.a.b.q r1 = com.p016a.p019b.p020a.p022b.C0479q.m631a(r1, r2)
            com.a.b.a.e.a r0 = r3.mo784a(r0)
            com.a.b.a.a.i r0 = (com.p016a.p019b.p020a.p021a.C0436i) r0
            goto L55
        L66:
            com.a.b.a.b.q r2 = com.p016a.p019b.p020a.p022b.C0479q.f574a
            java.lang.String r0 = "LocalVariableTypeTable"
            com.a.b.a.e.a r0 = r3.mo785a(r0)
            com.a.b.a.a.j r0 = (com.p016a.p019b.p020a.p021a.C0437j) r0
        L70:
            if (r0 == 0) goto L81
            com.a.b.a.b.q r4 = r0.m459b()
            com.a.b.a.b.q r2 = com.p016a.p019b.p020a.p022b.C0479q.m631a(r2, r4)
            com.a.b.a.e.a r0 = r3.mo784a(r0)
            com.a.b.a.a.j r0 = (com.p016a.p019b.p020a.p021a.C0437j) r0
            goto L70
        L81:
            int r0 = r2.m1977d_()
            if (r0 == 0) goto L8e
            com.a.b.a.b.q r0 = com.p016a.p019b.p020a.p022b.C0479q.m634b(r1, r2)
        L8b:
            r6.f564f = r0
            return
        L8e:
            r0 = r1
            goto L8b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p016a.p019b.p020a.p022b.C0474l.<init>(com.a.b.a.e.g, int, com.a.b.f.c.y, boolean, boolean):void");
    }

    public C0474l(InterfaceC0512g interfaceC0512g, InterfaceC0508c interfaceC0508c, boolean z, boolean z2) {
        this(interfaceC0512g, interfaceC0508c.mo747d(), interfaceC0508c.mo755l(), z, z2);
    }

    /* JADX INFO: renamed from: a */
    public final C0774z m582a(int i) {
        return new C0774z(this.f560b, i, this.f563e.m627a(i));
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0511f
    /* JADX INFO: renamed from: a */
    public final C0799w mo583a() {
        return this.f559a.mo583a();
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0511f
    /* JADX INFO: renamed from: b */
    public final C0801y mo584b() {
        return this.f559a.mo584b();
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0511f
    /* JADX INFO: renamed from: c */
    public final C0801y mo585c() {
        return this.f559a.mo585c();
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0511f
    /* JADX INFO: renamed from: d */
    public final int mo586d() {
        return this.f559a.mo586d();
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0511f
    /* JADX INFO: renamed from: e */
    public final InterfaceC0507b mo587e() {
        return this.f559a.mo587e();
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0511f
    /* JADX INFO: renamed from: f */
    public final C0802z mo588f() {
        return this.f559a.mo588f();
    }

    @Override // com.p016a.p019b.p020a.p025e.InterfaceC0512g
    /* JADX INFO: renamed from: g */
    public final C0803a mo589g() {
        return this.f559a.mo589g();
    }

    /* JADX INFO: renamed from: h */
    public final boolean m590h() {
        return this.f561c;
    }

    /* JADX INFO: renamed from: i */
    public final int m591i() {
        return this.f562d.m445b();
    }

    /* JADX INFO: renamed from: j */
    public final int m592j() {
        return this.f562d.m446c();
    }

    /* JADX INFO: renamed from: k */
    public final C0470h m593k() {
        return this.f562d.m447d();
    }

    /* JADX INFO: renamed from: l */
    public final C0467e m594l() {
        return this.f562d.m448e();
    }

    /* JADX INFO: renamed from: m */
    public final C0479q m595m() {
        return this.f564f;
    }
}
