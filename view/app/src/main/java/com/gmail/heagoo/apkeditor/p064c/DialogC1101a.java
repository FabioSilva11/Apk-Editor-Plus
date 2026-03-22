package com.gmail.heagoo.apkeditor.p064c;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.C1249gp;
import com.gmail.heagoo.apkeditor.InterfaceC1251gr;
import com.gmail.heagoo.apkeditor.TextEditNormalActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.apkeditor.util.C1377ab;
import com.gmail.heagoo.apkeditor.util.C1402z;
import com.gmail.heagoo.common.C1491w;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.c.a */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1101a extends Dialog implements View.OnClickListener, InterfaceC1251gr {

    /* JADX INFO: renamed from: a */
    private TextView f3124a;

    /* JADX INFO: renamed from: b */
    private View f3125b;

    /* JADX INFO: renamed from: c */
    private WebView f3126c;

    /* JADX INFO: renamed from: d */
    private String f3127d;

    /* JADX INFO: renamed from: e */
    private File f3128e;

    /* JADX INFO: renamed from: f */
    private WeakReference f3129f;

    /* JADX INFO: renamed from: g */
    private HandlerC1103c f3130g;

    /* JADX INFO: renamed from: h */
    private C1249gp f3131h;

    public DialogC1101a(Activity activity) {
        super(activity, R.style.Dialog_FullWindow);
        this.f3130g = new HandlerC1103c(this);
        this.f3131h = new C1249gp(this);
        this.f3129f = new WeakReference(activity);
        setContentView(R.layout.dlg_htmlview);
        this.f3124a = (TextView) findViewById(R.id.filename);
        this.f3125b = findViewById(R.id.menu_methods);
        this.f3126c = (WebView) findViewById(R.id.webView);
        View viewFindViewById = findViewById(R.id.editorBtn);
        this.f3125b.setOnClickListener(this);
        viewFindViewById.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2827a(int i) {
        if (this.f3128e != null) {
            this.f3126c.loadUrl("file://" + this.f3128e.getAbsolutePath() + (i > 0 ? "#line" + i : ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m2830a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                arrayList.add(line);
            }
            bufferedReader.close();
            try {
                File file = new File(((Activity) this.f3129f.get()).getFilesDir(), "viewsource.css");
                if (!file.exists()) {
                    InputStream inputStreamOpen = ((Activity) this.f3129f.get()).getAssets().open("viewsource.css");
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    C0985a.m2244b(inputStreamOpen, fileOutputStream);
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            File file2 = new File(((Activity) this.f3129f.get()).getFilesDir(), ".html");
            try {
                if (TextEditNormalActivity.m2616g(str)) {
                    new C1377ab().m3316a(arrayList, file2.getAbsolutePath());
                } else {
                    C0985a.m2218a(arrayList, file2.getAbsolutePath());
                }
                this.f3128e = file2;
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public boolean m2832b(String str) {
        C1402z c1402z = new C1402z(str);
        File file = new File(((Activity) this.f3129f.get()).getFilesDir(), ".html");
        try {
            c1402z.m3382a(file.getAbsolutePath());
            this.f3128e = file;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2833a(String str, String str2) {
        if (!str.equals(this.f3127d)) {
            this.f3127d = str;
            this.f3124a.setText(str2);
            if (TextEditNormalActivity.m3126c(str)) {
                this.f3125b.setVisibility(0);
            } else {
                this.f3125b.setVisibility(8);
            }
            new C1102b(this, str).start();
        }
        show();
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1251gr
    /* JADX INFO: renamed from: b */
    public final void mo2589b(int i) {
        m2827a(i);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id != R.id.menu_methods) {
            if (id == R.id.editorBtn) {
                dismiss();
            }
        } else {
            if (this.f3131h != null && this.f3131h.m3110a() != null) {
                this.f3131h.m3112a(view);
                return;
            }
            try {
                this.f3131h.m3111a((Activity) this.f3129f.get(), this.f3127d, new C1491w(this.f3127d).m3537b(), view);
            } catch (Exception e) {
            }
        }
    }
}
