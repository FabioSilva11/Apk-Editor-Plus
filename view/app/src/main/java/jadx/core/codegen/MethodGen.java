package jadx.core.codegen;

import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.annotations.MethodParameters;
import jadx.core.dex.attributes.nodes.JadxErrorAttr;
import jadx.core.dex.info.AccessInfo;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.trycatch.CatchAttr;
import jadx.core.dex.visitors.DepthTraversal;
import jadx.core.dex.visitors.FallbackModeVisitor;
import jadx.core.utils.InsnUtils;
import jadx.core.utils.Utils;
import jadx.core.utils.exceptions.CodegenException;
import jadx.core.utils.exceptions.DecodeException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MethodGen {
    private final AnnotationGen annotationGen;
    private final ClassGen classGen;
    private final MethodNode mth;
    private final NameGen nameGen;

    public MethodGen(ClassGen classGen, MethodNode methodNode) {
        this.mth = methodNode;
        this.classGen = classGen;
        this.annotationGen = classGen.getAnnotationGen();
        this.nameGen = new NameGen(methodNode, classGen.isFallbackMode());
    }

    public static void addFallbackInsns(CodeWriter codeWriter, MethodNode methodNode, InsnNode[] insnNodeArr, boolean z) {
        CatchAttr catchAttr;
        InsnGen insnGen = new InsnGen(getFallbackMethodGen(methodNode), true);
        for (InsnNode insnNode : insnNodeArr) {
            if (insnNode != null && insnNode.getType() != InsnType.NOP) {
                if (z && (insnNode.contains(AType.JUMP) || insnNode.contains(AType.EXC_HANDLER))) {
                    codeWriter.decIndent();
                    codeWriter.startLine(getLabelName(insnNode.getOffset()) + ":");
                    codeWriter.incIndent();
                }
                try {
                    if (insnGen.makeInsn(insnNode, codeWriter) && (catchAttr = (CatchAttr) insnNode.get(AType.CATCH_BLOCK)) != null) {
                        codeWriter.add("\t " + catchAttr);
                    }
                } catch (CodegenException e) {
                    codeWriter.startLine("// error: " + insnNode);
                }
            }
        }
    }

    private void addMethodArguments(CodeWriter codeWriter, List list) {
        MethodParameters methodParameters = (MethodParameters) this.mth.get(AType.ANNOTATION_MTH_PARAMETERS);
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            RegisterArg registerArg = (RegisterArg) it.next();
            if (methodParameters != null) {
                this.annotationGen.addForParameter(codeWriter, methodParameters, i2);
            }
            SSAVar sVar = registerArg.getSVar();
            if (sVar != null && sVar.contains(AFlag.FINAL)) {
                codeWriter.add("final ");
            }
            if (it.hasNext() || !this.mth.getAccessFlags().isVarArgs()) {
                this.classGen.useType(codeWriter, registerArg.getType());
            } else {
                ArgType type = registerArg.getType();
                if (type.isArray()) {
                    this.classGen.useType(codeWriter, type.getArrayElement());
                    codeWriter.add("...");
                } else {
                    this.classGen.useType(codeWriter, registerArg.getType());
                }
            }
            codeWriter.add(' ');
            codeWriter.add(this.nameGen.assignArg(registerArg));
            i = i2 + 1;
            if (it.hasNext()) {
                codeWriter.add(", ");
            }
        }
    }

    public static MethodGen getFallbackMethodGen(MethodNode methodNode) {
        return new MethodGen(new ClassGen(methodNode.getParentClass(), null, true, true), methodNode);
    }

    public static String getLabelName(int i) {
        return "L_" + InsnUtils.formatOffset(i);
    }

    public boolean addDefinition(CodeWriter codeWriter) {
        if (this.mth.getMethodInfo().isClassInit()) {
            codeWriter.attachDefinition(this.mth);
            codeWriter.startLine("static");
            return true;
        }
        if (this.mth.contains(AFlag.ANONYMOUS_CONSTRUCTOR)) {
            codeWriter.startLine();
            codeWriter.attachDefinition(this.mth);
            return false;
        }
        this.annotationGen.addForMethod(codeWriter, this.mth);
        AccessInfo accessFlags = this.mth.getParentClass().getAccessFlags();
        AccessInfo accessFlags2 = this.mth.getAccessFlags();
        if (accessFlags.isInterface()) {
            accessFlags2 = accessFlags2.remove(1024).remove(1);
        }
        if (accessFlags.isAnnotation()) {
            accessFlags2 = accessFlags2.remove(1);
        }
        codeWriter.startLineWithNum(this.mth.getSourceLine());
        codeWriter.add(accessFlags2.makeString());
        if (this.classGen.addGenericMap(codeWriter, this.mth.getGenericMap())) {
            codeWriter.add(' ');
        }
        if (this.mth.getAccessFlags().isConstructor()) {
            codeWriter.attachDefinition(this.mth);
            codeWriter.add(this.classGen.getClassNode().getShortName());
        } else {
            this.classGen.useType(codeWriter, this.mth.getReturnType());
            codeWriter.add(' ');
            codeWriter.attachDefinition(this.mth);
            codeWriter.add(this.mth.getAlias());
        }
        codeWriter.add('(');
        List arguments = this.mth.getArguments(false);
        if (this.mth.getMethodInfo().isConstructor() && this.mth.getParentClass().contains(AType.ENUM_CLASS)) {
            if (arguments.size() == 2) {
                arguments.clear();
            } else if (arguments.size() > 2) {
                arguments = arguments.subList(2, arguments.size());
            }
        }
        addMethodArguments(codeWriter, arguments);
        codeWriter.add(')');
        this.annotationGen.addThrows(this.mth, codeWriter);
        return true;
    }

    public void addFallbackMethodCode(CodeWriter codeWriter) {
        JadxErrorAttr jadxErrorAttr;
        if (this.mth.getInstructions() == null && ((jadxErrorAttr = (JadxErrorAttr) this.mth.get(AType.JADX_ERROR)) == null || jadxErrorAttr.getCause() == null || !jadxErrorAttr.getCause().getClass().equals(DecodeException.class))) {
            try {
                this.mth.load();
                DepthTraversal.visit(new FallbackModeVisitor(), this.mth);
            } catch (DecodeException e) {
                codeWriter.startLine("// Can't load method instructions: " + e.getMessage());
                return;
            }
        }
        InsnNode[] instructions = this.mth.getInstructions();
        if (instructions == null) {
            codeWriter.startLine("// Can't load method instructions.");
            return;
        }
        if (this.mth.getThisArg() != null) {
            codeWriter.startLine(this.nameGen.useArg(this.mth.getThisArg())).add(" = this;");
        }
        addFallbackInsns(codeWriter, this.mth, instructions, true);
    }

    public void addInstructions(CodeWriter codeWriter) {
        if (!this.mth.contains(AType.JADX_ERROR) && !this.mth.contains(AFlag.INCONSISTENT_CODE) && this.mth.getRegion() != null) {
            new RegionGen(this).makeRegion(codeWriter, this.mth.getRegion());
            return;
        }
        JadxErrorAttr jadxErrorAttr = (JadxErrorAttr) this.mth.get(AType.JADX_ERROR);
        if (jadxErrorAttr != null) {
            codeWriter.startLine("/* JADX: method processing error */");
            Throwable cause = jadxErrorAttr.getCause();
            if (cause != null) {
                codeWriter.newLine();
                codeWriter.add("/*");
                codeWriter.newLine().add("Error: ").add(Utils.getStackTrace(cause));
                codeWriter.add("*/");
            }
        }
        codeWriter.startLine("/*");
        addFallbackMethodCode(codeWriter);
        codeWriter.startLine("*/");
        codeWriter.startLine("throw new UnsupportedOperationException(\"Method not decompiled: ").add(this.mth.toString()).add("\");");
    }

    public ClassGen getClassGen() {
        return this.classGen;
    }

    public MethodNode getMethodNode() {
        return this.mth;
    }

    public NameGen getNameGen() {
        return this.nameGen;
    }
}
