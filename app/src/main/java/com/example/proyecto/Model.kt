package com.example.proyecto

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto.database.DatabaseManager
import com.example.proyecto.database.MyCoroutines
import com.example.proyecto.database.Product
import kotlinx.coroutines.launch

class Model: ViewModel() {

    val productosGuardados = MutableLiveData<List<Product>>()

    fun mostrarProductos(){
        viewModelScope.launch{
            val priductDao = DatabaseManager.instance.database.priductDao()

             productosGuardados.value = MyCoroutines(priductDao).mostrarProducts().value
        }
    }

    fun guardaProducto(product: Product){

        viewModelScope.launch{


            val priductDao = DatabaseManager.instance.database.priductDao()

            MyCoroutines(priductDao).guardar(product)
        }
    }
    fun eliminar(product: Product){
       viewModelScope.launch{


            val priductDao = DatabaseManager.instance.database.priductDao()

            MyCoroutines(priductDao).eliminar(product)
        }
    }



}