package p000a.p010c;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

/* JADX INFO: renamed from: a.c.d */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0064d {
    /* JADX INFO: renamed from: a */
    Set mo164a(boolean z);

    /* JADX INFO: renamed from: a */
    void mo166a(File file);

    /* JADX INFO: renamed from: a */
    void mo167a(File file, String str);

    /* JADX INFO: renamed from: a */
    boolean mo168a(String str);

    /* JADX INFO: renamed from: b */
    InputStream mo169b(String str);

    /* JADX INFO: renamed from: c */
    OutputStream mo171c(String str);

    /* JADX INFO: renamed from: d */
    InterfaceC0064d mo172d(String str);

    /* JADX INFO: renamed from: e */
    boolean mo173e(String str);

    int getCompressionLevel(String str);

    long getSize(String str);
}
