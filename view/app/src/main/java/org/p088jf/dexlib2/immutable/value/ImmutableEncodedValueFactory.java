package org.p088jf.dexlib2.immutable.value;

import android.support.v7.appcompat.C0299R;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.p088jf.dexlib2.iface.value.AnnotationEncodedValue;
import org.p088jf.dexlib2.iface.value.ArrayEncodedValue;
import org.p088jf.dexlib2.iface.value.BooleanEncodedValue;
import org.p088jf.dexlib2.iface.value.ByteEncodedValue;
import org.p088jf.dexlib2.iface.value.CharEncodedValue;
import org.p088jf.dexlib2.iface.value.DoubleEncodedValue;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.iface.value.EnumEncodedValue;
import org.p088jf.dexlib2.iface.value.FieldEncodedValue;
import org.p088jf.dexlib2.iface.value.FloatEncodedValue;
import org.p088jf.dexlib2.iface.value.IntEncodedValue;
import org.p088jf.dexlib2.iface.value.LongEncodedValue;
import org.p088jf.dexlib2.iface.value.MethodEncodedValue;
import org.p088jf.dexlib2.iface.value.MethodHandleEncodedValue;
import org.p088jf.dexlib2.iface.value.MethodTypeEncodedValue;
import org.p088jf.dexlib2.iface.value.ShortEncodedValue;
import org.p088jf.dexlib2.iface.value.StringEncodedValue;
import org.p088jf.dexlib2.iface.value.TypeEncodedValue;
import org.p088jf.util.ExceptionWithContext;
import org.p088jf.util.ImmutableConverter;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableEncodedValueFactory {
    public static final ImmutableConverter<ImmutableEncodedValue, EncodedValue> CONVERTER = new ImmutableConverter<ImmutableEncodedValue, EncodedValue>() { // from class: org.jf.dexlib2.immutable.value.ImmutableEncodedValueFactory.1
        @Override // org.p088jf.util.ImmutableConverter
        public boolean isImmutable(EncodedValue encodedValue) {
            return encodedValue instanceof ImmutableEncodedValue;
        }

        @Override // org.p088jf.util.ImmutableConverter
        public ImmutableEncodedValue makeImmutable(EncodedValue encodedValue) {
            return ImmutableEncodedValueFactory.m3926of(encodedValue);
        }
    };

    public static EncodedValue defaultValueForType(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            return new ImmutableFloatEncodedValue(0.0f);
        }
        if (cCharAt != 'L') {
            if (cCharAt == 'S') {
                return new ImmutableShortEncodedValue((short) 0);
            }
            if (cCharAt == 'I') {
                return new ImmutableIntEncodedValue(0);
            }
            if (cCharAt == 'J') {
                return new ImmutableLongEncodedValue(0L);
            }
            if (cCharAt == 'Z') {
                return ImmutableBooleanEncodedValue.FALSE_VALUE;
            }
            if (cCharAt != '[') {
                switch (cCharAt) {
                    case C0299R.styleable.AppCompatTheme_imageButtonStyle /* 66 */:
                        return new ImmutableByteEncodedValue((byte) 0);
                    case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /* 67 */:
                        return new ImmutableCharEncodedValue((char) 0);
                    case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /* 68 */:
                        return new ImmutableDoubleEncodedValue(0.0d);
                    default:
                        throw new ExceptionWithContext("Unrecognized type: %s", str);
                }
            }
        }
        return ImmutableNullEncodedValue.INSTANCE;
    }

    public static ImmutableList<ImmutableEncodedValue> immutableListOf(Iterable<? extends EncodedValue> iterable) {
        return CONVERTER.toList(iterable);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableEncodedValue m3926of(EncodedValue encodedValue) {
        int valueType = encodedValue.getValueType();
        if (valueType == 0) {
            return ImmutableByteEncodedValue.m3923of((ByteEncodedValue) encodedValue);
        }
        if (valueType == 6) {
            return ImmutableLongEncodedValue.m3931of((LongEncodedValue) encodedValue);
        }
        if (valueType == 2) {
            return ImmutableShortEncodedValue.m3935of((ShortEncodedValue) encodedValue);
        }
        if (valueType == 3) {
            return ImmutableCharEncodedValue.m3924of((CharEncodedValue) encodedValue);
        }
        if (valueType == 4) {
            return ImmutableIntEncodedValue.m3930of((IntEncodedValue) encodedValue);
        }
        if (valueType == 16) {
            return ImmutableFloatEncodedValue.m3929of((FloatEncodedValue) encodedValue);
        }
        if (valueType == 17) {
            return ImmutableDoubleEncodedValue.m3925of((DoubleEncodedValue) encodedValue);
        }
        switch (valueType) {
            case 21:
                return ImmutableMethodTypeEncodedValue.m3934of((MethodTypeEncodedValue) encodedValue);
            case 22:
                return ImmutableMethodHandleEncodedValue.m3933of((MethodHandleEncodedValue) encodedValue);
            case 23:
                return ImmutableStringEncodedValue.m3936of((StringEncodedValue) encodedValue);
            case 24:
                return ImmutableTypeEncodedValue.m3937of((TypeEncodedValue) encodedValue);
            case 25:
                return ImmutableFieldEncodedValue.m3928of((FieldEncodedValue) encodedValue);
            case 26:
                return ImmutableMethodEncodedValue.m3932of((MethodEncodedValue) encodedValue);
            case 27:
                return ImmutableEnumEncodedValue.m3927of((EnumEncodedValue) encodedValue);
            case 28:
                return ImmutableArrayEncodedValue.m3921of((ArrayEncodedValue) encodedValue);
            case 29:
                return ImmutableAnnotationEncodedValue.m3920of((AnnotationEncodedValue) encodedValue);
            case 30:
                return ImmutableNullEncodedValue.INSTANCE;
            case 31:
                return ImmutableBooleanEncodedValue.m3922of((BooleanEncodedValue) encodedValue);
            default:
                Preconditions.checkArgument(false);
                return null;
        }
    }

    public static ImmutableEncodedValue ofNullable(EncodedValue encodedValue) {
        if (encodedValue == null) {
            return null;
        }
        return m3926of(encodedValue);
    }
}
