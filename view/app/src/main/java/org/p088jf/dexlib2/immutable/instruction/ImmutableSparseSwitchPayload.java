package org.p088jf.dexlib2.immutable.instruction;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.SwitchElement;
import org.p088jf.dexlib2.iface.instruction.formats.SparseSwitchPayload;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableSparseSwitchPayload extends ImmutableInstruction implements SparseSwitchPayload {
    public static final Opcode OPCODE = Opcode.SPARSE_SWITCH_PAYLOAD;
    public final ImmutableList<? extends ImmutableSwitchElement> switchElements;

    public ImmutableSparseSwitchPayload(List<? extends SwitchElement> list) {
        super(OPCODE);
        this.switchElements = ImmutableSwitchElement.immutableListOf(list);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableSparseSwitchPayload m3908of(SparseSwitchPayload sparseSwitchPayload) {
        return sparseSwitchPayload instanceof ImmutableSparseSwitchPayload ? (ImmutableSparseSwitchPayload) sparseSwitchPayload : new ImmutableSparseSwitchPayload(sparseSwitchPayload.getSwitchElements());
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction, org.p088jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (this.switchElements.size() * 4) + 2;
    }

    @Override // org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return OPCODE.format;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.SwitchPayload, org.p088jf.dexlib2.iface.instruction.formats.PackedSwitchPayload
    public List<? extends SwitchElement> getSwitchElements() {
        return this.switchElements;
    }
}
