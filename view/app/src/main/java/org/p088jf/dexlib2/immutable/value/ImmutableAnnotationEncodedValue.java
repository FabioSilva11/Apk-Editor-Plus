package org.p088jf.dexlib2.immutable.value;

import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import org.p088jf.dexlib2.base.value.BaseAnnotationEncodedValue;
import org.p088jf.dexlib2.iface.AnnotationElement;
import org.p088jf.dexlib2.iface.value.AnnotationEncodedValue;
import org.p088jf.dexlib2.immutable.ImmutableAnnotationElement;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableAnnotationEncodedValue extends BaseAnnotationEncodedValue implements ImmutableEncodedValue {
    public final ImmutableSet<? extends ImmutableAnnotationElement> elements;
    public final String type;

    public ImmutableAnnotationEncodedValue(String str, Collection<? extends AnnotationElement> collection) {
        this.type = str;
        this.elements = ImmutableAnnotationElement.immutableSetOf(collection);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableAnnotationEncodedValue m3920of(AnnotationEncodedValue annotationEncodedValue) {
        return annotationEncodedValue instanceof ImmutableAnnotationEncodedValue ? (ImmutableAnnotationEncodedValue) annotationEncodedValue : new ImmutableAnnotationEncodedValue(annotationEncodedValue.getType(), annotationEncodedValue.getElements());
    }

    @Override // org.p088jf.dexlib2.iface.value.AnnotationEncodedValue
    public ImmutableSet<? extends ImmutableAnnotationElement> getElements() {
        return this.elements;
    }

    @Override // org.p088jf.dexlib2.iface.value.AnnotationEncodedValue
    public String getType() {
        return this.type;
    }
}
