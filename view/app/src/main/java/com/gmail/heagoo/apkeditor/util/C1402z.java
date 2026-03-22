package com.gmail.heagoo.apkeditor.util;

import jadx.core.codegen.CodeWriter;
import jadx.core.deobf.Deobfuscator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.z */
/* JADX INFO: loaded from: classes.dex */
public final class C1402z {

    /* JADX INFO: renamed from: a */
    private BufferedReader f4074a;

    /* JADX INFO: renamed from: b */
    private BufferedWriter f4075b;

    /* JADX INFO: renamed from: c */
    private List f4076c = new ArrayList();

    /* JADX INFO: renamed from: d */
    private boolean f4077d = false;

    public C1402z(String str) {
        try {
            this.f4074a = new BufferedReader(new FileReader(str));
            String line = this.f4074a.readLine();
            while (line != null) {
                this.f4076c.add(line);
                line = this.f4074a.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: b */
    private String m3380b(String str) {
        int iIndexOf;
        int i = 0;
        if (str.startsWith("\"")) {
            if (str.endsWith("\"")) {
                return "<font color=\"blue\">" + m3381c(str) + "</font>";
            }
            this.f4077d = true;
            return "<font color=\"blue\">" + m3381c(str);
        }
        if (str.endsWith("\"")) {
            this.f4077d = false;
            return m3381c(str) + "</font>";
        }
        if (this.f4077d) {
            return m3381c(str);
        }
        if (str.startsWith("L") && (iIndexOf = str.indexOf(59)) != -1) {
            return "L<font color=\"red\">" + str.substring(1, iIndexOf) + "</font>;" + str.substring(iIndexOf + 1);
        }
        StringBuilder sb = new StringBuilder();
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '>') {
                sb.append("&gt;");
            } else if (cCharAt == '<') {
                sb.append("&lt;");
            } else if ((cCharAt == 'v' || cCharAt == 'p') && i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))) {
                sb.append("<font color=\"red\">");
                sb.append(cCharAt);
                sb.append(str.charAt(i + 1));
                i++;
                if (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))) {
                    sb.append(str.charAt(i + 1));
                    i++;
                }
                sb.append("</font>");
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: c */
    private static String m3381c(String str) {
        return str.replaceAll("<", "&lt;").replace(">", "&gt;");
    }

    /* JADX INFO: renamed from: a */
    public final void m3382a(String str) throws IOException {
        int i;
        this.f4075b = new BufferedWriter(new FileWriter(str));
        this.f4075b.write("<html>");
        this.f4075b.write("<head>");
        this.f4075b.write("<title>1.xml</title>");
        this.f4075b.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"viewsource.css\">");
        this.f4075b.write("</head>");
        this.f4075b.write("<body id=\"viewsource\" class=\"wrap\" style=\"-moz-tab-size: 4\">");
        this.f4075b.write("<pre id=\"line1\">" + ((String) this.f4076c.get(0)) + "\n");
        for (int i2 = 1; i2 < this.f4076c.size(); i2++) {
            String str2 = (String) this.f4076c.get(i2);
            if (str2.trim().isEmpty()) {
                this.f4075b.write("<span id=\"line" + (i2 + 1) + "\"></span>\n");
            } else {
                this.f4075b.write("<span id=\"line" + (i2 + 1) + "\">");
                String[] strArrSplit = str2.split("\\s+");
                if (strArrSplit[0].equals("")) {
                    this.f4075b.write(CodeWriter.INDENT);
                    i = 1;
                } else {
                    i = 0;
                }
                String str3 = strArrSplit[i];
                this.f4075b.write("<font color=\"" + (str3.startsWith(Deobfuscator.CLASS_NAME_SEPARATOR) ? "#FF3399" : str3.startsWith(":") ? "brown" : "green") + "\">");
                this.f4075b.write(strArrSplit[i]);
                this.f4075b.write("</font>");
                while (true) {
                    i++;
                    if (i >= strArrSplit.length) {
                        break;
                    }
                    this.f4075b.write(" ");
                    this.f4075b.write(m3380b(strArrSplit[i]));
                }
                this.f4075b.write("</span>\n");
            }
        }
        this.f4075b.write("</body>");
        this.f4075b.write("</html>");
        this.f4075b.close();
    }
}
