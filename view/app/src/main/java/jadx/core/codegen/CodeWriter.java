package jadx.core.codegen;

import jadx.api.CodePosition;
import jadx.core.dex.attributes.nodes.LineAttrNode;
import jadx.core.utils.files.FileUtils;
import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class CodeWriter {
    private static final boolean ADD_LINE_NUMBERS = false;
    private static final int MAX_FILENAME_LENGTH = 128;
    private String code;

    /* JADX INFO: renamed from: NL */
    public static final String f4685NL = System.getProperty("line.separator");
    public static final String INDENT = "    ";
    private static final String[] INDENT_CACHE = {"", INDENT, "        ", "            ", "                ", "                    "};
    private StringBuilder buf = new StringBuilder();
    private int line = 1;
    private int offset = 0;
    private Map annotations = Collections.emptyMap();
    private Map lineMap = Collections.emptyMap();
    private int indent = 0;
    private String indentStr = "";

    class DefinitionWrapper {
        private final LineAttrNode node;

        private DefinitionWrapper(LineAttrNode lineAttrNode) {
            this.node = lineAttrNode;
        }

        public LineAttrNode getNode() {
            return this.node;
        }
    }

    private void addLine() {
        this.buf.append(f4685NL);
        this.line++;
        this.offset = 0;
    }

    private CodeWriter addLineIndent() {
        this.buf.append(this.indentStr);
        this.offset += this.indentStr.length();
        return this;
    }

    private Object attachAnnotation(Object obj, CodePosition codePosition) {
        if (this.annotations.isEmpty()) {
            this.annotations = new HashMap();
        }
        return this.annotations.put(codePosition, obj);
    }

    private void attachSourceLine(int i, int i2) {
        if (this.lineMap.isEmpty()) {
            this.lineMap = new TreeMap();
        }
        this.lineMap.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void removeFirstEmptyLine() {
        if (this.buf.indexOf(f4685NL) == 0) {
            this.buf.delete(0, f4685NL.length());
        }
    }

    private void updateIndent() {
        int i = this.indent;
        if (i < INDENT_CACHE.length) {
            this.indentStr = INDENT_CACHE[i];
            return;
        }
        StringBuilder sb = new StringBuilder(i * 4);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(INDENT);
        }
        this.indentStr = sb.toString();
    }

    public CodeWriter add(char c) {
        this.buf.append(c);
        this.offset++;
        return this;
    }

    CodeWriter add(CodeWriter codeWriter) {
        this.line--;
        for (Map.Entry entry : codeWriter.annotations.entrySet()) {
            CodePosition codePosition = (CodePosition) entry.getKey();
            attachAnnotation(entry.getValue(), new CodePosition(this.line + codePosition.getLine(), codePosition.getOffset()));
        }
        for (Map.Entry entry2 : codeWriter.lineMap.entrySet()) {
            attachSourceLine(((Integer) entry2.getKey()).intValue() + this.line, ((Integer) entry2.getValue()).intValue());
        }
        this.line += codeWriter.line;
        this.offset = codeWriter.offset;
        this.buf.append((CharSequence) codeWriter.buf);
        return this;
    }

    public CodeWriter add(String str) {
        this.buf.append(str);
        this.offset += str.length();
        return this;
    }

    public CodeWriter addIndent() {
        add(INDENT);
        return this;
    }

    public void attachAnnotation(Object obj) {
        attachAnnotation(obj, new CodePosition(this.line, this.offset + 1));
    }

    public void attachDefinition(LineAttrNode lineAttrNode) {
        attachAnnotation(lineAttrNode);
        attachAnnotation(new DefinitionWrapper(lineAttrNode), new CodePosition(this.line, this.offset));
    }

    public void attachSourceLine(int i) {
        if (i == 0) {
            return;
        }
        attachSourceLine(this.line, i);
    }

    public int bufLength() {
        return this.buf.length();
    }

    public void decIndent() {
        decIndent(1);
    }

    public void decIndent(int i) {
        this.indent -= i;
        if (this.indent < 0) {
            this.indent = 0;
        }
        updateIndent();
    }

    public void finish() {
        removeFirstEmptyLine();
        this.buf.trimToSize();
        this.code = this.buf.toString();
        this.buf = null;
        Iterator it = this.annotations.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            if (value instanceof DefinitionWrapper) {
                ((DefinitionWrapper) value).getNode().setDecompiledLine(((CodePosition) entry.getKey()).getLine());
                it.remove();
            }
        }
    }

    public Map getAnnotations() {
        return this.annotations;
    }

    public String getCodeStr() {
        return this.code;
    }

    public int getIndent() {
        return this.indent;
    }

    public int getLine() {
        return this.line;
    }

    public Map getLineMapping() {
        return this.lineMap;
    }

    public void incIndent() {
        incIndent(1);
    }

    public void incIndent(int i) {
        this.indent += i;
        updateIndent();
    }

    public CodeWriter newLine() {
        addLine();
        return this;
    }

    public void save(File file) throws Throwable {
        PrintWriter printWriter;
        if (this.code == null) {
            finish();
        }
        String name = file.getName();
        if (name.length() > 128) {
            int iIndexOf = name.indexOf(46);
            int length = ((128 - name.length()) + iIndexOf) - 1;
            file = new File(file.getParentFile(), length <= 0 ? name.substring(0, 127) : name.substring(0, length) + name.substring(iIndexOf));
        }
        PrintWriter printWriter2 = null;
        try {
            FileUtils.makeDirsForFile(file);
            printWriter = new PrintWriter(file, "UTF-8");
        } catch (Exception e) {
            printWriter = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            printWriter.println(this.code);
            printWriter.close();
        } catch (Exception e2) {
            if (printWriter != null) {
                printWriter.close();
            }
        } catch (Throwable th2) {
            printWriter2 = printWriter;
            th = th2;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th;
        }
    }

    public void save(File file, String str) throws Throwable {
        save(new File(file, str));
    }

    public void save(File file, String str, String str2) throws Throwable {
        save(file, new File(str, str2).getPath());
    }

    public CodeWriter startLine() {
        addLine();
        addLineIndent();
        return this;
    }

    public CodeWriter startLine(char c) {
        addLine();
        addLineIndent();
        add(c);
        return this;
    }

    public CodeWriter startLine(String str) {
        addLine();
        addLineIndent();
        add(str);
        return this;
    }

    public CodeWriter startLineWithNum(int i) {
        if (i == 0) {
            startLine();
        } else {
            startLine();
            attachSourceLine(i);
        }
        return this;
    }

    public String toString() {
        return this.buf == null ? this.code : this.buf.toString();
    }
}
