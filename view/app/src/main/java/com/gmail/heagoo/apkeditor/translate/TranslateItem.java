package com.gmail.heagoo.apkeditor.translate;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class TranslateItem implements Serializable {
    private static final long serialVersionUID = -3101805950698159689L;
    public String name;
    public String originValue;
    public String translatedValue;

    public TranslateItem(String str, String str2) {
        this.name = str;
        this.originValue = str2;
    }

    public TranslateItem(String str, String str2, String str3) {
        this.name = str;
        this.originValue = str2;
        this.translatedValue = str3;
    }
}
