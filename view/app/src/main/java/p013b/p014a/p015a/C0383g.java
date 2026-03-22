package p013b.p014a.p015a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.gmail.heagoo.apkeditor.gzd;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.a.a.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0383g implements InterfaceC0384h {

    /* JADX INFO: renamed from: a */
    private final C0394r f271a;

    /* JADX INFO: renamed from: b */
    private final OutputStream f272b;

    /* JADX INFO: renamed from: c */
    private final BufferedInputStream f273c;

    /* JADX INFO: renamed from: d */
    private int f274d;

    /* JADX INFO: renamed from: e */
    private int f275e;

    /* JADX INFO: renamed from: f */
    private String f276f;

    /* JADX INFO: renamed from: g */
    private EnumC0385i f277g;

    /* JADX INFO: renamed from: h */
    private Map f278h;

    /* JADX INFO: renamed from: i */
    private Map f279i;

    /* JADX INFO: renamed from: j */
    private C0381e f280j;

    /* JADX INFO: renamed from: k */
    private String f281k;

    /* JADX INFO: renamed from: l */
    private String f282l;

    /* JADX INFO: renamed from: m */
    private String f283m;

    /* JADX INFO: renamed from: n */
    private /* synthetic */ AbstractC0377a f284n;

    public C0383g(AbstractC0377a abstractC0377a, C0394r c0394r, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
        this.f284n = abstractC0377a;
        this.f271a = c0394r;
        this.f273c = new BufferedInputStream(inputStream, 8192);
        this.f272b = outputStream;
        this.f282l = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
        this.f279i = new HashMap();
    }

    /* JADX INFO: renamed from: a */
    private static int m266a(byte[] bArr, int i) {
        while (bArr[i] != 10) {
            i++;
        }
        return i + 1;
    }

    /* JADX INFO: renamed from: a */
    private static String m267a(String str, Pattern pattern, String str2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(2) : str2;
    }

    /* JADX INFO: renamed from: a */
    private String m268a(ByteBuffer byteBuffer, int i, int i2, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        C0393q c0393qM301b;
        ByteBuffer byteBufferDuplicate;
        String strM299b = "";
        if (i2 > 0) {
            try {
                c0393qM301b = this.f271a.m301b();
                byteBufferDuplicate = byteBuffer.duplicate();
                fileOutputStream = new FileOutputStream(c0393qM301b.m299b());
            } catch (Exception e) {
                e = e;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                AbstractC0377a.m245b(fileOutputStream);
                throw th;
            }
            try {
                try {
                    FileChannel channel = fileOutputStream.getChannel();
                    byteBufferDuplicate.position(i).limit(i + i2);
                    channel.write(byteBufferDuplicate.slice());
                    strM299b = c0393qM301b.m299b();
                    AbstractC0377a.m245b(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    AbstractC0377a.m245b(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                throw new Error(e);
            }
        }
        return strM299b;
    }

    /* JADX INFO: renamed from: a */
    private void m269a(BufferedReader bufferedReader, Map map, Map map2, Map map3) throws C0390n {
        String strM244b;
        try {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            if (!stringTokenizer.hasMoreTokens()) {
                throw new C0390n(EnumC0389m.f305b, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            }
            map.put("method", stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()) {
                throw new C0390n(EnumC0389m.f305b, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
            }
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf(63);
            if (iIndexOf >= 0) {
                m271a(strNextToken.substring(iIndexOf + 1), map2);
                strM244b = AbstractC0377a.m244b(strNextToken.substring(0, iIndexOf));
            } else {
                strM244b = AbstractC0377a.m244b(strNextToken);
            }
            if (stringTokenizer.hasMoreTokens()) {
                this.f283m = stringTokenizer.nextToken();
            } else {
                this.f283m = "HTTP/1.1";
                AbstractC0377a.f253g.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
            }
            String line2 = bufferedReader.readLine();
            while (line2 != null && line2.trim().length() > 0) {
                int iIndexOf2 = line2.indexOf(58);
                if (iIndexOf2 >= 0) {
                    map3.put(line2.substring(0, iIndexOf2).trim().toLowerCase(Locale.US), line2.substring(iIndexOf2 + 1).trim());
                }
                line2 = bufferedReader.readLine();
            }
            map.put("uri", strM244b);
        } catch (IOException e) {
            throw new C0390n(EnumC0389m.f307d, "SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m270a(String str, String str2, ByteBuffer byteBuffer, Map map, Map map2) throws Throwable {
        int[] iArr;
        int[] iArr2;
        String strGroup;
        String strGroup2;
        try {
            byte[] bytes = str.getBytes();
            int[] iArr3 = new int[0];
            if (byteBuffer.remaining() < bytes.length) {
                iArr = iArr3;
            } else {
                int i = 0;
                byte[] bArr = new byte[bytes.length + 4096];
                int iRemaining = byteBuffer.remaining() < bArr.length ? byteBuffer.remaining() : bArr.length;
                byteBuffer.get(bArr, 0, iRemaining);
                int length = iRemaining - bytes.length;
                do {
                    int i2 = 0;
                    while (i2 < length) {
                        int i3 = 0;
                        int[] iArr4 = iArr3;
                        while (i3 < bytes.length && bArr[i2 + i3] == bytes[i3]) {
                            if (i3 == bytes.length - 1) {
                                iArr2 = new int[iArr4.length + 1];
                                System.arraycopy(iArr4, 0, iArr2, 0, iArr4.length);
                                iArr2[iArr4.length] = i + i2;
                            } else {
                                iArr2 = iArr4;
                            }
                            i3++;
                            iArr4 = iArr2;
                        }
                        i2++;
                        iArr3 = iArr4;
                    }
                    i += length;
                    System.arraycopy(bArr, bArr.length - bytes.length, bArr, 0, bytes.length);
                    length = bArr.length - bytes.length;
                    if (byteBuffer.remaining() < length) {
                        length = byteBuffer.remaining();
                    }
                    byteBuffer.get(bArr, bytes.length, length);
                } while (length > 0);
                iArr = iArr3;
            }
            if (iArr.length < 2) {
                throw new C0390n(EnumC0389m.f305b, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
            }
            byte[] bArr2 = new byte[1024];
            for (int i4 = 0; i4 < iArr.length - 1; i4++) {
                byteBuffer.position(iArr[i4]);
                int iRemaining2 = byteBuffer.remaining() < 1024 ? byteBuffer.remaining() : 1024;
                byteBuffer.get(bArr2, 0, iRemaining2);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr2, 0, iRemaining2), Charset.forName(str2)), iRemaining2);
                if (!bufferedReader.readLine().contains(str)) {
                    throw new C0390n(EnumC0389m.f305b, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                }
                String str3 = null;
                String str4 = null;
                String strTrim = null;
                String line = bufferedReader.readLine();
                int i5 = 2;
                while (line != null && line.trim().length() > 0) {
                    Matcher matcher = AbstractC0377a.f250d.matcher(line);
                    if (matcher.matches()) {
                        Matcher matcher2 = AbstractC0377a.f252f.matcher(matcher.group(2));
                        strGroup = str4;
                        strGroup2 = str3;
                        while (matcher2.find()) {
                            String strGroup3 = matcher2.group(1);
                            if (strGroup3.equalsIgnoreCase("name")) {
                                strGroup2 = matcher2.group(2);
                            } else if (strGroup3.equalsIgnoreCase("filename")) {
                                strGroup = matcher2.group(2);
                            }
                        }
                    } else {
                        strGroup = str4;
                        strGroup2 = str3;
                    }
                    Matcher matcher3 = AbstractC0377a.f251e.matcher(line);
                    i5++;
                    strTrim = matcher3.matches() ? matcher3.group(2).trim() : strTrim;
                    line = bufferedReader.readLine();
                    str3 = strGroup2;
                    str4 = strGroup;
                }
                int iM266a = 0;
                while (true) {
                    int i6 = i5 - 1;
                    if (i5 <= 0) {
                        break;
                    }
                    iM266a = m266a(bArr2, iM266a);
                    i5 = i6;
                }
                if (iM266a >= iRemaining2 - 4) {
                    throw new C0390n(EnumC0389m.f307d, "Multipart header size exceeds MAX_HEADER_SIZE.");
                }
                int i7 = iM266a + iArr[i4];
                int i8 = iArr[i4 + 1] - 4;
                byteBuffer.position(i7);
                if (strTrim == null) {
                    byte[] bArr3 = new byte[i8 - i7];
                    byteBuffer.get(bArr3);
                    map.put(str3, new String(bArr3, str2));
                } else {
                    String strM268a = m268a(byteBuffer, i7, i8 - i7, str4);
                    if (map2.containsKey(str3)) {
                        int i9 = 2;
                        while (map2.containsKey(str3 + i9)) {
                            i9++;
                        }
                        map2.put(str3 + i9, strM268a);
                    } else {
                        map2.put(str3, strM268a);
                    }
                    map.put(str3, str4);
                }
            }
        } catch (C0390n e) {
            throw e;
        } catch (Exception e2) {
            throw new C0390n(EnumC0389m.f307d, e2.toString());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m271a(String str, Map map) {
        if (str == null) {
            this.f281k = "";
            return;
        }
        this.f281k = str;
        StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf(61);
            if (iIndexOf >= 0) {
                map.put(AbstractC0377a.m244b(strNextToken.substring(0, iIndexOf)).trim(), AbstractC0377a.m244b(strNextToken.substring(iIndexOf + 1)));
            } else {
                map.put(AbstractC0377a.m244b(strNextToken).trim(), "");
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static int m272b(byte[] bArr, int i) {
        for (int i2 = 0; i2 + 1 < i; i2++) {
            if (bArr[i2] == 13 && bArr[i2 + 1] == 10 && i2 + 3 < i && bArr[i2 + 2] == 13 && bArr[i2 + 3] == 10) {
                return i2 + 4;
            }
            if (bArr[i2] == 10 && bArr[i2 + 1] == 10) {
                return i2 + 2;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: f */
    private RandomAccessFile m273f() {
        try {
            return new RandomAccessFile(this.f271a.m301b().m299b(), "rw");
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m274a() {
        try {
            try {
                try {
                    try {
                        byte[] bArr = new byte[8192];
                        this.f274d = 0;
                        this.f275e = 0;
                        this.f273c.mark(8192);
                        try {
                            int i = this.f273c.read(bArr, 0, 8192);
                            if (i == -1) {
                                AbstractC0377a.m245b(this.f273c);
                                AbstractC0377a.m245b(this.f272b);
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            while (i > 0) {
                                this.f275e = i + this.f275e;
                                this.f274d = m272b(bArr, this.f275e);
                                if (this.f274d > 0) {
                                    break;
                                } else {
                                    i = this.f273c.read(bArr, this.f275e, 8192 - this.f275e);
                                }
                            }
                            if (this.f274d < this.f275e) {
                                this.f273c.reset();
                                this.f273c.skip(this.f274d);
                            }
                            this.f278h = new HashMap();
                            if (this.f279i == null) {
                                this.f279i = new HashMap();
                            } else {
                                this.f279i.clear();
                            }
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.f275e)));
                            HashMap map = new HashMap();
                            m269a(bufferedReader, map, this.f278h, this.f279i);
                            if (this.f282l != null) {
                                this.f279i.put("remote-addr", this.f282l);
                                this.f279i.put("http-client-ip", this.f282l);
                            }
                            this.f277g = EnumC0385i.m280a((String) map.get("method"));
                            if (this.f277g == null) {
                                throw new C0390n(EnumC0389m.f305b, "BAD REQUEST: Syntax error.");
                            }
                            this.f276f = (String) map.get("uri");
                            this.f280j = new C0381e(this.f284n, this.f279i);
                            String str = (String) this.f279i.get("connection");
                            boolean z = this.f283m.equals("HTTP/1.1") && (str == null || !str.matches("(?i).*close.*"));
                            C0386j c0386jMo254a = this.f284n.mo254a((InterfaceC0384h) this);
                            if (c0386jMo254a == null) {
                                throw new C0390n(EnumC0389m.f307d, "SERVER INTERNAL ERROR: Serve() returned a null response.");
                            }
                            String str2 = (String) this.f279i.get("accept-encoding");
                            this.f280j.m264a(c0386jMo254a);
                            c0386jMo254a.m287a(this.f277g);
                            c0386jMo254a.m290a(AbstractC0377a.m242a(c0386jMo254a) && str2 != null && str2.contains("gzip"));
                            c0386jMo254a.m291b(z);
                            c0386jMo254a.m288a(this.f272b);
                            if (!z || "close".equalsIgnoreCase(c0386jMo254a.m286a("connection"))) {
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            AbstractC0377a.m245b(c0386jMo254a);
                            this.f271a.m300a();
                        } catch (Exception e) {
                            AbstractC0377a.m245b(this.f273c);
                            AbstractC0377a.m245b(this.f272b);
                            throw new SocketException("NanoHttpd Shutdown");
                        }
                    } catch (C0390n e2) {
                        AbstractC0377a.m239a(e2.m294a(), "text/plain", e2.getMessage()).m288a(this.f272b);
                        AbstractC0377a.m245b(this.f272b);
                        AbstractC0377a.m245b((Object) null);
                        this.f271a.m300a();
                    } catch (IOException e3) {
                        AbstractC0377a.m239a(EnumC0389m.f307d, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e3.getMessage()).m288a(this.f272b);
                        AbstractC0377a.m245b(this.f272b);
                        AbstractC0377a.m245b((Object) null);
                        this.f271a.m300a();
                    }
                } catch (SocketException e4) {
                    throw e4;
                }
            } catch (SocketTimeoutException e5) {
                throw e5;
            }
        } catch (Throwable th) {
            AbstractC0377a.m245b((Object) null);
            this.f271a.m300a();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013b.p014a.p015a.InterfaceC0384h
    /* JADX INFO: renamed from: a */
    public final void mo275a(Map map) throws Throwable {
        Object obj;
        long j;
        DataOutput dataOutputM273f;
        ByteArrayOutputStream byteArrayOutputStream;
        RandomAccessFile randomAccessFile;
        ByteBuffer map2;
        StringTokenizer stringTokenizer = null;
        try {
            j = this.f279i.containsKey("content-length") ? Long.parseLong((String) this.f279i.get("content-length")) : this.f274d < this.f275e ? this.f275e - this.f274d : 0L;
            if (j < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                dataOutputM273f = new DataOutputStream(byteArrayOutputStream);
                randomAccessFile = 0;
            } else {
                dataOutputM273f = m273f();
                byteArrayOutputStream = null;
                randomAccessFile = dataOutputM273f;
            }
        } catch (Throwable th) {
            th = th;
            obj = null;
        }
        try {
            byte[] bArr = new byte[512];
            while (this.f275e >= 0 && j > 0) {
                this.f275e = this.f273c.read(bArr, 0, (int) Math.min(j, 512L));
                j -= (long) this.f275e;
                if (this.f275e > 0) {
                    dataOutputM273f.write(bArr, 0, this.f275e);
                }
            }
            if (byteArrayOutputStream != null) {
                map2 = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            } else {
                map2 = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, randomAccessFile.length());
                randomAccessFile.seek(0L);
            }
            if (EnumC0385i.POST.equals(this.f277g)) {
                String strNextToken = "";
                String str = (String) this.f279i.get("content-type");
                if (str != null) {
                    stringTokenizer = new StringTokenizer(str, ",; ");
                    if (stringTokenizer.hasMoreTokens()) {
                        strNextToken = stringTokenizer.nextToken();
                    }
                }
                if (!"multipart/form-data".equalsIgnoreCase(strNextToken)) {
                    byte[] bArr2 = new byte[map2.remaining()];
                    map2.get(bArr2);
                    String strTrim = new String(bArr2).trim();
                    if ("application/x-www-form-urlencoded".equalsIgnoreCase(strNextToken)) {
                        m271a(strTrim, this.f278h);
                    } else if (strTrim.length() != 0) {
                        map.put("postData", strTrim);
                    }
                } else {
                    if (!stringTokenizer.hasMoreTokens()) {
                        throw new C0390n(EnumC0389m.f305b, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                    }
                    m270a(m267a(str, AbstractC0377a.f249c, null), m267a(str, AbstractC0377a.f248b, "US-ASCII"), map2, this.f278h, map);
                }
            } else if (EnumC0385i.PUT.equals(this.f277g)) {
                map.put(gzd.COLUMN_CONTENT, m268a(map2, 0, map2.limit(), (String) null));
            }
            AbstractC0377a.m245b(randomAccessFile);
        } catch (Throwable th2) {
            th = th2;
            obj = randomAccessFile;
            AbstractC0377a.m245b(obj);
            throw th;
        }
    }

    @Override // p013b.p014a.p015a.InterfaceC0384h
    /* JADX INFO: renamed from: b */
    public final EnumC0385i mo276b() {
        return this.f277g;
    }

    @Override // p013b.p014a.p015a.InterfaceC0384h
    /* JADX INFO: renamed from: c */
    public final Map mo277c() {
        return this.f278h;
    }

    @Override // p013b.p014a.p015a.InterfaceC0384h
    /* JADX INFO: renamed from: d */
    public final String mo278d() {
        return this.f281k;
    }

    @Override // p013b.p014a.p015a.InterfaceC0384h
    /* JADX INFO: renamed from: e */
    public final String mo279e() {
        return this.f276f;
    }
}
