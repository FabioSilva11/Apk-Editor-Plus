package com.p016a.p019b.p020a.p022b;

import android.support.v7.appcompat.C0299R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p036f.p038b.C0761m;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0788l;
import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p036f.p039c.C0791o;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0803a;
import com.p016a.p019b.p036f.p040d.C0805c;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.a.b.aj */
/* JADX INFO: loaded from: classes.dex */
final class C0461aj implements InterfaceC0473k {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0483u f526a;

    /* JADX INFO: renamed from: b */
    private C0476n f527b = null;

    /* JADX INFO: renamed from: c */
    private int f528c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ C0460ai f529d;

    public C0461aj(C0460ai c0460ai) {
        this.f529d = c0460ai;
        this.f526a = c0460ai.f522a;
    }

    /* JADX INFO: renamed from: a */
    private void m533a(C0805c c0805c) {
        C0805c c0805cM1664a = this.f526a.mo468a().m1664a();
        if (!C0985a.m2248b(c0805cM1664a, c0805c)) {
            throw new C0459ah("return type mismatch: prototype indicates " + c0805cM1664a.mo657d() + ", but encountered type " + c0805c.mo657d());
        }
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final int mo534a() {
        return this.f528c;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo535a(int i) {
        this.f528c = i;
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo536a(int i, int i2, int i3) {
        throw new C0459ah("invalid opcode " + C0985a.m2298x(i));
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo537a(int i, int i2, int i3, int i4) {
        switch (i) {
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
                this.f526a.mo475a(this.f527b, C0805c.f2015f);
                break;
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
                this.f526a.mo476a(this.f527b, C0805c.f2015f, C0805c.f2015f);
                break;
            case 165:
            case 166:
                this.f526a.mo476a(this.f527b, C0805c.f2023n, C0805c.f2023n);
                break;
            case 167:
            case 168:
            case 200:
            case 201:
                this.f526a.mo484b();
                break;
            case 169:
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
            case 190:
            case 191:
            case 192:
            case 193:
            case 194:
            case 195:
            case 196:
            case 197:
            default:
                mo536a(i, i2, i3);
                return;
            case 198:
            case 199:
                this.f526a.mo475a(this.f527b, C0805c.f2023n);
                break;
        }
        this.f526a.mo485b(i4);
        this.f526a.mo515a(this.f527b, i2, i);
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo538a(int i, int i2, int i3, int i4, C0805c c0805c, int i5) {
        C0805c c0805c2;
        C0480r c0480rM635a = this.f529d.f524c.m635a(i == 54 ? i2 + i3 : i2, i4);
        if (c0480rM635a != null) {
            C0805c c0805cM642b = c0480rM635a.m642b();
            if (c0805cM642b.mo666e() != c0805c.mo666e()) {
                AbstractC0451a.m467a(c0805c, c0805cM642b);
                return;
            }
            c0805c2 = c0805cM642b;
        } else {
            c0805c2 = c0805c;
        }
        switch (i) {
            case 21:
            case 169:
                this.f526a.mo486b(this.f527b, i4);
                this.f526a.mo482a(c0480rM635a != null);
                this.f526a.mo479a(c0805c);
                break;
            case C0299R.styleable.AppCompatTheme_selectableItemBackground /* 54 */:
                C0761m c0761mM639a = c0480rM635a == null ? null : c0480rM635a.m639a();
                this.f526a.mo475a(this.f527b, c0805c);
                this.f526a.mo479a(c0805c);
                this.f526a.mo470a(i4, c0805c2, c0761mM639a);
                break;
            case 132:
                C0761m c0761mM639a2 = c0480rM635a != null ? c0480rM635a.m639a() : null;
                this.f526a.mo486b(this.f527b, i4);
                this.f526a.mo470a(i4, c0805c2, c0761mM639a2);
                this.f526a.mo479a(c0805c);
                this.f526a.mo469a(i5);
                this.f526a.mo478a(C0790n.m1629a(i5));
                break;
            default:
                mo536a(i, i2, i3);
                return;
        }
        this.f526a.mo515a(this.f527b, i2, i);
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo539a(int i, int i2, int i3, C0462ak c0462ak, int i4) {
        this.f526a.mo475a(this.f527b, C0805c.f2015f);
        this.f526a.mo469a(i4);
        this.f526a.mo471a(c0462ak);
        this.f526a.mo515a(this.f527b, i2, 171);
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo540a(int i, int i2, int i3, AbstractC0775a abstractC0775a, int i4) {
        AbstractC0775a abstractC0775aM1630j;
        switch (i) {
            case 179:
                this.f526a.mo475a(this.f527b, ((C0788l) abstractC0775a).mo663a());
                break;
            case 180:
            case 192:
            case 193:
                this.f526a.mo475a(this.f527b, C0805c.f2023n);
                break;
            case 181:
                this.f526a.mo476a(this.f527b, C0805c.f2023n, ((C0788l) abstractC0775a).mo663a());
                break;
            case 182:
            case 183:
                abstractC0775aM1630j = abstractC0775a;
                this.f526a.mo474a(this.f527b, ((C0798v) abstractC0775aM1630j).m1616a(false));
                abstractC0775a = abstractC0775aM1630j;
                break;
            case 184:
                this.f526a.mo474a(this.f527b, ((C0798v) abstractC0775a).m1616a(true));
                break;
            case 185:
                abstractC0775aM1630j = ((C0791o) abstractC0775a).m1630j();
                this.f526a.mo474a(this.f527b, ((C0798v) abstractC0775aM1630j).m1616a(false));
                abstractC0775a = abstractC0775aM1630j;
                break;
            case 186:
            case 187:
            case 188:
            case 190:
            case 191:
            case 194:
            case 195:
            case 196:
            default:
                this.f526a.mo484b();
                break;
            case 189:
                this.f526a.mo475a(this.f527b, C0805c.f2015f);
                break;
            case 197:
                this.f526a.mo474a(this.f527b, C0803a.m1657a(C0805c.f2018i, i4));
                break;
        }
        this.f526a.mo469a(i4);
        this.f526a.mo478a(abstractC0775a);
        this.f526a.mo515a(this.f527b, i2, i);
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo541a(int i, int i2, int i3, C0805c c0805c) {
        int i4;
        switch (i) {
            case 0:
                this.f526a.mo484b();
                break;
            case 46:
                C0805c c0805cM530a = C0460ai.m530a(c0805c, this.f527b.m622d().m607c(1));
                c0805c = c0805cM530a.m1697s();
                this.f526a.mo476a(this.f527b, c0805cM530a, C0805c.f2015f);
                break;
            case C0299R.styleable.AppCompatTheme_textAppearanceListItemSecondary /* 79 */:
                C0475m c0475mM622d = this.f527b.m622d();
                int i5 = c0805c.m1688j() ? 2 : 3;
                C0805c c0805cM607c = c0475mM622d.m607c(i5);
                boolean zM606b = c0475mM622d.m606b(i5);
                C0805c c0805cM530a2 = C0460ai.m530a(c0805c, c0805cM607c);
                if (zM606b) {
                    c0805c = c0805cM530a2.m1697s();
                }
                this.f526a.mo477a(this.f527b, c0805cM530a2, C0805c.f2015f, c0805c);
                break;
            case C0299R.styleable.AppCompatTheme_colorAccent /* 87 */:
                if (this.f527b.m622d().m607c(0).m1689k()) {
                    throw C0460ai.m528a();
                }
                this.f526a.mo473a(this.f527b, 1);
                break;
            case C0299R.styleable.AppCompatTheme_colorControlNormal /* 88 */:
            case C0299R.styleable.AppCompatTheme_colorSwitchThumbNormal /* 92 */:
                C0475m c0475mM622d2 = this.f527b.m622d();
                if (c0475mM622d2.m607c(0).m1689k()) {
                    this.f526a.mo473a(this.f527b, 1);
                    i4 = 17;
                } else {
                    if (!c0475mM622d2.m607c(1).m1688j()) {
                        throw C0460ai.m528a();
                    }
                    this.f526a.mo473a(this.f527b, 2);
                    i4 = 8481;
                }
                if (i == 92) {
                    this.f526a.mo469a(i4);
                }
                break;
            case C0299R.styleable.AppCompatTheme_colorControlActivated /* 89 */:
                if (this.f527b.m622d().m607c(0).m1689k()) {
                    throw C0460ai.m528a();
                }
                this.f526a.mo473a(this.f527b, 1);
                this.f526a.mo469a(17);
                break;
            case C0299R.styleable.AppCompatTheme_colorControlHighlight /* 90 */:
                C0475m c0475mM622d3 = this.f527b.m622d();
                if (!c0475mM622d3.m607c(0).m1688j() || !c0475mM622d3.m607c(1).m1688j()) {
                    throw C0460ai.m528a();
                }
                this.f526a.mo473a(this.f527b, 2);
                this.f526a.mo469a(530);
                break;
                break;
            case C0299R.styleable.AppCompatTheme_colorButtonNormal /* 91 */:
                C0475m c0475mM622d4 = this.f527b.m622d();
                if (c0475mM622d4.m607c(0).m1689k()) {
                    throw C0460ai.m528a();
                }
                if (c0475mM622d4.m607c(1).m1689k()) {
                    this.f526a.mo473a(this.f527b, 2);
                    this.f526a.mo469a(530);
                } else {
                    if (!c0475mM622d4.m607c(2).m1688j()) {
                        throw C0460ai.m528a();
                    }
                    this.f526a.mo473a(this.f527b, 3);
                    this.f526a.mo469a(12819);
                }
                break;
                break;
            case C0299R.styleable.AppCompatTheme_controlBackground /* 93 */:
                C0475m c0475mM622d5 = this.f527b.m622d();
                if (!c0475mM622d5.m607c(0).m1689k()) {
                    if (c0475mM622d5.m607c(1).m1689k() || c0475mM622d5.m607c(2).m1689k()) {
                        throw C0460ai.m528a();
                    }
                    this.f526a.mo473a(this.f527b, 3);
                    this.f526a.mo469a(205106);
                } else {
                    if (c0475mM622d5.m607c(2).m1689k()) {
                        throw C0460ai.m528a();
                    }
                    this.f526a.mo473a(this.f527b, 2);
                    this.f526a.mo469a(530);
                }
                break;
            case C0299R.styleable.AppCompatTheme_colorBackgroundFloating /* 94 */:
                C0475m c0475mM622d6 = this.f527b.m622d();
                if (!c0475mM622d6.m607c(0).m1689k()) {
                    if (!c0475mM622d6.m607c(1).m1688j()) {
                        throw C0460ai.m528a();
                    }
                    if (c0475mM622d6.m607c(2).m1689k()) {
                        this.f526a.mo473a(this.f527b, 3);
                        this.f526a.mo469a(205106);
                    } else {
                        if (!c0475mM622d6.m607c(3).m1688j()) {
                            throw C0460ai.m528a();
                        }
                        this.f526a.mo473a(this.f527b, 4);
                        this.f526a.mo469a(4399427);
                    }
                } else if (c0475mM622d6.m607c(2).m1689k()) {
                    this.f526a.mo473a(this.f527b, 2);
                    this.f526a.mo469a(530);
                } else {
                    if (!c0475mM622d6.m607c(3).m1688j()) {
                        throw C0460ai.m528a();
                    }
                    this.f526a.mo473a(this.f527b, 3);
                    this.f526a.mo469a(12819);
                }
                break;
            case C0299R.styleable.AppCompatTheme_alertDialogStyle /* 95 */:
                C0475m c0475mM622d7 = this.f527b.m622d();
                if (!c0475mM622d7.m607c(0).m1688j() || !c0475mM622d7.m607c(1).m1688j()) {
                    throw C0460ai.m528a();
                }
                this.f526a.mo473a(this.f527b, 2);
                this.f526a.mo469a(18);
                break;
                break;
            case C0299R.styleable.AppCompatTheme_alertDialogButtonGroupStyle /* 96 */:
            case C0299R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /* 100 */:
            case C0299R.styleable.AppCompatTheme_buttonStyle /* 104 */:
            case 108:
            case C0299R.styleable.AppCompatTheme_ratingBarStyleSmall /* 112 */:
            case 126:
            case 128:
            case 130:
                this.f526a.mo476a(this.f527b, c0805c, c0805c);
                break;
            case C0299R.styleable.AppCompatTheme_listMenuViewStyle /* 116 */:
                this.f526a.mo475a(this.f527b, c0805c);
                break;
            case 120:
            case 122:
            case 124:
                this.f526a.mo476a(this.f527b, c0805c, C0805c.f2015f);
                break;
            case 133:
            case 134:
            case 135:
            case 145:
            case 146:
            case 147:
                this.f526a.mo475a(this.f527b, C0805c.f2015f);
                break;
            case 136:
            case 137:
            case 138:
                this.f526a.mo475a(this.f527b, C0805c.f2016g);
                break;
            case 139:
            case 140:
            case 141:
                this.f526a.mo475a(this.f527b, C0805c.f2014e);
                break;
            case 142:
            case 143:
            case 144:
                this.f526a.mo475a(this.f527b, C0805c.f2013d);
                break;
            case 148:
                this.f526a.mo476a(this.f527b, C0805c.f2016g, C0805c.f2016g);
                break;
            case 149:
            case 150:
                this.f526a.mo476a(this.f527b, C0805c.f2014e, C0805c.f2014e);
                break;
            case 151:
            case 152:
                this.f526a.mo476a(this.f527b, C0805c.f2013d, C0805c.f2013d);
                break;
            case 172:
                C0805c c0805cM607c2 = c0805c == C0805c.f2023n ? this.f527b.m622d().m607c(0) : c0805c;
                this.f526a.mo475a(this.f527b, c0805c);
                m533a(c0805cM607c2);
                break;
            case 177:
                this.f526a.mo484b();
                m533a(C0805c.f2018i);
                break;
            case 190:
                C0805c c0805cM607c3 = this.f527b.m622d().m607c(0);
                if (!(c0805cM607c3.m1693o() || c0805cM607c3.equals(C0805c.f2019j))) {
                    throw new C0459ah("type mismatch: expected array type but encountered " + c0805cM607c3.mo657d());
                }
                this.f526a.mo475a(this.f527b, C0805c.f2023n);
                break;
                break;
            case 191:
            case 194:
            case 195:
                this.f526a.mo475a(this.f527b, C0805c.f2023n);
                break;
            default:
                mo536a(i, i2, i3);
                return;
        }
        this.f526a.mo479a(c0805c);
        this.f526a.mo515a(this.f527b, i2, i);
    }

    @Override // com.p016a.p019b.p020a.p022b.InterfaceC0473k
    /* JADX INFO: renamed from: a */
    public final void mo542a(int i, int i2, C0802z c0802z, ArrayList arrayList) {
        this.f526a.mo475a(this.f527b, C0805c.f2015f);
        this.f526a.mo481a(arrayList);
        this.f526a.mo478a(c0802z);
        this.f526a.mo515a(this.f527b, i, 188);
    }

    /* JADX INFO: renamed from: a */
    public final void m543a(C0476n c0476n) {
        if (c0476n == null) {
            throw new NullPointerException("frame == null");
        }
        this.f527b = c0476n;
    }
}
