package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tarea (
    @SerialName("id_tarea") var id_tarea: Int? = null,  // Hacer opcional
    @SerialName("nombre") var nombre: String,
    @SerialName("descripcion") var descripcion: String,
    @SerialName("estimacion") var estimacion: Int,
    @SerialName("fecha_creacion") var fecha_creacion: String,
    @SerialName("fecha_finalizacion") var fecha_finalizacion: String,
    @SerialName("programador") var programador: Int? = null,  // Hacer opcional
    @SerialName("proyecto") var proyecto: Int? = null  // Hacer opcional
)
