package org.p088jf.dexlib2.iface;

import java.util.Set;
import org.p088jf.dexlib2.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public interface DexFile {
    Set<? extends ClassDef> getClasses();

    Opcodes getOpcodes();
}
