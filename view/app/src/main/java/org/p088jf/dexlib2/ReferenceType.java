package org.p088jf.dexlib2;

import org.p088jf.dexlib2.iface.reference.CallSiteReference;
import org.p088jf.dexlib2.iface.reference.FieldReference;
import org.p088jf.dexlib2.iface.reference.MethodHandleReference;
import org.p088jf.dexlib2.iface.reference.MethodProtoReference;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.dexlib2.iface.reference.StringReference;
import org.p088jf.dexlib2.iface.reference.TypeReference;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public final class ReferenceType {

    public static class InvalidReferenceTypeException extends ExceptionWithContext {
        public final int referenceType;

        public InvalidReferenceTypeException(int i) {
            super("Invalid reference type: %d", Integer.valueOf(i));
            this.referenceType = i;
        }

        public int getReferenceType() {
            return this.referenceType;
        }
    }

    public static int getReferenceType(Reference reference) {
        if (reference instanceof StringReference) {
            return 0;
        }
        if (reference instanceof TypeReference) {
            return 1;
        }
        if (reference instanceof FieldReference) {
            return 2;
        }
        if (reference instanceof MethodReference) {
            return 3;
        }
        if (reference instanceof MethodProtoReference) {
            return 4;
        }
        if (reference instanceof CallSiteReference) {
            return 5;
        }
        if (reference instanceof MethodHandleReference) {
            return 6;
        }
        throw new IllegalStateException("Invalid reference");
    }

    public static void validateReferenceType(int i) {
        if (i < 0 || i > 4) {
            throw new InvalidReferenceTypeException(i);
        }
    }
}
