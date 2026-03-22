package org.p088jf.dexlib2.immutable.reference;

import org.p088jf.dexlib2.base.reference.BaseStringReference;
import org.p088jf.dexlib2.iface.reference.StringReference;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableStringReference extends BaseStringReference implements ImmutableReference {
    public final String str;

    public ImmutableStringReference(String str) {
        this.str = str;
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableStringReference m3918of(StringReference stringReference) {
        return stringReference instanceof ImmutableStringReference ? (ImmutableStringReference) stringReference : new ImmutableStringReference(stringReference.getString());
    }

    @Override // org.p088jf.dexlib2.iface.reference.StringReference
    public String getString() {
        return this.str;
    }
}
