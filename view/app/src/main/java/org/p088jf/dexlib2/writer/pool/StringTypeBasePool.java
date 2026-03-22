package org.p088jf.dexlib2.writer.pool;

import java.util.Collection;
import java.util.Map;
import org.p088jf.dexlib2.writer.NullableIndexSection;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public abstract class StringTypeBasePool extends BasePool<String, Integer> implements NullableIndexSection<CharSequence> {
    public StringTypeBasePool(DexPool dexPool) {
        super(dexPool);
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public int getItemIndex(CharSequence charSequence) {
        Integer num = (Integer) this.internedItems.get(charSequence.toString());
        if (num != null) {
            return num.intValue();
        }
        throw new ExceptionWithContext("Item not found.: %s", charSequence.toString());
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public Collection<Map.Entry<String, Integer>> getItems() {
        return this.internedItems.entrySet();
    }

    @Override // org.p088jf.dexlib2.writer.NullableIndexSection
    public int getNullableItemIndex(CharSequence charSequence) {
        if (charSequence == null) {
            return -1;
        }
        return getItemIndex(charSequence);
    }
}
