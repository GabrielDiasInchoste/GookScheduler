package com.br.gook.data.output

import com.br.gook.data.SchedulerStatusPort

data class PageSchedulerOutputPort(
    val courtId: Long?,
    val customerEmail: String?,
    val status: SchedulerStatusPort?
)