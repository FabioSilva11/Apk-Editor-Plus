package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.utils.Utils;

/* JADX INFO: loaded from: classes.dex */
public class JadxErrorAttr implements IAttribute {
    private final Throwable cause;

    public JadxErrorAttr(Throwable th) {
        this.cause = th;
    }

    public Throwable getCause() {
        return this.cause;
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.JADX_ERROR;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JadxError: ");
        if (this.cause == null) {
            sb.append("null");
        } else {
            sb.append(this.cause.getClass());
            sb.append(":");
            sb.append(this.cause.getMessage());
            sb.append("\n");
            sb.append(Utils.getStackTrace(this.cause));
        }
        return sb.toString();
    }
}
