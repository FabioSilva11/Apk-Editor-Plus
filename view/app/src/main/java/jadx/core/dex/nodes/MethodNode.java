package jadx.core.dex.nodes;

import com.p016a.p017a.C0405d;
import com.p016a.p017a.C0407f;
import com.p016a.p017a.C0408g;
import com.p016a.p017a.C0409h;
import jadx.core.deobf.Deobfuscator;
import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.nodes.JumpInfo;
import jadx.core.dex.attributes.nodes.LineAttrNode;
import jadx.core.dex.attributes.nodes.LoopInfo;
import jadx.core.dex.info.AccessInfo;
import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.info.MethodInfo;
import jadx.core.dex.instructions.GotoNode;
import jadx.core.dex.instructions.IfNode;
import jadx.core.dex.instructions.InsnDecoder;
import jadx.core.dex.instructions.SwitchNode;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.dex.instructions.args.TypeImmutableArg;
import jadx.core.dex.nodes.parser.SignatureParser;
import jadx.core.dex.regions.Region;
import jadx.core.dex.trycatch.ExcHandlerAttr;
import jadx.core.dex.trycatch.ExceptionHandler;
import jadx.core.dex.trycatch.TryCatchBlock;
import jadx.core.utils.Utils;
import jadx.core.utils.exceptions.DecodeException;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
public class MethodNode extends LineAttrNode implements ILoadable {
    private static final InterfaceC1668b LOG = C1677c.m3845a(MethodNode.class);
    private final AccessInfo accFlags;
    private List argsList;
    private List blocks;
    private int codeSize;
    private int debugInfoOffset;
    private BlockNode enterBlock;
    private List exitBlocks;
    private Map genericMap;
    private InsnNode[] instructions;
    private final C0405d methodData;
    private boolean methodIsVirtual;
    private final MethodInfo mthInfo;
    private boolean noCode;
    private final ClassNode parentClass;
    private Region region;
    private int regsCount;
    private ArgType retType;
    private RegisterArg thisArg;
    private List sVars = Collections.emptyList();
    private List exceptionHandlers = Collections.emptyList();
    private List loops = Collections.emptyList();

    public MethodNode(ClassNode classNode, C0405d c0405d, boolean z) {
        this.mthInfo = MethodInfo.fromDex(classNode.dex(), c0405d.m320a());
        this.parentClass = classNode;
        this.accFlags = new AccessInfo(c0405d.m321b(), AccessInfo.AFType.METHOD);
        this.noCode = c0405d.m322c() == 0;
        this.methodData = this.noCode ? null : c0405d;
        this.methodIsVirtual = z;
    }

    private static void addJump(InsnNode[] insnNodeArr, int i, int i2) {
        insnNodeArr[i2].addAttr(AType.JUMP, new JumpInfo(i, i2));
    }

    private void initArguments(List list) {
        int regCount;
        if (!this.noCode) {
            int regCount2 = this.regsCount;
            Iterator it = list.iterator();
            while (true) {
                regCount = regCount2;
                if (!it.hasNext()) {
                    break;
                } else {
                    regCount2 = regCount - ((ArgType) it.next()).getRegCount();
                }
            }
        } else {
            regCount = 1;
        }
        if (this.accFlags.isStatic()) {
            this.thisArg = null;
        } else {
            TypeImmutableArg typeImmutableArgTypeImmutableReg = InsnArg.typeImmutableReg(regCount - 1, this.parentClass.getClassInfo().getType());
            typeImmutableArgTypeImmutableReg.markAsThis();
            this.thisArg = typeImmutableArgTypeImmutableReg;
        }
        if (list.isEmpty()) {
            this.argsList = Collections.emptyList();
            return;
        }
        this.argsList = new ArrayList(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ArgType argType = (ArgType) it2.next();
            this.argsList.add(InsnArg.typeImmutableReg(regCount, argType));
            regCount += argType.getRegCount();
        }
    }

