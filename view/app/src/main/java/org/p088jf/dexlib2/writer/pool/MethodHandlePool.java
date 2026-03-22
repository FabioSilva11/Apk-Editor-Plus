package org.p088jf.dexlib2.writer.pool;

import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.iface.reference.MethodHandleReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.dexlib2.writer.MethodHandleSection;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class MethodHandlePool extends BaseIndexPool<MethodHandleReference> implements MethodHandleSection<MethodHandleReference, FieldReference, MethodReference> {
    public MethodHandlePool(DexPool dexPool) {
        super(dexPool);
    }

    @Override // org.p088jf.dexlib2.writer.MethodHandleSection
    public FieldReference getFieldReference(MethodHandleReference methodHandleReference) {
        return (FieldReference) methodHandleReference.getMemberReference();
    }

    @Override // org.p088jf.dexlib2.writer.MethodHandleSection
    public MethodReference getMethodReference(MethodHandleReference methodHandleReference) {
        return (MethodReference) methodHandleReference.getMemberReference();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void intern(MethodHandleReference methodHandleReference) {
        if (((Integer) this.internedItems.put((Key) methodHandleReference, (Value) 0)) == null) {
            switch (methodHandleReference.getMethodHandleType()) {
                case 0:
                case 1:
                case 2:
                case 3:
                    ((FieldPool) this.dexPool.fieldSection).intern((FieldReference) methodHandleReference.getMemberReference());
                    return;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    ((MethodPool) this.dexPool.methodSection).intern((MethodReference) methodHandleReference.getMemberReference());
                    return;
                default:
                    throw new ExceptionWithContext("Invalid method handle type: %d", Integer.valueOf(methodHandleReference.getMethodHandleType()));
            }
        }
    }
}
