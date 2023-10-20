package com.example.primerparcial_recetas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailRecipeActivity : AppCompatActivity() {

    private lateinit var tvDetalleNombre : TextView
    private lateinit var tvIngredientes : TextView
    private lateinit var imagenDetalle : ImageView
    private lateinit var listView: ListView
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_recipe)

        val receta = intent.getParcelableExtra<Receta>("receta")

        val ingredientes = receta?.ingredientes ?: listOf<String>()

        tvDetalleNombre = findViewById(R.id.tvDetail_nombre)
        tvIngredientes = findViewById(R.id.textView_Ingredientes)
        imagenDetalle = findViewById(R.id.imageView_details)
        listView = findViewById(R.id.listView)
        button = findViewById(R.id.buttonVolver)

        val adapterListView = ArrayAdapter(this,android.R.layout.simple_list_item_1, ingredientes)
        listView.adapter = adapterListView


        tvDetalleNombre.text = receta?.nombre
        tvIngredientes.text = "Ingredientes:"
        Glide.with(this).load(receta?.imagenReceta).into(imagenDetalle)


        button.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}