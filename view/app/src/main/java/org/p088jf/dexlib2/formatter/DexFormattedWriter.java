package org.p088jf.dexlib2.formatter;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import org.p088jf.dexlib2.MethodHandleType;
import org.p088jf.dexlib2.iface.AnnotationElement;
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

/* JADX INFO: loaded from: classes.dex */
public class DexFormattedWriter extends Writer {
    public final Writer writer;

    public DexFormattedWriter(Writer writer) {
        this.writer = writer;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        return this.writer.append(c);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        return this.writer.append(charSequence);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) throws IOException {
        return this.writer.append(charSequence, i, i2);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.writer.close();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.writer.flush();
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        this.writer.write(i);
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        this.writer.write(str);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        this.writer.write(str, i, i2);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        this.writer.write(cArr);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        this.writer.write(cArr, i, i2);
    }

    public void writeAnnotation(AnnotationEncodedValue annotationEncodedValue) throws IOException {
        this.writer.write("Annotation[");
        writeType(annotationEncodedValue.getType());
        for (AnnotationElement annotationElement : annotationEncodedValue.getElements()) {
            this.writer.write(", ");
            writeSimpleName(annotationElement.getName());
            this.writer.write(61);
            writeEncodedValue(annotationElement.getValue());
        }
        this.writer.write(93);
    }

    public void writeArray(ArrayEncodedValue arrayEncodedValue) throws IOException {
        this.writer.write("Array[");
        boolean z = true;
        for (EncodedValue encodedValue : arrayEncodedValue.getValue()) {
            if (z) {
                z = false;
            } else {
                this.writer.write(", ");
            }
            writeEncodedValue(encodedValue);
        }
        this.writer.write(93);
    }

    public void writeCallSite(CallSiteReference callSiteReference) throws IOException {
        writeSimpleName(callSiteReference.getName());
        this.writer.write(40);
        writeQuotedString(callSiteReference.getMethodName());
        this.writer.write(", ");
        writeMethodProtoDescriptor(callSiteReference.getMethodProto());
        for (EncodedValue encodedValue : callSiteReference.getExtraArguments()) {
            this.writer.write(", ");
            writeEncodedValue(encodedValue);
        }
        this.writer.write(")@");
        if (callSiteReference.getMethodHandle().getMethodHandleType() != 4) {
            throw new IllegalArgumentException("The linker method handle for a call site must be of type invoke-static");
        }
        writeMethodDescriptor((MethodReference) callSiteReference.getMethodHandle().getMemberReference());
    }

