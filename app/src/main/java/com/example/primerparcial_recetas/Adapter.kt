package com.example.primerparcial_recetas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class Adapter(val context: Context) : ListAdapter<Receta, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener:(Receta) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nombre : TextView = view.findViewById(R.id.textView_nombre)
        private val dificultad : TextView = view.findViewById(R.id.textView_dificultad)
        private val origen : TextView = view.findViewById(R.id.textView_origen)
        private val imagenreceta: ImageView = view.findViewById(R.id.imageView_receta)
        private val imagenBandera: ImageView = view.findViewById(R.id.imageView_bandera)
        private val imagenDificultad: ImageView = view.findViewById(R.id.imageView_dificultad)


        //como va a mostrar y que va a mostrar en cada lado
        //cada receta que reciba de VIEWHOLDER le de su atributos
        fun bind (receta: Receta) {
            nombre.text = "Nombre: " + receta.nombre
            dificultad.text = "Dificultad: " + receta.dificultad.toString()
            origen.text = "Origen: " + receta.origen.toString()

            val imagen = when(receta.origen){
                Paises.ARGENTINA -> R.drawable.argentina
                Paises.BRASIL -> R.drawable.brasil
                Paises.COLOMBIA -> R.drawable.colombia
                Paises.ECUADOR -> R.drawable.ecuador
                Paises.MEXICO -> R.drawable.mexico
                Paises.PARAGUAY -> R.drawable.paraguay
                Paises.PERU -> R.drawable.peru
                else -> R.drawable.venezuela
            }

            val dif = when(receta.dificultad){
                Dificultad.ALTA -> R.drawable.red
                Dificultad.MEDIA -> R.drawable.yellow
                else -> R.drawable.green
            }


            imagenBandera.setImageResource(imagen)
            imagenDificultad.setImageResource(dif)
            Glide.with(context).load(receta.imagenReceta).into(imagenreceta)


            view.setOnClickListener{
                onItemClickListener(receta)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val receta = getItem(position)
        holder.bind(receta)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem.id == newItem.id
        }
    }
}