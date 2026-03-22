package jadx.core.dex.visitors;

import jadx.core.codegen.TypeGen;
import jadx.core.deobf.NameMapper;
import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.nodes.FieldReplaceAttr;
import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.info.FieldInfo;
import jadx.core.dex.info.MethodInfo;
import jadx.core.dex.instructions.ArithNode;
import jadx.core.dex.instructions.ConstClassNode;
import jadx.core.dex.instructions.ConstStringNode;
import jadx.core.dex.instructions.FillArrayNode;
import jadx.core.dex.instructions.FilledNewArrayNode;
import jadx.core.dex.instructions.IndexInsnNode;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.InvokeNode;
import jadx.core.dex.instructions.NewArrayNode;
import jadx.core.dex.instructions.SwitchNode;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.LiteralArg;
import jadx.core.dex.instructions.args.NamedArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.dex.instructions.mods.ConstructorInsn;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.FieldNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.trycatch.ExcHandlerAttr;
import jadx.core.dex.trycatch.ExceptionHandler;
import jadx.core.utils.ErrorsCounter;
import jadx.core.utils.InsnUtils;
import jadx.core.utils.InstructionRemover;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
@JadxVisitor(desc = "Modify method instructions", name = "ModVisitor", runBefore = {CodeShrinker.class})
public class ModVisitor extends AbstractVisitor {
    private static final InterfaceC1668b LOG = C1677c.m3845a(ModVisitor.class);

    private static boolean allArgsNull(InsnNode insnNode) {
        for (InsnArg insnArg : insnNode.getArguments()) {
            if (insnArg.isLiteral()) {
                if (((LiteralArg) insnArg).getLiteral() != 0) {
                    return false;
                }
            } else if (!insnArg.isThis()) {
                return false;
            }
        }
        return true;
    }

    private static void checkArgsNames(MethodNode methodNode) {
        for (RegisterArg registerArg : methodNode.getArguments(false)) {
            String name = registerArg.getName();
            if (name != null && NameMapper.isReserved(name)) {
                registerArg.getSVar().setName(name + "_");
            }
        }
    }

    private static Map getArgsToFieldsMapping(MethodNode methodNode, ConstructorInsn constructorInsn) {
        FieldNode fieldNodeSearchField;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ClassNode parentClass = methodNode.getParentClass();
        List arguments = methodNode.getArguments(false);
        int i = parentClass.getAccessFlags().isStatic() ? 0 : 1;
        int size = arguments.size();
        for (int i2 = i; i2 < size; i2++) {
            InsnNode parentInsnSkipMove = getParentInsnSkipMove((RegisterArg) arguments.get(i2));
            if (parentInsnSkipMove == null) {
                return Collections.emptyMap();
            }
            if (parentInsnSkipMove.getType() != InsnType.IPUT) {
                if (parentInsnSkipMove.getType() == InsnType.CONSTRUCTOR && ((ConstructorInsn) parentInsnSkipMove).isSuper()) {
                    fieldNodeSearchField = null;
                }
                return Collections.emptyMap();
            }
            fieldNodeSearchField = parentClass.searchField((FieldInfo) ((IndexInsnNode) parentInsnSkipMove).getIndex());
            if (fieldNodeSearchField == null || !fieldNodeSearchField.getAccessFlags().isSynthetic()) {
                return Collections.emptyMap();
            }
            linkedHashMap.put(constructorInsn.getArg(i2), fieldNodeSearchField);
        }
        return linkedHashMap;
    }

    private static InsnNode getParentInsnSkipMove(RegisterArg registerArg) {
        InsnNode parentInsn;
        while (true) {
            SSAVar sVar = registerArg.getSVar();
            if (sVar.getUseCount() == 1 && (parentInsn = ((RegisterArg) sVar.getUseList().get(0)).getParentInsn()) != null) {
                if (parentInsn.getType() != InsnType.MOVE) {
                    return parentInsn;
                }
                registerArg = parentInsn.getResult();
            }
            return null;
        }
    }

