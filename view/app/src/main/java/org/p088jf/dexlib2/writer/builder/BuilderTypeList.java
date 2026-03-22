package org.p088jf.dexlib2.writer.builder;

import com.google.common.collect.ImmutableList;
import java.util.AbstractList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BuilderTypeList extends AbstractList<BuilderTypeReference> {
    public static final BuilderTypeList EMPTY = new BuilderTypeList(ImmutableList.m3778of());
    public int offset = 0;
    public final List<? extends BuilderTypeReference> types;

    public BuilderTypeList(List<? extends BuilderTypeReference> list) {
        this.types = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public BuilderTypeReference get(int i) {
        return this.types.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.types.size();
    }
}
