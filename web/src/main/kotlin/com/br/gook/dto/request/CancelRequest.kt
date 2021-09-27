package com.br.gook.dto.request

import java.time.LocalDateTime
import javax.validation.constraints.NotBlank

data class CancelRequest(

    @NotBlank(message = "Description not informed")
    val description: String,

    @NotBlank(message = "Cancel Request Date not informed")
    val cancelRequestedDate: LocalDateTime,

    val cancelConfirmedDate: LocalDateTime
)