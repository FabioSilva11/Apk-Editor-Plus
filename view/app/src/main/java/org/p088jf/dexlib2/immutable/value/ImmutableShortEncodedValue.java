package org.p088jf.dexlib2.immutable.value;

import org.p088jf.dexlib2.base.value.BaseShortEncodedValue;
import org.p088jf.dexlib2.iface.value.ShortEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableShortEncodedValue extends BaseShortEncodedValue implements ImmutableEncodedValue {
    public final short value;

    public ImmutableShortEncodedValue(short s) {
        this.value = s;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableShortEncodedValue m3935of(ShortEncodedValue shortEncodedValue) {
        return shortEncodedValue instanceof ImmutableShortEncodedValue ? (ImmutableShortEncodedValue) shortEncodedValue : new ImmutableShortEncodedValue(shortEncodedValue.getValue());
    }

    @Override // org.p088jf.dexlib2.iface.value.ShortEncodedValue
    public short getValue() {
        return this.value;
    }
}
