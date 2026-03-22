package p000a.p001a.p003b.p006b;

import java.io.EOFException;
import p000a.p001a.p003b.p004a.C0003a;
import p000a.p011d.C0074f;

/* JADX INFO: renamed from: a.a.b.b.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0046d {

    /* JADX INFO: renamed from: a */
    public final short f126a;

    /* JADX INFO: renamed from: b */
    public final int f127b;

    /* JADX INFO: renamed from: c */
    public final int f128c;

    private C0046d(short s, int i, int i2, int i3) {
        this.f126a = s;
        this.f127b = i3;
        this.f128c = i3 + i2;
    }

    /* JADX INFO: renamed from: a */
    public static C0046d m114a(C0074f c0074f, C0003a c0003a) {
        int iM0a = c0003a.m0a();
        try {
            byte[] bArr = new byte[8];
            c0074f.readFully(bArr);
            return new C0046d((short) (((bArr[1] & 255) << 8) | (bArr[0] & 255)), ((bArr[3] & 255) << 8) | (bArr[2] & 255), ((bArr[7] & 255) << 24) | ((bArr[6] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[4] & 255), iM0a);
        } catch (EOFException e) {
            return new C0046d((short) -1, 0, 0, c0003a.m0a());
        }
    }
}
