package com.br.gook.dto.response

import com.br.gook.data.CourtTypePort
import java.time.LocalDateTime

data class CourtResponse(
    val id: Long,
    val name: String,
    val type: CourtTypePort,
    val localId: Long,
    val description: String,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)