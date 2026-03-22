package jadx.core.codegen;

import jadx.core.Consts;
import jadx.core.deobf.NameMapper;
import jadx.core.dex.attributes.nodes.LoopLabelAttr;
import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.info.MethodInfo;
import jadx.core.dex.instructions.InvokeNode;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.InsnWrapArg;
import jadx.core.dex.instructions.args.NamedArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.dex.instructions.mods.ConstructorInsn;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.utils.StringUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class NameGen {
    private static final Map OBJ_ALIAS;
    private final boolean fallback;
    private final MethodNode mth;
    private final Set varNames = new HashSet();

    static {
        HashMap map = new HashMap();
        OBJ_ALIAS = map;
        map.put(Consts.CLASS_STRING, "str");
        OBJ_ALIAS.put(Consts.CLASS_CLASS, "cls");
        OBJ_ALIAS.put(Consts.CLASS_THROWABLE, "th");
        OBJ_ALIAS.put(Consts.CLASS_OBJECT, "obj");
        OBJ_ALIAS.put("java.util.Iterator", "it");
        OBJ_ALIAS.put("java.lang.Boolean", "bool");
        OBJ_ALIAS.put("java.lang.Short", "sh");
        OBJ_ALIAS.put("java.lang.Integer", "num");
        OBJ_ALIAS.put("java.lang.Character", "ch");
        OBJ_ALIAS.put("java.lang.Byte", "b");
        OBJ_ALIAS.put("java.lang.Float", "f");
        OBJ_ALIAS.put("java.lang.Long", "l");
        OBJ_ALIAS.put("java.lang.Double", "d");
    }

    public NameGen(MethodNode methodNode, boolean z) {
        this.mth = methodNode;
        this.fallback = z;
    }

    private static String fromName(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.toUpperCase().equals(str)) {
            return str.toLowerCase();
        }
        String str2 = Character.toLowerCase(str.charAt(0)) + str.substring(1);
        if (!str2.equals(str)) {
            return str2;
        }
        if (str.length() < 3) {
            return str + "Var";
        }
        return null;
    }

    private static String getAliasForObject(String str) {
        return (String) OBJ_ALIAS.get(str);
    }

    private String getFallbackName(RegisterArg registerArg) {
        return "r" + registerArg.getRegNum();
    }

    private String getUniqueVarName(String str) {
        int i = 2;
        String str2 = str;
        while (this.varNames.contains(str2)) {
            str2 = str + i;
            i++;
        }
        this.varNames.add(str2);
        return str2;
    }

    private String guessName(RegisterArg registerArg) {
        RegisterArg assign;
        InsnNode parentInsn;
        String strMakeNameFromInsn;
        SSAVar sVar = registerArg.getSVar();
        if (sVar == null || sVar.getName() != null || (parentInsn = (assign = sVar.getAssign()).getParentInsn()) == null || (strMakeNameFromInsn = makeNameFromInsn(parentInsn)) == null || NameMapper.isReserved(strMakeNameFromInsn)) {
            return makeNameForType(registerArg.getType());
        }
        assign.setName(strMakeNameFromInsn);
        return strMakeNameFromInsn;
    }

    private String makeArgName(RegisterArg registerArg) {
        if (this.fallback) {
            return getFallbackName(registerArg);
        }
        String name = registerArg.getName();
        if (name == null) {
            name = guessName(registerArg);
        } else if ("this".equals(name)) {
            return name;
        }
        return NameMapper.isReserved(name) ? name + "R" : name;
    }

    private String makeNameForObject(ArgType argType) {
        if (argType.isObject()) {
            String aliasForObject = getAliasForObject(argType.getObject());
            if (aliasForObject != null) {
                return aliasForObject;
            }
            String strFromName = fromName(ClassInfo.extCls(this.mth.dex(), argType).getShortName());
            if (strFromName != null) {
                return strFromName;
            }
        }
        return StringUtils.escape(argType.toString());
    }

    private static String makeNameForPrimitive(ArgType argType) {
        return argType.getPrimitiveType().getShortName().toLowerCase();
    }

    private String makeNameForType(ArgType argType) {
        return argType.isPrimitive() ? makeNameForPrimitive(argType) : argType.isArray() ? makeNameForType(argType.getArrayRootElement()) + "Arr" : makeNameForObject(argType);
    }

    private String makeNameFromInsn(InsnNode insnNode) {
        String strMakeNameFromInsn;
        switch (insnNode.getType()) {
            case INVOKE:
                return makeNameFromInvoke(((InvokeNode) insnNode).getCallMth());
            case CONSTRUCTOR:
                return makeNameForObject(((ConstructorInsn) insnNode).getClassType().getType());
            case ARRAY_LENGTH:
                return "length";
            case ARITH:
            case TERNARY:
            case CAST:
                for (InsnArg insnArg : insnNode.getArguments()) {
                    if (insnArg.isInsnWrap() && (strMakeNameFromInsn = makeNameFromInsn(((InsnWrapArg) insnArg).getWrapInsn())) != null) {
                        return strMakeNameFromInsn;
                    }
                }
            default:
                return null;
        }
    }

    private String makeNameFromInvoke(MethodInfo methodInfo) {
        String name = methodInfo.getName();
        if (name.startsWith("get") || name.startsWith("set")) {
            return fromName(name.substring(3));
        }
        ArgType type = methodInfo.getDeclClass().getAlias().getType();
        return "iterator".equals(name) ? "it" : "toString".equals(name) ? makeNameForType(type) : ("forName".equals(name) && type.equals(ArgType.CLASS)) ? (String) OBJ_ALIAS.get(Consts.CLASS_CLASS) : name;
    }

    public String assignArg(RegisterArg registerArg) {
        String strMakeArgName = makeArgName(registerArg);
        if (this.fallback) {
            return strMakeArgName;
        }
        String uniqueVarName = getUniqueVarName(strMakeArgName);
        registerArg.setName(uniqueVarName);
        return uniqueVarName;
    }

    public String assignNamedArg(NamedArg namedArg) {
        String name = namedArg.getName();
        if (this.fallback) {
            return name;
        }
        String uniqueVarName = getUniqueVarName(name);
        namedArg.setName(uniqueVarName);
        return uniqueVarName;
    }

    public String getLoopLabel(LoopLabelAttr loopLabelAttr) {
        String str = "loop" + loopLabelAttr.getLoop().getId();
        this.varNames.add(str);
        return str;
    }

    public String useArg(RegisterArg registerArg) {
        String name = registerArg.getName();
        return (name == null || this.fallback) ? getFallbackName(registerArg) : name;
    }
}
