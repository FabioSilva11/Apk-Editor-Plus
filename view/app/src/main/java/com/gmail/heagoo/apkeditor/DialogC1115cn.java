package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1469a;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.gmail.heagoo.p070b.C1450a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.cn */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1115cn extends Dialog implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    /* JADX INFO: renamed from: a */
    private C1213ff f3167a;

    /* JADX INFO: renamed from: b */
    private String f3168b;

    /* JADX INFO: renamed from: c */
    private boolean f3169c;

    /* JADX INFO: renamed from: d */
    private boolean f3170d;

    /* JADX INFO: renamed from: e */
    private String f3171e;

    /* JADX INFO: renamed from: f */
    private TextView f3172f;

    /* JADX INFO: renamed from: g */
    private TextView f3173g;

    /* JADX INFO: renamed from: h */
    private CheckBox f3174h;

    /* JADX INFO: renamed from: i */
    private InterfaceC1122cu f3175i;

    /* JADX INFO: renamed from: j */
    private Context f3176j;

    public DialogC1115cn(Context context, InterfaceC1122cu interfaceC1122cu, String str, String str2, String str3) {
        this(context, interfaceC1122cu, str, str2, str3, false, false, false, null);
    }

    public DialogC1115cn(Context context, InterfaceC1122cu interfaceC1122cu, String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        this(context, interfaceC1122cu, str, str2, str3, z, z2, z3, str4, null);
    }

    @SuppressLint({"InflateParams"})
    public DialogC1115cn(Context context, InterfaceC1122cu interfaceC1122cu, String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4, String str5) {
        super(context);
        super.requestWindowFeature(1);
        this.f3176j = context;
        this.f3175i = interfaceC1122cu;
        this.f3168b = str2;
        this.f3169c = z;
        this.f3170d = z2;
        this.f3171e = str4;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.dlg_fileselect, (ViewGroup) null, false);
        Button button = (Button) viewInflate.findViewById(R.id.confirm);
        if (z) {
            button.setVisibility(0);
            button.setOnClickListener(this);
        } else {
            button.setVisibility(8);
        }
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str4 != null ? str4 + "_lastDirectory" : "lastDirectory", "");
        string = new File(string).exists() ? string : str5 == null ? Environment.getExternalStorageDirectory().getPath() : str5;
        this.f3172f = (TextView) viewInflate.findViewById(R.id.tv_title);
        this.f3173g = (TextView) viewInflate.findViewById(R.id.tv_subtitle);
        this.f3172f.setText(str3 == null ? str != null ? context.getString(R.string.select_file_replace) + " (" + str + ")" : context.getString(R.string.select_file_replace) : str3);
        this.f3173g.setText(string);
        ListView listView = (ListView) viewInflate.findViewById(R.id.file_list);
        this.f3167a = new C1213ff(context, null, string, "/", new C1120cs(this));
        listView.setAdapter((ListAdapter) this.f3167a);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        this.f3174h = (CheckBox) viewInflate.findViewById(R.id.cb_edit_before_replace);
        if (z3) {
            this.f3174h.setText(String.format(context.getString(R.string.edit_before_replace), C0985a.m2284l(str2)));
            this.f3174h.setChecked(PreferenceManager.getDefaultSharedPreferences(this.f3176j).getBoolean(this.f3171e != null ? this.f3171e + "_editBeforeReplace" : "editBeforeReplace", false));
            this.f3174h.setVisibility(0);
        } else {
            this.f3174h.setVisibility(8);
        }
        ((Button) viewInflate.findViewById(R.id.close)).setOnClickListener(this);
        setContentView(viewInflate);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m2849a(DialogC1115cn dialogC1115cn) {
        String strM3038a = dialogC1115cn.f3167a.m3038a((List) null);
        float f = dialogC1115cn.f3176j.getResources().getDisplayMetrics().density;
        int i = (int) ((20.0f * f) + 0.5f);
        AlertDialog.Builder builder = new AlertDialog.Builder(dialogC1115cn.f3176j);
        builder.setTitle(R.string.new_folder);
        LinearLayout linearLayout = new LinearLayout(dialogC1115cn.f3176j);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(i, (int) ((f * 8.0f) + 0.5f), i, 0);
        EditText editText = new EditText(dialogC1115cn.f3176j);
        editText.setFilters(new InputFilter[]{C1469a.m3487a()});
        editText.setHint(R.string.pls_input_foldername);
        editText.setTextColor(ContextCompat.getColor(dialogC1115cn.f3176j, C0037k.mdTextMedium(C0037k.m89a(dialogC1115cn.f3176j))));
        editText.setTextSize(1, 14);
        editText.setLayoutParams(layoutParams);
        linearLayout.addView(editText);
        builder.setView(linearLayout);
        builder.setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC1118cq(dialogC1115cn, editText, strM3038a));
        builder.setNegativeButton(android.R.string.cancel, new DialogInterfaceOnClickListenerC1119cr(dialogC1115cn));
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m2851a(String str) {
        return this.f3175i.mo2503a(str, this.f3168b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m2854b(String str) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(this.f3176j).edit();
        editorEdit.putString(this.f3171e != null ? this.f3171e + "_lastDirectory" : "lastDirectory", str);
        editorEdit.apply();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.close) {
            dismiss();
            return;
        }
        if (id == R.id.confirm) {
            String strM3038a = this.f3167a.m3038a((List) null);
            if (this.f3170d) {
                new AlertDialog.Builder(this.f3176j).setTitle(R.string.confirm_dir_replace).setMessage(this.f3175i.mo2504b(strM3038a, this.f3168b)).setPositiveButton(R.string.yes, new DialogInterfaceOnClickListenerC1121ct(this, strM3038a)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                return;
            }
            this.f3175i.mo2502a(strM3038a, this.f3168b, this.f3174h.isChecked());
            m2854b(strM3038a);
            dismiss();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ArrayList arrayList = new ArrayList();
        String strM3038a = this.f3167a.m3038a(arrayList);
        C1450a c1450a = (C1450a) arrayList.get(i);
        if (c1450a == null) {
            return;
        }
        if (c1450a.f4256b) {
            this.f3167a.m3051c(c1450a.f4255a.equals("..") ? strM3038a.substring(0, strM3038a.lastIndexOf(47)) : strM3038a + "/" + c1450a.f4255a);
            this.f3173g.setText(this.f3167a.m3038a((List) null));
            return;
        }
        if (this.f3169c || !m2851a(c1450a.f4255a)) {
            return;
        }
        String str = strM3038a + "/" + c1450a.f4255a;
        boolean zIsChecked = this.f3174h.isChecked();
        this.f3175i.mo2502a(str, this.f3168b, zIsChecked);
        m2854b(strM3038a);
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(this.f3176j).edit();
        editorEdit.putBoolean(this.f3171e != null ? this.f3171e + "_editBeforeReplace" : "editBeforeReplace", zIsChecked);
        editorEdit.apply();
        dismiss();
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        adapterView.setOnCreateContextMenuListener(new ViewOnCreateContextMenuListenerC1116co(this));
        return false;
    }
}
