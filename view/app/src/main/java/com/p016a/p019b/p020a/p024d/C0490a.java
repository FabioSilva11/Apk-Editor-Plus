package com.p016a.p019b.p020a.p024d;

import android.support.v7.appcompat.C0299R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p025e.C0514i;
import com.p016a.p019b.p020a.p025e.InterfaceC0515j;
import com.p016a.p019b.p036f.p037a.C0740a;
import com.p016a.p019b.p036f.p037a.C0742c;
import com.p016a.p019b.p036f.p037a.C0743d;
import com.p016a.p019b.p036f.p037a.C0744e;
import com.p016a.p019b.p036f.p037a.EnumC0741b;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0779c;
import com.p016a.p019b.p036f.p039c.C0780d;
import com.p016a.p019b.p036f.p039c.C0781e;
import com.p016a.p019b.p036f.p039c.C0783g;
import com.p016a.p019b.p036f.p039c.C0784h;
import com.p016a.p019b.p036f.p039c.C0785i;
import com.p016a.p019b.p036f.p039c.C0786j;
import com.p016a.p019b.p036f.p039c.C0787k;
import com.p016a.p019b.p036f.p039c.C0789m;
import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p036f.p039c.C0796t;
import com.p016a.p019b.p036f.p039c.C0799w;
import com.p016a.p019b.p036f.p039c.C0800x;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p039c.InterfaceC0778b;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p043h.C0873c;
import com.p016a.p019b.p043h.C0874d;
import java.io.IOException;

