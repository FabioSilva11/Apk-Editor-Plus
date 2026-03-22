package com.gmail.heagoo.appdm;

import com.gmail.heagoo.appdm.util.C1443i;
import com.gmail.heagoo.common.ccc;
import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.gmail.heagoo.appdm.ac */
/* JADX INFO: loaded from: classes.dex */
final class C1411ac extends Thread {

    /* JADX INFO: renamed from: a */
    private WeakReference f4149a;

    /* JADX INFO: renamed from: b */
    private String f4150b;

    /* JADX INFO: renamed from: c */
    private String f4151c;

    /* JADX INFO: renamed from: d */
    private String f4152d;

    /* JADX INFO: renamed from: e */
    private String f4153e;

    public C1411ac(PrefOverallActivity prefOverallActivity) {
        this.f4150b = prefOverallActivity.f4118c;
        this.f4149a = new WeakReference(prefOverallActivity);
    }

    /* JADX INFO: renamed from: a */
    public final String m3435a() {
        return this.f4152d;
    }

    /* JADX INFO: renamed from: b */
    public final String m3436b() {
        return this.f4153e;
    }

    /* JADX INFO: renamed from: c */
    public final String m3437c() {
        return this.f4151c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        PrefOverallActivity prefOverallActivity = (PrefOverallActivity) this.f4149a.get();
        if (prefOverallActivity != null) {
            if (C1443i.m3464a()) {
                String path = prefOverallActivity.getFilesDir().getPath();
                int iIndexOf = path.indexOf(prefOverallActivity.getPackageName());
                if (iIndexOf == -1) {
                    this.f4151c = "Can not find data path!";
                } else {
                    String strSubstring = path.substring(0, iIndexOf);
                    if (prefOverallActivity.f4107G) {
                        String str = strSubstring + this.f4150b + "/shared_prefs/*.xml";
                        String str2 = strSubstring + this.f4150b + "/databases/*.db";
                        ccc cccVarM3429g = prefOverallActivity.m3429g();
                        if (cccVarM3429g.mo3495a(String.format("ls %s", str), (String[]) null, (Integer) 5000)) {
                            this.f4152d = cccVarM3429g.mo3493a();
                            if (cccVarM3429g.mo3495a(String.format("ls %s", str2), (String[]) null, (Integer) 5000)) {
                                this.f4153e = cccVarM3429g.mo3493a();
                            } else {
                                this.f4151c = "Can not get access to read files!";
                            }
                        } else {
                            this.f4151c = "Can not get access to read files!";
                        }
                    } else {
                        File[] fileArrListFiles = new File(strSubstring + this.f4150b + "/shared_prefs").listFiles();
                        if (fileArrListFiles != null) {
                            StringBuffer stringBuffer = new StringBuffer();
                            for (File file : fileArrListFiles) {
                                stringBuffer.append(file.getAbsolutePath());
                                stringBuffer.append("\n");
                            }
                            this.f4152d = stringBuffer.toString();
                        }
                        File[] fileArrListFiles2 = new File(strSubstring + this.f4150b + "/databases").listFiles();
                        if (fileArrListFiles2 != null) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            for (File file2 : fileArrListFiles2) {
                                stringBuffer2.append(file2.getAbsolutePath());
                                stringBuffer2.append("\n");
                            }
                            this.f4153e = stringBuffer2.toString();
                        }
                    }
                    z = true;
                }
            } else {
                this.f4151c = "Can not find SD card!";
            }
        }
        PrefOverallActivity prefOverallActivity2 = (PrefOverallActivity) this.f4149a.get();
        if (prefOverallActivity2 != null) {
            prefOverallActivity2.m3423a(z);
        }
    }
}
