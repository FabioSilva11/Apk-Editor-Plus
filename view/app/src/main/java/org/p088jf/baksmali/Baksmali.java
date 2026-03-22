package org.p088jf.baksmali;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.p088jf.baksmali.Adaptors.ClassDefinition;
import org.p088jf.baksmali.formatter.BaksmaliWriter;
import org.p088jf.dexlib2.iface.ClassDef;
import org.p088jf.dexlib2.iface.DexFile;
import org.p088jf.util.ClassFileNameHandler;

/* JADX INFO: loaded from: classes.dex */
public class Baksmali {
    public static boolean disassembleClass(ClassDef classDef, ClassFileNameHandler classFileNameHandler, BaksmaliOptions baksmaliOptions) throws Throwable {
        String type = classDef.getType();
        if (type.charAt(0) != 'L' || type.charAt(type.length() - 1) != ';') {
            System.err.println("Unrecognized class descriptor - " + type + " - skipping class");
            return false;
        }
        try {
            File uniqueFilenameForClass = classFileNameHandler.getUniqueFilenameForClass(type);
            ClassDefinition classDefinition = new ClassDefinition(baksmaliOptions, classDef);
            BaksmaliWriter baksmaliWriter = null;
            try {
                try {
                    File parentFile = uniqueFilenameForClass.getParentFile();
                    if (!parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                        System.err.println("Unable to create directory " + parentFile.toString() + " - skipping class");
                        return false;
                    }
                    if (!uniqueFilenameForClass.exists() && !uniqueFilenameForClass.createNewFile()) {
                        System.err.println("Unable to create file " + uniqueFilenameForClass.toString() + " - skipping class");
                        return false;
                    }
                    BaksmaliWriter baksmaliWriter2 = new BaksmaliWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(uniqueFilenameForClass), "UTF8")), baksmaliOptions.implicitReferences ? classDef.getType() : null);
                    try {
                        classDefinition.writeTo(baksmaliWriter2);
                        try {
                            baksmaliWriter2.close();
                        } catch (Throwable th) {
                            System.err.println("\n\nError occurred while closing file " + uniqueFilenameForClass.toString());
                            th.printStackTrace();
                        }
                        return true;
                    } catch (Exception e) {
                        e = e;
                        baksmaliWriter = baksmaliWriter2;
                        System.err.println("\n\nError occurred while disassembling class " + type.replace('/', '.') + " - skipping class");
                        e.printStackTrace();
                        uniqueFilenameForClass.delete();
                        if (baksmaliWriter != null) {
                            try {
                                baksmaliWriter.close();
                            } catch (Throwable th2) {
                                System.err.println("\n\nError occurred while closing file " + uniqueFilenameForClass.toString());
                                th2.printStackTrace();
                            }
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        baksmaliWriter = baksmaliWriter2;
                        if (baksmaliWriter != null) {
                            try {
                                baksmaliWriter.close();
                            } catch (Throwable th4) {
                                System.err.println("\n\nError occurred while closing file " + uniqueFilenameForClass.toString());
                                th4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (IOException e3) {
            System.err.println("\n\nError occurred while creating file for class " + type);
            e3.printStackTrace();
            return false;
        }
    }

    public static boolean disassembleDexFile(DexFile dexFile, File file, int i, final BaksmaliOptions baksmaliOptions, List<String> list) {
        List<ClassDef> listSortedCopy = Ordering.natural().sortedCopy(dexFile.getClasses());
        final ClassFileNameHandler classFileNameHandler = new ClassFileNameHandler(file, ".smali");
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(i);
        ArrayList<Future> arrayListNewArrayList = Lists.newArrayList();
        HashSet hashSet = list != null ? new HashSet(list) : null;
        for (final ClassDef classDef : listSortedCopy) {
            if (hashSet == null || hashSet.contains(classDef.getType())) {
                arrayListNewArrayList.add(executorServiceNewFixedThreadPool.submit(new Callable<Boolean>() { // from class: org.jf.baksmali.Baksmali.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        return Boolean.valueOf(Baksmali.disassembleClass(classDef, classFileNameHandler, baksmaliOptions));
                    }
                }));
            }
        }
        boolean z = false;
        try {
            for (Future future : arrayListNewArrayList) {
                while (true) {
                    try {
                        break;
                    } catch (InterruptedException unused) {
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (!((Boolean) future.get()).booleanValue()) {
                    z = true;
                }
            }
            executorServiceNewFixedThreadPool.shutdown();
            return !z;
        } catch (Throwable th) {
            executorServiceNewFixedThreadPool.shutdown();
            throw th;
        }
    }
}
