package com.gmail.heagoo.apkeditor;

/* JADX INFO: loaded from: classes.dex */
public class gzd {
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String CREATE_TABLE = "CREATE TABLE templates(id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,content TEXT)";
    public static final String TABLE_NAME = "templates";
    private String content;

    /* JADX INFO: renamed from: id */
    private int f3600id;
    private String title;

    public gzd() {
    }

    public gzd(int i, String str, String str2) {
        this.f3600id = i;
        this.title = str;
        this.content = str2;
    }

    public String getContent() {
        return this.content;
    }

    public int getId() {
        return this.f3600id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(int i) {
        this.f3600id = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
