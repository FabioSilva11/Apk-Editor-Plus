package jadx.api;

import jadx.core.Jadx;
import jadx.core.ProcessClass;
import jadx.core.codegen.CodeGen;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.RootNode;
import jadx.core.dex.visitors.IDexTreeVisitor;
import jadx.core.dex.visitors.SaveCode;
import jadx.core.utils.exceptions.JadxException;
import jadx.core.utils.exceptions.JadxRuntimeException;
import jadx.core.utils.files.InputFile;
import jadx.core.xmlgen.BinaryXMLParser;
import jadx.core.xmlgen.ResourcesSaver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class JadxDecompiler {
    private final IJadxArgs args;
    private List classes;
    private Map classesMap;
    private CodeGen codeGen;
    private Map fieldsMap;
    private final List inputFiles;
    private Map methodsMap;
    private File outDir;
    private List passes;
    private List resources;
    private RootNode root;
    private BinaryXMLParser xmlParser;

    public JadxDecompiler() {
        this(new JadxArgs());
    }

    public JadxDecompiler(IJadxArgs iJadxArgs) {
        this.inputFiles = new ArrayList();
        this.classesMap = new HashMap();
        this.methodsMap = new HashMap();
        this.fieldsMap = new HashMap();
        this.args = iJadxArgs;
        this.outDir = iJadxArgs.getOutDir();
        reset();
        init();
    }

    private ExecutorService getSaveExecutor(boolean z, boolean z2) {
        if (this.root == null) {
            throw new JadxRuntimeException("No loaded files");
        }
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(this.args.getThreadsCount());
        if (z) {
            for (final JavaClass javaClass : getClasses()) {
                executorServiceNewFixedThreadPool.execute(new Runnable() { // from class: jadx.api.JadxDecompiler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        javaClass.decompile();
                        SaveCode.save(JadxDecompiler.this.outDir, JadxDecompiler.this.args, javaClass.getClassNode());
                    }
                });
            }
        }
        if (z2) {
            Iterator it = getResources().iterator();
            while (it.hasNext()) {
                executorServiceNewFixedThreadPool.execute(new ResourcesSaver(this.outDir, (ResourceFile) it.next()));
            }
        }
        return executorServiceNewFixedThreadPool;
    }

    public static String getVersion() {
        return Jadx.getVersion();
    }

    private void initVisitors() {
        Iterator it = this.passes.iterator();
        while (it.hasNext()) {
            try {
                ((IDexTreeVisitor) it.next()).init(this.root);
            } catch (Exception e) {
            }
        }
    }

    private void save(boolean z, boolean z2) {
        try {
            ExecutorService saveExecutor = getSaveExecutor(z, z2);
            saveExecutor.shutdown();
            saveExecutor.awaitTermination(1L, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new JadxRuntimeException("Save interrupted", e);
        }
    }

    public final IJadxArgs getArgs() {
        return this.args;
    }

    public final List getClasses() {
        if (this.root == null) {
            return Collections.emptyList();
        }
        if (this.classes == null) {
            List<ClassNode> classes = this.root.getClasses(false);
            ArrayList arrayList = new ArrayList(classes.size());
            this.classesMap.clear();
            for (ClassNode classNode : classes) {
                JavaClass javaClass = new JavaClass(classNode, this);
                arrayList.add(javaClass);
                this.classesMap.put(classNode, javaClass);
            }
            this.classes = Collections.unmodifiableList(arrayList);
        }
        return this.classes;
    }

    final Map getClassesMap() {
        return this.classesMap;
    }

    public final int getErrorsCount() {
        if (this.root == null) {
            return 0;
        }
        return this.root.getErrorsCounter().getErrorCount();
    }

    final Map getFieldsMap() {
        return this.fieldsMap;
    }

    final Map getMethodsMap() {
        return this.methodsMap;
    }

    public final List getPackages() {
        List<JavaClass> classes = getClasses();
        if (classes.isEmpty()) {
            return Collections.emptyList();
        }
        HashMap map = new HashMap();
        for (JavaClass javaClass : classes) {
            String str = javaClass.getPackage();
            List arrayList = (List) map.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(str, arrayList);
            }
            arrayList.add(javaClass);
        }
        ArrayList arrayList2 = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList2.add(new JavaPackage((String) entry.getKey(), (List) entry.getValue()));
        }
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Collections.sort(((JavaPackage) it.next()).getClasses(), new Comparator() { // from class: jadx.api.JadxDecompiler.2
                @Override // java.util.Comparator
                public int compare(JavaClass javaClass2, JavaClass javaClass3) {
                    return javaClass2.getName().compareTo(javaClass3.getName());
                }
            });
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public final List getResources() {
        if (this.resources == null) {
            if (this.root == null) {
                return Collections.emptyList();
            }
            this.resources = new ResourcesLoader(this).load(this.inputFiles);
        }
        return this.resources;
    }

    final RootNode getRoot() {
        return this.root;
    }

    public final ExecutorService getSaveExecutor() {
        return getSaveExecutor(!this.args.isSkipSources(), this.args.isSkipResources() ? false : true);
    }

    final synchronized BinaryXMLParser getXmlParser() {
        if (this.xmlParser == null) {
            this.xmlParser = new BinaryXMLParser(this.root);
        }
        return this.xmlParser;
    }

    final void init() {
        if (this.outDir == null) {
            this.outDir = new JadxArgs().getOutDir();
        }
        this.passes = Jadx.getPassesList(this.args, this.outDir);
        this.codeGen = new CodeGen(this.args);
    }

    public final void loadFile(File file) throws JadxException {
        loadFiles(Collections.singletonList(file));
    }

    public final void loadFiles(List list) throws JadxException {
        if (list.isEmpty()) {
            throw new JadxException("Empty file list");
        }
        this.inputFiles.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            try {
                InputFile inputFile = new InputFile(file);
                this.inputFiles.add(inputFile);
                while (inputFile.nextDexIndex != -1) {
                    InputFile inputFile2 = new InputFile(file, inputFile.nextDexIndex);
                    this.inputFiles.add(inputFile2);
                    inputFile = inputFile2;
                }
            } catch (IOException e) {
                throw new JadxException("Error load file: " + file, e);
            }
        }
        parse();
    }

    final void parse() {
        reset();
        init();
        this.root = new RootNode(this.args);
        this.root.load(this.inputFiles);
        this.root.initClassPath();
        this.root.loadResources(getResources());
        this.root.initAppResClass();
        initVisitors();
    }

    public final void printErrorsReport() {
        if (this.root == null) {
            return;
        }
        this.root.getErrorsCounter().printReport();
    }

    final void processClass(ClassNode classNode) {
        ProcessClass.process(classNode, this.passes, this.codeGen);
    }

    final void reset() {
        this.classes = null;
        this.resources = null;
        this.xmlParser = null;
        this.root = null;
        this.passes = null;
        this.codeGen = null;
    }

    public final void save() {
        save(!this.args.isSkipSources(), this.args.isSkipResources() ? false : true);
    }

    public final void saveResources() {
        save(false, true);
    }

    public final void saveSources() {
        save(true, false);
    }

    public final void setOutputDir(File file) {
        this.outDir = file;
        init();
    }

    public final String toString() {
        return "jadx decompiler " + getVersion();
    }
}
