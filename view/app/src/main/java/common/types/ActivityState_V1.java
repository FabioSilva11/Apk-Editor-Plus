package common.types;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ActivityState_V1 implements Serializable {
    private Map stringValues = new HashMap();
    private Map objValues = new HashMap();
    private Map intValues = new HashMap();
    private Map boolValues = new HashMap();

    public String getString(String str) {
        return (String) this.stringValues.get(str);
    }

    public void putBoolean(String str, boolean z) {
        this.boolValues.put(str, Boolean.valueOf(z));
    }

    public void putInt(String str, int i) {
        this.intValues.put(str, Integer.valueOf(i));
    }

    public void putSerializable(String str, Serializable serializable) {
        this.objValues.put(str, serializable);
    }

    public void putString(String str, String str2) {
        this.stringValues.put(str, str2);
    }

    public void toBundle(Bundle bundle) {
        for (Map.Entry entry : this.stringValues.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        for (Map.Entry entry2 : this.intValues.entrySet()) {
            bundle.putInt((String) entry2.getKey(), ((Integer) entry2.getValue()).intValue());
        }
        for (Map.Entry entry3 : this.boolValues.entrySet()) {
            bundle.putBoolean((String) entry3.getKey(), ((Boolean) entry3.getValue()).booleanValue());
        }
        for (Map.Entry entry4 : this.objValues.entrySet()) {
            bundle.putSerializable((String) entry4.getKey(), (Serializable) entry4.getValue());
        }
    }
}
