package com.gmail.heagoo.httpserver;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000a.p001a.p003b.p004a.p005a.C0027x;

/* JADX INFO: renamed from: com.gmail.heagoo.httpserver.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1496e {

    /* JADX INFO: renamed from: a */
    private static C1496e f4339a = null;

    /* JADX INFO: renamed from: b */
    private final List f4340b = new ArrayList();

    private C1496e() {
    }

    /* JADX INFO: renamed from: a */
    public static C1496e m3554a() {
        if (f4339a == null) {
            f4339a = new C1496e();
        }
        return f4339a;
    }

    /* JADX INFO: renamed from: b */
    public static void m3557b(Activity activity) {
        activity.stopService(new Intent(activity, (Class<?>) HttpService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m3558b(Activity activity, String str) {
        new AlertDialog.Builder(activity).setTitle(R.string.web_server).setMessage(String.format(activity.getString(R.string.web_server_started), str)).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: renamed from: c */
    private BinderC1495d m3559c(Activity activity) {
        synchronized (this.f4340b) {
            for (ServiceConnectionC1497f serviceConnectionC1497f : this.f4340b) {
                if (serviceConnectionC1497f.f4341a.get() == activity) {
                    return serviceConnectionC1497f.f4342b;
                }
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3560a(Activity activity) {
        ServiceConnectionC1497f serviceConnectionC1497f;
        synchronized (this.f4340b) {
            Iterator it = this.f4340b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    serviceConnectionC1497f = null;
                    break;
                } else {
                    serviceConnectionC1497f = (ServiceConnectionC1497f) it.next();
                    if (serviceConnectionC1497f.f4341a.get() == activity) {
                        break;
                    }
                }
            }
        }
        if (serviceConnectionC1497f != null) {
            activity.unbindService(serviceConnectionC1497f);
            synchronized (this.f4340b) {
                this.f4340b.remove(serviceConnectionC1497f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3561a(Activity activity, String str) {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpen;
        File file;
        InputStream inputStream = null;
        BinderC1495d binderC1495dM3559c = m3559c(activity);
        if (binderC1495dM3559c != null) {
            binderC1495dM3559c.f4338a.f4330b = str;
            if (binderC1495dM3559c.f4338a.f4331c != null) {
                binderC1495dM3559c.f4338a.f4331c.m3552a(str);
            }
            m3558b(activity, binderC1495dM3559c.m3553a());
            return;
        }
        File file2 = new File(activity.getFilesDir(), "http_server");
        if (!file2.exists()) {
            try {
                inputStreamOpen = activity.getAssets().open("http.zip");
                try {
                    file = new File(activity.getFilesDir(), "http.zip");
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = null;
                    inputStream = inputStreamOpen;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    C0985a.m2244b(inputStreamOpen, fileOutputStream);
                    file2.mkdir();
                    C0027x.m29a(file.getPath(), file2.getPath());
                    file.delete();
                    C0985a.m2212a((Closeable) inputStreamOpen);
                    C0985a.m2212a(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    inputStream = inputStreamOpen;
                    try {
                        Toast.makeText(activity, "Init Error: " + e.getMessage(), 1).show();
                        C0985a.m2212a((Closeable) inputStream);
                        C0985a.m2212a(fileOutputStream);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamOpen = inputStream;
                        C0985a.m2212a((Closeable) inputStreamOpen);
                        C0985a.m2212a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    C0985a.m2212a((Closeable) inputStreamOpen);
                    C0985a.m2212a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                inputStreamOpen = null;
            }
        }
        Intent intent = new Intent(activity, (Class<?>) HttpService.class);
        C0985a.m2180a(intent, "httpDirectory", file2.getPath());
        C0985a.m2180a(intent, "projectDirectory", str);
        activity.startService(intent);
        activity.bindService(intent, new ServiceConnectionC1497f(this, activity), 1);
    }
}
