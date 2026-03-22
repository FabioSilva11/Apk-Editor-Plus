package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.WrappedDrawable;
import android.support.v7.graphics.drawable.DrawableWrapper;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DrawableUtils {
    public static final Rect INSETS_NONE = new Rect();
    private static final String TAG = "DrawableUtils";
    private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static Class sInsetsClazz;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                sInsetsClazz = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    private DrawableUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canSafelyMutateDrawable(@NonNull Drawable drawable) {
        Drawable wrappedDrawable = drawable;
        while (true) {
            if (Build.VERSION.SDK_INT < 15 && (wrappedDrawable instanceof InsetDrawable)) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 15 && (wrappedDrawable instanceof GradientDrawable)) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 17 && (wrappedDrawable instanceof LayerDrawable)) {
                return false;
            }
            if (wrappedDrawable instanceof DrawableContainer) {
                Drawable.ConstantState constantState = wrappedDrawable.getConstantState();
                if (constantState instanceof DrawableContainer.DrawableContainerState) {
                    Drawable[] children = ((DrawableContainer.DrawableContainerState) constantState).getChildren();
                    for (Drawable drawable2 : children) {
                        if (!canSafelyMutateDrawable(drawable2)) {
                            return false;
                        }
                    }
                }
            } else if (wrappedDrawable instanceof WrappedDrawable) {
                wrappedDrawable = ((WrappedDrawable) wrappedDrawable).getWrappedDrawable();
            } else if (!(wrappedDrawable instanceof DrawableWrapper)) {
                if (!(wrappedDrawable instanceof ScaleDrawable)) {
                    break;
                }
                wrappedDrawable = ((ScaleDrawable) wrappedDrawable).getDrawable();
            } else {
                wrappedDrawable = ((DrawableWrapper) wrappedDrawable).getWrappedDrawable();
            }
        }
        return true;
    }

    static void fixDrawable(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && VECTOR_DRAWABLE_CLAZZ_NAME.equals(drawable.getClass().getName())) {
            fixVectorDrawableTinting(drawable);
        }
    }

    private static void fixVectorDrawableTinting(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(ThemeUtils.CHECKED_STATE_SET);
        } else {
            drawable.setState(ThemeUtils.EMPTY_STATE_SET);
        }
        drawable.setState(state);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b A[Catch: Exception -> 0x0072, TRY_LEAVE, TryCatch #0 {Exception -> 0x0072, blocks: (B:4:0x0005, B:6:0x001f, B:8:0x002e, B:9:0x0039, B:10:0x003c, B:11:0x003f, B:24:0x006b, B:30:0x007d, B:31:0x0084, B:32:0x008b, B:12:0x0043, B:15:0x004d, B:18:0x0057, B:21:0x0061), top: B:34:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d A[Catch: Exception -> 0x0072, TRY_ENTER, TryCatch #0 {Exception -> 0x0072, blocks: (B:4:0x0005, B:6:0x001f, B:8:0x002e, B:9:0x0039, B:10:0x003c, B:11:0x003f, B:24:0x006b, B:30:0x007d, B:31:0x0084, B:32:0x008b, B:12:0x0043, B:15:0x004d, B:18:0x0057, B:21:0x0061), top: B:34:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0084 A[Catch: Exception -> 0x0072, TryCatch #0 {Exception -> 0x0072, blocks: (B:4:0x0005, B:6:0x001f, B:8:0x002e, B:9:0x0039, B:10:0x003c, B:11:0x003f, B:24:0x006b, B:30:0x007d, B:31:0x0084, B:32:0x008b, B:12:0x0043, B:15:0x004d, B:18:0x0057, B:21:0x0061), top: B:34:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b A[Catch: Exception -> 0x0072, TRY_LEAVE, TryCatch #0 {Exception -> 0x0072, blocks: (B:4:0x0005, B:6:0x001f, B:8:0x002e, B:9:0x0039, B:10:0x003c, B:11:0x003f, B:24:0x006b, B:30:0x007d, B:31:0x0084, B:32:0x008b, B:12:0x0043, B:15:0x004d, B:18:0x0057, B:21:0x0061), top: B:34:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003f A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Rect getOpticalBounds(android.graphics.drawable.Drawable r10) {
        /*
            r2 = 0
            java.lang.Class r0 = android.support.v7.widget.DrawableUtils.sInsetsClazz
            if (r0 == 0) goto L7a
            android.graphics.drawable.Drawable r0 = android.support.v4.graphics.drawable.DrawableCompat.unwrap(r10)     // Catch: java.lang.Exception -> L72
            java.lang.Class r1 = r0.getClass()     // Catch: java.lang.Exception -> L72
            java.lang.String r3 = "getOpticalInsets"
            r4 = 0
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L72
            java.lang.reflect.Method r1 = r1.getMethod(r3, r4)     // Catch: java.lang.Exception -> L72
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L72
            java.lang.Object r4 = r1.invoke(r0, r3)     // Catch: java.lang.Exception -> L72
            if (r4 == 0) goto L7a
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch: java.lang.Exception -> L72
            r0.<init>()     // Catch: java.lang.Exception -> L72
            java.lang.Class r1 = android.support.v7.widget.DrawableUtils.sInsetsClazz     // Catch: java.lang.Exception -> L72
            java.lang.reflect.Field[] r5 = r1.getFields()     // Catch: java.lang.Exception -> L72
            int r6 = r5.length     // Catch: java.lang.Exception -> L72
            r3 = r2
        L2c:
            if (r3 >= r6) goto L7c
            r7 = r5[r3]     // Catch: java.lang.Exception -> L72
            java.lang.String r8 = r7.getName()     // Catch: java.lang.Exception -> L72
            r1 = -1
            int r9 = r8.hashCode()     // Catch: java.lang.Exception -> L72
            switch(r9) {
                case -1383228885: goto L61;
                case 115029: goto L4d;
                case 3317767: goto L43;
                case 108511772: goto L57;
                default: goto L3c;
            }     // Catch: java.lang.Exception -> L72
        L3c:
            switch(r1) {
                case 0: goto L6b;
                case 1: goto L7d;
                case 2: goto L84;
                case 3: goto L8b;
                default: goto L3f;
            }     // Catch: java.lang.Exception -> L72
        L3f:
            int r1 = r3 + 1
            r3 = r1
            goto L2c
        L43:
            java.lang.String r9 = "left"
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Exception -> L72
            if (r8 == 0) goto L3c
            r1 = r2
            goto L3c
        L4d:
            java.lang.String r9 = "top"
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Exception -> L72
            if (r8 == 0) goto L3c
            r1 = 1
            goto L3c
        L57:
            java.lang.String r9 = "right"
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Exception -> L72
            if (r8 == 0) goto L3c
            r1 = 2
            goto L3c
        L61:
            java.lang.String r9 = "bottom"
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Exception -> L72
            if (r8 == 0) goto L3c
            r1 = 3
            goto L3c
        L6b:
            int r1 = r7.getInt(r4)     // Catch: java.lang.Exception -> L72
            r0.left = r1     // Catch: java.lang.Exception -> L72
            goto L3f
        L72:
            r0 = move-exception
            java.lang.String r0 = "DrawableUtils"
            java.lang.String r1 = "Couldn't obtain the optical insets. Ignoring."
            android.util.Log.e(r0, r1)
        L7a:
            android.graphics.Rect r0 = android.support.v7.widget.DrawableUtils.INSETS_NONE
        L7c:
            return r0
        L7d:
            int r1 = r7.getInt(r4)     // Catch: java.lang.Exception -> L72
            r0.top = r1     // Catch: java.lang.Exception -> L72
            goto L3f
        L84:
            int r1 = r7.getInt(r4)     // Catch: java.lang.Exception -> L72
            r0.right = r1     // Catch: java.lang.Exception -> L72
            goto L3f
        L8b:
            int r1 = r7.getInt(r4)     // Catch: java.lang.Exception -> L72
            r0.bottom = r1     // Catch: java.lang.Exception -> L72
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.DrawableUtils.getOpticalBounds(android.graphics.drawable.Drawable):android.graphics.Rect");
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return mode;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
        }
    }
}
