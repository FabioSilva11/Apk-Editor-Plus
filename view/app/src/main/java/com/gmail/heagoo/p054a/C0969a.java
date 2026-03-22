package com.gmail.heagoo.p054a;

import android.support.v4.view.InputDeviceCompat;
import com.gmail.heagoo.p054a.p055a.p056a.p057a.XmlResourceParserC0970a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Formatter;

/* JADX INFO: renamed from: com.gmail.heagoo.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0969a {

    /* JADX INFO: renamed from: b */
    private static final float[] f2430b = {0.00390625f, 3.051758E-5f, 1.192093E-7f, 4.656613E-10f};

    /* JADX INFO: renamed from: c */
    private static final String[] f2431c = {"px", "dip", "sp", "pt", "in", "mm", "", ""};

    /* JADX INFO: renamed from: d */
    private static final String[] f2432d = {"%", "%p", "", "", "", "", "", ""};

    /* JADX INFO: renamed from: a */
    private StringBuffer f2433a = new StringBuffer();

    /* JADX INFO: renamed from: a */
    private static float m2117a(int i) {
        return (i & InputDeviceCompat.SOURCE_ANY) * f2430b[(i >> 4) & 3];
    }

    /* JADX INFO: renamed from: a */
    private static String m2118a(String str) {
        return (str == null || str.length() == 0) ? "" : str + ":";
    }

    /* JADX INFO: renamed from: a */
    private void m2119a(String str, Object... objArr) {
        Formatter formatter = new Formatter();
        formatter.format(str, objArr);
        this.f2433a.append(formatter.toString() + "\n");
    }

    /* JADX INFO: renamed from: a */
    public final boolean m2120a(InputStream inputStream, OutputStream outputStream) {
        try {
            XmlResourceParserC0970a xmlResourceParserC0970a = new XmlResourceParserC0970a();
            xmlResourceParserC0970a.m2126a(inputStream);
            StringBuilder sb = new StringBuilder(10);
            while (true) {
                int next = xmlResourceParserC0970a.next();
                if (next == 1) {
                    String string = this.f2433a.toString();
                    OutputStreamWriter outputStreamWriter = null;
                    try {
                        outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    try {
                        try {
                            outputStreamWriter.write(string);
                            try {
                                outputStreamWriter.close();
                                outputStream.close();
                            } catch (IOException e2) {
                                throw new Error(e2);
                            }
                        } catch (Throwable th) {
                            try {
                                outputStreamWriter.close();
                                outputStream.close();
                                throw th;
                            } catch (IOException e3) {
                                throw new Error(e3);
                            }
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        try {
                            outputStreamWriter.close();
                            outputStream.close();
                        } catch (IOException e5) {
                            throw new Error(e5);
                        }
                    }
                    return true;
                }
                switch (next) {
                    case 0:
                        m2119a("<?xml version=\"1.0\" encoding=\"utf-8\"?>", new Object[0]);
                        break;
                    case 2:
                        m2119a("%s<%s%s", sb, m2118a(xmlResourceParserC0970a.getPrefix()), xmlResourceParserC0970a.getName());
                        sb.append("\t");
                        int namespaceCount = xmlResourceParserC0970a.getNamespaceCount(xmlResourceParserC0970a.getDepth());
                        for (int namespaceCount2 = xmlResourceParserC0970a.getNamespaceCount(xmlResourceParserC0970a.getDepth() - 1); namespaceCount2 != namespaceCount; namespaceCount2++) {
                            m2119a("%sxmlns:%s=\"%s\"", sb, xmlResourceParserC0970a.getNamespacePrefix(namespaceCount2), xmlResourceParserC0970a.getNamespaceUri(namespaceCount2));
                        }
                        for (int i = 0; i != xmlResourceParserC0970a.getAttributeCount(); i++) {
                            Object[] objArr = new Object[4];
                            objArr[0] = sb;
                            objArr[1] = m2118a(xmlResourceParserC0970a.getAttributePrefix(i));
                            objArr[2] = xmlResourceParserC0970a.getAttributeName(i);
                            int iM2125a = xmlResourceParserC0970a.m2125a(i);
                            int iM2127b = xmlResourceParserC0970a.m2127b(i);
                            objArr[3] = iM2125a == 3 ? xmlResourceParserC0970a.getAttributeValue(i) : iM2125a == 2 ? String.format("?%08X", Integer.valueOf(iM2127b)) : iM2125a == 1 ? iM2127b == 0 ? "@null" : String.format("@%08X", Integer.valueOf(iM2127b)) : iM2125a == 4 ? String.valueOf(Float.intBitsToFloat(iM2127b)) : iM2125a == 17 ? String.format("0x%08X", Integer.valueOf(iM2127b)) : iM2125a == 18 ? iM2127b != 0 ? "true" : "false" : iM2125a == 5 ? Float.toString(m2117a(iM2127b)) + f2431c[iM2127b & 15] : iM2125a == 6 ? Float.toString(m2117a(iM2127b)) + f2432d[iM2127b & 15] : (iM2125a < 28 || iM2125a > 31) ? (iM2125a < 16 || iM2125a > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(iM2127b), Integer.valueOf(iM2125a)) : String.valueOf(iM2127b) : String.format("#%08X", Integer.valueOf(iM2127b));
                            m2119a("%s%s%s=\"%s\"", objArr);
                        }
                        m2119a("%s>", sb);
                        break;
                    case 3:
                        sb.setLength(sb.length() - 1);
                        m2119a("%s</%s%s>", sb, m2118a(xmlResourceParserC0970a.getPrefix()), xmlResourceParserC0970a.getName());
                        break;
                    case 4:
                        m2119a("%s%s", sb, xmlResourceParserC0970a.getText());
                        break;
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }
}
