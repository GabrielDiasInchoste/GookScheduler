package com.br.gook.data.input

import com.br.gook.data.SchedulerStatusPort

data class PageSchedulerInputPort(
    val courtId: Long?,
    val customerEmail: String?,
    val status: SchedulerStatusPort?
)