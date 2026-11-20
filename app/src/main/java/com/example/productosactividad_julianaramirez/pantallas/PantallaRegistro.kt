package com.example.productosactividad_julianaramirez.pantallas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.productosactividad_julianaramirez.datos.RepositorioProductos
import com.example.productosactividad_julianaramirez.modelo.Producto
import com.example.productosactividad_julianaramirez.modelo.TipoProducto

@Composable
fun PantallaRegistro(volver: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf(TipoProducto.TECNOLOGIA) }
    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Registrar producto", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del producto") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )

        Text("Tipo de producto", style = MaterialTheme.typography.titleMedium)
        TipoProducto.entries.forEach { opcion ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().clickable { tipo = opcion }
            ) {
                RadioButton(selected = tipo == opcion, onClick = { tipo = opcion })
                Text(opcion.etiqueta)
            }
        }

        Button(
            onClick = {
                val precioNumero = precio.toDoubleOrNull()
                if (nombre.isBlank() || precioNumero == null) {
                    mensaje = "Ingresa un nombre y un precio válido"
                } else {
                    RepositorioProductos.agregar(Producto(nombre.trim(), precioNumero, tipo))
                    nombre = ""
                    precio = ""
                    tipo = TipoProducto.TECNOLOGIA
                    mensaje = "Producto registrado"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
        }

        if (mensaje.isNotEmpty()) {
            Text(mensaje, color = MaterialTheme.colorScheme.primary)
        }

        OutlinedButton(onClick = volver, modifier = Modifier.fillMaxWidth()) {
            Text("Volver")
        }
    }
}
