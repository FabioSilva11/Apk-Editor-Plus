package org.p088jf.dexlib2.util;

import android.support.v4.view.InputDeviceCompat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.VerificationError;
import org.p088jf.dexlib2.iface.instruction.SwitchElement;

/* JADX INFO: loaded from: classes.dex */
public class Preconditions {
    public static int check35cAnd45ccRegisterCount(int i) {
        if (i < 0 || i > 5) {
            throw new IllegalArgumentException(String.format("Invalid register count: %d. Must be between 0 and 5, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    public static int checkArrayPayloadElementWidth(int i) {
        if (i == 1 || i == 2 || i == 4 || i == 8) {
            return i;
        }
        throw new IllegalArgumentException(String.format("Not a valid element width: %d", Integer.valueOf(i)));
    }

    public static <L extends List<? extends Number>> L checkArrayPayloadElements(int i, L l) {
        long j = (1 << ((i * 8) - 1)) - 1;
        long j2 = (-j) - 1;
        Iterator it = l.iterator();
        while (it.hasNext()) {
            Number number = (Number) it.next();
            if (number.longValue() < j2 || number.longValue() > j) {
                throw new IllegalArgumentException(String.format("%d does not fit into a %d-byte signed integer", Long.valueOf(number.longValue()), Integer.valueOf(i)));
            }
        }
        return l;
    }

    public static int checkByteCodeOffset(int i) {
        if (i < -128 || i > 127) {
            throw new IllegalArgumentException(String.format("Invalid code offset: %d. Must be between -128 and 127, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    public static int checkByteLiteral(int i) {
        if (i < -128 || i > 127) {
            throw new IllegalArgumentException(String.format("Invalid literal value: %d. Must be between -128 and 127, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    public static int checkByteRegister(int i) {
        if ((i & InputDeviceCompat.SOURCE_ANY) == 0) {
            return i;
        }
        throw new IllegalArgumentException(String.format("Invalid register: v%d. Must be between v0 and v255, inclusive.", Integer.valueOf(i)));
    }

    public static int checkFieldOffset(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException(String.format("Invalid field offset: 0x%x. Must be between 0x0000 and 0xFFFF inclusive", Integer.valueOf(i)));
        }
        return i;
    }

    public static void checkFormat(Opcode opcode, Format format) {
        if (opcode.format != format) {
            throw new IllegalArgumentException(String.format("Invalid opcode %s for %s", opcode.name, format.name()));
        }
    }

    public static int checkInlineIndex(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException(String.format("Invalid inline index: %d. Must be between 0 and 65535, inclusive", Integer.valueOf(i)));
        }
        return i;
    }

    public static int checkIntegerHatLiteral(int i) {
        if ((65535 & i) == 0) {
            return i;
        }
        throw new IllegalArgumentException(String.format("Invalid literal value: %d. Low 16 bits must be zeroed out.", Integer.valueOf(i)));
    }

    public static long checkLongHatLiteral(long j) {
        if ((281474976710655L & j) == 0) {
            return j;
        }
        throw new IllegalArgumentException(String.format("Invalid literal value: %d. Low 48 bits must be zeroed out.", Long.valueOf(j)));
    }

    public static int checkNibbleLiteral(int i) {
        if (i < -8 || i > 7) {
            throw new IllegalArgumentException(String.format("Invalid literal value: %d. Must be between -8 and 7, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    public static int checkNibbleRegister(int i) {
        if ((i & (-16)) == 0) {
            return i;
        }
        throw new IllegalArgumentException(String.format("Invalid register: v%d. Must be between v0 and v15, inclusive.", Integer.valueOf(i)));
    }

    public static int checkRegisterRangeCount(int i) {
        if ((i & InputDeviceCompat.SOURCE_ANY) == 0) {
            return i;
        }
        throw new IllegalArgumentException(String.format("Invalid register count: %d. Must be between 0 and 255, inclusive.", Integer.valueOf(i)));
    }

    public static <C extends Collection<? extends SwitchElement>> C checkSequentialOrderedKeys(C c) {
        Iterator it = c.iterator();
        Integer numValueOf = null;
        while (it.hasNext()) {
            int key = ((SwitchElement) it.next()).getKey();
            if (numValueOf != null && numValueOf.intValue() + 1 != key) {
                throw new IllegalArgumentException("SwitchElement set is not sequential and ordered");
            }
            numValueOf = Integer.valueOf(key);
        }
        return c;
    }

    public static int checkShortCodeOffset(int i) {
        if (i < -32768 || i > 32767) {
            throw new IllegalArgumentException(String.format("Invalid code offset: %d. Must be between -32768 and 32767, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    public static int checkShortLiteral(int i) {
        if (i < -32768 || i > 32767) {
            throw new IllegalArgumentException(String.format("Invalid literal value: %d. Must be between -32768 and 32767, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    public static int checkShortRegister(int i) {
        if (((-65536) & i) == 0) {
            return i;
        }
        throw new IllegalArgumentException(String.format("Invalid register: v%d. Must be between v0 and v65535, inclusive.", Integer.valueOf(i)));
    }

    public static void checkValueArg(int i, int i2) {
        if (i > i2) {
            if (i2 != 0) {
                throw new IllegalArgumentException(String.format("Invalid value_arg value %d for an encoded_value. Expecting 0..%d, inclusive", Integer.valueOf(i), Integer.valueOf(i2)));
            }
            throw new IllegalArgumentException(String.format("Invalid value_arg value %d for an encoded_value. Expecting 0", Integer.valueOf(i)));
        }
    }

    public static int checkVerificationError(int i) {
        if (VerificationError.isValidVerificationError(i)) {
            return i;
        }
        throw new IllegalArgumentException(String.format("Invalid verification error value: %d. Must be between 1 and 9, inclusive", Integer.valueOf(i)));
    }

    public static int checkVtableIndex(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException(String.format("Invalid vtable index: %d. Must be between 0 and 65535, inclusive", Integer.valueOf(i)));
        }
        return i;
    }
}
