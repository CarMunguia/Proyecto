package com.example.proyecto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.database.Product
import com.example.proyecto.databinding.ItemCarritoBinding
import com.example.proyecto.databinding.ItemProductosBinding
import com.squareup.picasso.Picasso

class ApaterCarrito(private val productos: List<Product>, var callback: CallbackAction):
    RecyclerView.Adapter<ApaterCarrito.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApaterCarrito.MainHolder {
        val binding = ItemCarritoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding, callback)
    }

    override fun onBindViewHolder(holder: ApaterCarrito.MainHolder, position: Int) {
        holder.render(productos[position])
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    class MainHolder(val binding: ItemCarritoBinding, var callback: CallbackAction): RecyclerView.ViewHolder(binding.root) {
        fun render(producto: Product){
            binding.tvTitle.text = producto.titulo
            binding.tvPrice.text = producto.precio.toString()
            binding.tvCategory.text = producto.categoria
            binding.tvDescription.text = producto.descripcion
            Picasso.get().load(producto.imagen).into(binding.ivImagen)


            binding.btnEliminar.setOnClickListener{
                callback.onClick(
                    Product(
                        producto.id.toString(), producto.titulo, producto.precio, producto.descripcion, producto.categoria, producto.imagen, 1
                    )
                )
            }

        }
    }

}