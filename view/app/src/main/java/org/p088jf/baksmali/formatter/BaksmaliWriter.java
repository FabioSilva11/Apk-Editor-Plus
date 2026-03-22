package org.p088jf.baksmali.formatter;

import android.support.v7.appcompat.C0299R;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import org.p088jf.dexlib2.formatter.DexFormattedWriter;
import org.p088jf.dexlib2.iface.AnnotationElement;
import org.p088jf.dexlib2.iface.reference.CallSiteReference;
import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
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
import org.p088jf.util.IndentingWriter;

/* JADX INFO: loaded from: classes.dex */
public class BaksmaliWriter extends DexFormattedWriter {
    public final char[] buffer;
    public final String classContext;

    public BaksmaliWriter(Writer writer, String str) {
        super(writer instanceof IndentingWriter ? writer : new IndentingWriter(writer));
        this.buffer = new char[24];
        this.classContext = str;
    }

    public void deindent(int i) {
        ((IndentingWriter) this.writer).deindent(i);
    }

    public void indent(int i) {
        ((IndentingWriter) this.writer).indent(i);
    }

    public IndentingWriter indentingWriter() {
        return (IndentingWriter) this.writer;
    }

    @Override // org.p088jf.dexlib2.formatter.DexFormattedWriter
    public void writeAnnotation(AnnotationEncodedValue annotationEncodedValue) throws IOException {
        this.writer.write(".subannotation ");
        writeType(annotationEncodedValue.getType());
        this.writer.write(10);
        writeAnnotationElements(annotationEncodedValue.getElements());
        this.writer.write(".end subannotation");
    }

    public void writeAnnotationElements(Collection<? extends AnnotationElement> collection) throws IOException {
        indent(4);
        for (AnnotationElement annotationElement : collection) {
            writeSimpleName(annotationElement.getName());
            this.writer.write(" = ");
            writeEncodedValue(annotationElement.getValue());
            this.writer.write(10);
        }
        deindent(4);
    }

    @Override // org.p088jf.dexlib2.formatter.DexFormattedWriter
    public void writeArray(ArrayEncodedValue arrayEncodedValue) throws IOException {
        this.writer.write(123);
        List<? extends EncodedValue> value = arrayEncodedValue.getValue();
        if (value.size() == 0) {
            this.writer.write(125);
            return;
        }
        this.writer.write(10);
        indent(4);
        boolean z = true;
        for (EncodedValue encodedValue : value) {
            if (!z) {
                this.writer.write(",\n");
            }
            z = false;
            writeEncodedValue(encodedValue);
        }
        deindent(4);
        this.writer.write("\n}");
    }

    public void writeBooleanEncodedValue(BooleanEncodedValue booleanEncodedValue) throws IOException {
        this.writer.write(Boolean.toString(booleanEncodedValue.getValue()));
    }

    @Override // org.p088jf.dexlib2.formatter.DexFormattedWriter
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

    public void writeCharEncodedValue(CharEncodedValue charEncodedValue) throws IOException {
        char value = charEncodedValue.getValue();
        if (value >= ' ' && value < 127) {
            this.writer.write(39);
            if (value == '\'' || value == '\"' || value == '\\') {
                this.writer.write(92);
            }
            this.writer.write(value);
            this.writer.write(39);
            return;
        }
        if (value <= 127) {
            if (value == '\t') {
                this.writer.write("'\\t'");
                return;
            } else if (value == '\n') {
                this.writer.write("'\\n'");
                return;
            } else if (value == '\r') {
                this.writer.write("'\\r'");
                return;
            }
        }
        this.writer.write(39);
        this.writer.write("\\u");
        this.writer.write(Character.forDigit(value >> '\f', 16));
        this.writer.write(Character.forDigit((value >> '\b') & 15, 16));
        this.writer.write(Character.forDigit((value >> 4) & 15, 16));
        this.writer.write(Character.forDigit(value & 15, 16));
        this.writer.write(39);
    }

    @Override // org.p088jf.dexlib2.formatter.DexFormattedWriter
    public void writeClass(CharSequence charSequence) throws IOException {
        this.writer.write(charSequence.charAt(0));
        int i = 1;
        int i2 = 1;
        boolean z = false;
        while (true) {
            if (i >= charSequence.length()) {
                break;
            }
            char cCharAt = charSequence.charAt(i);
            if (Character.getType(cCharAt) == 12) {
                z = true;
            } else if (cCharAt == '/') {
                if (i == i2) {
                    throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
                }
                writeSimpleName(charSequence.subSequence(i2, i), z);
                this.writer.write(charSequence.charAt(i));
                i2 = i + 1;
                z = false;
            } else if (cCharAt == ';') {
                if (i == i2) {
                    throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
                }
                writeSimpleName(charSequence.subSequence(i2, i), z);
                this.writer.write(charSequence.charAt(i));
            }
            i++;
        }
        if (i != charSequence.length() - 1 || charSequence.charAt(i) != ';') {
            throw new IllegalArgumentException(String.format("Invalid type string: %s", charSequence));
        }
    }

    public void writeDoubleEncodedValue(DoubleEncodedValue doubleEncodedValue) throws IOException {
        this.writer.write(Double.toString(doubleEncodedValue.getValue()));
    }

