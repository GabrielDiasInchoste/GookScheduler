package com.br.gook.data

import java.time.LocalDateTime

data class CourtPort(
    val id: Int,
    val name: String,
    val type: String,
    val description: String,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)