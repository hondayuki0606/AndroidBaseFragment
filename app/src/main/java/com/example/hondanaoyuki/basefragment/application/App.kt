package com.example.basefragment.application

import android.app.Application
//import android.content.Context

class App: Application() {

    companion object {
        lateinit var instance: App
            private set
//        lateinit var context: Context
//            private set
    }
    
    override fun onCreate() {
        super.onCreate()
        instance = this
//        context = getApplicationContext()
    }
}