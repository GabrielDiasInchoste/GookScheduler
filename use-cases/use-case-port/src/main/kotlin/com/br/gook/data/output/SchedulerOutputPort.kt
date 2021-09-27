package com.br.gook.data.output

import java.time.LocalDateTime

data class SchedulerOutputPort(
    val id: Long?,
    val customerId: String,
    val court: CourtOutputPort,
    val cancel: CancelOutputPort?,
    val schedule: LocalDateTime,
    val confirmDate: LocalDateTime?,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)