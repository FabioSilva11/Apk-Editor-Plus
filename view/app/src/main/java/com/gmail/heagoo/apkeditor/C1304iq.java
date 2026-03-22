package com.gmail.heagoo.apkeditor;

import java.util.TimerTask;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.iq */
/* JADX INFO: loaded from: classes.dex */
final class C1304iq extends TimerTask {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ TextEditNormalActivity f3695a;

    C1304iq(TextEditNormalActivity textEditNormalActivity) {
        this.f3695a = textEditNormalActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static int m3184a(int i) {
        int i2 = 1;
        while (i >= 10) {
            i /= 10;
            i2++;
        }
        return Math.max(2, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m3186a() {
        int lineCount = this.f3695a.f2796l.getLineCount();
        if (lineCount == 0) {
            lineCount = 1;
        }
        TextEditNormalActivity.m2595a(this.f3695a, this.f3695a.f2784Y, m3184a(lineCount));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= lineCount; i++) {
            sb.append(i);
            sb.append('\n');
        }
        this.f3695a.f2761B.setText(sb.toString());
        this.f3695a.f2761B.requestLayout();
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        int i;
        int i2 = 0;
        if (!SettingEditorActivity.m2565e(this.f3695a)) {
            this.f3695a.f2797m = 0;
            return;
        }
        if (this.f3695a.f3579f) {
            String[] strArrSplit = this.f3695a.f2796l.getText().toString().split("\n");
            TextEditNormalActivity.m2595a(this.f3695a, this.f3695a.f2784Y, m3184a(strArrSplit.length + 1));
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            int length = 0;
            while (i3 < strArrSplit.length) {
                while (true) {
                    i = i2 + 1;
                    if (i2 < this.f3695a.f2796l.m3601b(length)) {
                        sb.append('\n');
                        i2 = i;
                    }
                }
                sb.append(i3 + 1);
                sb.append('\n');
                length += strArrSplit[i3].length() + 1;
                i3++;
                i2 = i;
            }
            this.f3695a.f2761B.setText(sb.toString());
        } else {
            m3186a();
        }
        this.f3695a.f2797m = this.f3695a.f2796l.getLineCount();
    }
}
