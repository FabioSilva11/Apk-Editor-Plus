package com.p050c.p051a;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.gmail.heagoo.apkeditor.gzd;
import java.io.InputStream;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.c.a.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0940f extends ImageView {

    /* JADX INFO: renamed from: A */
    private ColorFilter f2320A;

    /* JADX INFO: renamed from: B */
    private int f2321B;

    /* JADX INFO: renamed from: C */
    private int f2322C;

    /* JADX INFO: renamed from: D */
    private InterfaceC0943i f2323D;

    /* JADX INFO: renamed from: E */
    private ViewOnTouchListenerC0944j f2324E;

    /* JADX INFO: renamed from: F */
    private View.OnTouchListener f2325F;

    /* JADX INFO: renamed from: G */
    private View.OnClickListener f2326G;

    /* JADX INFO: renamed from: a */
    private final Semaphore f2327a;

    /* JADX INFO: renamed from: b */
    private C0936b f2328b;

    /* JADX INFO: renamed from: c */
    private Drawable f2329c;

    /* JADX INFO: renamed from: d */
    private float f2330d;

    /* JADX INFO: renamed from: e */
    private float f2331e;

    /* JADX INFO: renamed from: f */
    private boolean f2332f;

    /* JADX INFO: renamed from: g */
    private float f2333g;

    /* JADX INFO: renamed from: h */
    private float f2334h;

    /* JADX INFO: renamed from: i */
    private float f2335i;

    /* JADX INFO: renamed from: j */
    private float f2336j;

    /* JADX INFO: renamed from: k */
    private float f2337k;

    /* JADX INFO: renamed from: l */
    private float f2338l;

    /* JADX INFO: renamed from: m */
    private float f2339m;

    /* JADX INFO: renamed from: n */
    private float f2340n;

    /* JADX INFO: renamed from: o */
    private float f2341o;

    /* JADX INFO: renamed from: p */
    private float f2342p;

    /* JADX INFO: renamed from: q */
    private Float f2343q;

    /* JADX INFO: renamed from: r */
    private Float f2344r;

    /* JADX INFO: renamed from: s */
    private int f2345s;

    /* JADX INFO: renamed from: t */
    private int f2346t;

    /* JADX INFO: renamed from: u */
    private int f2347u;

    /* JADX INFO: renamed from: v */
    private boolean f2348v;

    /* JADX INFO: renamed from: w */
    private boolean f2349w;

    /* JADX INFO: renamed from: x */
    private int f2350x;

    /* JADX INFO: renamed from: y */
    private int f2351y;

    /* JADX INFO: renamed from: z */
    private int f2352z;

    public C0940f(Context context, Bitmap bitmap) {
        super(context);
        this.f2327a = new Semaphore(0);
        this.f2330d = 0.0f;
        this.f2331e = 0.0f;
        this.f2332f = false;
        this.f2333g = 1.0f;
        this.f2334h = -1.0f;
        this.f2335i = 1.0f;
        this.f2336j = 8.0f;
        this.f2337k = 0.5f;
        this.f2338l = 1.0f;
        this.f2339m = 1.0f;
        this.f2340n = 0.0f;
        this.f2347u = -1;
        this.f2348v = false;
        this.f2349w = false;
        this.f2352z = 255;
        this.f2321B = -1;
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f2329c = new BitmapDrawable(getResources(), bitmap);
        m2061k();
    }

    /* JADX INFO: renamed from: k */
    private void m2061k() {
        if (this.f2329c != null) {
            this.f2329c.setAlpha(this.f2352z);
            this.f2329c.setFilterBitmap(true);
            if (this.f2320A != null) {
                this.f2329c.setColorFilter(this.f2320A);
            }
        }
        if (this.f2332f) {
            int iM2071c = m2071c();
            int iM2072d = m2072d();
            this.f2345s = Math.round(iM2071c / 2.0f);
            this.f2346t = Math.round(iM2072d / 2.0f);
            this.f2329c.setBounds(-this.f2345s, -this.f2346t, this.f2345s, this.f2346t);
        } else {
            requestLayout();
        }
        postInvalidate();
    }

    /* JADX INFO: renamed from: a */
    public final float m2062a() {
        return this.f2338l < this.f2339m ? this.f2338l : this.f2339m;
    }

    /* JADX INFO: renamed from: a */
    public final void m2063a(float f) {
        this.f2333g = f;
    }

    /* JADX INFO: renamed from: a */
    public final void m2064a(float f, float f2) {
        this.f2330d = f;
        this.f2331e = f2;
    }

    /* JADX INFO: renamed from: a */
    public final void m2065a(InterfaceC0935a interfaceC0935a) {
        if (this.f2328b != null) {
            this.f2328b.m2051a(interfaceC0935a);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2066a(InterfaceC0943i interfaceC0943i) {
        this.f2323D = interfaceC0943i;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m2067a(long j) {
        return this.f2327a.tryAcquire(32L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: b */
    public final void m2068b() {
        if (this.f2328b != null) {
            this.f2328b.m2052b();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2069b(float f) {
        this.f2334h = 1.0f;
    }

    /* JADX INFO: renamed from: b */
    public final void m2070b(float f, float f2) {
        this.f2343q = Float.valueOf(f);
        this.f2344r = Float.valueOf(f2);
    }

    /* JADX INFO: renamed from: c */
    public final int m2071c() {
        if (this.f2329c != null) {
            return this.f2329c.getIntrinsicWidth();
        }
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public final int m2072d() {
        if (this.f2329c != null) {
            return this.f2329c.getIntrinsicHeight();
        }
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public final float m2073e() {
        return this.f2333g;
    }

    /* JADX INFO: renamed from: f */
    public final float m2074f() {
        return this.f2330d;
    }

    /* JADX INFO: renamed from: g */
    public final float m2075g() {
        return this.f2331e;
    }

    @Override // android.widget.ImageView
    public final Drawable getDrawable() {
        return this.f2329c;
    }

    @Override // android.widget.ImageView
    public final Matrix getImageMatrix() {
        return super.getImageMatrix();
    }

    /* JADX INFO: renamed from: h */
    public final InterfaceC0943i m2076h() {
        return this.f2323D;
    }

    /* JADX INFO: renamed from: i */
    public final float m2077i() {
        return this.f2341o;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    /* JADX INFO: renamed from: j */
    public final float m2078j() {
        return this.f2342p;
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onAttachedToWindow() {
        this.f2328b = new C0936b(this, "GestureImageViewAnimator");
        this.f2328b.start();
        if (this.f2347u >= 0 && this.f2329c == null) {
            setImageResource(this.f2347u);
        }
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        return super.onCreateDrawableState(i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onDetachedFromWindow() {
        if (this.f2328b != null) {
            this.f2328b.m2050a();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onDraw(Canvas canvas) {
        Bitmap bitmap;
        if (this.f2332f) {
            if (this.f2329c != null) {
                if (!((this.f2329c == null || !(this.f2329c instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) this.f2329c).getBitmap()) == null) ? false : bitmap.isRecycled())) {
                    canvas.save();
                    float f = this.f2335i * this.f2333g;
                    canvas.translate(this.f2330d, this.f2331e);
                    if (this.f2340n != 0.0f) {
                        canvas.rotate(this.f2340n);
                    }
                    if (f != 1.0f) {
                        canvas.scale(f, f);
                    }
                    this.f2329c.draw(canvas);
                    canvas.restore();
                }
            }
            if (this.f2327a.availablePermits() <= 0) {
                this.f2327a.release();
            }
        }
    }

    @Override // android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || !this.f2332f) {
            int i5 = this.f2351y;
            int i6 = this.f2350x;
            int i7 = getResources().getConfiguration().orientation;
            if (this.f2321B != i7) {
                this.f2332f = false;
                this.f2321B = i7;
            }
            if (this.f2329c == null || this.f2332f) {
                return;
            }
            int iM2071c = m2071c();
            int iM2072d = m2072d();
            this.f2345s = Math.round(iM2071c / 2.0f);
            this.f2346t = Math.round(iM2072d / 2.0f);
            int paddingLeft = i5 - (getPaddingLeft() + getPaddingRight());
            int paddingTop = i6 - (getPaddingTop() + getPaddingBottom());
            this.f2338l = paddingLeft / iM2071c;
            this.f2339m = paddingTop / iM2072d;
            if (this.f2334h <= 0.0f) {
                switch (C0942h.f2354a[getScaleType().ordinal()]) {
                    case 1:
                        this.f2334h = 1.0f;
                        break;
                    case 2:
                        this.f2334h = Math.max(paddingTop / iM2072d, paddingLeft / iM2071c);
                        break;
                    case 3:
                        if (iM2071c / paddingLeft <= iM2072d / paddingTop) {
                            this.f2334h = this.f2339m;
                        } else {
                            this.f2334h = this.f2338l;
                        }
                        break;
                }
            }
            this.f2333g = this.f2334h;
            this.f2341o = paddingLeft / 2.0f;
            this.f2342p = paddingTop / 2.0f;
            if (this.f2343q == null) {
                this.f2330d = this.f2341o;
            } else {
                this.f2330d = this.f2343q.floatValue();
            }
            if (this.f2344r == null) {
                this.f2331e = this.f2342p;
            } else {
                this.f2331e = this.f2344r.floatValue();
            }
            this.f2324E = new ViewOnTouchListenerC0944j(this, paddingLeft, paddingTop);
            this.f2324E.m2090b(this.f2337k);
            this.f2324E.m2087a(this.f2336j);
            this.f2329c.setBounds(-this.f2345s, -this.f2346t, this.f2345s, this.f2346t);
            super.setOnTouchListener(new ViewOnTouchListenerC0941g(this));
            this.f2332f = true;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onMeasure(int i, int i2) {
        if (this.f2329c == null) {
            this.f2350x = View.MeasureSpec.getSize(i2);
            this.f2351y = View.MeasureSpec.getSize(i);
        } else if (getResources().getConfiguration().orientation == 2) {
            this.f2350x = View.MeasureSpec.getSize(i2);
            if (getLayoutParams().width == -2) {
                this.f2351y = Math.round((m2071c() / m2072d()) * this.f2350x);
            } else {
                this.f2351y = View.MeasureSpec.getSize(i);
            }
        } else {
            this.f2351y = View.MeasureSpec.getSize(i);
            if (getLayoutParams().height == -2) {
                this.f2350x = Math.round((m2072d() / m2071c()) * this.f2351y);
            } else {
                this.f2350x = View.MeasureSpec.getSize(i2);
            }
        }
        setMeasuredDimension(this.f2351y, this.f2350x);
    }

    @Override // android.widget.ImageView
    public final void setAdjustViewBounds(boolean z) {
        super.setAdjustViewBounds(z);
    }

    @Override // android.widget.ImageView
    public final void setAlpha(int i) {
        this.f2352z = i;
        if (this.f2329c != null) {
            this.f2329c.setAlpha(i);
        }
    }

    @Override // android.widget.ImageView
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f2320A = colorFilter;
        if (this.f2329c != null) {
            this.f2329c.setColorFilter(colorFilter);
        }
    }

    @Override // android.widget.ImageView
    public final void setImageBitmap(Bitmap bitmap) {
        this.f2329c = new BitmapDrawable(getResources(), bitmap);
        m2061k();
    }

    @Override // android.widget.ImageView
    public final void setImageDrawable(Drawable drawable) {
        this.f2329c = drawable;
        m2061k();
    }

    @Override // android.widget.ImageView
    public final void setImageLevel(int i) {
        super.setImageLevel(i);
    }

    @Override // android.widget.ImageView
    public final void setImageMatrix(Matrix matrix) {
    }

    @Override // android.widget.ImageView
    public final void setImageResource(int i) {
        if (this.f2329c != null) {
        }
        this.f2347u = i;
        setImageDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.widget.ImageView
    public final void setImageState(int[] iArr, boolean z) {
    }

    @Override // android.widget.ImageView
    public final void setImageURI(Uri uri) throws Throwable {
        InputStream inputStream;
        if (gzd.COLUMN_CONTENT.equals(uri.getScheme())) {
            try {
                String[] strArr = {"orientation"};
                Cursor cursorQuery = getContext().getContentResolver().query(uri, strArr, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    this.f2322C = cursorQuery.getInt(cursorQuery.getColumnIndex(strArr[0]));
                }
                try {
                    InputStream inputStreamOpenInputStream = getContext().getContentResolver().openInputStream(uri);
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                        if (this.f2322C != 0) {
                            Matrix matrix = new Matrix();
                            matrix.postRotate(this.f2322C);
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix, true);
                            bitmapDecodeStream.recycle();
                            setImageDrawable(new BitmapDrawable(getResources(), bitmapCreateBitmap));
                        } else {
                            setImageDrawable(new BitmapDrawable(getResources(), bitmapDecodeStream));
                        }
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStreamOpenInputStream;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                }
            } catch (Exception e) {
                Log.w("GestureImageView", "Unable to open content: " + uri, e);
            }
        } else {
            setImageDrawable(Drawable.createFromPath(uri.toString()));
        }
        if (this.f2329c == null) {
            Log.e("GestureImageView", "resolveUri failed on bad bitmap uri: " + uri);
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f2326G = onClickListener;
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f2325F = onTouchListener;
    }

    @Override // android.view.View
    public final void setRotation(float f) {
        this.f2340n = f;
    }

    @Override // android.widget.ImageView
    public final void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.CENTER_CROP || scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            super.setScaleType(scaleType);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void setSelected(boolean z) {
        super.setSelected(z);
    }
}
