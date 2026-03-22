package ru.zeratul.preference;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: ru.zeratul.preference.c */
/* JADX INFO: loaded from: classes.dex */
public class C1840c {

    /* JADX INFO: renamed from: b */
    private int f4833b;

    /* JADX INFO: renamed from: a */
    private float[] f4832a = {0.0f, 0.0f, 0.0f};

    /* JADX INFO: renamed from: c */
    private List f4834c = new ArrayList();

    C1840c(int i) {
        Color.colorToHSV(i, this.f4832a);
        this.f4833b = Color.alpha(i);
    }

    /* JADX INFO: renamed from: a */
    public void m3954a(InterfaceC1839b interfaceC1839b) {
        this.f4834c.add(interfaceC1839b);
    }

    /* JADX INFO: renamed from: b */
    public void m3955b(int i, InterfaceC1839b interfaceC1839b) {
        Color.colorToHSV(i, this.f4832a);
        this.f4833b = Color.alpha(i);
        for (InterfaceC1839b interfaceC1839b2 : this.f4834c) {
            if (interfaceC1839b2 != interfaceC1839b) {
                interfaceC1839b2.mo3950a(this);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public int m3956c() {
        return Color.HSVToColor(this.f4833b, this.f4832a);
    }
}
