package org.p088jf.dexlib2.writer;

import org.p088jf.dexlib2.iface.reference.TypeReference;

/* JADX INFO: loaded from: classes.dex */
public interface TypeSection<StringKey, TypeKey, TypeRef extends TypeReference> extends NullableIndexSection<TypeKey> {
    int getItemIndex(TypeRef typeref);

    StringKey getString(TypeKey typekey);
}
