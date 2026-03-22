package androidx.cardview.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: renamed from: androidx.cardview.widget.a */
/* JADX INFO: loaded from: classes.dex */
class C0356a implements InterfaceC0362g {
    private Drawable mCardBackground;
    final /* synthetic */ CardView this$0;

    C0356a(CardView cardView) {
        this.this$0 = cardView;
    }

    @Override // androidx.cardview.widget.InterfaceC0362g
    public Drawable getCardBackground() {
        return this.mCardBackground;
    }

    @Override // androidx.cardview.widget.InterfaceC0362g
    public View getCardView() {
        return this.this$0;
    }

    @Override // androidx.cardview.widget.InterfaceC0362g
    public boolean getPreventCornerOverlap() {
        return this.this$0.getPreventCornerOverlap();
    }

    @Override // androidx.cardview.widget.InterfaceC0362g
    public boolean getUseCompatPadding() {
        return this.this$0.getUseCompatPadding();
    }

    @Override // androidx.cardview.widget.InterfaceC0362g
    public void setCardBackground(Drawable drawable) {
        this.mCardBackground = drawable;
        this.this$0.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.InterfaceC0362g
    public void setMinWidthHeightInternal(int i, int i2) {
        if (i > this.this$0.mUserSetMinWidth) {
            super/*android.widget.FrameLayout*/.setMinimumWidth(i);
        }
        if (i2 > this.this$0.mUserSetMinHeight) {
            super/*android.widget.FrameLayout*/.setMinimumHeight(i2);
        }
    }

    @Override // androidx.cardview.widget.InterfaceC0362g
    public void setShadowPadding(int i, int i2, int i3, int i4) {
        this.this$0.mShadowBounds.set(i, i2, i3, i4);
        CardView cardView = this.this$0;
        super/*android.widget.FrameLayout*/.setPadding(i + cardView.mContentPadding.left, i2 + this.this$0.mContentPadding.top, i3 + this.this$0.mContentPadding.right, i4 + this.this$0.mContentPadding.bottom);
    }
}
