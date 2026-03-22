package com.gmail.heagoo.apkeditor.util;

import android.content.Context;
import com.gmail.heagoo.apkeditor.p066e.C1153ad;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1487s;
import com.gmail.heagoo.common.C1491w;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1388l extends AbstractC1382f {

    /* JADX INFO: renamed from: e */
    private Map f4028e;

    /* JADX INFO: renamed from: f */
    private Map f4029f;

    /* JADX INFO: renamed from: g */
    private Map f4030g;

    public C1388l(String str, String str2) throws Throwable {
        super(str, str2);
        this.f4028e = new HashMap();
        this.f4029f = new HashMap();
        this.f4030g = new HashMap();
        try {
            m3349e();
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: e */
    private void m3349e() throws Throwable {
        BufferedReader bufferedReader;
        Pattern patternCompile;
        try {
            patternCompile = Pattern.compile("^(.+): error: File is case-insensitive equivalent to: (.+)");
            bufferedReader = new BufferedReader(new StringReader(this.f4012b));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                Matcher matcher = patternCompile.matcher(line);
                if (matcher.find()) {
                    this.f4028e.put(matcher.group(1), matcher.group(2));
                }
            }
            bufferedReader.close();
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
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
        return !this.f4028e.isEmpty();
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: b */
    public final void mo3340b() {
        boolean z;
        String str = this.f4011a + "res/values/public.xml";
        try {
            List listM3536a = new C1491w(str).m3536a();
            for (int i = 0; i < listM3536a.size(); i++) {
                C1153ad c1153adM2894a = C1153ad.m2894a((String) listM3536a.get(i));
                if (c1153adM2894a != null) {
                    String str2 = c1153adM2894a.f3254a;
                    String str3 = c1153adM2894a.f3255b;
                    String lowerCase = str3.toLowerCase();
                    Set hashSet = (Set) this.f4029f.get(str2);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        this.f4029f.put(str2, hashSet);
                    }
                    if (hashSet.contains(lowerCase)) {
                        z = false;
                    } else {
                        hashSet.add(lowerCase);
                        z = true;
                    }
                    if (!z) {
                        String str4 = str3 + "_" + C1487s.m3525a(6);
                        List arrayList = (List) this.f4030g.get(str2);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            this.f4030g.put(str2, arrayList);
                        }
                        arrayList.add(new C1401y(str2, str3, str4));
                        c1153adM2894a.f3255b = str4;
                        listM3536a.set(i, c1153adM2894a.toString());
                    }
                }
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            StringBuilder sb = new StringBuilder();
            Iterator it = listM3536a.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append("\n");
            }
            bufferedOutputStream.write(sb.toString().getBytes());
            bufferedOutputStream.close();
            this.f4013c.add(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry entry : this.f4030g.entrySet()) {
            m3338a((String) entry.getKey(), (List) entry.getValue());
        }
        if (this.f4030g.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = this.f4030g.values().iterator();
        while (it2.hasNext()) {
            arrayList2.addAll((List) it2.next());
        }
        m3336a(arrayList2);
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
