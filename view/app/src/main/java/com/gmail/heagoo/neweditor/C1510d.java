package com.gmail.heagoo.neweditor;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1510d implements InterfaceC1503ae {

    /* JADX INFO: renamed from: a */
    private Token f4478a;

    /* JADX INFO: renamed from: b */
    private Token f4479b;

    /* JADX INFO: renamed from: a */
    private static C1530x m3635a(C1505ag c1505ag) {
        while (c1505ag != null) {
            if (!c1505ag.f4433c.m3694l()) {
                return c1505ag.f4433c;
            }
            c1505ag = c1505ag.f4431a;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final Token m3636a() {
        return this.f4478a;
    }

    @Override // com.gmail.heagoo.neweditor.InterfaceC1503ae
    /* JADX INFO: renamed from: a */
    public final void mo3608a(byte b2, int i, int i2, C1505ag c1505ag) {
        Token token = new Token(b2, i, i2, m3635a(c1505ag));
        if (this.f4478a == null) {
            this.f4479b = token;
            this.f4478a = token;
        } else {
            this.f4479b.next = token;
            this.f4479b = this.f4479b.next;
        }
    }
}
