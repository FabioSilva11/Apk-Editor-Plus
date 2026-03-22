package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0299R;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void forceUniformWidth(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private static int resolveMinimumHeight(View view) {
        View childAt = view;
        while (true) {
            int minimumHeight = ViewCompat.getMinimumHeight(childAt);
            if (minimumHeight <= 0) {
                if (!(childAt instanceof ViewGroup)) {
                    break;
                }
                ViewGroup viewGroup = (ViewGroup) childAt;
                if (viewGroup.getChildCount() != 1) {
                    break;
                }
                childAt = viewGroup.getChildAt(0);
            } else {
                return minimumHeight;
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    private boolean tryOnMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iCombineMeasuredStates;
        int i6;
        int i7;
        int iCombineMeasuredStates2;
        View view;
        View view2 = null;
        View view3 = null;
        int childCount = getChildCount();
        int i8 = 0;
        View view4 = null;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == C0299R.id.topPanel) {
                    View view5 = view3;
                    view = childAt;
                    childAt = view5;
                } else if (id == C0299R.id.buttonPanel) {
                    view = view2;
                } else {
                    if ((id != C0299R.id.contentPanel && id != C0299R.id.customPanel) || view4 != null) {
                        return false;
                    }
                    view4 = childAt;
                    childAt = view3;
                    view = view2;
                }
            } else {
                childAt = view3;
                view = view2;
            }
            i8++;
            view2 = view;
            view3 = childAt;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int iCombineMeasuredStates3 = 0;
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (view2 != null) {
            view2.measure(i, 0);
            paddingBottom += view2.getMeasuredHeight();
            iCombineMeasuredStates3 = View.combineMeasuredStates(0, view2.getMeasuredState());
        }
        int iResolveMinimumHeight = 0;
        if (view3 != null) {
            view3.measure(i, 0);
            iResolveMinimumHeight = resolveMinimumHeight(view3);
            int measuredHeight = view3.getMeasuredHeight() - iResolveMinimumHeight;
            paddingBottom += iResolveMinimumHeight;
            iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, view3.getMeasuredState());
            i3 = measuredHeight;
        } else {
            i3 = 0;
        }
        if (view4 != null) {
            view4.measure(i, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingBottom), mode));
            int measuredHeight2 = view4.getMeasuredHeight();
            paddingBottom += measuredHeight2;
            iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, view4.getMeasuredState());
            i4 = measuredHeight2;
        } else {
            i4 = 0;
        }
        int i9 = size - paddingBottom;
        if (view3 != null) {
            int i10 = paddingBottom - iResolveMinimumHeight;
            int iMin = Math.min(i9, i3);
            if (iMin > 0) {
                i9 -= iMin;
                iResolveMinimumHeight += iMin;
            }
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(iResolveMinimumHeight, 1073741824));
            int measuredHeight3 = view3.getMeasuredHeight() + i10;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates3, view3.getMeasuredState());
            int i11 = i9;
            i6 = measuredHeight3;
            i5 = i11;
        } else {
            i5 = i9;
            iCombineMeasuredStates = iCombineMeasuredStates3;
            i6 = paddingBottom;
        }
        if (view4 == null || i5 <= 0) {
            i7 = i6;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
        } else {
            view4.measure(i, View.MeasureSpec.makeMeasureSpec(i5 + i4, mode));
            int measuredHeight4 = (i6 - i4) + view4.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, view4.getMeasuredState());
            i7 = measuredHeight4;
        }
        int iMax = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(iMax + getPaddingLeft() + getPaddingRight(), i, iCombineMeasuredStates2), View.resolveSizeAndState(i7, i2, 0));
        if (mode2 != 1073741824) {
            forceUniformWidth(childCount, i2);
        }
        return true;
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i7 = gravity & C0299R.styleable.AppCompatTheme_ratingBarStyleSmall;
        int i8 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        switch (i7) {
            case 16:
                paddingTop = (((i4 - i2) - measuredHeight) / 2) + getPaddingTop();
                break;
            case C0299R.styleable.AppCompatTheme_textAppearanceListItemSmall /* 80 */:
                paddingTop = ((getPaddingTop() + i4) - i2) - measuredHeight;
                break;
            default:
                paddingTop = getPaddingTop();
                break;
        }
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        int i9 = paddingTop;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i11 = layoutParams.gravity;
                if (i11 < 0) {
                    i11 = i8;
                }
                switch (GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this)) & 7) {
                    case 1:
                        i5 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 5:
                        i5 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                    default:
                        i5 = paddingLeft + layoutParams.leftMargin;
                        break;
                }
                int i12 = layoutParams.topMargin + (hasDividerBeforeChildAt(i10) ? i9 + intrinsicHeight : i9);
                setChildFrame(childAt, i5, i12, measuredWidth, measuredHeight2);
                i9 = i12 + layoutParams.bottomMargin + measuredHeight2;
            }
        }
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i, int i2) {
        if (tryOnMeasure(i, i2)) {
            return;
        }
        super.onMeasure(i, i2);
    }
}
