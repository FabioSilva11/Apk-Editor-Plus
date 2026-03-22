package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ge */
/* JADX INFO: loaded from: classes.dex */
final class AsyncTaskC1239ge extends AsyncTask {

    /* JADX INFO: renamed from: a */
    private String f3521a;

    /* JADX INFO: renamed from: b */
    private String f3522b;

    /* JADX INFO: renamed from: c */
    private int f3523c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ DialogC1229fv f3524d;

    public AsyncTaskC1239ge(DialogC1229fv dialogC1229fv, String str, String str2, int i) {
        this.f3524d = dialogC1229fv;
        this.f3521a = str;
        this.f3522b = str2;
        this.f3523c = i;
    }

    @SuppressLint({"DefaultLocale"})
    /* JADX INFO: renamed from: a */
    private C1305ir m3099a() throws Throwable {
        BufferedReader bufferedReader;
        C1305ir c1305ir = new C1305ir();
        c1305ir.f3696a = this.f3521a;
        String lowerCase = this.f3522b.toLowerCase();
        BufferedReader bufferedReader2 = null;
        try {
            ArrayList arrayList = new ArrayList();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.f3521a)));
            try {
                int i = 1;
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    int iIndexOf = this.f3524d.f3503j ? line.indexOf(this.f3522b) : line.toLowerCase().indexOf(lowerCase);
                    if (iIndexOf != -1) {
                        arrayList.add(new C1186eh(i, iIndexOf, line));
                    }
                    i++;
                }
                c1305ir.f3697b = arrayList;
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }
            } catch (Exception e2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable th) {
                bufferedReader2 = bufferedReader;
                th = th;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return c1305ir;
    }

    @Override // android.os.AsyncTask
    @SuppressLint({"DefaultLocale"})
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3099a();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        C1305ir c1305ir = (C1305ir) obj;
        if (c1305ir.f3697b != null) {
            this.f3524d.f3497d.m2975a(c1305ir.f3696a, c1305ir.f3697b);
        }
        this.f3524d.f3496c.expandGroup(this.f3523c);
    }
}
