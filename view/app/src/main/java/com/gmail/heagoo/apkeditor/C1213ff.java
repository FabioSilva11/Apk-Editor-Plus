package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.apksig.apk.ApkUtils;
import com.gmail.heagoo.apkeditor.p068se.C1345aa;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1476h;
import com.gmail.heagoo.common.C1481m;
import com.gmail.heagoo.common.C1487s;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.gmail.heagoo.p070b.C1450a;
import com.gmail.heagoo.p070b.C1451b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ff */
/* JADX INFO: loaded from: classes.dex */
public final class C1213ff extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a */
    private WeakReference f3431a;

    /* JADX INFO: renamed from: b */
    private WeakReference f3432b;

    /* JADX INFO: renamed from: c */
    private int f3433c;

    /* JADX INFO: renamed from: d */
    private String f3434d;

    /* JADX INFO: renamed from: e */
    private String f3435e;

    /* JADX INFO: renamed from: f */
    private String f3436f;

    /* JADX INFO: renamed from: g */
    private String f3437g;

    /* JADX INFO: renamed from: h */
    private List f3438h;

    /* JADX INFO: renamed from: i */
    private FilenameFilter f3439i;

    /* JADX INFO: renamed from: j */
    private Map f3440j;

    /* JADX INFO: renamed from: k */
    private Set f3441k;

    /* JADX INFO: renamed from: l */
    private LruCache f3442l;

    /* JADX INFO: renamed from: m */
    private C1218fk f3443m;

    /* JADX INFO: renamed from: n */
    private C1345aa f3444n;

    /* JADX INFO: renamed from: o */
    private Map f3445o;

    /* JADX INFO: renamed from: p */
    private Map f3446p;

    /* JADX INFO: renamed from: q */
    private Set f3447q;

    public C1213ff(Context context, String str, String str2, String str3, FilenameFilter filenameFilter) {
        this(context, null, str2, str3, null, filenameFilter, null);
    }

    public C1213ff(Context context, String str, String str2, String str3, Map map, FilenameFilter filenameFilter, InterfaceC1221fn interfaceC1221fn) {
        this.f3438h = new ArrayList();
        this.f3441k = new HashSet();
        this.f3442l = new C1214fg(this, 64);
        this.f3443m = new C1218fk();
        this.f3445o = new HashMap();
        this.f3446p = new HashMap();
        this.f3447q = new HashSet();
        this.f3431a = new WeakReference(context);
        if (interfaceC1221fn != null) {
            this.f3432b = new WeakReference(interfaceC1221fn);
        }
        this.f3434d = str;
        this.f3435e = str3;
        this.f3436f = str2;
        this.f3440j = map;
        this.f3439i = filenameFilter;
        this.f3437g = context.getResources().getString(R.string.resolution);
        this.f3433c = interfaceC1221fn != null ? R.layout.item_file_selectable : R.layout.item_file;
        if (str != null) {
            m3027f(str);
        }
        m3028g(str2);
    }

    /* JADX INFO: renamed from: a */
    private C1129dd m3015a(String str, boolean z) throws Throwable {
        String str2;
        String str3;
        C1481m c1481m;
        Bitmap bitmapM3518a;
        Bitmap bitmapM3518a2 = null;
        String str4 = (String) this.f3446p.get(str);
        if (str4 == null) {
            str4 = (String) this.f3445o.get(str);
        }
        C1216fi c1216fi = (str4 == null || (bitmapM3518a = (c1481m = new C1481m()).m3518a(str4, 32, 32)) == null) ? null : new C1216fi(bitmapM3518a, c1481m.m3517a(), c1481m.m3519b());
        if (c1216fi != null) {
            bitmapM3518a2 = c1216fi.f3451a;
            str2 = this.f3437g + ": " + c1216fi.f3452b + " X " + c1216fi.f3453c;
        } else if (this.f3434d == null) {
            C1481m c1481m2 = new C1481m();
            bitmapM3518a2 = c1481m2.m3518a(this.f3435e + "/" + str, 32, 32);
            str2 = this.f3437g + ": " + c1481m2.m3517a() + " X " + c1481m2.m3519b();
        } else if (z || !str.endsWith(".9.png")) {
            if (this.f3440j != null && (str3 = (String) this.f3440j.get(str)) != null) {
                str = str3;
            }
            C1216fi c1216fi2 = (C1216fi) this.f3442l.get(str);
            if (c1216fi2 == null) {
                Bitmap bitmapM3261a = this.f3444n.m3261a(str, 32, 32);
                if (bitmapM3261a != null) {
                    c1216fi2 = new C1216fi(bitmapM3261a, this.f3444n.m3260a(), this.f3444n.m3262b());
                }
                if (c1216fi2 != null) {
                    this.f3442l.put(str, c1216fi2);
                }
            }
            if (c1216fi2 != null) {
                bitmapM3518a2 = c1216fi2.f3451a;
                str2 = this.f3437g + ": " + c1216fi2.f3452b + " X " + c1216fi2.f3453c;
            } else {
                str2 = null;
            }
        } else {
            C1481m c1481m3 = new C1481m();
            bitmapM3518a2 = c1481m3.m3518a(this.f3435e + "/" + str, 32, 32);
            str2 = this.f3437g + ": " + c1481m3.m3517a() + " X " + c1481m3.m3519b();
        }
        return new C1129dd(bitmapM3518a2, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public List m3018a(File file) {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    file2.delete();
                    arrayList.add(file2.getPath());
                } else {
                    arrayList.addAll(m3018a(file2));
                }
            }
        }
        file.delete();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public Map m3020a(File file, File file2, String str) throws Throwable {
        if (!file2.exists()) {
            file2.mkdirs();
        }
        HashMap map = new HashMap();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file3 : fileArrListFiles) {
                String name = file3.getName();
                if (file3.isFile()) {
                    File file4 = new File(file2, file3.getName());
                    C1476h.m3509a(file3, file4);
                    map.put(str + "/" + name, file4.getPath());
                } else {
                    map.putAll(m3020a(file3, new File(file2, file3.getName()), str + "/" + name));
                }
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    private static void m3023a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m3025b(String str) {
        return str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".jpeg") || str.endsWith(".webp");
    }

    /* JADX INFO: renamed from: f */
    private void m3027f(String str) {
        try {
            ZipFile zipFile = new ZipFile(str);
            this.f3444n = new C1345aa(zipFile);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                String name = enumerationEntries.nextElement().getName();
                if (!name.startsWith("res/") && !name.startsWith("r/") && !name.startsWith("META-INF/")) {
                    String[] strArrSplit = name.split("/");
                    if (strArrSplit.length != 1 || (!name.equals(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME) && !name.endsWith(".dex") && !name.endsWith(".arsc"))) {
                        this.f3443m.m3068a(strArrSplit, true);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: renamed from: g */
    private void m3028g(String str) {
        synchronized (this.f3438h) {
            if (new File(str).exists()) {
                m3032i(str);
            } else {
                m3030h(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m3029g(String str, String str2) {
        if (this.f3447q.contains(str)) {
            this.f3447q.remove(str);
            this.f3445o.put(str, str2);
        } else if (this.f3445o.containsKey(str)) {
            Log.d("DEBUG", "error: " + str + " already exist?");
        } else {
            this.f3446p.put(str, str2);
        }
    }

    /* JADX INFO: renamed from: h */
    private void m3030h(String str) {
        C1218fk c1218fkM3067a = this.f3443m.m3067a(str.substring(this.f3435e.length() + 1).split("/"));
        if (c1218fkM3067a != null) {
            this.f3438h.clear();
            List<C1218fk> list = c1218fkM3067a.f3458a;
            if (list != null) {
                for (C1218fk c1218fk : list) {
                    C1450a c1450a = new C1450a();
                    c1450a.f4255a = c1218fk.f3459b;
                    c1450a.f4256b = !c1218fk.f3460c;
                    c1450a.f4257c = true;
                    this.f3438h.add(c1450a);
                }
                Collections.sort(this.f3438h, new C1451b());
            }
            C1450a c1450a2 = new C1450a();
            c1450a2.f4255a = "..";
            c1450a2.f4256b = true;
            this.f3438h.add(0, c1450a2);
            this.f3436f = str;
        }
    }

    /* JADX INFO: renamed from: h */
    private void m3031h(String str, String str2) {
        if (this.f3446p.containsKey(str)) {
            this.f3446p.put(str, str2);
        } else if (this.f3447q.contains(str)) {
            Log.d("DEBUG", "error: " + str + " is already deleted?");
        } else {
            this.f3445o.put(str, str2);
        }
    }

    /* JADX INFO: renamed from: i */
    private void m3032i(String str) {
        File file = new File(str);
        boolean zEquals = str.equals(this.f3435e);
        File[] fileArrListFiles = (!zEquals || this.f3439i == null) ? file.listFiles() : file.listFiles(this.f3439i);
        if (fileArrListFiles == null) {
            if (C0985a.m2260c(str, Environment.getExternalStorageDirectory().getPath())) {
                this.f3438h.clear();
                Environment.getExternalStorageDirectory().getPath();
                C1450a c1450a = new C1450a();
                c1450a.f4255a = C0985a.m2264d(str, Environment.getExternalStorageDirectory().getPath());
                c1450a.f4256b = true;
                this.f3438h.add(c1450a);
                if (!str.equals(this.f3435e)) {
                    C1450a c1450a2 = new C1450a();
                    c1450a2.f4255a = "..";
                    c1450a2.f4256b = true;
                    this.f3438h.add(0, c1450a2);
                }
                this.f3436f = str;
                return;
            }
            return;
        }
        this.f3438h.clear();
        for (File file2 : fileArrListFiles) {
            C1450a c1450a3 = new C1450a();
            c1450a3.f4255a = file2.getName();
            c1450a3.f4256b = file2.isDirectory();
            this.f3438h.add(c1450a3);
        }
        try {
            Collections.sort(this.f3438h, new C1451b());
        } catch (Exception e) {
        }
        if (zEquals) {
            ArrayList arrayList = new ArrayList();
            List<C1218fk> list = this.f3443m.f3458a;
            if (list != null && !list.isEmpty()) {
                for (C1218fk c1218fk : list) {
                    C1450a c1450a4 = new C1450a();
                    c1450a4.f4255a = c1218fk.f3459b;
                    c1450a4.f4256b = !c1218fk.f3460c;
                    c1450a4.f4257c = true;
                    arrayList.add(c1450a4);
                }
                Collections.sort(arrayList, new C1451b());
                this.f3438h.addAll(arrayList);
            }
        } else {
            C1450a c1450a5 = new C1450a();
            c1450a5.f4255a = "..";
            c1450a5.f4256b = true;
            this.f3438h.add(0, c1450a5);
        }
        this.f3436f = str;
    }

    /* JADX INFO: renamed from: j */
    private void m3033j(String str) throws Exception {
        if (str.equals("META-INF")) {
            m3034k(str);
        }
        ZipFile zipFile = new ZipFile(this.f3434d);
        if (zipFile.getEntry(str) == null) {
            zipFile.close();
        } else {
            zipFile.close();
            m3034k(str);
        }
    }

    /* JADX INFO: renamed from: k */
    private void m3034k(String str) throws Exception {
        throw new Exception(String.format(((Context) this.f3431a.get()).getString(R.string.file_already_exist), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l */
    public void m3035l(String str) {
        if (this.f3446p.containsKey(str)) {
            this.f3446p.remove(str);
        } else if (!this.f3445o.containsKey(str)) {
            this.f3447q.add(str);
        } else {
            this.f3445o.remove(str);
            this.f3447q.add(str);
        }
    }

    /* JADX INFO: renamed from: a */
    public final C1129dd m3036a(String str) {
        return m3015a(str.substring(this.f3435e.length() + 1), false);
    }

    /* JADX INFO: renamed from: a */
    public final C1450a m3037a(String str, InputStream inputStream) throws Exception {
        boolean z;
        boolean z2;
        int iLastIndexOf = str.lastIndexOf(47);
        String strSubstring = str.substring(0, iLastIndexOf);
        String strSubstring2 = str.substring(iLastIndexOf + 1);
        String strSubstring3 = strSubstring.equals(this.f3435e) ? strSubstring2 : str.substring(this.f3435e.length() + 1);
        if (strSubstring.equals(this.f3435e) && this.f3434d != null) {
            m3033j(strSubstring2);
        }
        File file = new File(strSubstring);
        String str2 = this.f3435e + "/res";
        if (strSubstring.equals(str2) || strSubstring.startsWith(str2 + "/")) {
            z = true;
        } else {
            String str3 = this.f3435e + "/smali";
            z = strSubstring.equals(str3) || strSubstring.startsWith(new StringBuilder().append(str3).append("/").toString()) || strSubstring.startsWith(new StringBuilder().append(str3).append("_").toString());
        }
        if (z || (file.exists() && !strSubstring.equals(this.f3435e))) {
            if (!file.exists()) {
                file.mkdirs();
            }
            if (new File(str).exists()) {
                m3034k(strSubstring3);
                z2 = false;
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                C0985a.m2244b(inputStream, fileOutputStream);
                fileOutputStream.close();
                z2 = false;
            }
        } else {
            String[] strArrSplit = strSubstring3.split("/");
            if (this.f3443m.m3069b(strArrSplit) != null) {
                m3034k(strSubstring3);
                z2 = true;
            } else {
                str = C0985a.m2263d((Context) this.f3431a.get(), "tmp") + C1487s.m3525a(8);
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                C0985a.m2244b(inputStream, fileOutputStream2);
                fileOutputStream2.close();
                this.f3443m.m3068a(strArrSplit, true);
                z2 = true;
            }
        }
        m3029g(strSubstring3, str);
        return new C1450a(strSubstring2, false, z2);
    }

    /* JADX INFO: renamed from: a */
    public final String m3038a(List list) {
        String str;
        synchronized (this.f3438h) {
            if (list != null) {
                list.addAll(this.f3438h);
                str = this.f3436f;
            } else {
                str = this.f3436f;
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    public final void m3039a() {
        m3051c(this.f3436f);
    }

    /* JADX INFO: renamed from: a */
    public final void m3040a(int i) {
        if (i == 0 && !this.f3438h.isEmpty() && "..".equals(((C1450a) this.f3438h.get(0)).f4255a)) {
            return;
        }
        if (this.f3441k.contains(Integer.valueOf(i))) {
            this.f3441k.remove(Integer.valueOf(i));
        } else {
            this.f3441k.add(Integer.valueOf(i));
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: a */
    public final void m3041a(String str, C1450a c1450a) {
        synchronized (this.f3438h) {
            if (this.f3436f.equals(str)) {
                this.f3438h.add(c1450a);
                notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.gmail.heagoo.apkeditor.ff] */
    /* JADX INFO: renamed from: a */
    public final void m3042a(String str, String str2) throws Throwable {
        Exception exc;
        int iLastIndexOf = str.lastIndexOf("/");
        String strSubstring = str.substring(iLastIndexOf + 1);
        String strSubstring2 = str.substring(0, iLastIndexOf);
        ?? r2 = 0;
        r2 = 0;
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(str2);
                try {
                    m3041a(strSubstring2, m3037a(str, fileInputStream));
                    r2 = String.format(((Context) this.f3431a.get()).getString(R.string.file_added), strSubstring);
                    Toast.makeText((Context) this.f3431a.get(), (CharSequence) r2, 0).show();
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Exception e2) {
                    r2 = fileInputStream;
                    exc = e2;
                    Toast.makeText((Context) this.f3431a.get(), String.format(((Context) this.f3431a.get()).getString(R.string.failed_1), exc.getMessage()), 1).show();
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r2 = fileInputStream;
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                exc = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3043a(String str, String str2, boolean z) throws Exception {
        if (str.equals(this.f3435e) && this.f3434d != null) {
            m3033j(str2);
        }
        if (!new File(str).exists() || str.equals(this.f3435e)) {
            String[] strArrSplit = (str.equals(this.f3435e) ? str2 : str.substring(this.f3435e.length() + 1) + "/" + str2).split("/");
            if (this.f3443m.m3069b(strArrSplit) != null) {
                m3034k(str2);
                return;
            }
            this.f3443m.m3068a(strArrSplit, false);
            if (z) {
                m3051c(str);
                return;
            }
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            m3034k(str2);
        }
        boolean zMkdir = file.mkdir();
        if (z) {
            if (zMkdir || this.f3431a.get() == null) {
                m3051c(str);
            } else {
                Toast.makeText((Context) this.f3431a.get(), R.string.failed, 1).show();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3044a(Map map, Set set, Map map2) {
        if (map != null) {
            this.f3446p = map;
        }
        if (set != null) {
            this.f3447q = set;
        }
        if (map2 != null) {
            this.f3445o = map2;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3045a(boolean z) {
        if (z) {
            if (!((C1450a) this.f3438h.get(0)).f4255a.equals("..")) {
                this.f3441k.add(0);
            }
            for (int i = 1; i < this.f3438h.size(); i++) {
                this.f3441k.add(Integer.valueOf(i));
            }
        } else {
            this.f3441k.clear();
            if (this.f3432b.get() != null) {
                ((InterfaceC1221fn) this.f3432b.get()).mo2445b(this.f3441k);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: b */
    public final Map m3046b() {
        return this.f3446p;
    }

    /* JADX INFO: renamed from: b */
    public final void m3047b(String str, String str2) {
        try {
            m3043a(str, str2, true);
        } catch (Exception e) {
            Toast.makeText((Context) this.f3431a.get(), e.getMessage(), 1).show();
        }
    }

    /* JADX INFO: renamed from: b */
    protected final void m3048b(List list) {
        Iterator it = this.f3438h.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            if (list.contains(Integer.valueOf(i))) {
                it.remove();
            }
            i++;
        }
        this.f3441k.clear();
        notifyDataSetChanged();
        if (this.f3432b.get() != null) {
            ((InterfaceC1221fn) this.f3432b.get()).mo2445b(this.f3441k);
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3049b(String str, String str2, boolean z) {
        List listM3018a;
        List listM3070c;
        ArrayList arrayList = null;
        boolean z2 = true;
        if (z) {
            if (!str.equals(this.f3435e)) {
                str2 = str.substring(this.f3435e.length() + 1) + "/" + str2;
            }
            listM3070c = this.f3443m.m3070c(str2.split("/"));
        } else {
            String str3 = str + "/" + str2;
            File file = new File(str3);
            if (!file.exists()) {
                listM3018a = null;
            } else if (file.isFile()) {
                file.delete();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str3);
                listM3018a = arrayList2;
            } else {
                listM3018a = m3018a(file);
            }
            if (listM3018a != null) {
                arrayList = new ArrayList();
                Iterator it = listM3018a.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).substring(this.f3435e.length() + 1));
                }
            }
            if (listM3018a != null) {
                listM3070c = arrayList;
            } else {
                z2 = false;
                listM3070c = arrayList;
            }
        }
        if (listM3070c != null) {
            Iterator it2 = listM3070c.iterator();
            while (it2.hasNext()) {
                m3035l((String) it2.next());
            }
        }
        return z2;
    }

    /* JADX INFO: renamed from: c */
    public final Map m3050c() {
        return this.f3445o;
    }

    /* JADX INFO: renamed from: c */
    public final void m3051c(String str) {
        if (!this.f3435e.startsWith(str) || str.equals(this.f3435e)) {
            m3028g(str);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m3052c(String str, String str2) {
        m3031h(str, str2);
    }

    /* JADX INFO: renamed from: c */
    protected final void m3053c(List list) {
        ArrayList arrayList = new ArrayList();
        String strM3038a = m3038a(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            C1450a c1450a = (C1450a) arrayList.get(iIntValue);
            if (c1450a != null) {
                m3049b(strM3038a, c1450a.f4255a, c1450a.f4257c);
                arrayList2.add(Integer.valueOf(iIntValue));
            }
        }
        m3048b(arrayList2);
    }

    /* JADX INFO: renamed from: d */
    public final String m3054d(String str) {
        String str2 = (String) this.f3445o.get(str);
        return str2 == null ? (String) this.f3446p.get(str) : str2;
    }

    /* JADX INFO: renamed from: d */
    public final Set m3055d() {
        return this.f3447q;
    }

    /* JADX INFO: renamed from: d */
    public final void m3056d(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        String strSubstring = str.substring(this.f3435e.length() + 1);
        if (new File(str).exists()) {
            try {
                fileInputStream = new FileInputStream(str2);
                try {
                    fileOutputStream = new FileOutputStream(str);
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = null;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    C0985a.m2244b(fileInputStream, fileOutputStream);
                    m3031h(strSubstring, str);
                    Toast.makeText((Context) this.f3431a.get(), R.string.file_replaced, 0).show();
                    m3023a(fileInputStream);
                    m3023a(fileOutputStream);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        e.printStackTrace();
                        m3023a(fileInputStream2);
                        m3023a(fileOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        m3023a(fileInputStream);
                        m3023a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    m3023a(fileInputStream);
                    m3023a(fileOutputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                fileInputStream = null;
            }
        } else {
            try {
                String str3 = C0985a.m2263d((Context) this.f3431a.get(), "tmp") + C1487s.m3525a(8);
                C1476h.m3510a(str2, str3);
                m3031h(strSubstring, str3);
                Toast.makeText((Context) this.f3431a.get(), R.string.file_replaced, 0).show();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: e */
    public final Set m3057e() {
        return this.f3441k;
    }

    /* JADX INFO: renamed from: e */
    public final void m3058e(String str, String str2) {
        new DialogC1201ey((Activity) this.f3431a.get(), new C1215fh(this, str, str2), R.string.folder_replaced).show();
    }

    /* JADX INFO: renamed from: e */
    public final boolean m3059e(String str) {
        if (new File(str).exists() || this.f3435e.equals(str)) {
            return true;
        }
        return this.f3443m.m3067a(str.substring(this.f3435e.length() + 1).split("/")) != null;
    }

    /* JADX INFO: renamed from: f */
    public final void m3060f(String str, String str2) {
        if (this.f3446p != null) {
            for (Map.Entry entry : this.f3446p.entrySet()) {
                if (((String) entry.getValue()).startsWith(str)) {
                    entry.setValue(str2 + ((String) entry.getValue()).substring(str.length()));
                }
            }
        }
        if (this.f3445o != null) {
            for (Map.Entry entry2 : this.f3445o.entrySet()) {
                if (((String) entry2.getValue()).startsWith(str)) {
                    entry2.setValue(str2 + ((String) entry2.getValue()).substring(str.length()));
                }
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final boolean m3061f() {
        return this.f3436f.equals(this.f3435e);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3438h.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f3438h.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public final View getView(int i, View view, ViewGroup viewGroup) throws Throwable {
        C1217fj c1217fj;
        String str;
        String str2;
        C1450a c1450a = (C1450a) this.f3438h.get(i);
        if (view == null) {
            view = LayoutInflater.from((Context) this.f3431a.get()).inflate(this.f3433c, (ViewGroup) null);
            C1217fj c1217fj2 = new C1217fj((byte) 0);
            c1217fj2.f3454a = (ImageView) view.findViewById(R.id.file_icon);
            c1217fj2.f3455b = (TextView) view.findViewById(R.id.filename);
            c1217fj2.f3456c = (TextView) view.findViewById(R.id.detail1);
            c1217fj2.f3457d = (CheckBox) view.findViewById(R.id.checkBox);
            view.setTag(c1217fj2);
            c1217fj = c1217fj2;
        } else {
            c1217fj = (C1217fj) view.getTag();
        }
        c1217fj.f3455b.setText(c1450a.f4255a);
        if (c1450a.f4255a.equals("..")) {
            c1217fj.f3454a.setImageResource(R.drawable.ic_file_up);
            str = null;
        } else if (c1450a.f4256b) {
            c1217fj.f3454a.setImageResource(R.drawable.ic_file_folder);
            str = null;
        } else {
            if (c1450a.f4255a.endsWith(".xml")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_xml);
            }
            if (c1450a.f4255a.endsWith(".smali")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_smali);
            }
            if (c1450a.f4255a.endsWith(".htm")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_html);
            }
            if (c1450a.f4255a.endsWith(".html")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_html);
            }
            if (c1450a.f4255a.endsWith(".rar")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_zip);
            }
            if (c1450a.f4255a.endsWith(".zip")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_zip);
            }
            if (c1450a.f4255a.endsWith(".dex")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_dex);
            }
            if (c1450a.f4255a.endsWith(".properties")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_text);
            }
            if (c1450a.f4255a.endsWith(".css")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_text);
            }
            if (c1450a.f4255a.endsWith(".java")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_text);
            }
            if (c1450a.f4255a.endsWith(".js")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_text);
            }
            if (c1450a.f4255a.endsWith(".MF")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_text);
            }
            if (c1450a.f4255a.endsWith(".SF")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_text);
            }
            if (c1450a.f4255a.endsWith(".txt")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_text);
            }
            if (c1450a.f4255a.endsWith(".apk")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_apk);
            }
            if (c1450a.f4255a.endsWith(".ttf")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_ttf);
            }
            if (m3025b(c1450a.f4255a)) {
                String str3 = this.f3436f;
                String str4 = c1450a.f4255a;
                if (str3.equals(this.f3435e)) {
                    str2 = str4;
                } else {
                    str2 = str3.substring(this.f3435e.endsWith("/") ? this.f3435e.length() : this.f3435e.length() + 1) + "/" + str4;
                }
                C1129dd c1129ddM3015a = m3015a(str2, c1450a.f4257c);
                c1217fj.f3454a.setImageBitmap(c1129ddM3015a.f3193a);
                str = c1129ddM3015a.f3194b;
            } else if (c1450a.f4255a.endsWith(".xml")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_xml);
                str = null;
            } else if (c1450a.f4255a.endsWith(".smali")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_smali);
                str = null;
            } else if (c1450a.f4255a.endsWith(".htm") || c1450a.f4255a.endsWith(".html")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_html);
                str = null;
            } else if (c1450a.f4255a.endsWith(".rar") || c1450a.f4255a.endsWith(".zip")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_zip);
                str = null;
            } else if (c1450a.f4255a.endsWith(".dex")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_dex);
                str = null;
            } else if (c1450a.f4255a.endsWith(".properties") || c1450a.f4255a.endsWith(".css") || c1450a.f4255a.endsWith(".java") || c1450a.f4255a.endsWith(".js") || c1450a.f4255a.endsWith(".MF") || c1450a.f4255a.endsWith(".SF") || c1450a.f4255a.endsWith(".txt")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_text);
                str = null;
            } else if (c1450a.f4255a.endsWith(".apk")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_apk);
                str = null;
            } else if (c1450a.f4255a.endsWith(".ttf")) {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_ttf);
                str = null;
            } else {
                c1217fj.f3454a.setImageResource(R.drawable.ic_file_unknown);
                str = null;
            }
        }
        if (str != null) {
            c1217fj.f3456c.setText(str);
            c1217fj.f3456c.setVisibility(0);
        } else {
            c1217fj.f3456c.setVisibility(8);
        }
        if (c1217fj.f3457d != null) {
            if (i == 0 && c1450a.f4255a.equals("..")) {
                c1217fj.f3457d.setVisibility(4);
            } else {
                c1217fj.f3457d.setVisibility(0);
                c1217fj.f3457d.setId(i);
                c1217fj.f3457d.setOnCheckedChangeListener(this);
                c1217fj.f3457d.setChecked(this.f3441k.contains(Integer.valueOf(i)));
            }
        }
        return view;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (z) {
            this.f3441k.add(Integer.valueOf(id));
        } else {
            this.f3441k.remove(Integer.valueOf(id));
        }
        if (this.f3432b != null) {
            ((InterfaceC1221fn) this.f3432b.get()).mo2445b(this.f3441k);
        }
    }
}
