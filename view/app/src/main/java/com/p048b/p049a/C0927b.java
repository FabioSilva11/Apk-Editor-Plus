package com.p048b.p049a;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: renamed from: com.b.a.b */
/* JADX INFO: loaded from: classes.dex */
final class C0927b implements InputFilter {
    C0927b(C0926a c0926a) {
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (!((cCharAt < '0' || cCharAt > '9') ? (cCharAt < 'a' || cCharAt > 'f') ? cCharAt >= 'A' && cCharAt <= 'F' : true : true)) {
                return "";
            }
            i++;
        }
        return null;
    }
}
