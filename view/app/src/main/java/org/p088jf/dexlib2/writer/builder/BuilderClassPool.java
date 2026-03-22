package org.p088jf.dexlib2.writer.builder;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.builder.MutableMethodImplementation;
import org.p088jf.dexlib2.iface.ExceptionHandler;
import org.p088jf.dexlib2.iface.Field;
import org.p088jf.dexlib2.iface.MethodImplementation;
import org.p088jf.dexlib2.iface.TryBlock;
import org.p088jf.dexlib2.iface.debug.DebugItem;
import org.p088jf.dexlib2.iface.debug.EndLocal;
import org.p088jf.dexlib2.iface.debug.LineNumber;
import org.p088jf.dexlib2.iface.debug.RestartLocal;
import org.p088jf.dexlib2.iface.debug.SetSourceFile;
import org.p088jf.dexlib2.iface.debug.StartLocal;
import org.p088jf.dexlib2.iface.instruction.Instruction;
import org.p088jf.dexlib2.iface.reference.StringReference;
import org.p088jf.dexlib2.iface.reference.TypeReference;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.util.EncodedValueUtils;
import org.p088jf.dexlib2.writer.ClassSection;
import org.p088jf.dexlib2.writer.DebugWriter;
import org.p088jf.dexlib2.writer.builder.BuilderEncodedValues;
import org.p088jf.util.AbstractForwardSequentialList;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class BuilderClassPool extends BaseBuilderPool implements ClassSection<BuilderStringReference, BuilderTypeReference, BuilderTypeList, BuilderClassDef, BuilderField, BuilderMethod, BuilderAnnotationSet, BuilderEncodedValues.BuilderArrayEncodedValue> {
    public static final Predicate<BuilderMethodParameter> HAS_PARAMETER_ANNOTATIONS;
    public static final Function<BuilderMethodParameter, BuilderAnnotationSet> PARAMETER_ANNOTATIONS;
    public final ConcurrentMap<String, BuilderClassDef> internedItems;
    public ImmutableList<BuilderClassDef> sortedClasses;

    static {
        new Predicate<Field>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.2
            @Override // com.google.common.base.Predicate
            public boolean apply(Field field) {
                EncodedValue initialValue = field.getInitialValue();
                return (initialValue == null || EncodedValueUtils.isDefaultValue(initialValue)) ? false : true;
            }
        };
        new Function<BuilderField, BuilderEncodedValues.BuilderEncodedValue>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.3
            @Override // com.google.common.base.Function
            public BuilderEncodedValues.BuilderEncodedValue apply(BuilderField builderField) {
                BuilderEncodedValues.BuilderEncodedValue initialValue = builderField.getInitialValue();
                return initialValue == null ? BuilderEncodedValues.defaultValueForType(builderField.getType()) : initialValue;
            }
        };
        HAS_PARAMETER_ANNOTATIONS = new Predicate<BuilderMethodParameter>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.4
            @Override // com.google.common.base.Predicate
            public boolean apply(BuilderMethodParameter builderMethodParameter) {
                return builderMethodParameter.getAnnotations().size() > 0;
            }
        };
        PARAMETER_ANNOTATIONS = new Function<BuilderMethodParameter, BuilderAnnotationSet>() { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.5
            @Override // com.google.common.base.Function
            public BuilderAnnotationSet apply(BuilderMethodParameter builderMethodParameter) {
                return builderMethodParameter.getAnnotations();
            }
        };
    }

    public BuilderClassPool(DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.newConcurrentMap();
        this.sortedClasses = null;
    }

    public final BuilderStringReference checkStringReference(StringReference stringReference) {
        if (stringReference == null) {
            return null;
        }
        try {
            return (BuilderStringReference) stringReference;
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Only StringReference instances returned by DexBuilder.internStringReference or DexBuilder.internNullableStringReference may be used.");
        }
    }

    public final BuilderTypeReference checkTypeReference(TypeReference typeReference) {
        if (typeReference == null) {
            return null;
        }
        try {
            return (BuilderTypeReference) typeReference;
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Only TypeReference instances returned by DexBuilder.internTypeReference or DexBuilder.internNullableTypeReference may be used.");
        }
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public int getAccessFlags(BuilderClassDef builderClassDef) {
        return builderClassDef.accessFlags;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public int getAnnotationDirectoryOffset(BuilderClassDef builderClassDef) {
        return builderClassDef.annotationDirectoryOffset;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public int getAnnotationSetRefListOffset(BuilderMethod builderMethod) {
        return builderMethod.annotationSetRefListOffset;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public BuilderAnnotationSet getClassAnnotations(BuilderClassDef builderClassDef) {
        if (builderClassDef.annotations.isEmpty()) {
            return null;
        }
        return builderClassDef.annotations;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Map.Entry<? extends BuilderClassDef, Integer> getClassEntryByType(BuilderTypeReference builderTypeReference) {
        final BuilderClassDef builderClassDef;
        if (builderTypeReference == null || (builderClassDef = this.internedItems.get(builderTypeReference.getType())) == null) {
            return null;
        }
        return new Map.Entry<BuilderClassDef, Integer>(this) { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.1
            @Override // java.util.Map.Entry
            public BuilderClassDef getKey() {
                return builderClassDef;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Map.Entry
            public Integer getValue() {
                return Integer.valueOf(builderClassDef.classDefIndex);
            }

            @Override // java.util.Map.Entry
            public Integer setValue(Integer num) {
                BuilderClassDef builderClassDef2 = builderClassDef;
                int iIntValue = num.intValue();
                builderClassDef2.classDefIndex = iIntValue;
                return Integer.valueOf(iIntValue);
            }
        };
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public int getCodeItemOffset(BuilderMethod builderMethod) {
        return builderMethod.codeItemOffset;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Iterable<? extends DebugItem> getDebugItems(BuilderMethod builderMethod) {
        MethodImplementation implementation = builderMethod.getImplementation();
        if (implementation == null) {
            return null;
        }
        return implementation.getDebugItems();
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public BuilderTypeReference getExceptionType(ExceptionHandler exceptionHandler) {
        return checkTypeReference(exceptionHandler.getExceptionTypeReference());
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public int getFieldAccessFlags(BuilderField builderField) {
        return builderField.accessFlags;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public BuilderAnnotationSet getFieldAnnotations(BuilderField builderField) {
        if (builderField.annotations.isEmpty()) {
            return null;
        }
        return builderField.annotations;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Set<HiddenApiRestriction> getFieldHiddenApiRestrictions(BuilderField builderField) {
        return builderField.getHiddenApiRestrictions();
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Iterable<? extends Instruction> getInstructions(BuilderMethod builderMethod) {
        MethodImplementation implementation = builderMethod.getImplementation();
        if (implementation == null) {
            return null;
        }
        return implementation.getInstructions();
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public BuilderTypeList getInterfaces(BuilderClassDef builderClassDef) {
        return builderClassDef.interfaces;
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.p088jf.dexlib2.writer.IndexSection
    public Collection<? extends Map.Entry<? extends BuilderClassDef, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderClassDef>(this, this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.8
            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(BuilderClassDef builderClassDef) {
                return builderClassDef.classDefIndex;
            }

            @Override // org.p088jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(BuilderClassDef builderClassDef, int i) {
                int i2 = builderClassDef.classDefIndex;
                builderClassDef.classDefIndex = i;
                return i2;
            }
        };
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public int getMethodAccessFlags(BuilderMethod builderMethod) {
        return builderMethod.accessFlags;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public BuilderAnnotationSet getMethodAnnotations(BuilderMethod builderMethod) {
        if (builderMethod.annotations.isEmpty()) {
            return null;
        }
        return builderMethod.annotations;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Set<HiddenApiRestriction> getMethodHiddenApiRestrictions(BuilderMethod builderMethod) {
        return builderMethod.getHiddenApiRestrictions();
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public List<? extends BuilderAnnotationSet> getParameterAnnotations(BuilderMethod builderMethod) {
        final List<? extends BuilderMethodParameter> parameters = builderMethod.getParameters();
        if (Iterables.any(parameters, HAS_PARAMETER_ANNOTATIONS)) {
            return new AbstractForwardSequentialList<BuilderAnnotationSet>(this) { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.6
                @Override // org.p088jf.util.AbstractForwardSequentialList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
                public Iterator<BuilderAnnotationSet> iterator() {
                    return FluentIterable.from(parameters).transform(BuilderClassPool.PARAMETER_ANNOTATIONS).iterator();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return parameters.size();
                }
            };
        }
        return null;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Iterable<? extends BuilderStringReference> getParameterNames(BuilderMethod builderMethod) {
        return Iterables.transform(builderMethod.getParameters(), new Function<BuilderMethodParameter, BuilderStringReference>(this) { // from class: org.jf.dexlib2.writer.builder.BuilderClassPool.7
            @Override // com.google.common.base.Function
            public BuilderStringReference apply(BuilderMethodParameter builderMethodParameter) {
                return builderMethodParameter.name;
            }
        });
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public int getRegisterCount(BuilderMethod builderMethod) {
        MethodImplementation implementation = builderMethod.getImplementation();
        if (implementation == null) {
            return 0;
        }
        return implementation.getRegisterCount();
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Collection<? extends BuilderClassDef> getSortedClasses() {
        if (this.sortedClasses == null) {
            this.sortedClasses = Ordering.natural().immutableSortedCopy(this.internedItems.values());
        }
        return this.sortedClasses;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Collection<? extends BuilderMethod> getSortedDirectMethods(BuilderClassDef builderClassDef) {
        return builderClassDef.getDirectMethods();
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Collection<? extends BuilderField> getSortedFields(BuilderClassDef builderClassDef) {
        return builderClassDef.getFields();
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Collection<? extends BuilderField> getSortedInstanceFields(BuilderClassDef builderClassDef) {
        return builderClassDef.getInstanceFields();
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Collection<? extends BuilderMethod> getSortedMethods(BuilderClassDef builderClassDef) {
        return builderClassDef.getMethods();
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Collection<? extends BuilderField> getSortedStaticFields(BuilderClassDef builderClassDef) {
        return builderClassDef.getStaticFields();
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public Collection<? extends BuilderMethod> getSortedVirtualMethods(BuilderClassDef builderClassDef) {
        return builderClassDef.getVirtualMethods();
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public BuilderStringReference getSourceFile(BuilderClassDef builderClassDef) {
        return builderClassDef.sourceFile;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public BuilderEncodedValues.BuilderArrayEncodedValue getStaticInitializers(BuilderClassDef builderClassDef) {
        return builderClassDef.staticInitializers;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public BuilderTypeReference getSuperclass(BuilderClassDef builderClassDef) {
        return builderClassDef.superclass;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public List<? extends TryBlock<? extends ExceptionHandler>> getTryBlocks(BuilderMethod builderMethod) {
        MethodImplementation implementation = builderMethod.getImplementation();
        return implementation == null ? ImmutableList.m3778of() : implementation.getTryBlocks();
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public BuilderTypeReference getType(BuilderClassDef builderClassDef) {
        return builderClassDef.type;
    }

    public BuilderClassDef internClass(BuilderClassDef builderClassDef) {
        if (this.internedItems.put(builderClassDef.getType(), builderClassDef) == null) {
            return builderClassDef;
        }
        throw new ExceptionWithContext("Class %s has already been interned", builderClassDef.getType());
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public MutableMethodImplementation makeMutableMethodImplementation(BuilderMethod builderMethod) {
        MethodImplementation implementation = builderMethod.getImplementation();
        return implementation instanceof MutableMethodImplementation ? (MutableMethodImplementation) implementation : new MutableMethodImplementation(implementation);
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public void setAnnotationDirectoryOffset(BuilderClassDef builderClassDef, int i) {
        builderClassDef.annotationDirectoryOffset = i;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public void setAnnotationSetRefListOffset(BuilderMethod builderMethod, int i) {
        builderMethod.annotationSetRefListOffset = i;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public void setCodeItemOffset(BuilderMethod builderMethod, int i) {
        builderMethod.codeItemOffset = i;
    }

    @Override // org.p088jf.dexlib2.writer.ClassSection
    public void writeDebugItem(DebugWriter<BuilderStringReference, BuilderTypeReference> debugWriter, DebugItem debugItem) throws IOException {
        switch (debugItem.getDebugItemType()) {
            case 3:
                StartLocal startLocal = (StartLocal) debugItem;
                debugWriter.writeStartLocal(startLocal.getCodeAddress(), startLocal.getRegister(), checkStringReference(startLocal.getNameReference()), checkTypeReference(startLocal.getTypeReference()), checkStringReference(startLocal.getSignatureReference()));
                return;
            case 4:
            default:
                throw new ExceptionWithContext("Unexpected debug item type: %d", Integer.valueOf(debugItem.getDebugItemType()));
            case 5:
                EndLocal endLocal = (EndLocal) debugItem;
                debugWriter.writeEndLocal(endLocal.getCodeAddress(), endLocal.getRegister());
                return;
            case 6:
                RestartLocal restartLocal = (RestartLocal) debugItem;
                debugWriter.writeRestartLocal(restartLocal.getCodeAddress(), restartLocal.getRegister());
                return;
            case 7:
                debugWriter.writePrologueEnd(debugItem.getCodeAddress());
                return;
            case 8:
                debugWriter.writeEpilogueBegin(debugItem.getCodeAddress());
                return;
            case 9:
                SetSourceFile setSourceFile = (SetSourceFile) debugItem;
                debugWriter.writeSetSourceFile(setSourceFile.getCodeAddress(), checkStringReference(setSourceFile.getSourceFileReference()));
                return;
            case 10:
                LineNumber lineNumber = (LineNumber) debugItem;
                debugWriter.writeLineNumber(lineNumber.getCodeAddress(), lineNumber.getLineNumber());
                return;
        }
    }
}
