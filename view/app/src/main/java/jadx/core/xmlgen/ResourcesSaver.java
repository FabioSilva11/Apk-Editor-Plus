package jadx.core.xmlgen;

import jadx.api.ResourceFile;
import jadx.api.ResourceType;
import jadx.core.codegen.CodeWriter;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResourcesSaver implements Runnable {
    private File outDir;
    private final ResourceFile resourceFile;

    public ResourcesSaver(File file, ResourceFile resourceFile) {
        this.resourceFile = resourceFile;
        this.outDir = file;
    }

    private void saveResources(ResContainer resContainer) throws Throwable {
        if (resContainer == null) {
            return;
        }
        List subFiles = resContainer.getSubFiles();
        if (!subFiles.isEmpty()) {
            Iterator it = subFiles.iterator();
            while (it.hasNext()) {
                saveResources((ResContainer) it.next());
            }
        } else {
            CodeWriter content = resContainer.getContent();
            if (content != null) {
                content.save(new File(this.outDir, resContainer.getFileName()));
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        ResContainer content;
        if (ResourceType.isSupportedForUnpack(this.resourceFile.getType()) && (content = this.resourceFile.getContent()) != null) {
            saveResources(content);
        }
    }
}
