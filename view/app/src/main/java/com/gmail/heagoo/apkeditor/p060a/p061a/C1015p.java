package com.gmail.heagoo.apkeditor.p060a.p061a;

import android.content.Context;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1028f;
import com.gmail.heagoo.apkeditor.p063b.C1067e;
import com.gmail.heagoo.common.C1487s;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.Serializable;
import java.util.Map;
import p000a.p001a.p003b.p004a.p005a.C0027x;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.a.a.p */
/* JADX INFO: loaded from: classes.dex */
public final class C1015p implements InterfaceC1026d, Serializable {

    /* JADX INFO: renamed from: a */
    private String f2874a;

    /* JADX INFO: renamed from: b */
    private String f2875b;

    public C1015p(String str, String str2) {
        this.f2874a = str;
        this.f2875b = str2;
    }

    @Override // com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d
    /* JADX INFO: renamed from: a */
    public final void mo2692a(Context context, String str, Map map, InterfaceC1028f interfaceC1028f) {
        for (String str2 : C0027x.m35c(str, "")) {
            if (str2.endsWith(".dex")) {
                String str3 = C0985a.m2263d(context, "tmp") + C1487s.m3525a(6) + ".dex";
                if (new C1067e(str, str2).m2800a(this.f2874a, this.f2875b, str3)) {
                    map.put(str2, str3);
                }
            }
        }
    }
}
