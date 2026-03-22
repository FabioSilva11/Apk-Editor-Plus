package com.p016a.p017a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import com.p016a.p017a.p018a.InterfaceC0398b;
import com.p016a.p017a.p018a.InterfaceC0399c;
import java.io.UTFDataFormatException;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.a.a.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0416o implements InterfaceC0398b, InterfaceC0399c {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C0410i f398a;

    /* JADX INFO: renamed from: b */
    private final String f399b;

    /* JADX INFO: renamed from: c */
    private final ByteBuffer f400c;

    /* JADX INFO: renamed from: d */
    private final int f401d;

    private C0416o(C0410i c0410i, String str, ByteBuffer byteBuffer) {
        this.f398a = c0410i;
        this.f399b = str;
        this.f400c = byteBuffer;
        this.f401d = byteBuffer.position();
    }

    /* synthetic */ C0416o(C0410i c0410i, String str, ByteBuffer byteBuffer, byte b2) {
        this(c0410i, str, byteBuffer);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ C0403b m371a(C0416o c0416o) {
        return new C0403b(c0416o.m374j(C0985a.m2232b(c0416o)), c0416o.m374j(C0985a.m2232b(c0416o)), c0416o.m375k(C0985a.m2232b(c0416o)), c0416o.m375k(C0985a.m2232b(c0416o)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00cf, code lost:
    
        r8[r10] = new com.p016a.p017a.C0409h(r13, r14, r2);
        r10 = r10 + 1;
     */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ com.p016a.p017a.C0407f m372b(com.p016a.p017a.C0416o r20) {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p016a.p017a.C0416o.m372b(com.a.a.o):com.a.a.f");
    }

    /* JADX INFO: renamed from: i */
    private short[] m373i(int i) {
        if (i == 0) {
            return C0410i.f381a;
        }
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = this.f400c.getShort();
        }
        return sArr;
    }

    /* JADX INFO: renamed from: j */
    private C0404c[] m374j(int i) {
        C0404c[] c0404cArr = new C0404c[i];
        int iM2232b = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iM2232b += C0985a.m2232b(this);
            c0404cArr[i2] = new C0404c(iM2232b, C0985a.m2232b(this));
        }
        return c0404cArr;
    }

    /* JADX INFO: renamed from: k */
    private C0405d[] m375k(int i) {
        C0405d[] c0405dArr = new C0405d[i];
        int iM2232b = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iM2232b += C0985a.m2232b(this);
            c0405dArr[i2] = new C0405d(iM2232b, C0985a.m2232b(this), C0985a.m2232b(this));
        }
        return c0405dArr;
    }

    /* JADX INFO: renamed from: l */
    private byte[] m376l(int i) {
        byte[] bArr = new byte[this.f400c.position() - i];
        this.f400c.position(i);
        this.f400c.get(bArr);
        return bArr;
    }

    /* JADX INFO: renamed from: o */
    private int m377o() {
        return this.f400c.getShort() & 65535;
    }

    /* JADX INFO: renamed from: a */
    public final int m378a() {
        return this.f400c.position();
    }

    /* JADX INFO: renamed from: a */
    public final void m379a(C0402ab c0402ab) {
        short[] sArrM313a = c0402ab.m313a();
        m392f(sArrM313a.length);
        for (short s : sArrM313a) {
            m381a(s);
        }
        m400l();
    }

    /* JADX INFO: renamed from: a */
    public final void m380a(String str) {
        try {
            m394g(str.length());
            m382a(C0985a.m2273f(str));
            mo307d(0);
        } catch (UTFDataFormatException e) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m381a(short s) {
        this.f400c.putShort(s);
    }

    /* JADX INFO: renamed from: a */
    public final void m382a(byte[] bArr) {
        this.f400c.put(bArr);
    }

    /* JADX INFO: renamed from: a */
    public final void m383a(short[] sArr) {
        for (short s : sArr) {
            m381a(s);
        }
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m384a(int i) {
        byte[] bArr = new byte[i];
        this.f400c.get(bArr);
        return bArr;
    }

    /* JADX INFO: renamed from: b */
    public final int m385b() {
        return this.f400c.getInt();
    }

    /* JADX INFO: renamed from: b */
    public final void m386b(int i) {
        m394g(i + 1);
    }

    /* JADX INFO: renamed from: c */
    public final short m387c() {
        return this.f400c.getShort();
    }

    /* JADX INFO: renamed from: c */
    public final void m388c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.f400c.position(this.f400c.position() + i);
    }

    @Override // com.p016a.p017a.p018a.InterfaceC0398b
    /* JADX INFO: renamed from: d */
    public final byte mo306d() {
        return this.f400c.get();
    }

    @Override // com.p016a.p017a.p018a.InterfaceC0399c
    /* JADX INFO: renamed from: d */
    public final void mo307d(int i) {
        this.f400c.put((byte) i);
    }

    /* JADX INFO: renamed from: e */
    public final C0402ab m389e() {
        short[] sArrM373i = m373i(this.f400c.getInt());
        this.f400c.position((this.f400c.position() + 3) & (-4));
        return new C0402ab(this.f398a, sArrM373i);
    }

    /* JADX INFO: renamed from: e */
    public final void m390e(int i) {
        short s = (short) i;
        if (i != (65535 & s)) {
            throw new IllegalArgumentException("Expected an unsigned short: " + i);
        }
        m381a(s);
    }

    /* JADX INFO: renamed from: f */
    public final String m391f() {
        int i = this.f400c.getInt();
        int iPosition = this.f400c.position();
        int iLimit = this.f400c.limit();
        this.f400c.position(i);
        this.f400c.limit(this.f400c.capacity());
        try {
            try {
                int iM2232b = C0985a.m2232b(this);
                String strM2196a = C0985a.m2196a(this, new char[iM2232b]);
                if (strM2196a.length() != iM2232b) {
                    throw new C0420s("Declared length " + iM2232b + " doesn't match decoded length of " + strM2196a.length());
                }
                return strM2196a;
            } catch (UTFDataFormatException e) {
                throw new C0420s(e);
            }
        } finally {
            this.f400c.position(iPosition);
            this.f400c.limit(iLimit);
        }
        this.f400c.position(iPosition);
        this.f400c.limit(iLimit);
    }

    /* JADX INFO: renamed from: f */
    public final void m392f(int i) {
        this.f400c.putInt(i);
    }

    /* JADX INFO: renamed from: g */
    public final C0424w m393g() {
        return new C0424w(this.f398a, m377o(), m377o(), this.f400c.getInt());
    }

    /* JADX INFO: renamed from: g */
    public final void m394g(int i) {
        try {
            C0985a.m2207a((InterfaceC0399c) this, i);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new C0420s("Section limit " + this.f400c.limit() + " exceeded by " + this.f399b);
        }
    }

    /* JADX INFO: renamed from: h */
    public final C0425x m395h() {
        return new C0425x(this.f398a, m377o(), m377o(), this.f400c.getInt());
    }

    /* JADX INFO: renamed from: h */
    public final void m396h(int i) {
        try {
            C0985a.m2241b((InterfaceC0399c) this, i);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new C0420s("Section limit " + this.f400c.limit() + " exceeded by " + this.f399b);
        }
    }

    /* JADX INFO: renamed from: i */
    public final C0426y m397i() {
        return new C0426y(this.f398a, this.f400c.getInt(), this.f400c.getInt(), this.f400c.getInt());
    }

    /* JADX INFO: renamed from: j */
    public final C0396a m398j() {
        byte b2 = this.f400c.get();
        int iPosition = this.f400c.position();
        new C0423v(this, 29).m427t();
        return new C0396a(this.f398a, b2, new C0422u(m376l(iPosition)));
    }

    /* JADX INFO: renamed from: k */
    public final C0422u m399k() {
        int iPosition = this.f400c.position();
        new C0423v(this, 28).m427t();
        return new C0422u(m376l(iPosition));
    }

    /* JADX INFO: renamed from: l */
    public final void m400l() {
        while ((this.f400c.position() & 3) != 0) {
            this.f400c.put((byte) 0);
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m401m() {
        if ((this.f400c.position() & 3) != 0) {
            throw new IllegalStateException("Not four byte aligned!");
        }
    }

    /* JADX INFO: renamed from: n */
    public final int m402n() {
        return this.f400c.position() - this.f401d;
    }
}
