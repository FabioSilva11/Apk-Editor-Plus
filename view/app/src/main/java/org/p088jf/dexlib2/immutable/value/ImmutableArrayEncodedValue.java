package org.p088jf.dexlib2.immutable.value;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import org.p088jf.dexlib2.base.value.BaseArrayEncodedValue;
import org.p088jf.dexlib2.iface.value.ArrayEncodedValue;
import org.p088jf.dexlib2.iface.value.EncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableArrayEncodedValue extends BaseArrayEncodedValue implements ImmutableEncodedValue {
    public final ImmutableList<? extends ImmutableEncodedValue> value;

    public ImmutableArrayEncodedValue(Collection<? extends EncodedValue> collection) {
        this.value = ImmutableEncodedValueFactory.immutableListOf(collection);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableArrayEncodedValue m3921of(ArrayEncodedValue arrayEncodedValue) {
        return arrayEncodedValue instanceof ImmutableArrayEncodedValue ? (ImmutableArrayEncodedValue) arrayEncodedValue : new ImmutableArrayEncodedValue(arrayEncodedValue.getValue());
    }

    @Override // org.p088jf.dexlib2.iface.value.ArrayEncodedValue
    public ImmutableList<? extends ImmutableEncodedValue> getValue() {
        return this.value;
    }
}
