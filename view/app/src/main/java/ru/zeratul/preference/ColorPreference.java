package ru.zeratul.preference;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v4.provider.FontsContractCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ColorPreference extends DialogPreference {

    /* JADX INFO: renamed from: a */
    private ViewOnClickListenerC1838a f4817a;

    /* JADX INFO: renamed from: b */
    private Integer f4818b;

    public ColorPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private Integer m3941a() {
        return getSharedPreferences().contains(getKey()) ? Integer.valueOf(getPersistedInt(-7829368)) : this.f4818b;
    }

    /* JADX INFO: renamed from: b */
    private void m3942b(Integer num) {
        if (num == null) {
            m3943c();
        } else {
            persistInt(num.intValue());
        }
        notifyChanged();
    }

    /* JADX INFO: renamed from: c */
    private void m3943c() {
        if (shouldPersist()) {
            getSharedPreferences().edit().remove(getKey()).commit();
        }
    }

    /* JADX INFO: renamed from: d */
    private static String m3944d(String str) {
        if (str.charAt(0) != '#' || str.length() > "#argb".length()) {
            return str;
        }
        String string = "#";
        for (int i = 1; i < str.length(); i++) {
            string = new StringBuffer().append(new StringBuffer().append(string).append(str.charAt(i)).toString()).append(str.charAt(i)).toString();
        }
        return string;
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        Integer numM3941a = m3941a();
        setSummary("#" + String.format("%02X%02X%02X%02X", new Integer(Color.alpha(numM3941a.intValue())), new Integer(Color.red(numM3941a.intValue())), new Integer(Color.green(numM3941a.intValue())), new Integer(Color.blue(numM3941a.intValue()))));
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.widget_frame);
        viewGroup.setVisibility(0);
        viewGroup.removeAllViews();
        LayoutInflater.from(getContext()).inflate(isEnabled() ? com.gmail.heagoo.apkeditor.pro.R.layout.cpv_thumb : com.gmail.heagoo.apkeditor.pro.R.layout.cpv_thumb_disabled, viewGroup);
        View viewFindViewById = viewGroup.findViewById(com.gmail.heagoo.apkeditor.pro.R.id.image);
        if (numM3941a == null) {
            numM3941a = this.f4818b;
        }
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(numM3941a == null ? 8 : 0);
            View viewFindViewById2 = viewFindViewById.findViewById(com.gmail.heagoo.apkeditor.pro.R.id.result_image);
            Drawable drawableMutate = viewFindViewById2.getBackground().mutate();
            drawableMutate.setTint(numM3941a != null ? numM3941a.intValue() : 0);
            viewFindViewById2.setBackground(drawableMutate);
        }
        super.onBindView(view);
    }

    @Override // android.preference.DialogPreference, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case FontsContractCompat.FontRequestCallback.FAIL_REASON_FONT_LOAD_ERROR /* -3 */:
                if (callChangeListener((Object) null)) {
                    m3942b((Integer) null);
                }
                break;
            case -2:
                dialogInterface.dismiss();
                break;
            case -1:
                int iM3953i = this.f4817a.m3953i();
                if (callChangeListener(new Integer(iM3953i))) {
                    m3942b(new Integer(iM3953i));
                }
                break;
        }
    }

    @Override // android.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        if (typedArray.peekValue(i) == null || typedArray.peekValue(i).type != 3) {
            this.f4818b = Integer.valueOf(typedArray.getColor(i, -7829368));
        } else {
            this.f4818b = Integer.valueOf(Color.parseColor(m3944d(typedArray.getString(i))));
        }
        return this.f4818b;
    }

    @Override // android.preference.DialogPreference
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        this.f4817a = new ViewOnClickListenerC1838a(getContext());
        this.f4817a.m3952h(getPersistedInt(this.f4818b == null ? -7829368 : this.f4818b.intValue()));
        builder.setTitle((CharSequence) null);
        builder.setView(this.f4817a);
        builder.setPositiveButton(com.gmail.heagoo.apkeditor.pro.R.string.set, this);
        builder.setNegativeButton(R.string.cancel, this);
        builder.setNeutralButton(com.gmail.heagoo.apkeditor.pro.R.string.reset, this);
    }

    @Override // android.preference.Preference
    protected void onSetInitialValue(boolean z, Object obj) {
        m3942b(z ? m3941a() : this.f4818b);
    }

    @Override // android.preference.DialogPreference
    protected void showDialog(Bundle bundle) {
        super.showDialog(bundle);
        getDialog().getWindow().setSoftInputMode(2);
    }
}
