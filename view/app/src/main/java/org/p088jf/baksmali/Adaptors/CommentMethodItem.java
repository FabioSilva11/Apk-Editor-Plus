package org.p088jf.baksmali.Adaptors;

import java.io.IOException;
import org.p088jf.baksmali.formatter.BaksmaliWriter;

/* JADX INFO: loaded from: classes.dex */
public class CommentMethodItem extends MethodItem {
    public final String comment;
    public final double sortOrder;

    public CommentMethodItem(String str, int i, double d) {
        super(i);
        this.comment = str;
        this.sortOrder = d;
    }

    @Override // org.p088jf.baksmali.Adaptors.MethodItem
    public double getSortOrder() {
        return this.sortOrder;
    }

    @Override // org.p088jf.baksmali.Adaptors.MethodItem
    public boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
        baksmaliWriter.write(35);
        baksmaliWriter.write(this.comment);
        return true;
    }
}
