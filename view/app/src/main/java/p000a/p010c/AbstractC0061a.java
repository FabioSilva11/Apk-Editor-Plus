package p000a.p010c;

import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: a.c.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0061a implements InterfaceC0064d {

    /* JADX INFO: renamed from: a */
    protected Set f173a;

    /* JADX INFO: renamed from: b */
    protected Map f174b;

    /* JADX INFO: renamed from: b */
    private Map m159b(boolean z) {
        if (this.f174b == null) {
            mo170b();
        }
        if (!z) {
            return this.f174b;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f174b);
        for (Map.Entry entry : m160c().entrySet()) {
            for (Map.Entry entry2 : ((AbstractC0061a) entry.getValue()).m159b(true).entrySet()) {
                linkedHashMap.put(((String) entry.getKey()) + '/' + ((String) entry2.getKey()), entry2.getValue());
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: c */
    private Map m160c() {
        return m159b(false);
    }

    /* JADX INFO: renamed from: j */
    private InterfaceC0064d m161j(String str) throws C0067g {
        C0062b c0062bM163l;
        AbstractC0061a abstractC0061aMo176h;
        while (true) {
            c0062bM163l = this.m163l(str);
            if (c0062bM163l.f175a == null) {
                break;
            }
            if (this.m159b(false).containsKey(c0062bM163l.f175a)) {
                abstractC0061aMo176h = (AbstractC0061a) this.m159b(false).get(c0062bM163l.f175a);
            } else {
                abstractC0061aMo176h = this.mo176h(c0062bM163l.f175a);
                this.m159b(false).put(c0062bM163l.f175a, abstractC0061aMo176h);
            }
            this = abstractC0061aMo176h;
            str = c0062bM163l.f176b;
        }
        if (this.m159b(false).containsKey(c0062bM163l.f176b)) {
            throw new C0067g(str);
        }
        AbstractC0061a abstractC0061aMo176h2 = this.mo176h(c0062bM163l.f176b);
        this.m159b(false).put(c0062bM163l.f176b, abstractC0061aMo176h2);
        return abstractC0061aMo176h2;
    }

    /* JADX INFO: renamed from: k */
    private C0063c m162k(String str) throws C0068h {
        C0062b c0062bM163l = m163l(str);
        if (c0062bM163l.f175a == null) {
            return new C0063c(this, null, c0062bM163l.f176b);
        }
        if (m159b(false).containsKey(c0062bM163l.f175a)) {
            return new C0063c(this, (AbstractC0061a) m160c().get(c0062bM163l.f175a), c0062bM163l.f176b);
        }
        throw new C0068h(str);
    }

    /* JADX INFO: renamed from: l */
    private C0062b m163l(String str) {
        int iIndexOf = str.indexOf(47);
        return iIndexOf == -1 ? new C0062b(this, null, str) : new C0062b(this, str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
    }

    @Override // p000a.p010c.InterfaceC0064d
    /* JADX INFO: renamed from: a */
    public final Set mo164a(boolean z) {
        if (this.f173a == null) {
            mo165a();
        }
        if (!z) {
            return this.f173a;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.f173a);
        for (Map.Entry entry : m160c().entrySet()) {
            Iterator it = ((InterfaceC0064d) entry.getValue()).mo164a(true).iterator();
            while (it.hasNext()) {
                linkedHashSet.add(((String) entry.getKey()) + '/' + ((String) it.next()));
            }
        }
        return linkedHashSet;
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo165a();

    @Override // p000a.p010c.InterfaceC0064d
    /* JADX INFO: renamed from: a */
    public final void mo166a(File file) throws C0065e {
        Iterator it = mo164a(true).iterator();
        while (it.hasNext()) {
            C0985a.m2202a(this, file, (String) it.next());
        }
    }

    @Override // p000a.p010c.InterfaceC0064d
    /* JADX INFO: renamed from: a */
    public final void mo167a(File file, String str) throws C0065e {
        C0985a.m2202a(this, file, str);
    }

    @Override // p000a.p010c.InterfaceC0064d
    /* JADX INFO: renamed from: a */
    public final boolean mo168a(String str) {
        while (true) {
            try {
                C0063c c0063cM162k = this.m162k(str);
                if (c0063cM162k.f177a == null) {
                    return this.m159b(false).containsKey(c0063cM162k.f178b);
                }
                this = c0063cM162k.f177a;
                str = c0063cM162k.f178b;
            } catch (C0068h e) {
                return false;
            }
        }
    }

    @Override // p000a.p010c.InterfaceC0064d
    /* JADX INFO: renamed from: b */
    public final InputStream mo169b(String str) throws C0068h {
        C0063c c0063cM162k;
        while (true) {
            c0063cM162k = this.m162k(str);
            if (c0063cM162k.f177a == null) {
                break;
            }
            this = c0063cM162k.f177a;
            str = c0063cM162k.f178b;
        }
        if (this.mo164a(false).contains(c0063cM162k.f178b)) {
            return this.mo174f(c0063cM162k.f178b);
        }
        throw new C0068h(str);
    }

    /* JADX INFO: renamed from: b */
    protected abstract void mo170b();

    @Override // p000a.p010c.InterfaceC0064d
    /* JADX INFO: renamed from: c */
    public final OutputStream mo171c(String str) {
        InterfaceC0064d interfaceC0064dM161j;
        C0062b c0062bM163l = m163l(str);
        if (c0062bM163l.f175a == null) {
            mo164a(false).add(c0062bM163l.f176b);
            return mo175g(c0062bM163l.f176b);
        }
        try {
            interfaceC0064dM161j = m161j(c0062bM163l.f175a);
        } catch (C0067g e) {
            interfaceC0064dM161j = (InterfaceC0064d) m159b(false).get(c0062bM163l.f175a);
        }
        return interfaceC0064dM161j.mo171c(c0062bM163l.f176b);
    }

    @Override // p000a.p010c.InterfaceC0064d
    /* JADX INFO: renamed from: d */
    public final InterfaceC0064d mo172d(String str) throws C0068h {
        C0063c c0063cM162k;
        while (true) {
            c0063cM162k = this.m162k(str);
            if (c0063cM162k.f177a == null) {
                break;
            }
            this = c0063cM162k.f177a;
            str = c0063cM162k.f178b;
        }
        if (this.m159b(false).containsKey(c0063cM162k.f178b)) {
            return (InterfaceC0064d) this.m159b(false).get(c0063cM162k.f178b);
        }
        throw new C0068h(str);
    }

    @Override // p000a.p010c.InterfaceC0064d
    /* JADX INFO: renamed from: e */
    public final boolean mo173e(String str) {
        C0063c c0063cM162k;
        while (true) {
            try {
                c0063cM162k = this.m162k(str);
                if (c0063cM162k.f177a == null) {
                    break;
                }
                this = c0063cM162k.f177a;
                str = c0063cM162k.f178b;
            } catch (C0068h e) {
                return false;
            }
        }
        if (!this.mo164a(false).contains(c0063cM162k.f178b)) {
            return false;
        }
        this.mo177i(c0063cM162k.f178b);
        this.mo164a(false).remove(c0063cM162k.f178b);
        return true;
    }

    /* JADX INFO: renamed from: f */
    protected abstract InputStream mo174f(String str);

    /* JADX INFO: renamed from: g */
    protected abstract OutputStream mo175g(String str);

    /* JADX INFO: renamed from: h */
    protected abstract AbstractC0061a mo176h(String str);

    /* JADX INFO: renamed from: i */
    protected abstract void mo177i(String str);
}