    @Override // org.p088jf.dexlib2.formatter.DexFormattedWriter
    public void writeEncodedValue(EncodedValue encodedValue) throws IOException {
        int valueType = encodedValue.getValueType();
        if (valueType == 0) {
            writeIntegralValue(((ByteEncodedValue) encodedValue).getValue(), 't');
            return;
        }
        if (valueType == 6) {
            writeIntegralValue(((LongEncodedValue) encodedValue).getValue(), 'L');
            return;
        }
        if (valueType == 2) {
            writeIntegralValue(((ShortEncodedValue) encodedValue).getValue(), 's');
            return;
        }
        if (valueType == 3) {
            writeCharEncodedValue((CharEncodedValue) encodedValue);
            return;
        }
        if (valueType == 4) {
            writeIntegralValue(((IntEncodedValue) encodedValue).getValue(), null);
            return;
        }
        if (valueType == 16) {
            writeFloatEncodedValue((FloatEncodedValue) encodedValue);
            return;
        }
        if (valueType == 17) {
            writeDoubleEncodedValue((DoubleEncodedValue) encodedValue);
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
                writeEnum((EnumEncodedValue) encodedValue);
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
                writeBooleanEncodedValue((BooleanEncodedValue) encodedValue);
                return;
            default:
                throw new IllegalArgumentException("Unknown encoded value type");
        }
    }

    public void writeEnum(EnumEncodedValue enumEncodedValue) throws IOException {
        this.writer.write(".enum ");
        writeFieldDescriptor(enumEncodedValue.getValue());
    }

    @Override // org.p088jf.dexlib2.formatter.DexFormattedWriter
    public void writeFieldDescriptor(FieldReference fieldReference) throws IOException {
        if (fieldReference.getDefiningClass().equals(this.classContext)) {
            writeShortFieldDescriptor(fieldReference);
        } else {
            super.writeFieldDescriptor(fieldReference);
        }
    }

    public void writeFloatEncodedValue(FloatEncodedValue floatEncodedValue) throws IOException {
        this.writer.write(Float.toString(floatEncodedValue.getValue()));
        this.writer.write(C0299R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle);
    }

    public void writeIntegralValue(long j, Character ch) throws IOException {
        if (j < 0) {
            this.writer.write("-0x");
            writeUnsignedLongAsHex(-j);
        } else {
            this.writer.write("0x");
            writeUnsignedLongAsHex(j);
        }
        if (ch != null) {
            this.writer.write(ch.charValue());
        }
    }

    @Override // org.p088jf.dexlib2.formatter.DexFormattedWriter
    public void writeMethodDescriptor(MethodReference methodReference) throws IOException {
        if (methodReference.getDefiningClass().equals(this.classContext)) {
            writeShortMethodDescriptor(methodReference);
        } else {
            super.writeMethodDescriptor(methodReference);
        }
    }

    public void writeSignedIntAsDec(int i) throws IOException {
        if (i < 0) {
            write(45);
        }
        int i2 = 15;
        while (true) {
            int iAbs = Math.abs(i % 10);
            char[] cArr = this.buffer;
            int i3 = i2 - 1;
            cArr[i2] = (char) (iAbs + 48);
            i /= 10;
            if (i == 0) {
                int i4 = i3 + 1;
                write(cArr, i4, 16 - i4);
                return;
            }
            i2 = i3;
        }
    }

    public void writeSignedIntOrLongTo(long j) throws IOException {
        if (j < 0) {
            this.writer.write("-0x");
            writeUnsignedLongAsHex(-j);
            if (j < -2147483648L) {
                this.writer.write(76);
                return;
            }
            return;
        }
        this.writer.write("0x");
        writeUnsignedLongAsHex(j);
        if (j > 2147483647L) {
            this.writer.write(76);
        }
    }

    public void writeSignedLongAsDec(long j) throws IOException {
        if (j < 0) {
            write(45);
        }
        int i = 23;
        while (true) {
            long jAbs = Math.abs(j % 10);
            char[] cArr = this.buffer;
            int i2 = i - 1;
            cArr[i] = (char) (jAbs + 48);
            j /= 10;
            if (j == 0) {
                int i3 = i2 + 1;
                write(cArr, i3, 24 - i3);
                return;
            }
            i = i2;
        }
    }

    @Override // org.p088jf.dexlib2.formatter.DexFormattedWriter
    public void writeSimpleName(CharSequence charSequence) throws IOException {
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= charSequence.length()) {
                break;
            }
            if (Character.getType(charSequence.charAt(i)) == 12) {
                z = true;
                break;
            }
            i++;
        }
        writeSimpleName(charSequence, z);
    }

    public void writeSimpleName(CharSequence charSequence, boolean z) throws IOException {
        if (z) {
            this.writer.write(96);
        }
        this.writer.append(charSequence);
        if (z) {
            this.writer.write(96);
        }
    }

    public void writeUnsignedIntAsDec(int i) throws IOException {
        if (i < 0) {
            writeSignedLongAsDec(((long) i) & 4294967295L);
        } else {
            writeSignedIntAsDec(i);
        }
    }

    public void writeUnsignedLongAsHex(long j) throws IOException {
        int i;
        int i2 = 23;
        do {
            int i3 = (int) (15 & j);
            if (i3 < 10) {
                i = i2 - 1;
                this.buffer[i2] = (char) (i3 + 48);
            } else {
                i = i2 - 1;
                this.buffer[i2] = (char) ((i3 - 10) + 97);
            }
            i2 = i;
            j >>>= 4;
        } while (j != 0);
        int i4 = i2 + 1;
        write(this.buffer, i4, 24 - i4);
    }
}
