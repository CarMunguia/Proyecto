package com.example.proyecto.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO add TABLE_USERS constant
@Entity(tableName = TABLE_PRODUCTS)
data class ProductEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "title") val title: String,
    val price: Double,
    val description: String,
    val image: String,
    val rate: Double,
    val id_user : Int
)

fun ProductEntity.toProduct() = Product(
    id,
    title,
    price,
    description,
    image,
    rate,
    id_user
)