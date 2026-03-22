package com.gmail.heagoo.apkeditor;

import android.content.Context;
import com.gmail.heagoo.common.C1487s;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fh */
/* JADX INFO: loaded from: classes.dex */
final class C1215fh implements InterfaceC1208fa {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f3448a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f3449b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ C1213ff f3450c;

    C1215fh(C1213ff c1213ff, String str, String str2) {
        this.f3450c = c1213ff;
        this.f3448a = str;
        this.f3449b = str2;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: a */
    public final void mo2530a() {
        File file = new File(this.f3448a);
        if (file.exists()) {
            List listM3018a = this.f3450c.m3018a(file);
            if (listM3018a != null) {
                Iterator it = listM3018a.iterator();
                while (it.hasNext()) {
                    this.f3450c.m3035l(((String) it.next()).substring(this.f3450c.f3435e.length() + 1));
                }
            }
            for (Map.Entry entry : this.f3450c.m3020a(new File(this.f3449b), file, this.f3448a.substring(this.f3450c.f3435e.length() + 1)).entrySet()) {
                this.f3450c.m3029g((String) entry.getKey(), (String) entry.getValue());
            }
            return;
        }
        String strSubstring = this.f3448a.substring(this.f3450c.f3435e.length() + 1);
        List listM3070c = this.f3450c.f3443m.m3070c(strSubstring.split("/"));
        if (listM3070c != null) {
            Iterator it2 = listM3070c.iterator();
            while (it2.hasNext()) {
                this.f3450c.m3035l((String) it2.next());
            }
        }
        for (Map.Entry entry2 : this.f3450c.m3020a(new File(this.f3449b), new File(C0985a.m2263d((Context) this.f3450c.f3431a.get(), "tmp") + C1487s.m3525a(6)), strSubstring).entrySet()) {
            this.f3450c.f3443m.m3068a(((String) entry2.getKey()).split("/"), true);
            this.f3450c.m3029g((String) entry2.getKey(), (String) entry2.getValue());
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1208fa
    /* JADX INFO: renamed from: b */
    public final void mo2531b() {
    }
}
