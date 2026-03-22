package com.gmail.heagoo.apkeditor;

import androidx.versionedparcelable.InterfaceC0376d;
import com.gmail.heagoo.p054a.p059c.C0985a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.xmlpull.v1.XmlPullParserException;
import p000a.p001a.C0000a;
import p000a.p001a.p003b.p004a.C0031e;
import p000a.p001a.p003b.p006b.C0051i;
import p000a.p001a.p003b.p006b.InterfaceC0053k;
import p000a.p001a.p003b.p006b.XmlResourceParserC0047e;
import p000a.p011d.C0075g;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ix */
/* JADX INFO: loaded from: classes.dex */
public final class C1311ix implements InterfaceC0053k {

    /* JADX INFO: renamed from: b */
    private XmlResourceParserC0047e f3710b;

    /* JADX INFO: renamed from: c */
    private boolean f3711c = false;

    /* JADX INFO: renamed from: a */
    private C0075g f3709a = new C0075g();

    static {
        float[] fArr = {0.00390625f, 3.051758E-5f, 1.192093E-7f, 4.656613E-10f};
        String[] strArr = {"px", "dip", "sp", "pt", "in", "mm", "", ""};
        String[] strArr2 = {"%", "%p", "", "", "", "", "", ""};
    }

    public C1311ix(InterfaceC0376d interfaceC0376d, C0031e c0031e) {
        C0051i c0051i = new C0051i();
        c0051i.m141a(c0031e);
        this.f3710b = new XmlResourceParserC0047e();
        this.f3710b.m119a(c0051i);
    }

    /* JADX INFO: renamed from: a */
    private void m3188a(XmlResourceParserC0047e xmlResourceParserC0047e, int i) throws XmlPullParserException, IOException {
        switch (i) {
            case 0:
                this.f3709a.startDocument(xmlResourceParserC0047e.getInputEncoding(), null);
                break;
            case 1:
                this.f3709a.endDocument();
                break;
            case 2:
                this.f3709a.m192a(xmlResourceParserC0047e);
                for (int i2 = 0; i2 < xmlResourceParserC0047e.getAttributeCount(); i2++) {
                    this.f3709a.attribute(xmlResourceParserC0047e.getAttributeNamespace(i2), xmlResourceParserC0047e.getAttributeName(i2), xmlResourceParserC0047e.getAttributeValue(i2));
                }
                break;
            case 3:
                this.f3709a.endTag(xmlResourceParserC0047e.getNamespace(), xmlResourceParserC0047e.getName());
                break;
            case 4:
                this.f3709a.text(C0985a.m2254c(xmlResourceParserC0047e.getText()));
                break;
            case 5:
                this.f3709a.cdsect(xmlResourceParserC0047e.getText());
                break;
            case 6:
                this.f3709a.entityRef(xmlResourceParserC0047e.getName());
                break;
            case 7:
                this.f3709a.ignorableWhitespace(xmlResourceParserC0047e.getText());
                break;
            case 8:
                this.f3709a.processingInstruction(xmlResourceParserC0047e.getText());
                break;
            case 9:
                this.f3709a.comment(xmlResourceParserC0047e.getText());
                break;
            case 10:
                this.f3709a.docdecl(xmlResourceParserC0047e.getText());
                break;
        }
    }

    @Override // p000a.p001a.p003b.p006b.InterfaceC0053k
    /* JADX INFO: renamed from: a */
    public final void mo137a(InputStream inputStream, OutputStream outputStream) throws C0000a {
        try {
            this.f3709a.setOutput(outputStream, "utf-8");
            this.f3710b.setInput(inputStream, "utf-8");
            while (this.f3710b.nextToken() != 1) {
                try {
                    m3188a(this.f3710b, this.f3710b.getEventType());
                } catch (Exception e) {
                    throw new C0000a(e.getMessage());
                }
            }
            this.f3709a.endDocument();
        } catch (Exception e2) {
            throw new C0000a(e2.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3189a(boolean z) {
        this.f3711c = true;
        this.f3710b.m120a(this.f3711c);
    }

    /* JADX INFO: renamed from: b */
    public final String m3190b(InputStream inputStream, OutputStream outputStream) throws C0000a {
        try {
            this.f3709a.setOutput(outputStream, "utf-8");
            this.f3710b.setInput(inputStream, "utf-8");
            while (this.f3710b.nextToken() != 1) {
                try {
                    int eventType = this.f3710b.getEventType();
                    if (eventType != 2) {
                        m3188a(this.f3710b, eventType);
                    } else if ("manifest".equals(this.f3710b.getName())) {
                        this.f3709a.m192a(this.f3710b);
                        int attributeCount = this.f3710b.getAttributeCount();
                        if (attributeCount >= 2) {
                            String[] strArr = new String[attributeCount];
                            String[] strArr2 = new String[attributeCount];
                            String[] strArr3 = new String[attributeCount];
                            for (int i = 0; i < attributeCount; i++) {
                                strArr[i] = this.f3710b.getAttributeNamespace(i);
                                strArr2[i] = this.f3710b.getAttributeName(i);
                                strArr3[i] = this.f3710b.getAttributeValue(i);
                                if ("package".equals(strArr2[i])) {
                                    String str = strArr3[i];
                                }
                            }
                            this.f3709a.m191a(strArr, strArr2, strArr3);
                        } else {
                            for (int i2 = 0; i2 < attributeCount; i2++) {
                                String attributeName = this.f3710b.getAttributeName(i2);
                                String attributeValue = this.f3710b.getAttributeValue(i2);
                                if ("package".equals(attributeName)) {
                                }
                                this.f3709a.attribute(this.f3710b.getAttributeNamespace(i2), attributeName, attributeValue);
                            }
                        }
                    } else {
                        this.f3709a.m192a(this.f3710b);
                        int attributeCount2 = this.f3710b.getAttributeCount();
                        if (attributeCount2 >= 2) {
                            String[] strArr4 = new String[attributeCount2];
                            String[] strArr5 = new String[attributeCount2];
                            String[] strArr6 = new String[attributeCount2];
                            for (int i3 = 0; i3 < attributeCount2; i3++) {
                                strArr4[i3] = this.f3710b.getAttributeNamespace(i3);
                                strArr5[i3] = this.f3710b.getAttributeName(i3);
                                strArr6[i3] = this.f3710b.getAttributeValue(i3);
                            }
                            this.f3709a.m191a(strArr4, strArr5, strArr6);
                        } else {
                            for (int i4 = 0; i4 < attributeCount2; i4++) {
                                this.f3709a.attribute(this.f3710b.getAttributeNamespace(i4), this.f3710b.getAttributeName(i4), this.f3710b.getAttributeValue(i4));
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new C0000a(e.getMessage());
                }
            }
            this.f3709a.flush();
            return null;
        } catch (Exception e2) {
            throw new C0000a(e2.getMessage());
        }
    }
}
