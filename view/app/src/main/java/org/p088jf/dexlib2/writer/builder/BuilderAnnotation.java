package org.p088jf.dexlib2.writer.builder;

import java.util.Set;
import org.p088jf.dexlib2.base.BaseAnnotation;

/* JADX INFO: loaded from: classes.dex */
public class BuilderAnnotation extends BaseAnnotation {
    public final Set<? extends BuilderAnnotationElement> elements;
    public int offset = 0;
    public final BuilderTypeReference type;
    public int visibility;

    public BuilderAnnotation(int i, BuilderTypeReference builderTypeReference, Set<? extends BuilderAnnotationElement> set) {
        this.visibility = i;
        this.type = builderTypeReference;
        this.elements = set;
    }

    @Override // org.p088jf.dexlib2.iface.Annotation
    public Set<? extends BuilderAnnotationElement> getElements() {
        return this.elements;
    }

    @Override // org.p088jf.dexlib2.iface.Annotation
    public String getType() {
        return this.type.getType();
    }

    @Override // org.p088jf.dexlib2.iface.Annotation
    public int getVisibility() {
        return this.visibility;
    }
}
