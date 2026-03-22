package jadx.core.clsp;

/* JADX INFO: loaded from: classes.dex */
public class NClass {

    /* JADX INFO: renamed from: id */
    private int f4684id;
    private final String name;
    private NClass[] parents;

    public NClass(String str, int i) {
        this.name = str;
        this.f4684id = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.name.equals(((NClass) obj).name);
    }

    public int getId() {
        return this.f4684id;
    }

    public String getName() {
        return this.name;
    }

    public NClass[] getParents() {
        return this.parents;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public void setId(int i) {
        this.f4684id = i;
    }

    public void setParents(NClass[] nClassArr) {
        this.parents = nClassArr;
    }

    public String toString() {
        return this.name;
    }
}
