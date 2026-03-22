package android.arch.lifecycle;

import android.arch.core.util.Function;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class Transformations {
    private Transformations() {
    }

    @MainThread
    public static LiveData map(@NonNull LiveData liveData, @NonNull final Function function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer() { // from class: android.arch.lifecycle.Transformations.1
            @Override // android.arch.lifecycle.Observer
            public final void onChanged(@Nullable Object obj) {
                mediatorLiveData.setValue(function.apply(obj));
            }
        });
        return mediatorLiveData;
    }

    @MainThread
    public static LiveData switchMap(@NonNull LiveData liveData, @NonNull final Function function) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer() { // from class: android.arch.lifecycle.Transformations.2
            LiveData mSource;

            @Override // android.arch.lifecycle.Observer
            public final void onChanged(@Nullable Object obj) {
                LiveData liveData2 = (LiveData) function.apply(obj);
                if (this.mSource == liveData2) {
                    return;
                }
                if (this.mSource != null) {
                    mediatorLiveData.removeSource(this.mSource);
                }
                this.mSource = liveData2;
                if (this.mSource != null) {
                    mediatorLiveData.addSource(this.mSource, new Observer() { // from class: android.arch.lifecycle.Transformations.2.1
                        @Override // android.arch.lifecycle.Observer
                        public void onChanged(@Nullable Object obj2) {
                            mediatorLiveData.setValue(obj2);
                        }
                    });
                }
            }
        });
        return mediatorLiveData;
    }
}
