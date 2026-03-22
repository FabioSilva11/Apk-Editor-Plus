package org.p088jf.dexlib2.builder.instruction;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderSwitchPayload;
import org.p088jf.dexlib2.builder.SwitchLabelElement;
import org.p088jf.dexlib2.iface.instruction.formats.SparseSwitchPayload;

/* JADX INFO: loaded from: classes.dex */
public class BuilderSparseSwitchPayload extends BuilderSwitchPayload implements SparseSwitchPayload {
    public static final Opcode OPCODE = Opcode.SPARSE_SWITCH_PAYLOAD;
    public final List<BuilderSwitchElement> switchElements;

    public BuilderSparseSwitchPayload(List<? extends SwitchLabelElement> list) {
        super(OPCODE);
        if (list == null) {
            this.switchElements = ImmutableList.m3778of();
        } else {
            this.switchElements = Lists.transform(list, new Function<SwitchLabelElement, BuilderSwitchElement>() { // from class: org.jf.dexlib2.builder.instruction.BuilderSparseSwitchPayload.1
                @Override // com.google.common.base.Function
                public BuilderSwitchElement apply(SwitchLabelElement switchLabelElement) {
                    return new BuilderSwitchElement(BuilderSparseSwitchPayload.this, switchLabelElement.key, switchLabelElement.target);
                }
            });
        }
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction, org.p088jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (this.switchElements.size() * 4) + 2;
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return OPCODE.format;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.SwitchPayload, org.p088jf.dexlib2.iface.instruction.formats.PackedSwitchPayload
    public List<BuilderSwitchElement> getSwitchElements() {
        return this.switchElements;
    }
}
