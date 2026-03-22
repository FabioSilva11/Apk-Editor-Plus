package jadx.core.dex.instructions.args;

import android.support.v7.widget.ActivityChooserView;
import jadx.core.dex.attributes.AttrNode;
import jadx.core.dex.instructions.PhiInsn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SSAVar extends AttrNode {
    private RegisterArg assign;
    private int endUseAddr;
    private final int regNum;
    private int startUseAddr;
    private ArgType type;
    private boolean typeImmutable;
    private final List useList = new ArrayList(2);
    private PhiInsn usedInPhi;
    private VarName varName;
    private final int version;

    public SSAVar(int i, int i2, RegisterArg registerArg) {
        this.regNum = i;
        this.version = i2;
        this.assign = registerArg;
        registerArg.setSVar(this);
        this.startUseAddr = -1;
        this.endUseAddr = -1;
    }

    private void calcUsageAddrRange() {
        int iMax;
        int iMin;
        int iMin2;
        int iMax2;
        int offset;
        int offset2;
        if (this.assign.getParentInsn() == null || (offset2 = this.assign.getParentInsn().getOffset()) < 0) {
            iMax = Integer.MIN_VALUE;
            iMin = Integer.MAX_VALUE;
        } else {
            iMin = Math.min(offset2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            iMax = Math.max(offset2, Integer.MIN_VALUE);
        }
        Iterator it = this.useList.iterator();
        while (true) {
            iMin2 = iMin;
            iMax2 = iMax;
            if (!it.hasNext()) {
                break;
            }
            RegisterArg registerArg = (RegisterArg) it.next();
            if (registerArg.getParentInsn() != null && (offset = registerArg.getParentInsn().getOffset()) >= 0) {
                iMin2 = Math.min(offset, iMin2);
                iMax2 = Math.max(offset, iMax2);
            }
            iMax = iMax2;
            iMin = iMin2;
        }
        if (iMin2 == Integer.MAX_VALUE || iMax2 == Integer.MIN_VALUE) {
            return;
        }
        this.startUseAddr = iMin2;
        this.endUseAddr = iMax2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SSAVar)) {
            return false;
        }
        SSAVar sSAVar = (SSAVar) obj;
        return this.regNum == sSAVar.regNum && this.version == sSAVar.version;
    }

    public RegisterArg getAssign() {
        return this.assign;
    }

    public int getEndAddr() {
        if (this.endUseAddr == -1) {
            calcUsageAddrRange();
        }
        return this.endUseAddr;
    }

    public String getName() {
        if (this.varName == null) {
            return null;
        }
        return this.varName.getName();
    }

    public int getRegNum() {
        return this.regNum;
    }

    public int getStartAddr() {
        if (this.startUseAddr == -1) {
            calcUsageAddrRange();
        }
        return this.startUseAddr;
    }

    public int getUseCount() {
        return this.useList.size();
    }

    public List getUseList() {
        return this.useList;
    }

    public PhiInsn getUsedInPhi() {
        return this.usedInPhi;
    }

    public VarName getVarName() {
        return this.varName;
    }

    public int getVariableUseCount() {
        return this.usedInPhi == null ? this.useList.size() : this.useList.size() + this.usedInPhi.getResult().getSVar().getUseCount();
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (this.regNum * 31) + this.version;
    }

    public boolean isTypeImmutable() {
        return this.typeImmutable;
    }

    public boolean isUsedInPhi() {
        return this.usedInPhi != null;
    }

    public void removeUse(RegisterArg registerArg) {
        int size = this.useList.size();
        for (int i = 0; i < size; i++) {
            if (this.useList.get(i) == registerArg) {
                this.useList.remove(i);
                return;
            }
        }
    }

    public void setAssign(RegisterArg registerArg) {
        this.assign = registerArg;
    }

    public void setName(String str) {
        if (str != null) {
            if (this.varName == null) {
                this.varName = new VarName();
            }
            this.varName.setName(str);
        }
    }

    public void setType(ArgType argType) {
        if (this.typeImmutable) {
            argType = this.type;
        } else {
            this.type = argType;
        }
        this.assign.type = argType;
        int size = this.useList.size();
        for (int i = 0; i < size; i++) {
            ((RegisterArg) this.useList.get(i)).type = argType;
        }
    }

    public void setTypeImmutable(ArgType argType) {
        setType(argType);
        this.typeImmutable = true;
    }

    public void setUsedInPhi(PhiInsn phiInsn) {
        this.usedInPhi = phiInsn;
    }

    public void setVarName(VarName varName) {
        this.varName = varName;
    }

    public String toString() {
        return "r" + this.regNum + "_" + this.version;
    }

    public void use(RegisterArg registerArg) {
        if (registerArg.getSVar() != null) {
            registerArg.getSVar().removeUse(registerArg);
        }
        registerArg.setSVar(this);
        this.useList.add(registerArg);
    }
}
