package org.p088jf.dexlib2.builder.instruction;

import org.p088jf.dexlib2.builder.BuilderSwitchPayload;
import org.p088jf.dexlib2.builder.Label;
import org.p088jf.dexlib2.iface.instruction.SwitchElement;

/* JADX INFO: loaded from: classes.dex */
public class BuilderSwitchElement implements SwitchElement {
    public final int key;
    public BuilderSwitchPayload parent;
    public final Label target;

    public BuilderSwitchElement(BuilderSwitchPayload builderSwitchPayload, int i, Label label) {
        this.parent = builderSwitchPayload;
        this.key = i;
        this.target = label;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.SwitchElement
    public int getKey() {
        return this.key;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.SwitchElement
    public int getOffset() {
        return this.target.getCodeAddress() - this.parent.getReferrer().getCodeAddress();
    }
}
