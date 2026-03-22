package com.gmail.heagoo.appdm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.InterfaceC1208fa;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.neweditor.EditorActivity;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.s */
/* JADX INFO: loaded from: classes.dex */
final class C1434s implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private String f4217a = null;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f4218b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f4219c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ PrefOverallActivity f4220d;

    C1434s(PrefOverallActivity prefOverallActivity, String str, String str2) {
        this.f4220d = prefOverallActivity;
        this.f4218b = str;
        this.f4219c = str2;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        this.f4217a = PrefOverallActivity.m3394a(this.f4220d, this.f4218b);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        if (this.f4217a == null) {
            Toast.makeText(this.f4220d, "Failed to open the file.", 0).show();
            return;
        }
        Intent intent = new Intent(this.f4220d, (Class<?>) EditorActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("filePath", this.f4217a);
        bundle.putString("realFilePath", this.f4218b);
        if (this.f4219c != null) {
            bundle.putString("syntaxFileName", this.f4219c);
        }
        bundle.putBoolean("isRootMode", this.f4220d.f4107G);
        bundle.putIntArray("resourceIds", new int[]{R.string.appdm_apk_file_path, R.string.appdm_apk_build_time, R.string.appdm_basic_info});
        intent.putExtras(bundle);
        this.f4220d.startActivityForResult(intent, 1000);
    }
}
