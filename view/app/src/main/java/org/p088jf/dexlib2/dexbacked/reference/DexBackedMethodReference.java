package org.p088jf.dexlib2.dexbacked.reference;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.p088jf.dexlib2.base.reference.BaseMethodReference;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.util.FixedSizeList;
import org.p088jf.dexlib2.iface.reference.Reference;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedMethodReference extends BaseMethodReference {
    public final DexBackedDexFile dexFile;
    public final int methodIndex;
    public int protoIdItemOffset;

    public DexBackedMethodReference(DexBackedDexFile dexBackedDexFile, int i) {
        this.dexFile = dexBackedDexFile;
        this.methodIndex = i;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getDefiningClass() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readUshort(this.dexFile.getMethodSection().getOffset(this.methodIndex) + 0));
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getName() {
        return this.dexFile.getStringSection().get(this.dexFile.getBuffer().readSmallUint(this.dexFile.getMethodSection().getOffset(this.methodIndex) + 4));
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference
    public List<String> getParameterTypes() {
        int smallUint = this.dexFile.getBuffer().readSmallUint(getProtoIdItemOffset() + 8);
        if (smallUint <= 0) {
            return ImmutableList.m3778of();
        }
        final int smallUint2 = this.dexFile.getDataBuffer().readSmallUint(smallUint + 0);
        final int i = smallUint + 4;
        return new FixedSizeList<String>() { // from class: org.jf.dexlib2.dexbacked.reference.DexBackedMethodReference.1
            @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeList
            public String readItem(int i2) {
                return DexBackedMethodReference.this.dexFile.getTypeSection().get(DexBackedMethodReference.this.dexFile.getDataBuffer().readUshort(i + (i2 * 2)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return smallUint2;
            }
        };
    }

    public final int getProtoIdItemOffset() {
        if (this.protoIdItemOffset == 0) {
            this.protoIdItemOffset = this.dexFile.getProtoSection().getOffset(this.dexFile.getBuffer().readUshort(this.dexFile.getMethodSection().getOffset(this.methodIndex) + 2));
        }
        return this.protoIdItemOffset;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getReturnType() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readSmallUint(getProtoIdItemOffset() + 4));
    }

    @Override // org.p088jf.dexlib2.base.reference.BaseReference, org.p088jf.dexlib2.iface.reference.Reference
    public void validateReference() throws Reference.InvalidReferenceException {
        int i = this.methodIndex;
        if (i < 0 || i >= this.dexFile.getMethodSection().size()) {
            throw new Reference.InvalidReferenceException("method@" + this.methodIndex);
        }
    }
}
