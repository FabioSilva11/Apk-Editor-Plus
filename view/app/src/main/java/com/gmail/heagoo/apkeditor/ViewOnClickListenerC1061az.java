package com.gmail.heagoo.apkeditor;

import android.view.View;
import android.widget.EditText;
import com.gmail.heagoo.p070b.C1450a;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.az */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1061az implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C1450a f3026a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ String f3027b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ String f3028c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ int f3029d;

    /* JADX INFO: renamed from: e */
    final /* synthetic */ ViewOnClickListenerC1057av f3030e;

    /* JADX INFO: renamed from: f */
    private /* synthetic */ EditText f3031f;

    ViewOnClickListenerC1061az(ViewOnClickListenerC1057av viewOnClickListenerC1057av, EditText editText, C1450a c1450a, String str, String str2, int i) {
        this.f3030e = viewOnClickListenerC1057av;
        this.f3031f = editText;
        this.f3026a = c1450a;
        this.f3027b = str;
        this.f3028c = str2;
        this.f3029d = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008e  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onClick(android.view.View r8) {
        /*
            r7 = this;
            r6 = 46
            r0 = 1
            r5 = -1
            r1 = 0
            android.widget.EditText r2 = r7.f3031f
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = r2.trim()
            java.lang.String r2 = ""
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L2a
            com.gmail.heagoo.apkeditor.av r0 = r7.f3030e
            com.gmail.heagoo.apkeditor.ApkInfoExActivity r0 = r0.f3019a
            r2 = 2131165293(0x7f07006d, float:1.79448E38)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r1)
            r0.show()
        L29:
            return
        L2a:
            com.gmail.heagoo.b.a r2 = r7.f3026a
            java.lang.String r2 = r2.f4255a
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L43
            com.gmail.heagoo.apkeditor.av r0 = r7.f3030e
            com.gmail.heagoo.apkeditor.ApkInfoExActivity r0 = r0.f3019a
            r2 = 2131165365(0x7f0700b5, float:1.7944945E38)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r1)
            r0.show()
            goto L29
        L43:
            com.gmail.heagoo.b.a r2 = r7.f3026a
            boolean r2 = r2.f4256b
            if (r2 != 0) goto L90
            com.gmail.heagoo.b.a r2 = r7.f3026a
            java.lang.String r2 = r2.f4255a
            int r3 = r2.lastIndexOf(r6)
            if (r3 == r5) goto L8e
            java.lang.String r2 = r2.substring(r3)
            int r3 = r4.lastIndexOf(r6)
            if (r3 != r5) goto L84
        L5d:
            if (r0 == 0) goto L90
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            com.gmail.heagoo.apkeditor.av r1 = r7.f3030e
            com.gmail.heagoo.apkeditor.ApkInfoExActivity r1 = r1.f3019a
            r0.<init>(r1)
            r1 = 2131165581(0x7f07018d, float:1.7945383E38)
            r0.setMessage(r1)
            r1 = 2131165499(0x7f07013b, float:1.7945217E38)
            com.gmail.heagoo.apkeditor.ba r2 = new com.gmail.heagoo.apkeditor.ba
            r2.<init>(r7, r4)
            r0.setPositiveButton(r1, r2)
            r1 = 2131165364(0x7f0700b4, float:1.7944943E38)
            r2 = 0
            r0.setNegativeButton(r1, r2)
            r0.show()
            goto L29
        L84:
            java.lang.String r3 = r4.substring(r3)
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L5d
        L8e:
            r0 = r1
            goto L5d
        L90:
            com.gmail.heagoo.apkeditor.av r0 = r7.f3030e
            java.lang.String r1 = r7.f3027b
            com.gmail.heagoo.b.a r2 = r7.f3026a
            java.lang.String r3 = r7.f3028c
            int r5 = r7.f3029d
            r0.m2768a(r1, r2, r3, r4, r5)
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.ViewOnClickListenerC1061az.onClick(android.view.View):void");
    }
}
