package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.AbstractC0374b;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class IconCompatParcelizer {
    public static IconCompat read(AbstractC0374b abstractC0374b) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.mType = abstractC0374b.m226b(iconCompat.mType, 1);
        iconCompat.mData = abstractC0374b.m231b(iconCompat.mData, 2);
        iconCompat.mParcelable = abstractC0374b.m227b(iconCompat.mParcelable, 3);
        iconCompat.mInt1 = abstractC0374b.m226b(iconCompat.mInt1, 4);
        iconCompat.mInt2 = abstractC0374b.m226b(iconCompat.mInt2, 5);
        iconCompat.mTintList = (ColorStateList) abstractC0374b.m227b(iconCompat.mTintList, 6);
        iconCompat.mTintModeStr = abstractC0374b.m229b(iconCompat.mTintModeStr, 7);
        iconCompat.onPostParceling();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, AbstractC0374b abstractC0374b) {
        iconCompat.onPreParceling(false);
        abstractC0374b.m218a(iconCompat.mType, 1);
        abstractC0374b.m225a(iconCompat.mData, 2);
        abstractC0374b.m220a(iconCompat.mParcelable, 3);
        abstractC0374b.m218a(iconCompat.mInt1, 4);
        abstractC0374b.m218a(iconCompat.mInt2, 5);
        abstractC0374b.m220a(iconCompat.mTintList, 6);
        abstractC0374b.m223a(iconCompat.mTintModeStr, 7);
    }
}
