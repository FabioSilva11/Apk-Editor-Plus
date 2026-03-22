package com.gmail.heagoo.apkeditor.util;

import android.content.Context;
import com.gmail.heagoo.apkeditor.pro.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.util.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1394r extends AbstractC1382f {

    /* JADX INFO: renamed from: e */
    private int f4047e;

    /* JADX INFO: renamed from: f */
    private Map f4048f;

    /* JADX INFO: renamed from: g */
    private List f4049g;

    public C1394r(String str, String str2) throws Throwable {
        super(str, str2);
        this.f4047e = 0;
        this.f4048f = new HashMap();
        this.f4049g = new ArrayList();
        try {
            m3367e();
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    private C1395s m3365a(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f4049g.size()) {
                return null;
            }
            C1395s c1395s = (C1395s) this.f4049g.get(i2);
            if (str.equals(c1395s.f4050a)) {
                return c1395s;
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00db  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m3366a(java.lang.String r12, java.util.Map r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.apkeditor.util.C1394r.m3366a(java.lang.String, java.util.Map):void");
    }

    /* JADX INFO: renamed from: e */
    private void m3367e() throws Throwable {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new StringReader(this.f4012b));
            try {
                String line = bufferedReader.readLine();
                while (line != null) {
                    int iIndexOf = line.indexOf(": error: Error parsing XML: not well-formed (invalid token)");
                    if (iIndexOf > 0) {
                        String strSubstring = line.substring(0, iIndexOf);
                        int iLastIndexOf = strSubstring.lastIndexOf(58);
                        if (iLastIndexOf != -1) {
                            String strSubstring2 = strSubstring.substring(0, iLastIndexOf);
                            try {
                                int iIntValue = Integer.valueOf(strSubstring.substring(iLastIndexOf + 1)).intValue();
                                if (m3365a(strSubstring2) == null) {
                                    this.f4049g.add(new C1395s(strSubstring2, iIntValue));
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
            } catch (Throwable th) {
                th = th;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: a */
    public final String mo3337a(Context context) {
        return String.format(context.getString(R.string.str_num_modified_file), Integer.valueOf(this.f4047e));
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: a */
    public final boolean mo3339a() {
        return this.f4049g.size() > 0;
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: b */
    public final void mo3340b() throws Throwable {
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f4049g.size()) {
                return;
            }
            m3366a(((C1395s) this.f4049g.get(i2)).f4050a, map);
            i = i2 + 1;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: c */
    public final boolean mo3341c() {
        return this.f4047e > 0;
    }

    @Override // com.gmail.heagoo.apkeditor.util.AbstractC1382f
    /* JADX INFO: renamed from: d */
    public final Map mo3342d() {
        return this.f4048f;
    }
}
