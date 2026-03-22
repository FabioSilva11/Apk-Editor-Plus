package org.p088jf.dexlib2.writer.builder;

import com.google.common.collect.ImmutableSet;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BuilderAnnotationSet extends AbstractSet<BuilderAnnotation> {
    public static final BuilderAnnotationSet EMPTY = new BuilderAnnotationSet(ImmutableSet.m3782of());
    public final Set<BuilderAnnotation> annotations;
    public int offset = 0;

    public BuilderAnnotationSet(Set<BuilderAnnotation> set) {
        this.annotations = set;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<BuilderAnnotation> iterator() {
        return this.annotations.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.annotations.size();
    }
}
