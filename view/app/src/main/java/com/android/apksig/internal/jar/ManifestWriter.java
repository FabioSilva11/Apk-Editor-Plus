package com.android.apksig.internal.jar;

import com.gmail.heagoo.neweditor.Token;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.jar.Attributes;

/* JADX INFO: loaded from: classes.dex */
public abstract class ManifestWriter {
    public static final byte[] CRLF = {Token.LITERAL1, 10};

    public static SortedMap<String, String> getAttributesSortedByName(Attributes attributes) {
        Set<Map.Entry<Object, Object>> setEntrySet = attributes.entrySet();
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<Object, Object> entry : setEntrySet) {
            treeMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return treeMap;
    }

    public static void writeAttribute(OutputStream outputStream, String str, String str2) throws IOException {
        writeLine(outputStream, str + ": " + str2);
    }

    public static void writeAttribute(OutputStream outputStream, Attributes.Name name, String str) throws IOException {
        writeAttribute(outputStream, name.toString(), str);
    }

    public static void writeAttributes(OutputStream outputStream, SortedMap<String, String> sortedMap) throws IOException {
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            writeAttribute(outputStream, entry.getKey(), entry.getValue());
        }
    }

    public static void writeIndividualSection(OutputStream outputStream, String str, Attributes attributes) throws IOException {
        writeAttribute(outputStream, "Name", str);
        if (!attributes.isEmpty()) {
            writeAttributes(outputStream, getAttributesSortedByName(attributes));
        }
        writeSectionDelimiter(outputStream);
    }

    public static void writeLine(OutputStream outputStream, String str) throws IOException {
        int iMin;
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        int length = bytes.length;
        boolean z = true;
        int i = 0;
        while (length > 0) {
            if (z) {
                iMin = Math.min(length, 70);
            } else {
                outputStream.write(CRLF);
                outputStream.write(32);
                iMin = Math.min(length, 69);
            }
            outputStream.write(bytes, i, iMin);
            i += iMin;
            length -= iMin;
            z = false;
        }
        outputStream.write(CRLF);
    }

    public static void writeMainSection(OutputStream outputStream, Attributes attributes) throws IOException {
        String value = attributes.getValue(Attributes.Name.MANIFEST_VERSION);
        if (value == null) {
            throw new IllegalArgumentException("Mandatory " + Attributes.Name.MANIFEST_VERSION + " attribute missing");
        }
        writeAttribute(outputStream, Attributes.Name.MANIFEST_VERSION, value);
        if (attributes.size() > 1) {
            SortedMap<String, String> attributesSortedByName = getAttributesSortedByName(attributes);
            attributesSortedByName.remove(Attributes.Name.MANIFEST_VERSION.toString());
            writeAttributes(outputStream, attributesSortedByName);
        }
        writeSectionDelimiter(outputStream);
    }

    public static void writeSectionDelimiter(OutputStream outputStream) throws IOException {
        outputStream.write(CRLF);
    }
}
