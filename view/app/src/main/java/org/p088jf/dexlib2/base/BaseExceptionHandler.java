package org.p088jf.dexlib2.base;

import com.google.common.base.Objects;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import org.p088jf.dexlib2.base.reference.BaseTypeReference;
import org.p088jf.dexlib2.iface.ExceptionHandler;
import org.p088jf.dexlib2.iface.reference.TypeReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseExceptionHandler implements ExceptionHandler {
    static {
        new Comparator<ExceptionHandler>() { // from class: org.jf.dexlib2.base.BaseExceptionHandler.2
            @Override // java.util.Comparator
            public int compare(ExceptionHandler exceptionHandler, ExceptionHandler exceptionHandler2) {
                String exceptionType = exceptionHandler.getExceptionType();
                if (exceptionType == null) {
                    return exceptionHandler2.getExceptionType() != null ? 1 : 0;
                }
                if (exceptionHandler2.getExceptionType() == null) {
                    return -1;
                }
                return exceptionType.compareTo(exceptionHandler2.getExceptionType());
            }
        };
    }

    @Override // java.lang.Comparable
    public int compareTo(ExceptionHandler exceptionHandler) {
        String exceptionType = getExceptionType();
        if (exceptionType == null) {
            if (exceptionHandler.getExceptionType() != null) {
                return 1;
            }
        } else {
            if (exceptionHandler.getExceptionType() == null) {
                return -1;
            }
            int iCompareTo = exceptionType.compareTo(exceptionHandler.getExceptionType());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Ints.compare(getHandlerCodeAddress(), exceptionHandler.getHandlerCodeAddress());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExceptionHandler)) {
            return false;
        }
        ExceptionHandler exceptionHandler = (ExceptionHandler) obj;
        return Objects.equal(getExceptionType(), exceptionHandler.getExceptionType()) && getHandlerCodeAddress() == exceptionHandler.getHandlerCodeAddress();
    }

    @Override // org.p088jf.dexlib2.iface.ExceptionHandler
    public TypeReference getExceptionTypeReference() {
        final String exceptionType = getExceptionType();
        if (exceptionType == null) {
            return null;
        }
        return new BaseTypeReference(this) { // from class: org.jf.dexlib2.base.BaseExceptionHandler.1
            @Override // org.p088jf.dexlib2.iface.reference.TypeReference
            public String getType() {
                return exceptionType;
            }
        };
    }

    public int hashCode() {
        String exceptionType = getExceptionType();
        return ((exceptionType == null ? 0 : exceptionType.hashCode()) * 31) + getHandlerCodeAddress();
    }
}
