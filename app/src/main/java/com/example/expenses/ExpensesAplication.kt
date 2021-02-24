package com.example.expenses

import android.app.Application
import com.example.expenses.activitys.Prefs

class ExpensesAplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Prefs.init(this)
    }
}