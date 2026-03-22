package jadx.core.dex.nodes.parser;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.C0416o;
import jadx.core.dex.attributes.nodes.SourceFileAttr;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.dex.nodes.DexNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.utils.exceptions.DecodeException;
import java.util.Iterator;
import java.util.List;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
public class DebugInfoParser {
    private static final int DBG_ADVANCE_LINE = 2;
    private static final int DBG_ADVANCE_PC = 1;
    private static final int DBG_END_LOCAL = 5;
    private static final int DBG_END_SEQUENCE = 0;
    private static final int DBG_FIRST_SPECIAL = 10;
    private static final int DBG_LINE_BASE = -4;
    private static final int DBG_LINE_RANGE = 15;
    private static final int DBG_RESTART_LOCAL = 6;
    private static final int DBG_SET_EPILOGUE_BEGIN = 8;
    private static final int DBG_SET_FILE = 9;
    private static final int DBG_SET_PROLOGUE_END = 7;
    private static final int DBG_START_LOCAL = 3;
    private static final int DBG_START_LOCAL_EXTENDED = 4;
    private static final InterfaceC1668b LOG = C1677c.m3845a(DebugInfoParser.class);
    private final InsnArg[] activeRegisters;
    private final DexNode dex;
    private final InsnNode[] insnByOffset;
    private final LocalVar[] locals;
    private final MethodNode mth;
    private final C0416o section;

    public DebugInfoParser(MethodNode methodNode, int i, InsnNode[] insnNodeArr) {
        this.mth = methodNode;
        this.dex = methodNode.dex();
        this.section = this.dex.openSection(i);
        int regsCount = methodNode.getRegsCount();
        this.locals = new LocalVar[regsCount];
        this.activeRegisters = new InsnArg[regsCount];
        this.insnByOffset = insnNodeArr;
    }

    private int addrChange(int i, int i2, int i3) {
        int iMin = Math.min(i + i2, this.insnByOffset.length - 1);
        for (int i4 = i + 1; i4 <= iMin; i4++) {
            InsnNode insnNode = this.insnByOffset[i4];
            if (insnNode != null) {
                for (InsnArg insnArg : insnNode.getArguments()) {
                    if (insnArg.isRegister()) {
                        this.activeRegisters[((RegisterArg) insnArg).getRegNum()] = insnArg;
                    }
                }
                RegisterArg result = insnNode.getResult();
                if (result != null) {
                    this.activeRegisters[result.getRegNum()] = result;
                }
            }
        }
        setSourceLines(i, iMin, i3);
        return iMin;
    }

    private static void fillLocals(InsnNode insnNode, LocalVar localVar) {
        merge(insnNode.getResult(), localVar);
        Iterator it = insnNode.getArguments().iterator();
        while (it.hasNext()) {
            merge((InsnArg) it.next(), localVar);
        }
    }

    private static void merge(InsnArg insnArg, LocalVar localVar) {
        boolean z = true;
        if (insnArg == null || !insnArg.isRegister()) {
            return;
        }
        RegisterArg registerArg = (RegisterArg) insnArg;
        if (localVar.getRegNum() == registerArg.getRegNum()) {
            SSAVar sVar = registerArg.getSVar();
            if (sVar != null) {
                int endAddr = sVar.getEndAddr();
                int startAddr = sVar.getStartAddr();
                int startAddr2 = localVar.getStartAddr();
                int endAddr2 = localVar.getEndAddr();
                if (!(endAddr2 >= startAddr && endAddr >= startAddr2) || endAddr > endAddr2) {
                    z = false;
                }
            }
            if (z) {
                registerArg.mergeDebugInfo(localVar.getType(), localVar.getName());
            }
        }
    }

    private void setLine(int i, int i2) {
        InsnNode insnNode = this.insnByOffset[i];
        if (insnNode != null) {
            insnNode.setSourceLine(i2);
        }
    }

    private void setSourceLines(int i, int i2, int i3) {
        for (int i4 = i + 1; i4 < i2; i4++) {
            setLine(i4, i3);
        }
    }

    private void setVar(LocalVar localVar) {
        int endAddr = localVar.getEndAddr();
        for (int startAddr = localVar.getStartAddr(); startAddr <= endAddr; startAddr++) {
            InsnNode insnNode = this.insnByOffset[startAddr];
            if (insnNode != null) {
                fillLocals(insnNode, localVar);
            }
        }
        merge(this.activeRegisters[localVar.getRegNum()], localVar);
    }

    private void startVar(LocalVar localVar, int i, int i2) {
        SSAVar sVar;
        InsnNode parentInsn;
        int regNum = localVar.getRegNum();
        LocalVar localVar2 = this.locals[regNum];
        if (localVar2 != null && !localVar2.isEnd()) {
            localVar2.end(i, i2);
            setVar(localVar2);
        }
        InsnArg insnArg = this.activeRegisters[localVar.getRegNum()];
        if ((insnArg instanceof RegisterArg) && (sVar = ((RegisterArg) insnArg).getSVar()) != null && sVar.getStartAddr() != -1 && (parentInsn = sVar.getAssign().getParentInsn()) != null && parentInsn.getOffset() >= 0) {
            i = parentInsn.getOffset();
        }
        localVar.start(i, i2);
        this.locals[regNum] = localVar;
    }

