package com.br.gook.data.input

import java.time.LocalDateTime

data class SchedulerInputPort(
    val customerId: String,
    val courtId: Long,
    val schedule: LocalDateTime
)