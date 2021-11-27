package com.br.gook.dto.response

import java.time.LocalDateTime

data class AddressResponse(
    val id: Long,
    val name: String,
    val number: Int,
    val description: String,
    val cep: String,
    val createDate: LocalDateTime,
    val latitude: String,
    val longitude: String,
    val lasModifiedDate: LocalDateTime
)