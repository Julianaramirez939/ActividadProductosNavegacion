package com.example.productosactividad_julianaramirez.datos

import androidx.compose.runtime.mutableStateListOf
import com.example.productosactividad_julianaramirez.modelo.Producto

object RepositorioProductos {
    val productos = mutableStateListOf<Producto>()

    fun agregar(producto: Producto) {
        productos.add(producto)
    }
}