package jadx.core.dex.instructions.mods;

import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.info.MethodInfo;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.InvokeNode;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;

/* JADX INFO: loaded from: classes.dex */
public class ConstructorInsn extends InsnNode {
    private final MethodInfo callMth;
    private final CallType callType;
    private final RegisterArg instanceArg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public enum CallType {
        CONSTRUCTOR,
        SUPER,
        THIS,
        SELF
    }

    public ConstructorInsn(MethodInfo methodInfo, CallType callType, RegisterArg registerArg) {
        super(InsnType.CONSTRUCTOR, methodInfo.getArgsCount());
        this.callMth = methodInfo;
        this.callType = callType;
        this.instanceArg = registerArg;
    }

    public ConstructorInsn(MethodNode methodNode, InvokeNode invokeNode) {
        super(InsnType.CONSTRUCTOR, invokeNode.getArgsCount() - 1);
        this.callMth = invokeNode.getCallMth();
        ClassInfo declClass = this.callMth.getDeclClass();
        this.instanceArg = (RegisterArg) invokeNode.getArg(0);
        if (!this.instanceArg.isThis()) {
            this.callType = CallType.CONSTRUCTOR;
            setResult(this.instanceArg);
            this.instanceArg.getSVar().setAssign(this.instanceArg);
        } else if (!declClass.equals(methodNode.getParentClass().getClassInfo())) {
            this.callType = CallType.SUPER;
        } else if (this.callMth.getShortId().equals(methodNode.getMethodInfo().getShortId())) {
            this.callType = CallType.SELF;
        } else {
            this.callType = CallType.THIS;
        }
        this.instanceArg.getSVar().removeUse(this.instanceArg);
        for (int i = 1; i < invokeNode.getArgsCount(); i++) {
            addArg(invokeNode.getArg(i));
        }
        this.offset = invokeNode.getOffset();
        setSourceLine(invokeNode.getSourceLine());
    }

    public MethodInfo getCallMth() {
        return this.callMth;
    }

    public CallType getCallType() {
        return this.callType;
    }

    public ClassInfo getClassType() {
        return this.callMth.getDeclClass();
    }

    public RegisterArg getInstanceArg() {
        return this.instanceArg;
    }

    public boolean isNewInstance() {
        return this.callType == CallType.CONSTRUCTOR;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public boolean isSame(InsnNode insnNode) {
        if (this == insnNode) {
            return true;
        }
        if (!(insnNode instanceof ConstructorInsn) || !super.isSame(insnNode)) {
            return false;
        }
        ConstructorInsn constructorInsn = (ConstructorInsn) insnNode;
        return this.callMth.equals(constructorInsn.callMth) && this.callType == constructorInsn.callType;
    }

    public boolean isSelf() {
        return this.callType == CallType.SELF;
    }

    public boolean isSuper() {
        return this.callType == CallType.SUPER;
    }

    public boolean isThis() {
        return this.callType == CallType.THIS;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public String toString() {
        return super.toString() + " " + this.callMth + " " + this.callType;
    }
}
