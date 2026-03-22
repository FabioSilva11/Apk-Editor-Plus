package jadx.core.dex.instructions;

import com.p016a.p019b.p033d.p034a.C0693g;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.PrimitiveType;
import jadx.core.dex.nodes.DexNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FillArrayNode extends InsnNode {
    private final Object data;
    private ArgType elemType;
    private final int size;

    public FillArrayNode(int i, C0693g c0693g) {
        ArgType argTypeUnknown;
        super(InsnType.FILL_ARRAY, 0);
        switch (c0693g.m1312u()) {
            case 1:
                argTypeUnknown = ArgType.unknown(PrimitiveType.BOOLEAN, PrimitiveType.BYTE);
                break;
            case 2:
                argTypeUnknown = ArgType.unknown(PrimitiveType.SHORT, PrimitiveType.CHAR);
                break;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new JadxRuntimeException("Unknown array element width: " + ((int) c0693g.m1312u()));
            case 4:
                argTypeUnknown = ArgType.unknown(PrimitiveType.INT, PrimitiveType.FLOAT);
                break;
            case 8:
                argTypeUnknown = ArgType.unknown(PrimitiveType.LONG, PrimitiveType.DOUBLE);
                break;
        }
        setResult(InsnArg.reg(i, ArgType.array(argTypeUnknown)));
        this.data = c0693g.m1314w();
        this.size = c0693g.m1313v();
        this.elemType = argTypeUnknown;
    }

    public final Object getData() {
        return this.data;
    }

    public final ArgType getElementType() {
        return this.elemType;
    }

    public final List getLiteralArgs() {
        int i = 0;
        ArrayList arrayList = new ArrayList(this.size);
        Object obj = this.data;
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i < length) {
                arrayList.add(InsnArg.lit(r0[i], this.elemType));
                i++;
            }
        } else if (obj instanceof byte[]) {
            int length2 = ((byte[]) obj).length;
            while (i < length2) {
                arrayList.add(InsnArg.lit(r0[i], this.elemType));
                i++;
            }
        } else if (obj instanceof short[]) {
            int length3 = ((short[]) obj).length;
            while (i < length3) {
                arrayList.add(InsnArg.lit(r0[i], this.elemType));
                i++;
            }
        } else {
            if (!(obj instanceof long[])) {
                throw new JadxRuntimeException("Unknown type: " + this.data.getClass() + ", expected: " + this.elemType);
            }
            long[] jArr = (long[]) obj;
            int length4 = jArr.length;
            while (i < length4) {
                arrayList.add(InsnArg.lit(jArr[i], this.elemType));
                i++;
            }
        }
        return arrayList;
    }

    public final int getSize() {
        return this.size;
    }

    @Override // jadx.core.dex.nodes.InsnNode
    public final boolean isSame(InsnNode insnNode) {
        if (this == insnNode) {
            return true;
        }
        if (!(insnNode instanceof FillArrayNode) || !super.isSame(insnNode)) {
            return false;
        }
        FillArrayNode fillArrayNode = (FillArrayNode) insnNode;
        return this.elemType.equals(fillArrayNode.elemType) && this.data == fillArrayNode.data;
    }

    public final void mergeElementType(DexNode dexNode, ArgType argType) {
        ArgType argTypeMerge = ArgType.merge(dexNode, this.elemType, argType);
        if (argTypeMerge != null) {
            this.elemType = argTypeMerge;
        }
    }
}
