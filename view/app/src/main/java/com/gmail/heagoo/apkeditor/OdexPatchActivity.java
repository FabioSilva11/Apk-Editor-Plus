package com.gmail.heagoo.apkeditor;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import p000a.p001a.p003b.p004a.C0037k;

/* JADX INFO: loaded from: classes.dex */
public class OdexPatchActivity extends Activity implements View.OnClickListener, InterfaceC1122cu {

    /* JADX INFO: renamed from: a */
    private EditText f2725a;

    /* JADX INFO: renamed from: b */
    private String f2726b;

    /* JADX INFO: renamed from: AB */
    private void m2534AB() {
        ActionBar actionBar = getActionBar();
        View viewInflate = getLayoutInflater().inflate(R.layout.mtrl_toolbar, (ViewGroup) null);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-2, -1, 17);
        ((TextView) viewInflate.findViewById(android.R.id.title)).setText(R.string.action_odex);
        actionBar.setCustomView(viewInflate, layoutParams);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final void mo2502a(String str, String str2, boolean z) {
        this.f2725a.setText(str);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: a */
    public final boolean mo2503a(String str, String str2) {
        return str.endsWith(".apk");
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1122cu
    /* JADX INFO: renamed from: b */
    public final String mo2504b(String str, String str2) {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_select_apkpath) {
            new DialogC1115cn(this, this, ".apk", "", null).show();
        } else if (id == R.id.btn_apply_patch) {
            this.f2726b = this.f2725a.getText().toString();
            new DialogC1201ey(this, new C1196et(this), -1).show();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(C0037k.m91md(C0037k.m89a(this)));
        super.onCreate(bundle);
        m2534AB();
        setContentView(R.layout.activity_odex_patch);
        this.f2725a = (EditText) findViewById(R.id.et_apkpath);
        ((Button) findViewById(R.id.btn_select_apkpath)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_apply_patch)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return false;
        }
    }
}
