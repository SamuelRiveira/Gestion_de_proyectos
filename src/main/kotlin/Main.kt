import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.navigator.Navigator

/*
    ----- PALETA DE COLORES -----

https://paletadecolores.com.mx/paleta/4180ab/ffffff/8ab3cf/bdd1de/e4ebf0/

    ----- PALETA DE COLORES -----
*/

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Navigator(LoginScreen())
    }
}


