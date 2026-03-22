package com.p050c.p051a;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.c.a.j */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnTouchListenerC0944j implements View.OnTouchListener {

    /* JADX INFO: renamed from: A */
    private int f2355A;

    /* JADX INFO: renamed from: B */
    private int f2356B;

    /* JADX INFO: renamed from: C */
    private C0939e f2357C;

    /* JADX INFO: renamed from: D */
    private C0937c f2358D;

    /* JADX INFO: renamed from: E */
    private C0951q f2359E;

    /* JADX INFO: renamed from: F */
    private C0948n f2360F;

    /* JADX INFO: renamed from: G */
    private GestureDetector f2361G;

    /* JADX INFO: renamed from: H */
    private InterfaceC0943i f2362H;

    /* JADX INFO: renamed from: a */
    private C0940f f2363a;

    /* JADX INFO: renamed from: j */
    private float f2372j;

    /* JADX INFO: renamed from: k */
    private float f2373k;

    /* JADX INFO: renamed from: l */
    private float f2374l;

    /* JADX INFO: renamed from: m */
    private float f2375m;

    /* JADX INFO: renamed from: n */
    private float f2376n;

    /* JADX INFO: renamed from: o */
    private float f2377o;

    /* JADX INFO: renamed from: p */
    private float f2378p;

    /* JADX INFO: renamed from: s */
    private float f2381s;

    /* JADX INFO: renamed from: t */
    private float f2382t;

    /* JADX INFO: renamed from: u */
    private float f2383u;

    /* JADX INFO: renamed from: y */
    private int f2387y;

    /* JADX INFO: renamed from: z */
    private int f2388z;

    /* JADX INFO: renamed from: b */
    private final PointF f2364b = new PointF();

    /* JADX INFO: renamed from: c */
    private final PointF f2365c = new PointF();

    /* JADX INFO: renamed from: d */
    private final PointF f2366d = new PointF();

    /* JADX INFO: renamed from: e */
    private final PointF f2367e = new PointF();

    /* JADX INFO: renamed from: f */
    private final C0950p f2368f = new C0950p();

    /* JADX INFO: renamed from: g */
    private final C0950p f2369g = new C0950p();

    /* JADX INFO: renamed from: h */
    private boolean f2370h = false;

    /* JADX INFO: renamed from: i */
    private boolean f2371i = false;

    /* JADX INFO: renamed from: q */
    private float f2379q = 5.0f;

    /* JADX INFO: renamed from: r */
    private float f2380r = 0.25f;

    /* JADX INFO: renamed from: v */
    private boolean f2384v = false;

    /* JADX INFO: renamed from: w */
    private boolean f2385w = false;

    /* JADX INFO: renamed from: x */
    private boolean f2386x = false;

    public ViewOnTouchListenerC0944j(C0940f c0940f, int i, int i2) {
        this.f2373k = 1.0f;
        this.f2374l = 1.0f;
        this.f2375m = 0.0f;
        this.f2376n = 0.0f;
        this.f2377o = 0.0f;
        this.f2378p = 0.0f;
        this.f2381s = 0.0f;
        this.f2382t = 0.0f;
        this.f2383u = 0.0f;
        this.f2363a = c0940f;
        this.f2387y = i;
        this.f2388z = i2;
        this.f2381s = i / 2.0f;
        this.f2382t = i2 / 2.0f;
        this.f2355A = c0940f.m2071c();
        this.f2356B = c0940f.m2072d();
        this.f2383u = c0940f.m2073e();
        this.f2374l = this.f2383u;
        this.f2373k = this.f2383u;
        this.f2377o = i;
        this.f2378p = i2;
        this.f2375m = 0.0f;
        this.f2376n = 0.0f;
        this.f2366d.x = c0940f.m2074f();
        this.f2366d.y = c0940f.m2075g();
        this.f2357C = new C0939e();
        this.f2358D = new C0937c();
        this.f2359E = new C0951q();
        this.f2360F = new C0948n();
        this.f2358D.m2054a(new C0945k(this));
        this.f2359E.m2100a(2.0f);
        this.f2359E.m2101a(new C0946l(this));
        this.f2360F.m2094a(new C0947m(this, c0940f));
        this.f2361G = new GestureDetector(c0940f.getContext(), this.f2357C);
        this.f2362H = c0940f.m2076h();
        m2085c();
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m2081a(ViewOnTouchListenerC0944j viewOnTouchListenerC0944j, boolean z) {
        viewOnTouchListenerC0944j.f2371i = false;
        return false;
    }

    /* JADX INFO: renamed from: b */
    private void m2083b() {
        if (this.f2366d.x < this.f2375m) {
            this.f2366d.x = this.f2375m;
        } else if (this.f2366d.x > this.f2377o) {
            this.f2366d.x = this.f2377o;
        }
        if (this.f2366d.y < this.f2376n) {
            this.f2366d.y = this.f2376n;
        } else if (this.f2366d.y > this.f2378p) {
            this.f2366d.y = this.f2378p;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m2085c() {
        int iRound = Math.round(this.f2355A * this.f2374l);
        int iRound2 = Math.round(this.f2356B * this.f2374l);
        this.f2384v = iRound > this.f2387y;
        this.f2385w = iRound2 > this.f2388z;
        if (this.f2384v) {
            float f = (iRound - this.f2387y) / 2.0f;
            this.f2375m = this.f2381s - f;
            this.f2377o = f + this.f2381s;
        }
        if (this.f2385w) {
            float f2 = (iRound2 - this.f2388z) / 2.0f;
            this.f2376n = this.f2382t - f2;
            this.f2378p = f2 + this.f2382t;
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m2086a() {
        this.f2386x = false;
        this.f2372j = 0.0f;
        this.f2373k = this.f2374l;
        if (!this.f2384v) {
            this.f2366d.x = this.f2381s;
        }
        if (!this.f2385w) {
            this.f2366d.y = this.f2382t;
        }
        m2083b();
        this.f2363a.m2063a(this.f2374l);
        this.f2363a.m2064a(this.f2366d.x, this.f2366d.y);
        if (this.f2362H != null) {
            this.f2362H.mo2079a(this.f2374l);
            float f = this.f2366d.x;
            float f2 = this.f2366d.y;
        }
        this.f2363a.postInvalidate();
    }

    /* JADX INFO: renamed from: a */
    public final void m2087a(float f) {
        this.f2379q = f;
    }

    /* JADX INFO: renamed from: a */
    protected final void m2088a(float f, float f2, float f3) {
        this.f2374l = f;
        if (this.f2374l > this.f2379q) {
            this.f2374l = this.f2379q;
        } else if (this.f2374l < this.f2380r) {
            this.f2374l = this.f2380r;
        } else {
            this.f2366d.x = f2;
            this.f2366d.y = f3;
        }
        m2085c();
        this.f2363a.m2063a(this.f2374l);
        this.f2363a.m2064a(this.f2366d.x, this.f2366d.y);
        if (this.f2362H != null) {
            this.f2362H.mo2079a(this.f2374l);
            float f4 = this.f2366d.x;
            float f5 = this.f2366d.y;
        }
        this.f2363a.postInvalidate();
    }

    /* JADX INFO: renamed from: a */
    protected final boolean m2089a(float f, float f2) {
        this.f2364b.x = f;
        this.f2364b.y = f2;
        float f3 = this.f2364b.x - this.f2365c.x;
        float f4 = this.f2364b.y - this.f2365c.y;
        if (f3 != 0.0f || f4 != 0.0f) {
            if (this.f2384v) {
                PointF pointF = this.f2366d;
                pointF.x = f3 + pointF.x;
            }
            if (this.f2385w) {
                PointF pointF2 = this.f2366d;
                pointF2.y = f4 + pointF2.y;
            }
            m2083b();
            this.f2365c.x = this.f2364b.x;
            this.f2365c.y = this.f2364b.y;
            if (this.f2384v || this.f2385w) {
                this.f2363a.m2064a(this.f2366d.x, this.f2366d.y);
                if (this.f2362H != null) {
                    float f5 = this.f2366d.x;
                    float f6 = this.f2366d.y;
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public final void m2090b(float f) {
        this.f2380r = f;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f2371i) {
            if (motionEvent.getPointerCount() == 1 && this.f2361G.onTouchEvent(motionEvent)) {
                this.f2358D.m2053a(this.f2357C.m2057a());
                this.f2358D.m2055b(this.f2357C.m2058b());
                this.f2363a.m2065a(this.f2358D);
            }
            if (motionEvent.getAction() == 1) {
                m2086a();
            } else if (motionEvent.getAction() == 0) {
                this.f2363a.m2068b();
                this.f2365c.x = motionEvent.getX();
                this.f2365c.y = motionEvent.getY();
                if (this.f2362H != null) {
                    float f = this.f2365c.x;
                    float f2 = this.f2365c.y;
                }
                this.f2370h = true;
            } else if (motionEvent.getAction() == 2) {
                if (motionEvent.getPointerCount() > 1) {
                    this.f2386x = true;
                    if (this.f2372j > 0.0f) {
                        C0950p c0950p = this.f2369g;
                        c0950p.f2399b.x = motionEvent.getX(0);
                        c0950p.f2399b.y = motionEvent.getY(0);
                        c0950p.f2400c.x = motionEvent.getX(1);
                        c0950p.f2400c.y = motionEvent.getY(1);
                        this.f2369g.m2097b();
                        float f3 = this.f2369g.f2398a;
                        if (this.f2372j != f3) {
                            float f4 = (f3 / this.f2372j) * this.f2373k;
                            if (f4 <= this.f2379q) {
                                this.f2368f.f2398a *= f4;
                                this.f2368f.m2095a();
                                this.f2368f.f2398a /= f4;
                                float f5 = this.f2368f.f2400c.x;
                                float f6 = this.f2368f.f2400c.y;
                                m2088a(f4, this.f2381s, this.f2382t);
                            }
                        }
                    } else {
                        float x = motionEvent.getX(0) - motionEvent.getX(1);
                        float y = motionEvent.getY(0) - motionEvent.getY(1);
                        this.f2372j = (float) Math.sqrt((x * x) + (y * y));
                        PointF pointF = this.f2367e;
                        float x2 = motionEvent.getX(0);
                        float y2 = motionEvent.getY(0);
                        float x3 = motionEvent.getX(1);
                        float y3 = motionEvent.getY(1);
                        pointF.x = (x2 + x3) / 2.0f;
                        pointF.y = (y2 + y3) / 2.0f;
                        this.f2368f.m2096a(this.f2367e);
                        this.f2368f.m2098b(this.f2366d);
                        this.f2368f.m2097b();
                        this.f2368f.m2099c();
                        this.f2368f.f2398a /= this.f2373k;
                    }
                } else if (!this.f2370h) {
                    this.f2370h = true;
                    this.f2365c.x = motionEvent.getX();
                    this.f2365c.y = motionEvent.getY();
                    this.f2366d.x = this.f2363a.m2074f();
                    this.f2366d.y = this.f2363a.m2075g();
                } else if (!this.f2386x && m2089a(motionEvent.getX(), motionEvent.getY())) {
                    this.f2363a.postInvalidate();
                }
            }
        }
        return true;
    }
}
