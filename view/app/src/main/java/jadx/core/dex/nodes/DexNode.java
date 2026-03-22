package jadx.core.dex.nodes;

import com.p016a.p017a.C0402ab;
import com.p016a.p017a.C0403b;
import com.p016a.p017a.C0405d;
import com.p016a.p017a.C0406e;
import com.p016a.p017a.C0407f;
import com.p016a.p017a.C0410i;
import com.p016a.p017a.C0416o;
import com.p016a.p017a.C0424w;
import com.p016a.p017a.C0425x;
import com.p016a.p017a.C0426y;
import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.info.FieldInfo;
import jadx.core.dex.info.InfoStorage;
import jadx.core.dex.info.MethodInfo;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.utils.files.InputFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DexNode {
    public static final int NO_INDEX = -1;
    private final C0410i dexBuf;
    private final InputFile file;
    private final RootNode root;
    private final List classes = new ArrayList();
    private final Map clsMap = new HashMap();
    private final Map constFields = new HashMap();
    private final InfoStorage infoStorage = new InfoStorage();

    public DexNode(RootNode rootNode, InputFile inputFile) {
        this.root = rootNode;
        this.file = inputFile;
        this.dexBuf = inputFile.getDexBuffer();
    }

    private MethodNode deepResolveMethod(ClassNode classNode, String str) {
        MethodNode methodNodeDeepResolveMethod;
        ClassNode classNodeResolveClass;
        MethodNode methodNodeDeepResolveMethod2;
        for (MethodNode methodNode : classNode.getMethods()) {
            if (methodNode.getMethodInfo().getShortId().startsWith(str)) {
                return methodNode;
            }
        }
        ArgType superClass = classNode.getSuperClass();
        if (superClass != null && (classNodeResolveClass = resolveClass(superClass)) != null && (methodNodeDeepResolveMethod2 = deepResolveMethod(classNodeResolveClass, str)) != null) {
            return methodNodeDeepResolveMethod2;
        }
        Iterator it = classNode.getInterfaces().iterator();
        while (it.hasNext()) {
            ClassNode classNodeResolveClass2 = resolveClass((ArgType) it.next());
            if (classNodeResolveClass2 != null && (methodNodeDeepResolveMethod = deepResolveMethod(classNodeResolveClass2, str)) != null) {
                return methodNodeDeepResolveMethod;
            }
        }
        return null;
    }

    public MethodNode deepResolveMethod(MethodInfo methodInfo) {
        ClassNode classNodeResolveClass = resolveClass(methodInfo.getDeclClass());
        if (classNodeResolveClass == null) {
            return null;
        }
        return deepResolveMethod(classNodeResolveClass, methodInfo.makeSignature(false));
    }

    public List getClasses() {
        return this.classes;
    }

    public Map getConstFields() {
        return this.constFields;
    }

    public C0424w getFieldId(int i) {
        return (C0424w) this.dexBuf.m367i().get(i);
    }

    public InfoStorage getInfoStorage() {
        return this.infoStorage;
    }

    public InputFile getInputFile() {
        return this.file;
    }

    public C0425x getMethodId(int i) {
        return (C0425x) this.dexBuf.m368j().get(i);
    }

    public C0426y getProtoId(int i) {
        return (C0426y) this.dexBuf.m366h().get(i);
    }

    public String getString(int i) {
        return (String) this.dexBuf.m363e().get(i);
    }

    public ArgType getType(int i) {
        return ArgType.parse(getString(((Integer) this.dexBuf.m364f().get(i)).intValue()));
    }

    void initInnerClasses() {
        ArrayList<ClassNode> arrayList = new ArrayList();
        for (ClassNode classNode : this.classes) {
            if (classNode.getClassInfo().isInner()) {
                arrayList.add(classNode);
            }
        }
        for (ClassNode classNode2 : arrayList) {
            ClassInfo classInfo = classNode2.getClassInfo();
            ClassNode classNodeResolveClass = resolveClass(classInfo.getParentClass());
            if (classNodeResolveClass == null) {
                this.clsMap.remove(classInfo);
                classInfo.notInner(classNode2.dex());
                this.clsMap.put(classInfo, classNode2);
            } else {
                classNodeResolveClass.addInnerClass(classNode2);
            }
        }
    }

    public void loadClasses() {
        Iterator it = this.dexBuf.m369k().iterator();
        while (it.hasNext()) {
            ClassNode classNode = new ClassNode(this, (C0406e) it.next());
            this.classes.add(classNode);
            this.clsMap.put(classNode.getClassInfo(), classNode);
        }
    }

    public C0416o openSection(int i) {
        return this.dexBuf.m354a(i);
    }

    public C0403b readClassData(C0406e c0406e) {
        return this.dexBuf.m352a(c0406e);
    }

    public C0407f readCode(C0405d c0405d) {
        return this.dexBuf.m353a(c0405d);
    }

    public List readParamList(int i) {
        C0402ab c0402abM359b = this.dexBuf.m359b(i);
        ArrayList arrayList = new ArrayList(c0402abM359b.m313a().length);
        short[] sArrM313a = c0402abM359b.m313a();
        for (short s : sArrM313a) {
            arrayList.add(getType(s));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public ClassNode resolveClass(ClassInfo classInfo) {
        return (ClassNode) this.clsMap.get(classInfo);
    }

    public ClassNode resolveClass(ArgType argType) {
        if (argType.isGeneric()) {
            argType = ArgType.object(argType.getObject());
        }
        return resolveClass(ClassInfo.fromType(this, argType));
    }

    public FieldNode resolveField(FieldInfo fieldInfo) {
        ClassNode classNodeResolveClass = resolveClass(fieldInfo.getDeclClass());
        if (classNodeResolveClass != null) {
            return classNodeResolveClass.searchField(fieldInfo);
        }
        return null;
    }

    public MethodNode resolveMethod(MethodInfo methodInfo) {
        ClassNode classNodeResolveClass = resolveClass(methodInfo.getDeclClass());
        if (classNodeResolveClass != null) {
            return classNodeResolveClass.searchMethod(methodInfo);
        }
        return null;
    }

    public RootNode root() {
        return this.root;
    }

    public String toString() {
        return "DEX";
    }
}
