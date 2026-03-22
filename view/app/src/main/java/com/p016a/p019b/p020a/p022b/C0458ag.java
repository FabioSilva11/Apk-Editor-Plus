package com.p016a.p019b.p020a.p022b;

import android.support.v7.appcompat.C0299R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p020a.p025e.InterfaceC0512g;
import com.p016a.p019b.p020a.p025e.InterfaceC0513h;
import com.p016a.p019b.p036f.p038b.C0771w;
import com.p016a.p019b.p036f.p038b.C0774z;
import com.p016a.p019b.p036f.p038b.InterfaceC0749ad;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0798v;
import com.p016a.p019b.p036f.p039c.C0799w;
import com.p016a.p019b.p036f.p039c.C0801y;
import com.p016a.p019b.p036f.p039c.C0802z;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0807e;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.a.b.a.b.ag */
/* JADX INFO: loaded from: classes.dex */
final class C0458ag extends C0463al {

    /* JADX INFO: renamed from: a */
    private static final C0802z f504a = new C0802z(C0805c.m1682c("java/lang/reflect/Array"));

    /* JADX INFO: renamed from: b */
    private static final C0798v f505b = new C0798v(f504a, new C0799w(new C0801y("newInstance"), new C0801y("(Ljava/lang/Class;[I)Ljava/lang/Object;")));

    /* JADX INFO: renamed from: c */
    private final C0486x f506c;

    /* JADX INFO: renamed from: d */
    private final C0474l f507d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC0513h f508e;

    /* JADX INFO: renamed from: f */
    private final InterfaceC0749ad f509f;

    /* JADX INFO: renamed from: g */
    private final int f510g;

    /* JADX INFO: renamed from: h */
    private final ArrayList f511h;

    /* JADX INFO: renamed from: i */
    private InterfaceC0807e f512i;

    /* JADX INFO: renamed from: j */
    private boolean f513j;

    /* JADX INFO: renamed from: k */
    private boolean f514k;

    /* JADX INFO: renamed from: l */
    private int f515l;

    /* JADX INFO: renamed from: m */
    private int f516m;

    /* JADX INFO: renamed from: n */
    private boolean f517n;

    /* JADX INFO: renamed from: o */
    private boolean f518o;

    /* JADX INFO: renamed from: p */
    private C0485w f519p;

    /* JADX INFO: renamed from: q */
    private C0771w f520q;

    /* JADX INFO: renamed from: r */
    private C0774z f521r;

    public C0458ag(C0486x c0486x, C0474l c0474l, InterfaceC0749ad interfaceC0749ad, InterfaceC0513h interfaceC0513h) {
        super(c0474l.mo589g());
        if (interfaceC0513h == null) {
            throw new NullPointerException("methods == null");
        }
        if (c0486x == null) {
            throw new NullPointerException("ropper == null");
        }
        if (interfaceC0749ad == null) {
            throw new NullPointerException("advice == null");
        }
        this.f506c = c0486x;
        this.f507d = c0474l;
        this.f508e = interfaceC0513h;
        this.f509f = interfaceC0749ad;
        this.f510g = c0474l.m592j();
        this.f511h = new ArrayList(25);
        this.f512i = null;
        this.f513j = false;
        this.f514k = false;
        this.f515l = -1;
        this.f516m = 0;
        this.f518o = false;
        this.f520q = null;
        this.f521r = null;
    }

