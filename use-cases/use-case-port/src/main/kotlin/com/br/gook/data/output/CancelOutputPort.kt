package com.br.gook.data.output

import java.time.LocalDateTime

data class CancelOutputPort(
    val id: Long?,
    val description: String,
    val cancelRequestedDate: LocalDateTime,
    val cancelConfirmedDate: LocalDateTime?,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)