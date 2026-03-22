package com.gmail.heagoo.apkeditor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.df */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1131df implements View.OnClickListener, InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private View f3196a;

    /* JADX INFO: renamed from: b */
    private Context f3197b;

    /* JADX INFO: renamed from: c */
    private WeakReference f3198c;

    /* JADX INFO: renamed from: d */
    private EditText f3199d;

    /* JADX INFO: renamed from: e */
    private EditText f3200e;

    public ViewOnClickListenerC1131df(KeyListPreference keyListPreference) {
        this.f3198c = new WeakReference(keyListPreference);
    }

    /* JADX INFO: renamed from: a */
    protected final void m2861a() {
        String string = this.f3199d.getText().toString();
        String string2 = this.f3200e.getText().toString();
        if ("".equals(string) || "".equals(string2)) {
            Toast.makeText(this.f3197b, R.string.error_filepath_empty, 1).show();
            return;
        }
        File file = new File(string2);
        File file2 = new File(string);
        if (!file.exists() || !file2.exists()) {
            Toast.makeText(this.f3197b, R.string.error_filepath_notexist, 1).show();
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(this.f3197b).edit();
        editorEdit.putString("PrivateKeyPath", string);
        editorEdit.putString("PublicKeyPath", string2);
        editorEdit.commit();
        KeyListPreference keyListPreference = (KeyListPreference) this.f3198c.get();
        keyListPreference.setValue(new StringBuilder().append((Object) keyListPreference.getEntryValues()[2]).toString());
    }

    /* JADX INFO: renamed from: a */
    public final void m2862a(Context context) {
        this.f3197b = context;
        this.f3196a = LayoutInflater.from(context).inflate(R.layout.dlg_keyselect, (ViewGroup) null, false);
        this.f3199d = (EditText) this.f3196a.findViewById(R.id.et_pk8path);
        this.f3200e = (EditText) this.f3196a.findViewById(R.id.et_x509path);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f3197b);
        this.f3199d.setText(defaultSharedPreferences.getString("PrivateKeyPath", ""));
        this.f3200e.setText(defaultSharedPreferences.getString("PublicKeyPath", ""));
        ((RelativeLayout) this.f3196a.findViewById(R.id.btn_select_pk8)).setOnClickListener(this);
        ((RelativeLayout) this.f3196a.findViewById(R.id.btn_select_x509)).setOnClickListener(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(this.f3196a);
        builder.setTitle(R.string.custom_key_setting);
        builder.setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC1132dg(this));
        builder.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) {
        if (".pk8".equals(str2)) {
            this.f3199d.setText(str);
        } else {
            this.f3200e.setText(str);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        return str.endsWith(".pk8") || str.endsWith(str2);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_select_pk8) {
            new DialogC1115cn(this.f3197b, this, ".pk8", ".pk8", this.f3197b.getString(R.string.select_key_file)).show();
        } else if (id == R.id.btn_select_x509) {
            new DialogC1115cn(this.f3197b, this, ".x509.pem", ".pem", this.f3197b.getString(R.string.select_key_file)).show();
        }
    }
}
