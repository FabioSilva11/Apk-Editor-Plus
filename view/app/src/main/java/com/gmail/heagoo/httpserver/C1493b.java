package com.gmail.heagoo.httpserver;

import com.gmail.heagoo.apkeditor.gzd;
import com.gmail.heagoo.common.C1491w;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p013b.p014a.p015a.AbstractC0377a;
import p013b.p014a.p015a.C0386j;
import p013b.p014a.p015a.EnumC0389m;
import p013b.p014a.p015a.InterfaceC0384h;

/* JADX INFO: renamed from: com.gmail.heagoo.httpserver.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1493b extends AbstractC0377a {

    /* JADX INFO: renamed from: b */
    private static final String[] f4333b = {"/listFiles", "/readFile", "/readImage", "/saveFile"};

    /* JADX INFO: renamed from: c */
    private String f4334c;

    /* JADX INFO: renamed from: d */
    private String f4335d;

    /* JADX INFO: renamed from: e */
    private String f4336e;

    public C1493b(String str, String str2) {
        super(8000);
        this.f4336e = null;
        this.f4334c = str;
        this.f4335d = str2;
    }

    /* JADX INFO: renamed from: a */
    private C0386j m3541a(Map map) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        String str = (String) map.get("path");
        String str2 = (String) map.get(gzd.COLUMN_CONTENT);
        if (str != null && str2 != null) {
            File file = new File(this.f4335d + "/" + str);
            if (file.isFile() && file.exists()) {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    e = e;
                    fileOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    fileOutputStream.write(str2.getBytes());
                    fileOutputStream.close();
                    C0386j c0386jA = m239a(EnumC0389m.f304a, "text/html", "OK");
                    C0985a.m2212a(fileOutputStream);
                    return c0386jA;
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        e.printStackTrace();
                        C0985a.m2212a(fileOutputStream2);
                        return m3548l();
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        C0985a.m2212a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    C0985a.m2212a(fileOutputStream);
                    throw th;
                }
            }
        }
        return m3548l();
    }

    /* JADX INFO: renamed from: b */
    private C0386j m3542b(Map map) {
        String str = (String) map.get("path");
        File file = new File(this.f4335d + "/" + str);
        if (!file.exists() || !file.isFile()) {
            return m3548l();
        }
        try {
            return m238a(EnumC0389m.f304a, m3545c(str), new FileInputStream(file), r2.available());
        } catch (IOException e) {
            return m3548l();
        }
    }

    /* JADX INFO: renamed from: c */
    private C0386j m3544c(Map map) {
        String str = (String) map.get("path");
        File file = new File(this.f4335d + "/" + str);
        if (!file.exists() || !file.isFile()) {
            return m3548l();
        }
        String str2 = str.endsWith(".xml") ? "xml" : str.endsWith(".java") ? "java" : str.endsWith(".kt") ? "kotlin" : str.endsWith(".css") ? "css" : str.endsWith(".js") ? "javascript" : (str.endsWith(".htm") || str.endsWith(".html")) ? "html" : (str.endsWith(".txt") || str.endsWith(".md") || str.endsWith(".project") || str.endsWith(".gradle") || str.endsWith(".smali")) ? "text" : (str.endsWith(".c") || str.endsWith(".cpp")) ? "c_cpp" : str.endsWith(".py") ? "python" : null;
        if (str2 == null) {
            if (str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".jpeg") || str.endsWith(".gif") || str.endsWith(".bmp")) {
                return m239a(EnumC0389m.f304a, "text/html", "<html>\n<head>\n<style type=\"text/css\">\nimg {\n    position: absolute;\n    margin: auto;\n    top: 0;\n    left: 0;\n    right: 0;\n    bottom: 0;\n}\n</style>\n</head>\n<body>\n<img src=\"readImage?path=" + str + "\">\n</body>\n</html>");
            }
            return m239a(EnumC0389m.f304a, "text/html", "<html>\n<head>\n<style type=\"text/css\">\n#tip {\n    position: absolute;\n    margin: auto;\n    top: 50%;\n    width: 100%;\n    height: 100px;\n    margin-top: -50px;\n}\n</style>\n</head>\n<body>\n<div id=\"tip\"><center>Cannot open " + str + "</center></div>\n</body>\n</html>");
        }
        if (this.f4336e == null) {
            try {
                this.f4336e = new C1491w(this.f4334c + "/editor.htm").m3537b();
            } catch (IOException e) {
                this.f4336e = "<html lang=\"en\">\n<head>\n  <meta charset=\"UTF-8\">\n  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n  <title>Editor</title>\n  <style type=\"text/css\" media=\"screen\">\n    body {\n        overflow: hidden;\n    }\n    #editor {\n        margin: 0;\n        position: absolute;\n        top: 0;\n        bottom: 0;\n        left: 0;\n        right: 0;\n    }\n  </style>\n</head>\n<body>\n<pre id=\"editor\">__CONTENT__</pre>\n<script src=\"src-min-noconflict/ace.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\n<script>\n    var editor = ace.edit(\"editor\");\n    editor.setTheme(\"ace/theme/dreamweaver\");\n    editor.session.setMode(\"ace/mode/__MODE__\");\n</script>\n</body>\n</html>";
            }
        }
        try {
            return m239a(EnumC0389m.f304a, "text/html", this.f4336e.replace("__MODE__", str2).replace("__PATH__", str).replace("__CONTENT__", new C1491w(file.getPath()).m3537b().replace("<", "&lt;")));
        } catch (IOException e2) {
            return m3548l();
        }
    }

    /* JADX INFO: renamed from: c */
    private static String m3545c(String str) {
        return (str.endsWith(".jpg") || str.endsWith(".jpeg")) ? "image/jpeg" : str.endsWith(".png") ? "image/png" : str.endsWith(".gif") ? "image/gif" : str.endsWith(".bmp") ? "image/bmp" : (str.endsWith(".htm") || str.endsWith(".html")) ? "text/html" : str.endsWith(".css") ? "text/css" : str.endsWith(".js") ? "text/javascript" : "text/plain";
    }

    /* JADX INFO: renamed from: d */
    private C0386j m3546d(Map map) {
        String str = (String) map.get("node");
        String str2 = str == null ? "" : str + "/";
        File file = new File(this.f4335d + "/" + str2);
        if (!file.exists() || !file.isDirectory()) {
            return m3548l();
        }
        List listAsList = Arrays.asList(file.listFiles());
        Collections.sort(listAsList, new C1492a());
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= listAsList.size()) {
                sb.append("]");
                return m239a(EnumC0389m.f304a, "application/json", sb.toString());
            }
            File file2 = (File) listAsList.get(i2);
            sb.append("{");
            sb.append("\"name\": \"" + file2.getName() + "\",");
            sb.append("\"id\": \"" + str2 + file2.getName() + "\",");
            if (file2.isDirectory()) {
                sb.append("\"load_on_demand\": true");
            } else {
                sb.append("\"load_on_demand\": false");
            }
            sb.append("}");
            if (i2 != listAsList.size() - 1) {
                sb.append(",");
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: d */
    private static boolean m3547d(String str) {
        String[] strArr = f4333b;
        for (int i = 0; i < 4; i++) {
            if (strArr[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: l */
    private static C0386j m3548l() {
        return m239a(EnumC0389m.f306c, "text/html", "Not Found!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX INFO: renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.net.InetAddress m3549m() throws java.net.UnknownHostException {
        /*
            r1 = 0
            java.util.Enumeration r2 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.lang.Exception -> L44
        L5:
            boolean r0 = r2.hasMoreElements()     // Catch: java.lang.Exception -> L44
            if (r0 == 0) goto L32
            java.lang.Object r0 = r2.nextElement()     // Catch: java.lang.Exception -> L44
            java.net.NetworkInterface r0 = (java.net.NetworkInterface) r0     // Catch: java.lang.Exception -> L44
            java.util.Enumeration r3 = r0.getInetAddresses()     // Catch: java.lang.Exception -> L44
        L15:
            boolean r0 = r3.hasMoreElements()     // Catch: java.lang.Exception -> L44
            if (r0 == 0) goto L5
            java.lang.Object r0 = r3.nextElement()     // Catch: java.lang.Exception -> L44
            java.net.InetAddress r0 = (java.net.InetAddress) r0     // Catch: java.lang.Exception -> L44
            boolean r4 = r0.isLoopbackAddress()     // Catch: java.lang.Exception -> L44
            if (r4 != 0) goto L5d
            boolean r4 = r0.isSiteLocalAddress()     // Catch: java.lang.Exception -> L44
            if (r4 == 0) goto L2e
        L2d:
            return r0
        L2e:
            if (r1 != 0) goto L5d
        L30:
            r1 = r0
            goto L15
        L32:
            if (r1 == 0) goto L36
            r0 = r1
            goto L2d
        L36:
            java.net.InetAddress r0 = java.net.InetAddress.getLocalHost()     // Catch: java.lang.Exception -> L44
            if (r0 != 0) goto L2d
            java.net.UnknownHostException r0 = new java.net.UnknownHostException     // Catch: java.lang.Exception -> L44
            java.lang.String r1 = "The JDK InetAddress.getLocalHost() method unexpectedly returned null."
            r0.<init>(r1)     // Catch: java.lang.Exception -> L44
            throw r0     // Catch: java.lang.Exception -> L44
        L44:
            r0 = move-exception
            java.net.UnknownHostException r1 = new java.net.UnknownHostException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to determine LAN address: "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r1.initCause(r0)
            throw r1
        L5d:
            r0 = r1
            goto L30
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.httpserver.C1493b.m3549m():java.net.InetAddress");
    }

    @Override // p013b.p014a.p015a.AbstractC0377a
    /* JADX INFO: renamed from: a */
    public final C0386j mo254a(InterfaceC0384h interfaceC0384h) {
        String strMo279e = interfaceC0384h.mo279e();
        try {
            interfaceC0384h.mo275a(new HashMap());
        } catch (Exception e) {
        }
        Map mapMo277c = interfaceC0384h.mo277c();
        try {
            if (m3547d(strMo279e)) {
                switch (strMo279e) {
                    case "/listFiles":
                        return m3546d(mapMo277c);
                    case "/readFile":
                        return m3544c(mapMo277c);
                    case "/readImage":
                        return m3542b(mapMo277c);
                    case "/saveFile":
                        return m3541a(mapMo277c);
                }
            }
            String str = "/".equals(strMo279e) ? this.f4334c + "/index.htm" : this.f4334c + strMo279e;
            if (str == null) {
                return super.mo254a(interfaceC0384h);
            }
            File file = new File(str);
            if (file.exists()) {
                new StringBuilder("file path = ").append(file.getAbsolutePath());
                return m238a(EnumC0389m.f304a, m3545c(str), new FileInputStream(file), r2.available());
            }
            new StringBuilder("Cannot find").append(file.getAbsolutePath());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return m3548l();
    }

    /* JADX INFO: renamed from: a */
    public final String m3550a() {
        String[] strArr = {""};
        C1494c c1494c = new C1494c(this, strArr);
        try {
            synchronized (c1494c) {
                c1494c.start();
                c1494c.wait();
            }
        } catch (InterruptedException e) {
        }
        return "http://" + strArr[0] + ":" + String.valueOf(m256c());
    }

    /* JADX INFO: renamed from: a */
    public final void m3551a(int i) {
        try {
            Field declaredField = AbstractC0377a.class.getDeclaredField("myPort");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(i + 8000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        m255a(5000, true);
    }

    /* JADX INFO: renamed from: a */
    public final void m3552a(String str) {
        this.f4335d = str;
    }
}
