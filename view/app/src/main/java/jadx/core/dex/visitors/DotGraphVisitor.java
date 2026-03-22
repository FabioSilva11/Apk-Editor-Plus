package jadx.core.dex.visitors;

import jadx.core.codegen.CodeWriter;
import jadx.core.codegen.MethodGen;
import jadx.core.deobf.Deobfuscator;
import jadx.core.dex.attributes.IAttributeNode;
import jadx.core.dex.instructions.IfNode;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.IBlock;
import jadx.core.dex.nodes.IContainer;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.trycatch.ExceptionHandler;
import jadx.core.utils.InsnUtils;
import jadx.core.utils.RegionUtils;
import jadx.core.utils.StringUtils;
import jadx.core.utils.Utils;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
public class DotGraphVisitor extends AbstractVisitor {
    private static final InterfaceC1668b LOG = C1677c.m3845a(DotGraphVisitor.class);

    /* JADX INFO: renamed from: NL */
    private static final String f4701NL = "\\l";
    private static final boolean PRINT_DOMINATORS = false;
    private final File dir;
    private final boolean rawInsn;
    private final boolean useRegions;

    class DumpDotGraph {
        private final CodeWriter conn;
        private final CodeWriter dot;

        private DumpDotGraph() {
            this.dot = new CodeWriter();
            this.conn = new CodeWriter();
        }

        private void addEdge(BlockNode blockNode, BlockNode blockNode2, String str) {
            this.conn.startLine(makeName(blockNode)).add(" -> ").add(makeName(blockNode2));
            this.conn.add(str);
            this.conn.add(';');
        }

        private String attributesString(IAttributeNode iAttributeNode) {
            StringBuilder sb = new StringBuilder();
            Iterator it = iAttributeNode.getAttributesStringsList().iterator();
            while (it.hasNext()) {
                sb.append(escape((String) it.next())).append(DotGraphVisitor.f4701NL);
            }
            return sb.toString();
        }

        private String escape(String str) {
            return str.replace("\\", "").replace("/", "\\/").replace(">", "\\>").replace("<", "\\<").replace("{", "\\{").replace("}", "\\}").replace("\"", "\\\"").replace("-", "\\-").replace("|", "\\|").replace("\n", DotGraphVisitor.f4701NL);
        }

        private String insertInsns(MethodNode methodNode, IBlock iBlock) {
            if (!DotGraphVisitor.this.rawInsn) {
                CodeWriter codeWriter = new CodeWriter();
                List instructions = iBlock.getInstructions();
                MethodGen.addFallbackInsns(codeWriter, methodNode, (InsnNode[]) instructions.toArray(new InsnNode[instructions.size()]), false);
                String strEscape = escape(codeWriter.newLine().toString());
                return strEscape.startsWith(DotGraphVisitor.f4701NL) ? strEscape.substring(2) : strEscape;
            }
            StringBuilder sb = new StringBuilder();
            for (InsnNode insnNode : iBlock.getInstructions()) {
                sb.append(escape(insnNode + " " + insnNode.getAttributesString()));
                sb.append(DotGraphVisitor.f4701NL);
            }
            return sb.toString();
        }

        private String makeName(IContainer iContainer) {
            return iContainer instanceof BlockNode ? "Node_" + ((BlockNode) iContainer).getId() : iContainer instanceof IBlock ? "Node_" + iContainer.getClass().getSimpleName() + "_" + iContainer.hashCode() : "cluster_" + iContainer.getClass().getSimpleName() + "_" + iContainer.hashCode();
        }

        private void processBlock(MethodNode methodNode, BlockNode blockNode, boolean z) {
            String strAttributesString = attributesString(blockNode);
            this.dot.startLine(makeName(blockNode));
            this.dot.add(" [shape=record,");
            if (z) {
                this.dot.add("color=red,");
            }
            this.dot.add("label=\"{");
            this.dot.add(String.valueOf(blockNode.getId())).add("\\:\\ ");
            this.dot.add(InsnUtils.formatOffset(blockNode.getStartOffset()));
            if (strAttributesString.length() != 0) {
                this.dot.add('|').add(strAttributesString);
            }
            String strInsertInsns = insertInsns(methodNode, blockNode);
            if (strInsertInsns.length() != 0) {
                this.dot.add('|').add(strInsertInsns);
            }
            this.dot.add("}\"];");
            BlockNode elseBlock = null;
            List instructions = blockNode.getInstructions();
            if (!instructions.isEmpty() && ((InsnNode) instructions.get(0)).getType() == InsnType.IF) {
                elseBlock = ((IfNode) instructions.get(0)).getElseBlock();
            }
            for (BlockNode blockNode2 : blockNode.getSuccessors()) {
                addEdge(blockNode, blockNode2, blockNode2 == elseBlock ? "[style=dashed]" : "");
            }
        }

        private void processIBlock(MethodNode methodNode, IBlock iBlock, boolean z) {
            String strAttributesString = attributesString(iBlock);
            this.dot.startLine(makeName(iBlock));
            this.dot.add(" [shape=record,");
            if (z) {
                this.dot.add("color=red,");
            }
            this.dot.add("label=\"{");
            if (strAttributesString.length() != 0) {
                this.dot.add(strAttributesString);
            }
            String strInsertInsns = insertInsns(methodNode, iBlock);
            if (strInsertInsns.length() != 0) {
                this.dot.add('|').add(strInsertInsns);
            }
            this.dot.add("}\"];");
        }

