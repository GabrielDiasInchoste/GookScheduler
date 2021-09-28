package com.br.gook.data.output

import com.br.gook.data.SchedulerStatusPort
import java.time.LocalDateTime

data class SchedulerOutputPort(
    val id: Long?,
    val customerId: String,
    val status: SchedulerStatusPort,
    val court: CourtOutputPort,
    val cancel: CancelOutputPort?,
    val schedule: LocalDateTime,
    val confirmDate: LocalDateTime?,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)