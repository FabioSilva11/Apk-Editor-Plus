package com.gmail.heagoo.apkeditor.p062ac;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public class EditTextWithTip extends AutoCompleteTextView {
    public EditTextWithTip(Context context) {
        super(context);
    }

    public EditTextWithTip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EditTextWithTip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        return true;
    }
}
