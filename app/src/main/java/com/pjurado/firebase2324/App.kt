package com.pjurado.firebase2324

import android.app.Application
import com.pjurado.firebase2324.core.AuthManager

class App: Application() {
    lateinit var auth: AuthManager

    override fun onCreate() {
        super.onCreate()
        auth = AuthManager(this)
    }
}