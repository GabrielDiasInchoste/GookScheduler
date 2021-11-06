package com.br.gook.dto.request

import com.br.gook.data.SchedulerStatusPort

data class PageSchedulerRequest(

    val customerEmail: String?,
    val status : SchedulerStatusPort?,
    val courtId: Long?
)
