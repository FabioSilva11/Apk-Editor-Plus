package org.p088jf.dexlib2.writer.builder;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.Opcodes;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.AnnotationElement;
import org.p088jf.dexlib2.iface.MethodImplementation;
import org.p088jf.dexlib2.iface.MethodParameter;
import org.p088jf.dexlib2.iface.reference.CallSiteReference;
import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.iface.reference.MethodHandleReference;
import org.p088jf.dexlib2.iface.reference.MethodProtoReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.dexlib2.iface.reference.StringReference;
import org.p088jf.dexlib2.iface.reference.TypeReference;
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
import org.p088jf.dexlib2.util.FieldUtil;
import org.p088jf.dexlib2.writer.DexWriter;
import org.p088jf.dexlib2.writer.builder.BuilderEncodedValues;
import org.p088jf.dexlib2.writer.util.StaticInitializerUtil;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class DexBuilder extends DexWriter<BuilderStringReference, BuilderStringReference, BuilderTypeReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderFieldReference, BuilderMethodReference, BuilderClassDef, BuilderCallSiteReference, BuilderMethodHandleReference, BuilderAnnotation, BuilderAnnotationSet, BuilderTypeList, BuilderField, BuilderMethod, BuilderEncodedValues.BuilderArrayEncodedValue, BuilderEncodedValues.BuilderEncodedValue, BuilderAnnotationElement, BuilderStringPool, BuilderTypePool, BuilderProtoPool, BuilderFieldPool, BuilderMethodPool, BuilderClassPool, BuilderCallSitePool, BuilderMethodHandlePool, BuilderTypeListPool, BuilderAnnotationPool, BuilderAnnotationSetPool, BuilderEncodedArrayPool> {

    public class DexBuilderSectionProvider extends DexWriter<BuilderStringReference, BuilderStringReference, BuilderTypeReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderFieldReference, BuilderMethodReference, BuilderClassDef, BuilderCallSiteReference, BuilderMethodHandleReference, BuilderAnnotation, BuilderAnnotationSet, BuilderTypeList, BuilderField, BuilderMethod, BuilderEncodedValues.BuilderArrayEncodedValue, BuilderEncodedValues.BuilderEncodedValue, BuilderAnnotationElement, BuilderStringPool, BuilderTypePool, BuilderProtoPool, BuilderFieldPool, BuilderMethodPool, BuilderClassPool, BuilderCallSitePool, BuilderMethodHandlePool, BuilderTypeListPool, BuilderAnnotationPool, BuilderAnnotationSetPool, BuilderEncodedArrayPool>.SectionProvider {
        public DexBuilderSectionProvider() {
            super(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public BuilderAnnotationPool getAnnotationSection() {
            return new BuilderAnnotationPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public BuilderAnnotationSetPool getAnnotationSetSection() {
            return new BuilderAnnotationSetPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public BuilderCallSitePool getCallSiteSection() {
            return new BuilderCallSitePool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public BuilderClassPool getClassSection() {
            return new BuilderClassPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public BuilderEncodedArrayPool getEncodedArraySection() {
            return new BuilderEncodedArrayPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public BuilderFieldPool getFieldSection() {
            return new BuilderFieldPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public BuilderMethodHandlePool getMethodHandleSection() {
            return new BuilderMethodHandlePool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public BuilderMethodPool getMethodSection() {
            return new BuilderMethodPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public BuilderProtoPool getProtoSection() {
            return new BuilderProtoPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public BuilderStringPool getStringSection() {
            return new BuilderStringPool();
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public BuilderTypeListPool getTypeListSection() {
            return new BuilderTypeListPool(DexBuilder.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public BuilderTypePool getTypeSection() {
            return new BuilderTypePool(DexBuilder.this);
        }
    }

    public DexBuilder(Opcodes opcodes) {
        super(opcodes);
    }

    @Override // org.p088jf.dexlib2.writer.DexWriter
    public DexWriter<BuilderStringReference, BuilderStringReference, BuilderTypeReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderFieldReference, BuilderMethodReference, BuilderClassDef, BuilderCallSiteReference, BuilderMethodHandleReference, BuilderAnnotation, BuilderAnnotationSet, BuilderTypeList, BuilderField, BuilderMethod, BuilderEncodedValues.BuilderArrayEncodedValue, BuilderEncodedValues.BuilderEncodedValue, BuilderAnnotationElement, BuilderStringPool, BuilderTypePool, BuilderProtoPool, BuilderFieldPool, BuilderMethodPool, BuilderClassPool, BuilderCallSitePool, BuilderMethodHandlePool, BuilderTypeListPool, BuilderAnnotationPool, BuilderAnnotationSetPool, BuilderEncodedArrayPool>.SectionProvider getSectionProvider() {
        return new DexBuilderSectionProvider();
    }

    public final BuilderAnnotationElement internAnnotationElement(AnnotationElement annotationElement) {
        return new BuilderAnnotationElement(((BuilderStringPool) this.stringSection).internString(annotationElement.getName()), internEncodedValue(annotationElement.getValue()));
    }

    public Set<? extends BuilderAnnotationElement> internAnnotationElements(Set<? extends AnnotationElement> set) {
        return ImmutableSet.copyOf(Iterators.transform(set.iterator(), new Function<AnnotationElement, BuilderAnnotationElement>() { // from class: org.jf.dexlib2.writer.builder.DexBuilder.2
            @Override // com.google.common.base.Function
            public BuilderAnnotationElement apply(AnnotationElement annotationElement) {
                return DexBuilder.this.internAnnotationElement(annotationElement);
            }
        }));
    }

    public final BuilderEncodedValues.BuilderAnnotationEncodedValue internAnnotationEncodedValue(AnnotationEncodedValue annotationEncodedValue) {
        return new BuilderEncodedValues.BuilderAnnotationEncodedValue(((BuilderTypePool) this.typeSection).internType(annotationEncodedValue.getType()), internAnnotationElements(annotationEncodedValue.getElements()));
    }

    public final BuilderEncodedValues.BuilderArrayEncodedValue internArrayEncodedValue(ArrayEncodedValue arrayEncodedValue) {
        return new BuilderEncodedValues.BuilderArrayEncodedValue(ImmutableList.copyOf(Iterators.transform(arrayEncodedValue.getValue().iterator(), new Function<EncodedValue, BuilderEncodedValues.BuilderEncodedValue>() { // from class: org.jf.dexlib2.writer.builder.DexBuilder.3
            @Override // com.google.common.base.Function
            public BuilderEncodedValues.BuilderEncodedValue apply(EncodedValue encodedValue) {
                return DexBuilder.this.internEncodedValue(encodedValue);
            }
        })));
    }

    public BuilderCallSiteReference internCallSite(CallSiteReference callSiteReference) {
        return ((BuilderCallSitePool) this.callSiteSection).internCallSite(callSiteReference);
    }

    public BuilderClassDef internClassDef(String str, int i, String str2, List<String> list, String str3, Set<? extends Annotation> set, Iterable<? extends BuilderField> iterable, Iterable<? extends BuilderMethod> iterable2) {
        List<String> listM3778of;
        ImmutableSortedSet immutableSortedSet;
        ImmutableSortedSet immutableSortedSet2;
        BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValueInternArrayEncodedValue;
        if (list == null) {
            listM3778of = ImmutableList.m3778of();
        } else {
            HashSet hashSetNewHashSet = Sets.newHashSet(list);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (hashSetNewHashSet.contains(next)) {
                    hashSetNewHashSet.remove(next);
                } else {
                    it.remove();
                }
            }
            listM3778of = list;
        }
        if (iterable != null) {
            ImmutableSortedSet immutableSortedSetCopyOf = ImmutableSortedSet.copyOf(Iterables.filter(iterable, FieldUtil.FIELD_IS_STATIC));
            ImmutableSortedSet immutableSortedSetCopyOf2 = ImmutableSortedSet.copyOf(Iterables.filter(iterable, FieldUtil.FIELD_IS_INSTANCE));
            ArrayEncodedValue staticInitializers = StaticInitializerUtil.getStaticInitializers(immutableSortedSetCopyOf);
            immutableSortedSet2 = immutableSortedSetCopyOf2;
            builderArrayEncodedValueInternArrayEncodedValue = staticInitializers != null ? ((BuilderEncodedArrayPool) this.encodedArraySection).internArrayEncodedValue(staticInitializers) : null;
            immutableSortedSet = immutableSortedSetCopyOf;
        } else {
            immutableSortedSet = null;
            immutableSortedSet2 = null;
            builderArrayEncodedValueInternArrayEncodedValue = null;
        }
        return ((BuilderClassPool) this.classSection).internClass(new BuilderClassDef(((BuilderTypePool) this.typeSection).internType(str), i, ((BuilderTypePool) this.typeSection).internNullableType(str2), ((BuilderTypeListPool) this.typeListSection).internTypeList(listM3778of), ((BuilderStringPool) this.stringSection).internNullableString(str3), ((BuilderAnnotationSetPool) this.annotationSetSection).internAnnotationSet(set), immutableSortedSet, immutableSortedSet2, iterable2, builderArrayEncodedValueInternArrayEncodedValue));
    }

    public BuilderEncodedValues.BuilderEncodedValue internEncodedValue(EncodedValue encodedValue) {
        int valueType = encodedValue.getValueType();
        if (valueType == 0) {
            return new BuilderEncodedValues.BuilderByteEncodedValue(((ByteEncodedValue) encodedValue).getValue());
        }
        if (valueType == 6) {
            return new BuilderEncodedValues.BuilderLongEncodedValue(((LongEncodedValue) encodedValue).getValue());
        }
        if (valueType == 2) {
            return new BuilderEncodedValues.BuilderShortEncodedValue(((ShortEncodedValue) encodedValue).getValue());
        }
        if (valueType == 3) {
            return new BuilderEncodedValues.BuilderCharEncodedValue(((CharEncodedValue) encodedValue).getValue());
        }
        if (valueType == 4) {
            return new BuilderEncodedValues.BuilderIntEncodedValue(((IntEncodedValue) encodedValue).getValue());
        }
        if (valueType == 16) {
            return new BuilderEncodedValues.BuilderFloatEncodedValue(((FloatEncodedValue) encodedValue).getValue());
        }
        if (valueType == 17) {
            return new BuilderEncodedValues.BuilderDoubleEncodedValue(((DoubleEncodedValue) encodedValue).getValue());
        }
        switch (valueType) {
            case 21:
                return internMethodTypeEncodedValue((MethodTypeEncodedValue) encodedValue);
            case 22:
                return internMethodHandleEncodedValue((MethodHandleEncodedValue) encodedValue);
            case 23:
                return internStringEncodedValue((StringEncodedValue) encodedValue);
            case 24:
                return internTypeEncodedValue((TypeEncodedValue) encodedValue);
            case 25:
                return internFieldEncodedValue((FieldEncodedValue) encodedValue);
            case 26:
                return internMethodEncodedValue((MethodEncodedValue) encodedValue);
            case 27:
                return internEnumEncodedValue((EnumEncodedValue) encodedValue);
            case 28:
                return internArrayEncodedValue((ArrayEncodedValue) encodedValue);
            case 29:
                return internAnnotationEncodedValue((AnnotationEncodedValue) encodedValue);
            case 30:
                return BuilderEncodedValues.BuilderNullEncodedValue.INSTANCE;
            case 31:
                return ((BooleanEncodedValue) encodedValue).getValue() ? BuilderEncodedValues.BuilderBooleanEncodedValue.TRUE_VALUE : BuilderEncodedValues.BuilderBooleanEncodedValue.FALSE_VALUE;
            default:
                throw new ExceptionWithContext("Unexpected encoded value type: %d", Integer.valueOf(encodedValue.getValueType()));
        }
    }

    public final BuilderEncodedValues.BuilderEnumEncodedValue internEnumEncodedValue(EnumEncodedValue enumEncodedValue) {
        return new BuilderEncodedValues.BuilderEnumEncodedValue(((BuilderFieldPool) this.fieldSection).internField(enumEncodedValue.getValue()));
    }

    public BuilderField internField(String str, String str2, String str3, int i, EncodedValue encodedValue, Set<? extends Annotation> set, Set<HiddenApiRestriction> set2) {
        return new BuilderField(((BuilderFieldPool) this.fieldSection).internField(str, str2, str3), i, internNullableEncodedValue(encodedValue), ((BuilderAnnotationSetPool) this.annotationSetSection).internAnnotationSet(set), set2);
    }

    public final BuilderEncodedValues.BuilderFieldEncodedValue internFieldEncodedValue(FieldEncodedValue fieldEncodedValue) {
        return new BuilderEncodedValues.BuilderFieldEncodedValue(((BuilderFieldPool) this.fieldSection).internField(fieldEncodedValue.getValue()));
    }

    public BuilderFieldReference internFieldReference(FieldReference fieldReference) {
        return ((BuilderFieldPool) this.fieldSection).internField(fieldReference);
    }

    public BuilderMethod internMethod(String str, String str2, List<? extends MethodParameter> list, String str3, int i, Set<? extends Annotation> set, Set<HiddenApiRestriction> set2, MethodImplementation methodImplementation) {
        List<? extends MethodParameter> listM3778of = list == null ? ImmutableList.m3778of() : list;
        return new BuilderMethod(((BuilderMethodPool) this.methodSection).internMethod(str, str2, listM3778of, str3), internMethodParameters(listM3778of), i, ((BuilderAnnotationSetPool) this.annotationSetSection).internAnnotationSet(set), set2, methodImplementation);
    }

    public final BuilderEncodedValues.BuilderMethodEncodedValue internMethodEncodedValue(MethodEncodedValue methodEncodedValue) {
        return new BuilderEncodedValues.BuilderMethodEncodedValue(((BuilderMethodPool) this.methodSection).internMethod(methodEncodedValue.getValue()));
    }

    public BuilderMethodHandleReference internMethodHandle(MethodHandleReference methodHandleReference) {
        return ((BuilderMethodHandlePool) this.methodHandleSection).internMethodHandle(methodHandleReference);
    }

    public final BuilderEncodedValues.BuilderMethodHandleEncodedValue internMethodHandleEncodedValue(MethodHandleEncodedValue methodHandleEncodedValue) {
        return new BuilderEncodedValues.BuilderMethodHandleEncodedValue(((BuilderMethodHandlePool) this.methodHandleSection).internMethodHandle(methodHandleEncodedValue.getValue()));
    }

    public final BuilderMethodParameter internMethodParameter(MethodParameter methodParameter) {
        return new BuilderMethodParameter(((BuilderTypePool) this.typeSection).internType(methodParameter.getType()), ((BuilderStringPool) this.stringSection).internNullableString(methodParameter.getName()), ((BuilderAnnotationSetPool) this.annotationSetSection).internAnnotationSet(methodParameter.getAnnotations()));
    }

    public final List<BuilderMethodParameter> internMethodParameters(List<? extends MethodParameter> list) {
        return list == null ? ImmutableList.m3778of() : ImmutableList.copyOf(Iterators.transform(list.iterator(), new Function<MethodParameter, BuilderMethodParameter>() { // from class: org.jf.dexlib2.writer.builder.DexBuilder.1
            @Override // com.google.common.base.Function
            public BuilderMethodParameter apply(MethodParameter methodParameter) {
                return DexBuilder.this.internMethodParameter(methodParameter);
            }
        }));
    }

    public BuilderMethodProtoReference internMethodProtoReference(MethodProtoReference methodProtoReference) {
        return ((BuilderProtoPool) this.protoSection).internMethodProto(methodProtoReference);
    }

    public BuilderMethodReference internMethodReference(MethodReference methodReference) {
        return ((BuilderMethodPool) this.methodSection).internMethod(methodReference);
    }

    public final BuilderEncodedValues.BuilderMethodTypeEncodedValue internMethodTypeEncodedValue(MethodTypeEncodedValue methodTypeEncodedValue) {
        return new BuilderEncodedValues.BuilderMethodTypeEncodedValue(((BuilderProtoPool) this.protoSection).internMethodProto(methodTypeEncodedValue.getValue()));
    }

    public BuilderEncodedValues.BuilderEncodedValue internNullableEncodedValue(EncodedValue encodedValue) {
        if (encodedValue == null) {
            return null;
        }
        return internEncodedValue(encodedValue);
    }

    public BuilderStringReference internNullableStringReference(String str) {
        if (str != null) {
            return internStringReference(str);
        }
        return null;
    }

    public BuilderTypeReference internNullableTypeReference(String str) {
        if (str != null) {
            return internTypeReference(str);
        }
        return null;
    }

    public BuilderReference internReference(Reference reference) {
        if (reference instanceof StringReference) {
            return internStringReference(((StringReference) reference).getString());
        }
        if (reference instanceof TypeReference) {
            return internTypeReference(((TypeReference) reference).getType());
        }
        if (reference instanceof MethodReference) {
            return internMethodReference((MethodReference) reference);
        }
        if (reference instanceof FieldReference) {
            return internFieldReference((FieldReference) reference);
        }
        if (reference instanceof MethodProtoReference) {
            return internMethodProtoReference((MethodProtoReference) reference);
        }
        if (reference instanceof CallSiteReference) {
            return internCallSite((CallSiteReference) reference);
        }
        if (reference instanceof MethodHandleReference) {
            return internMethodHandle((MethodHandleReference) reference);
        }
        throw new IllegalArgumentException("Could not determine type of reference");
    }

    public final BuilderEncodedValues.BuilderStringEncodedValue internStringEncodedValue(StringEncodedValue stringEncodedValue) {
        return new BuilderEncodedValues.BuilderStringEncodedValue(((BuilderStringPool) this.stringSection).internString(stringEncodedValue.getValue()));
    }

    public BuilderStringReference internStringReference(String str) {
        return ((BuilderStringPool) this.stringSection).internString(str);
    }

    public final BuilderEncodedValues.BuilderTypeEncodedValue internTypeEncodedValue(TypeEncodedValue typeEncodedValue) {
        return new BuilderEncodedValues.BuilderTypeEncodedValue(((BuilderTypePool) this.typeSection).internType(typeEncodedValue.getValue()));
    }

    public BuilderTypeReference internTypeReference(String str) {
        return ((BuilderTypePool) this.typeSection).internType(str);
    }

    @Override // org.p088jf.dexlib2.writer.DexWriter
    public void writeEncodedValue(DexWriter<BuilderStringReference, BuilderStringReference, BuilderTypeReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderFieldReference, BuilderMethodReference, BuilderClassDef, BuilderCallSiteReference, BuilderMethodHandleReference, BuilderAnnotation, BuilderAnnotationSet, BuilderTypeList, BuilderField, BuilderMethod, BuilderEncodedValues.BuilderArrayEncodedValue, BuilderEncodedValues.BuilderEncodedValue, BuilderAnnotationElement, BuilderStringPool, BuilderTypePool, BuilderProtoPool, BuilderFieldPool, BuilderMethodPool, BuilderClassPool, BuilderCallSitePool, BuilderMethodHandlePool, BuilderTypeListPool, BuilderAnnotationPool, BuilderAnnotationSetPool, BuilderEncodedArrayPool>.InternalEncodedValueWriter internalEncodedValueWriter, BuilderEncodedValues.BuilderEncodedValue builderEncodedValue) throws IOException {
        int valueType = builderEncodedValue.getValueType();
        if (valueType == 0) {
            internalEncodedValueWriter.writeByte(((ByteEncodedValue) builderEncodedValue).getValue());
            return;
        }
        if (valueType == 6) {
            internalEncodedValueWriter.writeLong(((LongEncodedValue) builderEncodedValue).getValue());
            return;
        }
        if (valueType == 2) {
            internalEncodedValueWriter.writeShort(((ShortEncodedValue) builderEncodedValue).getValue());
            return;
        }
        if (valueType == 3) {
            internalEncodedValueWriter.writeChar(((CharEncodedValue) builderEncodedValue).getValue());
            return;
        }
        if (valueType == 4) {
            internalEncodedValueWriter.writeInt(((IntEncodedValue) builderEncodedValue).getValue());
            return;
        }
        if (valueType == 16) {
            internalEncodedValueWriter.writeFloat(((FloatEncodedValue) builderEncodedValue).getValue());
            return;
        }
        if (valueType == 17) {
            internalEncodedValueWriter.writeDouble(((DoubleEncodedValue) builderEncodedValue).getValue());
            return;
        }
        switch (valueType) {
            case 21:
                internalEncodedValueWriter.writeMethodType(((BuilderEncodedValues.BuilderMethodTypeEncodedValue) builderEncodedValue).methodProtoReference);
                return;
            case 22:
                internalEncodedValueWriter.writeMethodHandle(((BuilderEncodedValues.BuilderMethodHandleEncodedValue) builderEncodedValue).methodHandleReference);
                return;
            case 23:
                internalEncodedValueWriter.writeString(((BuilderEncodedValues.BuilderStringEncodedValue) builderEncodedValue).stringReference);
                return;
            case 24:
                internalEncodedValueWriter.writeType(((BuilderEncodedValues.BuilderTypeEncodedValue) builderEncodedValue).typeReference);
                return;
            case 25:
                internalEncodedValueWriter.writeField(((BuilderEncodedValues.BuilderFieldEncodedValue) builderEncodedValue).fieldReference);
                return;
            case 26:
                internalEncodedValueWriter.writeMethod(((BuilderEncodedValues.BuilderMethodEncodedValue) builderEncodedValue).methodReference);
                return;
            case 27:
                internalEncodedValueWriter.writeEnum(((BuilderEncodedValues.BuilderEnumEncodedValue) builderEncodedValue).getValue());
                return;
            case 28:
                internalEncodedValueWriter.writeArray(((BuilderEncodedValues.BuilderArrayEncodedValue) builderEncodedValue).elements);
                return;
            case 29:
                BuilderEncodedValues.BuilderAnnotationEncodedValue builderAnnotationEncodedValue = (BuilderEncodedValues.BuilderAnnotationEncodedValue) builderEncodedValue;
                internalEncodedValueWriter.writeAnnotation(builderAnnotationEncodedValue.typeReference, builderAnnotationEncodedValue.elements);
                return;
            case 30:
                internalEncodedValueWriter.writeNull();
                return;
            case 31:
                internalEncodedValueWriter.writeBoolean(((BooleanEncodedValue) builderEncodedValue).getValue());
                return;
            default:
                throw new ExceptionWithContext("Unrecognized value type: %d", Integer.valueOf(builderEncodedValue.getValueType()));
        }
    }
}
