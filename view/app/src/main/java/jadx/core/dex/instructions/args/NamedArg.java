package jadx.core.dex.instructions.args;

/* JADX INFO: loaded from: classes.dex */
public final class NamedArg extends InsnArg implements Named {
    private String name;

    public NamedArg(String str, ArgType argType) {
        this.name = str;
        this.type = argType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NamedArg) {
            return this.name.equals(((NamedArg) obj).name);
        }
        return false;
    }

    @Override // jadx.core.dex.instructions.args.Named
    public final String getName() {
        return this.name;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    @Override // jadx.core.dex.instructions.args.InsnArg
    public final boolean isNamed() {
        return true;
    }

    @Override // jadx.core.dex.instructions.args.Named
    public final void setName(String str) {
        this.name = str;
    }

    public final String toString() {
        return "(" + this.name + " " + this.type + ")";
    }
}
