import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import model.Programador
import model.Proyecto
import model.Tarea
import network.ObtenerProgramadoresSinAsignar
import network.ObtenerProyectosGestor
import network.ObtenerTareasProyecto


class ProyectoScreen(item: Proyecto) : Screen {

    val proyecto = item

    @Composable
    override fun Content(){

        val navigator = LocalNavigator.current
        val tareas = listOf("Tarea 1", "Tarea 2", "Tarea 3", "Tarea 4", "Tarea 5", "Tarea 6")

        var programador_sin_asignar by remember { mutableStateOf(emptyList<Programador>()) }
        var tarea by remember { mutableStateOf(emptyList<Tarea>()) }

        ObtenerTareasProyecto(proyecto.id) { tarea = it }

        var paridad by remember { mutableStateOf(0xFFffffff) }
        var fila by remember { mutableStateOf(0) }
        var checked by remember { mutableStateOf(false) }

        val gris_clarito = 0xFFe4ebf0
        val lightskyblue = 0xFF87cefa

        LazyColumn(
            modifier = Modifier.background(Color(gris_clarito)).fillMaxSize()
        ) {
            item {
                Text(
                    text = "${proyecto.nombre}",
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
                    if ((fila % 2) != 0) {
                        paridad = 0xFFbdd1de
                    } else{
                        paridad = 0xFFffffff
                    }
                    Column {
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth().background(Color(paridad)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Nombre: ${proyecto.nombre}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                            fila ++
                        }
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth().background(Color(paridad)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Descripción: ${proyecto.descripcion}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                            fila ++
                        }
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth().background(Color(paridad)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Cliente: ${proyecto.cliente}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                            fila ++
                        }
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth().background(Color(paridad)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Fecha de creación: ${proyecto.fecha_creacion}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                            fila ++
                        }
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth().background(Color(paridad)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Fecha de inicio: ${proyecto.fecha_inicio}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                            fila ++
                        }
                        Row(
                            modifier = Modifier.height(50.dp).fillMaxWidth().background(Color(paridad)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Fecha de finalización: ${proyecto.fecha_finalizacion}",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                            fila ++
                        }
                    }
                    Divider()
                }
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Tareas",
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
                    elevation = 8.dp,
                    modifier = Modifier.padding(16.dp)
                ){
                    Column {
                        Row {
                            Box(modifier = Modifier.height(430.dp)) {
                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(3),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    itemsIndexed(tarea) { index, item ->
                                        Column(
                                            modifier = Modifier
                                                .padding(32.dp)
                                                .fillMaxWidth()
                                                .wrapContentWidth(Alignment.CenterHorizontally)
                                                .wrapContentHeight(Alignment.CenterVertically)
                                        ) {
                                            Card(
                                                elevation = 8.dp,
                                                modifier = Modifier
                                                    .height(150.dp)
                                                    .width(200.dp)
                                                    .clickable {
                                                        navigator?.push(TareaScreen(index.toString()))
                                                    },
                                                backgroundColor = Color(0xFF8ab3cf)
                                            ) {
                                                Column(modifier = Modifier.padding(16.dp)) {
                                                    Text(
                                                        text = "${item.nombre}",
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
                    }
                }
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text(
                        text = "Sin asignar",
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
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
//                    Tarjeta("Tareas sin asignar")
                    ObtenerProgramadoresSinAsignar { programador_sin_asignar = it }
                    Tarjeta(programador_sin_asignar)

                }
            }
        }
    }
}

@Composable
fun Tarjeta(programadores: List<Programador>) {

    var isExpanded by remember { mutableStateOf(false) }
    val animationPadding by animateDpAsState(
        targetValue = if (isExpanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Card(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        backgroundColor = Color(0xFF8ab3cf),
        elevation = 2.dp,
        shape = MaterialTheme.shapes.small,
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = "Programadores sin asignar",
                color = Color.White,
                style = MaterialTheme.typography.h6
            )

            if (isExpanded) {
                Column(modifier = Modifier.padding(top = animationPadding)) {
                    programadores.forEach { programador ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth().padding(4.dp)
                        ) {
                            Text(
                                modifier = Modifier.weight(1f),
                                text = "id del programador: ${programador.idProgramador}, sueldo por hora: ${programador.sueldo_hora}, id del empleado: ${programador.id_empleado}",
                                color = Color.White
                            )
                            Button(
                                onClick = { /* Acción para asignar el programador */ },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFbdd1de))
                            ) {
                                Text("Asignar", color = Color.White)
                            }
                        }
                    }
                }
            }

            Button(
                onClick = { isExpanded = !isExpanded },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFbdd1de)),
                modifier = Modifier.align(Alignment.End).padding(top = 8.dp)
            ) {
                Text(
                    text = if (isExpanded) "Mostrar menos" else "Mostrar más",
                    color = Color.White
                )
            }
        }
    }
}
