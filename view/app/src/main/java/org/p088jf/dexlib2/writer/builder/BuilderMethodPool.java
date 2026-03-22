package org.p088jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import org.p088jf.dexlib2.base.reference.BaseMethodReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.dexlib2.writer.MethodSection;

/* JADX INFO: loaded from: classes.dex */
public class BuilderMethodPool extends BaseBuilderPool implements MethodSection<BuilderStringReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderMethodReference, BuilderMethod> {
    public final ConcurrentMap<MethodReference, BuilderMethodReference> internedItems;

    public static class MethodKey extends BaseMethodReference {
        public final String definingClass;
        public final String name;
        public final List<? extends CharSequence> parameterTypes;
        public final String returnType;

        public MethodKey(String str, String str2, List<? extends CharSequence> list, String str3) {
            this.definingClass = str;
            this.name = str2;
            this.parameterTypes = list;
            this.returnType = str3;
        }

        @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
        public String getDefiningClass() {
            return this.definingClass;
        }

        @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
        public String getName() {
            return this.name;
        }

        @Override // org.p088jf.dexlib2.iface.reference.MethodReference
        public List<? extends CharSequence> getParameterTypes() {
            return this.parameterTypes;
        }

        @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
        public String getReturnType() {
            return this.returnType;
        }
    }

    public BuilderMethodPool(DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.newConcurrentMap();
    }

    @Override // org.p088jf.dexlib2.writer.MethodSection
    public BuilderTypeReference getDefiningClass(BuilderMethodReference builderMethodReference) {
        return builderMethodReference.definingClass;
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public int getItemIndex(BuilderMethodReference builderMethodReference) {
        return builderMethodReference.index;
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public Collection<? extends Map.Entry<? extends BuilderMethodReference, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderMethodReference>(this, this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderMethodPool.1
            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(BuilderMethodReference builderMethodReference) {
                return builderMethodReference.index;
            }

            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(BuilderMethodReference builderMethodReference, int i) {
                int i2 = builderMethodReference.index;
                builderMethodReference.index = i;
                return i2;
            }
        };
    }

    @Override // org.p088jf.dexlib2.writer.MethodSection
    public int getMethodIndex(BuilderMethod builderMethod) {
        return builderMethod.methodReference.index;
    }

    @Override // org.p088jf.dexlib2.writer.MethodSection
    public BuilderMethodReference getMethodReference(BuilderMethod builderMethod) {
        return builderMethod.methodReference;
    }

    @Override // org.p088jf.dexlib2.writer.MethodSection
    public BuilderStringReference getName(BuilderMethodReference builderMethodReference) {
        return builderMethodReference.name;
    }

    @Override // org.p088jf.dexlib2.writer.MethodSection
    public BuilderMethodProtoReference getPrototype(BuilderMethod builderMethod) {
        return builderMethod.methodReference.proto;
    }

    @Override // org.p088jf.dexlib2.writer.MethodSection
    public BuilderMethodProtoReference getPrototype(BuilderMethodReference builderMethodReference) {
        return builderMethodReference.proto;
    }

    public BuilderMethodReference internMethod(String str, String str2, List<? extends CharSequence> list, String str3) {
        return internMethod(new MethodKey(str, str2, list, str3));
    }

    public BuilderMethodReference internMethod(MethodReference methodReference) {
        BuilderMethodReference builderMethodReference = this.internedItems.get(methodReference);
        if (builderMethodReference != null) {
            return builderMethodReference;
        }
        BuilderMethodReference builderMethodReference2 = new BuilderMethodReference(((BuilderTypePool) this.dexBuilder.typeSection).internType(methodReference.getDefiningClass()), ((BuilderStringPool) this.dexBuilder.stringSection).internString(methodReference.getName()), ((BuilderProtoPool) this.dexBuilder.protoSection).internMethodProto(methodReference));
        BuilderMethodReference builderMethodReferencePutIfAbsent = this.internedItems.putIfAbsent(builderMethodReference2, builderMethodReference2);
        return builderMethodReferencePutIfAbsent == null ? builderMethodReference2 : builderMethodReferencePutIfAbsent;
    }
}
