package p000a.p011d;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import p000a.p001a.p003b.p004a.C0028b;

/* JADX INFO: renamed from: a.d.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0074f extends AbstractC0072d {
    public C0074f(C0028b c0028b) {
        super(c0028b);
    }

    public C0074f(InputStream inputStream) {
        super(new DataInputStream(inputStream));
    }

    /* JADX INFO: renamed from: a */
    public final String m183a(int i, boolean z) {
        int i2;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i == 0 || (s = readShort()) == 0) {
                break;
            }
            sb.append((char) s);
            i = i2;
        }
        skipBytes(i2 << 1);
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m184a(int i, int i2) throws IOException {
        int i3 = readInt();
        if (i3 == i2 || i3 < i) {
            m184a(i, -1);
        } else if (i3 != i) {
            throw new IOException(String.format("Expected: 0x%08x, actual: 0x%08x", Integer.valueOf(i), Integer.valueOf(i3)));
        }
    }
}