    private static InsnNode makeFilledArrayInsn(MethodNode methodNode, FillArrayNode fillArrayNode) {
        ArgType type = fillArrayNode.getResult().getType();
        ArgType arrayElement = type.getArrayElement();
        ArgType elementType = fillArrayNode.getElementType();
        if (!elementType.isTypeKnown() && arrayElement.isPrimitive() && elementType.contains(arrayElement.getPrimitiveType())) {
            elementType = arrayElement;
        }
        if (!elementType.equals(arrayElement) && !type.equals(ArgType.OBJECT)) {
            ErrorsCounter.methodError(methodNode, "Incorrect type for fill-array insn " + InsnUtils.formatOffset(fillArrayNode.getOffset()) + ", element type: " + elementType + ", insn element type: " + arrayElement);
        }
        if (!elementType.isTypeKnown()) {
            LOG.mo3821b("Unknown array element type: {} in mth: {}", elementType, methodNode);
            elementType = arrayElement.isTypeKnown() ? arrayElement : elementType.selectFirst();
            if (elementType == null) {
                throw new JadxRuntimeException("Null array element type");
            }
        }
        fillArrayNode.mergeElementType(methodNode.dex(), elementType);
        ArgType elementType2 = fillArrayNode.getElementType();
        List<LiteralArg> literalArgs = fillArrayNode.getLiteralArgs();
        FilledNewArrayNode filledNewArrayNode = new FilledNewArrayNode(elementType2, literalArgs.size());
        filledNewArrayNode.setResult(fillArrayNode.getResult());
        for (LiteralArg literalArg : literalArgs) {
            FieldNode constFieldByLiteralArg = methodNode.getParentClass().getConstFieldByLiteralArg(literalArg);
            if (constFieldByLiteralArg != null) {
                filledNewArrayNode.addArg(InsnArg.wrapArg(new IndexInsnNode(InsnType.SGET, constFieldByLiteralArg.getFieldInfo(), 0)));
            } else {
                filledNewArrayNode.addArg(literalArg);
            }
        }
        return filledNewArrayNode;
    }

    private static void processAnonymousConstructor(MethodNode methodNode, ConstructorInsn constructorInsn) {
        MethodInfo callMth = constructorInsn.getCallMth();
        MethodNode methodNodeResolveMethod = methodNode.dex().resolveMethod(callMth);
        if (methodNodeResolveMethod == null) {
            return;
        }
        ClassNode parentClass = methodNodeResolveMethod.getParentClass();
        ClassInfo classInfo = parentClass.getClassInfo();
        ClassNode parentClass2 = methodNode.getParentClass();
        if (classInfo.isInner() && Character.isDigit(classInfo.getShortName().charAt(0)) && parentClass2.getInnerClasses().contains(parentClass)) {
            if (parentClass.getAccessFlags().isStatic() || (callMth.getArgsCount() != 0 && ((ArgType) callMth.getArgumentsTypes().get(0)).equals(parentClass2.getClassInfo().getType()))) {
                Map argsToFieldsMapping = getArgsToFieldsMapping(methodNodeResolveMethod, constructorInsn);
                if (argsToFieldsMapping.isEmpty()) {
                    return;
                }
                parentClass.add(AFlag.ANONYMOUS_CLASS);
                methodNodeResolveMethod.add(AFlag.DONT_GENERATE);
                for (Map.Entry entry : argsToFieldsMapping.entrySet()) {
                    FieldNode fieldNode = (FieldNode) entry.getValue();
                    if (fieldNode != null) {
                        InsnArg insnArg = (InsnArg) entry.getKey();
                        fieldNode.addAttr(new FieldReplaceAttr(insnArg));
                        fieldNode.add(AFlag.DONT_GENERATE);
                        if (insnArg.isRegister()) {
                            RegisterArg registerArg = (RegisterArg) insnArg;
                            SSAVar sVar = registerArg.getSVar();
                            if (sVar != null) {
                                sVar.add(AFlag.FINAL);
                                sVar.add(AFlag.DONT_INLINE);
                            }
                            registerArg.add(AFlag.SKIP_ARG);
                        }
                    }
                }
            }
        }
    }

    private static ConstructorInsn processConstructor(MethodNode methodNode, ConstructorInsn constructorInsn) {
        MethodNode methodNodeResolveMethod = methodNode.dex().resolveMethod(constructorInsn.getCallMth());
        if (methodNodeResolveMethod == null || !methodNodeResolveMethod.getAccessFlags().isSynthetic() || !allArgsNull(constructorInsn)) {
            return null;
        }
        ClassNode classNodeResolveClass = methodNode.dex().resolveClass(methodNodeResolveMethod.getParentClass().getClassInfo());
        if (classNodeResolveClass == null) {
            return null;
        }
        MethodNode methodNodeSearchMethodByName = classNodeResolveClass.searchMethodByName("<init>(" + (constructorInsn.getArgsCount() > 0 && constructorInsn.getArg(0).isThis() ? TypeGen.signature(constructorInsn.getArg(0).getType()) : "") + ")V");
        if (methodNodeSearchMethodByName == null) {
            return null;
        }
        ConstructorInsn constructorInsn2 = new ConstructorInsn(methodNodeSearchMethodByName.getMethodInfo(), constructorInsn.getCallType(), constructorInsn.getInstanceArg());
        constructorInsn2.setResult(constructorInsn.getResult());
        return constructorInsn2;
    }

