package org.p088jf.dexlib2.writer.builder;

import org.p088jf.dexlib2.base.reference.BaseStringReference;

/* JADX INFO: loaded from: classes.dex */
public class BuilderStringReference extends BaseStringReference implements BuilderReference {
    public int index = -1;
    public final String string;

    public BuilderStringReference(String str) {
        this.string = str;
    }

    @Override // org.p088jf.dexlib2.iface.reference.StringReference
    public String getString() {
        return this.string;
    }
}
