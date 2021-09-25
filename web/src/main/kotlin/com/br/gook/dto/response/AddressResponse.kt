package com.br.gook.dto.response

import java.time.LocalDateTime

data class AddressResponse(
    val id: Int,
    val name: String,
    val number: Int,
    val description: String,
    val cep: String,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)