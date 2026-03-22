package com.gmail.heagoo.apkeditor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1471c;
import com.gmail.heagoo.common.C1487s;
import java.io.File;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.bu */
/* JADX INFO: loaded from: classes.dex */
final class C1094bu implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private String f3108a;

    /* JADX INFO: renamed from: b */
    private String f3109b;

    /* JADX INFO: renamed from: c */
    private String f3110c;

    /* JADX INFO: renamed from: d */
    private String f3111d;

    /* JADX INFO: renamed from: e */
    private String f3112e;

    /* JADX INFO: renamed from: f */
    private String f3113f;

    /* JADX INFO: renamed from: g */
    private boolean f3114g = false;

    /* JADX INFO: renamed from: h */
    private /* synthetic */ AxmlEditActivity f3115h;

    public C1094bu(AxmlEditActivity axmlEditActivity, String str, String str2) {
        this.f3115h = axmlEditActivity;
        this.f3108a = str;
        this.f3109b = str + ".bin";
        this.f3111d = str2;
        this.f3110c = str + C1487s.m3525a(6);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        String strM2482c = AxmlEditActivity.m2482c(this.f3115h);
        C1471c c1471c = new C1471c();
        c1471c.m3494a((Object) ((strM2482c + "aaptz") + " z -I " + (strM2482c + "android.jar") + " " + this.f3108a + " " + this.f3110c + " " + this.f3115h.m2479a()), (String[]) null, (Integer) 5000, false);
        this.f3112e = c1471c.mo3493a();
        this.f3113f = c1471c.mo3497b();
        File file = new File(this.f3110c);
        if (file.exists()) {
            this.f3114g = true;
            if (file.renameTo(new File(this.f3109b))) {
                return;
            }
            file.delete();
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        if (this.f3114g && new File(this.f3109b).exists()) {
            Toast.makeText(this.f3115h, String.format(this.f3115h.getString(R.string.entry_modified), this.f3111d), 0).show();
            this.f3115h.f2656e.m3286c(this.f3111d, this.f3109b);
            this.f3115h.f2660i.setVisibility(0);
        } else {
            String str = this.f3112e;
            if (this.f3113f != null && !this.f3113f.equals("")) {
                str = this.f3113f;
            }
            new AlertDialog.Builder(this.f3115h).setTitle(R.string.error).setMessage(str).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).show();
        }
    }
}
