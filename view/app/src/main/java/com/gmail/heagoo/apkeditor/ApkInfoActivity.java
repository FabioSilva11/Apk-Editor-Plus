package com.gmail.heagoo.apkeditor;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.view.PointerIconCompat;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.android.apksig.apk.ApkUtils;
import com.gmail.heagoo.apkeditor.p062ac.C1037a;
import com.gmail.heagoo.apkeditor.p067f.AsyncTaskC1204a;
import com.gmail.heagoo.apkeditor.p067f.InterfaceC1205b;
import com.gmail.heagoo.apkeditor.p069ui.DialogC1373a;
import com.gmail.heagoo.apkeditor.p069ui.InterfaceC1374b;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.apkeditor.translate.PossibleLanguages;
import com.gmail.heagoo.apkeditor.translate.TranslateItem;
import com.gmail.heagoo.common.C1470b;
import com.gmail.heagoo.common.C1476h;
import com.gmail.heagoo.common.C1487s;
import com.gmail.heagoo.common.C1491w;
import com.gmail.heagoo.httpserver.C1496e;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.gmail.heagoo.p070b.C1450a;
import com.gmail.heagoo.pngeditor.PngEditActivity;
import common.types.ActivityState_V1;
import common.types.ProjectInfo_V1;
import common.types.StringItem;
import jadx.core.deobf.Deobfuscator;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import p000a.p001a.p003b.p004a.C0029c;
import p000a.p001a.p003b.p004a.C0031e;
import p000a.p001a.p003b.p004a.C0032f;
import p000a.p001a.p003b.p004a.C0033g;
import p000a.p001a.p003b.p004a.p005a.AbstractC0023t;
import p000a.p001a.p003b.p004a.p005a.C0022s;
import p000a.p001a.p003b.p004a.p005a.C0026w;
import p000a.p001a.p003b.p004a.p005a.C0027x;
import p000a.p011d.C0073e;
import p000a.p011d.C0076h;
import p000a.p011d.C0077i;

/* JADX INFO: loaded from: classes.dex */
public class ApkInfoActivity extends Activity implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, InterfaceC1079bf, InterfaceC1126cz, InterfaceC1205b, InterfaceC1221fn, InterfaceC1374b {

    /* JADX INFO: renamed from: A */
    private ListView f2557A;

    /* JADX INFO: renamed from: B */
    private C1255gv f2558B;

    /* JADX INFO: renamed from: C */
    private Map f2559C;

    /* JADX INFO: renamed from: E */
    private ArrayList f2561E;

    /* JADX INFO: renamed from: F */
    private LinearLayout f2562F;

    /* JADX INFO: renamed from: G */
    private ListView f2563G;

    /* JADX INFO: renamed from: I */
    private View f2565I;

    /* JADX INFO: renamed from: J */
    private View f2566J;

    /* JADX INFO: renamed from: K */
    private HorizontalScrollView f2567K;

    /* JADX INFO: renamed from: L */
    private LinearLayout f2568L;

    /* JADX INFO: renamed from: M */
    private View f2569M;

    /* JADX INFO: renamed from: N */
    private TextView f2570N;

    /* JADX INFO: renamed from: O */
    private LinearLayout f2571O;

    /* JADX INFO: renamed from: P */
    private ListView f2572P;

    /* JADX INFO: renamed from: Q */
    private C1141dt f2573Q;

    /* JADX INFO: renamed from: R */
    private LinearLayout f2574R;

    /* JADX INFO: renamed from: S */
    private View f2575S;

    /* JADX INFO: renamed from: U */
    private View f2576U;

    /* JADX INFO: renamed from: V */
    private View f2577V;

    /* JADX INFO: renamed from: W */
    private C1080bg f2578W;

    /* JADX INFO: renamed from: a */
    protected String f2582a;

    /* JADX INFO: renamed from: aA */
    private String f2583aA;

    /* JADX INFO: renamed from: aB */
    private InterfaceC1254gu f2584aB;

    /* JADX INFO: renamed from: aC */
    private String f2585aC;

    /* JADX INFO: renamed from: aD */
    private String f2586aD;

    /* JADX INFO: renamed from: aE */
    private String f2587aE;

    /* JADX INFO: renamed from: aF */
    private long f2588aF;

    /* JADX INFO: renamed from: ad */
    private View f2591ad;

    /* JADX INFO: renamed from: ae */
    private Button f2592ae;

    /* JADX INFO: renamed from: af */
    private ProgressBar f2593af;

    /* JADX INFO: renamed from: ag */
    private View f2594ag;

    /* JADX INFO: renamed from: ah */
    private TextView f2595ah;

    /* JADX INFO: renamed from: ai */
    private TextView f2596ai;

    /* JADX INFO: renamed from: ak */
    private HashMap f2598ak;

    /* JADX INFO: renamed from: al */
    private HashMap f2599al;

    /* JADX INFO: renamed from: am */
    private ArrayList f2600am;

    /* JADX INFO: renamed from: an */
    private ArrayList f2601an;

    /* JADX INFO: renamed from: ao */
    private boolean f2602ao;

    /* JADX INFO: renamed from: ar */
    private String f2605ar;

    /* JADX INFO: renamed from: as */
    private Map f2606as;

    /* JADX INFO: renamed from: at */
    private Map f2607at;

    /* JADX INFO: renamed from: au */
    private Set f2608au;

    /* JADX INFO: renamed from: av */
    private C1037a f2609av;

    /* JADX INFO: renamed from: aw */
    private C1037a f2610aw;

    /* JADX INFO: renamed from: ax */
    private C1037a f2611ax;

    /* JADX INFO: renamed from: ay */
    private InterfaceC1125cy f2612ay;

    /* JADX INFO: renamed from: az */
    private String f2613az;

    /* JADX INFO: renamed from: b */
    protected String f2614b;

    /* JADX INFO: renamed from: c */
    C1470b f2615c;

    /* JADX INFO: renamed from: d */
    HashMap f2616d;

    /* JADX INFO: renamed from: e */
    C1213ff f2617e;

    /* JADX INFO: renamed from: f */
    protected ViewOnClickListenerC1219fl f2618f;

    /* JADX INFO: renamed from: g */
    protected ImageView f2619g;

    /* JADX INFO: renamed from: h */
    protected ImageView f2620h;

    /* JADX INFO: renamed from: k */
    protected Map f2623k;

    /* JADX INFO: renamed from: l */
    protected int f2624l;

    /* JADX INFO: renamed from: m */
    protected boolean f2625m;

    /* JADX INFO: renamed from: n */
    private ImageView f2626n;

    /* JADX INFO: renamed from: o */
    private TextView f2627o;

    /* JADX INFO: renamed from: p */
    private TextView f2628p;

    /* JADX INFO: renamed from: q */
    private RadioButton f2629q;

    /* JADX INFO: renamed from: r */
    private RadioButton f2630r;

    /* JADX INFO: renamed from: s */
    private RadioButton f2631s;

    /* JADX INFO: renamed from: z */
    private LinearLayout f2632z;

    /* JADX INFO: renamed from: D */
    private String f2560D = null;

    /* JADX INFO: renamed from: H */
    private Stack f2564H = new Stack();

    /* JADX INFO: renamed from: X */
    private boolean f2579X = false;

    /* JADX INFO: renamed from: Y */
    private boolean f2580Y = false;

    /* JADX INFO: renamed from: i */
    protected boolean f2621i = true;

    /* JADX INFO: renamed from: j */
    protected boolean f2622j = true;

    /* JADX INFO: renamed from: Z */
    private boolean f2581Z = false;

    /* JADX INFO: renamed from: aa */
    private boolean f2589aa = false;

    /* JADX INFO: renamed from: ab */
    private int f2590ab = 0;

    /* JADX INFO: renamed from: aj */
    private boolean f2597aj = false;

    /* JADX INFO: renamed from: ap */
    private boolean f2603ap = false;

    /* JADX INFO: renamed from: aq */
    private int f2604aq = 0;

