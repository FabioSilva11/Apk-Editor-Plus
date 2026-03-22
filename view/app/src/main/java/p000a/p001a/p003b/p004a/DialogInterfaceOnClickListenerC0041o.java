package p000a.p001a.p003b.p004a;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: renamed from: a.a.b.a.o */
/* JADX INFO: loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0041o implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C0040n f100a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ int f101b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ Context f102c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ InterfaceC0042p f103d;

    DialogInterfaceOnClickListenerC0041o(C0040n c0040n, int i, Context context, InterfaceC0042p interfaceC0042p) {
        this.f100a = c0040n;
        this.f101b = i;
        this.f102c = context;
        this.f103d = interfaceC0042p;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f101b != i) {
            C0040n.m97e(this.f102c, i);
            this.f103d.mo99a();
        }
        dialogInterface.dismiss();
    }
}
