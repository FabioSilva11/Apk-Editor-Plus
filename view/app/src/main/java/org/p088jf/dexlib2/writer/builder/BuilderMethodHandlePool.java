package org.p088jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.iface.reference.MethodHandleReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.dexlib2.writer.MethodHandleSection;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class BuilderMethodHandlePool extends BaseBuilderPool implements MethodHandleSection<BuilderMethodHandleReference, BuilderFieldReference, BuilderMethodReference> {
    public final ConcurrentMap<MethodHandleReference, BuilderMethodHandleReference> internedItems;

    public BuilderMethodHandlePool(DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.newConcurrentMap();
    }

    @Override // org.p088jf.dexlib2.writer.MethodHandleSection
    public BuilderFieldReference getFieldReference(BuilderMethodHandleReference builderMethodHandleReference) {
        return (BuilderFieldReference) builderMethodHandleReference.getMemberReference();
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public int getItemIndex(BuilderMethodHandleReference builderMethodHandleReference) {
        return builderMethodHandleReference.index;
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public Collection<? extends Map.Entry<? extends BuilderMethodHandleReference, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderMethodHandleReference>(this, this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderMethodHandlePool.1
            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(BuilderMethodHandleReference builderMethodHandleReference) {
                return builderMethodHandleReference.index;
            }

            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(BuilderMethodHandleReference builderMethodHandleReference, int i) {
                int i2 = builderMethodHandleReference.index;
                builderMethodHandleReference.index = i;
                return i2;
            }
        };
    }

    @Override // org.p088jf.dexlib2.writer.MethodHandleSection
    public BuilderMethodReference getMethodReference(BuilderMethodHandleReference builderMethodHandleReference) {
        return (BuilderMethodReference) builderMethodHandleReference.getMemberReference();
    }

    public BuilderMethodHandleReference internMethodHandle(MethodHandleReference methodHandleReference) {
        BuilderReference builderReferenceInternFieldReference;
        BuilderMethodHandleReference builderMethodHandleReference = this.internedItems.get(methodHandleReference);
        if (builderMethodHandleReference != null) {
            return builderMethodHandleReference;
        }
        switch (methodHandleReference.getMethodHandleType()) {
            case 0:
            case 1:
            case 2:
            case 3:
                builderReferenceInternFieldReference = this.dexBuilder.internFieldReference((FieldReference) methodHandleReference.getMemberReference());
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                builderReferenceInternFieldReference = this.dexBuilder.internMethodReference((MethodReference) methodHandleReference.getMemberReference());
                break;
            default:
                throw new ExceptionWithContext("Invalid method handle type: %d", Integer.valueOf(methodHandleReference.getMethodHandleType()));
        }
        BuilderMethodHandleReference builderMethodHandleReference2 = new BuilderMethodHandleReference(methodHandleReference.getMethodHandleType(), builderReferenceInternFieldReference);
        BuilderMethodHandleReference builderMethodHandleReferencePutIfAbsent = this.internedItems.putIfAbsent(builderMethodHandleReference2, builderMethodHandleReference2);
        return builderMethodHandleReferencePutIfAbsent == null ? builderMethodHandleReference2 : builderMethodHandleReferencePutIfAbsent;
    }
}
