package jadx.core.dex.nodes;

import com.p016a.p019b.p033d.p034a.AbstractC0692f;
import com.p052d.p053a.C0953a;
import jadx.core.dex.attributes.nodes.LineAttrNode;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.InsnWrapArg;
import jadx.core.dex.instructions.args.LiteralArg;
import jadx.core.dex.instructions.args.NamedArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.utils.InsnUtils;
import jadx.core.utils.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InsnNode extends LineAttrNode {
    private static final C0953a INSN_CLONER;
    private final List arguments;
    protected final InsnType insnType;
    protected int offset = -1;
    private RegisterArg result;

    static {
        C0953a c0953a = new C0953a();
        INSN_CLONER = c0953a;
        c0953a.m2108a(ArgType.class, SSAVar.class, LiteralArg.class, NamedArg.class);
        INSN_CLONER.m2109b(RegisterArg.class);
    }

    public InsnNode(InsnType insnType, int i) {
        this.insnType = insnType;
        if (i == 0) {
            this.arguments = Collections.emptyList();
        } else {
            this.arguments = new ArrayList(i);
        }
    }

    public static InsnNode wrapArg(InsnArg insnArg) {
        InsnNode insnNode = new InsnNode(InsnType.ONE_ARG, 1);
        insnNode.addArg(insnArg);
        return insnNode;
    }

    public void addArg(InsnArg insnArg) {
        insnArg.setParentInsn(this);
        this.arguments.add(insnArg);
    }

    protected void addLit(long j, ArgType argType) {
        addArg(InsnArg.lit(j, argType));
    }

    protected void addLit(AbstractC0692f abstractC0692f, ArgType argType) {
        addArg(InsnArg.lit(abstractC0692f, argType));
    }

    protected void addReg(int i, ArgType argType) {
        addArg(InsnArg.reg(i, argType));
    }

    protected void addReg(AbstractC0692f abstractC0692f, int i, ArgType argType) {
        addArg(InsnArg.reg(abstractC0692f, i, argType));
    }

    public boolean canReorder() {
        switch (getType()) {
            case CONST:
            case CONST_STR:
            case CONST_CLASS:
            case CAST:
            case MOVE:
            case ARITH:
            case NEG:
            case CMP_L:
            case CMP_G:
            case CHECK_CAST:
            case INSTANCE_OF:
            case FILL_ARRAY:
            case FILLED_NEW_ARRAY:
            case NEW_ARRAY:
            case NEW_MULTIDIM_ARRAY:
            case STR_CONCAT:
                return true;
            default:
                return false;
        }
    }

    public boolean canReorderRecursive() {
        if (!canReorder()) {
            return false;
        }
        for (InsnArg insnArg : getArguments()) {
            if (insnArg.isInsnWrap() && !((InsnWrapArg) insnArg).getWrapInsn().canReorderRecursive()) {
                return false;
            }
        }
        return true;
    }

    public boolean containsArg(RegisterArg registerArg) {
        for (InsnArg insnArg : this.arguments) {
            if (insnArg == registerArg || (insnArg.isRegister() && ((RegisterArg) insnArg).getRegNum() == registerArg.getRegNum())) {
                return true;
            }
        }
        return false;
    }

    public InsnNode copy() {
        return getClass() == InsnNode.class ? copyCommonParams(new InsnNode(this.insnType, getArgsCount())) : (InsnNode) INSN_CLONER.m2106a(this);
    }

    protected InsnNode copyCommonParams(InsnNode insnNode) {
        insnNode.setResult(this.result);
        if (insnNode.getArgsCount() == 0) {
            for (InsnArg insnArg : getArguments()) {
                if (insnArg.isInsnWrap()) {
                    insnNode.addArg(InsnArg.wrapArg(((InsnWrapArg) insnArg).getWrapInsn().copy()));
                } else {
                    insnNode.addArg(insnArg);
                }
            }
        }
        insnNode.copyAttributesFrom(this);
        insnNode.copyLines(this);
        insnNode.setOffset(getOffset());
        return insnNode;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public InsnArg getArg(int i) {
        return (InsnArg) this.arguments.get(i);
    }

    public int getArgsCount() {
        return this.arguments.size();
    }

    public Iterable getArguments() {
        return this.arguments;
    }

    public int getOffset() {
        return this.offset;
    }

    public void getRegisterArgs(Collection collection) {
        for (InsnArg insnArg : getArguments()) {
            if (insnArg.isRegister()) {
                collection.add((RegisterArg) insnArg);
            } else if (insnArg.isInsnWrap()) {
                ((InsnWrapArg) insnArg).getWrapInsn().getRegisterArgs(collection);
            }
        }
    }

    public RegisterArg getResult() {
        return this.result;
    }

    public InsnType getType() {
        return this.insnType;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public boolean isConstInsn() {
        switch (getType()) {
            case CONST:
            case CONST_STR:
            case CONST_CLASS:
                return true;
            default:
                return false;
        }
    }

    public boolean isSame(InsnNode insnNode) {
        int i;
        if (this == insnNode) {
            return true;
        }
        if (this.insnType != insnNode.insnType || this.arguments.size() != insnNode.arguments.size()) {
            return false;
        }
        int size = this.arguments.size();
        for (0; i < size; i + 1) {
            InsnArg insnArg = (InsnArg) this.arguments.get(i);
            InsnArg insnArg2 = (InsnArg) insnNode.arguments.get(i);
            i = (!insnArg.isInsnWrap() || (insnArg2.isInsnWrap() && ((InsnWrapArg) insnArg).getWrapInsn().isSame(((InsnWrapArg) insnArg2).getWrapInsn()))) ? i + 1 : 0;
            return false;
        }
        return true;
    }

    protected boolean removeArg(InsnArg insnArg) {
        int argsCount = getArgsCount();
        for (int i = 0; i < argsCount; i++) {
            if (insnArg == this.arguments.get(i)) {
                this.arguments.remove(i);
                if (insnArg instanceof RegisterArg) {
                    RegisterArg registerArg = (RegisterArg) insnArg;
                    registerArg.getSVar().removeUse(registerArg);
                }
                return true;
            }
        }
        return false;
    }

    public boolean replaceArg(InsnArg insnArg, InsnArg insnArg2) {
        int argsCount = getArgsCount();
        for (int i = 0; i < argsCount; i++) {
            InsnArg insnArg3 = (InsnArg) this.arguments.get(i);
            if (insnArg3 == insnArg) {
                setArg(i, insnArg2);
                return true;
            }
            if (insnArg3.isInsnWrap() && ((InsnWrapArg) insnArg3).getWrapInsn().replaceArg(insnArg, insnArg2)) {
                return true;
            }
        }
        return false;
    }

    public void setArg(int i, InsnArg insnArg) {
        insnArg.setParentInsn(this);
        this.arguments.set(i, insnArg);
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public void setResult(RegisterArg registerArg) {
        if (registerArg != null) {
            registerArg.setParentInsn(this);
        }
        this.result = registerArg;
    }

    public String toString() {
        return InsnUtils.formatOffset(this.offset) + ": " + InsnUtils.insnTypeToString(this.insnType) + (this.result == null ? "" : this.result + " = ") + Utils.listToString(this.arguments);
    }
}