    private void initJumps() {
        InsnNode[] insnNodeArr = this.instructions;
        for (int i = 0; i < insnNodeArr.length; i++) {
            InsnNode insnNode = insnNodeArr[i];
            if (insnNode != null) {
                switch (insnNode.getType()) {
                    case SWITCH:
                        int[] targets = ((SwitchNode) insnNode).getTargets();
                        for (int i2 : targets) {
                            addJump(insnNodeArr, i, i2);
                        }
                        int nextInsnOffset = InsnDecoder.getNextInsnOffset(insnNodeArr, i);
                        if (nextInsnOffset != -1) {
                            addJump(insnNodeArr, i, nextInsnOffset);
                        }
                        break;
                    case IF:
                        int nextInsnOffset2 = InsnDecoder.getNextInsnOffset(insnNodeArr, i);
                        if (nextInsnOffset2 != -1) {
                            addJump(insnNodeArr, i, nextInsnOffset2);
                        }
                        addJump(insnNodeArr, i, ((IfNode) insnNode).getTarget());
                        break;
                    case GOTO:
                        addJump(insnNodeArr, i, ((GotoNode) insnNode).getTarget());
                        break;
                }
            }
        }
    }

    private void initMethodTypes() {
        if (parseSignature()) {
            return;
        }
        this.retType = this.mthInfo.getReturnType();
        initArguments(this.mthInfo.getArgumentsTypes());
    }

    private void initTryCatches(C0407f c0407f) {
        InsnNode[] insnNodeArr = this.instructions;
        C0408g[] c0408gArrM339g = c0407f.m339g();
        C0409h[] c0409hArrM338f = c0407f.m338f();
        if (c0408gArrM339g.length == 0 && c0409hArrM338f.length == 0) {
            return;
        }
        int i = 0;
        HashSet hashSet = new HashSet();
        ArrayList<TryCatchBlock> arrayList = new ArrayList(c0408gArrM339g.length);
        for (C0408g c0408g : c0408gArrM339g) {
            TryCatchBlock tryCatchBlock = new TryCatchBlock();
            arrayList.add(tryCatchBlock);
            for (int i2 = 0; i2 < c0408g.m341b().length; i2++) {
                int i3 = c0408g.m341b()[i2];
                tryCatchBlock.addHandler(this, i3, ClassInfo.fromDex(this.parentClass.dex(), c0408g.m340a()[i2]));
                hashSet.add(Integer.valueOf(i3));
                i++;
            }
            int iM342c = c0408g.m342c();
            if (iM342c >= 0) {
                tryCatchBlock.addHandler(this, iM342c, null);
                hashSet.add(Integer.valueOf(iM342c));
                i++;
            }
        }
        if (i > 0 && i != hashSet.size()) {
            for (TryCatchBlock tryCatchBlock2 : arrayList) {
                for (TryCatchBlock tryCatchBlock3 : arrayList) {
                    if (tryCatchBlock2 != tryCatchBlock3 && tryCatchBlock3.containsAllHandlers(tryCatchBlock2)) {
                        for (ExceptionHandler exceptionHandler : tryCatchBlock2.getHandlers()) {
                            tryCatchBlock3.removeHandler(this, exceptionHandler);
                            exceptionHandler.setTryBlock(tryCatchBlock2);
                        }
                    }
                }
            }
        }
        hashSet.clear();
        for (TryCatchBlock tryCatchBlock4 : arrayList) {
            for (ExceptionHandler exceptionHandler2 : tryCatchBlock4.getHandlers()) {
                insnNodeArr[exceptionHandler2.getHandleOffset()].addAttr(new ExcHandlerAttr(tryCatchBlock4, exceptionHandler2));
            }
        }
        for (C0409h c0409h : c0409hArrM338f) {
            TryCatchBlock tryCatchBlock5 = (TryCatchBlock) arrayList.get(c0409h.m345c());
            int iM343a = c0409h.m343a();
            int iM344b = (c0409h.m344b() + iM343a) - 1;
            InsnNode insnNode = insnNodeArr[iM343a];
            insnNode.add(AFlag.TRY_ENTER);
            while (iM343a <= iM344b && iM343a >= 0) {
                insnNode = insnNodeArr[iM343a];
                tryCatchBlock5.addInsn(insnNode);
                iM343a = InsnDecoder.getNextInsnOffset(insnNodeArr, iM343a);
            }
            if (insnNodeArr[iM344b] != null) {
                insnNodeArr[iM344b].add(AFlag.TRY_LEAVE);
            } else {
                insnNode.add(AFlag.TRY_LEAVE);
            }
        }
    }

