package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.utils.Utils;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DeclareVariablesAttr implements IAttribute {
    private final List vars = new LinkedList();

    public void addVar(RegisterArg registerArg) {
        this.vars.add(registerArg);
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.DECLARE_VARIABLES;
    }

    public Iterable getVars() {
        return this.vars;
    }

    public String toString() {
        return "DECL_VAR: " + Utils.listToString(this.vars);
    }
}
