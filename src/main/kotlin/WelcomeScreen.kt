import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(){

    val list = listOf("Proyecto 1", "Proyecto 2", "Proyecto 3")

    LazyColumn(
        modifier = Modifier.background(Color(0xFFe4ebf0)).fillMaxSize()
    ) {
        item{
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
                Column {
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
        }

        item {
            Saludar()
        }

        item {
            Text(text = "Proyectos activos")
        }

        item {
            Box(modifier = Modifier.height(400.dp)) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(list) { item ->
                        Column {
                            Card(
                                elevation = 8.dp,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .height(150.dp)
                                    .width(200.dp),
                                backgroundColor = Color(0xFF8ab3cf)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(
                                        text = item,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(bottom = 8.dp)
                                    )
                                    Text(
                                        text = "Descripción",
                                        color = Color(0xFFE4EBF0)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Saludar(){
    val nombre = "Samu"
    Row(
        modifier = Modifier.padding(top = 64.dp, bottom = 64.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¡Bienvenido ",
            color = Color.White,
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(0.5f, 0.5f),
                    blurRadius = 1f
                )
            )
        )
        Text(
            text = nombre,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFbdd1de),
            fontSize = 64.sp,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(1f, 1f),
                    blurRadius = 1f
                )
            )
        )
        Text(
            text = "!",
            color = Color.White,
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(0.5f, 0.5f),
                    blurRadius = 1f
                )
            )
        )
    }
}