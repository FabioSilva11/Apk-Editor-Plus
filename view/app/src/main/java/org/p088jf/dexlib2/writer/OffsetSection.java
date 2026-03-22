package org.p088jf.dexlib2.writer;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface OffsetSection<Key> {
    int getItemOffset(Key key);

    Collection<? extends Map.Entry<? extends Key, Integer>> getItems();
}
