package org.p088jf.dexlib2.util;

import org.p088jf.dexlib2.iface.value.BooleanEncodedValue;
import org.p088jf.dexlib2.iface.value.ByteEncodedValue;
import org.p088jf.dexlib2.iface.value.CharEncodedValue;
import org.p088jf.dexlib2.iface.value.DoubleEncodedValue;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.iface.value.FloatEncodedValue;
import org.p088jf.dexlib2.iface.value.IntEncodedValue;
import org.p088jf.dexlib2.iface.value.LongEncodedValue;
import org.p088jf.dexlib2.iface.value.ShortEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public final class EncodedValueUtils {
    public static boolean isDefaultValue(EncodedValue encodedValue) {
        int valueType = encodedValue.getValueType();
        if (valueType == 0) {
            return ((ByteEncodedValue) encodedValue).getValue() == 0;
        }
        if (valueType == 6) {
            return ((LongEncodedValue) encodedValue).getValue() == 0;
        }
        if (valueType == 2) {
            return ((ShortEncodedValue) encodedValue).getValue() == 0;
        }
        if (valueType == 3) {
            return ((CharEncodedValue) encodedValue).getValue() == 0;
        }
        if (valueType == 4) {
            return ((IntEncodedValue) encodedValue).getValue() == 0;
        }
        if (valueType == 16) {
            return ((FloatEncodedValue) encodedValue).getValue() == 0.0f;
        }
        if (valueType == 17) {
            return ((DoubleEncodedValue) encodedValue).getValue() == 0.0d;
        }
        if (valueType == 30) {
            return true;
        }
        if (valueType != 31) {
            return false;
        }
        return !((BooleanEncodedValue) encodedValue).getValue();
    }
}
