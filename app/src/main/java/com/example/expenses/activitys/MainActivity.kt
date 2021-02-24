package com.example.expenses.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.expenses.`interface`.ExpensesComunication
import com.example.expenses.controllerRegister.ControllerRegister
import com.example.expenses.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ExpensesComunication {

    private lateinit var binding: ActivityMainBinding
    private val controller: ControllerRegister = ControllerRegister(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Prefs.estaLogeado){
            home()
            finish()
        }
        register()


    }

    private fun register() {
        binding.buttonLogIn.setOnClickListener {
            controller.register(
                binding.usernameEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
    }


    override fun emptyField() {
        Toast.makeText(this, "Usuario vacio", Toast.LENGTH_SHORT).show()
    }


    override fun existingUser() {
        Toast.makeText(this, "Usuario ya existe", Toast.LENGTH_LONG).show()
    }

    override fun SuccessfulRegistration() {
        Toast.makeText(this, "¡Registro exitoso!", Toast.LENGTH_LONG).show()
    }

    override fun emptyPassword() {
        Toast.makeText(this, "¡Contraseña vacia!", Toast.LENGTH_LONG).show()
    }

    override fun error() {
        Toast.makeText(this, "¡Usuario no existe!", Toast.LENGTH_LONG).show()
    }

    override fun passwordError() {
        Toast.makeText(this, "¡Contraseña incorrecta!", Toast.LENGTH_LONG).show()
    }

    override fun home() {
        Prefs.estaLogeado=true
        val validar: Intent = Intent(this, HomeActivity::class.java)
        startActivity(validar)
    }
}