package com.saas.apkeditorplus

import android.app.Application
import com.google.android.material.color.DynamicColors

class ApkEditorApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Aplica cores dinâmicas globalmente no aplicativo (Android 12+)
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}
