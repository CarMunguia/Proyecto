package com.example.proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto.databinding.FragmentMenuprincipalBinding
import com.example.proyecto.remote.productosEntry
import com.example.proyecto.remote.retofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MenuprincipalFragment : Fragment() {

     private lateinit var binding: FragmentMenuprincipalBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val retrofit = retofitBuilder.create()
        val response = retrofit.getProductos()

        response.enqueue(object : Callback<List<productosEntry>>{

            override fun onResponse(call: Call<List<productosEntry>>, response : Response<List<productosEntry>>){
                var listaproductos:List<productosEntry>? = response.body()
                if(listaproductos!=null)
                binding.rvMenuPrincipal.adapter=MainAdapter(listaproductos)
            }

            override fun onFailure(call: Call<List<productosEntry>>, t: Throwable){

            }
        })

        return inflater.inflate(R.layout.fragment_menuprincipal, container, false)
    }


            }
