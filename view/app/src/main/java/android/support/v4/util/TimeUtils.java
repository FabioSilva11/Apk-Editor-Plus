package android.support.v4.util;

import android.support.annotation.RestrictTo;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TimeUtils {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private TimeUtils() {
    }

    private static int accumField(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void formatDuration(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j - j2, printWriter, 0);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void formatDuration(long j, PrintWriter printWriter) {
        formatDuration(j, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j, i)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void formatDuration(long j, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j, 0));
        }
    }

    private static int formatDurationLocked(long j, int i) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (sFormatStr.length < i) {
            sFormatStr = new char[i];
        }
        char[] cArr = sFormatStr;
        if (j == 0) {
            int i7 = i - 1;
            while (i7 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j > 0) {
            c = '+';
        } else {
            j = -j;
            c = '-';
        }
        int i8 = (int) (j % 1000);
        int iFloor = (int) Math.floor(j / 1000);
        int i9 = 0;
        if (iFloor > SECONDS_PER_DAY) {
            i9 = iFloor / SECONDS_PER_DAY;
            iFloor -= SECONDS_PER_DAY * i9;
        }
        if (iFloor > SECONDS_PER_HOUR) {
            int i10 = iFloor / SECONDS_PER_HOUR;
            i2 = i10;
            i3 = iFloor - (i10 * SECONDS_PER_HOUR);
        } else {
            i2 = 0;
            i3 = iFloor;
        }
        if (i3 > 60) {
            int i11 = i3 / 60;
            i4 = i11;
            i5 = i3 - (i11 * 60);
        } else {
            i4 = 0;
            i5 = i3;
        }
        if (i != 0) {
            int iAccumField = accumField(i9, 1, false, 0);
            int iAccumField2 = iAccumField + accumField(i2, 1, iAccumField > 0, 2);
            int iAccumField3 = iAccumField2 + accumField(i4, 1, iAccumField2 > 0, 2);
            int iAccumField4 = iAccumField3 + accumField(i5, 1, iAccumField3 > 0, 2);
            i6 = 0;
            int iAccumField5 = accumField(i8, 2, true, iAccumField4 > 0 ? 3 : 0) + 1 + iAccumField4;
            while (iAccumField5 < i) {
                cArr[i6] = ' ';
                iAccumField5++;
                i6++;
            }
        } else {
            i6 = 0;
        }
        cArr[i6] = c;
        int i12 = i6 + 1;
        boolean z = i != 0;
        int iPrintField = printField(cArr, i9, 'd', i12, false, 0);
        int iPrintField2 = printField(cArr, i2, 'h', iPrintField, iPrintField != i12, z ? 2 : 0);
        int iPrintField3 = printField(cArr, i4, 'm', iPrintField2, iPrintField2 != i12, z ? 2 : 0);
        int iPrintField4 = printField(cArr, i5, 's', iPrintField3, iPrintField3 != i12, z ? 2 : 0);
        int iPrintField5 = printField(cArr, i8, 'm', iPrintField4, true, (!z || iPrintField4 == i12) ? 0 : 3);
        cArr[iPrintField5] = 's';
        return iPrintField5 + 1;
    }

    private static int printField(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        int i5;
        if (!z && i <= 0) {
            return i2;
        }
        if ((!z || i3 < 3) && i <= 99) {
            i4 = i2;
            i5 = i;
        } else {
            int i6 = i / 100;
            cArr[i2] = (char) (i6 + 48);
            i4 = i2 + 1;
            i5 = i - (i6 * 100);
        }
        if ((z && i3 >= 2) || i5 > 9 || i2 != i4) {
            int i7 = i5 / 10;
            cArr[i4] = (char) (i7 + 48);
            i4++;
            i5 -= i7 * 10;
        }
        cArr[i4] = (char) (i5 + 48);
        int i8 = i4 + 1;
        cArr[i8] = c;
        return i8 + 1;
    }
}
