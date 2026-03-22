package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ParcelImpl implements Parcelable {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0376d f240a;

    static {
        new C0373a();
    }

    protected ParcelImpl(Parcel parcel) {
        this.f240a = new C0375c(parcel).m237g();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        new C0375c(parcel).m221a(this.f240a);
    }
}
