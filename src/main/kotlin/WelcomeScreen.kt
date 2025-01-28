import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WelcomeScreen(){
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.height(70.dp).fillMaxWidth().padding(end = 16.dp)
        ) {
            Image(
                painter = painterResource("perfil.png"),
                contentDescription = "Perfil",
                modifier = Modifier.padding(8.dp)
            )
            Column(

            ) {
                Row {
                    Text(
                        text = "Samu",
                        fontSize = 14.sp
                    )
                    Text(
                        text = " (Gestor)",
                        fontSize = 14.sp
                    )
                }
                Text(
                    text = "Desconectar",
                    fontSize = 14.sp,
                    color = Color.Blue,
                    modifier = Modifier.clickable{}
                )
            }
        }
        Divider(modifier = Modifier.padding(bottom = 24.dp))

    }
}