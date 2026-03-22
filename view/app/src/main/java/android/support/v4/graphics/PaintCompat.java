package android.support.v4.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public final class PaintCompat {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "\udfffd";
    private static final ThreadLocal sRectThreadLocal = new ThreadLocal();

    private PaintCompat() {
    }

    public static boolean hasGlyph(@NonNull Paint paint, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return paint.hasGlyph(str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float fMeasureText = paint.measureText(TOFU_STRING);
        float fMeasureText2 = paint.measureText(EM_STRING);
        float fMeasureText3 = paint.measureText(str);
        if (fMeasureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (fMeasureText3 > fMeasureText2 * 2.0f) {
                return false;
            }
            float fMeasureText4 = 0.0f;
            int i = 0;
            while (i < length) {
                int iCharCount = Character.charCount(str.codePointAt(i));
                fMeasureText4 += paint.measureText(str, i, i + iCharCount);
                i += iCharCount;
            }
            if (fMeasureText3 >= fMeasureText4) {
                return false;
            }
        }
        if (fMeasureText3 != fMeasureText) {
            return true;
        }
        Pair pairObtainEmptyRects = obtainEmptyRects();
        paint.getTextBounds(TOFU_STRING, 0, 2, (Rect) pairObtainEmptyRects.first);
        paint.getTextBounds(str, 0, length, (Rect) pairObtainEmptyRects.second);
        return !((Rect) pairObtainEmptyRects.first).equals(pairObtainEmptyRects.second);
    }

    private static Pair obtainEmptyRects() {
        Pair pair = (Pair) sRectThreadLocal.get();
        if (pair == null) {
            Pair pair2 = new Pair(new Rect(), new Rect());
            sRectThreadLocal.set(pair2);
            return pair2;
        }
        ((Rect) pair.first).setEmpty();
        ((Rect) pair.second).setEmpty();
        return pair;
    }
}
