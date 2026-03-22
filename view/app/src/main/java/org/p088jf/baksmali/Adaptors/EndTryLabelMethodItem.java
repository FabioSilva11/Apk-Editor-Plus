package org.p088jf.baksmali.Adaptors;

import org.p088jf.baksmali.BaksmaliOptions;

/* JADX INFO: loaded from: classes.dex */
public class EndTryLabelMethodItem extends LabelMethodItem {
    public int endTryAddress;

    public EndTryLabelMethodItem(BaksmaliOptions baksmaliOptions, int i, int i2) {
        super(baksmaliOptions, i, "try_end_");
        this.endTryAddress = i2;
    }

    @Override // org.p088jf.baksmali.Adaptors.LabelMethodItem
    public int getLabelAddress() {
        return this.endTryAddress;
    }

    @Override // org.p088jf.baksmali.Adaptors.LabelMethodItem, org.p088jf.baksmali.Adaptors.MethodItem
    public double getSortOrder() {
        return 101.0d;
    }
}
