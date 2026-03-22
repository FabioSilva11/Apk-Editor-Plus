package com.gmail.heagoo.apkeditor;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import com.gmail.heagoo.apkeditor.pro.R;
import java.util.HashMap;

/* JADX INFO: renamed from: com.gmail.heagoo.apkeditor.ds */
/* JADX INFO: loaded from: classes.dex */
final class C1140ds {

    /* JADX INFO: renamed from: a */
    private static HashMap f3224a = new HashMap();

    /* JADX INFO: renamed from: a */
    static String m2869a(Context context, String str) {
        initMap(context);
        return (String) f3224a.get(str);
    }

    static void initMap(Context context) {
        f3224a.put("manifest", context.getResources().getString(R.string.mf_manifest));
        f3224a.put("application", context.getResources().getString(R.string.mf_application));
        f3224a.put("activity", context.getResources().getString(R.string.mf_activity));
        f3224a.put("intent-filter", context.getResources().getString(R.string.mf_intent_filter));
        f3224a.put("action", context.getResources().getString(R.string.mf_action));
        f3224a.put("category", context.getResources().getString(R.string.mf_category));
        f3224a.put("data", context.getResources().getString(R.string.mf_data));
        f3224a.put("meta-data", context.getResources().getString(R.string.mf_meta_data));
        f3224a.put("layout", context.getResources().getString(R.string.mf_layout));
        f3224a.put("activity-alias", context.getResources().getString(R.string.mf_activity_alias));
        f3224a.put(NotificationCompat.CATEGORY_SERVICE, context.getResources().getString(R.string.mf_service));
        f3224a.put("receiver", context.getResources().getString(R.string.mf_receiver));
        f3224a.put("profileable", context.getResources().getString(R.string.mf_profileable));
        f3224a.put("provider", context.getResources().getString(R.string.mf_provider));
        f3224a.put("grant-uri-permission", context.getResources().getString(R.string.mf_grant_uri_permission));
        f3224a.put("path-permission", context.getResources().getString(R.string.mf_path_permission));
        f3224a.put("uses-library", context.getResources().getString(R.string.mf_uses_library));
        f3224a.put("uses-native-library", context.getResources().getString(R.string.mf_uses_native_library));
        f3224a.put("compatible-screens", context.getResources().getString(R.string.mf_compatible_screens));
        f3224a.put("instrumentation", context.getResources().getString(R.string.mf_instrumentation));
        f3224a.put("permission", context.getResources().getString(R.string.mf_permission));
        f3224a.put("permission-group", context.getResources().getString(R.string.mf_permission_group));
        f3224a.put("permission-tree", context.getResources().getString(R.string.mf_permission_tree));
        f3224a.put("queries", context.getResources().getString(R.string.mf_queries));
        f3224a.put("supports-gl-texture", context.getResources().getString(R.string.mf_supports_gl_texture));
        f3224a.put("supports-screens", context.getResources().getString(R.string.mf_supports_screens));
        f3224a.put("uses-configuration", context.getResources().getString(R.string.mf_uses_configuration));
        f3224a.put("uses-feature", context.getResources().getString(R.string.mf_uses_feature));
        f3224a.put("uses-permission", context.getResources().getString(R.string.mf_uses_permission));
        f3224a.put("uses-permission-sdk-23", context.getResources().getString(R.string.string_7f0702bc));
        f3224a.put("uses-sdk", context.getResources().getString(R.string.mf_uses_sdk));
    }
}
