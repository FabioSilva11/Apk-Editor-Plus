package com.gmail.heagoo.apkeditor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.ListPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: loaded from: classes.dex */
public class KeyListPreference extends ListPreference implements Preference.OnPreferenceClickListener {

    /* JADX INFO: renamed from: a */
    private Context f2708a;

    public KeyListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2708a = context;
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference
    protected void onDialogClosed(boolean z) {
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        return false;
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        String value = getValue();
        int length = getEntryValues().length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = 2;
                break;
            } else if (value.equals(getEntryValues()[i])) {
                break;
            } else {
                i++;
            }
        }
        builder.setSingleChoiceItems(R.array.signer_key, i, new DialogInterfaceOnClickListenerC1130de(this));
        builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }
}
