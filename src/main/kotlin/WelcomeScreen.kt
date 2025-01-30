import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class WelcomeScreen: Screen{
    @Composable
    override fun Content(){
        val navigator = LocalNavigator.current
        val list = listOf("Proyecto 1", "Proyecto 2", "Proyecto 3", "Proyecto 4", "Proyecto 5", "Proyecto 6")

        val gris_clarito = 0xFFe4ebf0
        val lightskyblue = 0xFF87cefa

        LazyColumn(
            modifier = Modifier.background(Color(gris_clarito)).fillMaxSize()
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
                            modifier = Modifier.clickable{navigator?.pop()}
                        )
                    }
                }
            }

            item {
                Row {
                    Saludar(lightskyblue, gris_clarito)
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Proyectos activos",
                        modifier = Modifier.padding(start = 16.dp),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(lightskyblue),
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(0.5f, 0.5f),
                                blurRadius = 1f
                            )
                        )
                    )
                    Divider(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
                }
            }

            item {
                Box(modifier = Modifier.height(500.dp)) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        items(list) { item ->
                            Column(
                                modifier = Modifier
                                    .padding(32.dp)
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            ) {
                                Card(
                                    elevation = 8.dp,
                                    modifier = Modifier
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
                                            color = Color(gris_clarito)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Historial",
                        modifier = Modifier.padding(start = 16.dp),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(lightskyblue),
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(0.5f, 0.5f),
                                blurRadius = 1f
                            )
                        )
                    )
                    Divider(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
                }
            }

            item {
                Box(modifier = Modifier.height(500.dp)) {
                    Card(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        LazyColumn {
                            items(list) { item ->
                                Row(
                                    modifier = Modifier.height(50.dp).fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = item,
                                        modifier = Modifier.padding(start = 8.dp)
                                    )
                                    Text(
                                        text = "Fecha: dd/mm/aa",
                                        modifier = Modifier.padding(end = 8.dp)
                                    )
                                }
                                Divider()
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Saludar(lightskyblue: Long, gris_clarito: Long) {
        val nombre = "Samu"
        Row(
            modifier = Modifier.padding(top = 128.dp, bottom = 128.dp).fillMaxWidth(),
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
                color = Color(lightskyblue),
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
}
