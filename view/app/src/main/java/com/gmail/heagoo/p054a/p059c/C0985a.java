package com.gmail.heagoo.p054a.p059c;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.content.FileProvider;
import android.support.v7.appcompat.C0299R;
import android.widget.Toast;
import com.gmail.heagoo.apkeditor.C1095bv;
import com.gmail.heagoo.apkeditor.MainActivity;
import com.gmail.heagoo.apkeditor.SettingActivity;
import com.gmail.heagoo.apkeditor.SettingEditorActivity;
import com.gmail.heagoo.apkeditor.TextEditBigActivity;
import com.gmail.heagoo.apkeditor.TextEditNormalActivity;
import com.gmail.heagoo.apkeditor.installer.Installer;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.neweditor.C1532z;
import com.gmail.heagoo.neweditor.Token;
import com.p016a.p017a.C0420s;
import com.p016a.p017a.p018a.InterfaceC0398b;
import com.p016a.p017a.p018a.InterfaceC0399c;
import com.p016a.p019b.p020a.p022b.C0459ah;
import com.p016a.p019b.p020a.p022b.C0475m;
import com.p016a.p019b.p020a.p022b.C0484v;
import com.p016a.p019b.p036f.p039c.AbstractC0775a;
import com.p016a.p019b.p036f.p039c.C0783g;
import com.p016a.p019b.p036f.p039c.C0784h;
import com.p016a.p019b.p036f.p039c.C0785i;
import com.p016a.p019b.p036f.p039c.C0786j;
import com.p016a.p019b.p036f.p039c.C0789m;
import com.p016a.p019b.p036f.p039c.C0790n;
import com.p016a.p019b.p036f.p039c.C0792p;
import com.p016a.p019b.p036f.p039c.C0796t;
import com.p016a.p019b.p036f.p039c.C0800x;
import com.p016a.p019b.p036f.p040d.C0805c;
import com.p016a.p019b.p036f.p040d.InterfaceC0806d;
import jadx.core.codegen.CodeWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UTFDataFormatException;
import java.lang.Character;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipFile;
import p000a.p001a.C0000a;
import p000a.p001a.p003b.p004a.C0030d;
import p000a.p001a.p003b.p004a.C0031e;
import p000a.p001a.p003b.p004a.C0032f;
import p000a.p001a.p003b.p006b.C0043a;
import p000a.p001a.p003b.p007c.C0058b;
import p000a.p010c.C0065e;
import p000a.p010c.InterfaceC0064d;
import p000a.p011d.C0073e;

/* JADX INFO: renamed from: com.gmail.heagoo.a.c.a */
/* JADX INFO: loaded from: classes.dex */
public class C0985a {

    /* JADX INFO: renamed from: f */
    private static HashSet f2473f;

    /* JADX INFO: renamed from: g */
    private static HashSet f2474g;

    /* JADX INFO: renamed from: h */
    private static boolean f2475h;

    /* JADX INFO: renamed from: a */
    private final Map f2476a = new HashMap();

    /* JADX INFO: renamed from: b */
    private final Map f2477b = new HashMap();

    /* JADX INFO: renamed from: c */
    private final Set f2478c = new LinkedHashSet();

    /* JADX INFO: renamed from: d */
    private final Set f2479d = new LinkedHashSet();

    /* JADX INFO: renamed from: e */
    private Context f2480e;

    public C0985a() {
        new LinkedHashMap();
        new C0058b();
    }

    public C0985a(Context context, boolean z) {
        new LinkedHashMap();
        new C0058b();
        this.f2480e = context;
    }

