package com.example.primerparcial_recetas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvRecetas: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRecetas = findViewById(R.id.rv_recetas)
        rvRecetas.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        rvRecetas.adapter = adapter

        adapter.submitList(getListadoRecetas())

        adapter.onItemClickListener = {
            receta -> navergarDetalle(receta)
        }

    }

    private fun navergarDetalle(receta: Receta) {
        val intent = Intent(this,DetailRecipeActivity::class.java)
        intent.putExtra("receta", receta)
        startActivity(intent)
    }

    private fun getListadoRecetas(): MutableList<Receta>? {
        return mutableListOf(
            Receta(
                1,
                "Arepas Caseras",
                Dificultad.BAJA,
                Paises.VENEZUELA,
                "https://imag.bonviveur.com/arepas-caseras.jpg",
                ingredientes = listOf("450ml de agua templada","1 cucharada pequeña de sal fina","300g de harina de maiz",
                    "Aceite de oliva")
            ),
            Receta(
                2,
                "Guacamole",
                Dificultad.BAJA,
                Paises.MEXICO,
                "https://imag.bonviveur.com/guacamole.jpg",
                ingredientes = listOf("1 tomate natural","1/2 cebolla roja","1 chile (opcional si se desea picante)",
                    "2 ramas de cilantro fresco", "2 aguacates maduros", "1 lima", "1 pizca de sal")
            ),
            Receta(
                3,
                "Dulce de leche",
                Dificultad.MEDIA,
                Paises.ARGENTINA,
                "https://imag.bonviveur.com/dulce-de-leche-casero-tradicional-y-expres.jpg",
                ingredientes = listOf("1 litro de leche entera","350 g de azúcar","1 cucharadita de esencia de vainilla o las semillas de una vaina",
                    "1/2 cucharadita de bicarbonato sódico")
            ),
            Receta(
                4,
                "Ceviche pescado",
                Dificultad.ALTA,
                Paises.PERU,
                "https://imag.bonviveur.com/ceviche-peruano-de-pescado.jpg",
                ingredientes = listOf("1 boniato de unos 400 g","Sal","200 g de maíz choclo (o mote remojado desde la noche anterior)",
                    "1 cucharadita de azúcar", "2 cucharadas de aceite suave", "200 g de maíz cancha")
            ),
            Receta(
                5,
                "Tequeños de queso",
                Dificultad.MEDIA,
                Paises.VENEZUELA,
                "https://imag.bonviveur.com/relleno-de-los-tequenos-de-queso.jpg",
                ingredientes = listOf("175 g de harina de trigo","30 g de mantequilla fría","1 huevo M",
                    "35 ml de agua", "1 pizca de sal", "200 g de queso blanco tipo llanero (en su defecto gouda) cortados en bastones de 2 cm de ancho y 8 cm de largo",
                    "500 g de aceite para freír")
            ),
            Receta(
                6,
                "Picaña de ternera",
                Dificultad.ALTA,
                Paises.BRASIL,
                "https://imag.bonviveur.com/picana-de-ternera-al-horno.jpg",
                ingredientes = listOf("1 picaña de ternera entera (unos 2 kg)","1 cucharada de sal gruesa","1 cucharadita de pimientas varias en grano",
                    "1 cucharadita de mostaza en grano", "1 ramita de romero", "1 ramita de tomillo",
                    "5 patatas", "100 ml de aceite de oliva suave")
            ),
            Receta(
                7,
                "Chorizo a la pomarola",
                Dificultad.MEDIA,
                Paises.ARGENTINA,
                "https://imag.bonviveur.com/chorizo-a-la-pomarola.jpg",
                ingredientes = listOf("8 chorizos criollos","2 dientes de ajo","1 cebolla", "1 pimiento verde",
                    "1 pimiento rojo", "1 cucharada de aceite de oliva", "Sal", "1 cucharadita de pimentón ahumado",
                    "½ cucharadita de copos de chile", "1 hoja de laurel", "800 ml de tomate triturado",
                    "Pimienta negra recién molida", "50 ml de agua")
            ),
            Receta(
                8,
                "Sopa paraguaya",
                Dificultad.ALTA,
                Paises.PARAGUAY,
                "https://imag.bonviveur.com/sopa-paraguaya.jpg",
                ingredientes = listOf("250 g de harina de maíz","4 huevos grandes o 5 medianos","350 ml de leche entera",
                    "350 g de cebolla", "4 o 5 cucharadas de aceite de oliva (o grasa de cerdo)", "350 g de queso que funda bien",
                    "75 g de mantequilla (y un poco más para engrasar el molde)", "Sal", "Pimienta negra molida")
            ),
            Receta(
                9,
                "Humitas ecuatorianas",
                Dificultad.MEDIA,
                Paises.ECUADOR,
                "https://imag.bonviveur.com/humitas-ecuatorianas-portada.jpg",
                ingredientes = listOf("26 hojas secas de maíz","6 mazorcas de maíz","1 cebolla",
                    "2 dientes de ajo", "300 g de queso mozzarella rallado", "60 ml de nata líquida",
                    "2 huevos", "1 cucharadita de sal", "Salsa de ají de árbol (para servir)")
            ),
            Receta(
                10,
                "Causa limeña",
                Dificultad.ALTA,
                Paises.COLOMBIA,
                "https://imag.bonviveur.com/causa-limena-casera.jpg",
                ingredientes = listOf("1 kg de patatas","2 cucharadas de pasta de ají amarillo","Sal",
                    "1 lima", "Aceite de oliva virgen extra (sirve el de la conserva de atún)",
                    "250 g del ingrediente del relleno (atún en conserva o pollo cocido)", "100 g de mayonesa",
                    "¼ cebolla morada", "1 aguacate grande")
            )
        )
    }
}