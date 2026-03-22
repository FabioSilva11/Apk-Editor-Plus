package org.p088jf.dexlib2.writer.pool;

import org.p088jf.dexlib2.iface.reference.MethodProtoReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.dexlib2.writer.MethodSection;

/* JADX INFO: loaded from: classes.dex */
public class MethodPool extends BaseIndexPool<MethodReference> implements MethodSection<CharSequence, CharSequence, MethodProtoReference, MethodReference, PoolMethod> {
    public MethodPool(DexPool dexPool) {
        super(dexPool);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.p088jf.dexlib2.writer.MethodSection
    public CharSequence getDefiningClass(MethodReference methodReference) {
        return methodReference.getDefiningClass();
    }

    @Override // org.p088jf.dexlib2.writer.MethodSection
    public int getMethodIndex(PoolMethod poolMethod) {
        return getItemIndex(poolMethod);
    }

    @Override // org.p088jf.dexlib2.writer.MethodSection
    public MethodReference getMethodReference(PoolMethod poolMethod) {
        return poolMethod;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.p088jf.dexlib2.writer.MethodSection
    public CharSequence getName(MethodReference methodReference) {
        return methodReference.getName();
    }

    @Override // org.p088jf.dexlib2.writer.MethodSection
    public MethodProtoReference getPrototype(MethodReference methodReference) {
        return new PoolMethodProto(methodReference);
    }

    @Override // org.p088jf.dexlib2.writer.MethodSection
    public MethodProtoReference getPrototype(PoolMethod poolMethod) {
        return new PoolMethodProto(poolMethod);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void intern(MethodReference methodReference) {
        if (((Integer) this.internedItems.put((Key) methodReference, (Value) 0)) == null) {
            ((TypePool) this.dexPool.typeSection).intern(methodReference.getDefiningClass());
            ((ProtoPool) this.dexPool.protoSection).intern(new PoolMethodProto(methodReference));
            ((StringPool) this.dexPool.stringSection).intern(methodReference.getName());
        }
    }
}
