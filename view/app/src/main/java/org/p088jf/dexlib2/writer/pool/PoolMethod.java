package org.p088jf.dexlib2.writer.pool;

import com.google.common.base.Function;
import java.util.List;
import java.util.Set;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.base.reference.BaseMethodReference;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.Method;
import org.p088jf.dexlib2.iface.MethodImplementation;
import org.p088jf.dexlib2.iface.MethodParameter;

/* JADX INFO: loaded from: classes.dex */
public class PoolMethod extends BaseMethodReference implements Method {
    public static final Function<Method, PoolMethod> TRANSFORM = new Function<Method, PoolMethod>() { // from class: org.jf.dexlib2.writer.pool.PoolMethod.1
        @Override // com.google.common.base.Function
        public PoolMethod apply(Method method) {
            return new PoolMethod(method);
        }
    };
    public int annotationSetRefListOffset = 0;
    public int codeItemOffset = 0;
    public final Method method;

    public PoolMethod(Method method) {
        this.method = method;
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public int getAccessFlags() {
        return this.method.getAccessFlags();
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public Set<? extends Annotation> getAnnotations() {
        return this.method.getAnnotations();
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getDefiningClass() {
        return this.method.getDefiningClass();
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        return this.method.getHiddenApiRestrictions();
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public MethodImplementation getImplementation() {
        return this.method.getImplementation();
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getName() {
        return this.method.getName();
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference
    public List<? extends CharSequence> getParameterTypes() {
        return this.method.getParameterTypes();
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public List<? extends MethodParameter> getParameters() {
        return this.method.getParameters();
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getReturnType() {
        return this.method.getReturnType();
    }
}
