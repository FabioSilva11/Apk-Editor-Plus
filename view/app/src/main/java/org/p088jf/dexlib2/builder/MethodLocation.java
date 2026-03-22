package org.p088jf.dexlib2.builder;

import java.util.Set;
import org.p088jf.dexlib2.builder.debug.BuilderEndLocal;
import org.p088jf.dexlib2.builder.debug.BuilderEpilogueBegin;
import org.p088jf.dexlib2.builder.debug.BuilderLineNumber;
import org.p088jf.dexlib2.builder.debug.BuilderPrologueEnd;
import org.p088jf.dexlib2.builder.debug.BuilderRestartLocal;
import org.p088jf.dexlib2.builder.debug.BuilderSetSourceFile;
import org.p088jf.dexlib2.builder.debug.BuilderStartLocal;
import org.p088jf.dexlib2.iface.instruction.Instruction;
import org.p088jf.dexlib2.iface.reference.StringReference;
import org.p088jf.dexlib2.iface.reference.TypeReference;

/* JADX INFO: loaded from: classes.dex */
public class MethodLocation {
    public int codeAddress;
    public int index;
    public BuilderInstruction instruction;
    public final LocatedItems<BuilderDebugItem> debugItems = new LocatedDebugItems();
    public final LocatedItems<Label> labels = new LocatedLabels();

    public MethodLocation(BuilderInstruction builderInstruction, int i, int i2) {
        this.instruction = builderInstruction;
        this.codeAddress = i;
        this.index = i2;
    }

    public void addEndLocal(int i) {
        getDebugItems().add(new BuilderEndLocal(i));
    }

    public void addEpilogue() {
        getDebugItems().add(new BuilderEpilogueBegin());
    }

    public void addLineNumber(int i) {
        getDebugItems().add(new BuilderLineNumber(i));
    }

    public Label addNewLabel() {
        Label label = new Label();
        getLabels().add(label);
        return label;
    }

    public void addPrologue() {
        getDebugItems().add(new BuilderPrologueEnd());
    }

    public void addRestartLocal(int i) {
        getDebugItems().add(new BuilderRestartLocal(i));
    }

    public void addSetSourceFile(StringReference stringReference) {
        getDebugItems().add(new BuilderSetSourceFile(stringReference));
    }

    public void addStartLocal(int i, StringReference stringReference, TypeReference typeReference, StringReference stringReference2) {
        getDebugItems().add(new BuilderStartLocal(i, stringReference, typeReference, stringReference2));
    }

    public int getCodeAddress() {
        return this.codeAddress;
    }

    public Set<BuilderDebugItem> getDebugItems() {
        return this.debugItems.getModifiableItems(this);
    }

    public Instruction getInstruction() {
        return this.instruction;
    }

    public Set<Label> getLabels() {
        return this.labels.getModifiableItems(this);
    }

    public void mergeInto(MethodLocation methodLocation) {
        this.labels.mergeItemsIntoNext(methodLocation, methodLocation.labels);
        this.debugItems.mergeItemsIntoNext(methodLocation, methodLocation.debugItems);
    }
}
