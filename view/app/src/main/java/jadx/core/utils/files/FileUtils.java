package jadx.core.utils.files;

import jadx.core.utils.exceptions.JadxRuntimeException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class FileUtils {
    private FileUtils() {
    }

    public static void addFileToJar(JarOutputStream jarOutputStream, File file, String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        try {
            JarEntry jarEntry = new JarEntry(str);
            jarEntry.setTime(file.lastModified());
            jarOutputStream.putNextEntry(jarEntry);
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        jarOutputStream.closeEntry();
                        bufferedInputStream.close();
                        return;
                    }
                    jarOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                th = th;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    public static void makeDirsForFile(File file) {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
            throw new JadxRuntimeException("Can't create directory " + parentFile);
        }
    }
}
