package org.p088jf.dexlib2.iface;

import org.p088jf.dexlib2.iface.value.EncodedValue;

/* JADX INFO: loaded from: classes.dex */
public interface AnnotationElement extends Comparable<AnnotationElement> {
    String getName();

    EncodedValue getValue();
}
