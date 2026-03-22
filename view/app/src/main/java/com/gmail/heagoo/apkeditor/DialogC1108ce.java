package com.gmail.heagoo.apkeditor;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1476h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p000a.p001a.p003b.p004a.p005a.C0027x;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ce */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1108ce extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private List f3144a;

    /* JADX INFO: renamed from: b */
    private String f3145b;

    /* JADX INFO: renamed from: c */
    private String f3146c;

    /* JADX INFO: renamed from: d */
    private String f3147d;

    /* JADX INFO: renamed from: e */
    private Map f3148e;

    /* JADX INFO: renamed from: f */
    private HandlerC1111ch f3149f;

    /* JADX INFO: renamed from: g */
    private View f3150g;

    /* JADX INFO: renamed from: h */
    private String f3151h;

    /* JADX INFO: renamed from: i */
    private String f3152i;

    /* JADX INFO: renamed from: j */
    private int f3153j;

    /* JADX INFO: renamed from: k */
    private String f3154k;

    public DialogC1108ce(Context context, String str, String str2, String str3, String str4, Map map) {
        super(context);
        this.f3149f = new HandlerC1111ch(this);
        requestWindowFeature(1);
        C1110cg c1110cg = new C1110cg();
        c1110cg.f3156a = str;
        c1110cg.f3158c = false;
        c1110cg.f3157b = new File(str).isDirectory();
        this.f3144a = new ArrayList();
        this.f3144a.add(c1110cg);
        this.f3145b = null;
        this.f3147d = null;
        this.f3148e = null;
        if (str2 != null) {
            this.f3146c = str2;
        } else {
            this.f3146c = Environment.getExternalStorageDirectory().getPath() + "/ApkEditor";
        }
        m2837a(context);
    }

    public DialogC1108ce(Context context, String str, String str2, Map map, List list, String str3) {
        super(context);
        this.f3149f = new HandlerC1111ch(this);
        requestWindowFeature(1);
        this.f3145b = str;
        this.f3147d = str2;
        this.f3148e = map;
        this.f3144a = list;
        this.f3146c = str3;
        m2837a(context);
    }

    /* JADX INFO: renamed from: a */
    public static File m2835a(String str, boolean z) {
        String str2;
        String strSubstring;
        String strSubstring2;
        int i = 1;
        if (z) {
            str2 = null;
            strSubstring = null;
            strSubstring2 = null;
        } else {
            int iLastIndexOf = str.lastIndexOf(47);
            strSubstring2 = str.substring(0, iLastIndexOf + 1);
            strSubstring = str.substring(iLastIndexOf + 1);
            int iLastIndexOf2 = strSubstring.lastIndexOf(46);
            if (iLastIndexOf2 != -1) {
                String strSubstring3 = strSubstring.substring(0, iLastIndexOf2);
                String strSubstring4 = strSubstring.substring(iLastIndexOf2);
                strSubstring = strSubstring3;
                str2 = strSubstring4;
            } else {
                str2 = "";
            }
        }
        while (true) {
            File file = new File(z ? str + "(" + i + ")" : strSubstring2 + strSubstring + "(" + i + ")" + str2);
            if (!file.exists()) {
                return file;
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2837a(Context context) {
        this.f3153j = SettingActivity.m2550g(context);
        Resources resources = context.getResources();
        this.f3151h = resources.getString(R.string.save_succeed_1);
        this.f3152i = resources.getString(R.string.failed_1);
        this.f3150g = LayoutInflater.from(context).inflate(R.layout.dlg_extractres, (ViewGroup) null);
        setContentView(this.f3150g);
        ((Button) this.f3150g.findViewById(R.id.close_button)).setOnClickListener(this);
    }

    /* JADX INFO: renamed from: a */
    private void m2838a(File file, File file2) throws Throwable {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file3 : fileArrListFiles) {
                if (file3.isFile()) {
                    m2841b(file3, new File(file2, file3.getName()));
                } else {
                    File file4 = new File(file2, file3.getName());
                    file4.mkdir();
                    m2838a(file3, file4);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static String m2840b(String str) {
        return str.substring(str.lastIndexOf(47) + 1);
    }

    /* JADX INFO: renamed from: b */
    private void m2841b(File file, File file2) throws Throwable {
        String name = file.getName();
        if (this.f3145b == null || (!name.endsWith(".jpg") && (!name.endsWith(".png") || name.endsWith(".9.png")))) {
            C1476h.m3509a(file, file2);
            return;
        }
        String strSubstring = file.getPath().substring(this.f3147d.length() + 1);
        String str = (String) this.f3148e.get(strSubstring);
        if (str == null) {
            str = strSubstring;
        }
        C0027x.m34b(this.f3145b, str, file2.getPath());
    }

    /* JADX INFO: renamed from: a */
    public final void m2842a() {
        TextView textView = (TextView) this.f3150g.findViewById(R.id.result_tv);
        if (this.f3144a.size() == 1) {
            textView.setText(String.format(this.f3151h, this.f3154k));
        } else {
            textView.setText(String.format(this.f3151h, this.f3146c));
        }
        this.f3150g.findViewById(R.id.layout_done).setVisibility(0);
    }

    /* JADX INFO: renamed from: a */
    protected final void m2843a(C1110cg c1110cg) throws Throwable {
        String path = this.f3146c + "/" + m2840b(c1110cg.f3156a);
        if (new File(path).exists() && this.f3153j == 0) {
            path = m2835a(path, c1110cg.f3157b).getPath();
        }
        if (c1110cg.f3157b) {
            C0027x.m30a(this.f3145b, c1110cg.f3156a, path);
        } else {
            C0027x.m34b(this.f3145b, c1110cg.f3156a, path);
        }
        this.f3154k = path;
    }

    /* JADX INFO: renamed from: a */
    public final void m2844a(String str) {
        ((TextView) this.f3150g.findViewById(R.id.result_tv)).setText(String.format(this.f3152i, str));
        this.f3150g.findViewById(R.id.layout_done).setVisibility(0);
    }

    /* JADX INFO: renamed from: b */
    protected final void m2845b(C1110cg c1110cg) throws Throwable {
        String str = this.f3146c + "/" + m2840b(c1110cg.f3156a);
        File file = new File(c1110cg.f3156a);
        if (!file.isDirectory()) {
            File file2 = new File(str);
            if (file2.exists() && this.f3153j == 0) {
                file2 = m2835a(str, false);
            }
            m2841b(new File(c1110cg.f3156a), file2);
            this.f3154k = file2.getPath();
            return;
        }
        File file3 = new File(str);
        if (!file3.exists()) {
            file3.mkdirs();
        } else if (this.f3153j == 0) {
            file3 = m2835a(str, true);
            file3.mkdirs();
        }
        m2838a(file, file3);
        this.f3154k = file3.getPath();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == R.id.close_button) {
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        new C1109cf(this).start();
        super.show();
    }
}
