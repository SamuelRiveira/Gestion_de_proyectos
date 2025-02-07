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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import model.Proyecto
import network.ObtenerProyectosGestor


class ProyectoScreen(item: Proyecto) : Screen {

    val proyecto = item

    @Composable
    override fun Content(){

        val navigator = LocalNavigator.current

        val datos = listOf("nombre", "descripcion", "fecha de creación", "fecha de inicio", "fecha de finalización", "cliente")
        val tareas = listOf("Tarea 1", "Tarea 2", "Tarea 3", "Tarea 4", "Tarea 5", "Tarea 6")

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
                    Box(modifier = Modifier.height(300.dp)) {
                        LazyColumn {
                            itemsIndexed(datos) { index, item ->
                                var paridad = 0xFFffffff
                                if ((index % 2) != 0) {
                                    paridad = 0xFFbdd1de
                                }
                                Row(
                                    modifier = Modifier.height(50.dp).fillMaxWidth().background(Color(paridad)),
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
                                    itemsIndexed(tareas) { index, item ->
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
                    Tarjeta("Tareas sin asignar")
                    Tarjeta("Programadores sin asignar")
                }
            }
        }
    }
}

@Composable
fun Tarjeta(texto: String = ""){
    var expanded by rememberSaveable { mutableStateOf(0.dp) }
    var isExpanded by remember { mutableStateOf(false) }
    val animationPadding by
    animateDpAsState(
        if (isExpanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow                )
    )
    val currentPadding = animationPadding.coerceAtLeast(0.dp)
    Card(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        backgroundColor = Color(0xFF8ab3cf),
        elevation = 2.dp,
        shape = MaterialTheme.shapes.small,
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = currentPadding)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = texto,
                color = Color.White
            )
            Button(
                onClick = {
                    if (isExpanded) {
                        expanded = 0.dp
                        isExpanded = !isExpanded
                    } else{
                        expanded = 120.dp
                        isExpanded = !isExpanded
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFbdd1de))
            ){
                Text(
                    text = (if (isExpanded) "Mostrar menos" else "Mostrar más"),
                    color = Color.White
                )
            }
        }
    }
}