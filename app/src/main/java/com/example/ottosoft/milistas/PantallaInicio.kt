package com.example.ottosoft.milistas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class PantallaInicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_inicio)

        val btn_crear = findViewById(R.id.btn_crear) as Button

        btn_crear.setOnClickListener{

            val activityCrearLista = Intent(this, CrearLista::class.java)
            startActivity(activityCrearLista)

        }

    }


}
