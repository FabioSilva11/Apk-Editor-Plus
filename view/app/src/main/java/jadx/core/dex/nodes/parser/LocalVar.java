package jadx.core.dex.nodes.parser;

import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.nodes.DexNode;
import jadx.core.utils.InsnUtils;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
final class LocalVar {
    private static final InterfaceC1668b LOG = C1677c.m3845a(LocalVar.class);
    private int endAddr;
    private boolean isEnd;
    private String name;
    private final int regNum;
    private int startAddr;
    private ArgType type;

    public LocalVar(RegisterArg registerArg) {
        this.regNum = registerArg.getRegNum();
        init(registerArg.getName(), registerArg.getType(), null);
    }

    public LocalVar(DexNode dexNode, int i, int i2, int i3, int i4) {
        this.regNum = i;
        init(i2 == -1 ? null : dexNode.getString(i2), i3 == -1 ? null : dexNode.getType(i3), i4 != -1 ? dexNode.getString(i4) : null);
    }

    private boolean checkSignature(ArgType argType, String str, ArgType argType2) {
        ArgType arrayRootElement = argType2.getArrayRootElement();
        if (!arrayRootElement.isGeneric()) {
            return arrayRootElement.isGenericType();
        }
        if (!argType.getArrayRootElement().getObject().equals(arrayRootElement.getObject())) {
            LOG.mo3821b("Generic type in debug info not equals: {} != {}", argType, argType2);
        }
        return true;
    }

    private void init(String str, ArgType argType, String str2) {
        if (str2 != null) {
            try {
                ArgType argTypeGeneric = ArgType.generic(str2);
                if (checkSignature(argType, str2, argTypeGeneric)) {
                    argType = argTypeGeneric;
                }
            } catch (Exception e) {
                LOG.mo3826c("Can't parse signature for local variable: {}", str2, e);
            }
        }
        this.name = str;
        this.type = argType;
    }

    public final boolean end(int i, int i2) {
        if (this.isEnd) {
            return false;
        }
        this.isEnd = true;
        this.endAddr = i;
        return true;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int getEndAddr() {
        return this.endAddr;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRegNum() {
        return this.regNum;
    }

    public final int getStartAddr() {
        return this.startAddr;
    }

    public final ArgType getType() {
        return this.type;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean isEnd() {
        return this.isEnd;
    }

    public final void start(int i, int i2) {
        this.isEnd = false;
        this.startAddr = i;
    }

    public final String toString() {
        return super.toString() + " " + (this.isEnd ? "end: " + InsnUtils.formatOffset(this.startAddr) + "-" + InsnUtils.formatOffset(this.endAddr) : "active: " + InsnUtils.formatOffset(this.startAddr));
    }
}
