package com.p016a.p019b.p028c.p032c;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import com.p016a.p019b.p043h.InterfaceC0889s;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: com.a.b.c.c.ae */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0607ae implements InterfaceC0889s {

    /* JADX INFO: renamed from: w */
    private final int f1067w;

    /* JADX INFO: renamed from: x */
    private final String f1068x;

    /* JADX INFO: renamed from: y */
    private final String f1069y;

    /* JADX INFO: renamed from: a */
    public static final EnumC0607ae f1045a = new EnumC0607ae("TYPE_HEADER_ITEM", 0, 0, "header_item");

    /* JADX INFO: renamed from: b */
    public static final EnumC0607ae f1046b = new EnumC0607ae("TYPE_STRING_ID_ITEM", 1, 1, "string_id_item");

    /* JADX INFO: renamed from: c */
    public static final EnumC0607ae f1047c = new EnumC0607ae("TYPE_TYPE_ID_ITEM", 2, 2, "type_id_item");

    /* JADX INFO: renamed from: d */
    public static final EnumC0607ae f1048d = new EnumC0607ae("TYPE_PROTO_ID_ITEM", 3, 3, "proto_id_item");

    /* JADX INFO: renamed from: e */
    public static final EnumC0607ae f1049e = new EnumC0607ae("TYPE_FIELD_ID_ITEM", 4, 4, "field_id_item");

    /* JADX INFO: renamed from: f */
    public static final EnumC0607ae f1050f = new EnumC0607ae("TYPE_METHOD_ID_ITEM", 5, 5, "method_id_item");

    /* JADX INFO: renamed from: g */
    public static final EnumC0607ae f1051g = new EnumC0607ae("TYPE_CLASS_DEF_ITEM", 6, 6, "class_def_item");

    /* JADX INFO: renamed from: h */
    public static final EnumC0607ae f1052h = new EnumC0607ae("TYPE_MAP_LIST", 7, 4096, "map_list");

    /* JADX INFO: renamed from: i */
    public static final EnumC0607ae f1053i = new EnumC0607ae("TYPE_TYPE_LIST", 8, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, "type_list");

    /* JADX INFO: renamed from: j */
    public static final EnumC0607ae f1054j = new EnumC0607ae("TYPE_ANNOTATION_SET_REF_LIST", 9, InputDeviceCompat.SOURCE_TOUCHSCREEN, "annotation_set_ref_list");

    /* JADX INFO: renamed from: k */
    public static final EnumC0607ae f1055k = new EnumC0607ae("TYPE_ANNOTATION_SET_ITEM", 10, FragmentTransaction.TRANSIT_FRAGMENT_FADE, "annotation_set_item");

    /* JADX INFO: renamed from: l */
    public static final EnumC0607ae f1056l = new EnumC0607ae("TYPE_CLASS_DATA_ITEM", 11, 8192, "class_data_item");

    /* JADX INFO: renamed from: m */
    public static final EnumC0607ae f1057m = new EnumC0607ae("TYPE_CODE_ITEM", 12, 8193, "code_item");

    /* JADX INFO: renamed from: n */
    public static final EnumC0607ae f1058n = new EnumC0607ae("TYPE_STRING_DATA_ITEM", 13, 8194, "string_data_item");

    /* JADX INFO: renamed from: o */
    public static final EnumC0607ae f1059o = new EnumC0607ae("TYPE_DEBUG_INFO_ITEM", 14, 8195, "debug_info_item");

    /* JADX INFO: renamed from: p */
    public static final EnumC0607ae f1060p = new EnumC0607ae("TYPE_ANNOTATION_ITEM", 15, 8196, "annotation_item");

    /* JADX INFO: renamed from: q */
    public static final EnumC0607ae f1061q = new EnumC0607ae("TYPE_ENCODED_ARRAY_ITEM", 16, 8197, "encoded_array_item");

    /* JADX INFO: renamed from: r */
    public static final EnumC0607ae f1062r = new EnumC0607ae("TYPE_ANNOTATIONS_DIRECTORY_ITEM", 17, 8198, "annotations_directory_item");

    /* JADX INFO: renamed from: s */
    public static final EnumC0607ae f1063s = new EnumC0607ae("TYPE_MAP_ITEM", 18, -1, "map_item");

    /* JADX INFO: renamed from: u */
    private static EnumC0607ae f1065u = new EnumC0607ae("TYPE_TYPE_ITEM", 19, -1, "type_item");

    /* JADX INFO: renamed from: v */
    private static EnumC0607ae f1066v = new EnumC0607ae("TYPE_EXCEPTION_HANDLER_ITEM", 20, -1, "exception_handler_item");

    /* JADX INFO: renamed from: t */
    public static final EnumC0607ae f1064t = new EnumC0607ae("TYPE_ANNOTATION_SET_REF_ITEM", 21, -1, "annotation_set_ref_item");

    static {
        EnumC0607ae[] enumC0607aeArr = {f1045a, f1046b, f1047c, f1048d, f1049e, f1050f, f1051g, f1052h, f1053i, f1054j, f1055k, f1056l, f1057m, f1058n, f1059o, f1060p, f1061q, f1062r, f1063s, f1065u, f1066v, f1064t};
    }

    private EnumC0607ae(String str, int i, int i2, String str2) {
        this.f1067w = i2;
        this.f1068x = str2;
        this.f1069y = (str2.endsWith("_item") ? str2.substring(0, str2.length() - 5) : str2).replace('_', ' ');
    }

    /* JADX INFO: renamed from: a */
    public final int m1055a() {
        return this.f1067w;
    }

    /* JADX INFO: renamed from: b */
    public final String m1056b() {
        return this.f1068x;
    }

    @Override // com.p016a.p019b.p043h.InterfaceC0889s
    /* JADX INFO: renamed from: d */
    public final String mo657d() {
        return this.f1069y;
    }
}
