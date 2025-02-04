package network

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import java.net.http.HttpClient

object NetworkUntils {
    val httpClient = HttpClient{
        install(ContentNegotiation){
            json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
        }
    }
}