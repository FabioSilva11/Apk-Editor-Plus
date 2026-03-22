package com.gmail.heagoo.p070b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1469a;
import com.gmail.heagoo.common.C1476h;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.gmail.heagoo.p054a.p059c.C0987b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: renamed from: com.gmail.heagoo.b.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1454e implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    /* JADX INFO: renamed from: a */
    private Context f4266a;

    /* JADX INFO: renamed from: b */
    private ListView f4267b;

    /* JADX INFO: renamed from: c */
    private String f4268c;

    /* JADX INFO: renamed from: d */
    private String f4269d;

    /* JADX INFO: renamed from: e */
    private C1452c f4270e;

    /* JADX INFO: renamed from: f */
    private InterfaceC1463n f4271f;

    public C1454e(Context context, ListView listView, String str, String str2, InterfaceC1463n interfaceC1463n, InterfaceC1464o interfaceC1464o) {
        this.f4266a = context;
        this.f4267b = listView;
        this.f4269d = str;
        this.f4268c = str2;
        this.f4271f = interfaceC1463n;
        this.f4270e = new C1452c(this.f4266a, this.f4268c, this.f4269d, interfaceC1464o);
        this.f4267b.setAdapter((ListAdapter) this.f4270e);
        this.f4267b.setOnItemClickListener(this);
        this.f4267b.setOnItemLongClickListener(this);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m3473a(C1454e c1454e) {
        String strM3470a = c1454e.f4270e.m3470a((List) null);
        float f = c1454e.f4266a.getResources().getDisplayMetrics().density;
        int i = (int) ((8.0f * f) + 0.5f);
        int i2 = (int) ((f * 20.0f) + 0.5f);
        AlertDialog.Builder builder = new AlertDialog.Builder(c1454e.f4266a);
        builder.setTitle(R.string.new_file);
        LinearLayout linearLayout = new LinearLayout(c1454e.f4266a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(i2, i, i2, 0);
        EditText editText = new EditText(c1454e.f4266a);
        editText.setFilters(new InputFilter[]{C1469a.m3487a()});
        editText.setHint(R.string.pls_input_filename);
        editText.setTextColor(ContextCompat.getColor(c1454e.f4266a, C0037k.mdTextMedium(C0037k.m89a(c1454e.f4266a))));
        editText.setTextSize(1, 14);
        editText.setLayoutParams(layoutParams);
        linearLayout.addView(editText);
        builder.setView(linearLayout);
        builder.setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC1461l(c1454e, editText, strM3470a));
        builder.setNegativeButton(android.R.string.cancel, new DialogInterfaceOnClickListenerC1462m(c1454e));
        builder.show();
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m3474a(C1454e c1454e, int i) {
        ArrayList arrayList = new ArrayList();
        String strM3470a = c1454e.f4270e.m3470a(arrayList);
        C1450a c1450a = (C1450a) arrayList.get(i);
        if (c1450a != null) {
            String str = c1450a.f4255a;
            if (m3477b(strM3470a + "/" + c1450a.f4255a)) {
                c1454e.f4270e.m3472b(str);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ void m3476b(C1454e c1454e, int i) {
        float f = c1454e.f4266a.getResources().getDisplayMetrics().density;
        int i2 = (int) ((8.0f * f) + 0.5f);
        int i3 = (int) ((f * 20.0f) + 0.5f);
        AlertDialog.Builder builder = new AlertDialog.Builder(c1454e.f4266a);
        builder.setTitle(R.string.rename);
        LinearLayout linearLayout = new LinearLayout(c1454e.f4266a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(i3, i2, i3, 0);
        EditText editText = new EditText(c1454e.f4266a);
        editText.setHint(R.string.pls_input_filename);
        editText.setTextColor(ContextCompat.getColor(c1454e.f4266a, C0037k.mdTextMedium(C0037k.m89a(c1454e.f4266a))));
        editText.setTextSize(1, 14);
        editText.setLayoutParams(layoutParams);
        linearLayout.addView(editText);
        ArrayList arrayList = new ArrayList();
        String strM3470a = c1454e.f4270e.m3470a(arrayList);
        C1450a c1450a = (C1450a) arrayList.get(i);
        if (c1450a != null) {
            String str = c1450a.f4255a;
            editText.setText(str);
            builder.setView(linearLayout);
            builder.setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC1459j(c1454e, editText, strM3470a, str));
            builder.setNegativeButton(android.R.string.cancel, new DialogInterfaceOnClickListenerC1460k(c1454e));
            builder.show();
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m3477b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        try {
            C1476h.m3508a(file);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    static /* synthetic */ void m3479d(C1454e c1454e, int i) throws Throwable {
        ArrayList arrayList = new ArrayList();
        String strM3470a = c1454e.f4270e.m3470a(arrayList);
        C1450a c1450a = (C1450a) arrayList.get(i);
        if (c1450a != null) {
            String str = c1450a.f4255a;
            C0985a.m2204a(c1454e.f4266a, strM3470a + "/" + c1450a.f4255a);
        }
    }

    /* JADX INFO: renamed from: e */
    static /* synthetic */ void m3480e(C1454e c1454e, int i) {
        ArrayList arrayList = new ArrayList();
        String strM3470a = c1454e.f4270e.m3470a(arrayList);
        C1450a c1450a = (C1450a) arrayList.get(i);
        if (c1450a != null) {
            String str = c1450a.f4255a;
            C0985a.m2231aa(c1454e.f4266a, strM3470a + "/" + c1450a.f4255a);
        }
    }

    /* JADX INFO: renamed from: f */
    static /* synthetic */ void m3481f(C1454e c1454e, int i) {
        ArrayList arrayList = new ArrayList();
        String strM3470a = c1454e.f4270e.m3470a(arrayList);
        C1450a c1450a = (C1450a) arrayList.get(i);
        if (c1450a != null) {
            String str = c1450a.f4255a;
            C0987b.sign(c1454e.f4266a, strM3470a + "/" + c1450a.f4255a);
        }
    }

    /* JADX INFO: renamed from: g */
    static /* synthetic */ void m3482g(C1454e c1454e, int i) {
        ArrayList arrayList = new ArrayList();
        String strM3470a = c1454e.f4270e.m3470a(arrayList);
        C1450a c1450a = (C1450a) arrayList.get(i);
        if (c1450a != null) {
            String str = c1450a.f4255a;
            C0987b.checkSign(c1454e.f4266a, strM3470a + "/" + c1450a.f4255a);
        }
    }

    /* JADX INFO: renamed from: a */
    public final C1452c m3483a() {
        return this.f4270e;
    }

    /* JADX INFO: renamed from: a */
    public final void m3484a(String str) {
        String strM3470a = this.f4270e.m3470a((List) null);
        this.f4270e.m3471a(str);
        String strM3470a2 = this.f4270e.m3470a((List) null);
        if (strM3470a2.equals(strM3470a)) {
            return;
        }
        this.f4271f.mo2516a(strM3470a2);
    }

    /* JADX INFO: renamed from: a */
    protected final boolean m3485a(String str, String str2, String str3) {
        File file = new File(str + "/" + str3);
        if (file.exists()) {
            Toast.makeText(this.f4266a, String.format(this.f4266a.getResources().getString(R.string.file_already_exist), str3), 0).show();
            return false;
        }
        boolean zRenameTo = new File(str + "/" + str2).renameTo(file);
        Toast.makeText(this.f4266a, this.f4266a.getResources().getString(R.string.rename) + " " + this.f4266a.getResources().getString(zRenameTo ? R.string.succeed : R.string.failed), 0).show();
        return zRenameTo;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Context context;
        Intent intentM2267e;
        ArrayList arrayList = new ArrayList();
        String strM3470a = this.f4270e.m3470a(arrayList);
        C1450a c1450a = (C1450a) arrayList.get(i);
        if (c1450a == null) {
            return;
        }
        if (c1450a.f4256b) {
            this.f4270e.m3471a(c1450a.f4255a.equals("..") ? strM3470a.substring(0, strM3470a.lastIndexOf(47)) : strM3470a + "/" + c1450a.f4255a);
        } else {
            String str = strM3470a + "/" + c1450a.f4255a;
            if (!this.f4271f.mo2518b(str) && (intentM2267e = C0985a.m2267e((context = this.f4266a), str)) != null) {
                context.startActivity(intentM2267e);
            }
        }
        String strM3470a2 = this.f4270e.m3470a((List) null);
        if (strM3470a2.equals(strM3470a)) {
            return;
        }
        this.f4271f.mo2516a(strM3470a2);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        if (i == 0) {
            return true;
        }
        adapterView.setOnCreateContextMenuListener(new ViewOnCreateContextMenuListenerC1455f(this, i));
        return false;
    }
}
