package com.pjurado.firebase2324.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.pjurado.firebase2324.App
import com.pjurado.firebase2324.R
import com.pjurado.firebase2324.core.AuthManager
import com.pjurado.firebase2324.core.AuthRes
import com.pjurado.firebase2324.databinding.ActivityRecuperaContrasenaBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RecuperaContrasena : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRecuperaContrasenaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRecuperaContrasena.setOnClickListener {
            GlobalScope.launch {
                when ((application as App).auth.resetPassword(binding.etEmail.text.toString())){
                    is AuthRes.Success -> {
                        Snackbar.make(binding.root, "Correo enviado correctamente", Snackbar.LENGTH_SHORT).show()
                        finish()
                    }
                    is AuthRes.Error -> {
                        Snackbar.make(binding.root, "Error al enviar el correo", Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}