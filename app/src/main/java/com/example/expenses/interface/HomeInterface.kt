package com.example.expenses.`interface`

import com.example.expenses.Modelos.Gasto

interface HomeInterface {
    fun mostrarLista(gastos: List<Gasto>)
    fun totalAcomulado(total: Long)
}