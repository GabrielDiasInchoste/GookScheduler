package com.br.gook.data.output

import java.time.LocalDateTime

data class CourtOutputPort(
    val id: Long?,
    val name: String,
    val type: String,
    val localId: Long,
    val description: String,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)