package com.gmail.heagoo.apkeditor;

import android.preference.Preference;
import android.preference.SwitchPreference;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gh */
/* JADX INFO: loaded from: classes.dex */
final class C1241gh implements Preference.OnPreferenceChangeListener {
    C1241gh(SettingActivity settingActivity) {
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference preference, Object obj) {
        SwitchPreference switchPreference = (SwitchPreference) preference;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        switchPreference.setChecked(zBooleanValue);
        switchPreference.setSummary(zBooleanValue ? R.string.smali_edit_summary : R.string.smali_edit_disabled_summary);
        return true;
    }
}
