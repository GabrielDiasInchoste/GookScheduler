package com.br.gook.dto.request

import java.time.LocalDateTime

data class CourtRequest(
    val name: String,
    val type: String,
    val description: String,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)