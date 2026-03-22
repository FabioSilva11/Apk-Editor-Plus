package com.p016a.p019b.p026b.p027a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p019b.p026b.C0522a;
import com.p016a.p019b.p026b.C0532b;
import com.p016a.p019b.p028c.C0533a;
import com.p016a.p019b.p028c.p029a.C0534a;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: renamed from: com.a.b.b.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0525c {
    private static final String INCREMENTAL_OPTION = "--incremental";
    private static final String INPUT_LIST_OPTION = "--input-list";
    private static final String MAIN_DEX_LIST_OPTION = "--main-dex-list";
    private static final String MINIMAL_MAIN_DEX_OPTION = "--minimal-main-dex";
    private static final String MULTI_DEX_OPTION = "--multi-dex";
    private static final String NUM_THREADS_OPTION = "--num-threads";
    public C0534a cfOptions$4cfd32cd;
    public C0533a dexOptions;
    public String[] fileNames;
    public boolean statistics;
    public boolean debug = false;
    public boolean verbose = false;
    public boolean verboseDump = false;
    public boolean coreLibrary = false;
    public String methodToDump = null;
    public int dumpWidth = 0;
    public String outName = null;
    public String humanOutName = null;
    public boolean strictNameCheck = true;
    public boolean emptyOk = false;
    public boolean jarOutput = false;
    public boolean keepClassesInJar = false;
    public int positionInfo = 2;
    public boolean localInfo = true;
    public boolean incremental = false;
    public boolean forceJumbo = false;
    public boolean optimize = true;
    public String optimizeListFile = null;
    public String dontOptimizeListFile = null;
    public int numThreads = 1;
    public boolean multiDex = false;
    public String mainDexListFile = null;
    public boolean minimalMainDex = false;
    private Set inputList = null;
    private int maxNumberOfIdxPerDex = 65536;

    /* JADX INFO: Access modifiers changed from: private */
    public void makeOptionsObjects() {
        this.cfOptions$4cfd32cd = new C0534a();
        this.cfOptions$4cfd32cd.f683a = this.positionInfo;
        this.cfOptions$4cfd32cd.f684b = this.localInfo;
        this.cfOptions$4cfd32cd.f685c = this.strictNameCheck;
        this.cfOptions$4cfd32cd.f686d = this.optimize;
        this.cfOptions$4cfd32cd.f687e = this.optimizeListFile;
        this.cfOptions$4cfd32cd.f688f = this.dontOptimizeListFile;
        this.cfOptions$4cfd32cd.f689g = this.statistics;
        this.cfOptions$4cfd32cd.f690h = C0522a.f657b;
        this.dexOptions = new C0533a();
        this.dexOptions.f682c = this.forceJumbo;
    }

    public void parse(String[] strArr) {
        C0526d c0526d = new C0526d(strArr);
        boolean z = false;
        boolean z2 = false;
        while (c0526d.m825c()) {
            if (c0526d.m823a("--debug")) {
                this.debug = true;
            } else if (c0526d.m823a("--verbose")) {
                this.verbose = true;
            } else if (c0526d.m823a("--verbose-dump")) {
                this.verboseDump = true;
            } else if (c0526d.m823a("--no-files")) {
                this.emptyOk = true;
            } else if (c0526d.m823a("--no-optimize")) {
                this.optimize = false;
            } else if (c0526d.m823a("--no-strict")) {
                this.strictNameCheck = false;
            } else if (c0526d.m823a("--core-library")) {
                this.coreLibrary = true;
            } else if (c0526d.m823a("--statistics")) {
                this.statistics = true;
            } else if (c0526d.m823a("--optimize-list=")) {
                if (this.dontOptimizeListFile != null) {
                    System.err.println("--optimize-list and --no-optimize-list are incompatible.");
                    throw new C0532b();
                }
                this.optimize = true;
                this.optimizeListFile = c0526d.m824b();
            } else if (c0526d.m823a("--no-optimize-list=")) {
                if (this.dontOptimizeListFile != null) {
                    System.err.println("--optimize-list and --no-optimize-list are incompatible.");
                    throw new C0532b();
                }
                this.optimize = true;
                this.dontOptimizeListFile = c0526d.m824b();
            } else if (c0526d.m823a("--keep-classes")) {
                this.keepClassesInJar = true;
            } else if (c0526d.m823a("--output=")) {
                this.outName = c0526d.m824b();
                if (new File(this.outName).isDirectory()) {
                    this.jarOutput = false;
                    z2 = true;
                } else if (C0985a.m2275g(this.outName)) {
                    this.jarOutput = true;
                } else {
                    if (!this.outName.endsWith(".dex") && !this.outName.equals("-")) {
                        System.err.println("unknown output extension: " + this.outName);
                        throw new C0532b();
                    }
                    this.jarOutput = false;
                    z = true;
                }
            } else if (c0526d.m823a("--dump-to=")) {
                this.humanOutName = c0526d.m824b();
            } else if (c0526d.m823a("--dump-width=")) {
                this.dumpWidth = Integer.parseInt(c0526d.m824b());
            } else if (c0526d.m823a("--dump-method=")) {
                this.methodToDump = c0526d.m824b();
                this.jarOutput = false;
            } else if (c0526d.m823a("--positions=")) {
                String strIntern = c0526d.m824b().intern();
                if (strIntern == "none") {
                    this.positionInfo = 1;
                } else if (strIntern == "important") {
                    this.positionInfo = 3;
                } else {
                    if (strIntern != "lines") {
                        System.err.println("unknown positions option: " + strIntern);
                        throw new C0532b();
                    }
                    this.positionInfo = 2;
                }
            } else if (c0526d.m823a("--no-locals")) {
                this.localInfo = false;
            } else if (c0526d.m823a("--num-threads=")) {
                this.numThreads = Integer.parseInt(c0526d.m824b());
            } else if (c0526d.m823a(INCREMENTAL_OPTION)) {
                this.incremental = true;
            } else if (c0526d.m823a("--force-jumbo")) {
                this.forceJumbo = true;
            } else if (c0526d.m823a(MULTI_DEX_OPTION)) {
                this.multiDex = true;
            } else if (c0526d.m823a("--main-dex-list=")) {
                this.mainDexListFile = c0526d.m824b();
            } else if (c0526d.m823a(MINIMAL_MAIN_DEX_OPTION)) {
                this.minimalMainDex = true;
            } else if (c0526d.m823a("--set-max-idx-number=")) {
                this.maxNumberOfIdxPerDex = Integer.parseInt(c0526d.m824b());
            } else {
                if (!c0526d.m823a("--input-list=")) {
                    System.err.println("unknown option: " + c0526d.m822a());
                    throw new C0532b();
                }
                File file = new File(c0526d.m824b());
                try {
                    this.inputList = C0523a.m813c(file.getAbsolutePath());
                } catch (IOException e) {
                    System.err.println("Unable to read input list file: " + file.getName());
                    throw new C0532b();
                }
            }
        }
        this.fileNames = c0526d.m826d();
        if (this.inputList != null && !this.inputList.isEmpty()) {
            this.inputList.addAll(Arrays.asList(this.fileNames));
            this.fileNames = (String[]) this.inputList.toArray(new String[this.inputList.size()]);
        }
        if (this.fileNames.length == 0) {
            if (!this.emptyOk) {
                System.err.println("no input files specified");
                throw new C0532b();
            }
        } else if (this.emptyOk) {
            System.out.println("ignoring input files");
        }
        if (this.humanOutName == null && this.methodToDump != null) {
            this.humanOutName = "-";
        }
        if (this.mainDexListFile != null && !this.multiDex) {
            System.err.println("--main-dex-list is only supported in combination with --multi-dex");
            throw new C0532b();
        }
        if (this.minimalMainDex && (this.mainDexListFile == null || !this.multiDex)) {
            System.err.println("--minimal-main-dex is only supported in combination with --multi-dex and --main-dex-list");
            throw new C0532b();
        }
        if (this.multiDex && this.numThreads != 1) {
            System.out.println("--num-threads is ignored when used with --multi-dex");
            this.numThreads = 1;
        }
        if (this.multiDex && this.incremental) {
            System.err.println("--incremental is not supported with --multi-dex");
            throw new C0532b();
        }
        if (this.multiDex && z) {
            System.err.println("Unsupported output \"" + this.outName + "\". --multi-dex supports only archive or directory output");
            throw new C0532b();
        }
        if (z2 && !this.multiDex) {
            this.outName = new File(this.outName, "classes.dex").getPath();
        }
        makeOptionsObjects();
    }
}
