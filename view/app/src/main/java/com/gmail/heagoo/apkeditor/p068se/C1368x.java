package com.gmail.heagoo.apkeditor.p068se;

import android.app.Activity;
import android.content.Context;
import com.gmail.heagoo.apkeditor.DialogC1108ce;
import com.gmail.heagoo.apkeditor.InterfaceC1122cu;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.se.x */
/* JADX INFO: loaded from: classes.dex */
final class C1368x implements InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private WeakReference f3935a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ Activity f3936b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f3937c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ List f3938d;

    C1368x(Activity activity, String str, List list) {
        this.f3936b = activity;
        this.f3937c = str;
        this.f3938d = list;
        this.f3935a = new WeakReference(this.f3936b);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) {
        new DialogC1108ce((Context) this.f3935a.get(), this.f3937c, (String) null, (Map) null, this.f3938d, str).show();
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        return true;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return null;
    }
}
