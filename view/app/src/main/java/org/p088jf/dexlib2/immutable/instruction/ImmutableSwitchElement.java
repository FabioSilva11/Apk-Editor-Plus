package org.p088jf.dexlib2.immutable.instruction;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.p088jf.dexlib2.iface.instruction.SwitchElement;
import org.p088jf.util.ImmutableConverter;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableSwitchElement implements SwitchElement {
    public static final ImmutableConverter<ImmutableSwitchElement, SwitchElement> CONVERTER = new ImmutableConverter<ImmutableSwitchElement, SwitchElement>() { // from class: org.jf.dexlib2.immutable.instruction.ImmutableSwitchElement.1
        @Override // org.p088jf.util.ImmutableConverter
        public boolean isImmutable(SwitchElement switchElement) {
            return switchElement instanceof ImmutableSwitchElement;
        }

        @Override // org.p088jf.util.ImmutableConverter
        public ImmutableSwitchElement makeImmutable(SwitchElement switchElement) {
            return ImmutableSwitchElement.m3909of(switchElement);
        }
    };
    public final int key;
    public final int offset;

    public ImmutableSwitchElement(int i, int i2) {
        this.key = i;
        this.offset = i2;
    }

    public static ImmutableList<ImmutableSwitchElement> immutableListOf(List<? extends SwitchElement> list) {
        return CONVERTER.toList(list);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableSwitchElement m3909of(SwitchElement switchElement) {
        return switchElement instanceof ImmutableSwitchElement ? (ImmutableSwitchElement) switchElement : new ImmutableSwitchElement(switchElement.getKey(), switchElement.getOffset());
    }

    @Override // org.p088jf.dexlib2.iface.instruction.SwitchElement
    public int getKey() {
        return this.key;
    }

    @Override // org.p088jf.dexlib2.iface.instruction.SwitchElement
    public int getOffset() {
        return this.offset;
    }
}
