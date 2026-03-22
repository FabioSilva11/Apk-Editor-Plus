package org.p088jf.dexlib2.immutable.reference;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.p088jf.dexlib2.base.reference.BaseMethodProtoReference;
import org.p088jf.dexlib2.iface.reference.MethodProtoReference;
import org.p088jf.dexlib2.immutable.util.CharSequenceConverter;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableMethodProtoReference extends BaseMethodProtoReference implements ImmutableReference {
    public final ImmutableList<String> parameters;
    public final String returnType;

    public ImmutableMethodProtoReference(Iterable<? extends CharSequence> iterable, String str) {
        this.parameters = CharSequenceConverter.immutableStringList(iterable);
        this.returnType = str;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableMethodProtoReference m3914of(MethodProtoReference methodProtoReference) {
        return methodProtoReference instanceof ImmutableMethodProtoReference ? (ImmutableMethodProtoReference) methodProtoReference : new ImmutableMethodProtoReference(methodProtoReference.getParameterTypes(), methodProtoReference.getReturnType());
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodProtoReference
    public List<? extends CharSequence> getParameterTypes() {
        return this.parameters;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodProtoReference
    public String getReturnType() {
        return this.returnType;
    }
}
