package com.pjurado.firebase2324

import android.app.Application
import com.pjurado.firebase2324.core.AuthManager
import com.pjurado.firebase2324.core.FirestoreManager

class App: Application() {
    lateinit var auth: AuthManager
    lateinit var firestore: FirestoreManager

    override fun onCreate() {
        super.onCreate()
        auth = AuthManager(this)
        firestore = FirestoreManager(this)
    }
}