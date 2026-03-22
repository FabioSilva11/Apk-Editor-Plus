package org.p088jf.dexlib2.dexbacked.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Set;
import org.p088jf.dexlib2.dexbacked.DexBackedAnnotation;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnnotationsDirectory {
    public static final AnnotationsDirectory EMPTY = new AnnotationsDirectory() { // from class: org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.1
        @Override // org.p088jf.dexlib2.dexbacked.util.AnnotationsDirectory
        public Set<? extends DexBackedAnnotation> getClassAnnotations() {
            return ImmutableSet.m3782of();
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.AnnotationsDirectory
        public AnnotationIterator getFieldAnnotationIterator() {
            return AnnotationIterator.EMPTY;
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.AnnotationsDirectory
        public AnnotationIterator getMethodAnnotationIterator() {
            return AnnotationIterator.EMPTY;
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.AnnotationsDirectory
        public AnnotationIterator getParameterAnnotationIterator() {
            return AnnotationIterator.EMPTY;
        }
    };

    public interface AnnotationIterator {
        public static final AnnotationIterator EMPTY = new AnnotationIterator() { // from class: org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.AnnotationIterator.1
            @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.AnnotationIterator
            public int seekTo(int i) {
                return 0;
            }
        };

        int seekTo(int i);
    }

    public static class AnnotationsDirectoryImpl extends AnnotationsDirectory {
        public final DexBackedDexFile dexFile;
        public final int directoryOffset;

        public class AnnotationIteratorImpl implements AnnotationIterator {
            public int currentIndex = 0;
            public int currentItemIndex;
            public final int size;
            public final int startOffset;

            public AnnotationIteratorImpl(int i, int i2) {
                this.startOffset = i;
                this.size = i2;
                this.currentItemIndex = AnnotationsDirectoryImpl.this.dexFile.getDataBuffer().readSmallUint(i);
            }

            @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.AnnotationIterator
            public int seekTo(int i) {
                int i2;
                while (true) {
                    i2 = this.currentItemIndex;
                    if (i2 >= i) {
                        break;
                    }
                    int i3 = this.currentIndex;
                    if (i3 + 1 >= this.size) {
                        break;
                    }
                    this.currentIndex = i3 + 1;
                    this.currentItemIndex = AnnotationsDirectoryImpl.this.dexFile.getDataBuffer().readSmallUint(this.startOffset + (this.currentIndex * 8));
                }
                if (i2 == i) {
                    return AnnotationsDirectoryImpl.this.dexFile.getDataBuffer().readSmallUint(this.startOffset + (this.currentIndex * 8) + 4);
                }
                return 0;
            }
        }

        public AnnotationsDirectoryImpl(DexBackedDexFile dexBackedDexFile, int i) {
            this.dexFile = dexBackedDexFile;
            this.directoryOffset = i;
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.AnnotationsDirectory
        public Set<? extends DexBackedAnnotation> getClassAnnotations() {
            DexBackedDexFile dexBackedDexFile = this.dexFile;
            return AnnotationsDirectory.getAnnotations(dexBackedDexFile, dexBackedDexFile.getDataBuffer().readSmallUint(this.directoryOffset));
        }

        public int getFieldAnnotationCount() {
            return this.dexFile.getDataBuffer().readSmallUint(this.directoryOffset + 4);
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.AnnotationsDirectory
        public AnnotationIterator getFieldAnnotationIterator() {
            int fieldAnnotationCount = getFieldAnnotationCount();
            return fieldAnnotationCount == 0 ? AnnotationIterator.EMPTY : new AnnotationIteratorImpl(this.directoryOffset + 16, fieldAnnotationCount);
        }

        public int getMethodAnnotationCount() {
            return this.dexFile.getDataBuffer().readSmallUint(this.directoryOffset + 8);
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.AnnotationsDirectory
        public AnnotationIterator getMethodAnnotationIterator() {
            int methodAnnotationCount = getMethodAnnotationCount();
            if (methodAnnotationCount == 0) {
                return AnnotationIterator.EMPTY;
            }
            return new AnnotationIteratorImpl(this.directoryOffset + 16 + (getFieldAnnotationCount() * 8), methodAnnotationCount);
        }

        public int getParameterAnnotationCount() {
            return this.dexFile.getDataBuffer().readSmallUint(this.directoryOffset + 12);
        }

        @Override // org.p088jf.dexlib2.dexbacked.util.AnnotationsDirectory
        public AnnotationIterator getParameterAnnotationIterator() {
            int parameterAnnotationCount = getParameterAnnotationCount();
            if (parameterAnnotationCount == 0) {
                return AnnotationIterator.EMPTY;
            }
            return new AnnotationIteratorImpl(this.directoryOffset + 16 + (getFieldAnnotationCount() * 8) + (getMethodAnnotationCount() * 8), parameterAnnotationCount);
        }
    }

    public static Set<? extends DexBackedAnnotation> getAnnotations(final DexBackedDexFile dexBackedDexFile, final int i) {
        if (i == 0) {
            return ImmutableSet.m3782of();
        }
        final int smallUint = dexBackedDexFile.getDataBuffer().readSmallUint(i);
        return new FixedSizeSet<DexBackedAnnotation>() { // from class: org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.2
            @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeSet
            public DexBackedAnnotation readItem(int i2) {
                return new DexBackedAnnotation(dexBackedDexFile, dexBackedDexFile.getDataBuffer().readSmallUint(i + 4 + (i2 * 4)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return smallUint;
            }
        };
    }

    public static List<Set<? extends DexBackedAnnotation>> getParameterAnnotations(final DexBackedDexFile dexBackedDexFile, final int i) {
        if (i <= 0) {
            return ImmutableList.m3778of();
        }
        final int smallUint = dexBackedDexFile.getDataBuffer().readSmallUint(i);
        return new FixedSizeList<Set<? extends DexBackedAnnotation>>() { // from class: org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.3
            @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeList
            public Set<? extends DexBackedAnnotation> readItem(int i2) {
                return AnnotationsDirectory.getAnnotations(dexBackedDexFile, dexBackedDexFile.getDataBuffer().readSmallUint(i + 4 + (i2 * 4)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return smallUint;
            }
        };
    }

    public static AnnotationsDirectory newOrEmpty(DexBackedDexFile dexBackedDexFile, int i) {
        return i == 0 ? EMPTY : new AnnotationsDirectoryImpl(dexBackedDexFile, i);
    }

    public abstract Set<? extends DexBackedAnnotation> getClassAnnotations();

    public abstract AnnotationIterator getFieldAnnotationIterator();

    public abstract AnnotationIterator getMethodAnnotationIterator();

    public abstract AnnotationIterator getParameterAnnotationIterator();
}
