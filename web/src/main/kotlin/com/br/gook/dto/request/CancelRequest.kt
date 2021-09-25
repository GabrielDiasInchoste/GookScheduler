package com.br.gook.dto.request

import java.time.LocalDateTime

data class CancelRequest(
    val id: Int,
    val description: String,
    val cancelRequestedDate: LocalDateTime,
    val cancelConfirmedDate: LocalDateTime
)