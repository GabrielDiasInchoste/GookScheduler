package com.br.gook.data.input

import java.time.LocalDateTime

data class UpdateSchedulerInputPort(
    val scheduleDate: LocalDateTime?,
    val cancel: CancelInputPort?
)