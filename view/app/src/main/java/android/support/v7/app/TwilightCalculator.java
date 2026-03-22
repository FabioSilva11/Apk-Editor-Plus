package android.support.v7.app;

/* JADX INFO: loaded from: classes.dex */
class TwilightCalculator {
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;

    /* JADX INFO: renamed from: C1 */
    private static final float f234C1 = 0.0334196f;

    /* JADX INFO: renamed from: C2 */
    private static final float f235C2 = 3.49066E-4f;

    /* JADX INFO: renamed from: C3 */
    private static final float f236C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;

    /* JADX INFO: renamed from: J0 */
    private static final float f237J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    TwilightCalculator() {
    }

    static TwilightCalculator getInstance() {
        if (sInstance == null) {
            sInstance = new TwilightCalculator();
        }
        return sInstance;
    }

    public void calculateTwilight(long j, double d, double d2) {
        float f = 6.24006f + (0.01720197f * ((j - UTC_2000) / 8.64E7f));
        double dSin = ((double) f) + (0.03341960161924362d * Math.sin(f)) + (3.4906598739326E-4d * Math.sin(2.0f * f)) + (5.236000106378924E-6d * Math.sin(3.0f * f)) + 1.796593063d + 3.141592653589793d;
        double dSin2 = (Math.sin(f) * 0.0053d) + ((-d2) / 360.0d) + ((double) (Math.round(((double) (r2 - f237J0)) - r6) + f237J0)) + ((-0.0069d) * Math.sin(2.0d * dSin));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d3 = 0.01745329238474369d * d;
        double dSin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(d3) * Math.sin(dAsin))) / (Math.cos(dAsin) * Math.cos(d3));
        if (dSin3 >= 1.0d) {
            this.state = 1;
            this.sunset = -1L;
            this.sunrise = -1L;
        } else {
            if (dSin3 <= -1.0d) {
                this.state = 0;
                this.sunset = -1L;
                this.sunrise = -1L;
                return;
            }
            float fAcos = (float) (Math.acos(dSin3) / 6.283185307179586d);
            this.sunset = Math.round((((double) fAcos) + dSin2) * 8.64E7d) + UTC_2000;
            this.sunrise = Math.round((dSin2 - ((double) fAcos)) * 8.64E7d) + UTC_2000;
            if (this.sunrise >= j || this.sunset <= j) {
                this.state = 1;
            } else {
                this.state = 0;
            }
        }
    }
}
