package com.gmail.heagoo.apkeditor.pro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.gmail.heagoo.appdm.PrefOverallActivity;

/* JADX INFO: loaded from: classes.dex */
public class appdm {
    /* JADX INFO: renamed from: de */
    public static void m3229de(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) PrefOverallActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("packagePath", str);
        bundle.putBoolean("backup", false);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
