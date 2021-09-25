package com.br.gook.dto.response

import java.time.LocalDateTime

data class SchedulerResponse(
    val id: Int,
    val customerId: String,
    val local: LocalResponse,
    val cancel: CancelResponse?,
    val schedule: LocalDateTime?,
    val confirmDate: LocalDateTime?,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)