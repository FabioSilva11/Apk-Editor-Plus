package com.gmail.heagoo.apkeditor;

import android.content.Context;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d;
import com.gmail.heagoo.apkeditor.p067f.InterfaceC1206c;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1476h;
import com.gmail.heagoo.common.C1479k;
import com.gmail.heagoo.common.InterfaceC1478j;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.o */
/* JADX INFO: loaded from: classes.dex */
public final class C1331o extends AbstractC1099bz implements InterfaceC1206c {

    /* JADX INFO: renamed from: a */
    private Context f3765a;

    /* JADX INFO: renamed from: b */
    private String f3766b;

    /* JADX INFO: renamed from: c */
    private String f3767c;

    /* JADX INFO: renamed from: d */
    private String f3768d;

    /* JADX INFO: renamed from: e */
    private String f3769e;

    /* JADX INFO: renamed from: f */
    private String f3770f;

    /* JADX INFO: renamed from: g */
    private String f3771g;

    /* JADX INFO: renamed from: h */
    private boolean f3772h;

    /* JADX INFO: renamed from: i */
    private String f3773i;

    /* JADX INFO: renamed from: l */
    private InterfaceC1478j f3776l;

    /* JADX INFO: renamed from: m */
    private C1479k f3777m;
    private Set mdUncString;

    /* JADX INFO: renamed from: p */
    private boolean f3780p;

    /* JADX INFO: renamed from: q */
    private InterfaceC1026d f3781q;

    /* JADX INFO: renamed from: j */
    private Map f3774j = new HashMap();

    /* JADX INFO: renamed from: k */
    private List f3775k = new ArrayList();

    /* JADX INFO: renamed from: n */
    private long f3778n = 0;

    /* JADX INFO: renamed from: o */
    private boolean f3779o = false;

    public C1331o(Context context, String str, String str2) {
        this.f3765a = context;
        this.f3766b = context.getFilesDir().getAbsolutePath() + "/bin";
        this.f3767c = this.f3766b + "/aapt";
        this.f3768d = this.f3766b + "/android.jar";
        this.f3769e = str;
        this.f3770f = str2;
        this.f3771g = str + "/build/resource.apk";
        new StringBuilder("aaptPath: ").append(this.f3767c);
        new StringBuilder("androidJarPath: ").append(this.f3768d);
        new StringBuilder("decodedFilePath: ").append(this.f3769e);
        this.f3777m = new C1479k();
    }

