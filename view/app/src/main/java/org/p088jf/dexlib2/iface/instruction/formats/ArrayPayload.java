package org.p088jf.dexlib2.iface.instruction.formats;

import java.util.List;
import org.p088jf.dexlib2.iface.instruction.Instruction;

/* JADX INFO: loaded from: classes.dex */
public interface ArrayPayload extends Instruction {
    List<Number> getArrayElements();

    int getElementWidth();
}
