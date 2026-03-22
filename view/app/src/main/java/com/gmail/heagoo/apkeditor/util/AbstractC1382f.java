package com.gmail.heagoo.apkeditor.util;

import android.content.Context;
import com.android.apksig.apk.ApkUtils;
import com.gmail.heagoo.apkeditor.gzd;
import com.gmail.heagoo.common.C1491w;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.f */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC1382f {

    /* JADX INFO: renamed from: a */
    protected String f4011a;

    /* JADX INFO: renamed from: b */
    protected String f4012b;

    /* JADX INFO: renamed from: c */
    HashSet f4013c = new HashSet();

    /* JADX INFO: renamed from: d */
    int f4014d = 0;

    AbstractC1382f(String str, String str2) {
        this.f4011a = str;
        if (!str.endsWith("/")) {
            this.f4011a += "/";
        }
        this.f4012b = str2;
    }

    /* JADX INFO: renamed from: a */
    private static String m3328a(File file, List list) {
        String name = file.getName();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1401y c1401y = (C1401y) it.next();
            if (name.startsWith(c1401y.f4072b)) {
                String strSubstring = name.substring(c1401y.f4072b.length());
                if (strSubstring.equals("")) {
                    return c1401y.f4073c + strSubstring;
                }
                if ((strSubstring.charAt(0) != '.' || strSubstring.indexOf(46, 1) != -1) && !strSubstring.equals(".9.png")) {
                }
                return c1401y.f4073c + strSubstring;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static String m3329a(String str, String str2, Map map) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str2).matcher(str);
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String str3 = (String) map.get(matcher.group(1));
            if (str3 != null) {
                arrayList.add(new C1383g(matcher.start(1), matcher.end(1), str3));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return m3334b(str, arrayList);
    }

    /* JADX INFO: renamed from: a */
    protected static void m3330a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3331a(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (IOException e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
            m3330a(fileOutputStream);
            throw th;
        }
        try {
            try {
                fileOutputStream.write(str2.getBytes());
                this.f4013c.add(str);
                m3330a(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                m3330a(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            m3330a(fileOutputStream);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ae  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m3332a(java.io.File r12, java.util.Map r13) throws java.lang.Throwable {
        /*
            r11 = this;
            r10 = 10
            r2 = 1
            r9 = -1
            r1 = 0
            com.gmail.heagoo.common.w r0 = new com.gmail.heagoo.common.w     // Catch: java.io.IOException -> Lb1
            java.lang.String r3 = r12.getPath()     // Catch: java.io.IOException -> Lb1
            r0.<init>(r3)     // Catch: java.io.IOException -> Lb1
            java.lang.String r5 = r0.m3537b()     // Catch: java.io.IOException -> Lb1
            r0 = 64
            r3 = 0
            int r0 = r5.indexOf(r0, r3)     // Catch: java.io.IOException -> Lb1
            if (r0 == r9) goto Lae
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.io.IOException -> Lb1
            r6.<init>()     // Catch: java.io.IOException -> Lb1
            r3 = r0
        L21:
            if (r3 == r9) goto L96
            int r0 = r3 + 1
            r4 = r0
        L26:
            int r0 = r5.length()     // Catch: java.io.IOException -> Lb1
            if (r4 >= r0) goto Lb9
            char r0 = r5.charAt(r4)     // Catch: java.io.IOException -> Lb1
            r7 = 47
            if (r0 != r7) goto L58
            r0 = r2
        L35:
            if (r0 == 0) goto L8e
            int r0 = r3 + 1
            java.lang.String r7 = r5.substring(r0, r4)     // Catch: java.io.IOException -> Lb1
            int r0 = r4 + 1
            r3 = r0
        L40:
            int r0 = r5.length()     // Catch: java.io.IOException -> Lb1
            if (r3 >= r0) goto L66
            char r0 = r5.charAt(r3)     // Catch: java.io.IOException -> Lb1
            r8 = 34
            if (r0 == r8) goto L66
            r8 = 60
            if (r0 == r8) goto L66
            if (r0 == r10) goto L66
            int r0 = r3 + 1
            r3 = r0
            goto L40
        L58:
            r7 = 34
            if (r0 == r7) goto Lb9
            r7 = 60
            if (r0 == r7) goto Lb9
            if (r0 == r10) goto Lb9
            int r0 = r4 + 1
            r4 = r0
            goto L26
        L66:
            java.lang.Object r0 = r13.get(r7)     // Catch: java.io.IOException -> Lb1
            java.util.Map r0 = (java.util.Map) r0     // Catch: java.io.IOException -> Lb1
            if (r0 == 0) goto L86
            int r7 = r4 + 1
            java.lang.String r7 = r5.substring(r7, r3)     // Catch: java.io.IOException -> Lb1
            java.lang.Object r0 = r0.get(r7)     // Catch: java.io.IOException -> Lb1
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.io.IOException -> Lb1
            if (r0 == 0) goto L86
            com.gmail.heagoo.apkeditor.util.g r7 = new com.gmail.heagoo.apkeditor.util.g     // Catch: java.io.IOException -> Lb1
            int r4 = r4 + 1
            r7.<init>(r4, r3, r0)     // Catch: java.io.IOException -> Lb1
            r6.add(r7)     // Catch: java.io.IOException -> Lb1
        L86:
            r0 = 64
            int r0 = r5.indexOf(r0, r3)     // Catch: java.io.IOException -> Lb1
            r3 = r0
            goto L21
        L8e:
            r0 = 64
            int r0 = r5.indexOf(r0, r4)     // Catch: java.io.IOException -> Lb1
            r3 = r0
            goto L21
        L96:
            boolean r0 = r6.isEmpty()     // Catch: java.io.IOException -> Lb1
            if (r0 != 0) goto Lae
            java.lang.String r0 = m3334b(r5, r6)     // Catch: java.io.IOException -> Lb1
            r3 = r0
        La1:
            if (r3 == 0) goto Lb7
            r0 = r2
        La4:
            if (r0 == 0) goto Lad
            java.lang.String r2 = r12.getPath()     // Catch: java.io.IOException -> Lb1
            r11.m3331a(r2, r3)     // Catch: java.io.IOException -> Lb1
        Lad:
            return r0
        Lae:
            r0 = 0
            r3 = r0
            goto La1
        Lb1:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r1
            goto Lad
        Lb7:
            r0 = r1
            goto La4
        Lb9:
            r0 = r1
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.util.AbstractC1382f.m3332a(java.io.File, java.util.Map):boolean");
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3333a(String str) {
        String[] strArr = {"bools.xml", "colors.xml", "dimens.xml", "ids.xml", "integers.xml", "public.xml", "strings.xml"};
        for (int i = 0; i < 7; i++) {
            if (strArr[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private static String m3334b(String str, List list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                sb.append(str.substring(i2));
                return sb.toString();
            }
            C1383g c1383g = (C1383g) it.next();
            sb.append(str.substring(i2, c1383g.f4015a));
            sb.append(c1383g.f4017c);
            i = c1383g.f4016b;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m3335b(List list) throws Throwable {
        File file;
        File[] fileArrListFiles = new File(this.f4011a + "res").listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory() && file2.getName().startsWith("values")) {
                    file = new File(file2, "styles.xml");
                    if (!file.exists()) {
                        file = null;
                    }
                } else {
                    file = null;
                }
                if (file != null) {
                    String path = file.getPath();
                    try {
                        String strM3537b = new C1491w(path).m3537b();
                        Iterator it = list.iterator();
                        String str = strM3537b;
                        boolean z = false;
                        while (it.hasNext()) {
                            C1401y c1401y = (C1401y) it.next();
                            int length = str.length();
                            String strReplace = str.replace("item name=\"" + c1401y.f4072b + "\"", "item name=\"" + c1401y.f4073c + "\"");
                            z = strReplace.length() != length ? true : z;
                            str = strReplace;
                        }
                        if (z) {
                            m3331a(path, str);
                        }
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected final int m3336a(List list) {
        File[] fileArrListFiles = new File(this.f4011a + "res").listFiles();
        if (fileArrListFiles == null) {
            return 0;
        }
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1401y c1401y = (C1401y) it.next();
            Map map2 = (Map) map.get(c1401y.f4071a);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(c1401y.f4071a, map2);
            }
            map2.put(c1401y.f4072b, c1401y.f4073c);
        }
        int i = 0;
        for (File file : fileArrListFiles) {
            String name = file.getName();
            if (!name.startsWith("raw")) {
                boolean zEquals = "values".equals(name);
                File[] fileArrListFiles2 = file.listFiles();
                if (fileArrListFiles2 != null) {
                    for (File file2 : fileArrListFiles2) {
                        if (file2.isFile()) {
                            String name2 = file2.getName();
                            if (name2.endsWith(".xml") && ((!zEquals || !m3333a(name2)) && m3332a(file2, map))) {
                                i++;
                            }
                        }
                    }
                }
            }
        }
        File file3 = new File(this.f4011a + ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME);
        return (file3.exists() && m3332a(file3, map)) ? i + 1 : i;
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo3337a(Context context);

    /* JADX INFO: renamed from: a */
    protected final void m3338a(String str, List list) throws Throwable {
        File[] fileArrListFiles;
        File file;
        String strM3329a;
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1401y c1401y = (C1401y) it.next();
            map.put(c1401y.f4072b, c1401y.f4073c);
        }
        String str2 = "plurals".equals(str) ? "plurals.xml" : str + "s.xml";
        File[] fileArrListFiles2 = new File(this.f4011a + "res").listFiles();
        if (fileArrListFiles2 != null) {
            for (File file2 : fileArrListFiles2) {
                if (file2.isDirectory() && file2.getName().startsWith("values")) {
                    File file3 = new File(file2, str2);
                    file = !file3.exists() ? null : file3;
                } else {
                    file = null;
                }
                if (file != null) {
                    try {
                        String strM3537b = new C1491w(file.getPath()).m3537b();
                        if (gzd.COLUMN_ID.equals(str)) {
                            strM3329a = m3329a(strM3537b, "name=\"(.*?)\"", map);
                        } else if ("drawable".equals(str) || "dimen".equals(str) || "color".equals(str)) {
                            String strM3329a2 = m3329a(strM3537b, "@" + str + "/(.*?)<", map);
                            if (strM3329a2 != null) {
                                strM3537b = strM3329a2;
                            }
                            strM3329a = m3329a(strM3537b, "name=\"(.*?)\"", map);
                        } else {
                            strM3329a = m3329a(strM3537b, str + " name=\"(.*?)\"", map);
                        }
                        if (strM3329a != null) {
                            m3331a(file.getPath(), strM3329a);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if ("attr".equals(str)) {
            m3335b(list);
            return;
        }
        File[] fileArrListFiles3 = new File(this.f4011a + "res").listFiles();
        if (fileArrListFiles3 != null) {
            for (File file4 : fileArrListFiles3) {
                if (!file4.isFile()) {
                    String name = file4.getName();
                    if ((name.startsWith(str) || name.startsWith(str + "-")) && (fileArrListFiles = file4.listFiles()) != null) {
                        for (File file5 : fileArrListFiles) {
                            String strM3328a = m3328a(file5, list);
                            if (strM3328a != null) {
                                file5.renameTo(new File(file4, strM3328a));
                                this.f4014d++;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo3339a();

    /* JADX INFO: renamed from: b */
    public abstract void mo3340b();

    /* JADX INFO: renamed from: c */
    public abstract boolean mo3341c();

    /* JADX INFO: renamed from: d */
    public abstract Map mo3342d();
}
