package com.example.ottosoft.milistas

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory

class DatabaseHandler(context: Context, name: String, factory: CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        /* Tabla con la descripcion de todas las listas creadas */
        db.execSQL("create table listas(descripcion text , f_alta TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")

        /* Rubros */
        db.execSQL("create table rubros(descripcion text)")
        db.execSQL("insert into rubros (descripcion) values ('Bebidas')")
        db.execSQL("insert into rubros (descripcion) values ('Limpieza')")
        db.execSQL("insert into rubros (descripcion) values ('Comestible')")
        db.execSQL("insert into rubros (descripcion) values ('Almacen')")
        db.execSQL("insert into rubros (descripcion) values ('Frescos')")
        db.execSQL("insert into rubros (descripcion) values ('Perfumeria')")
        db.execSQL("insert into rubros (descripcion) values ('Electro.')")
        db.execSQL("insert into rubros (descripcion) values ('Tecno.')")
        db.execSQL("insert into rubros (descripcion) values ('Mascotas')")
        db.execSQL("insert into rubros (descripcion) values ('Hogar y Bazar')")
        db.execSQL("insert into rubros (descripcion) values ('Ferreteria')")
        db.execSQL("insert into rubros (descripcion) values ('Otros')")

        /* Tabla con la descripcion de todas las listas creadas */
        db.execSQL("create table listas_productos(codigo_lista int , codigo_rubro int , descripcion , " +
                "f_alta TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS listas");
        db.execSQL("DROP TABLE IF EXISTS rubros");
        onCreate(db);
    }
}