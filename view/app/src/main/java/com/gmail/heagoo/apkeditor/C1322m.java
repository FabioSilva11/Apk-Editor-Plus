package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import com.android.apksig.apk.ApkUtils;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d;
import com.gmail.heagoo.apkeditor.p067f.InterfaceC1206c;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1471c;
import com.gmail.heagoo.common.C1479k;
import com.gmail.heagoo.common.InterfaceC1478j;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000a.p001a.p003b.p004a.p005a.C0027x;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1322m extends AbstractC1099bz implements InterfaceC1206c {

    /* JADX INFO: renamed from: a */
    private Context f3737a;

    /* JADX INFO: renamed from: b */
    private String f3738b;

    /* JADX INFO: renamed from: c */
    private String f3739c;

    /* JADX INFO: renamed from: d */
    private String f3740d;

    /* JADX INFO: renamed from: e */
    private String f3741e;

    /* JADX INFO: renamed from: f */
    private String f3742f;

    /* JADX INFO: renamed from: g */
    private String f3743g;

    /* JADX INFO: renamed from: h */
    private String f3744h;

    /* JADX INFO: renamed from: i */
    private boolean f3745i;

    /* JADX INFO: renamed from: j */
    private String f3746j;

    /* JADX INFO: renamed from: l */
    private boolean f3748l;

    /* JADX INFO: renamed from: m */
    private boolean f3749m;

    /* JADX INFO: renamed from: n */
    private boolean f3750n;

    /* JADX INFO: renamed from: o */
    private List f3751o;

    /* JADX INFO: renamed from: p */
    private Map f3752p;

    /* JADX INFO: renamed from: q */
    private Map f3753q;

    /* JADX INFO: renamed from: r */
    private Set f3754r;

    /* JADX INFO: renamed from: s */
    private Map f3755s;

    /* JADX INFO: renamed from: t */
    private InterfaceC1478j f3756t;

    /* JADX INFO: renamed from: u */
    private C1479k f3757u;

    /* JADX INFO: renamed from: x */
    private boolean f3760x;

    /* JADX INFO: renamed from: y */
    private InterfaceC1026d f3761y;

    /* JADX INFO: renamed from: k */
    private Map f3747k = new HashMap();

    /* JADX INFO: renamed from: v */
    private long f3758v = 0;

    /* JADX INFO: renamed from: w */
    private boolean f3759w = false;

    public C1322m(Context context, String str, String str2, String str3) {
        this.f3737a = context;
        this.f3738b = context.getFilesDir().getAbsolutePath() + "/bin";
        this.f3739c = this.f3738b + "/aapt";
        this.f3740d = this.f3738b + "/android.jar";
        this.f3741e = str;
        this.f3742f = str2;
        this.f3743g = str3;
        this.f3744h = str2;
        new StringBuilder("aaptPath: ").append(this.f3739c);
        new StringBuilder("androidJarPath: ").append(this.f3740d);
        new StringBuilder("decodedFilePath: ").append(this.f3741e);
        this.f3757u = new C1479k();
    }

    /* JADX INFO: renamed from: a */
    private void m3194a(String str) {
        this.f3757u.f4305a++;
        this.f3757u.f4307c = str;
        this.f3756t.mo2334a(this.f3757u);
    }

    /* JADX INFO: renamed from: a */
    private static void m3195a(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            if (str.equals(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME)) {
                it.remove();
            } else if (str.startsWith("res/")) {
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3196a(Context context) {
        try {
            String packageName = context.getPackageName();
            String strM3199b = m3199b(context, packageName);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('i');
            stringBuffer.append('n');
            stringBuffer.append('g');
            if (strM3199b.endsWith(stringBuffer.toString())) {
                return packageName.endsWith("pro");
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    protected static boolean m3197a(Context context, String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int i = defaultSharedPreferences.getInt("aapt-no-version-vectors", -1);
        if (i == 1) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        C1471c c1471c = new C1471c();
        c1471c.m3494a((Object) new String[]{str}, (String[]) null, (Integer) 5000, false);
        String strMo3493a = c1471c.mo3493a();
        String strMo3497b = c1471c.mo3497b();
        boolean z = (strMo3493a != null && strMo3493a.contains("--no-version-vectors")) || (strMo3497b != null && strMo3497b.contains("--no-version-vectors"));
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putInt("aapt-no-version-vectors", z ? 1 : 0);
        editorEdit.apply();
        return z;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3198a(Context context, String str, String str2) throws Exception {
        String str3 = null;
        try {
            str3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("info", 0);
        boolean z = sharedPreferences.getBoolean("initialized", false);
        String string = sharedPreferences.getString("version", "");
        if (!z || !string.equals(str3)) {
            m3200b(context, str, str2);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("initialized", true);
            editorEdit.putString("version", str3);
            editorEdit.commit();
        }
        return true;
    }

    static ArrayList aaptNoCompress() {
        ArrayList arrayList = new ArrayList();
        Set<String> set = null;
        try {
            String strM2263d = C0985a.m2263d((Context) null, "tmp");
            if (new File(strM2263d, "aaptUncString").exists()) {
                set = (Set) C0985a.m2280j(strM2263d + "aaptUncString");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (set != null && !set.isEmpty()) {
            for (String str : set) {
                arrayList.add("-0");
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    private static String m3199b(Context context, String str) {
        String str2;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('g');
            stringBuffer.append('e');
            stringBuffer.append('t');
            stringBuffer.append("Package");
            stringBuffer.append('M');
            stringBuffer.append('a');
            stringBuffer.append('n');
            stringBuffer.append('a');
            stringBuffer.append('g');
            stringBuffer.append('e');
            stringBuffer.append('r');
            PackageManager packageManager = (PackageManager) Context.class.getMethod(stringBuffer.toString(), new Class[0]).invoke(context, new Object[0]);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append('g');
            stringBuffer2.append('e');
            stringBuffer2.append('t');
            stringBuffer2.append("In");
            stringBuffer2.append("stall");
            stringBuffer2.append("er");
            stringBuffer2.append("Package");
            stringBuffer2.append('N');
            stringBuffer2.append('a');
            stringBuffer2.append('m');
            stringBuffer2.append('e');
            str2 = (String) PackageManager.class.getMethod(stringBuffer2.toString(), String.class).invoke(packageManager, str);
        } catch (Exception e) {
            e.printStackTrace();
            str2 = null;
        }
        return str2 == null ? "" : str2;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 14 */
    /* JADX INFO: renamed from: b */
    private static boolean m3200b(Context context, String str, String str2) throws Exception {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            InputStream inputStreamOpen = context.getAssets().open("aapt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            C0985a.m2244b(inputStreamOpen, fileOutputStream);
            inputStreamOpen.close();
            fileOutputStream.close();
            file.setExecutable(true);
            InputStream inputStreamOpen2 = context.getAssets().open("android.zip");
            String str3 = str2 + "/tmp.zip";
            FileOutputStream fileOutputStream2 = new FileOutputStream(str2 + "/tmp.zip");
            C0985a.m2244b(inputStreamOpen2, fileOutputStream2);
            inputStreamOpen2.close();
            fileOutputStream2.close();
            C0027x.m33b(str3, str2);
            new File(str3).delete();
            C0027x.m33b(str2 + "/android.jar", str2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Can not copy file: " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: d */
    private void m3201d() {
        if (this.f3755s == null || this.f3755s.isEmpty()) {
            return;
        }
        if (!this.f3752p.isEmpty()) {
            HashMap map = new HashMap();
            for (Map.Entry entry : this.f3752p.entrySet()) {
                String str = (String) this.f3755s.get(entry.getKey());
                if (str != null) {
                    map.put(str, entry.getValue());
                } else {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
            this.f3752p = map;
        }
        if (!this.f3753q.isEmpty()) {
            HashMap map2 = new HashMap();
            for (Map.Entry entry2 : this.f3753q.entrySet()) {
                String str2 = (String) this.f3755s.get(entry2.getKey());
                if (str2 != null) {
                    map2.put(str2, entry2.getValue());
                } else {
                    map2.put(entry2.getKey(), entry2.getValue());
                }
            }
            this.f3753q = map2;
        }
        if (this.f3754r.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (String str3 : this.f3754r) {
            String str4 = (String) this.f3755s.get(str3);
            if (str4 != null) {
                hashSet.add(str4);
            } else {
                hashSet.add(str3);
            }
        }
        this.f3754r = hashSet;
    }

    /* JADX INFO: renamed from: e */
    private void m3202e() {
        m3195a(this.f3752p);
        m3195a(this.f3753q);
        Iterator it = this.f3754r.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).startsWith("res/")) {
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: f */
    private void m3203f() {
        int length = 0;
        HashMap map = new HashMap();
        if (this.f3761y != null) {
            try {
                this.f3761y.mo2692a(this.f3737a, this.f3744h, map, new C1323n(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        StringBuilder sb = new StringBuilder();
        int length2 = 0;
        for (Map.Entry entry : this.f3755s.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            sb.append(str);
            sb.append('\n');
            sb.append(str2);
            sb.append('\n');
            length2 += str2.getBytes().length + str.getBytes().length + 2;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry2 : this.f3752p.entrySet()) {
            String str3 = (String) entry2.getKey();
            String str4 = (String) entry2.getValue();
            if (!str3.startsWith("res/") || !str3.endsWith(".xml")) {
                sb2.append(str3);
                sb2.append('\n');
                sb2.append(str4);
                sb2.append('\n');
                length += str4.getBytes().length + str3.getBytes().length + 2;
            }
        }
        for (Map.Entry entry3 : this.f3753q.entrySet()) {
            String str5 = (String) entry3.getKey();
            if (!str5.equals(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME)) {
                String str6 = (String) entry3.getValue();
                if (!str5.startsWith("res/") || (!str5.endsWith(".xml") && !str5.endsWith(".9.png"))) {
                    sb2.append(str5);
                    sb2.append('\n');
                    sb2.append(str6);
                    sb2.append('\n');
                    length += str6.getBytes().length + str5.getBytes().length + 2;
                }
            }
        }
        int length3 = length;
        for (Map.Entry entry4 : map.entrySet()) {
            String str7 = (String) entry4.getKey();
            String str8 = (String) entry4.getValue();
            sb2.append((String) entry4.getKey());
            sb2.append('\n');
            sb2.append((String) entry4.getValue());
            sb2.append('\n');
            length3 += str7.getBytes().length + str8.getBytes().length + 2;
        }
        MainActivity.m2528mg(this.f3744h, this.f3742f, sb2.toString(), length3, sb.toString(), length2);
    }

    /* JADX INFO: renamed from: g */
    private boolean m3204g() {
        this.f3753q.putAll(this.f3747k);
        try {
            C0985a.m2205a(this.f3737a, this.f3744h, this.f3743g, (Map<String, String>) this.f3753q, (Map<String, String>) this.f3752p, (Set<String>) this.f3754r);
            return true;
        } catch (Exception e) {
            this.f3746j = this.f3737a.getResources().getString(R.string.sign_error) + e.getMessage();
            return false;
        }
    }

    /* JADX INFO: renamed from: h */
    private boolean m3205h() {
        this.f3753q.putAll(this.f3747k);
        StringBuilder sb = new StringBuilder();
        int length = 0;
        for (Map.Entry entry : this.f3752p.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            sb.append(str);
            sb.append('\n');
            sb.append(str2);
            sb.append('\n');
            length += str2.getBytes().length + str.getBytes().length + 2;
        }
        StringBuilder sb2 = new StringBuilder();
        int length2 = 0;
        for (String str3 : this.f3754r) {
            sb2.append(str3);
            sb2.append('\n');
            length2 += str3.getBytes().length + 1;
        }
        StringBuilder sb3 = new StringBuilder();
        int length3 = 0;
        for (Map.Entry entry2 : this.f3753q.entrySet()) {
            String str4 = (String) entry2.getKey();
            String str5 = (String) entry2.getValue();
            sb3.append(str4);
            sb3.append('\n');
            sb3.append(str5);
            sb3.append('\n');
            length3 += str5.getBytes().length + str4.getBytes().length + 2;
        }
        MainActivity.m2527md(this.f3743g, this.f3744h, sb.toString(), length, sb2.toString(), length2, sb3.toString(), length3);
        return true;
    }

    @Override // com.gmail.heagoo.apkeditor.p067f.InterfaceC1206c
    /* JADX INFO: renamed from: a */
    public final void mo3008a(int i, int i2) {
        if (System.currentTimeMillis() > 500) {
            this.f3757u.f4307c = String.format(this.f3737a.getString(R.string.assemble_dex_detail), Integer.valueOf(i), Integer.valueOf(i2));
            this.f3756t.mo2334a(this.f3757u);
        }
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractC1099bz
    /* JADX INFO: renamed from: a */
    public final void mo2822a(InterfaceC1026d interfaceC1026d) {
        this.f3761y = interfaceC1026d;
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractC1099bz
    /* JADX INFO: renamed from: a */
    public final void mo2823a(InterfaceC1478j interfaceC1478j) {
        this.f3756t = interfaceC1478j;
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractC1099bz
    /* JADX INFO: renamed from: a */
    public final void mo2824a(boolean z, boolean z2, boolean z3, List list, Map map, Map map2, Set set, Map map3, boolean z4) {
        this.f3748l = z;
        this.f3749m = z2;
        this.f3750n = z3;
        this.f3751o = list;
        this.f3752p = map;
        this.f3754r = set;
        this.f3753q = map2;
        this.f3755s = map3;
        this.f3760x = z4;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3206a() {
        try {
            return m3198a(this.f3737a, this.f3739c, this.f3738b);
        } catch (Exception e) {
            this.f3746j = e.getMessage();
            return false;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.AbstractC1099bz
    /* JADX INFO: renamed from: b */
    public final void mo2825b() {
        this.f3759w = true;
        interrupt();
    }

    /* JADX INFO: renamed from: c */
    public final String m3207c() {
        return this.f3746j;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0157 A[PHI: r3
  0x0157: PHI (r3v1 boolean) = (r3v0 boolean), (r3v4 boolean) binds: [B:20:0x0041, B:43:0x0155] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0237  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 873
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.C1322m.run():void");
    }
}
