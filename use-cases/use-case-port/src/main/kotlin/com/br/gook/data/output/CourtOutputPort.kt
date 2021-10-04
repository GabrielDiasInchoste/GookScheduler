package com.br.gook.data.output

import java.time.LocalDateTime

data class CourtOutputPort(
    val id: Long?,
    val name: String,
    val type: String,
    val local: LocalOutputPort,
    val description: String,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)