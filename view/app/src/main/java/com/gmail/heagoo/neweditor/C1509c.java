package com.gmail.heagoo.neweditor;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1509c {

    /* JADX INFO: renamed from: a */
    private int f4475a;

    /* JADX INFO: renamed from: b */
    private int[] f4476b = new int[16];

    /* JADX INFO: renamed from: c */
    private SharedPreferences f4477c;

    public C1509c(Context context) {
        this.f4477c = context.getSharedPreferences("editor_colors", 0);
        this.f4475a = m3631d(context, "editor_bg", 0);
        this.f4476b[0] = m3631d(context, "editor_numbers", -8355840);
        this.f4476b[1] = m3631d(context, "syntax_1", ContextCompat.getColor(context, C0037k.mdSyntax1(C0037k.m89a(context))));
        this.f4476b[2] = m3631d(context, "syntax_2", ContextCompat.getColor(context, C0037k.mdSyntax2(C0037k.m89a(context))));
        this.f4476b[3] = m3631d(context, "syntax_3", ContextCompat.getColor(context, C0037k.mdSyntax3(C0037k.m89a(context))));
        this.f4476b[4] = m3631d(context, "syntax_4", ContextCompat.getColor(context, C0037k.mdSyntax4(C0037k.m89a(context))));
        this.f4476b[5] = m3631d(context, "syntax_5", ContextCompat.getColor(context, C0037k.mdSyntax5(C0037k.m89a(context))));
        this.f4476b[6] = m3631d(context, "syntax_6", -8355712);
        this.f4476b[7] = m3631d(context, "syntax_7", -2346449);
        this.f4476b[8] = m3631d(context, "syntax_8", -47992);
        this.f4476b[9] = m3631d(context, "syntax_9", ContextCompat.getColor(context, C0037k.mdSyntax9(C0037k.m89a(context))));
    }

    /* JADX INFO: renamed from: d */
    private final int m3631d(Context context, String str, int i) {
        return this.f4477c.getBoolean("custom_colors", false) ? this.f4477c.getInt(str, i) : i;
    }

    /* JADX INFO: renamed from: a */
    public final int m3632a() {
        return this.f4475a;
    }

    /* JADX INFO: renamed from: a */
    public final int m3633a(Token token) {
        switch (token.f4408id) {
            case 1:
            case 2:
            case 3:
            case 4:
                return this.f4476b[6];
            case 5:
                return this.f4476b[2];
            case 6:
                return this.f4476b[8];
            case 7:
                return this.f4476b[7];
            case 8:
            case 9:
            case 10:
            case 11:
                return this.f4476b[1];
            case 12:
                return this.f4476b[4];
            case 13:
            case 14:
            case 15:
            case 16:
                return this.f4476b[3];
            case 17:
                return this.f4476b[5];
            case 18:
                return this.f4476b[9];
            default:
                return ViewCompat.MEASURED_STATE_MASK;
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m3634b() {
        return this.f4476b[0];
    }
}
