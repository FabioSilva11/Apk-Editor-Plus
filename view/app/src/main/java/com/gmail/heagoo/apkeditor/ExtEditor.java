package com.gmail.heagoo.apkeditor;

import android.preference.Preference;
import android.preference.SwitchPreference;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: loaded from: classes.dex */
public final class ExtEditor implements Preference.OnPreferenceChangeListener {
    public ExtEditor(SettingActivity settingActivity) {
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference preference, Object obj) {
        SwitchPreference switchPreference = (SwitchPreference) preference;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        switchPreference.setChecked(zBooleanValue);
        switchPreference.setSummary(zBooleanValue ? R.string.external_editor_e_summary : R.string.external_editor_d_summary);
        return true;
    }
}
