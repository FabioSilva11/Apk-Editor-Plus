package org.p088jf.dexlib2.builder.instruction;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderSwitchPayload;
import org.p088jf.dexlib2.builder.Label;
import org.p088jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;

/* JADX INFO: loaded from: classes.dex */
public class BuilderPackedSwitchPayload extends BuilderSwitchPayload implements PackedSwitchPayload {
    public static final Opcode OPCODE = Opcode.PACKED_SWITCH_PAYLOAD;
    public final List<BuilderSwitchElement> switchElements;

    public BuilderPackedSwitchPayload(int i, List<? extends Label> list) {
        super(OPCODE);
        if (list == null) {
            this.switchElements = ImmutableList.m3778of();
            return;
        }
        this.switchElements = Lists.newArrayList();
        Iterator<? extends Label> it = list.iterator();
        while (it.hasNext()) {
            this.switchElements.add(new BuilderSwitchElement(this, i, it.next()));
            i++;
        }
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction, org.p088jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (this.switchElements.size() * 2) + 4;
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
