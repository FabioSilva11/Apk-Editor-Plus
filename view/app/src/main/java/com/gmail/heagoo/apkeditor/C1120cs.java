package com.gmail.heagoo.apkeditor;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.cs */
/* JADX INFO: loaded from: classes.dex */
final class C1120cs implements FilenameFilter {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ DialogC1115cn f3182a;

    C1120cs(DialogC1115cn dialogC1115cn) {
        this.f3182a = dialogC1115cn;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return new File(file, str).isDirectory() || this.f3182a.m2851a(str);
    }
}
