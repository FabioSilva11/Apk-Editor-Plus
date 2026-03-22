package org.p088jf.dexlib2.dexbacked.reference;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.p088jf.dexlib2.base.reference.BaseCallSiteReference;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;
import org.p088jf.dexlib2.dexbacked.util.EncodedArrayItemIterator;
import org.p088jf.dexlib2.iface.reference.MethodHandleReference;
import org.p088jf.dexlib2.iface.reference.MethodProtoReference;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.iface.value.MethodHandleEncodedValue;
import org.p088jf.dexlib2.iface.value.MethodTypeEncodedValue;
import org.p088jf.dexlib2.iface.value.StringEncodedValue;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedCallSiteReference extends BaseCallSiteReference {
    public final int callSiteIdOffset;
    public final int callSiteIndex;
    public int callSiteOffset = -1;
    public final DexBackedDexFile dexFile;

    public DexBackedCallSiteReference(DexBackedDexFile dexBackedDexFile, int i) {
        this.dexFile = dexBackedDexFile;
        this.callSiteIndex = i;
        this.callSiteIdOffset = dexBackedDexFile.getCallSiteSection().getOffset(i);
    }

    public final EncodedArrayItemIterator getCallSiteIterator() {
        return EncodedArrayItemIterator.newOrEmpty(this.dexFile, getCallSiteOffset());
    }

    public final int getCallSiteOffset() {
        if (this.callSiteOffset < 0) {
            this.callSiteOffset = this.dexFile.getBuffer().readSmallUint(this.callSiteIdOffset);
        }
        return this.callSiteOffset;
    }

    @Override // org.p088jf.dexlib2.iface.reference.CallSiteReference
    public List<? extends EncodedValue> getExtraArguments() {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        EncodedArrayItemIterator callSiteIterator = getCallSiteIterator();
        if (callSiteIterator.getItemCount() < 3) {
            throw new ExceptionWithContext("Invalid call site item: must contain at least 3 entries.", new Object[0]);
        }
        if (callSiteIterator.getItemCount() == 3) {
            return arrayListNewArrayList;
        }
        callSiteIterator.skipNext();
        callSiteIterator.skipNext();
        callSiteIterator.skipNext();
        for (EncodedValue nextOrNull = callSiteIterator.getNextOrNull(); nextOrNull != null; nextOrNull = callSiteIterator.getNextOrNull()) {
            arrayListNewArrayList.add(nextOrNull);
        }
        return arrayListNewArrayList;
    }

    @Override // org.p088jf.dexlib2.iface.reference.CallSiteReference
    public MethodHandleReference getMethodHandle() {
        if (getCallSiteIterator().getItemCount() < 3) {
            throw new ExceptionWithContext("Invalid call site item: must contain at least 3 entries.", new Object[0]);
        }
        EncodedValue nextOrNull = getCallSiteIterator().getNextOrNull();
        if (nextOrNull.getValueType() == 22) {
            return ((MethodHandleEncodedValue) nextOrNull).getValue();
        }
        throw new ExceptionWithContext("Invalid encoded value type (%d) for the first item in call site %d", Integer.valueOf(nextOrNull.getValueType()), Integer.valueOf(this.callSiteIndex));
    }

    @Override // org.p088jf.dexlib2.iface.reference.CallSiteReference
    public String getMethodName() {
        EncodedArrayItemIterator callSiteIterator = getCallSiteIterator();
        if (callSiteIterator.getItemCount() < 3) {
            throw new ExceptionWithContext("Invalid call site item: must contain at least 3 entries.", new Object[0]);
        }
        callSiteIterator.skipNext();
        EncodedValue nextOrNull = callSiteIterator.getNextOrNull();
        if (nextOrNull.getValueType() == 23) {
            return ((StringEncodedValue) nextOrNull).getValue();
        }
        throw new ExceptionWithContext("Invalid encoded value type (%d) for the second item in call site %d", Integer.valueOf(nextOrNull.getValueType()), Integer.valueOf(this.callSiteIndex));
    }

    @Override // org.p088jf.dexlib2.iface.reference.CallSiteReference
    public MethodProtoReference getMethodProto() {
        EncodedArrayItemIterator callSiteIterator = getCallSiteIterator();
        if (callSiteIterator.getItemCount() < 3) {
            throw new ExceptionWithContext("Invalid call site item: must contain at least 3 entries.", new Object[0]);
        }
        callSiteIterator.skipNext();
        callSiteIterator.skipNext();
        EncodedValue nextOrNull = callSiteIterator.getNextOrNull();
        if (nextOrNull.getValueType() == 21) {
            return ((MethodTypeEncodedValue) nextOrNull).getValue();
        }
        throw new ExceptionWithContext("Invalid encoded value type (%d) for the second item in call site %d", Integer.valueOf(nextOrNull.getValueType()), Integer.valueOf(this.callSiteIndex));
    }

    @Override // org.p088jf.dexlib2.iface.reference.CallSiteReference
    public String getName() {
        return String.format("call_site_%d", Integer.valueOf(this.callSiteIndex));
    }

    @Override // org.p088jf.dexlib2.base.reference.BaseReference, org.p088jf.dexlib2.iface.reference.Reference
    public void validateReference() throws Reference.InvalidReferenceException {
        int i = this.callSiteIndex;
        if (i < 0 || i >= this.dexFile.getCallSiteSection().size()) {
            throw new Reference.InvalidReferenceException("callsite@" + this.callSiteIndex);
        }
    }
}
