import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import model.Tarea

class TareaScreen(tarea: Tarea) : Screen {

    val tarea = tarea

    val gris_clarito = 0xFFe4ebf0
    val lightskyblue = 0xFF87cefa

    @Composable
    override fun Content(){
        val navigator = LocalNavigator.current

        LazyColumn(
            modifier = Modifier.background(Color(gris_clarito)).fillMaxSize()
        ) {
            item {
                Text(
                    text = "${tarea.nombre}",
                    modifier = Modifier.padding(start = 16.dp, bottom = 32.dp),
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
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Datos",
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
                    Divider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))
                }
            }
            item {
                Card(
                    modifier = Modifier.padding(16.dp),
                    elevation = 4.dp
                ) {
                    Column {
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Nombre: ${tarea.nombre}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Descripción: ${tarea.descripcion}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Programador: ${tarea.programador}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Proyecto: ${tarea.proyecto}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Fecha de creación: ${tarea.fecha_creacion}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Fecha de finalización: ${tarea.fecha_finalizacion}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Estimación: ${tarea.estimacion}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                    Divider()
                }
            }
        }
    }
}