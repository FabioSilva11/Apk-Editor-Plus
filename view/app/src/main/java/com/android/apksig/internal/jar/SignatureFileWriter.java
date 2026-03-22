package com.android.apksig.internal.jar;

import java.io.IOException;
import java.io.OutputStream;
import java.util.SortedMap;
import java.util.jar.Attributes;

/* JADX INFO: loaded from: classes.dex */
public abstract class SignatureFileWriter {
    public static void writeIndividualSection(OutputStream outputStream, String str, Attributes attributes) throws IOException {
        ManifestWriter.writeIndividualSection(outputStream, str, attributes);
    }

    public static void writeMainSection(OutputStream outputStream, Attributes attributes) throws IOException {
        String value = attributes.getValue(Attributes.Name.SIGNATURE_VERSION);
        if (value == null) {
            throw new IllegalArgumentException("Mandatory " + Attributes.Name.SIGNATURE_VERSION + " attribute missing");
        }
        ManifestWriter.writeAttribute(outputStream, Attributes.Name.SIGNATURE_VERSION, value);
        if (attributes.size() > 1) {
            SortedMap<String, String> attributesSortedByName = ManifestWriter.getAttributesSortedByName(attributes);
            attributesSortedByName.remove(Attributes.Name.SIGNATURE_VERSION.toString());
            ManifestWriter.writeAttributes(outputStream, attributesSortedByName);
        }
        writeSectionDelimiter(outputStream);
    }

    public static void writeSectionDelimiter(OutputStream outputStream) throws IOException {
        ManifestWriter.writeSectionDelimiter(outputStream);
    }
}
