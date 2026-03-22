package jadx.core.dex.attributes.annotations;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.utils.Utils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AnnotationsList implements IAttribute {
    public static final AnnotationsList EMPTY = new AnnotationsList(Collections.emptyList());
    private final Map map;

    public AnnotationsList(List list) {
        this.map = new HashMap(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Annotation annotation = (Annotation) it.next();
            this.map.put(annotation.getAnnotationClass(), annotation);
        }
    }

    public Annotation get(String str) {
        return (Annotation) this.map.get(str);
    }

    public Collection getAll() {
        return this.map.values();
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.ANNOTATION_LIST;
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public int size() {
        return this.map.size();
    }

    public String toString() {
        return Utils.listToString(this.map.values());
    }
}
