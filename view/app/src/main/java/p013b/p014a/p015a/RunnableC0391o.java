package p013b.p014a.p015a;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;

/* JADX INFO: renamed from: b.a.a.o */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0391o implements Runnable {

    /* JADX INFO: renamed from: a */
    private final int f327a;

    /* JADX INFO: renamed from: b */
    private IOException f328b;

    /* JADX INFO: renamed from: c */
    private boolean f329c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ AbstractC0377a f330d;

    private RunnableC0391o(AbstractC0377a abstractC0377a, int i) {
        this.f330d = abstractC0377a;
        this.f329c = false;
        this.f327a = i;
    }

    /* synthetic */ RunnableC0391o(AbstractC0377a abstractC0377a, int i, byte b2) {
        this(abstractC0377a, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f330d.f257j.bind(this.f330d.f255h != null ? new InetSocketAddress(this.f330d.f255h, this.f330d.f256i) : new InetSocketAddress(this.f330d.f256i));
            this.f329c = true;
            do {
                try {
                    Socket socketAccept = this.f330d.f257j.accept();
                    if (this.f327a > 0) {
                        socketAccept.setSoTimeout(this.f327a);
                    }
                    this.f330d.f254a.m261b(new RunnableC0379c(this.f330d, socketAccept.getInputStream(), socketAccept, (byte) 0));
                } catch (IOException e) {
                    AbstractC0377a.f253g.log(Level.FINE, "Communication with the client broken", (Throwable) e);
                }
            } while (!this.f330d.f257j.isClosed());
        } catch (IOException e2) {
            this.f328b = e2;
        }
    }
}
