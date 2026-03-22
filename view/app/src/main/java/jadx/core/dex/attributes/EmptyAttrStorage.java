package jadx.core.dex.attributes;

import jadx.core.dex.attributes.annotations.Annotation;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class EmptyAttrStorage extends AttributeStorage {
    @Override // jadx.core.dex.attributes.AttributeStorage
    public final void clear() {
    }

    @Override // jadx.core.dex.attributes.AttributeStorage
    public final boolean contains(AFlag aFlag) {
        return false;
    }

    @Override // jadx.core.dex.attributes.AttributeStorage
    public final boolean contains(AType aType) {
        return false;
    }

    @Override // jadx.core.dex.attributes.AttributeStorage
    public final IAttribute get(AType aType) {
        return null;
    }

    @Override // jadx.core.dex.attributes.AttributeStorage
    public final List getAll(AType aType) {
        return Collections.emptyList();
    }

    @Override // jadx.core.dex.attributes.AttributeStorage
    public final Annotation getAnnotation(String str) {
        return null;
    }

    @Override // jadx.core.dex.attributes.AttributeStorage
    public final List getAttributeStrings() {
        return Collections.emptyList();
    }

    @Override // jadx.core.dex.attributes.AttributeStorage
    public final boolean isEmpty() {
        return true;
    }

    @Override // jadx.core.dex.attributes.AttributeStorage
    public final void remove(AFlag aFlag) {
    }

    @Override // jadx.core.dex.attributes.AttributeStorage
    public final void remove(AType aType) {
    }

    @Override // jadx.core.dex.attributes.AttributeStorage
    public final void remove(IAttribute iAttribute) {
    }

    @Override // jadx.core.dex.attributes.AttributeStorage
    public final String toString() {
        return "";
    }
}
