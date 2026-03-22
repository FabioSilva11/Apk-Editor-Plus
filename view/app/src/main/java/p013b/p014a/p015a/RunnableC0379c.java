package p013b.p014a.p015a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: renamed from: b.a.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0379c implements Runnable {

    /* JADX INFO: renamed from: a */
    private final InputStream f263a;

    /* JADX INFO: renamed from: b */
    private final Socket f264b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ AbstractC0377a f265c;

    private RunnableC0379c(AbstractC0377a abstractC0377a, InputStream inputStream, Socket socket) {
        this.f265c = abstractC0377a;
        this.f263a = inputStream;
        this.f264b = socket;
    }

    /* synthetic */ RunnableC0379c(AbstractC0377a abstractC0377a, InputStream inputStream, Socket socket, byte b2) {
        this(abstractC0377a, inputStream, socket);
    }

    /* JADX INFO: renamed from: a */
    public final void m262a() {
        AbstractC0377a.m245b(this.f263a);
        AbstractC0377a.m245b(this.f264b);
    }

    @Override // java.lang.Runnable
    public final void run() {
        OutputStream outputStream = null;
        try {
            outputStream = this.f264b.getOutputStream();
            C0383g c0383g = new C0383g(this.f265c, this.f265c.f260m.mo265a(), this.f263a, outputStream, this.f264b.getInetAddress());
            while (!this.f264b.isClosed()) {
                c0383g.m274a();
            }
        } catch (Exception e) {
            if ((!(e instanceof SocketException) || !"NanoHttpd Shutdown".equals(e.getMessage())) && !(e instanceof SocketTimeoutException)) {
                AbstractC0377a.f253g.log(Level.FINE, "Communication with the client broken", (Throwable) e);
            }
        } finally {
            AbstractC0377a.m245b(outputStream);
            AbstractC0377a.m245b(this.f263a);
            AbstractC0377a.m245b(this.f264b);
            this.f265c.f254a.m260a(this);
        }
    }
}
