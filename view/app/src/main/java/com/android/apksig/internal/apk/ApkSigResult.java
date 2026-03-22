package com.android.apksig.internal.apk;

import com.android.apksig.ApkVerificationIssue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ApkSigResult {
    public final int signatureSchemeVersion;
    public boolean verified;
    public final List<ApkSignerInfo> mSigners = new ArrayList();
    public final List<ApkVerificationIssue> mWarnings = new ArrayList();
    public final List<ApkVerificationIssue> mErrors = new ArrayList();

    public ApkSigResult(int i) {
        this.signatureSchemeVersion = i;
    }

    public void addError(int i, Object... objArr) {
        this.mErrors.add(new ApkVerificationIssue(i, objArr));
    }

    public void addWarning(int i, Object... objArr) {
        this.mWarnings.add(new ApkVerificationIssue(i, objArr));
    }

    public boolean containsErrors() {
        if (!this.mErrors.isEmpty()) {
            return true;
        }
        if (this.mSigners.isEmpty()) {
            return false;
        }
        Iterator<ApkSignerInfo> it = this.mSigners.iterator();
        while (it.hasNext()) {
            if (it.next().containsErrors()) {
                return true;
            }
        }
        return false;
    }

    public boolean containsWarnings() {
        if (!this.mWarnings.isEmpty()) {
            return true;
        }
        if (this.mSigners.isEmpty()) {
            return false;
        }
        Iterator<ApkSignerInfo> it = this.mSigners.iterator();
        while (it.hasNext()) {
            if (it.next().containsWarnings()) {
                return true;
            }
        }
        return false;
    }

    public List<? extends ApkVerificationIssue> getErrors() {
        return this.mErrors;
    }

    public List<? extends ApkVerificationIssue> getWarnings() {
        return this.mWarnings;
    }
}
