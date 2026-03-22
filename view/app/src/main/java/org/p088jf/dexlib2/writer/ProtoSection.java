package org.p088jf.dexlib2.writer;

/* JADX INFO: loaded from: classes.dex */
public interface ProtoSection<StringKey, TypeKey, ProtoKey, TypeListKey> extends IndexSection<ProtoKey> {
    TypeListKey getParameters(ProtoKey protokey);

    TypeKey getReturnType(ProtoKey protokey);

    StringKey getShorty(ProtoKey protokey);
}