    private boolean parseSignature() {
        SignatureParser signatureParserFromNode = SignatureParser.fromNode(this);
        if (signatureParserFromNode == null) {
            return false;
        }
        try {
            this.genericMap = signatureParserFromNode.consumeGenericMap();
            List listConsumeMethodArgs = signatureParserFromNode.consumeMethodArgs();
            this.retType = signatureParserFromNode.consumeType();
            List argumentsTypes = this.mthInfo.getArgumentsTypes();
            if (listConsumeMethodArgs.size() != argumentsTypes.size()) {
                if (listConsumeMethodArgs.isEmpty()) {
                    return false;
                }
                if (!this.mthInfo.isConstructor()) {
                    LOG.mo3823b("Wrong signature parse result: {} -> {}, not generic version: {}", signatureParserFromNode, listConsumeMethodArgs, argumentsTypes);
                    return false;
                }
                if (getParentClass().getAccessFlags().isEnum()) {
                    listConsumeMethodArgs.add(0, argumentsTypes.get(0));
                    listConsumeMethodArgs.add(1, argumentsTypes.get(1));
                } else {
                    listConsumeMethodArgs.add(0, argumentsTypes.get(0));
                }
                if (listConsumeMethodArgs.size() != argumentsTypes.size()) {
                    return false;
                }
            }
            initArguments(listConsumeMethodArgs);
            return true;
        } catch (JadxRuntimeException e) {
            LOG.mo3826c("Method signature parse error: {}", this, e);
            return false;
        }
    }

    public ExceptionHandler addExceptionHandler(ExceptionHandler exceptionHandler) {
        if (this.exceptionHandlers.isEmpty()) {
            this.exceptionHandlers = new ArrayList(2);
        } else {
            for (ExceptionHandler exceptionHandler2 : this.exceptionHandlers) {
                if (exceptionHandler2 == exceptionHandler || exceptionHandler2.getHandleOffset() == exceptionHandler.getHandleOffset()) {
                    return exceptionHandler2;
                }
            }
        }
        this.exceptionHandlers.add(exceptionHandler);
        return exceptionHandler;
    }

    public void addExitBlock(BlockNode blockNode) {
        this.exitBlocks.add(blockNode);
    }

