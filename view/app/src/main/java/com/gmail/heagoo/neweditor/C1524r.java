package com.gmail.heagoo.neweditor;

import java.util.TimerTask;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.r */
/* JADX INFO: loaded from: classes.dex */
final class C1524r extends TimerTask {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ EditorActivity f4509a;

    C1524r(EditorActivity editorActivity) {
        this.f4509a = editorActivity;
    }

    /* JADX INFO: renamed from: a */
    protected static int m3653a(int i) {
        int i2 = 1;
        while (i >= 10) {
            i /= 10;
            i2++;
        }
        return Math.max(2, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m3654a() {
        int lineCount = this.f4509a.f4377a.getLineCount();
        if (lineCount == 0) {
            lineCount = 1;
        }
        this.f4509a.m3568a(this.f4509a.f4370Q, m3653a(lineCount));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= lineCount; i++) {
            sb.append(i);
            sb.append('\n');
        }
        this.f4509a.f4393u.setText(sb.toString());
        this.f4509a.f4393u.requestLayout();
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        int i;
        int i2 = 0;
        try {
            if (this.f4509a.f4384l) {
                String[] strArrSplit = (String.valueOf(this.f4509a.f4377a.getText().toString()) + "\nEND").split("\n");
                this.f4509a.m3568a(this.f4509a.f4370Q, m3653a(strArrSplit.length));
                StringBuilder sb = new StringBuilder();
                int i3 = 0;
                int length = 0;
                while (i3 < strArrSplit.length - 1) {
                    while (true) {
                        i = i2 + 1;
                        if (i2 < this.f4509a.f4377a.m3601b(length)) {
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
                this.f4509a.f4393u.setText(sb.toString());
            } else {
                m3654a();
            }
        } catch (Exception e) {
        }
        this.f4509a.f4378b = this.f4509a.f4377a.getLineCount();
    }
}
