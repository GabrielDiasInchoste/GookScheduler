package com.br.gook.dto.request

import java.time.LocalDateTime
import javax.validation.constraints.NotBlank

data class SchedulerRequest(
    @NotBlank(message = "Customer Id not informed")
    val customerId: String,

    @NotBlank(message = "Court Id not informed")
    val courtId: Int,

    @NotBlank(message = "Scheduler not informed") //TODO Adicionar nos requests
    val schedule: LocalDateTime
)
