package com.br.gook.dto.request

import java.time.LocalDateTime

data class UpdateSchedulerRequest(
    val cancel: CancelRequest?,
    val scheduleDate: LocalDateTime?
)