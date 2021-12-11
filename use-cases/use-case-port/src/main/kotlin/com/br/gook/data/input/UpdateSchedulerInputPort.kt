package com.br.gook.data.input

import com.br.gook.data.SchedulerStatusPort
import java.time.LocalDateTime

data class UpdateSchedulerInputPort(
    val tokenSendPush: String?,
    val scheduleDate: LocalDateTime?,
    val status: SchedulerStatusPort?,
    val cancel: CancelInputPort?
)