package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p048b.p049a.AlertDialogC0931f;
import com.p048b.p049a.C0932g;
import com.p048b.p049a.C0933h;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class ColorXmlActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    private String f2663a;

    /* JADX INFO: renamed from: b */
    private ArrayList f2664b;

    /* JADX INFO: renamed from: c */
    private C0933h f2665c;

    /* JADX INFO: renamed from: d */
    private RelativeLayout f2666d;

    /* JADX WARN: Removed duplicated region for block: B:40:0x008c  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m2488a() throws java.lang.Throwable {
        /*
            r8 = this;
            r1 = 0
            r6 = -1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r8.f2664b = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7b
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7b
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7b
            java.lang.String r4 = r8.f2663a     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7b
            r3.<init>(r4)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7b
            r2.<init>(r3)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7b
            r0.<init>(r2)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7b
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L8a
        L1e:
            if (r2 == 0) goto L55
            java.lang.String r3 = "<color name=\""
            int r3 = r2.indexOf(r3)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L8a
            if (r3 == r6) goto L8c
            int r3 = r3 + 13
            java.lang.String r4 = "\">"
            int r4 = r2.indexOf(r4, r3)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L8a
            if (r4 == r6) goto L8c
            java.lang.String r3 = r2.substring(r3, r4)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L8a
            int r4 = r4 + 2
            java.lang.String r5 = "</color>"
            int r5 = r2.indexOf(r5, r4)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L8a
            if (r5 == r6) goto L8c
            java.lang.String r4 = r2.substring(r4, r5)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L8a
            com.b.a.g r2 = new com.b.a.g     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L8a
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L8a
        L49:
            if (r2 == 0) goto L50
            java.util.ArrayList r3 = r8.f2664b     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L8a
            r3.add(r2)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L8a
        L50:
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L8a
            goto L1e
        L55:
            r0.close()     // Catch: java.io.IOException -> L80
        L58:
            r0 = 0
            r1 = r0
        L5a:
            java.util.ArrayList r0 = r8.f2664b
            int r0 = r0.size()
            if (r1 >= r0) goto L84
            java.util.ArrayList r0 = r8.f2664b
            java.lang.Object r0 = r0.get(r1)
            com.b.a.g r0 = (com.p048b.p049a.C0932g) r0
            java.util.ArrayList r2 = r8.f2664b
            r0.m2046a(r8, r2)
            int r0 = r1 + 1
            r1 = r0
            goto L5a
        L73:
            r0 = move-exception
            r0 = r1
        L75:
            r0.close()     // Catch: java.io.IOException -> L79
            goto L58
        L79:
            r0 = move-exception
            goto L58
        L7b:
            r0 = move-exception
        L7c:
            r1.close()     // Catch: java.io.IOException -> L82
        L7f:
            throw r0
        L80:
            r0 = move-exception
            goto L58
        L82:
            r1 = move-exception
            goto L7f
        L84:
            return
        L85:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L7c
        L8a:
            r1 = move-exception
            goto L75
        L8c:
            r2 = r1
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.ColorXmlActivity.m2488a():void");
    }

    /* JADX INFO: renamed from: b */
    private void m2489b() {
        Intent intent = new Intent();
        intent.putExtra("xmlPath", this.f2663a);
        intent.putExtra("extraString", "res/values/colors.xml");
        setResult(1, intent);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.widget.Button, android.widget.RelativeLayout] */
    /* JADX INFO: renamed from: a */
    protected final void m2490a(int i, int i2) {
        if (i < this.f2664b.size()) {
            C0932g c0932g = (C0932g) this.f2664b.get(i);
            c0932g.f2301c = i2;
            c0932g.f2300b = "#" + Integer.toHexString(i2);
            this.f2666d.setVisibility(0);
            this.f2665c.notifyDataSetChanged();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        switch (i) {
            case 0:
                if (i2 != 0) {
                    m2488a();
                    this.f2665c.m2047a(this.f2664b);
                    m2489b();
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        BufferedWriter bufferedWriter;
        BufferedWriter id = view.getId();
        if (id == R.id.btn_close) {
            finish();
            return;
        }
        try {
            if (id != R.id.btn_save) {
                if (id == R.id.btn_openeditor) {
                    Intent intentM2177a = C0985a.m2177a(this, this.f2663a, (String) null);
                    C0985a.m2180a(intentM2177a, "syntaxFileName", "xml.xml");
                    C0985a.m2180a(intentM2177a, "displayFileName", "colors.xml");
                    C0985a.m2180a(intentM2177a, "extraString", "res/values/colors.xml");
                    startActivityForResult(intentM2177a, 0);
                    return;
                }
                return;
            }
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(this.f2663a));
            } catch (Exception e) {
                e = e;
                bufferedWriter = null;
            } catch (Throwable th) {
                th = th;
                id = 0;
                if (id != 0) {
                    try {
                        id.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
            try {
                bufferedWriter.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
                bufferedWriter.write("<resources>\n");
                for (int i = 0; i < this.f2664b.size(); i++) {
                    bufferedWriter.write(((C0932g) this.f2664b.get(i)).toString());
                    bufferedWriter.write("\n");
                }
                bufferedWriter.write("</resources>");
                m2489b();
                try {
                    bufferedWriter.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                Toast.makeText(this, String.format(getString(R.string.general_error), e.getMessage()), 1).show();
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e5) {
                    }
                }
            }
            finish();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws Throwable {
        setTheme(C0037k.mdNoActionBar(C0037k.m89a(this)));
        super.onCreate(bundle);
        setContentView(R.layout.activity_colors_xml);
        this.f2663a = C0985a.m2195a(getIntent(), "xmlPath");
        m2488a();
        ((TextView) findViewById(R.id.filename)).setText(this.f2663a.substring(this.f2663a.lastIndexOf(47) + 1));
        this.f2665c = new C0933h(this, this.f2664b);
        ListView listView = (ListView) findViewById(R.id.color_list);
        listView.setAdapter((ListAdapter) this.f2665c);
        listView.setOnItemClickListener(this);
        this.f2666d = (RelativeLayout) findViewById(R.id.btn_save);
        this.f2666d.setOnClickListener(this);
        ((RelativeLayout) findViewById(R.id.btn_close)).setOnClickListener(this);
        ((RelativeLayout) findViewById(R.id.btn_openeditor)).setOnClickListener(this);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        new AlertDialogC0931f(this, ((C0932g) this.f2664b.get(i)).f2301c, new C1096bw(this, i)).show();
    }
}
