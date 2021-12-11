package com.br.gook.dto.request

import java.time.LocalDateTime
import javax.validation.constraints.NotBlank

data class SchedulerRequest(
    @NotBlank(message = "Token Send Push not informed")
    val tokenSendPush: String,

    @NotBlank(message = "Customer Id not informed")
    val customerEmail: String,

    @NotBlank(message = "Court Id not informed")
    val courtId: Long,

    @NotBlank(message = "Scheduler not informed")
    val schedule: LocalDateTime
)
