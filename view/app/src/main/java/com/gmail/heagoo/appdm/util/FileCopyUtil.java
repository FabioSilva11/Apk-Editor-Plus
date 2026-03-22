package com.gmail.heagoo.appdm.util;

import android.content.Context;
import com.gmail.heagoo.common.C1471c;
import com.gmail.heagoo.common.ccc;
import com.gmail.heagoo.sqliteutil.C1549c;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class FileCopyUtil {
    public static void copyBack(Context context, String str, String str2, boolean z) throws Exception {
        ccc cccVarCreateCommandRunner = createCommandRunner(z);
        File file = new File(context.getFilesDir(), "mycp");
        if (!cccVarCreateCommandRunner.mo3495a(String.format((file.exists() ? file.getPath() : "cp") + " %s \"%s\"", str, str2), (String[]) null, (Integer) 5000)) {
            throw new Exception("Can not write file to " + str2);
        }
    }

    private static ccc createCommandRunner(boolean z) {
        return z ? new C1549c() : new C1471c();
    }
}
