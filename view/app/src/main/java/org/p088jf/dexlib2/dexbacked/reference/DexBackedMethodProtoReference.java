package org.p088jf.dexlib2.dexbacked.reference;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.p088jf.dexlib2.base.reference.BaseMethodProtoReference;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.util.FixedSizeList;
import org.p088jf.dexlib2.iface.reference.Reference;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedMethodProtoReference extends BaseMethodProtoReference {
    public final DexBackedDexFile dexFile;
    public final int protoIndex;

    public DexBackedMethodProtoReference(DexBackedDexFile dexBackedDexFile, int i) {
        this.dexFile = dexBackedDexFile;
        this.protoIndex = i;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodProtoReference
    public List<String> getParameterTypes() {
        int smallUint = this.dexFile.getBuffer().readSmallUint(this.dexFile.getProtoSection().getOffset(this.protoIndex) + 8);
        if (smallUint <= 0) {
            return ImmutableList.m3778of();
        }
        final int smallUint2 = this.dexFile.getDataBuffer().readSmallUint(smallUint + 0);
        final int i = smallUint + 4;
        return new FixedSizeList<String>() { // from class: org.jf.dexlib2.dexbacked.reference.DexBackedMethodProtoReference.1
            @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeList
            public String readItem(int i2) {
                return DexBackedMethodProtoReference.this.dexFile.getTypeSection().get(DexBackedMethodProtoReference.this.dexFile.getDataBuffer().readUshort(i + (i2 * 2)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return smallUint2;
            }
        };
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodProtoReference
    public String getReturnType() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readSmallUint(this.dexFile.getProtoSection().getOffset(this.protoIndex) + 4));
    }

    @Override // org.p088jf.dexlib2.base.reference.BaseReference, org.p088jf.dexlib2.iface.reference.Reference
    public void validateReference() throws Reference.InvalidReferenceException {
        int i = this.protoIndex;
        if (i < 0 || i >= this.dexFile.getProtoSection().size()) {
            throw new Reference.InvalidReferenceException("proto@" + this.protoIndex);
        }
    }
}
