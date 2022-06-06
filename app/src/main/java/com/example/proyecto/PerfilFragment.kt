package com.example.proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto.databinding.FragmentPerfilBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class PerfilFragment : Fragment() {

    private lateinit var binding: FragmentPerfilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPerfilBinding.inflate(layoutInflater)
        val database = Firebase.database
        val myRef = database.reference


        myRef.child("Usuarios").child("1").setValue(User("1", "Jose Carlos", "26/01/2022", "500 puntos, 15 puntos para el siguiente nivel", "4 en carrito"))
        myRef.child("Usuarios").child("2").setValue(User("2", "Alondra Diaz Carvajal", "09/12/1999", "0 puntos, 100 puntos para el siguiente nivel", "0 en carrito"))
        myRef.child("Usuarios").child("3").setValue(User("3", "Orlando Ochoa", "05/05/2007", "430 puntos, 85 puntos para el siguiente nivel", "3 en carrito"))
        myRef.child("Usuarios").child("4").setValue(User("4", "Sandra Paola", "15/09/1888", "230 puntos, 70 puntos para el siguiente nivel", "0 en carrito"))
        myRef.child("Usuarios").child("1").get().addOnSuccessListener { response->

            var Usuario1: String = response.value.toString()

            binding.tvUsuario1.text = "$Usuario1"
        }.addOnFailureListener{

        }

        myRef.child("Usuarios").child("2").get().addOnSuccessListener { response->

            var Usuario2: String = response.value.toString()

            binding.tvUsuario2.text = "$Usuario2"
        }.addOnFailureListener{

        }

        myRef.child("Usuarios").child("3").get().addOnSuccessListener { response->

            var Usuario3: String = response.value.toString()

            binding.tvUsuario3.text = "$Usuario3"
        }.addOnFailureListener{

        }
        myRef.child("Usuarios").child("3").get().addOnSuccessListener { response->

            var Usuario4: String = response.value.toString()

            binding.tvUsuario4.text = "$Usuario4"
        }.addOnFailureListener{

        }

        return binding.root
    }


                }
