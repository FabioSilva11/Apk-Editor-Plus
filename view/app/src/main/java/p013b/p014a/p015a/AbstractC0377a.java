package p013b.p014a.p015a;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.a.a.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0377a {

    /* JADX INFO: renamed from: b */
    private static final Pattern f248b = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;]*)['|\"]?", 2);

    /* JADX INFO: renamed from: c */
    private static final Pattern f249c = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;]*)['|\"]?", 2);

    /* JADX INFO: renamed from: d */
    private static final Pattern f250d = Pattern.compile("([ |\t]*Content-Disposition[ |\t]*:)(.*)", 2);

    /* JADX INFO: renamed from: e */
    private static final Pattern f251e = Pattern.compile("([ |\t]*content-type[ |\t]*:)(.*)", 2);

    /* JADX INFO: renamed from: f */
    private static final Pattern f252f = Pattern.compile("[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]");

    /* JADX INFO: renamed from: g */
    private static final Logger f253g = Logger.getLogger(AbstractC0377a.class.getName());

    /* JADX INFO: renamed from: a */
    protected C0378b f254a;

    /* JADX INFO: renamed from: h */
    private final String f255h;

    /* JADX INFO: renamed from: i */
    private final int f256i;

    /* JADX INFO: renamed from: j */
    private volatile ServerSocket f257j;

    /* JADX INFO: renamed from: k */
    private C0392p f258k;

    /* JADX INFO: renamed from: l */
    private Thread f259l;

    /* JADX INFO: renamed from: m */
    private InterfaceC0395s f260m;

    public AbstractC0377a(int i) {
        this(null, 8000);
    }

    private AbstractC0377a(String str, int i) {
        this.f258k = new C0392p();
        this.f255h = null;
        this.f256i = i;
        this.f260m = new C0382f(this, (byte) 0);
        this.f254a = new C0378b();
    }

    /* JADX INFO: renamed from: a */
    public static C0386j m238a(InterfaceC0388l interfaceC0388l, String str, InputStream inputStream, long j) {
        return new C0386j(interfaceC0388l, str, inputStream, j);
    }

    /* JADX INFO: renamed from: a */
    public static C0386j m239a(InterfaceC0388l interfaceC0388l, String str, String str2) {
        byte[] bytes;
        if (str2 == null) {
            return m238a(interfaceC0388l, str, new ByteArrayInputStream(new byte[0]), 0L);
        }
        try {
            bytes = str2.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            f253g.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e);
            bytes = new byte[0];
        }
        return m238a(interfaceC0388l, str, new ByteArrayInputStream(bytes), bytes.length);
    }

    /* JADX INFO: renamed from: a */
    protected static boolean m242a(C0386j c0386j) {
        return c0386j.m285a() != null && c0386j.m285a().toLowerCase().contains("text/");
    }

    /* JADX INFO: renamed from: b */
    protected static String m244b(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e) {
            f253g.log(Level.WARNING, "Encoding not supported, ignored", (Throwable) e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static final void m245b(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else {
                    if (!(obj instanceof ServerSocket)) {
                        throw new IllegalArgumentException("Unknown object to close");
                    }
                    ((ServerSocket) obj).close();
                }
            } catch (IOException e) {
                f253g.log(Level.SEVERE, "Could not close", (Throwable) e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public C0386j mo254a(InterfaceC0384h interfaceC0384h) {
        HashMap map = new HashMap();
        EnumC0385i enumC0385iMo276b = interfaceC0384h.mo276b();
        if (EnumC0385i.PUT.equals(enumC0385iMo276b) || EnumC0385i.POST.equals(enumC0385iMo276b)) {
            try {
                interfaceC0384h.mo275a(map);
            } catch (C0390n e) {
                return m239a(e.m294a(), "text/plain", e.getMessage());
            } catch (IOException e2) {
                return m239a(EnumC0389m.f307d, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e2.getMessage());
            }
        }
        interfaceC0384h.mo277c().put("NanoHttpd.QUERY_STRING", interfaceC0384h.mo278d());
        return m239a(EnumC0389m.f306c, "text/plain", "Not Found");
    }

    /* JADX INFO: renamed from: a */
    public final void m255a(int i, boolean z) throws IOException {
        this.f257j = this.f258k.m297a();
        this.f257j.setReuseAddress(true);
        RunnableC0391o runnableC0391o = new RunnableC0391o(this, i, (byte) 0);
        this.f259l = new Thread(runnableC0391o);
        this.f259l.setDaemon(true);
        this.f259l.setName("NanoHttpd Main Listener");
        this.f259l.start();
        while (!runnableC0391o.f329c && runnableC0391o.f328b == null) {
            try {
                Thread.sleep(10L);
            } catch (Throwable th) {
            }
        }
        if (runnableC0391o.f328b != null) {
            throw runnableC0391o.f328b;
        }
    }

    /* JADX INFO: renamed from: c */
    public final int m256c() {
        if (this.f257j == null) {
            return -1;
        }
        return this.f257j.getLocalPort();
    }

    /* JADX INFO: renamed from: d */
    public final boolean m257d() {
        return (this.f257j != null && this.f259l != null) && !this.f257j.isClosed() && this.f259l.isAlive();
    }

    /* JADX INFO: renamed from: e */
    public final void m258e() {
        try {
            m245b(this.f257j);
            this.f254a.m259a();
            if (this.f259l != null) {
                this.f259l.join();
            }
        } catch (Exception e) {
            f253g.log(Level.SEVERE, "Could not stop all connections", (Throwable) e);
        }
    }
}