    public void checkInstructions() {
        ArrayList arrayList = new ArrayList();
        for (InsnNode insnNode : this.instructions) {
            if (insnNode != null) {
                arrayList.clear();
                RegisterArg result = insnNode.getResult();
                if (result != null) {
                    arrayList.add(result);
                }
                insnNode.getRegisterArgs(arrayList);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (((RegisterArg) arrayList.get(i)).getRegNum() >= this.regsCount) {
                        throw new JadxRuntimeException("Incorrect register number in instruction: " + insnNode + ", expected to be less than " + this.regsCount);
                    }
                }
            }
        }
    }

    public DexNode dex() {
        return this.parentClass.dex();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mthInfo.equals(((MethodNode) obj).mthInfo);
    }

    public void finishBasicBlocks() {
        ((ArrayList) this.blocks).trimToSize();
        ((ArrayList) this.exitBlocks).trimToSize();
        this.blocks = Collections.unmodifiableList(this.blocks);
        this.exitBlocks = Collections.unmodifiableList(this.exitBlocks);
        Iterator it = this.blocks.iterator();
        while (it.hasNext()) {
            ((BlockNode) it.next()).lock();
        }
    }

    public AccessInfo getAccessFlags() {
        return this.accFlags;
    }

    public String getAlias() {
        return this.mthInfo.getAlias();
    }

    public List getAllLoopsForBlock(BlockNode blockNode) {
        if (this.loops.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.loops.size());
        for (LoopInfo loopInfo : this.loops) {
            if (loopInfo.getLoopBlocks().contains(blockNode)) {
                arrayList.add(loopInfo);
            }
        }
        return arrayList;
    }

    public List getArguments(boolean z) {
        if (!z || this.thisArg == null) {
            return this.argsList;
        }
        ArrayList arrayList = new ArrayList(this.argsList.size() + 1);
        arrayList.add(this.thisArg);
        arrayList.addAll(this.argsList);
        return arrayList;
    }

    public List getBasicBlocks() {
        return this.blocks;
    }

    public int getCodeSize() {
        return this.codeSize;
    }

    public int getDebugInfoOffset() {
        return this.debugInfoOffset;
    }

    public BlockNode getEnterBlock() {
        return this.enterBlock;
    }

    public Iterable getExceptionHandlers() {
        return this.exceptionHandlers;
    }

    public int getExceptionHandlersCount() {
        return this.exceptionHandlers.size();
    }

    public List getExitBlocks() {
        return this.exitBlocks;
    }

    public Map getGenericMap() {
        return this.genericMap;
    }

    public InsnNode[] getInstructions() {
        return this.instructions;
    }

    public LoopInfo getLoopForBlock(BlockNode blockNode) {
        if (this.loops.isEmpty()) {
            return null;
        }
        for (LoopInfo loopInfo : this.loops) {
            if (loopInfo.getLoopBlocks().contains(blockNode)) {
                return loopInfo;
            }
        }
        return null;
    }

    public Iterable getLoops() {
        return this.loops;
    }

    public int getLoopsCount() {
        return this.loops.size();
    }

    public MethodInfo getMethodInfo() {
        return this.mthInfo;
    }

    public String getName() {
        return this.mthInfo.getName();
    }

    public int getNextSVarVersion(int i) {
        int iMax = -1;
        Iterator it = this.sVars.iterator();
        while (true) {
            int i2 = iMax;
            if (!it.hasNext()) {
                return i2 + 1;
            }
            SSAVar sSAVar = (SSAVar) it.next();
            iMax = sSAVar.getRegNum() == i ? Math.max(i2, sSAVar.getVersion()) : i2;
        }
    }

    public ClassNode getParentClass() {
        return this.parentClass;
    }

    public Region getRegion() {
        return this.region;
    }

    public int getRegsCount() {
        return this.regsCount;
    }

    public ArgType getReturnType() {
        return this.retType;
    }

    public List getSVars() {
        return this.sVars;
    }

    public RegisterArg getThisArg() {
        return this.thisArg;
    }

    public int hashCode() {
        return this.mthInfo.hashCode();
    }

    public void initBasicBlocks() {
        this.blocks = new ArrayList();
        this.exitBlocks = new ArrayList(1);
    }

    public boolean isArgsOverload() {
        int size = this.mthInfo.getArgumentsTypes().size();
        if (size == 0) {
            return false;
        }
        String name = getName();
        for (MethodNode methodNode : this.parentClass.getMethods()) {
            MethodInfo methodInfo = methodNode.mthInfo;
            if (this != methodNode && methodInfo.getArgumentsTypes().size() == size && methodInfo.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isDefaultConstructor() {
        /*
            r4 = this;
            r1 = 1
            r2 = 0
            jadx.core.dex.info.AccessInfo r0 = r4.accFlags
            boolean r0 = r0.isConstructor()
            if (r0 == 0) goto L64
            jadx.core.dex.info.MethodInfo r0 = r4.mthInfo
            boolean r0 = r0.isConstructor()
            if (r0 == 0) goto L64
            jadx.core.dex.nodes.ClassNode r0 = r4.parentClass
            jadx.core.dex.info.ClassInfo r0 = r0.getClassInfo()
            boolean r0 = r0.isInner()
            if (r0 == 0) goto L65
            jadx.core.dex.nodes.ClassNode r0 = r4.parentClass
            jadx.core.dex.info.AccessInfo r0 = r0.getAccessFlags()
            boolean r0 = r0.isStatic()
            if (r0 != 0) goto L65
            jadx.core.dex.nodes.ClassNode r0 = r4.parentClass
            jadx.core.dex.nodes.ClassNode r3 = r0.getParentClass()
            java.util.List r0 = r4.argsList
            if (r0 == 0) goto L65
            java.util.List r0 = r4.argsList
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L65
            java.util.List r0 = r4.argsList
            java.lang.Object r0 = r0.get(r2)
            jadx.core.dex.instructions.args.RegisterArg r0 = (jadx.core.dex.instructions.args.RegisterArg) r0
            jadx.core.dex.instructions.args.ArgType r0 = r0.getType()
            jadx.core.dex.info.ClassInfo r3 = r3.getClassInfo()
            jadx.core.dex.instructions.args.ArgType r3 = r3.getType()
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L65
            r0 = r1
        L57:
            java.util.List r3 = r4.argsList
            if (r3 == 0) goto L63
            java.util.List r3 = r4.argsList
            int r3 = r3.size()
            if (r3 != r0) goto L64
        L63:
            r2 = r1
        L64:
            return r2
        L65:
            r0 = r2
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: jadx.core.dex.nodes.MethodNode.isDefaultConstructor():boolean");
    }

    public boolean isNoCode() {
        return this.noCode;
    }

    public boolean isNoExceptionHandlers() {
        return this.exceptionHandlers.isEmpty();
    }

    public boolean isVirtual() {
        return this.methodIsVirtual;
    }

    @Override // jadx.core.dex.nodes.ILoadable
    public void load() {
        try {
            if (this.noCode) {
                this.regsCount = 0;
                this.codeSize = 0;
                initMethodTypes();
                return;
            }
            C0407f code = this.parentClass.dex().readCode(this.methodData);
            this.regsCount = code.m333a();
            initMethodTypes();
            InsnDecoder insnDecoder = new InsnDecoder(this);
            insnDecoder.decodeInsns(code);
            this.instructions = insnDecoder.process();
            this.codeSize = this.instructions.length;
            initTryCatches(code);
            initJumps();
            this.debugInfoOffset = code.m336d();
        } catch (Exception e) {
            if (!this.noCode) {
                this.noCode = true;
                load();
                this.noCode = false;
            }
            throw new DecodeException(this, "Load method exception", e);
        }
    }

    public SSAVar makeNewSVar(int i, int i2, RegisterArg registerArg) {
        SSAVar sSAVar = new SSAVar(i, i2, registerArg);
        if (this.sVars.isEmpty()) {
            this.sVars = new ArrayList();
        }
        this.sVars.add(sSAVar);
        return sSAVar;
    }

    public void registerLoop(LoopInfo loopInfo) {
        if (this.loops.isEmpty()) {
            this.loops = new ArrayList(5);
        }
        loopInfo.setId(this.loops.size());
        this.loops.add(loopInfo);
    }

    public RegisterArg removeFirstArgument() {
        add(AFlag.SKIP_FIRST_ARG);
        return (RegisterArg) this.argsList.remove(0);
    }

    public void removeSVar(SSAVar sSAVar) {
        this.sVars.remove(sSAVar);
    }

    public void setEnterBlock(BlockNode blockNode) {
        this.enterBlock = blockNode;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String toString() {
        return this.parentClass + Deobfuscator.CLASS_NAME_SEPARATOR + this.mthInfo.getName() + "(" + Utils.listToString(this.mthInfo.getArgumentsTypes()) + "):" + this.retType;
    }

    @Override // jadx.core.dex.nodes.ILoadable
    public void unload() {
        if (this.noCode) {
            return;
        }
        this.instructions = null;
        this.blocks = null;
        this.exitBlocks = null;
        this.exceptionHandlers.clear();
    }

    public void unloadInsnArr() {
        this.instructions = null;
    }
}
