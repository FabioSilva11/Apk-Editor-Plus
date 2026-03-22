package org.p088jf.dexlib2.iface;

import java.util.List;
import org.p088jf.dexlib2.iface.debug.DebugItem;
import org.p088jf.dexlib2.iface.instruction.Instruction;

/* JADX INFO: loaded from: classes.dex */
public interface MethodImplementation {
    Iterable<? extends DebugItem> getDebugItems();

    Iterable<? extends Instruction> getInstructions();

    int getRegisterCount();

    List<? extends TryBlock<? extends ExceptionHandler>> getTryBlocks();
}
