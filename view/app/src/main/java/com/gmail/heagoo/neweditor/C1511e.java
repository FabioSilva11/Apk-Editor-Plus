package com.gmail.heagoo.neweditor;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.CharacterStyle;
import android.widget.EditText;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: renamed from: com.gmail.heagoo.neweditor.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1511e implements Serializable {

    /* JADX INFO: renamed from: a */
    private static int f4480a = 64;

    /* JADX INFO: renamed from: b */
    private transient ArrayList f4481b;

    /* JADX INFO: renamed from: d */
    private boolean f4483d;

    /* JADX INFO: renamed from: e */
    private int f4484e;

    /* JADX INFO: renamed from: f */
    private int f4485f;

    /* JADX INFO: renamed from: g */
    private File f4486g;

    /* JADX INFO: renamed from: m */
    private transient C1504af f4492m;

    /* JADX INFO: renamed from: n */
    private C1509c f4493n;

    /* JADX INFO: renamed from: c */
    private boolean f4482c = false;

    /* JADX INFO: renamed from: h */
    private Vector f4487h = new Vector();

    /* JADX INFO: renamed from: i */
    private int f4488i = 0;

    /* JADX INFO: renamed from: j */
    private int f4489j = 0;

    /* JADX INFO: renamed from: k */
    private String f4490k = null;

    /* JADX INFO: renamed from: l */
    private Vector f4491l = new Vector();

    public C1511e(Context context, File file, String str) {
        String str2;
        this.f4486g = file;
        this.f4493n = new C1509c(context);
        if (str == null) {
            String name = file.getName();
            int iLastIndexOf = name.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                String strSubstring = name.substring(iLastIndexOf + 1);
                str2 = (strSubstring.equals("htm") ? "html" : strSubstring) + ".xml";
            } else {
                str2 = "txt.xml";
            }
        } else {
            str2 = str;
        }
        C1506ah c1506ah = new C1506ah();
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            try {
                InputSource inputSource = new InputSource(new BufferedInputStream(context.getAssets().open("syntax/" + str2)));
                xMLReader.setContentHandler(c1506ah);
                xMLReader.setDTDHandler(c1506ah);
                xMLReader.setEntityResolver(c1506ah);
                xMLReader.setErrorHandler(c1506ah);
                xMLReader.parse(inputSource);
                this.f4492m = c1506ah.m3630a();
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
            }
        } catch (ParserConfigurationException e2) {
            e2.printStackTrace();
        } catch (SAXException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private C1505ag m3637a(int i) {
        if (this.f4481b == null) {
            this.f4481b = new ArrayList();
        }
        if (i >= this.f4481b.size()) {
            return null;
        }
        return (C1505ag) this.f4481b.get(i);
    }

    /* JADX INFO: renamed from: a */
    private void m3638a(int i, C1505ag c1505ag) {
        if (i >= 0) {
            if (this.f4481b == null) {
                this.f4481b = new ArrayList();
            }
            while (i >= this.f4481b.size()) {
                this.f4481b.add(null);
            }
            this.f4481b.set(i, c1505ag);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3639a(Spannable spannable, int i, int i2) {
        for (Object obj : spannable.getSpans(i, i2, C1501ac.class)) {
            spannable.removeSpan(obj);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3640a(Spannable spannable, CharacterStyle characterStyle, int i, int i2, int i3) {
        spannable.setSpan(characterStyle, i, i2, 33);
    }

    /* JADX INFO: renamed from: c */
    private String m3641c() {
        return this.f4486g != null ? this.f4486g.getName() : "untitled";
    }

    /* JADX INFO: renamed from: a */
    public final String m3642a() {
        return this.f4490k;
    }

    /* JADX INFO: renamed from: a */
    public final void m3643a(Context context) throws IOException {
        m3648a(this.f4486g.getAbsolutePath());
    }

    /* JADX INFO: renamed from: a */
    public final void m3644a(Context context, String str, int i) throws IOException {
        int i2;
        File file = new File(str);
        FileInputStream fileInputStream = new FileInputStream(file);
        long length = file.length();
        if (length > 4194304) {
            throw new IOException(context.getString(i));
        }
        byte[] bArr = new byte[(int) length];
        int i3 = 0;
        while (i3 < bArr.length && (i2 = fileInputStream.read(bArr, i3, bArr.length - i3)) >= 0) {
            i3 += i2;
        }
        this.f4490k = new String(bArr, "UTF-8");
        this.f4482c = false;
        fileInputStream.close();
    }

    /* JADX INFO: renamed from: a */
    public final void m3645a(EditText editText) {
        C1505ag c1505agM3617a;
        try {
            if (this.f4492m == null) {
                this.f4483d = false;
                return;
            }
            Editable text = editText.getText();
            String[] strArrSplit = text.toString().split("\\n");
            C1532z c1532z = new C1532z();
            C1505ag c1505ag = null;
            int i = 0;
            int i2 = 0;
            while (i < strArrSplit.length) {
                m3639a(text, i2, strArrSplit[i].length() + i2);
                try {
                    C1510d c1510d = new C1510d();
                    c1532z.f4545a = strArrSplit[i].toCharArray();
                    c1532z.f4547c = 0;
                    c1532z.f4546b = strArrSplit[i].length();
                    c1505agM3617a = this.f4492m.m3617a(c1505ag, c1510d, c1532z);
                    try {
                        for (Token tokenM2187a = C0985a.m2187a(c1510d.m3636a()); tokenM2187a != null; tokenM2187a = tokenM2187a.next) {
                            if (tokenM2187a.length > 0 && tokenM2187a.f4408id != 0) {
                                m3640a(text, new C1501ac(this.f4493n.m3633a(tokenM2187a)), tokenM2187a.offset + i2, tokenM2187a.length + tokenM2187a.offset + i2, 33);
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e = e2;
                    c1505agM3617a = c1505ag;
                }
                m3638a(i, c1505ag);
                int length = i2 + strArrSplit[i].length() + 1;
                i++;
                i2 = length;
                c1505ag = c1505agM3617a;
            }
        } catch (Error e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3646a(EditText editText, int i, int i2, int i3, int i4, boolean z) {
        C1505ag c1505agM3637a;
        C1505ag c1505agM3617a;
        C1510d c1510d;
        try {
            if (this.f4492m == null) {
                this.f4483d = false;
                return;
            }
            Editable text = editText.getText();
            String[] strArrSplit = text.toString().split("\\n");
            C1532z c1532z = new C1532z();
            C1505ag c1505ag = null;
            int i5 = 0;
            int i6 = 0;
            while (i5 < strArrSplit.length) {
                if (i5 >= this.f4485f && i5 <= this.f4484e && (i5 < i3 || i5 > i4)) {
                    m3639a(editText.getText(), i6, strArrSplit[i5].length() + i6);
                }
                if ((!z || i > strArrSplit[i5].length() + i6 || i2 < i6) && ((z || i5 < i3 || i5 > i4) && (m3637a(i5) == c1505ag || i5 < i3 || i5 > i4))) {
                    c1505agM3637a = m3637a(i5 + 1);
                } else {
                    m3639a(text, i6, strArrSplit[i5].length() + i6);
                    try {
                        c1510d = new C1510d();
                        c1532z.f4545a = strArrSplit[i5].toCharArray();
                        c1532z.f4547c = 0;
                        c1532z.f4546b = strArrSplit[i5].length();
                        c1505agM3617a = this.f4492m.m3617a(c1505ag, c1510d, c1532z);
                    } catch (Exception e) {
                        e = e;
                        c1505agM3617a = c1505ag;
                    }
                    try {
                        for (Token tokenM2187a = C0985a.m2187a(c1510d.m3636a()); tokenM2187a != null; tokenM2187a = tokenM2187a.next) {
                            if (i5 >= i3 && i5 <= i4 && tokenM2187a.length > 0 && tokenM2187a.f4408id != 0) {
                                m3640a(text, new C1501ac(this.f4493n.m3633a(tokenM2187a)), tokenM2187a.offset + i6, tokenM2187a.length + tokenM2187a.offset + i6, 33);
                            }
                        }
                        c1505agM3637a = c1505agM3617a;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        c1505agM3637a = c1505agM3617a;
                    }
                    m3638a(i5, c1505ag);
                }
                int length = i6 + strArrSplit[i5].length() + 1;
                i5++;
                i6 = length;
                c1505ag = c1505agM3637a;
            }
            this.f4485f = i3;
            this.f4484e = i4;
        } catch (Error e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3647a(CharSequence charSequence, int i, int i2, int i3) {
        try {
            String str = this.f4490k;
            this.f4490k = charSequence.toString();
            C1498a c1498a = new C1498a(i, str.substring(i, i + i2), this.f4490k.substring(i, i + i3));
            if (this.f4491l.size() <= 0 || !((C1498a) this.f4491l.lastElement()).m3605a(c1498a)) {
                this.f4491l.addElement(c1498a);
            } else {
                ((C1498a) this.f4491l.lastElement()).m3606b(c1498a);
            }
            while (f4480a != 0 && this.f4491l.size() > f4480a) {
                this.f4491l.remove(0);
            }
            this.f4487h.clear();
            this.f4482c = true;
        } catch (Exception e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3648a(String str) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(this.f4490k);
        bufferedWriter.flush();
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    /* JADX INFO: renamed from: a */
    public final void m3649a(boolean z) {
        this.f4482c = z;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3650b() {
        return this.f4482c;
    }

    public final String toString() {
        return this.f4482c ? m3641c() + " *" : m3641c();
    }
}
