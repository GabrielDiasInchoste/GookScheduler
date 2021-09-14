package com.br.gook.data

import java.time.LocalDateTime

data class SchedulerPort(
    val id: Int,
    val customerId: String,
    val court: CourtPort,
    val cancel: CancelPort,
    val requestDate: LocalDateTime,
    val confirmDate: LocalDateTime,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)