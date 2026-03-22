package com.gmail.heagoo.appdm;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.appdm.util.C1440e;
import com.gmail.heagoo.common.ccc;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.ad */
/* JADX INFO: loaded from: classes.dex */
public final class C1412ad extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private WeakReference f4154a;

    /* JADX INFO: renamed from: b */
    private String f4155b;

    /* JADX INFO: renamed from: c */
    private String f4156c;

    /* JADX INFO: renamed from: d */
    private boolean f4157d;

    /* JADX INFO: renamed from: e */
    private boolean f4158e;

    /* JADX INFO: renamed from: f */
    private List f4159f = new ArrayList();

    /* JADX INFO: renamed from: g */
    private String f4160g;

    public C1412ad(PrefOverallActivity prefOverallActivity, String str, boolean z, boolean z2) {
        this.f4154a = new WeakReference(prefOverallActivity);
        this.f4155b = str;
        this.f4157d = z;
        this.f4158e = z2;
        this.f4156c = str;
        this.f4160g = prefOverallActivity.getString(R.string.appdm_file_size) + " ";
        new C1415ag(this, this.f4156c).start();
    }

    /* JADX INFO: renamed from: a */
    protected static C1440e m3438a() {
        C1440e c1440e = new C1440e();
        c1440e.f4243a = "..";
        c1440e.f4245c = true;
        return c1440e;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List m3442b(java.lang.String r6) throws java.lang.Throwable {
        /*
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L80
            java.io.StringReader r0 = new java.io.StringReader     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L80
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L80
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L80
            java.lang.String r0 = r1.readLine()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
        L14:
            if (r0 == 0) goto L6c
            java.lang.String r4 = "\\s+"
            java.lang.String[] r4 = r0.split(r4)     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            int r0 = r4.length     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            r5 = 5
            if (r0 < r5) goto L4d
            r0 = 0
            r0 = r4[r0]     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            r5 = 0
            char r0 = r0.charAt(r5)     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            r5 = 45
            if (r0 != r5) goto L52
            com.gmail.heagoo.appdm.util.e r0 = new com.gmail.heagoo.appdm.util.e     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            r0.<init>()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            r5 = 0
            r0.f4245c = r5     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            r5 = 3
            r5 = r4[r5]     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e java.lang.Throwable -> L83
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e java.lang.Throwable -> L83
            int r5 = r5.intValue()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e java.lang.Throwable -> L83
            r0.f4244b = r5     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e java.lang.Throwable -> L83
        L41:
            if (r0 == 0) goto L4d
            int r5 = r4.length     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            int r5 = r5 + (-1)
            r4 = r4[r5]     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            r0.f4243a = r4     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            r3.add(r0)     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
        L4d:
            java.lang.String r0 = r1.readLine()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            goto L14
        L52:
            r5 = 100
            if (r0 != r5) goto L85
            com.gmail.heagoo.appdm.util.e r0 = new com.gmail.heagoo.appdm.util.e     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            r0.<init>()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            r5 = 1
            r0.f4245c = r5     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            r5 = 0
            r0.f4244b = r5     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L7e
            goto L41
        L62:
            r0 = move-exception
        L63:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L6b
            r1.close()     // Catch: java.io.IOException -> L7a
        L6b:
            return r3
        L6c:
            r1.close()     // Catch: java.io.IOException -> L70
            goto L6b
        L70:
            r0 = move-exception
            goto L6b
        L72:
            r0 = move-exception
            r1 = r2
        L74:
            if (r1 == 0) goto L79
            r1.close()     // Catch: java.io.IOException -> L7c
        L79:
            throw r0
        L7a:
            r0 = move-exception
            goto L6b
        L7c:
            r1 = move-exception
            goto L79
        L7e:
            r0 = move-exception
            goto L74
        L80:
            r0 = move-exception
            r1 = r2
            goto L63
        L83:
            r5 = move-exception
            goto L41
        L85:
            r0 = r2
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.appdm.C1412ad.m3442b(java.lang.String):java.util.List");
    }

    /* JADX INFO: renamed from: a */
    public final String m3445a(List list) {
        String str;
        synchronized (this.f4159f) {
            list.addAll(this.f4159f);
            str = this.f4156c;
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    protected final List m3446a(String str) {
        return m3447a(str, false);
    }

    /* JADX INFO: renamed from: a */
    protected final List m3447a(String str, boolean z) {
        String strMo3493a;
        if (this.f4157d) {
            ccc cccVarM3429g = ((PrefOverallActivity) this.f4154a.get()).m3429g();
            if (cccVarM3429g.mo3498a(String.format("ls -l %s", str), null, 5000, z) && (strMo3493a = cccVarM3429g.mo3493a()) != null) {
                return m3442b(strMo3493a);
            }
            ((PrefOverallActivity) this.f4154a.get()).runOnUiThread(new RunnableC1413ae(this, "Read error, please try again."));
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles == null) {
            return arrayList;
        }
        for (File file : fileArrListFiles) {
            C1440e c1440e = new C1440e();
            c1440e.f4243a = file.getName();
            c1440e.f4245c = file.isDirectory();
            c1440e.f4244b = (int) file.length();
            arrayList.add(c1440e);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public final void m3448a(String str, List list) {
        Activity activity = (Activity) this.f4154a.get();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new RunnableC1414af(this, str, list));
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f4159f.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f4159f.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1416ah c1416ah;
        C1440e c1440e = (C1440e) getItem(i);
        if (c1440e == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from((Context) this.f4154a.get()).inflate(R.layout.appdm_item_file, (ViewGroup) null);
            C1416ah c1416ah2 = new C1416ah();
            c1416ah2.f4168a = (ImageView) view.findViewById(R.id.file_icon);
            c1416ah2.f4169b = (TextView) view.findViewById(R.id.filename);
            c1416ah2.f4170c = (TextView) view.findViewById(R.id.detail1);
            view.setTag(c1416ah2);
            c1416ah = c1416ah2;
        } else {
            c1416ah = (C1416ah) view.getTag();
        }
        if (c1440e.f4245c) {
            c1416ah.f4168a.setImageResource(R.drawable.ic_file_folder);
            c1416ah.f4170c.setVisibility(8);
        } else {
            c1416ah.f4168a.setImageResource(R.drawable.ic_file_unknown);
            c1416ah.f4170c.setText(this.f4160g + c1440e.f4244b);
            c1416ah.f4170c.setVisibility(0);
        }
        c1416ah.f4169b.setText(c1440e.f4243a);
        return view;
    }
}
