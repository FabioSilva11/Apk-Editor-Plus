package jadx.core.dex.attributes.nodes;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.dex.nodes.FieldNode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class EnumMapAttr implements IAttribute {
    private final Map fieldsMap = new HashMap();

    public class KeyValueMap {
        private final Map map = new HashMap();

        public Object get(Object obj) {
            return this.map.get(obj);
        }

        void put(Object obj, Object obj2) {
            this.map.put(obj, obj2);
        }
    }

    public void add(FieldNode fieldNode, Object obj, Object obj2) {
        KeyValueMap map = getMap(fieldNode);
        if (map == null) {
            map = new KeyValueMap();
            this.fieldsMap.put(fieldNode, map);
        }
        map.put(obj, obj2);
    }

    public KeyValueMap getMap(FieldNode fieldNode) {
        return (KeyValueMap) this.fieldsMap.get(fieldNode);
    }

    @Override // jadx.core.dex.attributes.IAttribute
    public AType getType() {
        return AType.ENUM_MAP;
    }

    public String toString() {
        return "Enum fields map: " + this.fieldsMap;
    }
}
