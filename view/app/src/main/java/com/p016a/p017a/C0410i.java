package com.p016a.p017a;

import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.a.a.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0410i {

    /* JADX INFO: renamed from: a */
    static final short[] f381a = new short[0];

    /* JADX INFO: renamed from: b */
    private ByteBuffer f382b;

    /* JADX INFO: renamed from: c */
    private final C0427z f383c;

    /* JADX INFO: renamed from: d */
    private int f384d;

    /* JADX INFO: renamed from: e */
    private final C0417p f385e;

    /* JADX INFO: renamed from: f */
    private final C0418q f386f;

    /* JADX INFO: renamed from: g */
    private final C0419r f387g;

    /* JADX INFO: renamed from: h */
    private final C0415n f388h;

    /* JADX INFO: renamed from: i */
    private final C0413l f389i;

    /* JADX INFO: renamed from: j */
    private final C0414m f390j;

    public C0410i(int i) {
        byte b2 = 0;
        this.f383c = new C0427z();
        this.f384d = 0;
        this.f385e = new C0417p(this, b2);
        this.f386f = new C0418q(this, b2);
        this.f387g = new C0419r(this, b2);
        this.f388h = new C0415n(this, b2);
        this.f389i = new C0413l(this, b2);
        this.f390j = new C0414m(this, b2);
        this.f382b = ByteBuffer.wrap(new byte[i]);
        this.f382b.order(ByteOrder.LITTLE_ENDIAN);
    }

    public C0410i(File file) throws IOException {
        byte b2 = 0;
        this.f383c = new C0427z();
        this.f384d = 0;
        this.f385e = new C0417p(this, b2);
        this.f386f = new C0418q(this, b2);
        this.f387g = new C0419r(this, b2);
        this.f388h = new C0415n(this, b2);
        this.f389i = new C0413l(this, b2);
        this.f390j = new C0414m(this, b2);
        if (!C0985a.m2275g(file.getName())) {
            if (!file.getName().endsWith(".dex")) {
                throw new C0420s("unknown output extension: " + file);
            }
            m348a(new FileInputStream(file));
        } else {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("classes.dex");
            if (entry == null) {
                throw new C0420s("Expected classes.dex in " + file);
            }
            m348a(zipFile.getInputStream(entry));
            zipFile.close();
        }
    }

    private C0410i(ByteBuffer byteBuffer) {
        byte b2 = 0;
        this.f383c = new C0427z();
        this.f384d = 0;
        this.f385e = new C0417p(this, b2);
        this.f386f = new C0418q(this, b2);
        this.f387g = new C0419r(this, b2);
        this.f388h = new C0415n(this, b2);
        this.f389i = new C0413l(this, b2);
        this.f390j = new C0414m(this, b2);
        this.f382b = byteBuffer;
        this.f382b.order(ByteOrder.LITTLE_ENDIAN);
        this.f383c.m442a(this);
    }

    public C0410i(byte[] bArr) {
        this(ByteBuffer.wrap(bArr));
    }

    /* JADX INFO: renamed from: a */
    private void m348a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                inputStream.close();
                this.f382b = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                this.f382b.order(ByteOrder.LITTLE_ENDIAN);
                this.f383c.m442a(this);
                return;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m350b(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
        }
    }

    /* JADX INFO: renamed from: m */
    private byte[] m351m() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            ByteBuffer byteBufferDuplicate = this.f382b.duplicate();
            byteBufferDuplicate.limit(byteBufferDuplicate.capacity());
            byteBufferDuplicate.position(32);
            while (byteBufferDuplicate.hasRemaining()) {
                int iMin = Math.min(8192, byteBufferDuplicate.remaining());
                byteBufferDuplicate.get(bArr, 0, iMin);
                messageDigest.update(bArr, 0, iMin);
            }
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0403b m352a(C0406e c0406e) {
        int iM331i = c0406e.m331i();
        if (iM331i == 0) {
            throw new IllegalArgumentException("offset == 0");
        }
        return C0416o.m371a(m354a(iM331i));
    }

    /* JADX INFO: renamed from: a */
    public final C0407f m353a(C0405d c0405d) {
        int iM322c = c0405d.m322c();
        if (iM322c == 0) {
            throw new IllegalArgumentException("offset == 0");
        }
        return C0416o.m372b(m354a(iM322c));
    }

    /* JADX INFO: renamed from: a */
    public final C0416o m354a(int i) {
        if (i < 0 || i >= this.f382b.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.f382b.capacity());
        }
        ByteBuffer byteBufferDuplicate = this.f382b.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.limit(this.f382b.capacity());
        return new C0416o(this, "section", byteBufferDuplicate, (byte) 0);
    }

    /* JADX INFO: renamed from: a */
    public final C0416o m355a(int i, String str) {
        if ((i & 3) != 0) {
            throw new IllegalStateException("Not four byte aligned!");
        }
        int i2 = this.f384d + i;
        ByteBuffer byteBufferDuplicate = this.f382b.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferDuplicate.position(this.f384d);
        byteBufferDuplicate.limit(i2);
        C0416o c0416o = new C0416o(this, str, byteBufferDuplicate, (byte) 0);
        this.f384d = i2;
        return c0416o;
    }

    /* JADX INFO: renamed from: a */
    public final C0427z m356a() {
        return this.f383c;
    }

    /* JADX INFO: renamed from: a */
    public final void m357a(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        ByteBuffer byteBufferDuplicate = this.f382b.duplicate();
        byteBufferDuplicate.clear();
        while (byteBufferDuplicate.hasRemaining()) {
            int iMin = Math.min(8192, byteBufferDuplicate.remaining());
            byteBufferDuplicate.get(bArr, 0, iMin);
            outputStream.write(bArr, 0, iMin);
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m358b() {
        return this.f382b.capacity();
    }

    /* JADX INFO: renamed from: b */
    public final C0402ab m359b(int i) {
        return i == 0 ? C0402ab.f345a : m354a(i).m389e();
    }

    /* JADX INFO: renamed from: c */
    public final int m360c() {
        return this.f384d;
    }

    /* JADX INFO: renamed from: c */
    public final int m361c(int i) {
        m350b(i, this.f383c.f424c.f342b);
        return this.f382b.getInt(this.f383c.f424c.f343c + (i * 4));
    }

    /* JADX INFO: renamed from: d */
    public final byte[] m362d() {
        ByteBuffer byteBufferDuplicate = this.f382b.duplicate();
        byte[] bArr = new byte[byteBufferDuplicate.capacity()];
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.get(bArr);
        return bArr;
    }

    /* JADX INFO: renamed from: e */
    public final List m363e() {
        return this.f385e;
    }

    /* JADX INFO: renamed from: f */
    public final List m364f() {
        return this.f386f;
    }

    /* JADX INFO: renamed from: g */
    public final List m365g() {
        return this.f387g;
    }

    /* JADX INFO: renamed from: h */
    public final List m366h() {
        return this.f388h;
    }

    /* JADX INFO: renamed from: i */
    public final List m367i() {
        return this.f389i;
    }

    /* JADX INFO: renamed from: j */
    public final List m368j() {
        return this.f390j;
    }

    /* JADX INFO: renamed from: k */
    public final Iterable m369k() {
        return new C0411j(this, (byte) 0);
    }

    /* JADX INFO: renamed from: l */
    public final void m370l() {
        m354a(12).m382a(m351m());
        C0416o c0416oM354a = m354a(8);
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[8192];
        ByteBuffer byteBufferDuplicate = this.f382b.duplicate();
        byteBufferDuplicate.limit(byteBufferDuplicate.capacity());
        byteBufferDuplicate.position(12);
        while (byteBufferDuplicate.hasRemaining()) {
            int iMin = Math.min(8192, byteBufferDuplicate.remaining());
            byteBufferDuplicate.get(bArr, 0, iMin);
            adler32.update(bArr, 0, iMin);
        }
        c0416oM354a.m392f((int) adler32.getValue());
    }
}
