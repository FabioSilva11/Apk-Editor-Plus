package org.p088jf.baksmali.Adaptors;

import java.io.IOException;
import org.p088jf.baksmali.BaksmaliOptions;
import org.p088jf.baksmali.formatter.BaksmaliWriter;

/* JADX INFO: loaded from: classes.dex */
public class LabelMethodItem extends MethodItem {
    public final String labelPrefix;
    public int labelSequence;
    public final BaksmaliOptions options;

    public LabelMethodItem(BaksmaliOptions baksmaliOptions, int i, String str) {
        super(i);
        this.options = baksmaliOptions;
        this.labelPrefix = str;
    }

    @Override // org.p088jf.baksmali.Adaptors.MethodItem, java.lang.Comparable
    public int compareTo(MethodItem methodItem) {
        int iCompareTo = super.compareTo(methodItem);
        return (iCompareTo == 0 && (methodItem instanceof LabelMethodItem)) ? this.labelPrefix.compareTo(((LabelMethodItem) methodItem).labelPrefix) : iCompareTo;
    }

    public boolean equals(Object obj) {
        return (obj instanceof LabelMethodItem) && compareTo((MethodItem) obj) == 0;
    }

    public int getLabelAddress() {
        return getCodeAddress();
    }

    public String getLabelPrefix() {
        return this.labelPrefix;
    }

    @Override // org.p088jf.baksmali.Adaptors.MethodItem
    public double getSortOrder() {
        return 0.0d;
    }

    public int hashCode() {
        return getCodeAddress();
    }

    public void setLabelSequence(int i) {
        this.labelSequence = i;
    }

    @Override // org.p088jf.baksmali.Adaptors.MethodItem
    public boolean writeTo(BaksmaliWriter baksmaliWriter) throws IOException {
        baksmaliWriter.write(58);
        baksmaliWriter.write(this.labelPrefix);
        if (this.options.sequentialLabels) {
            baksmaliWriter.writeUnsignedLongAsHex(this.labelSequence);
            return true;
        }
        baksmaliWriter.writeUnsignedLongAsHex(getLabelAddress());
        return true;
    }
}
