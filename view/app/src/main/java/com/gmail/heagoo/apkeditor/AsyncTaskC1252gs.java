package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gs */
/* JADX INFO: loaded from: classes.dex */
final class AsyncTaskC1252gs extends AsyncTask {

    /* JADX INFO: renamed from: a */
    private WeakReference f3550a;

    /* JADX INFO: renamed from: b */
    private String f3551b;

    /* JADX INFO: renamed from: c */
    private String f3552c;

    /* JADX INFO: renamed from: d */
    private View f3553d;

    /* JADX INFO: renamed from: e */
    private List f3554e = new ArrayList();

    /* JADX INFO: renamed from: f */
    private int f3555f;

    /* JADX INFO: renamed from: g */
    private /* synthetic */ C1249gp f3556g;

    AsyncTaskC1252gs(C1249gp c1249gp, Activity activity, String str, String str2, View view) {
        this.f3556g = c1249gp;
        this.f3555f = -1;
        this.f3550a = new WeakReference(activity);
        this.f3551b = str;
        this.f3552c = str2;
        this.f3553d = view;
        if (str.endsWith(".smali")) {
            this.f3555f = 0;
        } else if (str.endsWith(".java")) {
            this.f3555f = 1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: renamed from: a */
    private Boolean m3113a() {
        int i = 0;
        BufferedReader bufferedReader = new BufferedReader(new StringReader(this.f3552c));
        try {
            switch (this.f3555f) {
                case 0:
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            if (line.startsWith(".method ")) {
                                this.f3554e.add(new C1248go(i, line.substring(8)));
                            }
                            i++;
                        }
                        break;
                    }
                    break;
                case 1:
                    while (true) {
                        int i2 = i;
                        String line2 = bufferedReader.readLine();
                        if (line2 != null) {
                            String strTrim = line2.trim();
                            if (strTrim.length() > 6 && strTrim.charAt(0) == 'p' && (strTrim.charAt(1) == 'u' || strTrim.charAt(1) == 'r')) {
                                Matcher matcher = Pattern.compile("(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])").matcher(strTrim);
                                if (matcher.matches()) {
                                    String strGroup = matcher.group(0);
                                    if (strGroup.endsWith("{")) {
                                        strGroup = strGroup.substring(0, strGroup.length() - 1).trim();
                                    }
                                    this.f3554e.add(new C1248go(i2, strGroup));
                                }
                            }
                            i = i2 + 1;
                        }
                        break;
                    }
                    break;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3113a();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        C1249gp.m3108a(this.f3556g, (Activity) this.f3550a.get(), this.f3551b, this.f3554e);
        this.f3556g.m3112a(this.f3553d);
    }
}
