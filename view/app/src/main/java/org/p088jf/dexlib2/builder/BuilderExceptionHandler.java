package org.p088jf.dexlib2.builder;

import org.p088jf.dexlib2.base.BaseExceptionHandler;
import org.p088jf.dexlib2.iface.reference.TypeReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class BuilderExceptionHandler extends BaseExceptionHandler {
    public final Label handler;

    public BuilderExceptionHandler(Label label) {
        this.handler = label;
    }

    public static BuilderExceptionHandler newExceptionHandler(Label label) {
        return new BuilderExceptionHandler(label) { // from class: org.jf.dexlib2.builder.BuilderExceptionHandler.2
            @Override // org.p088jf.dexlib2.iface.ExceptionHandler
            public String getExceptionType() {
                return null;
            }

            @Override // org.p088jf.dexlib2.iface.ExceptionHandler
            public int getHandlerCodeAddress() {
                return this.handler.getCodeAddress();
            }
        };
    }

    public static BuilderExceptionHandler newExceptionHandler(final TypeReference typeReference, Label label) {
        return typeReference == null ? newExceptionHandler(label) : new BuilderExceptionHandler(label) { // from class: org.jf.dexlib2.builder.BuilderExceptionHandler.1
            @Override // org.p088jf.dexlib2.iface.ExceptionHandler
            public String getExceptionType() {
                return typeReference.getType();
            }

            @Override // org.p088jf.dexlib2.base.BaseExceptionHandler, org.p088jf.dexlib2.iface.ExceptionHandler
            public TypeReference getExceptionTypeReference() {
                return typeReference;
            }

            @Override // org.p088jf.dexlib2.iface.ExceptionHandler
            public int getHandlerCodeAddress() {
                return this.handler.getCodeAddress();
            }
        };
    }
}
