package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class LoaderManager {

    public interface LoaderCallbacks {
        @NonNull
        @MainThread
        Loader onCreateLoader(int i, @Nullable Bundle bundle);

        @MainThread
        void onLoadFinished(@NonNull Loader loader, Object obj);

        @MainThread
        void onLoaderReset(@NonNull Loader loader);
    }

    public static void enableDebugLogging(boolean z) {
        LoaderManagerImpl.DEBUG = z;
    }

    @NonNull
    public static LoaderManager getInstance(@NonNull LifecycleOwner lifecycleOwner) {
        return new LoaderManagerImpl(lifecycleOwner, ((ViewModelStoreOwner) lifecycleOwner).getViewModelStore());
    }

    @MainThread
    public abstract void destroyLoader(int i);

    @Deprecated
    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @Nullable
    public abstract Loader getLoader(int i);

    public boolean hasRunningLoaders() {
        return false;
    }

    @NonNull
    @MainThread
    public abstract Loader initLoader(int i, @Nullable Bundle bundle, @NonNull LoaderCallbacks loaderCallbacks);

    public abstract void markForRedelivery();

    @NonNull
    @MainThread
    public abstract Loader restartLoader(int i, @Nullable Bundle bundle, @NonNull LoaderCallbacks loaderCallbacks);
}
