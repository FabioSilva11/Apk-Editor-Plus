package com.gmail.heagoo.apkeditor;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.apksig.apk.ApkUtils;
import com.gmail.heagoo.apkeditor.p060a.C1029g;
import com.gmail.heagoo.apkeditor.p060a.C1031i;
import com.gmail.heagoo.apkeditor.p066e.C1157e;
import com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import jadx.core.deobf.Deobfuscator;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.eu */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1197eu extends Dialog implements View.OnClickListener, InterfaceC1154b {

    /* JADX INFO: renamed from: a */
    private WeakReference f3379a;

    /* JADX INFO: renamed from: b */
    private String f3380b;

    /* JADX INFO: renamed from: c */
    private String f3381c;

    /* JADX INFO: renamed from: d */
    private View f3382d;

    /* JADX INFO: renamed from: e */
    private TextView f3383e;

    /* JADX INFO: renamed from: f */
    private TextView f3384f;

    /* JADX INFO: renamed from: g */
    private Button f3385g;

    /* JADX INFO: renamed from: i */
    private View f3386i;

    /* JADX INFO: renamed from: j */
    private TextView f3387j;

    /* JADX INFO: renamed from: k */
    private C1029g f3388k;

    /* JADX INFO: renamed from: l */
    private C1157e f3389l;

    /* JADX INFO: renamed from: m */
    private Map f3390m;

    /* JADX INFO: renamed from: n */
    private ProgressBar f3391n;

    public DialogC1197eu(ApkInfoActivity apkInfoActivity) {
        super(apkInfoActivity);
        this.f3380b = null;
        this.f3381c = null;
        this.f3390m = new HashMap();
        requestWindowFeature(1);
        this.f3379a = new WeakReference(apkInfoActivity);
        View viewInflate = LayoutInflater.from(apkInfoActivity).inflate(R.layout.dlg_patch, (ViewGroup) null);
        this.f3382d = viewInflate.findViewById(R.id.tv_curpatch);
        this.f3382d.setOnClickListener(this);
        this.f3383e = (TextView) viewInflate.findViewById(R.id.tv_patch_path);
        ((Button) viewInflate.findViewById(R.id.btn_close)).setOnClickListener(this);
        this.f3385g = (Button) viewInflate.findViewById(R.id.btn_select_apply);
        this.f3385g.setOnClickListener(this);
        this.f3391n = (ProgressBar) viewInflate.findViewById(R.id.progress_patch);
        this.f3384f = (TextView) viewInflate.findViewById(R.id.tv_save_patches);
        this.f3384f.setOnClickListener(this);
        this.f3386i = viewInflate.findViewById(R.id.log_layout);
        this.f3387j = (TextView) viewInflate.findViewById(R.id.tv_patchlog);
        setContentView(viewInflate);
        int i = apkInfoActivity.getResources().getDisplayMetrics().widthPixels;
        Window window = getWindow();
        window.setLayout((i * 7) / 8, -2);
        window.setFlags(128, 128);
    }

    /* JADX INFO: renamed from: a */
    private static String m2984a(C1029g c1029g, int i) {
        if (c1029g.f2967u != null && c1029g.f2967u.containsKey(Integer.valueOf(i))) {
            i = ((Integer) c1029g.f2967u.get(Integer.valueOf(i))).intValue();
        }
        if (i >= c1029g.f2961o.size()) {
            return null;
        }
        String str = (String) c1029g.f2961o.get(i);
        return str.startsWith(Deobfuscator.CLASS_NAME_SEPARATOR) ? c1029g.f2951e + str : !str.contains(Deobfuscator.CLASS_NAME_SEPARATOR) ? c1029g.f2951e + Deobfuscator.CLASS_NAME_SEPARATOR + str : str;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m2985a(DialogC1197eu dialogC1197eu, String str) throws Throwable {
        dialogC1197eu.f3386i.setVisibility(0);
        String strM2991c = dialogC1197eu.m2991c(str);
        if (strM2991c != null) {
            dialogC1197eu.f3387j.setText(strM2991c);
        }
        dialogC1197eu.f3381c = str;
        dialogC1197eu.f3383e.setText(dialogC1197eu.f3381c);
        dialogC1197eu.f3385g.setText(R.string.apply_the_patch);
    }

    /* JADX INFO: renamed from: a */
    private static void m2986a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2987a(String str, boolean z, boolean z2) {
        ((ApkInfoActivity) this.f3379a.get()).runOnUiThread(new RunnableC1199ew(this, z2, str, z));
    }

    /* JADX INFO: renamed from: a */
    private static void m2988a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m2990b(String str) throws Throwable {
        InputStream inputStreamOpen;
        IOException iOException;
        boolean z;
        FileOutputStream fileOutputStream = null;
        m2992g();
        String str2 = this.f3380b + str;
        try {
            try {
                inputStreamOpen = ((ApkInfoActivity) this.f3379a.get()).getAssets().open(str);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                    try {
                        C0985a.m2244b(inputStreamOpen, fileOutputStream2);
                        m2986a(inputStreamOpen);
                        m2986a(fileOutputStream2);
                        z = true;
                    } catch (IOException e) {
                        fileOutputStream = fileOutputStream2;
                        iOException = e;
                        Toast.makeText((Context) this.f3379a.get(), iOException.getMessage(), 0).show();
                        m2986a(inputStreamOpen);
                        m2986a(fileOutputStream);
                        z = false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        m2986a(inputStreamOpen);
                        m2986a(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    iOException = e2;
                }
            } catch (IOException e3) {
                iOException = e3;
                inputStreamOpen = null;
            } catch (Throwable th2) {
                th = th2;
                inputStreamOpen = null;
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: renamed from: c */
    private String m2991c(String str) throws Throwable {
        InputStream inputStream;
        ZipFile zipFile;
        Throwable th;
        String strM2197a = null;
        try {
            try {
                zipFile = new ZipFile(str);
            } catch (Exception e) {
                e = e;
                inputStream = null;
                zipFile = null;
            } catch (Throwable th2) {
                inputStream = null;
                zipFile = null;
                th = th2;
            }
            try {
                ZipEntry entry = zipFile.getEntry("patch.txt");
                if (entry == null) {
                    mo2900a(R.string.patch_error_no_entry, "patch.txt");
                }
                inputStream = zipFile.getInputStream(entry);
            } catch (Exception e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
                m2986a(inputStream);
                m2988a(zipFile);
                throw th;
            }
            try {
                strM2197a = C0985a.m2197a(inputStream);
                m2986a(inputStream);
                m2988a(zipFile);
            } catch (Exception e3) {
                e = e3;
                mo2900a(R.string.general_error, e.getMessage());
                m2986a(inputStream);
                m2988a(zipFile);
            }
            return strM2197a;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: renamed from: g */
    private void m2992g() {
        if (this.f3380b == null) {
            try {
                this.f3380b = C0985a.m2263d((Context) this.f3379a.get(), "patches");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: h */
    private void m2993h() {
        m2992g();
        new DialogC1115cn((Context) this.f3379a.get(), new C1198ev(this), ".zip", null, ((ApkInfoActivity) this.f3379a.get()).getString(R.string.select_patch), false, false, false, "patch", new File(this.f3380b).exists() ? this.f3380b : null).show();
    }

    /* JADX INFO: renamed from: i */
    private void m2994i() throws Throwable {
        ZipFile zipFile;
        InputStream inputStream = null;
        try {
            try {
                zipFile = new ZipFile(((ApkInfoActivity) this.f3379a.get()).m2464l());
            } catch (Exception e) {
                e = e;
                zipFile = null;
            } catch (Throwable th) {
                th = th;
                zipFile = null;
                m2986a(inputStream);
                m2988a(zipFile);
                throw th;
            }
            try {
                inputStream = zipFile.getInputStream(zipFile.getEntry(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME));
                C1031i c1031i = new C1031i(inputStream);
                c1031i.m2760b();
                this.f3388k = c1031i.m2759a();
                m2986a(inputStream);
                m2988a(zipFile);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                m2986a(inputStream);
                m2988a(zipFile);
            }
        } catch (Throwable th2) {
            th = th2;
            m2986a(inputStream);
            m2988a(zipFile);
            throw th;
        }
    }

    static ProgressBar progressPatch(DialogC1197eu dialogC1197eu) {
        return dialogC1197eu.f3391n;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b
    /* JADX INFO: renamed from: a */
    public final String mo2896a(int i) {
        return ((ApkInfoActivity) this.f3379a.get()).getString(i);
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b
    /* JADX INFO: renamed from: a */
    public final String mo2897a(String str) {
        return (String) this.f3390m.get(str);
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b
    /* JADX INFO: renamed from: a */
    public final void mo2898a() {
        ((ApkInfoActivity) this.f3379a.get()).runOnUiThread(new RunnableC1200ex(this));
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b
    /* JADX INFO: renamed from: a */
    public final void mo2899a(int i, boolean z, Object... objArr) {
        String str = String.format(((ApkInfoActivity) this.f3379a.get()).getString(i), objArr);
        m2987a(z ? "\n" + str + "\n" : str + "\n", z, false);
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b
    /* JADX INFO: renamed from: a */
    public final void mo2900a(int i, Object... objArr) {
        m2987a(String.format(((ApkInfoActivity) this.f3379a.get()).getString(i), objArr) + "\n", false, true);
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b
    /* JADX INFO: renamed from: a */
    public final void mo2901a(String str, String str2) {
        this.f3390m.put(str, str2);
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b
    /* JADX INFO: renamed from: a */
    public final void mo2902a(String str, boolean z, Object... objArr) {
        m2987a(String.format(str, objArr) + "\n", false, false);
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b
    /* JADX INFO: renamed from: b */
    public final String mo2903b() {
        return ((ApkInfoActivity) this.f3379a.get()).m2460i();
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b
    /* JADX INFO: renamed from: c */
    public final String mo2904c() throws Throwable {
        String str;
        if (this.f3388k == null) {
            m2994i();
        }
        if (this.f3388k != null && (str = this.f3388k.f2952f) != null) {
            return str.startsWith(Deobfuscator.CLASS_NAME_SEPARATOR) ? this.f3388k.f2951e + str : !str.contains(Deobfuscator.CLASS_NAME_SEPARATOR) ? this.f3388k.f2951e + Deobfuscator.CLASS_NAME_SEPARATOR + str : str;
        }
        return null;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b
    /* JADX INFO: renamed from: d */
    public final List mo2905d() throws Throwable {
        if (this.f3388k == null) {
            m2994i();
        }
        if (this.f3388k == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.f3388k.f2963q.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == 0) {
                String strM2984a = m2984a(this.f3388k, ((Integer) entry.getKey()).intValue());
                if (!arrayList.contains(strM2984a)) {
                    arrayList.add(strM2984a);
                }
            }
        }
        return arrayList;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b
    /* JADX INFO: renamed from: e */
    public final List mo2906e() throws Throwable {
        if (this.f3388k == null) {
            m2994i();
        }
        if (this.f3388k == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f3388k.f2966t.iterator();
        while (it.hasNext()) {
            String strM2984a = m2984a(this.f3388k, ((Integer) it.next()).intValue());
            if (!arrayList.contains(strM2984a)) {
                arrayList.add(strM2984a);
            }
        }
        return arrayList;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.InterfaceC1154b
    /* JADX INFO: renamed from: f */
    public final List mo2907f() {
        if (this.f3389l != null) {
            return this.f3389l.m2915c();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_close) {
            dismiss();
            return;
        }
        if (id == R.id.tv_curpatch) {
            m2993h();
            return;
        }
        if (id != R.id.btn_select_apply) {
            if (id != R.id.tv_save_patches || (!(m2990b("patch_app_rename.zip") | m2990b("patch_data_editor.zip") | m2990b("patch_new_entrance.zip") | m2990b("patch_my_font.zip") | m2990b("patch_mem_editor.zip") | m2990b("patch_bypass_sigcheck.zip") | m2990b("patch_launcher_toast.zip")) && !m2990b("patch_script_example.zip"))) {
                return;
            }
            Toast.makeText((Context) this.f3379a.get(), String.format(((ApkInfoActivity) this.f3379a.get()).getString(R.string.patch_examples_copied), this.f3380b), 0).show();
            return;
        }
        if (this.f3381c == null) {
            m2993h();
            return;
        }
        this.f3387j.setText("");
        this.f3385g.setEnabled(false);
        this.f3385g.setVisibility(8);
        this.f3391n.setVisibility(0);
        this.f3389l = new C1157e((ApkInfoActivity) this.f3379a.get(), this.f3381c, this);
        this.f3389l.m2914b();
    }
}
