package org.p088jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import org.p088jf.dexlib2.iface.value.ArrayEncodedValue;
import org.p088jf.dexlib2.writer.EncodedArraySection;
import org.p088jf.dexlib2.writer.builder.BuilderEncodedValues;

/* JADX INFO: loaded from: classes.dex */
public class BuilderEncodedArrayPool extends BaseBuilderPool implements EncodedArraySection<BuilderEncodedValues.BuilderArrayEncodedValue, BuilderEncodedValues.BuilderEncodedValue> {
    public final ConcurrentMap<ArrayEncodedValue, BuilderEncodedValues.BuilderArrayEncodedValue> internedItems;

    public BuilderEncodedArrayPool(DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.newConcurrentMap();
    }

    @Override // org.p088jf.dexlib2.writer.EncodedArraySection
    public List<? extends BuilderEncodedValues.BuilderEncodedValue> getEncodedValueList(BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue) {
        return builderArrayEncodedValue.elements;
    }

    @Override // org.p088jf.dexlib2.writer.OffsetSection
    public int getItemOffset(BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue) {
        return builderArrayEncodedValue.offset;
    }

    @Override // org.p088jf.dexlib2.writer.OffsetSection
    public Collection<? extends Map.Entry<? extends BuilderEncodedValues.BuilderArrayEncodedValue, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderEncodedValues.BuilderArrayEncodedValue>(this, this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderEncodedArrayPool.1
            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue) {
                return builderArrayEncodedValue.offset;
            }

            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue, int i) {
                int i2 = builderArrayEncodedValue.offset;
                builderArrayEncodedValue.offset = i;
                return i2;
            }
        };
    }

    public BuilderEncodedValues.BuilderArrayEncodedValue internArrayEncodedValue(ArrayEncodedValue arrayEncodedValue) {
        BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue = this.internedItems.get(arrayEncodedValue);
        if (builderArrayEncodedValue != null) {
            return builderArrayEncodedValue;
        }
        BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue2 = (BuilderEncodedValues.BuilderArrayEncodedValue) this.dexBuilder.internEncodedValue(arrayEncodedValue);
        BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValuePutIfAbsent = this.internedItems.putIfAbsent(builderArrayEncodedValue2, builderArrayEncodedValue2);
        return builderArrayEncodedValuePutIfAbsent == null ? builderArrayEncodedValue2 : builderArrayEncodedValuePutIfAbsent;
    }
}
