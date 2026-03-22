package android.support.v4.content;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class SharedPreferencesCompat {

    @Deprecated
    public final class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper = new Helper();

        class Helper {
            Helper() {
            }

            public void apply(@NonNull SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError e) {
                    editor.commit();
                }
            }
        }

        private EditorCompat() {
        }

        @Deprecated
        public static EditorCompat getInstance() {
            if (sInstance == null) {
                sInstance = new EditorCompat();
            }
            return sInstance;
        }

        @Deprecated
        public final void apply(@NonNull SharedPreferences.Editor editor) {
            this.mHelper.apply(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
