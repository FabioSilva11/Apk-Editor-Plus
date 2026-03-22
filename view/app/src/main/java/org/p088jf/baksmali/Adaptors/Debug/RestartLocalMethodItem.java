package org.p088jf.baksmali.Adaptors.Debug;

import java.io.IOException;
import org.p088jf.baksmali.Adaptors.ClassDefinition;
import org.p088jf.baksmali.Adaptors.RegisterFormatter;
import org.p088jf.baksmali.formatter.BaksmaliWriter;
import org.p088jf.dexlib2.iface.debug.RestartLocal;

/* JADX INFO: loaded from: classes.dex */
public class RestartLocalMethodItem extends DebugMethodItem {
    public final RegisterFormatter registerFormatter;
    public final RestartLocal restartLocal;

    public RestartLocalMethodItem(ClassDefinition classDefinition, int i, int i2, RegisterFormatter registerFormatter, RestartLocal restartLocal) {
        super(i, i2);
        this.restartLocal = restartLocal;
        this.registerFormatter = registerFormatter;
    }

    @Override // org.p088jf.baksmali.Adaptors.MethodItem
    public boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
        baksmaliWriter.write(".restart local ");
        this.registerFormatter.writeTo(baksmaliWriter, this.restartLocal.getRegister());
        String name = this.restartLocal.getName();
        String type = this.restartLocal.getType();
        String signature = this.restartLocal.getSignature();
        if (name == null && type == null && signature == null) {
            return true;
        }
        baksmaliWriter.write("    # ");
        LocalFormatter.writeLocal(baksmaliWriter, name, type, signature);
        return true;
    }
}
