package com.br.gook.data.output

import java.time.LocalDateTime

data class CancelOutputPort(
    val id: Int,
    val description: String,
    val cancelRequestedDate: LocalDateTime,
    val cancelConfirmedDate: LocalDateTime
)