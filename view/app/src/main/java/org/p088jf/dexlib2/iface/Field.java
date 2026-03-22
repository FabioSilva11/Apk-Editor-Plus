package org.p088jf.dexlib2.iface;

import java.util.Set;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.iface.value.EncodedValue;

/* JADX INFO: loaded from: classes.dex */
public interface Field extends FieldReference {
    int getAccessFlags();

    Set<? extends Annotation> getAnnotations();

    String getDefiningClass();

    Set<HiddenApiRestriction> getHiddenApiRestrictions();

    EncodedValue getInitialValue();

    String getName();

    String getType();
}
