package jadx.core.xmlgen;

import jadx.core.codegen.CodeWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResContainer implements Comparable {
    private CodeWriter content;
    private final String name;
    private final List subFiles;

    private ResContainer(String str, CodeWriter codeWriter, List list) {
        this.name = str;
        this.content = codeWriter;
        this.subFiles = list;
    }

    public static ResContainer multiFile(String str) {
        return new ResContainer(str, null, new ArrayList());
    }

    public static ResContainer singleFile(String str, CodeWriter codeWriter) {
        return new ResContainer(str, codeWriter, Collections.emptyList());
    }

    @Override // java.lang.Comparable
    public int compareTo(ResContainer resContainer) {
        return this.name.compareTo(resContainer.name);
    }

    public CodeWriter getContent() {
        return this.content;
    }

    public String getFileName() {
        return this.name.replace("/", File.separator);
    }

    public String getName() {
        return this.name;
    }

    public List getSubFiles() {
        return this.subFiles;
    }

    public void setContent(CodeWriter codeWriter) {
        this.content = codeWriter;
    }

    public String toString() {
        return "ResContainer{name='" + this.name + "', content=" + this.content + ", subFiles=" + this.subFiles + "}";
    }
}
