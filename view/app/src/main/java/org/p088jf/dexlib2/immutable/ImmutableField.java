package org.p088jf.dexlib2.immutable;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Set;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.base.reference.BaseFieldReference;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.Field;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableEncodedValue;
import org.p088jf.dexlib2.immutable.value.ImmutableEncodedValueFactory;
import org.p088jf.util.ImmutableConverter;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableField extends BaseFieldReference implements Field {
    public static final ImmutableConverter<ImmutableField, Field> CONVERTER = new ImmutableConverter<ImmutableField, Field>() { // from class: org.jf.dexlib2.immutable.ImmutableField.1
        @Override // org.p088jf.util.ImmutableConverter
        public boolean isImmutable(Field field) {
            return field instanceof ImmutableField;
        }

        @Override // org.p088jf.util.ImmutableConverter
        public ImmutableField makeImmutable(Field field) {
            return ImmutableField.m3859of(field);
        }
    };
    public final int accessFlags;
    public final ImmutableSet<? extends ImmutableAnnotation> annotations;
    public final String definingClass;
    public final ImmutableSet<HiddenApiRestriction> hiddenApiRestrictions;
    public final ImmutableEncodedValue initialValue;
    public final String name;
    public final String type;

    public ImmutableField(String str, String str2, String str3, int i, EncodedValue encodedValue, Collection<? extends Annotation> collection, Set<HiddenApiRestriction> set) {
        this.definingClass = str;
        this.name = str2;
        this.type = str3;
        this.accessFlags = i;
        this.initialValue = ImmutableEncodedValueFactory.ofNullable(encodedValue);
        this.annotations = ImmutableAnnotation.immutableSetOf(collection);
        this.hiddenApiRestrictions = set == null ? ImmutableSet.m3782of() : ImmutableSet.copyOf((Collection) set);
    }

    public static ImmutableSortedSet<ImmutableField> immutableSetOf(Iterable<? extends Field> iterable) {
        return CONVERTER.toSortedSet(Ordering.natural(), iterable);
    }

    /* JADX INFO: renamed from: of */
    public static ImmutableField m3859of(Field field) {
        return field instanceof ImmutableField ? (ImmutableField) field : new ImmutableField(field.getDefiningClass(), field.getName(), field.getType(), field.getAccessFlags(), field.getInitialValue(), field.getAnnotations(), field.getHiddenApiRestrictions());
    }

    @Override // org.p088jf.dexlib2.iface.Field
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.p088jf.dexlib2.iface.Field
    public ImmutableSet<? extends ImmutableAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getDefiningClass() {
        return this.definingClass;
    }

    @Override // org.p088jf.dexlib2.iface.Field
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        return this.hiddenApiRestrictions;
    }

    @Override // org.p088jf.dexlib2.iface.Field
    public EncodedValue getInitialValue() {
        return this.initialValue;
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getName() {
        return this.name;
    }

    @Override // org.p088jf.dexlib2.iface.reference.FieldReference, org.p088jf.dexlib2.iface.Field
    public String getType() {
        return this.type;
    }
}
