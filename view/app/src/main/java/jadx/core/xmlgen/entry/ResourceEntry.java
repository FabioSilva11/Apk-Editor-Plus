package jadx.core.xmlgen.entry;

import jadx.core.deobf.Deobfuscator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ResourceEntry {
    private EntryConfig config;

    /* JADX INFO: renamed from: id */
    private final int f4705id;
    private final String keyName;
    private List namedValues;
    private int parentRef;
    private final String pkgName;
    private RawValue simpleValue;
    private final String typeName;

    public ResourceEntry(int i) {
        this(i, "", "", "");
    }

    public ResourceEntry(int i, String str, String str2, String str3) {
        this.f4705id = i;
        this.pkgName = str;
        this.typeName = str2;
        this.keyName = str3;
    }

    public final EntryConfig getConfig() {
        return this.config;
    }

    public final int getId() {
        return this.f4705id;
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public final List getNamedValues() {
        return this.namedValues;
    }

    public final int getParentRef() {
        return this.parentRef;
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final RawValue getSimpleValue() {
        return this.simpleValue;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final void setConfig(EntryConfig entryConfig) {
        this.config = entryConfig;
    }

    public final void setNamedValues(List list) {
        this.namedValues = list;
    }

    public final void setParentRef(int i) {
        this.parentRef = i;
    }

    public final void setSimpleValue(RawValue rawValue) {
        this.simpleValue = rawValue;
    }

    public final String toString() {
        return "  0x" + Integer.toHexString(this.f4705id) + " (" + this.f4705id + ")" + this.config + " = " + this.typeName + Deobfuscator.CLASS_NAME_SEPARATOR + this.keyName;
    }
}
