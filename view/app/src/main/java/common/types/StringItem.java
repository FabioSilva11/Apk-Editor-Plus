package common.types;

import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class StringItem implements Serializable {
    private static final long serialVersionUID = -3234844926022744481L;
    public String name;
    public String styledValue;
    public String value;

    public StringItem(String str, String str2) {
        this(str, str2, null);
    }

    public StringItem(String str, String str2, String str3) {
        this.name = str;
        this.value = str2;
        this.styledValue = str3;
    }

    public static String toString(String str, String str2, String str3) {
        boolean z = C0985a.m2266d(str2);
        if (!str2.startsWith("@string/") && !str2.startsWith("@android:string/")) {
            str2 = str3 == null ? C0985a.m2254c(C0985a.m2198a(str2)) : C0985a.m2254c(str3);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<string name=\"");
        sb.append(str);
        if (z) {
            sb.append(" formatted=\"false\"");
        }
        sb.append("\">");
        sb.append(str2);
        sb.append("</string>");
        return sb.toString();
    }

    public String toString() {
        return toString(this.name, this.value, this.styledValue);
    }
}
