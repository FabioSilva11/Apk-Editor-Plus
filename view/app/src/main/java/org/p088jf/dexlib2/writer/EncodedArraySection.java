package org.p088jf.dexlib2.writer;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface EncodedArraySection<EncodedArrayKey, EncodedValue> extends OffsetSection<EncodedArrayKey> {
    List<? extends EncodedValue> getEncodedValueList(EncodedArrayKey encodedarraykey);
}
