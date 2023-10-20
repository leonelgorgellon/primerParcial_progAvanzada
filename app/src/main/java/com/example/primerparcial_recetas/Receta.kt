package com.example.primerparcial_recetas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Receta (
    val id: Int,
    val nombre: String,
    val dificultad: Dificultad,
    val origen: Paises,
    val imagenReceta: String,
    val ingredientes: List<String> = emptyList()
): Parcelable


enum class Dificultad{
    BAJA,
    MEDIA,
    ALTA,
}

enum class Paises{
    ARGENTINA,
    BRASIL,
    COLOMBIA,
    ECUADOR,
    PERU,
    VENEZUELA,
    MEXICO,
    PARAGUAY
}