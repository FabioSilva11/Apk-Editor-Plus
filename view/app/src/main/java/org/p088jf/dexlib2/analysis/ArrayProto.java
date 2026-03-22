package org.p088jf.dexlib2.analysis;

import com.google.common.base.Strings;
import org.p088jf.dexlib2.iface.Method;
import org.p088jf.dexlib2.util.TypeUtils;

/* JADX INFO: loaded from: classes.dex */
public class ArrayProto implements TypeProto {
    public static final String BRACKETS = Strings.repeat("[", 256);
    public final int dimensions;
    public final String elementType;

    public static String makeArrayType(String str, int i) {
        return BRACKETS.substring(0, i) + str;
    }

    @Override // org.p088jf.dexlib2.analysis.TypeProto
    public TypeProto getCommonSuperclass(TypeProto typeProto) {
        if (!(typeProto instanceof ArrayProto)) {
            if (!(typeProto instanceof ClassProto)) {
                return typeProto.getCommonSuperclass(this);
            }
            try {
                if (!typeProto.isInterface()) {
                    throw null;
                }
                if (implementsInterface(typeProto.getType())) {
                    return typeProto;
                }
                throw null;
            } catch (UnresolvedClassException unused) {
                throw null;
            }
        }
        if (!TypeUtils.isPrimitiveType(getElementType())) {
            ArrayProto arrayProto = (ArrayProto) typeProto;
            if (!TypeUtils.isPrimitiveType(arrayProto.getElementType())) {
                int i = this.dimensions;
                int i2 = arrayProto.dimensions;
                if (i == i2) {
                    throw null;
                }
                makeArrayType("Ljava/lang/Object;", Math.min(i, i2));
                throw null;
            }
        }
        ArrayProto arrayProto2 = (ArrayProto) typeProto;
        if (this.dimensions == arrayProto2.dimensions && getElementType().equals(arrayProto2.getElementType())) {
            return this;
        }
        throw null;
    }

    public String getElementType() {
        return this.elementType;
    }

    public String getImmediateElementType() {
        int i = this.dimensions;
        return i > 1 ? makeArrayType(this.elementType, i - 1) : this.elementType;
    }

    @Override // org.p088jf.dexlib2.analysis.TypeProto
    public Method getMethodByVtableIndex(int i) {
        throw null;
    }

    @Override // org.p088jf.dexlib2.analysis.TypeProto
    public String getType() {
        return makeArrayType(this.elementType, this.dimensions);
    }

    public boolean implementsInterface(String str) {
        return str.equals("Ljava/lang/Cloneable;") || str.equals("Ljava/io/Serializable;");
    }

    @Override // org.p088jf.dexlib2.analysis.TypeProto
    public boolean isInterface() {
        return false;
    }

    public String toString() {
        return getType();
    }
}
