package jadx.core.dex.attributes;

import jadx.core.dex.attributes.annotations.Annotation;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IAttributeNode {
    void add(AFlag aFlag);

    void addAttr(AType aType, Object obj);

    void addAttr(IAttribute iAttribute);

    void clearAttributes();

    boolean contains(AFlag aFlag);

    boolean contains(AType aType);

    void copyAttributesFrom(AttrNode attrNode);

    IAttribute get(AType aType);

    List getAll(AType aType);

    Annotation getAnnotation(String str);

    String getAttributesString();

    List getAttributesStringsList();

    void remove(AFlag aFlag);

    void remove(AType aType);

    void removeAttr(IAttribute iAttribute);
}
