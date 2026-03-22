package org.p088jf.dexlib2.writer.builder;

import org.p088jf.dexlib2.base.reference.BaseTypeReference;

/* JADX INFO: loaded from: classes.dex */
public class BuilderTypeReference extends BaseTypeReference implements BuilderReference {
    public int index = -1;
    public final BuilderStringReference stringReference;

    public BuilderTypeReference(BuilderStringReference builderStringReference) {
        this.stringReference = builderStringReference;
    }

    public int getIndex() {
        return this.index;
    }

    @Override // org.p088jf.dexlib2.iface.reference.TypeReference
    public String getType() {
        return this.stringReference.getString();
    }
}
