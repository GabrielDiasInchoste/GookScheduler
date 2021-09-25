package com.br.gook.data

import java.time.LocalDateTime

data class AddressPort(
    val id: Int?,
    val name: String,
    val number: Int,
    val description: String,
    val cep: String,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)