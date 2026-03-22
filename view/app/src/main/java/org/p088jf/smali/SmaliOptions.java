package org.p088jf.smali;

/* JADX INFO: loaded from: classes.dex */
public class SmaliOptions {
    public int apiLevel = 15;
    public String outputDexFile = "out.dex";
    public int jobs = Runtime.getRuntime().availableProcessors();
    public boolean allowOdexOpcodes = false;
    public boolean verboseErrors = false;
}
