package jadx.core.dex.attributes;

import jadx.core.dex.attributes.annotations.Annotation;
import jadx.core.dex.attributes.annotations.AnnotationsList;
import jadx.core.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AttributeStorage {
    private final Set flags = EnumSet.noneOf(AFlag.class);
    private final Map attributes = new IdentityHashMap();

    public void add(AFlag aFlag) {
        this.flags.add(aFlag);
    }

    public void add(AType aType, Object obj) {
        AttrList attrList = (AttrList) get(aType);
        if (attrList == null) {
            attrList = new AttrList(aType);
            add(attrList);
        }
        attrList.getList().add(obj);
    }

    public void add(IAttribute iAttribute) {
        this.attributes.put(iAttribute.getType(), iAttribute);
    }

    public void addAll(AttributeStorage attributeStorage) {
        this.flags.addAll(attributeStorage.flags);
        this.attributes.putAll(attributeStorage.attributes);
    }

    public void clear() {
        this.flags.clear();
        this.attributes.clear();
    }

    public boolean contains(AFlag aFlag) {
        return this.flags.contains(aFlag);
    }

    public boolean contains(AType aType) {
        return this.attributes.containsKey(aType);
    }

    public IAttribute get(AType aType) {
        return (IAttribute) this.attributes.get(aType);
    }

    public List getAll(AType aType) {
        AttrList attrList = (AttrList) get(aType);
        return attrList == null ? Collections.emptyList() : Collections.unmodifiableList(attrList.getList());
    }

    public Annotation getAnnotation(String str) {
        AnnotationsList annotationsList = (AnnotationsList) get(AType.ANNOTATION_LIST);
        if (annotationsList == null) {
            return null;
        }
        return annotationsList.get(str);
    }

    public List getAttributeStrings() {
        int size = this.flags.size() + this.attributes.size() + this.attributes.size();
        if (size == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator it = this.flags.iterator();
        while (it.hasNext()) {
            arrayList.add(((AFlag) it.next()).toString());
        }
        Iterator it2 = this.attributes.values().iterator();
        while (it2.hasNext()) {
            arrayList.add(((IAttribute) it2.next()).toString());
        }
        return arrayList;
    }

    public boolean isEmpty() {
        return this.flags.isEmpty() && this.attributes.isEmpty();
    }

    public void remove(AFlag aFlag) {
        this.flags.remove(aFlag);
    }

    public void remove(AType aType) {
        this.attributes.remove(aType);
    }

    public void remove(IAttribute iAttribute) {
        AType type = iAttribute.getType();
        if (((IAttribute) this.attributes.get(type)) == iAttribute) {
            this.attributes.remove(type);
        }
    }

    public String toString() {
        List attributeStrings = getAttributeStrings();
        return attributeStrings.isEmpty() ? "" : "A:{" + Utils.listToString(attributeStrings) + "}";
    }
}
