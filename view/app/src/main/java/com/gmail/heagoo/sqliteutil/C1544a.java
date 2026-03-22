package com.gmail.heagoo.sqliteutil;

import android.graphics.Rect;
import android.os.Handler;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.Scroller;

/* JADX INFO: renamed from: com.gmail.heagoo.sqliteutil.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1544a extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private long f4620a;

    /* JADX INFO: renamed from: b */
    private final Rect f4621b;

    /* JADX INFO: renamed from: c */
    private boolean f4622c;

    /* JADX INFO: renamed from: d */
    private float f4623d;

    /* JADX INFO: renamed from: e */
    private float f4624e;

    /* JADX INFO: renamed from: f */
    private boolean f4625f;

    /* JADX INFO: renamed from: g */
    private View f4626g;

    /* JADX INFO: renamed from: h */
    private boolean f4627h;

    /* JADX INFO: renamed from: i */
    private VelocityTracker f4628i;

    /* JADX INFO: renamed from: j */
    private int f4629j;

    /* JADX INFO: renamed from: k */
    private long f4630k;

    /* JADX INFO: renamed from: l */
    private View f4631l;

    /* JADX INFO: renamed from: a */
    private static int m3738a(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    /* JADX INFO: renamed from: a */
    private int m3739a(Rect rect) {
        int iMax;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            iMax = Math.min(rect.height() > height ? (rect.top - scrollY) + 0 : (rect.bottom - i) + 0, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            iMax = 0;
        } else {
            iMax = Math.max(rect.height() > height ? 0 - (i - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
        return iMax;
    }

    /* JADX INFO: renamed from: a */
    private void m3741a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() >> 8) & 255;
        if (motionEvent.getPointerId(action) == this.f4629j) {
            int i = action == 0 ? 1 : 0;
            this.f4624e = motionEvent.getX(i);
            this.f4623d = motionEvent.getY(i);
            this.f4629j = motionEvent.getPointerId(i);
            if (this.f4628i != null) {
                this.f4628i.clear();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3742a(View view) {
        view.getDrawingRect(this.f4621b);
        offsetDescendantRectToMyCoords(view, this.f4621b);
        int iM3739a = m3739a(this.f4621b);
        int iM3749b = m3749b(this.f4621b);
        if (iM3749b == 0 && iM3739a == 0) {
            return;
        }
        scrollBy(iM3749b, iM3739a);
    }

    /* JADX INFO: renamed from: a */
    private boolean m3743a() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00f8  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m3744a(int r19) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.sqliteutil.C1544a.m3744a(int):boolean");
    }

    /* JADX INFO: renamed from: a */
    private boolean m3745a(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() - scrollX && i < childAt.getRight() - scrollX;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3746a(View view, int i) {
        view.getDrawingRect(this.f4621b);
        offsetDescendantRectToMyCoords(view, this.f4621b);
        return this.f4621b.right + i >= getScrollX() && this.f4621b.left - i <= getScrollX() + getWidth();
    }

    /* JADX INFO: renamed from: a */
    private boolean m3747a(View view, int i, int i2) {
        view.getDrawingRect(this.f4621b);
        offsetDescendantRectToMyCoords(view, this.f4621b);
        return this.f4621b.bottom + i >= getScrollY() && this.f4621b.top - i <= getScrollY() + i2;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3748a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && m3748a((View) parent, view2);
    }

    /* JADX INFO: renamed from: b */
    private int m3749b(Rect rect) {
        int iMax;
        if (getChildCount() == 0) {
            return 0;
        }
        int width = getWidth();
        int scrollX = getScrollX();
        int i = scrollX + width;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (rect.left > 0) {
            scrollX += horizontalFadingEdgeLength;
        }
        if (rect.right < getChildAt(0).getWidth()) {
            i -= horizontalFadingEdgeLength;
        }
        if (rect.right > i && rect.left > scrollX) {
            iMax = Math.min(rect.width() > width ? (rect.left - scrollX) + 0 : (rect.right - i) + 0, getChildAt(0).getRight() - i);
        } else if (rect.left >= scrollX || rect.right >= i) {
            iMax = 0;
        } else {
            iMax = Math.max(rect.width() > width ? 0 - (i - rect.right) : 0 - (scrollX - rect.left), -getScrollX());
        }
        return iMax;
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ Rect m3750b(C1544a c1544a) {
        return null;
    }

    /* JADX INFO: renamed from: b */
    private boolean m3751b() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            return getWidth() < (childAt.getWidth() + getPaddingLeft()) + getPaddingRight();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00f7  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m3752b(int r19) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.sqliteutil.C1544a.m3752b(int):boolean");
    }

    /* JADX INFO: renamed from: c */
    private boolean m3753c(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        int bottom = (int) (0.5f * (getBottom() - getTop()));
        if (viewFindNextFocus == null || !m3747a(viewFindNextFocus, bottom, getHeight())) {
            if (i == 33 && getScrollY() < bottom) {
                bottom = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom2 = getChildAt(0).getBottom();
                int scrollY = getScrollY() + getHeight();
                if (bottom2 - scrollY < bottom) {
                    bottom = bottom2 - scrollY;
                }
            }
            if (bottom == 0) {
                return false;
            }
            if (i != 130) {
                bottom = -bottom;
            }
            m3755e(bottom);
        } else {
            viewFindNextFocus.getDrawingRect(this.f4621b);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f4621b);
            m3755e(m3739a(this.f4621b));
            viewFindNextFocus.requestFocus(i);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused()) {
            if (m3747a(viewFindFocus, 0, getHeight()) ? false : true) {
                int descendantFocusability = getDescendantFocusability();
                setDescendantFocusability(131072);
                requestFocus();
                setDescendantFocusability(descendantFocusability);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: d */
    private boolean m3754d(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        int right = (int) (0.5f * (getRight() - getLeft()));
        if (viewFindNextFocus == null || !m3746a(viewFindNextFocus, right)) {
            if (i == 17 && getScrollX() < right) {
                right = getScrollX();
            } else if (i == 66 && getChildCount() > 0) {
                int right2 = getChildAt(0).getRight();
                int scrollX = getScrollX() + getWidth();
                if (right2 - scrollX < right) {
                    right = right2 - scrollX;
                }
            }
            if (right == 0) {
                return false;
            }
            if (i != 66) {
                right = -right;
            }
            m3756f(right);
        } else {
            viewFindNextFocus.getDrawingRect(this.f4621b);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f4621b);
            m3756f(m3749b(this.f4621b));
            viewFindNextFocus.requestFocus(i);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused()) {
            if (m3746a(viewFindFocus, 0) ? false : true) {
                int descendantFocusability = getDescendantFocusability();
                setDescendantFocusability(131072);
                requestFocus();
                setDescendantFocusability(descendantFocusability);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: e */
    private void m3755e(int i) {
        if (i != 0) {
            scrollBy(0, i);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m3756f(int i) {
        if (i != 0) {
            scrollBy(i, 0);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    @Override // android.view.View
    protected final int computeHorizontalScrollOffset() {
        return Math.max(0, super.computeHorizontalScrollOffset());
    }

    @Override // android.view.View
    protected final int computeHorizontalScrollRange() {
        return getChildCount() == 0 ? (getWidth() - getPaddingLeft()) - getPaddingRight() : getChildAt(0).getRight();
    }

    @Override // android.view.View
    public final void computeScroll() {
        Scroller scroller = null;
        if (scroller.computeScrollOffset()) {
            int currX = scroller.getCurrX();
            int currY = scroller.getCurrY();
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                super.scrollTo(m3738a(currX, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth()), m3738a(currY, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight()));
            }
            awakenScrollBars();
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    protected final int computeVerticalScrollRange() {
        return getChildCount() == 0 ? (getHeight() - getPaddingBottom()) - getPaddingTop() : getChildAt(0).getBottom();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean zM3744a;
        if (!super.dispatchKeyEvent(keyEvent)) {
            this.f4621b.setEmpty();
            if (keyEvent.getAction() == 0) {
                switch (keyEvent.getKeyCode()) {
                    case 19:
                        if (!m3743a()) {
                            zM3744a = false;
                        } else if (!keyEvent.isAltPressed()) {
                            zM3744a = m3753c(33);
                        } else {
                            zM3744a = m3744a(33);
                        }
                        break;
                    case 20:
                        if (!m3743a()) {
                            zM3744a = false;
                        } else if (!keyEvent.isAltPressed()) {
                            zM3744a = m3753c(130);
                        } else {
                            zM3744a = m3744a(130);
                        }
                        break;
                    case 21:
                        if (!m3751b()) {
                            zM3744a = false;
                        } else if (!keyEvent.isAltPressed()) {
                            zM3744a = m3754d(17);
                        } else {
                            zM3744a = m3752b(17);
                        }
                        break;
                    case 22:
                        if (!m3751b()) {
                            zM3744a = false;
                        } else if (!keyEvent.isAltPressed()) {
                            zM3744a = m3754d(66);
                        } else {
                            zM3744a = m3752b(66);
                        }
                        break;
                    default:
                        zM3744a = false;
                        break;
                }
            } else {
                zM3744a = false;
            }
            if (!zM3744a) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    protected final float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected final float getLeftFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (getScrollX() < horizontalFadingEdgeLength) {
            return getScrollX() / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected final float getRightFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int right = (getChildAt(0).getRight() - getScrollX()) - (getWidth() - getPaddingRight());
        if (right < horizontalFadingEdgeLength) {
            return right / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected final float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (getScrollY() < verticalFadingEdgeLength) {
            return getScrollY() / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.ViewGroup
    protected final void measureChild(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected final void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, 0), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        if (getChildCount() > 0) {
            this.f4631l = getChildAt(0);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f4627h) {
            return true;
        }
        switch (action & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (!m3745a((int) x, (int) y)) {
                    this.f4627h = false;
                } else {
                    this.f4623d = y;
                    this.f4624e = x;
                    this.f4629j = motionEvent.getPointerId(0);
                    Scroller scroller = null;
                    this.f4627h = scroller.isFinished() ? false : true;
                }
                break;
            case 1:
            case 3:
                this.f4627h = false;
                this.f4629j = -1;
                break;
            case 2:
                int i = this.f4629j;
                if (i != -1) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    if (((int) Math.abs(y2 - this.f4623d)) > 0) {
                        this.f4627h = true;
                        this.f4623d = y2;
                    }
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    if (((int) Math.abs(x2 - this.f4624e)) > 0) {
                        this.f4627h = true;
                        this.f4624e = x2;
                    }
                }
                break;
            case 6:
                m3741a(motionEvent);
                break;
        }
        return this.f4627h;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f4625f = false;
        if (this.f4626g != null && m3748a(this.f4626g, this)) {
            m3742a(this.f4626g);
        }
        this.f4626g = null;
        scrollTo(getScrollX(), getScrollY());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    protected final boolean onRequestFocusInDescendants(int i, Rect rect) {
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus == null) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i, rect);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus) {
            return;
        }
        if (m3747a(viewFindFocus, 0, i4)) {
            viewFindFocus.getDrawingRect(this.f4621b);
            offsetDescendantRectToMyCoords(viewFindFocus, this.f4621b);
            m3755e(m3739a(this.f4621b));
        }
        if (m3746a(viewFindFocus, getRight() - getLeft())) {
            viewFindFocus.getDrawingRect(this.f4621b);
            offsetDescendantRectToMyCoords(viewFindFocus, this.f4621b);
            m3756f(m3749b(this.f4621b));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Rect rect = null;
        byte b2 = 0;
        byte b3 = 0;
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f4628i == null) {
            this.f4628i = VelocityTracker.obtain();
        }
        this.f4628i.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                boolean zM3745a = m3745a((int) x, (int) y);
                this.f4627h = zM3745a;
                if (!zM3745a) {
                    return false;
                }
                if (System.currentTimeMillis() - this.f4630k < 200) {
                    motionEvent.setAction(3);
                }
                this.f4630k = System.currentTimeMillis();
                if (!(b3 == true ? 1 : 0).isFinished()) {
                    (b2 == true ? 1 : 0).abortAnimation();
                }
                this.f4623d = y;
                this.f4624e = x;
                this.f4629j = motionEvent.getPointerId(0);
                return true;
            case 1:
                if (this.f4627h) {
                    if (!rect.isEmpty()) {
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -this.f4631l.getLeft(), 0.0f, -this.f4631l.getTop());
                        translateAnimation.setDuration(200L);
                        this.f4631l.startAnimation(translateAnimation);
                        new Handler().postDelayed(new RunnableC1548b(this), 200L);
                    }
                    this.f4629j = -1;
                    this.f4627h = false;
                    if (this.f4628i != null) {
                        this.f4628i.recycle();
                        this.f4628i = null;
                    }
                }
                return true;
            case 2:
                if (this.f4627h) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f4629j);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    int i = (int) (this.f4623d - y2);
                    this.f4623d = y2;
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    int i2 = (int) (this.f4624e - x2);
                    this.f4624e = x2;
                    scrollBy(i2, i);
                    int measuredWidth = this.f4631l.getMeasuredWidth() - getWidth();
                    int scrollX = getScrollX();
                    if (scrollX != 0 && scrollX != measuredWidth) {
                        int measuredHeight = this.f4631l.getMeasuredHeight() - getHeight();
                        int scrollY = getScrollY();
                        if (scrollY == 0 || scrollY == measuredHeight) {
                        }
                    }
                }
                return true;
            case 3:
                if (this.f4627h && getChildCount() > 0) {
                    this.f4629j = -1;
                    this.f4627h = false;
                    if (this.f4628i != null) {
                        this.f4628i.recycle();
                        this.f4628i = null;
                    }
                }
                return true;
            case 4:
            case 5:
            default:
                return true;
            case 6:
                m3741a(motionEvent);
                return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (!this.f4622c) {
            if (this.f4625f) {
                this.f4626g = view2;
            } else {
                m3742a(view2);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Scroller scroller = null;
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int iM3739a = m3739a(rect);
        int iM3749b = m3749b(rect);
        boolean z2 = (iM3749b == 0 && iM3739a == 0) ? false : true;
        if (z2) {
            if (z) {
                scrollBy(iM3749b, iM3739a);
            } else if (getChildCount() != 0) {
                if (AnimationUtils.currentAnimationTimeMillis() - this.f4620a > 250) {
                    int iMax = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                    int scrollY = getScrollY();
                    int iMax2 = Math.max(0, Math.min(iM3739a + scrollY, iMax)) - scrollY;
                    int iMax3 = Math.max(0, getChildAt(0).getWidth() - ((getWidth() - getPaddingRight()) - getPaddingLeft()));
                    int scrollX = getScrollX();
                    scroller.startScroll(scrollX, scrollY, Math.max(0, Math.min(iM3749b + scrollX, iMax3)) - scrollX, iMax2);
                    invalidate();
                } else {
                    if (!scroller.isFinished()) {
                        scroller.abortAnimation();
                    }
                    scrollBy(iM3749b, iM3739a);
                }
                this.f4620a = AnimationUtils.currentAnimationTimeMillis();
            }
        }
        return z2;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f4625f = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int iM3738a = m3738a(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int iM3738a2 = m3738a(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (iM3738a == getScrollX() && iM3738a2 == getScrollY()) {
                return;
            }
            super.scrollTo(iM3738a, iM3738a2);
        }
    }
}
