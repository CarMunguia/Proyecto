package com.example.proyecto


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.databinding.ItemProductosBinding
import com.example.proyecto.remote.productosEntry
import com.squareup.picasso.Picasso


class MainAdapter(private val productos: List<productosEntry>):RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemProductosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(productos[position])
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    class MainHolder(val binding: ItemProductosBinding): RecyclerView.ViewHolder(binding.root) {
        fun render(producto: productosEntry){
            binding.tvTitle.setText(producto.title)
            binding.tvPrice.setText(producto.price)
            binding.tvCategory.setText(producto.category)
            binding.tvDescription.setText(producto.description)
            Picasso.get().load(producto.image).into(binding.ivImagen)
        }
    }

}