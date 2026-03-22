package jadx.api;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public interface IJadxArgs {
    int getDeobfuscationMaxLength();

    int getDeobfuscationMinLength();

    File getOutDir();

    int getThreadsCount();

    boolean isCFGOutput();

    boolean isDeobfuscationForceSave();

    boolean isDeobfuscationOn();

    boolean isFallbackMode();

    boolean isRawCFGOutput();

    boolean isShowInconsistentCode();

    boolean isSkipResources();

    boolean isSkipSources();

    boolean isVerbose();

    boolean useSourceNameAsClassAlias();
}
