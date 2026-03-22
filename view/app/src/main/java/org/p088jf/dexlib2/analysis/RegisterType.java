package org.p088jf.dexlib2.analysis;

import android.support.v7.appcompat.C0299R;
import com.gmail.heagoo.neweditor.Token;
import java.io.IOException;
import java.io.Writer;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class RegisterType {
    public final byte category;
    public final TypeProto type;
    public static final String[] CATEGORY_NAMES = {"Unknown", "Uninit", "Null", "One", "Boolean", "Byte", "PosByte", "Short", "PosShort", "Char", "Integer", "Float", "LongLo", "LongHi", "DoubleLo", "DoubleHi", "UninitRef", "UninitThis", "Reference", "Conflicted"};
    public static byte[][] mergeTable = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Token.KEYWORD4, 12, Token.LITERAL1, Token.LITERAL2, Token.LITERAL3, Token.LITERAL4, Token.MARKUP, Token.OPERATOR, Token.ID_COUNT}, new byte[]{1, 1, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{2, Token.ID_COUNT, 2, 4, 4, 5, 6, 7, 8, 9, 10, Token.KEYWORD4, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.OPERATOR, Token.ID_COUNT}, new byte[]{3, Token.ID_COUNT, 4, 3, 4, 5, 6, 7, 8, 9, 10, Token.KEYWORD4, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{4, Token.ID_COUNT, 4, 4, 4, 5, 6, 7, 8, 9, 10, Token.KEYWORD4, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{5, Token.ID_COUNT, 5, 5, 5, 5, 5, 7, 7, 10, 10, Token.KEYWORD4, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{6, Token.ID_COUNT, 6, 6, 6, 5, 6, 7, 8, 9, 10, Token.KEYWORD4, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{7, Token.ID_COUNT, 7, 7, 7, 7, 7, 7, 7, 10, 10, Token.KEYWORD4, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{8, Token.ID_COUNT, 8, 8, 8, 7, 8, 7, 8, 9, 10, Token.KEYWORD4, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{9, Token.ID_COUNT, 9, 9, 9, 10, 9, 10, 9, 9, 10, Token.KEYWORD4, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{10, Token.ID_COUNT, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{Token.KEYWORD4, Token.ID_COUNT, Token.KEYWORD4, Token.KEYWORD4, Token.KEYWORD4, Token.KEYWORD4, Token.KEYWORD4, Token.KEYWORD4, Token.KEYWORD4, Token.KEYWORD4, 10, Token.KEYWORD4, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{12, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, 12, Token.ID_COUNT, 12, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{Token.LITERAL1, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.LITERAL1, Token.ID_COUNT, Token.LITERAL1, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{Token.LITERAL2, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, 12, Token.ID_COUNT, Token.LITERAL2, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{Token.LITERAL3, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.LITERAL1, Token.ID_COUNT, Token.LITERAL3, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{Token.LITERAL4, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{Token.MARKUP, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.MARKUP, Token.ID_COUNT, Token.ID_COUNT}, new byte[]{Token.OPERATOR, Token.ID_COUNT, Token.OPERATOR, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.OPERATOR, Token.ID_COUNT}, new byte[]{Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT, Token.ID_COUNT}};
    public static final RegisterType UNKNOWN_TYPE = new RegisterType((byte) 0, null);
    public static final RegisterType UNINIT_TYPE = new RegisterType((byte) 1, null);
    public static final RegisterType NULL_TYPE = new RegisterType((byte) 2, null);
    public static final RegisterType ONE_TYPE = new RegisterType((byte) 3, null);
    public static final RegisterType BOOLEAN_TYPE = new RegisterType((byte) 4, null);
    public static final RegisterType BYTE_TYPE = new RegisterType((byte) 5, null);
    public static final RegisterType POS_BYTE_TYPE = new RegisterType((byte) 6, null);
    public static final RegisterType SHORT_TYPE = new RegisterType((byte) 7, null);
    public static final RegisterType POS_SHORT_TYPE = new RegisterType((byte) 8, null);
    public static final RegisterType CHAR_TYPE = new RegisterType((byte) 9, null);
    public static final RegisterType INTEGER_TYPE = new RegisterType((byte) 10, null);
    public static final RegisterType FLOAT_TYPE = new RegisterType(Token.KEYWORD4, null);
    public static final RegisterType LONG_LO_TYPE = new RegisterType((byte) 12, null);
    public static final RegisterType LONG_HI_TYPE = new RegisterType(Token.LITERAL1, null);
    public static final RegisterType DOUBLE_LO_TYPE = new RegisterType(Token.LITERAL2, null);
    public static final RegisterType DOUBLE_HI_TYPE = new RegisterType(Token.LITERAL3, null);
    public static final RegisterType CONFLICTED_TYPE = new RegisterType(Token.ID_COUNT, null);

    public RegisterType(byte b2, TypeProto typeProto) {
        this.category = b2;
        this.type = typeProto;
    }

    public static RegisterType getRegisterType(byte b2, TypeProto typeProto) {
        if (b2 == 19) {
            return CONFLICTED_TYPE;
        }
        switch (b2) {
            case 0:
                return UNKNOWN_TYPE;
            case 1:
                return UNINIT_TYPE;
            case 2:
                return NULL_TYPE;
            case 3:
                return ONE_TYPE;
            case 4:
                return BOOLEAN_TYPE;
            case 5:
                return BYTE_TYPE;
            case 6:
                return POS_BYTE_TYPE;
            case 7:
                return SHORT_TYPE;
            case 8:
                return POS_SHORT_TYPE;
            case 9:
                return CHAR_TYPE;
            case 10:
                return INTEGER_TYPE;
            case 11:
                return FLOAT_TYPE;
            case 12:
                return LONG_LO_TYPE;
            case 13:
                return LONG_HI_TYPE;
            case 14:
                return DOUBLE_LO_TYPE;
            case 15:
                return DOUBLE_HI_TYPE;
            default:
                return new RegisterType(b2, typeProto);
        }
    }

    public static RegisterType getRegisterType(ClassPath classPath, CharSequence charSequence) {
        char cCharAt = charSequence.charAt(0);
        if (cCharAt == 'F') {
            return FLOAT_TYPE;
        }
        if (cCharAt != 'L') {
            if (cCharAt == 'S') {
                return SHORT_TYPE;
            }
            if (cCharAt == 'I') {
                return INTEGER_TYPE;
            }
            if (cCharAt == 'J') {
                return LONG_LO_TYPE;
            }
            if (cCharAt == 'Z') {
                return BOOLEAN_TYPE;
            }
            if (cCharAt != '[') {
                switch (cCharAt) {
                    case C0299R.styleable.AppCompatTheme_imageButtonStyle /* 66 */:
                        return BYTE_TYPE;
                    case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /* 67 */:
                        return CHAR_TYPE;
                    case C0299R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /* 68 */:
                        return DOUBLE_LO_TYPE;
                    default:
                        throw new AnalysisException("Invalid type: " + ((Object) charSequence), new Object[0]);
                }
            }
        }
        throw null;
    }

    public static RegisterType getRegisterTypeForLiteral(int i) {
        return i < -32768 ? INTEGER_TYPE : i < -128 ? SHORT_TYPE : i < 0 ? BYTE_TYPE : i == 0 ? NULL_TYPE : i == 1 ? ONE_TYPE : i < 128 ? POS_BYTE_TYPE : i < 32768 ? POS_SHORT_TYPE : i < 65536 ? CHAR_TYPE : INTEGER_TYPE;
    }

    public static RegisterType getWideRegisterType(CharSequence charSequence, boolean z) {
        char cCharAt = charSequence.charAt(0);
        if (cCharAt == 'D') {
            return z ? getRegisterType(Token.LITERAL2, (TypeProto) null) : getRegisterType(Token.LITERAL3, (TypeProto) null);
        }
        if (cCharAt == 'J') {
            return z ? getRegisterType((byte) 12, (TypeProto) null) : getRegisterType(Token.LITERAL1, (TypeProto) null);
        }
        throw new ExceptionWithContext("Cannot use this method for narrow register type: %s", charSequence);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && RegisterType.class == obj.getClass()) {
            RegisterType registerType = (RegisterType) obj;
            byte b2 = this.category;
            if (b2 == registerType.category && b2 != 16 && b2 != 17) {
                TypeProto typeProto = this.type;
                TypeProto typeProto2 = registerType.type;
                return typeProto != null ? typeProto.equals(typeProto2) : typeProto2 == null;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.category * 31;
        TypeProto typeProto = this.type;
        return i + (typeProto != null ? typeProto.hashCode() : 0);
    }

    public RegisterType merge(RegisterType registerType) {
        if (registerType.equals(this)) {
            return this;
        }
        byte[][] bArr = mergeTable;
        byte b2 = this.category;
        byte b3 = bArr[b2][registerType.category];
        TypeProto typeProto = null;
        if (b3 == 18) {
            TypeProto commonSuperclass = this.type;
            if (commonSuperclass != null) {
                TypeProto typeProto2 = registerType.type;
                if (typeProto2 != null) {
                    commonSuperclass = commonSuperclass.getCommonSuperclass(typeProto2);
                }
            } else {
                commonSuperclass = registerType.type;
            }
            typeProto = commonSuperclass;
        } else if (b3 == 16 || b3 == 17) {
            return b2 == 0 ? registerType : this;
        }
        if (typeProto != null) {
            if (typeProto.equals(this.type)) {
                return this;
            }
            if (typeProto.equals(registerType.type)) {
                return registerType;
            }
        }
        return getRegisterType(b3, typeProto);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(CATEGORY_NAMES[this.category]);
        if (this.type == null) {
            str = "";
        } else {
            str = "," + this.type;
        }
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    public void writeTo(Writer writer) throws IOException {
        writer.write(40);
        writer.write(CATEGORY_NAMES[this.category]);
        if (this.type != null) {
            writer.write(44);
            writer.write(this.type.getType());
        }
        writer.write(41);
    }
}
