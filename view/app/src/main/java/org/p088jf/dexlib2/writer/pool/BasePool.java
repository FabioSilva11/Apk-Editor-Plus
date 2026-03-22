package org.p088jf.dexlib2.writer.pool;

import com.google.common.collect.Maps;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BasePool<Key, Value> {
    public final DexPool dexPool;
    public final Map<Key, Value> internedItems = Maps.newLinkedHashMap();

    public BasePool(DexPool dexPool) {
        this.dexPool = dexPool;
    }

    public int getItemCount() {
        return this.internedItems.size();
    }
}
