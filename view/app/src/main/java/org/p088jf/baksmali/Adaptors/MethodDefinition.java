package org.p088jf.baksmali.Adaptors;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p088jf.baksmali.Adaptors.Debug.DebugMethodItem;
import org.p088jf.baksmali.Adaptors.Format.InstructionMethodItemFactory;
import org.p088jf.baksmali.BaksmaliOptions;
import org.p088jf.baksmali.formatter.BaksmaliWriter;
import org.p088jf.dexlib2.AccessFlags;
import org.p088jf.dexlib2.Format;
import org.p088jf.dexlib2.HiddenApiRestriction;
import org.p088jf.dexlib2.Opcode;
import org.p088jf.dexlib2.analysis.AnalysisException;
import org.p088jf.dexlib2.analysis.AnalyzedInstruction;
import org.p088jf.dexlib2.analysis.MethodAnalyzer;
import org.p088jf.dexlib2.iface.Annotation;
import org.p088jf.dexlib2.iface.ExceptionHandler;
import org.p088jf.dexlib2.iface.Method;
import org.p088jf.dexlib2.iface.MethodImplementation;
import org.p088jf.dexlib2.iface.MethodParameter;
import org.p088jf.dexlib2.iface.TryBlock;
import org.p088jf.dexlib2.iface.debug.DebugItem;
import org.p088jf.dexlib2.iface.instruction.Instruction;
import org.p088jf.dexlib2.iface.instruction.OffsetInstruction;
import org.p088jf.dexlib2.iface.instruction.formats.Instruction31t;
import org.p088jf.dexlib2.immutable.instruction.ImmutableInstruction31t;
import org.p088jf.dexlib2.util.InstructionOffsetMap;
import org.p088jf.dexlib2.util.SyntheticAccessorResolver;
import org.p088jf.dexlib2.util.TypeUtils;
import org.p088jf.util.ExceptionWithContext;
import org.p088jf.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public class MethodDefinition {
    public final ClassDefinition classDef;
    public final List<Instruction> effectiveInstructions;
    public final InstructionOffsetMap instructionOffsetMap;
    public final ImmutableList<Instruction> instructions;
    public final LabelCache labelCache = new LabelCache();
    public final Method method;
    public final MethodImplementation methodImpl;
    public final ImmutableList<MethodParameter> methodParameters;
    public final SparseIntArray packedSwitchMap;
    public RegisterFormatter registerFormatter;
    public final SparseIntArray sparseSwitchMap;

    public static class InvalidSwitchPayload extends ExceptionWithContext {
        public InvalidSwitchPayload(int i) {
            super("No switch payload at offset: %d", Integer.valueOf(i));
        }
    }

    public static class LabelCache {
        public HashMap<LabelMethodItem, LabelMethodItem> labels = new HashMap<>();

        public Collection<LabelMethodItem> getLabels() {
            return this.labels.values();
        }

        public LabelMethodItem internLabel(LabelMethodItem labelMethodItem) {
            LabelMethodItem labelMethodItem2 = this.labels.get(labelMethodItem);
            if (labelMethodItem2 != null) {
                return labelMethodItem2;
            }
            this.labels.put(labelMethodItem, labelMethodItem);
            return labelMethodItem;
        }
    }

    public MethodDefinition(ClassDefinition classDefinition, Method method, MethodImplementation methodImplementation) {
        boolean z;
        int codeUnits;
        boolean z2;
        this.classDef = classDefinition;
        this.method = method;
        this.methodImpl = methodImplementation;
        try {
            ImmutableList<Instruction> immutableListCopyOf = ImmutableList.copyOf(methodImplementation.getInstructions());
            this.instructions = immutableListCopyOf;
            this.methodParameters = ImmutableList.copyOf((Collection) method.getParameters());
            this.effectiveInstructions = Lists.newArrayList(immutableListCopyOf);
            this.packedSwitchMap = new SparseIntArray(0);
            this.sparseSwitchMap = new SparseIntArray(0);
            InstructionOffsetMap instructionOffsetMap = new InstructionOffsetMap(immutableListCopyOf);
            this.instructionOffsetMap = instructionOffsetMap;
            int instructionCodeOffset = instructionOffsetMap.getInstructionCodeOffset(immutableListCopyOf.size() - 1) + immutableListCopyOf.get(immutableListCopyOf.size() - 1).getCodeUnits();
            for (int i = 0; i < this.instructions.size(); i++) {
                Instruction instruction = this.instructions.get(i);
                Opcode opcode = instruction.getOpcode();
                if (opcode == Opcode.PACKED_SWITCH) {
                    int instructionCodeOffset2 = this.instructionOffsetMap.getInstructionCodeOffset(i);
                    int codeOffset = ((OffsetInstruction) instruction).getCodeOffset() + instructionCodeOffset2;
                    try {
                        codeOffset = findPayloadOffset(codeOffset, Opcode.PACKED_SWITCH_PAYLOAD);
                        z2 = true;
                    } catch (InvalidSwitchPayload unused) {
                        z2 = false;
                    }
                    if (z2) {
                        if (this.packedSwitchMap.get(codeOffset, -1) != -1) {
                            Instruction instructionFindSwitchPayload = findSwitchPayload(codeOffset, Opcode.PACKED_SWITCH_PAYLOAD);
                            this.effectiveInstructions.set(i, new ImmutableInstruction31t(opcode, ((Instruction31t) instruction).getRegisterA(), instructionCodeOffset - instructionCodeOffset2));
                            this.effectiveInstructions.add(instructionFindSwitchPayload);
                            codeUnits = instructionFindSwitchPayload.getCodeUnits() + instructionCodeOffset;
                        } else {
                            codeUnits = instructionCodeOffset;
                            instructionCodeOffset = codeOffset;
                        }
                        this.packedSwitchMap.append(instructionCodeOffset, instructionCodeOffset2);
                        instructionCodeOffset = codeUnits;
                    }
                } else if (opcode == Opcode.SPARSE_SWITCH) {
                    int instructionCodeOffset3 = this.instructionOffsetMap.getInstructionCodeOffset(i);
                    int codeOffset2 = ((OffsetInstruction) instruction).getCodeOffset() + instructionCodeOffset3;
                    try {
                        codeOffset2 = findPayloadOffset(codeOffset2, Opcode.SPARSE_SWITCH_PAYLOAD);
                        z = true;
                    } catch (InvalidSwitchPayload unused2) {
                        z = false;
                    }
                    if (z) {
                        if (this.sparseSwitchMap.get(codeOffset2, -1) != -1) {
                            Instruction instructionFindSwitchPayload2 = findSwitchPayload(codeOffset2, Opcode.SPARSE_SWITCH_PAYLOAD);
                            this.effectiveInstructions.set(i, new ImmutableInstruction31t(opcode, ((Instruction31t) instruction).getRegisterA(), instructionCodeOffset - instructionCodeOffset3));
                            this.effectiveInstructions.add(instructionFindSwitchPayload2);
                            codeUnits = instructionFindSwitchPayload2.getCodeUnits() + instructionCodeOffset;
                        } else {
                            codeUnits = instructionCodeOffset;
                            instructionCodeOffset = codeOffset2;
                        }
                        this.sparseSwitchMap.append(instructionCodeOffset, instructionCodeOffset3);
                        instructionCodeOffset = codeUnits;
                    }
                }
            }
        } catch (Exception e) {
            try {
                throw ExceptionWithContext.withContext(e, "Error while processing method %s", classDefinition.getFormatter().getMethodDescriptor(method));
            } catch (Exception unused3) {
                throw ExceptionWithContext.withContext(e, "Error while processing method", new Object[0]);
            }
        }
    }

    public static void writeAccessFlagsAndRestrictions(BaksmaliWriter baksmaliWriter, int i, Set<HiddenApiRestriction> set) throws IOException {
        for (AccessFlags accessFlags : AccessFlags.getAccessFlagsForMethod(i)) {
            baksmaliWriter.write(accessFlags.toString());
            baksmaliWriter.write(32);
        }
        Iterator<HiddenApiRestriction> it = set.iterator();
        while (it.hasNext()) {
            baksmaliWriter.write(it.next().toString());
            baksmaliWriter.write(32);
        }
    }

    public static void writeEmptyMethodTo(BaksmaliWriter baksmaliWriter, Method method, ClassDefinition classDefinition) throws IOException {
        baksmaliWriter.write(".method ");
        writeAccessFlagsAndRestrictions(baksmaliWriter, method.getAccessFlags(), method.getHiddenApiRestrictions());
        baksmaliWriter.write(method.getName());
        baksmaliWriter.write("(");
        ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) method.getParameters());
        UnmodifiableIterator it = immutableListCopyOf.iterator();
        while (it.hasNext()) {
            baksmaliWriter.writeType(((MethodParameter) it.next()).getType());
        }
        baksmaliWriter.write(")");
        baksmaliWriter.write(method.getReturnType());
        baksmaliWriter.write(10);
        baksmaliWriter.indent(4);
        writeParameters(classDefinition, baksmaliWriter, method, immutableListCopyOf);
        AnnotationFormatter.writeTo(baksmaliWriter, method.getAnnotations());
        baksmaliWriter.deindent(4);
        baksmaliWriter.write(".end method\n");
    }

    public static void writeParameters(ClassDefinition classDefinition, BaksmaliWriter baksmaliWriter, Method method, List<? extends MethodParameter> list) throws IOException {
        int i = !AccessFlags.STATIC.isSet(method.getAccessFlags()) ? 1 : 0;
        for (MethodParameter methodParameter : list) {
            String type = methodParameter.getType();
            CharSequence name = methodParameter.getName();
            Set<? extends Annotation> annotations = methodParameter.getAnnotations();
            if ((classDefinition.options.debugInfo && name != null) || annotations.size() != 0) {
                baksmaliWriter.write(".param p");
                baksmaliWriter.writeSignedIntAsDec(i);
                if (name != null && classDefinition.options.debugInfo) {
                    baksmaliWriter.write(", ");
                    baksmaliWriter.writeQuotedString(name);
                }
                baksmaliWriter.write("    # ");
                baksmaliWriter.writeType(type);
                baksmaliWriter.write("\n");
                if (annotations.size() > 0) {
                    baksmaliWriter.indent(4);
                    AnnotationFormatter.writeTo(baksmaliWriter, annotations);
                    baksmaliWriter.deindent(4);
                    baksmaliWriter.write(".end param\n");
                }
            }
            i++;
            if (TypeUtils.isWideType(type)) {
                i++;
            }
        }
    }

    public final void addAnalyzedInstructionMethodItems(List<MethodItem> list) {
        BaksmaliOptions baksmaliOptions = this.classDef.options;
        MethodAnalyzer methodAnalyzer = new MethodAnalyzer(baksmaliOptions.classPath, this.method, baksmaliOptions.inlineResolver, baksmaliOptions.normalizeVirtualMethods);
        AnalysisException analysisException = methodAnalyzer.getAnalysisException();
        if (analysisException != null) {
            list.add(new CommentMethodItem(String.format("AnalysisException: %s", analysisException.getMessage()), analysisException.codeAddress, -2.147483648E9d));
            analysisException.printStackTrace(System.err);
        }
        List<AnalyzedInstruction> analyzedInstructions = methodAnalyzer.getAnalyzedInstructions();
        int codeUnits = 0;
        for (int i = 0; i < analyzedInstructions.size(); i++) {
            AnalyzedInstruction analyzedInstruction = analyzedInstructions.get(i);
            list.add(InstructionMethodItemFactory.makeInstructionFormatMethodItem(this, codeUnits, analyzedInstruction.getInstruction()));
            if (analyzedInstruction.getInstruction().getOpcode().format == Format.UnresolvedOdexInstruction) {
                list.add(new CommentedOutMethodItem(InstructionMethodItemFactory.makeInstructionFormatMethodItem(this, codeUnits, analyzedInstruction.getOriginalInstruction())));
            }
            if (i != analyzedInstructions.size() - 1) {
                list.add(new BlankMethodItem(codeUnits));
            }
            if (this.classDef.options.codeOffsets) {
                list.add(new MethodItem(this, codeUnits) { // from class: org.jf.baksmali.Adaptors.MethodDefinition.2
                    @Override // org.p088jf.baksmali.Adaptors.MethodItem
                    public double getSortOrder() {
                        return -1000.0d;
                    }

                    @Override // org.p088jf.baksmali.Adaptors.MethodItem
                    public boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
                        baksmaliWriter.write("#@");
                        baksmaliWriter.writeUnsignedLongAsHex(((long) this.codeAddress) & 4294967295L);
                        return true;
                    }
                });
            }
            if (this.classDef.options.registerInfo != 0 && !analyzedInstruction.getInstruction().getOpcode().format.isPayloadFormat) {
                list.add(new PreInstructionRegisterInfoMethodItem(this.classDef.options.registerInfo, methodAnalyzer, this.registerFormatter, analyzedInstruction, codeUnits));
                list.add(new PostInstructionRegisterInfoMethodItem(this.registerFormatter, analyzedInstruction, codeUnits));
            }
            codeUnits += analyzedInstruction.getInstruction().getCodeUnits();
        }
    }

    public final void addDebugInfo(List<MethodItem> list) {
        Iterator<? extends DebugItem> it = this.methodImpl.getDebugItems().iterator();
        while (it.hasNext()) {
            list.add(DebugMethodItem.build(this.classDef, this.registerFormatter, it.next()));
        }
    }

    public final void addInstructionMethodItems(List<MethodItem> list) {
        int codeUnits = 0;
        for (int i = 0; i < this.effectiveInstructions.size(); i++) {
            Instruction instruction = this.effectiveInstructions.get(i);
            list.add(InstructionMethodItemFactory.makeInstructionFormatMethodItem(this, codeUnits, instruction));
            if (i != this.effectiveInstructions.size() - 1) {
                list.add(new BlankMethodItem(codeUnits));
            }
            if (this.classDef.options.codeOffsets) {
                list.add(new MethodItem(this, codeUnits) { // from class: org.jf.baksmali.Adaptors.MethodDefinition.1
                    @Override // org.p088jf.baksmali.Adaptors.MethodItem
                    public double getSortOrder() {
                        return -1000.0d;
                    }

                    @Override // org.p088jf.baksmali.Adaptors.MethodItem
                    public boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
                        baksmaliWriter.write("#@");
                        baksmaliWriter.writeUnsignedLongAsHex(((long) this.codeAddress) & 4294967295L);
                        return true;
                    }
                });
            }
            BaksmaliOptions baksmaliOptions = this.classDef.options;
            if (baksmaliOptions.accessorComments) {
                SyntheticAccessorResolver syntheticAccessorResolver = baksmaliOptions.syntheticAccessorResolver;
            }
            codeUnits += instruction.getCodeUnits();
        }
    }

    public final void addTries(List<MethodItem> list) {
        List<? extends TryBlock<? extends ExceptionHandler>> tryBlocks = this.methodImpl.getTryBlocks();
        if (tryBlocks.size() == 0) {
            return;
        }
        int instructionCodeOffset = this.instructionOffsetMap.getInstructionCodeOffset(this.instructions.size() - 1);
        ImmutableList<Instruction> immutableList = this.instructions;
        int codeUnits = instructionCodeOffset + immutableList.get(immutableList.size() - 1).getCodeUnits();
        for (TryBlock<? extends ExceptionHandler> tryBlock : tryBlocks) {
            int startCodeAddress = tryBlock.getStartCodeAddress();
            int codeUnitCount = startCodeAddress + tryBlock.getCodeUnitCount();
            if (startCodeAddress >= codeUnits) {
                throw new RuntimeException(String.format("Try start offset %d is past the end of the code block.", Integer.valueOf(startCodeAddress)));
            }
            if (codeUnitCount > codeUnits) {
                throw new RuntimeException(String.format("Try end offset %d is past the end of the code block.", Integer.valueOf(codeUnitCount)));
            }
            int instructionCodeOffset2 = this.instructionOffsetMap.getInstructionCodeOffset(this.instructionOffsetMap.getInstructionIndexAtCodeOffset(codeUnitCount - 1, false));
            Iterator it = tryBlock.getExceptionHandlers().iterator();
            while (it.hasNext()) {
                ExceptionHandler exceptionHandler = (ExceptionHandler) it.next();
                int handlerCodeAddress = exceptionHandler.getHandlerCodeAddress();
                if (handlerCodeAddress >= codeUnits) {
                    throw new ExceptionWithContext("Exception handler offset %d is past the end of the code block.", Integer.valueOf(handlerCodeAddress));
                }
                list.add(new CatchMethodItem(this.classDef.options, this.labelCache, instructionCodeOffset2, exceptionHandler.getExceptionType(), startCodeAddress, codeUnitCount, handlerCodeAddress));
            }
        }
    }

    public int findPayloadOffset(int i, Opcode opcode) {
        int i2;
        try {
            int instructionIndexAtCodeOffset = this.instructionOffsetMap.getInstructionIndexAtCodeOffset(i);
            Instruction instruction = this.instructions.get(instructionIndexAtCodeOffset);
            if (instruction.getOpcode() == opcode) {
                return i;
            }
            if (instruction.getOpcode() == Opcode.NOP && (i2 = instructionIndexAtCodeOffset + 1) < this.instructions.size() && this.instructions.get(i2).getOpcode() == opcode) {
                return this.instructionOffsetMap.getInstructionCodeOffset(i2);
            }
            throw new InvalidSwitchPayload(i);
        } catch (InstructionOffsetMap.InvalidInstructionOffset unused) {
            throw new InvalidSwitchPayload(i);
        }
    }

    public Instruction findSwitchPayload(int i, Opcode opcode) {
        int i2;
        try {
            int instructionIndexAtCodeOffset = this.instructionOffsetMap.getInstructionIndexAtCodeOffset(i);
            Instruction instruction = this.instructions.get(instructionIndexAtCodeOffset);
            if (instruction.getOpcode() == opcode) {
                return instruction;
            }
            if (instruction.getOpcode() == Opcode.NOP && (i2 = instructionIndexAtCodeOffset + 1) < this.instructions.size()) {
                Instruction instruction2 = this.instructions.get(i2);
                if (instruction2.getOpcode() == opcode) {
                    return instruction2;
                }
            }
            throw new InvalidSwitchPayload(i);
        } catch (InstructionOffsetMap.InvalidInstructionOffset unused) {
            throw new InvalidSwitchPayload(i);
        }
    }

    public LabelCache getLabelCache() {
        return this.labelCache;
    }

    public final List<MethodItem> getMethodItems() {
        ArrayList arrayList = new ArrayList();
        BaksmaliOptions baksmaliOptions = this.classDef.options;
        if (baksmaliOptions.registerInfo != 0 || baksmaliOptions.normalizeVirtualMethods || (baksmaliOptions.deodex && needsAnalyzed())) {
            addAnalyzedInstructionMethodItems(arrayList);
        } else {
            addInstructionMethodItems(arrayList);
        }
        addTries(arrayList);
        if (this.classDef.options.debugInfo) {
            addDebugInfo(arrayList);
        }
        if (this.classDef.options.sequentialLabels) {
            setLabelSequentialNumbers();
        }
        Iterator<LabelMethodItem> it = this.labelCache.getLabels().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public int getPackedSwitchBaseAddress(int i) {
        return this.packedSwitchMap.get(i, -1);
    }

    public int getSparseSwitchBaseAddress(int i) {
        return this.sparseSwitchMap.get(i, -1);
    }

    public final boolean needsAnalyzed() {
        Iterator<? extends Instruction> it = this.methodImpl.getInstructions().iterator();
        while (it.hasNext()) {
            if (it.next().getOpcode().odexOnly()) {
                return true;
            }
        }
        return false;
    }

    public final void setLabelSequentialNumbers() {
        HashMap map = new HashMap();
        ArrayList<LabelMethodItem> arrayList = new ArrayList(this.labelCache.getLabels());
        Collections.sort(arrayList);
        for (LabelMethodItem labelMethodItem : arrayList) {
            Integer num = (Integer) map.get(labelMethodItem.getLabelPrefix());
            if (num == null) {
                num = 0;
            }
            labelMethodItem.setLabelSequence(num.intValue());
            map.put(labelMethodItem.getLabelPrefix(), Integer.valueOf(num.intValue() + 1));
        }
    }

    public void writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
        int i = !AccessFlags.STATIC.isSet(this.method.getAccessFlags()) ? 1 : 0;
        baksmaliWriter.write(".method ");
        writeAccessFlagsAndRestrictions(baksmaliWriter, this.method.getAccessFlags(), this.method.getHiddenApiRestrictions());
        baksmaliWriter.writeSimpleName(this.method.getName());
        baksmaliWriter.write("(");
        UnmodifiableIterator<MethodParameter> it = this.methodParameters.iterator();
        while (it.hasNext()) {
            String type = it.next().getType();
            baksmaliWriter.writeType(type);
            i++;
            if (TypeUtils.isWideType(type)) {
                i++;
            }
        }
        baksmaliWriter.write(")");
        baksmaliWriter.writeType(this.method.getReturnType());
        baksmaliWriter.write(10);
        baksmaliWriter.indent(4);
        if (this.classDef.options.localsDirective) {
            baksmaliWriter.write(".locals ");
            baksmaliWriter.writeSignedIntAsDec(this.methodImpl.getRegisterCount() - i);
        } else {
            baksmaliWriter.write(".registers ");
            baksmaliWriter.writeSignedIntAsDec(this.methodImpl.getRegisterCount());
        }
        baksmaliWriter.write(10);
        writeParameters(this.classDef, baksmaliWriter, this.method, this.methodParameters);
        if (this.registerFormatter == null) {
            this.registerFormatter = new RegisterFormatter(this.classDef.options, this.methodImpl.getRegisterCount(), i);
        }
        AnnotationFormatter.writeTo(baksmaliWriter, this.method.getAnnotations());
        baksmaliWriter.write(10);
        Iterator<MethodItem> it2 = getMethodItems().iterator();
        while (it2.hasNext()) {
            if (it2.next().writeTo(baksmaliWriter)) {
                baksmaliWriter.write(10);
            }
        }
        baksmaliWriter.deindent(4);
        baksmaliWriter.write(".end method\n");
    }
}
