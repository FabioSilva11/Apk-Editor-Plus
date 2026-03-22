package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: androidx.versionedparcelable.a */
/* JADX INFO: loaded from: classes.dex */
final class C0373a implements Parcelable.Creator {
    C0373a() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ParcelImpl(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ParcelImpl[i];
    }
}
