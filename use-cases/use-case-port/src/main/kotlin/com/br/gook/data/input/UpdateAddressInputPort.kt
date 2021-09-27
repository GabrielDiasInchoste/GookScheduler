package com.br.gook.data.input

data class UpdateAddressInputPort(
    val name: String?,
    val number: Int?,
    val description: String?,
    val cep: String?
)