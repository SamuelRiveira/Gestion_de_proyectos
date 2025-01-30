import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator


class ProyectoScreen(item: String) : Screen {

    val proyecto = item

    @Composable
    override fun Content(){

        val navigator = LocalNavigator.current
        Text(text = proyecto)
    }
}