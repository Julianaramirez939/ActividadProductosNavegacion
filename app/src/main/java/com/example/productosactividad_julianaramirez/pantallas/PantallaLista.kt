package com.example.productosactividad_julianaramirez.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.productosactividad_julianaramirez.datos.RepositorioProductos
import com.example.productosactividad_julianaramirez.modelo.Producto

@Composable
fun PantallaLista(volver: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Productos registrados", style = MaterialTheme.typography.headlineMedium)

        if (RepositorioProductos.productos.isEmpty()) {
            Text(
                "Aún no hay productos registrados",
                modifier = Modifier.padding(top = 24.dp)
            )
        }

        LazyColumn(
            modifier = Modifier.weight(1f).padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(RepositorioProductos.productos) { producto ->
                TarjetaProducto(producto)
            }
        }

        OutlinedButton(onClick = volver, modifier = Modifier.fillMaxWidth()) {
            Text("Volver")
        }
    }
}

@Composable
fun TarjetaProducto(producto: Producto) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(producto.tipo.imagen),
                contentDescription = producto.tipo.etiqueta,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(72.dp).clip(MaterialTheme.shapes.medium)
            )
            Column(modifier = Modifier.padding(start = 12.dp)) {
                Text(producto.nombre, style = MaterialTheme.typography.titleLarge)
                Text("Precio: $${producto.precio}", style = MaterialTheme.typography.bodyLarge)
                Text("Tipo: ${producto.tipo.etiqueta}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}