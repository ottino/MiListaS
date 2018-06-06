package com.example.ottosoft.milistas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class CrearLista : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_lista)

        Toast.makeText(this, "Hola Maxi", Toast.LENGTH_SHORT).show()

    }
}
