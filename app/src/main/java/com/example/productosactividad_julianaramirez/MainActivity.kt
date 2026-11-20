package com.example.productosactividad_julianaramirez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.productosactividad_julianaramirez.ui.theme.ProductosActividadJulianaRamirezTheme
import com.example.productosactividad_julianaramirez.navegacion.NavegacionApp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductosActividadJulianaRamirezTheme {
                Scaffold { innerPadding ->
                    NavegacionApp(modifier = Modifier.padding(innerPadding))
                }
                }
            }
        }
    }

