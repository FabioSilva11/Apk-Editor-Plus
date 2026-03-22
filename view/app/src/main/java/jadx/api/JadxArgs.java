package jadx.api;

import android.support.v7.widget.ActivityChooserView;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class JadxArgs implements IJadxArgs {
    private File outDir = new File("jadx-output");
    private int threadsCount = Math.max(1, Runtime.getRuntime().availableProcessors() - 1);
    private boolean cfgOutput = false;
    private boolean rawCFGOutput = false;
    private boolean isVerbose = false;
    private boolean fallbackMode = false;
    private boolean showInconsistentCode = false;
    private boolean isSkipResources = false;
    private boolean isSkipSources = false;
    private boolean isDeobfuscationOn = false;
    private boolean isDeobfuscationForceSave = false;
    private boolean useSourceNameAsClassAlias = false;
    private int deobfuscationMinLength = 0;
    private int deobfuscationMaxLength = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    @Override // jadx.api.IJadxArgs
    public int getDeobfuscationMaxLength() {
        return this.deobfuscationMaxLength;
    }

    @Override // jadx.api.IJadxArgs
    public int getDeobfuscationMinLength() {
        return this.deobfuscationMinLength;
    }

    @Override // jadx.api.IJadxArgs
    public File getOutDir() {
        return this.outDir;
    }

    @Override // jadx.api.IJadxArgs
    public int getThreadsCount() {
        return this.threadsCount;
    }

    @Override // jadx.api.IJadxArgs
    public boolean isCFGOutput() {
        return this.cfgOutput;
    }

    @Override // jadx.api.IJadxArgs
    public boolean isDeobfuscationForceSave() {
        return this.isDeobfuscationForceSave;
    }

    @Override // jadx.api.IJadxArgs
    public boolean isDeobfuscationOn() {
        return this.isDeobfuscationOn;
    }

    @Override // jadx.api.IJadxArgs
    public boolean isFallbackMode() {
        return this.fallbackMode;
    }

    @Override // jadx.api.IJadxArgs
    public boolean isRawCFGOutput() {
        return this.rawCFGOutput;
    }

    @Override // jadx.api.IJadxArgs
    public boolean isShowInconsistentCode() {
        return this.showInconsistentCode;
    }

    @Override // jadx.api.IJadxArgs
    public boolean isSkipResources() {
        return this.isSkipResources;
    }

    @Override // jadx.api.IJadxArgs
    public boolean isSkipSources() {
        return this.isSkipSources;
    }

    @Override // jadx.api.IJadxArgs
    public boolean isVerbose() {
        return this.isVerbose;
    }

    public void setCfgOutput(boolean z) {
        this.cfgOutput = z;
    }

    public void setDeobfuscationForceSave(boolean z) {
        this.isDeobfuscationForceSave = z;
    }

    public void setDeobfuscationMaxLength(int i) {
        this.deobfuscationMaxLength = i;
    }

    public void setDeobfuscationMinLength(int i) {
        this.deobfuscationMinLength = i;
    }

    public void setDeobfuscationOn(boolean z) {
        this.isDeobfuscationOn = z;
    }

    public void setFallbackMode(boolean z) {
        this.fallbackMode = z;
    }

    public void setOutDir(File file) {
        this.outDir = file;
    }

    public void setRawCFGOutput(boolean z) {
        this.rawCFGOutput = z;
    }

    public void setShowInconsistentCode(boolean z) {
        this.showInconsistentCode = z;
    }

    public void setSkipResources(boolean z) {
        this.isSkipResources = z;
    }

    public void setSkipSources(boolean z) {
        this.isSkipSources = z;
    }

    public void setThreadsCount(int i) {
        this.threadsCount = i;
    }

    public void setUseSourceNameAsClassAlias(boolean z) {
        this.useSourceNameAsClassAlias = z;
    }

    public void setVerbose(boolean z) {
        this.isVerbose = z;
    }

    @Override // jadx.api.IJadxArgs
    public boolean useSourceNameAsClassAlias() {
        return this.useSourceNameAsClassAlias;
    }
}
