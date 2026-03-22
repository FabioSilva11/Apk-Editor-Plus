package org.p088jf.util;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class NumberUtils {
    public static final int canonicalFloatNaN = Float.floatToRawIntBits(Float.NaN);
    public static final int maxFloat = Float.floatToRawIntBits(Float.MAX_VALUE);
    public static final int piFloat = Float.floatToRawIntBits(3.1415927f);
    public static final int eFloat = Float.floatToRawIntBits(2.7182817f);
    public static final long canonicalDoubleNaN = Double.doubleToRawLongBits(Double.NaN);
    public static final long maxDouble = Double.doubleToLongBits(Double.MAX_VALUE);
    public static final long piDouble = Double.doubleToLongBits(3.141592653589793d);
    public static final long eDouble = Double.doubleToLongBits(2.718281828459045d);
    public static final DecimalFormat format = new DecimalFormat("0.####################E0");

    public static boolean isLikelyDouble(long j) {
        if (j == canonicalDoubleNaN || j == maxDouble || j == piDouble || j == eDouble) {
            return true;
        }
        if (j == Long.MAX_VALUE || j == Long.MIN_VALUE) {
            return false;
        }
        double dLongBitsToDouble = Double.longBitsToDouble(j);
        if (Double.isNaN(dLongBitsToDouble)) {
            return false;
        }
        DecimalFormat decimalFormat = format;
        String str = decimalFormat.format(j);
        String str2 = decimalFormat.format(dLongBitsToDouble);
        int iIndexOf = str2.indexOf(46);
        int iIndexOf2 = str2.indexOf("E");
        int iIndexOf3 = str2.indexOf("000");
        if (iIndexOf3 <= iIndexOf || iIndexOf3 >= iIndexOf2) {
            int iIndexOf4 = str2.indexOf("999");
            if (iIndexOf4 > iIndexOf && iIndexOf4 < iIndexOf2) {
                str2 = str2.substring(0, iIndexOf4) + str2.substring(iIndexOf2);
            }
        } else {
            str2 = str2.substring(0, iIndexOf3) + str2.substring(iIndexOf2);
        }
        return str2.length() < str.length();
    }

    public static boolean isLikelyFloat(int i) {
        if (i == canonicalFloatNaN || i == maxFloat || i == piFloat || i == eFloat) {
            return true;
        }
        if (i == Integer.MAX_VALUE || i == Integer.MIN_VALUE) {
            return false;
        }
        int i2 = i >> 24;
        int i3 = (i >> 16) & 255;
        int i4 = 65535 & i;
        if ((i2 == 127 || i2 == 1) && i3 < 31 && i4 < 4095) {
            return false;
        }
        float fIntBitsToFloat = Float.intBitsToFloat(i);
        if (Float.isNaN(fIntBitsToFloat)) {
            return false;
        }
        DecimalFormat decimalFormat = format;
        String str = decimalFormat.format(i);
        String str2 = decimalFormat.format(fIntBitsToFloat);
        int iIndexOf = str2.indexOf(46);
        int iIndexOf2 = str2.indexOf("E");
        int iIndexOf3 = str2.indexOf("000");
        if (iIndexOf3 <= iIndexOf || iIndexOf3 >= iIndexOf2) {
            int iIndexOf4 = str2.indexOf("999");
            if (iIndexOf4 > iIndexOf && iIndexOf4 < iIndexOf2) {
                str2 = str2.substring(0, iIndexOf4) + str2.substring(iIndexOf2);
            }
        } else {
            str2 = str2.substring(0, iIndexOf3) + str2.substring(iIndexOf2);
        }
        return str2.length() < str.length();
    }
}
