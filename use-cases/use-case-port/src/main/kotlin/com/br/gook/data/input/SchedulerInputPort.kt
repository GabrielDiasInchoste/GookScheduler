package com.br.gook.data.input

import java.time.LocalDateTime

data class SchedulerInputPort(
    val tokenSendPush: String,
    val customerEmail: String,
    val courtId: Long,
    val schedule: LocalDateTime
)