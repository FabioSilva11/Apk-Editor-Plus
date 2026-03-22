package com.p016a.p019b.p028c.p030b;

import android.support.v7.appcompat.C0299R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p033d.C0716e;

/* JADX INFO: renamed from: com.a.b.c.b.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0589n {

    /* JADX INFO: renamed from: a */
    private final int f792a;

    /* JADX INFO: renamed from: b */
    private final int f793b;

    /* JADX INFO: renamed from: c */
    private final int f794c;

    /* JADX INFO: renamed from: d */
    private final AbstractC0593r f795d;

    /* JADX INFO: renamed from: e */
    private final boolean f796e;

    public C0589n(int i, int i2, int i3, AbstractC0593r abstractC0593r, boolean z) {
        if (!C0985a.m2270e(i)) {
            throw new IllegalArgumentException("bogus opcode");
        }
        if (!C0985a.m2270e(i2)) {
            throw new IllegalArgumentException("bogus family");
        }
        if (!C0985a.m2270e(i3)) {
            throw new IllegalArgumentException("bogus nextOpcode");
        }
        if (abstractC0593r == null) {
            throw new NullPointerException("format == null");
        }
        this.f792a = i;
        this.f793b = i2;
        this.f794c = i3;
        this.f795d = abstractC0593r;
        this.f796e = z;
    }

    /* JADX INFO: renamed from: a */
    public final int m974a() {
        return this.f792a;
    }

    /* JADX INFO: renamed from: b */
    public final int m975b() {
        return this.f793b;
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC0593r m976c() {
        return this.f795d;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m977d() {
        return this.f796e;
    }

    /* JADX INFO: renamed from: e */
    public final String m978e() {
        return C0716e.m1337a(this.f792a);
    }

    /* JADX INFO: renamed from: f */
    public final int m979f() {
        return this.f794c;
    }

    /* JADX INFO: renamed from: g */
    public final C0589n m980g() {
        switch (this.f792a) {
            case 50:
                return C0590o.f813Q;
            case C0299R.styleable.AppCompatTheme_actionButtonStyle /* 51 */:
                return C0590o.f812P;
            case C0299R.styleable.AppCompatTheme_buttonBarStyle /* 52 */:
                return C0590o.f815S;
            case C0299R.styleable.AppCompatTheme_buttonBarButtonStyle /* 53 */:
                return C0590o.f814R;
            case C0299R.styleable.AppCompatTheme_selectableItemBackground /* 54 */:
                return C0590o.f817U;
            case C0299R.styleable.AppCompatTheme_selectableItemBackgroundBorderless /* 55 */:
                return C0590o.f816T;
            case C0299R.styleable.AppCompatTheme_borderlessButtonStyle /* 56 */:
                return C0590o.f819W;
            case C0299R.styleable.AppCompatTheme_dividerVertical /* 57 */:
                return C0590o.f818V;
            case C0299R.styleable.AppCompatTheme_dividerHorizontal /* 58 */:
                return C0590o.f821Y;
            case C0299R.styleable.AppCompatTheme_activityChooserViewStyle /* 59 */:
                return C0590o.f820X;
            case C0299R.styleable.AppCompatTheme_toolbarStyle /* 60 */:
                return C0590o.f850aa;
            case C0299R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /* 61 */:
                return C0590o.f822Z;
            default:
                throw new IllegalArgumentException("bogus opcode: " + this);
        }
    }

    public final String toString() {
        return C0716e.m1337a(this.f792a);
    }
}
