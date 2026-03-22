package org.p088jf.dexlib2.iface.instruction;

import org.p088jf.dexlib2.iface.reference.Reference;

/* JADX INFO: loaded from: classes.dex */
public interface ReferenceInstruction extends Instruction {
    Reference getReference();

    int getReferenceType();
}
