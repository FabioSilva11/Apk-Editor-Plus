package com.gmail.heagoo.neweditor;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import java.io.Serializable;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.ac */
/* JADX INFO: loaded from: classes.dex */
public class C1501ac extends CharacterStyle implements Serializable {

    /* JADX INFO: renamed from: a */
    private int f4416a;

    public C1501ac(int i) {
        this.f4416a = i;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.f4416a);
    }
}
