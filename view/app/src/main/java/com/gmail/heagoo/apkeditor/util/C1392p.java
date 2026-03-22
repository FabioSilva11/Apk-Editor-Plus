package com.gmail.heagoo.apkeditor.util;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.p */
/* JADX INFO: loaded from: classes.dex */
final class C1392p {

    /* JADX INFO: renamed from: a */
    String f4041a;

    /* JADX INFO: renamed from: b */
    List f4042b;

    private C1392p(String str, String str2, int i, String str3) {
        this.f4041a = str2;
        if (!this.f4041a.startsWith("/")) {
            this.f4041a = str + this.f4041a;
        }
        this.f4042b = new ArrayList();
        this.f4042b.add(new C1393q(this, i, str3, (byte) 0));
    }

    /* synthetic */ C1392p(String str, String str2, int i, String str3, byte b2) {
        this(str, str2, i, str3);
    }
}
