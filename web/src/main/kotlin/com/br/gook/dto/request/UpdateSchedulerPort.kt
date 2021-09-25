package com.br.gook.dto.request

import java.time.LocalDateTime

data class UpdateSchedulerPort(
    val customerId: String?,
    val court: CourtRequest?,
    val cancel: CancelRequest?,
    val requestDate: LocalDateTime?,
    val confirmDate: LocalDateTime?,
    val createDate: LocalDateTime?,
    val lasModifiedDate: LocalDateTime?
)