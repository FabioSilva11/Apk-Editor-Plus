package org.p088jf.dexlib2.builder;

import java.util.HashMap;
import org.p088jf.dexlib2.iface.MethodImplementation;
import org.p088jf.dexlib2.iface.reference.StringReference;
import org.p088jf.dexlib2.iface.reference.TypeReference;

/* JADX INFO: loaded from: classes.dex */
public class MethodImplementationBuilder {
    public MethodLocation currentLocation;
    public final MutableMethodImplementation impl;
    public final HashMap<String, Label> labels = new HashMap<>();

    public MethodImplementationBuilder(int i) {
        MutableMethodImplementation mutableMethodImplementation = new MutableMethodImplementation(i);
        this.impl = mutableMethodImplementation;
        this.currentLocation = mutableMethodImplementation.instructionList.get(0);
    }

    public void addCatch(Label label, Label label2, Label label3) {
        this.impl.addCatch(label, label2, label3);
    }

    public void addCatch(TypeReference typeReference, Label label, Label label2, Label label3) {
        this.impl.addCatch(typeReference, label, label2, label3);
    }

    public void addEndLocal(int i) {
        this.currentLocation.addEndLocal(i);
    }

    public void addEpilogue() {
        this.currentLocation.addEpilogue();
    }

    public void addInstruction(BuilderInstruction builderInstruction) {
        this.impl.addInstruction(builderInstruction);
        this.currentLocation = this.impl.instructionList.get(r2.size() - 1);
    }

    public Label addLabel(String str) {
        Label label = this.labels.get(str);
        if (label == null) {
            Label labelAddNewLabel = this.currentLocation.addNewLabel();
            this.labels.put(str, labelAddNewLabel);
            return labelAddNewLabel;
        }
        if (label.isPlaced()) {
            throw new IllegalArgumentException("There is already a label with that name.");
        }
        this.currentLocation.getLabels().add(label);
        return label;
    }

    public void addLineNumber(int i) {
        this.currentLocation.addLineNumber(i);
    }

    public void addPrologue() {
        this.currentLocation.addPrologue();
    }

    public void addRestartLocal(int i) {
        this.currentLocation.addRestartLocal(i);
    }

    public void addSetSourceFile(StringReference stringReference) {
        this.currentLocation.addSetSourceFile(stringReference);
    }

    public void addStartLocal(int i, StringReference stringReference, TypeReference typeReference, StringReference stringReference2) {
        this.currentLocation.addStartLocal(i, stringReference, typeReference, stringReference2);
    }

    public Label getLabel(String str) {
        Label label = this.labels.get(str);
        if (label != null) {
            return label;
        }
        Label label2 = new Label();
        this.labels.put(str, label2);
        return label2;
    }

    public MethodImplementation getMethodImplementation() {
        return this.impl;
    }
}
