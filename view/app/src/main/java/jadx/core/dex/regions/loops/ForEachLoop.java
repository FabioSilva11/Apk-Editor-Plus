package jadx.core.dex.regions.loops;

import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.RegisterArg;

/* JADX INFO: loaded from: classes.dex */
public final class ForEachLoop extends LoopType {
    private final InsnArg iterableArg;
    private final RegisterArg varArg;

    public ForEachLoop(RegisterArg registerArg, InsnArg insnArg) {
        this.varArg = registerArg;
        this.iterableArg = insnArg;
    }

    public final InsnArg getIterableArg() {
        return this.iterableArg;
    }

    public final RegisterArg getVarArg() {
        return this.varArg;
    }
}