/* JADX INFO: renamed from: com.a.b.a.d.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0490a {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0778b f607a;

    /* JADX INFO: renamed from: b */
    private final C0873c f608b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC0515j f609c;

    /* JADX INFO: renamed from: d */
    private final C0874d f610d;

    /* JADX INFO: renamed from: e */
    private int f611e;

    public C0490a(C0500k c0500k, int i, int i2, InterfaceC0515j interfaceC0515j) {
        if (c0500k == null) {
            throw new NullPointerException("cf == null");
        }
        this.f607a = c0500k.m750g();
        this.f609c = interfaceC0515j;
        this.f608b = c0500k.m745b().m1959a(i, i + i2);
        this.f610d = this.f608b.m1962b();
        this.f611e = 0;
    }

    /* JADX INFO: renamed from: a */
    private void m711a(int i) {
        if (this.f610d.available() < i) {
            throw new C0514i("truncated annotation attribute");
        }
    }

    /* JADX INFO: renamed from: a */
    private void m712a(int i, String str) {
        this.f611e += i;
    }

    /* JADX INFO: renamed from: b */
    private AbstractC0775a m713b() {
        int unsignedByte = this.f610d.readUnsignedByte();
        if (this.f609c != null) {
            m712a(1, "tag: " + new C0801y(Character.toString((char) unsignedByte)).m1648i());
        }
        switch (unsignedByte) {
            case 64:
                return new C0779c(m716d(EnumC0741b.EMBEDDED));
            case C0299R.styleable.AppCompatTheme_imageButtonStyle /* 66 */:
                return C0784h.m1622a(((C0790n) m715c()).mo1632j());
            case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /* 67 */:
                C0790n c0790n = (C0790n) m715c();
                c0790n.mo1632j();
                return C0785i.m1624a(c0790n.mo1632j());
            case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /* 68 */:
                return (C0786j) m715c();
            case C0299R.styleable.AppCompatTheme_searchViewStyle /* 70 */:
                return (C0789m) m715c();
            case C0299R.styleable.AppCompatTheme_listPreferredItemHeightLarge /* 73 */:
                return (C0790n) m715c();
            case C0299R.styleable.AppCompatTheme_listPreferredItemPaddingLeft /* 74 */:
                return (C0796t) m715c();
            case C0299R.styleable.AppCompatTheme_panelMenuListTheme /* 83 */:
                return C0800x.m1643a(((C0790n) m715c()).mo1632j());
            case C0299R.styleable.AppCompatTheme_colorControlHighlight /* 90 */:
                return C0783g.m1619a(((C0790n) m715c()).mo1632j());
            case C0299R.styleable.AppCompatTheme_colorButtonNormal /* 91 */:
                m711a(2);
                int unsignedShort = this.f610d.readUnsignedShort();
                C0781e c0781e = new C0781e(unsignedShort);
                if (this.f609c != null) {
                    m712a(2, "num_values: " + unsignedShort);
                }
                for (int i = 0; i < unsignedShort; i++) {
                    if (this.f609c != null) {
                        m712a(0, "element_value[" + i + "]:");
                    }
                    c0781e.m1615a(i, m713b());
                }
                c0781e.mo549b_();
                return new C0780d(c0781e);
            case C0299R.styleable.AppCompatTheme_textColorAlertDialogListItem /* 99 */:
                C0805c c0805cM1681b = C0805c.m1681b(((C0801y) this.f607a.mo1607a(this.f610d.readUnsignedShort())).m1649j());
                if (this.f609c != null) {
                    m712a(2, "class_info: " + c0805cM1681b.mo657d());
                }
                return new C0802z(c0805cM1681b);
            case C0299R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle /* 101 */:
                m711a(4);
                int unsignedShort2 = this.f610d.readUnsignedShort();
                int unsignedShort3 = this.f610d.readUnsignedShort();
                C0801y c0801y = (C0801y) this.f607a.mo1607a(unsignedShort2);
                C0801y c0801y2 = (C0801y) this.f607a.mo1607a(unsignedShort3);
                if (this.f609c != null) {
                    m712a(2, "type_name: " + c0801y.mo657d());
                    m712a(2, "const_name: " + c0801y2.mo657d());
                }
                return new C0787k(new C0799w(c0801y2, c0801y));
            case C0299R.styleable.AppCompatTheme_switchStyle /* 115 */:
                return m715c();
            default:
                throw new C0514i("unknown annotation tag: " + C0985a.m2298x(unsignedByte));
        }
    }

    /* JADX INFO: renamed from: c */
    private C0742c m714c(EnumC0741b enumC0741b) {
        int unsignedShort = this.f610d.readUnsignedShort();
        if (this.f609c != null) {
            m712a(2, "num_annotations: " + C0985a.m2296v(unsignedShort));
        }
        C0742c c0742c = new C0742c();
        for (int i = 0; i < unsignedShort; i++) {
            if (this.f609c != null) {
                m712a(0, "annotations[" + i + "]:");
            }
            c0742c.m1448a(m716d(enumC0741b));
        }
        c0742c.mo549b_();
        return c0742c;
    }

    /* JADX INFO: renamed from: c */
    private AbstractC0775a m715c() {
        AbstractC0775a abstractC0775aMo1607a = this.f607a.mo1607a(this.f610d.readUnsignedShort());
        if (this.f609c != null) {
            m712a(2, "constant_value: " + (abstractC0775aMo1607a instanceof C0801y ? ((C0801y) abstractC0775aMo1607a).m1648i() : abstractC0775aMo1607a.mo657d()));
        }
        return abstractC0775aMo1607a;
    }

    /* JADX INFO: renamed from: d */
    private C0740a m716d(EnumC0741b enumC0741b) {
        m711a(4);
        int unsignedShort = this.f610d.readUnsignedShort();
        int unsignedShort2 = this.f610d.readUnsignedShort();
        C0802z c0802z = new C0802z(C0805c.m1679a(((C0801y) this.f607a.mo1607a(unsignedShort)).m1649j()));
        if (this.f609c != null) {
            m712a(2, "type: " + c0802z.mo657d());
            m712a(2, "num_elements: " + unsignedShort2);
        }
        C0740a c0740a = new C0740a(c0802z, enumC0741b);
        for (int i = 0; i < unsignedShort2; i++) {
            if (this.f609c != null) {
                m712a(0, "elements[" + i + "]:");
            }
            m711a(5);
            C0801y c0801y = (C0801y) this.f607a.mo1607a(this.f610d.readUnsignedShort());
            if (this.f609c != null) {
                m712a(2, "element_name: " + c0801y.mo657d());
                m712a(0, "value: ");
            }
            c0740a.m1440b(new C0744e(c0801y, m713b()));
        }
        c0740a.mo549b_();
        return c0740a;
    }

    /* JADX INFO: renamed from: a */
    public final C0743d m717a(EnumC0741b enumC0741b) {
        try {
            int unsignedByte = this.f610d.readUnsignedByte();
            if (this.f609c != null) {
                m712a(1, "num_parameters: " + C0985a.m2298x(unsignedByte));
            }
            C0743d c0743d = new C0743d(unsignedByte);
            for (int i = 0; i < unsignedByte; i++) {
                if (this.f609c != null) {
                    m712a(0, "parameter_annotations[" + i + "]:");
                }
                c0743d.m1453a(i, m714c(enumC0741b));
            }
            c0743d.mo549b_();
            if (this.f610d.available() != 0) {
                throw new C0514i("extra data in attribute");
            }
            return c0743d;
        } catch (IOException e) {
            throw new RuntimeException("shouldn't happen", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0775a m718a() {
        try {
            AbstractC0775a abstractC0775aM713b = m713b();
            if (this.f610d.available() != 0) {
                throw new C0514i("extra data in attribute");
            }
            return abstractC0775aM713b;
        } catch (IOException e) {
            throw new RuntimeException("shouldn't happen", e);
        }
    }

    /* JADX INFO: renamed from: b */
    public final C0742c m719b(EnumC0741b enumC0741b) {
        try {
            C0742c c0742cM714c = m714c(enumC0741b);
            if (this.f610d.available() != 0) {
                throw new C0514i("extra data in attribute");
            }
            return c0742cM714c;
        } catch (IOException e) {
            throw new RuntimeException("shouldn't happen", e);
        }
    }
}
