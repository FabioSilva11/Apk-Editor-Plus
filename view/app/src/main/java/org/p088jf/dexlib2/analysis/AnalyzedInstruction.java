package org.p088jf.dexlib2.analysis;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.p088jf.dexlib2.iface.instruction.FiveRegisterInstruction;
import org.p088jf.dexlib2.iface.instruction.Instruction;
import org.p088jf.dexlib2.iface.instruction.OneRegisterInstruction;
import org.p088jf.dexlib2.iface.instruction.ReferenceInstruction;
import org.p088jf.dexlib2.iface.instruction.RegisterRangeInstruction;
import org.p088jf.dexlib2.iface.reference.MethodReference;
import org.p088jf.dexlib2.iface.reference.Reference;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class AnalyzedInstruction implements Comparable<AnalyzedInstruction> {
    public Instruction instruction;
    public final int instructionIndex;
    public final MethodAnalyzer methodAnalyzer;
    public final Instruction originalInstruction;
    public final RegisterType[] postRegisterMap;
    public final RegisterType[] preRegisterMap;
    public final TreeSet<AnalyzedInstruction> predecessors = new TreeSet<>();
    public final LinkedList<AnalyzedInstruction> successors = new LinkedList<>();
    public Map<PredecessorOverrideKey, RegisterType> predecessorRegisterOverrides = null;

    public static class PredecessorOverrideKey {
        public final AnalyzedInstruction analyzedInstruction;
        public final int registerNumber;

        public PredecessorOverrideKey(AnalyzedInstruction analyzedInstruction, int i) {
            this.analyzedInstruction = analyzedInstruction;
            this.registerNumber = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || PredecessorOverrideKey.class != obj.getClass()) {
                return false;
            }
            PredecessorOverrideKey predecessorOverrideKey = (PredecessorOverrideKey) obj;
            return Objects.equal(Integer.valueOf(this.registerNumber), Integer.valueOf(predecessorOverrideKey.registerNumber)) && Objects.equal(this.analyzedInstruction, predecessorOverrideKey.analyzedInstruction);
        }

        public int hashCode() {
            return Objects.hashCode(this.analyzedInstruction, Integer.valueOf(this.registerNumber));
        }
    }

    public AnalyzedInstruction(MethodAnalyzer methodAnalyzer, Instruction instruction, int i, int i2) {
        this.methodAnalyzer = methodAnalyzer;
        this.instruction = instruction;
        this.originalInstruction = instruction;
        this.instructionIndex = i;
        this.postRegisterMap = new RegisterType[i2];
        this.preRegisterMap = new RegisterType[i2];
        RegisterType registerType = RegisterType.getRegisterType((byte) 0, (TypeProto) null);
        for (int i3 = 0; i3 < i2; i3++) {
            this.preRegisterMap[i3] = registerType;
            this.postRegisterMap[i3] = registerType;
        }
    }

    public boolean addPredecessor(AnalyzedInstruction analyzedInstruction) {
        return this.predecessors.add(analyzedInstruction);
    }

    public void addSuccessor(AnalyzedInstruction analyzedInstruction) {
        this.successors.add(analyzedInstruction);
    }

    @Override // java.lang.Comparable
    public int compareTo(AnalyzedInstruction analyzedInstruction) {
        int i = this.instructionIndex;
        int i2 = analyzedInstruction.instructionIndex;
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public int getDestinationRegister() {
        if (this.instruction.getOpcode().setsRegister()) {
            return ((OneRegisterInstruction) this.instruction).getRegisterA();
        }
        throw new ExceptionWithContext("Cannot call getDestinationRegister() for an instruction that doesn't store a value", new Object[0]);
    }

    public Instruction getInstruction() {
        return this.instruction;
    }

    public int getInstructionIndex() {
        return this.instructionIndex;
    }

    public RegisterType getMergedPreRegisterTypeFromPredecessors(int i) {
        Iterator<AnalyzedInstruction> it = this.predecessors.iterator();
        RegisterType registerTypeMerge = null;
        while (it.hasNext()) {
            RegisterType predecessorRegisterType = getPredecessorRegisterType(it.next(), i);
            if (predecessorRegisterType != null) {
                registerTypeMerge = registerTypeMerge == null ? predecessorRegisterType : predecessorRegisterType.merge(registerTypeMerge);
            }
        }
        if (registerTypeMerge != null) {
            return registerTypeMerge;
        }
        throw new IllegalStateException();
    }

    public Instruction getOriginalInstruction() {
        return this.originalInstruction;
    }

    public RegisterType getPostInstructionRegisterType(int i) {
        return this.postRegisterMap[i];
    }

    public RegisterType getPreInstructionRegisterType(int i) {
        return this.preRegisterMap[i];
    }

    public int getPredecessorCount() {
        return this.predecessors.size();
    }

    public RegisterType getPredecessorRegisterType(AnalyzedInstruction analyzedInstruction, int i) {
        RegisterType registerType;
        Map<PredecessorOverrideKey, RegisterType> map = this.predecessorRegisterOverrides;
        return (map == null || (registerType = map.get(new PredecessorOverrideKey(analyzedInstruction, i))) == null) ? analyzedInstruction.postRegisterMap[i] : registerType;
    }

    public SortedSet<AnalyzedInstruction> getPredecessors() {
        return Collections.unmodifiableSortedSet(this.predecessors);
    }

    public int getRegisterCount() {
        return this.postRegisterMap.length;
    }

    public List<Integer> getSetRegisters() {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        if (this.instruction.getOpcode().setsRegister()) {
            arrayListNewArrayList.add(Integer.valueOf(getDestinationRegister()));
        }
        if (this.instruction.getOpcode().setsWideRegister()) {
            arrayListNewArrayList.add(Integer.valueOf(getDestinationRegister() + 1));
        }
        if (isInvokeInit()) {
            Instruction instruction = this.instruction;
            int registerC = instruction instanceof FiveRegisterInstruction ? ((FiveRegisterInstruction) instruction).getRegisterC() : ((RegisterRangeInstruction) instruction).getStartRegister();
            byte b2 = getPreInstructionRegisterType(registerC).category;
            int i = 0;
            if (b2 == 16 || b2 == 17) {
                arrayListNewArrayList.add(Integer.valueOf(registerC));
                RegisterType registerType = this.preRegisterMap[registerC];
                while (true) {
                    RegisterType[] registerTypeArr = this.preRegisterMap;
                    if (i >= registerTypeArr.length) {
                        break;
                    }
                    if (i != registerC) {
                        RegisterType registerType2 = registerTypeArr[i];
                        if (registerType2.equals(registerType)) {
                            arrayListNewArrayList.add(Integer.valueOf(i));
                        } else {
                            byte b3 = registerType2.category;
                            if ((b3 == 16 || b3 == 17) && this.postRegisterMap[i].category == 0) {
                                arrayListNewArrayList.add(Integer.valueOf(i));
                            }
                        }
                    }
                    i++;
                }
            } else if (b2 == 0) {
                while (true) {
                    RegisterType[] registerTypeArr2 = this.preRegisterMap;
                    if (i >= registerTypeArr2.length) {
                        break;
                    }
                    byte b4 = registerTypeArr2[i].category;
                    if (b4 == 16 || b4 == 17) {
                        arrayListNewArrayList.add(Integer.valueOf(i));
                    }
                    i++;
                }
            }
        }
        if (this.instructionIndex <= 0) {
            return arrayListNewArrayList;
        }
        this.methodAnalyzer.getClassPath();
        throw null;
    }

    public boolean isBeginningInstruction() {
        return this.predecessors.size() != 0 && this.predecessors.first().instructionIndex == -1;
    }

    public boolean isInvokeInit() {
        if (!this.instruction.getOpcode().canInitializeReference()) {
            return false;
        }
        Reference reference = ((ReferenceInstruction) this.instruction).getReference();
        if (reference instanceof MethodReference) {
            return ((MethodReference) reference).getName().equals("<init>");
        }
        return false;
    }

    public boolean mergeRegister(int i, RegisterType registerType, BitSet bitSet, boolean z) {
        RegisterType registerType2 = this.preRegisterMap[i];
        RegisterType mergedPreRegisterTypeFromPredecessors = z ? getMergedPreRegisterTypeFromPredecessors(i) : registerType2.merge(registerType);
        if (mergedPreRegisterTypeFromPredecessors.equals(registerType2)) {
            return false;
        }
        this.preRegisterMap[i] = mergedPreRegisterTypeFromPredecessors;
        bitSet.clear(this.instructionIndex);
        if (setsRegister(i)) {
            return false;
        }
        this.postRegisterMap[i] = mergedPreRegisterTypeFromPredecessors;
        return true;
    }

    public void restoreOdexedInstruction() {
        this.instruction = this.originalInstruction;
    }

    public void setDeodexedInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public boolean setPostRegisterType(int i, RegisterType registerType) {
        if (this.postRegisterMap[i].equals(registerType)) {
            return false;
        }
        this.postRegisterMap[i] = registerType;
        return true;
    }

    public boolean setsRegister(int i) {
        byte b2;
        if (!isInvokeInit()) {
            if (this.instructionIndex > 0) {
                this.methodAnalyzer.getClassPath();
                throw null;
            }
            if (!this.instruction.getOpcode().setsRegister()) {
                return false;
            }
            int destinationRegister = getDestinationRegister();
            if (i == destinationRegister) {
                return true;
            }
            return this.instruction.getOpcode().setsWideRegister() && i == destinationRegister + 1;
        }
        Instruction instruction = this.instruction;
        int registerC = instruction instanceof FiveRegisterInstruction ? ((FiveRegisterInstruction) instruction).getRegisterC() : ((RegisterRangeInstruction) instruction).getStartRegister();
        RegisterType preInstructionRegisterType = getPreInstructionRegisterType(registerC);
        if (preInstructionRegisterType.category == 0 && ((b2 = getPreInstructionRegisterType(i).category) == 16 || b2 == 17)) {
            return true;
        }
        byte b3 = preInstructionRegisterType.category;
        if (b3 != 16 && b3 != 17) {
            return false;
        }
        if (i == registerC) {
            return true;
        }
        return preInstructionRegisterType.equals(getPreInstructionRegisterType(i));
    }
}
