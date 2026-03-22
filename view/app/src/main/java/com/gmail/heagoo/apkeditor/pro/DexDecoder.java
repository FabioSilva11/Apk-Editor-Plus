package com.gmail.heagoo.apkeditor.pro;

import com.gmail.heagoo.apkeditor.App;
import com.gmail.heagoo.apkeditor.SettingActivity;
import java.io.File;
import java.util.List;
import org.p088jf.baksmali.Baksmali;
import org.p088jf.baksmali.BaksmaliOptions;
import org.p088jf.dexlib2.DexFileFactory;
import org.p088jf.dexlib2.Opcodes;
import org.p088jf.dexlib2.dexbacked.DexBackedDexFile;

/* JADX INFO: loaded from: classes.dex */
public class DexDecoder {
    private final String dexFilePath;
    private String strWarning;

    public DexDecoder(String str) {
        this.dexFilePath = str;
    }

    private BaksmaliOptions getOptions() {
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

    public void dex2smali(String str) throws Exception {
        DexBackedDexFile dexBackedDexFileLoadDexFile = loadDexFile(this.dexFilePath);
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            if (!Baksmali.disassembleDexFile(dexBackedDexFileLoadDexFile, file, Runtime.getRuntime().availableProcessors(), getOptions(), (List) null)) {
                throw new Exception("Baksmali.disassembleDexFile failed.");
            }
        } else {
            throw new Exception("Can't create the output directory " + str);
        }
    }

    public String getWarning() {
        return this.strWarning;
    }

    protected DexBackedDexFile loadDexFile(String str) throws Exception {
        File file = new File(str);
        if (file.exists() && !file.isDirectory()) {
            return DexFileFactory.loadDexFile(file, Opcodes.forApi(SettingActivity.smaliApiLevel(App.getContext())));
        }
        throw new Exception("Can't find file: " + str);
    }
}
