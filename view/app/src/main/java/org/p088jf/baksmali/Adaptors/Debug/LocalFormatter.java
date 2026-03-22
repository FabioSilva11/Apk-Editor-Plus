package org.p088jf.baksmali.Adaptors.Debug;

import java.io.IOException;
import org.p088jf.baksmali.formatter.BaksmaliWriter;
import org.p088jf.dexlib2.immutable.value.ImmutableNullEncodedValue;

/* JADX INFO: loaded from: classes.dex */
public class LocalFormatter {
    public static void writeLocal(BaksmaliWriter baksmaliWriter, String str, String str2, String str3) throws IOException {
        if (str != null) {
            baksmaliWriter.writeQuotedString(str);
        } else {
            baksmaliWriter.writeEncodedValue(ImmutableNullEncodedValue.INSTANCE);
        }
        baksmaliWriter.write(58);
        if (str2 != null) {
            baksmaliWriter.writeType(str2);
        } else {
            baksmaliWriter.writeType("V");
        }
        if (str3 != null) {
            baksmaliWriter.write(", ");
            baksmaliWriter.writeQuotedString(str3);
        }
    }
}
