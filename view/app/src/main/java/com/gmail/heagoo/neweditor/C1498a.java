package com.gmail.heagoo.neweditor;

import android.content.Context;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1028f;
import com.gmail.heagoo.apkeditor.p067f.AsyncTaskC1204a;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1471c;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.a */
/* JADX INFO: loaded from: classes.dex */
public class C1498a implements InterfaceC1026d, Serializable {

    /* JADX INFO: renamed from: a */
    private String f4409a;

    /* JADX INFO: renamed from: b */
    private String f4410b;

    /* JADX INFO: renamed from: c */
    private int f4411c;

    /* JADX INFO: renamed from: d */
    private int f4412d;

    public C1498a() {
    }

    public C1498a(int i, String str, String str2) {
        this.f4412d = C1508b.f4471a;
        this.f4411c = i;
        this.f4410b = str;
        this.f4409a = str2;
        if (str.length() == 0 && this.f4409a.length() > 0) {
            this.f4412d = C1508b.f4472b;
        }
        if (str.length() > 0 && this.f4409a.length() == 0) {
            this.f4412d = C1508b.f4473c;
        }
        if (str.length() <= 0 || this.f4409a.length() <= 0) {
            return;
        }
        this.f4412d = C1508b.f4474d;
    }

    @Override // com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d
    /* JADX INFO: renamed from: a */
    public void mo2692a(Context context, String str, Map map, InterfaceC1028f interfaceC1028f) throws Throwable {
        if (interfaceC1028f != null) {
            interfaceC1028f.mo2755a(context.getString(R.string.decode_dex_file));
        }
        String str2 = context.getFilesDir().getAbsolutePath() + "/decoded";
        new C1471c().mo3495a("rm -rf " + str2 + "/smali", (String[]) null, (Integer) 10000);
        new AsyncTaskC1204a(context, str, str2, null).m3007a();
        if (interfaceC1028f != null) {
            interfaceC1028f.mo2755a("");
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3605a(C1498a c1498a) {
        if (this.f4412d == C1508b.f4472b && c1498a.f4412d == C1508b.f4472b && c1498a.f4409a.length() == 1 && !Character.isWhitespace(c1498a.f4409a.charAt(0)) && this.f4411c + this.f4409a.length() == c1498a.f4411c) {
            return true;
        }
        return this.f4412d == C1508b.f4473c && c1498a.f4412d == C1508b.f4473c && c1498a.f4410b.length() == 1 && !Character.isWhitespace(c1498a.f4410b.charAt(0)) && c1498a.f4411c + c1498a.f4410b.length() == this.f4411c;
    }

    /* JADX INFO: renamed from: b */
    public final void m3606b(C1498a c1498a) {
        if (this.f4412d == C1508b.f4472b && c1498a.f4412d == C1508b.f4472b) {
            this.f4409a += c1498a.f4409a;
        }
        if (this.f4412d == C1508b.f4473c && c1498a.f4412d == C1508b.f4473c) {
            this.f4410b = c1498a.f4410b + this.f4410b;
            this.f4411c = c1498a.f4411c;
        }
    }
}
