package com.p048b.p049a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.b.a.f */
/* JADX INFO: loaded from: classes.dex */
public final class AlertDialogC0931f extends AlertDialog implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private C0926a f2296a;

    /* JADX INFO: renamed from: b */
    private int f2297b;

    /* JADX INFO: renamed from: c */
    private InterfaceC0930e f2298c;

    public AlertDialogC0931f(Context context, int i, InterfaceC0930e interfaceC0930e) {
        super(context);
        this.f2296a = null;
        this.f2298c = null;
        this.f2297b = i;
        this.f2298c = interfaceC0930e;
        this.f2296a = new C0926a(context);
        this.f2296a.m2044a(i);
        setView(this.f2296a);
        setButton(context.getText(R.string.colormixer_set), this);
        setButton2(context.getText(R.string.colormixer_cancel), (DialogInterface.OnClickListener) null);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.f2297b != this.f2296a.m2043a()) {
            this.f2298c.mo2045a(this.f2296a.m2043a());
        }
    }

    @Override // android.app.Dialog
    public final void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f2296a.m2044a(bundle.getInt("c"));
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.putInt("c", this.f2296a.m2043a());
        return bundleOnSaveInstanceState;
    }
}
