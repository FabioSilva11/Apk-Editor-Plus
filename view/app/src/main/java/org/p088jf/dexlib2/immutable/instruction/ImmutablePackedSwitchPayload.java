package org.p088jf.dexlib2.immutable.instruction;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.SwitchElement;
import org.p088jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;
import org.p088jf.dexlib2.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ImmutablePackedSwitchPayload extends ImmutableInstruction implements PackedSwitchPayload {
    public static final Opcode OPCODE = Opcode.PACKED_SWITCH_PAYLOAD;
    public final ImmutableList<? extends ImmutableSwitchElement> switchElements;

    public ImmutablePackedSwitchPayload(List<? extends SwitchElement> list) {
        super(OPCODE);
        this.switchElements = (ImmutableList) Preconditions.checkSequentialOrderedKeys(ImmutableSwitchElement.immutableListOf(list));
    }

    /* JADX INFO: renamed from: of */
    public static ImmutablePackedSwitchPayload m3907of(PackedSwitchPayload packedSwitchPayload) {
        return packedSwitchPayload instanceof ImmutablePackedSwitchPayload ? (ImmutablePackedSwitchPayload) packedSwitchPayload : new ImmutablePackedSwitchPayload(packedSwitchPayload.getSwitchElements());
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction, org.p088jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (this.switchElements.size() * 2) + 4;
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return OPCODE.format;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.formats.PackedSwitchPayload
    public List<? extends SwitchElement> getSwitchElements() {
        return this.switchElements;
    }
}
