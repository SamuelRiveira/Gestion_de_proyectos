package network

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.Programador
import network.NetworkUntils.httpClient

fun ObtenerProgramadoresSinAsignar(onSuccessResponse: (List<Programador>) -> Unit) {
    val url = "http://127.0.0.1:5000/proyecto/programadores_no_asignados"

    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.get(url) {
            contentType(ContentType.Application.Json)
        }
        if (response.status == HttpStatusCode.OK) {
            val listProgramador = response.body<List<Programador>>()
            onSuccessResponse(listProgramador)
        } else {
            println("Error: ${response.status}, Body: ${response.bodyAsText()}")
        }
    }
}

fun ObtenerAsignarProgramador(onSuccessResponse: (List<Programador>) -> Unit) {
    val url = "http://127.0.0.1:5000/proyecto/programador_proyecto"

    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.get(url) {
            contentType(ContentType.Application.Json)
        }
        if (response.status == HttpStatusCode.OK) {
            val listProgramador = response.body<List<Programador>>()
            onSuccessResponse(listProgramador)
        } else {
            println("Error: ${response.status}, Body: ${response.bodyAsText()}")
        }
    }
}