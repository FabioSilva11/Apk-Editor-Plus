package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fy */
/* JADX INFO: loaded from: classes.dex */
final class C1232fy implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private int f3508a = 0;

    /* JADX INFO: renamed from: b */
    private String f3509b = "";

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f3510c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ DialogC1229fv f3511d;

    C1232fy(DialogC1229fv dialogC1229fv, String str) {
        this.f3511d = dialogC1229fv;
        this.f3510c = str;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() throws Throwable {
        for (String str : this.f3511d.f3504k) {
            try {
                this.f3511d.f3497d.m2974a(str, this.f3510c);
                this.f3511d.m3096b(str);
            } catch (Exception e) {
                this.f3509b += "\n" + String.format(((ApkInfoActivity) this.f3511d.f3499f.get()).getString(R.string.failed_to_modify), str);
                this.f3508a++;
            }
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        for (int i = 0; i < this.f3511d.f3497d.getGroupCount(); i++) {
            this.f3511d.f3496c.collapseGroup(i);
            this.f3511d.f3497d.m2978b(i);
        }
        String str = String.format(((ApkInfoActivity) this.f3511d.f3499f.get()).getString(R.string.str_num_modified_file), Integer.valueOf(this.f3511d.f3504k.size() - this.f3508a));
        if (this.f3508a > 0) {
            Toast.makeText((Context) this.f3511d.f3499f.get(), str + this.f3509b, 1).show();
        } else {
            Toast.makeText((Context) this.f3511d.f3499f.get(), str, 0).show();
        }
    }
}
