package jadx.core.xmlgen;

import jadx.core.utils.exceptions.JadxException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes.dex */
public class ManifestAttributes {
    private static final String ATTR_XML = "/android/attrs.xml";
    private static final InterfaceC1668b LOG = C1677c.m3845a(ManifestAttributes.class);
    private static final String MANIFEST_ATTR_XML = "/android/attrs_manifest.xml";
    private final Map attrMap = new HashMap();

    class MAttr {
        private final MAttrType type;
        private final Map values = new LinkedHashMap();

        public MAttr(MAttrType mAttrType) {
            this.type = mAttrType;
        }

        public MAttrType getType() {
            return this.type;
        }

        public Map getValues() {
            return this.values;
        }

        public String toString() {
            return "[" + this.type + ", " + this.values + "]";
        }
    }

    enum MAttrType {
        ENUM,
        FLAG
    }

    private Document loadXML(String str) throws IOException {
        InputStream inputStream = null;
        try {
            InputStream resourceAsStream = ManifestAttributes.class.getResourceAsStream(str);
            if (resourceAsStream == null) {
                throw new JadxException(str + " not found in classpath");
            }
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resourceAsStream);
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return document;
        } catch (Throwable th) {
            if (0 != 0) {
                inputStream.close();
            }
            throw th;
        }
    }

    private void parse(Document document) {
        NodeList childNodes = document.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1 && nodeItem.hasChildNodes()) {
                parseAttrList(nodeItem.getChildNodes());
            }
        }
    }

    private void parseAttrList(NodeList nodeList) {
        String nodeValue;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodeItem = nodeList.item(i);
            if (nodeItem.getNodeType() == 1 && nodeItem.hasAttributes() && nodeItem.hasChildNodes()) {
                NamedNodeMap attributes = nodeItem.getAttributes();
                int i2 = 0;
                while (true) {
                    if (i2 >= attributes.getLength()) {
                        nodeValue = null;
                        break;
                    }
                    Node nodeItem2 = attributes.item(i2);
                    if (nodeItem2.getNodeName().equals("name")) {
                        nodeValue = nodeItem2.getNodeValue();
                        break;
                    }
                    i2++;
                }
                if (nodeValue == null || !nodeItem.getNodeName().equals("attr")) {
                    parseAttrList(nodeItem.getChildNodes());
                } else {
                    parseValues(nodeValue, nodeItem.getChildNodes());
                }
            }
        }
    }

    private void parseValues(String str, NodeList nodeList) {
        Node namedItem;
        MAttr mAttr = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodeItem = nodeList.item(i);
            if (nodeItem.getNodeType() == 1 && nodeItem.hasAttributes()) {
                if (mAttr == null) {
                    if (nodeItem.getNodeName().equals("enum")) {
                        mAttr = new MAttr(MAttrType.ENUM);
                    } else if (nodeItem.getNodeName().equals("flag")) {
                        mAttr = new MAttr(MAttrType.FLAG);
                    }
                    if (mAttr == null) {
                        return;
                    } else {
                        this.attrMap.put(str, mAttr);
                    }
                }
                NamedNodeMap attributes = nodeItem.getAttributes();
                Node namedItem2 = attributes.getNamedItem("name");
                if (namedItem2 != null && (namedItem = attributes.getNamedItem("value")) != null) {
                    try {
                        String nodeValue = namedItem.getNodeValue();
                        mAttr.getValues().put(Long.valueOf(nodeValue.startsWith("0x") ? Long.parseLong(nodeValue.substring(2), 16) : Long.parseLong(nodeValue)), namedItem2.getNodeValue());
                    } catch (NumberFormatException e) {
                        LOG.mo3817a("Failed parse manifest number", (Throwable) e);
                    }
                }
            }
        }
    }

    public String decode(String str, long j) {
        MAttr mAttr = (MAttr) this.attrMap.get(str);
        if (mAttr == null) {
            return null;
        }
        if (mAttr.getType() == MAttrType.ENUM) {
            String str2 = (String) mAttr.getValues().get(Long.valueOf(j));
            if (str2 != null) {
                return str2;
            }
        } else if (mAttr.getType() == MAttrType.FLAG) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : mAttr.getValues().entrySet()) {
                if ((((Long) entry.getKey()).longValue() & j) != 0) {
                    sb.append((String) entry.getValue()).append('|');
                }
            }
            if (sb.length() != 0) {
                return sb.deleteCharAt(sb.length() - 1).toString();
            }
        }
        return "UNKNOWN_DATA_0x" + Long.toHexString(j);
    }

    public void parseAll() {
        parse(loadXML(ATTR_XML));
        parse(loadXML(MANIFEST_ATTR_XML));
        LOG.mo3815a("Loaded android attributes count: {}", Integer.valueOf(this.attrMap.size()));
    }
}
