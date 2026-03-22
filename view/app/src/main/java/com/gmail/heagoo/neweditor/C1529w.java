package com.gmail.heagoo.neweditor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.w */
/* JADX INFO: loaded from: classes.dex */
public final class C1529w {

    /* JADX INFO: renamed from: a */
    public final int f4517a;

    /* JADX INFO: renamed from: b */
    public C1530x f4518b;

    /* JADX INFO: renamed from: c */
    public final char[] f4519c;

    /* JADX INFO: renamed from: d */
    public final int f4520d;

    /* JADX INFO: renamed from: e */
    public final C1529w f4521e;

    /* JADX INFO: renamed from: f */
    public final byte f4522f;

    /* JADX INFO: renamed from: g */
    public final char[] f4523g;

    /* JADX INFO: renamed from: h */
    public final int f4524h;

    /* JADX INFO: renamed from: i */
    public final Pattern f4525i;

    /* JADX INFO: renamed from: j */
    public final byte f4526j;

    /* JADX INFO: renamed from: k */
    public final char[] f4527k;

    /* JADX INFO: renamed from: l */
    public final char[] f4528l;

    private C1529w(int i, String str, int i2, char[] cArr, Pattern pattern, int i3, char[] cArr2, Pattern pattern2, C1530x c1530x, byte b2, byte b3, String str2) {
        C1529w c1529wM3665a = null;
        this.f4517a = i;
        this.f4527k = str == null ? null : str.toUpperCase().toCharArray();
        this.f4528l = null;
        this.f4524h = i2;
        this.f4523g = cArr;
        this.f4525i = pattern;
        this.f4520d = i3;
        this.f4519c = cArr2;
        this.f4518b = c1530x;
        this.f4526j = b2;
        this.f4522f = b3;
        if (str2 != null && str2.length() > 0) {
            c1529wM3665a = m3665a(str2);
        }
        this.f4521e = c1529wM3665a;
        if (this.f4518b != null || (i & 255) == 0) {
            return;
        }
        this.f4518b = C1530x.m3670a(b2);
    }

