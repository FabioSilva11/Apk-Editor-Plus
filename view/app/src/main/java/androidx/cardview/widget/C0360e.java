package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: renamed from: androidx.cardview.widget.e */
/* JADX INFO: loaded from: classes.dex */
class C0360e implements InterfaceC0363h {
    final RectF mCornerRect = new RectF();

    C0360e() {
    }

    private C0365j createBackground(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new C0365j(context.getResources(), colorStateList, f, f2, f3);
    }

    private C0365j getShadowBackground(InterfaceC0362g interfaceC0362g) {
        return (C0365j) interfaceC0362g.getCardBackground();
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public ColorStateList getBackgroundColor(InterfaceC0362g interfaceC0362g) {
        return getShadowBackground(interfaceC0362g).getColor();
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public float getElevation(InterfaceC0362g interfaceC0362g) {
        return getShadowBackground(interfaceC0362g).getShadowSize();
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public float getMaxElevation(InterfaceC0362g interfaceC0362g) {
        return getShadowBackground(interfaceC0362g).getMaxShadowSize();
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public float getMinHeight(InterfaceC0362g interfaceC0362g) {
        return getShadowBackground(interfaceC0362g).getMinHeight();
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public float getMinWidth(InterfaceC0362g interfaceC0362g) {
        return getShadowBackground(interfaceC0362g).getMinWidth();
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public float getRadius(InterfaceC0362g interfaceC0362g) {
        return getShadowBackground(interfaceC0362g).getCornerRadius();
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void initStatic() {
        C0365j.sRoundRectHelper = new C0361f(this);
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void initialize(InterfaceC0362g interfaceC0362g, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        C0365j c0365jCreateBackground = createBackground(context, colorStateList, f, f2, f3);
        c0365jCreateBackground.setAddPaddingForCorners(interfaceC0362g.getPreventCornerOverlap());
        interfaceC0362g.setCardBackground(c0365jCreateBackground);
        updatePadding(interfaceC0362g);
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void onCompatPaddingChanged(InterfaceC0362g interfaceC0362g) {
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void onPreventCornerOverlapChanged(InterfaceC0362g interfaceC0362g) {
        getShadowBackground(interfaceC0362g).setAddPaddingForCorners(interfaceC0362g.getPreventCornerOverlap());
        updatePadding(interfaceC0362g);
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void setBackgroundColor(InterfaceC0362g interfaceC0362g, ColorStateList colorStateList) {
        getShadowBackground(interfaceC0362g).setColor(colorStateList);
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void setElevation(InterfaceC0362g interfaceC0362g, float f) {
        getShadowBackground(interfaceC0362g).setShadowSize(f);
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void setMaxElevation(InterfaceC0362g interfaceC0362g, float f) {
        getShadowBackground(interfaceC0362g).setMaxShadowSize(f);
        updatePadding(interfaceC0362g);
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void setRadius(InterfaceC0362g interfaceC0362g, float f) {
        getShadowBackground(interfaceC0362g).setCornerRadius(f);
        updatePadding(interfaceC0362g);
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void updatePadding(InterfaceC0362g interfaceC0362g) {
        Rect rect = new Rect();
        getShadowBackground(interfaceC0362g).getMaxShadowAndCornerPadding(rect);
        interfaceC0362g.setMinWidthHeightInternal((int) Math.ceil(getMinWidth(interfaceC0362g)), (int) Math.ceil(getMinHeight(interfaceC0362g)));
        interfaceC0362g.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
