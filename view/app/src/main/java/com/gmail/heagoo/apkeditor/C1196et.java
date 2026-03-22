package com.gmail.heagoo.apkeditor;

import android.widget.Toast;
import com.gmail.heagoo.apkeditor.util.C1400x;
import com.gmail.heagoo.common.C1469a;
import com.gmail.heagoo.common.C1470b;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.et */
/* JADX INFO: loaded from: classes.dex */
final class C1196et implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private String f3376a;

    /* JADX INFO: renamed from: b */
    private String f3377b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ OdexPatchActivity f3378c;

    C1196et(OdexPatchActivity odexPatchActivity) {
        this.f3378c = odexPatchActivity;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() throws Exception {
        new C1469a();
        C1470b c1470bM3488a = C1469a.m3488a(this.f3378c, this.f3378c.f2726b);
        if (c1470bM3488a == null) {
            return;
        }
        C1400x c1400x = new C1400x(c1470bM3488a.f4291b);
        c1400x.m3379a(this.f3378c, this.f3378c.f2726b);
        this.f3377b = c1400x.f4066b;
        if (c1400x.f4065a != null) {
            this.f3376a = c1400x.f4065a;
            throw new Exception(this.f3376a);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
        if (this.f3376a == null) {
            Toast.makeText(this.f3378c, "Patched to " + this.f3377b, 1).show();
        }
    }
}
