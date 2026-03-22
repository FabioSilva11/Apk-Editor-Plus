package p000a.p001a.p003b.p004a.p005a;

import java.util.Comparator;

/* JADX INFO: renamed from: a.a.b.a.a.k */
/* JADX INFO: loaded from: classes.dex */
final class C0014k implements Comparator {
    C0014k(C0013j c0013j) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return Integer.valueOf(Integer.bitCount(((C0015l) obj2).f16a)).compareTo(Integer.valueOf(Integer.bitCount(((C0015l) obj).f16a)));
    }
}
