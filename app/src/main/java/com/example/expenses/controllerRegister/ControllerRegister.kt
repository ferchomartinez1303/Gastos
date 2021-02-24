package com.example.expenses.controllerRegister

import com.example.expenses.`interface`.ExpensesComunication

class ControllerRegister(
    private val comunication: ExpensesComunication
) {


    fun register(name: String, password: String) {
        if (name.isNotEmpty()) {
            if (password.isNotEmpty()) {
                if (name == "admin" && password == "nimda") {
                    comunication.home()
                } else {
                    comunication.error()
                }
            } else {
                comunication.emptyPassword()
            }
        } else {
            comunication.emptyField()
        }
    }
}

