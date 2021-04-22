package com.muhammad.green.home

import android.app.Application
import java.util.*

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val locale = Locale("ar")
        Locale.setDefault(locale)
        val config = baseContext.resources.configuration
        config.setLocale(locale)
        createConfigurationContext(config)
    }
}