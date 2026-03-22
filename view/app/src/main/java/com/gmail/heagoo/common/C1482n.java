package com.gmail.heagoo.common;

import android.support.v7.appcompat.C0299R;
import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: renamed from: com.gmail.heagoo.common.n */
/* JADX INFO: loaded from: classes.dex */
final class C1482n implements InputFilter {
    C1482n() {
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        while (i < i2) {
            switch (charSequence.charAt(i)) {
                case '\"':
                case '*':
                case '/':
                case C0299R.styleable.AppCompatTheme_dividerHorizontal /* 58 */:
                case C0299R.styleable.AppCompatTheme_toolbarStyle /* 60 */:
                case C0299R.styleable.AppCompatTheme_popupMenuStyle /* 62 */:
                case '?':
                case C0299R.styleable.AppCompatTheme_colorSwitchThumbNormal /* 92 */:
                case '|':
                    return "";
                default:
                    i++;
                    break;
            }
        }
        return null;
    }
}
