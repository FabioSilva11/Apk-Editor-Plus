package com.gmail.heagoo.apkeditor;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import com.android.apksig.apk.ApkUtils;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.fc */
/* JADX INFO: loaded from: classes.dex */
public final class C1210fc {

    /* JADX INFO: renamed from: a */
    private Context f3413a;

    /* JADX INFO: renamed from: b */
    private CheckBox f3414b;

    /* JADX INFO: renamed from: c */
    private CheckBox f3415c;

    /* JADX INFO: renamed from: d */
    private CheckBox f3416d;

    /* JADX INFO: renamed from: e */
    private boolean f3417e;

    /* JADX INFO: renamed from: f */
    private boolean f3418f;

    /* JADX INFO: renamed from: g */
    private boolean f3419g;

    /* JADX INFO: renamed from: h */
    private int f3420h = 0;

    /* JADX INFO: renamed from: i */
    private int f3421i = 0;

    /* JADX INFO: renamed from: j */
    private int f3422j = 0;

    /* JADX INFO: renamed from: k */
    private int f3423k = 0;

    /* JADX INFO: renamed from: l */
    private int f3424l = 0;

    /* JADX INFO: renamed from: m */
    private int f3425m = 0;

    /* JADX INFO: renamed from: n */
    private Map f3426n;

    /* JADX INFO: renamed from: o */
    private Map f3427o;

    /* JADX INFO: renamed from: p */
    private Map f3428p;

    /* JADX INFO: renamed from: q */
    private Set f3429q;

    public C1210fc(Context context, boolean z, boolean z2, Map map, Map map2, Set set) {
        this.f3413a = context;
        this.f3417e = z;
        this.f3418f = z2;
        m3011a(map, map2, set);
    }

    /* JADX INFO: renamed from: a */
    private void m3011a(Map map, Map map2, Set set) {
        this.f3419g = false;
        this.f3429q = new HashSet();
        this.f3426n = new HashMap();
        this.f3427o = new HashMap();
        this.f3428p = new HashMap();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            if (str.startsWith("res/")) {
                if (!this.f3419g && !ApkInfoActivity.m2399b(str)) {
                    this.f3419g = true;
                }
                this.f3420h++;
            } else {
                String strM2381a = ApkInfoActivity.m2381a(str, this.f3429q);
                if (strM2381a != null) {
                    Integer num = (Integer) this.f3426n.get(strM2381a);
                    if (num == null) {
                        this.f3426n.put(strM2381a, 1);
                    } else {
                        this.f3426n.put(strM2381a, Integer.valueOf(num.intValue() + 1));
                    }
                } else {
                    this.f3423k++;
                }
            }
        }
        Iterator it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            String str2 = (String) ((Map.Entry) it2.next()).getKey();
            if (str2.equals(ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME) || str2.startsWith("res/")) {
                if (!this.f3419g && !ApkInfoActivity.m2399b(str2)) {
                    this.f3419g = true;
                }
                this.f3422j++;
            } else {
                String strM2381a2 = ApkInfoActivity.m2381a(str2, this.f3429q);
                if (strM2381a2 != null) {
                    Integer num2 = (Integer) this.f3428p.get(strM2381a2);
                    if (num2 == null) {
                        this.f3428p.put(strM2381a2, 1);
                    } else {
                        this.f3428p.put(strM2381a2, Integer.valueOf(num2.intValue() + 1));
                    }
                } else {
                    this.f3425m++;
                }
            }
        }
        Iterator it3 = set.iterator();
        while (it3.hasNext()) {
            String str3 = (String) it3.next();
            if (str3.startsWith("res/")) {
                if (!this.f3419g && !ApkInfoActivity.m2399b(str3)) {
                    this.f3419g = true;
                }
                this.f3421i++;
            } else {
                String strM2381a3 = ApkInfoActivity.m2381a(str3, this.f3429q);
                if (strM2381a3 != null) {
                    Integer num3 = (Integer) this.f3427o.get(strM2381a3);
                    if (num3 == null) {
                        this.f3427o.put(strM2381a3, 1);
                    } else {
                        this.f3427o.put(strM2381a3, Integer.valueOf(num3.intValue() + 1));
                    }
                } else {
                    this.f3424l++;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private List m3013b() {
        ArrayList arrayList = new ArrayList();
        if (this.f3417e) {
            arrayList.add(new C1193eq(this.f3413a.getString(R.string.string), -1, -1, -1));
        } else {
            arrayList.add(new C1193eq(this.f3413a.getString(R.string.string), 0, 0, 0));
        }
        arrayList.add(new C1193eq(this.f3413a.getString(R.string.resource), this.f3420h, this.f3421i, this.f3422j));
        if (this.f3418f) {
            arrayList.add(new C1193eq(this.f3413a.getString(R.string.manifest), -1, -1, -1));
        } else {
            arrayList.add(new C1193eq(this.f3413a.getString(R.string.manifest), 0, 0, 0));
        }
        for (String str : this.f3429q) {
            Integer num = (Integer) this.f3426n.get(str);
            Integer num2 = (Integer) this.f3427o.get(str);
            Integer num3 = (Integer) this.f3428p.get(str);
            arrayList.add(new C1193eq(str, num == null ? 0 : num.intValue(), num2 == null ? 0 : num2.intValue(), num3 == null ? 0 : num3.intValue()));
        }
        if (this.f3423k > 0 || this.f3424l > 0 || this.f3425m > 0) {
            arrayList.add(new C1193eq(this.f3413a.getString(R.string.others), this.f3423k, this.f3424l, this.f3425m));
        }
        return arrayList;
    }

    @SuppressLint({"InflateParams"})
    /* JADX INFO: renamed from: a */
    public final void m3014a() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f3413a);
        builder.setTitle(R.string.rebuild_the_apk);
        View viewInflate = LayoutInflater.from(this.f3413a).inflate(R.layout.dlg_rebuild_confirm, (ViewGroup) null);
        ExpandableListView expandableListView = (ExpandableListView) viewInflate.findViewById(R.id.modificationList);
        List listM3013b = m3013b();
        expandableListView.setAdapter(new C1192ep(this.f3413a, listM3013b));
        for (int i = 0; i < listM3013b.size(); i++) {
            expandableListView.expandGroup(i);
        }
        this.f3414b = (CheckBox) viewInflate.findViewById(R.id.cb_rebuild_dex);
        this.f3415c = (CheckBox) viewInflate.findViewById(R.id.cb_rebuild_res);
        this.f3416d = (CheckBox) viewInflate.findViewById(R.id.cb_resign);
        this.f3414b.setChecked(!this.f3429q.isEmpty());
        this.f3415c.setChecked(this.f3417e || this.f3418f || this.f3419g);
        this.f3414b.setEnabled(false);
        this.f3415c.setEnabled(false);
        this.f3416d.setChecked(true);
        builder.setView(viewInflate);
        builder.setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC1211fd(this));
        builder.setNegativeButton(android.R.string.cancel, new DialogInterfaceOnClickListenerC1212fe(this));
        builder.show();
    }
}
