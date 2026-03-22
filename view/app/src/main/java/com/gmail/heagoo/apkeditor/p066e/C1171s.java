package com.gmail.heagoo.apkeditor.p066e;

import android.util.SparseIntArray;
import com.gmail.heagoo.apkeditor.ApkInfoActivity;
import com.gmail.heagoo.apkeditor.pro.R;
import com.gmail.heagoo.common.C1487s;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.e.s */
/* JADX INFO: loaded from: classes.dex */
final class C1171s extends AbstractC1159g {

    /* JADX INFO: renamed from: b */
    private String f3308b;

    /* JADX INFO: renamed from: c */
    private SparseIntArray f3309c;

    C1171s() {
    }

    /* JADX INFO: renamed from: a */
    private static int m2944a(Map map) {
        int iIntValue = 0;
        Iterator it = map.values().iterator();
        while (true) {
            int i = iIntValue;
            if (!it.hasNext()) {
                return i >> 16;
            }
            iIntValue = ((Integer) it.next()).intValue() & 16711680;
            if (iIntValue <= i) {
                iIntValue = i;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private SparseIntArray m2946a(List list, Map map) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return sparseIntArray;
            }
            C1153ad c1153ad = (C1153ad) list.get(i2);
            Integer num = (Integer) map.get(c1153ad.f3254a);
            if (num != null) {
                int iIntValue = num.intValue() + 1;
                sparseIntArray.put(c1153ad.f3256c, iIntValue);
                c1153ad.f3256c = iIntValue;
                map.put(c1153ad.f3254a, Integer.valueOf(iIntValue));
            } else {
                int iM2944a = ((m2944a(map) + 1) << 16) + 2130706432;
                sparseIntArray.put(c1153ad.f3256c, iM2944a);
                c1153ad.f3256c = iM2944a;
                map.put(c1153ad.f3254a, Integer.valueOf(iM2944a));
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    private static List m2947a(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return arrayList;
            }
            C1153ad c1153adM2894a = C1153ad.m2894a(line);
            if (c1153adM2894a != null) {
                arrayList.add(c1153adM2894a);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static Map m2948a(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            C1153ad c1153ad = (C1153ad) it.next();
            if ("drawable".equals(c1153ad.f3254a)) {
                if (c1153ad.f3256c > i3) {
                    i3 = c1153ad.f3256c;
                }
            } else if ("layout".equals(c1153ad.f3254a)) {
                if (c1153ad.f3256c > i2) {
                    i2 = c1153ad.f3256c;
                }
            } else if (!"string".equals(c1153ad.f3254a)) {
                Integer num = (Integer) map.get(c1153ad.f3254a);
                if (num == null || c1153ad.f3256c > num.intValue()) {
                    map.put(c1153ad.f3254a, Integer.valueOf(c1153ad.f3256c));
                }
            } else if (c1153ad.f3256c > i) {
                i = c1153ad.f3256c;
            }
        }
        map.put("drawable", Integer.valueOf(i3));
        map.put("layout", Integer.valueOf(i2));
        map.put("string", Integer.valueOf(i));
        return map;
    }

    /* JADX INFO: renamed from: a */
    private void m2950a(String str, List list) throws Throwable {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                m2951b(str, arrayList);
                return;
            } else {
                arrayList.add(((C1153ad) list.get(i2)).toString());
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m2951b(String str, List list) throws Throwable {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
            try {
                long length = randomAccessFile.length();
                if (length < 16) {
                    throw new Exception("File is too small!");
                }
                randomAccessFile.seek(length - 16);
                byte[] bArr = new byte[32];
                int i = randomAccessFile.read(bArr);
                int i2 = 0;
                while (i2 < i && (bArr[i2] != 60 || bArr[i2 + 1] != 47)) {
                    i2++;
                }
                randomAccessFile.seek(((long) i2) + (length - 16));
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    sb.append((String) list.get(i3));
                    sb.append("\n");
                }
                sb.append("</resources>");
                randomAccessFile.write(sb.toString().getBytes());
                m2919a(randomAccessFile);
            } catch (Throwable th) {
                th = th;
                m2919a(randomAccessFile);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final String mo2924a(ApkInfoActivity apkInfoActivity, ZipFile zipFile, InterfaceC1154b interfaceC1154b) throws Throwable {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        FileInputStream fileInputStream;
        InputStream inputStream3;
        ZipFile zipFile2;
        FileOutputStream fileOutputStream2 = null;
        ZipEntry entry = zipFile.getEntry(this.f3308b);
        if (entry == null) {
            interfaceC1154b.mo2900a(R.string.patch_error_no_entry, this.f3308b);
        } else {
            try {
                inputStream = zipFile.getInputStream(entry);
                try {
                    String str = C0985a.m2263d(apkInfoActivity, "tmp") + C1487s.m3525a(6);
                    fileOutputStream = new FileOutputStream(str);
                    try {
                        C0985a.m2244b(inputStream, fileOutputStream);
                        fileOutputStream.close();
                        String str2 = apkInfoActivity.m2460i() + "/res/values/public.xml";
                        try {
                            zipFile2 = new ZipFile(str);
                            try {
                                ZipEntry entry2 = zipFile2.getEntry("res/values/public.xml");
                                if (entry2 == null) {
                                    throw new Exception(interfaceC1154b.mo2896a(R.string.patch_error_publicxml_notfound));
                                }
                                inputStream3 = zipFile2.getInputStream(entry2);
                                try {
                                    List listM2947a = m2947a(inputStream3);
                                    fileInputStream = new FileInputStream(str2);
                                    try {
                                        this.f3309c = m2946a(listM2947a, m2948a(m2947a((InputStream) fileInputStream)));
                                        m2950a(str2, listM2947a);
                                        m2919a((Closeable) fileInputStream);
                                        m2919a((Closeable) inputStream3);
                                        m2920a(zipFile2);
                                        m2926a(apkInfoActivity, str, new C1172t(this, apkInfoActivity.m2460i()), interfaceC1154b);
                                        m2919a((Closeable) inputStream);
                                        m2919a((Closeable) null);
                                    } catch (Throwable th) {
                                        th = th;
                                        m2919a((Closeable) fileInputStream);
                                        m2919a((Closeable) inputStream3);
                                        m2920a(zipFile2);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = null;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream = null;
                                inputStream3 = null;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileInputStream = null;
                            inputStream3 = null;
                            zipFile2 = null;
                        }
                    } catch (Exception e) {
                        e = e;
                        inputStream2 = inputStream;
                        try {
                            interfaceC1154b.mo2900a(R.string.general_error, e.getMessage());
                            m2919a((Closeable) inputStream2);
                            m2919a(fileOutputStream);
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream2 = fileOutputStream;
                            inputStream = inputStream2;
                            m2919a((Closeable) inputStream);
                            m2919a(fileOutputStream2);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileOutputStream2 = fileOutputStream;
                        m2919a((Closeable) inputStream);
                        m2919a(fileOutputStream2);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                    inputStream2 = inputStream;
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                inputStream2 = null;
            } catch (Throwable th8) {
                th = th8;
                inputStream = null;
            }
        }
        return null;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final void mo2927a(C1155c c1155c, InterfaceC1154b interfaceC1154b) {
        this.f3267a = c1155c.m2908a();
        String line = c1155c.readLine();
        while (line != null) {
            String strTrim = line.trim();
            if ("[/MERGE]".equals(strTrim)) {
                return;
            }
            if (super.m2930a(strTrim, c1155c)) {
                line = c1155c.readLine();
            } else {
                if ("SOURCE:".equals(strTrim)) {
                    this.f3308b = c1155c.readLine().trim();
                } else {
                    interfaceC1154b.mo2900a(R.string.patch_error_cannot_parse, Integer.valueOf(c1155c.m2908a()), strTrim);
                }
                line = c1155c.readLine();
            }
        }
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2928a() {
        return true;
    }

    @Override // com.gmail.heagoo.apkeditor.p066e.AbstractC1159g
    /* JADX INFO: renamed from: a */
    public final boolean mo2929a(InterfaceC1154b interfaceC1154b) {
        if (this.f3308b != null) {
            return true;
        }
        interfaceC1154b.mo2900a(R.string.patch_error_no_source_file, new Object[0]);
        return false;
    }
}
