package com.gmail.heagoo.appdm;

import com.gmail.heagoo.appdm.util.C1443i;
import com.gmail.heagoo.common.ccc;
import com.gmail.heagoo.p054a.p059c.C0986ax;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.m */
/* JADX INFO: loaded from: classes.dex */
final class C1428m extends Thread {

    /* JADX INFO: renamed from: a */
    private WeakReference f4208a;

    public C1428m(PrefDetailActivity prefDetailActivity) {
        this.f4208a = new WeakReference(prefDetailActivity);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap mapA_004;
        PrefDetailActivity prefDetailActivity = (PrefDetailActivity) this.f4208a.get();
        if (prefDetailActivity != null) {
            try {
                if (!C1443i.m3464a()) {
                    throw new Exception("Can not find SD Card!");
                }
                File file = new File(C1443i.m3465b(prefDetailActivity));
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (prefDetailActivity.f4096l) {
                    String path = new File(prefDetailActivity.getFilesDir(), "work.xml").getPath();
                    prefDetailActivity.f4087b = path;
                    ccc cccVarM3383a = PrefDetailActivity.m3383a(prefDetailActivity.f4096l);
                    File file2 = new File(prefDetailActivity.getFilesDir(), "mycp");
                    boolean zMo3495a = cccVarM3383a.mo3495a(String.format((file2.exists() ? file2.getPath() : "cp") + " \"%s\" %s", prefDetailActivity.f4086a, path, path), (String[]) null, (Integer) 5000);
                    cccVarM3383a.mo3497b();
                    if (!zMo3495a) {
                        path = prefDetailActivity.f4086a;
                    }
                    FileInputStream fileInputStream = new FileInputStream(path);
                    mapA_004 = C0986ax.a_004(fileInputStream);
                    fileInputStream.close();
                } else {
                    FileInputStream fileInputStream2 = new FileInputStream(prefDetailActivity.f4086a);
                    mapA_004 = C0986ax.a_004(fileInputStream2);
                    fileInputStream2.close();
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : mapA_004.entrySet()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
                PrefDetailActivity.m3385a(prefDetailActivity, linkedHashMap);
                prefDetailActivity.m3389a((String) null);
            } catch (Exception e) {
                prefDetailActivity.m3389a(e.getMessage() + ": " + ((String) null));
            }
        }
    }
}
