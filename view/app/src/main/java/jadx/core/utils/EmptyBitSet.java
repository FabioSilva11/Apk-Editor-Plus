package jadx.core.utils;

import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public final class EmptyBitSet extends BitSet {
    public static final BitSet EMPTY = new EmptyBitSet();
    private static final long serialVersionUID = -1194884945157778639L;

    public EmptyBitSet() {
        super(0);
    }

    @Override // java.util.BitSet
    public final void and(BitSet bitSet) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public final void andNot(BitSet bitSet) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public final int cardinality() {
        return 0;
    }

    @Override // java.util.BitSet
    public final Object clone() {
        return this;
    }

    @Override // java.util.BitSet
    public final BitSet get(int i, int i2) {
        return EMPTY;
    }

    @Override // java.util.BitSet
    public final boolean get(int i) {
        return false;
    }

    @Override // java.util.BitSet
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.BitSet
    public final int length() {
        return 0;
    }

    @Override // java.util.BitSet
    public final int nextSetBit(int i) {
        return -1;
    }

    @Override // java.util.BitSet
    public final void or(BitSet bitSet) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public final void set(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public final void set(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public final void set(int i, int i2, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public final void set(int i, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.BitSet
    public final int size() {
        return 0;
    }

    @Override // java.util.BitSet
    public final void xor(BitSet bitSet) {
        throw new UnsupportedOperationException();
    }
}
