package jadx.core.dex.nodes;

import jadx.api.IJadxArgs;
import jadx.api.ResourceFile;
import jadx.api.ResourceType;
import jadx.api.ResourcesLoader;
import jadx.core.clsp.ClspGraph;
import jadx.core.dex.info.ClassInfo;
import jadx.core.utils.ErrorsCounter;
import jadx.core.utils.exceptions.DecodeException;
import jadx.core.utils.exceptions.JadxException;
import jadx.core.utils.files.InputFile;
import jadx.core.xmlgen.ResContainer;
import jadx.core.xmlgen.ResTableParser;
import jadx.core.xmlgen.ResourceStorage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RootNode {
    private String appPackage;
    private ClassNode appResClass;
    private final IJadxArgs args;
    private ClspGraph clsp;
    private List dexNodes;
    private final ErrorsCounter errorsCounter = new ErrorsCounter();
    private Map resourcesNames = new HashMap();

    public RootNode(IJadxArgs iJadxArgs) {
        this.args = iJadxArgs;
    }

    private void initInnerClasses() {
        Iterator it = this.dexNodes.iterator();
        while (it.hasNext()) {
            ((DexNode) it.next()).initInnerClasses();
        }
    }

    private ClassNode makeClass(String str) {
        DexNode dexNode = (DexNode) this.dexNodes.get(0);
        return new ClassNode(dexNode, ClassInfo.fromName(dexNode, str));
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public ClassNode getAppResClass() {
        return this.appResClass;
    }

    public IJadxArgs getArgs() {
        return this.args;
    }

    public List getClasses(boolean z) {
        ArrayList arrayList = new ArrayList();
        for (DexNode dexNode : this.dexNodes) {
            if (z) {
                arrayList.addAll(dexNode.getClasses());
            } else {
                for (ClassNode classNode : dexNode.getClasses()) {
                    if (!classNode.getClassInfo().isInner()) {
                        arrayList.add(classNode);
                    }
                }
            }
        }
        return arrayList;
    }

    public ClspGraph getClsp() {
        return this.clsp;
    }

    public List getDexNodes() {
        return this.dexNodes;
    }

    public ErrorsCounter getErrorsCounter() {
        return this.errorsCounter;
    }

    public Map getResourcesNames() {
        return this.resourcesNames;
    }

    public void initAppResClass() {
        if (this.appPackage == null) {
            this.appResClass = makeClass("R");
            return;
        }
        String str = this.appPackage + ".R";
        ClassNode classNodeSearchClassByName = searchClassByName(str);
        if (classNodeSearchClassByName != null) {
            this.appResClass = classNodeSearchClassByName;
        } else {
            this.appResClass = makeClass(str);
        }
    }

    public void initClassPath() {
        try {
            if (this.clsp == null) {
                ClspGraph clspGraph = new ClspGraph();
                clspGraph.load();
                ArrayList arrayList = new ArrayList();
                Iterator it = this.dexNodes.iterator();
                while (it.hasNext()) {
                    arrayList.addAll(((DexNode) it.next()).getClasses());
                }
                clspGraph.addApp(arrayList);
                this.clsp = clspGraph;
            }
        } catch (IOException e) {
            throw new DecodeException("Error loading classpath", e);
        }
    }

    public void load(List list) {
        this.dexNodes = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            InputFile inputFile = (InputFile) it.next();
            try {
                this.dexNodes.add(new DexNode(this, inputFile));
            } catch (Exception e) {
                throw new DecodeException("Error decode file: " + inputFile, e);
            }
        }
        Iterator it2 = this.dexNodes.iterator();
        while (it2.hasNext()) {
            ((DexNode) it2.next()).loadClasses();
        }
        initInnerClasses();
    }

    public void loadResources(List list) {
        ResourceFile resourceFile;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                resourceFile = null;
                break;
            } else {
                resourceFile = (ResourceFile) it.next();
                if (resourceFile.getType() == ResourceType.ARSC) {
                    break;
                }
            }
        }
        if (resourceFile == null) {
            return;
        }
        final ResTableParser resTableParser = new ResTableParser();
        try {
            ResourcesLoader.decodeStream(resourceFile, new ResourcesLoader.ResourceDecoder() { // from class: jadx.core.dex.nodes.RootNode.1
                @Override // jadx.api.ResourcesLoader.ResourceDecoder
                public ResContainer decode(long j, InputStream inputStream) {
                    resTableParser.decode(inputStream);
                    return null;
                }
            });
            ResourceStorage resStorage = resTableParser.getResStorage();
            this.resourcesNames = resStorage.getResourcesNames();
            this.appPackage = resStorage.getAppPackage();
        } catch (JadxException e) {
        }
    }

    public ClassNode searchClassByName(String str) {
        for (DexNode dexNode : this.dexNodes) {
            ClassNode classNodeResolveClass = dexNode.resolveClass(ClassInfo.fromName(dexNode, str));
            if (classNodeResolveClass != null) {
                return classNodeResolveClass;
            }
        }
        return null;
    }
}
