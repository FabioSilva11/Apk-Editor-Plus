package org.p088jf.baksmali.Adaptors.Debug;

import java.io.IOException;
import org.p088jf.baksmali.Adaptors.ClassDefinition;
import org.p088jf.baksmali.Adaptors.RegisterFormatter;
import org.p088jf.baksmali.formatter.BaksmaliWriter;
import org.p088jf.dexlib2.iface.debug.StartLocal;

/* JADX INFO: loaded from: classes.dex */
public class StartLocalMethodItem extends DebugMethodItem {
    public final RegisterFormatter registerFormatter;
    public final StartLocal startLocal;

    public StartLocalMethodItem(ClassDefinition classDefinition, int i, int i2, RegisterFormatter registerFormatter, StartLocal startLocal) {
        super(i, i2);
        this.startLocal = startLocal;
        this.registerFormatter = registerFormatter;
    }

    @Override // org.p088jf.baksmali.Adaptors.MethodItem
    public boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
        baksmaliWriter.write(".local ");
        this.registerFormatter.writeTo(baksmaliWriter, this.startLocal.getRegister());
        String name = this.startLocal.getName();
        String type = this.startLocal.getType();
        String signature = this.startLocal.getSignature();
        if (name == null && type == null && signature == null) {
            return true;
        }
        baksmaliWriter.write(", ");
        LocalFormatter.writeLocal(baksmaliWriter, name, type, signature);
        return true;
    }
}
