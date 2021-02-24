package com.example.expenses.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.expenses.Modelos.Gasto
import com.example.expenses.R
import com.example.expenses.`interface`.HomeInterface
import com.example.expenses.controllerRegister.ControllerHome
import com.example.expenses.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), HomeInterface {

    private val controller: ControllerHome = ControllerHome(this)

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        probar()
    }


    private fun probar() {
        binding.saveExpensen.setOnClickListener {
            controller.guardarGasto(binding.expenseOptions.selectedItem.toString(), binding.expenseValue.text.toString().toLong())
        }
    }

    override fun mostrarLista(gastos: List<Gasto>) {
        binding.gastosContainer.removeAllViews()
        gastos.map {
            val tv=TextView(this)
            tv.text= String.format(
                getString(R.string.textView_gasto),
                it.categoria, it.valor.toString()
            )
            binding.gastosContainer.addView(tv)
        }
    }

    override fun totalAcomulado(total: Long) {
        binding.total.text = total.toString()
    }


}


