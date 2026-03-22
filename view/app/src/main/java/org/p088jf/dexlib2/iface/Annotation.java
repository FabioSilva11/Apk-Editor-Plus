package org.p088jf.dexlib2.iface;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface Annotation extends Comparable<Annotation> {
    Set<? extends AnnotationElement> getElements();

    String getType();

    int getVisibility();
}
