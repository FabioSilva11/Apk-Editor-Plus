package com.gmail.heagoo.apkeditor.p066e;

import com.gmail.heagoo.apkeditor.pro.R;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.d */
/* JADX INFO: loaded from: classes.dex */
public class C1156d {

    /* JADX INFO: renamed from: a */
    public List f3258a = new ArrayList();

    /* JADX INFO: renamed from: a */
    public static C1156d m2909a(InputStream inputStream, InterfaceC1154b interfaceC1154b) {
        interfaceC1154b.mo2899a(R.string.patch_start_parse, true, new Object[0]);
        C1156d c1156d = new C1156d();
        C1155c c1155c = new C1155c(new InputStreamReader(inputStream));
        for (String line = c1155c.readLine(); line != null; line = c1155c.readLine()) {
            String strTrim = line.trim();
            if (strTrim.startsWith("[")) {
                if ("[MIN_ENGINE_VER]".equals(strTrim)) {
                    Integer.valueOf(c1155c.readLine()).intValue();
                } else if ("[AUTHOR]".equals(strTrim)) {
                    c1155c.readLine();
                } else if ("[PACKAGE]".equals(strTrim)) {
                    c1155c.readLine();
                } else {
                    AbstractC1159g c1163k = null;
                    if ("[ADD_FILES]".equals(strTrim)) {
                        c1163k = new C1161i();
                    } else if ("[REMOVE_FILES]".equals(strTrim)) {
                        c1163k = new C1173u();
                    } else if ("[MERGE]".equals(strTrim)) {
                        c1163k = new C1171s();
                    } else if ("[MATCH_REPLACE]".equals(strTrim)) {
                        c1163k = new C1169q();
                    } else if ("[MATCH_GOTO]".equals(strTrim)) {
                        c1163k = new C1167o();
                    } else if ("[MATCH_ASSIGN]".equals(strTrim)) {
                        c1163k = new C1166n();
                    } else if ("[FUNCTION_REPLACE]".equals(strTrim)) {
                        c1163k = new C1164l();
                    } else if ("[SIGNATURE_REVISE]".equals(strTrim)) {
                        c1163k = new C1174v();
                    } else if ("[GOTO]".equals(strTrim)) {
                        c1163k = new C1165m();
                    } else if ("[CARLOS]".equals(strTrim)) {
                        c1163k = new C1162j();
                    } else if ("[EXECUTE_DEX]".equals(strTrim)) {
                        c1163k = new C1163k();
                    } else {
                        interfaceC1154b.mo2900a(R.string.patch_error_unknown_rule, Integer.valueOf(c1155c.m2908a()), strTrim);
                    }
                    if (c1163k != null) {
                        c1163k.mo2927a(c1155c, interfaceC1154b);
                    }
                    if (c1163k != null) {
                        c1156d.f3258a.add(c1163k);
                    }
                }
            } else if (!strTrim.startsWith("#") && !"".equals(strTrim)) {
                interfaceC1154b.mo2900a(R.string.patch_error_unknown_rule, Integer.valueOf(c1155c.m2908a()), strTrim);
            }
        }
        return c1156d;
    }
}
