package jadx.api;

import jadx.core.xmlgen.ResContainer;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class ResourceFile {
    private final JadxDecompiler decompiler;
    private final String name;
    private final ResourceType type;
    private ZipRef zipRef;

    public final class ZipRef {
        private final String entryName;
        private final File zipFile;

        public ZipRef(File file, String str) {
            this.zipFile = file;
            this.entryName = str;
        }

        public final String getEntryName() {
            return this.entryName;
        }

        public final File getZipFile() {
            return this.zipFile;
        }

        public final String toString() {
            return "ZipRef{" + this.zipFile + ", '" + this.entryName + "'}";
        }
    }

    ResourceFile(JadxDecompiler jadxDecompiler, String str, ResourceType resourceType) {
        this.decompiler = jadxDecompiler;
        this.name = str;
        this.type = resourceType;
    }

    public ResContainer getContent() {
        return ResourcesLoader.loadContent(this.decompiler, this);
    }

    public String getName() {
        return this.name;
    }

    public ResourceType getType() {
        return this.type;
    }

    ZipRef getZipRef() {
        return this.zipRef;
    }

    void setZipRef(ZipRef zipRef) {
        this.zipRef = zipRef;
    }

    public String toString() {
        return "ResourceFile{name='" + this.name + "', type=" + this.type + "}";
    }
}
