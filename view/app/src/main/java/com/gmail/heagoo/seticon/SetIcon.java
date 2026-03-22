package com.gmail.heagoo.seticon;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import com.gmail.heagoo.apkeditor.pro.R;

/* JADX INFO: loaded from: classes.dex */
public class SetIcon {
    public static int[] getAllIcons() {
        return new int[]{R.drawable.editorpro, R.drawable.editorpro2, R.drawable.appiconframed};
    }

    public static int getDefaultIcon() {
        return R.drawable.editorpro;
    }

    public static int getIconId() {
        return R.drawable.editorpro;
    }

    public static int getSelectedIcon(Activity activity) {
        int[] allIcons = getAllIcons();
        String[] stringArray = activity.getResources().getStringArray(R.array.appicon_value);
        String string = PreferenceManager.getDefaultSharedPreferences(activity).getString("MyIcon", stringArray[0]);
        for (int i = 0; i < stringArray.length; i++) {
            if (string.equals(stringArray[i])) {
                return allIcons[i];
            }
        }
        return allIcons[0];
    }

    @SuppressLint({"NewApi"})
    public static void setIcon(Activity activity, String str) {
        int i = 0;
        String[] strArr = {"com.gmail.heagoo.apkeditor.MainActivity-New1", "com.gmail.heagoo.apkeditor.MainActivity-New2", "com.gmail.heagoo.apkeditor.MainActivity-New3"};
        int[] allIcons = getAllIcons();
        PackageManager packageManager = activity.getPackageManager();
        for (int i2 = 0; i2 < 3; i2++) {
            packageManager.setComponentEnabledSetting(new ComponentName(activity, strArr[i2]), 2, 1);
        }
        String[] stringArray = activity.getResources().getStringArray(R.array.appicon_value);
        int i3 = 0;
        while (true) {
            if (i3 >= stringArray.length) {
                break;
            }
            if (stringArray[i3].equals(str)) {
                i = i3;
                break;
            }
            i3++;
        }
        packageManager.setComponentEnabledSetting(new ComponentName(activity, strArr[i]), 1, 1);
        if (Build.VERSION.SDK_INT < 14 || activity.getActionBar() == null) {
            return;
        }
        activity.getActionBar().setIcon(allIcons[i]);
    }
}