    private static void processInvoke(MethodNode methodNode, BlockNode blockNode, int i, InstructionRemover instructionRemover) {
        MethodNode methodNodeSearchMethodByName;
        InsnNode insnNodeRemoveAssignChain;
        ClassNode parentClass = methodNode.getParentClass();
        InsnNode insnNode = (InsnNode) blockNode.getInstructions().get(i);
        InvokeNode invokeNode = (InvokeNode) insnNode;
        MethodInfo callMth = invokeNode.getCallMth();
        if (callMth.isConstructor()) {
            InsnNode assignInsn = ((RegisterArg) invokeNode.getArg(0)).getAssignInsn();
            ConstructorInsn constructorInsn = new ConstructorInsn(methodNode, invokeNode);
            boolean z = (constructorInsn.isSuper() && (constructorInsn.getArgsCount() == 0 || parentClass.isEnum())) ? true : constructorInsn.isThis() && constructorInsn.getArgsCount() == 0 && ((methodNodeSearchMethodByName = parentClass.searchMethodByName(callMth.getShortId())) == null || methodNodeSearchMethodByName.isNoCode());
            if (parentClass.isAnonymous() && methodNode.isDefaultConstructor() && constructorInsn.isSuper()) {
                z = true;
            }
            if (z) {
                instructionRemover.add(insnNode);
                return;
            }
            if (constructorInsn.isNewInstance() && (insnNodeRemoveAssignChain = removeAssignChain(assignInsn, instructionRemover, InsnType.NEW_INSTANCE)) != null) {
                RegisterArg result = insnNodeRemoveAssignChain.getResult();
                RegisterArg result2 = constructorInsn.getResult();
                if (!result2.equals(result)) {
                    for (RegisterArg registerArg : new ArrayList(result.getSVar().getUseList())) {
                        RegisterArg registerArgDuplicate = result2.duplicate();
                        InsnNode parentInsn = registerArg.getParentInsn();
                        parentInsn.replaceArg(registerArg, registerArgDuplicate);
                        registerArgDuplicate.setParentInsn(parentInsn);
                        result2.getSVar().use(registerArgDuplicate);
                    }
                }
            }
            ConstructorInsn constructorInsnProcessConstructor = processConstructor(methodNode, constructorInsn);
            if (constructorInsnProcessConstructor == null) {
                constructorInsnProcessConstructor = constructorInsn;
            }
            replaceInsn(blockNode, i, constructorInsnProcessConstructor);
            processAnonymousConstructor(methodNode, constructorInsnProcessConstructor);
        }
    }

    private static void processMoveException(MethodNode methodNode, BlockNode blockNode, InsnNode insnNode, InstructionRemover instructionRemover) {
        ExcHandlerAttr excHandlerAttr = (ExcHandlerAttr) blockNode.get(AType.EXC_HANDLER);
        if (excHandlerAttr == null) {
            return;
        }
        ExceptionHandler handler = excHandlerAttr.getHandler();
        RegisterArg result = insnNode.getResult();
        ArgType type = handler.isCatchAll() ? ArgType.THROWABLE : handler.getCatchType().getType();
        String str = handler.isCatchAll() ? "th" : "e";
        if (result.getName() == null) {
            result.setName(str);
        }
        SSAVar sVar = insnNode.getResult().getSVar();
        if (sVar.getUseCount() == 0) {
            handler.setArg(new NamedArg(str, type));
            instructionRemover.add(insnNode);
        } else if (sVar.isUsedInPhi()) {
            InsnNode insnNode2 = new InsnNode(InsnType.MOVE, 1);
            insnNode2.setResult(insnNode.getResult());
            NamedArg namedArg = new NamedArg(str, type);
            insnNode2.addArg(namedArg);
            handler.setArg(namedArg);
            replaceInsn(blockNode, 0, insnNode2);
        }
    }

    private static InsnNode removeAssignChain(InsnNode insnNode, InstructionRemover instructionRemover, InsnType insnType) {
        for (InsnNode assignInsn = insnNode; assignInsn != null; assignInsn = ((RegisterArg) assignInsn.getArg(0)).getAssignInsn()) {
            instructionRemover.add(assignInsn);
            InsnType type = assignInsn.getType();
            if (type == insnType) {
                return assignInsn;
            }
            if (type != InsnType.MOVE) {
                return null;
            }
        }
        return null;
    }

