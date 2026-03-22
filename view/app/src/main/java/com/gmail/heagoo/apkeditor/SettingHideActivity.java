package com.gmail.heagoo.apkeditor;

import android.app.ActionBar;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import p000a.p001a.p003b.p004a.C0037k;
import p000a.p001a.p003b.p004a.C0040n;

/* JADX INFO: loaded from: classes.dex */
public class SettingHideActivity extends PreferenceActivity implements Preference.OnPreferenceClickListener {
    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.m91md(C0037k.m89a(this)));
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.pref_hide);
        ActionBar actionBar = getActionBar();
        View viewInflate = getLayoutInflater().inflate(R.layout.mtrl_toolbar, (ViewGroup) null);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-2, -1, 17);
        ((TextView) viewInflate.findViewById(android.R.id.title)).setText(R.string.settings_hidden);
        actionBar.setCustomView(viewInflate, layoutParams);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Preference preferenceFindPreference = findPreference("style_buttons");
        preferenceFindPreference.setSummary(C0040n.m95c(C0040n.m96d(this)));
        preferenceFindPreference.setOnPreferenceClickListener(this);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return false;
        }
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (preference.getKey().equals("style_buttons")) {
            C0037k.f92md = true;
            new C0040n().m98f(this, R.string.layout_title, new C1316jb(this));
        }
        return false;
    }
}
