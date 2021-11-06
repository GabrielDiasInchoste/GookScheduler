package com.br.gook.data.output

import java.time.LocalDateTime

data class PageSchedulerResponseOutputPort(
    val number: Int,
    val numberOfElements: Int,
    val size: Int,
    val totalPages: Int,
    val totalElements: Long,
    val first: Boolean,
    val last: Boolean,
    val schedulers: List<SchedulerOutputPort>
)
