package org.p088jf.dexlib2.writer.pool;

import org.p088jf.dexlib2.writer.NullableOffsetSection;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseNullableOffsetPool<Key> extends BaseOffsetPool<Key> implements NullableOffsetSection<Key> {
    public BaseNullableOffsetPool(DexPool dexPool) {
        super(dexPool);
    }

    @Override // org.p088jf.dexlib2.writer.NullableOffsetSection
    public int getNullableItemOffset(Key key) {
        if (key == null) {
            return 0;
        }
        return getItemOffset(key);
    }
}
