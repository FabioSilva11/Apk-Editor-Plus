package org.p088jf.dexlib2.writer;

import java.io.IOException;
import java.lang.CharSequence;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class DebugWriter<StringKey extends CharSequence, TypeKey extends CharSequence> {
    public int currentAddress;
    public int currentLine;
    public final StringSection<StringKey, ?> stringSection;
    public final TypeSection<StringKey, TypeKey, ?> typeSection;
    public final DexDataWriter writer;

    public DebugWriter(StringSection<StringKey, ?> stringSection, TypeSection<StringKey, TypeKey, ?> typeSection, DexDataWriter dexDataWriter) {
        this.stringSection = stringSection;
        this.typeSection = typeSection;
        this.writer = dexDataWriter;
    }

    public void reset(int i) {
        this.currentAddress = 0;
        this.currentLine = i;
    }

    public final void writeAdvanceLine(int i) throws IOException {
        int i2 = i - this.currentLine;
        if (i2 != 0) {
            this.writer.write(2);
            this.writer.writeSleb128(i2);
            this.currentLine = i;
        }
    }

    public final void writeAdvancePC(int i) throws IOException {
        int i2 = i - this.currentAddress;
        if (i2 > 0) {
            this.writer.write(1);
            this.writer.writeUleb128(i2);
            this.currentAddress = i;
        }
    }

    public void writeEndLocal(int i, int i2) throws IOException {
        writeAdvancePC(i);
        this.writer.write(5);
        this.writer.writeUleb128(i2);
    }

    public void writeEpilogueBegin(int i) throws IOException {
        writeAdvancePC(i);
        this.writer.write(8);
    }

    public void writeLineNumber(int i, int i2) throws IOException {
        int i3 = i2 - this.currentLine;
        int i4 = i - this.currentAddress;
        if (i4 < 0) {
            throw new ExceptionWithContext("debug info items must have non-decreasing code addresses", new Object[0]);
        }
        if (i3 < -4 || i3 > 10) {
            writeAdvanceLine(i2);
            i3 = 0;
        }
        if ((i3 < 2 && i4 > 16) || (i3 > 1 && i4 > 15)) {
            writeAdvancePC(i);
            i4 = 0;
        }
        writeSpecialOpcode(i3, i4);
    }

    public void writePrologueEnd(int i) throws IOException {
        writeAdvancePC(i);
        this.writer.write(7);
    }

    public void writeRestartLocal(int i, int i2) throws IOException {
        writeAdvancePC(i);
        this.writer.write(6);
        this.writer.writeUleb128(i2);
    }

    public void writeSetSourceFile(int i, StringKey stringkey) throws IOException {
        writeAdvancePC(i);
        this.writer.write(9);
        this.writer.writeUleb128(this.stringSection.getNullableItemIndex(stringkey) + 1);
    }

    public final void writeSpecialOpcode(int i, int i2) throws IOException {
        this.writer.write((byte) ((i2 * 15) + 10 + i + 4));
        this.currentLine += i;
        this.currentAddress += i2;
    }

    public void writeStartLocal(int i, int i2, StringKey stringkey, TypeKey typekey, StringKey stringkey2) throws IOException {
        int nullableItemIndex = this.stringSection.getNullableItemIndex(stringkey);
        int nullableItemIndex2 = this.typeSection.getNullableItemIndex(typekey);
        int nullableItemIndex3 = this.stringSection.getNullableItemIndex(stringkey2);
        writeAdvancePC(i);
        if (nullableItemIndex3 == -1) {
            this.writer.write(3);
            this.writer.writeUleb128(i2);
            this.writer.writeUleb128(nullableItemIndex + 1);
            this.writer.writeUleb128(nullableItemIndex2 + 1);
            return;
        }
        this.writer.write(4);
        this.writer.writeUleb128(i2);
        this.writer.writeUleb128(nullableItemIndex + 1);
        this.writer.writeUleb128(nullableItemIndex2 + 1);
        this.writer.writeUleb128(nullableItemIndex3 + 1);
    }
}
