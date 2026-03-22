package org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class BitSet implements Cloneable {
    public long[] bits;

    public BitSet() {
        this(64);
    }

    public BitSet(int i) {
        this.bits = new long[((i - 1) >> 6) + 1];
    }

    public BitSet(long[] jArr) {
        this.bits = jArr;
    }

    public static final long bitMask(int i) {
        return 1 << (i & 63);
    }

    public static final int wordNumber(int i) {
        return i >> 6;
    }

    public Object clone() {
        try {
            BitSet bitSet = (BitSet) super.clone();
            long[] jArr = new long[this.bits.length];
            bitSet.bits = jArr;
            long[] jArr2 = this.bits;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            return bitSet;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BitSet)) {
            return false;
        }
        BitSet bitSet = (BitSet) obj;
        int iMin = Math.min(this.bits.length, bitSet.bits.length);
        for (int i = 0; i < iMin; i++) {
            if (this.bits[i] != bitSet.bits[i]) {
                return false;
            }
        }
        if (this.bits.length > iMin) {
            int i2 = iMin + 1;
            while (true) {
                long[] jArr = this.bits;
                if (i2 >= jArr.length) {
                    break;
                }
                if (jArr[i2] != 0) {
                    return false;
                }
                i2++;
            }
        } else if (bitSet.bits.length > iMin) {
            int i3 = iMin + 1;
            while (true) {
                long[] jArr2 = bitSet.bits;
                if (i3 >= jArr2.length) {
                    break;
                }
                if (jArr2[i3] != 0) {
                    return false;
                }
                i3++;
            }
        }
        return true;
    }

    public boolean member(int i) {
        if (i < 0) {
            return false;
        }
        int iWordNumber = wordNumber(i);
        long[] jArr = this.bits;
        return iWordNumber < jArr.length && (jArr[iWordNumber] & bitMask(i)) != 0;
    }

    /* JADX INFO: renamed from: or */
    public BitSet m3786or(BitSet bitSet) {
        if (bitSet == null) {
            return this;
        }
        BitSet bitSet2 = (BitSet) clone();
        bitSet2.orInPlace(bitSet);
        return bitSet2;
    }

    public void orInPlace(BitSet bitSet) {
        if (bitSet == null) {
            return;
        }
        long[] jArr = bitSet.bits;
        if (jArr.length > this.bits.length) {
            setSize(jArr.length);
        }
        for (int iMin = Math.min(this.bits.length, bitSet.bits.length) - 1; iMin >= 0; iMin--) {
            long[] jArr2 = this.bits;
            jArr2[iMin] = jArr2[iMin] | bitSet.bits[iMin];
        }
    }

    public void remove(int i) {
        int iWordNumber = wordNumber(i);
        long[] jArr = this.bits;
        if (iWordNumber < jArr.length) {
            jArr[iWordNumber] = jArr[iWordNumber] & (bitMask(i) ^ (-1));
        }
    }

    public final void setSize(int i) {
        long[] jArr = new long[i];
        System.arraycopy(this.bits, 0, jArr, 0, Math.min(i, this.bits.length));
        this.bits = jArr;
    }

    public String toString() {
        return toString(null);
    }

    public String toString(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        boolean z = false;
        for (int i = 0; i < (this.bits.length << 6); i++) {
            if (member(i)) {
                if (i > 0 && z) {
                    sb.append(",");
                }
                if (strArr != null) {
                    sb.append(strArr[i]);
                } else {
                    sb.append(i);
                }
                z = true;
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
