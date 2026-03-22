package org.p088jf.util;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class IndentingWriter extends Writer {
    public static final String newLine = System.getProperty("line.separator");
    public final Writer writer;
    public int indentLevel = 0;
    public boolean beginningOfLine = true;

    public IndentingWriter(Writer writer) {
        this.writer = writer;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        write(charSequence.toString());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) throws IOException {
        write(charSequence.subSequence(i, i2).toString());
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.writer.close();
    }

    public void deindent(int i) {
        int i2 = this.indentLevel - i;
        this.indentLevel = i2;
        if (i2 < 0) {
            this.indentLevel = 0;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.writer.flush();
    }

    public void indent(int i) {
        int i2 = this.indentLevel + i;
        this.indentLevel = i2;
        if (i2 < 0) {
            this.indentLevel = 0;
        }
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        if (i == 10) {
            this.writer.write(newLine);
            this.beginningOfLine = true;
        } else {
            if (this.beginningOfLine) {
                writeIndent();
            }
            this.beginningOfLine = false;
            this.writer.write(i);
        }
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            i = str.indexOf(10, i4);
            if (i == -1 || i >= i3) {
                writeLine(str, i4, i3 - i4);
                return;
            }
            writeLine(str, i4, i - i4);
            this.writer.write(newLine);
            this.beginningOfLine = true;
            i4 = i + 1;
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            if (cArr[i] == '\n') {
                writeLine(cArr, i4, i - i4);
                this.writer.write(newLine);
                this.beginningOfLine = true;
                i4 = i + 1;
                i = i4;
            } else {
                i++;
            }
        }
        writeLine(cArr, i4, i - i4);
    }

    public void writeIndent() throws IOException {
        for (int i = 0; i < this.indentLevel; i++) {
            this.writer.write(32);
        }
    }

    public final void writeLine(String str, int i, int i2) throws IOException {
        if (this.beginningOfLine && i2 > 0) {
            writeIndent();
            this.beginningOfLine = false;
        }
        this.writer.write(str, i, i2);
    }

    public final void writeLine(char[] cArr, int i, int i2) throws IOException {
        if (this.beginningOfLine && i2 > 0) {
            writeIndent();
            this.beginningOfLine = false;
        }
        this.writer.write(cArr, i, i2);
    }
}
