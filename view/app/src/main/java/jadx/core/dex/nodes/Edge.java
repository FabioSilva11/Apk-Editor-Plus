package jadx.core.dex.nodes;

/* JADX INFO: loaded from: classes.dex */
public class Edge {
    private final BlockNode source;
    private final BlockNode target;

    public Edge(BlockNode blockNode, BlockNode blockNode2) {
        this.source = blockNode;
        this.target = blockNode2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Edge edge = (Edge) obj;
        return this.source.equals(edge.source) && this.target.equals(edge.target);
    }

    public BlockNode getSource() {
        return this.source;
    }

    public BlockNode getTarget() {
        return this.target;
    }

    public int hashCode() {
        return this.source.hashCode() + (this.target.hashCode() * 31);
    }

    public String toString() {
        return "Edge: " + this.source + " -> " + this.target;
    }
}
