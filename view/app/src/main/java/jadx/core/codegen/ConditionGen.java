package jadx.core.codegen;

import jadx.core.dex.instructions.ArithNode;
import jadx.core.dex.instructions.IfOp;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.InsnWrapArg;
import jadx.core.dex.instructions.args.LiteralArg;
import jadx.core.dex.regions.conditions.Compare;
import jadx.core.dex.regions.conditions.IfCondition;
import jadx.core.utils.ErrorsCounter;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
public class ConditionGen extends InsnGen {
    private static final InterfaceC1668b LOG = C1677c.m3845a(ConditionGen.class);

    class CondStack {
        private final Queue stack;

        private CondStack() {
            this.stack = new LinkedList();
        }

        public Queue getStack() {
            return this.stack;
        }

        public IfCondition pop() {
            return (IfCondition) this.stack.poll();
        }

        public void push(IfCondition ifCondition) {
            this.stack.add(ifCondition);
        }
    }

    public ConditionGen(InsnGen insnGen) {
        super(insnGen.mgen, insnGen.fallback);
    }

    private void add(CodeWriter codeWriter, CondStack condStack, IfCondition ifCondition) {
        condStack.push(ifCondition);
        switch (ifCondition.getMode()) {
            case COMPARE:
                addCompare(codeWriter, condStack, ifCondition.getCompare());
                break;
            case TERNARY:
                addTernary(codeWriter, condStack, ifCondition);
                break;
            case NOT:
                addNot(codeWriter, condStack, ifCondition);
                break;
            case AND:
            case OR:
                addAndOr(codeWriter, condStack, ifCondition);
                break;
            default:
                throw new JadxRuntimeException("Unknown condition mode: " + ifCondition.getMode());
        }
        condStack.pop();
    }

    private void addAndOr(CodeWriter codeWriter, CondStack condStack, IfCondition ifCondition) {
        String str = ifCondition.getMode() == IfCondition.Mode.AND ? " && " : " || ";
        Iterator it = ifCondition.getArgs().iterator();
        while (it.hasNext()) {
            wrap(codeWriter, condStack, (IfCondition) it.next());
            if (it.hasNext()) {
                codeWriter.add(str);
            }
        }
    }

    private void addCompare(CodeWriter codeWriter, CondStack condStack, Compare compare) {
        IfOp op = compare.getOp();
        InsnArg a2 = compare.getA();
        InsnArg b2 = compare.getB();
        if (a2.getType().equals(ArgType.BOOLEAN) && b2.isLiteral() && b2.getType().equals(ArgType.BOOLEAN)) {
            IfOp ifOpInvert = ((LiteralArg) b2).getLiteral() == 0 ? op.invert() : op;
            if (ifOpInvert == IfOp.EQ) {
                if (condStack.getStack().size() == 1) {
                    addArg(codeWriter, a2, false);
                    return;
                } else {
                    wrap(codeWriter, a2);
                    return;
                }
            }
            if (ifOpInvert == IfOp.NE) {
                codeWriter.add('!');
                wrap(codeWriter, a2);
                return;
            } else {
                LOG.mo3819b(ErrorsCounter.formatErrorMsg(this.mth, "Unsupported boolean condition " + ifOpInvert.getSymbol()));
                op = ifOpInvert;
            }
        }
        addArg(codeWriter, a2, isArgWrapNeeded(a2));
        codeWriter.add(' ').add(op.getSymbol()).add(' ');
        addArg(codeWriter, b2, isArgWrapNeeded(b2));
    }

    private void addNot(CodeWriter codeWriter, CondStack condStack, IfCondition ifCondition) {
        codeWriter.add('!');
        wrap(codeWriter, condStack, (IfCondition) ifCondition.getArgs().get(0));
    }

    private void addTernary(CodeWriter codeWriter, CondStack condStack, IfCondition ifCondition) {
        add(codeWriter, condStack, ifCondition.first());
        codeWriter.add(" ? ");
        add(codeWriter, condStack, ifCondition.second());
        codeWriter.add(" : ");
        add(codeWriter, condStack, ifCondition.third());
    }

    private static boolean isArgWrapNeeded(InsnArg insnArg) {
        if (!insnArg.isInsnWrap()) {
            return false;
        }
        InsnType type = ((InsnWrapArg) insnArg).getWrapInsn().getType();
        if (type == InsnType.ARITH) {
            switch (((ArithNode) r0).getOp()) {
                case ADD:
                case SUB:
                case MUL:
                case DIV:
                case REM:
                    return false;
                default:
                    return true;
            }
        }
        switch (type) {
            case INVOKE:
            case SGET:
            case IGET:
            case AGET:
            case CONST:
            case ARRAY_LENGTH:
                return false;
            default:
                return true;
        }
    }

    private boolean isWrapNeeded(IfCondition ifCondition) {
        return (ifCondition.isCompare() || ifCondition.getMode() == IfCondition.Mode.NOT) ? false : true;
    }

    private void wrap(CodeWriter codeWriter, CondStack condStack, IfCondition ifCondition) {
        boolean zIsWrapNeeded = isWrapNeeded(ifCondition);
        if (zIsWrapNeeded) {
            codeWriter.add('(');
        }
        add(codeWriter, condStack, ifCondition);
        if (zIsWrapNeeded) {
            codeWriter.add(')');
        }
    }

    private void wrap(CodeWriter codeWriter, InsnArg insnArg) {
        boolean zIsArgWrapNeeded = isArgWrapNeeded(insnArg);
        if (zIsArgWrapNeeded) {
            codeWriter.add('(');
        }
        addArg(codeWriter, insnArg, false);
        if (zIsArgWrapNeeded) {
            codeWriter.add(')');
        }
    }

    void add(CodeWriter codeWriter, IfCondition ifCondition) {
        add(codeWriter, new CondStack(), ifCondition);
    }

    void wrap(CodeWriter codeWriter, IfCondition ifCondition) {
        wrap(codeWriter, new CondStack(), ifCondition);
    }
}
