package com.example.expenses.controllerRegister

import com.example.expenses.Modelos.Gasto
import com.example.expenses.`interface`.HomeInterface

class ControllerHome(
    private val comunication : HomeInterface
) {

    private val lista = mutableListOf<Gasto>()
    private var totalacumulado = 0L


    fun guardarGasto(category: String, value: Long) {
         val gasto = Gasto(value, category)
        lista.add(gasto)
        comunication.mostrarLista(lista)
        totalacumulado += value
        comunication.totalAcomulado(totalacumulado)
    }


}