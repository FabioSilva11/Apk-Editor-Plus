package com.gmail.heagoo.apkeditor;

import android.support.v4.internal.view.SupportMenu;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ew */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC1199ew implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ boolean f3393a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f3394b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ boolean f3395c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ DialogC1197eu f3396d;

    RunnableC1199ew(DialogC1197eu dialogC1197eu, boolean z, String str, boolean z2) {
        this.f3396d = dialogC1197eu;
        this.f3393a = z;
        this.f3394b = str;
        this.f3395c = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3393a) {
            SpannableString spannableString = new SpannableString(this.f3394b);
            spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), 0, this.f3394b.length(), 33);
            this.f3396d.f3387j.append(spannableString);
        } else {
            if (!this.f3395c) {
                this.f3396d.f3387j.append(this.f3394b);
                return;
            }
            SpannableString spannableString2 = new SpannableString(this.f3394b);
            spannableString2.setSpan(new StyleSpan(1), 0, this.f3394b.length(), 33);
            this.f3396d.f3387j.append(spannableString2);
        }
    }
}
