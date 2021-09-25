package com.br.gook.dto.response

import java.time.LocalDateTime

data class CancelResponse(
    val id: Int,
    val description: String,
    val cancelRequestedDate: LocalDateTime,
    val cancelConfirmedDate: LocalDateTime
)