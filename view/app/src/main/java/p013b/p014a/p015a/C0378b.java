package p013b.p014a.p015a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: b.a.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0378b {

    /* JADX INFO: renamed from: a */
    private long f261a;

    /* JADX INFO: renamed from: b */
    private final List f262b = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: a */
    public void m259a() {
        Iterator it = new ArrayList(this.f262b).iterator();
        while (it.hasNext()) {
            ((RunnableC0379c) it.next()).m262a();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m260a(RunnableC0379c runnableC0379c) {
        this.f262b.remove(runnableC0379c);
    }

    /* JADX INFO: renamed from: b */
    public void m261b(RunnableC0379c runnableC0379c) {
        this.f261a++;
        Thread thread = new Thread(runnableC0379c);
        thread.setDaemon(true);
        thread.setName("NanoHttpd Request Processor (#" + this.f261a + ")");
        this.f262b.add(runnableC0379c);
        thread.start();
    }
}
