package com.gmail.heagoo.neweditor;

import android.widget.ScrollView;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.g */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1513g implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C1511e f4495a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ EditorActivity f4496b;

    RunnableC1513g(EditorActivity editorActivity, C1511e c1511e) {
        this.f4496b = editorActivity;
        this.f4495a = c1511e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView scrollView = this.f4496b.f4364K;
        C1511e c1511e = this.f4495a;
        C1511e c1511e2 = this.f4495a;
        scrollView.scrollTo(0, 0);
    }
}
