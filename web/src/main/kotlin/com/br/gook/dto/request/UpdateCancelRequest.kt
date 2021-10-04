package com.br.gook.dto.request

import java.time.LocalDateTime

data class UpdateCancelRequest(

    val description: String?,
    val cancelRequestedDate: LocalDateTime?,
    val cancelConfirmedDate: LocalDateTime?
)