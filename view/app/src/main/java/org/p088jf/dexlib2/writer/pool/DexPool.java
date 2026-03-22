package org.p088jf.dexlib2.writer.pool;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.p088jf.dexlib2.Opcodes;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.AnnotationElement;
import org.p088jf.dexlib2.iface.ClassDef;
import org.p088jf.dexlib2.iface.DexFile;
import org.p088jf.dexlib2.iface.Field;
import org.p088jf.dexlib2.iface.reference.CallSiteReference;
import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.iface.reference.MethodHandleReference;
import org.p088jf.dexlib2.iface.reference.MethodProtoReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
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
import org.p088jf.dexlib2.writer.DexWriter;
import org.p088jf.dexlib2.writer.p089io.FileDataStore;
import org.p088jf.dexlib2.writer.pool.TypeListPool;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class DexPool extends DexWriter<CharSequence, StringReference, CharSequence, TypeReference, MethodProtoReference, FieldReference, MethodReference, PoolClassDef, CallSiteReference, MethodHandleReference, Annotation, Set<? extends Annotation>, TypeListPool.Key<? extends Collection<? extends CharSequence>>, Field, PoolMethod, ArrayEncodedValue, EncodedValue, AnnotationElement, StringPool, TypePool, ProtoPool, FieldPool, MethodPool, ClassPool, CallSitePool, MethodHandlePool, TypeListPool, AnnotationPool, AnnotationSetPool, EncodedArrayPool> {

    public class DexPoolSectionProvider extends DexWriter<CharSequence, StringReference, CharSequence, TypeReference, MethodProtoReference, FieldReference, MethodReference, PoolClassDef, CallSiteReference, MethodHandleReference, Annotation, Set<? extends Annotation>, TypeListPool.Key<? extends Collection<? extends CharSequence>>, Field, PoolMethod, ArrayEncodedValue, EncodedValue, AnnotationElement, StringPool, TypePool, ProtoPool, FieldPool, MethodPool, ClassPool, CallSitePool, MethodHandlePool, TypeListPool, AnnotationPool, AnnotationSetPool, EncodedArrayPool>.SectionProvider {
        public DexPoolSectionProvider() {
            super(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public AnnotationPool getAnnotationSection() {
            return new AnnotationPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public AnnotationSetPool getAnnotationSetSection() {
            return new AnnotationSetPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public CallSitePool getCallSiteSection() {
            return new CallSitePool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public ClassPool getClassSection() {
            return new ClassPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public EncodedArrayPool getEncodedArraySection() {
            return new EncodedArrayPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public FieldPool getFieldSection() {
            return new FieldPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public MethodHandlePool getMethodHandleSection() {
            return new MethodHandlePool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public MethodPool getMethodSection() {
            return new MethodPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public ProtoPool getProtoSection() {
            return new ProtoPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public StringPool getStringSection() {
            return new StringPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public TypeListPool getTypeListSection() {
            return new TypeListPool(DexPool.this);
        }

        @Override // org.jf.dexlib2.writer.DexWriter.SectionProvider
        public TypePool getTypeSection() {
            return new TypePool(DexPool.this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DexPool(Opcodes opcodes) {
        super(opcodes);
    }

    public static void writeTo(String str, DexFile dexFile) throws IOException {
        DexPool dexPool = new DexPool(dexFile.getOpcodes());
        Iterator<? extends ClassDef> it = dexFile.getClasses().iterator();
        while (it.hasNext()) {
            dexPool.internClass(it.next());
        }
        dexPool.writeTo(new FileDataStore(new File(str)));
    }

    @Override // org.p088jf.dexlib2.writer.DexWriter
    public DexWriter<CharSequence, StringReference, CharSequence, TypeReference, MethodProtoReference, FieldReference, MethodReference, PoolClassDef, CallSiteReference, MethodHandleReference, Annotation, Set<? extends Annotation>, TypeListPool.Key<? extends Collection<? extends CharSequence>>, Field, PoolMethod, ArrayEncodedValue, EncodedValue, AnnotationElement, StringPool, TypePool, ProtoPool, FieldPool, MethodPool, ClassPool, CallSitePool, MethodHandlePool, TypeListPool, AnnotationPool, AnnotationSetPool, EncodedArrayPool>.SectionProvider getSectionProvider() {
        return new DexPoolSectionProvider();
    }

    public void internClass(ClassDef classDef) {
        ((ClassPool) this.classSection).intern(classDef);
    }

    public void internEncodedValue(EncodedValue encodedValue) {
        switch (encodedValue.getValueType()) {
            case 21:
                ((ProtoPool) this.protoSection).intern(((MethodTypeEncodedValue) encodedValue).getValue());
                break;
            case 22:
                ((MethodHandlePool) this.methodHandleSection).intern(((MethodHandleEncodedValue) encodedValue).getValue());
                break;
            case 23:
                ((StringPool) this.stringSection).intern(((StringEncodedValue) encodedValue).getValue());
                break;
            case 24:
                ((TypePool) this.typeSection).intern(((TypeEncodedValue) encodedValue).getValue());
                break;
            case 25:
                ((FieldPool) this.fieldSection).intern(((FieldEncodedValue) encodedValue).getValue());
                break;
            case 26:
                ((MethodPool) this.methodSection).intern(((MethodEncodedValue) encodedValue).getValue());
                break;
            case 27:
                ((FieldPool) this.fieldSection).intern(((EnumEncodedValue) encodedValue).getValue());
                break;
            case 28:
                Iterator<? extends EncodedValue> it = ((ArrayEncodedValue) encodedValue).getValue().iterator();
                while (it.hasNext()) {
                    internEncodedValue(it.next());
                }
                break;
            case 29:
                AnnotationEncodedValue annotationEncodedValue = (AnnotationEncodedValue) encodedValue;
                ((TypePool) this.typeSection).intern(annotationEncodedValue.getType());
                for (AnnotationElement annotationElement : annotationEncodedValue.getElements()) {
                    ((StringPool) this.stringSection).intern(annotationElement.getName());
                    internEncodedValue(annotationElement.getValue());
                }
                break;
        }
    }

    @Override // org.p088jf.dexlib2.writer.DexWriter
    public void writeEncodedValue(DexWriter<CharSequence, StringReference, CharSequence, TypeReference, MethodProtoReference, FieldReference, MethodReference, PoolClassDef, CallSiteReference, MethodHandleReference, Annotation, Set<? extends Annotation>, TypeListPool.Key<? extends Collection<? extends CharSequence>>, Field, PoolMethod, ArrayEncodedValue, EncodedValue, AnnotationElement, StringPool, TypePool, ProtoPool, FieldPool, MethodPool, ClassPool, CallSitePool, MethodHandlePool, TypeListPool, AnnotationPool, AnnotationSetPool, EncodedArrayPool>.InternalEncodedValueWriter internalEncodedValueWriter, EncodedValue encodedValue) throws IOException {
        int valueType = encodedValue.getValueType();
        if (valueType == 0) {
            internalEncodedValueWriter.writeByte(((ByteEncodedValue) encodedValue).getValue());
            return;
        }
        if (valueType == 6) {
            internalEncodedValueWriter.writeLong(((LongEncodedValue) encodedValue).getValue());
            return;
        }
        if (valueType == 2) {
            internalEncodedValueWriter.writeShort(((ShortEncodedValue) encodedValue).getValue());
            return;
        }
        if (valueType == 3) {
            internalEncodedValueWriter.writeChar(((CharEncodedValue) encodedValue).getValue());
            return;
        }
        if (valueType == 4) {
            internalEncodedValueWriter.writeInt(((IntEncodedValue) encodedValue).getValue());
            return;
        }
        if (valueType == 16) {
            internalEncodedValueWriter.writeFloat(((FloatEncodedValue) encodedValue).getValue());
            return;
        }
        if (valueType == 17) {
            internalEncodedValueWriter.writeDouble(((DoubleEncodedValue) encodedValue).getValue());
            return;
        }
        switch (valueType) {
            case 21:
                internalEncodedValueWriter.writeMethodType(((MethodTypeEncodedValue) encodedValue).getValue());
                return;
            case 22:
                internalEncodedValueWriter.writeMethodHandle(((MethodHandleEncodedValue) encodedValue).getValue());
                return;
            case 23:
                internalEncodedValueWriter.writeString(((StringEncodedValue) encodedValue).getValue());
                return;
            case 24:
                internalEncodedValueWriter.writeType(((TypeEncodedValue) encodedValue).getValue());
                return;
            case 25:
                internalEncodedValueWriter.writeField(((FieldEncodedValue) encodedValue).getValue());
                return;
            case 26:
                internalEncodedValueWriter.writeMethod(((MethodEncodedValue) encodedValue).getValue());
                return;
            case 27:
                internalEncodedValueWriter.writeEnum(((EnumEncodedValue) encodedValue).getValue());
                return;
            case 28:
                internalEncodedValueWriter.writeArray(((ArrayEncodedValue) encodedValue).getValue());
                return;
            case 29:
                AnnotationEncodedValue annotationEncodedValue = (AnnotationEncodedValue) encodedValue;
                internalEncodedValueWriter.writeAnnotation(annotationEncodedValue.getType(), annotationEncodedValue.getElements());
                return;
            case 30:
                internalEncodedValueWriter.writeNull();
                return;
            case 31:
                internalEncodedValueWriter.writeBoolean(((BooleanEncodedValue) encodedValue).getValue());
                return;
            default:
                throw new ExceptionWithContext("Unrecognized value type: %d", Integer.valueOf(encodedValue.getValueType()));
        }
    }
}
