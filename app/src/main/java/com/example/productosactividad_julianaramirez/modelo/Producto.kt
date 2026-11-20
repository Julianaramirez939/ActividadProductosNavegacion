package com.example.productosactividad_julianaramirez.modelo

import androidx.annotation.DrawableRes
import com.example.productosactividad_julianaramirez.R

enum class TipoProducto(val etiqueta: String, @DrawableRes val imagen: Int) {
    TECNOLOGIA("Tecnología", R.drawable.img_tecnologia),
    ROPA("Ropa", R.drawable.img_ropa),
    ALIMENTOS("Alimentos", R.drawable.img_alimentos),
    HOGAR("Hogar", R.drawable.img_hogar)
}

data class Producto(
    val nombre: String,
    val precio: Double,
    val tipo: TipoProducto
)