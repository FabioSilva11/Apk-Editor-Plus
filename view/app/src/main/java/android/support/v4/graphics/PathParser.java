package android.support.v4.graphics;

import android.graphics.Path;
import android.support.annotation.RestrictTo;
import android.support.v7.appcompat.C0299R;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PathParser {
    private static final String LOGTAG = "PathParser";

    class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    public class PathDataNode {

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public float[] mParams;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public char mType;

        PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            this.mParams = PathParser.copyOfRange(pathDataNode.mParams, 0, pathDataNode.mParams.length);
        }

        private static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[2];
            float f16 = fArr[3];
            float f17 = fArr[4];
            float f18 = fArr[5];
            switch (c2) {
                case C0299R.styleable.AppCompatTheme_editTextBackground /* 65 */:
                case C0299R.styleable.AppCompatTheme_alertDialogCenterButtons /* 97 */:
                    i = 7;
                    break;
                case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /* 67 */:
                case C0299R.styleable.AppCompatTheme_textColorAlertDialogListItem /* 99 */:
                    i = 6;
                    break;
                case C0299R.styleable.AppCompatTheme_listPreferredItemHeightSmall /* 72 */:
                case C0299R.styleable.AppCompatTheme_colorPrimaryDark /* 86 */:
                case C0299R.styleable.AppCompatTheme_buttonStyle /* 104 */:
                case C0299R.styleable.AppCompatTheme_tooltipForegroundColor /* 118 */:
                    i = 1;
                    break;
                case C0299R.styleable.AppCompatTheme_dropDownListViewStyle /* 76 */:
                case C0299R.styleable.AppCompatTheme_listPopupWindowStyle /* 77 */:
                case C0299R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /* 84 */:
                case 'l':
                case 'm':
                case C0299R.styleable.AppCompatTheme_listMenuViewStyle /* 116 */:
                    i = 2;
                    break;
                case 'Q':
                case C0299R.styleable.AppCompatTheme_panelMenuListTheme /* 83 */:
                case C0299R.styleable.AppCompatTheme_seekBarStyle /* 113 */:
                case C0299R.styleable.AppCompatTheme_switchStyle /* 115 */:
                    i = 4;
                    break;
                case C0299R.styleable.AppCompatTheme_colorControlHighlight /* 90 */:
                case 'z':
                    path.close();
                    path.moveTo(f17, f18);
                    f16 = f18;
                    f15 = f17;
                    f14 = f18;
                    f13 = f17;
                    i = 2;
                    break;
                default:
                    i = 2;
                    break;
            }
            int i2 = 0;
            float f19 = f18;
            float f20 = f17;
            float f21 = f14;
            float f22 = f13;
            while (i2 < fArr2.length) {
                switch (c2) {
                    case C0299R.styleable.AppCompatTheme_editTextBackground /* 65 */:
                        drawArc(path, f22, f21, fArr2[i2 + 5], fArr2[i2 + 6], fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        float f23 = fArr2[i2 + 5];
                        float f24 = fArr2[i2 + 6];
                        f = f19;
                        f2 = f20;
                        f3 = f23;
                        f4 = f24;
                        f5 = f23;
                        f6 = f24;
                        break;
                    case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /* 67 */:
                        path.cubicTo(fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        float f25 = fArr2[i2 + 4];
                        float f26 = fArr2[i2 + 5];
                        f3 = fArr2[i2 + 2];
                        f4 = f26;
                        f5 = f25;
                        f = f19;
                        f2 = f20;
                        f6 = fArr2[i2 + 3];
                        break;
                    case C0299R.styleable.AppCompatTheme_listPreferredItemHeightSmall /* 72 */:
                        path.lineTo(fArr2[i2], f21);
                        f = f19;
                        f3 = f15;
                        f4 = f21;
                        f5 = fArr2[i2];
                        f6 = f16;
                        f2 = f20;
                        break;
                    case C0299R.styleable.AppCompatTheme_dropDownListViewStyle /* 76 */:
                        path.lineTo(fArr2[i2], fArr2[i2 + 1]);
                        float f27 = fArr2[i2];
                        f3 = f15;
                        f4 = fArr2[i2 + 1];
                        f5 = f27;
                        f = f19;
                        f2 = f20;
                        f6 = f16;
                        break;
                    case C0299R.styleable.AppCompatTheme_listPopupWindowStyle /* 77 */:
                        f2 = fArr2[i2];
                        f = fArr2[i2 + 1];
                        if (i2 <= 0) {
                            path.moveTo(fArr2[i2], fArr2[i2 + 1]);
                            f3 = f15;
                            f4 = f;
                            f5 = f2;
                            f6 = f16;
                        } else {
                            path.lineTo(fArr2[i2], fArr2[i2 + 1]);
                            f3 = f15;
                            f4 = f;
                            f5 = f2;
                            f = f19;
                            f2 = f20;
                            f6 = f16;
                        }
                        break;
                    case 'Q':
                        path.quadTo(fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        float f28 = fArr2[i2];
                        float f29 = fArr2[i2 + 1];
                        float f30 = fArr2[i2 + 2];
                        f3 = f28;
                        f4 = fArr2[i2 + 3];
                        f5 = f30;
                        f = f19;
                        f2 = f20;
                        f6 = f29;
                        break;
                    case C0299R.styleable.AppCompatTheme_panelMenuListTheme /* 83 */:
                        if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                            f9 = (2.0f * f22) - f15;
                            f10 = (2.0f * f21) - f16;
                        } else {
                            f10 = f21;
                            f9 = f22;
                        }
                        path.cubicTo(f9, f10, fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        float f31 = fArr2[i2];
                        float f32 = fArr2[i2 + 1];
                        float f33 = fArr2[i2 + 2];
                        f3 = f31;
                        f4 = fArr2[i2 + 3];
                        f5 = f33;
                        f = f19;
                        f2 = f20;
                        f6 = f32;
                        break;
                    case C0299R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /* 84 */:
                        if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                            f22 = (2.0f * f22) - f15;
                            f21 = (2.0f * f21) - f16;
                        }
                        path.quadTo(f22, f21, fArr2[i2], fArr2[i2 + 1]);
                        float f34 = fArr2[i2];
                        f6 = f21;
                        f3 = f22;
                        f4 = fArr2[i2 + 1];
                        f5 = f34;
                        f = f19;
                        f2 = f20;
                        break;
                    case C0299R.styleable.AppCompatTheme_colorPrimaryDark /* 86 */:
                        path.lineTo(f22, fArr2[i2]);
                        f2 = f20;
                        f3 = f15;
                        f4 = fArr2[i2];
                        f5 = f22;
                        f6 = f16;
                        f = f19;
                        break;
                    case C0299R.styleable.AppCompatTheme_alertDialogCenterButtons /* 97 */:
                        drawArc(path, f22, f21, fArr2[i2 + 5] + f22, fArr2[i2 + 6] + f21, fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        float f35 = f22 + fArr2[i2 + 5];
                        float f36 = fArr2[i2 + 6] + f21;
                        f = f19;
                        f2 = f20;
                        f3 = f35;
                        f4 = f36;
                        f5 = f35;
                        f6 = f36;
                        break;
                    case C0299R.styleable.AppCompatTheme_textColorAlertDialogListItem /* 99 */:
                        path.rCubicTo(fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        float f37 = f22 + fArr2[i2 + 2];
                        float f38 = fArr2[i2 + 3] + f21;
                        float f39 = f22 + fArr2[i2 + 4];
                        f3 = f37;
                        f4 = fArr2[i2 + 5] + f21;
                        f5 = f39;
                        f = f19;
                        f2 = f20;
                        f6 = f38;
                        break;
                    case C0299R.styleable.AppCompatTheme_buttonStyle /* 104 */:
                        path.rLineTo(fArr2[i2], 0.0f);
                        f = f19;
                        f3 = f15;
                        f4 = f21;
                        f5 = f22 + fArr2[i2];
                        f6 = f16;
                        f2 = f20;
                        break;
                    case 'l':
                        path.rLineTo(fArr2[i2], fArr2[i2 + 1]);
                        float f40 = f22 + fArr2[i2];
                        f3 = f15;
                        f4 = fArr2[i2 + 1] + f21;
                        f5 = f40;
                        f = f19;
                        f2 = f20;
                        f6 = f16;
                        break;
                    case 'm':
                        f2 = f22 + fArr2[i2];
                        f = fArr2[i2 + 1] + f21;
                        if (i2 <= 0) {
                            path.rMoveTo(fArr2[i2], fArr2[i2 + 1]);
                            f3 = f15;
                            f4 = f;
                            f5 = f2;
                            f6 = f16;
                        } else {
                            path.rLineTo(fArr2[i2], fArr2[i2 + 1]);
                            f3 = f15;
                            f4 = f;
                            f5 = f2;
                            f = f19;
                            f2 = f20;
                            f6 = f16;
                        }
                        break;
                    case C0299R.styleable.AppCompatTheme_seekBarStyle /* 113 */:
                        path.rQuadTo(fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        float f41 = f22 + fArr2[i2];
                        float f42 = fArr2[i2 + 1] + f21;
                        float f43 = f22 + fArr2[i2 + 2];
                        f3 = f41;
                        f4 = fArr2[i2 + 3] + f21;
                        f5 = f43;
                        f = f19;
                        f2 = f20;
                        f6 = f42;
                        break;
                    case C0299R.styleable.AppCompatTheme_switchStyle /* 115 */:
                        if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                            f11 = f22 - f15;
                            f12 = f21 - f16;
                        } else {
                            f12 = 0.0f;
                            f11 = 0.0f;
                        }
                        path.rCubicTo(f11, f12, fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        float f44 = f22 + fArr2[i2];
                        float f45 = fArr2[i2 + 1] + f21;
                        float f46 = f22 + fArr2[i2 + 2];
                        f3 = f44;
                        f4 = fArr2[i2 + 3] + f21;
                        f5 = f46;
                        f = f19;
                        f2 = f20;
                        f6 = f45;
                        break;
                    case C0299R.styleable.AppCompatTheme_listMenuViewStyle /* 116 */:
                        if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                            f7 = f22 - f15;
                            f8 = f21 - f16;
                        } else {
                            f8 = 0.0f;
                            f7 = 0.0f;
                        }
                        path.rQuadTo(f7, f8, fArr2[i2], fArr2[i2 + 1]);
                        float f47 = f22 + fArr2[i2];
                        f3 = f22 + f7;
                        f4 = fArr2[i2 + 1] + f21;
                        f5 = f47;
                        f = f19;
                        f2 = f20;
                        f6 = f8 + f21;
                        break;
                    case C0299R.styleable.AppCompatTheme_tooltipForegroundColor /* 118 */:
                        path.rLineTo(0.0f, fArr2[i2]);
                        f2 = f20;
                        f3 = f15;
                        f4 = fArr2[i2] + f21;
                        f5 = f22;
                        f6 = f16;
                        f = f19;
                        break;
                    default:
                        f = f19;
                        f2 = f20;
                        f3 = f15;
                        f4 = f21;
                        f5 = f22;
                        f6 = f16;
                        break;
                }
                i2 += i;
                f19 = f;
                f20 = f2;
                f21 = f4;
                f22 = f5;
                c = c2;
                f16 = f6;
                f15 = f3;
            }
            fArr[0] = f22;
            fArr[1] = f21;
            fArr[2] = f15;
            fArr[3] = f16;
            fArr[4] = f20;
            fArr[5] = f19;
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            int iCeil = (int) Math.ceil(Math.abs((4.0d * d9) / 3.141592653589793d));
            double dCos = Math.cos(d7);
            double dSin = Math.sin(d7);
            double dCos2 = Math.cos(d8);
            double dSin2 = Math.sin(d8);
            double d10 = (((-d3) * dCos) * dSin2) - ((d4 * dSin) * dCos2);
            double d11 = (dCos2 * d4 * dCos) + (dSin2 * (-d3) * dSin);
            double d12 = d9 / ((double) iCeil);
            int i = 0;
            while (i < iCeil) {
                double d13 = d8 + d12;
                double dSin3 = Math.sin(d13);
                double dCos3 = Math.cos(d13);
                double d14 = (((d3 * dCos) * dCos3) + d) - ((d4 * dSin) * dSin3);
                double d15 = (d4 * dCos * dSin3) + (d3 * dSin * dCos3) + d2;
                double d16 = (((-d3) * dCos) * dSin3) - ((d4 * dSin) * dCos3);
                double d17 = (dCos3 * d4 * dCos) + (dSin3 * (-d3) * dSin);
                double dTan = Math.tan((d13 - d8) / 2.0d);
                double dSqrt = ((Math.sqrt((dTan * (3.0d * dTan)) + 4.0d) - 1.0d) * Math.sin(d13 - d8)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d10 * dSqrt) + d5), (float) (d6 + (d11 * dSqrt)), (float) (d14 - (dSqrt * d16)), (float) (d15 - (dSqrt * d17)), (float) d14, (float) d15);
                d10 = d16;
                d8 = d13;
                i++;
                d6 = d15;
                d5 = d14;
                d11 = d17;
            }
        }

        private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            while (true) {
                double radians = Math.toRadians(f7);
                double dCos = Math.cos(radians);
                double dSin = Math.sin(radians);
                double d3 = ((((double) f) * dCos) + (((double) f2) * dSin)) / ((double) f5);
                double d4 = ((((double) (-f)) * dSin) + (((double) f2) * dCos)) / ((double) f6);
                double d5 = ((((double) f3) * dCos) + (((double) f4) * dSin)) / ((double) f5);
                double d6 = ((((double) (-f3)) * dSin) + (((double) f4) * dCos)) / ((double) f6);
                double d7 = d3 - d5;
                double d8 = d4 - d6;
                double d9 = (d3 + d5) / 2.0d;
                double d10 = (d4 + d6) / 2.0d;
                double d11 = (d7 * d7) + (d8 * d8);
                if (d11 == 0.0d) {
                    Log.w(PathParser.LOGTAG, " Points are coincident");
                    return;
                }
                double d12 = (1.0d / d11) - 0.25d;
                if (d12 >= 0.0d) {
                    double dSqrt = Math.sqrt(d12);
                    double d13 = d7 * dSqrt;
                    double d14 = d8 * dSqrt;
                    if (z == z2) {
                        d = d9 - d14;
                        d2 = d13 + d10;
                    } else {
                        d = d14 + d9;
                        d2 = d10 - d13;
                    }
                    double dAtan2 = Math.atan2(d4 - d2, d3 - d);
                    double dAtan22 = Math.atan2(d6 - d2, d5 - d) - dAtan2;
                    if (z2 != (dAtan22 >= 0.0d)) {
                        dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
                    }
                    double d15 = d * ((double) f5);
                    double d16 = ((double) f6) * d2;
                    arcToBezier(path, (d15 * dCos) - (d16 * dSin), (d15 * dSin) + (dCos * d16), f5, f6, f, f2, radians, dAtan2, dAtan22);
                    return;
                }
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d11);
                float fSqrt = (float) (Math.sqrt(d11) / 1.99999d);
                f5 *= fSqrt;
                f6 *= fSqrt;
            }
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                addCommand(path, fArr, c, pathDataNodeArr[i].mType, pathDataNodeArr[i].mParams);
                c = pathDataNodeArr[i].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            for (int i = 0; i < pathDataNode.mParams.length; i++) {
                this.mParams[i] = (pathDataNode.mParams[i] * (1.0f - f)) + (pathDataNode2.mParams[i] * f);
            }
        }
    }

    private PathParser() {
    }

    private static void addNode(ArrayList arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int iMin = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, iMin);
        return fArr2;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int iNextStart = nextStart(str, i);
            String strTrim = str.substring(i2, iNextStart).trim();
            if (strTrim.length() > 0) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i = iNextStart + 1;
            i2 = iNextStart;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            addNode(arrayList, str.charAt(i2), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] pathDataNodeArrCreateNodesFromPathData = createNodesFromPathData(str);
        if (pathDataNodeArrCreateNodesFromPathData == null) {
            return null;
        }
        try {
            PathDataNode.nodesToPath(pathDataNodeArrCreateNodesFromPathData, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    private static void extract(String str, int i, ExtractFloatResult extractFloatResult) {
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            switch (str.charAt(i2)) {
                case ' ':
                case ',':
                    z = false;
                    z3 = true;
                    break;
                case '-':
                    if (i2 == i || z) {
                        z = false;
                    } else {
                        extractFloatResult.mEndWithNegOrDot = true;
                        z = false;
                        z3 = true;
                    }
                    break;
                case '.':
                    if (z2) {
                        extractFloatResult.mEndWithNegOrDot = true;
                        z = false;
                        z3 = true;
                    } else {
                        z = false;
                        z2 = true;
                    }
                    break;
                case C0299R.styleable.AppCompatTheme_textColorSearchUrl /* 69 */:
                case C0299R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle /* 101 */:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z3) {
                extractFloatResult.mEndPosition = i2;
            }
        }
        extractFloatResult.mEndPosition = i2;
    }

    private static float[] getFloats(String str) {
        int i;
        int i2 = 0;
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i3 = 1;
            while (i3 < length) {
                extract(str, i3, extractFloatResult);
                int i4 = extractFloatResult.mEndPosition;
                if (i3 < i4) {
                    i = i2 + 1;
                    fArr[i2] = Float.parseFloat(str.substring(i3, i4));
                } else {
                    i = i2;
                }
                if (extractFloatResult.mEndWithNegOrDot) {
                    i3 = i4;
                    i2 = i;
                } else {
                    i3 = i4 + 1;
                    i2 = i;
                }
            }
            return copyOfRange(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }
}
