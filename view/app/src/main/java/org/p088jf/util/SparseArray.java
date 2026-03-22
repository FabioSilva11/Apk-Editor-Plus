package org.p088jf.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SparseArray<E> {
    public static final Object DELETED = new Object();
    public int[] mKeys;
    public Object[] mValues;
    public boolean mGarbage = false;
    public int mSize = 0;

    public SparseArray(int i) {
        this.mKeys = new int[i];
        this.mValues = new Object[i];
    }

    public static int binarySearch(int[] iArr, int i, int i2, int i3) {
        int i4 = i2 + i;
        int i5 = i - 1;
        int i6 = i4;
        while (i6 - i5 > 1) {
            int i7 = (i6 + i5) / 2;
            if (iArr[i7] < i3) {
                i5 = i7;
            } else {
                i6 = i7;
            }
        }
        return i6 == i4 ? i4 ^ (-1) : iArr[i6] == i3 ? i6 : i6 ^ (-1);
    }

    public void append(int i, E e) {
        int i2 = this.mSize;
        if (i2 != 0 && i <= this.mKeys[i2 - 1]) {
            put(i, e);
            return;
        }
        if (this.mGarbage && i2 >= this.mKeys.length) {
            m3940gc();
        }
        int i3 = this.mSize;
        int[] iArr = this.mKeys;
        if (i3 >= iArr.length) {
            int iMax = Math.max(i3 + 1, iArr.length * 2);
            int[] iArr2 = new int[iMax];
            Object[] objArr = new Object[iMax];
            int[] iArr3 = this.mKeys;
            System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = iArr2;
            this.mValues = objArr;
        }
        this.mKeys[i3] = i;
        this.mValues[i3] = e;
        this.mSize = i3 + 1;
    }

    public void ensureCapacity(int i) {
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            m3940gc();
        }
        int[] iArr = this.mKeys;
        if (iArr.length < i) {
            int[] iArr2 = new int[i];
            Object[] objArr = new Object[i];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = iArr2;
            this.mValues = objArr;
        }
    }

    /* JADX INFO: renamed from: gc */
    public final void m3940gc() {
        int i = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public E get(int i) {
        return get(i, null);
    }

    public E get(int i, E e) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, i);
        if (iBinarySearch >= 0) {
            Object[] objArr = this.mValues;
            if (objArr[iBinarySearch] != DELETED) {
                return (E) objArr[iBinarySearch];
            }
        }
        return e;
    }

    public List<E> getValues() {
        return Collections.unmodifiableList(Arrays.asList(this.mValues));
    }

    public int keyAt(int i) {
        if (this.mGarbage) {
            m3940gc();
        }
        return this.mKeys[i];
    }

    public void put(int i, E e) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, i);
        if (iBinarySearch >= 0) {
            this.mValues[iBinarySearch] = e;
            return;
        }
        int iBinarySearch2 = iBinarySearch ^ (-1);
        int i2 = this.mSize;
        if (iBinarySearch2 < i2) {
            Object[] objArr = this.mValues;
            if (objArr[iBinarySearch2] == DELETED) {
                this.mKeys[iBinarySearch2] = i;
                objArr[iBinarySearch2] = e;
                return;
            }
        }
        if (this.mGarbage && i2 >= this.mKeys.length) {
            m3940gc();
            iBinarySearch2 = binarySearch(this.mKeys, 0, this.mSize, i) ^ (-1);
        }
        int i3 = this.mSize;
        int[] iArr = this.mKeys;
        if (i3 >= iArr.length) {
            int iMax = Math.max(i3 + 1, iArr.length * 2);
            int[] iArr2 = new int[iMax];
            Object[] objArr2 = new Object[iMax];
            int[] iArr3 = this.mKeys;
            System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = iArr2;
            this.mValues = objArr2;
        }
        int i4 = this.mSize;
        if (i4 - iBinarySearch2 != 0) {
            int[] iArr4 = this.mKeys;
            int i5 = iBinarySearch2 + 1;
            System.arraycopy(iArr4, iBinarySearch2, iArr4, i5, i4 - iBinarySearch2);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, iBinarySearch2, objArr4, i5, this.mSize - iBinarySearch2);
        }
        this.mKeys[iBinarySearch2] = i;
        this.mValues[iBinarySearch2] = e;
        this.mSize++;
    }

    public int size() {
        if (this.mGarbage) {
            m3940gc();
        }
        return this.mSize;
    }

    public E valueAt(int i) {
        if (this.mGarbage) {
            m3940gc();
        }
        return (E) this.mValues[i];
    }
}
