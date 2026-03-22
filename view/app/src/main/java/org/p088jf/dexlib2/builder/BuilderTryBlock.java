package org.p088jf.dexlib2.builder;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.p088jf.dexlib2.base.BaseTryBlock;
import org.p088jf.dexlib2.iface.reference.TypeReference;

/* JADX INFO: loaded from: classes.dex */
public class BuilderTryBlock extends BaseTryBlock<BuilderExceptionHandler> {
    public final Label end;
    public final BuilderExceptionHandler exceptionHandler;
    public final Label start;

    public BuilderTryBlock(Label label, Label label2, Label label3) {
        this.start = label;
        this.end = label2;
        this.exceptionHandler = BuilderExceptionHandler.newExceptionHandler(label3);
    }

    public BuilderTryBlock(Label label, Label label2, TypeReference typeReference, Label label3) {
        this.start = label;
        this.end = label2;
        this.exceptionHandler = BuilderExceptionHandler.newExceptionHandler(typeReference, label3);
    }

    @Override // org.p088jf.dexlib2.iface.TryBlock
    public int getCodeUnitCount() {
        return this.end.getCodeAddress() - this.start.getCodeAddress();
    }

    @Override // org.p088jf.dexlib2.iface.TryBlock
    public List<? extends BuilderExceptionHandler> getExceptionHandlers() {
        return ImmutableList.m3779of(this.exceptionHandler);
    }

    @Override // org.p088jf.dexlib2.iface.TryBlock
    public int getStartCodeAddress() {
        return this.start.getCodeAddress();
    }
}
