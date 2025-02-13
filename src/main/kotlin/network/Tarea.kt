package network

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.Tarea
import network.NetworkUntils.httpClient

fun ObtenerHistawdadworial(onSuccessResponse: (List<Tarea>) -> Unit) {
    val url = "http://127.0.0.1:5000/proyecto/historial"

    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.get(url) {
            contentType(ContentType.Application.Json)
        }
        if (response.status == HttpStatusCode.OK) {
            val listTarea = response.body<List<Tarea>>()
            onSuccessResponse(listTarea)
        } else {
            println("Error: ${response.status}, Body: ${response.bodyAsText()}")
        }
    }
}

fun ObtenerTareasProyectasdado(onSuccessResponse: (List<Tarea>) -> Unit) {
    val url = "http://127.0.0.1:5000/proyecto/tareas_proyectos"

    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.get(url) {
            contentType(ContentType.Application.Json)
        }
        if (response.status == HttpStatusCode.OK) {
            val listTarea = response.body<List<Tarea>>()
            onSuccessResponse(listTarea)
        } else {
            println("Error: ${response.status}, Body: ${response.bodyAsText()}")
        }
    }
}

fun ObtenerTareasProyecto(id: Int, onSuccessResponse: (List<Tarea>) -> Unit) {
    val url = "http://127.0.0.1:5000/proyecto/tareas_proyectos?id=$id"

    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.get(url) {
            contentType(ContentType.Application.Json)
        }
        if (response.status == HttpStatusCode.OK) {
            val listTarea = response.body<List<Tarea>>()
            onSuccessResponse(listTarea)
        } else {
            println("Error: ${response.status}, Body: ${response.bodyAsText()}")
        }
    }
}