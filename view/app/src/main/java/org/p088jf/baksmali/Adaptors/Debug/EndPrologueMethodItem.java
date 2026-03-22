package org.p088jf.baksmali.Adaptors.Debug;

import java.io.IOException;
import org.p088jf.baksmali.formatter.BaksmaliWriter;

/* JADX INFO: loaded from: classes.dex */
public class EndPrologueMethodItem extends DebugMethodItem {
    public EndPrologueMethodItem(int i, int i2) {
        super(i, i2);
    }

    @Override // org.p088jf.baksmali.Adaptors.MethodItem
    public boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
        baksmaliWriter.write(".prologue");
        return true;
    }
}
