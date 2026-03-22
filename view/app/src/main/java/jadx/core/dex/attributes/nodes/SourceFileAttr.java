package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;

/* JADX INFO: loaded from: classes.dex */
public class SourceFileAttr implements IAttribute {
    private final String fileName;

    public SourceFileAttr(String str) {
        this.fileName = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.SOURCE_FILE;
    }

    public String toString() {
        return "SOURCE:" + this.fileName;
    }
}
