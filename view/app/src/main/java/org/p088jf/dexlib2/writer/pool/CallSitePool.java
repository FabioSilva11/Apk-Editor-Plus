package org.p088jf.dexlib2.writer.pool;

import org.p088jf.dexlib2.iface.reference.CallSiteReference;
import org.p088jf.dexlib2.iface.value.ArrayEncodedValue;
import org.p088jf.dexlib2.writer.CallSiteSection;
import org.p088jf.dexlib2.writer.util.CallSiteUtil;

/* JADX INFO: loaded from: classes.dex */
public class CallSitePool extends BaseIndexPool<CallSiteReference> implements CallSiteSection<CallSiteReference, ArrayEncodedValue> {
    public CallSitePool(DexPool dexPool) {
        super(dexPool);
    }

    @Override // org.p088jf.dexlib2.writer.CallSiteSection
    public ArrayEncodedValue getEncodedCallSite(CallSiteReference callSiteReference) {
        return CallSiteUtil.getEncodedCallSite(callSiteReference);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void intern(CallSiteReference callSiteReference) {
        if (((Integer) this.internedItems.put((Key) callSiteReference, (Value) 0)) == null) {
            ((EncodedArrayPool) this.dexPool.encodedArraySection).intern(getEncodedCallSite(callSiteReference));
        }
    }
}
