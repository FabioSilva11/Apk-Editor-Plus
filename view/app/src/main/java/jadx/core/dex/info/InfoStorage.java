package jadx.core.dex.info;

import jadx.core.dex.instructions.args.ArgType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class InfoStorage {
    private final Map classes = new HashMap();
    private final Map methods = new HashMap();
    private final Map fields = new HashMap();

    public ClassInfo getCls(ArgType argType) {
        return (ClassInfo) this.classes.get(argType);
    }

    public FieldInfo getField(FieldInfo fieldInfo) {
        synchronized (this.fields) {
            FieldInfo fieldInfo2 = (FieldInfo) this.fields.get(fieldInfo);
            if (fieldInfo2 != null) {
                return fieldInfo2;
            }
            this.fields.put(fieldInfo, fieldInfo);
            return fieldInfo;
        }
    }

    public MethodInfo getMethod(int i) {
        return (MethodInfo) this.methods.get(Integer.valueOf(i));
    }

    public ClassInfo putCls(ClassInfo classInfo) {
        synchronized (this.classes) {
            ClassInfo classInfo2 = (ClassInfo) this.classes.put(classInfo.getType(), classInfo);
            if (classInfo2 != null) {
                classInfo = classInfo2;
            }
        }
        return classInfo;
    }

    public MethodInfo putMethod(int i, MethodInfo methodInfo) {
        synchronized (this.methods) {
            MethodInfo methodInfo2 = (MethodInfo) this.methods.put(Integer.valueOf(i), methodInfo);
            if (methodInfo2 != null) {
                methodInfo = methodInfo2;
            }
        }
        return methodInfo;
    }
}
