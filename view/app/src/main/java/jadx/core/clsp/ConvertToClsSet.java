package jadx.core.clsp;

import jadx.api.JadxArgs;
import jadx.core.dex.nodes.RootNode;
import jadx.core.utils.files.InputFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.p085d.C1677c;
import org.p085d.InterfaceC1668b;

/* JADX INFO: loaded from: classes.dex */
public class ConvertToClsSet {
    private static final InterfaceC1668b LOG = C1677c.m3845a(ConvertToClsSet.class);

    private static void addFilesFromDirectory(File file, List list) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                addFilesFromDirectory(file2, list);
            }
            String name = file2.getName();
            if (name.endsWith(".dex") || name.endsWith(".jar") || name.endsWith(".apk")) {
                InputFile inputFile = new InputFile(file2);
                list.add(inputFile);
                while (inputFile.nextDexIndex != -1) {
                    InputFile inputFile2 = new InputFile(file2, inputFile.nextDexIndex);
                    list.add(inputFile2);
                    inputFile = inputFile2;
                }
            }
        }
    }

    public static void main(String[] strArr) {
        if (strArr.length < 2) {
            usage();
            System.exit(1);
        }
        File file = new File(strArr[0]);
        ArrayList arrayList = new ArrayList(strArr.length - 1);
        for (int i = 1; i < strArr.length; i++) {
            File file2 = new File(strArr[i]);
            if (file2.isDirectory()) {
                addFilesFromDirectory(file2, arrayList);
            } else {
                InputFile inputFile = new InputFile(file2);
                arrayList.add(inputFile);
                while (inputFile.nextDexIndex != -1) {
                    InputFile inputFile2 = new InputFile(file2, inputFile.nextDexIndex);
                    arrayList.add(inputFile2);
                    inputFile = inputFile2;
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LOG.mo3820b("Loaded: {}", ((InputFile) it.next()).getFile());
        }
        RootNode rootNode = new RootNode(new JadxArgs());
        rootNode.load(arrayList);
        ClsSet clsSet = new ClsSet();
        clsSet.load(rootNode);
        clsSet.save(file);
        LOG.mo3820b("Output: {}", file);
        LOG.mo3814a("done");
    }

    public static void usage() {
        LOG.mo3814a("<output .jcst or .jar file> <several input dex or jar files> ");
    }
}
