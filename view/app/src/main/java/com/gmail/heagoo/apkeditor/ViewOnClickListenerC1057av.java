package com.gmail.heagoo.apkeditor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.p062ac.C1037a;
import com.gmail.heagoo.apkeditor.p062ac.EditTextWithTip;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1487s;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.gmail.heagoo.p070b.C1450a;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipFile;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.av */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnClickListenerC1057av implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ApkInfoExActivity f3019a;

    ViewOnClickListenerC1057av(ApkInfoExActivity apkInfoExActivity) {
        this.f3019a = apkInfoExActivity;
    }

    /* JADX INFO: renamed from: a */
    private AlertDialog m2765a(String str, C1450a c1450a, int i) throws Throwable {
        String str2;
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        String str3 = c1450a.f4255a;
        String str4 = str + "/" + c1450a.f4255a;
        String strSubstring = str4.substring(this.f3019a.f2614b.length() + 1);
        if (str4.startsWith(this.f3019a.f2614b + "/")) {
            String strSubstring2 = str4.substring(this.f3019a.f2614b.length() + 1);
            String str5 = this.f3019a.f2623k != null ? (String) this.f3019a.f2623k.get(strSubstring2) : null;
            if (str5 == null) {
                str5 = strSubstring2;
            }
            try {
                zipFile = new ZipFile(this.f3019a.f2582a);
            } catch (Exception e) {
                e = e;
                zipFile = null;
            } catch (Throwable th) {
                th = th;
                m2767a(zipFile2);
                throw th;
            }
            try {
                try {
                    if (zipFile.getEntry(str5) == null) {
                        str5 = null;
                    }
                    m2767a(zipFile);
                    str2 = str5;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    m2767a(zipFile);
                    str2 = null;
                }
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = zipFile;
                m2767a(zipFile2);
                throw th;
            }
        } else {
            str2 = null;
        }
        View viewInflate = LayoutInflater.from(this.f3019a).inflate(R.layout.dlg_resfile_more, (ViewGroup) null);
        EditText editText = (EditText) viewInflate.findViewById(R.id.filename);
        editText.setText(str3);
        ((EditText) viewInflate.findViewById(R.id.filepath)).setText(strSubstring);
        ((EditText) viewInflate.findViewById(R.id.fileentry)).setText(str2 != null ? str2 : this.f3019a.getString(R.string.not_available));
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.btn_extract);
        if (c1450a.f4256b) {
            relativeLayout.setVisibility(8);
        } else {
            relativeLayout.setOnClickListener(new ViewOnClickListenerC1060ay(this, str2));
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.btn_rename);
        if (!this.f3019a.f2625m && c1450a.f4256b) {
            relativeLayout2.setVisibility(8);
        }
        relativeLayout2.setOnClickListener(new ViewOnClickListenerC1061az(this, editText, c1450a, str, str2, i));
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f3019a);
        builder.setTitle(R.string.detail);
        builder.setView(viewInflate);
        builder.setNeutralButton(R.string.copy_file_path, new DialogInterfaceOnClickListenerC1075bb(this, strSubstring));
        builder.setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null);
        return builder.create();
    }

    /* JADX INFO: renamed from: a */
    private static void m2766a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2767a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    protected final void m2768a(String str, C1450a c1450a, String str2, String str3, int i) {
        InputStream inputStream;
        ZipFile zipFile;
        FileOutputStream fileOutputStream;
        ZipFile zipFile2;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        fileOutputStream2 = null;
        inputStream = null;
        fileOutputStream2 = null;
        InputStream inputStream2 = null;
        boolean z = false;
        if (this.f3019a.f2625m) {
            new File(str + "/" + c1450a.f4255a).renameTo(new File(str + "/" + str3));
            return;
        }
        if (!c1450a.f4257c && !ApkInfoExActivity.m2399b(c1450a.f4255a)) {
            z = true;
        }
        try {
            if (z) {
                inputStream = new FileInputStream(str + "/" + c1450a.f4255a);
                zipFile = null;
            } else {
                ZipFile zipFile3 = new ZipFile(this.f3019a.f2582a);
                try {
                    inputStream = zipFile3.getInputStream(zipFile3.getEntry(str2));
                    zipFile = zipFile3;
                } catch (Exception e) {
                    zipFile2 = zipFile3;
                    fileOutputStream = null;
                    try {
                        Toast.makeText(this.f3019a, R.string.str_rename_failed, 0).show();
                        m2766a(fileOutputStream);
                        m2766a(inputStream2);
                        m2767a(zipFile2);
                    } catch (Throwable th) {
                        zipFile = zipFile2;
                        inputStream = inputStream2;
                        fileOutputStream2 = fileOutputStream;
                        th = th;
                        m2766a(fileOutputStream2);
                        m2766a(inputStream);
                        m2767a(zipFile);
                        throw th;
                    }
                } catch (Throwable th2) {
                    zipFile = zipFile3;
                    th = th2;
                    inputStream = null;
                    m2766a(fileOutputStream2);
                    m2766a(inputStream);
                    m2767a(zipFile);
                    throw th;
                }
            }
            try {
                String str4 = C0985a.m2263d(this.f3019a, "tmp") + C1487s.m3525a(6);
                fileOutputStream = new FileOutputStream(str4);
                try {
                    C0985a.m2244b(inputStream, fileOutputStream);
                    m2766a(fileOutputStream);
                    m2766a(inputStream);
                    m2767a(zipFile);
                    this.f3019a.f2617e.m3049b(str, c1450a.f4255a, c1450a.f4257c);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(i));
                    this.f3019a.f2617e.m3048b(arrayList);
                    String str5 = str + "/" + str3;
                    try {
                        fileInputStream = new FileInputStream(str4);
                    } catch (Exception e2) {
                        e = e2;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                    try {
                        this.f3019a.f2617e.m3041a(str, this.f3019a.f2617e.m3037a(str5, fileInputStream));
                        Toast.makeText(this.f3019a, R.string.file_renamed, 0).show();
                        m2766a(fileInputStream);
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream2 = fileInputStream;
                        try {
                            e.printStackTrace();
                            Toast.makeText(this.f3019a, R.string.str_rename_failed, 0).show();
                            m2766a(fileInputStream2);
                        } catch (Throwable th4) {
                            th = th4;
                            fileInputStream = fileInputStream2;
                            m2766a(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        m2766a(fileInputStream);
                        throw th;
                    }
                } catch (Exception e4) {
                    inputStream2 = inputStream;
                    zipFile2 = zipFile;
                    Toast.makeText(this.f3019a, R.string.str_rename_failed, 0).show();
                    m2766a(fileOutputStream);
                    m2766a(inputStream2);
                    m2767a(zipFile2);
                } catch (Throwable th6) {
                    fileOutputStream2 = fileOutputStream;
                    th = th6;
                    m2766a(fileOutputStream2);
                    m2766a(inputStream);
                    m2767a(zipFile);
                    throw th;
                }
            } catch (Exception e5) {
                fileOutputStream = null;
                inputStream2 = inputStream;
                zipFile2 = zipFile;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e6) {
            fileOutputStream = null;
            zipFile2 = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            zipFile = null;
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m2769a(String str, boolean z, boolean z2) {
        Set setM3057e = this.f3019a.f2617e.m3057e();
        if (setM3057e.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String strM3038a = this.f3019a.f2617e.m3038a(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(setM3057e.size());
        arrayList3.addAll(setM3057e);
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            arrayList2.add(((C1450a) arrayList.get(((Integer) it.next()).intValue())).f4255a);
        }
        this.f3019a.m2435a(str, strM3038a, arrayList2, z, !z2);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.menu_home) {
            this.f3019a.f2617e.m3051c(this.f3019a.f2614b);
            this.f3019a.f2618f.m3072a(this.f3019a.f2614b);
            return;
        }
        if (id == R.id.menu_done) {
            this.f3019a.f2617e.m3045a(false);
            return;
        }
        if (id == R.id.menu_select) {
            Set setM3057e = this.f3019a.f2617e.m3057e();
            int count = this.f3019a.f2617e.getCount();
            ArrayList arrayList = new ArrayList(count);
            this.f3019a.f2617e.m3038a(arrayList);
            if (setM3057e.size() != ("..".equals(((C1450a) arrayList.get(0)).f4255a) ? count - 1 : count)) {
                this.f3019a.f2617e.m3045a(true);
                return;
            } else {
                this.f3019a.f2617e.m3045a(false);
                return;
            }
        }
        if (id == R.id.menu_addfile) {
            this.f3019a.m2454f();
            return;
        }
        if (id == R.id.menu_addfolder) {
            this.f3019a.m2457g();
            return;
        }
        if (id == R.id.menu_searchoptions) {
            this.f3019a.m2469n();
            return;
        }
        if (id == R.id.menu_caseinsensitive) {
            this.f3019a.m2470o();
            return;
        }
        if (id == R.drawable.ic_res_extract) {
            Set setM3057e2 = this.f3019a.f2617e.m3057e();
            if (setM3057e2.isEmpty()) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(setM3057e2);
            Collections.sort(arrayList2);
            this.f3019a.m2437a((List) arrayList2);
            return;
        }
        if (id == R.drawable.ic_res_replace) {
            Set setM3057e3 = this.f3019a.f2617e.m3057e();
            if (setM3057e3.isEmpty()) {
                return;
            }
            int iIntValue = ((Integer) setM3057e3.iterator().next()).intValue();
            ArrayList arrayList3 = new ArrayList();
            this.f3019a.f2617e.m3038a(arrayList3);
            if (((C1450a) arrayList3.get(iIntValue)).f4256b) {
                this.f3019a.m2443b(iIntValue);
                return;
            } else {
                this.f3019a.m2429a(iIntValue);
                return;
            }
        }
        if (id != R.drawable.ic_res_search) {
            if (id == R.drawable.ic_res_delete) {
                Set setM3057e4 = this.f3019a.f2617e.m3057e();
                if (setM3057e4.isEmpty()) {
                    return;
                }
                ArrayList arrayList4 = new ArrayList();
                arrayList4.addAll(setM3057e4);
                Collections.sort(arrayList4);
                this.f3019a.f2617e.m3053c(arrayList4);
                return;
            }
            if (id == R.drawable.ic_res_detail) {
                Set setM3057e5 = this.f3019a.f2617e.m3057e();
                if (setM3057e5.isEmpty()) {
                    return;
                }
                int iIntValue2 = ((Integer) setM3057e5.iterator().next()).intValue();
                ArrayList arrayList5 = new ArrayList();
                m2765a(this.f3019a.f2617e.m3038a(arrayList5), (C1450a) arrayList5.get(iIntValue2), iIntValue2).show();
                return;
            }
            return;
        }
        float f = this.f3019a.getResources().getDisplayMetrics().density;
        int i = (int) ((8.0f * f) + 0.5f);
        int i2 = (int) ((18.0f * f) + 0.5f);
        int i3 = (int) ((f * 20.0f) + 0.5f);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f3019a);
        builder.setTitle(R.string.search);
        C1037a c1037a = new C1037a(this.f3019a, "res_keywords");
        LinearLayout linearLayout = new LinearLayout(this.f3019a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        EditTextWithTip editTextWithTip = new EditTextWithTip(this.f3019a);
        editTextWithTip.setHint(R.string.pls_input_keyword);
        editTextWithTip.setTextColor(ContextCompat.getColor(this.f3019a, C0037k.mdTextMedium(C0037k.m89a(this.f3019a))));
        editTextWithTip.setTextSize(1, 14);
        editTextWithTip.setAdapter(c1037a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(i3, i, i3, 0);
        editTextWithTip.setLayoutParams(layoutParams);
        linearLayout.addView(editTextWithTip);
        CheckBox checkBox = new CheckBox(this.f3019a);
        checkBox.setText(R.string.case_insensitive);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(i2, 0, i2, 0);
        checkBox.setLayoutParams(layoutParams2);
        linearLayout.addView(checkBox);
        CheckBox checkBox2 = new CheckBox(this.f3019a);
        checkBox2.setText(R.string.search_file_names);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(i2, 0, i2, 0);
        checkBox2.setLayoutParams(layoutParams3);
        linearLayout.addView(checkBox2);
        builder.setView(linearLayout);
        builder.setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC1058aw(this, editTextWithTip, checkBox2, checkBox));
        builder.setNegativeButton(android.R.string.cancel, new DialogInterfaceOnClickListenerC1059ax(this));
        builder.show();
    }
}
