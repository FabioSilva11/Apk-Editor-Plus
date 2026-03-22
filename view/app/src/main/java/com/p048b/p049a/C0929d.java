package com.p048b.p049a;

import android.widget.SeekBar;

/* JADX INFO: renamed from: com.b.a.d */
/* JADX INFO: loaded from: classes.dex */
final class C0929d implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ C0926a f2295a;

    C0929d(C0926a c0926a) {
        this.f2295a = c0926a;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.f2295a.f2283a.removeMessages(0);
        this.f2295a.f2283a.sendEmptyMessageDelayed(0, 100L);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
    }
}
