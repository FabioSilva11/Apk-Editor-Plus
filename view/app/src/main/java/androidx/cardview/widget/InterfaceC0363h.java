package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;

/* JADX INFO: renamed from: androidx.cardview.widget.h */
/* JADX INFO: loaded from: classes.dex */
interface InterfaceC0363h {
    ColorStateList getBackgroundColor(InterfaceC0362g interfaceC0362g);

    float getElevation(InterfaceC0362g interfaceC0362g);

    float getMaxElevation(InterfaceC0362g interfaceC0362g);

    float getMinHeight(InterfaceC0362g interfaceC0362g);

    float getMinWidth(InterfaceC0362g interfaceC0362g);

    float getRadius(InterfaceC0362g interfaceC0362g);

    void initStatic();

    void initialize(InterfaceC0362g interfaceC0362g, Context context, ColorStateList colorStateList, float f, float f2, float f3);

    void onCompatPaddingChanged(InterfaceC0362g interfaceC0362g);

    void onPreventCornerOverlapChanged(InterfaceC0362g interfaceC0362g);

    void setBackgroundColor(InterfaceC0362g interfaceC0362g, ColorStateList colorStateList);

    void setElevation(InterfaceC0362g interfaceC0362g, float f);

    void setMaxElevation(InterfaceC0362g interfaceC0362g, float f);

    void setRadius(InterfaceC0362g interfaceC0362g, float f);

    void updatePadding(InterfaceC0362g interfaceC0362g);
}
