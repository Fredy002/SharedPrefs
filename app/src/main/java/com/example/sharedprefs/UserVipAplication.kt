package com.example.sharedprefs

import android.app.Application

// se ejecutará cuando la app se inicie, antes que pase por el main activity
class UserVipAplication: Application(){

    companion object{
        lateinit var prefs:Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)

    }
}