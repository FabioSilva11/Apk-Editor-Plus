package com.gmail.heagoo.apkeditor;

import android.widget.BaseAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1234g extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private WeakReference f3514a;

    /* JADX INFO: renamed from: c */
    private List f3515c = new ArrayList();

    public C1234g(ApkComposeActivity apkComposeActivity, String str) {
        this.f3514a = new WeakReference(apkComposeActivity);
        m3098a(str);
    }

    /* JADX INFO: renamed from: a */
    public final void m3098a(String str) {
        this.f3515c.clear();
        if (str != null) {
            for (String str2 : str.split("\\r?\\n")) {
                if (!"".equals(str2)) {
                    this.f3515c.add(str2);
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3515c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f3515c.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View getView(int r10, android.view.View r11, android.view.ViewGroup r12) {
        /*
            r9 = this;
            r8 = 58
            r2 = -1
            r4 = 0
            if (r11 != 0) goto L93
            r0 = 2130903189(0x7f030095, float:1.7413189E38)
            r1 = r0
            java.lang.ref.WeakReference r0 = r9.f3514a
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            r3 = 0
            android.view.View r11 = r0.inflate(r1, r3)
            com.gmail.heagoo.apkeditor.i r1 = new com.gmail.heagoo.apkeditor.i
            r1.<init>(r4)
            r0 = 2131558519(0x7f0d0077, float:1.8742356E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.f3664a = r0
            r0 = 2131558843(0x7f0d01bb, float:1.8743013E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r1.f3665b = r0
            r11.setTag(r1)
        L39:
            java.util.List r0 = r9.f3515c
            java.lang.Object r0 = r0.get(r10)
            java.lang.String r0 = (java.lang.String) r0
            int r5 = r0.indexOf(r8)
            if (r5 == r2) goto L9e
            java.lang.String r6 = r0.substring(r4, r5)
            java.io.File r3 = new java.io.File
            r3.<init>(r6)
            boolean r3 = r3.exists()
            if (r3 == 0) goto L9e
            r3 = 1
            android.widget.RelativeLayout r7 = r1.f3665b
            r7.setVisibility(r4)
            int r4 = r5 + 1
            int r4 = r0.indexOf(r8, r4)
            if (r4 == r2) goto L9c
            int r5 = r5 + 1
            java.lang.String r0 = r0.substring(r5, r4)     // Catch: java.lang.Exception -> L9b
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> L9b
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> L9b
        L72:
            android.widget.RelativeLayout r2 = r1.f3665b
            com.gmail.heagoo.apkeditor.h r4 = new com.gmail.heagoo.apkeditor.h
            r4.<init>(r9, r6, r0)
            r2.setOnClickListener(r4)
            r0 = r3
        L7d:
            if (r0 != 0) goto L85
            android.widget.RelativeLayout r0 = r1.f3665b
            r2 = 4
            r0.setVisibility(r2)
        L85:
            android.widget.TextView r1 = r1.f3664a
            java.util.List r0 = r9.f3515c
            java.lang.Object r0 = r0.get(r10)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            return r11
        L93:
            java.lang.Object r0 = r11.getTag()
            com.gmail.heagoo.apkeditor.i r0 = (com.gmail.heagoo.apkeditor.C1287i) r0
            r1 = r0
            goto L39
        L9b:
            r0 = move-exception
        L9c:
            r0 = r2
            goto L72
        L9e:
            r0 = r4
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.C1234g.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
