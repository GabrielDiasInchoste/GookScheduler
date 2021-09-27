package com.br.gook.data.output

import java.time.LocalDateTime

data class CourtOutputPort(
    val id: Int,
    val name: String,
    val type: String,
    val description: String,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)