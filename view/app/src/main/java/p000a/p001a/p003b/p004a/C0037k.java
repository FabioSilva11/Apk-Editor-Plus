package p000a.p001a.p003b.p004a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.PreferenceManager;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: a.a.b.a.k */
/* JADX INFO: loaded from: classes.dex */
public class C0037k {

    /* JADX INFO: renamed from: A */
    private static final String f90A = "aabak";

    /* JADX INFO: renamed from: MD */
    static final int[] f91MD = {R.style.MD_DayNight, R.style.MD_Light, R.style.MD_Dark, R.style.MD_Black};
    static final int[] MD_GOOGLE_BTN_TEXT = {R.color.dn_google_btn_text, R.color.light_google_btn_text, R.color.dark_google_btn_text, R.color.black_google_btn_text};
    static final int[] MD_MAIN = {R.style.MD_DayNight_Main, R.style.MD_Light_Main, R.style.MD_Dark_Main, R.style.MD_Black_Main};
    static final int[] MD_NAMES = {R.string.theme_system, R.string.theme_light, R.string.theme_dark, R.string.theme_black};
    static final int[] MD_NAV_ACTIVATED = {R.color.dn_nav_activated, R.color.light_nav_activated, R.color.dark_nav_activated, R.color.black_nav_activated};
    static final int[] MD_NAV_NORMAL = {R.color.dn_nav_normal, R.color.light_nav_normal, R.color.dark_nav_normal, R.color.black_nav_normal};
    static final int[] MD_NOACTIONBAR = {R.style.MD_DayNight_NoActionBar, R.style.MD_Light_NoActionBar, R.style.MD_Dark_NoActionBar, R.style.MD_Black_NoActionBar};
    static final int[] MD_PATCHED = {R.color.dn_patched, R.color.light_patched, R.color.dark_patched, R.color.black_patched};
    static final int[] MD_PROGRESS = {R.color.dn_progress, R.color.light_progress, R.color.dark_progress, R.color.black_progress};
    static final int[] MD_TEXT_MEDIUM = {R.color.dn_text_medium, R.color.light_text_medium, R.color.dark_text_medium, R.color.black_text_medium};
    static final int[] MD_TEXT_SMALL = {R.color.dn_text_small, R.color.light_text_small, R.color.dark_text_small, R.color.black_text_small};
    static final int[] MD_SYNTAX_1 = {R.color.dn_syntax_1, R.color.light_syntax_1, R.color.dark_syntax_1, R.color.dark_syntax_1};
    static final int[] MD_SYNTAX_2 = {R.color.dn_syntax_2, R.color.light_syntax_2, R.color.dark_syntax_2, R.color.dark_syntax_2};
    static final int[] MD_SYNTAX_3 = {R.color.dn_syntax_3, R.color.light_syntax_3, R.color.dark_syntax_3, R.color.dark_syntax_3};
    static final int[] MD_SYNTAX_4 = {R.color.dn_syntax_4, R.color.light_syntax_4, R.color.dark_syntax_4, R.color.dark_syntax_4};
    static final int[] MD_SYNTAX_5 = {R.color.dn_syntax_5, R.color.light_syntax_5, R.color.dark_syntax_5, R.color.dark_syntax_5};
    static final int[] MD_SYNTAX_9 = {R.color.dn_syntax_9, R.color.light_syntax_9, R.color.dark_syntax_9, R.color.dark_syntax_9};
    static final int[] MD_RIPPLE = {R.color.dn_ripple, R.color.light_ripple, R.color.dark_ripple, R.color.black_ripple};
    static final int[] MD_ACCENT = {R.color.dn_accent, R.color.light_accent, R.color.dark_accent, R.color.black_accent};

    /* JADX INFO: renamed from: md */
    public static boolean f92md = false;

    /* JADX INFO: renamed from: a */
    public static int m89a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(f90A, context.getResources().getInteger(R.integer.theme_def));
    }

    /* JADX INFO: renamed from: e */
    public static void m90e(Context context, int i) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(f90A, i).commit();
    }

    /* JADX INFO: renamed from: md */
    public static int m91md(int i) {
        return f91MD[i];
    }

    public static int mdAccent(int i) {
        return MD_ACCENT[i];
    }

    public static int mdGoogleBtnText(int i) {
        return MD_GOOGLE_BTN_TEXT[i];
    }

    public static int mdMain(int i) {
        return MD_MAIN[i];
    }

    public static int mdNames(int i) {
        return MD_NAMES[i];
    }

    public static int mdNavActivated(int i) {
        return MD_NAV_ACTIVATED[i];
    }

    public static int mdNavNormal(int i) {
        return MD_NAV_NORMAL[i];
    }

    public static int mdNoActionBar(int i) {
        return MD_NOACTIONBAR[i];
    }

    public static int mdPatched(int i) {
        return MD_PATCHED[i];
    }

    public static int mdProgress(int i) {
        return MD_PROGRESS[i];
    }

    public static int mdRipple(int i) {
        return MD_RIPPLE[i];
    }

    public static int mdSyntax1(int i) {
        return MD_SYNTAX_1[i];
    }

    public static int mdSyntax2(int i) {
        return MD_SYNTAX_2[i];
    }

    public static int mdSyntax3(int i) {
        return MD_SYNTAX_3[i];
    }

    public static int mdSyntax4(int i) {
        return MD_SYNTAX_4[i];
    }

    public static int mdSyntax5(int i) {
        return MD_SYNTAX_5[i];
    }

    public static int mdSyntax9(int i) {
        return MD_SYNTAX_9[i];
    }

    public static int mdTextMedium(int i) {
        return MD_TEXT_MEDIUM[i];
    }

    public static int mdTextSmall(int i) {
        return MD_TEXT_SMALL[i];
    }

    /* JADX INFO: renamed from: f */
    public void m92f(Context context, int i, InterfaceC0039m interfaceC0039m) {
        String[] strArr = new String[MD_NAMES.length];
        int i2 = 0;
        while (true) {
            int[] iArr = MD_NAMES;
            if (i2 >= iArr.length) {
                int iM89a = m89a(context);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(i);
                builder.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
                builder.setSingleChoiceItems(strArr, iM89a, new DialogInterfaceOnClickListenerC0038l(this, iM89a, context, interfaceC0039m));
                builder.show();
                return;
            }
            strArr[i2] = context.getString(iArr[i2]);
            i2++;
        }
    }
}