    public void process() throws DecodeException {
        int iM2171a;
        int iAddrChange;
        int iM2232b = C0985a.m2232b(this.section);
        int iM2232b2 = C0985a.m2232b(this.section);
        List<RegisterArg> arguments = this.mth.getArguments(false);
        for (int i = 0; i < iM2232b2; i++) {
            int iM2232b3 = C0985a.m2232b(this.section) - 1;
            if (iM2232b3 != -1) {
                String string = this.dex.getString(iM2232b3);
                if (i < arguments.size()) {
                    ((RegisterArg) arguments.get(i)).setName(string);
                }
            }
        }
        for (RegisterArg registerArg : arguments) {
            int regNum = registerArg.getRegNum();
            this.locals[regNum] = new LocalVar(registerArg);
            this.activeRegisters[regNum] = registerArg;
        }
        addrChange(-1, 1, iM2232b);
        setLine(0, iM2232b);
        int iMo306d = this.section.mo306d() & 255;
        int i2 = 0;
        while (iMo306d != 0) {
            switch (iMo306d) {
                case 1:
                    int iAddrChange2 = addrChange(i2, C0985a.m2232b(this.section), iM2232b);
                    setLine(iAddrChange2, iM2232b);
                    iAddrChange = iAddrChange2;
                    iM2171a = iM2232b;
                    continue;
                    iM2232b = iM2171a;
                    i2 = iAddrChange;
                    iMo306d = this.section.mo306d() & 255;
                    break;
                case 2:
                    iM2171a = C0985a.m2171a(this.section) + iM2232b;
                    iAddrChange = i2;
                    continue;
                    iM2232b = iM2171a;
                    i2 = iAddrChange;
                    iMo306d = this.section.mo306d() & 255;
                    break;
                case 3:
                    startVar(new LocalVar(this.dex, C0985a.m2232b(this.section), C0985a.m2232b(this.section) - 1, C0985a.m2232b(this.section) - 1, -1), i2, iM2232b);
                    iM2171a = iM2232b;
                    iAddrChange = i2;
                    continue;
                    iM2232b = iM2171a;
                    i2 = iAddrChange;
                    iMo306d = this.section.mo306d() & 255;
                    break;
                case 4:
                    startVar(new LocalVar(this.dex, C0985a.m2232b(this.section), C0985a.m2232b(this.section) - 1, C0985a.m2232b(this.section) - 1, C0985a.m2232b(this.section) - 1), i2, iM2232b);
                    iM2171a = iM2232b;
                    iAddrChange = i2;
                    continue;
                    iM2232b = iM2171a;
                    i2 = iAddrChange;
                    iMo306d = this.section.mo306d() & 255;
                    break;
                case 5:
                    LocalVar localVar = this.locals[C0985a.m2232b(this.section)];
                    if (localVar != null) {
                        localVar.end(i2, iM2232b);
                        setVar(localVar);
                        iM2171a = iM2232b;
                        iAddrChange = i2;
                    }
                    iM2232b = iM2171a;
                    i2 = iAddrChange;
                    iMo306d = this.section.mo306d() & 255;
                    break;
                case 6:
                    LocalVar localVar2 = this.locals[C0985a.m2232b(this.section)];
                    if (localVar2 != null) {
                        if (localVar2.end(i2, iM2232b)) {
                            setVar(localVar2);
                        }
                        localVar2.start(i2, iM2232b);
                        iM2171a = iM2232b;
                        iAddrChange = i2;
                    }
                    iM2232b = iM2171a;
                    i2 = iAddrChange;
                    iMo306d = this.section.mo306d() & 255;
                    break;
                case 7:
                case 8:
                    iM2171a = iM2232b;
                    iAddrChange = i2;
                    continue;
                    iM2232b = iM2171a;
                    i2 = iAddrChange;
                    iMo306d = this.section.mo306d() & 255;
                    break;
                case 9:
                    int iM2232b4 = C0985a.m2232b(this.section) - 1;
                    if (iM2232b4 != -1) {
                        this.mth.addAttr(new SourceFileAttr(this.dex.getString(iM2232b4)));
                        iM2171a = iM2232b;
                        iAddrChange = i2;
                    }
                    iM2232b = iM2171a;
                    i2 = iAddrChange;
                    iMo306d = this.section.mo306d() & 255;
                    break;
                default:
                    if (iMo306d < 10) {
                        throw new DecodeException("Unknown debug insn code: " + iMo306d);
                    }
                    iAddrChange = addrChange(i2, (iMo306d - 10) / 15, iM2232b);
                    iM2171a = ((r0 % 15) - 4) + iM2232b;
                    setLine(iAddrChange, iM2171a);
                    continue;
                    iM2232b = iM2171a;
                    i2 = iAddrChange;
                    iMo306d = this.section.mo306d() & 255;
                    break;
                    break;
            }
            iM2171a = iM2232b;
            iAddrChange = i2;
            iM2232b = iM2171a;
            i2 = iAddrChange;
            iMo306d = this.section.mo306d() & 255;
        }
        for (LocalVar localVar3 : this.locals) {
            if (localVar3 != null && !localVar3.isEnd()) {
                localVar3.end(this.mth.getCodeSize() - 1, iM2232b);
                setVar(localVar3);
            }
        }
        setSourceLines(i2, this.insnByOffset.length, iM2232b);
    }
}
