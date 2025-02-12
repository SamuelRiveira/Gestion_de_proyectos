package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Programador(
    @SerialName("id_programador") var idProgramador: Int,
    @SerialName("sueldo_hora") var sueldo_hora: Int,
    @SerialName("id_empleado") var id_empleado: Int
)