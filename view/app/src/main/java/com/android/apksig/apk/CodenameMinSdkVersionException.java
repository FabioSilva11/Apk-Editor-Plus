package com.android.apksig.apk;

/* JADX INFO: loaded from: classes.dex */
public class CodenameMinSdkVersionException extends MinSdkVersionException {
    public final String mCodename;

    public CodenameMinSdkVersionException(String str, String str2) {
        super(str);
        this.mCodename = str2;
    }

    public String getCodename() {
        return this.mCodename;
    }
}
