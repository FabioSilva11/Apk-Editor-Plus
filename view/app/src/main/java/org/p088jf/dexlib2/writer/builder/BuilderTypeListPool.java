package org.p088jf.dexlib2.writer.builder;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import org.p088jf.dexlib2.writer.TypeListSection;

/* JADX INFO: loaded from: classes.dex */
public class BuilderTypeListPool extends BaseBuilderPool implements TypeListSection<BuilderTypeReference, BuilderTypeList> {
    public final ConcurrentMap<List<? extends CharSequence>, BuilderTypeList> internedItems;

    public BuilderTypeListPool(DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.newConcurrentMap();
    }

    @Override // org.p088jf.dexlib2.writer.OffsetSection
    public Collection<? extends Map.Entry<? extends BuilderTypeList, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderTypeList>(this, this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderTypeListPool.2
            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(BuilderTypeList builderTypeList) {
                return builderTypeList.offset;
            }

            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(BuilderTypeList builderTypeList, int i) {
                int i2 = builderTypeList.offset;
                builderTypeList.offset = i;
                return i2;
            }
        };
    }

    @Override // org.p088jf.dexlib2.writer.TypeListSection, org.p088jf.dexlib2.writer.NullableOffsetSection
    public int getNullableItemOffset(BuilderTypeList builderTypeList) {
        if (builderTypeList == null || builderTypeList.size() == 0) {
            return 0;
        }
        return builderTypeList.offset;
    }

    @Override // org.p088jf.dexlib2.writer.TypeListSection
    public Collection<? extends BuilderTypeReference> getTypes(BuilderTypeList builderTypeList) {
        return builderTypeList == null ? BuilderTypeList.EMPTY : builderTypeList.types;
    }

    public BuilderTypeList internTypeList(List<? extends CharSequence> list) {
        if (list == null || list.size() == 0) {
            return BuilderTypeList.EMPTY;
        }
        BuilderTypeList builderTypeList = this.internedItems.get(list);
        if (builderTypeList != null) {
            return builderTypeList;
        }
        BuilderTypeList builderTypeList2 = new BuilderTypeList(ImmutableList.copyOf(Iterables.transform(list, new Function<CharSequence, BuilderTypeReference>() { // from class: org.jf.dexlib2.writer.builder.BuilderTypeListPool.1
            @Override // com.google.common.base.Function
            public BuilderTypeReference apply(CharSequence charSequence) {
                return ((BuilderTypePool) BuilderTypeListPool.this.dexBuilder.typeSection).internType(charSequence.toString());
            }
        })));
        BuilderTypeList builderTypeListPutIfAbsent = this.internedItems.putIfAbsent(builderTypeList2, builderTypeList2);
        return builderTypeListPutIfAbsent == null ? builderTypeList2 : builderTypeListPutIfAbsent;
    }
}
