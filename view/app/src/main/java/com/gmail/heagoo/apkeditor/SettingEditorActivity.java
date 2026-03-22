package com.gmail.heagoo.apkeditor;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.SwitchPreference;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import p000a.p001a.p003b.p004a.C0037k;
import ru.zeratul.preference.ColorPreference;

/* JADX INFO: loaded from: classes.dex */
public class SettingEditorActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener {
    /* JADX INFO: renamed from: AB */
    private void m2558AB() {
        ActionBar actionBar = getActionBar();
        View viewInflate = getLayoutInflater().inflate(R.layout.mtrl_toolbar, (ViewGroup) null);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-2, -1, 17);
        ((TextView) viewInflate.findViewById(android.R.id.title)).setText(R.string.action_edit);
        actionBar.setCustomView(viewInflate, layoutParams);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    /* JADX INFO: renamed from: a */
    private static int m2559a(SharedPreferences sharedPreferences) {
        try {
            return Integer.valueOf(sharedPreferences.getString("FontSize", "12")).intValue();
        } catch (Exception e) {
            return 12;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2560a(Context context) {
        return context.getSharedPreferences("editor_colors", 0).getBoolean("LineWrap", true);
    }

    /* JADX INFO: renamed from: b */
    public static int m2561b(Context context) {
        return m2559a(context.getSharedPreferences("editor_colors", 0));
    }

    /* JADX INFO: renamed from: b */
    private static int m2562b(SharedPreferences sharedPreferences) {
        try {
            return Integer.valueOf(sharedPreferences.getString("BigFileSize", "64")).intValue();
        } catch (Exception e) {
            return 64;
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m2563c(Context context) {
        return context.getSharedPreferences("editor_colors", 0).getBoolean("SymbolInput", true);
    }

    /* JADX INFO: renamed from: d */
    public static int m2564d(Context context) {
        return m2562b(context.getSharedPreferences("editor_colors", 0));
    }

    /* JADX INFO: renamed from: e */
    public static boolean m2565e(Context context) {
        return context.getSharedPreferences("editor_colors", 0).getBoolean("ShowLineNumbers", true);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(C0037k.m91md(C0037k.m89a(this)));
        super.onCreate(bundle);
        getPreferenceManager().setSharedPreferencesName("editor_colors");
        addPreferencesFromResource(R.xml.editor_setting);
        m2558AB();
        SwitchPreference switchPreference = (SwitchPreference) findPreference("custom_colors");
        switchPreference.setSummaryOff(R.string.default_res_0x7f070291);
        switchPreference.setSummaryOn(R.string.custom);
        switchPreference.setOnPreferenceChangeListener(this);
        ColorPreference colorPreference = (ColorPreference) findPreference("editor_bg");
        colorPreference.setDependency("custom_colors");
        colorPreference.setOnPreferenceChangeListener(this);
        ColorPreference colorPreference2 = (ColorPreference) findPreference("editor_numbers");
        colorPreference2.setDependency("custom_colors");
        colorPreference2.setOnPreferenceChangeListener(this);
        ColorPreference colorPreference3 = (ColorPreference) findPreference("syntax_1");
        colorPreference3.setDependency("custom_colors");
        colorPreference3.setOnPreferenceChangeListener(this);
        ColorPreference colorPreference4 = (ColorPreference) findPreference("syntax_2");
        colorPreference4.setDependency("custom_colors");
        colorPreference4.setOnPreferenceChangeListener(this);
        ColorPreference colorPreference5 = (ColorPreference) findPreference("syntax_3");
        colorPreference5.setDependency("custom_colors");
        colorPreference5.setOnPreferenceChangeListener(this);
        ColorPreference colorPreference6 = (ColorPreference) findPreference("syntax_4");
        colorPreference6.setDependency("custom_colors");
        colorPreference6.setOnPreferenceChangeListener(this);
        ColorPreference colorPreference7 = (ColorPreference) findPreference("syntax_5");
        colorPreference7.setDependency("custom_colors");
        colorPreference7.setOnPreferenceChangeListener(this);
        ColorPreference colorPreference8 = (ColorPreference) findPreference("syntax_6");
        colorPreference8.setDependency("custom_colors");
        colorPreference8.setOnPreferenceChangeListener(this);
        ColorPreference colorPreference9 = (ColorPreference) findPreference("syntax_7");
        colorPreference9.setDependency("custom_colors");
        colorPreference9.setOnPreferenceChangeListener(this);
        ColorPreference colorPreference10 = (ColorPreference) findPreference("syntax_8");
        colorPreference10.setDependency("custom_colors");
        colorPreference10.setOnPreferenceChangeListener(this);
        ColorPreference colorPreference11 = (ColorPreference) findPreference("syntax_9");
        colorPreference11.setDependency("custom_colors");
        colorPreference11.setOnPreferenceChangeListener(this);
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

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        int iM2561b;
        int iM2564d;
        String key = preference.getKey();
        if ("LineWrap".equals(key)) {
            if (((Boolean) obj).booleanValue()) {
                preference.setSummary(R.string.line_wrap_enabled);
            } else {
                preference.setSummary(R.string.line_wrap_disabled);
            }
        } else if ("FontSize".equals(key)) {
            try {
                iM2561b = Integer.valueOf((String) obj).intValue();
            } catch (Exception e) {
                iM2561b = m2561b(this);
            }
            preference.setSummary(String.format(getString(R.string.font_size_summary), Integer.valueOf(iM2561b)));
        } else if ("BigFileSize".equals(key)) {
            try {
                iM2564d = Integer.valueOf((String) obj).intValue();
            } catch (Exception e2) {
                iM2564d = m2564d(this);
            }
            preference.setSummary(String.format(getString(R.string.use_bfe_summary), Integer.valueOf(iM2564d)));
        } else if ("ShowLineNumbers".equals(key)) {
            if (((Boolean) obj).booleanValue()) {
                preference.setSummary(R.string.line_numebrs_enabled);
            } else {
                preference.setSummary(R.string.line_numbers_disabled);
            }
        } else if (key.equals("custom_colors") || key.equals("editor_bg") || key.equals("editor_numbers") || key.equals("syntax_1") || key.equals("syntax_2") || key.equals("syntax_3") || key.equals("syntax_4") || key.equals("syntax_5") || key.equals("syntax_6") || key.equals("syntax_7") || key.equals("syntax_8") || key.equals("syntax_9")) {
            AbstractActivityC1258gy.f3573z = true;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("editor_colors", 0);
        SwitchPreference switchPreference = (SwitchPreference) findPreference("LineWrap");
        switchPreference.setOnPreferenceChangeListener(this);
        if (sharedPreferences.getBoolean("LineWrap", true)) {
            switchPreference.setSummary(R.string.line_wrap_enabled);
            switchPreference.setChecked(true);
        } else {
            switchPreference.setSummary(R.string.line_wrap_disabled);
            switchPreference.setChecked(false);
        }
        EditTextPreference editTextPreference = (EditTextPreference) findPreference("FontSize");
        editTextPreference.setOnPreferenceChangeListener(this);
        editTextPreference.setSummary(String.format(getString(R.string.font_size_summary), Integer.valueOf(m2559a(sharedPreferences))));
        EditTextPreference editTextPreference2 = (EditTextPreference) findPreference("BigFileSize");
        editTextPreference2.setOnPreferenceChangeListener(this);
        editTextPreference2.setSummary(String.format(getString(R.string.use_bfe_summary), Integer.valueOf(m2562b(sharedPreferences))));
        SwitchPreference switchPreference2 = (SwitchPreference) findPreference("ShowLineNumbers");
        switchPreference2.setOnPreferenceChangeListener(this);
        if (sharedPreferences.getBoolean("ShowLineNumbers", true)) {
            switchPreference2.setSummary(R.string.line_numebrs_enabled);
            switchPreference2.setChecked(true);
        } else {
            switchPreference2.setSummary(R.string.line_numbers_disabled);
            switchPreference2.setChecked(false);
        }
        ((SwitchPreference) findPreference("SymbolInput")).setChecked(sharedPreferences.getBoolean("SymbolInput", true));
        ImageView imageView = (ImageView) findViewById(R.id.title_icon);
        if (imageView != null) {
            imageView.setImageResource(((Integer) C0985a.m2190a("com.gmail.heagoo.seticon.SetIcon", "getSelectedIcon", new Class[]{Activity.class}, new Object[]{this})).intValue());
        }
    }
}
