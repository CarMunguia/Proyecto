package com.example.proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.proyecto.database.Product
import com.example.proyecto.databinding.FragmentCarritoBinding



class CarritoFragment : Fragment(), CallbackAction{

    private lateinit var binding: FragmentCarritoBinding
    private val model : Model by viewModels()

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCarritoBinding.inflate(layoutInflater)
        model.mostrarProductos()


        model.productosGuardados.observe(viewLifecycleOwner) { Product ->
            if (Product.isNotEmpty()) {

                binding.rvCarrito.adapter = ApaterCarrito(Product, this@CarritoFragment)
            }
        }
        return binding.root

    }

    override fun onClick(product: Product) {
        //TODO("Not yet implemented")
        model.eliminar(product)
    }


}
