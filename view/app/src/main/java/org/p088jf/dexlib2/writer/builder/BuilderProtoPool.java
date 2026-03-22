package org.p088jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import org.p088jf.dexlib2.iface.reference.MethodProtoReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableMethodProtoReference;
import org.p088jf.dexlib2.util.MethodUtil;
import org.p088jf.dexlib2.writer.ProtoSection;

/* JADX INFO: loaded from: classes.dex */
public class BuilderProtoPool extends BaseBuilderPool implements ProtoSection<BuilderStringReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderTypeList> {
    public final ConcurrentMap<MethodProtoReference, BuilderMethodProtoReference> internedItems;

    public BuilderProtoPool(DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.newConcurrentMap();
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public int getItemIndex(BuilderMethodProtoReference builderMethodProtoReference) {
        return builderMethodProtoReference.getIndex();
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public Collection<? extends Map.Entry<? extends BuilderMethodProtoReference, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderMethodProtoReference>(this, this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderProtoPool.1
            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(BuilderMethodProtoReference builderMethodProtoReference) {
                return builderMethodProtoReference.index;
            }

            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(BuilderMethodProtoReference builderMethodProtoReference, int i) {
                int i2 = builderMethodProtoReference.index;
                builderMethodProtoReference.index = i;
                return i2;
            }
        };
    }

    @Override // org.p088jf.dexlib2.writer.ProtoSection
    public BuilderTypeList getParameters(BuilderMethodProtoReference builderMethodProtoReference) {
        return builderMethodProtoReference.parameterTypes;
    }

    @Override // org.p088jf.dexlib2.writer.ProtoSection
    public BuilderTypeReference getReturnType(BuilderMethodProtoReference builderMethodProtoReference) {
        return builderMethodProtoReference.returnType;
    }

    @Override // org.p088jf.dexlib2.writer.ProtoSection
    public BuilderStringReference getShorty(BuilderMethodProtoReference builderMethodProtoReference) {
        return builderMethodProtoReference.shorty;
    }

    public BuilderMethodProtoReference internMethodProto(MethodProtoReference methodProtoReference) {
        BuilderMethodProtoReference builderMethodProtoReference = this.internedItems.get(methodProtoReference);
        if (builderMethodProtoReference != null) {
            return builderMethodProtoReference;
        }
        BuilderMethodProtoReference builderMethodProtoReference2 = new BuilderMethodProtoReference(((BuilderStringPool) this.dexBuilder.stringSection).internString(MethodUtil.getShorty(methodProtoReference.getParameterTypes(), methodProtoReference.getReturnType())), ((BuilderTypeListPool) this.dexBuilder.typeListSection).internTypeList(methodProtoReference.getParameterTypes()), ((BuilderTypePool) this.dexBuilder.typeSection).internType(methodProtoReference.getReturnType()));
        BuilderMethodProtoReference builderMethodProtoReferencePutIfAbsent = this.internedItems.putIfAbsent(builderMethodProtoReference2, builderMethodProtoReference2);
        return builderMethodProtoReferencePutIfAbsent == null ? builderMethodProtoReference2 : builderMethodProtoReferencePutIfAbsent;
    }

    public BuilderMethodProtoReference internMethodProto(MethodReference methodReference) {
        return internMethodProto(new ImmutableMethodProtoReference(methodReference.getParameterTypes(), methodReference.getReturnType()));
    }
}
