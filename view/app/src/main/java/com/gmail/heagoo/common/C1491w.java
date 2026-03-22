package com.gmail.heagoo.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.common.w */
/* JADX INFO: loaded from: classes.dex */
public final class C1491w {

    /* JADX INFO: renamed from: a */
    private List f4328a = new ArrayList();

    public C1491w(String str) throws Throwable {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                this.f4328a.add(line);
            }
            bufferedReader.close();
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final List m3536a() {
        return this.f4328a;
    }

    /* JADX INFO: renamed from: b */
    public final String m3537b() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f4328a.size()) {
                return sb.toString();
            }
            sb.append((String) this.f4328a.get(i2));
            if (i2 != this.f4328a.size() - 1) {
                sb.append("\n");
            }
            i = i2 + 1;
        }
    }
}
