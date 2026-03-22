package jadx.core.xmlgen;

import jadx.core.utils.Utils;
import jadx.core.xmlgen.entry.ResourceEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ResourceStorage {
    private static final Comparator COMPARATOR = new Comparator() { // from class: jadx.core.xmlgen.ResourceStorage.1
        @Override // java.util.Comparator
        public final int compare(ResourceEntry resourceEntry, ResourceEntry resourceEntry2) {
            return Utils.compare(resourceEntry.getId(), resourceEntry2.getId());
        }
    };
    private String appPackage;
    private final List list = new ArrayList();

    public void add(ResourceEntry resourceEntry) {
        this.list.add(resourceEntry);
    }

    public void finish() {
        Collections.sort(this.list, COMPARATOR);
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public ResourceEntry getByRef(int i) {
        int iBinarySearch = Collections.binarySearch(this.list, new ResourceEntry(i), COMPARATOR);
        if (iBinarySearch < 0) {
            return null;
        }
        return (ResourceEntry) this.list.get(iBinarySearch);
    }

    public Collection getResources() {
        return this.list;
    }

    public Map getResourcesNames() {
        HashMap map = new HashMap();
        for (ResourceEntry resourceEntry : this.list) {
            map.put(Integer.valueOf(resourceEntry.getId()), resourceEntry.getTypeName() + "/" + resourceEntry.getKeyName());
        }
        return map;
    }

    public void setAppPackage(String str) {
        this.appPackage = str;
    }
}