    public void writeClass(CharSequence charSequence) throws IOException {
        this.writer.write(charSequence.charAt(0));
        int i = 1;
        int i2 = 1;
        while (true) {
            if (i >= charSequence.length()) {
                break;
            }
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == '/') {
                if (i == i2) {
                    throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
                }
                writeSimpleName(charSequence.subSequence(i2, i));
                this.writer.write(charSequence.charAt(i));
                i2 = i + 1;
            } else if (cCharAt == ';') {
                if (i == i2) {
                    throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
                }
                writeSimpleName(charSequence.subSequence(i2, i));
                this.writer.write(charSequence.charAt(i));
            }
            i++;
        }
        if (i != charSequence.length() - 1 || charSequence.charAt(i) != ';') {
            throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
        }
    }

    public void writeEncodedValue(EncodedValue encodedValue) throws IOException {
        int valueType = encodedValue.getValueType();
        if (valueType == 0) {
            this.writer.write(String.format("0x%x", Byte.valueOf(((ByteEncodedValue) encodedValue).getValue())));
            return;
        }
        if (valueType == 6) {
            this.writer.write(String.format("0x%x", Long.valueOf(((LongEncodedValue) encodedValue).getValue())));
            return;
        }
        if (valueType == 2) {
            this.writer.write(String.format("0x%x", Short.valueOf(((ShortEncodedValue) encodedValue).getValue())));
            return;
        }
        if (valueType == 3) {
            this.writer.write(String.format("0x%x", Integer.valueOf(((CharEncodedValue) encodedValue).getValue())));
            return;
        }
        if (valueType == 4) {
            this.writer.write(String.format("0x%x", Integer.valueOf(((IntEncodedValue) encodedValue).getValue())));
            return;
        }
        if (valueType == 16) {
            this.writer.write(Float.toString(((FloatEncodedValue) encodedValue).getValue()));
            return;
        }
        if (valueType == 17) {
            this.writer.write(Double.toString(((DoubleEncodedValue) encodedValue).getValue()));
            return;
        }
        switch (valueType) {
            case 21:
                writeMethodProtoDescriptor(((MethodTypeEncodedValue) encodedValue).getValue());
                return;
            case 22:
                writeMethodHandle(((MethodHandleEncodedValue) encodedValue).getValue());
                return;
            case 23:
                writeQuotedString(((StringEncodedValue) encodedValue).getValue());
                return;
            case 24:
                writeType(((TypeEncodedValue) encodedValue).getValue());
                return;
            case 25:
                writeFieldDescriptor(((FieldEncodedValue) encodedValue).getValue());
                return;
            case 26:
                writeMethodDescriptor(((MethodEncodedValue) encodedValue).getValue());
                return;
            case 27:
                writeFieldDescriptor(((EnumEncodedValue) encodedValue).getValue());
                return;
            case 28:
                writeArray((ArrayEncodedValue) encodedValue);
                return;
            case 29:
                writeAnnotation((AnnotationEncodedValue) encodedValue);
                return;
            case 30:
                this.writer.write("null");
                return;
            case 31:
                this.writer.write(Boolean.toString(((BooleanEncodedValue) encodedValue).getValue()));
                return;
            default:
                throw new IllegalArgumentException("Unknown encoded value type");
        }
    }

    public void writeFieldDescriptor(FieldReference fieldReference) throws IOException {
        writeType(fieldReference.getDefiningClass());
        this.writer.write("->");
        writeSimpleName(fieldReference.getName());
        this.writer.write(58);
        writeType(fieldReference.getType());
    }

    public void writeMethodDescriptor(MethodReference methodReference) throws IOException {
        writeType(methodReference.getDefiningClass());
        this.writer.write("->");
        writeSimpleName(methodReference.getName());
        this.writer.write(40);
        Iterator<? extends CharSequence> it = methodReference.getParameterTypes().iterator();
        while (it.hasNext()) {
            writeType(it.next());
        }
        this.writer.write(41);
        writeType(methodReference.getReturnType());
    }

    public void writeMethodHandle(MethodHandleReference methodHandleReference) throws IOException {
        this.writer.write(MethodHandleType.toString(methodHandleReference.getMethodHandleType()));
        this.writer.write(64);
        Reference memberReference = methodHandleReference.getMemberReference();
        if (memberReference instanceof MethodReference) {
            writeMethodDescriptor((MethodReference) memberReference);
        } else {
            writeFieldDescriptor((FieldReference) memberReference);
        }
    }

    public void writeMethodProtoDescriptor(MethodProtoReference methodProtoReference) throws IOException {
        this.writer.write(40);
        Iterator<? extends CharSequence> it = methodProtoReference.getParameterTypes().iterator();
        while (it.hasNext()) {
            writeType(it.next());
        }
        this.writer.write(41);
        writeType(methodProtoReference.getReturnType());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeQuotedString(java.lang.CharSequence r7) throws java.io.IOException {
        /*
            r6 = this;
            java.io.Writer r0 = r6.writer
            r1 = 34
            r0.write(r1)
            java.lang.String r7 = r7.toString()
            r0 = 0
        Lc:
            int r2 = r7.length()
            if (r0 >= r2) goto L97
            char r2 = r7.charAt(r0)
            r3 = 32
            r4 = 127(0x7f, float:1.78E-43)
            if (r2 < r3) goto L33
            if (r2 >= r4) goto L33
            r3 = 39
            r4 = 92
            if (r2 == r3) goto L28
            if (r2 == r1) goto L28
            if (r2 != r4) goto L2d
        L28:
            java.io.Writer r3 = r6.writer
            r3.write(r4)
        L2d:
            java.io.Writer r3 = r6.writer
            r3.write(r2)
            goto L93
        L33:
            if (r2 > r4) goto L5a
            r3 = 9
            if (r2 == r3) goto L52
            r3 = 10
            if (r2 == r3) goto L4a
            r3 = 13
            if (r2 == r3) goto L42
            goto L5a
        L42:
            java.io.Writer r2 = r6.writer
            java.lang.String r3 = "\\r"
            r2.write(r3)
            goto L93
        L4a:
            java.io.Writer r2 = r6.writer
            java.lang.String r3 = "\\n"
            r2.write(r3)
            goto L93
        L52:
            java.io.Writer r2 = r6.writer
            java.lang.String r3 = "\\t"
            r2.write(r3)
            goto L93
        L5a:
            java.io.Writer r3 = r6.writer
            java.lang.String r4 = "\\u"
            r3.write(r4)
            java.io.Writer r3 = r6.writer
            int r4 = r2 >> 12
            r5 = 16
            char r4 = java.lang.Character.forDigit(r4, r5)
            r3.write(r4)
            java.io.Writer r3 = r6.writer
            int r4 = r2 >> 8
            r4 = r4 & 15
            char r4 = java.lang.Character.forDigit(r4, r5)
            r3.write(r4)
            java.io.Writer r3 = r6.writer
            int r4 = r2 >> 4
            r4 = r4 & 15
            char r4 = java.lang.Character.forDigit(r4, r5)
            r3.write(r4)
            java.io.Writer r3 = r6.writer
            r2 = r2 & 15
            char r2 = java.lang.Character.forDigit(r2, r5)
            r3.write(r2)
        L93:
            int r0 = r0 + 1
            goto Lc
        L97:
            java.io.Writer r7 = r6.writer
            r7.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p088jf.dexlib2.formatter.DexFormattedWriter.writeQuotedString(java.lang.CharSequence):void");
    }

    public void writeReference(Reference reference) throws IOException {
        if (reference instanceof StringReference) {
            writeQuotedString((StringReference) reference);
            return;
        }
        if (reference instanceof TypeReference) {
            writeType((TypeReference) reference);
            return;
        }
        if (reference instanceof FieldReference) {
            writeFieldDescriptor((FieldReference) reference);
            return;
        }
        if (reference instanceof MethodReference) {
            writeMethodDescriptor((MethodReference) reference);
            return;
        }
        if (reference instanceof MethodProtoReference) {
            writeMethodProtoDescriptor((MethodProtoReference) reference);
        } else if (reference instanceof MethodHandleReference) {
            writeMethodHandle((MethodHandleReference) reference);
        } else {
            if (!(reference instanceof CallSiteReference)) {
                throw new IllegalArgumentException(String.format("Not a known reference type: %s", reference.getClass()));
            }
            writeCallSite((CallSiteReference) reference);
        }
    }

    public void writeShortFieldDescriptor(FieldReference fieldReference) throws IOException {
        writeSimpleName(fieldReference.getName());
        this.writer.write(58);
        writeType(fieldReference.getType());
    }

    public void writeShortMethodDescriptor(MethodReference methodReference) throws IOException {
        writeSimpleName(methodReference.getName());
        this.writer.write(40);
        Iterator<? extends CharSequence> it = methodReference.getParameterTypes().iterator();
        while (it.hasNext()) {
            writeType(it.next());
        }
        this.writer.write(41);
        writeType(methodReference.getReturnType());
    }

    public void writeSimpleName(CharSequence charSequence) throws IOException {
        this.writer.append(charSequence);
    }

    public void writeType(CharSequence charSequence) throws IOException {
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == 'L') {
                writeClass(charSequence.subSequence(i, charSequence.length()));
                return;
            }
            if (cCharAt != '[') {
                if (cCharAt != 'Z' && cCharAt != 'B' && cCharAt != 'S' && cCharAt != 'C' && cCharAt != 'I' && cCharAt != 'J' && cCharAt != 'F' && cCharAt != 'D' && cCharAt != 'V') {
                    throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
                }
                this.writer.write(cCharAt);
                if (i != charSequence.length() - 1) {
                    throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
                }
                return;
            }
            this.writer.write(cCharAt);
        }
        throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
    }
}
