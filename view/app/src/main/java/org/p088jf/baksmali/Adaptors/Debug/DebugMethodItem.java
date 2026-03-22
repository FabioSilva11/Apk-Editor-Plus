package org.p088jf.baksmali.Adaptors.Debug;

import org.p088jf.baksmali.Adaptors.ClassDefinition;
import org.p088jf.baksmali.Adaptors.MethodItem;
import org.p088jf.baksmali.Adaptors.RegisterFormatter;
import org.p088jf.dexlib2.iface.debug.DebugItem;
import org.p088jf.dexlib2.iface.debug.EndLocal;
import org.p088jf.dexlib2.iface.debug.LineNumber;
import org.p088jf.dexlib2.iface.debug.RestartLocal;
import org.p088jf.dexlib2.iface.debug.SetSourceFile;
import org.p088jf.dexlib2.iface.debug.StartLocal;
import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public abstract class DebugMethodItem extends MethodItem {
    public final int sortOrder;

    public DebugMethodItem(int i, int i2) {
        super(i);
        this.sortOrder = i2;
    }

    public static DebugMethodItem build(ClassDefinition classDefinition, RegisterFormatter registerFormatter, DebugItem debugItem) {
        int codeAddress = debugItem.getCodeAddress();
        switch (debugItem.getDebugItemType()) {
            case 3:
                return new StartLocalMethodItem(classDefinition, codeAddress, -1, registerFormatter, (StartLocal) debugItem);
            case 4:
            default:
                throw new ExceptionWithContext("Invalid debug item type: %d", Integer.valueOf(debugItem.getDebugItemType()));
            case 5:
                return new EndLocalMethodItem(codeAddress, -1, registerFormatter, (EndLocal) debugItem);
            case 6:
                return new RestartLocalMethodItem(classDefinition, codeAddress, -1, registerFormatter, (RestartLocal) debugItem);
            case 7:
                return new EndPrologueMethodItem(codeAddress, -4);
            case 8:
                return new BeginEpilogueMethodItem(codeAddress, -4);
            case 9:
                return new SetSourceFileMethodItem(codeAddress, -3, (SetSourceFile) debugItem);
            case 10:
                return new LineNumberMethodItem(codeAddress, -2, (LineNumber) debugItem);
        }
    }

    @Override // org.p088jf.baksmali.Adaptors.MethodItem
    public double getSortOrder() {
        return this.sortOrder;
    }
}
