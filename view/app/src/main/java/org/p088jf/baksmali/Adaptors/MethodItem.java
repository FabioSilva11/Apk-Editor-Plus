package org.p088jf.baksmali.Adaptors;

import java.io.IOException;
import org.p088jf.baksmali.formatter.BaksmaliWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class MethodItem implements Comparable<MethodItem> {
    public final int codeAddress;

    public MethodItem(int i) {
        this.codeAddress = i;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    public int compareTo(MethodItem methodItem) {
        int iCompareTo = Integer.valueOf(this.codeAddress).compareTo(Integer.valueOf(methodItem.codeAddress));
        return iCompareTo == 0 ? Double.valueOf(getSortOrder()).compareTo(Double.valueOf(methodItem.getSortOrder())) : iCompareTo;
    }

    public int getCodeAddress() {
        return this.codeAddress;
    }

    public abstract double getSortOrder();

    public abstract boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException;
}
