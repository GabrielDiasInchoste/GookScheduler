package com.br.gook.data.input

import java.time.LocalDateTime

data class CancelInputPort(
    val description: String?,
    val cancelRequestedDate: LocalDateTime?,
    val cancelConfirmedDate: LocalDateTime?
)