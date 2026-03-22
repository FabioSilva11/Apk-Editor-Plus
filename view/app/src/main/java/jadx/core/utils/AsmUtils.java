package jadx.core.utils;

import java.io.File;
import java.io.FileInputStream;
import org.p075b.p076a.C1646a;

/* JADX INFO: loaded from: classes.dex */
public class AsmUtils {
    private AsmUtils() {
    }

    public static String getNameFromClassFile(File file) throws Throwable {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                String strM3795a = new C1646a(fileInputStream).m3795a();
                fileInputStream.close();
                return strM3795a;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }
}
