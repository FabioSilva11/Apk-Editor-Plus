package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.p062ac.C1037a;
import com.gmail.heagoo.apkeditor.p062ac.EditTextWithTip;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fv */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1229fv extends Dialog implements View.OnClickListener, AdapterView.OnItemLongClickListener, ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener {

    /* JADX INFO: renamed from: a */
    private TextView f3494a;

    /* JADX INFO: renamed from: b */
    private EditTextWithTip f3495b;

    /* JADX INFO: renamed from: c */
    private ExpandableListView f3496c;

    /* JADX INFO: renamed from: d */
    private ViewOnClickListenerC1187ei f3497d;

    /* JADX INFO: renamed from: e */
    private LinearLayout f3498e;

    /* JADX INFO: renamed from: f */
    private WeakReference f3499f;

    /* JADX INFO: renamed from: g */
    private String f3500g;

    /* JADX INFO: renamed from: h */
    private List f3501h;

    /* JADX INFO: renamed from: i */
    private String f3502i;

    /* JADX INFO: renamed from: j */
    private boolean f3503j;

    /* JADX INFO: renamed from: k */
    private ArrayList f3504k;

    /* JADX INFO: renamed from: l */
    private C1037a f3505l;

    public DialogC1229fv(ApkInfoActivity apkInfoActivity, String str, List list, String str2, boolean z) {
        super(apkInfoActivity, R.style.Dialog_FullWindow);
        this.f3504k = new ArrayList();
        requestWindowFeature(1);
        this.f3499f = new WeakReference(apkInfoActivity);
        this.f3500g = str;
        this.f3501h = list;
        this.f3502i = str2;
        this.f3503j = z;
        if (!this.f3500g.endsWith("/")) {
            new StringBuilder().append(str).append("/");
        }
        View viewInflate = LayoutInflater.from(apkInfoActivity).inflate(R.layout.dialog_txt_searchresult, (ViewGroup) null);
        this.f3494a = (TextView) viewInflate.findViewById(R.id.title);
        this.f3495b = (EditTextWithTip) viewInflate.findViewById(R.id.et_replaceall);
        this.f3496c = (ExpandableListView) viewInflate.findViewById(R.id.lv_matchedfiles);
        this.f3498e = (LinearLayout) viewInflate.findViewById(R.id.searching_layout);
        this.f3496c.setVisibility(4);
        new AsyncTaskC1240gf(this, this.f3500g, this.f3501h, this.f3502i, this.f3503j).execute(new Object[0]);
        viewInflate.findViewById(R.id.btn_replaceall).setOnClickListener(this);
        this.f3505l = new C1037a(apkInfoActivity, "search_replace_with");
        ((EditTextWithTip) viewInflate.findViewById(R.id.et_replaceall)).setAdapter(this.f3505l);
        setContentView(viewInflate);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m3086a(DialogC1229fv dialogC1229fv, int i) {
        C1213ff c1213ff = ((ApkInfoActivity) dialogC1229fv.f3499f.get()).f2617e;
        String str = (String) dialogC1229fv.f3504k.get(i);
        int iLastIndexOf = str.lastIndexOf(47);
        c1213ff.m3049b(iLastIndexOf != -1 ? str.substring(0, iLastIndexOf) : "", str.substring(iLastIndexOf + 1), false);
        dialogC1229fv.f3497d.m2979c(i);
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m3087b(DialogC1229fv dialogC1229fv) {
        dialogC1229fv.f3494a.setText(String.format(((ApkInfoActivity) dialogC1229fv.f3499f.get()).getString(R.string.str_files_found), Integer.valueOf(dialogC1229fv.f3504k.size()), dialogC1229fv.f3502i));
        dialogC1229fv.f3497d = new ViewOnClickListenerC1187ei(dialogC1229fv.f3499f, dialogC1229fv.f3496c, dialogC1229fv.f3500g, dialogC1229fv.f3504k, dialogC1229fv.f3502i);
        dialogC1229fv.f3496c.setAdapter(dialogC1229fv.f3497d);
        dialogC1229fv.f3496c.setOnGroupClickListener(dialogC1229fv);
        dialogC1229fv.f3496c.setOnChildClickListener(dialogC1229fv);
        dialogC1229fv.f3496c.setOnItemLongClickListener(dialogC1229fv);
        dialogC1229fv.f3496c.setVisibility(0);
        dialogC1229fv.f3498e.setVisibility(4);
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m3088b(DialogC1229fv dialogC1229fv, int i) {
        if (i < dialogC1229fv.f3504k.size()) {
            ((ApkInfoActivity) dialogC1229fv.f3499f.get()).m2459h((String) dialogC1229fv.f3504k.get(i));
        }
    }

    /* JADX INFO: renamed from: c */
    static /* synthetic */ void m3089c(DialogC1229fv dialogC1229fv, int i) {
        if (i < dialogC1229fv.f3504k.size()) {
            ((ApkInfoActivity) dialogC1229fv.f3499f.get()).m2432a((String) dialogC1229fv.f3504k.get(i), new C1238gd(dialogC1229fv, i));
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m3095a(String str) {
        new DialogC1201ey((Activity) this.f3499f.get(), new C1232fy(this, str), -1);
    }

    /* JADX INFO: renamed from: b */
    public final void m3096b(String str) {
        ((ApkInfoActivity) this.f3499f.get()).m2433a(str, (String) null);
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        Intent intentM2178a;
        ArrayList arrayListM2973a = this.f3497d.m2973a();
        C1186eh c1186eh = (C1186eh) this.f3497d.getChild(i, i2);
        if (c1186eh != null) {
            if (arrayListM2973a.size() > 100) {
                String str = (String) arrayListM2973a.get(i);
                ApkInfoActivity apkInfoActivity = (ApkInfoActivity) this.f3499f.get();
                intentM2178a = C0985a.m2177a(apkInfoActivity, str, apkInfoActivity.m2464l());
                C0985a.m2180a(intentM2178a, "startLine", new StringBuilder().append(c1186eh.f3339a).toString());
            } else {
                ApkInfoActivity apkInfoActivity2 = (ApkInfoActivity) this.f3499f.get();
                intentM2178a = C0985a.m2178a(apkInfoActivity2, arrayListM2973a, i, apkInfoActivity2.m2464l());
                C0985a.m2181a(intentM2178a, "fileList", arrayListM2973a);
                C0985a.m2179a(intentM2178a, "curFileIndex", i);
                ArrayList<Integer> arrayList = new ArrayList<>(arrayListM2973a.size());
                for (int i3 = 0; i3 < i; i3++) {
                    arrayList.add(-1);
                }
                arrayList.add(Integer.valueOf(c1186eh.f3339a));
                for (int i4 = i + 1; i4 < arrayListM2973a.size(); i4++) {
                    arrayList.add(-1);
                }
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("startLineList", arrayList);
                intentM2178a.putExtras(bundle);
            }
            C0985a.m2180a(intentM2178a, "searchString", this.f3502i);
            ((ApkInfoActivity) this.f3499f.get()).startActivityForResult(intentM2178a, 0);
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == R.id.btn_replaceall) {
            String string = this.f3495b.getText().toString();
            AlertDialog.Builder builder = new AlertDialog.Builder((Context) this.f3499f.get());
            builder.setMessage(String.format(((ApkInfoActivity) this.f3499f.get()).getString(R.string.sure_to_replace_all), this.f3502i, string));
            builder.setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC1230fw(this, string));
            builder.setNegativeButton(android.R.string.cancel, new DialogInterfaceOnClickListenerC1231fx(this));
            builder.show();
        }
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        if (expandableListView.isGroupExpanded(i) || this.f3497d.m2976a(i)) {
            return false;
        }
        new AsyncTaskC1239ge(this, (String) this.f3497d.getGroup(i), this.f3497d.m2977b(), i).execute(new Object[0]);
        return true;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        if (ExpandableListView.getPackedPositionType(j) != 0) {
            return true;
        }
        adapterView.setOnCreateContextMenuListener(new ViewOnCreateContextMenuListenerC1233fz(this, ExpandableListView.getPackedPositionGroup(j)));
        return false;
    }
}
