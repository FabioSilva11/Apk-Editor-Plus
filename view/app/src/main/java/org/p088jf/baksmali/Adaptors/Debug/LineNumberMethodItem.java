package org.p088jf.baksmali.Adaptors.Debug;

import java.io.IOException;
import org.p088jf.baksmali.formatter.BaksmaliWriter;
import org.p088jf.dexlib2.iface.debug.LineNumber;

/* JADX INFO: loaded from: classes.dex */
public class LineNumberMethodItem extends DebugMethodItem {
    public final int lineNumber;

    public LineNumberMethodItem(int i, int i2, LineNumber lineNumber) {
        super(i, i2);
        this.lineNumber = lineNumber.getLineNumber();
    }

    @Override // org.p088jf.baksmali.Adaptors.MethodItem
    public boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
        baksmaliWriter.write(".line ");
        baksmaliWriter.writeUnsignedIntAsDec(this.lineNumber);
        return true;
    }
}
