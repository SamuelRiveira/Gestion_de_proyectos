import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class TareaScreen(indiceTarea: String) : Screen {

    val idTarea = indiceTarea

    @Composable
    override fun Content(){
        val navigator = LocalNavigator.current

        Text(text = "Tarea ${idTarea.toInt() + 1}")
    }
}