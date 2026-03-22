package p000a.p001a.p003b.p004a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.PreferenceManager;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: a.a.b.a.n */
/* JADX INFO: loaded from: classes.dex */
public class C0040n {

    /* JADX INFO: renamed from: A */
    private static final String f97A = "aaban";

    /* JADX INFO: renamed from: B */
    static final int[] f98B = {R.layout.activity_main, R.layout.activity_main_cards};

    /* JADX INFO: renamed from: C */
    static final int[] f99C = {R.string.layout_buttons, R.string.layout_cards};

    /* JADX INFO: renamed from: b */
    public static int m94b(int i) {
        return f98B[i];
    }

    /* JADX INFO: renamed from: c */
    public static int m95c(int i) {
        return f99C[i];
    }

    /* JADX INFO: renamed from: d */
    public static int m96d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(f97A, context.getResources().getInteger(R.integer.layout_def));
    }

    /* JADX INFO: renamed from: e */
    public static void m97e(Context context, int i) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(f97A, i).commit();
    }

    /* JADX INFO: renamed from: f */
    public void m98f(Context context, int i, InterfaceC0042p interfaceC0042p) {
        String[] strArr = new String[f99C.length];
        int i2 = 0;
        while (true) {
            int[] iArr = f99C;
            if (i2 >= iArr.length) {
                int iM96d = m96d(context);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(i);
                builder.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
                builder.setSingleChoiceItems(strArr, iM96d, new DialogInterfaceOnClickListenerC0041o(this, iM96d, context, interfaceC0042p));
                builder.show();
                return;
            }
            strArr[i2] = context.getString(iArr[i2]);
            i2++;
        }
    }
}
