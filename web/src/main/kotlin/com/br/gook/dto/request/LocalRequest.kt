package com.br.gook.dto.request

import java.time.LocalDateTime

data class LocalRequest(
    val name: String,
    val address: AddressRequest, //TODO
    val courts: List<CourtRequest>,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)