package org.p088jf.dexlib2.iface.value;

import java.util.Set;
import org.p088jf.dexlib2.iface.AnnotationElement;

/* JADX INFO: loaded from: classes.dex */
public interface AnnotationEncodedValue extends EncodedValue {
    Set<? extends AnnotationElement> getElements();

    String getType();
}