    /* JADX INFO: renamed from: A */
    public static String m2168A(int i) {
        char[] cArr = new char[5];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[4 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: B */
    public static String m2169B(int i) {
        char[] cArr = new char[3];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        for (int i2 = 0; i2 < 2; i2++) {
            cArr[2 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: a */
    public static int m2170a(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return (((long) i) & 4294967295L) < (((long) i2) & 4294967295L) ? -1 : 1;
    }

    /* JADX INFO: renamed from: a */
    public static int m2171a(InterfaceC0398b interfaceC0398b) {
        int iMo306d;
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        do {
            iMo306d = interfaceC0398b.mo306d() & 255;
            i3 |= (iMo306d & 127) << (i * 7);
            i2 <<= 7;
            i++;
            if ((iMo306d & 128) != 128) {
                break;
            }
        } while (i < 5);
        if ((iMo306d & 128) == 128) {
            throw new C0420s("invalid LEB128 sequence");
        }
        return ((i2 >> 1) & i3) != 0 ? i3 | i2 : i3;
    }

    /* JADX INFO: renamed from: a */
    public static int m2172a(InterfaceC0398b interfaceC0398b, int i) {
        int iMo306d = 0;
        for (int i2 = i; i2 >= 0; i2--) {
            iMo306d = (iMo306d >>> 8) | ((interfaceC0398b.mo306d() & 255) << 24);
        }
        return iMo306d >> ((3 - i) << 3);
    }

    /* JADX INFO: renamed from: a */
    public static int m2173a(InterfaceC0398b interfaceC0398b, int i, boolean z) {
        int iMo306d = 0;
        if (z) {
            while (i >= 0) {
                iMo306d = (iMo306d >>> 8) | ((interfaceC0398b.mo306d() & 255) << 24);
                i--;
            }
            return iMo306d;
        }
        for (int i2 = i; i2 >= 0; i2--) {
            iMo306d = (iMo306d >>> 8) | ((interfaceC0398b.mo306d() & 255) << 24);
        }
        return iMo306d >>> ((3 - i) << 3);
    }

    /* JADX INFO: renamed from: a */
    public static int m2174a(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return (s & 65535) < (65535 & s2) ? -1 : 1;
    }

    /* JADX INFO: renamed from: a */
    public static int m2175a(int[] iArr) {
        return iArr.length << 5;
    }

    /* JADX INFO: renamed from: a */
    private static C0073e m2176a(String str, int i) {
        char cCharAt;
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (str == null) {
            return new C0073e(arrayList, arrayList2);
        }
        int length = str.length();
        while (true) {
            int iIndexOf = str.indexOf(37, i2);
            if (iIndexOf != -1) {
                int i3 = iIndexOf + 1;
                if (i3 != length) {
                    i2 = i3 + 1;
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 != '%') {
                        if (cCharAt2 >= '0' && cCharAt2 <= '9' && i2 < length) {
                            do {
                                int i4 = i2;
                                i2 = i4 + 1;
                                cCharAt = str.charAt(i4);
                                if (cCharAt < '0' || cCharAt > '9') {
                                    break;
                                }
                            } while (i2 < length);
                            if (cCharAt == '$') {
                                arrayList2.add(Integer.valueOf(iIndexOf));
                            }
                        }
                        arrayList.add(Integer.valueOf(iIndexOf));
                        if (arrayList.size() >= 4) {
                            break;
                        }
                    }
                } else {
                    arrayList.add(Integer.valueOf(iIndexOf));
                    break;
                }
            } else {
                break;
            }
        }
        return new C0073e(arrayList, arrayList2);
    }

    /* JADX INFO: renamed from: a */
    public static Intent m2177a(Context context, String str, String str2) {
        Intent intent = m2272f(context, str) ? new Intent(context, (Class<?>) TextEditBigActivity.class) : new Intent(context, (Class<?>) TextEditNormalActivity.class);
        m2180a(intent, "xmlPath", str);
        if (str2 != null) {
            m2180a(intent, "apkPath", str2);
        }
        return intent;
    }

    /* JADX INFO: renamed from: a */
    public static Intent m2178a(Context context, ArrayList arrayList, int i, String str) {
        Intent intent = m2272f(context, (String) arrayList.get(i)) ? new Intent(context, (Class<?>) TextEditBigActivity.class) : new Intent(context, (Class<?>) TextEditNormalActivity.class);
        m2181a(intent, "fileList", arrayList);
        m2179a(intent, "curFileIndex", i);
        if (str != null) {
            m2180a(intent, "apkPath", str);
        }
        return intent;
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m2179a(Intent intent, String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        intent.putExtras(bundle);
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m2180a(Intent intent, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        intent.putExtras(bundle);
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m2181a(Intent intent, String str, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(str, arrayList);
        intent.putExtras(bundle);
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m2182a(Intent intent, String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(str, z);
        intent.putExtras(bundle);
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    public static C0475m m2183a(C0475m c0475m, C0475m c0475m2) {
        if (c0475m == c0475m2) {
            return c0475m;
        }
        int iM605b = c0475m.m605b();
        if (c0475m2.m605b() != iM605b) {
            throw new C0459ah("mismatched stack depths");
        }
        C0475m c0475mM598a = null;
        for (int i = 0; i < iM605b; i++) {
            InterfaceC0806d interfaceC0806dM600a = c0475m.m600a(i);
            InterfaceC0806d interfaceC0806dM600a2 = c0475m2.m600a(i);
            InterfaceC0806d interfaceC0806dM2186a = m2186a(interfaceC0806dM600a, interfaceC0806dM600a2);
            if (interfaceC0806dM2186a != interfaceC0806dM600a) {
                if (c0475mM598a == null) {
                    c0475mM598a = c0475m.m598a();
                }
                if (interfaceC0806dM2186a == null) {
                    throw new C0459ah("incompatible: " + interfaceC0806dM600a + ", " + interfaceC0806dM600a2);
                }
                try {
                    c0475mM598a.m601a(i, interfaceC0806dM2186a);
                } catch (C0459ah e) {
                    e.m311a("...while merging stack[" + m2296v(i) + "]");
                    throw e;
                }
                e.m311a("...while merging stack[" + m2296v(i) + "]");
                throw e;
            }
        }
        if (c0475mM598a == null) {
            return c0475m;
        }
        c0475mM598a.mo549b_();
        return c0475mM598a;
    }

    /* JADX INFO: renamed from: a */
    public static C0484v m2184a(C0484v c0484v, C0484v c0484v2) {
        if (c0484v == c0484v2) {
            return c0484v;
        }
        int iM662f = c0484v.m662f();
        if (c0484v2.m662f() != iM662f) {
            throw new C0459ah("mismatched maxLocals values");
        }
        C0484v c0484vM661e = null;
        for (int i = 0; i < iM662f; i++) {
            InterfaceC0806d interfaceC0806dM660c = c0484v.m660c(i);
            InterfaceC0806d interfaceC0806dM2186a = m2186a(interfaceC0806dM660c, c0484v2.m660c(i));
            if (interfaceC0806dM2186a != interfaceC0806dM660c) {
                if (c0484vM661e == null) {
                    c0484vM661e = c0484v.mo643a();
                }
                if (interfaceC0806dM2186a == null) {
                    c0484vM661e.m659b(i);
                } else {
                    c0484vM661e.mo647a(i, interfaceC0806dM2186a);
                }
            }
        }
        if (c0484vM661e == null) {
            return c0484v;
        }
        c0484vM661e.mo549b_();
        return c0484vM661e;
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC0775a m2185a(C0805c c0805c) {
        switch (c0805c.mo665c()) {
            case 1:
                return C0783g.f1906a;
            case 2:
                return C0784h.f1908a;
            case 3:
                return C0785i.f1909a;
            case 4:
                return C0786j.f1910a;
            case 5:
                return C0789m.f1913a;
            case 6:
                return C0790n.f1917b;
            case 7:
                return C0796t.f1928a;
            case 8:
                return C0800x.f1935a;
            case 9:
                return C0792p.f1925a;
            default:
                throw new UnsupportedOperationException("no zero for type: " + c0805c.mo657d());
        }
    }

    /* JADX INFO: renamed from: a */
    public static InterfaceC0806d m2186a(InterfaceC0806d interfaceC0806d, InterfaceC0806d interfaceC0806d2) {
        if (interfaceC0806d == null || interfaceC0806d.equals(interfaceC0806d2)) {
            return interfaceC0806d;
        }
        if (interfaceC0806d2 == null) {
            return null;
        }
        C0805c c0805cMo663a = interfaceC0806d.mo663a();
        C0805c c0805cMo663a2 = interfaceC0806d2.mo663a();
        if (c0805cMo663a == c0805cMo663a2) {
            return c0805cMo663a;
        }
        if (!c0805cMo663a.m1692n() || !c0805cMo663a2.m1692n()) {
            if (c0805cMo663a.m1690l() && c0805cMo663a2.m1690l()) {
                return C0805c.f2015f;
            }
            return null;
        }
        if (c0805cMo663a == C0805c.f2019j) {
            return c0805cMo663a2;
        }
        if (c0805cMo663a2 == C0805c.f2019j) {
            return c0805cMo663a;
        }
        if (!c0805cMo663a.m1693o() || !c0805cMo663a2.m1693o()) {
            return C0805c.f2023n;
        }
        InterfaceC0806d interfaceC0806dM2186a = m2186a(c0805cMo663a.m1697s(), c0805cMo663a2.m1697s());
        return interfaceC0806dM2186a == null ? C0805c.f2023n : ((C0805c) interfaceC0806dM2186a).m1696r();
    }

    /* JADX INFO: renamed from: a */
    public static Token m2187a(Token token) {
        if (token == null) {
            return null;
        }
        Token token2 = token;
        for (Token token3 = token.next; token3 != null; token3 = token3.next) {
            if (token3.f4408id == token2.f4408id && token3.offset == token2.offset + token2.length) {
                token2.length += token3.length;
            } else {
                token2.next = token3;
                token2 = token3;
            }
        }
        token2.next = null;
        return token;
    }

    /* JADX INFO: renamed from: a */
    public static File m2188a(String str, boolean z) {
        String strSubstring;
        int i;
        int iLastIndexOf = str.lastIndexOf(47);
        String strSubstring2 = str.substring(0, iLastIndexOf + 1);
        String strSubstring3 = str.substring(iLastIndexOf + 1);
        String strSubstring4 = "";
        int iLastIndexOf2 = strSubstring3.lastIndexOf(46);
        if (iLastIndexOf2 != -1) {
            strSubstring = strSubstring3.substring(0, iLastIndexOf2);
            strSubstring4 = strSubstring3.substring(iLastIndexOf2);
            i = 1;
        } else {
            strSubstring = strSubstring3;
            i = 1;
        }
        while (true) {
            File file = new File(strSubstring2 + strSubstring + i + strSubstring4);
            if (!file.exists()) {
                return file;
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Object m2189a(String str, String str2, Object obj, Class[] clsArr, Object[] objArr) {
        try {
            return Class.forName(str).getMethod(str2, clsArr).invoke(obj, objArr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (SecurityException e5) {
            e5.printStackTrace();
            return null;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Object m2190a(String str, String str2, Class[] clsArr, Object[] objArr) {
        try {
            return Class.forName(str).getMethod(str2, clsArr).invoke(null, objArr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (SecurityException e5) {
            e5.printStackTrace();
            return null;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Object m2191a(String str, Class[] clsArr, Object[] objArr) {
        try {
            return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m2192a(int i, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer(80);
        int i4 = (i2 ^ (-1)) & i;
        int i5 = i & i2;
        if ((i5 & 1) != 0) {
            stringBuffer.append("|public");
        }
        if ((i5 & 2) != 0) {
            stringBuffer.append("|private");
        }
        if ((i5 & 4) != 0) {
            stringBuffer.append("|protected");
        }
        if ((i5 & 8) != 0) {
            stringBuffer.append("|static");
        }
        if ((i5 & 16) != 0) {
            stringBuffer.append("|final");
        }
        if ((i5 & 32) != 0) {
            if (i3 == 1) {
                stringBuffer.append("|super");
            } else {
                stringBuffer.append("|synchronized");
            }
        }
        if ((i5 & 64) != 0) {
            if (i3 == 3) {
                stringBuffer.append("|bridge");
            } else {
                stringBuffer.append("|volatile");
            }
        }
        if ((i5 & 128) != 0) {
            if (i3 == 3) {
                stringBuffer.append("|varargs");
            } else {
                stringBuffer.append("|transient");
            }
        }
        if ((i5 & 256) != 0) {
            stringBuffer.append("|native");
        }
        if ((i5 & 512) != 0) {
            stringBuffer.append("|interface");
        }
        if ((i5 & 1024) != 0) {
            stringBuffer.append("|abstract");
        }
        if ((i5 & 2048) != 0) {
            stringBuffer.append("|strictfp");
        }
        if ((i5 & 4096) != 0) {
            stringBuffer.append("|synthetic");
        }
        if ((i5 & 8192) != 0) {
            stringBuffer.append("|annotation");
        }
        if ((i5 & 16384) != 0) {
            stringBuffer.append("|enum");
        }
        if ((65536 & i5) != 0) {
            stringBuffer.append("|constructor");
        }
        if ((i5 & 131072) != 0) {
            stringBuffer.append("|declared_synchronized");
        }
        if (i4 != 0 || stringBuffer.length() == 0) {
            stringBuffer.append('|');
            stringBuffer.append(m2296v(i4));
        }
        return stringBuffer.substring(1);
    }

    /* JADX INFO: renamed from: a */
    public static String m2193a(long j) {
        char[] cArr = new char[16];
        for (int i = 0; i < 16; i++) {
            cArr[15 - i] = Character.forDigit(((int) j) & 15, 16);
            j >>= 4;
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: a */
    public static String m2194a(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        if (cursorQuery == null) {
                            return string;
                        }
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m2195a(Intent intent, String str) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return extras.getString(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static String m2196a(InterfaceC0398b interfaceC0398b, char[] cArr) throws UTFDataFormatException {
        int i = 0;
        while (true) {
            char cMo306d = (char) (interfaceC0398b.mo306d() & 255);
            if (cMo306d == 0) {
                return new String(cArr, 0, i);
            }
            cArr[i] = cMo306d;
            if (cMo306d < 128) {
                i++;
            } else if ((cMo306d & 224) == 192) {
                int iMo306d = interfaceC0398b.mo306d() & 255;
                if ((iMo306d & 192) != 128) {
                    throw new UTFDataFormatException("bad second byte");
                }
                cArr[i] = (char) (((cMo306d & 31) << 6) | (iMo306d & 63));
                i++;
            } else {
                if ((cMo306d & 240) != 224) {
                    throw new UTFDataFormatException("bad byte");
                }
                int iMo306d2 = interfaceC0398b.mo306d() & 255;
                int iMo306d3 = interfaceC0398b.mo306d() & 255;
                if ((iMo306d2 & 192) != 128 || (iMo306d3 & 192) != 128) {
                    break;
                }
                cArr[i] = (char) (((cMo306d & 15) << 12) | ((iMo306d2 & 63) << 6) | (iMo306d3 & 63));
                i++;
            }
        }
        throw new UTFDataFormatException("bad second or third byte");
    }

    /* JADX INFO: renamed from: a */
    public static String m2197a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public static String m2198a(String str) {
        return str.replace("&", "&amp;").replace("<", "&lt;");
    }

    /* JADX INFO: renamed from: a */
    public static String m2199a(String str, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i == strArr.length - 1) {
                sb.append(strArr[i]);
            } else {
                sb.append(strArr[i]).append(str);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public static String m2200a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i += 3) {
            stringBuffer.append(m2229a(bArr, i));
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    public static String m2201a(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        int i6 = i + i2;
        if ((i | i2 | i6) < 0 || i6 > bArr.length) {
            throw new IndexOutOfBoundsException("arr.length " + bArr.length + "; " + i + "..!" + i6);
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("outOffset < 0");
        }
        if (i2 == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer((i2 << 2) + 6);
        int i7 = 0;
        while (i2 > 0) {
            if (i7 == 0) {
                stringBuffer.append(m2295u(i3));
                stringBuffer.append(": ");
            } else if ((i7 & 1) == 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append(m2298x(bArr[i]));
            i3++;
            i++;
            i7++;
            if (i7 == i4) {
                stringBuffer.append('\n');
                i7 = 0;
            }
            i2--;
        }
        if (i7 != 0) {
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    public static void m2202a(InterfaceC0064d interfaceC0064d, File file, String str) throws C0065e {
        try {
            if (interfaceC0064d.mo168a(str)) {
                m2213a(new File(file, str));
                interfaceC0064d.mo172d(str).mo166a(new File(file, str));
            } else {
                File file2 = new File(file, str);
                file2.getParentFile().mkdirs();
                m2215a(interfaceC0064d.mo169b(str), new FileOutputStream(file2));
            }
        } catch (IOException e) {
            throw new C0065e("File copy error: " + str, e);
        } catch (Exception e2) {
            throw new C0065e("File copy error: " + str, e2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2203a(Activity activity, String str, int i) {
        Intent intentM2267e = m2267e(activity, str);
        if (intentM2267e != null) {
            activity.startActivityForResult(intentM2267e, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2204a(Context context, String str) throws Throwable {
        Intent intent;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        Uri uriFromFile = null;
        fileInputStream = null;
        if (Build.VERSION.SDK_INT >= 24) {
            intent = new Intent("android.intent.action.INSTALL_PACKAGE");
            intent.setFlags(1);
            File externalFilesDir = context.getExternalFilesDir("apk");
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdir();
            }
            File file = new File(externalFilesDir, "gen.apk");
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(str));
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        m2244b(fileInputStream2, fileOutputStream);
                        m2212a((Closeable) fileInputStream2);
                        m2212a(fileOutputStream);
                        try {
                            uriFromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                        } catch (Throwable th) {
                        }
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            Toast.makeText(context, "Internal error: " + e.getMessage(), 1);
                            m2212a((Closeable) fileInputStream);
                            m2212a(fileOutputStream);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            m2212a((Closeable) fileInputStream);
                            m2212a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        m2212a((Closeable) fileInputStream);
                        m2212a(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
        } else {
            intent = new Intent("android.intent.action.VIEW");
            uriFromFile = Uri.fromFile(new File(str));
        }
        if (uriFromFile != null) {
            try {
                intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                intent.setDataAndType(uriFromFile, "application/vnd.android.package-archive");
                intent.setFlags(268468224);
                intent.addFlags(1);
                context.startActivity(intent);
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2205a(Context context, String str, String str2, Map<String, String> map, Map<String, String> map2, Set<String> set) {
        String str3;
        String str4;
        String absolutePath;
        String absolutePath2;
        if (isNullOrEmpty(map) && isNullOrEmpty(map2) && isNullOrEmpty(set)) {
            str4 = null;
            str3 = str;
        } else {
            str3 = str2 + ".signed";
            int length = 0;
            StringBuilder sb = new StringBuilder();
            char c = '\n';
            if (!isNullOrEmpty(map2)) {
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    sb.append(key);
                    sb.append('\n');
                    sb.append(value);
                    sb.append('\n');
                    length += key.getBytes().length + value.getBytes().length + 2;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            int length2 = 0;
            if (!isNullOrEmpty(set)) {
                for (String str5 : set) {
                    sb2.append(str5);
                    sb2.append('\n');
                    length2 += str5.getBytes().length + 1;
                }
            }
            StringBuilder sb3 = new StringBuilder();
            int length3 = 0;
            if (!isNullOrEmpty(map)) {
                for (Map.Entry<String, String> entry2 : map.entrySet()) {
                    String key2 = entry2.getKey();
                    String value2 = entry2.getValue();
                    sb3.append(key2);
                    sb3.append(c);
                    sb3.append(value2);
                    sb3.append(c);
                    length3 += key2.getBytes().length + value2.getBytes().length + 2;
                    c = '\n';
                }
            }
            MainActivity.m2527md(str3, str, sb.toString(), length, sb2.toString(), length2, sb3.toString(), length3);
            str4 = str3;
        }
        String strM2546c = SettingActivity.m2546c(context);
        if (strM2546c.charAt(0) == 'c' && strM2546c.charAt(1) == 'u') {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            String string = defaultSharedPreferences.getString("PublicKeyPath", "");
            absolutePath2 = defaultSharedPreferences.getString("PrivateKeyPath", "");
            absolutePath = string;
        } else {
            File file = new File(context.getFilesDir(), "signing");
            File file2 = new File(file, strM2546c + ".x509.pem");
            File file3 = new File(file, strM2546c + ".pk8");
            if (file2.exists() && file3.exists()) {
                absolutePath = file2.getAbsolutePath();
                absolutePath2 = file3.getAbsolutePath();
            } else {
                file.mkdir();
                try {
                    AssetManager assets = context.getAssets();
                    m2215a(assets.open(strM2546c + ".x509.pem"), new FileOutputStream(file2));
                    m2215a(assets.open(strM2546c + ".pk8"), new FileOutputStream(file3));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!file2.exists() || !file3.exists()) {
                    return;
                }
                absolutePath = file2.getAbsolutePath();
                absolutePath2 = file3.getAbsolutePath();
            }
        }
        boolean[] zArrEnabledSignatureVersions = SettingActivity.enabledSignatureVersions(context);
        C0987b.m2312a(absolutePath, absolutePath2, str3, str2, zArrEnabledSignatureVersions[0], zArrEnabledSignatureVersions[1], zArrEnabledSignatureVersions[2], zArrEnabledSignatureVersions[3]);
        if (str4 != null) {
            File file4 = new File(str4);
            if (file4.exists()) {
                file4.delete();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2206a(Intent intent, String str, Map map) {
        Bundle bundle = new Bundle();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (String str2 : map.keySet()) {
            String str3 = (String) map.get(str2);
            arrayList.add(str2);
            arrayList2.add(str3);
        }
        bundle.putStringArrayList(str + "_keys", arrayList);
        bundle.putStringArrayList(str + "_values", arrayList2);
        intent.putExtras(bundle);
    }

    /* JADX INFO: renamed from: a */
    public static void m2207a(InterfaceC0399c interfaceC0399c, int i) {
        for (int i2 = i >>> 7; i2 != 0; i2 >>>= 7) {
            interfaceC0399c.mo307d((byte) ((i & 127) | 128));
            i = i2;
        }
        interfaceC0399c.mo307d((byte) (i & 127));
    }

    /* JADX INFO: renamed from: a */
    public static void m2208a(InterfaceC0399c interfaceC0399c, int i, long j) {
        int iNumberOfLeadingZeros = ((65 - Long.numberOfLeadingZeros((j >> 63) ^ j)) + 7) >> 3;
        interfaceC0399c.mo307d(((iNumberOfLeadingZeros - 1) << 5) | i);
        while (iNumberOfLeadingZeros > 0) {
            interfaceC0399c.mo307d((byte) j);
            j >>= 8;
            iNumberOfLeadingZeros--;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2209a(BufferedWriter bufferedWriter, int i, String str) {
        for (int i2 = 0; i2 < i; i2++) {
            bufferedWriter.write(CodeWriter.INDENT);
        }
        bufferedWriter.write("&lt;/<span class=\"end-tag\">" + str + "</span>&gt;");
    }

    /* JADX INFO: renamed from: a */
    private static void m2210a(BufferedWriter bufferedWriter, int i, String str, String str2) {
        bufferedWriter.write("\n");
        for (int i2 = 0; i2 < i; i2++) {
            bufferedWriter.write(CodeWriter.INDENT);
        }
        bufferedWriter.write("<span class=\"attribute-name\">" + str + "</span>=<a class=\"attribute-value\">" + str2 + "</a>");
    }

    /* JADX INFO: renamed from: a */
    private static void m2211a(BufferedWriter bufferedWriter, String str) {
        bufferedWriter.write(str.replaceAll("<", "&lt;").replace(">", "&gt;"));
    }

    /* JADX INFO: renamed from: a */
    public static void m2212a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2213a(File file) {
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        m2213a(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2214a(File file, File file2) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        File[] fileArrListFiles = file2.listFiles();
        if (fileArrListFiles != null) {
            for (File file3 : fileArrListFiles) {
                if (file3.isFile()) {
                    try {
                        fileInputStream = new FileInputStream(file3);
                        try {
                            fileOutputStream = new FileOutputStream(new File(file, file3.getName()));
                        } catch (Exception e) {
                            fileOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception e2) {
                        fileOutputStream = null;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                    try {
                        m2244b(fileInputStream, fileOutputStream);
                        m2212a((Closeable) fileInputStream);
                        m2212a(fileOutputStream);
                    } catch (Exception e3) {
                        m2212a((Closeable) fileInputStream);
                        m2212a(fileOutputStream);
                    } catch (Throwable th3) {
                        fileOutputStream2 = fileOutputStream;
                        th = th3;
                        m2212a((Closeable) fileInputStream);
                        m2212a(fileOutputStream2);
                        throw th;
                    }
                } else if (file3.isDirectory()) {
                    File file4 = new File(file, file3.getName());
                    file4.mkdir();
                    m2214a(file4, file3);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2215a(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[1024];
            int i = inputStream.read(bArr);
            while (i > 0) {
                outputStream.write(bArr, 0, i);
                i = inputStream.read(bArr);
            }
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2216a(InputStream inputStream, byte[] bArr) {
        int i;
        int i2 = 0;
        while (i2 < bArr.length && (i = inputStream.read(bArr, i2, bArr.length - i2)) != -1) {
            i2 += i;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2217a(String str, String str2) {
        if (f2475h) {
            return;
        }
        if (str != null && str2 != null) {
            throw new RuntimeException("optimize and don't optimize lists  are mutually exclusive.");
        }
        if (str != null) {
            f2473f = m2286m(str);
        }
        if (str2 != null) {
            f2474g = m2286m(str2);
        }
        f2475h = true;
    }

    /* JADX INFO: renamed from: a */
    public static void m2218a(List list, String str) throws IOException {
        if (list.isEmpty()) {
            return;
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(str)));
        bufferedWriter.write("<html><head>");
        bufferedWriter.write("<title>1.xml</title>");
        bufferedWriter.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"viewsource.css\">");
        bufferedWriter.write("</head>");
        bufferedWriter.write("<body id=\"viewsource\" class=\"wrap\" style=\"-moz-tab-size: 4\">");
        bufferedWriter.write("<pre id=\"line1\">");
        String str2 = (String) list.get(0);
        if (str2 != null) {
            bufferedWriter.write(str2.replaceAll("<", "&lt;").replace(">", "&gt;"));
        }
        int i = 1;
        int i2 = 2;
        int i3 = 0;
        while (true) {
            int i4 = i;
            if (i4 >= list.size()) {
                bufferedWriter.close();
                return;
            }
            String strTrim = ((String) list.get(i4)).trim();
            bufferedWriter.write("\n<span id=\"line" + i2 + "\"></span>");
            boolean z = false;
            if (strTrim.length() >= 2 && strTrim.charAt(0) == '<') {
                char cCharAt = strTrim.charAt(1);
                if ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == '_')) {
                    boolean z2 = false;
                    boolean z3 = false;
                    if (strTrim.endsWith(">")) {
                        z2 = true;
                        if (strTrim.endsWith("/>")) {
                            z3 = true;
                            strTrim = strTrim.substring(0, strTrim.length() - 2);
                        } else {
                            strTrim = strTrim.substring(0, strTrim.length() - 1);
                        }
                    }
                    String[] strArrSplit = strTrim.split(" ");
                    m2243b(bufferedWriter, i3, strArrSplit[0].substring(1));
                    for (int i5 = 1; i5 < strArrSplit.length; i5++) {
                        int iIndexOf = strArrSplit[i5].indexOf("=");
                        if (iIndexOf != -1) {
                            m2210a(bufferedWriter, i3 + 1, strArrSplit[i5].substring(0, iIndexOf), strArrSplit[i5].substring(iIndexOf + 1));
                        } else {
                            m2211a(bufferedWriter, strArrSplit[i5]);
                        }
                    }
                    if (z3) {
                        m2211a(bufferedWriter, "/>");
                    } else if (z2) {
                        m2211a(bufferedWriter, ">");
                    }
                    if (!z3) {
                        i3++;
                    }
                    z = true;
                } else if (cCharAt == '/') {
                    i3--;
                    m2209a(bufferedWriter, i3, strTrim.substring(2, strTrim.length() - 1));
                    z = true;
                }
            }
            if (!z) {
                for (int i6 = 0; i6 < i3; i6++) {
                    bufferedWriter.write(CodeWriter.INDENT);
                }
                bufferedWriter.write(strTrim.replaceAll("<", "&lt;").replace(">", "&gt;"));
            }
            i2++;
            i = i4 + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2219a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2220a(byte[] bArr, int i, String str) {
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != 0 && cCharAt <= 127) {
                i2 = i + 1;
                bArr[i] = (byte) cCharAt;
            } else if (cCharAt <= 2047) {
                int i4 = i + 1;
                bArr[i] = (byte) (((cCharAt >> 6) & 31) | 192);
                i2 = i4 + 1;
                bArr[i4] = (byte) ((cCharAt & '?') | 128);
            } else {
                int i5 = i + 1;
                bArr[i] = (byte) (((cCharAt >> '\f') & 15) | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((cCharAt >> 6) & 63) | 128);
                i2 = i6 + 1;
                bArr[i6] = (byte) ((cCharAt & '?') | 128);
            }
            i3++;
            i = i2;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2221a(int[] iArr, int i, boolean z) {
        int i2 = i >> 5;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    /* JADX INFO: renamed from: a */
    public static void m2222a(int[] iArr, int[] iArr2) {
        for (int i = 0; i < iArr2.length; i++) {
            iArr[i] = iArr[i] | iArr2[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private static boolean m2223a(char c) {
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(c);
        return (Character.isISOControl(c) || c == -1 || unicodeBlockOf == null || unicodeBlockOf == Character.UnicodeBlock.SPECIALS) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2224a(Context context, String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, false);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2225a(String str, Object obj) {
        ObjectOutputStream objectOutputStream;
        boolean z;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(str)));
            } catch (IOException e) {
                e = e;
                objectOutputStream = null;
            } catch (Throwable th) {
                th = th;
                m2212a(objectOutputStream2);
                throw th;
            }
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                m2212a(objectOutputStream);
                z = true;
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                m2212a(objectOutputStream);
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            m2212a(objectOutputStream2);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2226a(boolean z, C1532z c1532z, int i, char[] cArr) {
        int length = i + cArr.length;
        if (length > c1532z.f4547c + c1532z.f4546b) {
            return false;
        }
        char[] cArr2 = c1532z.f4545a;
        int i2 = 0;
        while (i < length) {
            char upperCase = cArr2[i];
            char upperCase2 = cArr[i2];
            if (z) {
                upperCase = Character.toUpperCase(upperCase);
                upperCase2 = Character.toUpperCase(upperCase2);
            }
            if (upperCase != upperCase2) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2227a(int[] iArr, int i) {
        return (iArr[i >> 5] & (1 << (i & 31))) != 0;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2228a(int[] iArr, int i, int i2) {
        int iM2262d = m2262d(iArr, i);
        return iM2262d >= 0 && iM2262d < i2;
    }

    /* JADX INFO: renamed from: a */
    private static char[] m2229a(byte[] bArr, int i) {
        int length = (bArr.length - i) - 1;
        int i2 = length >= 2 ? 2 : length;
        int i3 = 0;
        for (int i4 = 0; i4 <= i2; i4++) {
            int i5 = bArr[i + i4];
            if (i5 < 0) {
                i5 += 256;
            }
            i3 += i5 << ((2 - i4) * 8);
        }
        char[] cArr = new char[4];
        for (int i6 = 0; i6 < 4; i6++) {
            int i7 = (i3 >>> ((3 - i6) * 6)) & 63;
            cArr[i6] = (i7 < 0 || i7 > 25) ? (i7 < 26 || i7 > 51) ? (i7 < 52 || i7 > 61) ? i7 == 62 ? '+' : i7 == 63 ? '/' : '?' : (char) ((i7 - 52) + 48) : (char) ((i7 - 26) + 97) : (char) (i7 + 65);
        }
        if (length <= 0) {
            cArr[2] = '=';
        }
        if (length < 2) {
            cArr[3] = '=';
        }
        return cArr;
    }

    /* JADX INFO: renamed from: a */
    private C0031e[] m2230a(C0985a c0985a, boolean z) throws C0000a {
        ByteArrayInputStream byteArrayInputStream;
        try {
            File file = new File(this.f2480e.getFilesDir().getAbsolutePath() + "/bin/resources.arsc");
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[(int) file.length()];
                m2216a(fileInputStream, bArr);
                byteArrayInputStream = new ByteArrayInputStream(bArr);
            } catch (Throwable th) {
                byteArrayInputStream = null;
            }
            C0031e[] c0031eArrM113a = C0043a.m101a(byteArrayInputStream != null ? byteArrayInputStream : fileInputStream, false, true, c0985a, null, false).m113a();
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception e) {
                }
            }
            try {
                fileInputStream.close();
            } catch (Exception e2) {
            }
            return c0031eArrM113a;
        } catch (IOException e3) {
            throw new C0000a("Could not load resources.arsc", e3);
        }
    }

    /* JADX INFO: renamed from: aa */
    public static void m2231aa(Context context, String str) {
        File file = new File(str);
        if (!file.exists() && !file.isFile()) {
            Toast.makeText(context, "File " + file.getAbsolutePath() + " don't exist", 1).show();
            return;
        }
        if (file.canRead()) {
            new Installer(context).installApkFiles(file);
            return;
        }
        Toast.makeText(context, "File " + file.getAbsolutePath() + " don't open", 1).show();
    }

    /* JADX INFO: renamed from: b */
    public static int m2232b(InterfaceC0398b interfaceC0398b) {
        int iMo306d;
        int i = 0;
        int i2 = 0;
        do {
            iMo306d = interfaceC0398b.mo306d() & 255;
            i2 |= (iMo306d & 127) << (i * 7);
            i++;
            if ((iMo306d & 128) != 128) {
                break;
            }
        } while (i < 5);
        if ((iMo306d & 128) == 128) {
            throw new C0420s("invalid LEB128 sequence");
        }
        return i2;
    }

    /* JADX INFO: renamed from: b */
    public static int m2233b(byte[] bArr) {
        if (bArr.length != 8 || bArr[0] != 100 || bArr[1] != 101 || bArr[2] != 120 || bArr[3] != 10 || bArr[7] != 0) {
            return -1;
        }
        String string = new StringBuilder().append((char) bArr[4]).append((char) bArr[5]).append((char) bArr[6]).toString();
        if (string.equals("036")) {
            return 14;
        }
        return string.equals("035") ? 13 : -1;
    }

    /* JADX INFO: renamed from: b */
    public static long m2234b(InterfaceC0398b interfaceC0398b, int i) {
        long jMo306d = 0;
        for (int i2 = i; i2 >= 0; i2--) {
            jMo306d = (jMo306d >>> 8) | ((((long) interfaceC0398b.mo306d()) & 255) << 56);
        }
        return jMo306d >> ((7 - i) << 3);
    }

    /* JADX INFO: renamed from: b */
    public static long m2235b(InterfaceC0398b interfaceC0398b, int i, boolean z) {
        long jMo306d = 0;
        while (i >= 0) {
            jMo306d = (jMo306d >>> 8) | ((((long) interfaceC0398b.mo306d()) & 255) << 56);
            i--;
        }
        return jMo306d;
    }

    /* JADX INFO: renamed from: b */
    public static Bundle m2236b(Intent intent, String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(str, z);
        intent.putExtras(bundle);
        return bundle;
    }

    /* JADX INFO: renamed from: b */
    public static String m2237b(long j) {
        char[] cArr = new char[17];
        if (j < 0) {
            cArr[0] = '-';
            j = -j;
        } else {
            cArr[0] = '+';
        }
        for (int i = 0; i < 16; i++) {
            cArr[16 - i] = Character.forDigit(((int) j) & 15, 16);
            j >>= 4;
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: b */
    public static String m2238b(Context context) {
        ClipData primaryClip = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            return null;
        }
        return primaryClip.getItemAt(0).coerceToText(context).toString();
    }

    /* JADX INFO: renamed from: b */
    public static String m2239b(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder(str.length() + 10);
        switch (charArray[0]) {
            case '#':
            case '?':
            case '@':
                sb.append('\\');
                break;
        }
        for (char c : charArray) {
            switch (c) {
                case '\n':
                    sb.append("\\n");
                    continue;
                    break;
                case '\"':
                    sb.append("&quot;");
                    continue;
                    break;
                case C0299R.styleable.AppCompatTheme_colorSwitchThumbNormal /* 92 */:
                    sb.append('\\');
                    break;
                default:
                    if (!m2223a(c)) {
                        sb.append(String.format("\\u%04x", Integer.valueOf(c)));
                    }
                    break;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    public static void m2240b(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean(str, true);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: b */
    public static void m2241b(InterfaceC0399c interfaceC0399c, int i) {
        int i2 = i >> 7;
        int i3 = (Integer.MIN_VALUE & i) == 0 ? 0 : -1;
        boolean z = true;
        int i4 = i2;
        while (z) {
            z = (i4 == i3 && (i4 & 1) == ((i >> 6) & 1)) ? false : true;
            interfaceC0399c.mo307d((byte) ((z ? 128 : 0) | (i & 127)));
            i = i4;
            i4 >>= 7;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m2242b(InterfaceC0399c interfaceC0399c, int i, long j) {
        int iNumberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j);
        if (iNumberOfLeadingZeros == 0) {
            iNumberOfLeadingZeros = 1;
        }
        int i2 = (iNumberOfLeadingZeros + 7) >> 3;
        interfaceC0399c.mo307d(((i2 - 1) << 5) | i);
        while (i2 > 0) {
            interfaceC0399c.mo307d((byte) j);
            j >>= 8;
            i2--;
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m2243b(BufferedWriter bufferedWriter, int i, String str) {
        for (int i2 = 0; i2 < i; i2++) {
            bufferedWriter.write(CodeWriter.INDENT);
        }
        bufferedWriter.write("&lt;<span class=\"start-tag\">" + str + "</span>");
    }

    /* JADX INFO: renamed from: b */
    public static void m2244b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m2245b(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(str2.getBytes());
                m2212a(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                m2212a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m2246b(int[] iArr, int i) {
        int i2 = i >> 5;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    /* JADX INFO: renamed from: b */
    public static boolean m2247b(Intent intent, String str) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return extras.getBoolean(str, false);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r1.m1690l() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        if (r0.m1690l() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return false;
     */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m2248b(com.p016a.p019b.p036f.p040d.InterfaceC0806d r9, com.p016a.p019b.p036f.p040d.InterfaceC0806d r10) {
        /*
            r7 = 10
            r5 = 9
            r3 = 0
            r2 = 1
        L6:
            com.a.b.f.d.c r6 = r9.mo663a()
            com.a.b.f.d.c r4 = r10.mo663a()
            boolean r0 = r6.equals(r4)
            if (r0 == 0) goto L16
            r0 = r2
        L15:
            return r0
        L16:
            int r1 = r6.mo665c()
            int r0 = r4.mo665c()
            if (r1 != r7) goto L8b
            com.a.b.f.d.c r1 = com.p016a.p019b.p036f.p040d.C0805c.f2023n
            r6 = r5
        L23:
            if (r0 != r7) goto L87
            com.a.b.f.d.c r0 = com.p016a.p019b.p036f.p040d.C0805c.f2023n
            r4 = r5
        L28:
            if (r6 != r5) goto L2c
            if (r4 == r5) goto L3c
        L2c:
            boolean r1 = r1.m1690l()
            if (r1 == 0) goto L3a
            boolean r0 = r0.m1690l()
            if (r0 == 0) goto L3a
            r0 = r2
            goto L15
        L3a:
            r0 = r3
            goto L15
        L3c:
            com.a.b.f.d.c r4 = com.p016a.p019b.p036f.p040d.C0805c.f2019j
            if (r1 != r4) goto L42
            r0 = r3
            goto L15
        L42:
            com.a.b.f.d.c r4 = com.p016a.p019b.p036f.p040d.C0805c.f2019j
            if (r0 != r4) goto L48
            r0 = r2
            goto L15
        L48:
            com.a.b.f.d.c r4 = com.p016a.p019b.p036f.p040d.C0805c.f2023n
            if (r1 != r4) goto L4e
            r0 = r2
            goto L15
        L4e:
            boolean r4 = r1.m1693o()
            if (r4 == 0) goto L73
            boolean r4 = r0.m1693o()
            if (r4 != 0) goto L5c
            r0 = r3
            goto L15
        L5c:
            com.a.b.f.d.c r1 = r1.m1697s()
            com.a.b.f.d.c r0 = r0.m1697s()
            boolean r4 = r1.m1693o()
            if (r4 == 0) goto L70
            boolean r4 = r0.m1693o()
            if (r4 != 0) goto L5c
        L70:
            r10 = r0
            r9 = r1
            goto L6
        L73:
            boolean r0 = r0.m1693o()
            if (r0 == 0) goto L85
            com.a.b.f.d.c r0 = com.p016a.p019b.p036f.p040d.C0805c.f2024o
            if (r1 == r0) goto L81
            com.a.b.f.d.c r0 = com.p016a.p019b.p036f.p040d.C0805c.f2022m
            if (r1 != r0) goto L83
        L81:
            r0 = r2
            goto L15
        L83:
            r0 = r3
            goto L15
        L85:
            r0 = r2
            goto L15
        L87:
            r8 = r0
            r0 = r4
            r4 = r8
            goto L28
        L8b:
            r8 = r1
            r1 = r6
            r6 = r8
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gmail.heagoo.p054a.p059c.C0985a.m2248b(com.a.b.f.d.d, com.a.b.f.d.d):boolean");
    }

    /* JADX INFO: renamed from: b */
    private static boolean m2249b(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m2250b(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m2251b(File file) {
        if (!file.exists()) {
            throw new RuntimeException(file + ": file not found");
        }
        if (!file.isFile()) {
            throw new RuntimeException(file + ": not a file");
        }
        if (!file.canRead()) {
            throw new RuntimeException(file + ": file not readable");
        }
        long length = file.length();
        int i = (int) length;
        if (i != length) {
            throw new RuntimeException(file + ": file too long");
        }
        byte[] bArr = new byte[i];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int i2 = 0;
            while (i > 0) {
                int i3 = fileInputStream.read(bArr, i2, i);
                if (i3 == -1) {
                    throw new RuntimeException(file + ": unexpected EOF");
                }
                i2 += i3;
                i -= i3;
            }
            fileInputStream.close();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(file + ": trouble reading", e);
        }
    }

    /* JADX INFO: renamed from: c */
    public static int m2252c(int[] iArr) {
        int iBitCount = 0;
        for (int i : iArr) {
            iBitCount += Integer.bitCount(i);
        }
        return iBitCount;
    }

    /* JADX INFO: renamed from: c */
    public static String m2253c(int i) {
        return i >= 14 ? "dex\n036\u0000" : "dex\n035\u0000";
    }

    /* JADX INFO: renamed from: c */
    public static String m2254c(String str) {
        boolean z;
        boolean z2;
        if (str == null || str.isEmpty()) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder(str.length() + 16);
        switch (charArray[0]) {
            case '#':
            case '?':
            case '@':
                sb.append('\\');
                break;
        }
        int length = charArray.length;
        int i = 0;
        boolean z3 = true;
        boolean z4 = false;
        int length2 = 0;
        boolean z5 = false;
        while (i < length) {
            char c = charArray[i];
            if (z5) {
                if (c == '>') {
                    length2 = sb.length() + 1;
                    z5 = false;
                    z2 = z3;
                    z = false;
                } else {
                    boolean z6 = z3;
                    z = z4;
                    z2 = z6;
                }
            } else if (c == ' ') {
                if (z3) {
                    z4 = true;
                }
                z = z4;
                z2 = true;
            } else {
                switch (c) {
                    case '\n':
                    case '\'':
                        z2 = false;
                        z = true;
                        break;
                    case '\"':
                        sb.append('\\');
                        z = z4;
                        z2 = false;
                        break;
                    case C0299R.styleable.AppCompatTheme_toolbarStyle /* 60 */:
                        if (!z4) {
                            z = z4;
                            z5 = true;
                            z2 = false;
                        } else {
                            sb.insert(length2, '\"').append('\"');
                            z = z4;
                            z5 = true;
                            z2 = false;
                        }
                        break;
                    case C0299R.styleable.AppCompatTheme_colorSwitchThumbNormal /* 92 */:
                        sb.append('\\');
                        z = z4;
                        z2 = false;
                        break;
                    default:
                        if (m2223a(c)) {
                            z = z4;
                            z2 = false;
                        } else if (sb.length() + 1 == str.length() && c == 0) {
                            z = z4;
                            z2 = false;
                        } else {
                            sb.append(String.format("\\u%04x", Integer.valueOf(c)));
                            z = z4;
                            z2 = false;
                        }
                        break;
                }
                i++;
                boolean z7 = z2;
                z4 = z;
                z3 = z7;
            }
            sb.append(c);
            i++;
            boolean z72 = z2;
            z4 = z;
            z3 = z72;
        }
        if (z4 || z3) {
            sb.insert(length2, '\"').append('\"');
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: c */
    public static String m2255c(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: c */
    public static ArrayList m2256c(Intent intent, String str) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return extras.getStringArrayList(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public static void m2257c(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", str));
    }

    /* JADX INFO: renamed from: c */
    public static void m2258c(InterfaceC0399c interfaceC0399c, int i, long j) {
        int iNumberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j);
        if (iNumberOfTrailingZeros == 0) {
            iNumberOfTrailingZeros = 1;
        }
        int i2 = (iNumberOfTrailingZeros + 7) >> 3;
        long j2 = j >> (64 - (i2 << 3));
        interfaceC0399c.mo307d(((i2 - 1) << 5) | i);
        while (i2 > 0) {
            interfaceC0399c.mo307d((byte) j2);
            j2 >>= 8;
            i2--;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m2259c(int[] iArr, int i) {
        int i2 = i >> 5;
        iArr[i2] = ((1 << (i & 31)) ^ (-1)) & iArr[i2];
    }

    /* JADX INFO: renamed from: c */
    public static boolean m2260c(String str, String str2) {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        if (str2.endsWith("/")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        String[] strArrSplit = str.split("/");
        String[] strArrSplit2 = str2.split("/");
        if (strArrSplit.length >= strArrSplit2.length) {
            return false;
        }
        for (int i = 0; i < strArrSplit.length; i++) {
            if (!strArrSplit[i].equals(strArrSplit2[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: d */
    public static int m2261d(int i) {
        int i2 = i >> 7;
        int i3 = 0;
        while (i2 != 0) {
            i2 >>= 7;
            i3++;
        }
        return i3 + 1;
    }

    /* JADX INFO: renamed from: d */
    public static int m2262d(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = i & 31;
        for (int i3 = i >> 5; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i4 != 0) {
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros((((1 << i2) - 1) ^ (-1)) & i4);
                if (iNumberOfTrailingZeros == 32) {
                    iNumberOfTrailingZeros = -1;
                }
                if (iNumberOfTrailingZeros >= 0) {
                    return (i3 << 5) + iNumberOfTrailingZeros;
                }
            }
            i2 = 0;
        }
        return -1;
    }

    /* JADX INFO: renamed from: d */
    public static String m2263d(Context context, String str) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            throw new Exception("Can not find sd card.");
        }
        String str2 = Environment.getExternalStorageDirectory().getPath() + ("/ApkEditor/" + str + "/");
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    /* JADX INFO: renamed from: d */
    public static String m2264d(String str, String str2) {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        if (str2.endsWith("/")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        String[] strArrSplit = str.split("/");
        String[] strArrSplit2 = str2.split("/");
        if (strArrSplit.length < strArrSplit2.length) {
            return strArrSplit2[strArrSplit.length];
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public static Map m2265d(Intent intent, String str) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            HashMap map = new HashMap();
            ArrayList<String> stringArrayList = extras.getStringArrayList(str + "_keys");
            ArrayList<String> stringArrayList2 = extras.getStringArrayList(str + "_values");
            if (stringArrayList != null && stringArrayList2 != null) {
                for (int i = 0; i < stringArrayList.size(); i++) {
                    map.put(stringArrayList.get(i), stringArrayList2.get(i));
                }
                return map;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m2266d(String str) {
        C0073e c0073eM2176a = m2176a(str, 4);
        if (!((List) c0073eM2176a.f190a).isEmpty()) {
            if (((List) c0073eM2176a.f191b).size() + ((List) c0073eM2176a.f190a).size() > 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: e */
    public static Intent m2267e(Context context, String str) {
        Uri uriForFile;
        Intent intent = null;
        try {
            uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", new File(str));
        } catch (Throwable th) {
            uriForFile = null;
        }
        if (uriForFile != null) {
            if (m2249b(str, context.getResources().getStringArray(R.array.fileTypeImage))) {
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setDataAndType(uriForFile, "image/*");
            } else if (m2249b(str, context.getResources().getStringArray(R.array.fileTypeWebText))) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(uriForFile, "text/html");
            } else if (m2249b(str, context.getResources().getStringArray(R.array.fileTypePackage))) {
                intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
            } else if (m2249b(str, context.getResources().getStringArray(R.array.fileTypeAudio))) {
                intent = new Intent("android.intent.action.VIEW");
                intent.putExtra("oneshot", 0);
                intent.putExtra("configchange", 0);
                intent.setDataAndType(uriForFile, "audio/*");
            } else if (m2249b(str, context.getResources().getStringArray(R.array.fileTypeVideo))) {
                intent = new Intent("android.intent.action.VIEW");
                intent.putExtra("oneshot", 0);
                intent.putExtra("configchange", 0);
                intent.setDataAndType(uriForFile, "video/*");
            } else if (m2249b(str, context.getResources().getStringArray(R.array.fileTypeText))) {
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setDataAndType(uriForFile, "text/plain");
            } else if (m2249b(str, context.getResources().getStringArray(R.array.fileTypePdf))) {
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setDataAndType(uriForFile, "application/pdf");
            } else if (m2249b(str, context.getResources().getStringArray(R.array.fileTypeWord))) {
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setDataAndType(uriForFile, "application/msword");
            } else if (m2249b(str, context.getResources().getStringArray(R.array.fileTypeExcel))) {
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setDataAndType(uriForFile, "application/vnd.ms-excel");
            } else if (m2249b(str, context.getResources().getStringArray(R.array.fileTypePPT))) {
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setDataAndType(uriForFile, "application/vnd.ms-powerpoint");
            } else {
                intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(uriForFile, "*/*");
            }
            intent.setFlags(3);
        }
        return intent;
    }

    /* JADX INFO: renamed from: e */
    public static Object m2268e(String str, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            return null;
        } catch (SecurityException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public static String m2269e(String str) {
        int i = 0;
        C0073e c0073eM2176a = m2176a(str, 4);
        if (((List) c0073eM2176a.f190a).isEmpty()) {
            return str;
        }
        if (((List) c0073eM2176a.f191b).size() + ((List) c0073eM2176a.f190a).size() < 2) {
            return str;
        }
        List list = (List) c0073eM2176a.f190a;
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            Integer numValueOf = Integer.valueOf(((Integer) it.next()).intValue() + 1);
            int i2 = i + 1;
            sb.append(str.substring(iIntValue, numValueOf.intValue())).append(i2).append('$');
            iIntValue = numValueOf.intValue();
            i = i2;
        }
        sb.append(str.substring(iIntValue));
        return sb.toString();
    }

    /* JADX INFO: renamed from: e */
    public static boolean m2270e(int i) {
        if (i < -1) {
            return false;
        }
        if (i == -1) {
            return true;
        }
        int i2 = i & 255;
        if (i2 == 0 || i2 == 255) {
            return true;
        }
        return (65280 & i) == 0;
    }

    /* JADX INFO: renamed from: f */
    public static int m2271f(int i) {
        int i2 = i & 255;
        return (i2 == 0 || i2 == 255) ? i : i2;
    }

    /* JADX INFO: renamed from: f */
    private static boolean m2272f(Context context, String str) {
        File file = new File(str);
        boolean z = file.exists() && file.length() > ((long) (SettingEditorActivity.m2564d(context) << 10));
        if (z) {
            Toast.makeText(context, R.string.use_bfe_tip, 0);
        }
        return z;
    }

    /* JADX INFO: renamed from: f */
    public static byte[] m2273f(String str) throws UTFDataFormatException {
        long j = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            j = (cCharAt == 0 || cCharAt > 127) ? cCharAt <= 2047 ? j + 2 : j + 3 : j + 1;
            if (j > 65535) {
                throw new UTFDataFormatException("String more than 65535 UTF bytes long");
            }
        }
        byte[] bArr = new byte[(int) j];
        m2220a(bArr, 0, str);
        return bArr;
    }

    /* JADX INFO: renamed from: g */
    public static String m2274g(int i) {
        return m2192a(i, 30257, 1);
    }

    /* JADX INFO: renamed from: g */
    public static boolean m2275g(String str) {
        return str.endsWith(".zip") || str.endsWith(".jar") || str.endsWith(".apk");
    }

    /* JADX INFO: renamed from: h */
    public static String m2276h(int i) {
        return m2192a(i, 30239, 1);
    }

    /* JADX INFO: renamed from: h */
    public static boolean m2277h(String str) {
        return f2473f != null ? f2473f.contains(str) : f2474g == null || !f2474g.contains(str);
    }

    /* JADX INFO: renamed from: i */
    public static String m2278i(int i) {
        return m2192a(i, 20703, 2);
    }

    /* JADX INFO: renamed from: i */
    public static void m2279i(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        byte[] bArr = new byte[4096];
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
            int i = 0;
            while (true) {
                try {
                    int i2 = randomAccessFile.read(bArr);
                    if (i2 == -1) {
                        randomAccessFile.close();
                        randomAccessFile.close();
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        bArr[i3] = (byte) (bArr[i3] ^ 85);
                    }
                    randomAccessFile.seek(i);
                    randomAccessFile.write(bArr, 0, i2);
                    i += i2;
                } catch (Throwable th) {
                    th = th;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /* JADX INFO: renamed from: j */
    public static Object m2280j(String str) throws Throwable {
        ObjectInputStream objectInputStream;
        Throwable th;
        Object object = null;
        if (str != null) {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(new File(str)));
            } catch (Exception e) {
                e = e;
                objectInputStream = null;
            } catch (Throwable th2) {
                objectInputStream = null;
                th = th2;
                m2212a((Closeable) objectInputStream);
                throw th;
            }
            try {
                try {
                    object = objectInputStream.readObject();
                    m2212a((Closeable) objectInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    m2212a((Closeable) objectInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                m2212a((Closeable) objectInputStream);
            }
        }
        return object;
    }

    /* JADX INFO: renamed from: j */
    public static String m2281j(int i) {
        return m2192a(i, 204287, 3);
    }

    /* JADX INFO: renamed from: k */
    public static String m2282k(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            char[] cArr2 = new char[bArrDigest.length << 1];
            int i = 0;
            for (byte b2 : bArrDigest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b2 >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b2 & Token.LITERAL3];
            }
            return new String(cArr2);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: k */
    public static boolean m2283k(int i) {
        return (i & 2) != 0;
    }

    /* JADX INFO: renamed from: l */
    public static String m2284l(String str) {
        if (str != null) {
            return str.substring(str.lastIndexOf(47) + 1);
        }
        return null;
    }

    /* JADX INFO: renamed from: l */
    public static boolean m2285l(int i) {
        return (i & 8) != 0;
    }

    /* JADX INFO: renamed from: m */
    private static HashSet m2286m(String str) {
        HashSet hashSet = new HashSet();
        try {
            FileReader fileReader = new FileReader(str);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    fileReader.close();
                    return hashSet;
                }
                hashSet.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error with optimize list: " + str, e);
        }
    }

    /* JADX INFO: renamed from: m */
    public static boolean m2287m(int i) {
        return (i & 32) != 0;
    }

    /* JADX INFO: renamed from: n */
    public static boolean m2288n(int i) {
        return (i & 1024) != 0;
    }

    /* JADX INFO: renamed from: o */
    public static boolean m2289o(int i) {
        return (i & 256) != 0;
    }

    /* JADX INFO: renamed from: p */
    public static boolean m2290p(int i) {
        return (i & 8192) != 0;
    }

    /* JADX INFO: renamed from: q */
    public static String m2291q(int i) {
        switch (i) {
            case 1:
                return "nop";
            case 2:
                return "move";
            case 3:
                return "move-param";
            case 4:
                return "move-exception";
            case 5:
                return "const";
            case 6:
                return "goto";
            case 7:
                return "if-eq";
            case 8:
                return "if-ne";
            case 9:
                return "if-lt";
            case 10:
                return "if-ge";
            case 11:
                return "if-le";
            case 12:
                return "if-gt";
            case 13:
                return "switch";
            case 14:
                return "add";
            case 15:
                return "sub";
            case 16:
                return "mul";
            case 17:
                return "div";
            case 18:
                return "rem";
            case 19:
                return "neg";
            case 20:
                return "and";
            case 21:
                return "or";
            case 22:
                return "xor";
            case 23:
                return "shl";
            case 24:
                return "shr";
            case 25:
                return "ushr";
            case 26:
                return "not";
            case 27:
                return "cmpl";
            case 28:
                return "cmpg";
            case 29:
                return "conv";
            case 30:
                return "to-byte";
            case 31:
                return "to-char";
            case 32:
                return "to-short";
            case 33:
                return "return";
            case 34:
                return "array-length";
            case 35:
                return "throw";
            case 36:
                return "monitor-enter";
            case 37:
                return "monitor-exit";
            case 38:
                return "aget";
            case 39:
                return "aput";
            case 40:
                return "new-instance";
            case 41:
                return "new-array";
            case 42:
                return "filled-new-array";
            case 43:
                return "check-cast";
            case 44:
                return "instance-of";
            case 45:
                return "get-field";
            case 46:
                return "get-static";
            case 47:
                return "put-field";
            case C0299R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /* 48 */:
                return "put-static";
            case C0299R.styleable.AppCompatTheme_spinnerDropDownItemStyle /* 49 */:
                return "invoke-static";
            case 50:
                return "invoke-virtual";
            case C0299R.styleable.AppCompatTheme_actionButtonStyle /* 51 */:
                return "invoke-super";
            case C0299R.styleable.AppCompatTheme_buttonBarStyle /* 52 */:
                return "invoke-direct";
            case C0299R.styleable.AppCompatTheme_buttonBarButtonStyle /* 53 */:
                return "invoke-interface";
            case C0299R.styleable.AppCompatTheme_selectableItemBackground /* 54 */:
            default:
                return "unknown-" + m2298x(i);
            case C0299R.styleable.AppCompatTheme_selectableItemBackgroundBorderless /* 55 */:
                return "move-result";
            case C0299R.styleable.AppCompatTheme_borderlessButtonStyle /* 56 */:
                return "move-result-pseudo";
            case C0299R.styleable.AppCompatTheme_dividerVertical /* 57 */:
                return "fill-array-data";
        }
    }

    /* JADX INFO: renamed from: r */
    public static int m2292r(int i) {
        switch (i) {
            case 7:
            case 8:
                return i;
            case 9:
                return 12;
            case 10:
                return 11;
            case 11:
                return 10;
            case 12:
                return 9;
            default:
                throw new RuntimeException("Unrecognized IF regop: " + i);
        }
    }

    /* JADX INFO: renamed from: s */
    public static int[] m2293s(int i) {
        return new int[(i + 31) >> 5];
    }

    /* JADX INFO: renamed from: t */
    public static String m2294t(int i) {
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 8; i2++) {
            cArr[7 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: u */
    public static String m2295u(int i) {
        char[] cArr = new char[6];
        for (int i2 = 0; i2 < 6; i2++) {
            cArr[5 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: v */
    public static String m2296v(int i) {
        char[] cArr = new char[4];
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[3 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: w */
    public static String m2297w(int i) {
        return i == ((char) i) ? m2296v(i) : m2294t(i);
    }

    /* JADX INFO: renamed from: x */
    public static String m2298x(int i) {
        char[] cArr = new char[2];
        for (int i2 = 0; i2 < 2; i2++) {
            cArr[1 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: y */
    public static String m2299y(int i) {
        return new String(new char[]{Character.forDigit(i & 15, 16)});
    }

    /* JADX INFO: renamed from: z */
    public static String m2300z(int i) {
        char[] cArr = new char[9];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        for (int i2 = 0; i2 < 8; i2++) {
            cArr[8 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: a */
    public C0031e m2301a(C0985a c0985a, int i) throws C0000a {
        C0031e c0031eM2820b;
        new StringBuilder("*************************************id=").append(i);
        if (i != 1 || (c0031eM2820b = C1095bv.m2818a().m2820b()) == null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            C0031e[] c0031eArrM2230a = m2230a(c0985a, true);
            if (c0031eArrM2230a.length != 1) {
                throw new C0000a("Arsc files with zero or multiple packages");
            }
            c0031eM2820b = c0031eArrM2230a[0];
            if (c0031eM2820b.m55e() != i) {
                throw new C0000a("Expected pkg of id: " + String.valueOf(i) + ", got: " + c0031eM2820b.m55e());
            }
            c0985a.m2305a(c0031eM2820b, false);
            new StringBuilder("Loaded. Time=").append(System.currentTimeMillis() - jCurrentTimeMillis);
            C1095bv.m2818a().m2819a(c0031eM2820b);
        } else {
            c0985a.m2305a(c0031eM2820b, false);
        }
        return c0031eM2820b;
    }

    /* JADX INFO: renamed from: a */
    public C0032f m2302a(int i) {
        if ((i >> 24) == 0) {
            i |= 33554432;
        }
        return m2303a(new C0030d(i));
    }

    /* JADX INFO: renamed from: a */
    public C0032f m2303a(C0030d c0030d) {
        C0031e c0031eM2306b = m2306b(c0030d.f63a);
        if (c0031eM2306b != null) {
            return c0031eM2306b.m49b(c0030d);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public Set m2304a() {
        return this.f2478c;
    }

    /* JADX INFO: renamed from: a */
    public void m2305a(C0031e c0031e, boolean z) throws C0000a {
        Integer numValueOf = Integer.valueOf(c0031e.m55e());
        if (this.f2476a.containsKey(numValueOf)) {
            throw new C0000a("Multiple packages: id=" + numValueOf.toString());
        }
        String strM56f = c0031e.m56f();
        if (this.f2477b.containsKey(strM56f)) {
            throw new C0000a("Multiple packages: name=" + strM56f);
        }
        this.f2476a.put(numValueOf, c0031e);
        this.f2477b.put(strM56f, c0031e);
        if (z) {
            this.f2478c.add(c0031e);
        } else {
            this.f2479d.add(c0031e);
        }
    }

    /* JADX INFO: renamed from: b */
    public C0031e m2306b(int i) {
        C0031e c0031e = (C0031e) this.f2476a.get(Integer.valueOf(i));
        if (c0031e != null) {
            return c0031e;
        }
        if (this.f2476a.get(1) == null) {
            try {
                return m2301a(this, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
