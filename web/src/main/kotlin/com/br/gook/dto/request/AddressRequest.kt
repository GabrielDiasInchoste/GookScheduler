package com.br.gook.dto.request

import java.time.LocalDateTime

data class AddressRequest(
    val name: String,
    val number: Int,
    val description: String,
    val cep: String,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)