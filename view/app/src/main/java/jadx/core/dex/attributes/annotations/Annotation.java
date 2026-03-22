package jadx.core.dex.attributes.annotations;

import jadx.core.dex.instructions.args.ArgType;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Annotation {
    private final ArgType atype;
    private final Map values;
    private final Visibility visibility;

    public enum Visibility {
        BUILD,
        RUNTIME,
        SYSTEM
    }

    public Annotation(Visibility visibility, ArgType argType, Map map) {
        this.visibility = visibility;
        this.atype = argType;
        this.values = map;
    }

    public String getAnnotationClass() {
        return this.atype.getObject();
    }

    public Object getDefaultValue() {
        return this.values.get("value");
    }

    public ArgType getType() {
        return this.atype;
    }

    public Map getValues() {
        return this.values;
    }

    public Visibility getVisibility() {
        return this.visibility;
    }

    public String toString() {
        return "Annotation[" + this.visibility + ", " + this.atype + ", " + this.values + "]";
    }
}
