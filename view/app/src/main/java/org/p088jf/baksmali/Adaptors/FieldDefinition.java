package org.p088jf.baksmali.Adaptors;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.p088jf.baksmali.formatter.BaksmaliWriter;
import org.p088jf.dexlib2.AccessFlags;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.Field;
import org.p088jf.dexlib2.iface.value.EncodedValue;
import org.p088jf.dexlib2.util.EncodedValueUtils;

/* JADX INFO: loaded from: classes.dex */
public class FieldDefinition {
    public static void writeAccessFlagsAndRestrictions(BaksmaliWriter baksmaliWriter, int i, Set<HiddenApiRestriction> set) throws IOException {
        for (AccessFlags accessFlags : AccessFlags.getAccessFlagsForField(i)) {
            baksmaliWriter.write(accessFlags.toString());
            baksmaliWriter.write(32);
        }
        Iterator<HiddenApiRestriction> it = set.iterator();
        while (it.hasNext()) {
            baksmaliWriter.write(it.next().toString());
            baksmaliWriter.write(32);
        }
    }

    public static void writeTo(BaksmaliWriter baksmaliWriter, Field field, boolean z) throws IOException {
        EncodedValue initialValue = field.getInitialValue();
        int accessFlags = field.getAccessFlags();
        if (z && AccessFlags.STATIC.isSet(accessFlags) && AccessFlags.FINAL.isSet(accessFlags) && initialValue != null) {
            if (EncodedValueUtils.isDefaultValue(initialValue)) {
                initialValue = null;
            } else {
                baksmaliWriter.write("# The value of this static final field might be set in the static constructor\n");
            }
        }
        baksmaliWriter.write(".field ");
        writeAccessFlagsAndRestrictions(baksmaliWriter, field.getAccessFlags(), field.getHiddenApiRestrictions());
        baksmaliWriter.writeSimpleName(field.getName());
        baksmaliWriter.write(58);
        baksmaliWriter.writeType(field.getType());
        if (initialValue != null) {
            baksmaliWriter.write(" = ");
            baksmaliWriter.writeEncodedValue(initialValue);
        }
        baksmaliWriter.write(10);
        Set<? extends Annotation> annotations = field.getAnnotations();
        if (annotations.size() > 0) {
            baksmaliWriter.indent(4);
            AnnotationFormatter.writeTo(baksmaliWriter, annotations);
            baksmaliWriter.deindent(4);
            baksmaliWriter.write(".end field\n");
        }
    }
}
