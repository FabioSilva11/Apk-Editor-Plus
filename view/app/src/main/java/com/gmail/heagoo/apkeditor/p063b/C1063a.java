package com.gmail.heagoo.apkeditor.p063b;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import java.util.List;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.b.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1063a {

    /* JADX INFO: renamed from: a */
    short f3032a;

    /* JADX INFO: renamed from: b */
    int f3033b;

    /* JADX INFO: renamed from: c */
    int f3034c;

    /* JADX INFO: renamed from: a */
    public static C1063a m2770a(List list, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return null;
            }
            C1063a c1063a = (C1063a) list.get(i3);
            if (c1063a.f3032a == i) {
                return c1063a;
            }
            i2 = i3 + 1;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("type: ");
        String str = "";
        switch (this.f3032a) {
            case 0:
                str = "kDexTypeHeaderItem";
                break;
            case 1:
                str = "kDexTypeStringIdItem";
                break;
            case 2:
                str = "kDexTypeTypeIdItem";
                break;
            case 3:
                str = "kDexTypeProtoIdItem";
                break;
            case 4:
                str = "kDexTypeFieldIdItem";
                break;
            case 5:
                str = "kDexTypeMethodIdItem";
                break;
            case 6:
                str = "kDexTypeClassDefItem";
                break;
            case 7:
                str = "kDexTypeCallSiteIdItem";
                break;
            case 8:
                str = "kDexTypeMethodHandleItem";
                break;
            case 4096:
                str = "kDexTypeMapList";
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                str = "kDexTypeTypeList";
                break;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                str = "kDexTypeAnnotationSetRefList";
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                str = "kDexTypeAnnotationSetItem";
                break;
            case 8192:
                str = "kDexTypeClassDataItem";
                break;
            case 8193:
                str = "kDexTypeCodeItem";
                break;
            case 8194:
                str = "kDexTypeStringDataItem";
                break;
            case 8195:
                str = "kDexTypeDebugInfoItem";
                break;
            case 8196:
                str = "kDexTypeAnnotationItem";
                break;
            case 8197:
                str = "kDexTypeEncodedArrayItem";
                break;
            case 8198:
                str = "kDexTypeAnnotationsDirectoryItem";
                break;
        }
        sb.append(str);
        sb.append("; ");
        sb.append("size: " + this.f3033b + "; ");
        sb.append("offset: " + this.f3034c);
        return sb.toString();
    }
}
