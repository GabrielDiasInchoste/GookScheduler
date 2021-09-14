package com.br.gook.data

import java.time.LocalDateTime

data class LocalPort(
    val id: Int,
    val name: String,
    val address: AddressPort,
    val courts: List<CourtPort>,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)