    /* JADX INFO: renamed from: a */
    private int m514a(int i, AbstractC0775a abstractC0775a) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case C0299R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /* 48 */:
            case C0299R.styleable.AppCompatTheme_spinnerDropDownItemStyle /* 49 */:
            case 50:
            case C0299R.styleable.AppCompatTheme_actionButtonStyle /* 51 */:
            case C0299R.styleable.AppCompatTheme_buttonBarStyle /* 52 */:
            case C0299R.styleable.AppCompatTheme_buttonBarButtonStyle /* 53 */:
            case C0299R.styleable.AppCompatTheme_selectableItemBackgroundBorderless /* 55 */:
            case C0299R.styleable.AppCompatTheme_borderlessButtonStyle /* 56 */:
            case C0299R.styleable.AppCompatTheme_dividerVertical /* 57 */:
            case C0299R.styleable.AppCompatTheme_dividerHorizontal /* 58 */:
            case C0299R.styleable.AppCompatTheme_activityChooserViewStyle /* 59 */:
            case C0299R.styleable.AppCompatTheme_toolbarStyle /* 60 */:
            case C0299R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /* 61 */:
            case C0299R.styleable.AppCompatTheme_popupMenuStyle /* 62 */:
            case 63:
            case 64:
            case C0299R.styleable.AppCompatTheme_editTextBackground /* 65 */:
            case C0299R.styleable.AppCompatTheme_imageButtonStyle /* 66 */:
            case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /* 67 */:
            case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /* 68 */:
            case C0299R.styleable.AppCompatTheme_textColorSearchUrl /* 69 */:
            case C0299R.styleable.AppCompatTheme_searchViewStyle /* 70 */:
            case C0299R.styleable.AppCompatTheme_listPreferredItemHeight /* 71 */:
            case C0299R.styleable.AppCompatTheme_listPreferredItemHeightSmall /* 72 */:
            case C0299R.styleable.AppCompatTheme_listPreferredItemHeightLarge /* 73 */:
            case C0299R.styleable.AppCompatTheme_listPreferredItemPaddingLeft /* 74 */:
            case C0299R.styleable.AppCompatTheme_listPreferredItemPaddingRight /* 75 */:
            case C0299R.styleable.AppCompatTheme_dropDownListViewStyle /* 76 */:
            case C0299R.styleable.AppCompatTheme_listPopupWindowStyle /* 77 */:
            case C0299R.styleable.AppCompatTheme_textAppearanceListItem /* 78 */:
            case C0299R.styleable.AppCompatTheme_textAppearanceListItemSmall /* 80 */:
            case 81:
            case C0299R.styleable.AppCompatTheme_panelMenuListWidth /* 82 */:
            case C0299R.styleable.AppCompatTheme_panelMenuListTheme /* 83 */:
            case C0299R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /* 84 */:
            case C0299R.styleable.AppCompatTheme_colorPrimary /* 85 */:
            case C0299R.styleable.AppCompatTheme_colorPrimaryDark /* 86 */:
            case C0299R.styleable.AppCompatTheme_colorAccent /* 87 */:
            case C0299R.styleable.AppCompatTheme_colorControlNormal /* 88 */:
            case C0299R.styleable.AppCompatTheme_colorControlActivated /* 89 */:
            case C0299R.styleable.AppCompatTheme_colorControlHighlight /* 90 */:
            case C0299R.styleable.AppCompatTheme_colorButtonNormal /* 91 */:
            case C0299R.styleable.AppCompatTheme_colorSwitchThumbNormal /* 92 */:
            case C0299R.styleable.AppCompatTheme_controlBackground /* 93 */:
            case C0299R.styleable.AppCompatTheme_colorBackgroundFloating /* 94 */:
            case C0299R.styleable.AppCompatTheme_alertDialogStyle /* 95 */:
            case C0299R.styleable.AppCompatTheme_alertDialogCenterButtons /* 97 */:
            case C0299R.styleable.AppCompatTheme_alertDialogTheme /* 98 */:
            case C0299R.styleable.AppCompatTheme_textColorAlertDialogListItem /* 99 */:
            case C0299R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle /* 101 */:
            case C0299R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle /* 102 */:
            case C0299R.styleable.AppCompatTheme_autoCompleteTextViewStyle /* 103 */:
            case C0299R.styleable.AppCompatTheme_buttonStyleSmall /* 105 */:
            case C0299R.styleable.AppCompatTheme_checkboxStyle /* 106 */:
            case C0299R.styleable.AppCompatTheme_checkedTextViewStyle /* 107 */:
            case 109:
            case C0299R.styleable.AppCompatTheme_ratingBarStyle /* 110 */:
            case C0299R.styleable.AppCompatTheme_ratingBarStyleIndicator /* 111 */:
            case C0299R.styleable.AppCompatTheme_seekBarStyle /* 113 */:
            case C0299R.styleable.AppCompatTheme_spinnerStyle /* 114 */:
            case C0299R.styleable.AppCompatTheme_switchStyle /* 115 */:
            case C0299R.styleable.AppCompatTheme_tooltipFrameBackground /* 117 */:
            case C0299R.styleable.AppCompatTheme_tooltipForegroundColor /* 118 */:
            case C0299R.styleable.AppCompatTheme_colorError /* 119 */:
            case 121:
            case 123:
            case 125:
            case 127:
            case 129:
            case 131:
            case 168:
            case 169:
            case 170:
            case 173:
            case 174:
            case 175:
            case 176:
            case 186:
            case 196:
            case 197:
            default:
                throw new RuntimeException("shouldn't happen");
            case 18:
            case 20:
                return 5;
            case 21:
            case C0299R.styleable.AppCompatTheme_selectableItemBackground /* 54 */:
                return 2;
            case 46:
                return 38;
            case C0299R.styleable.AppCompatTheme_textAppearanceListItemSecondary /* 79 */:
                return 39;
            case C0299R.styleable.AppCompatTheme_alertDialogButtonGroupStyle /* 96 */:
            case 132:
                return 14;
            case C0299R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /* 100 */:
                return 15;
            case C0299R.styleable.AppCompatTheme_buttonStyle /* 104 */:
                return 16;
            case 108:
                return 17;
            case C0299R.styleable.AppCompatTheme_ratingBarStyleSmall /* 112 */:
                return 18;
            case C0299R.styleable.AppCompatTheme_listMenuViewStyle /* 116 */:
                return 19;
            case 120:
                return 23;
            case 122:
                return 24;
            case 124:
                return 25;
            case 126:
                return 20;
            case 128:
                return 21;
            case 130:
                return 22;
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
                return 29;
            case 145:
                return 30;
            case 146:
                return 31;
            case 147:
                return 32;
            case 148:
            case 149:
            case 151:
                return 27;
            case 150:
            case 152:
                return 28;
            case 153:
            case 159:
            case 165:
            case 198:
                return 7;
            case 154:
            case 160:
            case 166:
            case 199:
                return 8;
            case 155:
            case 161:
                return 9;
            case 156:
            case 162:
                return 10;
            case 157:
            case 163:
                return 12;
            case 158:
            case 164:
                return 11;
            case 167:
                return 6;
            case 171:
                return 13;
            case 172:
            case 177:
                return 33;
            case 178:
                return 46;
            case 179:
                return 48;
            case 180:
                return 45;
            case 181:
                return 47;
            case 182:
                C0798v c0798v = (C0798v) abstractC0775a;
                if (c0798v.m1636k().equals(this.f507d.mo588f())) {
                    for (int i2 = 0; i2 < this.f508e.m792d_(); i2++) {
                        InterfaceC0512g interfaceC0512gMo791a = this.f508e.mo791a(i2);
                        if (C0985a.m2283k(interfaceC0512gMo791a.mo586d()) && c0798v.m1637l().equals(interfaceC0512gMo791a.mo583a())) {
                            return 52;
                        }
                    }
                }
                return 50;
            case 183:
                C0798v c0798v2 = (C0798v) abstractC0775a;
                return (c0798v2.m1637l().m1641e() || c0798v2.m1636k().equals(this.f507d.mo588f()) || !this.f507d.m590h()) ? 52 : 51;
            case 184:
                return 49;
            case 185:
                return 53;
            case 187:
                return 40;
            case 188:
            case 189:
                return 41;
            case 190:
                return 34;
            case 191:
                return 35;
            case 192:
                return 43;
            case 193:
                return 44;
            case 194:
                return 36;
            case 195:
                return 37;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0446  */
    @Override // com.p016a.p019b.p020a.p022b.C0463al, com.p016a.p019b.p020a.p022b.InterfaceC0483u
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo515a(com.p016a.p019b.p020a.p022b.C0476n r15, int r16, int r17) {
        /*
            Method dump skipped, instruction units count: 1124
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p016a.p019b.p020a.p022b.C0458ag.mo515a(com.a.b.a.b.n, int, int):void");
    }

    /* JADX INFO: renamed from: a */
    public final void m516a(InterfaceC0807e interfaceC0807e) {
        this.f512i = interfaceC0807e;
        this.f511h.clear();
        this.f513j = false;
        this.f514k = false;
        this.f515l = 0;
        this.f516m = 0;
        this.f518o = false;
        this.f517n = false;
        this.f519p = null;
    }

    /* JADX INFO: renamed from: m */
    public final ArrayList m517m() {
        return this.f511h;
    }

    /* JADX INFO: renamed from: n */
    public final C0771w m518n() {
        return this.f520q;
    }

    /* JADX INFO: renamed from: o */
    public final C0774z m519o() {
        return this.f521r;
    }

    /* JADX INFO: renamed from: p */
    public final boolean m520p() {
        return this.f513j;
    }

    /* JADX INFO: renamed from: q */
    public final boolean m521q() {
        return this.f514k;
    }

    /* JADX INFO: renamed from: r */
    public final int m522r() {
        return this.f515l;
    }

    /* JADX INFO: renamed from: s */
    public final int m523s() {
        return this.f516m;
    }

    /* JADX INFO: renamed from: t */
    public final boolean m524t() {
        return this.f518o;
    }

    /* JADX INFO: renamed from: u */
    public final boolean m525u() {
        return this.f517n;
    }

    /* JADX INFO: renamed from: v */
    public final boolean m526v() {
        return this.f519p != null;
    }

    /* JADX INFO: renamed from: w */
    public final C0485w m527w() {
        return this.f519p;
    }
}
