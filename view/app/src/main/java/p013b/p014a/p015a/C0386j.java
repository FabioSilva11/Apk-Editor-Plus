package p013b.p014a.p015a;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: b.a.a.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0386j implements Closeable {

    /* JADX INFO: renamed from: a */
    private InterfaceC0388l f295a;

    /* JADX INFO: renamed from: b */
    private String f296b;

    /* JADX INFO: renamed from: c */
    private InputStream f297c;

    /* JADX INFO: renamed from: d */
    private long f298d;

    /* JADX INFO: renamed from: e */
    private final Map f299e = new HashMap();

    /* JADX INFO: renamed from: f */
    private EnumC0385i f300f;

    /* JADX INFO: renamed from: g */
    private boolean f301g;

    /* JADX INFO: renamed from: h */
    private boolean f302h;

    /* JADX INFO: renamed from: i */
    private boolean f303i;

    protected C0386j(InterfaceC0388l interfaceC0388l, String str, InputStream inputStream, long j) {
        this.f295a = interfaceC0388l;
        this.f296b = str;
        if (inputStream == null) {
            this.f297c = new ByteArrayInputStream(new byte[0]);
            this.f298d = 0L;
        } else {
            this.f297c = inputStream;
            this.f298d = j;
        }
        this.f301g = this.f298d < 0;
        this.f303i = true;
    }

    /* JADX INFO: renamed from: a */
    private static long m281a(PrintWriter printWriter, Map map, long j) {
        for (String str : map.keySet()) {
            if (str.equalsIgnoreCase("content-length")) {
                try {
                    return Long.parseLong((String) map.get(str));
                } catch (NumberFormatException e) {
                    return j;
                }
            }
        }
        printWriter.print("Content-Length: " + j + "\r\n");
        return j;
    }

    /* JADX INFO: renamed from: a */
    private void m282a(OutputStream outputStream, long j) throws IOException {
        if (!this.f302h) {
            m284b(outputStream, j);
            return;
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        m284b(gZIPOutputStream, -1L);
        gZIPOutputStream.finish();
    }

    /* JADX INFO: renamed from: a */
    private static boolean m283a(Map map, String str) {
        boolean zEqualsIgnoreCase = false;
        Iterator it = map.keySet().iterator();
        while (true) {
            boolean z = zEqualsIgnoreCase;
            if (!it.hasNext()) {
                return z;
            }
            zEqualsIgnoreCase = ((String) it.next()).equalsIgnoreCase(str) | z;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m284b(OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[16384];
        boolean z = j == -1;
        long j2 = j;
        while (true) {
            if (j2 <= 0 && !z) {
                return;
            }
            int i = this.f297c.read(bArr, 0, (int) (z ? 16384L : Math.min(j2, PlaybackStateCompat.ACTION_PREPARE)));
            if (i <= 0) {
                return;
            }
            outputStream.write(bArr, 0, i);
            j2 = !z ? j2 - ((long) i) : j2;
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m285a() {
        return this.f296b;
    }

    /* JADX INFO: renamed from: a */
    public final String m286a(String str) {
        for (String str2 : this.f299e.keySet()) {
            if (str2.equalsIgnoreCase(str)) {
                return (String) this.f299e.get(str2);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final void m287a(EnumC0385i enumC0385i) {
        this.f300f = enumC0385i;
    }

    /* JADX INFO: renamed from: a */
    protected final void m288a(OutputStream outputStream) {
        String str = this.f296b;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            if (this.f295a == null) {
                throw new Error("sendResponse(): Status can't be null.");
            }
            PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8")), false);
            printWriter.print("HTTP/1.1 " + this.f295a.mo293a() + " \r\n");
            if (str != null) {
                printWriter.print("Content-Type: " + str + "\r\n");
            }
            if (this.f299e.get("Date") == null) {
                printWriter.print("Date: " + simpleDateFormat.format(new Date()) + "\r\n");
            }
            for (String str2 : this.f299e.keySet()) {
                printWriter.print(str2 + ": " + ((String) this.f299e.get(str2)) + "\r\n");
            }
            if (!m283a(this.f299e, "connection")) {
                printWriter.print("Connection: " + (this.f303i ? "keep-alive" : "close") + "\r\n");
            }
            if (m283a(this.f299e, "content-length")) {
                this.f302h = false;
            }
            if (this.f302h) {
                printWriter.print("Content-Encoding: gzip\r\n");
                this.f301g = true;
            }
            long jM281a = this.f297c != null ? this.f298d : 0L;
            if (this.f300f != EnumC0385i.HEAD && this.f301g) {
                printWriter.print("Transfer-Encoding: chunked\r\n");
            } else if (!this.f302h) {
                jM281a = m281a(printWriter, this.f299e, jM281a);
            }
            printWriter.print("\r\n");
            printWriter.flush();
            if (this.f300f == EnumC0385i.HEAD || !this.f301g) {
                m282a(outputStream, jM281a);
            } else {
                C0387k c0387k = new C0387k(outputStream);
                m282a(c0387k, -1L);
                c0387k.m292a();
            }
            outputStream.flush();
            AbstractC0377a.m245b(this.f297c);
        } catch (IOException e) {
            AbstractC0377a.f253g.log(Level.SEVERE, "Could not send response to the client", (Throwable) e);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m289a(String str, String str2) {
        this.f299e.put(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public final void m290a(boolean z) {
        this.f302h = z;
    }

    /* JADX INFO: renamed from: b */
    public final void m291b(boolean z) {
        this.f303i = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f297c != null) {
            this.f297c.close();
        }
    }
}
