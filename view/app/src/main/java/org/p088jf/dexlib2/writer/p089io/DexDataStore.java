package org.p088jf.dexlib2.writer.p089io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public interface DexDataStore {
    void close() throws IOException;

    OutputStream outputAt(int i);

    InputStream readAt(int i);
}
