package com.gmail.heagoo.p070b;

import android.content.DialogInterface;
import android.widget.EditText;
import java.util.Iterator;

/* JADX INFO: renamed from: com.gmail.heagoo.b.j */
/* JADX INFO: loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1459j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditText f4277a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f4278b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f4279c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ C1454e f4280d;

    DialogInterfaceOnClickListenerC1459j(C1454e c1454e, EditText editText, String str, String str2) {
        this.f4280d = c1454e;
        this.f4277a = editText;
        this.f4278b = str;
        this.f4279c = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        String string = this.f4277a.getText().toString();
        if (this.f4280d.m3485a(this.f4278b, this.f4279c, string)) {
            C1452c c1452c = this.f4280d.f4270e;
            String str = this.f4279c;
            synchronized (c1452c.f4258a) {
                Iterator it = c1452c.f4258a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1450a c1450a = (C1450a) it.next();
                    if (c1450a.f4255a.equals(str)) {
                        c1450a.f4255a = string;
                        break;
                    }
                }
            }
            c1452c.notifyDataSetChanged();
        }
    }
}
