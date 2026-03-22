package com.android.apksig.internal.asn1.ber;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class BerDataValue {
    public final boolean mConstructed;
    public final ByteBuffer mEncoded;
    public final ByteBuffer mEncodedContents;
    public final int mTagClass;
    public final int mTagNumber;

    public static final class ParsedValueReader implements BerDataValueReader {
        public final BerDataValue mValue;
        public boolean mValueOutput;

        public ParsedValueReader(BerDataValue berDataValue) {
            this.mValue = berDataValue;
        }

        @Override // com.android.apksig.internal.asn1.ber.BerDataValueReader
        public BerDataValue readDataValue() throws BerDataValueFormatException {
            if (this.mValueOutput) {
                return null;
            }
            this.mValueOutput = true;
            return this.mValue;
        }
    }

    public BerDataValue(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, boolean z, int i2) {
        this.mEncoded = byteBuffer;
        this.mEncodedContents = byteBuffer2;
        this.mTagClass = i;
        this.mConstructed = z;
        this.mTagNumber = i2;
    }

    public BerDataValueReader contentsReader() {
        return new ByteBufferBerDataValueReader(getEncodedContents());
    }

    public BerDataValueReader dataValueReader() {
        return new ParsedValueReader(this);
    }

    public ByteBuffer getEncoded() {
        return this.mEncoded.slice();
    }

    public ByteBuffer getEncodedContents() {
        return this.mEncodedContents.slice();
    }

    public int getTagClass() {
        return this.mTagClass;
    }

    public int getTagNumber() {
        return this.mTagNumber;
    }

    public boolean isConstructed() {
        return this.mConstructed;
    }
}
