package jadx.core.clsp;

import jadx.core.dex.nodes.ClassNode;
import jadx.core.utils.exceptions.JadxRuntimeException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
public class ClspGraph {
    private static final InterfaceC1668b LOG = C1677c.m3845a(ClspGraph.class);
    private final Map ancestorCache = new WeakHashMap();
    private Map nameMap;

    private void addAncestorsNames(NClass nClass, Set set) {
        set.add(nClass.getName());
        for (NClass nClass2 : nClass.getParents()) {
            addAncestorsNames(nClass2, set);
        }
    }

    private NClass addClass(ClassNode classNode) {
        String rawName = classNode.getRawName();
        NClass nClass = new NClass(rawName, -1);
        this.nameMap.put(rawName, nClass);
        return nClass;
    }

    private Set getAncestors(String str) {
        Set set = (Set) this.ancestorCache.get(str);
        if (set != null) {
            return set;
        }
        NClass nClass = (NClass) this.nameMap.get(str);
        if (nClass == null) {
            LOG.mo3815a("Missing class: {}", str);
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        addAncestorsNames(nClass, hashSet);
        Set setEmptySet = hashSet.isEmpty() ? Collections.emptySet() : hashSet;
        this.ancestorCache.put(str, setEmptySet);
        return setEmptySet;
    }

    private String searchCommonParent(Set set, NClass nClass) {
        for (NClass nClass2 : nClass.getParents()) {
            String name = nClass2.getName();
            if (set.contains(name)) {
                return name;
            }
            String strSearchCommonParent = searchCommonParent(set, nClass2);
            if (strSearchCommonParent != null) {
                return strSearchCommonParent;
            }
        }
        return null;
    }

    public void addApp(List list) {
        if (this.nameMap == null) {
            throw new JadxRuntimeException("Classpath must be loaded first");
        }
        int size = list.size();
        NClass[] nClassArr = new NClass[size];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            nClassArr[i] = addClass((ClassNode) it.next());
            i++;
        }
        for (int i2 = 0; i2 < size; i2++) {
            nClassArr[i2].setParents(ClsSet.makeParentsArray((ClassNode) list.get(i2), this.nameMap));
        }
    }

    public void addClasspath(ClsSet clsSet) {
        if (this.nameMap != null) {
            throw new JadxRuntimeException("Classpath already loaded");
        }
        this.nameMap = new HashMap(clsSet.getClassesCount());
        clsSet.addToMap(this.nameMap);
    }

    public String getCommonAncestor(String str, String str2) {
        if (str.equals(str2)) {
            return str;
        }
        NClass nClass = (NClass) this.nameMap.get(str2);
        if (nClass != null) {
            return isImplements(str, str2) ? str2 : searchCommonParent(getAncestors(str), nClass);
        }
        LOG.mo3815a("Missing class: {}", str2);
        return null;
    }

    public boolean isImplements(String str, String str2) {
        return getAncestors(str).contains(str2);
    }

    public void load() {
        ClsSet clsSet = new ClsSet();
        clsSet.load();
        addClasspath(clsSet);
    }
}
