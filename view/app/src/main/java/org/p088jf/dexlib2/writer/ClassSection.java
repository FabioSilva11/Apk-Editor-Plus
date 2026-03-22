package org.p088jf.dexlib2.writer;

import java.io.IOException;
import java.lang.CharSequence;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.builder.MutableMethodImplementation;
import org.p088jf.dexlib2.iface.ExceptionHandler;
import org.p088jf.dexlib2.iface.TryBlock;
import org.p088jf.dexlib2.iface.debug.DebugItem;
import org.p088jf.dexlib2.iface.instruction.Instruction;

/* JADX INFO: loaded from: classes.dex */
public interface ClassSection<StringKey extends CharSequence, TypeKey extends CharSequence, TypeListKey, ClassKey, FieldKey, MethodKey, AnnotationSetKey, EncodedArrayKey> extends IndexSection<ClassKey> {
    int getAccessFlags(ClassKey classkey);

    int getAnnotationDirectoryOffset(ClassKey classkey);

    int getAnnotationSetRefListOffset(MethodKey methodkey);

    AnnotationSetKey getClassAnnotations(ClassKey classkey);

    Map.Entry<? extends ClassKey, Integer> getClassEntryByType(TypeKey typekey);

    int getCodeItemOffset(MethodKey methodkey);

    Iterable<? extends DebugItem> getDebugItems(MethodKey methodkey);

    TypeKey getExceptionType(ExceptionHandler exceptionHandler);

    int getFieldAccessFlags(FieldKey fieldkey);

    AnnotationSetKey getFieldAnnotations(FieldKey fieldkey);

    Set<HiddenApiRestriction> getFieldHiddenApiRestrictions(FieldKey fieldkey);

    Iterable<? extends Instruction> getInstructions(MethodKey methodkey);

    TypeListKey getInterfaces(ClassKey classkey);

    int getMethodAccessFlags(MethodKey methodkey);

    AnnotationSetKey getMethodAnnotations(MethodKey methodkey);

    Set<HiddenApiRestriction> getMethodHiddenApiRestrictions(MethodKey methodkey);

    List<? extends AnnotationSetKey> getParameterAnnotations(MethodKey methodkey);

    Iterable<? extends StringKey> getParameterNames(MethodKey methodkey);

    int getRegisterCount(MethodKey methodkey);

    Collection<? extends ClassKey> getSortedClasses();

    Collection<? extends MethodKey> getSortedDirectMethods(ClassKey classkey);

    Collection<? extends FieldKey> getSortedFields(ClassKey classkey);

    Collection<? extends FieldKey> getSortedInstanceFields(ClassKey classkey);

    Collection<? extends MethodKey> getSortedMethods(ClassKey classkey);

    Collection<? extends FieldKey> getSortedStaticFields(ClassKey classkey);

    Collection<? extends MethodKey> getSortedVirtualMethods(ClassKey classkey);

    StringKey getSourceFile(ClassKey classkey);

    EncodedArrayKey getStaticInitializers(ClassKey classkey);

    TypeKey getSuperclass(ClassKey classkey);

    List<? extends TryBlock<? extends ExceptionHandler>> getTryBlocks(MethodKey methodkey);

    TypeKey getType(ClassKey classkey);

    MutableMethodImplementation makeMutableMethodImplementation(MethodKey methodkey);

    void setAnnotationDirectoryOffset(ClassKey classkey, int i);

    void setAnnotationSetRefListOffset(MethodKey methodkey, int i);

    void setCodeItemOffset(MethodKey methodkey, int i);

    void writeDebugItem(DebugWriter<StringKey, TypeKey> debugWriter, DebugItem debugItem) throws IOException;
}
