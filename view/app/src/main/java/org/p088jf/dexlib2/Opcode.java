package org.p088jf.dexlib2;

import android.support.v4.view.InputDeviceCompat;
import android.support.v7.appcompat.C0299R;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NOP' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public final class Opcode {
    public static final /* synthetic */ Opcode[] $VALUES;
    public static final Opcode ADD_DOUBLE;
    public static final Opcode ADD_DOUBLE_2ADDR;
    public static final Opcode ADD_FLOAT;
    public static final Opcode ADD_FLOAT_2ADDR;
    public static final Opcode ADD_INT;
    public static final Opcode ADD_INT_2ADDR;
    public static final Opcode ADD_INT_LIT16;
    public static final Opcode ADD_INT_LIT8;
    public static final Opcode ADD_LONG;
    public static final Opcode ADD_LONG_2ADDR;
    public static final Opcode AGET;
    public static final Opcode AGET_BOOLEAN;
    public static final Opcode AGET_BYTE;
    public static final Opcode AGET_CHAR;
    public static final Opcode AGET_OBJECT;
    public static final Opcode AGET_SHORT;
    public static final Opcode AGET_WIDE;
    public static final Opcode AND_INT;
    public static final Opcode AND_INT_2ADDR;
    public static final Opcode AND_INT_LIT16;
    public static final Opcode AND_INT_LIT8;
    public static final Opcode AND_LONG;
    public static final Opcode AND_LONG_2ADDR;
    public static final Opcode APUT;
    public static final Opcode APUT_BOOLEAN;
    public static final Opcode APUT_BYTE;
    public static final Opcode APUT_CHAR;
    public static final Opcode APUT_OBJECT;
    public static final Opcode APUT_SHORT;
    public static final Opcode APUT_WIDE;
    public static final Opcode ARRAY_LENGTH;
    public static final Opcode ARRAY_PAYLOAD;
    public static final Opcode CHECK_CAST;
    public static final Opcode CMPG_DOUBLE;
    public static final Opcode CMPG_FLOAT;
    public static final Opcode CMPL_DOUBLE;
    public static final Opcode CMPL_FLOAT;
    public static final Opcode CMP_LONG;
    public static final Opcode CONST;
    public static final Opcode CONST_16;
    public static final Opcode CONST_4;
    public static final Opcode CONST_CLASS;
    public static final Opcode CONST_HIGH16;
    public static final Opcode CONST_METHOD_HANDLE;
    public static final Opcode CONST_METHOD_TYPE;
    public static final Opcode CONST_STRING;
    public static final Opcode CONST_STRING_JUMBO;
    public static final Opcode CONST_WIDE;
    public static final Opcode CONST_WIDE_16;
    public static final Opcode CONST_WIDE_32;
    public static final Opcode CONST_WIDE_HIGH16;
    public static final Opcode DIV_DOUBLE;
    public static final Opcode DIV_DOUBLE_2ADDR;
    public static final Opcode DIV_FLOAT;
    public static final Opcode DIV_FLOAT_2ADDR;
    public static final Opcode DIV_INT;
    public static final Opcode DIV_INT_2ADDR;
    public static final Opcode DIV_INT_LIT16;
    public static final Opcode DIV_INT_LIT8;
    public static final Opcode DIV_LONG;
    public static final Opcode DIV_LONG_2ADDR;
    public static final Opcode DOUBLE_TO_FLOAT;
    public static final Opcode DOUBLE_TO_INT;
    public static final Opcode DOUBLE_TO_LONG;
    public static final Opcode EXECUTE_INLINE;
    public static final Opcode EXECUTE_INLINE_RANGE;
    public static final Opcode FILLED_NEW_ARRAY;
    public static final Opcode FILLED_NEW_ARRAY_RANGE;
    public static final Opcode FILL_ARRAY_DATA;
    public static final Opcode FLOAT_TO_DOUBLE;
    public static final Opcode FLOAT_TO_INT;
    public static final Opcode FLOAT_TO_LONG;
    public static final Opcode GOTO;
    public static final Opcode GOTO_16;
    public static final Opcode GOTO_32;
    public static final Opcode IF_EQ;
    public static final Opcode IF_EQZ;
    public static final Opcode IF_GE;
    public static final Opcode IF_GEZ;
    public static final Opcode IF_GT;
    public static final Opcode IF_GTZ;
    public static final Opcode IF_LE;
    public static final Opcode IF_LEZ;
    public static final Opcode IF_LT;
    public static final Opcode IF_LTZ;
    public static final Opcode IF_NE;
    public static final Opcode IF_NEZ;
    public static final Opcode IGET;
    public static final Opcode IGET_BOOLEAN;
    public static final Opcode IGET_BOOLEAN_QUICK;
    public static final Opcode IGET_BYTE;
    public static final Opcode IGET_BYTE_QUICK;
    public static final Opcode IGET_CHAR;
    public static final Opcode IGET_CHAR_QUICK;
    public static final Opcode IGET_OBJECT;
    public static final Opcode IGET_OBJECT_QUICK;
    public static final Opcode IGET_OBJECT_VOLATILE;
    public static final Opcode IGET_QUICK;
    public static final Opcode IGET_SHORT;
    public static final Opcode IGET_SHORT_QUICK;
    public static final Opcode IGET_VOLATILE;
    public static final Opcode IGET_WIDE;
    public static final Opcode IGET_WIDE_QUICK;
    public static final Opcode IGET_WIDE_VOLATILE;
    public static final Opcode INSTANCE_OF;
    public static final Opcode INT_TO_BYTE;
    public static final Opcode INT_TO_CHAR;
    public static final Opcode INT_TO_DOUBLE;
    public static final Opcode INT_TO_FLOAT;
    public static final Opcode INT_TO_LONG;
    public static final Opcode INT_TO_SHORT;
    public static final Opcode INVOKE_CUSTOM;
    public static final Opcode INVOKE_CUSTOM_RANGE;
    public static final Opcode INVOKE_DIRECT;
    public static final Opcode INVOKE_DIRECT_EMPTY;
    public static final Opcode INVOKE_DIRECT_RANGE;
    public static final Opcode INVOKE_INTERFACE;
    public static final Opcode INVOKE_INTERFACE_RANGE;
    public static final Opcode INVOKE_OBJECT_INIT_RANGE;
    public static final Opcode INVOKE_POLYMORPHIC;
    public static final Opcode INVOKE_POLYMORPHIC_RANGE;
    public static final Opcode INVOKE_STATIC;
    public static final Opcode INVOKE_STATIC_RANGE;
    public static final Opcode INVOKE_SUPER;
    public static final Opcode INVOKE_SUPER_QUICK;
    public static final Opcode INVOKE_SUPER_QUICK_RANGE;
    public static final Opcode INVOKE_SUPER_RANGE;
    public static final Opcode INVOKE_VIRTUAL;
    public static final Opcode INVOKE_VIRTUAL_QUICK;
    public static final Opcode INVOKE_VIRTUAL_QUICK_RANGE;
    public static final Opcode INVOKE_VIRTUAL_RANGE;
    public static final Opcode IPUT;
    public static final Opcode IPUT_BOOLEAN;
    public static final Opcode IPUT_BOOLEAN_QUICK;
    public static final Opcode IPUT_BYTE;
    public static final Opcode IPUT_BYTE_QUICK;
    public static final Opcode IPUT_CHAR;
    public static final Opcode IPUT_CHAR_QUICK;
    public static final Opcode IPUT_OBJECT;
    public static final Opcode IPUT_OBJECT_QUICK;
    public static final Opcode IPUT_OBJECT_VOLATILE;
    public static final Opcode IPUT_QUICK;
    public static final Opcode IPUT_SHORT;
    public static final Opcode IPUT_SHORT_QUICK;
    public static final Opcode IPUT_VOLATILE;
    public static final Opcode IPUT_WIDE;
    public static final Opcode IPUT_WIDE_QUICK;
    public static final Opcode IPUT_WIDE_VOLATILE;
    public static final Opcode LONG_TO_DOUBLE;
    public static final Opcode LONG_TO_FLOAT;
    public static final Opcode LONG_TO_INT;
    public static final Opcode MONITOR_ENTER;
    public static final Opcode MONITOR_EXIT;
    public static final Opcode MOVE;
    public static final Opcode MOVE_16;
    public static final Opcode MOVE_EXCEPTION;
    public static final Opcode MOVE_FROM16;
    public static final Opcode MOVE_OBJECT;
    public static final Opcode MOVE_OBJECT_16;
    public static final Opcode MOVE_OBJECT_FROM16;
    public static final Opcode MOVE_RESULT;
    public static final Opcode MOVE_RESULT_OBJECT;
    public static final Opcode MOVE_RESULT_WIDE;
    public static final Opcode MOVE_WIDE;
    public static final Opcode MOVE_WIDE_16;
    public static final Opcode MOVE_WIDE_FROM16;
    public static final Opcode MUL_DOUBLE;
    public static final Opcode MUL_DOUBLE_2ADDR;
    public static final Opcode MUL_FLOAT;
    public static final Opcode MUL_FLOAT_2ADDR;
    public static final Opcode MUL_INT;
    public static final Opcode MUL_INT_2ADDR;
    public static final Opcode MUL_INT_LIT16;
    public static final Opcode MUL_INT_LIT8;
    public static final Opcode MUL_LONG;
    public static final Opcode MUL_LONG_2ADDR;
    public static final Opcode NEG_DOUBLE;
    public static final Opcode NEG_FLOAT;
    public static final Opcode NEG_INT;
    public static final Opcode NEG_LONG;
    public static final Opcode NEW_ARRAY;
    public static final Opcode NEW_INSTANCE;
    public static final Opcode NOP;
    public static final Opcode NOT_INT;
    public static final Opcode NOT_LONG;
    public static final Opcode OR_INT;
    public static final Opcode OR_INT_2ADDR;
    public static final Opcode OR_INT_LIT16;
    public static final Opcode OR_INT_LIT8;
    public static final Opcode OR_LONG;
    public static final Opcode OR_LONG_2ADDR;
    public static final Opcode PACKED_SWITCH;
    public static final Opcode PACKED_SWITCH_PAYLOAD;
    public static final Opcode REM_DOUBLE;
    public static final Opcode REM_DOUBLE_2ADDR;
    public static final Opcode REM_FLOAT;
    public static final Opcode REM_FLOAT_2ADDR;
    public static final Opcode REM_INT;
    public static final Opcode REM_INT_2ADDR;
    public static final Opcode REM_INT_LIT16;
    public static final Opcode REM_INT_LIT8;
    public static final Opcode REM_LONG;
    public static final Opcode REM_LONG_2ADDR;
    public static final Opcode RETURN;
    public static final Opcode RETURN_OBJECT;
    public static final Opcode RETURN_VOID;
    public static final Opcode RETURN_VOID_BARRIER;
    public static final Opcode RETURN_VOID_NO_BARRIER;
    public static final Opcode RETURN_WIDE;
    public static final Opcode RSUB_INT;
    public static final Opcode RSUB_INT_LIT8;
    public static final Opcode SGET;
    public static final Opcode SGET_BOOLEAN;
    public static final Opcode SGET_BYTE;
    public static final Opcode SGET_CHAR;
    public static final Opcode SGET_OBJECT;
    public static final Opcode SGET_OBJECT_VOLATILE;
    public static final Opcode SGET_SHORT;
    public static final Opcode SGET_VOLATILE;
    public static final Opcode SGET_WIDE;
    public static final Opcode SGET_WIDE_VOLATILE;
    public static final Opcode SHL_INT;
    public static final Opcode SHL_INT_2ADDR;
    public static final Opcode SHL_INT_LIT8;
    public static final Opcode SHL_LONG;
    public static final Opcode SHL_LONG_2ADDR;
    public static final Opcode SHR_INT;
    public static final Opcode SHR_INT_2ADDR;
    public static final Opcode SHR_INT_LIT8;
    public static final Opcode SHR_LONG;
    public static final Opcode SHR_LONG_2ADDR;
    public static final Opcode SPARSE_SWITCH;
    public static final Opcode SPARSE_SWITCH_PAYLOAD;
    public static final Opcode SPUT;
    public static final Opcode SPUT_BOOLEAN;
    public static final Opcode SPUT_BYTE;
    public static final Opcode SPUT_CHAR;
    public static final Opcode SPUT_OBJECT;
    public static final Opcode SPUT_OBJECT_VOLATILE;
    public static final Opcode SPUT_SHORT;
    public static final Opcode SPUT_VOLATILE;
    public static final Opcode SPUT_WIDE;
    public static final Opcode SPUT_WIDE_VOLATILE;
    public static final Opcode SUB_DOUBLE;
    public static final Opcode SUB_DOUBLE_2ADDR;
    public static final Opcode SUB_FLOAT;
    public static final Opcode SUB_FLOAT_2ADDR;
    public static final Opcode SUB_INT;
    public static final Opcode SUB_INT_2ADDR;
    public static final Opcode SUB_LONG;
    public static final Opcode SUB_LONG_2ADDR;
    public static final Opcode THROW;
    public static final Opcode THROW_VERIFICATION_ERROR;
    public static final Opcode USHR_INT;
    public static final Opcode USHR_INT_2ADDR;
    public static final Opcode USHR_INT_LIT8;
    public static final Opcode USHR_LONG;
    public static final Opcode USHR_LONG_2ADDR;
    public static final Opcode XOR_INT;
    public static final Opcode XOR_INT_2ADDR;
    public static final Opcode XOR_INT_LIT16;
    public static final Opcode XOR_INT_LIT8;
    public static final Opcode XOR_LONG;
    public static final Opcode XOR_LONG_2ADDR;
    public final RangeMap<Integer, Short> apiToValueMap;
    public final RangeMap<Integer, Short> artVersionToValueMap;
    public final int flags;
    public final Format format;
    public final String name;
    public final int referenceType;
    public final int referenceType2;

    public static class VersionConstraint {
        public final Range<Integer> apiRange;
        public final Range<Integer> artVersionRange;
        public final int opcodeValue;

        public VersionConstraint(Range<Integer> range, Range<Integer> range2, int i) {
            this.apiRange = range;
            this.artVersionRange = range2;
            this.opcodeValue = i;
        }
    }

    static {
        Format format = Format.Format10x;
        Opcode opcode = new Opcode("NOP", 0, 0, "nop", 7, format, 4);
        NOP = opcode;
        Format format2 = Format.Format12x;
        Opcode opcode2 = new Opcode("MOVE", 1, 1, "move", 7, format2, 20);
        MOVE = opcode2;
        Format format3 = Format.Format22x;
        Opcode opcode3 = new Opcode("MOVE_FROM16", 2, 2, "move/from16", 7, format3, 20);
        MOVE_FROM16 = opcode3;
        Format format4 = Format.Format32x;
        Opcode opcode4 = new Opcode("MOVE_16", 3, 3, "move/16", 7, format4, 20);
        MOVE_16 = opcode4;
        Opcode opcode5 = new Opcode("MOVE_WIDE", 4, 4, "move-wide", 7, format2, 52);
        MOVE_WIDE = opcode5;
        Opcode opcode6 = new Opcode("MOVE_WIDE_FROM16", 5, 5, "move-wide/from16", 7, format3, 52);
        MOVE_WIDE_FROM16 = opcode6;
        Opcode opcode7 = new Opcode("MOVE_WIDE_16", 6, 6, "move-wide/16", 7, format4, 52);
        MOVE_WIDE_16 = opcode7;
        Opcode opcode8 = new Opcode("MOVE_OBJECT", 7, 7, "move-object", 7, format2, 20);
        MOVE_OBJECT = opcode8;
        Opcode opcode9 = new Opcode("MOVE_OBJECT_FROM16", 8, 8, "move-object/from16", 7, format3, 20);
        MOVE_OBJECT_FROM16 = opcode9;
        Opcode opcode10 = new Opcode("MOVE_OBJECT_16", 9, 9, "move-object/16", 7, format4, 20);
        MOVE_OBJECT_16 = opcode10;
        Format format5 = Format.Format11x;
        Opcode opcode11 = new Opcode("MOVE_RESULT", 10, 10, "move-result", 7, format5, 20);
        MOVE_RESULT = opcode11;
        Opcode opcode12 = new Opcode("MOVE_RESULT_WIDE", 11, 11, "move-result-wide", 7, format5, 52);
        MOVE_RESULT_WIDE = opcode12;
        Opcode opcode13 = new Opcode("MOVE_RESULT_OBJECT", 12, 12, "move-result-object", 7, format5, 20);
        MOVE_RESULT_OBJECT = opcode13;
        Opcode opcode14 = new Opcode("MOVE_EXCEPTION", 13, 13, "move-exception", 7, format5, 20);
        MOVE_EXCEPTION = opcode14;
        Opcode opcode15 = new Opcode("RETURN_VOID", 14, 14, "return-void", 7, format);
        RETURN_VOID = opcode15;
        Opcode opcode16 = new Opcode("RETURN", 15, 15, "return", 7, format5);
        RETURN = opcode16;
        Opcode opcode17 = new Opcode("RETURN_WIDE", 16, 16, "return-wide", 7, format5);
        RETURN_WIDE = opcode17;
        Opcode opcode18 = new Opcode("RETURN_OBJECT", 17, 17, "return-object", 7, format5);
        RETURN_OBJECT = opcode18;
        Opcode opcode19 = new Opcode("CONST_4", 18, 18, "const/4", 7, Format.Format11n, 20);
        CONST_4 = opcode19;
        Format format6 = Format.Format21s;
        Opcode opcode20 = new Opcode("CONST_16", 19, 19, "const/16", 7, format6, 20);
        CONST_16 = opcode20;
        Format format7 = Format.Format31i;
        Opcode opcode21 = new Opcode("CONST", 20, 20, "const", 7, format7, 20);
        CONST = opcode21;
        Opcode opcode22 = new Opcode("CONST_HIGH16", 21, 21, "const/high16", 7, Format.Format21ih, 20);
        CONST_HIGH16 = opcode22;
        Opcode opcode23 = new Opcode("CONST_WIDE_16", 22, 22, "const-wide/16", 7, format6, 52);
        CONST_WIDE_16 = opcode23;
        Opcode opcode24 = new Opcode("CONST_WIDE_32", 23, 23, "const-wide/32", 7, format7, 52);
        CONST_WIDE_32 = opcode24;
        Opcode opcode25 = new Opcode("CONST_WIDE", 24, 24, "const-wide", 7, Format.Format51l, 52);
        CONST_WIDE = opcode25;
        Opcode opcode26 = new Opcode("CONST_WIDE_HIGH16", 25, 25, "const-wide/high16", 7, Format.Format21lh, 52);
        CONST_WIDE_HIGH16 = opcode26;
        Format format8 = Format.Format21c;
        Opcode opcode27 = new Opcode("CONST_STRING", 26, 26, "const-string", 0, format8, 21);
        CONST_STRING = opcode27;
        Opcode opcode28 = new Opcode("CONST_STRING_JUMBO", 27, 27, "const-string/jumbo", 0, Format.Format31c, 21);
        CONST_STRING_JUMBO = opcode28;
        Opcode opcode29 = new Opcode("CONST_CLASS", 28, 28, "const-class", 1, format8, 21);
        CONST_CLASS = opcode29;
        Opcode opcode30 = new Opcode("MONITOR_ENTER", 29, 29, "monitor-enter", 7, format5, 5);
        MONITOR_ENTER = opcode30;
        Opcode opcode31 = new Opcode("MONITOR_EXIT", 30, 30, "monitor-exit", 7, format5, 5);
        MONITOR_EXIT = opcode31;
        Opcode opcode32 = new Opcode("CHECK_CAST", 31, 31, "check-cast", 1, format8, 21);
        CHECK_CAST = opcode32;
        Format format9 = Format.Format22c;
        Opcode opcode33 = new Opcode("INSTANCE_OF", 32, 32, "instance-of", 1, format9, 21);
        INSTANCE_OF = opcode33;
        Opcode opcode34 = new Opcode("ARRAY_LENGTH", 33, 33, "array-length", 7, format2, 21);
        ARRAY_LENGTH = opcode34;
        Opcode opcode35 = new Opcode("NEW_INSTANCE", 34, 34, "new-instance", 1, format8, 21);
        NEW_INSTANCE = opcode35;
        Opcode opcode36 = new Opcode("NEW_ARRAY", 35, 35, "new-array", 1, format9, 21);
        NEW_ARRAY = opcode36;
        Format format10 = Format.Format35c;
        Opcode opcode37 = new Opcode("FILLED_NEW_ARRAY", 36, 36, "filled-new-array", 1, format10, 13);
        FILLED_NEW_ARRAY = opcode37;
        Format format11 = Format.Format3rc;
        Opcode opcode38 = new Opcode("FILLED_NEW_ARRAY_RANGE", 37, 37, "filled-new-array/range", 1, format11, 13);
        FILLED_NEW_ARRAY_RANGE = opcode38;
        Format format12 = Format.Format31t;
        Opcode opcode39 = new Opcode("FILL_ARRAY_DATA", 38, 38, "fill-array-data", 7, format12, 4);
        FILL_ARRAY_DATA = opcode39;
        Opcode opcode40 = new Opcode("THROW", 39, 39, "throw", 7, format5, 1);
        THROW = opcode40;
        Opcode opcode41 = new Opcode("GOTO", 40, 40, "goto", 7, Format.Format10t);
        GOTO = opcode41;
        Opcode opcode42 = new Opcode("GOTO_16", 41, 41, "goto/16", 7, Format.Format20t);
        GOTO_16 = opcode42;
        Opcode opcode43 = new Opcode("GOTO_32", 42, 42, "goto/32", 7, Format.Format30t);
        GOTO_32 = opcode43;
        Opcode opcode44 = new Opcode("PACKED_SWITCH", 43, 43, "packed-switch", 7, format12, 4);
        PACKED_SWITCH = opcode44;
        Opcode opcode45 = new Opcode("SPARSE_SWITCH", 44, 44, "sparse-switch", 7, format12, 4);
        SPARSE_SWITCH = opcode45;
        Format format13 = Format.Format23x;
        Opcode opcode46 = new Opcode("CMPL_FLOAT", 45, 45, "cmpl-float", 7, format13, 20);
        CMPL_FLOAT = opcode46;
        Opcode opcode47 = new Opcode("CMPG_FLOAT", 46, 46, "cmpg-float", 7, format13, 20);
        CMPG_FLOAT = opcode47;
        Opcode opcode48 = new Opcode("CMPL_DOUBLE", 47, 47, "cmpl-double", 7, format13, 20);
        CMPL_DOUBLE = opcode48;
        Opcode opcode49 = new Opcode("CMPG_DOUBLE", 48, 48, "cmpg-double", 7, format13, 20);
        CMPG_DOUBLE = opcode49;
        Opcode opcode50 = new Opcode("CMP_LONG", 49, 49, "cmp-long", 7, format13, 20);
        CMP_LONG = opcode50;
        Format format14 = Format.Format22t;
        Opcode opcode51 = new Opcode("IF_EQ", 50, 50, "if-eq", 7, format14, 4);
        IF_EQ = opcode51;
        Opcode opcode52 = new Opcode("IF_NE", 51, 51, "if-ne", 7, format14, 4);
        IF_NE = opcode52;
        Opcode opcode53 = new Opcode("IF_LT", 52, 52, "if-lt", 7, format14, 4);
        IF_LT = opcode53;
        Opcode opcode54 = new Opcode("IF_GE", 53, 53, "if-ge", 7, format14, 4);
        IF_GE = opcode54;
        Opcode opcode55 = new Opcode("IF_GT", 54, 54, "if-gt", 7, format14, 4);
        IF_GT = opcode55;
        Opcode opcode56 = new Opcode("IF_LE", 55, 55, "if-le", 7, format14, 4);
        IF_LE = opcode56;
        Format format15 = Format.Format21t;
        Opcode opcode57 = new Opcode("IF_EQZ", 56, 56, "if-eqz", 7, format15, 4);
        IF_EQZ = opcode57;
        Opcode opcode58 = new Opcode("IF_NEZ", 57, 57, "if-nez", 7, format15, 4);
        IF_NEZ = opcode58;
        Opcode opcode59 = new Opcode("IF_LTZ", 58, 58, "if-ltz", 7, format15, 4);
        IF_LTZ = opcode59;
        Opcode opcode60 = new Opcode("IF_GEZ", 59, 59, "if-gez", 7, format15, 4);
        IF_GEZ = opcode60;
        Opcode opcode61 = new Opcode("IF_GTZ", 60, 60, "if-gtz", 7, format15, 4);
        IF_GTZ = opcode61;
        Opcode opcode62 = new Opcode("IF_LEZ", 61, 61, "if-lez", 7, format15, 4);
        IF_LEZ = opcode62;
        Opcode opcode63 = new Opcode("AGET", 62, 68, "aget", 7, format13, 21);
        AGET = opcode63;
        Opcode opcode64 = new Opcode("AGET_WIDE", 63, 69, "aget-wide", 7, format13, 53);
        AGET_WIDE = opcode64;
        Opcode opcode65 = new Opcode("AGET_OBJECT", 64, 70, "aget-object", 7, format13, 21);
        AGET_OBJECT = opcode65;
        Opcode opcode66 = new Opcode("AGET_BOOLEAN", 65, 71, "aget-boolean", 7, format13, 21);
        AGET_BOOLEAN = opcode66;
        Opcode opcode67 = new Opcode("AGET_BYTE", 66, 72, "aget-byte", 7, format13, 21);
        AGET_BYTE = opcode67;
        Opcode opcode68 = new Opcode("AGET_CHAR", 67, 73, "aget-char", 7, format13, 21);
        AGET_CHAR = opcode68;
        Opcode opcode69 = new Opcode("AGET_SHORT", 68, 74, "aget-short", 7, format13, 21);
        AGET_SHORT = opcode69;
        Opcode opcode70 = new Opcode("APUT", 69, 75, "aput", 7, format13, 5);
        APUT = opcode70;
        Opcode opcode71 = new Opcode("APUT_WIDE", 70, 76, "aput-wide", 7, format13, 5);
        APUT_WIDE = opcode71;
        Opcode opcode72 = new Opcode("APUT_OBJECT", 71, 77, "aput-object", 7, format13, 5);
        APUT_OBJECT = opcode72;
        Opcode opcode73 = new Opcode("APUT_BOOLEAN", 72, 78, "aput-boolean", 7, format13, 5);
        APUT_BOOLEAN = opcode73;
        Opcode opcode74 = new Opcode("APUT_BYTE", 73, 79, "aput-byte", 7, format13, 5);
        APUT_BYTE = opcode74;
        Opcode opcode75 = new Opcode("APUT_CHAR", 74, 80, "aput-char", 7, format13, 5);
        APUT_CHAR = opcode75;
        Opcode opcode76 = new Opcode("APUT_SHORT", 75, 81, "aput-short", 7, format13, 5);
        APUT_SHORT = opcode76;
        Opcode opcode77 = new Opcode("IGET", 76, 82, "iget", 2, format9, 21);
        IGET = opcode77;
        Opcode opcode78 = new Opcode("IGET_WIDE", 77, 83, "iget-wide", 2, format9, 53);
        IGET_WIDE = opcode78;
        Opcode opcode79 = new Opcode("IGET_OBJECT", 78, 84, "iget-object", 2, format9, 21);
        IGET_OBJECT = opcode79;
        Opcode opcode80 = new Opcode("IGET_BOOLEAN", 79, 85, "iget-boolean", 2, format9, 21);
        IGET_BOOLEAN = opcode80;
        Opcode opcode81 = new Opcode("IGET_BYTE", 80, 86, "iget-byte", 2, format9, 21);
        IGET_BYTE = opcode81;
        Opcode opcode82 = new Opcode("IGET_CHAR", 81, 87, "iget-char", 2, format9, 21);
        IGET_CHAR = opcode82;
        Opcode opcode83 = new Opcode("IGET_SHORT", 82, 88, "iget-short", 2, format9, 21);
        IGET_SHORT = opcode83;
        Opcode opcode84 = new Opcode("IPUT", 83, 89, "iput", 2, format9, 5);
        IPUT = opcode84;
        Opcode opcode85 = new Opcode("IPUT_WIDE", 84, 90, "iput-wide", 2, format9, 5);
        IPUT_WIDE = opcode85;
        Opcode opcode86 = new Opcode("IPUT_OBJECT", 85, 91, "iput-object", 2, format9, 5);
        IPUT_OBJECT = opcode86;
        Opcode opcode87 = new Opcode("IPUT_BOOLEAN", 86, 92, "iput-boolean", 2, format9, 5);
        IPUT_BOOLEAN = opcode87;
        Opcode opcode88 = new Opcode("IPUT_BYTE", 87, 93, "iput-byte", 2, format9, 5);
        IPUT_BYTE = opcode88;
        Opcode opcode89 = new Opcode("IPUT_CHAR", 88, 94, "iput-char", 2, format9, 5);
        IPUT_CHAR = opcode89;
        Opcode opcode90 = new Opcode("IPUT_SHORT", 89, 95, "iput-short", 2, format9, 5);
        IPUT_SHORT = opcode90;
        Opcode opcode91 = new Opcode("SGET", 90, 96, "sget", 2, format8, 277);
        SGET = opcode91;
        Opcode opcode92 = new Opcode("SGET_WIDE", 91, 97, "sget-wide", 2, format8, 309);
        SGET_WIDE = opcode92;
        Opcode opcode93 = new Opcode("SGET_OBJECT", 92, 98, "sget-object", 2, format8, 277);
        SGET_OBJECT = opcode93;
        Opcode opcode94 = new Opcode("SGET_BOOLEAN", 93, 99, "sget-boolean", 2, format8, 277);
        SGET_BOOLEAN = opcode94;
        Opcode opcode95 = new Opcode("SGET_BYTE", 94, 100, "sget-byte", 2, format8, 277);
        SGET_BYTE = opcode95;
        Opcode opcode96 = new Opcode("SGET_CHAR", 95, C0299R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle, "sget-char", 2, format8, 277);
        SGET_CHAR = opcode96;
        Opcode opcode97 = new Opcode("SGET_SHORT", 96, C0299R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle, "sget-short", 2, format8, 277);
        SGET_SHORT = opcode97;
        Opcode opcode98 = new Opcode("SPUT", 97, C0299R.styleable.AppCompatTheme_autoCompleteTextViewStyle, "sput", 2, format8, 261);
        SPUT = opcode98;
        Opcode opcode99 = new Opcode("SPUT_WIDE", 98, C0299R.styleable.AppCompatTheme_buttonStyle, "sput-wide", 2, format8, 261);
        SPUT_WIDE = opcode99;
        Opcode opcode100 = new Opcode("SPUT_OBJECT", 99, C0299R.styleable.AppCompatTheme_buttonStyleSmall, "sput-object", 2, format8, 261);
        SPUT_OBJECT = opcode100;
        Opcode opcode101 = new Opcode("SPUT_BOOLEAN", 100, C0299R.styleable.AppCompatTheme_checkboxStyle, "sput-boolean", 2, format8, 261);
        SPUT_BOOLEAN = opcode101;
        Opcode opcode102 = new Opcode("SPUT_BYTE", C0299R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle, C0299R.styleable.AppCompatTheme_checkedTextViewStyle, "sput-byte", 2, format8, 261);
        SPUT_BYTE = opcode102;
        Opcode opcode103 = new Opcode("SPUT_CHAR", C0299R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle, 108, "sput-char", 2, format8, 261);
        SPUT_CHAR = opcode103;
        Opcode opcode104 = new Opcode("SPUT_SHORT", C0299R.styleable.AppCompatTheme_autoCompleteTextViewStyle, 109, "sput-short", 2, format8, 261);
        SPUT_SHORT = opcode104;
        Opcode opcode105 = new Opcode("INVOKE_VIRTUAL", C0299R.styleable.AppCompatTheme_buttonStyle, C0299R.styleable.AppCompatTheme_ratingBarStyle, "invoke-virtual", 3, format10, 13);
        INVOKE_VIRTUAL = opcode105;
        Opcode opcode106 = new Opcode("INVOKE_SUPER", C0299R.styleable.AppCompatTheme_buttonStyleSmall, C0299R.styleable.AppCompatTheme_ratingBarStyleIndicator, "invoke-super", 3, format10, 13);
        INVOKE_SUPER = opcode106;
        Opcode opcode107 = new Opcode("INVOKE_DIRECT", C0299R.styleable.AppCompatTheme_checkboxStyle, C0299R.styleable.AppCompatTheme_ratingBarStyleSmall, "invoke-direct", 3, format10, 1037);
        INVOKE_DIRECT = opcode107;
        Opcode opcode108 = new Opcode("INVOKE_STATIC", C0299R.styleable.AppCompatTheme_checkedTextViewStyle, C0299R.styleable.AppCompatTheme_seekBarStyle, "invoke-static", 3, format10, 13);
        INVOKE_STATIC = opcode108;
        Opcode opcode109 = new Opcode("INVOKE_INTERFACE", 108, C0299R.styleable.AppCompatTheme_spinnerStyle, "invoke-interface", 3, format10, 13);
        INVOKE_INTERFACE = opcode109;
        Opcode opcode110 = new Opcode("INVOKE_VIRTUAL_RANGE", 109, C0299R.styleable.AppCompatTheme_listMenuViewStyle, "invoke-virtual/range", 3, format11, 13);
        INVOKE_VIRTUAL_RANGE = opcode110;
        Opcode opcode111 = new Opcode("INVOKE_SUPER_RANGE", C0299R.styleable.AppCompatTheme_ratingBarStyle, C0299R.styleable.AppCompatTheme_tooltipFrameBackground, "invoke-super/range", 3, format11, 13);
        INVOKE_SUPER_RANGE = opcode111;
        Opcode opcode112 = new Opcode("INVOKE_DIRECT_RANGE", C0299R.styleable.AppCompatTheme_ratingBarStyleIndicator, C0299R.styleable.AppCompatTheme_tooltipForegroundColor, "invoke-direct/range", 3, format11, 1037);
        INVOKE_DIRECT_RANGE = opcode112;
        Opcode opcode113 = new Opcode("INVOKE_STATIC_RANGE", C0299R.styleable.AppCompatTheme_ratingBarStyleSmall, C0299R.styleable.AppCompatTheme_colorError, "invoke-static/range", 3, format11, 13);
        INVOKE_STATIC_RANGE = opcode113;
        Opcode opcode114 = new Opcode("INVOKE_INTERFACE_RANGE", C0299R.styleable.AppCompatTheme_seekBarStyle, 120, "invoke-interface/range", 3, format11, 13);
        INVOKE_INTERFACE_RANGE = opcode114;
        Opcode opcode115 = new Opcode("NEG_INT", C0299R.styleable.AppCompatTheme_spinnerStyle, 123, "neg-int", 7, format2, 20);
        NEG_INT = opcode115;
        Opcode opcode116 = new Opcode("NOT_INT", C0299R.styleable.AppCompatTheme_switchStyle, 124, "not-int", 7, format2, 20);
        NOT_INT = opcode116;
        Opcode opcode117 = new Opcode("NEG_LONG", C0299R.styleable.AppCompatTheme_listMenuViewStyle, 125, "neg-long", 7, format2, 52);
        NEG_LONG = opcode117;
        Opcode opcode118 = new Opcode("NOT_LONG", C0299R.styleable.AppCompatTheme_tooltipFrameBackground, 126, "not-long", 7, format2, 52);
        NOT_LONG = opcode118;
        Opcode opcode119 = new Opcode("NEG_FLOAT", C0299R.styleable.AppCompatTheme_tooltipForegroundColor, 127, "neg-float", 7, format2, 20);
        NEG_FLOAT = opcode119;
        Opcode opcode120 = new Opcode("NEG_DOUBLE", C0299R.styleable.AppCompatTheme_colorError, 128, "neg-double", 7, format2, 52);
        NEG_DOUBLE = opcode120;
        Opcode opcode121 = new Opcode("INT_TO_LONG", 120, 129, "int-to-long", 7, format2, 52);
        INT_TO_LONG = opcode121;
        Opcode opcode122 = new Opcode("INT_TO_FLOAT", 121, 130, "int-to-float", 7, format2, 20);
        INT_TO_FLOAT = opcode122;
        Opcode opcode123 = new Opcode("INT_TO_DOUBLE", 122, 131, "int-to-double", 7, format2, 52);
        INT_TO_DOUBLE = opcode123;
        Opcode opcode124 = new Opcode("LONG_TO_INT", 123, 132, "long-to-int", 7, format2, 20);
        LONG_TO_INT = opcode124;
        Opcode opcode125 = new Opcode("LONG_TO_FLOAT", 124, 133, "long-to-float", 7, format2, 20);
        LONG_TO_FLOAT = opcode125;
        Opcode opcode126 = new Opcode("LONG_TO_DOUBLE", 125, 134, "long-to-double", 7, format2, 52);
        LONG_TO_DOUBLE = opcode126;
        Opcode opcode127 = new Opcode("FLOAT_TO_INT", 126, 135, "float-to-int", 7, format2, 20);
        FLOAT_TO_INT = opcode127;
        Opcode opcode128 = new Opcode("FLOAT_TO_LONG", 127, 136, "float-to-long", 7, format2, 52);
        FLOAT_TO_LONG = opcode128;
        Opcode opcode129 = new Opcode("FLOAT_TO_DOUBLE", 128, 137, "float-to-double", 7, format2, 52);
        FLOAT_TO_DOUBLE = opcode129;
        Opcode opcode130 = new Opcode("DOUBLE_TO_INT", 129, 138, "double-to-int", 7, format2, 20);
        DOUBLE_TO_INT = opcode130;
        Opcode opcode131 = new Opcode("DOUBLE_TO_LONG", 130, 139, "double-to-long", 7, format2, 52);
        DOUBLE_TO_LONG = opcode131;
        Opcode opcode132 = new Opcode("DOUBLE_TO_FLOAT", 131, 140, "double-to-float", 7, format2, 20);
        DOUBLE_TO_FLOAT = opcode132;
        Opcode opcode133 = new Opcode("INT_TO_BYTE", 132, 141, "int-to-byte", 7, format2, 20);
        INT_TO_BYTE = opcode133;
        Opcode opcode134 = new Opcode("INT_TO_CHAR", 133, 142, "int-to-char", 7, format2, 20);
        INT_TO_CHAR = opcode134;
        Opcode opcode135 = new Opcode("INT_TO_SHORT", 134, 143, "int-to-short", 7, format2, 20);
        INT_TO_SHORT = opcode135;
        Opcode opcode136 = new Opcode("ADD_INT", 135, 144, "add-int", 7, format13, 20);
        ADD_INT = opcode136;
        Opcode opcode137 = new Opcode("SUB_INT", 136, 145, "sub-int", 7, format13, 20);
        SUB_INT = opcode137;
        Opcode opcode138 = new Opcode("MUL_INT", 137, 146, "mul-int", 7, format13, 20);
        MUL_INT = opcode138;
        Opcode opcode139 = new Opcode("DIV_INT", 138, 147, "div-int", 7, format13, 21);
        DIV_INT = opcode139;
        Opcode opcode140 = new Opcode("REM_INT", 139, 148, "rem-int", 7, format13, 21);
        REM_INT = opcode140;
        Opcode opcode141 = new Opcode("AND_INT", 140, 149, "and-int", 7, format13, 20);
        AND_INT = opcode141;
        Opcode opcode142 = new Opcode("OR_INT", 141, 150, "or-int", 7, format13, 20);
        OR_INT = opcode142;
        Opcode opcode143 = new Opcode("XOR_INT", 142, 151, "xor-int", 7, format13, 20);
        XOR_INT = opcode143;
        Opcode opcode144 = new Opcode("SHL_INT", 143, 152, "shl-int", 7, format13, 20);
        SHL_INT = opcode144;
        Opcode opcode145 = new Opcode("SHR_INT", 144, 153, "shr-int", 7, format13, 20);
        SHR_INT = opcode145;
        Opcode opcode146 = new Opcode("USHR_INT", 145, 154, "ushr-int", 7, format13, 20);
        USHR_INT = opcode146;
        Opcode opcode147 = new Opcode("ADD_LONG", 146, 155, "add-long", 7, format13, 52);
        ADD_LONG = opcode147;
        Opcode opcode148 = new Opcode("SUB_LONG", 147, 156, "sub-long", 7, format13, 52);
        SUB_LONG = opcode148;
        Opcode opcode149 = new Opcode("MUL_LONG", 148, 157, "mul-long", 7, format13, 52);
        MUL_LONG = opcode149;
        Opcode opcode150 = new Opcode("DIV_LONG", 149, 158, "div-long", 7, format13, 53);
        DIV_LONG = opcode150;
        Opcode opcode151 = new Opcode("REM_LONG", 150, 159, "rem-long", 7, format13, 53);
        REM_LONG = opcode151;
        Opcode opcode152 = new Opcode("AND_LONG", 151, 160, "and-long", 7, format13, 52);
        AND_LONG = opcode152;
        Opcode opcode153 = new Opcode("OR_LONG", 152, 161, "or-long", 7, format13, 52);
        OR_LONG = opcode153;
        Opcode opcode154 = new Opcode("XOR_LONG", 153, 162, "xor-long", 7, format13, 52);
        XOR_LONG = opcode154;
        Opcode opcode155 = new Opcode("SHL_LONG", 154, 163, "shl-long", 7, format13, 52);
        SHL_LONG = opcode155;
        Opcode opcode156 = new Opcode("SHR_LONG", 155, 164, "shr-long", 7, format13, 52);
        SHR_LONG = opcode156;
        Opcode opcode157 = new Opcode("USHR_LONG", 156, 165, "ushr-long", 7, format13, 52);
        USHR_LONG = opcode157;
        Opcode opcode158 = new Opcode("ADD_FLOAT", 157, 166, "add-float", 7, format13, 20);
        ADD_FLOAT = opcode158;
        Opcode opcode159 = new Opcode("SUB_FLOAT", 158, 167, "sub-float", 7, format13, 20);
        SUB_FLOAT = opcode159;
        Opcode opcode160 = new Opcode("MUL_FLOAT", 159, 168, "mul-float", 7, format13, 20);
        MUL_FLOAT = opcode160;
        Opcode opcode161 = new Opcode("DIV_FLOAT", 160, 169, "div-float", 7, format13, 20);
        DIV_FLOAT = opcode161;
        Opcode opcode162 = new Opcode("REM_FLOAT", 161, 170, "rem-float", 7, format13, 20);
        REM_FLOAT = opcode162;
        Opcode opcode163 = new Opcode("ADD_DOUBLE", 162, 171, "add-double", 7, format13, 52);
        ADD_DOUBLE = opcode163;
        Opcode opcode164 = new Opcode("SUB_DOUBLE", 163, 172, "sub-double", 7, format13, 52);
        SUB_DOUBLE = opcode164;
        Opcode opcode165 = new Opcode("MUL_DOUBLE", 164, 173, "mul-double", 7, format13, 52);
        MUL_DOUBLE = opcode165;
        Opcode opcode166 = new Opcode("DIV_DOUBLE", 165, 174, "div-double", 7, format13, 52);
        DIV_DOUBLE = opcode166;
        Opcode opcode167 = new Opcode("REM_DOUBLE", 166, 175, "rem-double", 7, format13, 52);
        REM_DOUBLE = opcode167;
        Opcode opcode168 = new Opcode("ADD_INT_2ADDR", 167, 176, "add-int/2addr", 7, format2, 20);
        ADD_INT_2ADDR = opcode168;
        Opcode opcode169 = new Opcode("SUB_INT_2ADDR", 168, 177, "sub-int/2addr", 7, format2, 20);
        SUB_INT_2ADDR = opcode169;
        Opcode opcode170 = new Opcode("MUL_INT_2ADDR", 169, 178, "mul-int/2addr", 7, format2, 20);
        MUL_INT_2ADDR = opcode170;
        Opcode opcode171 = new Opcode("DIV_INT_2ADDR", 170, 179, "div-int/2addr", 7, format2, 21);
        DIV_INT_2ADDR = opcode171;
        Opcode opcode172 = new Opcode("REM_INT_2ADDR", 171, 180, "rem-int/2addr", 7, format2, 21);
        REM_INT_2ADDR = opcode172;
        Opcode opcode173 = new Opcode("AND_INT_2ADDR", 172, 181, "and-int/2addr", 7, format2, 20);
        AND_INT_2ADDR = opcode173;
        Opcode opcode174 = new Opcode("OR_INT_2ADDR", 173, 182, "or-int/2addr", 7, format2, 20);
        OR_INT_2ADDR = opcode174;
        Opcode opcode175 = new Opcode("XOR_INT_2ADDR", 174, 183, "xor-int/2addr", 7, format2, 20);
        XOR_INT_2ADDR = opcode175;
        Opcode opcode176 = new Opcode("SHL_INT_2ADDR", 175, 184, "shl-int/2addr", 7, format2, 20);
        SHL_INT_2ADDR = opcode176;
        Opcode opcode177 = new Opcode("SHR_INT_2ADDR", 176, 185, "shr-int/2addr", 7, format2, 20);
        SHR_INT_2ADDR = opcode177;
        Opcode opcode178 = new Opcode("USHR_INT_2ADDR", 177, 186, "ushr-int/2addr", 7, format2, 20);
        USHR_INT_2ADDR = opcode178;
        Opcode opcode179 = new Opcode("ADD_LONG_2ADDR", 178, 187, "add-long/2addr", 7, format2, 52);
        ADD_LONG_2ADDR = opcode179;
        Opcode opcode180 = new Opcode("SUB_LONG_2ADDR", 179, 188, "sub-long/2addr", 7, format2, 52);
        SUB_LONG_2ADDR = opcode180;
        Opcode opcode181 = new Opcode("MUL_LONG_2ADDR", 180, 189, "mul-long/2addr", 7, format2, 52);
        MUL_LONG_2ADDR = opcode181;
        Opcode opcode182 = new Opcode("DIV_LONG_2ADDR", 181, 190, "div-long/2addr", 7, format2, 53);
        DIV_LONG_2ADDR = opcode182;
        Opcode opcode183 = new Opcode("REM_LONG_2ADDR", 182, 191, "rem-long/2addr", 7, format2, 53);
        REM_LONG_2ADDR = opcode183;
        Opcode opcode184 = new Opcode("AND_LONG_2ADDR", 183, 192, "and-long/2addr", 7, format2, 52);
        AND_LONG_2ADDR = opcode184;
        Opcode opcode185 = new Opcode("OR_LONG_2ADDR", 184, 193, "or-long/2addr", 7, format2, 52);
        OR_LONG_2ADDR = opcode185;
        Opcode opcode186 = new Opcode("XOR_LONG_2ADDR", 185, 194, "xor-long/2addr", 7, format2, 52);
        XOR_LONG_2ADDR = opcode186;
        Opcode opcode187 = new Opcode("SHL_LONG_2ADDR", 186, 195, "shl-long/2addr", 7, format2, 52);
        SHL_LONG_2ADDR = opcode187;
        Opcode opcode188 = new Opcode("SHR_LONG_2ADDR", 187, 196, "shr-long/2addr", 7, format2, 52);
        SHR_LONG_2ADDR = opcode188;
        Opcode opcode189 = new Opcode("USHR_LONG_2ADDR", 188, 197, "ushr-long/2addr", 7, format2, 52);
        USHR_LONG_2ADDR = opcode189;
        Opcode opcode190 = new Opcode("ADD_FLOAT_2ADDR", 189, 198, "add-float/2addr", 7, format2, 20);
        ADD_FLOAT_2ADDR = opcode190;
        Opcode opcode191 = new Opcode("SUB_FLOAT_2ADDR", 190, 199, "sub-float/2addr", 7, format2, 20);
        SUB_FLOAT_2ADDR = opcode191;
        Opcode opcode192 = new Opcode("MUL_FLOAT_2ADDR", 191, 200, "mul-float/2addr", 7, format2, 20);
        MUL_FLOAT_2ADDR = opcode192;
        Opcode opcode193 = new Opcode("DIV_FLOAT_2ADDR", 192, 201, "div-float/2addr", 7, format2, 20);
        DIV_FLOAT_2ADDR = opcode193;
        Opcode opcode194 = new Opcode("REM_FLOAT_2ADDR", 193, 202, "rem-float/2addr", 7, format2, 20);
        REM_FLOAT_2ADDR = opcode194;
        Opcode opcode195 = new Opcode("ADD_DOUBLE_2ADDR", 194, 203, "add-double/2addr", 7, format2, 52);
        ADD_DOUBLE_2ADDR = opcode195;
        Opcode opcode196 = new Opcode("SUB_DOUBLE_2ADDR", 195, 204, "sub-double/2addr", 7, format2, 52);
        SUB_DOUBLE_2ADDR = opcode196;
        Opcode opcode197 = new Opcode("MUL_DOUBLE_2ADDR", 196, 205, "mul-double/2addr", 7, format2, 52);
        MUL_DOUBLE_2ADDR = opcode197;
        Opcode opcode198 = new Opcode("DIV_DOUBLE_2ADDR", 197, 206, "div-double/2addr", 7, format2, 52);
        DIV_DOUBLE_2ADDR = opcode198;
        Opcode opcode199 = new Opcode("REM_DOUBLE_2ADDR", 198, 207, "rem-double/2addr", 7, format2, 52);
        REM_DOUBLE_2ADDR = opcode199;
        Format format16 = Format.Format22s;
        Opcode opcode200 = new Opcode("ADD_INT_LIT16", 199, 208, "add-int/lit16", 7, format16, 20);
        ADD_INT_LIT16 = opcode200;
        Opcode opcode201 = new Opcode("RSUB_INT", 200, 209, "rsub-int", 7, format16, 20);
        RSUB_INT = opcode201;
        Opcode opcode202 = new Opcode("MUL_INT_LIT16", 201, 210, "mul-int/lit16", 7, format16, 20);
        MUL_INT_LIT16 = opcode202;
        Opcode opcode203 = new Opcode("DIV_INT_LIT16", 202, 211, "div-int/lit16", 7, format16, 21);
        DIV_INT_LIT16 = opcode203;
        Opcode opcode204 = new Opcode("REM_INT_LIT16", 203, 212, "rem-int/lit16", 7, format16, 21);
        REM_INT_LIT16 = opcode204;
        Opcode opcode205 = new Opcode("AND_INT_LIT16", 204, 213, "and-int/lit16", 7, format16, 20);
        AND_INT_LIT16 = opcode205;
        Opcode opcode206 = new Opcode("OR_INT_LIT16", 205, 214, "or-int/lit16", 7, format16, 20);
        OR_INT_LIT16 = opcode206;
        Opcode opcode207 = new Opcode("XOR_INT_LIT16", 206, 215, "xor-int/lit16", 7, format16, 20);
        XOR_INT_LIT16 = opcode207;
        Format format17 = Format.Format22b;
        Opcode opcode208 = new Opcode("ADD_INT_LIT8", 207, 216, "add-int/lit8", 7, format17, 20);
        ADD_INT_LIT8 = opcode208;
        Opcode opcode209 = new Opcode("RSUB_INT_LIT8", 208, 217, "rsub-int/lit8", 7, format17, 20);
        RSUB_INT_LIT8 = opcode209;
        Opcode opcode210 = new Opcode("MUL_INT_LIT8", 209, 218, "mul-int/lit8", 7, format17, 20);
        MUL_INT_LIT8 = opcode210;
        Opcode opcode211 = new Opcode("DIV_INT_LIT8", 210, 219, "div-int/lit8", 7, format17, 21);
        DIV_INT_LIT8 = opcode211;
        Opcode opcode212 = new Opcode("REM_INT_LIT8", 211, 220, "rem-int/lit8", 7, format17, 21);
        REM_INT_LIT8 = opcode212;
        Opcode opcode213 = new Opcode("AND_INT_LIT8", 212, 221, "and-int/lit8", 7, format17, 20);
        AND_INT_LIT8 = opcode213;
        Opcode opcode214 = new Opcode("OR_INT_LIT8", 213, 222, "or-int/lit8", 7, format17, 20);
        OR_INT_LIT8 = opcode214;
        Opcode opcode215 = new Opcode("XOR_INT_LIT8", 214, 223, "xor-int/lit8", 7, format17, 20);
        XOR_INT_LIT8 = opcode215;
        Opcode opcode216 = new Opcode("SHL_INT_LIT8", 215, 224, "shl-int/lit8", 7, format17, 20);
        SHL_INT_LIT8 = opcode216;
        Opcode opcode217 = new Opcode("SHR_INT_LIT8", 216, 225, "shr-int/lit8", 7, format17, 20);
        SHR_INT_LIT8 = opcode217;
        Opcode opcode218 = new Opcode("USHR_INT_LIT8", 217, 226, "ushr-int/lit8", 7, format17, 20);
        USHR_INT_LIT8 = opcode218;
        Opcode opcode219 = new Opcode("IGET_VOLATILE", 218, firstApi(227, 9), "iget-volatile", 2, format9, 151);
        IGET_VOLATILE = opcode219;
        Opcode opcode220 = new Opcode("IPUT_VOLATILE", 219, firstApi(228, 9), "iput-volatile", 2, format9, 135);
        IPUT_VOLATILE = opcode220;
        Opcode opcode221 = new Opcode("SGET_VOLATILE", 220, firstApi(229, 9), "sget-volatile", 2, format8, 407);
        SGET_VOLATILE = opcode221;
        Opcode opcode222 = new Opcode("SPUT_VOLATILE", 221, firstApi(230, 9), "sput-volatile", 2, format8, 391);
        SPUT_VOLATILE = opcode222;
        Opcode opcode223 = new Opcode("IGET_OBJECT_VOLATILE", 222, firstApi(231, 9), "iget-object-volatile", 2, format9, 151);
        IGET_OBJECT_VOLATILE = opcode223;
        Opcode opcode224 = new Opcode("IGET_WIDE_VOLATILE", 223, firstApi(232, 9), "iget-wide-volatile", 2, format9, 183);
        IGET_WIDE_VOLATILE = opcode224;
        Opcode opcode225 = new Opcode("IPUT_WIDE_VOLATILE", 224, firstApi(233, 9), "iput-wide-volatile", 2, format9, 135);
        IPUT_WIDE_VOLATILE = opcode225;
        Opcode opcode226 = new Opcode("SGET_WIDE_VOLATILE", 225, firstApi(234, 9), "sget-wide-volatile", 2, format8, 439);
        SGET_WIDE_VOLATILE = opcode226;
        Opcode opcode227 = new Opcode("SPUT_WIDE_VOLATILE", 226, firstApi(235, 9), "sput-wide-volatile", 2, format8, 391);
        SPUT_WIDE_VOLATILE = opcode227;
        Opcode opcode228 = new Opcode("THROW_VERIFICATION_ERROR", 227, firstApi(237, 5), "throw-verification-error", 7, Format.Format20bc, 3);
        THROW_VERIFICATION_ERROR = opcode228;
        Opcode opcode229 = new Opcode("EXECUTE_INLINE", 228, allApis(238), "execute-inline", 7, Format.Format35mi, 15);
        EXECUTE_INLINE = opcode229;
        Opcode opcode230 = new Opcode("EXECUTE_INLINE_RANGE", 229, firstApi(239, 8), "execute-inline/range", 7, Format.Format3rmi, 15);
        EXECUTE_INLINE_RANGE = opcode230;
        Opcode opcode231 = new Opcode("INVOKE_DIRECT_EMPTY", 230, lastApi(240, 13), "invoke-direct-empty", 3, format10, 1039);
        INVOKE_DIRECT_EMPTY = opcode231;
        Opcode opcode232 = new Opcode("INVOKE_OBJECT_INIT_RANGE", 231, firstApi(240, 14), "invoke-object-init/range", 3, format11, 1039);
        INVOKE_OBJECT_INIT_RANGE = opcode232;
        Opcode opcode233 = new Opcode("RETURN_VOID_BARRIER", 232, combine(firstApi(241, 11), lastArtVersion(C0299R.styleable.AppCompatTheme_switchStyle, 59)), "return-void-barrier", 7, format, 2);
        RETURN_VOID_BARRIER = opcode233;
        Opcode opcode234 = new Opcode("RETURN_VOID_NO_BARRIER", 233, firstArtVersion(C0299R.styleable.AppCompatTheme_switchStyle, 60), "return-void-no-barrier", 7, format, 2);
        RETURN_VOID_NO_BARRIER = opcode234;
        List<VersionConstraint> listCombine = combine(allApis(242), allArtVersions(227));
        Format format18 = Format.Format22cs;
        Opcode opcode235 = new Opcode("IGET_QUICK", 234, listCombine, "iget-quick", 7, format18, 87);
        IGET_QUICK = opcode235;
        Opcode opcode236 = new Opcode("IGET_WIDE_QUICK", 235, combine(allApis(243), allArtVersions(228)), "iget-wide-quick", 7, format18, C0299R.styleable.AppCompatTheme_colorError);
        IGET_WIDE_QUICK = opcode236;
        Opcode opcode237 = new Opcode("IGET_OBJECT_QUICK", 236, combine(allApis(244), allArtVersions(229)), "iget-object-quick", 7, format18, 87);
        IGET_OBJECT_QUICK = opcode237;
        Opcode opcode238 = new Opcode("IPUT_QUICK", 237, combine(allApis(245), allArtVersions(230)), "iput-quick", 7, format18, 71);
        IPUT_QUICK = opcode238;
        Opcode opcode239 = new Opcode("IPUT_WIDE_QUICK", 238, combine(allApis(246), allArtVersions(231)), "iput-wide-quick", 7, format18, 71);
        IPUT_WIDE_QUICK = opcode239;
        Opcode opcode240 = new Opcode("IPUT_OBJECT_QUICK", 239, combine(allApis(247), allArtVersions(232)), "iput-object-quick", 7, format18, 71);
        IPUT_OBJECT_QUICK = opcode240;
        Opcode opcode241 = new Opcode("IPUT_BOOLEAN_QUICK", 240, allArtVersions(235), "iput-boolean-quick", 7, format18, 71);
        IPUT_BOOLEAN_QUICK = opcode241;
        Opcode opcode242 = new Opcode("IPUT_BYTE_QUICK", 241, allArtVersions(236), "iput-byte-quick", 7, format18, 71);
        IPUT_BYTE_QUICK = opcode242;
        Opcode opcode243 = new Opcode("IPUT_CHAR_QUICK", 242, allArtVersions(237), "iput-char-quick", 7, format18, 71);
        IPUT_CHAR_QUICK = opcode243;
        Opcode opcode244 = new Opcode("IPUT_SHORT_QUICK", 243, allArtVersions(238), "iput-short-quick", 7, format18, 71);
        IPUT_SHORT_QUICK = opcode244;
        Opcode opcode245 = new Opcode("IGET_BOOLEAN_QUICK", 244, allArtVersions(239), "iget-boolean-quick", 7, format18, 87);
        IGET_BOOLEAN_QUICK = opcode245;
        Opcode opcode246 = new Opcode("IGET_BYTE_QUICK", 245, allArtVersions(240), "iget-byte-quick", 7, format18, 87);
        IGET_BYTE_QUICK = opcode246;
        Opcode opcode247 = new Opcode("IGET_CHAR_QUICK", 246, allArtVersions(241), "iget-char-quick", 7, format18, 87);
        IGET_CHAR_QUICK = opcode247;
        Opcode opcode248 = new Opcode("IGET_SHORT_QUICK", 247, allArtVersions(242), "iget-short-quick", 7, format18, 87);
        IGET_SHORT_QUICK = opcode248;
        List<VersionConstraint> listCombine2 = combine(allApis(248), allArtVersions(233));
        Format format19 = Format.Format35ms;
        Opcode opcode249 = new Opcode("INVOKE_VIRTUAL_QUICK", 248, listCombine2, "invoke-virtual-quick", 7, format19, 15);
        INVOKE_VIRTUAL_QUICK = opcode249;
        List<VersionConstraint> listCombine3 = combine(allApis(249), allArtVersions(234));
        Format format20 = Format.Format3rms;
        Opcode opcode250 = new Opcode("INVOKE_VIRTUAL_QUICK_RANGE", 249, listCombine3, "invoke-virtual-quick/range", 7, format20, 15);
        INVOKE_VIRTUAL_QUICK_RANGE = opcode250;
        Opcode opcode251 = new Opcode("INVOKE_SUPER_QUICK", 250, lastApi(250, 25), "invoke-super-quick", 7, format19, 15);
        INVOKE_SUPER_QUICK = opcode251;
        Opcode opcode252 = new Opcode("INVOKE_SUPER_QUICK_RANGE", 251, lastApi(251, 25), "invoke-super-quick/range", 7, format20, 15);
        INVOKE_SUPER_QUICK_RANGE = opcode252;
        Opcode opcode253 = new Opcode("IPUT_OBJECT_VOLATILE", 252, firstApi(252, 9), "iput-object-volatile", 2, format9, 135);
        IPUT_OBJECT_VOLATILE = opcode253;
        Opcode opcode254 = new Opcode("SGET_OBJECT_VOLATILE", 253, firstApi(253, 9), "sget-object-volatile", 2, format8, 407);
        SGET_OBJECT_VOLATILE = opcode254;
        Opcode opcode255 = new Opcode("SPUT_OBJECT_VOLATILE", 254, betweenApi(254, 9, 19), "sput-object-volatile", 2, format8, 391);
        SPUT_OBJECT_VOLATILE = opcode255;
        Opcode opcode256 = new Opcode("PACKED_SWITCH_PAYLOAD", 255, 256, "packed-switch-payload", 7, Format.PackedSwitchPayload, 0);
        PACKED_SWITCH_PAYLOAD = opcode256;
        Opcode opcode257 = new Opcode("SPARSE_SWITCH_PAYLOAD", 256, 512, "sparse-switch-payload", 7, Format.SparseSwitchPayload, 0);
        SPARSE_SWITCH_PAYLOAD = opcode257;
        Opcode opcode258 = new Opcode("ARRAY_PAYLOAD", InputDeviceCompat.SOURCE_KEYBOARD, 768, "array-payload", 7, Format.ArrayPayload, 0);
        ARRAY_PAYLOAD = opcode258;
        Opcode opcode259 = new Opcode("INVOKE_POLYMORPHIC", 258, firstArtVersion(250, 87), "invoke-polymorphic", 3, 4, Format.Format45cc, 13);
        INVOKE_POLYMORPHIC = opcode259;
        Opcode opcode260 = new Opcode("INVOKE_POLYMORPHIC_RANGE", 259, firstArtVersion(251, 87), "invoke-polymorphic/range", 3, 4, Format.Format4rcc, 13);
        INVOKE_POLYMORPHIC_RANGE = opcode260;
        Opcode opcode261 = new Opcode("INVOKE_CUSTOM", 260, firstArtVersion(252, C0299R.styleable.AppCompatTheme_ratingBarStyleIndicator), "invoke-custom", 5, format10, 13);
        INVOKE_CUSTOM = opcode261;
        Opcode opcode262 = new Opcode("INVOKE_CUSTOM_RANGE", 261, firstArtVersion(253, C0299R.styleable.AppCompatTheme_ratingBarStyleIndicator), "invoke-custom/range", 5, format11, 13);
        INVOKE_CUSTOM_RANGE = opcode262;
        Opcode opcode263 = new Opcode("CONST_METHOD_HANDLE", 262, firstArtVersion(254, 134), "const-method-handle", 6, format8, 21);
        CONST_METHOD_HANDLE = opcode263;
        Opcode opcode264 = new Opcode("CONST_METHOD_TYPE", 263, firstArtVersion(255, 134), "const-method-type", 4, format8, 21);
        CONST_METHOD_TYPE = opcode264;
        $VALUES = new Opcode[]{opcode, opcode2, opcode3, opcode4, opcode5, opcode6, opcode7, opcode8, opcode9, opcode10, opcode11, opcode12, opcode13, opcode14, opcode15, opcode16, opcode17, opcode18, opcode19, opcode20, opcode21, opcode22, opcode23, opcode24, opcode25, opcode26, opcode27, opcode28, opcode29, opcode30, opcode31, opcode32, opcode33, opcode34, opcode35, opcode36, opcode37, opcode38, opcode39, opcode40, opcode41, opcode42, opcode43, opcode44, opcode45, opcode46, opcode47, opcode48, opcode49, opcode50, opcode51, opcode52, opcode53, opcode54, opcode55, opcode56, opcode57, opcode58, opcode59, opcode60, opcode61, opcode62, opcode63, opcode64, opcode65, opcode66, opcode67, opcode68, opcode69, opcode70, opcode71, opcode72, opcode73, opcode74, opcode75, opcode76, opcode77, opcode78, opcode79, opcode80, opcode81, opcode82, opcode83, opcode84, opcode85, opcode86, opcode87, opcode88, opcode89, opcode90, opcode91, opcode92, opcode93, opcode94, opcode95, opcode96, opcode97, opcode98, opcode99, opcode100, opcode101, opcode102, opcode103, opcode104, opcode105, opcode106, opcode107, opcode108, opcode109, opcode110, opcode111, opcode112, opcode113, opcode114, opcode115, opcode116, opcode117, opcode118, opcode119, opcode120, opcode121, opcode122, opcode123, opcode124, opcode125, opcode126, opcode127, opcode128, opcode129, opcode130, opcode131, opcode132, opcode133, opcode134, opcode135, opcode136, opcode137, opcode138, opcode139, opcode140, opcode141, opcode142, opcode143, opcode144, opcode145, opcode146, opcode147, opcode148, opcode149, opcode150, opcode151, opcode152, opcode153, opcode154, opcode155, opcode156, opcode157, opcode158, opcode159, opcode160, opcode161, opcode162, opcode163, opcode164, opcode165, opcode166, opcode167, opcode168, opcode169, opcode170, opcode171, opcode172, opcode173, opcode174, opcode175, opcode176, opcode177, opcode178, opcode179, opcode180, opcode181, opcode182, opcode183, opcode184, opcode185, opcode186, opcode187, opcode188, opcode189, opcode190, opcode191, opcode192, opcode193, opcode194, opcode195, opcode196, opcode197, opcode198, opcode199, opcode200, opcode201, opcode202, opcode203, opcode204, opcode205, opcode206, opcode207, opcode208, opcode209, opcode210, opcode211, opcode212, opcode213, opcode214, opcode215, opcode216, opcode217, opcode218, opcode219, opcode220, opcode221, opcode222, opcode223, opcode224, opcode225, opcode226, opcode227, opcode228, opcode229, opcode230, opcode231, opcode232, opcode233, opcode234, opcode235, opcode236, opcode237, opcode238, opcode239, opcode240, opcode241, opcode242, opcode243, opcode244, opcode245, opcode246, opcode247, opcode248, opcode249, opcode250, opcode251, opcode252, opcode253, opcode254, opcode255, opcode256, opcode257, opcode258, opcode259, opcode260, opcode261, opcode262, opcode263, opcode264};
    }

    public Opcode(String str, int i, int i2, String str2, int i3, Format format) {
        this(str, i, i2, str2, i3, format, 0);
    }

    public Opcode(String str, int i, int i2, String str2, int i3, Format format, int i4) {
        this(str, i, allVersions(i2), str2, i3, format, i4);
    }

    public Opcode(String str, int i, List list, String str2, int i2, int i3, Format format, int i4) {
        ImmutableRangeMap.Builder builder = ImmutableRangeMap.builder();
        ImmutableRangeMap.Builder builder2 = ImmutableRangeMap.builder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            VersionConstraint versionConstraint = (VersionConstraint) it.next();
            if (!versionConstraint.apiRange.isEmpty()) {
                builder.put(versionConstraint.apiRange, Short.valueOf((short) versionConstraint.opcodeValue));
            }
            if (!versionConstraint.artVersionRange.isEmpty()) {
                builder2.put(versionConstraint.artVersionRange, Short.valueOf((short) versionConstraint.opcodeValue));
            }
        }
        this.apiToValueMap = builder.build();
        this.artVersionToValueMap = builder2.build();
        this.name = str2;
        this.referenceType = i2;
        this.referenceType2 = i3;
        this.format = format;
        this.flags = i4;
    }

    public Opcode(String str, int i, List list, String str2, int i2, Format format, int i3) {
        this(str, i, list, str2, i2, -1, format, i3);
    }

    public static List<VersionConstraint> allApis(int i) {
        return Lists.newArrayList(new VersionConstraint(Range.all(), Range.openClosed(0, 0), i));
    }

    public static List<VersionConstraint> allArtVersions(int i) {
        return Lists.newArrayList(new VersionConstraint(Range.openClosed(0, 0), Range.all(), i));
    }

    public static List<VersionConstraint> allVersions(int i) {
        return Lists.newArrayList(new VersionConstraint(Range.all(), Range.all(), i));
    }

    public static List<VersionConstraint> betweenApi(int i, int i2, int i3) {
        return Lists.newArrayList(new VersionConstraint(Range.closed(Integer.valueOf(i2), Integer.valueOf(i3)), Range.openClosed(0, 0), i));
    }

    public static List<VersionConstraint> combine(List<VersionConstraint>... listArr) {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        for (List<VersionConstraint> list : listArr) {
            arrayListNewArrayList.addAll(list);
        }
        return arrayListNewArrayList;
    }

    public static List<VersionConstraint> firstApi(int i, int i2) {
        return Lists.newArrayList(new VersionConstraint(Range.atLeast(Integer.valueOf(i2)), Range.openClosed(0, 0), i));
    }

    public static List<VersionConstraint> firstArtVersion(int i, int i2) {
        return Lists.newArrayList(new VersionConstraint(Range.openClosed(0, 0), Range.atLeast(Integer.valueOf(i2)), i));
    }

    public static List<VersionConstraint> lastApi(int i, int i2) {
        return Lists.newArrayList(new VersionConstraint(Range.atMost(Integer.valueOf(i2)), Range.openClosed(0, 0), i));
    }

    public static List<VersionConstraint> lastArtVersion(int i, int i2) {
        return Lists.newArrayList(new VersionConstraint(Range.openClosed(0, 0), Range.atMost(Integer.valueOf(i2)), i));
    }

    public static Opcode valueOf(String str) {
        return (Opcode) Enum.valueOf(Opcode.class, str);
    }

    public static Opcode[] values() {
        return (Opcode[]) $VALUES.clone();
    }

    public final boolean canContinue() {
        return (this.flags & 4) != 0;
    }

    public final boolean canInitializeReference() {
        return (this.flags & 1024) != 0;
    }

    public final boolean canThrow() {
        return (this.flags & 1) != 0;
    }

    public final boolean isVolatileFieldAccessor() {
        return (this.flags & 128) != 0;
    }

    public final boolean odexOnly() {
        return (this.flags & 2) != 0;
    }

    public final boolean setsRegister() {
        return (this.flags & 16) != 0;
    }

    public final boolean setsResult() {
        return (this.flags & 8) != 0;
    }

    public final boolean setsWideRegister() {
        return (this.flags & 32) != 0;
    }
}
