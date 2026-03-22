package com.gmail.heagoo.apkeditor.util;

import android.app.Activity;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.ApkComposeActivity;
import com.gmail.heagoo.apkeditor.InterfaceC1208fa;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.e */
/* JADX INFO: loaded from: classes.dex */
final class C1381e implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Activity f4009a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ C1380d f4010b;

    C1381e(C1380d c1380d, Activity activity) {
        this.f4010b = c1380d;
        this.f4009a = activity;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        this.f4010b.f4006d.mo3340b();
        C1380d c1380d = this.f4010b;
        Map mapMo3342d = this.f4010b.f4006d.mo3342d();
        if (mapMo3342d != null) {
            for (Map.Entry entry : mapMo3342d.entrySet()) {
                String str = (String) entry.getKey();
                Map map = (Map) c1380d.f4003a.get(str);
                if (map == null) {
                    c1380d.f4003a.put(str, entry.getValue());
                } else {
                    map.putAll((Map) entry.getValue());
                }
            }
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        if (!this.f4010b.f4006d.mo3341c()) {
            Toast.makeText(this.f4009a, R.string.str_fix_failed, 0).show();
            return;
        }
        Toast.makeText(this.f4009a, this.f4010b.f4006d.mo3337a(this.f4009a), 0).show();
        ((ApkComposeActivity) this.f4009a).m2338c();
    }
}
