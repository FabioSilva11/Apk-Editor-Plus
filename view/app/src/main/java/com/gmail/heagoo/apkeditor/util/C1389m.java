package com.gmail.heagoo.apkeditor.util;

import android.content.Context;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1491w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1389m extends AbstractC1382f {

    /* JADX INFO: renamed from: e */
    private int f4031e;

    /* JADX INFO: renamed from: f */
    private int f4032f;

    /* JADX INFO: renamed from: g */
    private List f4033g;

    public C1389m(String str, String str2) throws Throwable {
        super(str, str2);
        this.f4031e = 0;
        this.f4032f = 0;
        this.f4033g = new ArrayList();
        try {
            m3352e();
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3350a(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3351a(String str) {
        String[] strArrSplit = str.split("/");
        int length = strArrSplit.length;
        String str2 = strArrSplit[length - 1];
        String str3 = strArrSplit[length - 2];
        int iIndexOf = str3.indexOf(45);
        String strSubstring = iIndexOf != -1 ? str3.substring(0, iIndexOf) : str3;
        for (int i = 0; i < this.f4033g.size(); i++) {
            C1390n c1390n = (C1390n) this.f4033g.get(i);
            if (str2.equals(c1390n.f4036c) && strSubstring.equals(c1390n.f4034a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: e */
    private void m3352e() throws Throwable {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new StringReader(this.f4012b));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                int iIndexOf = line.indexOf(": Invalid file name: must contain only ");
                if (iIndexOf > 0) {
                    String strSubstring = line.substring(0, iIndexOf);
                    if (!m3351a(strSubstring)) {
                        this.f4033g.add(new C1390n(strSubstring, (byte) 0));
                    }
                }
            }
            m3350a(bufferedReader);
        } catch (Throwable th2) {
            th = th2;
            m3350a(bufferedReader);
            throw th;
        }
    }

    /* JADX INFO: renamed from: f */
    private void m3353f() {
        ArrayList arrayList = new ArrayList();
        for (C1390n c1390n : this.f4033g) {
            arrayList.add(new C1401y(c1390n.f4034a, c1390n.f4035b, c1390n.f4038e));
        }
        m3336a(arrayList);
    }

    /* JADX INFO: renamed from: g */
    private void m3354g() {
        String str = this.f4011a + "res/values/public.xml";
        try {
            String strM3537b = new C1491w(str).m3537b();
            for (int i = 0; i < this.f4033g.size(); i++) {
                C1390n c1390n = (C1390n) this.f4033g.get(i);
                strM3537b = strM3537b.replace("\"" + c1390n.f4035b + "\"", "\"" + c1390n.f4038e + "\"");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(strM3537b.getBytes());
            fileOutputStream.close();
            this.f4032f++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: a */
    public final String mo3337a(Context context) {
        StringBuilder sb = new StringBuilder();
        if (this.f4031e > 0) {
            sb.append(String.format(context.getString(R.string.str_num_renamed_file), Integer.valueOf(this.f4031e)));
            sb.append("\n");
        }
        if (this.f4032f > 0) {
            sb.append(String.format(context.getString(R.string.str_num_modified_file), Integer.valueOf(this.f4032f)));
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: a */
    public final boolean mo3339a() {
        return this.f4033g.size() > 0;
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: b */
    public final void mo3340b() {
        File[] fileArrListFiles;
        File[] fileArrListFiles2 = new File(this.f4011a + "res").listFiles();
        for (int i = 0; i < this.f4033g.size(); i++) {
            C1390n c1390n = (C1390n) this.f4033g.get(i);
            C1390n.m3355a(c1390n, i);
            if (fileArrListFiles2 != null) {
                for (File file : fileArrListFiles2) {
                    if (!file.isFile() && file.getName().startsWith(c1390n.f4034a) && (fileArrListFiles = file.listFiles()) != null) {
                        for (File file2 : fileArrListFiles) {
                            if (!file2.isDirectory() && file2.getName().equals(c1390n.f4036c)) {
                                file2.renameTo(new File(file, c1390n.f4037d));
                                this.f4031e++;
                            }
                        }
                    }
                }
            }
        }
        m3354g();
        m3353f();
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: c */
    public final boolean mo3341c() {
        return this.f4031e > 0 || this.f4032f > 0;
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: d */
    public final Map mo3342d() {
        return null;
    }
}
