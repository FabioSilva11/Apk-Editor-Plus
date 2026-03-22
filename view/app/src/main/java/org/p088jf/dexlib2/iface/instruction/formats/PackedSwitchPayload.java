package org.p088jf.dexlib2.iface.instruction.formats;

import java.util.List;
import org.p088jf.dexlib2.iface.instruction.SwitchElement;
import org.p088jf.dexlib2.iface.instruction.SwitchPayload;

/* JADX INFO: loaded from: classes.dex */
public interface PackedSwitchPayload extends SwitchPayload {
    List<? extends SwitchElement> getSwitchElements();
}
