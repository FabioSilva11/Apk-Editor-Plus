package org.p088jf.dexlib2.iface.instruction;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SwitchPayload extends Instruction {
    List<? extends SwitchElement> getSwitchElements();
}
