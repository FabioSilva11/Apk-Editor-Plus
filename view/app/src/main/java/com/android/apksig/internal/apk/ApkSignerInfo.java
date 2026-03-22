package com.android.apksig.internal.apk;

import com.android.apksig.ApkVerificationIssue;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ApkSignerInfo {
    public int index;
    public List<X509Certificate> certs = new ArrayList();
    public List<X509Certificate> certificateLineage = new ArrayList();
    public final List<ApkVerificationIssue> mWarnings = new ArrayList();
    public final List<ApkVerificationIssue> mErrors = new ArrayList();

    public void addError(int i, Object... objArr) {
        this.mErrors.add(new ApkVerificationIssue(i, objArr));
    }

    public void addWarning(int i, Object... objArr) {
        this.mWarnings.add(new ApkVerificationIssue(i, objArr));
    }

    public boolean containsErrors() {
        return !this.mErrors.isEmpty();
    }

    public boolean containsWarnings() {
        return !this.mWarnings.isEmpty();
    }

    public List<? extends ApkVerificationIssue> getErrors() {
        return this.mErrors;
    }

    public List<? extends ApkVerificationIssue> getWarnings() {
        return this.mWarnings;
    }
}
