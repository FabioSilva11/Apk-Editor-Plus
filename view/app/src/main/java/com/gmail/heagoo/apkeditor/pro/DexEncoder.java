package com.gmail.heagoo.apkeditor.pro;

import com.gmail.heagoo.apkeditor.App;
import com.gmail.heagoo.apkeditor.SettingActivity;
import com.gmail.heagoo.apkeditor.p067f.InterfaceC1206c;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.p088jf.dexlib2.Opcodes;
import org.p088jf.dexlib2.writer.builder.DexBuilder;
import org.p088jf.dexlib2.writer.p089io.FileDataStore;
import org.p088jf.smali.SmaliOptions;
import org.p088jf.smali.smaliFlexLexer;
import org.p088jf.smali.smaliParser;
import org.p088jf.smali.smaliTreeWalker;

/* JADX INFO: loaded from: classes.dex */
public class DexEncoder {
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean assembleSmaliFile(File file, DexBuilder dexBuilder, SmaliOptions smaliOptions) throws Exception {
        String str;
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            smaliFlexLexer smaliflexlexer = new smaliFlexLexer(new InputStreamReader(fileInputStream, "UTF-8"), smaliOptions.apiLevel);
            smaliflexlexer.setSourceFile(file);
            CommonTokenStream commonTokenStream = new CommonTokenStream(smaliflexlexer);
            smaliParser smaliparser = new smaliParser(commonTokenStream);
            smaliparser.setVerboseErrors(smaliOptions.verboseErrors);
            smaliparser.setAllowOdex(smaliOptions.allowOdexOpcodes);
            smaliparser.setApiLevel(smaliOptions.apiLevel);
            smaliParser.smali_file_return smali_file_returnVarSmali_file = smaliparser.smali_file();
            if (smaliparser.getNumberOfSyntaxErrors() <= 0 && smaliflexlexer.getNumberOfSyntaxErrors() <= 0) {
                CommonTreeNodeStream commonTreeNodeStream = new CommonTreeNodeStream(smali_file_returnVarSmali_file.getTree());
                commonTreeNodeStream.setTokenStream(commonTokenStream);
                smaliTreeWalker smalitreewalker = new smaliTreeWalker(commonTreeNodeStream);
                smalitreewalker.setApiLevel(smaliOptions.apiLevel);
                smalitreewalker.setVerboseErrors(smaliOptions.verboseErrors);
                smalitreewalker.setDexBuilder(dexBuilder);
                smalitreewalker.smali_file();
                if (smalitreewalker.getNumberOfSyntaxErrors() <= 0) {
                    fileInputStream.close();
                    fileInputStream.close();
                    return true;
                }
                String errorMessages = smalitreewalker.getErrorMessages();
                if (!errorMessages.equals("")) {
                    throw new Exception(errorMessages);
                }
                throw new Exception("Error occurred while compiling2 " + file.getName());
            }
            if (smaliflexlexer.getNumberOfSyntaxErrors() > 0) {
                str = "" + smaliflexlexer.getErrorMessages();
            } else {
                str = "";
            }
            if (smaliparser.getNumberOfSyntaxErrors() > 0) {
                str = str + smaliparser.getErrorMessages();
            }
            if (!str.equals("")) {
                throw new Exception(str);
            }
            throw new Exception("Error occurred while compiling1 " + file.getName());
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                throw th2;
            }
        }
    }

    private static void getSmaliFilesInDir(File file, Set<File> set) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    getSmaliFilesInDir(file2, set);
                } else if (file2.getName().endsWith(".smali")) {
                    set.add(file2);
                }
            }
        }
    }

    public static void smali2Dex(String str, String str2, InterfaceC1206c interfaceC1206c) throws Exception {
        final SmaliOptions smaliOptions = new SmaliOptions();
        smaliOptions.jobs = Runtime.getRuntime().availableProcessors();
        smaliOptions.apiLevel = SettingActivity.smaliApiLevel(App.getContext());
        smaliOptions.outputDexFile = str2;
        smaliOptions.allowOdexOpcodes = false;
        smaliOptions.verboseErrors = false;
        System.currentTimeMillis();
        LinkedHashSet<File> linkedHashSet = new LinkedHashSet();
        getSmaliFilesInDir(new File(str), linkedHashSet);
        final DexBuilder dexBuilder = new DexBuilder(Opcodes.forApi(smaliOptions.apiLevel));
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(smaliOptions.jobs);
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        for (final File file : linkedHashSet) {
            arrayListNewArrayList.add(executorServiceNewFixedThreadPool.submit(new Callable<Boolean>() { // from class: com.gmail.heagoo.apkeditor.pro.DexEncoder.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() throws Exception {
                    try {
                        return Boolean.valueOf(DexEncoder.assembleSmaliFile(file, dexBuilder, smaliOptions));
                    } catch (RuntimeException e) {
                        throw new RuntimeException(e.getMessage());
                    } catch (Exception e2) {
                        throw new Exception(e2.getMessage());
                    }
                }
            }));
        }
        int size = arrayListNewArrayList.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            if (!((Boolean) ((Future) arrayListNewArrayList.get(i)).get()).booleanValue()) {
                z = true;
            }
            interfaceC1206c.mo3008a(i, size);
        }
        executorServiceNewFixedThreadPool.shutdown();
        if (z) {
            throw new Exception("Encountered errors while compiling smali files.");
        }
        dexBuilder.writeTo(new FileDataStore(new File(smaliOptions.outputDexFile)));
        System.currentTimeMillis();
    }
}
