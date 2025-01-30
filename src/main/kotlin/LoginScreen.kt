import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class LoginScreen: Screen{
    @Composable
    override fun Content(){
        val navigator = LocalNavigator.current
        var usuario by remember { mutableStateOf("") }
        var contraseña by remember { mutableStateOf("") }
        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFF8ab3cf)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                elevation = 16.dp
            ) {
                Column(
                    modifier = Modifier.padding(36.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Login",
                        modifier = Modifier.padding(bottom = 24.dp),
                        fontSize = 36.sp
                    )
                    OutlinedTextField(
                        value = usuario,
                        onValueChange = { usuario = it },
                        label = { Text("Usuario") },
                        modifier = Modifier.padding(bottom = 24.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF4180ab),
                            focusedLabelColor = Color(0xFF4180ab)
                        )
                    )
                    OutlinedTextField(
                        value = contraseña,
                        onValueChange = { contraseña = it },
                        label = { Text("Contraseña")},
                        modifier = Modifier.padding(bottom = 24.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF4180ab),
                            focusedLabelColor = Color(0xFF4180ab)
                        )
                    )
                    Button(
                        onClick = {
                            navigator?.push(WelcomeScreen())
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4180ab))
                    ){
                        Text(
                            text = "Iniciar sesión",
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
