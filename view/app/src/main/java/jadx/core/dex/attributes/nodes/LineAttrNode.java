package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AttrNode;

/* JADX INFO: loaded from: classes.dex */
public abstract class LineAttrNode extends AttrNode {
    private int decompiledLine;
    private int sourceLine;

    public void copyLines(LineAttrNode lineAttrNode) {
        setSourceLine(lineAttrNode.getSourceLine());
        setDecompiledLine(lineAttrNode.getDecompiledLine());
    }

    public int getDecompiledLine() {
        return this.decompiledLine;
    }

    public int getSourceLine() {
        return this.sourceLine;
    }

    public void setDecompiledLine(int i) {
        this.decompiledLine = i;
    }

    public void setSourceLine(int i) {
        this.sourceLine = i;
    }
}