    private C1529w(char[] cArr, int i, int i2, char[] cArr2, Pattern pattern, int i3, char[] cArr3, Pattern pattern2, C1530x c1530x, byte b2, byte b3, String str) {
        this.f4517a = i;
        this.f4527k = null;
        HashSet hashSet = new HashSet();
        for (char c : cArr) {
            hashSet.add(Character.valueOf(Character.toUpperCase(c)));
        }
        this.f4528l = new char[hashSet.size()];
        Iterator it = hashSet.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            this.f4528l[i4] = ((Character) it.next()).charValue();
            i4++;
        }
        Arrays.sort(this.f4528l);
        this.f4524h = i2;
        this.f4523g = null;
        this.f4525i = pattern;
        this.f4520d = i3;
        this.f4519c = cArr3;
        this.f4518b = c1530x;
        this.f4526j = b2;
        this.f4522f = b3;
        this.f4521e = (str == null || str.length() <= 0) ? null : m3665a(str);
        if (this.f4518b != null || (i & 255) == 0) {
            return;
        }
        this.f4518b = C1530x.m3670a(b2);
    }

    /* JADX INFO: renamed from: a */
    public static C1529w m3658a(int i, String str, byte b2, byte b3) {
        return new C1529w(8, str.substring(0, 1), i, str.toCharArray(), (Pattern) null, 0, (char[]) null, (Pattern) null, (C1530x) null, b2, b3, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static C1529w m3659a(int i, String str, int i2, String str2, C1530x c1530x, byte b2, byte b3, boolean z, boolean z2, String str3) {
        return new C1529w((z2 ? 1024 : 0) | (z ? 512 : 0) | 2, str.substring(0, 1), i, str.toCharArray(), (Pattern) null, i2, str2.toCharArray(), (Pattern) null, c1530x, b2, b3, str3);
    }

    /* JADX INFO: renamed from: a */
    public static C1529w m3660a(int i, String str, C1530x c1530x, byte b2) {
        return new C1529w(0, str.substring(0, 1), i, str.toCharArray(), (Pattern) null, 0, (char[]) null, (Pattern) null, c1530x, b2, (byte) -1, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static C1529w m3661a(int i, String str, C1530x c1530x, byte b2, byte b3) {
        return new C1529w(528, str.substring(0, 1), i, str.toCharArray(), (Pattern) null, 0, (char[]) null, (Pattern) null, c1530x, b2, b3, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static C1529w m3662a(int i, char[] cArr, String str, int i2, String str2, C1530x c1530x, byte b2, byte b3, boolean z, boolean z2, boolean z3, String str3, boolean z4) {
        Pattern patternCompile;
        char[] charArray;
        int i3 = (z ? 512 : 0) | 8194 | (z2 ? 1024 : 0);
        if (z4) {
            i3 |= 16384;
            patternCompile = Pattern.compile(str2, z3 ? 2 : 0);
            charArray = null;
        } else {
            patternCompile = null;
            charArray = str2.toCharArray();
        }
        return new C1529w(cArr, i3, i, (char[]) null, Pattern.compile(str, z3 ? 2 : 0), i2, charArray, patternCompile, c1530x, b2, b3, str3);
    }

    /* JADX INFO: renamed from: a */
    public static C1529w m3663a(int i, char[] cArr, String str, C1530x c1530x, byte b2, byte b3, boolean z) {
        return new C1529w(cArr, 8720, i, (char[]) null, Pattern.compile(str, z ? 2 : 0), 0, (char[]) null, (Pattern) null, c1530x, b2, b3, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static C1529w m3664a(int i, char[] cArr, String str, C1530x c1530x, byte b2, boolean z) {
        return new C1529w(cArr, 8192, i, (char[]) null, Pattern.compile(str, z ? 2 : 0), 0, (char[]) null, (Pattern) null, c1530x, b2, (byte) -1, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static C1529w m3665a(String str) {
        return new C1529w(2048, str.substring(0, 1), 0, str.toCharArray(), (Pattern) null, 0, (char[]) null, (Pattern) null, (C1530x) null, (byte) 0, (byte) -1, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static C1529w m3666a(String str, int i, String str2, int i2, String str3, C1530x c1530x, byte b2, byte b3, boolean z, boolean z2, boolean z3, String str4, boolean z4) {
        Pattern patternCompile;
        char[] charArray;
        int i3 = (z ? 512 : 0) | 8194 | (z2 ? 1024 : 0);
        if (z4) {
            i3 |= 16384;
            patternCompile = Pattern.compile(str3, z3 ? 2 : 0);
            charArray = null;
        } else {
            patternCompile = null;
            charArray = str3.toCharArray();
        }
        return new C1529w(i3, str, i, (char[]) null, Pattern.compile(str2, z3 ? 2 : 0), i2, charArray, patternCompile, c1530x, b2, b3, str4);
    }

    /* JADX INFO: renamed from: a */
    public static C1529w m3667a(String str, int i, String str2, C1530x c1530x, byte b2, byte b3, boolean z) {
        return new C1529w(8720, str, i, (char[]) null, Pattern.compile(str2, z ? 2 : 0), 0, (char[]) null, (Pattern) null, c1530x, b2, b3, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static C1529w m3668a(String str, int i, String str2, C1530x c1530x, byte b2, boolean z) {
        return new C1529w(8192, str, i, (char[]) null, Pattern.compile(str2, z ? 2 : 0), 0, (char[]) null, (Pattern) null, c1530x, b2, (byte) -1, (String) null);
    }

    /* JADX INFO: renamed from: b */
    public static C1529w m3669b(int i, String str, byte b2, byte b3) {
        return new C1529w(4, str.substring(0, 1), i, str.toCharArray(), (Pattern) null, 0, (char[]) null, (Pattern) null, (C1530x) null, b2, b3, (String) null);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName()).append("[action=");
        switch (this.f4517a & 255) {
            case 0:
                sb.append("SEQ");
                break;
            case 2:
                sb.append("SPAN");
                break;
            case 4:
                sb.append("MARK_PREVIOUS");
                break;
            case 8:
                sb.append("MARK_FOLLOWING");
                break;
            case 16:
                sb.append("EOL_SPAN");
                break;
            default:
                sb.append("UNKNOWN");
                break;
        }
        int i = 65280 & this.f4517a;
        sb.append("[matchType=").append(this.f4522f == -1 ? "MATCH_TYPE_CONTEXT" : this.f4522f == -2 ? "MATCH_TYPE_RULE" : Token.tokenToString(this.f4522f));
        sb.append(",NO_LINE_BREAK=").append((i & 512) != 0);
        sb.append(",NO_WORD_BREAK=").append((i & 1024) != 0);
        sb.append(",IS_ESCAPE=").append((i & 2048) != 0);
        sb.append(",REGEXP=").append((i & 8192) != 0);
        sb.append("],upHashChar=").append(new String(this.f4527k));
        sb.append(",upHashChars=").append(Arrays.toString(this.f4528l));
        sb.append(",startPosMatch=");
        sb.append("[AT_LINE_START=").append((this.f4524h & 2) != 0);
        sb.append(",AT_WHITESPACE_END=").append((this.f4524h & 4) != 0);
        sb.append(",AT_WORD_START=").append((this.f4524h & 8) != 0);
        sb.append("],start=").append(this.f4523g == null ? null : String.valueOf(this.f4523g));
        sb.append(",startRegexp=").append(this.f4525i);
        sb.append(",endPosMatch=");
        sb.append("[AT_LINE_START=").append((this.f4520d & 2) != 0);
        sb.append(",AT_WHITESPACE_END=").append((this.f4520d & 4) != 0);
        sb.append(",AT_WORD_START=").append((this.f4520d & 8) != 0);
        sb.append("],end=").append(this.f4519c != null ? String.valueOf(this.f4519c) : null);
        sb.append(",delegate=").append(this.f4518b);
        sb.append(",escapeRule=").append(this.f4521e);
        sb.append(",token=").append(Token.tokenToString(this.f4526j)).append(']');
        return sb.toString();
    }
}
