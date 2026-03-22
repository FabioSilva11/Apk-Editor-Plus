package jadx.core.dex.instructions.args;

/* JADX INFO: loaded from: classes.dex */
public enum PrimitiveType {
    BOOLEAN("Z", "boolean"),
    CHAR("C", "char"),
    BYTE("B", "byte"),
    SHORT("S", "short"),
    INT("I", "int"),
    FLOAT("F", "float"),
    LONG("J", "long"),
    DOUBLE("D", "double"),
    OBJECT("L", "OBJECT"),
    ARRAY("[", "ARRAY"),
    VOID("V", "void");

    private final String longName;
    private final String shortName;

    PrimitiveType(String str, String str2) {
        this.shortName = str;
        this.longName = str2;
    }

    public static PrimitiveType getSmaller(PrimitiveType primitiveType, PrimitiveType primitiveType2) {
        return primitiveType.ordinal() < primitiveType2.ordinal() ? primitiveType : primitiveType2;
    }

    public static PrimitiveType getWidest(PrimitiveType primitiveType, PrimitiveType primitiveType2) {
        return primitiveType.ordinal() > primitiveType2.ordinal() ? primitiveType : primitiveType2;
    }

    public final String getLongName() {
        return this.longName;
    }

    public final String getShortName() {
        return this.shortName;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.longName;
    }
}
