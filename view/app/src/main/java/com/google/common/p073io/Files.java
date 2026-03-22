package com.google.common.p073io;

import com.google.common.base.Preconditions;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class Files {
    static {
        new Object() { // from class: com.google.common.io.Files.2
        };
    }

    public static String getNameWithoutExtension(String str) {
        Preconditions.checkNotNull(str);
        String name = new File(str).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf == -1 ? name : name.substring(0, iLastIndexOf);
    }
}
