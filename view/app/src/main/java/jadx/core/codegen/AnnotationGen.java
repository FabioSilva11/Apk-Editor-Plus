package jadx.core.codegen;

import jadx.core.Consts;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttributeNode;
import jadx.core.dex.attributes.annotations.Annotation;
import jadx.core.dex.attributes.annotations.AnnotationsList;
import jadx.core.dex.attributes.annotations.MethodParameters;
import jadx.core.dex.info.FieldInfo;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.FieldNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.utils.StringUtils;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AnnotationGen {
    private final ClassGen classGen;
    private final ClassNode cls;

    public AnnotationGen(ClassNode classNode, ClassGen classGen) {
        this.cls = classNode;
        this.classGen = classGen;
    }

    private void add(IAttributeNode iAttributeNode, CodeWriter codeWriter) {
        AnnotationsList annotationsList = (AnnotationsList) iAttributeNode.get(AType.ANNOTATION_LIST);
        if (annotationsList == null || annotationsList.isEmpty()) {
            return;
        }
        for (Annotation annotation : annotationsList.getAll()) {
            if (!annotation.getAnnotationClass().startsWith(Consts.DALVIK_ANNOTATION_PKG)) {
                codeWriter.startLine();
                formatAnnotation(codeWriter, annotation);
            }
        }
    }

    private void formatAnnotation(CodeWriter codeWriter, Annotation annotation) {
        codeWriter.add('@');
        this.classGen.useType(codeWriter, annotation.getType());
        Map values = annotation.getValues();
        if (values.isEmpty()) {
            return;
        }
        codeWriter.add('(');
        if (values.size() == 1 && values.containsKey("value")) {
            encodeValue(codeWriter, values.get("value"));
        } else {
            Iterator it = values.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                codeWriter.add((String) entry.getKey());
                codeWriter.add(" = ");
                encodeValue(codeWriter, entry.getValue());
                if (it.hasNext()) {
                    codeWriter.add(", ");
                }
            }
        }
        codeWriter.add(')');
    }

    public void addForClass(CodeWriter codeWriter) {
        add(this.cls, codeWriter);
    }

    public void addForField(CodeWriter codeWriter, FieldNode fieldNode) {
        add(fieldNode, codeWriter);
    }

    public void addForMethod(CodeWriter codeWriter, MethodNode methodNode) {
        add(methodNode, codeWriter);
    }

    public void addForParameter(CodeWriter codeWriter, MethodParameters methodParameters, int i) {
        AnnotationsList annotationsList;
        List paramList = methodParameters.getParamList();
        if (i >= paramList.size() || (annotationsList = (AnnotationsList) paramList.get(i)) == null || annotationsList.isEmpty()) {
            return;
        }
        Iterator it = annotationsList.getAll().iterator();
        while (it.hasNext()) {
            formatAnnotation(codeWriter, (Annotation) it.next());
            codeWriter.add(' ');
        }
    }

    public void addThrows(MethodNode methodNode, CodeWriter codeWriter) {
        Annotation annotation = methodNode.getAnnotation(Consts.DALVIK_THROWS);
        if (annotation != null) {
            Object defaultValue = annotation.getDefaultValue();
            codeWriter.add(" throws ");
            Iterator it = ((List) defaultValue).iterator();
            while (it.hasNext()) {
                this.classGen.useType(codeWriter, (ArgType) it.next());
                if (it.hasNext()) {
                    codeWriter.add(", ");
                }
            }
        }
    }

    public void encodeValue(CodeWriter codeWriter, Object obj) {
        if (obj == null) {
            codeWriter.add("null");
            return;
        }
        if (obj instanceof String) {
            codeWriter.add(StringUtils.unescapeString((String) obj));
            return;
        }
        if (obj instanceof Integer) {
            codeWriter.add(TypeGen.formatInteger(((Integer) obj).intValue()));
            return;
        }
        if (obj instanceof Character) {
            codeWriter.add(StringUtils.unescapeChar(((Character) obj).charValue()));
            return;
        }
        if (obj instanceof Boolean) {
            codeWriter.add(Boolean.TRUE.equals(obj) ? "true" : "false");
            return;
        }
        if (obj instanceof Float) {
            codeWriter.add(TypeGen.formatFloat(((Float) obj).floatValue()));
            return;
        }
        if (obj instanceof Double) {
            codeWriter.add(TypeGen.formatDouble(((Double) obj).doubleValue()));
            return;
        }
        if (obj instanceof Long) {
            codeWriter.add(TypeGen.formatLong(((Long) obj).longValue()));
            return;
        }
        if (obj instanceof Short) {
            codeWriter.add(TypeGen.formatShort(((Short) obj).shortValue()));
            return;
        }
        if (obj instanceof Byte) {
            codeWriter.add(TypeGen.formatByte(((Byte) obj).byteValue()));
            return;
        }
        if (obj instanceof ArgType) {
            this.classGen.useType(codeWriter, (ArgType) obj);
            codeWriter.add(".class");
            return;
        }
        if (obj instanceof FieldInfo) {
            InsnGen.makeStaticFieldAccess(codeWriter, (FieldInfo) obj, this.classGen);
            return;
        }
        if (!(obj instanceof Iterable)) {
            if (!(obj instanceof Annotation)) {
                throw new JadxRuntimeException("Can't decode value: " + obj + " (" + obj.getClass() + ")");
            }
            formatAnnotation(codeWriter, (Annotation) obj);
            return;
        }
        codeWriter.add('{');
        Iterator it = ((Iterable) obj).iterator();
        while (it.hasNext()) {
            encodeValue(codeWriter, it.next());
            if (it.hasNext()) {
                codeWriter.add(", ");
            }
        }
        codeWriter.add('}');
    }

    public Object getAnnotationDefaultValue(String str) {
        Annotation annotation = this.cls.getAnnotation(Consts.DALVIK_ANNOTATION_DEFAULT);
        if (annotation != null) {
            return ((Annotation) annotation.getDefaultValue()).getValues().get(str);
        }
        return null;
    }
}
