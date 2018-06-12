package com.example.ottosoft.milistas

import android.content.ContentValues
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pantalla_inicio.*
import kotlin.math.round

class PantallaInicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_inicio)


        val btn_crear = findViewById(R.id.btn_crear) as Button
        val btn_consultar = findViewById(R.id.btn_consultar) as Button
        val NombreLista = findViewById(R.id.NombreLista) as EditText
        val VerConsultar = findViewById(R.id.verConsultar) as EditText

        btn_crear.setOnClickListener{

            /* Abrir otra actividad
            val activityCrearLista = Intent(this, CrearLista::class.java)
            startActivity(activityCrearLista)
           */

            if (!NombreLista.getText().toString().isNullOrEmpty()) {

                val admin = DatabaseHandler(this, "administracion", null, 7)
                val bd = admin.writableDatabase
                val registro = ContentValues()
                //registro.put("codigo", 1)
                registro.put("descripcion", NombreLista.getText().toString())
                bd.insert("listas", null, registro)
                bd.close()
                Toast.makeText(this, "Se cargaron la lista ${NombreLista.getText().toString()}", Toast.LENGTH_SHORT).show()

            } else Toast.makeText(this, "Ingrese un nombre de lista", Toast.LENGTH_SHORT).show()

        }


        btn_consultar.setOnClickListener {

            val admin = DatabaseHandler(this, "administracion", null, 7)
            val bd = admin.writableDatabase

            val fila = bd.rawQuery("select max(rowid) from listas", null)

            if (fila.moveToFirst()) {
                VerConsultar.setText(fila.getString(0))
            } else
                Toast.makeText(this, "No existe un artículo con dicho código",  Toast.LENGTH_SHORT).show()

            // Version de la base de datos
            Log.d("version ", "Version de la base de datos: " + bd.version);

            bd.close()

        }

    }


}
