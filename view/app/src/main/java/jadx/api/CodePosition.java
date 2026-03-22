package jadx.api;

/* JADX INFO: loaded from: classes.dex */
public final class CodePosition {
    private final int line;
    private final JavaNode node;
    private final int offset;

    public CodePosition(int i, int i2) {
        this.node = null;
        this.line = i;
        this.offset = i2;
    }

    public CodePosition(JavaNode javaNode, int i, int i2) {
        this.node = javaNode;
        this.line = i;
        this.offset = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CodePosition codePosition = (CodePosition) obj;
        return this.line == codePosition.line && this.offset == codePosition.offset;
    }

    public final JavaClass getJavaClass() {
        JavaClass declaringClass = this.node.getDeclaringClass();
        return (declaringClass == null && (this.node instanceof JavaClass)) ? (JavaClass) this.node : declaringClass;
    }

    public final int getLine() {
        return this.line;
    }

    public final JavaNode getNode() {
        return this.node;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int hashCode() {
        return this.line + (this.offset * 31);
    }

    public final String toString() {
        return this.line + ":" + this.offset + (this.node != null ? " " + this.node : "");
    }
}
