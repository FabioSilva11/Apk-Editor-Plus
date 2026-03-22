package org.p088jf.dexlib2.dexbacked;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.base.reference.BaseMethodReference;
import org.p088jf.dexlib2.dexbacked.util.AnnotationsDirectory;
import org.p088jf.dexlib2.dexbacked.util.FixedSizeList;
import org.p088jf.dexlib2.dexbacked.util.ParameterIterator;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.Method;
import org.p088jf.dexlib2.iface.MethodParameter;
import org.p088jf.util.AbstractForwardSequentialList;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedMethod extends BaseMethodReference implements Method {
    public final int accessFlags;
    public final DexBackedClassDef classDef;
    public final int codeOffset;
    public final DexBackedDexFile dexFile;
    public final int hiddenApiRestrictions;
    public final int methodAnnotationSetOffset;
    public int methodIdItemOffset;
    public final int methodIndex;
    public final int parameterAnnotationSetListOffset;
    public int parametersOffset = -1;
    public int protoIdItemOffset;

    public DexBackedMethod(DexBackedDexFile dexBackedDexFile, DexReader dexReader, DexBackedClassDef dexBackedClassDef, int i, AnnotationsDirectory.AnnotationIterator annotationIterator, AnnotationsDirectory.AnnotationIterator annotationIterator2, int i2) {
        this.dexFile = dexBackedDexFile;
        this.classDef = dexBackedClassDef;
        dexReader.getOffset();
        int largeUleb128 = dexReader.readLargeUleb128() + i;
        this.methodIndex = largeUleb128;
        this.accessFlags = dexReader.readSmallUleb128();
        this.codeOffset = dexReader.readSmallUleb128();
        this.hiddenApiRestrictions = i2;
        this.methodAnnotationSetOffset = annotationIterator.seekTo(largeUleb128);
        this.parameterAnnotationSetListOffset = annotationIterator2.seekTo(largeUleb128);
    }

    public static void skipMethods(DexReader dexReader, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            dexReader.skipUleb128();
            dexReader.skipUleb128();
            dexReader.skipUleb128();
        }
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public Set<? extends Annotation> getAnnotations() {
        return AnnotationsDirectory.getAnnotations(this.dexFile, this.methodAnnotationSetOffset);
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getDefiningClass() {
        return this.classDef.getType();
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        int i = this.hiddenApiRestrictions;
        return i == 7 ? ImmutableSet.m3782of() : EnumSet.copyOf((Collection) HiddenApiRestriction.getAllFlags(i));
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public DexBackedMethodImplementation getImplementation() {
        int i = this.codeOffset;
        if (i <= 0) {
            return null;
        }
        DexBackedDexFile dexBackedDexFile = this.dexFile;
        return dexBackedDexFile.createMethodImplementation(dexBackedDexFile, this, i);
    }

    public final int getMethodIdItemOffset() {
        if (this.methodIdItemOffset == 0) {
            this.methodIdItemOffset = this.dexFile.getMethodSection().getOffset(this.methodIndex);
        }
        return this.methodIdItemOffset;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getName() {
        return this.dexFile.getStringSection().get(this.dexFile.getBuffer().readSmallUint(getMethodIdItemOffset() + 4));
    }

    public List<? extends Set<? extends DexBackedAnnotation>> getParameterAnnotations() {
        return AnnotationsDirectory.getParameterAnnotations(this.dexFile, this.parameterAnnotationSetListOffset);
    }

    public Iterator<String> getParameterNames() {
        DexBackedMethodImplementation implementation = getImplementation();
        return implementation != null ? implementation.getParameterNames(null) : ImmutableSet.m3782of().iterator();
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference
    public List<String> getParameterTypes() {
        int parametersOffset = getParametersOffset();
        if (parametersOffset <= 0) {
            return ImmutableList.m3778of();
        }
        final int smallUint = this.dexFile.getDataBuffer().readSmallUint(parametersOffset + 0);
        final int i = parametersOffset + 4;
        return new FixedSizeList<String>() { // from class: org.jf.dexlib2.dexbacked.DexBackedMethod.2
            @Override // org.p088jf.dexlib2.dexbacked.util.FixedSizeList
            public String readItem(int i2) {
                return DexBackedMethod.this.dexFile.getTypeSection().get(DexBackedMethod.this.dexFile.getDataBuffer().readUshort(i + (i2 * 2)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return smallUint;
            }
        };
    }

    @Override // org.p088jf.dexlib2.iface.Method
    public List<? extends MethodParameter> getParameters() {
        if (getParametersOffset() <= 0) {
            return ImmutableList.m3778of();
        }
        final List<String> parameterTypes = getParameterTypes();
        return new AbstractForwardSequentialList<MethodParameter>() { // from class: org.jf.dexlib2.dexbacked.DexBackedMethod.1
            @Override // org.p088jf.util.AbstractForwardSequentialList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
            public Iterator<MethodParameter> iterator() {
                return new ParameterIterator(parameterTypes, DexBackedMethod.this.getParameterAnnotations(), DexBackedMethod.this.getParameterNames());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return parameterTypes.size();
            }
        };
    }

    public final int getParametersOffset() {
        if (this.parametersOffset == -1) {
            this.parametersOffset = this.dexFile.getBuffer().readSmallUint(getProtoIdItemOffset() + 8);
        }
        return this.parametersOffset;
    }

    public final int getProtoIdItemOffset() {
        if (this.protoIdItemOffset == 0) {
            this.protoIdItemOffset = this.dexFile.getProtoSection().getOffset(this.dexFile.getBuffer().readUshort(getMethodIdItemOffset() + 2));
        }
        return this.protoIdItemOffset;
    }

    @Override // org.p088jf.dexlib2.iface.reference.MethodReference, org.p088jf.dexlib2.iface.Method
    public String getReturnType() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readSmallUint(getProtoIdItemOffset() + 4));
    }
}
