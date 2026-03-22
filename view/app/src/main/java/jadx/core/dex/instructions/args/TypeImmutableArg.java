package jadx.core.dex.instructions.args;

/* JADX INFO: loaded from: classes.dex */
public class TypeImmutableArg extends RegisterArg {
    private boolean isThis;

    public TypeImmutableArg(int i, ArgType argType) {
        super(i, argType);
    }

    @Override // jadx.core.dex.instructions.args.RegisterArg
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TypeImmutableArg) && super.equals(obj) && this.isThis == ((TypeImmutableArg) obj).isThis;
    }

    @Override // jadx.core.dex.instructions.args.RegisterArg, jadx.core.dex.instructions.args.Named
    public String getName() {
        return this.isThis ? "this" : super.getName();
    }

    @Override // jadx.core.dex.instructions.args.RegisterArg
    public int hashCode() {
        return (this.isThis ? 1 : 0) + (super.hashCode() * 31);
    }

    @Override // jadx.core.dex.instructions.args.RegisterArg, jadx.core.dex.instructions.args.InsnArg
    public boolean isThis() {
        return this.isThis;
    }

    @Override // jadx.core.dex.instructions.args.Typed
    public boolean isTypeImmutable() {
        return true;
    }

    public void markAsThis() {
        this.isThis = true;
    }

    @Override // jadx.core.dex.instructions.args.RegisterArg
    void setSVar(SSAVar sSAVar) {
        if (this.isThis) {
            sSAVar.setName("this");
        }
        sSAVar.setTypeImmutable(this.type);
        super.setSVar(sSAVar);
    }

    @Override // jadx.core.dex.instructions.args.RegisterArg, jadx.core.dex.instructions.args.Typed
    public void setType(ArgType argType) {
    }
}
