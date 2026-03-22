package org.p088jf.dexlib2.immutable.instruction;

import com.google.common.collect.ImmutableList;
import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.iface.instruction.Instruction;
import org.p088jf.dexlib2.iface.instruction.formats.ArrayPayload;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction10t;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction10x;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction11n;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction11x;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction12x;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction20bc;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction20t;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction21c;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction21ih;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction21lh;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction21s;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction21t;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction22b;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction22c;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction22cs;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction22s;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction22t;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction22x;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction23x;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction30t;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction31c;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction31i;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction31t;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction32x;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction35c;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction35mi;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction35ms;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction3rc;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction3rmi;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction3rms;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction45cc;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction4rcc;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction51l;
import org.p088jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;
import org.p088jf.dexlib2.iface.instruction.formats.SparseSwitchPayload;
import org.p088jf.dexlib2.iface.instruction.formats.UnknownInstruction;
import org.p088jf.dexlib2.util.Preconditions;
import org.p088jf.util.ImmutableConverter;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableInstruction implements Instruction {
    public static final ImmutableConverter<ImmutableInstruction, Instruction> CONVERTER = new ImmutableConverter<ImmutableInstruction, Instruction>() { // from class: org.jf.dexlib2.immutable.instruction.ImmutableInstruction.1
        @Override // org.p088jf.util.ImmutableConverter
        public boolean isImmutable(Instruction instruction) {
            return instruction instanceof ImmutableInstruction;
        }

        @Override // org.p088jf.util.ImmutableConverter
        public ImmutableInstruction makeImmutable(Instruction instruction) {
            return ImmutableInstruction.m3873of(instruction);
        }
    };
    public final Opcode opcode;

    /* JADX INFO: renamed from: org.jf.dexlib2.immutable.instruction.ImmutableInstruction$2 */
    public static /* synthetic */ class C17742 {
        public static final /* synthetic */ int[] $SwitchMap$org$jf$dexlib2$Format;

        static {
            int[] iArr = new int[Format.values().length];
            $SwitchMap$org$jf$dexlib2$Format = iArr;
            try {
                iArr[Format.Format10t.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format10x.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format11n.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format11x.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format12x.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format20bc.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format20t.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format21c.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format21ih.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format21lh.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format21s.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format21t.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22b.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22c.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22cs.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format22x.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format23x.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format30t.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format31c.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format31i.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format31t.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format32x.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format35c.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format35mi.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format35ms.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format3rc.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format3rmi.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format3rms.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format45cc.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format4rcc.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.Format51l.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.PackedSwitchPayload.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.SparseSwitchPayload.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$org$jf$dexlib2$Format[Format.ArrayPayload.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
        }
    }

    public ImmutableInstruction(Opcode opcode) {
        Preconditions.checkFormat(opcode, getFormat());
        this.opcode = opcode;
    }

    public static ImmutableList<ImmutableInstruction> immutableListOf(Iterable<? extends Instruction> iterable) {
        return CONVERTER.toList(iterable);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableInstruction m3873of(Instruction instruction) {
        if (instruction instanceof ImmutableInstruction) {
            return (ImmutableInstruction) instruction;
        }
        switch (C17742.$SwitchMap$org$jf$dexlib2$Format[instruction.getOpcode().format.ordinal()]) {
            case 1:
                return ImmutableInstruction10t.m3874of((Instruction10t) instruction);
            case 2:
                return instruction instanceof UnknownInstruction ? ImmutableUnknownInstruction.m3910of((UnknownInstruction) instruction) : ImmutableInstruction10x.m3875of((Instruction10x) instruction);
            case 3:
                return ImmutableInstruction11n.m3876of((Instruction11n) instruction);
            case 4:
                return ImmutableInstruction11x.m3877of((Instruction11x) instruction);
            case 5:
                return ImmutableInstruction12x.m3878of((Instruction12x) instruction);
            case 6:
                return ImmutableInstruction20bc.m3879of((Instruction20bc) instruction);
            case 7:
                return ImmutableInstruction20t.m3880of((Instruction20t) instruction);
            case 8:
                return ImmutableInstruction21c.m3881of((Instruction21c) instruction);
            case 9:
                return ImmutableInstruction21ih.m3882of((Instruction21ih) instruction);
            case 10:
                return ImmutableInstruction21lh.m3883of((Instruction21lh) instruction);
            case 11:
                return ImmutableInstruction21s.m3884of((Instruction21s) instruction);
            case 12:
                return ImmutableInstruction21t.m3885of((Instruction21t) instruction);
            case 13:
                return ImmutableInstruction22b.m3886of((Instruction22b) instruction);
            case 14:
                return ImmutableInstruction22c.m3887of((Instruction22c) instruction);
            case 15:
                return ImmutableInstruction22cs.m3888of((Instruction22cs) instruction);
            case 16:
                return ImmutableInstruction22s.m3889of((Instruction22s) instruction);
            case 17:
                return ImmutableInstruction22t.m3890of((Instruction22t) instruction);
            case 18:
                return ImmutableInstruction22x.m3891of((Instruction22x) instruction);
            case 19:
                return ImmutableInstruction23x.m3892of((Instruction23x) instruction);
            case 20:
                return ImmutableInstruction30t.m3893of((Instruction30t) instruction);
            case 21:
                return ImmutableInstruction31c.m3894of((Instruction31c) instruction);
            case 22:
                return ImmutableInstruction31i.m3895of((Instruction31i) instruction);
            case 23:
                return ImmutableInstruction31t.m3896of((Instruction31t) instruction);
            case 24:
                return ImmutableInstruction32x.m3897of((Instruction32x) instruction);
            case 25:
                return ImmutableInstruction35c.m3898of((Instruction35c) instruction);
            case 26:
                return ImmutableInstruction35mi.m3899of((Instruction35mi) instruction);
            case 27:
                return ImmutableInstruction35ms.m3900of((Instruction35ms) instruction);
            case 28:
                return ImmutableInstruction3rc.m3901of((Instruction3rc) instruction);
            case 29:
                return ImmutableInstruction3rmi.m3902of((Instruction3rmi) instruction);
            case 30:
                return ImmutableInstruction3rms.m3903of((Instruction3rms) instruction);
            case 31:
                return ImmutableInstruction45cc.m3904of((Instruction45cc) instruction);
            case 32:
                return ImmutableInstruction4rcc.m3905of((Instruction4rcc) instruction);
            case 33:
                return ImmutableInstruction51l.m3906of((Instruction51l) instruction);
            case 34:
                return ImmutablePackedSwitchPayload.m3907of((PackedSwitchPayload) instruction);
            case 35:
                return ImmutableSparseSwitchPayload.m3908of((SparseSwitchPayload) instruction);
            case 36:
                return ImmutableArrayPayload.m3872of((ArrayPayload) instruction);
            default:
                throw new RuntimeException("Unexpected instruction type");
        }
    }

    @Override // org.p088jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return getFormat().size / 2;
    }

    public abstract Format getFormat();

    @Override // org.p088jf.dexlib2.iface.instruction.Instruction
    public Opcode getOpcode() {
        return this.opcode;
    }
}
