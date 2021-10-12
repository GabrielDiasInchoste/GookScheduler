package com.br.gook.dto.request

import javax.validation.constraints.NotBlank

data class CancelRequest(

    @NotBlank(message = "Description not informed")
    val description: String

)