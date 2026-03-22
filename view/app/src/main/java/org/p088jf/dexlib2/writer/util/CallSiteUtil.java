package org.p088jf.dexlib2.writer.util;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.p088jf.dexlib2.base.value.BaseArrayEncodedValue;
import org.p088jf.dexlib2.base.value.BaseMethodHandleEncodedValue;
import org.p088jf.dexlib2.base.value.BaseMethodTypeEncodedValue;
import org.p088jf.dexlib2.iface.reference.CallSiteReference;
import org.p088jf.dexlib2.iface.reference.MethodHandleReference;
import org.p088jf.dexlib2.iface.reference.MethodProtoReference;
import org.p088jf.dexlib2.iface.value.ArrayEncodedValue;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableStringEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class CallSiteUtil {
    public static ArrayEncodedValue getEncodedCallSite(final CallSiteReference callSiteReference) {
        return new BaseArrayEncodedValue() { // from class: org.jf.dexlib2.writer.util.CallSiteUtil.1
            @Override // org.p088jf.dexlib2.iface.value.ArrayEncodedValue
            public List<? extends EncodedValue> getValue() {
                ArrayList arrayListNewArrayList = Lists.newArrayList();
                arrayListNewArrayList.add(new BaseMethodHandleEncodedValue() { // from class: org.jf.dexlib2.writer.util.CallSiteUtil.1.1
                    @Override // org.p088jf.dexlib2.iface.value.MethodHandleEncodedValue
                    public MethodHandleReference getValue() {
                        return callSiteReference.getMethodHandle();
                    }
                });
                arrayListNewArrayList.add(new ImmutableStringEncodedValue(callSiteReference.getMethodName()));
                arrayListNewArrayList.add(new BaseMethodTypeEncodedValue() { // from class: org.jf.dexlib2.writer.util.CallSiteUtil.1.2
                    @Override // org.p088jf.dexlib2.iface.value.MethodTypeEncodedValue
                    public MethodProtoReference getValue() {
                        return callSiteReference.getMethodProto();
                    }
                });
                arrayListNewArrayList.addAll(callSiteReference.getExtraArguments());
                return arrayListNewArrayList;
            }
        };
    }
}
