package com.gmail.heagoo.apkeditor;

import android.content.Context;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.eq */
/* JADX INFO: loaded from: classes.dex */
final class C1193eq {

    /* JADX INFO: renamed from: a */
    public String f3367a;

    /* JADX INFO: renamed from: b */
    public int f3368b;

    /* JADX INFO: renamed from: c */
    public int f3369c;

    /* JADX INFO: renamed from: d */
    public int f3370d;

    public C1193eq(String str, int i, int i2, int i3) {
        this.f3367a = str;
        this.f3368b = i;
        this.f3369c = i2;
        this.f3370d = i3;
    }

    /* JADX INFO: renamed from: a */
    public final String m2980a(Context context, int i) {
        if (this.f3368b < 0 && this.f3369c < 0 && this.f3370d < 0) {
            return context.getString(R.string.str_modified);
        }
        if (this.f3368b == 0 && this.f3369c == 0 && this.f3370d == 0) {
            return context.getString(R.string.str_not_modified);
        }
        int i2 = this.f3368b > 0 ? 0 : -1;
        if (i2 == i) {
            return String.format(context.getString(R.string.str_num_added_file), Integer.valueOf(this.f3368b));
        }
        if (this.f3369c > 0) {
            i2++;
        }
        if (i2 == i) {
            return String.format(context.getString(R.string.str_num_removed_file), Integer.valueOf(this.f3369c));
        }
        if (this.f3370d > 0) {
            i2++;
        }
        if (i2 == i) {
            return String.format(context.getString(R.string.str_num_modified_file), Integer.valueOf(this.f3370d));
        }
        return null;
    }
}
