package jadx.core.deobf;

import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.info.FieldInfo;
import jadx.core.dex.info.MethodInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.p074io.FileUtils;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
class DeobfPresets {
    private static final InterfaceC1668b LOG = C1677c.m3845a(DeobfPresets.class);
    private static final String MAP_FILE_CHARSET = "UTF-8";
    private final File deobfMapFile;
    private final Deobfuscator deobfuscator;
    private final Map clsPresetMap = new HashMap();
    private final Map fldPresetMap = new HashMap();
    private final Map mthPresetMap = new HashMap();

    public DeobfPresets(Deobfuscator deobfuscator, File file) {
        this.deobfuscator = deobfuscator;
        this.deobfMapFile = file;
    }

    private static void dfsPackageName(List list, String str, PackageNode packageNode) {
        Iterator it = packageNode.getInnerPackages().iterator();
        while (it.hasNext()) {
            dfsPackageName(list, str + '.' + packageNode.getName(), (PackageNode) it.next());
        }
        if (packageNode.hasAlias()) {
            list.add(String.format("p %s.%s = %s", str, packageNode.getName(), packageNode.getAlias()));
        }
    }

    private void dumpMapping() throws IOException {
        ArrayList arrayList = new ArrayList();
        for (PackageNode packageNode : this.deobfuscator.getRootPackage().getInnerPackages()) {
            Iterator it = packageNode.getInnerPackages().iterator();
            while (it.hasNext()) {
                dfsPackageName(arrayList, packageNode.getName(), (PackageNode) it.next());
            }
            if (packageNode.hasAlias()) {
                arrayList.add(String.format("p %s = %s", packageNode.getName(), packageNode.getAlias()));
            }
        }
        for (DeobfClsInfo deobfClsInfo : this.deobfuscator.getClsMap().values()) {
            if (deobfClsInfo.getAlias() != null) {
                arrayList.add(String.format("c %s = %s", deobfClsInfo.getCls().getClassInfo().getFullName(), deobfClsInfo.getAlias()));
            }
        }
        for (FieldInfo fieldInfo : this.deobfuscator.getFldMap().keySet()) {
            arrayList.add(String.format("f %s = %s", fieldInfo.getFullId(), fieldInfo.getAlias()));
        }
        for (MethodInfo methodInfo : this.deobfuscator.getMthMap().keySet()) {
            arrayList.add(String.format("m %s = %s", methodInfo.getFullId(), methodInfo.getAlias()));
        }
        Collections.sort(arrayList);
        FileUtils.writeLines(this.deobfMapFile, MAP_FILE_CHARSET, arrayList);
        arrayList.clear();
    }

    private static String[] splitAndTrim(String str) {
        String[] strArrSplit = str.substring(2).split("=");
        for (int i = 0; i < strArrSplit.length; i++) {
            strArrSplit[i] = strArrSplit[i].trim();
        }
        return strArrSplit;
    }

    public void clear() {
        this.clsPresetMap.clear();
        this.fldPresetMap.clear();
        this.mthPresetMap.clear();
    }

    public Map getClsPresetMap() {
        return this.clsPresetMap;
    }

    public Map getFldPresetMap() {
        return this.fldPresetMap;
    }

    public String getForCls(ClassInfo classInfo) {
        return (String) this.clsPresetMap.get(classInfo.getFullName());
    }

    public String getForFld(FieldInfo fieldInfo) {
        return (String) this.fldPresetMap.get(fieldInfo.getFullId());
    }

    public String getForMth(MethodInfo methodInfo) {
        return (String) this.mthPresetMap.get(methodInfo.getFullId());
    }

    public Map getMthPresetMap() {
        return this.mthPresetMap;
    }

    public void load() {
        if (this.deobfMapFile.exists()) {
            try {
                Iterator<String> it = FileUtils.readLines(this.deobfMapFile, MAP_FILE_CHARSET).iterator();
                while (it.hasNext()) {
                    String strTrim = it.next().trim();
                    if (!strTrim.isEmpty() && !strTrim.startsWith("#")) {
                        String[] strArrSplitAndTrim = splitAndTrim(strTrim);
                        if (strArrSplitAndTrim.length == 2) {
                            String str = strArrSplitAndTrim[0];
                            String str2 = strArrSplitAndTrim[1];
                            if (strTrim.startsWith("p ")) {
                                this.deobfuscator.addPackagePreset(str, str2);
                            } else if (strTrim.startsWith("c ")) {
                                this.clsPresetMap.put(str, str2);
                            } else if (strTrim.startsWith("f ")) {
                                this.fldPresetMap.put(str, str2);
                            } else if (strTrim.startsWith("m ")) {
                                this.mthPresetMap.put(str, str2);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                LOG.mo3826c("Failed to load deobfuscation map file '{}'", this.deobfMapFile.getAbsolutePath(), e);
            }
        }
    }

    public void save(boolean z) {
        try {
            if (!this.deobfMapFile.exists() || z) {
                dumpMapping();
            } else {
                LOG.mo3825c("Deobfuscation map file '{}' exists. Use command line option '--deobf-rewrite-cfg' to rewrite it", this.deobfMapFile.getAbsolutePath());
            }
        } catch (IOException e) {
            LOG.mo3826c("Failed to load deobfuscation map file '{}'", this.deobfMapFile.getAbsolutePath(), e);
        }
    }
}
