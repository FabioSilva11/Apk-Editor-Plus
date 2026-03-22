package org.p088jf.baksmali.formatter;

import java.io.Writer;
import org.p088jf.dexlib2.formatter.DexFormatter;

/* JADX INFO: loaded from: classes.dex */
public class BaksmaliFormatter extends DexFormatter {
    public final String classContext;

    public BaksmaliFormatter(String str) {
        this.classContext = str;
    }

    @Override // org.p088jf.dexlib2.formatter.DexFormatter
    public BaksmaliWriter getWriter(Writer writer) {
        return new BaksmaliWriter(writer, this.classContext);
    }
}
