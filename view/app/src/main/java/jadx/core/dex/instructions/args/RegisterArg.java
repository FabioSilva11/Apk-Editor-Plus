package jadx.core.dex.instructions.args;

import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.PhiInsn;
import jadx.core.dex.nodes.DexNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.utils.InsnUtils;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
public class RegisterArg extends InsnArg implements Named {
    private static final InterfaceC1668b LOG = C1677c.m3845a(RegisterArg.class);
    protected final int regNum;
    private SSAVar sVar;

    public RegisterArg(int i) {
        this.regNum = i;
    }

    public RegisterArg(int i, ArgType argType) {
        this.type = argType;
        this.regNum = i;
    }

    public RegisterArg duplicate() {
        return duplicate(getRegNum(), this.sVar);
    }

    public RegisterArg duplicate(int i, SSAVar sSAVar) {
        RegisterArg registerArg = new RegisterArg(i, getType());
        if (sSAVar != null) {
            registerArg.setSVar(sSAVar);
        }
        registerArg.copyAttributesFrom(this);
        return registerArg;
    }

    public boolean equalRegisterAndType(RegisterArg registerArg) {
        return this.regNum == registerArg.regNum && this.type.equals(registerArg.type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof RegisterArg)) {
            RegisterArg registerArg = (RegisterArg) obj;
            if (this.regNum == registerArg.regNum && this.type.equals(registerArg.type)) {
                return this.sVar == null || this.sVar.equals(registerArg.getSVar());
            }
            return false;
        }
        return false;
    }

    public InsnNode getAssignInsn() {
        if (this.sVar == null) {
            return null;
        }
        return this.sVar.getAssign().getParentInsn();
    }

    public Object getConstValue(DexNode dexNode) {
        InsnNode assignInsn = getAssignInsn();
        if (assignInsn == null) {
            return null;
        }
        return InsnUtils.getConstValueByInsn(dexNode, assignInsn);
    }

    @Override // jadx.core.dex.instructions.args.Named
    public String getName() {
        if (this.sVar == null) {
            return null;
        }
        return this.sVar.getName();
    }

    public InsnNode getPhiAssignInsn() {
        PhiInsn usedInPhi = this.sVar.getUsedInPhi();
        if (usedInPhi != null) {
            return usedInPhi;
        }
        InsnNode parentInsn = this.sVar.getAssign().getParentInsn();
        if (parentInsn == null || parentInsn.getType() != InsnType.PHI) {
            return null;
        }
        return parentInsn;
    }

    public int getRegNum() {
        return this.regNum;
    }

    public SSAVar getSVar() {
        return this.sVar;
    }

    public int hashCode() {
        return (this.regNum * 31) + this.type.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isNameEquals(InsnArg insnArg) {
        String name = getName();
        if (name == null || !(insnArg instanceof Named)) {
            return false;
        }
        return name.equals(((Named) insnArg).getName());
    }

    @Override // jadx.core.dex.instructions.args.InsnArg
    public boolean isRegister() {
        return true;
    }

    @Override // jadx.core.dex.instructions.args.InsnArg
    public boolean isThis() {
        InsnArg arg;
        if ("this".equals(getName())) {
            return true;
        }
        InsnNode assignInsn = getAssignInsn();
        if (assignInsn == null || assignInsn.getType() != InsnType.MOVE || (arg = assignInsn.getArg(0)) == this) {
            return false;
        }
        return arg.isThis();
    }

    public void mergeDebugInfo(ArgType argType, String str) {
        setType(argType);
        setName(str);
    }

    @Override // jadx.core.dex.instructions.args.Named
    public void setName(String str) {
        if (this.sVar != null) {
            this.sVar.setName(str);
        }
    }

    void setSVar(SSAVar sSAVar) {
        this.sVar = sSAVar;
    }

    @Override // jadx.core.dex.instructions.args.Typed
    public void setType(ArgType argType) {
        if (this.sVar != null) {
            this.sVar.setType(argType);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(r");
        sb.append(this.regNum);
        if (this.sVar != null) {
            sb.append("_").append(this.sVar.getVersion());
        }
        if (getName() != null) {
            sb.append(" '").append(getName()).append("'");
        }
        sb.append(" ");
        sb.append(this.type);
        sb.append(")");
        return sb.toString();
    }
}
