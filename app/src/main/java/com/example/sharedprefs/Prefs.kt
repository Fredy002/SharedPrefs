package com.example.sharedprefs

import android.content.Context

class Prefs (val context:Context){

    val SHARED_NAME = "MyDataBase"
    val SHARED_USER_NAME = "userName"
    val SHARED_VIP = "vip"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveName(name:String){
        // guardamos el nombre
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun saveVip(vip:Boolean){
        storage.edit().putBoolean(SHARED_VIP, vip).apply()
    }

    // para obtener el nombre
    fun getName():String{
        return storage.getString(SHARED_USER_NAME, "")!!
    }

    fun getVip():Boolean{
        return storage.getBoolean(SHARED_VIP, false)
    }

    fun wipe(){
        // borrar todo el contenido
        storage.edit().clear().apply()
    }
}