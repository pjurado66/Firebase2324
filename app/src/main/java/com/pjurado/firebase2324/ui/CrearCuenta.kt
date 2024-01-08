package com.pjurado.firebase2324.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.pjurado.firebase2324.App
import com.pjurado.firebase2324.core.AuthManager
import com.pjurado.firebase2324.core.AuthRes
import com.pjurado.firebase2324.databinding.ActivityCrearCuentaBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CrearCuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnRegistrar.setOnClickListener {
                signUp(etEmail.text.toString(), etPassword.text.toString())
            }
            tvIniciaSesion.setOnClickListener {
                finish()
            }
        }
    }

    private fun ActivityCrearCuentaBinding.signUp(eMail: String, password: String) {
        if (!eMail.isNullOrEmpty() && !password.isNullOrEmpty()) {
            GlobalScope.launch {
                when ((application as App).auth.createUserWithEmailAndPassword(
                    eMail,
                    password
                )){
                    is AuthRes.Success -> {
                        Snackbar.make(root, "Usuario creado correctamente", Snackbar.LENGTH_SHORT)
                            .show()
                        finish()
                    }
                    is AuthRes.Error -> {
                        Snackbar.make(root, "Error al crear el usuario", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
        else{
            Snackbar.make(root, "Debes llenar todos los campos", Snackbar.LENGTH_SHORT).show()
        }
    }
}