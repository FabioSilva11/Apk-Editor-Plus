package org.p088jf.dexlib2.builder;

import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.SwitchPayload;

/* JADX INFO: loaded from: classes.dex */
public abstract class BuilderSwitchPayload extends BuilderInstruction implements SwitchPayload {
    public MethodLocation referrer;

    public BuilderSwitchPayload(Opcode opcode) {
        super(opcode);
    }

    public MethodLocation getReferrer() {
        MethodLocation methodLocation = this.referrer;
        if (methodLocation != null) {
            return methodLocation;
        }
        throw new IllegalStateException("The referrer has not been set yet");
    }
}
