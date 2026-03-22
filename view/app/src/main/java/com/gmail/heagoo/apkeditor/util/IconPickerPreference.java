package com.gmail.heagoo.apkeditor.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class IconPickerPreference extends ListPreference {

    /* JADX INFO: renamed from: a */
    private Context f3977a;

    /* JADX INFO: renamed from: b */
    private int[] f3978b;

    /* JADX INFO: renamed from: c */
    private CharSequence[] f3979c;

    /* JADX INFO: renamed from: d */
    private CharSequence[] f3980d;

    /* JADX INFO: renamed from: e */
    private List f3981e;

    /* JADX INFO: renamed from: f */
    private SharedPreferences f3982f;

    /* JADX INFO: renamed from: g */
    private Resources f3983g;

    /* JADX INFO: renamed from: h */
    private String f3984h;

    /* JADX INFO: renamed from: i */
    private String f3985i;

    /* JADX INFO: renamed from: j */
    private TextView f3986j;

    public IconPickerPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3977a = context;
        this.f3983g = context.getResources();
        this.f3982f = PreferenceManager.getDefaultSharedPreferences(context);
        this.f3979c = this.f3983g.getStringArray(R.array.appicon_key);
        this.f3980d = this.f3983g.getStringArray(R.array.appicon_value);
        this.f3985i = this.f3980d[0].toString();
        this.f3984h = this.f3982f.getString("MyIcon", this.f3985i);
        this.f3978b = (int[]) C0985a.m2190a("com.gmail.heagoo.seticon.SetIcon", "getAllIcons", (Class[]) null, (Object[]) null);
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        if (Build.VERSION.SDK_INT < 21) {
            view.setPadding((int) ((view.getPaddingLeft() / 16.0f) * 6.0f), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
        ((TextView) view.findViewById(R.id.title)).setText(R.string.launcher_icon);
        this.f3986j = (TextView) view.findViewById(R.id.summary);
        for (int i = 0; i < this.f3980d.length; i++) {
            if (this.f3984h.equals(this.f3980d[i])) {
                this.f3986j.setText(this.f3979c[i]);
                return;
            }
        }
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference
    protected void onDialogClosed(boolean z) {
        super.onDialogClosed(z);
        if (this.f3981e != null) {
            for (int i = 0; i < this.f3979c.length; i++) {
                C1398v c1398v = (C1398v) this.f3981e.get(i);
                if (c1398v.f4059b) {
                    SharedPreferences.Editor editorEdit = this.f3982f.edit();
                    editorEdit.putString("MyIcon", c1398v.f4061d);
                    editorEdit.commit();
                    this.f3986j.setText(c1398v.f4060c);
                    String str = c1398v.f4061d;
                    if (this.f3984h.equals(str)) {
                        return;
                    }
                    this.f3984h = str;
                    C0985a.m2190a("com.gmail.heagoo.seticon.SetIcon", "setIcon", new Class[]{Activity.class, String.class}, new Object[]{(Activity) this.f3977a, str});
                    Toast.makeText(this.f3977a, R.string.icon_changed_tip, 1).show();
                    return;
                }
            }
        }
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        builder.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
        this.f3979c = getEntries();
        this.f3980d = getEntryValues();
        if (this.f3979c == null || this.f3980d == null || this.f3979c.length != this.f3980d.length) {
            throw new IllegalStateException("Invalid arguments.");
        }
        this.f3981e = new ArrayList();
        for (int i = 0; i < this.f3979c.length; i++) {
            this.f3981e.add(new C1398v(this.f3979c[i], this.f3980d[i], this.f3978b[i], this.f3984h.equals(this.f3980d[i])));
        }
        builder.setAdapter(new C1396t(this, this.f3977a, R.layout.item_iconpicker, this.f3981e), null);
    }
}