    /* JADX INFO: renamed from: a */
    public static C0029c m2374a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((C0029c) it.next()).m42a());
        }
        String strM2400c = m2400c(hashSet);
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            C0029c c0029c = (C0029c) it2.next();
            if (c0029c.m42a().equals(strM2400c)) {
                return c0029c;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ C1080bg m2375a(ApkInfoActivity apkInfoActivity, C1080bg c1080bg) {
        apkInfoActivity.f2578W = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public ActivityState_V1 m2377a(String str, boolean z, File file) {
        ActivityState_V1 activityState_V1 = new ActivityState_V1();
        Map mapM3115a = this.f2558B.m3115a();
        if (mapM3115a != null && !mapM3115a.isEmpty()) {
            this.f2579X = true;
            String str2 = str + "changedStringValues";
            C0985a.m2225a(str2, mapM3115a);
            activityState_V1.putString("changedStringValues_file", str2);
        }
        if (!this.f2625m && this.f2617e != null) {
            activityState_V1.putString("res_current_dir", this.f2617e.m3038a((List) null));
            Map mapM3046b = this.f2617e.m3046b();
            Map mapM3050c = this.f2617e.m3050c();
            Set setM3055d = this.f2617e.m3055d();
            if (file != null) {
                m2390a(mapM3046b, mapM3050c, file);
            }
            if (mapM3046b != null && !mapM3046b.isEmpty()) {
                String str3 = str + "res_added";
                C0985a.m2225a(str3, mapM3046b);
                activityState_V1.putString("res_added_file", str3);
            }
            if (mapM3050c != null && !mapM3050c.isEmpty()) {
                String str4 = str + "res_replaced";
                C0985a.m2225a(str4, mapM3050c);
                activityState_V1.putString("res_replaced_file", str4);
            }
            if (setM3055d != null && !setM3055d.isEmpty()) {
                String str5 = str + "res_deleted";
                C0985a.m2225a(str5, setM3055d);
                activityState_V1.putString("res_deleted_file", str5);
            }
        }
        String str6 = str + "allStringValues";
        if (z) {
            C0985a.m2225a(str6, this.f2616d);
        }
        activityState_V1.putString("allStringValues_file", str6);
        String str7 = str + "fileEntry2ZipEntry";
        if (z && !this.f2625m) {
            C0985a.m2225a(str7, this.f2623k);
        }
        activityState_V1.putString("fileEntry2ZipEntry_file", str7);
        activityState_V1.putString("curConfig", this.f2560D.toString());
        activityState_V1.putSerializable("langConfigList", this.f2561E);
        activityState_V1.putBoolean("stringModified", this.f2579X);
        activityState_V1.putBoolean("manifestModified", this.f2580Y);
        activityState_V1.putBoolean("stringParsed", this.f2581Z);
        activityState_V1.putBoolean("resourceParsed", this.f2589aa);
        activityState_V1.putBoolean("bStringPrepared", this.f2603ap);
        activityState_V1.putBoolean("searchTextContent", this.f2621i);
        activityState_V1.putBoolean("searchResSensitive", this.f2622j);
        activityState_V1.putInt("curSelectedRadio", this.f2590ab);
        activityState_V1.putInt("rotateClickedTimes", this.f2604aq);
        activityState_V1.putBoolean("dex2smaliClicked", this.f2597aj);
        activityState_V1.putString("savedParam_extraStr", this.f2583aA);
        activityState_V1.putString("savedParam_filePath", this.f2613az);
        activityState_V1.putBoolean("isFullDecoding", this.f2625m);
        return activityState_V1;
    }

    /* JADX INFO: renamed from: a */
    public static ProjectInfo_V1 m2378a(String str) {
        String str2 = str + "/.prj_version";
        String str3 = str + "/ae.prj";
        File file = new File(str2);
        File file2 = new File(str3);
        if (file.exists() && file2.exists()) {
            try {
                switch (Integer.valueOf(new C1491w(str2).m3537b()).intValue()) {
                    case 1:
                        return (ProjectInfo_V1) C0985a.m2280j(str3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static String m2380a(String str, String str2, String str3) {
        if (str2.endsWith("/")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        String str4 = str2 + "/" + str3 + ".apk";
        int iLastIndexOf = str.lastIndexOf(47);
        String strSubstring = str.substring(0, iLastIndexOf);
        String strSubstring2 = str.substring(iLastIndexOf + 1);
        if (!strSubstring.equals(str2) || !strSubstring2.startsWith(str3)) {
            return str4;
        }
        String strSubstring3 = strSubstring2.substring(str3.length());
        if (".apk".equals(strSubstring3)) {
            return str2 + "/" + str3 + "2.apk";
        }
        if (!strSubstring3.matches("[1-9][0-9]*\\.apk")) {
            return str4;
        }
        try {
            return str2 + "/" + str3 + (Integer.valueOf(strSubstring3.substring(0, strSubstring3.length() - 4)).intValue() + 1) + ".apk";
        } catch (Exception e) {
            return str4;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m2381a(String str, Set set) {
        if ((str.startsWith("smali/") || str.startsWith("smali_")) && str.endsWith(".smali")) {
            int iIndexOf = str.indexOf(47);
            strSubstring = iIndexOf != -1 ? str.substring(0, iIndexOf) : null;
            set.add(strSubstring);
        }
        return strSubstring;
    }

    /* JADX INFO: renamed from: a */
    private void m2382a(Bundle bundle) {
        new DialogC1201ey(this, new C1341q(this, bundle), -1).show();
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m2383a(ApkInfoActivity apkInfoActivity) {
        apkInfoActivity.m2421s();
        apkInfoActivity.m2428a();
        apkInfoActivity.m2426x();
        if (apkInfoActivity.f2597aj) {
            apkInfoActivity.f2591ad.setVisibility(8);
        }
        apkInfoActivity.m2415n();
        apkInfoActivity.f2575S.setVisibility(0);
        apkInfoActivity.f2576U.setVisibility(0);
        apkInfoActivity.f2577V.setVisibility(0);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m2384a(ApkInfoActivity apkInfoActivity, Bundle bundle) {
        apkInfoActivity.f2616d = (HashMap) C0985a.m2280j(bundle.getString("allStringValues_file"));
        String string = bundle.getString("changedStringValues_file");
        if (string != null) {
            apkInfoActivity.f2559C = (HashMap) C0985a.m2280j(string);
            HashMap map = apkInfoActivity.f2616d;
            for (Map.Entry entry : apkInfoActivity.f2559C.entrySet()) {
                String str = (String) entry.getKey();
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    Iterator it = ((ArrayList) map.get(str)).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            StringItem stringItem = (StringItem) it.next();
                            if (((String) entry2.getKey()).equals(stringItem.name)) {
                                stringItem.value = (String) entry2.getValue();
                                break;
                            }
                        }
                    }
                }
            }
        }
        apkInfoActivity.f2623k = (HashMap) C0985a.m2280j(bundle.getString("fileEntry2ZipEntry_file"));
        apkInfoActivity.f2560D = bundle.getString("curConfig");
        apkInfoActivity.f2561E = (ArrayList) bundle.getSerializable("langConfigList");
        apkInfoActivity.f2579X = bundle.getBoolean("stringModified");
        apkInfoActivity.f2580Y = bundle.getBoolean("manifestModified");
        apkInfoActivity.f2581Z = bundle.getBoolean("stringParsed");
        apkInfoActivity.f2589aa = bundle.getBoolean("resourceParsed");
        apkInfoActivity.f2603ap = bundle.getBoolean("bStringPrepared");
        apkInfoActivity.f2621i = bundle.getBoolean("searchTextContent");
        apkInfoActivity.f2622j = bundle.getBoolean("searchResSensitive");
        apkInfoActivity.f2590ab = bundle.getInt("curSelectedRadio");
        apkInfoActivity.f2604aq = bundle.getInt("rotateClickedTimes");
        apkInfoActivity.f2605ar = bundle.getString("res_current_dir");
        String string2 = bundle.getString("res_added_file");
        if (string2 != null) {
            apkInfoActivity.f2606as = (Map) C0985a.m2280j(string2);
        }
        String string3 = bundle.getString("res_replaced_file");
        if (string3 != null) {
            apkInfoActivity.f2607at = (Map) C0985a.m2280j(string3);
        }
        String string4 = bundle.getString("res_deleted_file");
        if (string4 != null) {
            apkInfoActivity.f2608au = (Set) C0985a.m2280j(string4);
        }
        apkInfoActivity.f2597aj = bundle.getBoolean("dex2smaliClicked");
        apkInfoActivity.f2583aA = bundle.getString("savedParam_extraStr");
        apkInfoActivity.f2613az = bundle.getString("savedParam_filePath");
        apkInfoActivity.f2625m = bundle.getBoolean("isFullDecoding");
    }

    /* JADX INFO: renamed from: a */
    private static void m2386a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2387a(String str, List list) throws IOException {
        m2396b(str, list);
        this.f2579X = true;
        String str2 = null;
        for (Map.Entry entry : this.f2616d.entrySet()) {
            String str3 = (String) entry.getKey();
            if (str3.equals(str)) {
                ArrayList arrayList = (ArrayList) entry.getValue();
                arrayList.clear();
                arrayList.addAll(list);
            } else {
                str3 = str2;
            }
            str2 = str3;
        }
        if (str2 == null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            this.f2616d.put(str, arrayList2);
        }
        m2425w();
    }

    /* JADX INFO: renamed from: a */
    private void m2388a(String str, List list, List list2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f2614b + "/AndroidManifest.xml");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            int i = 1;
            while (line != null) {
                if (line.contains(str)) {
                    list.add(Integer.valueOf(i));
                    list2.add(line);
                }
                line = bufferedReader.readLine();
                i++;
            }
            bufferedReader.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2389a(ArrayList arrayList) {
        this.f2558B.m3117a(this.f2560D, arrayList);
    }

    /* JADX INFO: renamed from: a */
    private void m2390a(Map map, Map map2, File file) {
        try {
            String strM2263d = C0985a.m2263d(this, "tmp");
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getValue();
                    if (str != null && str.startsWith(strM2263d)) {
                        File file2 = new File(str);
                        File file3 = new File(file, file2.getName());
                        if (file2.renameTo(file3)) {
                            entry.setValue(file3.getPath());
                        }
                    }
                }
            }
            if (map2 == null || map2.isEmpty()) {
                return;
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                String str2 = (String) entry2.getValue();
                if (str2 != null && str2.startsWith(strM2263d)) {
                    File file4 = new File(str2);
                    File file5 = new File(file, file4.getName());
                    if (file4.renameTo(file5)) {
                        entry2.setValue(file5.getPath());
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2391a(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setDataAndType(null, "application/com.gmail.heagoo.apkeditor-translate");
        return context.getPackageManager().queryIntentActivities(intent, 0).size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static boolean m2393a(String str, ProjectInfo_V1 projectInfo_V1) {
        String str2 = str + "/ae.prj";
        try {
            C0985a.m2245b(str + "/.prj_version", "1");
            return C0985a.m2225a(str2, projectInfo_V1);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    private String m2395b(Map map) {
        try {
            String str = C0985a.m2263d(this, "tmp") + C1487s.m3525a(8);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            for (Map.Entry entry : map.entrySet()) {
                bufferedOutputStream.write(((String) entry.getKey()).getBytes());
                bufferedOutputStream.write(10);
                bufferedOutputStream.write(((String) entry.getValue()).getBytes());
                bufferedOutputStream.write(10);
            }
            bufferedOutputStream.close();
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2396b(String str, List list) throws IOException {
        C0076h c0076h = new C0076h();
        String str2 = this.f2614b + "/res/values" + str;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str2 + "/strings.xml"));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        c0076h.setOutput(outputStreamWriter);
        outputStreamWriter.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        outputStreamWriter.write("<resources>\n");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            StringItem stringItem = (StringItem) it.next();
            c0076h.startTag(null, "string");
            c0076h.attribute(null, "name", stringItem.name);
            if (C0985a.m2266d(stringItem.value)) {
                c0076h.attribute(null, "formatted", "false");
            }
            c0076h.ignorableWhitespace((stringItem.value.startsWith("@string/") || stringItem.value.startsWith("@android:string/")) ? stringItem.value : stringItem.styledValue == null ? C0985a.m2254c(C0985a.m2198a(stringItem.value)) : C0985a.m2254c(stringItem.styledValue));
            c0076h.endTag(null, "string");
            c0076h.flush();
            outputStreamWriter.write("\n");
        }
        outputStreamWriter.write("</resources>\n");
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    /* JADX INFO: renamed from: b */
    private void m2397b(String str, List list, List list2) {
        ArrayList<StringItem> arrayList = null;
        ArrayList<StringItem> arrayList2 = null;
        for (Map.Entry entry : this.f2616d.entrySet()) {
            String str2 = (String) entry.getKey();
            if (str2.equals(str)) {
                arrayList = (ArrayList) entry.getValue();
            } else {
                arrayList2 = "".equals(str2) ? (ArrayList) entry.getValue() : arrayList2;
            }
        }
        if (arrayList2 == null) {
            if (arrayList != null) {
                for (StringItem stringItem : arrayList) {
                    list.add(new TranslateItem(stringItem.name, "", stringItem.value));
                }
                return;
            }
            return;
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (arrayList != null) {
            for (StringItem stringItem2 : arrayList) {
                map.put(stringItem2.name, stringItem2.value);
            }
        }
        for (StringItem stringItem3 : arrayList2) {
            map2.put(stringItem3.name, stringItem3.value);
        }
        if (arrayList != null) {
            for (StringItem stringItem4 : arrayList) {
                String str3 = stringItem4.name;
                list.add(new TranslateItem(str3, (String) map2.get(str3), stringItem4.value));
            }
        }
        for (StringItem stringItem5 : arrayList2) {
            String str4 = stringItem5.name;
            if (((String) map.get(str4)) == null) {
                list2.add(new TranslateItem(str4, stringItem5.value, null));
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2398b(List list) {
        new DialogC1115cn(this, new C1047ak(this, list), null, null, getString(R.string.select_folder), true, false, false, null).show();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m2399b(String str) {
        return str.endsWith(".jpg") || (str.endsWith(".png") && !str.endsWith(".9.png"));
    }

    /* JADX INFO: renamed from: c */
    private static String m2400c(Set set) {
        String str = null;
        Locale locale = Locale.getDefault();
        String str2 = "-" + locale.getLanguage();
        String str3 = str2 + "-r" + locale.getCountry();
        new StringBuilder("*****realQualifier=").append(str3);
        Iterator it = set.iterator();
        while (true) {
            String str4 = str;
            if (!it.hasNext()) {
                return str4;
            }
            str = (String) it.next();
            if (str3.equals(str)) {
                return str;
            }
            if (!str2.equals(str)) {
                if (!str.equals("") || str4 != null) {
                    str = str4;
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m2402c(String str, String str2) {
        String strSubstring;
        String[] strArrSplit = str.split("/");
        int iLastIndexOf = strArrSplit[strArrSplit.length - 1].lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring = str.substring(0, str.length() - (strArrSplit[strArrSplit.length - 1].length() - iLastIndexOf));
        } else {
            strSubstring = str;
        }
        if (strSubstring != null && strSubstring.endsWith("/APKEDITOR.xcrhfvke")) {
            File file = new File(str);
            String str3 = strSubstring.substring(0, strSubstring.length() - 18) + C1487s.m3525a(8);
            if (file.renameTo(new File(str3))) {
                str = str3;
            } else {
                Log.w("DEBUG", "file rename error.");
            }
        }
        m2433a(str, str2);
    }

    /* JADX INFO: renamed from: d */
    private void m2404d(boolean z) {
        boolean z2;
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) getSystemService("activity")).getRunningServices(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            if (ApkComposeService.class.getName().equals(it.next().service.getClassName())) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            bindService(new Intent(this, (Class<?>) ApkComposeService.class), new ServiceConnectionC1056au(this, z), 1);
        } else {
            m2406e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m2406e(boolean z) {
        String str;
        String str2 = Environment.getExternalStorageDirectory().getPath() + "/ApkEditor";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        switch (SettingActivity.m2547d(this)) {
            case 0:
                str = !z ? this.f2615c.f4291b + "_unsigned" : this.f2615c.f4291b + "_signed";
                break;
            case 1:
            default:
                str = !z ? "gen_unsigned" : "gen_signed";
                break;
            case 2:
                str = !z ? this.f2615c.f4290a + "_unsigned" : this.f2615c.f4290a + "_signed";
                break;
        }
        String strM2380a = m2380a(this.f2582a, str2, C1476h.m3507a(str));
        if (new File(strM2380a).exists() && SettingActivity.m2550g(this) == 0) {
            strM2380a = DialogC1108ce.m2835a(strM2380a, false).getPath();
        }
        Intent intent = new Intent(this, (Class<?>) ApkComposeService.class);
        C0985a.m2180a(intent, "decodeRootPath", this.f2614b);
        if (!this.f2625m) {
            C0985a.m2180a(intent, "srcApkPath", this.f2582a);
        }
        C0985a.m2180a(intent, "targetApkPath", strM2380a);
        C0985a.m2180a(intent, "stringModified", this.f2579X ? "true" : "false");
        C0985a.m2180a(intent, "manifestModified", this.f2580Y ? "true" : "false");
        C0985a.m2180a(intent, "resFileModified", this.f2602ao ? "true" : "false");
        C0985a.m2181a(intent, "modifiedSmaliFolders", this.f2601an);
        C0985a.m2206a(intent, "addedFiles", this.f2598ak);
        C0985a.m2181a(intent, "deletedFiles", this.f2600am);
        C0985a.m2206a(intent, "replacedFiles", this.f2599al);
        C0985a.m2236b(intent, "signAPK", z);
        C0985a.m2180a(intent, "fileEntry2ZipEntry", m2395b(this.f2623k));
        startService(intent);
        startActivityForResult(new Intent(this, (Class<?>) ApkComposeActivity.class), 1);
    }

    private void extEditor(String str, String str2, boolean z) {
        String str3;
        String strM2410j;
        if (!str2.endsWith(".xml") && !str2.endsWith(".smali") && !str2.endsWith(".html") && !str2.endsWith(".htm") && !str2.endsWith(".css") && !str2.endsWith(".java") && !str2.endsWith(".json") && !str2.endsWith(".txt") && !str2.endsWith(".js")) {
            m2436a(str, str2, z);
            return;
        }
        if (str.equals(this.f2614b)) {
            str3 = str2;
        } else {
            str3 = str.substring(this.f2614b.length() + 1) + "/" + str2;
        }
        String strM3054d = this.f2617e.m3054d(str3);
        if (strM3054d == null) {
            if (z || C1213ff.m3025b(str2)) {
                strM2410j = m2410j(str3);
            } else {
                strM2410j = str + "/" + str2;
            }
            strM3054d = strM2410j;
        }
        if (strM3054d != null) {
            this.f2586aD = strM3054d;
            this.f2587aE = str3;
            this.f2588aF = new File(strM3054d).lastModified();
            C0985a.m2203a(this, strM3054d, PointerIconCompat.TYPE_HAND);
        }
    }

    /* JADX INFO: renamed from: j */
    private String m2410j(String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        String strSubstring = iLastIndexOf != -1 ? str.substring(iLastIndexOf + 1) : str;
        int iLastIndexOf2 = strSubstring.lastIndexOf(Deobfuscator.CLASS_NAME_SEPARATOR);
        String strSubstring2 = iLastIndexOf2 != -1 ? strSubstring.substring(iLastIndexOf2) : "";
        try {
            String str2 = (String) this.f2623k.get(str);
            String str3 = C0985a.m2263d(this, "tmp") + "APKEDITOR.xcrhfvke" + strSubstring2;
            if (str2 == null) {
                str2 = str;
            }
            C0027x.m34b(this.f2582a, str2, str3);
            return str3;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: j */
    static /* synthetic */ boolean m2411j(ApkInfoActivity apkInfoActivity) {
        return true;
    }

    /* JADX INFO: renamed from: n */
    private void m2415n() {
        int i = this.f2621i ? R.drawable.searchtxt_checked : R.drawable.searchtxt_unchecked;
        int i2 = this.f2622j ? R.drawable.ic_case_sensitive : R.drawable.ic_case_insensitive;
        this.f2619g.setImageResource(i);
        this.f2620h.setImageResource(i2);
    }

    /* JADX INFO: renamed from: o */
    private boolean m2417o() {
        try {
            return "amazon".equals(getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.getString("com.gmail.heagoo.publish_channel"));
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: p */
    private void m2418p() {
        int i;
        Map mapM3115a = this.f2558B.m3115a();
        if (mapM3115a == null || mapM3115a.isEmpty()) {
            return;
        }
        this.f2579X = true;
        try {
            for (Map.Entry entry : mapM3115a.entrySet()) {
                String str = (String) entry.getKey();
                Map map = (Map) entry.getValue();
                String str2 = this.f2614b + "/res/values" + str;
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str3 = str2 + "/strings.xml";
                List listM3536a = new C1491w(str3).m3536a();
                ArrayList arrayList = new ArrayList();
                HashSet hashSet = new HashSet();
                int i2 = 0;
                int size = -1;
                while (i2 < listM3536a.size()) {
                    String str4 = (String) listM3536a.get(i2);
                    int iIndexOf = str4.indexOf("<string name=\"");
                    if (iIndexOf == -1) {
                        arrayList.add(str4);
                        i = i2;
                    } else {
                        int i3 = iIndexOf + 14;
                        int iIndexOf2 = str4.indexOf(34, i3);
                        if (iIndexOf2 == -1) {
                            arrayList.add(str4);
                            i = i2;
                        } else {
                            String strSubstring = str4.substring(i3, iIndexOf2);
                            String str5 = (String) map.get(strSubstring);
                            if (str5 != null) {
                                arrayList.add(StringItem.toString(strSubstring, str5, null));
                                hashSet.add(strSubstring);
                                if (!str4.contains("</string>")) {
                                    do {
                                        i2++;
                                        if (i2 < listM3536a.size()) {
                                        }
                                    } while (!((String) listM3536a.get(i2)).contains("</string>"));
                                    i = i2;
                                    size = arrayList.size() - 1;
                                }
                            } else {
                                arrayList.add(str4);
                            }
                            i = i2;
                            size = arrayList.size() - 1;
                        }
                    }
                    i2 = i + 1;
                }
                for (Map.Entry entry2 : map.entrySet()) {
                    String str6 = (String) entry2.getKey();
                    if (!hashSet.contains(str6)) {
                        size++;
                        listM3536a.add(size, StringItem.toString(str6, (String) entry2.getValue(), null));
                    }
                    size = size;
                }
                C1476h.m3511a(str3, arrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: q */
    private void m2419q() {
        this.f2574R.setVisibility(4);
        this.f2571O.setVisibility(4);
        this.f2632z.setVisibility(4);
        this.f2562F.setVisibility(4);
        switch (this.f2590ab) {
            case 0:
                if (!this.f2581Z) {
                    this.f2574R.setVisibility(0);
                } else {
                    this.f2632z.setVisibility(0);
                }
                break;
            case 1:
                if (!this.f2589aa) {
                    this.f2574R.setVisibility(0);
                } else {
                    this.f2562F.setVisibility(0);
                }
                break;
            case 2:
                if (!this.f2589aa) {
                    this.f2574R.setVisibility(0);
                } else {
                    this.f2571O.setVisibility(0);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: r */
    private boolean m2420r() {
        String string;
        this.f2616d = new HashMap();
        C0031e c0031eM2812a = this.f2578W.m2812a();
        if (c0031eM2812a == null) {
            return false;
        }
        for (C0032f c0032f : c0031eM2812a.m44a()) {
            if ("string".equals(c0032f.m69h().m80a())) {
                String strM67f = c0032f.m67f();
                for (Map.Entry entry : c0032f.m63b().entrySet()) {
                    C0029c c0029c = (C0029c) entry.getKey();
                    C0026w c0026wM75d = ((C0033g) entry.getValue()).m75d();
                    if ((c0026wM75d instanceof C0022s) || !(c0026wM75d instanceof AbstractC0023t)) {
                        string = c0026wM75d.toString();
                    } else {
                        AbstractC0023t abstractC0023t = (AbstractC0023t) c0026wM75d;
                        strM21l = abstractC0023t.m23n() ? abstractC0023t.m21l() : null;
                        string = abstractC0023t.m22m();
                        if (string == null) {
                            string = c0026wM75d.toString();
                        }
                    }
                    StringItem stringItem = new StringItem(strM67f, string, strM21l);
                    String strM42a = c0029c.m42a();
                    ArrayList arrayList = (ArrayList) this.f2616d.get(strM42a);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        this.f2616d.put(strM42a, arrayList);
                    }
                    arrayList.add(stringItem);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m2421s() {
        if (this.f2558B != null && this.f2559C != null) {
            this.f2558B.m3118a(this.f2559C);
        }
        findViewById(R.id.add_language).setOnClickListener(new ViewOnClickListenerC1406y(this));
        View viewFindViewById = findViewById(R.id.translate);
        if (m2391a((Context) this) || m2422t()) {
            viewFindViewById.setOnClickListener(this);
        } else {
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC1407z(this));
        }
        m2424v();
        findViewById(R.id.search_button).setOnClickListener(this);
        this.f2581Z = true;
        m2419q();
    }

    /* JADX INFO: renamed from: t */
    private boolean m2422t() {
        try {
            getPackageManager().getApplicationInfo("apkeditor.translate", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: u */
    public void m2423u() {
        if (this.f2560D == null) {
            this.f2560D = m2400c(this.f2616d.keySet());
        }
        new StringBuilder("********BEST*********").append(this.f2560D);
        m2389a((ArrayList) this.f2616d.get(this.f2560D));
    }

    /* JADX INFO: renamed from: v */
    private void m2424v() {
        int i = 0;
        if (this.f2616d == null) {
            return;
        }
        if (this.f2560D == null) {
            this.f2560D = m2400c(this.f2616d.keySet());
        }
        this.f2561E = new ArrayList();
        String[] strArr = new String[this.f2616d.size()];
        ArrayList<String> arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (String str : this.f2616d.keySet()) {
            String strM200a = C0077i.m200a(str);
            arrayList.add(strM200a);
            map.put(strM200a, str);
        }
        Collections.sort(arrayList);
        int i2 = 0;
        for (String str2 : arrayList) {
            String str3 = (String) map.get(str2);
            strArr[i] = str2;
            this.f2561E.add(str3);
            int i3 = str3.equals(this.f2560D) ? i : i2;
            i++;
            i2 = i3;
        }
        Spinner spinner = (Spinner) findViewById(R.id.language_spinner);
        if (spinner != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, strArr);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
            spinner.setOnItemSelectedListener(new C1035ab(this));
            spinner.setSelection(i2);
        }
    }

    /* JADX INFO: renamed from: w */
    private void m2425w() {
        m2424v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: x */
    public void m2426x() {
        this.f2617e = new C1213ff(this, this.f2625m ? null : this.f2582a, (this.f2605ar == null || !this.f2605ar.startsWith(this.f2614b)) ? this.f2614b : this.f2605ar, this.f2614b, this.f2623k, new C1036ac(this), this);
        this.f2617e.m3044a(this.f2606as, this.f2608au, this.f2607at);
        this.f2563G.setAdapter((ListAdapter) this.f2617e);
        this.f2563G.setOnItemClickListener(this);
        this.f2563G.setOnItemLongClickListener(this);
        this.f2573Q = new C1141dt(this, this.f2614b + "/AndroidManifest.xml", this);
        this.f2572P.setAdapter((ListAdapter) this.f2573Q);
        this.f2572P.setOnItemClickListener(this.f2573Q);
        this.f2572P.setOnItemLongClickListener(this.f2573Q);
        if (this.f2618f != null && this.f2605ar != null) {
            this.f2618f.m3072a(this.f2605ar);
        }
        this.f2589aa = true;
        m2419q();
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1126cz
    /* JADX INFO: renamed from: a */
    public final String mo2427a(C1135dj c1135dj) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    protected final void m2428a() {
        this.f2629q.setOnClickListener(new ViewOnClickListenerC1054as(this));
        this.f2630r.setOnClickListener(new ViewOnClickListenerC1055at(this));
        this.f2631s.setOnClickListener(new ViewOnClickListenerC1342r(this));
        this.f2577V = findViewById(R.id.save_button);
        this.f2577V.setOnClickListener(new ViewOnClickListenerC1343s(this));
        this.f2576U = findViewById(R.id.menu_apply_patch);
        this.f2576U.setOnClickListener(this);
        this.f2575S = findViewById(R.id.menu_webserver);
        this.f2575S.setOnClickListener(this);
    }

    /* JADX INFO: renamed from: a */
    protected final void m2429a(int i) {
        ArrayList arrayList = new ArrayList();
        m2432a(this.f2617e.m3038a(arrayList) + "/" + ((C1450a) arrayList.get(i)).f4255a, (InterfaceC1254gu) null);
    }

    /* JADX INFO: renamed from: a */
    public final void m2430a(InterfaceC1125cy interfaceC1125cy) {
        this.f2612ay = interfaceC1125cy;
        new AsyncTaskC1204a(this, this.f2582a, this.f2614b, this).execute(new Void[0]);
        this.f2597aj = true;
    }

    /* JADX INFO: renamed from: a */
    public final void m2431a(String str, int i) {
        this.f2617e.m3051c(str);
        if (i > 0) {
            C0073e c0073e = null;
            int i2 = 0;
            while (i2 < i) {
                try {
                    i2++;
                    c0073e = (C0073e) this.f2564H.pop();
                } catch (Exception e) {
                    return;
                }
            }
            if (c0073e != null) {
                this.f2563G.setSelectionFromTop(((Integer) c0073e.f190a).intValue(), ((Integer) c0073e.f191b).intValue());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m2432a(String str, InterfaceC1254gu interfaceC1254gu) {
        String strSubstring = str.substring(str.lastIndexOf(47) + 1);
        int iLastIndexOf = strSubstring.lastIndexOf(46);
        String strSubstring2 = iLastIndexOf != -1 ? strSubstring.substring(iLastIndexOf) : null;
        new DialogC1115cn(this, new C1048al(this, interfaceC1254gu, strSubstring2), strSubstring2, str, null, false, false, true, null).show();
    }

    /* JADX INFO: renamed from: a */
    protected final void m2433a(String str, String str2) {
        if (str2 == null) {
            str2 = str.substring(this.f2614b.length() + 1);
        }
        this.f2617e.m3052c(str2, str);
    }

    /* JADX INFO: renamed from: a */
    public final void m2434a(String str, String str2, InterfaceC1254gu interfaceC1254gu) {
        this.f2613az = str;
        this.f2583aA = str2;
        this.f2584aB = interfaceC1254gu;
    }

    /* JADX INFO: renamed from: a */
    protected final void m2435a(String str, String str2, ArrayList arrayList, boolean z, boolean z2) {
        if (this.f2610aw != null) {
            this.f2610aw.m2764a(str);
        }
        if (z) {
            new DialogC1222fo(this, str2, arrayList, str, z2).show();
        } else {
            new DialogC1229fv(this, str2, arrayList, str, z2).show();
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m2436a(String str, String str2, boolean z) {
        String str3 = str.equals(this.f2614b) ? str2 : str.substring(this.f2614b.length() + 1) + "/" + str2;
        String str4 = str2.endsWith(".xml") ? "xml.xml" : str2.endsWith(".smali") ? "smali.xml" : (str2.endsWith(".html") || str2.endsWith(".htm")) ? "html.xml" : str2.endsWith(".css") ? "css.xml" : str2.endsWith(".java") ? "java.xml" : str2.endsWith(".json") ? "json.xml" : str2.endsWith(".txt") ? "txt.xml" : str2.endsWith(".js") ? "js.xml" : null;
        if (str4 == null) {
            String strM3054d = this.f2617e.m3054d(str3);
            if (strM3054d == null) {
                strM3054d = (z || C1213ff.m3025b(str2)) ? m2410j(str3) : str + "/" + str2;
            }
            if (strM3054d != null) {
                this.f2586aD = strM3054d;
                this.f2587aE = str3;
                this.f2588aF = new File(strM3054d).lastModified();
                if (!str2.endsWith(".png")) {
                    C0985a.m2203a(this, strM3054d, PointerIconCompat.TYPE_HAND);
                    return;
                }
                Intent intent = new Intent(this, (Class<?>) PngEditActivity.class);
                C0985a.m2180a(intent, "filePath", strM3054d);
                startActivityForResult(intent, PointerIconCompat.TYPE_HAND);
                return;
            }
            return;
        }
        String strM3054d2 = this.f2617e.m3054d(str3);
        if (strM3054d2 == null) {
            if (z) {
                strM3054d2 = m2410j(str3);
                if (strM3054d2 == null) {
                    Toast.makeText(this, String.format(getString(R.string.cannot_open_xxx), str3), 0).show();
                    return;
                }
            } else {
                strM3054d2 = str + "/" + str2;
            }
        }
        if ("res/values/colors.xml".equals(str3)) {
            Intent intent2 = new Intent(this, (Class<?>) ColorXmlActivity.class);
            C0985a.m2180a(intent2, "xmlPath", strM3054d2);
            startActivityForResult(intent2, 3);
        } else {
            Intent intentM2177a = C0985a.m2177a(this, strM3054d2, this.f2582a);
            C0985a.m2180a(intentM2177a, "syntaxFileName", str4);
            if (str2 != null) {
                C0985a.m2180a(intentM2177a, "displayFileName", str2);
            }
            C0985a.m2180a(intentM2177a, "extraString", str3);
            startActivityForResult(intentM2177a, 0);
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m2437a(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strM3038a = this.f2617e.m3038a(arrayList2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            if (iIntValue < arrayList2.size()) {
                C1450a c1450a = (C1450a) arrayList2.get(iIntValue);
                C1110cg c1110cg = new C1110cg();
                if (c1450a.f4257c) {
                    c1110cg.f3156a = (strM3038a + "/" + c1450a.f4255a).substring(this.f2614b.length() + 1);
                } else {
                    c1110cg.f3156a = strM3038a + "/" + c1450a.f4255a;
                }
                c1110cg.f3158c = c1450a.f4257c;
                c1110cg.f3157b = c1450a.f4256b;
                arrayList.add(c1110cg);
            }
        }
        m2398b(arrayList);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1079bf
    /* JADX INFO: renamed from: a */
    public final void mo2438a(Map map) {
        this.f2623k = map;
        new C1403v(this, map).start();
        boolean z = !this.f2603ap;
        if (!this.f2603ap) {
            this.f2603ap = m2420r();
        }
        runOnUiThread(new RunnableC1404w(this, z));
    }

    /* JADX INFO: renamed from: a */
    public final void m2439a(boolean z) {
        this.f2580Y = true;
        if (z) {
            this.f2573Q.m2876a();
        } else {
            runOnUiThread(new RunnableC1053aq(this));
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p067f.InterfaceC1205b
    /* JADX INFO: renamed from: a */
    public final void mo2440a(boolean z, String str, String str2) {
        boolean z2;
        if (this.f2612ay != null) {
            this.f2612ay.mo2860a();
            this.f2612ay = null;
        }
        if (!z) {
            this.f2595ah.setText(R.string.failed);
            this.f2596ai.setVisibility(0);
            if (str != null) {
                this.f2596ai.setText(str);
                z2 = true;
            } else {
                this.f2596ai.setText(R.string.unknown_error);
                z2 = true;
            }
        } else if (str2 != null) {
            this.f2595ah.setText(R.string.succeed_with_warning);
            this.f2596ai.setText(getString(R.string.warning) + ": " + str2);
            this.f2596ai.setVisibility(0);
            z2 = true;
        } else {
            this.f2595ah.setText(R.string.succeed);
            this.f2596ai.setVisibility(8);
            z2 = false;
        }
        this.f2592ae.setVisibility(4);
        this.f2593af.setVisibility(4);
        if (z2) {
            this.f2594ag.setVisibility(0);
        } else {
            this.f2591ad.setVisibility(8);
            Toast.makeText(this, R.string.dex_decode_succeed, 1).show();
        }
        String strM3038a = this.f2617e.m3038a((List) null);
        if (strM3038a.endsWith("/decoded")) {
            this.f2617e.m3051c(strM3038a);
        }
    }

    /* JADX INFO: renamed from: aa */
    protected final void m2441aa(int i) {
        ArrayList arrayList = new ArrayList();
        String strM3038a = this.f2617e.m3038a(arrayList);
        C1450a c1450a = (C1450a) arrayList.get(i);
        if (c1450a != null) {
            extEditor(strM3038a, c1450a.f4255a, false);
        }
    }

    /* JADX INFO: renamed from: b */
    protected final void m2442b() {
        if (!MainActivity.m2522a(this)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.please_note);
            builder.setMessage(R.string.build_not_support_tip);
            builder.show();
            return;
        }
        m2418p();
        if (!SettingActivity.m2549f(this)) {
            m2446b(true);
            return;
        }
        new C1210fc(this, this.f2579X, this.f2580Y, this.f2617e.m3046b(), this.f2617e.m3050c(), this.f2617e.m3055d()).m3014a();
    }

    /* JADX INFO: renamed from: b */
    protected final void m2443b(int i) {
        String string = getString(R.string.select_folder_replace);
        ArrayList arrayList = new ArrayList();
        new DialogC1115cn(this, new C1049am(this), null, this.f2617e.m3038a(arrayList) + "/" + ((C1450a) arrayList.get(i)).f4255a, string, true, true, false, null).show();
    }

    /* JADX INFO: renamed from: b */
    protected final void m2444b(String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
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
            }
            try {
                C0985a.m2244b(fileInputStream, fileOutputStream);
                m2386a(fileInputStream);
                m2386a(fileOutputStream);
            } catch (IOException e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                try {
                    e.printStackTrace();
                    m2386a(fileInputStream2);
                    m2386a(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    fileOutputStream2 = fileOutputStream;
                    m2386a(fileInputStream);
                    m2386a(fileOutputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                m2386a(fileInputStream);
                m2386a(fileOutputStream2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1221fn
    /* JADX INFO: renamed from: b */
    public void mo2445b(Set set) {
        if (!(!set.isEmpty())) {
            this.f2566J.setVisibility(8);
            this.f2569M.setVisibility(8);
            this.f2565I.setVisibility(0);
            this.f2568L.setVisibility(0);
            return;
        }
        this.f2565I.setVisibility(8);
        this.f2568L.setVisibility(8);
        this.f2566J.setVisibility(0);
        this.f2569M.setVisibility(0);
        this.f2570N.setText(String.format(getString(R.string.num_items_selected), Integer.valueOf(set.size())));
    }

    /* JADX INFO: renamed from: b */
    protected final void m2446b(boolean z) {
        this.f2602ao = false;
        HashSet hashSet = new HashSet();
        Log.d("DEBUG", "resModifyTime=" + C1476h.m3513b(new File(this.f2614b + "/res")));
        Log.d("DEBUG", "manifestTime=" + C1476h.m3513b(new File(this.f2614b + "/AndroidManifest.xml")));
        Map mapM3046b = this.f2617e.m3046b();
        Map mapM3050c = this.f2617e.m3050c();
        Set<String> setM3055d = this.f2617e.m3055d();
        this.f2598ak = new HashMap();
        this.f2599al = new HashMap();
        this.f2600am = new ArrayList();
        for (Map.Entry entry : mapM3046b.entrySet()) {
            String str = (String) entry.getKey();
            if (str.startsWith("res/")) {
                if (!this.f2602ao && !m2399b(str)) {
                    this.f2602ao = true;
                }
                this.f2598ak.put(entry.getKey(), entry.getValue());
            } else if (m2381a(str, hashSet) == null) {
                this.f2598ak.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : mapM3050c.entrySet()) {
            String str2 = (String) entry2.getKey();
            if (str2.equals(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME) || str2.startsWith("res/")) {
                if (!this.f2602ao && !m2399b(str2)) {
                    this.f2602ao = true;
                }
                this.f2599al.put(entry2.getKey(), entry2.getValue());
            } else if (m2381a(str2, hashSet) == null) {
                this.f2599al.put(entry2.getKey(), entry2.getValue());
            }
        }
        for (String str3 : setM3055d) {
            if (str3.startsWith("res/")) {
                if (!this.f2602ao && !m2399b(str3)) {
                    this.f2602ao = true;
                }
                this.f2600am.add(str3);
            } else if (m2381a(str3, hashSet) == null) {
                this.f2600am.add(str3);
            }
        }
        this.f2601an = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.f2601an.add((String) it.next());
        }
        m2404d(z);
    }

    /* JADX INFO: renamed from: c */
    protected final void m2447c() {
        if (this.f2590ab != 2) {
            this.f2590ab = 2;
            m2419q();
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p069ui.InterfaceC1374b
    /* JADX INFO: renamed from: c */
    public final void mo2448c(String str) {
        this.f2617e.m3047b(this.f2617e.m3038a((List) null), str);
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1079bf
    /* JADX INFO: renamed from: c */
    public final void mo2449c(boolean z) {
        this.f2603ap = m2420r();
        if (this.f2603ap) {
            runOnUiThread(new RunnableC1372u(this));
        }
    }

    /* JADX INFO: renamed from: d */
    protected final void m2450d() {
        SharedPreferences defaultSharedPreferences;
        int i;
        if (this.f2590ab == 1) {
            return;
        }
        this.f2590ab = 1;
        m2419q();
        if (this.f2597aj || (i = (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)).getInt("HideSmaliMsgShown", 0)) > 0 || !SettingActivity.m2548e(this)) {
            return;
        }
        Toast.makeText(this, R.string.hide_smali_tip, 1).show();
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putInt("HideSmaliMsgShown", i + 1);
        editorEdit.apply();
    }

    @Override // com.gmail.heagoo.apkeditor.p069ui.InterfaceC1374b
    /* JADX INFO: renamed from: d */
    public final void mo2451d(String str) {
        new DialogC1201ey(this, new C1371t(this, str, this.f2617e.m3038a((List) null)), -1).show();
    }

    /* JADX INFO: renamed from: e */
    protected final void m2452e() {
        if (this.f2590ab != 0) {
            this.f2590ab = 0;
            m2419q();
        }
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1079bf
    /* JADX INFO: renamed from: e */
    public final void mo2453e(String str) {
        runOnUiThread(new RunnableC1405x(this, str));
    }

    protected final void editorSwitch(String str, String str2, boolean z) {
        if (!SettingActivity.extEditor(this) || str2.equals("colors.xml")) {
            m2436a(str, str2, z);
        } else {
            extEditor(str, str2, z);
        }
    }

    /* JADX INFO: renamed from: f */
    protected final void m2454f() {
        new DialogC1115cn(this, new C1050an(this), null, this.f2617e.m3038a((List) null), getString(R.string.add_a_file)).show();
    }

    /* JADX INFO: renamed from: f */
    public final void m2455f(String str) {
        Intent intent;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        m2397b(str, arrayList, arrayList2);
        try {
            if (m2391a((Context) this)) {
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setDataAndType(null, "application/com.gmail.heagoo.apkeditor-translate");
            } else {
                ComponentName componentName = new ComponentName("apkeditor.translate", "apkeditor.translate.TranslateActivity");
                intent = new Intent();
                intent.setComponent(componentName);
            }
            Bundle bundle = new Bundle();
            String str2 = C0985a.m2263d(this, "tmp") + "translated";
            C0985a.m2225a(str2, arrayList);
            bundle.putString("translatedList_file", str2);
            String str3 = C0985a.m2263d(this, "tmp") + "untranslatedList";
            C0985a.m2225a(str3, arrayList2);
            bundle.putString("untranslatedList_file", str3);
            bundle.putString("targetLanguageCode", str);
            intent.putExtras(bundle);
            startActivityForResult(intent, 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: g */
    public final String m2456g(String str) {
        String str2;
        String str3;
        boolean z = true;
        Resources resources = getResources();
        if (str.length() < 3) {
            return resources.getString(R.string.invalid_lang_code);
        }
        if (!this.f2589aa) {
            return resources.getString(R.string.wait_for_decoding);
        }
        List<TranslateItem> arrayList = new ArrayList();
        List<TranslateItem> arrayList2 = new ArrayList();
        m2397b(str, arrayList, arrayList2);
        if (arrayList2.isEmpty()) {
            return resources.getString(R.string.lang_exist);
        }
        ArrayList arrayList3 = new ArrayList();
        for (TranslateItem translateItem : arrayList2) {
            arrayList3.add(new StringItem(translateItem.name, translateItem.originValue));
        }
        Iterator it = this.f2616d.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = null;
                z = false;
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str4 = (String) entry.getKey();
            if (str4.equals(str)) {
                ((ArrayList) entry.getValue()).addAll(arrayList3);
                str2 = str4;
                break;
            }
        }
        if (str2 == null) {
            this.f2616d.put(str, arrayList3);
            str3 = str;
        } else {
            str3 = str2;
        }
        try {
            if (z) {
                List arrayList4 = new ArrayList();
                for (TranslateItem translateItem2 : arrayList) {
                    arrayList4.add(new StringItem(translateItem2.name, translateItem2.translatedValue));
                }
                arrayList4.addAll(arrayList3);
                m2396b(str, arrayList4);
            } else {
                m2396b(str, arrayList3);
            }
            this.f2579X = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f2560D = str3;
        m2425w();
        return null;
    }

    /* JADX INFO: renamed from: g */
    protected final void m2457g() {
        new DialogC1373a(this, this, this.f2625m).show();
    }

    @Override // com.gmail.heagoo.apkeditor.p067f.InterfaceC1205b
    /* JADX INFO: renamed from: h */
    public final void mo2458h() {
        this.f2592ae.setVisibility(4);
        this.f2594ag.setVisibility(4);
        this.f2593af.setVisibility(0);
    }

    /* JADX INFO: renamed from: h */
    protected final void m2459h(String str) {
        ArrayList arrayList = new ArrayList();
        C1110cg c1110cg = new C1110cg();
        c1110cg.f3158c = false;
        c1110cg.f3157b = false;
        c1110cg.f3156a = str;
        arrayList.add(c1110cg);
        m2398b(arrayList);
    }

    /* JADX INFO: renamed from: i */
    public final String m2460i() {
        return this.f2614b;
    }

    @Override // com.gmail.heagoo.apkeditor.InterfaceC1126cz
    /* JADX INFO: renamed from: i */
    public final void mo2461i(String str) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(this.f2614b + "/AndroidManifest.xml");
            try {
                fileOutputStream.write(str.getBytes());
                this.f2580Y = true;
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable th) {
                fileOutputStream2 = fileOutputStream;
                th = th;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: j */
    public final C1213ff m2462j() {
        return this.f2617e;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m2463k() {
        return this.f2597aj;
    }

    /* JADX INFO: renamed from: l */
    public final String m2464l() {
        return this.f2582a;
    }

    /* JADX INFO: renamed from: m */
    public final C1470b m2465m() {
        return this.f2615c;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
            case 3:
                if (i2 != 0) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("modifiedFiles");
                    if (stringArrayListExtra != null) {
                        Iterator<String> it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            m2433a(it.next(), (String) null);
                        }
                    } else {
                        m2402c(intent.getStringExtra("xmlPath"), intent.getStringExtra("extraString"));
                    }
                }
                break;
            case 1:
                if (i2 == 10005) {
                    finish();
                }
                break;
            case 2:
                if (i2 != 0) {
                    m2439a(true);
                }
                break;
            case 1000:
                if (i2 == -1) {
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("targetLanguageCode");
                    List<TranslateItem> list = (List) C0985a.m2280j(extras.getString("translatedList_file"));
                    if (list != null && !list.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (TranslateItem translateItem : list) {
                            arrayList.add(new StringItem(translateItem.name, translateItem.translatedValue));
                        }
                        try {
                            m2387a(string, arrayList);
                            Toast.makeText(this, String.format(getString(R.string.save_succeed_tip), Integer.valueOf(arrayList.size())), 0).show();
                        } catch (Exception e) {
                            Toast.makeText(this, e.getMessage(), 1).show();
                            return;
                        }
                        break;
                    }
                }
                break;
            case PointerIconCompat.TYPE_CONTEXT_MENU /* 1001 */:
                this.f2617e.m3056d(this.f2583aA, this.f2613az);
                if ((this.f2614b + "/AnfroidManifest.xml").equals(this.f2583aA)) {
                    m2439a(true);
                }
                if (this.f2584aB != null) {
                    this.f2584aB.mo3082a();
                }
                break;
            case PointerIconCompat.TYPE_HAND /* 1002 */:
                if (new File(this.f2586aD).lastModified() > this.f2588aF) {
                    m2402c(this.f2586aD, this.f2587aE);
                }
                break;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z = false;
        if (this.f2590ab == 1 && this.f2617e != null) {
            if (!this.f2617e.m3057e().isEmpty()) {
                this.f2617e.m3045a(false);
                z = true;
            } else if (!this.f2617e.m3061f()) {
                String strM3038a = this.f2617e.m3038a((List) null);
                String strSubstring = strM3038a.substring(0, strM3038a.lastIndexOf(47));
                this.f2617e.m3051c(strSubstring);
                this.f2618f.m3072a(strSubstring);
                try {
                    C0073e c0073e = (C0073e) this.f2564H.pop();
                    this.f2563G.setSelectionFromTop(((Integer) c0073e.f190a).intValue(), ((Integer) c0073e.f191b).intValue());
                } catch (Exception e) {
                }
                z = true;
            }
        }
        if (z) {
            return;
        }
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this).setMessage(R.string.sure_to_exit_editing).setPositiveButton(R.string.yes, new DialogInterfaceOnClickListenerC1034aa(this)).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null);
        if (this.f2585aC == null && (this.f2578W == null || !this.f2578W.isAlive())) {
            negativeButton.setMessage(R.string.sure_to_exit);
            negativeButton.setNeutralButton(R.string.save_as_project, new DialogInterfaceOnClickListenerC1051ao(this));
        }
        negativeButton.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.search_button) {
            String strTrim = ((EditText) findViewById(R.id.keyword_edit)).getText().toString().trim();
            if (strTrim.equals("")) {
                m2423u();
            } else {
                String lowerCase = strTrim.toLowerCase();
                ArrayList<StringItem> arrayList = (ArrayList) this.f2616d.get(this.f2560D);
                if (arrayList != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (StringItem stringItem : arrayList) {
                        if (stringItem.value.toLowerCase().contains(lowerCase)) {
                            arrayList2.add(stringItem);
                        }
                    }
                    m2389a(arrayList2);
                }
                this.f2609av.m2764a(strTrim);
            }
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            return;
        }
        if (id == R.id.btn_search_mf) {
            String strTrim2 = ((EditText) findViewById(R.id.mf_keyword)).getText().toString().trim();
            if (strTrim2.equals("")) {
                Toast.makeText(this, R.string.empty_input_tip, 0).show();
                return;
            }
            this.f2611ax.m2764a(strTrim2);
            ArrayList<Integer> arrayList3 = new ArrayList<>();
            ArrayList<String> arrayList4 = new ArrayList<>();
            m2388a(strTrim2, arrayList3, arrayList4);
            if (arrayList3.isEmpty()) {
                Toast.makeText(this, R.string.notfound_in_manifest, 0).show();
                return;
            }
            Intent intent = new Intent(this, (Class<?>) MfSearchRetActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("xmlPath", this.f2614b + "/AndroidManifest.xml");
            bundle.putIntegerArrayList("lineIndexs", arrayList3);
            bundle.putStringArrayList("lineContents", arrayList4);
            intent.putExtras(bundle);
            startActivityForResult(intent, 2);
            return;
        }
        if (id == R.id.menu_search_res) {
            String strTrim3 = ((EditText) findViewById(R.id.et_res_keyword)).getText().toString().trim();
            if (strTrim3.equals("")) {
                Toast.makeText(this, R.string.empty_input_tip, 0).show();
                return;
            }
            if (this.f2617e != null) {
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                String strM3038a = this.f2617e.m3038a(arrayList6);
                if (!"..".equals(((C1450a) arrayList6.get(0)).f4255a)) {
                    arrayList5.add(((C1450a) arrayList6.get(0)).f4255a);
                }
                for (int i = 1; i < arrayList6.size(); i++) {
                    arrayList5.add(((C1450a) arrayList6.get(i)).f4255a);
                }
                m2435a(strTrim3, strM3038a, arrayList5, !this.f2621i, this.f2622j);
                return;
            }
            return;
        }
        if (id == R.id.imageview_dex2smali) {
            if (!C0985a.m2224a((Context) this, "smali_license_showed", false)) {
                new DialogC1253gt(this).show();
            }
            m2430a((InterfaceC1125cy) null);
        } else {
            if (id == R.id.down_arrow_container) {
                this.f2591ad.setVisibility(8);
                return;
            }
            if (id == R.id.menu_webserver) {
                C1496e.m3554a().m3561a(this, this.f2614b);
                return;
            }
            if (id == R.id.menu_apply_patch) {
                new DialogC1197eu(this).show();
            } else if (id == R.id.translate) {
                DialogC1133dh dialogC1133dh = new DialogC1133dh(this, PossibleLanguages.languages, PossibleLanguages.codes);
                dialogC1133dh.setTitle(R.string.select_target_lang);
                dialogC1133dh.show();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x03c0  */
    @Override // android.app.Activity
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onCreate(android.os.Bundle r10) {
        /*
            Method dump skipped, instruction units count: 1123
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.ApkInfoActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        C1496e.m3554a().m3560a(this);
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String strSubstring;
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        String strM3038a = this.f2617e.m3038a(arrayList);
        C1450a c1450a = (C1450a) arrayList.get(i);
        if (c1450a == null) {
            return;
        }
        if (!this.f2617e.m3057e().isEmpty()) {
            this.f2617e.m3040a(i);
            return;
        }
        if (!c1450a.f4256b) {
            editorSwitch(strM3038a, c1450a.f4255a, c1450a.f4257c);
            return;
        }
        if (c1450a.f4255a.equals("..")) {
            z = true;
            strSubstring = strM3038a.substring(0, strM3038a.lastIndexOf(47));
        } else {
            int firstVisiblePosition = this.f2563G.getFirstVisiblePosition();
            View childAt = this.f2563G.getChildAt(0);
            this.f2564H.push(new C0073e(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt == null ? 0 : childAt.getTop() - this.f2563G.getPaddingTop())));
            strSubstring = strM3038a + "/" + c1450a.f4255a;
        }
        this.f2617e.m3051c(strSubstring);
        this.f2618f.m3072a(strSubstring);
        if (!z) {
            this.f2563G.setSelectionAfterHeaderView();
            return;
        }
        try {
            C0073e c0073e = (C0073e) this.f2564H.pop();
            this.f2563G.setSelectionFromTop(((Integer) c0073e.f190a).intValue(), ((Integer) c0073e.f191b).intValue());
        } catch (Exception e) {
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        adapterView.setOnCreateContextMenuListener(new ViewOnCreateContextMenuListenerC1040ad(this, i, i == 0));
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() != R.id.imageview_dex2smali) {
            return false;
        }
        this.f2591ad.setVisibility(8);
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        String strM2263d;
        try {
            if (this.f2585aC != null) {
                strM2263d = C0985a.m2263d(this, ".projects") + this.f2585aC + "/";
            } else {
                strM2263d = C0985a.m2263d(this, "tmp");
            }
            m2377a(strM2263d, false, (File) null).toBundle(bundle);
        } catch (Exception e) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
