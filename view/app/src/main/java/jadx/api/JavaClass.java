package jadx.api;

import jadx.core.codegen.CodeWriter;
import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.nodes.LineAttrNode;
import jadx.core.dex.info.AccessInfo;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.FieldNode;
import jadx.core.dex.nodes.MethodNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class JavaClass implements JavaNode {
    private final ClassNode cls;
    private final JadxDecompiler decompiler;
    private List fields;
    private List innerClasses;
    private List methods;
    private final JavaClass parent;

    JavaClass(ClassNode classNode, JadxDecompiler jadxDecompiler) {
        this.innerClasses = Collections.emptyList();
        this.fields = Collections.emptyList();
        this.methods = Collections.emptyList();
        this.decompiler = jadxDecompiler;
        this.cls = classNode;
        this.parent = null;
    }

    JavaClass(ClassNode classNode, JavaClass javaClass) {
        this.innerClasses = Collections.emptyList();
        this.fields = Collections.emptyList();
        this.methods = Collections.emptyList();
        this.decompiler = null;
        this.cls = classNode;
        this.parent = javaClass;
    }

    private JavaNode convertNode(Object obj) {
        if (!(obj instanceof LineAttrNode)) {
            return null;
        }
        if (obj instanceof ClassNode) {
            return (JavaNode) getRootDecompiler().getClassesMap().get(obj);
        }
        if (obj instanceof MethodNode) {
            return (JavaNode) getRootDecompiler().getMethodsMap().get(obj);
        }
        if (obj instanceof FieldNode) {
            return (JavaNode) getRootDecompiler().getFieldsMap().get(obj);
        }
        return null;
    }

    private Map getCodeAnnotations() {
        decompile();
        return this.cls.getCode().getAnnotations();
    }

    private JadxDecompiler getRootDecompiler() {
        while (this.parent != null) {
            this = this.parent;
        }
        return this.decompiler;
    }

    private void load() {
        JadxDecompiler rootDecompiler = getRootDecompiler();
        int size = this.cls.getInnerClasses().size();
        if (size != 0) {
            ArrayList arrayList = new ArrayList(size);
            for (ClassNode classNode : this.cls.getInnerClasses()) {
                if (!classNode.contains(AFlag.DONT_GENERATE)) {
                    JavaClass javaClass = new JavaClass(classNode, this);
                    javaClass.load();
                    arrayList.add(javaClass);
                    rootDecompiler.getClassesMap().put(classNode, javaClass);
                }
            }
            this.innerClasses = Collections.unmodifiableList(arrayList);
        }
        int size2 = this.cls.getFields().size();
        if (size2 != 0) {
            ArrayList arrayList2 = new ArrayList(size2);
            for (FieldNode fieldNode : this.cls.getFields()) {
                if (!fieldNode.contains(AFlag.DONT_GENERATE)) {
                    JavaField javaField = new JavaField(fieldNode, this);
                    arrayList2.add(javaField);
                    rootDecompiler.getFieldsMap().put(fieldNode, javaField);
                }
            }
            this.fields = Collections.unmodifiableList(arrayList2);
        }
        int size3 = this.cls.getMethods().size();
        if (size3 != 0) {
            ArrayList arrayList3 = new ArrayList(size3);
            for (MethodNode methodNode : this.cls.getMethods()) {
                if (!methodNode.contains(AFlag.DONT_GENERATE)) {
                    JavaMethod javaMethod = new JavaMethod(this, methodNode);
                    arrayList3.add(javaMethod);
                    rootDecompiler.getMethodsMap().put(methodNode, javaMethod);
                }
            }
            Collections.sort(arrayList3, new Comparator() { // from class: jadx.api.JavaClass.1
                @Override // java.util.Comparator
                public int compare(JavaMethod javaMethod2, JavaMethod javaMethod3) {
                    return javaMethod2.getName().compareTo(javaMethod3.getName());
                }
            });
            this.methods = Collections.unmodifiableList(arrayList3);
        }
    }

    public final synchronized void decompile() {
        if (this.decompiler != null && this.cls.getCode() == null) {
            this.decompiler.processClass(this.cls);
            load();
        }
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof JavaClass) && this.cls.equals(((JavaClass) obj).cls));
    }

    public final AccessInfo getAccessInfo() {
        return this.cls.getAccessFlags();
    }

    final ClassNode getClassNode() {
        return this.cls;
    }

    public final String getCode() {
        CodeWriter code = this.cls.getCode();
        if (code == null) {
            decompile();
            code = this.cls.getCode();
            if (code == null) {
                return "";
            }
        }
        return code.getCodeStr();
    }

    @Override // jadx.api.JavaNode
    public final JavaClass getDeclaringClass() {
        return this.parent;
    }

    @Override // jadx.api.JavaNode
    public final int getDecompiledLine() {
        return this.cls.getDecompiledLine();
    }

    public final CodePosition getDefinitionPosition(int i, int i2) {
        JavaNode javaNodeAtPosition = getJavaNodeAtPosition(i, i2);
        if (javaNodeAtPosition == null) {
            return null;
        }
        return getDefinitionPosition(javaNodeAtPosition);
    }

    public final CodePosition getDefinitionPosition(JavaNode javaNode) {
        JavaClass topParentClass = javaNode.getTopParentClass();
        topParentClass.decompile();
        int decompiledLine = javaNode.getDecompiledLine();
        if (decompiledLine == 0) {
            return null;
        }
        return new CodePosition(topParentClass, decompiledLine, 0);
    }

    public final List getFields() {
        decompile();
        return this.fields;
    }

    @Override // jadx.api.JavaNode
    public final String getFullName() {
        return this.cls.getFullName();
    }

    public final List getInnerClasses() {
        decompile();
        return this.innerClasses;
    }

    public final JavaNode getJavaNodeAtPosition(int i, int i2) {
        Object obj;
        Map codeAnnotations = getCodeAnnotations();
        if (codeAnnotations.isEmpty() || (obj = codeAnnotations.get(new CodePosition(i, i2))) == null) {
            return null;
        }
        return convertNode(obj);
    }

    public final List getMethods() {
        decompile();
        return this.methods;
    }

    @Override // jadx.api.JavaNode
    public final String getName() {
        return this.cls.getShortName();
    }

    public final String getPackage() {
        return this.cls.getPackage();
    }

    public final Integer getSourceLine(int i) {
        decompile();
        return (Integer) this.cls.getCode().getLineMapping().get(Integer.valueOf(i));
    }

    @Override // jadx.api.JavaNode
    public final JavaClass getTopParentClass() {
        while (this.parent != null) {
            this = this.parent;
        }
        return this;
    }

    public final Map getUsageMap() {
        JavaNode javaNodeConvertNode;
        Map codeAnnotations = getCodeAnnotations();
        if (codeAnnotations.isEmpty() || this.decompiler == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(codeAnnotations.size());
        for (Map.Entry entry : codeAnnotations.entrySet()) {
            CodePosition codePosition = (CodePosition) entry.getKey();
            Object value = entry.getValue();
            if ((value instanceof LineAttrNode) && (javaNodeConvertNode = convertNode(value)) != null) {
                map.put(codePosition, javaNodeConvertNode);
            }
        }
        return map;
    }

    public final int hashCode() {
        return this.cls.hashCode();
    }

    public final String toString() {
        return this.cls.getFullName() + "[ " + getFullName() + " ]";
    }
}
