package org.p088jf.dexlib2.iface.instruction;

import org.p088jf.dexlib2.Opcode;

/* JADX INFO: loaded from: classes.dex */
public interface Instruction {
    int getCodeUnits();

    Opcode getOpcode();
}
