package com.gmail.heagoo.apkeditor.p066e;

import java.io.BufferedReader;
import java.io.Reader;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1155c extends BufferedReader {

    /* JADX INFO: renamed from: a */
    private int f3257a;

    public C1155c(Reader reader) {
        super(reader);
        this.f3257a = 0;
    }

    /* JADX INFO: renamed from: a */
    public final int m2908a() {
        return this.f3257a;
    }

    @Override // java.io.BufferedReader
    public final String readLine() {
        this.f3257a++;
        return super.readLine();
    }
}
