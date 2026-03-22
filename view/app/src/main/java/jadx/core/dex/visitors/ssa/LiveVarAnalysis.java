package jadx.core.dex.visitors.ssa;

import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LiveVarAnalysis {
    private BitSet[] assignBlocks;
    private BitSet[] defs;
    private BitSet[] liveIn;
    private final MethodNode mth;
    private BitSet[] uses;

    public LiveVarAnalysis(MethodNode methodNode) {
        this.mth = methodNode;
    }

    private void fillBasicBlockInfo() {
        for (BlockNode blockNode : this.mth.getBasicBlocks()) {
            int id = blockNode.getId();
            BitSet bitSet = this.uses[id];
            BitSet bitSet2 = this.defs[id];
            for (InsnNode insnNode : blockNode.getInstructions()) {
                for (InsnArg insnArg : insnNode.getArguments()) {
                    if (insnArg.isRegister()) {
                        int regNum = ((RegisterArg) insnArg).getRegNum();
                        if (!bitSet2.get(regNum)) {
                            bitSet.set(regNum);
                        }
                    }
                }
                RegisterArg result = insnNode.getResult();
                if (result != null) {
                    int regNum2 = result.getRegNum();
                    bitSet2.set(regNum2);
                    this.assignBlocks[regNum2].set(id);
                }
            }
        }
    }

    private static BitSet[] initBitSetArray(int i, int i2) {
        BitSet[] bitSetArr = new BitSet[i];
        for (int i3 = 0; i3 < i; i3++) {
            bitSetArr[i3] = new BitSet(i2);
        }
        return bitSetArr;
    }

    private void processLiveInfo() {
        boolean z;
        int size = this.mth.getBasicBlocks().size();
        int regsCount = this.mth.getRegsCount();
        BitSet[] bitSetArrInitBitSetArray = initBitSetArray(size, regsCount);
        List basicBlocks = this.mth.getBasicBlocks();
        int size2 = basicBlocks.size();
        int i = 0;
        while (true) {
            int i2 = 0;
            boolean z2 = false;
            while (i2 < size2) {
                BlockNode blockNode = (BlockNode) basicBlocks.get(i2);
                int id = blockNode.getId();
                BitSet bitSet = bitSetArrInitBitSetArray[id];
                BitSet bitSet2 = new BitSet(regsCount);
                List successors = blockNode.getSuccessors();
                int size3 = successors.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    bitSet2.or(bitSetArrInitBitSetArray[((BlockNode) successors.get(i3)).getId()]);
                }
                bitSet2.andNot(this.defs[id]);
                bitSet2.or(this.uses[id]);
                if (bitSet.equals(bitSet2)) {
                    z = z2;
                } else {
                    z = true;
                    bitSetArrInitBitSetArray[id] = bitSet2;
                }
                i2++;
                z2 = z;
            }
            int i4 = i + 1;
            if (i > 1000) {
                throw new JadxRuntimeException("Live variable analysis reach iterations limit");
            }
            if (!z2) {
                this.liveIn = bitSetArrInitBitSetArray;
                return;
            }
            i = i4;
        }
    }

    public BitSet getAssignBlocks(int i) {
        return this.assignBlocks[i];
    }

    public boolean isLive(int i, int i2) {
        if (i >= this.liveIn.length) {
            return false;
        }
        return this.liveIn[i].get(i2);
    }

    public boolean isLive(BlockNode blockNode, int i) {
        return isLive(blockNode.getId(), i);
    }

    public void runAnalysis() {
        int size = this.mth.getBasicBlocks().size();
        int regsCount = this.mth.getRegsCount();
        this.uses = initBitSetArray(size, regsCount);
        this.defs = initBitSetArray(size, regsCount);
        this.assignBlocks = initBitSetArray(regsCount, size);
        fillBasicBlockInfo();
        processLiveInfo();
    }
}
