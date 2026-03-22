package com.gmail.heagoo.apkeditor.pro;

import java.io.File;
import java.util.List;
import org.jf.baksmali.Baksmali_r;
import org.p088jf.baksmali.BaksmaliOptions;
import org.p088jf.dexlib2.DexFileFactory;
import org.p088jf.dexlib2.Opcodes;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;

/* JADX INFO: loaded from: classes.dex */
public class ResourceDecoder {
    public static void decodeResources(String str, String str2) throws Exception {
        DexBackedDexFile dexBackedDexFileLoadDexFile = loadDexFile(str);
        File file = new File(str2);
        if (!file.exists() && !file.mkdirs()) {
            throw new Exception("Can't create the output directory " + str2);
        }
        if (!Baksmali_r.disassembleDexResource(dexBackedDexFileLoadDexFile, file, Runtime.getRuntime().availableProcessors(), getOptions(), (List) null)) {
            throw new Exception("Baksmali.disassembleDexFile failed.");
        }
    }

    private static BaksmaliOptions getOptions() {
        BaksmaliOptions baksmaliOptions = new BaksmaliOptions();
        baksmaliOptions.parameterRegisters = true;
        baksmaliOptions.localsDirective = false;
        baksmaliOptions.sequentialLabels = false;
        baksmaliOptions.debugInfo = true;
        baksmaliOptions.codeOffsets = false;
        baksmaliOptions.accessorComments = true;
        baksmaliOptions.implicitReferences = false;
        baksmaliOptions.normalizeVirtualMethods = false;
        baksmaliOptions.registerInfo = 0;
        return baksmaliOptions;
    }

    protected static DexBackedDexFile loadDexFile(String str) throws Exception {
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            throw new Exception("Can't find file: " + str);
        }
        return DexFileFactory.loadDexFile(file, Opcodes.forApi(15));
    }
}