    private static void removeStep(MethodNode methodNode, InstructionRemover instructionRemover) {
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            instructionRemover.setBlock(blockNode);
            for (InsnNode insnNode : blockNode.getInstructions()) {
                switch (insnNode.getType()) {
                    case NOP:
                    case GOTO:
                    case NEW_INSTANCE:
                        instructionRemover.add(insnNode);
                        break;
                }
            }
            instructionRemover.perform();
        }
    }

    private static void replaceInsn(BlockNode blockNode, int i, InsnNode insnNode) {
        InsnNode insnNode2 = (InsnNode) blockNode.getInstructions().get(i);
        insnNode.copyAttributesFrom(insnNode2);
        insnNode.setSourceLine(insnNode2.getSourceLine());
        blockNode.getInstructions().set(i, insnNode);
    }

    private static void replaceStep(MethodNode methodNode, InstructionRemover instructionRemover) {
        FieldNode constFieldByLiteralArg;
        ClassNode parentClass = methodNode.getParentClass();
        for (BlockNode blockNode : methodNode.getBasicBlocks()) {
            instructionRemover.setBlock(blockNode);
            int size = blockNode.getInstructions().size();
            for (int i = 0; i < size; i++) {
                InsnNode insnNode = (InsnNode) blockNode.getInstructions().get(i);
                switch (insnNode.getType()) {
                    case INVOKE:
                        processInvoke(methodNode, blockNode, i, instructionRemover);
                        break;
                    case CONST:
                    case CONST_STR:
                    case CONST_CLASS:
                        FieldNode constField = insnNode.getType() == InsnType.CONST_STR ? parentClass.getConstField(((ConstStringNode) insnNode).getString()) : insnNode.getType() == InsnType.CONST_CLASS ? parentClass.getConstField(((ConstClassNode) insnNode).getClsType()) : parentClass.getConstFieldByLiteralArg((LiteralArg) insnNode.getArg(0));
                        if (constField != null) {
                            IndexInsnNode indexInsnNode = new IndexInsnNode(InsnType.SGET, constField.getFieldInfo(), 0);
                            indexInsnNode.setResult(insnNode.getResult());
                            replaceInsn(blockNode, i, indexInsnNode);
                        }
                        break;
                    case SWITCH:
                        SwitchNode switchNode = (SwitchNode) insnNode;
                        for (int i2 = 0; i2 < switchNode.getCasesCount(); i2++) {
                            FieldNode constField2 = parentClass.getConstField(switchNode.getKeys()[i2]);
                            if (constField2 != null) {
                                switchNode.getKeys()[i2] = constField2;
                            }
                        }
                        break;
                    case NEW_ARRAY:
                        int i3 = i + 1;
                        if (i3 < size) {
                            InsnNode insnNode2 = (InsnNode) blockNode.getInstructions().get(i3);
                            if (insnNode2.getType() == InsnType.FILL_ARRAY) {
                                insnNode2.getResult().merge(methodNode.dex(), insnNode.getResult());
                                ((FillArrayNode) insnNode2).mergeElementType(methodNode.dex(), ((NewArrayNode) insnNode).getArrayType().getArrayElement());
                                instructionRemover.add(insnNode);
                            }
                        }
                        break;
                    case FILL_ARRAY:
                        replaceInsn(blockNode, i, makeFilledArrayInsn(methodNode, (FillArrayNode) insnNode));
                        break;
                    case MOVE_EXCEPTION:
                        processMoveException(methodNode, blockNode, insnNode, instructionRemover);
                        break;
                    case ARITH:
                        ArithNode arithNode = (ArithNode) insnNode;
                        if (arithNode.getArgsCount() == 2) {
                            InsnArg arg = arithNode.getArg(1);
                            if (arg.isLiteral() && (constFieldByLiteralArg = parentClass.getConstFieldByLiteralArg((LiteralArg) arg)) != null) {
                                insnNode.replaceArg(arg, InsnArg.wrapArg(new IndexInsnNode(InsnType.SGET, constFieldByLiteralArg.getFieldInfo(), 0)));
                            }
                        }
                        break;
                }
            }
            instructionRemover.perform();
        }
    }

    @Override // jadx.core.dex.visitors.AbstractVisitor, jadx.core.dex.visitors.IDexTreeVisitor
    public void visit(MethodNode methodNode) {
        if (methodNode.isNoCode()) {
            return;
        }
        InstructionRemover instructionRemover = new InstructionRemover(methodNode);
        replaceStep(methodNode, instructionRemover);
        removeStep(methodNode, instructionRemover);
        checkArgsNames(methodNode);
    }
}
