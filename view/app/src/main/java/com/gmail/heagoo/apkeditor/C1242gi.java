package com.gmail.heagoo.apkeditor;

import android.preference.Preference;
import android.preference.SwitchPreference;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.gi */
/* JADX INFO: loaded from: classes.dex */
final class C1242gi implements Preference.OnPreferenceChangeListener {
    C1242gi(SettingActivity settingActivity) {
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference preference, Object obj) {
        SwitchPreference switchPreference = (SwitchPreference) preference;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        switchPreference.setChecked(zBooleanValue);
        switchPreference.setSummary(zBooleanValue ? R.string.rebuild_confirm_e_summary : R.string.rebuild_confirm_d_summary);
        return true;
    }
}
