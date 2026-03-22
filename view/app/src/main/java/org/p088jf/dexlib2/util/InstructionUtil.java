package org.p088jf.dexlib2.util;

import org.p088jf.dexlib2.Opcode;

/* JADX INFO: loaded from: classes.dex */
public final class InstructionUtil {
    public static boolean isInvokePolymorphic(Opcode opcode) {
        return opcode == Opcode.INVOKE_POLYMORPHIC || opcode == Opcode.INVOKE_POLYMORPHIC_RANGE;
    }

    public static boolean isInvokeStatic(Opcode opcode) {
        return opcode == Opcode.INVOKE_STATIC || opcode == Opcode.INVOKE_STATIC_RANGE;
    }
}
