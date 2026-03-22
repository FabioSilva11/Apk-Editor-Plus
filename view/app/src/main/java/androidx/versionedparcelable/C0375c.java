package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.util.SparseIntArray;

/* JADX INFO: renamed from: androidx.versionedparcelable.c */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class C0375c extends AbstractC0374b {

    /* JADX INFO: renamed from: a */
    private final SparseIntArray f241a;

    /* JADX INFO: renamed from: b */
    private final Parcel f242b;

    /* JADX INFO: renamed from: c */
    private final int f243c;

    /* JADX INFO: renamed from: d */
    private final int f244d;

    /* JADX INFO: renamed from: e */
    private final String f245e;

    /* JADX INFO: renamed from: f */
    private int f246f;

    /* JADX INFO: renamed from: g */
    private int f247g;

    C0375c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    private C0375c(Parcel parcel, int i, int i2, String str) {
        this.f241a = new SparseIntArray();
        this.f246f = -1;
        this.f247g = 0;
        this.f242b = parcel;
        this.f243c = i;
        this.f244d = i2;
        this.f247g = this.f243c;
        this.f245e = str;
    }

    @Override // androidx.versionedparcelable.AbstractC0374b
    /* JADX INFO: renamed from: a */
    public final void mo216a() {
        if (this.f246f >= 0) {
            int i = this.f241a.get(this.f246f);
            int iDataPosition = this.f242b.dataPosition();
            this.f242b.setDataPosition(i);
            this.f242b.writeInt(iDataPosition - i);
            this.f242b.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.AbstractC0374b
    /* JADX INFO: renamed from: a */
    public final void mo217a(int i) {
        this.f242b.writeInt(i);
    }

    @Override // androidx.versionedparcelable.AbstractC0374b
    /* JADX INFO: renamed from: a */
    public final void mo219a(Parcelable parcelable) {
        this.f242b.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.AbstractC0374b
    /* JADX INFO: renamed from: a */
    public final void mo222a(String str) {
        this.f242b.writeString(str);
    }

    @Override // androidx.versionedparcelable.AbstractC0374b
    /* JADX INFO: renamed from: a */
    public final void mo224a(byte[] bArr) {
        if (bArr == null) {
            this.f242b.writeInt(-1);
        } else {
            this.f242b.writeInt(bArr.length);
            this.f242b.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.AbstractC0374b
    /* JADX INFO: renamed from: b */
    protected final AbstractC0374b mo228b() {
        return new C0375c(this.f242b, this.f242b.dataPosition(), this.f247g == this.f243c ? this.f244d : this.f247g, this.f245e + "  ");
    }

    @Override // androidx.versionedparcelable.AbstractC0374b
    /* JADX INFO: renamed from: b */
    public final boolean mo230b(int i) {
        int iDataPosition;
        while (true) {
            if (this.f247g >= this.f244d) {
                iDataPosition = -1;
                break;
            }
            this.f242b.setDataPosition(this.f247g);
            int i2 = this.f242b.readInt();
            int i3 = this.f242b.readInt();
            this.f247g = i2 + this.f247g;
            if (i3 == i) {
                iDataPosition = this.f242b.dataPosition();
                break;
            }
        }
        if (iDataPosition == -1) {
            return false;
        }
        this.f242b.setDataPosition(iDataPosition);
        return true;
    }

    @Override // androidx.versionedparcelable.AbstractC0374b
    /* JADX INFO: renamed from: c */
    public final int mo232c() {
        return this.f242b.readInt();
    }

    @Override // androidx.versionedparcelable.AbstractC0374b
    /* JADX INFO: renamed from: c */
    public final void mo233c(int i) {
        mo216a();
        this.f246f = i;
        this.f241a.put(i, this.f242b.dataPosition());
        mo217a(0);
        mo217a(i);
    }

    @Override // androidx.versionedparcelable.AbstractC0374b
    /* JADX INFO: renamed from: d */
    public final String mo234d() {
        return this.f242b.readString();
    }

    @Override // androidx.versionedparcelable.AbstractC0374b
    /* JADX INFO: renamed from: e */
    public final byte[] mo235e() {
        int i = this.f242b.readInt();
        if (i < 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.f242b.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.AbstractC0374b
    /* JADX INFO: renamed from: f */
    public final Parcelable mo236f() {
        return this.f242b.readParcelable(getClass().getClassLoader());
    }
}
