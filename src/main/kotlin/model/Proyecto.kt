package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Proyecto(
    @SerialName("id") val id: Int,
    @SerialName("nombre") val nombre: String,
    @SerialName("descripcion") val descripcion: String,
    @SerialName("fecha_creacion") val fecha_creacion: String,
    @SerialName("fecha_inicio") val fecha_inicio: String,
    @SerialName("fecha_finalizacion") val fecha_finalizacion: String?,
    @SerialName("cliente") val cliente: Int
)