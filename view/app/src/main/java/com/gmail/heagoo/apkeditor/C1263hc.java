package com.gmail.heagoo.apkeditor;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.gmail.heagoo.apkeditor.pro.R;
import com.p048b.p049a.AlertDialogC0931f;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.hc */
/* JADX INFO: loaded from: classes.dex */
final class C1263hc implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C1194er f3608a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ PopupWindow f3609b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ AbstractActivityC1258gy f3610c;

    C1263hc(AbstractActivityC1258gy abstractActivityC1258gy, C1194er c1194er, PopupWindow popupWindow) {
        this.f3610c = abstractActivityC1258gy;
        this.f3608a = c1194er;
        this.f3609b = popupWindow;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (this.f3608a.m2982a(i)) {
            case 0:
                AbstractActivityC1258gy.m3128d(this.f3610c);
                break;
            case 1:
                new AlertDialogC0931f(this.f3610c, -1, this.f3610c).show();
                break;
            case 2:
                this.f3610c.f3582i = 2;
                new C1136dk().m2868a(this.f3610c, R.string.delete_lines, this.f3610c);
                break;
            case 3:
                this.f3610c.startActivity(new Intent(this.f3610c, (Class<?>) SettingEditorActivity.class));
                break;
            case 4:
                this.f3610c.startActivity(new Intent(this.f3610c, (Class<?>) AboutModActivity.class));
                break;
            case 5:
                this.f3610c.f3582i = 5;
                new C1136dk().m2868a(this.f3610c, R.string.comment_lines, this.f3610c);
                break;
            case 6:
                this.f3610c.startActivity(new Intent(this.f3610c, (Class<?>) TemplatesActivity.class));
                break;
            case 7:
                AbstractActivityC1258gy.m3132f(this.f3610c);
                break;
        }
        if (this.f3609b != null) {
            this.f3609b.dismiss();
        }
    }
}
