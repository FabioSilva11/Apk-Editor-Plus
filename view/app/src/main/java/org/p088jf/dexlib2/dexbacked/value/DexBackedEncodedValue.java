package org.p088jf.dexlib2.dexbacked.value;

import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.DexReader;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableBooleanEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableByteEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableCharEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableDoubleEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableFloatEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableIntEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableLongEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableNullEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableShortEncodedValue;
import org.p088jf.dexlib2.util.Preconditions;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public abstract class DexBackedEncodedValue {
    public static EncodedValue readFrom(DexBackedDexFile dexBackedDexFile, DexReader dexReader) {
        int offset = dexReader.getOffset();
        try {
            int ubyte = dexReader.readUbyte();
            int i = ubyte & 31;
            int i2 = ubyte >>> 5;
            if (i == 0) {
                Preconditions.checkValueArg(i2, 0);
                return new ImmutableByteEncodedValue((byte) dexReader.readByte());
            }
            if (i == 6) {
                Preconditions.checkValueArg(i2, 7);
                return new ImmutableLongEncodedValue(dexReader.readSizedLong(i2 + 1));
            }
            if (i == 2) {
                Preconditions.checkValueArg(i2, 1);
                return new ImmutableShortEncodedValue((short) dexReader.readSizedInt(i2 + 1));
            }
            if (i == 3) {
                Preconditions.checkValueArg(i2, 1);
                return new ImmutableCharEncodedValue((char) dexReader.readSizedSmallUint(i2 + 1));
            }
            if (i == 4) {
                Preconditions.checkValueArg(i2, 3);
                return new ImmutableIntEncodedValue(dexReader.readSizedInt(i2 + 1));
            }
            if (i == 16) {
                Preconditions.checkValueArg(i2, 3);
                return new ImmutableFloatEncodedValue(Float.intBitsToFloat(dexReader.readSizedRightExtendedInt(i2 + 1)));
            }
            if (i == 17) {
                Preconditions.checkValueArg(i2, 7);
                return new ImmutableDoubleEncodedValue(Double.longBitsToDouble(dexReader.readSizedRightExtendedLong(i2 + 1)));
            }
            switch (i) {
                case 21:
                    Preconditions.checkValueArg(i2, 3);
                    return new DexBackedMethodTypeEncodedValue(dexBackedDexFile, dexReader, i2);
                case 22:
                    Preconditions.checkValueArg(i2, 3);
                    return new DexBackedMethodHandleEncodedValue(dexBackedDexFile, dexReader, i2);
                case 23:
                    Preconditions.checkValueArg(i2, 3);
                    return new DexBackedStringEncodedValue(dexBackedDexFile, dexReader, i2);
                case 24:
                    Preconditions.checkValueArg(i2, 3);
                    return new DexBackedTypeEncodedValue(dexBackedDexFile, dexReader, i2);
                case 25:
                    Preconditions.checkValueArg(i2, 3);
                    return new DexBackedFieldEncodedValue(dexBackedDexFile, dexReader, i2);
                case 26:
                    Preconditions.checkValueArg(i2, 3);
                    return new DexBackedMethodEncodedValue(dexBackedDexFile, dexReader, i2);
                case 27:
                    Preconditions.checkValueArg(i2, 3);
                    return new DexBackedEnumEncodedValue(dexBackedDexFile, dexReader, i2);
                case 28:
                    Preconditions.checkValueArg(i2, 0);
                    return new DexBackedArrayEncodedValue(dexBackedDexFile, dexReader);
                case 29:
                    Preconditions.checkValueArg(i2, 0);
                    return new DexBackedAnnotationEncodedValue(dexBackedDexFile, dexReader);
                case 30:
                    Preconditions.checkValueArg(i2, 0);
                    return ImmutableNullEncodedValue.INSTANCE;
                case 31:
                    Preconditions.checkValueArg(i2, 1);
                    return ImmutableBooleanEncodedValue.forBoolean(i2 == 1);
                default:
                    throw new ExceptionWithContext("Invalid encoded_value type: 0x%x", Integer.valueOf(i));
            }
        } catch (Exception e) {
            throw ExceptionWithContext.withContext(e, "Error while reading encoded value at offset 0x%x", Integer.valueOf(offset));
        }
    }

    public static void skipFrom(DexReader dexReader) {
        int offset = dexReader.getOffset();
        try {
            int ubyte = dexReader.readUbyte();
            int i = ubyte & 31;
            if (i == 0) {
                dexReader.skipByte();
                return;
            }
            if (i != 6 && i != 2 && i != 3 && i != 4 && i != 16 && i != 17) {
                switch (i) {
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                        break;
                    case 28:
                        DexBackedArrayEncodedValue.skipFrom(dexReader);
                        return;
                    case 29:
                        DexBackedAnnotationEncodedValue.skipFrom(dexReader);
                        return;
                    case 30:
                    case 31:
                        return;
                    default:
                        throw new ExceptionWithContext("Invalid encoded_value type: 0x%x", Integer.valueOf(i));
                }
            }
            dexReader.moveRelative((ubyte >>> 5) + 1);
        } catch (Exception e) {
            throw ExceptionWithContext.withContext(e, "Error while skipping encoded value at offset 0x%x", Integer.valueOf(offset));
        }
    }
}
