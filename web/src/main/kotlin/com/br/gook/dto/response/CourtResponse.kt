package com.br.gook.dto.response

import java.time.LocalDateTime

data class CourtResponse(
    val id: Int,
    val name: String,
    val type: String,
    val description: String,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)