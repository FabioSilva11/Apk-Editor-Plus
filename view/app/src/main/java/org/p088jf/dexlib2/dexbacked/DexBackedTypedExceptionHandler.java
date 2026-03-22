package org.p088jf.dexlib2.dexbacked;

/* JADX INFO: loaded from: classes.dex */
public class DexBackedTypedExceptionHandler extends DexBackedExceptionHandler {
    public final DexBackedDexFile dexFile;
    public final int handlerCodeAddress;
    public final int typeId;

    public DexBackedTypedExceptionHandler(DexBackedDexFile dexBackedDexFile, DexReader dexReader) {
        this.dexFile = dexBackedDexFile;
        this.typeId = dexReader.readSmallUleb128();
        this.handlerCodeAddress = dexReader.readSmallUleb128();
    }

    @Override // org.p088jf.dexlib2.iface.ExceptionHandler
    public String getExceptionType() {
        return this.dexFile.getTypeSection().get(this.typeId);
    }

    @Override // org.p088jf.dexlib2.iface.ExceptionHandler
    public int getHandlerCodeAddress() {
        return this.handlerCodeAddress;
    }
}
