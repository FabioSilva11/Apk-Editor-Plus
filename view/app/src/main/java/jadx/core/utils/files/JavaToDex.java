package jadx.core.utils.files;

import com.p016a.p019b.p026b.C0522a;
import com.p016a.p019b.p026b.p027a.C0523a;
import com.p016a.p019b.p026b.p027a.C0525c;
import jadx.core.utils.exceptions.JadxException;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class JavaToDex {
    private static final String CHARSET_NAME = "UTF-8";
    private String dxErrors;

    public class DxArgs extends C0525c {
        public DxArgs(String str, String[] strArr) {
            this.outName = str;
            this.fileNames = strArr;
            this.jarOutput = false;
            this.optimize = true;
            this.localInfo = true;
            this.coreLibrary = true;
        }
    }

    public byte[] convert(String str) throws JadxException {
        JadxException jadxException;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            C0522a.f657b = new PrintStream((OutputStream) byteArrayOutputStream, true, CHARSET_NAME);
            PrintStream printStream = System.out;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                try {
                    System.setOut(new PrintStream((OutputStream) byteArrayOutputStream2, true, CHARSET_NAME));
                    C0523a.m799a(new DxArgs("-", new String[]{str}));
                    byteArrayOutputStream2.close();
                    try {
                        this.dxErrors = byteArrayOutputStream.toString(CHARSET_NAME);
                        return byteArrayOutputStream2.toByteArray();
                    } catch (UnsupportedEncodingException e) {
                        throw new JadxException("Can't save error output", e);
                    }
                } finally {
                }
            } finally {
                System.setOut(printStream);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new JadxException(e2.getMessage(), e2);
        }
    }

    public String getDxErrors() {
        return this.dxErrors;
    }

    public boolean isError() {
        return this.dxErrors != null && this.dxErrors.length() > 0;
    }
}