        private void processMethodRegion(MethodNode methodNode) {
            processRegion(methodNode, methodNode.getRegion());
            for (ExceptionHandler exceptionHandler : methodNode.getExceptionHandlers()) {
                if (exceptionHandler.getHandlerRegion() != null) {
                    processRegion(methodNode, exceptionHandler.getHandlerRegion());
                }
            }
            HashSet hashSet = new HashSet(methodNode.getBasicBlocks().size());
            RegionUtils.getAllRegionBlocks(methodNode.getRegion(), hashSet);
            Iterator it = methodNode.getExceptionHandlers().iterator();
            while (it.hasNext()) {
                IContainer handlerRegion = ((ExceptionHandler) it.next()).getHandlerRegion();
                if (handlerRegion != null) {
                    RegionUtils.getAllRegionBlocks(handlerRegion, hashSet);
                }
            }
            for (BlockNode blockNode : methodNode.getBasicBlocks()) {
                if (!hashSet.contains(blockNode)) {
                    processBlock(methodNode, blockNode, true);
                }
            }
        }

        private void processRegion(MethodNode methodNode, IContainer iContainer) {
            if (!(iContainer instanceof IRegion)) {
                if (iContainer instanceof BlockNode) {
                    processBlock(methodNode, (BlockNode) iContainer, false);
                    return;
                } else {
                    if (iContainer instanceof IBlock) {
                        processIBlock(methodNode, (IBlock) iContainer, false);
                        return;
                    }
                    return;
                }
            }
            IRegion iRegion = (IRegion) iContainer;
            this.dot.startLine("subgraph " + makeName(iContainer) + " {");
            this.dot.startLine("label = \"").add(iRegion.toString());
            String strAttributesString = attributesString(iRegion);
            if (strAttributesString.length() != 0) {
                this.dot.add(" | ").add(strAttributesString);
            }
            this.dot.add("\";");
            this.dot.startLine("node [shape=record,color=blue];");
            Iterator it = iRegion.getSubBlocks().iterator();
            while (it.hasNext()) {
                processRegion(methodNode, (IContainer) it.next());
            }
            this.dot.startLine('}');
        }

        public void process(MethodNode methodNode) throws Throwable {
            this.dot.startLine("digraph \"CFG for");
            this.dot.add(escape(methodNode.getParentClass() + Deobfuscator.CLASS_NAME_SEPARATOR + methodNode.getMethodInfo().getShortId()));
            this.dot.add("\" {");
            if (!DotGraphVisitor.this.useRegions) {
                Iterator it = methodNode.getBasicBlocks().iterator();
                while (it.hasNext()) {
                    processBlock(methodNode, (BlockNode) it.next(), false);
                }
            } else if (methodNode.getRegion() == null) {
                return;
            } else {
                processMethodRegion(methodNode);
            }
            this.dot.startLine("MethodNode[shape=record,label=\"{");
            this.dot.add(escape(methodNode.getAccessFlags().makeString()));
            this.dot.add(escape(methodNode.getReturnType() + " " + methodNode.getParentClass() + Deobfuscator.CLASS_NAME_SEPARATOR + methodNode.getName() + "(" + Utils.listToString(methodNode.getArguments(true)) + ") "));
            String strAttributesString = attributesString(methodNode);
            if (strAttributesString.length() != 0) {
                this.dot.add(" | ").add(strAttributesString);
            }
            this.dot.add("}\"];");
            this.dot.startLine("MethodNode -> ").add(makeName(methodNode.getEnterBlock())).add(';');
            this.dot.add(this.conn.toString());
            this.dot.startLine('}');
            this.dot.startLine();
            this.dot.save(DotGraphVisitor.this.dir, methodNode.getParentClass().getClassInfo().getFullPath() + "_graphs", StringUtils.escape(methodNode.getMethodInfo().getShortId()) + (DotGraphVisitor.this.useRegions ? ".regions" : "") + (DotGraphVisitor.this.rawInsn ? ".raw" : "") + ".dot");
        }
    }

    private DotGraphVisitor(File file, boolean z, boolean z2) {
        this.dir = file;
        this.useRegions = z;
        this.rawInsn = z2;
        InterfaceC1668b interfaceC1668b = LOG;
        Object[] objArr = new Object[3];
        objArr[0] = z ? "regions " : "";
        objArr[1] = z2 ? "raw " : "";
        objArr[2] = file.getAbsolutePath();
        interfaceC1668b.mo3818a("DOT {}{}graph dump dir: {}", objArr);
    }

    public static DotGraphVisitor dump(File file) {
        return new DotGraphVisitor(file, false, false);
    }

    public static DotGraphVisitor dumpRaw(File file) {
        return new DotGraphVisitor(file, false, true);
    }

    public static DotGraphVisitor dumpRawRegions(File file) {
        return new DotGraphVisitor(file, true, true);
    }

    public static DotGraphVisitor dumpRegions(File file) {
        return new DotGraphVisitor(file, true, false);
    }

    @Override // jadx.core.dex.visitors.AbstractVisitor, jadx.core.dex.visitors.IDexTreeVisitor
    public void visit(MethodNode methodNode) throws Throwable {
        if (methodNode.isNoCode()) {
            return;
        }
        new DumpDotGraph().process(methodNode);
    }
}
