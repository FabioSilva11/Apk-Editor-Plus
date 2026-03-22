package org.p088jf.baksmali.Adaptors;

import android.support.v7.appcompat.C0299R;
import java.io.IOException;
import org.p088jf.baksmali.BaksmaliOptions;
import org.p088jf.baksmali.formatter.BaksmaliWriter;

/* JADX INFO: loaded from: classes.dex */
public class RegisterFormatter {
    public final BaksmaliOptions options;
    public final int parameterRegisterCount;
    public final int registerCount;

    public RegisterFormatter(BaksmaliOptions baksmaliOptions, int i, int i2) {
        this.options = baksmaliOptions;
        this.registerCount = i;
        this.parameterRegisterCount = i2;
    }

    public void writeRegisterRange(BaksmaliWriter baksmaliWriter, int i, int i2) throws IOException {
        if (!this.options.parameterRegisters || i < this.registerCount - this.parameterRegisterCount) {
            baksmaliWriter.write("{v");
            baksmaliWriter.writeSignedIntAsDec(i);
            baksmaliWriter.write(" .. v");
            baksmaliWriter.writeSignedIntAsDec(i2);
            baksmaliWriter.write(125);
            return;
        }
        baksmaliWriter.write("{p");
        baksmaliWriter.writeSignedIntAsDec(i - (this.registerCount - this.parameterRegisterCount));
        baksmaliWriter.write(" .. p");
        baksmaliWriter.writeSignedIntAsDec(i2 - (this.registerCount - this.parameterRegisterCount));
        baksmaliWriter.write(125);
    }

    public void writeTo(BaksmaliWriter baksmaliWriter, int i) throws IOException {
        if (!this.options.parameterRegisters || i < this.registerCount - this.parameterRegisterCount) {
            baksmaliWriter.write(C0299R.styleable.AppCompatTheme_tooltipForegroundColor);
            baksmaliWriter.writeSignedIntAsDec(i);
        } else {
            baksmaliWriter.write(C0299R.styleable.AppCompatTheme_ratingBarStyleSmall);
            baksmaliWriter.writeSignedIntAsDec(i - (this.registerCount - this.parameterRegisterCount));
        }
    }
}
