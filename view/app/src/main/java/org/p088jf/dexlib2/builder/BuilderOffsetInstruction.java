package org.p088jf.dexlib2.builder;

import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.OffsetInstruction;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public abstract class BuilderOffsetInstruction extends BuilderInstruction implements OffsetInstruction {
    public final Label target;

    public BuilderOffsetInstruction(Opcode opcode, Label label) {
        super(opcode);
        this.target = label;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.OffsetInstruction
    public int getCodeOffset() {
        int iInternalGetCodeOffset = internalGetCodeOffset();
        if (getCodeUnits() == 1) {
            if (iInternalGetCodeOffset < -128 || iInternalGetCodeOffset > 127) {
                throw new ExceptionWithContext("Invalid instruction offset: %d. Offset must be in [-128, 127]", Integer.valueOf(iInternalGetCodeOffset));
            }
        } else if (getCodeUnits() == 2 && (iInternalGetCodeOffset < -32768 || iInternalGetCodeOffset > 32767)) {
            throw new ExceptionWithContext("Invalid instruction offset: %d. Offset must be in [-32768, 32767]", Integer.valueOf(iInternalGetCodeOffset));
        }
        return iInternalGetCodeOffset;
    }

    public Label getTarget() {
        return this.target;
    }

    public int internalGetCodeOffset() {
        return this.target.getCodeAddress() - getLocation().getCodeAddress();
    }
}
