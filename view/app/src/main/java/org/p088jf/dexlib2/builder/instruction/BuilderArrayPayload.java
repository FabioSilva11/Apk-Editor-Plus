package org.p088jf.dexlib2.builder.instruction;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.builder.BuilderInstruction;
import org.p088jf.dexlib2.iface.instruction.formats.ArrayPayload;

/* JADX INFO: loaded from: classes.dex */
public class BuilderArrayPayload extends BuilderInstruction implements ArrayPayload {
    public static final Opcode OPCODE = Opcode.ARRAY_PAYLOAD;
    public final List<Number> arrayElements;
    public final int elementWidth;

    public BuilderArrayPayload(int i, List<Number> list) {
        super(OPCODE);
        this.elementWidth = i;
        this.arrayElements = list == null ? ImmutableList.m3778of() : list;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.formats.ArrayPayload
    public List<Number> getArrayElements() {
        return this.arrayElements;
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction, org.p088jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (((this.elementWidth * this.arrayElements.size()) + 1) / 2) + 4;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.formats.ArrayPayload
    public int getElementWidth() {
        return this.elementWidth;
    }

    @Override // org.p088jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return OPCODE.format;
    }
}
