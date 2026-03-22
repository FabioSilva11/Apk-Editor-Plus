package com.gmail.heagoo.apkeditor;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fo */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1222fo extends Dialog implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, InterfaceC1221fn {

    /* JADX INFO: renamed from: a */
    private WeakReference f3467a;

    /* JADX INFO: renamed from: b */
    private TextView f3468b;

    /* JADX INFO: renamed from: c */
    private View f3469c;

    /* JADX INFO: renamed from: d */
    private TextView f3470d;

    /* JADX INFO: renamed from: e */
    private ListView f3471e;

    /* JADX INFO: renamed from: f */
    private C1184ef f3472f;

    /* JADX INFO: renamed from: g */
    private LinearLayout f3473g;

    /* JADX INFO: renamed from: h */
    private Button f3474h;

    /* JADX INFO: renamed from: i */
    private Button f3475i;

    /* JADX INFO: renamed from: j */
    private View f3476j;

    /* JADX INFO: renamed from: k */
    private View f3477k;

    /* JADX INFO: renamed from: l */
    private String f3478l;

    /* JADX INFO: renamed from: m */
    private List f3479m;

    /* JADX INFO: renamed from: n */
    private String f3480n;

    /* JADX INFO: renamed from: o */
    private boolean f3481o;

    /* JADX INFO: renamed from: p */
    private ArrayList f3482p;

    public DialogC1222fo(ApkInfoActivity apkInfoActivity, String str, List list, String str2, boolean z) {
        super(apkInfoActivity, R.style.Dialog_FullWindow);
        this.f3482p = new ArrayList();
        new HashSet();
        requestWindowFeature(1);
        this.f3467a = new WeakReference(apkInfoActivity);
        this.f3478l = str;
        this.f3479m = list;
        this.f3480n = str2;
        this.f3481o = z;
        if (!this.f3478l.endsWith("/")) {
            new StringBuilder().append(str).append("/");
        }
        View viewInflate = LayoutInflater.from(apkInfoActivity).inflate(R.layout.dlg_filename_searchret, (ViewGroup) null);
        this.f3468b = (TextView) viewInflate.findViewById(R.id.title);
        this.f3469c = viewInflate.findViewById(R.id.res_header_selection);
        this.f3470d = (TextView) viewInflate.findViewById(R.id.selection_tip);
        this.f3471e = (ListView) viewInflate.findViewById(R.id.file_list);
        this.f3473g = (LinearLayout) viewInflate.findViewById(R.id.searching_layout);
        this.f3476j = viewInflate.findViewById(R.id.menu_done);
        this.f3477k = viewInflate.findViewById(R.id.menu_select);
        this.f3476j.setOnClickListener(this);
        this.f3477k.setOnClickListener(this);
        this.f3474h = (Button) viewInflate.findViewById(R.id.btn_close);
        this.f3475i = (Button) viewInflate.findViewById(R.id.btn_delete);
        this.f3474h.setOnClickListener(this);
        this.f3475i.setOnClickListener(this);
        this.f3471e.setVisibility(4);
        new AsyncTaskC1228fu(this, this.f3478l, this.f3479m, this.f3480n).execute(new Object[0]);
        setContentView(viewInflate);
    }

    /* JADX INFO: renamed from: a */
    private void m3073a() {
        this.f3468b.setVisibility(0);
        this.f3469c.setVisibility(8);
        this.f3475i.setVisibility(8);
        this.f3468b.setText(String.format(((ApkInfoActivity) this.f3467a.get()).getString(R.string.str_files_found), Integer.valueOf(this.f3482p.size()), this.f3480n));
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m3074a(DialogC1222fo dialogC1222fo, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i));
        dialogC1222fo.m3075a(arrayList);
    }

    /* JADX INFO: renamed from: a */
    private void m3075a(List list) {
        C1213ff c1213ff = ((ApkInfoActivity) this.f3467a.get()).f2617e;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) this.f3482p.get(((Integer) it.next()).intValue());
            int iLastIndexOf = str.lastIndexOf(47);
            c1213ff.m3049b(iLastIndexOf != -1 ? str.substring(0, iLastIndexOf) : "", str.substring(iLastIndexOf + 1), false);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f3482p.size(); i++) {
            if (!list.contains(Integer.valueOf(i))) {
                arrayList.add(this.f3482p.get(i));
            }
        }
        this.f3482p = arrayList;
        this.f3472f.m2962a(this.f3482p, list);
        if (this.f3472f.m2966e()) {
            m3073a();
        }
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m3078b(DialogC1222fo dialogC1222fo, int i) {
        if (i < dialogC1222fo.f3482p.size()) {
            ((ApkInfoActivity) dialogC1222fo.f3467a.get()).m2459h((String) dialogC1222fo.f3482p.get(i));
        }
    }

    /* JADX INFO: renamed from: c */
    static /* synthetic */ void m3079c(DialogC1222fo dialogC1222fo) {
        dialogC1222fo.f3468b.setText(String.format(((ApkInfoActivity) dialogC1222fo.f3467a.get()).getString(R.string.str_files_found), Integer.valueOf(dialogC1222fo.f3482p.size()), dialogC1222fo.f3480n));
        dialogC1222fo.f3472f = new C1184ef((ApkInfoActivity) dialogC1222fo.f3467a.get(), dialogC1222fo, dialogC1222fo.f3478l, dialogC1222fo.f3482p);
        dialogC1222fo.f3471e.setAdapter((ListAdapter) dialogC1222fo.f3472f);
        dialogC1222fo.f3471e.setOnItemClickListener(dialogC1222fo);
        dialogC1222fo.f3471e.setOnItemLongClickListener(dialogC1222fo);
        dialogC1222fo.f3471e.setVisibility(0);
        dialogC1222fo.f3473g.setVisibility(4);
    }

    /* JADX INFO: renamed from: c */
    static /* synthetic */ void m3080c(DialogC1222fo dialogC1222fo, int i) {
        if (i < dialogC1222fo.f3482p.size()) {
            ((ApkInfoActivity) dialogC1222fo.f3467a.get()).m2432a((String) dialogC1222fo.f3482p.get(i), new C1223fp(dialogC1222fo));
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1221fn
    /* JADX INFO: renamed from: b */
    public final void mo2445b(Set set) {
        if (set.isEmpty()) {
            m3073a();
            return;
        }
        this.f3470d.setText(String.format(((ApkInfoActivity) this.f3467a.get()).getString(R.string.num_items_selected), Integer.valueOf(set.size())));
        this.f3468b.setVisibility(8);
        this.f3469c.setVisibility(0);
        this.f3475i.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_close) {
            dismiss();
            return;
        }
        if (id == R.id.btn_delete) {
            m3075a(this.f3472f.m2961a());
            return;
        }
        if (id == R.id.menu_done) {
            this.f3472f.m2964c();
            m3073a();
        } else if (id == R.id.menu_select) {
            if (!this.f3472f.m2965d()) {
                this.f3472f.m2963b();
            } else {
                this.f3472f.m2964c();
                m3073a();
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str;
        int iLastIndexOf;
        if (i < this.f3482p.size() && (iLastIndexOf = (str = (String) this.f3482p.get(i)).lastIndexOf("/")) != -1) {
            ((ApkInfoActivity) this.f3467a.get()).m2436a(str.substring(0, iLastIndexOf), str.substring(iLastIndexOf + 1), false);
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        adapterView.setOnCreateContextMenuListener(new ViewOnCreateContextMenuListenerC1224fq(this, i));
        return false;
    }
}
