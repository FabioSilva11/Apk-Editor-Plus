package jadx.api;

import jadx.core.codegen.CodeWriter;
import jadx.core.xmlgen.ResContainer;

/* JADX INFO: loaded from: classes.dex */
public class ResourceFileContent extends ResourceFile {
    private final CodeWriter content;

    public ResourceFileContent(String str, ResourceType resourceType, CodeWriter codeWriter) {
        super(null, str, resourceType);
        this.content = codeWriter;
    }

    @Override // jadx.api.ResourceFile
    public ResContainer getContent() {
        return ResContainer.singleFile(getName(), this.content);
    }
}
