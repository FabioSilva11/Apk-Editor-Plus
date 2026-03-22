package org.p088jf.dexlib2.writer;

import com.google.common.collect.Ordering;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.p088jf.dexlib2.base.BaseAnnotationElement;
import org.p088jf.dexlib2.iface.AnnotationElement;
import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.iface.reference.MethodHandleReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class EncodedValueWriter<StringKey, TypeKey, FieldRefKey extends FieldReference, MethodRefKey extends MethodReference, AnnotationElement extends AnnotationElement, ProtoRefKey, MethodHandleKey extends MethodHandleReference, EncodedValue> {
    public final AnnotationSection<StringKey, TypeKey, ?, AnnotationElement, EncodedValue> annotationSection;
    public final FieldSection<?, ?, FieldRefKey, ?> fieldSection;
    public final MethodHandleSection<MethodHandleKey, ?, ?> methodHandleSection;
    public final MethodSection<?, ?, ?, MethodRefKey, ?> methodSection;
    public final ProtoSection<?, ?, ProtoRefKey, ?> protoSection;
    public final StringSection<StringKey, ?> stringSection;
    public final TypeSection<?, TypeKey, ?> typeSection;
    public final DexDataWriter writer;

    public EncodedValueWriter(DexDataWriter dexDataWriter, StringSection<StringKey, ?> stringSection, TypeSection<?, TypeKey, ?> typeSection, FieldSection<?, ?, FieldRefKey, ?> fieldSection, MethodSection<?, ?, ?, MethodRefKey, ?> methodSection, ProtoSection<?, ?, ProtoRefKey, ?> protoSection, MethodHandleSection<MethodHandleKey, ?, ?> methodHandleSection, AnnotationSection<StringKey, TypeKey, ?, AnnotationElement, EncodedValue> annotationSection) {
        this.writer = dexDataWriter;
        this.stringSection = stringSection;
        this.typeSection = typeSection;
        this.fieldSection = fieldSection;
        this.methodSection = methodSection;
        this.protoSection = protoSection;
        this.methodHandleSection = methodHandleSection;
        this.annotationSection = annotationSection;
    }

    public void writeAnnotation(TypeKey typekey, Collection<? extends AnnotationElement> collection) throws IOException {
        this.writer.writeEncodedValueHeader(29, 0);
        this.writer.writeUleb128(this.typeSection.getItemIndex(typekey));
        this.writer.writeUleb128(collection.size());
        for (AnnotationElement annotationElement : Ordering.from(BaseAnnotationElement.BY_NAME).immutableSortedCopy(collection)) {
            this.writer.writeUleb128(this.stringSection.getItemIndex(this.annotationSection.getElementName((AnnotationElement) annotationElement)));
            writeEncodedValue(this.annotationSection.getElementValue((AnnotationElement) annotationElement));
        }
    }

    public void writeArray(Collection<? extends EncodedValue> collection) throws IOException {
        this.writer.writeEncodedValueHeader(28, 0);
        this.writer.writeUleb128(collection.size());
        Iterator<? extends EncodedValue> it = collection.iterator();
        while (it.hasNext()) {
            writeEncodedValue(it.next());
        }
    }

    public void writeBoolean(boolean z) throws IOException {
        this.writer.writeEncodedValueHeader(31, z ? 1 : 0);
    }

    public void writeByte(byte b2) throws IOException {
        this.writer.writeEncodedInt(0, b2);
    }

    public void writeChar(char c) throws IOException {
        this.writer.writeEncodedUint(3, c);
    }

    public void writeDouble(double d) throws IOException {
        this.writer.writeEncodedDouble(17, d);
    }

    public abstract void writeEncodedValue(EncodedValue encodedvalue) throws IOException;

    public void writeEnum(FieldRefKey fieldrefkey) throws IOException {
        this.writer.writeEncodedUint(27, this.fieldSection.getItemIndex(fieldrefkey));
    }

    public void writeField(FieldRefKey fieldrefkey) throws IOException {
        this.writer.writeEncodedUint(25, this.fieldSection.getItemIndex(fieldrefkey));
    }

    public void writeFloat(float f) throws IOException {
        this.writer.writeEncodedFloat(16, f);
    }

    public void writeInt(int i) throws IOException {
        this.writer.writeEncodedInt(4, i);
    }

    public void writeLong(long j) throws IOException {
        this.writer.writeEncodedLong(6, j);
    }

    public void writeMethod(MethodRefKey methodrefkey) throws IOException {
        this.writer.writeEncodedUint(26, this.methodSection.getItemIndex(methodrefkey));
    }

    public void writeMethodHandle(MethodHandleKey methodhandlekey) throws IOException {
        this.writer.writeEncodedUint(22, this.methodHandleSection.getItemIndex(methodhandlekey));
    }

    public void writeMethodType(ProtoRefKey protorefkey) throws IOException {
        this.writer.writeEncodedUint(21, this.protoSection.getItemIndex(protorefkey));
    }

    public void writeNull() throws IOException {
        this.writer.write(30);
    }

    public void writeShort(int i) throws IOException {
        this.writer.writeEncodedInt(2, i);
    }

    public void writeString(StringKey stringkey) throws IOException {
        this.writer.writeEncodedUint(23, this.stringSection.getItemIndex(stringkey));
    }

    public void writeType(TypeKey typekey) throws IOException {
        this.writer.writeEncodedUint(24, this.typeSection.getItemIndex(typekey));
    }
}
