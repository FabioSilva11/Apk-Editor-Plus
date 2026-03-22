package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: renamed from: androidx.cardview.widget.d */
/* JADX INFO: loaded from: classes.dex */
class C0359d implements InterfaceC0363h {
    C0359d() {
    }

    private C0364i getCardBackground(InterfaceC0362g interfaceC0362g) {
        return (C0364i) interfaceC0362g.getCardBackground();
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public ColorStateList getBackgroundColor(InterfaceC0362g interfaceC0362g) {
        return getCardBackground(interfaceC0362g).getColor();
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public float getElevation(InterfaceC0362g interfaceC0362g) {
        return interfaceC0362g.getCardView().getElevation();
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public float getMaxElevation(InterfaceC0362g interfaceC0362g) {
        return getCardBackground(interfaceC0362g).getPadding();
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public float getMinHeight(InterfaceC0362g interfaceC0362g) {
        return getRadius(interfaceC0362g) * 2.0f;
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public float getMinWidth(InterfaceC0362g interfaceC0362g) {
        return getRadius(interfaceC0362g) * 2.0f;
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public float getRadius(InterfaceC0362g interfaceC0362g) {
        return getCardBackground(interfaceC0362g).getRadius();
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void initStatic() {
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void initialize(InterfaceC0362g interfaceC0362g, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        interfaceC0362g.setCardBackground(new C0364i(colorStateList, f));
        View cardView = interfaceC0362g.getCardView();
        cardView.setClipToOutline(true);
        cardView.setElevation(f2);
        setMaxElevation(interfaceC0362g, f3);
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void onCompatPaddingChanged(InterfaceC0362g interfaceC0362g) {
        setMaxElevation(interfaceC0362g, getMaxElevation(interfaceC0362g));
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void onPreventCornerOverlapChanged(InterfaceC0362g interfaceC0362g) {
        setMaxElevation(interfaceC0362g, getMaxElevation(interfaceC0362g));
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void setBackgroundColor(InterfaceC0362g interfaceC0362g, ColorStateList colorStateList) {
        getCardBackground(interfaceC0362g).setColor(colorStateList);
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void setElevation(InterfaceC0362g interfaceC0362g, float f) {
        interfaceC0362g.getCardView().setElevation(f);
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void setMaxElevation(InterfaceC0362g interfaceC0362g, float f) {
        getCardBackground(interfaceC0362g).setPadding(f, interfaceC0362g.getUseCompatPadding(), interfaceC0362g.getPreventCornerOverlap());
        updatePadding(interfaceC0362g);
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void setRadius(InterfaceC0362g interfaceC0362g, float f) {
        getCardBackground(interfaceC0362g).setRadius(f);
    }

    @Override // androidx.cardview.widget.InterfaceC0363h
    public void updatePadding(InterfaceC0362g interfaceC0362g) {
        if (!interfaceC0362g.getUseCompatPadding()) {
            interfaceC0362g.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float maxElevation = getMaxElevation(interfaceC0362g);
        float radius = getRadius(interfaceC0362g);
        int iCeil = (int) Math.ceil(C0365j.calculateHorizontalPadding(maxElevation, radius, interfaceC0362g.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(C0365j.calculateVerticalPadding(maxElevation, radius, interfaceC0362g.getPreventCornerOverlap()));
        interfaceC0362g.setShadowPadding(iCeil, iCeil2, iCeil, iCeil2);
    }
}
