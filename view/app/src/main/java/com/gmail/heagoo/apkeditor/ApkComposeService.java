package com.gmail.heagoo.apkeditor;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import com.android.apksig.apk.ApkUtils;
import com.gmail.heagoo.apkeditor.p060a.InterfaceC1026d;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1479k;
import com.gmail.heagoo.common.InterfaceC1478j;
import com.gmail.heagoo.p054a.p059c.C0985a;
import com.gmail.heagoo.p054a.p059c.ResXmlPatcher;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ApkComposeService extends Service implements InterfaceC1478j {

    /* JADX INFO: renamed from: a */
    private String f2524a;

    /* JADX INFO: renamed from: b */
    private String f2525b;

    /* JADX INFO: renamed from: c */
    private Boolean f2526c;

    /* JADX INFO: renamed from: d */
    private Boolean f2527d;

    /* JADX INFO: renamed from: e */
    private Boolean f2528e;

    /* JADX INFO: renamed from: f */
    private ArrayList f2529f;

    /* JADX INFO: renamed from: g */
    private Map f2530g;

    /* JADX INFO: renamed from: h */
    private Map f2531h;

    /* JADX INFO: renamed from: i */
    private Set f2532i;

    /* JADX INFO: renamed from: j */
    private Map f2533j;

    /* JADX INFO: renamed from: k */
    private String f2534k;

    /* JADX INFO: renamed from: l */
    private AbstractC1099bz f2535l;

    /* JADX INFO: renamed from: n */
    private WeakReference f2537n;

    /* JADX INFO: renamed from: p */
    private NotificationManager f2539p;

    /* JADX INFO: renamed from: q */
    private NotificationCompat.Builder f2540q;

    /* JADX INFO: renamed from: u */
    private boolean f2544u;

    /* JADX INFO: renamed from: m */
    private C1314j f2536m = new C1314j(this);

    /* JADX INFO: renamed from: o */
    private InterfaceC1026d f2538o = null;

    /* JADX INFO: renamed from: r */
    private boolean f2541r = false;

    /* JADX INFO: renamed from: s */
    private HandlerC1319l f2542s = new HandlerC1319l(this, 0);

    /* JADX INFO: renamed from: t */
    private BinderC1318k f2543t = new BinderC1318k(this);

    /* JADX INFO: renamed from: v */
    private long f2545v = 0;

    /* JADX INFO: renamed from: a */
    static /* synthetic */ NotificationManager m2340a(ApkComposeService apkComposeService, NotificationManager notificationManager) {
        apkComposeService.f2539p = null;
        return null;
    }

    /* JADX INFO: renamed from: a */
    private void m2344a(boolean z, String str, String str2) {
        if (this.f2539p != null) {
            this.f2542s.removeMessages(0);
            this.f2542s.m3193a(str, str2);
            if (z || System.currentTimeMillis() - this.f2545v > 1000) {
                this.f2542s.sendEmptyMessage(0);
            } else {
                this.f2542s.sendEmptyMessageDelayed(0, 500L);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static Map m2346b(String str) throws Throwable {
        BufferedReader bufferedReader;
        HashMap map = new HashMap();
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
        } catch (Exception e) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String line2 = bufferedReader.readLine();
                if (line2 != null) {
                    map.put(line, line2);
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e2) {
            }
        } catch (Exception e3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                }
            }
        } catch (Throwable th2) {
            bufferedReader2 = bufferedReader;
            th = th2;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m2347b() {
        Intent intent = new Intent(this, (Class<?>) ApkComposeActivity.class);
        intent.setAction("com.gmail.heagoo.action.apkcompose");
        intent.setFlags(131072);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 0);
        int iIntValue = ((Integer) C0985a.m2190a("com.gmail.heagoo.seticon.SetIcon", "getIconId", (Class[]) null, (Object[]) null)).intValue();
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), iIntValue);
        String string = getString(R.string.app_name);
        this.f2539p = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2540q = new NotificationCompat.Builder(this, "default");
        } else {
            this.f2540q = new NotificationCompat.Builder(this);
        }
        this.f2540q.setContentTitle(string).setTicker(string).setContentText(getString(R.string.build_ongoing)).setSmallIcon(iIntValue).setLargeIcon(Bitmap.createScaledBitmap(bitmapDecodeResource, 128, 128, false)).setContentIntent(activity).setOngoing(true);
        startForeground(8001, this.f2540q.build());
        this.f2541r = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m2350c() {
        if (this.f2535l != null && this.f2535l.isAlive()) {
            this.f2535l.mo2825b();
        }
        C1314j c1314j = this.f2536m;
        c1314j.f3724a = false;
        c1314j.f3726c = null;
        c1314j.f3727d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m2352d() {
        ResXmlPatcher.m2166a(new File(this.f2524a, ApkUtils.ANDROID_MANIFEST_ZIP_ENTRY_NAME));
        if (this.f2525b != null) {
            this.f2535l = new C1322m(this, this.f2524a, this.f2525b, this.f2534k);
        } else {
            this.f2535l = new C1331o(this, this.f2524a, this.f2534k);
        }
        if (this.f2538o != null) {
            this.f2535l.mo2822a(this.f2538o);
        }
        this.f2535l.mo2824a(this.f2526c.booleanValue(), this.f2527d.booleanValue(), this.f2528e.booleanValue(), this.f2529f, this.f2530g, this.f2531h, this.f2532i, this.f2533j, this.f2544u);
        this.f2535l.mo2823a(this);
        this.f2535l.start();
    }

    @Override // com.gmail.heagoo.common.InterfaceC1478j
    /* JADX INFO: renamed from: a */
    public final void mo2333a() {
        InterfaceC1478j interfaceC1478j;
        synchronized (this.f2536m) {
            this.f2536m.f3724a = true;
            this.f2536m.f3725b = true;
            this.f2536m.f3726c = null;
        }
        m2344a(true, getString(R.string.build_finished), getString(R.string.succeed));
        if (this.f2537n == null || (interfaceC1478j = (InterfaceC1478j) this.f2537n.get()) == null) {
            return;
        }
        interfaceC1478j.mo2333a();
    }

    @Override // com.gmail.heagoo.common.InterfaceC1478j
    /* JADX INFO: renamed from: a */
    public final void mo2334a(C1479k c1479k) {
        InterfaceC1478j interfaceC1478j;
        synchronized (this.f2536m) {
            this.f2536m.f3727d = c1479k;
        }
        if (this.f2537n != null && (interfaceC1478j = (InterfaceC1478j) this.f2537n.get()) != null) {
            interfaceC1478j.mo2334a(c1479k);
        }
        m2344a(c1479k.f4305a == c1479k.f4306b, getString(R.string.build_ongoing), String.format(getResources().getString(R.string.step) + " %d/%d: %s", Integer.valueOf(c1479k.f4305a), Integer.valueOf(c1479k.f4306b), c1479k.f4307c));
    }

    @Override // com.gmail.heagoo.common.InterfaceC1478j
    /* JADX INFO: renamed from: a */
    public final void mo2335a(String str) {
        InterfaceC1478j interfaceC1478j;
        synchronized (this.f2536m) {
            this.f2536m.f3724a = true;
            this.f2536m.f3725b = false;
            this.f2536m.f3726c = str;
        }
        m2344a(true, getString(R.string.build_finished), getString(R.string.failed));
        if (this.f2537n == null || (interfaceC1478j = (InterfaceC1478j) this.f2537n.get()) == null) {
            return;
        }
        interfaceC1478j.mo2335a(str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2543t;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        this.f2524a = C0985a.m2195a(intent, "decodeRootPath");
        this.f2525b = C0985a.m2195a(intent, "srcApkPath");
        this.f2534k = C0985a.m2195a(intent, "targetApkPath");
        this.f2526c = Boolean.valueOf(C0985a.m2195a(intent, "stringModified"));
        this.f2527d = Boolean.valueOf(C0985a.m2195a(intent, "manifestModified"));
        this.f2528e = Boolean.valueOf(C0985a.m2195a(intent, "resFileModified"));
        this.f2529f = C0985a.m2256c(intent, "modifiedSmaliFolders");
        this.f2544u = C0985a.m2247b(intent, "signAPK");
        this.f2530g = C0985a.m2265d(intent, "addedFiles");
        this.f2531h = C0985a.m2265d(intent, "replacedFiles");
        this.f2532i = new HashSet();
        Iterator it = C0985a.m2256c(intent, "deletedFiles").iterator();
        while (it.hasNext()) {
            this.f2532i.add((String) it.next());
        }
        String strM2195a = C0985a.m2195a(intent, "fileEntry2ZipEntry");
        if (strM2195a != null) {
            this.f2533j = m2346b(strM2195a);
        }
        m2350c();
        m2347b();
        m2352d();
        return 1;
    }
}
