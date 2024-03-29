package com.br.gook.dto.request

import com.br.gook.data.SchedulerStatusPort
import java.time.LocalDateTime

data class UpdateSchedulerRequest(
    val tokenSendPush: String?,
    val cancel: CancelRequest?,
    val status: SchedulerStatusPort?,
    val scheduleDate: LocalDateTime?
)