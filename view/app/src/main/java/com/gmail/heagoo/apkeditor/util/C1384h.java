package com.gmail.heagoo.apkeditor.util;

import android.content.Context;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1491w;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1384h extends AbstractC1382f {

    /* JADX INFO: renamed from: e */
    private int f4018e;

    /* JADX INFO: renamed from: f */
    private List f4019f;

    /* JADX INFO: renamed from: g */
    private Map f4020g;

    public C1384h(String str, String str2) throws Throwable {
        super(str, str2);
        this.f4018e = 0;
        this.f4019f = new ArrayList();
        this.f4020g = new HashMap();
        try {
            m3344e();
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    private C1387k m3343a(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f4019f.size()) {
                return null;
            }
            C1387k c1387k = (C1387k) this.f4019f.get(i2);
            if (str.equals(c1387k.f4025a)) {
                return c1387k;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: e */
    private void m3344e() throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            Pattern patternCompile = Pattern.compile("^(.+):([0-9]+): Tag (.+) attribute (.+) has invalid character '");
            BufferedReader bufferedReader2 = new BufferedReader(new StringReader(this.f4012b));
            try {
                String line = bufferedReader2.readLine();
                while (line != null) {
                    Matcher matcher = patternCompile.matcher(line);
                    if (matcher.find()) {
                        String strSubstring = line.substring(matcher.start(1), matcher.end(1));
                        String strSubstring2 = line.substring(matcher.start(2), matcher.end(2));
                        String strSubstring3 = line.substring(matcher.start(3), matcher.end(3));
                        String strSubstring4 = line.substring(matcher.start(4), matcher.end(4));
                        try {
                            int iIntValue = Integer.valueOf(strSubstring2).intValue();
                            C1387k c1387kM3343a = m3343a(strSubstring);
                            if (c1387kM3343a == null) {
                                this.f4019f.add(new C1387k(this.f4011a, strSubstring, iIntValue, strSubstring3, strSubstring4, (byte) 0));
                            } else {
                                c1387kM3343a.f4026b.add(new C1386j(iIntValue > 0 ? iIntValue - 1 : 0, strSubstring3, strSubstring4, (byte) 0));
                            }
                        } catch (Exception e) {
                        }
                    }
                    line = bufferedReader2.readLine();
                }
                bufferedReader2.close();
                for (int i = 0; i < this.f4019f.size(); i++) {
                    ((C1387k) this.f4019f.get(i)).m3348a();
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: a */
    public final String mo3337a(Context context) {
        return String.format(context.getString(R.string.str_num_modified_file), Integer.valueOf(this.f4018e));
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: a */
    public final boolean mo3339a() {
        return this.f4019f.size() > 0;
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: b */
    public final void mo3340b() throws Throwable {
        BufferedWriter bufferedWriter;
        List listM3536a;
        boolean z;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f4019f.size()) {
                return;
            }
            C1387k c1387k = (C1387k) this.f4019f.get(i2);
            BufferedWriter bufferedWriter2 = null;
            try {
                listM3536a = new C1491w(c1387k.f4025a).m3536a();
                for (int i3 = 0; i3 < listM3536a.size(); i3++) {
                    C1385i c1385iM3346a = c1387k.m3346a(i3);
                    if (c1385iM3346a != null) {
                        String str = c1387k.f4025a;
                        String str2 = (String) listM3536a.get(i3);
                        List list = c1385iM3346a.f4022b;
                        String[] strArrSplit = str2.split(" ");
                        for (int i4 = 0; i4 < strArrSplit.length; i4++) {
                            String[] strArrSplit2 = strArrSplit[i4].split("=");
                            if (strArrSplit2.length == 2) {
                                String str3 = strArrSplit2[0];
                                Iterator it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    String str4 = (String) it.next();
                                    if (!str3.equals(str4)) {
                                        if (str3.endsWith(":" + str4)) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    String[] strArr = new String[2];
                                    StringBuilder sbAppend = new StringBuilder().append(strArrSplit2[0]).append("=");
                                    String str5 = strArrSplit2[1];
                                    int i5 = 0;
                                    String str6 = "";
                                    if (str5.startsWith("\"")) {
                                        i5 = 1;
                                        str6 = "\"";
                                    }
                                    int iLastIndexOf = str5.lastIndexOf("\"");
                                    if (iLastIndexOf != -1) {
                                        String strSubstring = str5.substring(iLastIndexOf);
                                        if (iLastIndexOf > i5) {
                                            String strSubstring2 = str5.substring(i5, iLastIndexOf);
                                            String strM3322b = C1380d.m3322b(strSubstring2);
                                            strArr[0] = strSubstring2;
                                            strArr[1] = strM3322b;
                                            str5 = str6 + strM3322b + strSubstring;
                                        }
                                    }
                                    strArrSplit[i4] = sbAppend.append(str5).toString();
                                    if (strArr[1] != null) {
                                        String str7 = strArr[0];
                                        String str8 = strArr[1];
                                        Map map = (Map) this.f4020g.get(str);
                                        if (map == null) {
                                            map = new HashMap();
                                            this.f4020g.put(str, map);
                                        }
                                        map.put(str7, str8);
                                    }
                                }
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        for (String str9 : strArrSplit) {
                            sb.append(str9);
                            sb.append(" ");
                        }
                        sb.deleteCharAt(sb.length() - 1);
                        listM3536a.set(i3, sb.toString());
                    }
                }
                bufferedWriter = new BufferedWriter(new FileWriter(c1387k.f4025a));
            } catch (IOException e) {
                e = e;
                bufferedWriter = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    Iterator it2 = listM3536a.iterator();
                    while (it2.hasNext()) {
                        bufferedWriter.write((String) it2.next());
                        bufferedWriter.write("\n");
                    }
                    this.f4018e++;
                    C1380d.m3321a(bufferedWriter);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter2 = bufferedWriter;
                    C1380d.m3321a(bufferedWriter2);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                C1380d.m3321a(bufferedWriter);
            }
            i = i2 + 1;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: c */
    public final boolean mo3341c() {
        return this.f4018e > 0;
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: d */
    public final Map mo3342d() {
        return this.f4020g;
    }
}
