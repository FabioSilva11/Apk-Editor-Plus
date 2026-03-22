package jadx.core.dex.visitors.regions;

import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.nodes.DeclareVariablesAttr;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.VarName;
import jadx.core.dex.nodes.IBlock;
import jadx.core.dex.nodes.IBranchRegion;
import jadx.core.dex.nodes.IContainer;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.regions.loops.ForLoop;
import jadx.core.dex.regions.loops.LoopRegion;
import jadx.core.dex.regions.loops.LoopType;
import jadx.core.dex.visitors.AbstractVisitor;
import jadx.core.utils.RegionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ProcessVariables extends AbstractVisitor {

    class CollectUsageRegionVisitor extends TracedRegionVisitor {
        private final List args = new ArrayList();
        private final Map usageMap;

        public CollectUsageRegionVisitor(Map map) {
            this.usageMap = map;
        }

        private void regionProcess(MethodNode methodNode, IRegion iRegion) {
            if (iRegion instanceof LoopRegion) {
                LoopType type = ((LoopRegion) iRegion).getType();
                if (type instanceof ForLoop) {
                    ForLoop forLoop = (ForLoop) type;
                    processInsn(forLoop.getInitInsn(), iRegion);
                    processInsn(forLoop.getIncrInsn(), iRegion);
                }
            }
        }

        @Override // jadx.core.dex.visitors.regions.TracedRegionVisitor
        public void processBlockTraced(MethodNode methodNode, IBlock iBlock, IRegion iRegion) {
            regionProcess(methodNode, iRegion);
            int size = iBlock.getInstructions().size();
            for (int i = 0; i < size; i++) {
                InsnNode insnNode = (InsnNode) iBlock.getInstructions().get(i);
                if (!insnNode.contains(AFlag.SKIP)) {
                    this.args.clear();
                    processInsn(insnNode, iRegion);
                }
            }
        }

        void processInsn(InsnNode insnNode, IRegion iRegion) {
            if (insnNode == null) {
                return;
            }
            RegisterArg result = insnNode.getResult();
            if (result != null && result.isRegister()) {
                Usage usageAddToUsageMap = ProcessVariables.addToUsageMap(result, this.usageMap);
                if (usageAddToUsageMap.getArg() == null) {
                    usageAddToUsageMap.setArg(result);
                    usageAddToUsageMap.setArgRegion(iRegion);
                }
                usageAddToUsageMap.getAssigns().add(iRegion);
            }
            this.args.clear();
            insnNode.getRegisterArgs(this.args);
            Iterator it = this.args.iterator();
            while (it.hasNext()) {
                ProcessVariables.addToUsageMap((RegisterArg) it.next(), this.usageMap).getUseRegions().add(iRegion);
            }
        }
    }

    class Usage {
        private RegisterArg arg;
        private IRegion argRegion;
        private final Set assigns;
        private final Set usage;
        private VarName varName;

        private Usage() {
            this.usage = new HashSet(2);
            this.assigns = new HashSet(2);
        }

        public RegisterArg getArg() {
            return this.arg;
        }

        public IRegion getArgRegion() {
            return this.argRegion;
        }

        public Set getAssigns() {
            return this.assigns;
        }

        public Set getUseRegions() {
            return this.usage;
        }

        public VarName getVarName() {
            return this.varName;
        }

        public void setArg(RegisterArg registerArg) {
            this.arg = registerArg;
        }

        public void setArgRegion(IRegion iRegion) {
            this.argRegion = iRegion;
        }

        public void setVarName(VarName varName) {
            this.varName = varName;
        }

        public String toString() {
            return this.arg + ", a:" + this.assigns + ", u:" + this.usage;
        }
    }

    class Variable {
        private final int regNum;
        private final ArgType type;

        public Variable(RegisterArg registerArg) {
            this.regNum = registerArg.getRegNum();
            this.type = registerArg.getType();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Variable variable = (Variable) obj;
            return this.regNum == variable.regNum && this.type.equals(variable.type);
        }

        public int hashCode() {
            return (this.regNum * 31) + this.type.hashCode();
        }

        public String toString() {
            return this.regNum + " " + this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Usage addToUsageMap(RegisterArg registerArg, Map map) {
        Variable variable = new Variable(registerArg);
        Usage usage = (Usage) map.get(variable);
        if (usage == null) {
            usage = new Usage();
            map.put(variable, usage);
        }
        if (usage.getVarName() == null) {
            VarName varName = registerArg.getSVar().getVarName();
            if (varName == null) {
                varName = new VarName();
                registerArg.getSVar().setVarName(varName);
            }
            usage.setVarName(varName);
        } else {
            registerArg.getSVar().setVarName(usage.getVarName());
        }
        return usage;
    }

    private static int calculateOrder(IContainer iContainer, Map map, int i, boolean z) {
        int i2;
        if (!(iContainer instanceof IRegion)) {
            return i;
        }
        IRegion iRegion = (IRegion) iContainer;
        if (((Integer) map.put(iRegion, Integer.valueOf(i))) != null) {
            return i;
        }
        int iCalculateOrder = i;
        for (IContainer iContainer2 : iRegion.getSubBlocks()) {
            if (iContainer2 instanceof IBranchRegion) {
                if (z) {
                    iCalculateOrder++;
                }
                iCalculateOrder = calculateOrder(iContainer2, map, iCalculateOrder, false);
            } else {
                List excHandlersForRegion = RegionUtils.getExcHandlersForRegion(iContainer2);
                if (!excHandlersForRegion.isEmpty()) {
                    Iterator it = excHandlersForRegion.iterator();
                    while (true) {
                        i2 = iCalculateOrder;
                        if (!it.hasNext()) {
                            break;
                        }
                        IContainer iContainer3 = (IContainer) it.next();
                        if (z) {
                            i2++;
                        }
                        iCalculateOrder = calculateOrder(iContainer3, map, i2, z);
                    }
                    iCalculateOrder = i2;
                }
                if (z) {
                    iCalculateOrder++;
                }
                iCalculateOrder = calculateOrder(iContainer2, map, iCalculateOrder, z);
            }
        }
        return iCalculateOrder;
    }

    private static boolean canDeclareInRegion(Usage usage, IRegion iRegion, Map map) {
        Integer num = (Integer) map.get(iRegion);
        if (num == null) {
            return false;
        }
        if (iRegion instanceof LoopRegion) {
            Iterator it = usage.getAssigns().iterator();
            while (it.hasNext()) {
                if (!RegionUtils.isRegionContainsRegion(iRegion, (IRegion) it.next())) {
                    return false;
                }
            }
        }
        return isAllRegionsAfter(iRegion, num.intValue(), usage.getAssigns(), map) && isAllRegionsAfter(iRegion, num.intValue(), usage.getUseRegions(), map);
    }

    private static boolean declareAtAssign(Usage usage) {
        RegisterArg arg = usage.getArg();
        InsnNode parentInsn = arg.getParentInsn();
        if (!arg.equals(parentInsn.getResult())) {
            return false;
        }
        parentInsn.add(AFlag.DECLARE_VAR);
        return true;
    }

    private static void declareVar(IContainer iContainer, RegisterArg registerArg) {
        DeclareVariablesAttr declareVariablesAttr = (DeclareVariablesAttr) iContainer.get(AType.DECLARE_VARIABLES);
        if (declareVariablesAttr == null) {
            declareVariablesAttr = new DeclareVariablesAttr();
            iContainer.addAttr(declareVariablesAttr);
        }
        declareVariablesAttr.addVar(registerArg);
    }

    private static boolean isAllRegionsAfter(IRegion iRegion, int i, Set set, Map map) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            IRegion iRegion2 = (IRegion) it.next();
            if (iRegion2 != iRegion) {
                Integer num = (Integer) map.get(iRegion2);
                if (num != null && i <= num.intValue()) {
                    if (i == num.intValue()) {
                        return isAllRegionsAfterRecursive(iRegion, set);
                    }
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isAllRegionsAfterRecursive(IRegion iRegion, Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!RegionUtils.isRegionContainsRegion(iRegion, (IRegion) it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // jadx.core.dex.visitors.AbstractVisitor, jadx.core.dex.visitors.IDexTreeVisitor
    public void visit(MethodNode methodNode) {
        boolean z;
        if (methodNode.isNoCode()) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = methodNode.getArguments(true).iterator();
        while (it.hasNext()) {
            addToUsageMap((RegisterArg) it.next(), linkedHashMap);
        }
        DepthRegionTraversal.traverse(methodNode, new CollectUsageRegionVisitor(linkedHashMap));
        Iterator it2 = methodNode.getArguments(true).iterator();
        while (it2.hasNext()) {
            linkedHashMap.remove(new Variable((RegisterArg) it2.next()));
        }
        Iterator it3 = linkedHashMap.entrySet().iterator();
        while (it3.hasNext()) {
            Usage usage = (Usage) ((Map.Entry) it3.next()).getValue();
            if (usage.getAssigns().isEmpty()) {
                it3.remove();
            } else {
                InsnNode parentInsn = usage.getArg().getParentInsn();
                if (parentInsn == null || parentInsn.getType() == InsnType.MOVE_EXCEPTION) {
                    it3.remove();
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        calculateOrder(methodNode.getRegion(), map, 0, true);
        Iterator it4 = linkedHashMap.entrySet().iterator();
        while (it4.hasNext()) {
            Usage usage2 = (Usage) ((Map.Entry) it4.next()).getValue();
            Iterator it5 = usage2.getAssigns().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                IRegion iRegion = (IRegion) it5.next();
                if (usage2.getArgRegion() == iRegion && canDeclareInRegion(usage2, iRegion, map) && declareAtAssign(usage2)) {
                    it4.remove();
                    break;
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        Iterator it6 = linkedHashMap.entrySet().iterator();
        while (it6.hasNext()) {
            Usage usage3 = (Usage) ((Map.Entry) it6.next()).getValue();
            Set useRegions = usage3.getUseRegions();
            Iterator it7 = useRegions.iterator();
            while (it7.hasNext()) {
                IRegion parent = ((IRegion) it7.next()).getParent();
                if (parent != null && useRegions.contains(parent)) {
                    it7.remove();
                }
            }
            IRegion iRegion2 = null;
            if (!useRegions.isEmpty()) {
                iRegion2 = (IRegion) useRegions.iterator().next();
            } else if (!usage3.getAssigns().isEmpty()) {
                iRegion2 = (IRegion) usage3.getAssigns().iterator().next();
            }
            if (iRegion2 != null) {
                IRegion parent2 = iRegion2;
                while (true) {
                    if (parent2 == null) {
                        z = false;
                        break;
                    } else if (canDeclareInRegion(usage3, iRegion2, map)) {
                        declareVar(iRegion2, usage3.getArg());
                        z = true;
                        break;
                    } else {
                        IRegion iRegion3 = parent2;
                        parent2 = parent2.getParent();
                        iRegion2 = iRegion3;
                    }
                }
                if (!z) {
                    declareVar(methodNode.getRegion(), usage3.getArg());
                }
            }
        }
    }
}
