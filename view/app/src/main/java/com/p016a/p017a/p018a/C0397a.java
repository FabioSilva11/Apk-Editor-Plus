package com.p016a.p017a.p018a;

/* JADX INFO: renamed from: com.a.a.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0397a implements InterfaceC0398b {

    /* JADX INFO: renamed from: a */
    private final byte[] f338a;

    /* JADX INFO: renamed from: b */
    private int f339b;

    public C0397a(byte... bArr) {
        this.f338a = bArr;
    }

    @Override // com.p016a.p017a.p018a.InterfaceC0398b
    /* JADX INFO: renamed from: d */
    public final byte mo306d() {
        byte[] bArr = this.f338a;
        int i = this.f339b;
        this.f339b = i + 1;
        return bArr[i];
    }
}
