package com.br.gook.data.input

import java.time.LocalDateTime

data class SchedulerInputPort(
    val customerId: String,
    val local: LocalInputPort,
    val cancel: CancelInputPort?,
    val schedule: LocalDateTime,
    val confirmDate: LocalDateTime,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)