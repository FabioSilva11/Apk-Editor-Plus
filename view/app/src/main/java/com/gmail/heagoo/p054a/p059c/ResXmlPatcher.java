package com.gmail.heagoo.p054a.p059c;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes.dex */
public final class ResXmlPatcher {
    /* JADX INFO: renamed from: a */
    public static String m2165a(File file, String str) {
        if (str == null || !str.contains("@")) {
            return (String) null;
        }
        File file2 = new File(file, "/res/values/strings.xml");
        String strReplace = str.replace("@string/", "");
        if (file2.exists()) {
            try {
                Object objEvaluate = XPathFactory.newInstance().newXPath().compile(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("/resources/string[@name=").append('\"').toString()).append(strReplace).toString()).append("\"]/text()").toString()).evaluate(m2167b(file2), XPathConstants.STRING);
                if (objEvaluate != null) {
                    return (String) objEvaluate;
                }
            } catch (IOException e) {
            } catch (ParserConfigurationException e2) {
            } catch (XPathExpressionException e3) {
            } catch (SAXException e4) {
            }
        }
        return (String) null;
    }

    /* JADX INFO: renamed from: a */
    public static void m2166a(File file) {
        String strM2165a;
        boolean z = false;
        String strM2311e = C0986ax.m2311e(file);
        String strM2308a = C0986ax.m2308a(strM2311e);
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile(new StringBuffer().append(new StringBuffer().append("<provider([^>]+?)").append(strM2308a).toString()).append(":authorities=\"@string/([^\"]+)\"").toString()).matcher(strM2311e);
        while (matcher.find()) {
            String strM2165a2 = m2165a(file.getParentFile(), new StringBuffer().append("@string/").append(matcher.group(2)).toString());
            if (strM2165a2 != null) {
                if (!z) {
                    z = true;
                }
                matcher.appendReplacement(stringBuffer, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<provider").append(matcher.group(1)).toString()).append("").toString()).append(strM2308a).toString()).append(":authorities=\"").toString()).append(strM2165a2).toString()).append("\"").toString());
            }
        }
        matcher.appendTail(stringBuffer);
        StringBuffer stringBuffer2 = new StringBuffer();
        Matcher matcher2 = Pattern.compile(new StringBuffer().append(new StringBuffer().append("<data([^>]+?)").append(strM2308a).toString()).append(":scheme=\"@string/([^\"]+)\"").toString()).matcher(stringBuffer.toString());
        if (matcher2.find() && (strM2165a = m2165a(file.getParentFile(), new StringBuffer().append("@string/").append(matcher2.group(2)).toString())) != null) {
            if (!z) {
                z = true;
            }
            matcher2.appendReplacement(stringBuffer2, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<data").append(matcher2.group(1)).toString()).append("").toString()).append(strM2308a).toString()).append(":scheme=\"").toString()).append(strM2165a).toString()).append("\"").toString());
        }
        matcher2.appendTail(stringBuffer2);
        if (z) {
            C0986ax.m2310b(file, stringBuffer2.toString());
        }
    }

    /* JADX INFO: renamed from: b */
    private static Document m2167b(File file) throws ParserConfigurationException, IOException {
        DocumentBuilder documentBuilderNewDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return documentBuilderNewDocumentBuilder.parse(fileInputStream);
        } finally {
            fileInputStream.close();
        }
    }
}
