package com.br.gook.data

import java.time.LocalDateTime

data class SchedulerPort(
    val id: Int?,
    val customerId: String,
    val local: LocalPort?, // TODO
    val cancel: CancelPort?,
    val schedule: LocalDateTime,
    val confirmDate: LocalDateTime,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)