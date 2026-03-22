package com.android.apksig.util;

import android.annotation.TargetApi;
import android.os.Build;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public interface RunnablesExecutor {
    public static final RunnablesExecutor SINGLE_THREADED = new RunnablesExecutor() { // from class: com.android.apksig.util.RunnablesExecutor.1
        @Override // com.android.apksig.util.RunnablesExecutor
        public void execute(RunnablesProvider runnablesProvider) {
            runnablesProvider.createRunnable().run();
        }
    };
    public static final RunnablesExecutor MULTI_THREADED = new RunnablesExecutor() { // from class: com.android.apksig.util.RunnablesExecutor.2
        public final int PARALLELISM = Math.min(32, Runtime.getRuntime().availableProcessors());

        @Override // com.android.apksig.util.RunnablesExecutor
        @TargetApi(21)
        public void execute(final RunnablesProvider runnablesProvider) {
            int i = this.PARALLELISM;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(4), new ThreadPoolExecutor.CallerRunsPolicy());
            final Phaser phaser = Build.VERSION.SDK_INT >= 21 ? new Phaser(1) : null;
            for (int i2 = 0; i2 < this.PARALLELISM; i2++) {
                Runnable runnable = new Runnable(this) { // from class: com.android.apksig.util.RunnablesExecutor.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnablesProvider.createRunnable().run();
                        phaser.arriveAndDeregister();
                    }
                };
                phaser.register();
                threadPoolExecutor.execute(runnable);
            }
            phaser.arriveAndAwaitAdvance();
            threadPoolExecutor.shutdownNow();
        }
    };

    void execute(RunnablesProvider runnablesProvider);
}
