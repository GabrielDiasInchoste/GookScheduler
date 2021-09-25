package com.br.gook.dto.response

import java.time.LocalDateTime

data class UpdateSchedulerPort(
    val customerId: String,
    val local: LocalResponse,
    val cancel: CancelResponse?,
    val confirmDate: LocalDateTime,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)