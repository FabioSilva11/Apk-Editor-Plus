package org.p088jf.dexlib2.writer.builder;

import android.support.v7.appcompat.C0299R;
import java.util.List;
import java.util.Set;
import org.p088jf.dexlib2.base.value.BaseAnnotationEncodedValue;
import org.p088jf.dexlib2.base.value.BaseArrayEncodedValue;
import org.p088jf.dexlib2.base.value.BaseBooleanEncodedValue;
import org.p088jf.dexlib2.base.value.BaseEnumEncodedValue;
import org.p088jf.dexlib2.base.value.BaseFieldEncodedValue;
import org.p088jf.dexlib2.base.value.BaseMethodEncodedValue;
import org.p088jf.dexlib2.base.value.BaseMethodHandleEncodedValue;
import org.p088jf.dexlib2.base.value.BaseMethodTypeEncodedValue;
import org.p088jf.dexlib2.base.value.BaseNullEncodedValue;
import org.p088jf.dexlib2.base.value.BaseStringEncodedValue;
import org.p088jf.dexlib2.base.value.BaseTypeEncodedValue;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableByteEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableCharEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableDoubleEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableFloatEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableIntEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableLongEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableShortEncodedValue;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public abstract class BuilderEncodedValues {

    public static class BuilderAnnotationEncodedValue extends BaseAnnotationEncodedValue implements BuilderEncodedValue {
        public final Set<? extends BuilderAnnotationElement> elements;
        public final BuilderTypeReference typeReference;

        public BuilderAnnotationEncodedValue(BuilderTypeReference builderTypeReference, Set<? extends BuilderAnnotationElement> set) {
            this.typeReference = builderTypeReference;
            this.elements = set;
        }

        @Override // org.p088jf.dexlib2.iface.value.AnnotationEncodedValue
        public Set<? extends BuilderAnnotationElement> getElements() {
            return this.elements;
        }

        @Override // org.p088jf.dexlib2.iface.value.AnnotationEncodedValue
        public String getType() {
            return this.typeReference.getType();
        }
    }

    public static class BuilderArrayEncodedValue extends BaseArrayEncodedValue implements BuilderEncodedValue {
        public final List<? extends BuilderEncodedValue> elements;
        public int offset = 0;

        public BuilderArrayEncodedValue(List<? extends BuilderEncodedValue> list) {
            this.elements = list;
        }

        @Override // org.p088jf.dexlib2.iface.value.ArrayEncodedValue
        public List<? extends EncodedValue> getValue() {
            return this.elements;
        }
    }

    public static class BuilderBooleanEncodedValue extends BaseBooleanEncodedValue implements BuilderEncodedValue {
        public final boolean value;
        public static final BuilderBooleanEncodedValue TRUE_VALUE = new BuilderBooleanEncodedValue(true);
        public static final BuilderBooleanEncodedValue FALSE_VALUE = new BuilderBooleanEncodedValue(false);

        public BuilderBooleanEncodedValue(boolean z) {
            this.value = z;
        }

        @Override // org.p088jf.dexlib2.iface.value.BooleanEncodedValue
        public boolean getValue() {
            return this.value;
        }
    }

    public static class BuilderByteEncodedValue extends ImmutableByteEncodedValue implements BuilderEncodedValue {
        public BuilderByteEncodedValue(byte b2) {
            super(b2);
        }
    }

    public static class BuilderCharEncodedValue extends ImmutableCharEncodedValue implements BuilderEncodedValue {
        public BuilderCharEncodedValue(char c) {
            super(c);
        }
    }

    public static class BuilderDoubleEncodedValue extends ImmutableDoubleEncodedValue implements BuilderEncodedValue {
        public BuilderDoubleEncodedValue(double d) {
            super(d);
        }
    }

    public interface BuilderEncodedValue extends EncodedValue {
    }

    public static class BuilderEnumEncodedValue extends BaseEnumEncodedValue implements BuilderEncodedValue {
        public final BuilderFieldReference enumReference;

        public BuilderEnumEncodedValue(BuilderFieldReference builderFieldReference) {
            this.enumReference = builderFieldReference;
        }

        @Override // org.p088jf.dexlib2.iface.value.EnumEncodedValue
        public BuilderFieldReference getValue() {
            return this.enumReference;
        }
    }

    public static class BuilderFieldEncodedValue extends BaseFieldEncodedValue implements BuilderEncodedValue {
        public final BuilderFieldReference fieldReference;

        public BuilderFieldEncodedValue(BuilderFieldReference builderFieldReference) {
            this.fieldReference = builderFieldReference;
        }

        @Override // org.p088jf.dexlib2.iface.value.FieldEncodedValue
        public BuilderFieldReference getValue() {
            return this.fieldReference;
        }
    }

    public static class BuilderFloatEncodedValue extends ImmutableFloatEncodedValue implements BuilderEncodedValue {
        public BuilderFloatEncodedValue(float f) {
            super(f);
        }
    }

    public static class BuilderIntEncodedValue extends ImmutableIntEncodedValue implements BuilderEncodedValue {
        public BuilderIntEncodedValue(int i) {
            super(i);
        }
    }

    public static class BuilderLongEncodedValue extends ImmutableLongEncodedValue implements BuilderEncodedValue {
        public BuilderLongEncodedValue(long j) {
            super(j);
        }
    }

    public static class BuilderMethodEncodedValue extends BaseMethodEncodedValue implements BuilderEncodedValue {
        public final BuilderMethodReference methodReference;

        public BuilderMethodEncodedValue(BuilderMethodReference builderMethodReference) {
            this.methodReference = builderMethodReference;
        }

        @Override // org.p088jf.dexlib2.iface.value.MethodEncodedValue
        public BuilderMethodReference getValue() {
            return this.methodReference;
        }
    }

    public static class BuilderMethodHandleEncodedValue extends BaseMethodHandleEncodedValue implements BuilderEncodedValue {
        public final BuilderMethodHandleReference methodHandleReference;

        public BuilderMethodHandleEncodedValue(BuilderMethodHandleReference builderMethodHandleReference) {
            this.methodHandleReference = builderMethodHandleReference;
        }

        @Override // org.p088jf.dexlib2.iface.value.MethodHandleEncodedValue
        public BuilderMethodHandleReference getValue() {
            return this.methodHandleReference;
        }
    }

    public static class BuilderMethodTypeEncodedValue extends BaseMethodTypeEncodedValue implements BuilderEncodedValue {
        public final BuilderMethodProtoReference methodProtoReference;

        public BuilderMethodTypeEncodedValue(BuilderMethodProtoReference builderMethodProtoReference) {
            this.methodProtoReference = builderMethodProtoReference;
        }

        @Override // org.p088jf.dexlib2.iface.value.MethodTypeEncodedValue
        public BuilderMethodProtoReference getValue() {
            return this.methodProtoReference;
        }
    }

    public static class BuilderNullEncodedValue extends BaseNullEncodedValue implements BuilderEncodedValue {
        public static final BuilderNullEncodedValue INSTANCE = new BuilderNullEncodedValue();
    }

    public static class BuilderShortEncodedValue extends ImmutableShortEncodedValue implements BuilderEncodedValue {
        public BuilderShortEncodedValue(short s) {
            super(s);
        }
    }

    public static class BuilderStringEncodedValue extends BaseStringEncodedValue implements BuilderEncodedValue {
        public final BuilderStringReference stringReference;

        public BuilderStringEncodedValue(BuilderStringReference builderStringReference) {
            this.stringReference = builderStringReference;
        }

        @Override // org.p088jf.dexlib2.iface.value.StringEncodedValue
        public String getValue() {
            return this.stringReference.getString();
        }
    }

    public static class BuilderTypeEncodedValue extends BaseTypeEncodedValue implements BuilderEncodedValue {
        public final BuilderTypeReference typeReference;

        public BuilderTypeEncodedValue(BuilderTypeReference builderTypeReference) {
            this.typeReference = builderTypeReference;
        }

        @Override // org.p088jf.dexlib2.iface.value.TypeEncodedValue
        public String getValue() {
            return this.typeReference.getType();
        }
    }

    public static BuilderEncodedValue defaultValueForType(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            return new BuilderFloatEncodedValue(0.0f);
        }
        if (cCharAt != 'L') {
            if (cCharAt == 'S') {
                return new BuilderShortEncodedValue((short) 0);
            }
            if (cCharAt == 'I') {
                return new BuilderIntEncodedValue(0);
            }
            if (cCharAt == 'J') {
                return new BuilderLongEncodedValue(0L);
            }
            if (cCharAt == 'Z') {
                return BuilderBooleanEncodedValue.FALSE_VALUE;
            }
            if (cCharAt != '[') {
                switch (cCharAt) {
                    case C0299R.styleable.AppCompatTheme_imageButtonStyle /* 66 */:
                        return new BuilderByteEncodedValue((byte) 0);
                    case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /* 67 */:
                        return new BuilderCharEncodedValue((char) 0);
                    case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /* 68 */:
                        return new BuilderDoubleEncodedValue(0.0d);
                    default:
                        throw new ExceptionWithContext("Unrecognized type: %s", str);
                }
            }
        }
        return BuilderNullEncodedValue.INSTANCE;
    }
}
