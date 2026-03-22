package org.p088jf.dexlib2.analysis;

import org.p088jf.util.ExceptionWithContext;

/* JADX INFO: loaded from: classes.dex */
public class AnalysisException extends ExceptionWithContext {
    public int codeAddress;

    public AnalysisException(String str, Object... objArr) {
        super(str, objArr);
    }
}
