package com.p016a.p019b.p043h;

import android.support.v7.widget.ActivityChooserView;
import java.io.FilterWriter;
import java.io.Writer;

/* JADX INFO: renamed from: com.a.b.h.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0878h extends FilterWriter {

    /* JADX INFO: renamed from: a */
    private final String f2239a;

    /* JADX INFO: renamed from: b */
    private final int f2240b;

    /* JADX INFO: renamed from: c */
    private final int f2241c;

    /* JADX INFO: renamed from: d */
    private int f2242d;

    /* JADX INFO: renamed from: e */
    private boolean f2243e;

    /* JADX INFO: renamed from: f */
    private int f2244f;

    public C0878h(Writer writer, int i) {
        this(writer, i, "");
    }

    public C0878h(Writer writer, int i, String str) {
        super(writer);
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("width < 0");
        }
        if (str == null) {
            throw new NullPointerException("prefix == null");
        }
        this.f2240b = i != 0 ? i : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f2241c = i >> 1;
        this.f2239a = str.length() == 0 ? null : str;
        m1981a();
    }

    /* JADX INFO: renamed from: a */
    private void m1981a() {
        this.f2242d = 0;
        this.f2243e = this.f2241c != 0;
        this.f2244f = 0;
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public final void write(int i) {
        synchronized (this.lock) {
            if (this.f2243e) {
                if (i == 32) {
                    this.f2244f++;
                    if (this.f2244f >= this.f2241c) {
                        this.f2244f = this.f2241c;
                        this.f2243e = false;
                    }
                } else {
                    this.f2243e = false;
                }
            }
            if (this.f2242d == this.f2240b && i != 10) {
                this.out.write(10);
                this.f2242d = 0;
            }
            if (this.f2242d == 0) {
                if (this.f2239a != null) {
                    this.out.write(this.f2239a);
                }
                if (!this.f2243e) {
                    for (int i2 = 0; i2 < this.f2244f; i2++) {
                        this.out.write(32);
                    }
                    this.f2242d = this.f2244f;
                }
            }
            this.out.write(i);
            if (i == 10) {
                m1981a();
            } else {
                this.f2242d++;
            }
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public final void write(String str, int i, int i2) {
        synchronized (this.lock) {
            while (i2 > 0) {
                write(str.charAt(i));
                i++;
                i2--;
            }
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        synchronized (this.lock) {
            while (i2 > 0) {
                write(cArr[i]);
                i++;
                i2--;
            }
        }
    }
}
