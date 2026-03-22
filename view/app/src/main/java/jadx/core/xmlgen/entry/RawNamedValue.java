package jadx.core.xmlgen.entry;

/* JADX INFO: loaded from: classes.dex */
public class RawNamedValue {
    private final int nameRef;
    private final RawValue rawValue;

    public RawNamedValue(int i, RawValue rawValue) {
        this.nameRef = i;
        this.rawValue = rawValue;
    }

    public int getNameRef() {
        return this.nameRef;
    }

    public RawValue getRawValue() {
        return this.rawValue;
    }

    public String toString() {
        return "RawNamedValue{nameRef=" + this.nameRef + ", rawValue=" + this.rawValue + '}';
    }
}
