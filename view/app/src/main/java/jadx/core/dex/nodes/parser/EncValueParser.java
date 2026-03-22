package jadx.core.dex.nodes.parser;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.C0416o;
import jadx.core.dex.info.FieldInfo;
import jadx.core.dex.info.MethodInfo;
import jadx.core.dex.nodes.DexNode;
import jadx.core.utils.exceptions.DecodeException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class EncValueParser {
    private static final int ENCODED_ANNOTATION = 29;
    private static final int ENCODED_ARRAY = 28;
    private static final int ENCODED_BOOLEAN = 31;
    private static final int ENCODED_BYTE = 0;
    private static final int ENCODED_CHAR = 3;
    private static final int ENCODED_DOUBLE = 17;
    private static final int ENCODED_ENUM = 27;
    private static final int ENCODED_FIELD = 25;
    private static final int ENCODED_FLOAT = 16;
    private static final int ENCODED_INT = 4;
    private static final int ENCODED_LONG = 6;
    private static final int ENCODED_METHOD = 26;
    private static final int ENCODED_NULL = 30;
    private static final int ENCODED_SHORT = 2;
    private static final int ENCODED_STRING = 23;
    private static final int ENCODED_TYPE = 24;
    private final DexNode dex;

    /* JADX INFO: renamed from: in */
    protected final C0416o f4699in;

    public EncValueParser(DexNode dexNode, C0416o c0416o) {
        this.f4699in = c0416o;
        this.dex = dexNode;
    }

    private long parseNumber(int i, boolean z) {
        return parseNumber(i, z, 0);
    }

    private long parseNumber(int i, boolean z, int i2) {
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        while (i3 < i) {
            j = readByte();
            long j3 = (j << (i3 << 3)) | j2;
            i3++;
            j2 = j3;
        }
        if (i2 != 0) {
            while (i < i2) {
                j2 <<= 8;
                i++;
            }
        } else if (z && (128 & j) != 0) {
            while (i < 8) {
                j2 |= 255 << (i << 3);
                i++;
            }
        }
        return j2;
    }

    private int parseUnsignedInt(int i) {
        return (int) parseNumber(i, false, 0);
    }

    private int readByte() {
        return this.f4699in.mo306d() & 255;
    }

    public Object parseValue() throws DecodeException {
        int i = readByte();
        int i2 = i & 31;
        int i3 = (i & 224) >> 5;
        int i4 = i3 + 1;
        switch (i2) {
            case 0:
                return Byte.valueOf(this.f4699in.mo306d());
            case 1:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            default:
                throw new DecodeException("Unknown encoded value type: 0x" + Integer.toHexString(i2));
            case 2:
                return Short.valueOf((short) parseNumber(i4, true));
            case 3:
                return Character.valueOf((char) parseUnsignedInt(i4));
            case 4:
                return Integer.valueOf((int) parseNumber(i4, true));
            case 6:
                return Long.valueOf(parseNumber(i4, true));
            case 16:
                return Float.valueOf(Float.intBitsToFloat((int) parseNumber(i4, false, 4)));
            case 17:
                return Double.valueOf(Double.longBitsToDouble(parseNumber(i4, false, 8)));
            case 23:
                return this.dex.getString(parseUnsignedInt(i4));
            case 24:
                return this.dex.getType(parseUnsignedInt(i4));
            case 25:
            case 27:
                return FieldInfo.fromDex(this.dex, parseUnsignedInt(i4));
            case 26:
                return MethodInfo.fromDex(this.dex, parseUnsignedInt(i4));
            case 28:
                int iM2232b = C0985a.m2232b(this.f4699in);
                ArrayList arrayList = new ArrayList(iM2232b);
                for (int i5 = 0; i5 < iM2232b; i5++) {
                    arrayList.add(parseValue());
                }
                return arrayList;
            case 29:
                return AnnotationsParser.readAnnotation(this.dex, this.f4699in, false);
            case 30:
                return null;
            case 31:
                return Boolean.valueOf(i3 == 1);
        }
    }
}
