package com.br.gook.data.output

import java.time.LocalDateTime

data class LocalOutputPort(
    val id: Long,
    val name: String,
    val address: AddressOutputPort,
    val courts: List<CourtOutputPort>,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)