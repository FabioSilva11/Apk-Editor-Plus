package jadx.core.xmlgen.entry;

/* JADX INFO: loaded from: classes.dex */
public final class RawValue {
    private final int data;
    private final int dataType;

    public RawValue(int i, int i2) {
        this.dataType = i;
        this.data = i2;
    }

    public final int getData() {
        return this.data;
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final String toString() {
        return "RawValue: type=0x" + Integer.toHexString(this.dataType) + ", value=" + this.data;
    }
}
