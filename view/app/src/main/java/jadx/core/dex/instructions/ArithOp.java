package jadx.core.dex.instructions;

/* JADX INFO: loaded from: classes.dex */
public enum ArithOp {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/"),
    REM("%"),
    AND("&"),
    OR("|"),
    XOR("^"),
    SHL("<<"),
    SHR(">>"),
    USHR(">>>");

    private final String symbol;

    ArithOp(String str) {
        this.symbol = str;
    }

    public final String getSymbol() {
        return this.symbol;
    }
}
