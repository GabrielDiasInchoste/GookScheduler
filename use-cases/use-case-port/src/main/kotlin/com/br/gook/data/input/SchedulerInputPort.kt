package com.br.gook.data.input

import java.time.LocalDateTime

data class SchedulerInputPort(
    val customerEmail: String,
    val courtId: Long,
    val schedule: LocalDateTime
)