    /* JADX INFO: renamed from: a */
    private static long m3208a(File file) {
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    /* JADX INFO: renamed from: a */
    private static String m3209a(String str) {
        return "smali".equals(str) ? "classes.dex" : str.startsWith("smali_") ? str.substring(6) + ".dex" : str + ".dex";
    }

    /* JADX INFO: renamed from: a */
    private void m3210a() {
        for (File file : new File(this.f3769e).listFiles()) {
            if (file.isDirectory()) {
                String name = file.getName();
                if (name.equals("smali") || name.startsWith("smali_")) {
                    String strM3209a = m3209a(name);
                    long jM3208a = m3208a(new File(this.f3769e + "/" + strM3209a));
                    long jM3208a2 = m3208a(new File(this.f3769e + "/build/" + strM3209a));
                    if (jM3208a2 <= jM3208a) {
                        jM3208a2 = jM3208a;
                    }
                    if (C1476h.m3513b(file) > jM3208a2) {
                        this.f3775k.add(name);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3211a(Map map) {
        map.putAll(this.f3774j);
        for (File file : new File(this.f3769e).listFiles()) {
            String name = file.getName();
            if (file.isFile() && name.endsWith(".dex") && !this.f3774j.containsKey(name)) {
                File file2 = new File(this.f3769e + "/build/" + name);
                if (file2.isFile() && file2.exists()) {
                    map.put(name, file2.getPath());
                } else {
                    map.put(name, file.getPath());
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3212a(Map map, File file, String str) {
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                map.put(str + file2.getName(), file2.getPath());
            } else if (file2.isDirectory()) {
                m3212a(map, file2, str + file2.getName() + "/");
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m3213b(String str) {
        this.f3777m.f4305a++;
        this.f3777m.f4307c = str;
        this.f3776l.mo2334a(this.f3777m);
    }

    /* JADX INFO: renamed from: c */
    private void m3214c() {
        HashMap map = new HashMap();
        InterfaceC1026d interfaceC1026d = this.f3781q;
        if (interfaceC1026d != null) {
            try {
                interfaceC1026d.mo2692a(this.f3765a, this.f3771g, map, new C1332p(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HashMap map2 = new HashMap();
        File file = new File(this.f3769e + "/assets");
        if (file.exists()) {
            m3212a(map2, file, "assets/");
        }
        File file2 = new File(this.f3769e + "/lib");
        if (file2.exists()) {
            m3212a(map2, file2, "lib/");
        }
        File file3 = new File(this.f3769e + "/libs");
        if (file3.exists()) {
            m3212a(map2, file3, "libs/");
        }
        File file4 = new File(this.f3769e + "/kotlin");
        if (file4.exists()) {
            m3212a(map2, file4, "kotlin/");
        }
        File file5 = new File(this.f3769e + "/unknown");
        if (file5.exists()) {
            m3212a(map2, file5, "");
        }
        m3211a(map2);
        mdNoCompress();
        HashMap map3 = new HashMap();
        Set set = this.mdUncString;
        if (set == null || set.isEmpty()) {
            map3 = map2;
        } else {
            for (Map.Entry entry : map2.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (this.mdUncString.contains(str)) {
                    map3.put(str + ":0", str2);
                } else {
                    map3.put(str, str2);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int length = 0;
        for (Map.Entry entry2 : map3.entrySet()) {
            String str3 = (String) entry2.getKey();
            String str4 = (String) entry2.getValue();
            sb.append(str3);
            sb.append('\n');
            sb.append(str4);
            sb.append('\n');
            length += str4.getBytes().length + str3.getBytes().length + 2;
        }
        StringBuilder sb2 = new StringBuilder();
        int length2 = 0;
        for (Map.Entry entry3 : map.entrySet()) {
            String str5 = (String) entry3.getKey();
            String str6 = (String) entry3.getValue();
            sb2.append(str5);
            sb2.append('\n');
            sb2.append(str6);
            sb2.append('\n');
            length2 += str6.getBytes().length + str5.getBytes().length + 2;
        }
        MainActivity.m2527md(this.f3770f, this.f3771g, sb.toString(), length, "", 0, sb2.toString(), length2);
    }

    /* JADX INFO: renamed from: d */
    private boolean m3215d() {
        String str = this.f3770f + ".signed";
        try {
            HashMap map = new HashMap();
            C0985a.m2205a(this.f3765a, this.f3770f, str, map, map, new HashSet());
            File file = new File(this.f3770f);
            file.delete();
            new File(str).renameTo(file);
            return true;
        } catch (Exception e) {
            this.f3773i = this.f3765a.getResources().getString(R.string.sign_error) + e.getMessage();
            return false;
        }
    }

    /* JADX INFO: renamed from: e */
    private boolean m3216e() {
        try {
            return C1322m.m3198a(this.f3765a, this.f3767c, this.f3766b);
        } catch (Exception e) {
            this.f3773i = e.getMessage();
            return false;
        }
    }

    private void mdNoCompress() {
        this.mdUncString = null;
        try {
            String strM2263d = C0985a.m2263d((Context) null, "tmp");
            if (new File(strM2263d, "mdUncString").exists()) {
                this.mdUncString = (Set) C0985a.m2280j(strM2263d + "mdUncString");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p067f.InterfaceC1206c
    /* JADX INFO: renamed from: a */
    public final void mo3008a(int i, int i2) {
        if (System.currentTimeMillis() > 500) {
            this.f3777m.f4307c = String.format(this.f3765a.getString(R.string.assemble_dex_detail), Integer.valueOf(i), Integer.valueOf(i2));
            this.f3776l.mo2334a(this.f3777m);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractC1099bz
    /* JADX INFO: renamed from: a */
    public final void mo2822a(InterfaceC1026d interfaceC1026d) {
        this.f3781q = interfaceC1026d;
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractC1099bz
    /* JADX INFO: renamed from: a */
    public final void mo2823a(InterfaceC1478j interfaceC1478j) {
        this.f3776l = interfaceC1478j;
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractC1099bz
    /* JADX INFO: renamed from: a */
    public final void mo2824a(boolean z, boolean z2, boolean z3, List list, Map map, Map map2, Set set, Map map3, boolean z4) {
        this.f3780p = z4;
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractC1099bz
    /* JADX INFO: renamed from: b */
    public final void mo2825b() {
        this.f3779o = true;
        interrupt();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x031f  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 896
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.C1331o.run():void");
    }
}
