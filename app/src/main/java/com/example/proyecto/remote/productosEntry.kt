package com.example.proyecto.remote

import com.google.gson.annotations.SerializedName

data class productosEntry(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("category")
    val category: String,

   @SerializedName("image")
   val image: String,

    @SerializedName("rating")
     val rating: ratingEntry,

)
data class ratingEntry(
    @SerializedName("rate")
    val rate: Int,

    @SerializedName("count")
    val count: Int,
)