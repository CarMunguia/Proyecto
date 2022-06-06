package com.example.proyecto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.database.Product
import com.example.proyecto.databinding.ItemSearchBinding
import com.example.proyecto.remote.productosEntry
import com.squareup.picasso.Picasso


class SearchAdapter(private val productos: List<productosEntry>, var callback: CallbackAction):RecyclerView.Adapter<SearchAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.MainHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding, callback)
    }

    override fun onBindViewHolder(holder: SearchAdapter.MainHolder, position: Int) {
        holder.render(productos[position])
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    class MainHolder(val binding: ItemSearchBinding, var callback: CallbackAction): RecyclerView.ViewHolder(binding.root) {
        fun render(producto: productosEntry){
            binding.tvTitle.text = producto.title
            binding.tvPrice.text = producto.price.toString()
            binding.tvCategory.text = producto.category
            binding.tvDescription.text = producto.description
            Picasso.get().load(producto.image).into(binding.ivImagen)

            binding.btnAgregar.setOnClickListener{
                callback.onClick(
                    Product(
                        producto.id.toString(), producto.title, producto.price, producto.description, producto.category, producto.image, 1
                    )
                )
            }
        }
    }

}