package org.p088jf.dexlib2.dexbacked;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p088jf.dexlib2.base.reference.BaseTypeReference;
import org.p088jf.dexlib2.dexbacked.util.AnnotationsDirectory;
import org.p088jf.dexlib2.dexbacked.util.EncodedArrayItemIterator;
import org.p088jf.dexlib2.dexbacked.util.VariableSizeListIterator;
import org.p088jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator;
import org.p088jf.dexlib2.iface.ClassDef;
import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableFieldReference;
import org.p088jf.dexlib2.immutable.reference.ImmutableMethodReference;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedClassDef extends BaseTypeReference implements ClassDef {
    public AnnotationsDirectory annotationsDirectory;
    public final int classDefOffset;
    public final DexBackedDexFile dexFile;
    public final int directMethodCount;
    public final HiddenApiRestrictionsReader hiddenApiRestrictionsReader;
    public final int instanceFieldCount;
    public final int staticFieldCount;
    public final int staticFieldsOffset;
    public final int virtualMethodCount;
    public int instanceFieldsOffset = 0;
    public int directMethodsOffset = 0;
    public int virtualMethodsOffset = 0;

    /* JADX INFO: renamed from: org.jf.dexlib2.dexbacked.DexBackedClassDef$5 */
    public class C17095 implements Iterable<DexBackedMethod> {
        public final AnnotationsDirectory.AnnotationIterator methodAnnotationIterator;
        public final AnnotationsDirectory.AnnotationIterator parameterAnnotationIterator;
        public final /* synthetic */ AnnotationsDirectory val$annotationsDirectory;
        public final /* synthetic */ Iterator val$hiddenApiRestrictionIterator;
        public final /* synthetic */ int val$methodsStartOffset;
        public final /* synthetic */ boolean val$skipDuplicates;

        public C17095(AnnotationsDirectory annotationsDirectory, int i, Iterator it, boolean z) {
            this.val$annotationsDirectory = annotationsDirectory;
            this.val$methodsStartOffset = i;
            this.val$hiddenApiRestrictionIterator = it;
            this.val$skipDuplicates = z;
            this.methodAnnotationIterator = annotationsDirectory.getMethodAnnotationIterator();
            this.parameterAnnotationIterator = annotationsDirectory.getParameterAnnotationIterator();
        }

        @Override // java.lang.Iterable
        public Iterator<DexBackedMethod> iterator() {
            return new VariableSizeLookaheadIterator<DexBackedMethod>(DexBackedClassDef.this.dexFile.getDataBuffer(), this.val$methodsStartOffset) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.5.1
                public int count;
                public int previousIndex;
                public MethodReference previousMethod;

                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator
                public DexBackedMethod readNextItem(DexReader dexReader) {
                    DexBackedMethod dexBackedMethod;
                    MethodReference methodReference;
                    ImmutableMethodReference immutableMethodReferenceM3915of;
                    do {
                        int i = this.count + 1;
                        this.count = i;
                        if (i > DexBackedClassDef.this.virtualMethodCount) {
                            return endOfData();
                        }
                        Iterator it = C17095.this.val$hiddenApiRestrictionIterator;
                        int iIntValue = it != null ? ((Integer) it.next()).intValue() : 7;
                        C17095 c17095 = C17095.this;
                        DexBackedClassDef dexBackedClassDef = DexBackedClassDef.this;
                        dexBackedMethod = new DexBackedMethod(dexBackedClassDef.dexFile, dexReader, dexBackedClassDef, this.previousIndex, c17095.methodAnnotationIterator, c17095.parameterAnnotationIterator, iIntValue);
                        methodReference = this.previousMethod;
                        immutableMethodReferenceM3915of = ImmutableMethodReference.m3915of(dexBackedMethod);
                        this.previousMethod = immutableMethodReferenceM3915of;
                        this.previousIndex = dexBackedMethod.methodIndex;
                        if (!C17095.this.val$skipDuplicates || methodReference == null) {
                            break;
                        }
                    } while (methodReference.equals(immutableMethodReferenceM3915of));
                    return dexBackedMethod;
                }
            };
        }
    }

    public class HiddenApiRestrictionsReader {
        public int directMethodsStartOffset;
        public int instanceFieldsStartOffset;
        public final int startOffset;
        public int virtualMethodsStartOffset;

        public HiddenApiRestrictionsReader(int i) {
            this.startOffset = i;
        }

        public final int getDirectMethodsStartOffset() {
            if (this.directMethodsStartOffset == 0) {
                DexReader<? extends DexBuffer> dexReader = DexBackedClassDef.this.dexFile.getDataBuffer().readerAt(getInstanceFieldsStartOffset());
                for (int i = 0; i < DexBackedClassDef.this.instanceFieldCount; i++) {
                    dexReader.readSmallUleb128();
                }
                this.directMethodsStartOffset = dexReader.getOffset();
            }
            return this.directMethodsStartOffset;
        }

        public final int getInstanceFieldsStartOffset() {
            if (this.instanceFieldsStartOffset == 0) {
                DexReader<? extends DexBuffer> dexReader = DexBackedClassDef.this.dexFile.getDataBuffer().readerAt(this.startOffset);
                for (int i = 0; i < DexBackedClassDef.this.staticFieldCount; i++) {
                    dexReader.readSmallUleb128();
                }
                this.instanceFieldsStartOffset = dexReader.getOffset();
            }
            return this.instanceFieldsStartOffset;
        }

        public final Iterator<Integer> getRestrictionsForDirectMethods() {
            return new VariableSizeListIterator<Integer>(DexBackedClassDef.this.dexFile.getDataBuffer(), getDirectMethodsStartOffset(), DexBackedClassDef.this.directMethodCount) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.HiddenApiRestrictionsReader.3
                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeListIterator, java.util.ListIterator, java.util.Iterator
                public Integer next() {
                    if (nextIndex() == DexBackedClassDef.this.directMethodCount) {
                        HiddenApiRestrictionsReader.this.virtualMethodsStartOffset = getReaderOffset();
                    }
                    return (Integer) super.next();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeListIterator
                public Integer readNextItem(DexReader<? extends DexBuffer> dexReader, int i) {
                    return Integer.valueOf(dexReader.readSmallUleb128());
                }

                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeListIterator
                public /* bridge */ /* synthetic */ Integer readNextItem(DexReader dexReader, int i) {
                    return readNextItem((DexReader<? extends DexBuffer>) dexReader, i);
                }
            };
        }

        public final Iterator<Integer> getRestrictionsForInstanceFields() {
            return new VariableSizeListIterator<Integer>(DexBackedClassDef.this.dexFile.getDataBuffer(), getInstanceFieldsStartOffset(), DexBackedClassDef.this.instanceFieldCount) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.HiddenApiRestrictionsReader.2
                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeListIterator, java.util.ListIterator, java.util.Iterator
                public Integer next() {
                    if (nextIndex() == DexBackedClassDef.this.instanceFieldCount) {
                        HiddenApiRestrictionsReader.this.directMethodsStartOffset = getReaderOffset();
                    }
                    return (Integer) super.next();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeListIterator
                public Integer readNextItem(DexReader<? extends DexBuffer> dexReader, int i) {
                    return Integer.valueOf(dexReader.readSmallUleb128());
                }

                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeListIterator
                public /* bridge */ /* synthetic */ Integer readNextItem(DexReader dexReader, int i) {
                    return readNextItem((DexReader<? extends DexBuffer>) dexReader, i);
                }
            };
        }

        public final VariableSizeListIterator<Integer> getRestrictionsForStaticFields() {
            return new VariableSizeListIterator<Integer>(DexBackedClassDef.this.dexFile.getDataBuffer(), this.startOffset, DexBackedClassDef.this.staticFieldCount) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.HiddenApiRestrictionsReader.1
                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeListIterator, java.util.ListIterator, java.util.Iterator
                public Integer next() {
                    if (nextIndex() == DexBackedClassDef.this.staticFieldCount) {
                        HiddenApiRestrictionsReader.this.instanceFieldsStartOffset = getReaderOffset();
                    }
                    return (Integer) super.next();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeListIterator
                public Integer readNextItem(DexReader<? extends DexBuffer> dexReader, int i) {
                    return Integer.valueOf(dexReader.readSmallUleb128());
                }

                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeListIterator
                public /* bridge */ /* synthetic */ Integer readNextItem(DexReader dexReader, int i) {
                    return readNextItem((DexReader<? extends DexBuffer>) dexReader, i);
                }
            };
        }

        public final Iterator<Integer> getRestrictionsForVirtualMethods() {
            return new VariableSizeListIterator<Integer>(this, DexBackedClassDef.this.dexFile.getDataBuffer(), getVirtualMethodsStartOffset(), DexBackedClassDef.this.virtualMethodCount) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.HiddenApiRestrictionsReader.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeListIterator
                public Integer readNextItem(DexReader<? extends DexBuffer> dexReader, int i) {
                    return Integer.valueOf(dexReader.readSmallUleb128());
                }

                @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeListIterator
                public /* bridge */ /* synthetic */ Integer readNextItem(DexReader dexReader, int i) {
                    return readNextItem((DexReader<? extends DexBuffer>) dexReader, i);
                }
            };
        }

        public final int getVirtualMethodsStartOffset() {
            if (this.virtualMethodsStartOffset == 0) {
                DexReader<? extends DexBuffer> dexReader = DexBackedClassDef.this.dexFile.getDataBuffer().readerAt(getDirectMethodsStartOffset());
                for (int i = 0; i < DexBackedClassDef.this.directMethodCount; i++) {
                    dexReader.readSmallUleb128();
                }
                this.virtualMethodsStartOffset = dexReader.getOffset();
            }
            return this.virtualMethodsStartOffset;
        }
    }

    public DexBackedClassDef(DexBackedDexFile dexBackedDexFile, int i, int i2) {
        this.dexFile = dexBackedDexFile;
        this.classDefOffset = i;
        int smallUint = dexBackedDexFile.getBuffer().readSmallUint(i + 24);
        if (smallUint == 0) {
            this.staticFieldsOffset = -1;
            this.staticFieldCount = 0;
            this.instanceFieldCount = 0;
            this.directMethodCount = 0;
            this.virtualMethodCount = 0;
        } else {
            DexReader<? extends DexBuffer> dexReader = dexBackedDexFile.getDataBuffer().readerAt(smallUint);
            this.staticFieldCount = dexReader.readSmallUleb128();
            this.instanceFieldCount = dexReader.readSmallUleb128();
            this.directMethodCount = dexReader.readSmallUleb128();
            this.virtualMethodCount = dexReader.readSmallUleb128();
            this.staticFieldsOffset = dexReader.getOffset();
        }
        if (i2 != 0) {
            this.hiddenApiRestrictionsReader = new HiddenApiRestrictionsReader(i2);
        } else {
            this.hiddenApiRestrictionsReader = null;
        }
    }

    @Override // org.p088jf.dexlib2.iface.ClassDef
    public int getAccessFlags() {
        return this.dexFile.getBuffer().readSmallUint(this.classDefOffset + 4);
    }

    @Override // org.p088jf.dexlib2.iface.ClassDef
    public Set<? extends DexBackedAnnotation> getAnnotations() {
        return getAnnotationsDirectory().getClassAnnotations();
    }

    public final AnnotationsDirectory getAnnotationsDirectory() {
        if (this.annotationsDirectory == null) {
            this.annotationsDirectory = AnnotationsDirectory.newOrEmpty(this.dexFile, this.dexFile.getBuffer().readSmallUint(this.classDefOffset + 20));
        }
        return this.annotationsDirectory;
    }

    @Override // org.p088jf.dexlib2.iface.ClassDef
    public Iterable<? extends DexBackedMethod> getDirectMethods() {
        return getDirectMethods(true);
    }

    public Iterable<? extends DexBackedMethod> getDirectMethods(final boolean z) {
        if (this.directMethodCount <= 0) {
            int i = this.directMethodsOffset;
            if (i > 0) {
                this.virtualMethodsOffset = i;
            }
            return ImmutableSet.m3782of();
        }
        DexReader<? extends DexBuffer> dexReader = this.dexFile.getDataBuffer().readerAt(getDirectMethodsOffset());
        final AnnotationsDirectory annotationsDirectory = getAnnotationsDirectory();
        final int offset = dexReader.getOffset();
        HiddenApiRestrictionsReader hiddenApiRestrictionsReader = this.hiddenApiRestrictionsReader;
        final Iterator restrictionsForDirectMethods = hiddenApiRestrictionsReader == null ? null : hiddenApiRestrictionsReader.getRestrictionsForDirectMethods();
        return new Iterable<DexBackedMethod>() { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.4
            @Override // java.lang.Iterable
            public Iterator<DexBackedMethod> iterator() {
                final AnnotationsDirectory.AnnotationIterator methodAnnotationIterator = annotationsDirectory.getMethodAnnotationIterator();
                final AnnotationsDirectory.AnnotationIterator parameterAnnotationIterator = annotationsDirectory.getParameterAnnotationIterator();
                return new VariableSizeLookaheadIterator<DexBackedMethod>(DexBackedClassDef.this.dexFile.getDataBuffer(), offset) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.4.1
                    public int count;
                    public int previousIndex;
                    public MethodReference previousMethod;

                    @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator
                    public DexBackedMethod readNextItem(DexReader dexReader2) {
                        DexBackedMethod dexBackedMethod;
                        MethodReference methodReference;
                        ImmutableMethodReference immutableMethodReferenceM3915of;
                        do {
                            int i2 = this.count + 1;
                            this.count = i2;
                            if (i2 > DexBackedClassDef.this.directMethodCount) {
                                DexBackedClassDef.this.virtualMethodsOffset = dexReader2.getOffset();
                                return endOfData();
                            }
                            Iterator it = restrictionsForDirectMethods;
                            int iIntValue = it != null ? ((Integer) it.next()).intValue() : 7;
                            DexBackedClassDef dexBackedClassDef = DexBackedClassDef.this;
                            dexBackedMethod = new DexBackedMethod(dexBackedClassDef.dexFile, dexReader2, dexBackedClassDef, this.previousIndex, methodAnnotationIterator, parameterAnnotationIterator, iIntValue);
                            methodReference = this.previousMethod;
                            immutableMethodReferenceM3915of = ImmutableMethodReference.m3915of(dexBackedMethod);
                            this.previousMethod = immutableMethodReferenceM3915of;
                            this.previousIndex = dexBackedMethod.methodIndex;
                            if (!z || methodReference == null) {
                                break;
                            }
                        } while (methodReference.equals(immutableMethodReferenceM3915of));
                        return dexBackedMethod;
                    }
                };
            }
        };
    }

    public final int getDirectMethodsOffset() {
        int i = this.directMethodsOffset;
        if (i > 0) {
            return i;
        }
        DexReader<? extends DexBuffer> dexReader = this.dexFile.getDataBuffer().readerAt(getInstanceFieldsOffset());
        DexBackedField.skipFields(dexReader, this.instanceFieldCount);
        int offset = dexReader.getOffset();
        this.directMethodsOffset = offset;
        return offset;
    }

    @Override // org.p088jf.dexlib2.iface.ClassDef
    public Iterable<? extends DexBackedField> getInstanceFields() {
        return getInstanceFields(true);
    }

    public Iterable<? extends DexBackedField> getInstanceFields(final boolean z) {
        if (this.instanceFieldCount <= 0) {
            int i = this.instanceFieldsOffset;
            if (i > 0) {
                this.directMethodsOffset = i;
            }
            return ImmutableSet.m3782of();
        }
        DexReader<? extends DexBuffer> dexReader = this.dexFile.getDataBuffer().readerAt(getInstanceFieldsOffset());
        final AnnotationsDirectory annotationsDirectory = getAnnotationsDirectory();
        final int offset = dexReader.getOffset();
        HiddenApiRestrictionsReader hiddenApiRestrictionsReader = this.hiddenApiRestrictionsReader;
        final Iterator restrictionsForInstanceFields = hiddenApiRestrictionsReader == null ? null : hiddenApiRestrictionsReader.getRestrictionsForInstanceFields();
        return new Iterable<DexBackedField>() { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.3
            @Override // java.lang.Iterable
            public Iterator<DexBackedField> iterator() {
                final AnnotationsDirectory.AnnotationIterator fieldAnnotationIterator = annotationsDirectory.getFieldAnnotationIterator();
                return new VariableSizeLookaheadIterator<DexBackedField>(DexBackedClassDef.this.dexFile.getDataBuffer(), offset) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.3.1
                    public int count;
                    public FieldReference previousField;
                    public int previousIndex;

                    @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator
                    public DexBackedField readNextItem(DexReader dexReader2) {
                        DexBackedField dexBackedField;
                        FieldReference fieldReference;
                        ImmutableFieldReference immutableFieldReferenceM3912of;
                        do {
                            int i2 = this.count + 1;
                            this.count = i2;
                            if (i2 > DexBackedClassDef.this.instanceFieldCount) {
                                DexBackedClassDef.this.directMethodsOffset = dexReader2.getOffset();
                                return endOfData();
                            }
                            Iterator it = restrictionsForInstanceFields;
                            int iIntValue = it != null ? ((Integer) it.next()).intValue() : 7;
                            DexBackedClassDef dexBackedClassDef = DexBackedClassDef.this;
                            dexBackedField = new DexBackedField(dexBackedClassDef.dexFile, dexReader2, dexBackedClassDef, this.previousIndex, fieldAnnotationIterator, iIntValue);
                            fieldReference = this.previousField;
                            immutableFieldReferenceM3912of = ImmutableFieldReference.m3912of(dexBackedField);
                            this.previousField = immutableFieldReferenceM3912of;
                            this.previousIndex = dexBackedField.fieldIndex;
                            if (!z || fieldReference == null) {
                                break;
                            }
                        } while (fieldReference.equals(immutableFieldReferenceM3912of));
                        return dexBackedField;
                    }
                };
            }
        };
    }

    public final int getInstanceFieldsOffset() {
        int i = this.instanceFieldsOffset;
        if (i > 0) {
            return i;
        }
        DexReader<? extends DexBuffer> dexReader = this.dexFile.getDataBuffer().readerAt(this.staticFieldsOffset);
        DexBackedField.skipFields(dexReader, this.staticFieldCount);
        int offset = dexReader.getOffset();
        this.instanceFieldsOffset = offset;
        return offset;
    }

    @Override // org.p088jf.dexlib2.iface.ClassDef
    public List<String> getInterfaces() {
        final int smallUint = this.dexFile.getBuffer().readSmallUint(this.classDefOffset + 12);
        if (smallUint <= 0) {
            return ImmutableList.m3778of();
        }
        final int smallUint2 = this.dexFile.getDataBuffer().readSmallUint(smallUint);
        return new AbstractList<String>() { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.1
            @Override // java.util.AbstractList, java.util.List
            public String get(int i) {
                return DexBackedClassDef.this.dexFile.getTypeSection().get(DexBackedClassDef.this.dexFile.getDataBuffer().readUshort(smallUint + 4 + (i * 2)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return smallUint2;
            }
        };
    }

    @Override // org.p088jf.dexlib2.iface.ClassDef
    public String getSourceFile() {
        return this.dexFile.getStringSection().getOptional(this.dexFile.getBuffer().readOptionalUint(this.classDefOffset + 16));
    }

    @Override // org.p088jf.dexlib2.iface.ClassDef
    public Iterable<? extends DexBackedField> getStaticFields() {
        return getStaticFields(true);
    }

    public Iterable<? extends DexBackedField> getStaticFields(final boolean z) {
        if (this.staticFieldCount <= 0) {
            this.instanceFieldsOffset = this.staticFieldsOffset;
            return ImmutableSet.m3782of();
        }
        DexReader<? extends DexBuffer> dexReader = this.dexFile.getDataBuffer().readerAt(this.staticFieldsOffset);
        final AnnotationsDirectory annotationsDirectory = getAnnotationsDirectory();
        final int smallUint = this.dexFile.getBuffer().readSmallUint(this.classDefOffset + 28);
        final int offset = dexReader.getOffset();
        HiddenApiRestrictionsReader hiddenApiRestrictionsReader = this.hiddenApiRestrictionsReader;
        final VariableSizeListIterator restrictionsForStaticFields = hiddenApiRestrictionsReader == null ? null : hiddenApiRestrictionsReader.getRestrictionsForStaticFields();
        return new Iterable<DexBackedField>() { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.2
            @Override // java.lang.Iterable
            public Iterator<DexBackedField> iterator() {
                final AnnotationsDirectory.AnnotationIterator fieldAnnotationIterator = annotationsDirectory.getFieldAnnotationIterator();
                final EncodedArrayItemIterator encodedArrayItemIteratorNewOrEmpty = EncodedArrayItemIterator.newOrEmpty(DexBackedClassDef.this.dexFile, smallUint);
                return new VariableSizeLookaheadIterator<DexBackedField>(DexBackedClassDef.this.dexFile.getDataBuffer(), offset) { // from class: org.jf.dexlib2.dexbacked.DexBackedClassDef.2.1
                    public int count;
                    public FieldReference previousField;
                    public int previousIndex;

                    @Override // org.p088jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator
                    public DexBackedField readNextItem(DexReader dexReader2) {
                        DexBackedField dexBackedField;
                        FieldReference fieldReference;
                        ImmutableFieldReference immutableFieldReferenceM3912of;
                        do {
                            int i = this.count + 1;
                            this.count = i;
                            if (i > DexBackedClassDef.this.staticFieldCount) {
                                DexBackedClassDef.this.instanceFieldsOffset = dexReader2.getOffset();
                                return endOfData();
                            }
                            Iterator it = restrictionsForStaticFields;
                            int iIntValue = it != null ? ((Integer) it.next()).intValue() : 7;
                            DexBackedClassDef dexBackedClassDef = DexBackedClassDef.this;
                            dexBackedField = new DexBackedField(dexBackedClassDef.dexFile, dexReader2, dexBackedClassDef, this.previousIndex, encodedArrayItemIteratorNewOrEmpty, fieldAnnotationIterator, iIntValue);
                            fieldReference = this.previousField;
                            immutableFieldReferenceM3912of = ImmutableFieldReference.m3912of(dexBackedField);
                            this.previousField = immutableFieldReferenceM3912of;
                            this.previousIndex = dexBackedField.fieldIndex;
                            if (!z || fieldReference == null) {
                                break;
                            }
                        } while (fieldReference.equals(immutableFieldReferenceM3912of));
                        return dexBackedField;
                    }
                };
            }
        };
    }

    @Override // org.p088jf.dexlib2.iface.ClassDef
    public String getSuperclass() {
        return this.dexFile.getTypeSection().getOptional(this.dexFile.getBuffer().readOptionalUint(this.classDefOffset + 8));
    }

    @Override // org.p088jf.dexlib2.iface.reference.TypeReference
    public String getType() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readSmallUint(this.classDefOffset + 0));
    }

    @Override // org.p088jf.dexlib2.iface.ClassDef
    public Iterable<? extends DexBackedMethod> getVirtualMethods() {
        return getVirtualMethods(true);
    }

    public Iterable<? extends DexBackedMethod> getVirtualMethods(boolean z) {
        if (this.virtualMethodCount <= 0) {
            return ImmutableSet.m3782of();
        }
        DexReader<? extends DexBuffer> dexReader = this.dexFile.getDataBuffer().readerAt(getVirtualMethodsOffset());
        AnnotationsDirectory annotationsDirectory = getAnnotationsDirectory();
        int offset = dexReader.getOffset();
        HiddenApiRestrictionsReader hiddenApiRestrictionsReader = this.hiddenApiRestrictionsReader;
        return new C17095(annotationsDirectory, offset, hiddenApiRestrictionsReader == null ? null : hiddenApiRestrictionsReader.getRestrictionsForVirtualMethods(), z);
    }

    public final int getVirtualMethodsOffset() {
        int i = this.virtualMethodsOffset;
        if (i > 0) {
            return i;
        }
        DexReader<? extends DexBuffer> dexReader = this.dexFile.getDataBuffer().readerAt(getDirectMethodsOffset());
        DexBackedMethod.skipMethods(dexReader, this.directMethodCount);
        int offset = dexReader.getOffset();
        this.virtualMethodsOffset = offset;
        return offset;
    }
}
