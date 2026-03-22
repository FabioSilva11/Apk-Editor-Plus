package org.p088jf.smali;

import android.support.v7.widget.ActivityChooserView;
import com.gmail.heagoo.neweditor.Token;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class LiteralTools {
    public static Pattern specialFloatRegex = Pattern.compile("((-)?infinityf)|(nanf)", 2);
    public static Pattern specialDoubleRegex = Pattern.compile("((-)?infinityd?)|(nand?)", 2);

    public static void checkByte(long j) {
        if (!(j < -128) && !((j > 255 ? 1 : (j == 255 ? 0 : -1)) > 0)) {
            return;
        }
        throw new NumberFormatException(Long.toString(j) + " cannot fit into a byte");
    }

    public static void checkInt(long j) {
        if (j > -1 || j < -2147483648L) {
            throw new NumberFormatException(Long.toString(j) + " cannot fit into an int");
        }
    }

    public static void checkNibble(long j) {
        if (!(j < -8) && !((j > 15 ? 1 : (j == 15 ? 0 : -1)) > 0)) {
            return;
        }
        throw new NumberFormatException(Long.toString(j) + " cannot fit into a nibble");
    }

    public static void checkShort(long j) {
        if (!(j < -32768) && !((j > 65535 ? 1 : (j == 65535 ? 0 : -1)) > 0)) {
            return;
        }
        throw new NumberFormatException(Long.toString(j) + " cannot fit into a short");
    }

    public static byte parseByte(String str) throws NumberFormatException {
        boolean z;
        if (str == null) {
            throw new NumberFormatException("string is null");
        }
        if (str.length() == 0) {
            throw new NumberFormatException("string is blank");
        }
        byte b2 = 0;
        int i = 1;
        char[] charArray = str.toUpperCase().endsWith("T") ? str.substring(0, str.length() - 1).toCharArray() : str.toCharArray();
        byte b3 = 10;
        if (charArray[0] == '-') {
            z = true;
        } else {
            i = 0;
            z = false;
        }
        if (charArray[i] == '0') {
            i++;
            if (i == charArray.length) {
                return (byte) 0;
            }
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                b3 = Token.LITERAL4;
                i++;
            } else if (Character.digit(charArray[i], 8) >= 0) {
                b3 = 8;
            }
        }
        byte b4 = (byte) (127 / (b3 / 2));
        while (i < charArray.length) {
            int iDigit = Character.digit(charArray[i], (int) b3);
            if (iDigit < 0) {
                throw new NumberFormatException("The string contains invalid an digit - '" + charArray[i] + "'");
            }
            byte b5 = (byte) (b2 * b3);
            if (b2 > b4) {
                throw new NumberFormatException(str + " cannot fit into a byte");
            }
            if (b5 < 0 && b5 >= (-iDigit)) {
                throw new NumberFormatException(str + " cannot fit into a byte");
            }
            b2 = (byte) (b5 + iDigit);
            i++;
        }
        if (!z || b2 == -128) {
            return b2;
        }
        if (b2 >= 0) {
            return (byte) (b2 * (-1));
        }
        throw new NumberFormatException(str + " cannot fit into a byte");
    }

    public static double parseDouble(String str) {
        Matcher matcher = specialDoubleRegex.matcher(str);
        if (!matcher.matches()) {
            return Double.parseDouble(str);
        }
        if (matcher.start(1) != -1) {
            return matcher.start(2) != -1 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        return Double.NaN;
    }

    public static float parseFloat(String str) {
        Matcher matcher = specialFloatRegex.matcher(str);
        if (!matcher.matches()) {
            return Float.parseFloat(str);
        }
        if (matcher.start(1) != -1) {
            return matcher.start(2) != -1 ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        }
        return Float.NaN;
    }

    public static int parseInt(String str) throws NumberFormatException {
        boolean z;
        if (str == null) {
            throw new NumberFormatException("string is null");
        }
        if (str.length() == 0) {
            throw new NumberFormatException("string is blank");
        }
        char[] charArray = str.toCharArray();
        int i = 10;
        int i2 = 0;
        int i3 = 1;
        if (charArray[0] == '-') {
            z = true;
        } else {
            z = false;
            i3 = 0;
        }
        if (charArray[i3] == '0') {
            i3++;
            if (i3 == charArray.length) {
                return 0;
            }
            if (charArray[i3] == 'x' || charArray[i3] == 'X') {
                i = 16;
                i3++;
            } else if (Character.digit(charArray[i3], 8) >= 0) {
                i = 8;
            }
        }
        int i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED / (i / 2);
        while (i3 < charArray.length) {
            int iDigit = Character.digit(charArray[i3], i);
            if (iDigit < 0) {
                throw new NumberFormatException("The string contains an invalid digit - '" + charArray[i3] + "'");
            }
            int i5 = i2 * i;
            if (i2 > i4) {
                throw new NumberFormatException(str + " cannot fit into an int");
            }
            if (i5 < 0 && i5 >= (-iDigit)) {
                throw new NumberFormatException(str + " cannot fit into an int");
            }
            i2 = i5 + iDigit;
            i3++;
        }
        if (!z || i2 == Integer.MIN_VALUE) {
            return i2;
        }
        if (i2 >= 0) {
            return i2 * (-1);
        }
        throw new NumberFormatException(str + " cannot fit into an int");
    }

    public static long parseLong(String str) throws NumberFormatException {
        if (str == null) {
            throw new NumberFormatException("string is null");
        }
        if (str.length() == 0) {
            throw new NumberFormatException("string is blank");
        }
        int i = 0;
        boolean z = true;
        char[] charArray = str.toUpperCase().endsWith("L") ? str.substring(0, str.length() - 1).toCharArray() : str.toCharArray();
        int i2 = 10;
        if (charArray[0] == '-') {
            i = 1;
        } else {
            z = false;
        }
        if (charArray[i] == '0') {
            i++;
            if (i == charArray.length) {
                return 0L;
            }
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                i2 = 16;
                i++;
            } else if (Character.digit(charArray[i], 8) >= 0) {
                i2 = 8;
            }
        }
        long j = Long.MAX_VALUE / ((long) (i2 / 2));
        long j2 = 0;
        while (i < charArray.length) {
            int iDigit = Character.digit(charArray[i], i2);
            if (iDigit < 0) {
                throw new NumberFormatException("The string contains an invalid digit - '" + charArray[i] + "'");
            }
            long j3 = ((long) i2) * j2;
            if (j2 > j) {
                throw new NumberFormatException(str + " cannot fit into a long");
            }
            if (j3 < 0 && j3 >= (-iDigit)) {
                throw new NumberFormatException(str + " cannot fit into a long");
            }
            j2 = ((long) iDigit) + j3;
            i++;
        }
        if (!z || j2 == Long.MIN_VALUE) {
            return j2;
        }
        if (j2 >= 0) {
            return j2 * (-1);
        }
        throw new NumberFormatException(str + " cannot fit into a long");
    }

    public static short parseShort(String str) throws NumberFormatException {
        boolean z;
        if (str == null) {
            throw new NumberFormatException("string is null");
        }
        if (str.length() == 0) {
            throw new NumberFormatException("string is blank");
        }
        short s = 0;
        int i = 1;
        char[] charArray = str.toUpperCase().endsWith("S") ? str.substring(0, str.length() - 1).toCharArray() : str.toCharArray();
        short s2 = 10;
        if (charArray[0] == '-') {
            z = true;
        } else {
            i = 0;
            z = false;
        }
        if (charArray[i] == '0') {
            i++;
            if (i == charArray.length) {
                return (short) 0;
            }
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                s2 = 16;
                i++;
            } else if (Character.digit(charArray[i], 8) >= 0) {
                s2 = 8;
            }
        }
        short s3 = (short) (32767 / (s2 / 2));
        while (i < charArray.length) {
            int iDigit = Character.digit(charArray[i], (int) s2);
            if (iDigit < 0) {
                throw new NumberFormatException("The string contains invalid an digit - '" + charArray[i] + "'");
            }
            short s4 = (short) (s * s2);
            if (s > s3) {
                throw new NumberFormatException(str + " cannot fit into a short");
            }
            if (s4 < 0 && s4 >= (-iDigit)) {
                throw new NumberFormatException(str + " cannot fit into a short");
            }
            s = (short) (s4 + iDigit);
            i++;
        }
        if (!z || s == Short.MIN_VALUE) {
            return s;
        }
        if (s >= 0) {
            return (short) (s * (-1));
        }
        throw new NumberFormatException(str + " cannot fit into a short");
    }
}
