package org.p088jf.dexlib2.iface.reference;

/* JADX INFO: loaded from: classes.dex */
public interface Reference {

    public static class InvalidReferenceException extends Exception {
        public final String invalidReferenceRepresentation;

        public InvalidReferenceException(String str) {
            super("Invalid reference");
            this.invalidReferenceRepresentation = str;
        }

        public InvalidReferenceException(String str, Throwable th) {
            super(th);
            this.invalidReferenceRepresentation = str;
        }

        public String getInvalidReferenceRepresentation() {
            return this.invalidReferenceRepresentation;
        }
    }

    void validateReference() throws InvalidReferenceException;
}
