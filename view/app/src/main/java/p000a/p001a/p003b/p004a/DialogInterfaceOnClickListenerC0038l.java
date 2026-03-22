package p000a.p001a.p003b.p004a;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: renamed from: a.a.b.a.l */
/* JADX INFO: loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0038l implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C0037k f93a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ int f94b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ Context f95c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ InterfaceC0039m f96d;

    DialogInterfaceOnClickListenerC0038l(C0037k c0037k, int i, Context context, InterfaceC0039m interfaceC0039m) {
        this.f93a = c0037k;
        this.f94b = i;
        this.f95c = context;
        this.f96d = interfaceC0039m;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f94b != i) {
            C0037k.m90e(this.f95c, i);
            this.f96d.mo93a();
        }
        dialogInterface.dismiss();
    }
}
