package com.br.gook.data.output

import java.time.LocalDateTime

data class AddressOutputPort(
    val id: Int,
    val name: String,
    val number: Int,
    val description: String,
    val cep: String,
    val createDate: LocalDateTime,
    val lasModifiedDate: LocalDateTime
)