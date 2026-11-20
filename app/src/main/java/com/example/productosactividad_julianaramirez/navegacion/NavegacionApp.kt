package com.example.productosactividad_julianaramirez.navegacion
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.productosactividad_julianaramirez.pantallas.PantallaLista
import com.example.productosactividad_julianaramirez.pantallas.PantallaPrincipal
import com.example.productosactividad_julianaramirez.pantallas.PantallaRegistro

@Composable
fun NavegacionApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Principal,
        modifier = modifier
    ) {
        composable<Principal> {
            PantallaPrincipal(
                irARegistro = { navController.navigate(Registro) },
                irALista = { navController.navigate(Lista) }
            )
        }
        composable<Registro> {
            PantallaRegistro(volver = { navController.popBackStack() })
        }
        composable<Lista> {
            PantallaLista(volver = { navController.popBackStack() })
        }
    }
}