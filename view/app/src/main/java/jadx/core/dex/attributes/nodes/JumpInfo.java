package jadx.core.dex.attributes.nodes;

import jadx.core.utils.InsnUtils;

/* JADX INFO: loaded from: classes.dex */
public class JumpInfo {
    private final int dest;
    private final int src;

    public JumpInfo(int i, int i2) {
        this.src = i;
        this.dest = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            JumpInfo jumpInfo = (JumpInfo) obj;
            return this.dest == jumpInfo.dest && this.src == jumpInfo.src;
        }
        return false;
    }

    public int getDest() {
        return this.dest;
    }

    public int getSrc() {
        return this.src;
    }

    public int hashCode() {
        return (this.dest * 31) + this.src;
    }

    public String toString() {
        return "JUMP: " + InsnUtils.formatOffset(this.src) + " -> " + InsnUtils.formatOffset(this.dest);
    }
}
