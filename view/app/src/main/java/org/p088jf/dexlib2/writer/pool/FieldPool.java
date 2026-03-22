package org.p088jf.dexlib2.writer.pool;

import org.p088jf.dexlib2.iface.Field;
import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.writer.FieldSection;

/* JADX INFO: loaded from: classes.dex */
public class FieldPool extends BaseIndexPool<FieldReference> implements FieldSection<CharSequence, CharSequence, FieldReference, Field> {
    public FieldPool(DexPool dexPool) {
        super(dexPool);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.p088jf.dexlib2.writer.FieldSection
    public CharSequence getDefiningClass(FieldReference fieldReference) {
        return fieldReference.getDefiningClass();
    }

    @Override // org.p088jf.dexlib2.writer.FieldSection
    public int getFieldIndex(Field field) {
        return getItemIndex(field);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.p088jf.dexlib2.writer.FieldSection
    public CharSequence getFieldType(FieldReference fieldReference) {
        return fieldReference.getType();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.p088jf.dexlib2.writer.FieldSection
    public CharSequence getName(FieldReference fieldReference) {
        return fieldReference.getName();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void intern(FieldReference fieldReference) {
        if (((Integer) this.internedItems.put((Key) fieldReference, (Value) 0)) == null) {
            ((TypePool) this.dexPool.typeSection).intern(fieldReference.getDefiningClass());
            ((StringPool) this.dexPool.stringSection).intern(fieldReference.getName());
            ((TypePool) this.dexPool.typeSection).intern(fieldReference.getType());
        }
    }
}
