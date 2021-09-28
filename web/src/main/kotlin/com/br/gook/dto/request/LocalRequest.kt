package com.br.gook.dto.request

import java.time.LocalDateTime
import javax.validation.constraints.NotBlank

data class LocalRequest(
    @NotBlank(message = "Description not informed")
    val name: String,

    @NotBlank(message = "Address Id not informed")
    val addressId: Long
)