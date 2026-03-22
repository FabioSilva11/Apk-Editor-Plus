package com.p016a.p019b.p020a.p022b;

import android.support.v7.appcompat.C0299R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.AbstractC0797u;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p043h.C0880j;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.a.b.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0464b implements InterfaceC0473k {

    /* JADX INFO: renamed from: a */
    private final C0474l f533a;

    /* JADX INFO: renamed from: b */
    private final int[] f534b;

    /* JADX INFO: renamed from: c */
    private final int[] f535c;

    /* JADX INFO: renamed from: d */
    private final int[] f536d;

    /* JADX INFO: renamed from: e */
    private final C0880j[] f537e;

    /* JADX INFO: renamed from: f */
    private final C0467e[] f538f;

    /* JADX INFO: renamed from: g */
    private int f539g;

    private C0464b(C0474l c0474l) {
        if (c0474l == null) {
            throw new NullPointerException("method == null");
        }
        this.f533a = c0474l;
        int iM580b = c0474l.m593k().m580b() + 1;
        this.f534b = C0985a.m2293s(iM580b);
        this.f535c = C0985a.m2293s(iM580b);
        this.f536d = C0985a.m2293s(iM580b);
        this.f537e = new C0880j[iM580b];
        this.f538f = new C0467e[iM580b];
        this.f539g = -1;
    }

    /* JADX INFO: renamed from: a */
    public static C0466d m554a(C0474l c0474l) {
        C0464b c0464b = new C0464b(c0474l);
        C0470h c0470hM593k = c0464b.f533a.m593k();
        C0467e c0467eM594l = c0464b.f533a.m594l();
        int iD_ = c0467eM594l.m1977d_();
        C0985a.m2246b(c0464b.f534b, 0);
        C0985a.m2246b(c0464b.f536d, 0);
        while (!C0985a.m2250b(c0464b.f534b)) {
            try {
                int[] iArr = c0464b.f534b;
                if (c0464b == null) {
                    throw new NullPointerException("visitor == null");
                }
                while (true) {
                    int iM2262d = C0985a.m2262d(iArr, 0);
                    if (iM2262d < 0) {
                        break;
                    }
                    C0985a.m2259c(iArr, iM2262d);
                    c0470hM593k.m577a(iM2262d, c0464b);
                    c0464b.mo535a(iM2262d);
                }
                for (int i = 0; i < iD_; i++) {
                    C0468f c0468fM566a = c0467eM594l.m566a(i);
                    int iM570a = c0468fM566a.m570a();
                    int iM572b = c0468fM566a.m572b();
                    if (C0985a.m2228a(c0464b.f535c, iM570a, iM572b)) {
                        C0985a.m2246b(c0464b.f536d, iM570a);
                        C0985a.m2246b(c0464b.f536d, iM572b);
                        c0464b.m556a(c0468fM566a.m573c(), true);
                    }
                }
            } catch (IllegalArgumentException e) {
                throw new C0459ah("flow of control falls off end of method", e);
            }
        }
        return c0464b.m557b();
    }

    /* JADX INFO: renamed from: a */
    private void m555a(int i, int i2, boolean z) {
        C0985a.m2246b(this.f535c, i);
        if (z) {
            m556a(i + i2, false);
        } else {
            C0985a.m2246b(this.f536d, i + i2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m556a(int i, boolean z) {
        if (!C0985a.m2227a(this.f535c, i)) {
            C0985a.m2246b(this.f534b, i);
        }
        if (z) {
            C0985a.m2246b(this.f536d, i);
        }
    }

    /* JADX INFO: renamed from: b */
    private C0466d m557b() {
        int i;
        C0467e c0467e;
        C0465c[] c0465cArr = new C0465c[this.f533a.m593k().m580b()];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int iM2262d = C0985a.m2262d(this.f536d, i2 + 1);
            if (iM2262d < 0) {
                break;
            }
            if (C0985a.m2227a(this.f535c, i2)) {
                C0880j c0880jM1982a = null;
                int i4 = iM2262d - 1;
                while (true) {
                    if (i4 < i2) {
                        i4 = -1;
                        break;
                    }
                    c0880jM1982a = this.f537e[i4];
                    if (c0880jM1982a != null) {
                        break;
                    }
                    i4--;
                }
                if (c0880jM1982a == null) {
                    c0880jM1982a = C0880j.m1982a(iM2262d);
                    c0467e = C0467e.f545a;
                } else {
                    c0467e = this.f538f[i4];
                    if (c0467e == null) {
                        c0467e = C0467e.f545a;
                    }
                }
                c0465cArr[i3] = new C0465c(i2, i2, iM2262d, c0880jM1982a, c0467e);
                i = i3 + 1;
            } else {
                i = i3;
            }
            i2 = iM2262d;
            i3 = i;
        }
        C0466d c0466d = new C0466d(i3);
        for (int i5 = 0; i5 < i3; i5++) {
            c0466d.m565a(i5, c0465cArr[i5]);
        }
        return c0466d;
    }

    /* JADX INFO: renamed from: b */
    private void m558b(int i, int i2, boolean z) {
        C0880j c0880jM1982a;
        int i3 = i + i2;
        if (z) {
            m556a(i3, true);
        }
        C0467e c0467eM569b = this.f533a.m594l().m569b(i);
        this.f538f[i] = c0467eM569b;
        C0880j[] c0880jArr = this.f537e;
        int i4 = z ? i3 : -1;
        if (i4 < -1) {
            throw new IllegalArgumentException("noException < -1");
        }
        boolean z2 = i4 >= 0;
        int iD_ = c0467eM569b.m1977d_();
        if (iD_ == 0) {
            c0880jM1982a = z2 ? C0880j.m1982a(i4) : C0880j.f2245a;
        } else {
            C0880j c0880j = new C0880j((z2 ? 1 : 0) + iD_);
            for (int i5 = 0; i5 < iD_; i5++) {
                c0880j.m1988c(c0467eM569b.m566a(i5).m573c());
            }
            if (z2) {
                c0880j.m1988c(i4);
            }
            c0880j.mo549b_();
            c0880jM1982a = c0880j;
        }
        c0880jArr[i] = c0880jM1982a;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final int mo534a() {
        return this.f539g;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo535a(int i) {
        this.f539g = i;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo536a(int i, int i2, int i3) {
        m555a(i2, i3, true);
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo537a(int i, int i2, int i3, int i4) {
        switch (i) {
            case 167:
                m555a(i2, i3, false);
                this.f537e[i2] = C0880j.m1982a(i4);
                break;
            case 168:
                m556a(i2, true);
            default:
                int i5 = i2 + i3;
                m555a(i2, i3, true);
                m556a(i5, true);
                this.f537e[i2] = C0880j.m1983a(i5, i4);
                break;
        }
        m556a(i4, true);
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo538a(int i, int i2, int i3, int i4, C0805c c0805c, int i5) {
        if (i != 169) {
            m555a(i2, i3, true);
        } else {
            m555a(i2, i3, false);
            this.f537e[i2] = C0880j.f2245a;
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo539a(int i, int i2, int i3, C0462ak c0462ak, int i4) {
        m555a(i2, i3, false);
        m556a(c0462ak.m547b(), true);
        int iM544a = c0462ak.m544a();
        for (int i5 = 0; i5 < iM544a; i5++) {
            m556a(c0462ak.m548b(i5), true);
        }
        this.f537e[i2] = c0462ak.m551d();
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo540a(int i, int i2, int i3, AbstractC0775a abstractC0775a, int i4) {
        m555a(i2, i3, true);
        if ((abstractC0775a instanceof AbstractC0797u) || (abstractC0775a instanceof C0802z) || (abstractC0775a instanceof C0801y)) {
            m558b(i2, i3, true);
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo541a(int i, int i2, int i3, C0805c c0805c) {
        switch (i) {
            case 46:
            case 47:
            case C0299R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /* 48 */:
            case C0299R.styleable.AppCompatTheme_spinnerDropDownItemStyle /* 49 */:
            case 50:
            case C0299R.styleable.AppCompatTheme_actionButtonStyle /* 51 */:
            case C0299R.styleable.AppCompatTheme_buttonBarStyle /* 52 */:
            case C0299R.styleable.AppCompatTheme_buttonBarButtonStyle /* 53 */:
            case C0299R.styleable.AppCompatTheme_textAppearanceListItemSecondary /* 79 */:
            case C0299R.styleable.AppCompatTheme_textAppearanceListItemSmall /* 80 */:
            case 81:
            case C0299R.styleable.AppCompatTheme_panelMenuListWidth /* 82 */:
            case C0299R.styleable.AppCompatTheme_panelMenuListTheme /* 83 */:
            case C0299R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /* 84 */:
            case C0299R.styleable.AppCompatTheme_colorPrimary /* 85 */:
            case C0299R.styleable.AppCompatTheme_colorPrimaryDark /* 86 */:
            case 190:
            case 194:
            case 195:
                m555a(i2, i3, true);
                m558b(i2, i3, true);
                break;
            case 108:
            case C0299R.styleable.AppCompatTheme_ratingBarStyleSmall /* 112 */:
                m555a(i2, i3, true);
                if (c0805c == C0805c.f2015f || c0805c == C0805c.f2016g) {
                    m558b(i2, i3, true);
                }
                break;
            case 172:
            case 177:
                m555a(i2, i3, false);
                this.f537e[i2] = C0880j.f2245a;
                break;
            case 191:
                m555a(i2, i3, false);
                m558b(i2, i3, false);
                break;
            default:
                m555a(i2, i3, true);
                break;
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo542a(int i, int i2, C0802z c0802z, ArrayList arrayList) {
        m555a(i, i2, true);
        m558b(i, i2, true);
    }
}
