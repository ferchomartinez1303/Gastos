package com.example.expenses.activitys

import android.content.Context
import android.content.SharedPreferences


object Prefs {
    private lateinit var preferences: SharedPreferences

    var estaLogeado: Boolean
        set(value) = preferences.edit().putBoolean("esta_logeado", value).apply()
        get() = preferences.getBoolean("esta_logeado", false)

    fun init(context: Context) {
        preferences = context.getSharedPreferences("mis_preferencias", Context.MODE_PRIVATE)
    }

}