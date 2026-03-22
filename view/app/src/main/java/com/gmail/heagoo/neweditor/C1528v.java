package com.gmail.heagoo.neweditor;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.v */
/* JADX INFO: loaded from: classes.dex */
final class C1528v extends BaseInputConnection {
    C1528v(ObEditText obEditText, View view, boolean z) {
        super(view, false);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        return (i == 1 && i2 == 0) ? super.sendKeyEvent(new KeyEvent(0, 67)) && super.sendKeyEvent(new KeyEvent(1, 67)) : super.deleteSurroundingText(i, i2);
    }
}
