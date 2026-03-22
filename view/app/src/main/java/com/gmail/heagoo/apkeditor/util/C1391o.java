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

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.o */
/* JADX INFO: loaded from: classes.dex */
final class C1391o extends AbstractC1382f {

    /* JADX INFO: renamed from: e */
    private List f4040e;

    C1391o(String str, String str2) throws Throwable {
        super(str, str2);
        this.f4040e = new ArrayList();
        try {
            m3360e();
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    private C1392p m3356a(String str) {
        if (!str.startsWith("/")) {
            str = this.f4011a + str;
        }
        for (C1392p c1392p : this.f4040e) {
            if (str.equals(c1392p.f4041a)) {
                return c1392p;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private void m3357a(C1392p c1392p) {
        int i;
        int iIndexOf;
        try {
            List listM3536a = new C1491w(c1392p.f4041a).m3536a();
            for (C1393q c1393q : c1392p.f4042b) {
                if (c1393q.f4043a > 0) {
                    int i2 = c1393q.f4043a - 1;
                    String str = (String) listM3536a.get(i2);
                    int iIndexOf2 = str.indexOf("type=\"");
                    if (iIndexOf2 != -1 && (iIndexOf = str.indexOf(34, (i = iIndexOf2 + 6))) != -1) {
                        c1393q.f4044b = str.substring(i, iIndexOf);
                    }
                    listM3536a.set(i2, str.replace("name=\"" + c1393q.f4045c + "\"", "name=\"" + c1393q.m3364a() + "\""));
                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(c1392p.f4041a));
            Iterator it = listM3536a.iterator();
            while (it.hasNext()) {
                bufferedWriter.write((String) it.next());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            this.f4013c.add(c1392p.f4041a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3358a(List list, String str, String str2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1401y c1401y = (C1401y) it.next();
            if (str.equals(c1401y.f4071a) && str2.equals(c1401y.f4072b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private static Map m3359b(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1393q c1393q = (C1393q) it.next();
            List arrayList = (List) map.get(c1393q.f4044b);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(c1393q.f4044b, arrayList);
            }
            arrayList.add(new C1401y(c1393q.f4044b, c1393q.f4045c, c1393q.m3364a()));
        }
        return map;
    }

    /* JADX INFO: renamed from: e */
    private void m3360e() throws Throwable {
        Pattern patternCompile;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            patternCompile = Pattern.compile("^(.+):([0-9]+): error: invalid symbol: '(.+)'");
            bufferedReader = new BufferedReader(new StringReader(this.f4012b));
        } catch (Throwable th) {
            th = th;
        }
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                Matcher matcher = patternCompile.matcher(line);
                if (matcher.find()) {
                    String strSubstring = line.substring(matcher.start(1), matcher.end(1));
                    String strSubstring2 = line.substring(matcher.start(2), matcher.end(2));
                    String strSubstring3 = line.substring(matcher.start(3), matcher.end(3));
                    try {
                        int iIntValue = Integer.valueOf(strSubstring2).intValue();
                        C1392p c1392pM3356a = m3356a(strSubstring);
                        if (c1392pM3356a == null) {
                            this.f4040e.add(new C1392p(this.f4011a, strSubstring, iIntValue, strSubstring3, (byte) 0));
                        } else {
                            c1392pM3356a.f4042b.add(new C1393q(c1392pM3356a, iIntValue, strSubstring3, (byte) 0));
                        }
                    } catch (Exception e) {
                    }
                }
                line = bufferedReader.readLine();
            }
            m3330a(bufferedReader);
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            m3330a(bufferedReader2);
            throw th;
        }
    }

    /* JADX INFO: renamed from: f */
    private List m3361f() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f4040e.iterator();
        while (it.hasNext()) {
            for (C1393q c1393q : ((C1392p) it.next()).f4042b) {
                if (C1393q.m3363a(c1393q) && !m3358a(arrayList, c1393q.f4044b, c1393q.f4045c)) {
                    arrayList.add(new C1401y(c1393q.f4044b, c1393q.f4045c, c1393q.m3364a()));
                }
            }
        }
        return arrayList;
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: a */
    public final String mo3337a(Context context) {
        StringBuilder sb = new StringBuilder();
        if (this.f4014d > 0) {
            sb.append(String.format(context.getString(R.string.str_num_renamed_file), Integer.valueOf(this.f4014d)));
            sb.append("\n");
        }
        if (!this.f4013c.isEmpty()) {
            sb.append(String.format(context.getString(R.string.str_num_modified_file), Integer.valueOf(this.f4013c.size())));
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: a */
    public final boolean mo3339a() {
        return this.f4040e.size() > 0;
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: b */
    public final void mo3340b() {
        C1392p c1392pM3356a = m3356a(this.f4011a + "res/values/public.xml");
        if (c1392pM3356a != null) {
            m3357a(c1392pM3356a);
        }
        if (c1392pM3356a != null) {
            for (Map.Entry entry : m3359b(c1392pM3356a.f4042b).entrySet()) {
                m3338a((String) entry.getKey(), (List) entry.getValue());
            }
        }
        List listM3361f = m3361f();
        if (listM3361f.isEmpty()) {
            return;
        }
        m3336a(listM3361f);
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: c */
    public final boolean mo3341c() {
        return this.f4014d > 0 || !this.f4013c.isEmpty();
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: d */
    public final Map mo3342d() {
        return null;
    }
}
