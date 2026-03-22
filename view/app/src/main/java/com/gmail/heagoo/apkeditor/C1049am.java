package com.gmail.heagoo.apkeditor;

import android.os.Environment;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.am */
/* JADX INFO: loaded from: classes.dex */
final class C1049am implements InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ApkInfoActivity f3006a;

    C1049am(ApkInfoActivity apkInfoActivity) {
        this.f3006a = apkInfoActivity;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) {
        String str3 = Environment.getExternalStorageDirectory().getPath() + "/ApkEditor/tmp";
        if (str3.startsWith(str)) {
            Toast.makeText(this.f3006a, R.string.select_folder_err2, 1).show();
        } else if (str.startsWith(str3)) {
            Toast.makeText(this.f3006a, R.string.select_folder_err1, 1).show();
        } else {
            this.f3006a.f2617e.m3058e(str2, str);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        return true;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return String.format(this.f3006a.getString(R.string.folder_replace_tip), str2.substring(this.f3006a.f2614b.length() + 1), str);
    }
}
