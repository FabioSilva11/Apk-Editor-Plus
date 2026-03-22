package jadx.core.dex.attributes;

import jadx.core.dex.attributes.annotations.Annotation;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class AttrNode implements IAttributeNode {
    private static final AttributeStorage EMPTY_ATTR_STORAGE = new EmptyAttrStorage();
    private AttributeStorage storage = EMPTY_ATTR_STORAGE;

    private AttributeStorage initStorage() {
        AttributeStorage attributeStorage = this.storage;
        if (attributeStorage != EMPTY_ATTR_STORAGE) {
            return attributeStorage;
        }
        AttributeStorage attributeStorage2 = new AttributeStorage();
        this.storage = attributeStorage2;
        return attributeStorage2;
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public void add(AFlag aFlag) {
        initStorage().add(aFlag);
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public void addAttr(AType aType, Object obj) {
        initStorage().add(aType, obj);
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public void addAttr(IAttribute iAttribute) {
        initStorage().add(iAttribute);
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public void clearAttributes() {
        this.storage.clear();
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public boolean contains(AFlag aFlag) {
        return this.storage.contains(aFlag);
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public boolean contains(AType aType) {
        return this.storage.contains(aType);
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public void copyAttributesFrom(AttrNode attrNode) {
        AttributeStorage attributeStorage = attrNode.storage;
        if (attributeStorage.isEmpty()) {
            return;
        }
        initStorage().addAll(attributeStorage);
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public IAttribute get(AType aType) {
        return this.storage.get(aType);
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public List getAll(AType aType) {
        return this.storage.getAll(aType);
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public Annotation getAnnotation(String str) {
        return this.storage.getAnnotation(str);
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public String getAttributesString() {
        return this.storage.toString();
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public List getAttributesStringsList() {
        return this.storage.getAttributeStrings();
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public void remove(AFlag aFlag) {
        this.storage.remove(aFlag);
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public void remove(AType aType) {
        this.storage.remove(aType);
    }

    @Override // jadx.core.dex.attributes.IAttributeNode
    public void removeAttr(IAttribute iAttribute) {
        this.storage.remove(iAttribute);
    }
}
