package com.br.gook.data

import java.time.LocalDateTime

data class CancelPort(
    val id: Int,
    val description: String,
    val cancelRequestedDate: LocalDateTime,
    val cancelConfirmedDate: LocalDateTime
)