package com.br.gook.dto.response

import com.br.gook.data.SchedulerStatusPort
import java.time.LocalDateTime

data class SchedulerResponse(
    val id: Long,
    val customerEmail: String,
    val tokenSendPush: String?,
    val status: SchedulerStatusPort,
    val court: CourtResponse,
    val cancel: CancelResponse?,
    val schedule: LocalDateTime?,
    val confirmDate: LocalDateTime?,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)