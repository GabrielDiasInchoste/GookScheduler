package com.br.gook.dto.request

import com.br.gook.data.CourtTypePort
import javax.validation.constraints.NotBlank

data class CourtRequest(

    @NotBlank(message = "Description not informed")
    val name: String,

    @NotBlank(message = "Type not informed")
    val type: CourtTypePort,

    @NotBlank(message = "Description not informed")
    val description: String,

    @NotBlank(message = "Local Id not informed")
    val localId: Long
)