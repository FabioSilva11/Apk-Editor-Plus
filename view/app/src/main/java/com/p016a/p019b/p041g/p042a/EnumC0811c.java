package com.p016a.p019b.p041g.p042a;

import java.util.BitSet;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: com.a.b.g.a.c */
/* JADX INFO: loaded from: classes.dex */
abstract class EnumC0811c {

    /* JADX INFO: renamed from: a */
    public static final EnumC0811c f2055a;

    /* JADX INFO: renamed from: b */
    public static final EnumC0811c f2056b;

    /* JADX INFO: renamed from: c */
    public static final EnumC0811c f2057c;

    static {
        final int i = 2;
        final int i2 = 1;
        final int i3 = 0;
        final String str = "EVEN";
        f2055a = new EnumC0811c(str, i3) { // from class: com.a.b.g.a.d
            {
                byte b2 = 0;
            }

            @Override // com.p016a.p019b.p041g.p042a.EnumC0811c
            /* JADX INFO: renamed from: a */
            final int mo1731a(BitSet bitSet, int i4) {
                int iNextClearBit = bitSet.nextClearBit(i4);
                while (!C0809a.m1725f(iNextClearBit)) {
                    iNextClearBit = bitSet.nextClearBit(iNextClearBit + 1);
                }
                return iNextClearBit;
            }
        };
        final String str2 = "ODD";
        f2056b = new EnumC0811c(str2, i2) { // from class: com.a.b.g.a.e
            {
                int i4 = 1;
                byte b2 = 0;
            }

            @Override // com.p016a.p019b.p041g.p042a.EnumC0811c
            /* JADX INFO: renamed from: a */
            final int mo1731a(BitSet bitSet, int i4) {
                int iNextClearBit = bitSet.nextClearBit(i4);
                while (C0809a.m1725f(iNextClearBit)) {
                    iNextClearBit = bitSet.nextClearBit(iNextClearBit + 1);
                }
                return iNextClearBit;
            }
        };
        final String str3 = "UNSPECIFIED";
        f2057c = new EnumC0811c(str3, i) { // from class: com.a.b.g.a.f
            {
                int i4 = 2;
                byte b2 = 0;
            }

            @Override // com.p016a.p019b.p041g.p042a.EnumC0811c
            /* JADX INFO: renamed from: a */
            final int mo1731a(BitSet bitSet, int i4) {
                return bitSet.nextClearBit(i4);
            }
        };
        EnumC0811c[] enumC0811cArr = {f2055a, f2056b, f2057c};
    }

    private EnumC0811c(String str, int i) {
    }

    /* synthetic */ EnumC0811c(String str, int i, byte b2) {
        this(str, i);
    }

    /* JADX INFO: renamed from: a */
    abstract int mo1731a(BitSet bitSet, int i);
}
